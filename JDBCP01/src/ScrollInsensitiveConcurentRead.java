

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ScrollInsensitiveConcurentRead {
    // 1. Load driver
    // 2. create connection
    // 3. create statement
    // 4. execute query
    public static void main(String[] args) throws ClassNotFoundException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mystd"
                    ,"root","root");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String queryy = "insert into student (id,name,age) values (5,'Ronky',27)";
            int insert= statement.executeUpdate(queryy);
            System.out.println("inserted "+insert+" row");
            String query = "select * from student";
            ResultSet rs = statement.executeQuery(query);
            System.out.println("------type scroll insensitive and concurrent read------");
            //ScrollInsensitive means can access forward ,backward and particular
            //and it also make copy of database at rs cache at resultset object creation

            //concurrent read does not allow to update table content while fetching live
            //using resultset function like updateInt & updateRow

            rs.first();
            System.out.println("first row: "+rs.getInt("id")+"  |  "
                    +rs.getString("name")+"  |  "+ rs.getInt("age"));
            rs.last();
            System.out.println("last row: "+rs.getInt("id")+"  |  "
                    +rs.getString("name")+"  |  "+ rs.getInt("age"));
            rs.absolute(2);//for particular row
            System.out.println("particular row: "+rs.getInt("id")+"  |  "
                    +rs.getString("name")+"  |  "+ rs.getInt("age"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
