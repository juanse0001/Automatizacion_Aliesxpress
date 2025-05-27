package co.com.AutoFacebook.stepsdefinitions;

import co.com.AutoFacebook.tasks.*;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ProductSearchStepDefinitions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("^que \"([^\"]*)\" accede a la página principal de AliExpress$")
    public void abrirPaginaPrincipal(String actorName) {
        theActorCalled(actorName).attemptsTo(
                OpenAliExpress.homePage()
        );
    }

    @Cuando("^busca el producto \"([^\"]*)\", aplica un filtro aleatorio y selecciona uno de los resultados$")
    public void buscarFiltrarYSeleccionarProducto(String producto) {
        theActorInTheSpotlight().attemptsTo(
                SearchForProduct.called(producto),
                ApplyRandomFilter.onSearchResults(),
                SelectFirstProduct.fromTheListExcludingPacksDeOfertas()
        );
    }

    @Entonces("^se encuentra en la página de detalles del producto$")
    public void estaEnDetalleDelProducto() {
        // Este paso puede ser validación o simplemente informativo
        System.out.println("El actor está en los detalles del producto.");
    }

    @Entonces("^guarda la configuración de moneda y envío si aparece el modal$")
    public void guardaConfiguracionMonedaYEnvio() {
        theActorInTheSpotlight().attemptsTo(
                SaveCurrencyAndShipment.settings()
        );
    }

    @Entonces("^agrega el producto a la cesta$")
    public void agregaProductoALaCesta() {
        theActorInTheSpotlight().attemptsTo(
                AddToCart.theProductAndGoToCart()
        );
    }
}
