package util;

//Paquete para archivos
import java.io.File;

//Paquetes para asistir la interacción con la base de datos
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCUtilities {

    //Ubicación de la base de datos
    private static final String UBICACION_BD = "G:/My Drive/Mintic 2021/Curso 2/Programacion/Semana 5/Reto 5/reto5/ProyectosConstruccion.db";    

    //Construir conexión con la base de datos
    public static Connection getConnection() throws SQLException {        
        String url = "jdbc:sqlite:" + JDBCUtilities.UBICACION_BD;
        return DriverManager.getConnection(url);
    }

    //Función para validar si estamos en una base de datos vacía -> SQLite
    public static boolean estaVacia(){
        File archivo = new File(JDBCUtilities.UBICACION_BD);

        //Salida de diagnóstico
        // System.out.println("Líneas identificadas: " + archivo.length());

        return archivo.length() == 0;
    }
    
}
