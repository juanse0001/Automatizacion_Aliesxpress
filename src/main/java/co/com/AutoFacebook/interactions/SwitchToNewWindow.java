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
        String originalWindow = driver.getWindowHandle(); // Guarda el handle de la ventana original

        // Espera un momento para que la nueva ventana se abra completamente
        // Esto es crucial, ya que la nueva ventana puede no estar disponible inmediatamente
        try {
            Thread.sleep(5000); // Pequeña espera, puedes ajustarla o usar un WebDriverWait más sofisticado
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Set<String> allWindowHandles = driver.getWindowHandles(); // Obtiene todos los handles de ventanas

        // Itera sobre los handles para encontrar la nueva ventana
        for (String windowHandle : allWindowHandles) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle); // Cambia el foco a la nueva ventana
                System.out.println("Foco cambiado a la nueva ventana/pestaña: " + driver.getCurrentUrl());
                return; // Sal de la función una vez que se cambia
            }
        }
        throw new RuntimeException("No se encontró una nueva ventana/pestaña para cambiar el foco.");
    }

    public static SwitchToNewWindow now() {
        return instrumented(SwitchToNewWindow.class);
    }
}