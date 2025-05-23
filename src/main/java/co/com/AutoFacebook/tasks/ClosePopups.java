package co.com.AutoFacebook.tasks;

import co.com.AutoFacebook.userinterface.AliExpressHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.ElementClickInterceptedException;
import net.serenitybdd.core.exceptions.SerenityManagedException;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable; // Importación necesaria

public class ClosePopups implements Task {

        @Step("{0} intenta cerrar popups si están presentes")
        @Override
        public <T extends Actor> void performAs(T actor) {
                try {
                        System.out.println("Intentando cerrar el popup 'Enviar a' si está presente.");
                        actor.attemptsTo(
                                WaitUntil.the(AliExpressHomePage.SAVE_REGION_BUTTON, isClickable()).forNoMoreThan(2).seconds(),
                                Click.on(AliExpressHomePage.SAVE_REGION_BUTTON)
                        );
                        System.out.println("Popup 'Enviar a' cerrado exitosamente haciendo clic en Guardar.");

                } catch (TimeoutException e) {
                        System.out.println("El botón 'Guardar' del popup 'Enviar a' no apareció o no fue clicable a tiempo. Continuando con la ejecución.");
                } catch (NoSuchElementException e) {
                        System.out.println("El botón 'Guardar' del popup 'Enviar a' no se encontró. Continuando con la ejecución.");
                } catch (ElementClickInterceptedException e) {
                        System.out.println("El clic en el botón 'Guardar' fue interceptado por otro elemento. Detalles: " + e.getMessage() + ". Continuando.");
                } catch (SerenityManagedException e) {
                        System.out.println("Serenity Managed Exception (posible error subyacente) al intentar cerrar el popup: " + e.getMessage() + ". Continuando.");
                } catch (Exception e) { // Captura cualquier otra excepción inesperada
                        System.err.println("Ocurrió un error inesperado al intentar cerrar el popup: " + e.getMessage());
                }
        }

        public static ClosePopups now() {
                return instrumented(ClosePopups.class);
        }
}