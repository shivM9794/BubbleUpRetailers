package app.bubbleupretailers.Model;

public class PickUpModel {

    public String name;
    public String serviceType;
    public String service_id;
    public String bookingDate;
    public String bookingTime;
    public String address;

    public PickUpModel(String name, String serviceType, String service_id, String bookingDate, String bookingTime, String address) {
        this.name = name;
        this.serviceType = serviceType;
        this.service_id = service_id;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getService_id() {
        return service_id;
    }

    public void setService_id(String service_id) {
        this.service_id = service_id;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
