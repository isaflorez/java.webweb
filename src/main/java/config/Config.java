package config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Config {

        private static final String URL = "jdbc:oracle:thin:@//10.0.0.3:1521/XEPDB1";
        private static final String USER = "user1";
        private static final String PASS = "Clave123";
        private Connection cnn = null;
        public Connection conectar(){
            try {
                cnn = (Connection) DriverManager.getConnection(
                        Config.URL, Config.USER, Config.PASS
                );
            } catch (SQLException e) {
                System.err.println(e);
            }
            return cnn;
        }
    
}