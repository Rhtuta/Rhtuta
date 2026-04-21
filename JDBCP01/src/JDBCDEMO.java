

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDEMO {
    // 1. Load driver
    // 2. create connection
    // 3. create statement
    // 4. execute query
    public static void main(String[] args) throws ClassNotFoundException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mystd"
                    ,"root","root");
            Statement statement = con.createStatement();
            String query = "select * from student";
            ResultSet rs = statement.executeQuery(query);
            while(rs.next())
            {
                System.out.println(rs.getInt("id")+" | "+
                        rs.getString("name")+" | "+
                        rs.getInt("age"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
