package Services;

import Entity.Customer;
import config.DBconfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    public void addCustomer(Customer customer) throws SQLException {
        Connection con = DBconfig.getConnection();
        PreparedStatement ps = con.prepareStatement("insert into customers " +
                "(name,phone) values (?,?)");
        ps.setString(1, customer.getName());
        ps.setString(2, customer.getPhone());
        ps.executeUpdate();
        ps.close();
        con.close();
    }

    public Customer getCustomerByPhoneno(String phone) throws SQLException {
        Customer customer = new Customer();
        Connection con = DBconfig.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from customers where phone ="+phone);
        while (rs.next())
        {
            customer = new Customer(rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("phone"));
        }
        return customer;
    }

    public List<Customer> getAllCustomers() throws SQLException {
        List<Customer> list = new ArrayList<>();
        Connection con = DBconfig.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from customers");
        while (rs.next())
        {
            list.add(new Customer(rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("phone")));
        }
        return list;
    }
}
