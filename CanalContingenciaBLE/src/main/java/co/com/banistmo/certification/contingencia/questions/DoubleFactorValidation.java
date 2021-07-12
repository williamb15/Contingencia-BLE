package co.com.banistmo.certification.contingencia.questions;

import static co.com.banistmo.certification.contingencia.userinterfaces.LoginElements.ERROR_MODAL;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class DoubleFactorValidation implements Question<String> {

  private Target target;

  public DoubleFactorValidation(Target target) {
    this.target = target;
  }

  public static DoubleFactorValidation withMessage(Target target) {
    return new DoubleFactorValidation(target);
  }

  @Override
  public String answeredBy(Actor actor) {
    actor.attemptsTo(
        WaitUntil.the(target, WebElementStateMatchers.isVisible())
    );
    return Text.of(target).viewedBy(actor).asString();
  }
}
