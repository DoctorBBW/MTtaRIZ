import java.sql.*;
class Db 
{
    String dbUrl = "jdbc:mysql://localhost:3306/myGame?useSSL=false";
    String user = "root";
    String password = "1234";
    Connection con;
    public Db() 
    {
        try 
        { 
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            this.con=DriverManager.getConnection(dbUrl,user,password);
        } 

        catch(Exception e) 
        { 
            System.out.println(e); 
        }
    }
    public void close() 
    {
        try 
        {
            con.close(); 
        }
        catch(Exception e) 
        { 
            System.out.println(e); 
        } 
    }
    public boolean isUserExists(String username)
    {
        try 
        { 
            Statement stmt=con.createStatement(); 
            ResultSet rs=stmt.executeQuery("SELECT count(*) FROM users WHERE username='"+username+"';"); 
            while(rs.next()) 
                if (rs.getInt(1) == 1) return true; 
                else return false;
        }
        catch(Exception e) 
        { 
            System.out.println(e); 
        }
        return true;
    }
    public boolean checkLogin(String username, String password) 
    {
        String sql = "SELECT password FROM users WHERE username = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) 
        {
            
            stmt.setString(1, username);

            try (ResultSet rs = stmt.executeQuery()) 
            {
                
                if (rs.next()) 
                {
                    String dbPassword = rs.getString("password");
                    return dbPassword.equals(password); 
                } 
                else 
                {
                    return false;
                }
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Error:");
            e.printStackTrace();
        }
        return false;
    }
}