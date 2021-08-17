package vista;

import java.util.ArrayList;
import java.sql.SQLException;
import java.util.IllegalFormatConversionException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import controlador.Controlador;
import modelo.vo.Requerimiento_2;

public class VistaRequerimiento2 extends JFrame {

    // Atributos
    private JTable jtTableR2;
    private String[][] mensajeR2;

    private static final Controlador controlador = new Controlador();

    public VistaRequerimiento2() {

    }

    public void requerimiento2(){

        try {
            ArrayList<Requerimiento_2> compras = controlador.requerimiento2();
            int sizeCompras = compras.size();
            this.formatoRequerimiento2(compras, sizeCompras);

            // Titulo del requerimiento 2
            setTitle("Requerimiento 2");
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            String[] encabezado = {"ID_Proyecto", "Proveedor", "Pagado", "ID_MaterialConstruccion", "Nombre_Material"};

            jtTableR2 = new JTable(this.mensajeR2, encabezado);
            jtTableR2.setShowGrid(false);
            jtTableR2.setSize(800, 500);

            DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
            Alinear.setHorizontalAlignment(SwingConstants.CENTER);
            for (int i = 0; i < 5; i++) {
                jtTableR2.getColumnModel().getColumn(i).setCellRenderer(Alinear);
            }

            JScrollPane sp = new JScrollPane(jtTableR2);
            sp.setSize(800, 500);

            getContentPane().add(sp);

            setSize(800,500);
            setLocationRelativeTo(null);
            setVisible(true);

            // Diferenciando el error que puede suceder en este contexto
        } catch (SQLException e) {
            System.err.println("Error consultando todos los líderes!! " + e.getMessage());
        } catch (IllegalFormatConversionException f) {
            System.err.println("Error con los tipos del formato de impresión!! " + f.getMessage());
        }
    }

    public void formatoRequerimiento2(ArrayList<Requerimiento_2> compras,Integer sizeCompras) {
        
        // Inicializo contenedor de la tabla final
        this.mensajeR2 = new String[sizeCompras][5];
        // Desempaquetar informacion de los compras por ciudad

        for (int i = 0; i < sizeCompras; i++) {
            this.mensajeR2[i][0] = String.valueOf(compras.get(i).getID_Proyecto());
            this.mensajeR2[i][1] = compras.get(i).getProveedor();
            this.mensajeR2[i][2] = compras.get(i).getPagado();
            this.mensajeR2[i][3] = String.valueOf(compras.get(i).getID_MaterialConstruccion());
            this.mensajeR2[i][4] = compras.get(i).getNombre_Material();
        }
    }

}
