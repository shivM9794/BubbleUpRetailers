package app.bubbleupretailers.Model;

public class DeliveredModel {

    public String name;
    public String amount;
    public String mobileNo;
    public String address;
    public String deliveryDate;
    public String deliveryTime;

    public DeliveredModel(String name, String amount, String mobileNo, String address, String deliveryDate, String deliveryTime) {
        this.name = name;
        this.amount = amount;
        this.mobileNo = mobileNo;
        this.address = address;
        this.deliveryDate = deliveryDate;
        this.deliveryTime = deliveryTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
}
