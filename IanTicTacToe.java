import java.util.Scanner;

public class IanTicTacToe
{
    private char[][] board;
    private char currentPlayer;

    public IanTicTacToe()
    {
        board = new char[3][3];
        currentPlayer = 'x';
        initializeBoard();
    }

    //check if board is full
    public boolean isFull()
    {
        boolean isFull = true;
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (board[i][j] == ' ')
                {
                    isFull = false;
                }
            }
        }
        return isFull;
    }

    //populate board
    public void initializeBoard()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                board[i][j] = ' ';
            }
        }
    }


    //board printing
    public void printBoard()
    {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++)
        {
            System.out.print("| ");
            for (int j = 0; j < 3; j++)
            {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    //check for win
    public boolean checkForWin()
    {
        return (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin());
    }

    private boolean checkDiagonalsForWin()
    {
        char firstDiagnol = board[0][0];
        char secondDiagnol = board [2][0];
        if(firstDiagnol == board[1][1] && firstDiagnol == board[2][2] && firstDiagnol != ' ')
        {
            return true;
        }
        else if (secondDiagnol == board[1][1] && secondDiagnol == board[0][2] && secondDiagnol != ' ')
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private boolean checkColumnsForWin()
    {
        for (int i = 0; i < 3; i++)
        {
            if (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] != ' ')
            {
                return true;
            }
        }
        return false;
    }

    private boolean checkRowsForWin()
    {
        for (int i = 0; i < 3; i++)
        {
            if (board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] != ' ')
            {
                return true;
            }
        }
        return false;
    }
    // Change player marks back and forth.
    public void changePlayer() {
        currentPlayer = (currentPlayer == 'x') ? 'o' : 'x';
    }

    // Places a mark at the cell specified by row and col with the mark of the current player.
    public boolean placeMark(int row, int col)
    {
        //subtract one from row and col to match array
        row -= 1;
        col -= 1;
        // Check if that cell is empty
        if (board[row][col] == ' ')
        {
            board[row][col] = currentPlayer;
            return true;
        }
        return false;
    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        IanTicTacToe game = new IanTicTacToe();
        game.initializeBoard();
        do
        {
            System.out.println("Board:");
            game.printBoard();
            int row;
            int col;
            do
            {
                System.out.println("Player " + game.currentPlayer + ", enter an empty row and column to place your mark!");
                row = scan.nextInt();
                col = scan.nextInt();
            }
            while (!game.placeMark(row, col));
            game.changePlayer();
        }
        while(!game.checkForWin() && !game.isFull());
        if (game.isFull() && !game.checkForWin())
        {
            System.out.println("The game was a tie!");
        }
        else
        {
            System.out.println("Current board layout:");
            game.printBoard();
            game.changePlayer();
            System.out.println(Character.toUpperCase(game.currentPlayer) + " Wins!");
        }
    }
}
