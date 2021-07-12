package co.com.banistmo.certification.contingencia.interacions;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class SelectInTheList implements Interaction {

  private Target listOptions;
  private Target option;

  public SelectInTheList(Target listOptions, Target option) {
    this.listOptions = listOptions;
    this.option = option;
  }

  public static SelectInTheList withOption(Target listOptions, Target option) {
    return Tasks.instrumented(SelectInTheList.class, listOptions, option);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        WaitUntil.the(listOptions, isVisible()),
        Click.on(listOptions),
        WaitUntil.the(option, isVisible()),
        Click.on(option));
  }
}
