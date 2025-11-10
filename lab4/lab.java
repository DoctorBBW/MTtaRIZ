import java.util.Scanner;
public class lab 
{
    public static void main(String[] args) 
    {

        Db database = new Db();
        Scanner scanner = new Scanner(System.in);
        player player1 = null;
        player player2 = null;

        for (int i = 1; i <= 2; i++) 
        {
            System.out.println("\nUser " + i);
            
            System.out.print("Name: ");
            String username = scanner.nextLine();

            System.out.print("Password: ");
            String password = scanner.nextLine();

            if (database.checkLogin(username, password)) 
            {
                System.out.println("SUCCESSFUL " + username);
                if(i == 1)
                {
                    player1 = new player(username, 'X');
                }
                else
                {
                    player2 = new player(username, 'O');
                }
            } 
            else 
            {
                System.out.println("ERROR username or password");
                i--;
            }
        }
        database.close();

        if (player1 == null || player2 == null) 
        {
            System.out.println("\nEnter Error");
            scanner.close();
            return;
        }
        game_field field = new game_field();

        player currentPlayer = player1; 
        int moveCount = 0;

        System.out.print("\n");

        while (true) 
        {
            field.gameFieldPrint(); 
            
            int[] move;
            while (true) 
            {
                move = currentPlayer.makeMove(scanner);
                if (field.setFieldCell(move[0], move[1], currentPlayer.getSymbol())) 
                {
                    break;
                }
            }
            
            moveCount++;

            if (field.isWin(currentPlayer.getSymbol())) 
            {
                field.gameFieldPrint();
                System.out.println("Win " + currentPlayer.getName());
                break; 
            }
            
            if (moveCount == 9) 
            {
                field.gameFieldPrint();
                System.out.println("Draw");
                break;
            }

            if (currentPlayer == player1) 
            {
                currentPlayer = player2;
            } 
            else 
            {
                currentPlayer = player1;
            }
        }
        scanner.close();
    }
}
