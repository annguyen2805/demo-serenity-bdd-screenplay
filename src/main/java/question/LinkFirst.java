package question;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import ui.HomePage;

public class LinkFirst implements Question<String> {

    public static LinkFirst isDisplayed() {
        return new LinkFirst();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(HomePage.LINK_FACE).viewedBy(actor).asString();
    }
}
