package co.com.AutoFacebook.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GoBack implements Task {

    @Step("{0} regresa a la página anterior")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                GoBack.toPreviousPage()
        );
    }
    public static GoBack toPreviousPage() {
        return instrumented(GoBack.class);
    }
}