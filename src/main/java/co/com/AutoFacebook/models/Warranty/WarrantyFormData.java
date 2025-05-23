package co.com.AutoFacebook.models.Warranty;

public class WarrantyFormData {
    private String company;
    private String contactPerson;
    private String customerAddress;
    private String customerPhone;
    private String customerCity;
    private String customerState;
    private String customerZip;
    private String homeownerName;
    private String homeownerPhone;
    private String homeownerAddress;
    private String homeownerCity;
    private String homeownerState;
    private String homeownerZip;
    private String item;
    private String model;
    private String serialNumber;
    private String brand;
    private String dateInstalled;
    private String reasonForWarranty;
    private String signature;

    public WarrantyFormData(String company, String contactPerson, String customerAddress, String customerPhone,
                            String customerCity, String customerState, String customerZip, String homeownerName,
                            String homeownerPhone, String homeownerAddress, String homeownerCity,
                            String homeownerState, String homeownerZip, String item, String model,
                            String serialNumber, String brand, String dateInstalled, String reasonForWarranty,
                            String signature) {
        this.company = company;
        this.contactPerson = contactPerson;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
        this.customerCity = customerCity;
        this.customerState = customerState;
        this.customerZip = customerZip;
        this.homeownerName = homeownerName;
        this.homeownerPhone = homeownerPhone;
        this.homeownerAddress = homeownerAddress;
        this.homeownerCity = homeownerCity;
        this.homeownerState = homeownerState;
        this.homeownerZip = homeownerZip;
        this.item = item;
        this.model = model;
        this.serialNumber = serialNumber;
        this.brand = brand;
        this.dateInstalled = dateInstalled;
        this.reasonForWarranty = reasonForWarranty;
        this.signature = signature;
    }

    // Métodos get
    public String getCompany() {
        return company;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public String getCustomerState() {
        return customerState;
    }

    public String getCustomerZip() {
        return customerZip;
    }

    public String getHomeownerName() {
        return homeownerName;
    }

    public String getHomeownerPhone() {
        return homeownerPhone;
    }

    public String getHomeownerAddress() {
        return homeownerAddress;
    }

    public String getHomeownerCity() {
        return homeownerCity;
    }

    public String getHomeownerState() {
        return homeownerState;
    }

    public String getHomeownerZip() {
        return homeownerZip;
    }

    public String getItem() {
        return item;
    }

    public String getModel() {
        return model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getBrand() {
        return brand;
    }

    public String getDateInstalled() {
        return dateInstalled;
    }

    public String getReasonForWarranty() {
        return reasonForWarranty;
    }

    public String getSignature() {
        return signature;
    }
}