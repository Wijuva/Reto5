package modelo.dao;

import modelo.vo.Requerimiento_1;
import util.JDBCUtilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Requerimiento_1Dao {
    
    //DAO -> CRUD -> Create Read Update Delete

    //Consultar todos los líderes
    public ArrayList<Requerimiento_1> consultarNumeroLideres() throws SQLException {
        //Preparo contenedor de la respuesta
        ArrayList<Requerimiento_1> respuesta = new ArrayList<Requerimiento_1>();
        //Preparo contenero de la conexión
        Connection conexion = null;

        try{
            //Crear la conexión
            conexion = JDBCUtilities.getConnection();
            //Crear objeto a partir de la consulta SQL
            PreparedStatement statement = conexion.prepareStatement("SELECT DISTINCT COUNT (l.ID_Lider) AS Nro_Lideres , l.Ciudad_Residencia AS Ciudad_Residencia FROM Lider l GROUP BY l.Ciudad_Residencia;");

            //Ejecutar la consulta y almacenar la respuesta en estructura de datos
            //tipo ResultSet (iterador)
            ResultSet resultSet = statement.executeQuery();

            //Recorrer estilo iterador la estructura de datos que aloja los registros
            //Se detiene cuando siguiente retorna falso!
            while(resultSet.next()){
                Requerimiento_1 lider = new Requerimiento_1();
                lider.setNro_Lideres(resultSet.getInt("Nro_Lideres"));
                lider.setCiudad_Residencia(resultSet.getString("Ciudad_Residencia"));
                respuesta.add(lider);
            }

            resultSet.close();
            statement.close();

        }catch(SQLException e){
            System.err.println("Error consultando el numero de lideres por ciudad: " + e.getMessage());
        }finally{
            //Siempre debo cerrar la conexión con la base de datos si se logró
            if(conexion != null){
                conexion.close();
            }
        }

        //Retornar respuesta obtenida tras interactuar con la base de datos
        return respuesta;

    }

}
