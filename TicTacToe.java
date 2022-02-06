import java.util.*; 
public class TicTacToe
 {
    static int a, turn, win, play, player, last=0, computer=0,f;    
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
         //display info of game
        System.out.println("\n\t\t\t\t\t Welcome to 3X3 Tic Tac Toe! \n\nTic Tac Toe is a puzzle game for two players, called X and O, who take turns marking the spaces in a 3×3 grid.\nThe player who succeeded in placing three respective marks in a horizontal, vertical, or diagonal row wins the game.\nYou can either play 2-Player Version or Computer v/s Player Version! \n");
        System.out.println("→Enter 1 to play Player v/s Player\n→Enter 2 to play Computer v/s Player\n→Enter any other value to Quit\n");
        System.out.print("Enter: ");
        a=sc.nextInt();
        while(a<3)
        {
        switch (a)
        {
            case 1:
            Board b1=new Board(); // new object creation
            turn=0; win=-1; player=1; f=0;
            System.out.println("\nWelcome to Tic Tac Toe 2-Player Version! Player 1 is X and Player 2 is O. ");
            b1.printInstructions();
            while(win==-1 && turn<9 && f!=-1) // runs till anyone wins the game i.e win==1 , or the no. of turns have
            { 
                turn++;
                if(turn==1)
                    b1.printBoard();
                System.out.println("*Turn "+turn+"*");
                System.out.print("Player "+player+", enter your desired location [1-9] or enter any other number to quit game: ");
                play=sc.nextInt();
                if(play>=1 && play<=9)
                {
                    while(b1.checkFilled(play)!=1) //checking if its a valid move i.e. the location is not already occupied
                    {
                        System.out.print("This location is already filled! Enter a new location: ");
                        play=sc.nextInt();
                    }
                    b1.updateBoard(player,play);
                    b1.printBoard();
                    if(b1.winCheck()==1) //checking if the player won
                    {
                        System.out.println("Player "+player+" won!");
                        win=1;
                    }
                    player=(turn%2==1)?2:1; 
                    if(turn==9 && win!=1)
                        System.out.println("The game is a Tie!");               
                }
                else 
                {
                    System.out.println("Player "+player+" has left the game, hence the last game was ended!");
                    f=-1;
                }
            }

            break;

            case 2:
            Board b2=new Board(); // new object creation
            turn=0; win=-1; player=1;
            Random rand = new Random();
            char c;
            System.out.println("\nWelcome to Tic Tac Toe Computer v/s Player Version! Player is X and Computer is O. \n");
            System.out.println("You can play Easy mode or Hard mode.");
            System.out.println("→Enter A for Easy mode\n→Enter B for Hard mode\n→Enter any other value to Quit Computer vs Player Version\n");
            System.out.print("Enter: ");
            c = sc.next().charAt(0);
            switch(c)
            {
                case 'A':
                System.out.println("\nWelcome to Easy mode!"); 
                f=0;
                b2.printInstructions();
                while(win==-1 && turn<9 && f!=-1)
                { 
                    turn++;
                    if(turn==1)
                        b2.printBoard();
                    System.out.println("\n*Turn "+turn+"*");
                    if(turn%2==1) // if its the player's turn 
                    {
                        System.out.print("Enter your desired location [1-9] or enter 0 to undo last move or enter any other number to leave the game: ");
                        play=sc.nextInt();
                        if(play>9 || play<0 ) // if the player chose to quit game
                        {
                            System.out.println("You left the game!");
                            f=-1;
                        }

                        if(play==0) // if the player chose to undo last move
                        {
                            System.out.println("\nThe last move was reset!");
                            b2.undo(last, computer);
                            turn-=3;
                            b2.printBoard();
                        }

                        while( f!=-1 && play!=0 && b2.checkFilled(play)!=1) //checking if its a valid move i.e. the location is not already occupied
                        {
                            System.out.print("This location is already filled! Enter a new location: ");
                            play=sc.nextInt();
                        }
                        if(play<=9 || play>=1)
                        last=play;
                    }
                    else if(f!=-1 && play !=0) // executed if the player has not chosen to quit game or undo last move
                    {
                        play=b2.checkPlayerWinRows(2);
                        play=(play==-1)?(b2.checkPlayerWinColumns(2)):play;
                        play=(play==-1)?(b2.checkPlayerWinDiagonal(2)):play; 
                        if(play==-1)
                        {  
                            play=rand.nextInt(9) + 1;
                            while(b2.checkFilled(play)!=1) 
                            play=rand.nextInt(9) + 1;
                        }
                       
                        System.out.println("The computer picked :"+play);
                        computer=play;
                    }
                    
                    if(play!=0 && f!=-1)
                    {
                        b2.updateBoard(player,play);
                        if(turn%2==0)
                            b2.printBoard();
                        if(b2.winCheck()==1)
                        {
                            b2.printBoard();
                            if(turn%2==1)
                                System.out.println("You won!");
                            else
                                System.out.println("The computer won!"); 
                            win=1;
                        }
                        player=(turn%2==1)?2:1; 
                        if(turn==9 && win!=1)
                            System.out.println("The game is a Tie!");  
                    }                 
                }

                break;

                case 'B':
                f=-1; int first=0; // first stores the first move by player
                System.out.println("\nWelcome to Hard mode!"); 
                b2.printInstructions();
                turn=1;
                while(win==-1 && turn<=9 && f!=-2)
                { 
                    if(turn==1)
                        b2.printBoard();
                    System.out.println("\n*Turn "+turn+"*");   
                    f=-1;
                    if(turn%2==1)
                    {   
                        player=1;
                        System.out.print("Enter your desired location [1-9] or enter 0 to undo last move or enter any other number to leave the game: ");
                        play=sc.nextInt();

                        if(play>9 || play<0 )
                        {
                            System.out.println("You left the game!");
                            f=-2;
                        }

                        if(play==0)
                        {
                            System.out.println("\nThe last move was reset!");
                            b2.undo(last, computer);
                            turn-=2;
                            b2.printBoard();
                        }

                        if(f!=-2 && play!=0)
                        {
                            while(b2.checkFilled(play)!=1) //checking if its a valid move i.e. the location is not already occupied
                            {
                                System.out.print("This location is already filled! Enter a new location: ");
                                play=sc.nextInt();
                            }

                            b2.updateBoard(player,play);
                            last=play;
                            if(turn==1) first=play;
                            turn++;

                            if(turn==10)
                            {
                                System.out.println("The game is a Tie!"); 
                                b2.printBoard();
                            }
                        }

                    }

                    if(turn%2==0 && turn<9 && f!=-2 && play!=0)
                    {
                        player=2; 

                        if(turn==2 )
                        {
                            if(play==5)
                                play=1;
                            else 
                                play=5;
                        }

                        else
                        {
                            // checking for winning moves for computer
                            play=b2.checkPlayerWinRows(2);
                            play=(play==-1)?(b2.checkPlayerWinColumns(2)):play;
                            play=(play==-1)?(b2.checkPlayerWinDiagonal(2)):play;
                            f=(play!=-1)?1:f;
                            // checking for winning moves for player in the next round, so that the computer can block
                            play=(play==-1)?(b2.checkPlayerWinRows(1)):play;
                            play=(play==-1)?(b2.checkPlayerWinColumns(1)):play;
                            play=(play==-1)?(b2.checkPlayerWinDiagonal(1)):play;
                            if(play==-1)
                            {
                                if(turn==4 && first!=5)
                                {
                                    play=b2.turn4(first,play);
                                }
                                else
                                {
                                    play=rand.nextInt(9) + 1;
                                    while(b2.checkFilled(play)!=1) 
                                        play=rand.nextInt(9) + 1;  
                                }                                        
                            }
                        }
                        System.out.println("\n*Turn "+turn+"*");
                        System.out.println("The computer picked : "+play); 
                        b2.updateBoard(player,play);
                        computer=play;
                        b2.printBoard();
                        if(f==1)
                        {
                            System.out.println("The computer won!"); 
                            turn=10;
                            win=1;
                        }
                        turn++;
                    }
                }
                break;
                }     
            break;

            default:
            System.exit(0);

        }
        System.out.println("\nTry Again!");
        System.out.println("→Enter 1 to play Player v/s Player\n→Enter 2 to play Computer v/s Player\n→Enter any other value to Quit\n");
        System.out.print("Enter: ");
        a=sc.nextInt();
        }
    }
}