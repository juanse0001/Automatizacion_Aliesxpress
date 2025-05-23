package co.com.AutoFacebook.tasks;

import co.com.AutoFacebook.models.ProductSearchData;
import co.com.AutoFacebook.userinterface.AliExpressHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AdvancedSearch implements Task {
    private final ProductSearchData searchData;

    public AdvancedSearch(ProductSearchData searchData) {
        this.searchData = searchData;
    }

    @Step("{0} performs advanced search with criteria")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClosePopups.now(),
                Enter.theValue(searchData.getTerm()).into(AliExpressHomePage.SEARCH_INPUT),
                Click.on(AliExpressHomePage.SEARCH_BUTTON),

                WaitUntil.the(AliExpressHomePage.CATEGORY_DROPDOWN, isClickable()).forNoMoreThan(5).seconds(),
                Click.on(AliExpressHomePage.CATEGORY_DROPDOWN),

                WaitUntil.the(AliExpressHomePage.CATEGORY_LIST, isVisible()).forNoMoreThan(5).seconds(),

                WaitUntil.the(Target.the("Category: " + searchData.getCategory()).located(By.xpath("//ul[contains(@class, 'Category--categoryList')]//a[contains(text(),'"+searchData.getCategory()+"')]")), isClickable()).forNoMoreThan(5).seconds(),
                Click.on(By.xpath("//ul[contains(@class, 'Category--categoryList')]//a[contains(text(),'"+searchData.getCategory()+"')]"))
        );
    }

    public static AdvancedSearch withCriteria(ProductSearchData searchData) {
        return instrumented(AdvancedSearch.class, searchData);
    }
}