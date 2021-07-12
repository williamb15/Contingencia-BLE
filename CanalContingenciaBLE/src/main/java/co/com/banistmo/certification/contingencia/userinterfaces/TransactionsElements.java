package co.com.banistmo.certification.contingencia.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class TransactionsElements {

  public static final Target ORIGIN_ACCOUNT = Target.the("Select Origin Account")
      .locatedBy("//mat-select[@formcontrolname='OriginAccount']");
  public static final Target OPTION_ORIGIN_ACCOUNT = Target.the("Option Origin Account")
      .locatedBy("//mat-option//small[contains (text (),'{0}')]");
  public static final Target TRANSACTION_TYPE = Target.the("Transaction Type")
      .locatedBy("//mat-select[@formcontrolname='transactionType']");
  public static final Target OPTION_TRANSACTION_TYPE = Target.the("Option Transaction Type")
      .locatedBy("//mat-option//span[contains (text (),'{0}')]");
  public static final Target DELIMITER_TYPE = Target.the("Delimiter select")
      .locatedBy("//mat-select[@formcontrolname='separator']");
  public static final Target DELIMITER_OPTION = Target.the("Delimiter Option")
      .locatedBy("//mat-option//span[contains(text(),'{0}')]");
  public static final Target VALIDATOR_BUTTON = Target.the("Button to validated batch file")
      .locatedBy("//button[@class='btn-white']");
  public static final Target ESTATE_BATCH = Target.the("Label with batch status")
      .locatedBy("((//div[@class='secciones'])[1]//div)[2]//span");
  public static final Target BTN_CONTINUE = Target.the("Btn continue to execute")
      .locatedBy("//button[contains(text(),'CONTINUAR')]");
  public static final Target BTN_EXECUTE_BATCH = Target.the("Btn to execute batch")
      .locatedBy("//button[contains(text(),'EJECUTAR LOTE')]");
  public static final Target BUTTON_ACCEPT = Target.the("Button accept sent to process successfully")
      .locatedBy("//button[contains(text(),'Aceptar')]");
  public static final Target MESSAGE_SATISFACTORY_DELIVERY = Target.the("Successful send message to process")
      .locatedBy("//div[@class='success-container']/p");
  public static final Target PROOF_NUMBER = Target.the("Proof number")
      .locatedBy("//div[@class='comprobante']/h5");

  private TransactionsElements() {
  }
}
