class tree_gen 
{
    private int height;

    public tree_gen(int height) 
    {
        this.height = height;
    }

    public void print() 
    {
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
}
