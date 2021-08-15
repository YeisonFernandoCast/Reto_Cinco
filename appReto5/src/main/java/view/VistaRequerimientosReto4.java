package view;

import controller.ControladorRequerimientosReto4;

import model.vo.CompraPorProveedor;
import model.vo.ProyectosCasaCampestre;
import model.vo.AsesorPorCiudad;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;



public class VistaRequerimientosReto4 extends JFrame{
    
    public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();
    
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextArea textArea;

    public VistaRequerimientosReto4(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 200, 900, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(7,7,7,7));
        contentPane.setBackground(new Color(72, 209, 204));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lbltitulo = new JLabel(" Reto 5 Grupo 70 ");
        lbltitulo.setBounds(395, 6, 100, 20);
        contentPane.add(lbltitulo);

        JLabel lbltripulante = new JLabel(" Tripulante: ");
        lbltripulante.setBounds(410, 25, 80, 20);
        contentPane.add(lbltripulante);

        JLabel lblautor = new JLabel("Yeison Fernando Castaño Ubillús");
        lblautor.setBounds(350, 45, 200, 20);
        contentPane.add(lblautor);

        JLabel lblconstru = new JLabel("Constructora ESTRUCTURANDO");
        lblconstru.setBounds(330, 615, 230, 29);
        contentPane.add(lblconstru);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(140, 70, 690, 550);
        contentPane.add(scrollPane);

        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);

        JButton btnConsuta1 = new JButton("CONSULTA  1");
        btnConsuta1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                requerimiento1();
            }
        });
        btnConsuta1.setBounds(12, 100, 120, 27);
        btnConsuta1.setBackground(new Color(190, 206, 235));
        contentPane.add(btnConsuta1);
      

        JButton btnConsuta2 = new JButton("CONSULTA  2");
        btnConsuta2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                requerimiento2();
            }
        });
        btnConsuta2.setBounds(12, 150, 120, 27);
        btnConsuta2.setBackground(new Color(190, 206, 235));
        contentPane.add(btnConsuta2);

        JButton btnConsuta3 = new JButton("CONSULTA  3");
        btnConsuta3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                requerimiento3();
            }
        });
        btnConsuta3.setBounds(12, 200, 122, 27);
        btnConsuta3.setBackground(new Color(190, 206, 235));
        contentPane.add(btnConsuta3);

        JButton btnLimpiar = new JButton("LIMPIAR");
        btnLimpiar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });
        btnLimpiar.setBounds(12, 250, 122, 27);
        btnLimpiar.setBackground(new Color(190, 200, 230));
        contentPane.add(btnLimpiar);

    }



    public void requerimiento1(){
        try{
            ArrayList<AsesorPorCiudad> rankingAsesorPorCiudad = controlador.consultarAsesorPorCiudad();
            String salida = "  *** Asesor por Ciudad *** \n\nID_Lider\tNombre\tPrimer_Apellido\t\tResidencia\n\n ";
            for (AsesorPorCiudad asesorPorCiudad : rankingAsesorPorCiudad){
                salida += asesorPorCiudad.getIdLider();
                salida += "\t";
                salida += asesorPorCiudad.getNombre();
                salida += "\t";
                salida += asesorPorCiudad.getPrimerApellido();
                salida += "\t\t";
                salida += asesorPorCiudad.getCiudadResidencia();
                salida += "\n";
            }
            textArea.setText(salida);

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }
    }

    public void requerimiento2(){
        try{
            ArrayList<ProyectosCasaCampestre> rankingProyectosCasaCampestre = controlador.consultarProyectosCasaCampestre();
            String salida = "  *** Proyectos Casa Campestre *** \n\nID_Proyecto\tConstructora\t\tHabitaciones\t\tCiudad\n\n";
            for (ProyectosCasaCampestre proyectosCasaCampestre : rankingProyectosCasaCampestre){
                salida += proyectosCasaCampestre.getID_Proyecto();
                salida += "\t";
                salida += proyectosCasaCampestre.getConstructora();
                if(proyectosCasaCampestre.getConstructora().length() <= 11 || proyectosCasaCampestre.getConstructora().equals("Ingenieros Ltda.")){
                    salida += "\t\t";
                } else {
                    salida += "\t";
                }
                salida += proyectosCasaCampestre.getNumero_Habitaciones();
                salida += "\t\t";
                salida += proyectosCasaCampestre.getCiudad();
                salida += "\n";
            }
            textArea.setText(salida);

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }
    }

    public void requerimiento3(){
        try{
            ArrayList<CompraPorProveedor> rankingCompraPorProveedor = controlador.consultarCompraPorProveedor();
            String salida = "  *** Compras por Proveedor *** \n\nID_Compra\tProveedor\tConstructora\t\tBanco\t\tCiudad\n\n";
            for (CompraPorProveedor compraPorProveedor : rankingCompraPorProveedor){
                salida += compraPorProveedor.getID_Compra();
                salida += "\t";
                salida += compraPorProveedor.getProveedor();
                salida += "\t";
                salida += compraPorProveedor.getConstructora();
                if(compraPorProveedor.getConstructora().length() <= 11 || compraPorProveedor.getConstructora().equals("Ingenieros Ltda.")) {
                    salida += "\t\t";
                } else {
                    salida += "\t";
                }
                salida += compraPorProveedor.getBanco_Vinculado();
                if(compraPorProveedor.getBanco_Vinculado().length() <= 15){
                    salida += "\t\t";
                } else {
                    salida += "\t";
                }
                salida += compraPorProveedor.getCiudad();
                salida += "\n";
            } 
            textArea.setText(salida);   
        
        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }
    }
}