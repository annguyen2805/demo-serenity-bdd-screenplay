package task;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;
import ui.GoogleSearchPage;


public class OpenTheApplication implements Task {

    GoogleSearchPage googleSearchPage;

    public static OpenTheApplication HomePage() {
        return Tasks.instrumented(OpenTheApplication.class);
    }

    @Step("Open google page")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(googleSearchPage)
        );
    }
}
