package co.com.banistmo.certification.contingencia.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class LoginElements {

  public static final Target USER_INPUT = Target.the("UserName input")
      .locatedBy("//input[@ng-reflect-name='user']");
  public static final Target PASSWORD_INPUT = Target.the("Password input")
      .locatedBy("//input[@ng-reflect-name='password']");
  public static final Target CONTINUE_BTN = Target.the("Continue button")
      .locatedBy("//button/span[text()='CONTINUAR']");
  public static final Target ERROR_MODAL = Target.the("Warning Modal")
      .locatedBy("//div[@id='swal2-content']");
  public static final Target ALERT_SESION = Target.the("Alert active sesion")
      .locatedBy("//button[contains(text(),'Continuar')]");

  private LoginElements() {
  }
}
