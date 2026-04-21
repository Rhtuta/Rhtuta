package Services;


import Entity.Invoice;
import config.DBconfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceService {
    public  void addInvoice(Invoice invoice) throws SQLException {
        Connection con = DBconfig.getConnection();
        Statement statement = con.createStatement();
        PreparedStatement ps = con.prepareStatement("insert into invoices " +
                "(customer_id,vehicle_id,service_id) values (?,?,?)",statement.RETURN_GENERATED_KEYS);
        ps.setInt(1,invoice.getCustomerId());
        ps.setInt(2,invoice.getVehicleId());
        ps.setString(3,invoice.getServiceId());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()){
            invoice.setId(rs.getInt(1));
        }


        ResultSet rs1 = statement.executeQuery("select * from invoices where id ="+invoice.getId());
        if (rs1.next()){
            System.out.println("  [Invoice id : "+rs1.getInt("id")+
                    ", customer id : "+rs1.getInt("customer_id")+
                    ", vehicle id : "+rs1.getInt("vehicle_id")+
                    ", service id : "+rs1.getString("service_id")+
                    "date : "+rs1.getTimestamp("date")+" ]");
        }
        rs.close();
        ps.close();
        con.close();
    }


    public List<Invoice> getAllInvoices() throws SQLException {
        List<Invoice> list = new ArrayList<>();
        Connection con = DBconfig.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from invoices");
        while (rs.next())
        {
            list.add(new Invoice(rs.getInt("id"),
                    rs.getInt("customer_id"),
                    rs.getInt("vehicle_id"),
                    rs.getString("service_id"),
                    rs.getTimestamp("date")));
        }
        return list;
    }
}
