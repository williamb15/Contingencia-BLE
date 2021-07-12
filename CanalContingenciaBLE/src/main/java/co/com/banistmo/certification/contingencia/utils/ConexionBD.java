package co.com.banistmo.certification.contingencia.utils;

import static co.com.banistmo.certification.contingencia.utils.DataBaseConstants.DB_HOST_NAME;
import static co.com.banistmo.certification.contingencia.utils.DataBaseConstants.DB_PASS;
import static co.com.banistmo.certification.contingencia.utils.DataBaseConstants.DB_PROPERTIES;
import static co.com.banistmo.certification.contingencia.utils.DataBaseConstants.DB_USER;
import static co.com.banistmo.certification.contingencia.utils.DataBaseConstants.DRIVER;
import static co.com.banistmo.certification.contingencia.utils.DataBaseConstants.ERROR_DB;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.logging.Logger;

public class ConexionBD {

  private static final Logger LOGGER = Logger.getLogger(ConexionBD.class.getName());
  private Connection con;

  public Connection conetionManager() {
    try {
      Properties prop = new Properties();
      prop.load(new FileReader(DB_PROPERTIES));
      String user = prop.getProperty(DB_USER);
      String password = prop.getProperty(DB_PASS);
      String nameHost = prop.getProperty(DB_HOST_NAME);
      Class.forName(prop.getProperty(DRIVER));
      con = DriverManager.getConnection(nameHost, user, password);

    } catch (Exception e) {
      LOGGER.info(ERROR_DB + e);
    }
    return con;
  }
}