package co.com.banistmo.certification.contingencia.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class DoubleFactorElements {

  public static final Target INPUT_EMAIL = Target.the("Label with batch status")
      .locatedBy("//input[@ng-reflect-name='code_correo']");
  public static final Target INPUT_SMS = Target.the("Label with batch status")
      .locatedBy("//input[@ng-reflect-name='code_sms']");
  public static final Target BTN_CONTINUE_TO_PROCESS = Target
      .the("Button continue to processing Batch")
      .locatedBy("//app-modal-double-factor//span[contains(text(),'CONTINUAR')]");
  public static final Target MSJ_FILE_PROCESSED_SUCCESFUL = Target
      .the("Batch message sent to process successfully")
      .locatedBy("//div[@id='swal2-content']");
  public static final Target LABEL_ERROR_TOKEN = Target
      .the("Label with message error by token")
      .locatedBy("//mat-error");
  public static final Target LABEL_ERROR_TOKEN_ATTEPMTS = Target
      .the("Label with message error by token")
      .locatedBy("//div[@id='swal2-content']");

  private DoubleFactorElements() {
  }
}
