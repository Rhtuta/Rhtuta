import Entity.Customer;
import Entity.Invoice;
import Services.BillingService;
import Services.VehicleService;
import config.DBconfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws SQLException {
        Customer getcustomerbyphone = null;
        BillingService billingService = new BillingService();
        Scanner sc =new Scanner(System.in);
        System.out.println();
        System.out.println("Welcome to Garage APP ! [Built using core java & jdbc]");
        while (true)
        {
            System.out.println();
            System.out.println(" 1. Add Customer with vehicle \n 2. Generate Invoice \n" +
                " 3. Show All Invoices \n 4. Show all customer details \n" +
                    " 5. Show all vehicles details \n 6. Show all available services list \n " +
                    "7. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice)
            {
                case 1 :
                    sc.nextLine();
                    System.out.print("Enter Customer name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Customer phone no: ");
                    String phone = sc.next();
                    billingService.customerService.addCustomer(new Customer(0,name,phone));
                    System.out.print("Enter vehicle number: ");
                    String vehNum = sc.next();
                    System.out.print("Enter vehicle model: ");
                    String model = sc.next();
                    getcustomerbyphone= billingService.customerService.getCustomerByPhoneno(phone);
                    System.out.println(getcustomerbyphone);
                    billingService.vehicleService.addVehicle(getcustomerbyphone.getId(),vehNum,model);
                    billingService.vehicleService.getvehiclesDetailsbyCid(getcustomerbyphone.getId());
                    System.out.println();
                    System.out.println("Customer with vehicle Details Added Successfully !");
                    break;


                case 2 :
                    Timestamp date = null;
                    System.out.print("Enter Customer id: ");
                    int cid = sc.nextInt();
                    System.out.print("Enter vehicle id: ");
                    int vid = sc.nextInt();
                    System.out.print("Enter total no of services that customer taken: ");
                    int n = sc.nextInt();
                    List<Integer> sids = new ArrayList<>();
                    for (int i = 0; i < n; i++)
                    {
                        System.out.print("Enter "+(i+1)+"st Service id: ");
                        sids.add(sc.nextInt());
                    }
                    System.out.println();
                    billingService.createInvoice(cid,vid,sids,date);
                    break;


                case 3:
                        System.out.println();
                        billingService.showAllInvoices();
                        break;

                case 4:
                        System.out.println();
                        System.out.println("All customers List !");
                        System.out.println();
                        List<Customer> customerList = billingService.customerService.getAllCustomers();
                        for(Customer customer : customerList)
                        {
                            System.out.println(customer);
                        }
                        break;

                case 5:
                {
                    Connection con = DBconfig.getConnection();
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("select * from vehicles");
                    System.out.println();
                    System.out.println("All vehicles List !");
                    System.out.println();
                    while (rs.next())
                    {
                        System.out.println((" [ Vehicle id : "+rs.getInt("id")+
                                ", Customer id : "+rs.getInt("customer_id")+
                                ", vehicle number plate : "+rs.getString("number_plate")+
                                ", vehicle model : "+rs.getString("model")+" ]"));
                    }
                    rs.close();
                    con.close();
                    stmt.close();
                    break;
                }

                case 6:
                    Connection con = DBconfig.getConnection();
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("select * from services");
                    System.out.println();
                    System.out.println("All available services List !");
                    System.out.println();
                    while (rs.next())
                    {
                        System.out.println((" [ Service id : "+rs.getInt("id")+
                                ", Service name : "+rs.getString("description")+
                                ", Service cost : "+rs.getDouble("cost")+" ]"));
                    }
                    rs.close();
                    con.close();
                    stmt.close();
                    break;

                case 7: System.exit(0);

                default: System.out.println("Invalid choice !");
            }

        }
    }
}
