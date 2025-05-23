package co.com.AutoFacebook.tasks;

import co.com.AutoFacebook.models.WarrantyFormData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;

import java.util.List;

import static co.com.AutoFacebook.userinterface.WarrantyFormPage.*;

public class FillWarrantyForm implements Task {
    private final List<WarrantyFormData> formData;

    public FillWarrantyForm(List<WarrantyFormData> formData) {
        this.formData = formData;
    }

    public static FillWarrantyForm withData(List<WarrantyFormData> formData) {
        return new FillWarrantyForm(formData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WarrantyFormData data = formData.get(0);

        actor.attemptsTo(
            Click.on(INPUT_COMPANY),
            Enter.theValue(data.getCompany()).into(INPUT_COMPANY),
            Click.on(INPUT_CONTACT_PERSON),
            Enter.theValue(data.getContactPerson()).into(INPUT_CONTACT_PERSON),
            Click.on(INPUT_CUSTOMER_ADDRESS),
            Enter.theValue(data.getCustomerAddress()).into(INPUT_CUSTOMER_ADDRESS),
            Click.on(INPUT_CUSTOMER_PHONE),
            Enter.theValue(data.getCustomerPhone()).into(INPUT_CUSTOMER_PHONE),
            Click.on(INPUT_CUSTOMER_CITY),
            Enter.theValue(data.getCustomerCity()).into(INPUT_CUSTOMER_CITY),
            Click.on(INPUT_CUSTOMER_STATE),
            Enter.theValue(data.getCustomerState()).into(INPUT_CUSTOMER_STATE),
            Click.on(INPUT_CUSTOMER_ZIP),
            Enter.theValue(data.getCustomerZip()).into(INPUT_CUSTOMER_ZIP),
            Click.on(INPUT_HOMEOWNER_NAME),
            Enter.theValue(data.getHomeownerName()).into(INPUT_HOMEOWNER_NAME),
            Click.on(INPUT_HOMEOWNER_PHONE),
            Enter.theValue(data.getHomeownerPhone()).into(INPUT_HOMEOWNER_PHONE),
            Click.on(INPUT_HOMEOWNER_ADDRESS),
            Enter.theValue(data.getHomeownerAddress()).into(INPUT_HOMEOWNER_ADDRESS),
            Click.on(INPUT_HOMEOWNER_CITY),
            Enter.theValue(data.getHomeownerCity()).into(INPUT_HOMEOWNER_CITY),
            Click.on(INPUT_HOMEOWNER_STATE),
            Enter.theValue(data.getHomeownerState()).into(INPUT_HOMEOWNER_STATE),
            Click.on(INPUT_HOMEOWNER_ZIP),
            Enter.theValue(data.getHomeownerZip()).into(INPUT_HOMEOWNER_ZIP),
            Click.on(INPUT_ITEM),
            Enter.theValue(data.getItem()).into(INPUT_ITEM),
            Click.on(INPUT_MODEL),
            Enter.theValue(data.getModel()).into(INPUT_MODEL),
            Click.on(INPUT_SERIAL_NUMBER),
            Enter.theValue(data.getSerialNumber()).into(INPUT_SERIAL_NUMBER),
            Click.on(INPUT_BRAND),
            Enter.theValue(data.getBrand()).into(INPUT_BRAND),
            Click.on(INPUT_DATE_INSTALLED),
            Enter.theValue(data.getDateInstalled()).into(INPUT_DATE_INSTALLED),
            Click.on(INPUT_REASON_FOR_WARRANTY),
            Enter.theValue(data.getReasonForWarranty()).into(INPUT_REASON_FOR_WARRANTY),
            Click.on(INPUT_SIGNATURE),
            Enter.theValue(data.getSignature()).into(INPUT_SIGNATURE),
            Click.on(BUTTON_SUBMIT)
        );
    }
}