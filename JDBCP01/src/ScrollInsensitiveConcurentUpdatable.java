

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ScrollInsensitiveConcurentUpdatable {
    // 1. Load driver
    // 2. create connection
    // 3. create statement
    // 4. execute query
    public static void main(String[] args) throws ClassNotFoundException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mystd"
                    ,"root","root");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            String query = "select * from student";
            ResultSet rs = statement.executeQuery(query);
            System.out.println("------type scroll insensitive and concurrent read------");
            //ScrollInsensitive means can access forward ,backward and particular
            //and it also make copy of database at rs cache at resultset object creation

            //concurrent updatable must table & query have primary key and single table if
            // allow to update table content while fetching live with resultset functions


            if(rs.first())
            {
                System.out.println("first row: "+rs.getInt("id")+"  |  "
                        +rs.getString("name")+"  |  "+ rs.getInt("age"));
                rs.updateInt("age",10);
                rs.updateRow();
                System.out.println("Row updated successfully");
                //also works on while(hasnext()) loop
                System.out.println("first row: "+rs.getInt("id")+"  |  "
                        +rs.getString("name")+"  |  "+ rs.getInt("age"));

            }
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
