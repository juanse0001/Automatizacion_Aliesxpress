package co.com.AutoFacebook.tasks.Warranty;

import co.com.AutoFacebook.userinterface.Warranty.InicioFormulario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

public class AbrirPaginaformulario implements Task {
    private final InicioFormulario inicioWarrantyForm;

    public AbrirPaginaformulario() {
        this.inicioWarrantyForm = new InicioFormulario();
    }

    public static AbrirPaginaformulario warrantyForm() {
        return Tasks.instrumented(AbrirPaginaformulario.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn(inicioWarrantyForm)
        );
    }
}
