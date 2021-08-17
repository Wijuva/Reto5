package controlador;

import modelo.dao.*;
import modelo.vo.*;
import vista.*;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;

// manejo de botones
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {
    
    private final Requerimiento_1Dao requerimeinto1;
    private final Requerimiento_2Dao requerimeinto2;
    private final Requerimiento_3Dao requerimeinto3;
    private final VistaGUI vistaGUI;
    private final VistaRequerimiento1 vistaR1;
    private final VistaRequerimiento2 vistaR2;
    private final VistaRequerimiento3 vistaR3;

    public Controlador(){
        this.requerimeinto1 = new Requerimiento_1Dao();
        this.requerimeinto2 = new Requerimiento_2Dao();
        this.requerimeinto3 = new Requerimiento_3Dao();
        this.vistaGUI = new VistaGUI();
        this.vistaR1 = new VistaRequerimiento1();
        this.vistaR2 = new VistaRequerimiento2();
        this.vistaR3 = new VistaRequerimiento3();
    }

    public ArrayList<Requerimiento_1> requerimiento1() throws SQLException {
        return this.requerimeinto1.consultarNumeroLideres();
    }
    
    public ArrayList<Requerimiento_2> requerimiento2() throws SQLException {
        return this.requerimeinto2.materialNoPagado();
    }

    public ArrayList<Requerimiento_3> requerimiento3() throws SQLException {
        return this.requerimeinto3.lideresMaterialNoPago();
    }
    
    public void inicio(){
        this.vistaGUI.iniciarGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String actionComand = ((JButton)e.getSource()).getActionCommand();
        
        //Caminos segun el evento ocurrido
        switch (actionComand){
            case "Lideres por ciudad":
                System.out.println("Lideres por ciudad");
                this.vistaR1.requerimiento1();
            break;
            case "Material no pagado":
                System.out.println("Material no pagado");
                this.vistaR2.requerimiento2();
            break;
            case "Lideres con material no pago":
                System.out.println("Lideres con material no pago");
                this.vistaR3.requerimiento3();
            break;
        }
        
    }

}
