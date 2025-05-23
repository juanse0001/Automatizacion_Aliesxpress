package co.com.AutoFacebook.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static co.com.AutoFacebook.userinterface.AliExpressHomePage.LINK_OPEN_CURRENCY_SHIPMENT_MODAL;
import static co.com.AutoFacebook.userinterface.AliExpressHomePage.SAVE_BUTTON_CURRENCY_SHIPMENT;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SaveCurrencyAndShipment implements Task {

    @Step("{0} guarda la configuración de moneda y envío")
    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("DEBUG: Intentando hacer clic para abrir el modal de configuración de moneda y envío.");
        actor.attemptsTo(
                WaitUntil.the(LINK_OPEN_CURRENCY_SHIPMENT_MODAL, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(15).seconds(),
                Click.on(LINK_OPEN_CURRENCY_SHIPMENT_MODAL)
        );

        System.out.println("DEBUG: Intentando hacer clic en el botón 'Guardar' dentro del modal.");
        actor.attemptsTo(
                WaitUntil.the(SAVE_BUTTON_CURRENCY_SHIPMENT, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds(),
                WaitUntil.the(SAVE_BUTTON_CURRENCY_SHIPMENT, WebElementStateMatchers.isEnabled())
                        .forNoMoreThan(10).seconds(),
                Click.on(SAVE_BUTTON_CURRENCY_SHIPMENT)
        );
        System.out.println("DEBUG: Se intentó hacer clic en el botón 'Guardar' del modal de configuración.");
    }

    public static SaveCurrencyAndShipment settings() {
        return instrumented(SaveCurrencyAndShipment.class);
    }
}