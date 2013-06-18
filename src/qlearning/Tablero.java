/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qlearning;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observer;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
//import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
//import javax.swing.border.Border;

/**
 *
 * @author Grupo 6
 */
public class Tablero extends JFrame implements ActionListener {

    /**
     * Creates new form Tablero
     */
    public Tablero() {
        initComponents();
        //panCentro.setSize(350, 350);
        spinEps.setModel(new SpinnerNumberModel(0.1, 0.1, 1.0, 0.05));
        panGral.setLayout(new BorderLayout());
        panGral.add(panBot, BorderLayout.WEST);
        panGral.add(panCentro, BorderLayout.CENTER);
    }
    
    public static String letra = null;
    public static Color fondo = Color.WHITE;
    public static Color colMalo = new Color(50, 200, 0);
    public static Color colBueno = new Color(100, 100, 100);
    public static Color colExc = new Color(150, 150, 150);
    public static Color colPozo = new Color(0, 0, 0);
    public static JButton[] estados;
    public static int posFinal;
    public static int posInic = -1;
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jFrame1 = new javax.swing.JFrame();
        panGral = new javax.swing.JPanel();
        panBot = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        comboSize = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        btnAleat = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        comboTipo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        radioEpsilon = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        spinEps = new javax.swing.JSpinner();
        radioSoft = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        btnAprende = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        comboTableros = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        lblAprende = new javax.swing.JLabel();
        lblCiclo = new javax.swing.JLabel();
        panCentro = new javax.swing.JPanel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Q-learning");
        setAlwaysOnTop(true);
        setBounds(new java.awt.Rectangle(0, 0, 800, 500));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(800, 800));
        setPreferredSize(new java.awt.Dimension(800, 800));
        setResizable(false);

        jLabel6.setText("Tamaño");

        comboSize.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "6x6", "7x7", "8x8", "9x9", "10x10" }));
        comboSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSizeActionPerformed(evt);
            }
        });

        jLabel5.setText("Tipo de Mapa");

        btnAleat.setText("Aleatorio");
        btnAleat.setEnabled(false);
        btnAleat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAleatActionPerformed(evt);
            }
        });

        jLabel1.setText("Tipo de Estado");

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Malo", "Bueno", "Excelente", "Neutro", "Pozo", "Inicial", "Final" }));
        comboTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoActionPerformed(evt);
            }
        });

        jLabel2.setText("Políticas");

        buttonGroup1.add(radioEpsilon);
        radioEpsilon.setText("e-greedy");
        radioEpsilon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioEpsilonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("є");

        spinEps.setEnabled(false);

        buttonGroup1.add(radioSoft);
        radioSoft.setText("Softmax");
        radioSoft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioSoftActionPerformed(evt);
            }
        });

        jLabel3.setText("Tau");

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));

        btnAprende.setText("Aprender");
        btnAprende.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAprendeActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar Tablero");
        btnGuardar.setToolTipText("");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        comboTableros.setEnabled(false);
        comboTableros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTablerosActionPerformed(evt);
            }
        });

        jButton1.setText("Limpiar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblAprende.setText("Aprendiendo..");

        lblCiclo.setText("0");

        javax.swing.GroupLayout panBotLayout = new javax.swing.GroupLayout(panBot);
        panBot.setLayout(panBotLayout);
        panBotLayout.setHorizontalGroup(
            panBotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBotLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panBotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panBotLayout.createSequentialGroup()
                        .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panBotLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panBotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(comboSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(btnAleat)
                            .addGroup(panBotLayout.createSequentialGroup()
                                .addGroup(panBotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panBotLayout.createSequentialGroup()
                                        .addComponent(radioEpsilon)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4))
                                    .addGroup(panBotLayout.createSequentialGroup()
                                        .addComponent(radioSoft)
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel3)))
                                .addGap(18, 18, 18)
                                .addGroup(panBotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(spinEps)
                                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(2, 2, 2))
                    .addGroup(panBotLayout.createSequentialGroup()
                        .addGroup(panBotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboTableros, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panBotLayout.createSequentialGroup()
                                .addComponent(btnAprende)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panBotLayout.createSequentialGroup()
                        .addComponent(lblAprende)
                        .addGap(18, 18, 18)
                        .addComponent(lblCiclo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(19, 19, 19)))
                .addContainerGap())
        );
        panBotLayout.setVerticalGroup(
            panBotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBotLayout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAleat)
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panBotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panBotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioEpsilon)
                    .addComponent(jLabel4)
                    .addComponent(spinEps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panBotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioSoft)
                    .addComponent(jLabel3)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboTableros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(panBotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAprende)
                    .addComponent(lblCiclo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panBotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAprende)
                    .addComponent(btnSalir)))
        );

        panCentro.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panCentro.setMaximumSize(new java.awt.Dimension(500, 500));

        javax.swing.GroupLayout panCentroLayout = new javax.swing.GroupLayout(panCentro);
        panCentro.setLayout(panCentroLayout);
        panCentroLayout.setHorizontalGroup(
            panCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 419, Short.MAX_VALUE)
        );
        panCentroLayout.setVerticalGroup(
            panCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 349, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panGralLayout = new javax.swing.GroupLayout(panGral);
        panGral.setLayout(panGralLayout);
        panGralLayout.setHorizontalGroup(
            panGralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panGralLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(panBot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panCentro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        panGralLayout.setVerticalGroup(
            panGralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panGralLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(panGralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panCentro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panBot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        panCentro.getAccessibleContext().setAccessibleName("");
        panCentro.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panGral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panGral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAprendeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAprendeActionPerformed
        
        this.setCursor(Cursor.WAIT_CURSOR);
        politicaElegida();
        Matriz.inicializarEstados();
        finalUnico();
        matrizR();
        Matriz.aprendizaje();
        this.setCursor(Cursor.DEFAULT_CURSOR);
        mostrarRecorrido();

    }//GEN-LAST:event_btnAprendeActionPerformed

    private void radioSoftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioSoftActionPerformed
        //        textTau.setEnabled(true);
        //        textTau.requestFocusInWindow();
        jFormattedTextField1.setEnabled(true);
        jFormattedTextField1.requestFocusInWindow();
        spinEps.setEnabled(false);
        //        textEpsilon.setText(null);
        //        textEpsilon.setEnabled(false);
    }//GEN-LAST:event_radioSoftActionPerformed

    private void radioEpsilonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioEpsilonActionPerformed
        //textEpsilon.setEnabled(true);
        //textEpsilon.requestFocusInWindow();
        spinEps.setEnabled(true);
        spinEps.requestFocusInWindow();
        //        textTau.setText(null);
        //        textTau.setEnabled(false);
        jFormattedTextField1.setValue(0);
        jFormattedTextField1.setEnabled(false);
    }//GEN-LAST:event_radioEpsilonActionPerformed

    private void comboTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoActionPerformed
        tipoDePantalla();
    }//GEN-LAST:event_comboTipoActionPerformed

    private void btnAleatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAleatActionPerformed
        aleatorio();//Completar el paso de parametro con el tamaño de tablero
    }//GEN-LAST:event_btnAleatActionPerformed

    private void comboSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSizeActionPerformed
        iniciar();
        btnAleat.setEnabled(true);
    }//GEN-LAST:event_comboSizeActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Estadistica.guardarTablero();
        cantTableros();
        comboTableros.setEnabled(true);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void comboTablerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTablerosActionPerformed
        redibujar();
    }//GEN-LAST:event_comboTablerosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        limpiarTablero();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    //Toma el valor de tamaño del tablero desde el comboBox
    private void sizeDePantalla (){
        int size= 0;
        String aux = (String)comboSize.getSelectedItem();
        switch(aux){
            case "6x6":size= 6;
                break;
            case "7x7":size= 7;
                break;
            case "8x8":size= 8;
                break;
            case "9x9":size= 9;
                break;
            case "10x10":size=10;
                break;
        }    
        ConfTab.setSize(size);
    }
    
    //Toma el valor de que tipo de estado se quiere colocar en el tablero
    public String tipoDePantalla(){
        String aux = (String) comboTipo.getSelectedItem();
        switch(aux){
            case "Malo":{
                letra = "M";
                fondo = colMalo;
            }
                break;
            case "Bueno":{
                letra = "B";
                fondo = colBueno;
            }
                break;
            case "Excelente":{
                letra = "E";
                fondo = colExc;
            }
                break;
            case "Neutro":{
                letra = "";
                fondo = Color.WHITE;
            }
                break;
            case "Pozo":{
                letra = "P";
                fondo = colPozo;
            }
                break;
            case "Inicial":{
                letra = "Inicial";
                fondo = Color.WHITE;
            }
                break;
            case "Final":{
                letra = "Final";
                fondo = Color.WHITE;
            }
                break;
        }
        return aux;
    }
    
    
    //Dependiendo de que politica se selecciona actualiza el valor de epsilon o tau en la clase ConfTab
    public void politicaElegida(){
         if(radioEpsilon.isSelected()){
             ConfTab.setEpsilon((double) spinEps.getValue());
             //ConfTab.setEpsilon(Float.parseFloat(textEpsilon.getText()));
         }
         else{
             ConfTab.setTau(Double.parseDouble(jFormattedTextField1.getText()) );
             //ConfTab.setTau(Float.parseFloat(textTau.getText()));
         }
    }
    
    //Pinta un tablero con el tamaño elegido y todos los estados neutro
    public void iniciar(){
        sizeDePantalla();
        int size = ConfTab.size;
        estados = new JButton[size*size];
        panCentro.setVisible(false);
        panCentro.removeAll();
        panCentro.setLayout(new GridLayout(size, size));
        for (int i = 0; i < (size*size); i++) {
                            
            final JButton temp = new JButton();
            temp.setBackground(Color.WHITE);
            temp.setSize(290/size, 290/size);
            temp.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {                       
                    if ("Final".equals(tipoDePantalla())){
                        if (!finalUnico()){
                            estados[posFinal].setBackground(Color.WHITE);
                            estados[posFinal].setText("");
                            panCentro.remove(posFinal);
                            panCentro.add(estados[posFinal], posFinal);
                            
                        }
                    }
                    if ("Inicial".equals(tipoDePantalla())){
                        if (!inicialUnico()){
                            estados[posInic].setBackground(Color.WHITE);
                            estados[posInic].setText("");
                            panCentro.remove(posInic);
                            panCentro.add(estados[posInic], posInic);
                        }
                    }
                    temp.setText(letra);
                    temp.setBackground(fondo);
                }
            });

            //agregar el boton al panel
            panCentro.add(temp);
            //agregar el boton al arreglo
            estados[i] = temp;
