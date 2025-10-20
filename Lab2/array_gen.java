class array_gen 
{
    private final int sizeRows;
    private final int sizeCols;

    public array_gen(int sizeRows, int sizeCols) 
    {
        this.sizeRows = sizeRows;
        this.sizeCols = sizeCols;
    }

    public void printArray()
    {
        int[][] array = new int[sizeCols][sizeRows];
        int number = 0;
        for (int i = 0; i < sizeCols; i++) 
        {
            for (int j = 0; j < sizeRows; j++) 
            {
                array[i][j] = number;
                number += 3;
            }
        }
        for (int i = 0; i < sizeCols; i++) 
        {
            for (int j = 0; j < sizeRows; j++) 
            {
                System.out.print(array[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
