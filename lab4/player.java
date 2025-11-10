import java.util.Scanner;

public class player 
{
    private String name;
    private char symbol;

    public player(String name, char symbol) 
    {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() 
    {
        return name;
    }

    public char getSymbol() 
    {
        return symbol;
    }

    public int[] makeMove(Scanner scanner) 
    {
        int[] move = new int[2];
        while (true) 
        {
            try 
            {
                System.out.printf("%s (%c) (1): ", name, symbol);
                move[0] = scanner.nextInt() - 1;
                System.out.printf("%s (%c) (2): ", name, symbol);
                move[1] = scanner.nextInt() - 1;
                System.out.print("\n");
                scanner.nextLine();
                break; 
            } 
            catch (Exception e) 
            {
                System.out.printf("Error %s\n", e.getMessage());
                scanner.nextLine();
            }
        }
        return move;
    }
}