//                estados[i][j] = temp;
        }
        panCentro.setVisible(true);
        
        
    }
    
    //Pinta un tablero definiendo los tipos de estado aleatoriamente
    public void aleatorio(){

        int size = ConfTab.getSize();
        for (int i = 0; i < size*size; i++) {
            float x = new Random().nextFloat();
            if (x < 0.2) {
                estados[i].setText("M");
                estados[i].setBackground(colMalo);
            } else {
                if (x < 0.5) {
                    estados[i].setText("B");
                    estados[i].setBackground(colBueno);
                } else {
                    if (x < 0.6) {
                        estados[i].setText("E");
                        estados[i].setBackground(colExc);
                    } else {
                        if (x < 0.7) {
                            estados[i].setText("P");
                            estados[i].setBackground(colPozo);
                        }
                        else {
                            estados[i].setText("");
                            estados[i].setBackground(Color.WHITE);
                        }
                    }
                }
            }
            panCentro.add(estados[i]);
        }
        
        //Para colocar el estado inicial en una posicion aleatoria
        int z = new Random().nextInt(size*size);
        estados[z].setText("Inicial");
        estados[z].setBackground(Color.WHITE);
        posInic = z;
        panCentro.remove(z);
        panCentro.add(estados[z], z);
        
        //Para colocar el estado final en una posicion aleatoria
        int y = new Random().nextInt(size*size);
        estados[y].setText("Final");
        estados[y].setBackground(Color.WHITE);
        posFinal = y;
        panCentro.remove(y);
        panCentro.add(estados[y], y);
        //panCentro.setVisible(true);
    } 
    
    public void redibujar(){
        JButton[] tablero = Estadistica.cargarTablero(comboTableros.getSelectedIndex());
        int x = tablero.length;
        panCentro.removeAll();
        panCentro.setLayout(new GridLayout(x/x, x/x));
        for (int i = 0; i < x; i++) {
            panCentro.add(tablero[i]);
        }
        panCentro.repaint();
        jFrame1.pack();
        panCentro.setVisible(true);
        
    }
    
    //Segun los tipos de estado, actualiza los valores de recompensa en el arreglo de estados de Matriz
    public void matrizR(){
        int size = ConfTab.getSize();
        for (int i = 0; i < (size*size); i++) {
            if (estados[i].getBackground() == colMalo){
                Matriz.estados[i].setRecompensa(ConfTab.getrMalo());
            } else {
                if (estados[i].getBackground() == colBueno){
                    Matriz.estados[i].setRecompensa(ConfTab.getrBueno());
                } else {
                    if (estados[i].getBackground() == colExc){
                        Matriz.estados[i].setRecompensa(ConfTab.getrExc());
                    } else {
                        if (estados[i].getBackground() == colPozo) {
                            Matriz.estados[i].setRecompensa(ConfTab.getrPozo());
                        } else {
                            if ("Final".equals(estados[i].getText())){
                                Matriz.estados[i].setRecompensa(ConfTab.getrFin());
                                Matriz.actualizarEstadoFinal(i);
                                posFinal = i;
                            } else
                                if ("Inicial".equals(estados[i].getText())) {
                                    Matriz.estados[i].setRecompensa(ConfTab.getrNeutro());
                                    posInic = i;
                            }else
                                Matriz.estados[i].setRecompensa(ConfTab.getrNeutro());
                        }
                    }
                }
            }
        }
    }
    
    public void limpiarTablero(){
        panCentro.removeAll();
        int x = estados.length;
        for (int i = 0; i < x; i++) {
            estados[i].removeAll();
        }
        iniciar();
    }
    
    //Verifica que el final sea unico
    public Boolean finalUnico(){
        Boolean flag = true;
        for (int i = 0; i < (ConfTab.getSize()*ConfTab.getSize()); i++) {
            if ("Final".equals(estados[i].getText())){
                flag = false;
                posFinal = i;
            }
        }
        return flag;
    }
    
    //Verifica que el inicio sea unico
    public Boolean inicialUnico(){
        Boolean flag = true;
        for (int i = 0; i < (ConfTab.getSize()*ConfTab.getSize()); i++) {
            if ("Inicial".equals(estados[i].getText())){
                flag = false;
                posInic = i;
            }
        }
        return flag;
    }
    
    //Pinta el recorrido aprendido
    public void mostrarRecorrido(){
        Border lineaRoja = BorderFactory.createLineBorder(Color.RED, 3);
        //Iterator it;
        ArrayList elCamino;
        elCamino = Matriz.recorrer();
        //it = elCamino.iterator();
        for (int i = 0; i < elCamino.size(); i++) {
            estados[(int)elCamino.get(i)].setBorder(lineaRoja);
            panCentro.remove((int) elCamino.get(i));
            panCentro.add(estados[(int)elCamino.get(i)], (int)elCamino.get(i));
        }
    }
    
    public void cantTableros(){
        int longTab = Estadistica.tableros.size();
        comboTableros.insertItemAt(longTab, longTab-1);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tablero().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAleat;
    private javax.swing.JButton btnAprende;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox comboSize;
    private javax.swing.JComboBox comboTableros;
    private javax.swing.JComboBox comboTipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblAprende;
    private javax.swing.JLabel lblCiclo;
    private javax.swing.JPanel panBot;
    private javax.swing.JPanel panCentro;
    private javax.swing.JPanel panGral;
    private javax.swing.JRadioButton radioEpsilon;
    private javax.swing.JRadioButton radioSoft;
    private javax.swing.JSpinner spinEps;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
