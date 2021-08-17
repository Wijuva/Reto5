package vista;

// import java.util.Scanner;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.IllegalFormatConversionException;
import modelo.dao.*;
import modelo.vo.*;

// Librerias para la GUI
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlador.Controlador;

public class VistaGUI extends JFrame {
    
    //Controlador
    private static final Controlador controlador = new Controlador();

    // Atributos para la GUI
    private JButton btnRequerimiento1;
    private JButton btnRequerimiento2;
    private JButton btnRequerimiento3;

    // Metodo que genera la ventana 
    // Alternativas  ->  Constructor
    //               ->  Metodo

    public void iniciarGUI() {
        // Titulo
        super.setTitle("Menu inicial reto 5");
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Nombre y correo
        JLabel labelNombre = new JLabel();
        labelNombre.setText("Realizado por: Wilson Jurado Valbuena");
        JLabel labelCorreo = new JLabel();
        labelCorreo.setText("wjuradov@correo.udistrital.edu.co");


        // Crear componentes
        btnRequerimiento1 = new JButton("Lideres por ciudad");
        btnRequerimiento1.addActionListener(controlador);
        btnRequerimiento1.setActionCommand("Lideres por ciudad");

        btnRequerimiento2 = new JButton("Material no pagado");
        btnRequerimiento2.addActionListener(controlador);
        btnRequerimiento2.setActionCommand("Material no pagado");

        btnRequerimiento3 = new JButton("Lideres con material no pago");
        btnRequerimiento3.addActionListener(controlador);
        btnRequerimiento3.setActionCommand("Lideres con material no pago");

        // Añadir los componentes del contenedor o contenedores intermedios
        JPanel panel = new JPanel();
        panel.add(labelNombre);
        panel.add(labelCorreo);
        panel.add(btnRequerimiento1);
        panel.add(btnRequerimiento2);
        panel.add(btnRequerimiento3);

        // Añadir panel al JFrame
        super.getContentPane().add(panel);

        // Establecer ultimas propiedades del frame
        super.setSize(550,100);
        super.setLocationRelativeTo(null);
        super.setVisible(true);

    }
}
