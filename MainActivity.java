package edu.msmary.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Start (View view) {
        String text = "";
        String[] inputs1 = {"3", "4", "5", "6", "7", "8"};
        ArrayList <String> inputs = new ArrayList<String>();
        inputs.addAll(Arrays.asList(inputs1));
        EditText ringNum = findViewById(R.id.rings);
        if (inputs.contains(ringNum.getText()+"")) {
            text = ringNum.getText()+"";
            Intent intent = new Intent(MainActivity.this, PlayGame.class);
            intent.setType("");
            intent.putExtra(Intent.EXTRA_TEXT, text);
            startActivity(intent);
            ringNum.setText("");

        } else {
            Toast toast = Toast.makeText(this, "Invalid input.", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

}
