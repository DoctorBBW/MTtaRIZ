public class game_field 
{
    private char[][] field;
    private final int sizeField = 3;
    private final char emptySymbol = '-';

    public game_field() 
    {
        field = new char[sizeField][sizeField];
        for (int i = 0; i < sizeField; i++) 
        {
            for (int j = 0; j < sizeField; j++) 
            {
                field[i][j] = emptySymbol;
            }
        }
    }

    public void gameFieldPrint() 
    {
        for (int i = 0; i < sizeField; i++) 
        {
            for (int j = 0; j < sizeField; j++) 
            {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean setFieldCell(int row, int col, char symbol) 
    {
        if (row < 0 || row >= sizeField || col < 0 || col >= sizeField) 
        {
            System.out.println("Error: out of field");
            return false;
        }
        if (field[row][col] != emptySymbol) 
        {
            System.out.println("Erroe cell is full");
            return false;
        }
        field[row][col] = symbol;
        return true;
    }

    public boolean isWin(char symbol) 
    {
        for (int i = 0; i < sizeField; i++) 
        {
            int rowCount = 0;
            int colCount = 0;
            for (int j = 0; j < sizeField; j++) 
            {
                if (field[i][j] == symbol) 
                {
                    rowCount++;
                }
                if (field[j][i] == symbol) 
                {
                    colCount++;
                }
            }
            if (rowCount == sizeField || colCount == sizeField) 
            {
                return true;
            }
        }

        int mainCount = 0;
        int mirrorCount = 0;
        for (int i = 0; i < sizeField; i++)
        {

            if (field[i][i] == symbol) 
            {
                mainCount++;
            }
            if (field[i][sizeField - 1 - i] == symbol) 
            {
                mirrorCount++;
            }
        }
        if (mainCount == sizeField || mirrorCount == sizeField) 
        {
            return true;
        }

        return false;
    }
}