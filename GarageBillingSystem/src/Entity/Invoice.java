package Entity;

import java.sql.Timestamp;

public class Invoice {
    private  int id ;

    private int customerId;

    private int vehicleId;

    private String serviceId;

    private Timestamp date;

    public Invoice(int id, int customerId, int vehicleId, String serviceId,Timestamp date) {
        this.id = id;
        this.customerId = customerId;
        this.vehicleId = vehicleId;
        this.serviceId = serviceId;
        this.date= date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public String toString() {
        return "[ Invoice Id: " + id +
                ", customerId: " + customerId +
                ", vehicleId: " + vehicleId +
                ", serviceId: " + serviceId +
                "date: " + date +
                " ]";
    }
}
