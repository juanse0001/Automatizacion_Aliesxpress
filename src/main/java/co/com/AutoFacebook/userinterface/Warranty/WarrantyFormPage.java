package co.com.AutoFacebook.userinterface.Warranty;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class WarrantyFormPage {
    public static final Target INPUT_COMPANY = Target.the("Company input").located(By.id("company"));
    public static final Target INPUT_CONTACT_PERSON = Target.the("Contact person input").located(By.id("contactPerson"));
    public static final Target INPUT_CUSTOMER_ADDRESS = Target.the("Customer address input").located(By.id("customerAddress"));
    public static final Target INPUT_CUSTOMER_PHONE = Target.the("Customer phone input").located(By.id("customerPhone"));
    public static final Target INPUT_CUSTOMER_CITY = Target.the("Customer city input").located(By.id("customerCity"));
    public static final Target INPUT_CUSTOMER_STATE = Target.the("Customer state input").located(By.id("customerState"));
    public static final Target INPUT_CUSTOMER_ZIP = Target.the("Customer zip input").located(By.id("customerZip"));
    public static final Target INPUT_HOMEOWNER_NAME = Target.the("Homeowner name input").located(By.id("homeownerName"));
    public static final Target INPUT_HOMEOWNER_PHONE = Target.the("Homeowner phone input").located(By.id("homeownerPhone"));
    public static final Target INPUT_HOMEOWNER_ADDRESS = Target.the("Homeowner address input").located(By.id("homeownerAddress"));
    public static final Target INPUT_HOMEOWNER_CITY = Target.the("Homeowner city input").located(By.id("homeownerCity"));
    public static final Target INPUT_HOMEOWNER_STATE = Target.the("Homeowner state input").located(By.id("homeownerState"));
    public static final Target INPUT_HOMEOWNER_ZIP = Target.the("Homeowner zip input").located(By.id("homeownerZip"));
    public static final Target INPUT_ITEM = Target.the("Item input").located(By.id("item"));
    public static final Target INPUT_MODEL = Target.the("Model input").located(By.id("model"));
    public static final Target INPUT_SERIAL_NUMBER = Target.the("Serial number input").located(By.id("serialNumber"));
    public static final Target INPUT_BRAND = Target.the("Brand input").located(By.id("brand"));
    public static final Target INPUT_DATE_INSTALLED = Target.the("Date installed input").located(By.id("dateInstalled"));
    public static final Target INPUT_REASON_FOR_WARRANTY = Target.the("Reason for warranty input").located(By.id("reasonForWarranty"));
    public static final Target INPUT_SIGNATURE = Target.the("Signature input").located(By.id("signature"));
    public static final Target BUTTON_SUBMIT = Target.the("Submit button").located(By.cssSelector("button[type='submit']"));
}