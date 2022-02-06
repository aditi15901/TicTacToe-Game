CS202-Programming Paradigms & Pragmatics
Lab 2: Java Programming

Name: Aditi Das 
Entry Number: 2020CSB1064

Aim: To design the basics of a two-player game of Tic-Tac-Toe using OOP in Java.

I have used TicTacToe as the main class in the project. The class Board is inherited in the class TicTactoe to implement
OOP in Java. 

1.) Type the following lines in terminal for compiling and running the project TicTactoe:

    (i) For Compiling and Running the project-
        make all (or javac *.java && java TicTacToe)

2.) The following message is displayed after running the program/project:

                                                Welcome to 3X3 Tic Tac Toe! 

        Tic Tac Toe is a puzzle game for two players, called X and O, who take turns marking the spaces in a 3×3 grid.
        The player who succeeded in placing three respective marks in a horizontal, vertical, or diagonal row wins the game.
        You can either play 2-Player Version or Computer v/s Player Version! 

        →Enter 1 to play Player v/s Player
        →Enter 2 to play Computer v/s Player
        →Enter any other number to Quit

    You must enter the preferred value after this. Enter 1 to play 2-Player version of TicTacToe, enter 2 to play 
    Computer v/s Player version of TicTacToe or enter any other value to Quit the program/game.

3.) If 1 is entered in Step (2.) then the following message is displayed on the screen:

        Welcome to Tic Tac Toe 2-Player Version! Player 1 is X and Player 2 is O. 
        This is a new game. The board numbers are as follows:

        1 | 2 | 3
       --- --- ---
        4 | 5 | 6
       --- --- ---
        7 | 8 | 9

    The program then asks to enter the desired location for Player 1, which must be within range [1-9].
    ** Here, the player can enter any number outside the range [1-9] to quit the current game. The game ends after that.**
    If the entered location is already filled then the program asks to enter another value for location (you cant quit the game here).
    
    After a valid location is entered, the updated board is displayed and its Player 2's turn to enter a valid location. 
    The game continues till a player gets three respective marks (O or X) in a horizontal, vertical, or diagonal row or till
    a player quits the game.

    The game ends in a tie if noone has won the game till Turn 9.

(4.) If 2 is entered in Step (2.) then the following message is displayed on the screen:

        Welcome to Tic Tac Toe Computer v/s Player Version! Player is X and Computer is O. 

        You can play Easy mode or Hard mode.
        →Enter A for Easy mode
        →Enter B for Hard mode
        →Enter any other value to Quit Computer vs Player Version

    The Computer v/s Player Version has two modes, one Easy and one Hard. 
    (i) In the Easy mode, either of the player or computer can win or the game might end in a tie. 
        Here, computer uses random inputs unless it has a winning move.
    (ii) In the Hard mode, the game can only end in a tie or with the computer winning. Hence, the Player will
        never win and hence the name(Hard mode). 

    You must enter the preferred value after this. Enter A to play Easy Mode, enter B to play 
    Hard Mode or enter any other value to Quit the Computer vs Player Version of the game.

(5.) Depending on the choice in step (4.) the Easy or Hard mode is executed. There is not much difference in the 
     display of these modes. The difference is only in the computer choosing its locations more optimally in Hard mode.
     The program then displays the mode that the player has chosen and then displays the following message on the screen:

        This is a new game. The board numbers are as follows:

        1 | 2 | 3
       --- --- ---
        4 | 5 | 6
       --- --- ---
        7 | 8 | 9

    The program then asks to enter the desired location for the Player, which must be within range [1-9]. 
    ** Here, you can enter 0 to undo your last move or enter any number outside the range [0-9] to quit the current game. **
    If the entered location is already filled then the program asks to enter another value for location. (you cant quit the game here)
    
    After a valid location is entered, its the computer's turn. The game automatically displays the move of the computer
    and then displays the updated board on the screen. The game continues till a player gets three respective marks (O or X)
    in a horizontal, vertical, or diagonal row or if the player has quit the game. As mentioned before, in Easy mode either 
    of the player or computer may win the game or it may end in a tie while in Hard mode its either the game ending with the 
    computer winning or in a tie, given that the player doesn't quit. The game ends in a tie if noone has won the game till Turn 9.
  

   *******************************************************THE END*****************************************************************