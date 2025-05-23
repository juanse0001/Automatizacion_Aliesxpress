package co.com.AutoFacebook.tasks;

import co.com.AutoFacebook.interactions.SwitchToNewWindow;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static co.com.AutoFacebook.userinterface.AliExpressHomePage.BOTON_AGREGAR_CARRITO;
import static co.com.AutoFacebook.userinterface.AliExpressHomePage.BUTTON_IR_A_LA_CESTA;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddToCart implements Task {

    private boolean irALaCesta = false;
    public AddToCart withGoToCartOption() {
        this.irALaCesta = true;
        return this;
    }

    @Step("{0} agrega el producto a la cesta desde el modal de detalles")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(BOTON_AGREGAR_CARRITO, WebElementStateMatchers.isEnabled())
                        .forNoMoreThan(15).seconds(),
                Click.on(BOTON_AGREGAR_CARRITO)
        );
        if (irALaCesta) {
            actor.attemptsTo(
                    Click.on(BUTTON_IR_A_LA_CESTA)
            );
            actor.attemptsTo(
                    SwitchToNewWindow.now()
            );
        }
    }

    public static AddToCart theProduct() {
        return instrumented(AddToCart.class);
    }

    public static AddToCart theProductAndGoToCart() {
        return instrumented(AddToCart.class).withGoToCartOption();
    }
}