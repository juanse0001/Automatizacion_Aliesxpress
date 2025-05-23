package co.com.AutoFacebook.stepsdefinitions;

import co.com.AutoFacebook.models.Warranty.WarrantyFormData;
import co.com.AutoFacebook.tasks.Warranty.AbrirPaginaformulario;
import co.com.AutoFacebook.tasks.Warranty.FillWarrantyForm;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import org.openqa.selenium.WebDriver;

import java.util.List;



public class WarrantyFormStepDefinitions{
    private WebDriver driver;

    @Dado("^que el usuario se encuentra en la página del formulario de garantía$")
    public void queElUsuarioSeEncuentraEnLaPáginaDelFormularioDeGarantía() {
        OnStage.theActorInTheSpotlight().wasAbleTo(AbrirPaginaformulario.warrantyForm());
    }

    @Cuando("^el usuario llena el formulario con datos válidos$")
    public void elUsuarioLlenaElFormularioConDatosVálidos(List<WarrantyFormData> warrantyFormData)
    {
        OnStage.theActorInTheSpotlight().attemptsTo(FillWarrantyForm.withData(warrantyFormData));
    }


    @Entonces("^el formulario debe enviarse exitosamente$")
    public void elFormularioDebeEnviarseExitosamente() {
        // Aquí puedes agregar la lógica para verificar que el formulario se haya enviado correctamente
    }
}