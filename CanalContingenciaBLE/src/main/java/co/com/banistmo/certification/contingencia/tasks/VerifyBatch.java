package co.com.banistmo.certification.contingencia.tasks;

import static co.com.banistmo.certification.contingencia.userinterfaces.HomePageElements.TRANSACTION_SECTION;
import static co.com.banistmo.certification.contingencia.userinterfaces.TransactionsElements.DELIMITER_OPTION;
import static co.com.banistmo.certification.contingencia.userinterfaces.TransactionsElements.DELIMITER_TYPE;
import static co.com.banistmo.certification.contingencia.userinterfaces.TransactionsElements.OPTION_ORIGIN_ACCOUNT;
import static co.com.banistmo.certification.contingencia.userinterfaces.TransactionsElements.OPTION_TRANSACTION_TYPE;
import static co.com.banistmo.certification.contingencia.userinterfaces.TransactionsElements.ORIGIN_ACCOUNT;
import static co.com.banistmo.certification.contingencia.userinterfaces.TransactionsElements.TRANSACTION_TYPE;
import static co.com.banistmo.certification.contingencia.userinterfaces.TransactionsElements.VALIDATOR_BUTTON;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import co.com.banistmo.certification.contingencia.interacions.SelectInTheList;
import co.com.banistmo.certification.contingencia.models.User;
import java.util.List;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class VerifyBatch implements Task {

  private User data;

  public VerifyBatch(List<User> dataList) {
    this.data = dataList.get(0);
  }

  public static VerifyBatch withFile(List<User> data) {
    return Tasks.instrumented(VerifyBatch.class, data);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        WaitUntil.the(TRANSACTION_SECTION, isVisible()),
        Click.on(TRANSACTION_SECTION),
        SelectInTheList.withOption(ORIGIN_ACCOUNT,
            OPTION_ORIGIN_ACCOUNT.of(data.getOriginAccount())),
        SelectInTheList.withOption(TRANSACTION_TYPE,
            OPTION_TRANSACTION_TYPE.of(data.getTransaction())),
        AttachBatch.forTrasnfer(data.getFileName()),
        Check.whether(data.getExtension().equals("TXT"))
            .andIfSo(
                SelectInTheList.withOption(DELIMITER_TYPE,
                    DELIMITER_OPTION.of(data.getDelimiter()))
            ),
        Click.on(VALIDATOR_BUTTON)
    );
  }
}
