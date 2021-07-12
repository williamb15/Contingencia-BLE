package co.com.banistmo.certification.contingencia.questions;

import static co.com.banistmo.certification.contingencia.userinterfaces.InquiriesElements.GENERAL_INFO;
import static co.com.banistmo.certification.contingencia.userinterfaces.LoginElements.ERROR_MODAL;

import co.com.banistmo.certification.contingencia.userinterfaces.InquiriesElements;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class IncorrectLogin implements Question<String> {

    public static IncorrectLogin withMessage() {
        return new IncorrectLogin();
    }

    @Override
    public String answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(ERROR_MODAL, WebElementStateMatchers.isVisible())
        );
        return Text.of(ERROR_MODAL).viewedBy(actor).asString();
    }
}
