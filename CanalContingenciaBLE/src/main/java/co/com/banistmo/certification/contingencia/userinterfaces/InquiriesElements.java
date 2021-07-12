package co.com.banistmo.certification.contingencia.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class InquiriesElements {

  public static final Target QUERY_VOUCHER_ID = Target.the("Input Query by Voucher Id")
      .locatedBy("//input[@ng-reflect-name='voucherId']");
  public static final Target SEARCH_TYPE_TRANSACTION = Target.the("Search by type of transaction")
      .locatedBy("//mat-select[@formcontrolname='batchTypeId']");
  public static final Target OPTION_TYPE_TRANSACTION = Target.the("Inquiries Section")
      .locatedBy("//mat-option//span[contains (text(),'Planilla')]");
  public static final Target TABLE_QUERY = Target.the("Inquiries Section table")
      .locatedBy("//tbody");
  public static final Target GENERAL_INFO = Target.the("Modal with general info of transaction")
      .locatedBy("//h3[@class='info-general-title']");
}