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
import modelo.vo.Requerimiento_1;

public class VistaRequerimiento1 extends JFrame {

    // Atributos
    private JTable jtTableR1;
    private String[][] mensajeR1;

    private static final Controlador controlador = new Controlador();

    public VistaRequerimiento1() {

    }

    public void requerimiento1() {

        try {
            ArrayList<Requerimiento_1> lideres = controlador.requerimiento1();
            int sizeLideres = lideres.size();
            this.formatoRequerimiento1(lideres, sizeLideres);

            // Titulo del requerimiento 1
            setTitle("Requerimiento 1");
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            String[] encabezado = {"Nro_Lideres","Ciudad_Residencia"};

            jtTableR1 = new JTable(this.mensajeR1, encabezado);
            jtTableR1.setShowGrid(false);

            DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
            Alinear.setHorizontalAlignment(SwingConstants.CENTER);
            jtTableR1.getColumnModel().getColumn(0).setCellRenderer(Alinear);
            jtTableR1.getColumnModel().getColumn(1).setCellRenderer(Alinear);

            JScrollPane sp = new JScrollPane(jtTableR1);

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

    public void formatoRequerimiento1(ArrayList<Requerimiento_1> lideres,Integer sizeLideres) {
        
        // Inicializo contenedor de la tabla final
        this.mensajeR1 = new String[sizeLideres][2];
        // Desempaquetar informacion de los lideres por ciudad

        for (int i = 0; i < sizeLideres; i++) {
            this.mensajeR1[i][0] = String.valueOf(lideres.get(i).getNro_Lideres());
            this.mensajeR1[i][1] = lideres.get(i).getCiudad_Residencia();
        }
    }

}
