package com.demo.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import question.LinkFirst;
import task.OpenTheApplication;
import task.SearchGoogle;
import ui.HomePage;
import static org.hamcrest.Matchers.equalToIgnoringCase;

import static net.serenitybdd.screenplay.GivenWhenThen.*;

@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag("demo")
})
public class TestGoogle {
    private Actor annv = Actor.named("annv");

    @Managed
    private WebDriver hisBrowser;

    @Before
    public void annvCanBrowser(){
        annv.can(BrowseTheWeb.with(hisBrowser));
        annv.wasAbleTo(
            OpenTheApplication.HomePage()
        );
    }

    @Test
    public void test_search_google(){
        when(annv).attemptsTo(
                SearchGoogle.withKeword("facebook")
        );
        and(annv).attemptsTo(
                Ensure.that(HomePage.LOGO_GOOGLE).isDisplayed()
        );
        then(annv).should(
                seeThat(LinkFirst.isDisplayed(),equalToIgnoringCase("Facebook - Đăng nhập hoặc đăng ký"))
        );
    }

}
