package task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;
import ui.HomePage;

public class SearchGoogle implements Task {
    private String key;

    public SearchGoogle(String key){
        this.key = key;
    }

    public static SearchGoogle withKeword(String key) {
        return Tasks.instrumented(SearchGoogle.class, key);
    }

    @Step("Search with keyword {0}")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.keyValues(key).into(HomePage.SEARCH_TEXT_BOX).thenHit(Keys.ENTER)
        );
    }
}
