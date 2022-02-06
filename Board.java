public class Board   // class containing all functions depending on the board/grid of TicTacToe 
{
    private char[] grid = new char[9]; // declaring the 3X3 board for a new game of TicTacToe

    Board() //constructor to inistialise the variables when a new object is created
    {
        for(int i=0;i<9;i++)
            grid[i]=' ';
    }
 
    public int checkFilled(int location) // checks if its a valid move i.e. the location is not already occupied
    {
        if(grid[location-1]!=' ') 
            return -1;
        else 
            return 1;
    }

    public void undo(int player, int computer) // undos the last move of the player, hence undos the last move of the computer too
    {
        grid[player-1]=' ';
        grid[computer-1]=' ';
    }

    public int turn4(int first,int play) // specifications for the computer for its move in *turn 4*
    {
        if(first==1 || first==3 || first==7 || first==9)
        {
            play=(grid[1]==' ')?2:play;
            play=(play==-1)?4:play;
        } 
        else if(first==2 || first==4 || first==6 || first==8)
        {
            play=(grid[0]==' ')?1:play;
            play=(play==-1)?3:play;
        } 
        return play;
    }

    public void updateBoard(int player,int location) // updates the grid when a cell is filled by either the player or the computer
    {
        grid[location-1]=(player==1)?'X':'O';
    }

    public void printBoard() // prints the current grid for the game
    {
        //System.out.println("\nThe updated Board is :\n");
        System.out.println();
        System.out.println("  "+grid[0]+" | "+grid[1]+" | "+grid[2]);
        System.out.println(" --- --- ---");
        System.out.println("  "+grid[3]+" | "+grid[4]+" | "+grid[5]);
        System.out.println(" --- --- ---");
        System.out.println("  "+grid[6]+" | "+grid[7]+" | "+grid[8]+"\n");
    }
     
    public void printInstructions() // prints the instructions before the start of a game
    {
        System.out.println("This is a new game. The board numbers are as follows:\n");
        System.out.println("  1 | 2 | 3");
        System.out.println(" --- --- ---");
        System.out.println("  4 | 5 | 6");
        System.out.println(" --- --- ---");
        System.out.println("  7 | 8 | 9\n");
    }

    public int winCheck() // checks if a player has won the game
    {
        if((grid[0]==grid[1] && grid[1]==grid[2] && grid[1]!=' ')||(grid[3]==grid[4] && grid[4]==grid[5] && grid[4]!=' ')||(grid[6]==grid[7] && grid[7]==grid[8] && grid[7]!=' ')||(grid[0]==grid[3] && grid[3]==grid[6] && grid[3]!=' ')||(grid[1]==grid[4] && grid[4]==grid[7] && grid[4]!=' ')||(grid[2]==grid[5] && grid[5]==grid[8] && grid[5]!=' ')||(grid[0]==grid[4] && grid[4]==grid[8] && grid[4]!=' ')||(grid[2]==grid[4] && grid[4]==grid[6] && grid[4]!=' '))
            return 1;
        else 
            return 0;
    }

    public int checkPlayerWinRows(int player) // checks if a row has two cells filled with 'player' and returns the other cell if its empty 
    {
        char c=(player==1)?'X':'O';
        int location=0;
        while(location!=9)
        {
        if( (int)grid[location] + (int)grid[location+1] + (int)grid[location+2] ==2*(int)c + 32 )
        {
            if (grid[location]==' ') return location+1;
            if (grid[location+1]==' ') return (location+2);
            if (grid[location+2]==' ') return (location+3);
        }
        location+=3;
        }
        return -1;
    }

    public int checkPlayerWinColumns(int player) // checks if a column has two cells filled with 'player' and returns the other cell if its empty 
    {
        char c=(player==1)?'X':'O';
        int location=0;
        while(location!=3)
        {
            if( (int)grid[location] + (int)grid[location+3] + (int)grid[location+6] ==2*(int)c + 32 )
            {
                if (grid[location]==' ') return location+1;
                if (grid[location+3]==' ') return location+4;
                if (grid[location+6]==' ') return location+7;
            }
            location++;
        }
        return -1;
    }

    public int checkPlayerWinDiagonal(int player) // checks if a diagonal has two cells filled with 'player' and returns the other cell if its empty 
    {
        char c=(player==1)?'X':'O';
        if( (int)grid[0] + (int)grid[4] + (int)grid[8] ==2*(int)c + 32 )
        {
            if (grid[0]==' ') return 1;
            if (grid[4]==' ') return 5;
            if (grid[8]==' ') return 9;
        }

        if( (int)grid[2] + (int)grid[4] + (int)grid[6] ==2*(int)c + 32 )
        {
            if (grid[2]==' ') return 3;
            if (grid[4]==' ') return 5;
            if (grid[6]==' ') return 7;
        }
        return -1;
    }
}