package co.com.banistmo.certification.contingencia.integrations;

import static co.com.banistmo.certification.contingencia.utils.DataBaseConstants.EMAIL;
import static co.com.banistmo.certification.contingencia.utils.DataBaseConstants.SMS;

import co.com.banistmo.certification.contingencia.utils.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public class ConsultarBDCtg {

  private static final Logger LOGGER = Logger.getLogger(ConsultarBDCtg.class);
  private String result = null;

  public String consultarIdclienteIdProducto(String queryConsulta) {
    ResultSet resultSet = null;
    try {
      ConexionBD conexionCTG = new ConexionBD();
      try (Connection conexion = conexionCTG.conetionManager();
          PreparedStatement consulta = conexion.prepareStatement(queryConsulta)) {
        resultSet = consulta.executeQuery();
        while (resultSet.next()) {
          result = resultSet.getNString(SMS) + "-" + resultSet
              .getNString(EMAIL);
        }
      } finally {
        if (resultSet != null) {
          resultSet.close();
        }
      }
    } catch (SQLException e) {
      LOGGER.info(e);
    }
    return result;
  }
}
