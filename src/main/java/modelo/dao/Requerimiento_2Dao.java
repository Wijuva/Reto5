package modelo.dao;

import modelo.vo.Requerimiento_2;
import util.JDBCUtilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Requerimiento_2Dao {
    
    //DAO -> CRUD -> Create Read Update Delete

    //Consultar todos los líderes
    public ArrayList<Requerimiento_2> materialNoPagado() throws SQLException {
        //Preparo contenedor de la respuesta
        ArrayList<Requerimiento_2> respuesta = new ArrayList<Requerimiento_2>();
        //Preparo contenero de la conexión
        Connection conexion = null;

        try{
            //Crear la conexión
            conexion = JDBCUtilities.getConnection();
            //Crear objeto a partir de la consulta SQL
            String mensaje = "SELECT c.ID_Proyecto, c.Proveedor, c.Pagado, c.ID_MaterialConstruccion, mc.Nombre_Material FROM Compra c INNER JOIN MaterialConstruccion mc ON c.ID_MaterialConstruccion = mc.ID_MaterialConstruccion WHERE c.Proveedor = " + "\"Homecenter\"" + " AND c.Pagado = " + "\"No\"" + " ORDER BY c.ID_Proyecto;";
            PreparedStatement statement = conexion.prepareStatement(mensaje);

            //Ejecutar la consulta y almacenar la respuesta en estructura de datos
            //tipo ResultSet (iterador)
            ResultSet resultSet = statement.executeQuery();

            //Recorrer estilo iterador la estructura de datos que aloja los registros
            //Se detiene cuando siguiente retorna falso!
            while(resultSet.next()){
                Requerimiento_2 Compra = new Requerimiento_2();
                Compra.setID_Proyecto(resultSet.getInt("ID_Proyecto"));
                Compra.setProveedor(resultSet.getString("Proveedor"));
                Compra.setPagado(resultSet.getString("Pagado"));
                Compra.setID_MaterialConstruccion(resultSet.getInt("ID_MaterialConstruccion"));
                Compra.setNombre_Material(resultSet.getString("Nombre_Material"));
                respuesta.add(Compra);
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
