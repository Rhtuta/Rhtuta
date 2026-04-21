import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCInsertDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mystd"
                    ,"root","root");
            Statement statement = con.createStatement();
            String query = "insert into student (id,name,age) values (4,'Varun',25)";
            int insert= statement.executeUpdate(query);
            System.out.println("Inserted "+insert+ " rows");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
