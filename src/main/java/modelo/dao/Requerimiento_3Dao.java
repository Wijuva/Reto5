package modelo.dao;

import modelo.vo.Requerimiento_3;
import util.JDBCUtilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Requerimiento_3Dao {
    
    //DAO -> CRUD -> Create Read Update Delete

    //Consultar todos los líderes
    public ArrayList<Requerimiento_3> lideresMaterialNoPago() throws SQLException {
        //Preparo contenedor de la respuesta
        ArrayList<Requerimiento_3> respuesta = new ArrayList<Requerimiento_3>();
        //Preparo contenero de la conexión
        Connection conexion = null;

        try{
            //Crear la conexión
            conexion = JDBCUtilities.getConnection();
            //Crear objeto a partir de la consulta SQL
            String mensaje = "SELECT DISTINCT l.ID_Lider, l.Nombre, l.Primer_Apellido, l.Segundo_Apellido FROM Lider l INNER JOIN Proyecto p ON p.ID_Lider = l.ID_Lider;";
            PreparedStatement statement = conexion.prepareStatement(mensaje);

            //Ejecutar la consulta y almacenar la respuesta en estructura de datos
            //tipo ResultSet (iterador)
            ResultSet resultSet = statement.executeQuery();

            //Recorrer estilo iterador la estructura de datos que aloja los registros
            //Se detiene cuando siguiente retorna falso!
            while(resultSet.next()){
                Requerimiento_3 Lider = new Requerimiento_3();
                Lider.setID_Lider(resultSet.getInt("ID_Lider"));
                Lider.setNombre(resultSet.getString("Nombre"));
                Lider.setPrimer_Apellido(resultSet.getString("Primer_Apellido"));
                Lider.setSegundo_Apellido(resultSet.getString("Segundo_Apellido"));
                respuesta.add(Lider);
            }

            resultSet.close();
            statement.close();

        }catch(SQLException e){
            System.err.println("Error consultando los materiales sin pagar: " + e.getMessage());
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
