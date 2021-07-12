package co.com.banistmo.certification.contingencia.utils;

public class GeneralConstants {

  public static final String CHROME = "chrome";
  public static final String FIREFOX = "firefox";
  public static final String CERTIFICATION_URL = "http://web-app-route-qa-stage.apps.ocptdev.bancolombia.corp/";
  public static final String DEVELOPMENT_URL = "http://web-app-route-dev-stage.apps.ocptdev.bancolombia.corp/";
  public static final String USER = "User";
  public static final String FILE_PATH = "/src/test/resources/files/";
  public static final String USER_DIRECTORY = "user.dir";
  public static final String ATTACH_FILE = "subir";
  public static final String QUERY_SQL = "SELECT vc.fragment_part1 AS SMS, vc.fragment_part2 AS EMAIL FROM SCHCTG.ctg_verification_context VC WHERE USERNAME = 'USUARIOPRUEBA1'";
  public static final String FILE_SEND_TO_PROCESS = "Su archivo de pago ha sido enviado a procesar";
  public static final String FILE_PROCESSED_SUCCESSFULLY = "El lote se ha ejecutado exitosamente y ha pasado al proceso de aprobación";
  public static final String GENERIC_CODE = "12345";
  public static final String MSJ_TOKEN_ERROR = "Token incorrecto. Verifique la información.";
  public static final String MSJ_TOKEN_ERROR_ATTEMPTS = "Se ha cerrado la sesión por exceder el máximo de intentos permitidos en el ingreso del token.";
  public static final String LABEL_GENERAL_INFO = "Información general";

  private GeneralConstants() {
  }
}

