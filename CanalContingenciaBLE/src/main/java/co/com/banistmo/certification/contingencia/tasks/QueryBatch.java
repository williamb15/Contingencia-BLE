package co.com.banistmo.certification.contingencia.tasks;

import static co.com.banistmo.certification.contingencia.userinterfaces.HomePageElements.INQUIRIES_SECTION;
import static co.com.banistmo.certification.contingencia.userinterfaces.HomePageElements.LOADER;
import static co.com.banistmo.certification.contingencia.userinterfaces.InquiriesElements.QUERY_VOUCHER_ID;
import static co.com.banistmo.certification.contingencia.userinterfaces.InquiriesElements.TABLE_QUERY;
import static co.com.banistmo.certification.contingencia.userinterfaces.TransactionsElements.PROOF_NUMBER;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import co.com.banistmo.certification.contingencia.interacions.SelectInTable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class QueryBatch implements Task {

  public static QueryBatch withNumber() {
    return Tasks.instrumented(QueryBatch.class);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    String vaucherId = Text.of(PROOF_NUMBER).viewedBy(actor).asString();
    System.out.println("VOUCHERid: " + vaucherId);
    actor.attemptsTo(
        WaitUntil.the(INQUIRIES_SECTION, isVisible()),
        Click.on(INQUIRIES_SECTION),
        WaitUntil.the(LOADER, isVisible()),
        WaitUntil.the(LOADER, isNotVisible()),
        Click.on(QUERY_VOUCHER_ID),
        Enter.theValue(vaucherId.substring(1)).into(QUERY_VOUCHER_ID),
        SelectInTable.aBatchProcessed(TABLE_QUERY, vaucherId)
    );
  }
}