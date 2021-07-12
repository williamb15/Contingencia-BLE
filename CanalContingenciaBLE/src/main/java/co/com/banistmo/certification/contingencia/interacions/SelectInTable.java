package co.com.banistmo.certification.contingencia.interacions;

import java.util.List;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SelectInTable implements Interaction {

  private Target tabla;
  private String opcion;

  public SelectInTable(Target tabla, String opcion) {
    this.tabla = tabla;
    this.opcion = opcion;
  }

  public static SelectInTable aBatchProcessed(Target tabla, String opcion) {
    return new SelectInTable(tabla, opcion);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    List<WebElement> rows = tabla.resolveFor(actor).findElements(By.tagName("tr"));
    for (int i = 0; i < rows.size(); i++) {
      List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
      if (columns.get(0).getText().contains(opcion)) {
        columns.get(5).click();
        break;
      }
    }
  }
}
