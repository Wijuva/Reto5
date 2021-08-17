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
import modelo.vo.Requerimiento_3;

public class VistaRequerimiento3 extends JFrame {

    // Atributos
    private JTable jtTableR3;
    private String[][] mensajeR3;

    private static final Controlador controlador = new Controlador();

    public VistaRequerimiento3() {

    }

    public void requerimiento3(){

        try {
            ArrayList<Requerimiento_3> compras = controlador.requerimiento3();
            int sizeCompras = compras.size();
            this.formatoRequerimiento3(compras, sizeCompras);

            // Titulo del requerimiento 3
            setTitle("Requerimiento 3");
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            String[] encabezado = {"ID_Lider", "Nombre", "Primer_Apellido", "Segundo_Apellido"};

            jtTableR3 = new JTable(this.mensajeR3, encabezado);
            jtTableR3.setShowGrid(false);

            DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
            Alinear.setHorizontalAlignment(SwingConstants.CENTER);
            for (int i = 0; i < 4; i++) {
                jtTableR3.getColumnModel().getColumn(i).setCellRenderer(Alinear);
            }

            JScrollPane sp = new JScrollPane(jtTableR3);

            getContentPane().add(sp);

            setSize(500,500);
            setLocationRelativeTo(null);
            setVisible(true);

            // Diferenciando el error que puede suceder en este contexto
        } catch (SQLException e) {
            System.err.println("Error consultando todos los líderes!! " + e.getMessage());
        } catch (IllegalFormatConversionException f) {
            System.err.println("Error con los tipos del formato de impresión!! " + f.getMessage());
        }
    }

    public void formatoRequerimiento3(ArrayList<Requerimiento_3> compras,Integer sizeCompras) {
        
        // Inicializo contenedor de la tabla final
        this.mensajeR3 = new String[sizeCompras][4];
        // Desempaquetar informacion de los compras por ciudad

        for (int i = 0; i < sizeCompras; i++) {
            this.mensajeR3[i][0] = String.valueOf(compras.get(i).getID_Lider());
            this.mensajeR3[i][1] = compras.get(i).getNombre();
            this.mensajeR3[i][2] = compras.get(i).getPrimer_Apellido();
            this.mensajeR3[i][3] = compras.get(i).getSegundo_Apellido();
        }
    }
}
