package edu.msmary.project2;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PlayGame extends AppCompatActivity {
    private int rings = 0;
    private int moves = 0;
    private int from = 0;
    private int to = 0;
    private int prevfrom = 0;
    private int prevto = 0;
    private boolean fromclicked = false;
    private boolean hasWon = false;
    private LinkedStack[] main = new LinkedStack[3];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        Intent intent = getIntent();
        rings = Integer.parseInt(Objects.requireNonNull(intent.getExtras()).get(Intent.EXTRA_TEXT) + "");

        for (int i = 0; i < 3; i++) {
            main[i] = new LinkedStack();
        }
        for (int i = 1; i < rings + 1; i++) {
            main[0].push(i);
        }
        display();

    }
    public void timer(){

    }
    public void pole1(View view){
        if (fromclicked == false){
            from = 1;
            fromclicked = true;
        }
        else{
            to = 1;
            go();
        }
    }
    public void pole2(View view){
        if (fromclicked == false){
            from = 2;
            fromclicked = true;
        }
        else{
            to = 2;
            go();
        }
    }

    public void pole3(View view){
        if (fromclicked == false){
            from = 3;
            fromclicked = true;
        }
        else{
            to = 3;
            go();
        }
    }

    public void display() {
        Map<Integer, Integer> it = new LinkedHashMap<>();
        List<List<ImageView>> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(new ArrayList<ImageView>());
        }
        list.get(0).add((ImageView)findViewById(R.id.p1disk1));
        list.get(0).add((ImageView)findViewById(R.id.p1disk2));
        list.get(0).add((ImageView)findViewById(R.id.p1disk3));
        list.get(0).add((ImageView)findViewById(R.id.p1disk4));
        list.get(0).add((ImageView)findViewById(R.id.p1disk5));
        list.get(0).add((ImageView)findViewById(R.id.p1disk6));
        list.get(0).add((ImageView)findViewById(R.id.p1disk7));
        list.get(0).add((ImageView)findViewById(R.id.p1disk8));
        list.get(1).add((ImageView)findViewById(R.id.p2disk8));
        list.get(1).add((ImageView)findViewById(R.id.p2disk7));
        list.get(1).add((ImageView)findViewById(R.id.p2disk6));
        list.get(1).add((ImageView)findViewById(R.id.p2disk5));
        list.get(1).add((ImageView)findViewById(R.id.p2disk4));
        list.get(1).add((ImageView)findViewById(R.id.p2disk3));
        list.get(1).add((ImageView)findViewById(R.id.p2disk2));
        list.get(1).add((ImageView)findViewById(R.id.p2disk1));
        list.get(2).add((ImageView)findViewById(R.id.p3disk8));
        list.get(2).add((ImageView)findViewById(R.id.p3disk7));
        list.get(2).add((ImageView)findViewById(R.id.p3disk6));
        list.get(2).add((ImageView)findViewById(R.id.p3disk5));
        list.get(2).add((ImageView)findViewById(R.id.p3disk4));
        list.get(2).add((ImageView)findViewById(R.id.p3disk3));
        list.get(2).add((ImageView)findViewById(R.id.p3disk2));
        list.get(2).add((ImageView)findViewById(R.id.p3disk1));
        it.put(0, null);
        it.put(1, R.drawable.ring8);
        it.put(2, R.drawable.ring7);
        it.put(3, R.drawable.ring6);
        it.put(4, R.drawable.ring5);
        it.put(5, R.drawable.ring4);
        it.put(6, R.drawable.ring3);
        it.put(7, R.drawable.ring2);
        it.put(8, R.drawable.ring1);

        if (!main[0].isEmpty()) {
            for (int i = main[0].size() - 1; i >= 0; i--) {
                list.get(0).get(i).setImageResource(it.get(main[0].get(i)));
            }
        } else {
            for (int i = 0; i < list.get(0).size(); i++) {
                list.get(0).get(i).setImageResource(0);
            }
        }
        if (!main[1].isEmpty()) {
            for (int i = main[1].size() - 1; i >= 0; i--) {
                list.get(1).get(i).setImageResource(it.get(main[1].get(i)));
            }
        } else {
            for (int i = 0; i < list.get(1).size(); i++) {
                list.get(1).get(i).setImageResource(0);
            }
        }
        if (!main[2].isEmpty()) {
            for (int i = main[2].size() - 1; i >= 0; i--) {
                list.get(2).get(i).setImageResource(it.get(main[2].get(i)));
            }
        } else {
            for (int i = 0; i < list.get(2).size(); i++) {
                list.get(2).get(i).setImageResource(0);
            }
        }

    }

    public void go() {
        fromclicked = false;
        if (!main[from - 1].isEmpty()) {
            if (main[to - 1].isEmpty()) {
                move(main, from, to);
            } else if (main[from - 1].look() > main[to - 1].look()) {
                move(main, from, to);
            } else {
                illegalMove();
            }
        } else {
            illegalMove();
        }
        display();
        prevfrom = from;
        from = 0;
        prevto = to;
        to = 0;
        if (rings == main[main.length - 1].size()) {
            Button pg = findViewById(R.id.play_again);
            pg.setVisibility(View.VISIBLE);
            hasWon = true;
            pg.setText("CONGRATS YOU WON IN " + moves + " MOVES!!!\n Press me to play again");
        }
    }

    public void move(LinkedStack[] it, int f, int t) {
        if (hasWon == false) {
            it[t - 1].push(it[f - 1].pop());
            moves++;
        }
        else{
            illegalMove();

        }
    }

    public void Restart(View view) {
        finish();
    }


    public void Reset(View view){
        fromclicked = false;
        for (int i = 0; i < 3; i++) {
            main[i] = new LinkedStack();
        }
        for (int i = 1; i < rings + 1; i++) {
            main[0].push(i);
        }
        display();
        hasWon = false;
        moves = 0;
        Button pg = findViewById(R.id.play_again);
        pg.setVisibility(View.INVISIBLE);
        prevfrom = from;
        from = 0;
        prevto = to;
        to = 0;

    }
    public void changePoles(View view){
        finish();
    }

    public void undo(View view) {
        fromclicked = false;
        if (hasWon == false) {
            try {
                main[prevfrom - 1].push(main[prevto - 1].pop());
                moves--;
                display();
                prevfrom = from;
                from = 0;
                prevto = to;
                to = 0;
            } catch (Exception e) {
                illegalMove();
                prevfrom = from;
                from = 0;
                prevto = to;
                to = 0;
            }
        } else {
            illegalMove();
            prevfrom = from;
            from = 0;
            prevto = to;
            to = 0;

        }
    }

    public void illegalMove() {
        fromclicked = false;
        if (hasWon == false) {
            Toast toast = Toast.makeText(this, "Illegal move try again.", Toast.LENGTH_SHORT);
            toast.show();
            prevfrom = from;
            from = 0;
            prevto = to;
            to = 0;
        }
        else{
            Toast toast = Toast.makeText(this, "you have won the game click PlayAgain to reset.", Toast.LENGTH_SHORT);
            toast.show();
            prevfrom = from;
            from = 0;
            prevto = to;
            to = 0;
        }
    }
}
