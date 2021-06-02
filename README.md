# Towers-of-Hanoi
This project is one the created in Android Studio. If you are not familiar with the popular game called Towers of Hanoi, 
the object of the game is that you start with three polls and x amount of rings. 
In this implementation I allow the user to select the amount of the rings they would like to use. 
So from the start there are x amount of rings starting on the leftmost pole and your goal is to get all of those rings over to the right most poll. 
When executing this you can only move one ring at a time and you cannot stack a larger ring on top of a smaller ring. 
Once the user gets all of the rings from the leftmost poll to the the right most poll, they have won the game and have the option of going back to the start menu to play again. 
I am still working on implementing a timer that times how long it takes the user to solve it and I am also working on adding a scoreboard that interacts with MySQL database.  
When it comes to operating the app, the first thing you will see when you boot it up on an emulator/android-phone is a textbox that asks you to enter the amount of rings you would like to play with. 
Once you enter the rings, you will then be brought to the activity where you will be solving the puzzle. 
From here your first tap on a pole is which poll you want to move from and the second tap on a poll is the poll in which you want to move the ring to, 
Keep in mind your always moving the ring that is on the top of the stack. You can keep doing this until you solve the puzzle. 
There are appropriate error messages that will pop up if you try to make an illegal move. 
Once you solve the puzzle, the program will tell you that you have solved it and it will display how many moves it took you to solve the puzzle. 
From here you may also go back to the main menu and play again.
