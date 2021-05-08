package task;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import ui.GoogleSearchPage;


public class OpenTheApplication implements Task {

    private final String username;
    private final String password;
    private static final EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();

    GoogleSearchPage googleSearchPage;
    public OpenTheApplication(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static OpenTheApplication asSuperAdmin() {
        String username = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("portal.admin");
        String password = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("portal.password");
        return Tasks.instrumented(OpenTheApplication.class, username, password);
    }
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
