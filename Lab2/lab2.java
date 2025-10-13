class Lab2
{
    public static void tree_generator(int height) {
        for(int i=0; i<height; i++)
        {
            for (int j = 0; j < height - i; j++)
            {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i + 1; j++)
            {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
    public static void array_generator(int rows, int cols) {
        int[][] array = new int[cols][rows];
        int number = 0;
        for (int i = 0; i < cols; i++) 
        {
            for (int j = 0; j < rows; j++) 
            {
                array[i][j] = number;
                number += 3;
            }
        }
        for (int i = 0; i < cols; i++) 
        {
            for (int j = 0; j < rows; j++) 
            {
                System.out.print(array[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
    public static void main(String[] args) 
    {
        
        int height = 10;
        int rows = 10;
        int cols = 5;
        tree_generator(height);
        System.out.print("\n");
        array_generator(rows, cols);
        System.out.print("\n");
    }
}