package co.com.banistmo.certification.contingencia.tasks;

import static co.com.banistmo.certification.contingencia.userinterfaces.LoginElements.ALERT_SESION;
import static co.com.banistmo.certification.contingencia.userinterfaces.LoginElements.CONTINUE_BTN;
import static co.com.banistmo.certification.contingencia.userinterfaces.LoginElements.PASSWORD_INPUT;
import static co.com.banistmo.certification.contingencia.userinterfaces.LoginElements.USER_INPUT;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import co.com.banistmo.certification.contingencia.models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class Login implements Task {

    private User credentials;

    public Login(User credentials) {
        this.credentials = credentials;
    }


    public static Login inTheWeb(User credentials) {
        return instrumented(Login.class, credentials);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.remember("userName", credentials.getUserName());
        actor.attemptsTo(WaitUntil.the(USER_INPUT, isVisible()),
                Enter.theValue(credentials.getUserName()).into(USER_INPUT),
                Enter.theValue(credentials.getPassword()).into(PASSWORD_INPUT),
                Click.on(CONTINUE_BTN));
        if (ALERT_SESION.resolveFor(actor).isVisible()) {
            actor.attemptsTo(Click.on(ALERT_SESION));
        }
    }
}
