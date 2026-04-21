import java.sql.*;

public class InsertUsingPrepareStmt {
    public static void main(String[] args) throws ClassNotFoundException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mystd"
                    ,"root","root");
            PreparedStatement pstmt = con.prepareStatement("insert into student " +
                    "(id,name,age) values (?,?,?)");
            pstmt.setInt(1,5);
            pstmt.setString(2,"Varun");
            pstmt.setInt(3,26);
            pstmt.executeUpdate();
            System.out.println("Inserted rows");

            System.out.println("---------------------------------");

            PreparedStatement pstmt1 = con.prepareStatement(
                    "SELECT id, age FROM student WHERE age > ?");
            pstmt1.setInt(1, 25);
            ResultSet rs = pstmt1.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("id")+" | "
                        +rs.getInt("age"));
            }

            PreparedStatement pstmt2 = con.prepareStatement(
                    "delete from student where id = ?");
            pstmt2.setInt(1,4);
            pstmt2.executeUpdate();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
