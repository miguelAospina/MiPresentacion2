package miPresentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;



public class GUI_Presentacion extends JFrame {
    //atributos
    private JButton miFoto, miHobby, misExpectativas;
    private JPanel panelBotones, panelDatos;
    private Titulos titulo;
    private JLabel labelImagen;
    private JTextArea textoExpectativas;
    private Escucha escucha;

    //metodos
    public GUI_Presentacion() {
        initGUI();

        //configuracion base de la ventana
        this.setTitle("Mi presentacion");
        this.setSize(600, 540);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initGUI() {
        //Definir Container y Layout del JFrame
        //Crear objetos Escucha y control
        escucha = new Escucha();
        //Configurar JComponents
        titulo = new Titulos("Buenos dias,tardes o noches, soy Miguel Ospina, presiona los botones",Color.BLACK);
        this.add(titulo,BorderLayout.PAGE_START);

        panelDatos = new JPanel();
        panelDatos.setBorder(BorderFactory.createTitledBorder(null,"algo de mi:",
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, new Font("Calibri",
                        Font.PLAIN, 20),Color.BLACK));

        this.add(panelDatos, BorderLayout.CENTER);

        miFoto = new JButton("soy yo");
        miFoto.addMouseListener(escucha);
        miHobby = new JButton("lo que mas me entretiene");
        miHobby.addMouseListener(escucha);
        misExpectativas = new JButton("mis sueños");
        misExpectativas.addKeyListener(escucha);

        panelBotones = new JPanel();
        panelBotones.add(miFoto);
        panelBotones.add(miHobby);
        panelBotones.add(misExpectativas);

        this.add(panelBotones,BorderLayout.SOUTH);

        labelImagen = new JLabel();
        textoExpectativas = new JTextArea(10,12);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
            GUI_Presentacion miGUIPresentacion = new GUI_Presentacion();

            }
        });

    }

    private class Escucha implements MouseListener, KeyListener {
         private ImageIcon image;

        @Override
        public void mouseClicked (MouseEvent e) {

            if ((e.getSource()==miFoto) && (e.getClickCount()==1)){
                panelDatos.removeAll();
                image = new ImageIcon(getClass().getResource("/recursos/IMG_3250.PNG"));
                labelImagen.setIcon(image);
                panelDatos.add(labelImagen);
            }
            if((e.getSource()==miHobby) && (e.getClickCount() == 2)){
                    image = new ImageIcon(getClass().getResource("/recursos/1366_2000.jpeg"));
                    labelImagen.setIcon(image);
                    panelDatos.add(labelImagen);
                }
            revalidate();
            repaint();
            }
        @Override
        public void mousePressed (MouseEvent e){

        }

        @Override
        public void mouseReleased (MouseEvent e){

        }

        @Override
        public void mouseEntered (MouseEvent e){

        }

        @Override
        public void mouseExited (MouseEvent e){

        }

        @Override
        public void keyTyped(KeyEvent e){
            if((e.getComponent() == misExpectativas) && (e.getKeyChar() == KeyEvent.VK_M)){
                 panelDatos.removeAll();
                textoExpectativas.setFont(new Font("SansSerif", Font.BOLD, 22));
                textoExpectativas.setLineWrap(true);
                textoExpectativas.setBackground(null);
                textoExpectativas.setWrapStyleWord(true);
                textoExpectativas.setEditable(false);
                textoExpectativas.setText("Aprender sobre este nuevo lenguaje, " +
                        "que es muy usado y conocido en todo el mundo");
                panelDatos.add(textoExpectativas);

                revalidate();
                repaint();

            }

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

    }

}

