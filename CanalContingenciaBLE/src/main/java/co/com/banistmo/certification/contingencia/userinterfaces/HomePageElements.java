package co.com.banistmo.certification.contingencia.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class HomePageElements {

  public static final Target WELCOME_MSJ =
      Target.the("Welcome label ")
          .locatedBy("//app-welcome[@class='ng-star-inserted']/h2");
  public static final Target INQUIRIES_SECTION = Target.the("Transaction section")
      .locatedBy("//div[@ng-reflect-router-link='inquiries']/p");
  public static final Target TRANSACTION_SECTION = Target.the("Inquiries Section")
      .locatedBy("//div[@ng-reflect-router-link='transactions']/p");
  public static final Target LOADER = Target.the("Loader Circle")
      .locatedBy("//app-loader");

  private HomePageElements() {
  }
}
