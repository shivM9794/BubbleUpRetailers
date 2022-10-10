package app.bubbleupretailers.Model;

public class EarningsModel {

    public String name;
    public String serviceID;
    public String amount;
    public String jobDetails;
    public String loc;
    public String bookingDate;
    public String deliveryDate;

    public EarningsModel(String name, String serviceID, String amount, String jobDetails, String loc, String bookingDate, String deliveryDate) {
        this.name = name;
        this.serviceID = serviceID;
        this.amount = amount;
        this.jobDetails = jobDetails;
        this.loc = loc;
        this.bookingDate = bookingDate;
        this.deliveryDate = deliveryDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getJobDetails() {
        return jobDetails;
    }

    public void setJobDetails(String jobDetails) {
        this.jobDetails = jobDetails;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}
