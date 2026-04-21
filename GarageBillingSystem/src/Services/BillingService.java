package Services;

import Entity.Invoice;
import config.DBconfig;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BillingService {
    public CustomerService customerService = new CustomerService();
     public InvoiceService invoiceService = new InvoiceService();
     public VehicleService vehicleService = new VehicleService();

    public void createInvoice(int customerId, int vehicleId, List<Integer> serviceIds, Timestamp date) throws SQLException {
        StringBuilder sids= new StringBuilder();
        for(int serviceId: serviceIds)
        {
           sids.append(serviceId);
            sids.append(", ");
        }
        invoiceService.addInvoice(new Invoice(0,customerId,vehicleId,sids.toString(),date));
        System.out.println("Invoice generated successfully !");
    }

    public void showAllInvoices() throws SQLException {
        List<Invoice> invoices =  invoiceService.getAllInvoices();
        for(Invoice invoice: invoices)
        {
            System.out.println(invoice);
        }
    }

}
