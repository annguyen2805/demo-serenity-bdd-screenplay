package ui;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {

    public static final Target SEARCH_TEXT_BOX = Target.the("the textbox search")
            .locatedBy("//input[@title='Tìm kiếm']");
    public static final Target LOGO_GOOGLE = Target.the("the logo google")
            .locatedBy("div.logo");
    public static final Target LINK_FACE = Target.the("the link facebook")
            .locatedBy("(//a/h3)[1]");
}
