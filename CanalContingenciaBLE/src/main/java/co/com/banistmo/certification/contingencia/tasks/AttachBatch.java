package co.com.banistmo.certification.contingencia.tasks;


import static co.com.banistmo.certification.contingencia.utils.GeneralConstants.ATTACH_FILE;
import static co.com.banistmo.certification.contingencia.utils.GeneralConstants.FILE_PATH;
import static co.com.banistmo.certification.contingencia.utils.GeneralConstants.USER_DIRECTORY;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AttachBatch implements Task {

  public final WebDriver driver;
  private String path = System.getProperty(USER_DIRECTORY);
  private String fileName;

  public AttachBatch(String fileName) {
    this.fileName = fileName;
    driver = Serenity.getWebdriverManager().getCurrentDriver();
  }

  public static AttachBatch forTrasnfer(String fileName) {
    return instrumented(AttachBatch.class, fileName);
  }

  @Step("{0} Adjuntar archivos requeridos")
  @Override
  public <T extends Actor> void performAs(T actor) {
    path = path + FILE_PATH + fileName;
    WebElement element = driver.findElement(By.id(ATTACH_FILE));
    element.sendKeys(path);
  }
}