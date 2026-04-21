import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDeleteDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mystd"
                    ,"root","root");
            Statement statement = con.createStatement();
            String query = "delete from student where id = 5";
            int delete= statement.executeUpdate(query);
            System.out.println("Deleted "+delete+ " rows");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
