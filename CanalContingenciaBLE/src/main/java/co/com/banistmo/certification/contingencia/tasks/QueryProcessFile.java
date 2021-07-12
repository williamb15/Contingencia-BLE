package co.com.banistmo.certification.contingencia.tasks;

import static co.com.banistmo.certification.contingencia.userinterfaces.HomePageElements.INQUIRIES_SECTION;
import static co.com.banistmo.certification.contingencia.userinterfaces.HomePageElements.LOADER;
import static co.com.banistmo.certification.contingencia.userinterfaces.InquiriesElements.OPTION_TYPE_TRANSACTION;
import static co.com.banistmo.certification.contingencia.userinterfaces.InquiriesElements.QUERY_VOUCHER_ID;
import static co.com.banistmo.certification.contingencia.userinterfaces.InquiriesElements.SEARCH_TYPE_TRANSACTION;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import co.com.banistmo.certification.contingencia.interacions.SelectInTable;
import co.com.banistmo.certification.contingencia.interacions.SelectInTheList;
import co.com.banistmo.certification.contingencia.userinterfaces.InquiriesElements;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class QueryProcessFile implements Task {

  public static QueryProcessFile byTransaction() {
    return Tasks.instrumented(QueryProcessFile.class);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        WaitUntil.the(LOADER, isVisible()),
        WaitUntil.the(LOADER, isNotVisible()),
        WaitUntil.the(QUERY_VOUCHER_ID, isClickable()),
        Click.on(INQUIRIES_SECTION),
        SelectInTheList.withOption(SEARCH_TYPE_TRANSACTION,
            OPTION_TYPE_TRANSACTION),
        SelectInTable.aBatchProcessed(InquiriesElements.TABLE_QUERY, "C0082")
    );
  }

}
