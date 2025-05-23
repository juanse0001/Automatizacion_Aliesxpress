package co.com.AutoFacebook.tasks;

import co.com.AutoFacebook.userinterface.AliExpressHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ApplyRandomFilter implements Task {

    @Step("{0} aplica un filtro de resultados aleatorio: Relevancia, Pedidos o Precio")
    @Override
    public <T extends Actor> void performAs(T actor) {
        List<Target> filters = Arrays.asList(
                AliExpressHomePage.FILTER_RELEVANCE,
                AliExpressHomePage.FILTER_ORDERS,
                AliExpressHomePage.FILTER_PRICE
        );

        Random random = new Random();
        Target selectedFilter = filters.get(random.nextInt(filters.size()));

        System.out.println("Aplicando filtro aleatorio: " + selectedFilter.getName());

        actor.attemptsTo(
                WaitUntil.the(selectedFilter, WebElementStateMatchers.isClickable())
                        .forNoMoreThan(10).seconds(),
                Click.on(selectedFilter),
                WaitUntil.the(AliExpressHomePage.PRODUCT_CARD_ITEM_LINK, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(15).seconds()
        );
    }
    public static ApplyRandomFilter onSearchResults() {
        return instrumented(ApplyRandomFilter.class);
    }
}