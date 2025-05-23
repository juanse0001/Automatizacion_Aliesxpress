package co.com.AutoFacebook.interactions; // Crea un paquete 'interactions' si no lo tienes

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;

import java.util.Set;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SwitchToNewWindow implements Interaction {

    @Step("{0} cambia el foco a la nueva ventana/pestaña abierta")
    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        String originalWindow = driver.getWindowHandle();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String windowHandle : allWindowHandles) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                System.out.println("Foco cambiado a la nueva ventana/pestaña: " + driver.getCurrentUrl());
                return;
            }
        }
        throw new RuntimeException("No se encontró una nueva ventana/pestaña para cambiar el foco.");
    }
    public static SwitchToNewWindow now() {
        return instrumented(SwitchToNewWindow.class);
    }
}