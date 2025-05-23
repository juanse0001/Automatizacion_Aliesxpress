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

    @Dado("^que \"([^\"]*)\" está en la página principal de AliExpress$")
    public void openHomePage(String actorName) {
        theActorCalled(actorName).attemptsTo(
                OpenAliExpress.homePage()
        );
    }

    @Cuando("^Juan busca \"([^\"]*)\"$")
    public void juanBusca(String product) {
        theActorInTheSpotlight().attemptsTo(
                SearchForProduct.called(product)
        );
    }

    @Cuando("^aplica un filtro de resultados aleatorio$")
    public void aplicaUnFiltroAleatorio() {
        theActorInTheSpotlight().attemptsTo(
                ApplyRandomFilter.onSearchResults()
        );
    }
    @Entonces("^selecciona un producto$")
    public void SeleccionarProducto() {
        theActorInTheSpotlight().attemptsTo(
                SelectFirstProduct.fromTheListExcludingPacksDeOfertas()
        );
    }

    @Dado("^Que (?:.*) esta en los detalles del producto$")
    public void juanEstaEnLosDetallesDelProducto() {
        System.out.println("El actor está en los detalles del producto.");
    }

    @Cuando("^guarda la configuración de moneda y envío si aparece el modal$") // Torsión ajustada
    public void guardaLaConfiguracionDeMonedaYEnvioSiApareceElModal() {
        theActorInTheSpotlight().attemptsTo(
                SaveCurrencyAndShipment.settings()
        );
    }

    @Entonces("^agrega a la cesta$")
    public void agregaALaCesta() {
        theActorInTheSpotlight().attemptsTo(
                AddToCart.theProductAndGoToCart()
        );
    }
}