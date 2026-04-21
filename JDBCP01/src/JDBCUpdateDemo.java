import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCUpdateDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mystd"
                    ,"root","root");
            Statement statement = con.createStatement();
            String query = "update student set age = 28 where id = 2";
            int update= statement.executeUpdate(query);
            System.out.println("Updated "+update+ " rows");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
