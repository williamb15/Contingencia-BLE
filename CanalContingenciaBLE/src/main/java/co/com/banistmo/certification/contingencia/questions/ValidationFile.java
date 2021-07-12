package co.com.banistmo.certification.contingencia.questions;

import static co.com.banistmo.certification.contingencia.userinterfaces.TransactionsElements.ESTATE_BATCH;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class ValidationFile implements Question<String> {

  public static ValidationFile withMessage() {
    return new ValidationFile();
  }

  @Override
  public String answeredBy(Actor actor) {
    actor.attemptsTo(
        WaitUntil.the(ESTATE_BATCH, WebElementStateMatchers.isVisible()),
        Scroll.to(ESTATE_BATCH).andAlignToTop()
    );
    String msj = Text.of(ESTATE_BATCH).viewedBy(actor).asString();
    System.out.println("Mensaje: " + msj);
    return msj;
  }
}
