package Services;

import Entity.Customer;
import config.DBconfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleService {
    public void addVehicle(int customerid,String vehNum,String model) throws SQLException {
        Connection con = DBconfig.getConnection();
        PreparedStatement ps = con.prepareStatement("insert into vehicles " +
                "(customer_id,number_plate,model) values (?,?,?)");
        ps.setInt(1, customerid);
        ps.setString(2, vehNum);
        ps.setString(3, model);
        ps.executeUpdate();
        ps.close();
        con.close();
    }


    public void getvehiclesDetailsbyCid(int cid) throws SQLException {
        Connection con = DBconfig.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from vehicles where customer_id = "+cid);
        while (rs.next())
        {
            System.out.println((" [ Vehicle id : "+rs.getInt("id")+
                    ", Customer id : "+rs.getInt("customer_id")+
                    ", vehicle number plate : "+rs.getString("number_plate")+
                    ", vehicle model : "+rs.getString("model")+" ]"));
        }

    }

    public void getAllvehicles(int cid) throws SQLException {
        Connection con = DBconfig.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from vehicles");
        while (rs.next())
        {
            System.out.println(("[ Vehicle id : "+rs.getInt("id")+
                    ", vehicle number plate : "+rs.getString("number_plate")+
                    ", vehicle model : "+rs.getString("model")+" ]"));
        }

    }
}
