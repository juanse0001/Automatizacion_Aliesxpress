package co.com.AutoFacebook.tasks;

import co.com.AutoFacebook.userinterface.AliExpressHomePage;
import co.com.AutoFacebook.interactions.SwitchToNewWindow;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectFirstProduct implements Task {

    @Step("{0} selecciona el primer producto válido de la lista de resultados que no sea 'Packs de ofertas' y cambia a la nueva pestaña")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(AliExpressHomePage.CONTENEDORES_TARJETAS_PRODUCTO, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(20).seconds()
        );

        List<WebElementFacade> tarjetasProductos = AliExpressHomePage.CONTENEDORES_TARJETAS_PRODUCTO.resolveAllFor(actor);
        System.out.println("Se encontraron " + tarjetasProductos.size() + " tarjetas de productos.");

        if (tarjetasProductos.isEmpty()) {
            throw new AssertionError("No se encontraron tarjetas de productos en la página.");
        }

        WebElementFacade tarjetaSeleccionada = null;

        for (WebElementFacade tarjeta : tarjetasProductos) {
            List<WebElementFacade> elementosPacks = tarjeta.thenFindAll(By.cssSelector("span.lj_ae"));

            boolean esPacksDeOfertas = false;
            for (WebElementFacade elementoPack : elementosPacks) {
                if (elementoPack.getTextContent().contains("Packs de ofertas")) {
                    esPacksDeOfertas = true;
                    break;
                }
            }

            if (!esPacksDeOfertas) {
                tarjetaSeleccionada = tarjeta;
                System.out.println("Primer producto válido encontrado. Deteniendo búsqueda.");
                break;
            } else {
                System.out.println("Producto filtrado: contiene 'Packs de ofertas'.");
            }
        }


        if (tarjetaSeleccionada == null) {
            throw new AssertionError("No se encontraron productos disponibles que no fueran 'Packs de ofertas'.");
        }

        List<WebElementFacade> enlacesProducto = tarjetaSeleccionada.thenFindAll(By.cssSelector("a.search-card-item, a.lj_b.h4_h9, a[href*='/item/']"));

        if (enlacesProducto.isEmpty()) {
            throw new AssertionError("No se pudo encontrar un enlace clickeable en la tarjeta del producto seleccionado.");
        }

        WebElementFacade enlaceProducto = enlacesProducto.get(0);

        String tituloProducto = "Producto desconocido";
        try {
            List<WebElementFacade> elementosTitulo = tarjetaSeleccionada.thenFindAll(By.cssSelector("div.lj_z, h3, [title]"));
            if (!elementosTitulo.isEmpty()) {
                WebElementFacade tituloElement = elementosTitulo.get(0);
                tituloProducto = tituloElement.getTextContent().trim();
                if (tituloProducto.isEmpty() && tituloElement.getAttribute("title") != null) {
                    tituloProducto = tituloElement.getAttribute("title").trim();
                }
            }
        } catch (Exception e) {
            System.out.println("No se pudo obtener el título del producto para logging: " + e.getMessage());
        }

        System.out.println("Seleccionando el primer producto válido: " + tituloProducto);

        actor.attemptsTo(
                Click.on(enlaceProducto)
        );

        System.out.println("Producto seleccionado. Intentando cambiar a nueva pestaña.");

        actor.attemptsTo(
                SwitchToNewWindow.now()
        );
    }

    public static SelectFirstProduct fromTheListExcludingPacksDeOfertas() {
        return instrumented(SelectFirstProduct.class);
    }
}