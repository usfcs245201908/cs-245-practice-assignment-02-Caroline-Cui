public class NQueens
{
    int[][] board;
    public NQueens(int size)
    {
        board = new int[size][size];
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                board[i][j] = 0;
//                    System.out.print(board[i][j]);
            }
//                System.out.println();
        }
    }


    public boolean canPlaceQueen(int row, int col)
    {
        int i;
        int sum = 0;
        for (i = 0; i < board.length; i++)
        {
            sum = sum + board[row][i];
            if (sum == 1)
            {
                return false;
            }

        }
        sum = 0;
        for (i = 0; i < board.length; i++)
        {
            sum = sum + board[i][col];
            if (sum == 1)
            {
                return false;
            }
        }
        sum = 0;

        if (checkD(row,col) == false)
        {
            return false;
        }

        return true;
    }

    public boolean checkD(int r, int c)
    {
        int j;
        j = 1;
        while ((r + j < board.length)&& (c + j < board.length) )
        {
            if (board[r+j][c+j] == 1)
            {
                return false;
            }
            j++;
        }


        j = 1;
        while ((r - j >= 0) && (c - j >= 0))
        {
            if (board[r-j][c-j] == 1)
            {
                return false;
            }
            j++;
        }

        j = 1;

        while ((r - j >= 0)&&(c + j < board.length))
        {
            if (board[r-j][c+j] == 1)
            {
                return false;
            }
            j++;

        }
        j = 1;

        while ((r + j < board.length) && (c - j >= 0))
        {
            if (board[r+j][c-j] == 1)
            {
                return false;
            }
            j++;

        }
        return true;
    }

    public boolean placeQueen(int row)
    {
        if (board.length<1)
        {
            throw new IllegalArgumentException("Your input is a negative number");
        }
//        int size = board.length;
        else
        {
            if (row >= board.length)
            {
                printToConsole();
                return true;
            }
            for (int i = 0; i < board.length; i++)
            {
                if (canPlaceQueen(row, i))
                {
                    board[row][i] = 1;
                    if (placeQueen(row + 1))
                    {
                        return true;
                    }
                }

                board[row][i] = 0;


            }
        }

        return false;
    }

    public boolean placeNQueens()
    {
        if (placeQueen(0))
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    public void printToConsole()
    {
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board.length; j++)
            {
                System.out.print("["+board[i][j]+"]");
            }
            System.out.println();
        }
    }


}
