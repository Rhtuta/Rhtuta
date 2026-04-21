

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ScrollsensitiveConcurentUpdate {
    // 1. Load driver
    // 2. create connection
    // 3. create statement
    // 4. execute query
    public static void main(String[] args) throws ClassNotFoundException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mystd"
                    ,"root","root");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            String query = "select * from student";
            ResultSet rs = statement.executeQuery(query);
            System.out.println("------type scroll insensitive and concurrent read------");
            //Scrollsensitive:- resultset is sync with Database even during fetching
            // and does not make copy at database at resultset obj creation
            // so data might update at live fetching but depends on mysql driver
            //as mysql driver usually not supporting

            
            rs.beforeFirst();
            Thread.sleep(20000);
            System.out.println("sensitive and concurrentUpdate with using resultset functions" +
                    "like updateInt and UpdateRow etc");
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
            System.out.println("sensitive and concurrentUpdate without using resultset functions" +
                    "like updateInt and UpdateRow etc");
            rs.beforeFirst();
            System.out.println("-------------------------------");
            while (rs.next())
            {
                System.out.println("last row: "+rs.getInt("id")+"  |  "
                        +rs.getString("name")+"  |  "+ rs.getInt("age"));
            }
            con.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}
