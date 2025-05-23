package co.com.AutoFacebook.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenAliExpress implements Task {
    private final String url;

    public OpenAliExpress(String url) {
        this.url = url;
    }

    @Step("{0} opens AliExpress homepage")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(url)
        );
    }
    public static OpenAliExpress homePage() {
        return instrumented(OpenAliExpress.class, "https://es.aliexpress.com");
    }
}