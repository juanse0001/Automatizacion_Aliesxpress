package co.com.AutoFacebook.tasks;

import co.com.AutoFacebook.userinterface.AliExpressHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectAndAddToCartFirstProduct implements Task {

    private static final int MAX_PRODUCTS_TO_CHECK = 10; // Límite de productos a revisar

    @Step("{0} selecciona el primer producto adecuado y lo añade al carrito desde el modal")
    @Override
    public <T extends Actor> void performAs(T actor) {
        boolean productAddedToCart = false;

        System.out.println("Buscando y abriendo modal del primer producto adecuado para añadir al carrito...");
        List<WebElementFacade> allProductCardLinks = AliExpressHomePage.PRODUCT_CARD_ITEM_LINK.resolveAllFor(actor);

        int productsToIterate = Math.min(allProductCardLinks.size(), MAX_PRODUCTS_TO_CHECK);

        for (int i = 0; i < productsToIterate; i++) {
            WebElementFacade currentProductLink = allProductCardLinks.get(i);
            System.out.println("Intentando producto #" + (i + 1) + "/" + productsToIterate + " (abriendo modal)...");

            // Lógica para cerrar pop-ups si aparecen al hacer clic en el producto (puedes ajustar los tiempos o eliminar si no son un problema)
            try {
                actor.attemptsTo(
                        Click.on(currentProductLink)
                );
                // Manejo de posibles pop-ups después de hacer clic en el producto (opcional, si aparecen con frecuencia)
                try {
                    actor.attemptsTo(WaitUntil.the(AliExpressHomePage.COOKIE_ACCEPT_BUTTON, WebElementStateMatchers.isClickable()).forNoMoreThan(2).seconds(), Click.on(AliExpressHomePage.COOKIE_ACCEPT_BUTTON)); System.out.println("Pop-up de cookies cerrado después de clic en producto.");
                } catch (Exception e) {}
                try {
                    actor.attemptsTo(WaitUntil.the(AliExpressHomePage.SAVE_REGION_BUTTON, WebElementStateMatchers.isClickable()).forNoMoreThan(2).seconds(), Click.on(AliExpressHomePage.SAVE_REGION_BUTTON)); System.out.println("Pop-up de región cerrado después de clic en producto.");
                } catch (Exception e) {}
                try {
                    actor.attemptsTo(WaitUntil.the(AliExpressHomePage.GENERIC_POPUP_CLOSE_BUTTON, WebElementStateMatchers.isClickable()).forNoMoreThan(2).seconds(), Click.on(AliExpressHomePage.GENERIC_POPUP_CLOSE_BUTTON)); System.out.println("Pop-up genérico de cierre (X) cerrado después de clic en producto.");
                } catch (Exception e) {}


                actor.attemptsTo(
                        WaitUntil.the(AliExpressHomePage.PRODUCT_DETAIL_MODAL_CONTAINER, WebElementStateMatchers.isVisible())
                                .forNoMoreThan(10).seconds() // Espera que el modal sea visible
                );
                System.out.println("Modal de detalles de producto abierto para producto #" + (i + 1));

                // Intentar seleccionar una opción de SKU dentro del modal si existen
                try {
                    List<WebElementFacade> skuOptions = AliExpressHomePage.SKU_OPTIONS_IN_MODAL.resolveAllFor(actor);
                    if (!skuOptions.isEmpty()) {
                        List<WebElementFacade> enabledSkuOptions = skuOptions.stream()
                                .filter(option -> option.isCurrentlyVisible() && option.isClickable())
                                .collect(Collectors.toList());

                        if (!enabledSkuOptions.isEmpty()) {
                            Random random = new Random();
                            WebElementFacade randomSkuOption = enabledSkuOptions.get(random.nextInt(enabledSkuOptions.size()));
                            System.out.println("Seleccionando opción de SKU aleatoria: " + randomSkuOption.getText());
                            actor.attemptsTo(Click.on(randomSkuOption));
                        } else {
                            System.out.println("No se encontraron opciones de SKU visibles y clicables en el modal.");
                        }
                    } else {
                        System.out.println("No se encontraron elementos de SKU en el modal para seleccionar.");
                    }
                } catch (Exception skuException) {
                    System.out.println("Error al intentar seleccionar SKU en el modal: " + skuException.getMessage());
                }

                // Esperar a que el botón "Agregar al carrito" esté clicable dentro del modal
                actor.attemptsTo(
                        WaitUntil.the(AliExpressHomePage.ADD_TO_CART_BUTTON_IN_MODAL, WebElementStateMatchers.isClickable())
                                .forNoMoreThan(10).seconds()
                );

                // Clic final en el botón de agregar al carrito dentro del modal
                actor.attemptsTo(
                        Click.on(AliExpressHomePage.ADD_TO_CART_BUTTON_IN_MODAL)
                );

                productAddedToCart = true;
                System.out.println("--> Producto #" + (i + 1) + " agregado al carrito desde el modal de detalles.");
                break; // Salir del bucle, ya encontramos un producto adecuado y lo agregamos.

            } catch (Exception e) {
                System.out.println("Producto #" + (i + 1) + " no abrió el modal de detalles deseado o el botón de carrito no está disponible. Causa: " + e.getMessage());
                // Intentar cerrar el modal si se abrió parcialmente o para limpiar
                try {
                    actor.attemptsTo(
                            Click.on(AliExpressHomePage.MODAL_CLOSE_BUTTON)
                    );
                    System.out.println("Modal de detalles cerrado.");
                } catch (Exception closeException) {
                    System.out.println("No se pudo cerrar el modal de detalles o no apareció. Error: " + closeException.getMessage());
                }
            }
        }

        if (!productAddedToCart) {
            System.out.println("ERROR: No se encontró ningún producto con la opción de añadir al carrito después de revisar " + MAX_PRODUCTS_TO_CHECK + " productos.");
            throw new AssertionError("No se pudo encontrar un producto con la opción de añadir al carrito.");
        }
    }

    public static SelectAndAddToCartFirstProduct fromResults() {
        return instrumented(SelectAndAddToCartFirstProduct.class);
    }
}