package sv.edu.udb.form;

import clases.Datos;

import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import com.opencsv.*;


public class Cajero extends javax.swing.JFrame {
    private JPanel pnlCajero;
    private JButton crearClienteButton;
    private JButton btningresaraCuentas;
    private JButton salirButton;
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtDui;
    private JTextField txtPin;
    private JButton salirButton1;
    private JTextField txtCuenta1;
    private JTextField txtInicial;
    private JButton agregarButton;
    private JTextField txtCuenta2;
    private JTextField txtRetiro;
    private JButton retirarButton;
    private JTextField txtCuenta3;
    private JTextField txtAbono;
    private JButton abonarButton;
    private JTable tblDatos;
    private JTextField txtCuenta4;
    private JTextField txtUsuario;
    private JLabel lblClave;
    private JLabel lblUsuario;
    private JPasswordField txtClave;
    private JButton btnIngresar;
    private JLabel lblId;
    private JLabel lblNombre;
    private JLabel lblDui;
    private JLabel lblPin;
    private JLabel lblCuenta1;
    private JLabel lblCuenta2;
    private JLabel lblCuenta3;
    private JLabel lblCuenta4;
    private JButton guardarButton;
    private JButton regresarButton;
    private JComboBox cmbCuentas;
    private JButton movimientosDeCuentasButton;
    private JTable tblcuentas;
    private JLabel lblInicial;
    private JLabel lblRetiro;
    private JLabel lblAbono;
    private JScrollPane jscuentas;
    private JScrollPane jsdatos;
    private JLabel lblop;
    DefaultTableModel model=null;

    public Cajero(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlCajero);
        this.setMinimumSize(new Dimension(600, 500));
        this.setLocationRelativeTo(getParent());
        this.setSize(1300,600);

        lblId.setVisible(false);
        lblNombre.setVisible(false);
        lblDui.setVisible(false);
        lblPin.setVisible(false);
        lblCuenta1.setVisible(false);
        lblCuenta2.setVisible(false);
        lblCuenta3.setVisible(false);
        lblCuenta4.setVisible(false);
        txtId.setVisible(false);
        txtDui.setVisible(false);
        txtNombre.setVisible(false);
        txtPin.setVisible(false);
        txtCuenta1.setVisible(false);
        txtCuenta2.setVisible(false);
        txtCuenta3.setVisible(false);
        txtCuenta4.setVisible(false);
        guardarButton.setVisible(false);
        regresarButton.setVisible(false);
        cmbCuentas.setVisible(false);
        salirButton1.setVisible(false);
        txtInicial.setVisible(false);
        txtAbono.setVisible(false);
        txtRetiro.setVisible(false);
        lblInicial.setVisible(false);
        lblRetiro.setVisible(false);
        lblAbono.setVisible(false);
        retirarButton.setVisible(false);
        agregarButton.setVisible(false);
        abonarButton.setVisible(false);
        tblcuentas.setVisible(false);
        tblDatos.setVisible(false);
        jscuentas.setVisible(false);
        jsdatos.setVisible(false);
        crearClienteButton.setVisible(false);
        cmbCuentas.setVisible(false);
        salirButton1.setVisible(false);
        //salirButton.setVisible(false);
        movimientosDeCuentasButton.setVisible(false);
        lblop.setVisible(false);
        // crear objetos
        btningresaraCuentas = new JButton("Ingresar a cuentas");
        //btnIngresar = new JButton("Ingresar");
        //txtUsuario = new JTextField("Usuario");
        //txtClave = new JPasswordField("***");

        //Arreglo de objetos para tabla Datos y crear columnas
        Object [] [] data =null;
        String [] colums= {
                "Id","Nombre","Dui","Pin","Cuenta 1","Cuenta 2","Cuenta 3","Cuenta 4"
        };

        //Instanciamos el modelo
        model =new DefaultTableModel(data, colums);
        this.tblDatos.setModel(model);

        this.loadDataFromCsvToTable();

        // Definir propiedades de los objetos
        btningresaraCuentas.setToolTipText("Ingresar a la informacion de las cuentas");

        // Agregar eventos a los objetos
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { btnIngresarActionPerformed(e); }
        });

        crearClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { crearClienteButtonActionPerformed(e); }
        });
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { guardarButton();  }
        });
        tblDatos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                tblDatos(e);
            }
        });
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regresarButton();
            }
        });
        movimientosDeCuentasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                movimientosDeCuentasButtonActionPerformed(e);
            }
        });
        salirButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salirButton1();
            }
        });

        retirarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retirarButton();
            }
        });

        abonarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abonarButton();
            }
        });

        cmbCuentas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cmbCuentas();
            }
        });
        tblcuentas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                tblcuentas(e);
            }
        });
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarButton();
            }
        });

        abonarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abonarButton();
            }
        });
    }
    private void agregarButton(){
        String nombre;
        String dui;
        String cuenta1;

        nombre = txtNombre.getText();
        dui = txtDui.getText();
        cuenta1 = txtInicial.getText();

        JOptionPane.showMessageDialog(null,"Datos Obtenidos: \n Nombre " +nombre+
                "\n Dui: "+ dui+"\n Cuenta: "+cuenta1);

        Object [] newRow={
                nombre,
                dui,
                cuenta1 };

        model.addRow(newRow);

        this.saveDataInCsvCuentas(nombre, dui, cuenta1);
    }

    private void retirarButton(){
        String cuenta;
        String abono;
        String retiro;
        String saldo;

        cuenta = txtNombre.getText();
        abono = "0.0";
        retiro = txtRetiro.getText();


        JOptionPane.showMessageDialog(null,"Datos Obtenidos: \n cuenta " +cuenta+
                "\n Abono: 0.0 "+"\n Retiro: "+retiro);

        Object [] newRow={
                cuenta,
                abono,
                retiro };

        model.addRow(newRow);

        this.saveDataInCsvMovimientos(cuenta, abono, retiro);
    }

    private void abonarButton(){
        String cuenta;
        String abono;
        String retiro;
        String saldo;

        cuenta = txtNombre.getText();
        abono =  txtAbono.getText();
        retiro = "0.0";


        JOptionPane.showMessageDialog(null,"Datos Obtenidos: \n cuenta " +cuenta+
                "\n Abono: "+abono+"\n Retiro: 0.0");

        Object [] newRow={
                cuenta,
                abono,
                retiro };

        model.addRow(newRow);

        this.saveDataInCsvMovimientos(cuenta, abono, retiro);
    }

    private void cmbCuentas(){
        if(cmbCuentas.getSelectedIndex() == 0){
            lblDui.setVisible(true);
            lblPin.setVisible(true);
            lblNombre.setVisible(true);
            lblInicial.setVisible(true);
            lblRetiro.setVisible(false);
            lblAbono.setVisible(false);
            txtDui.setVisible(true);
            txtPin.setVisible(true);
            txtNombre.setVisible(true);
            txtInicial.setVisible(true);
            txtAbono.setVisible(false);
            txtRetiro.setVisible(false);
            retirarButton.setVisible(false);
            abonarButton.setVisible(false);
            jscuentas.setVisible(true);
            tblcuentas.setVisible(true);
            agregarButton.setVisible(true);
        }
        else if (cmbCuentas.getSelectedIndex() == 1) {
            lblDui.setVisible(true);
            lblPin.setVisible(true);
            txtDui.setVisible(true);
            txtPin.setVisible(true);
            txtInicial.setVisible(true);
            txtAbono.setVisible(true);
            txtRetiro.setVisible(true);
            lblInicial.setVisible(true);
            lblRetiro.setVisible(true);
            lblAbono.setVisible(true);
            retirarButton.setVisible(true);
            agregarButton.setVisible(true);
            abonarButton.setVisible(true);
            tblcuentas.setVisible(true);
            jscuentas.setVisible(true);
        }
        else if (cmbCuentas.getSelectedIndex() == 2) {
            lblDui.setVisible(true);
            lblPin.setVisible(true);
            txtDui.setVisible(true);
            txtPin.setVisible(true);
            lblInicial.setVisible(true);
            lblRetiro.setVisible(false);
            lblAbono.setVisible(true);
            txtInicial.setVisible(true);
            txtAbono.setVisible(true);
            txtRetiro.setVisible(false);
            retirarButton.setVisible(false);
            agregarButton.setVisible(false);
            abonarButton.setVisible(true);
            jscuentas.setVisible(true);
            tblcuentas.setVisible(true);
        }
    }
    private void salirButton1(){
        cmbCuentas.setVisible(false);
        salirButton1.setVisible(false);
        txtInicial.setVisible(false);
        txtAbono.setVisible(false);
        txtRetiro.setVisible(false);
        lblInicial.setVisible(false);
        lblRetiro.setVisible(false);
        lblAbono.setVisible(false);
        retirarButton.setVisible(false);
        agregarButton.setVisible(false);
        abonarButton.setVisible(false);
        tblcuentas.setVisible(false);
        jscuentas.setVisible(false);
        lblDui.setVisible(false);
        lblPin.setVisible(false);
        txtDui.setVisible(false);
        txtPin.setVisible(false);
    }
    private void movimientosDeCuentasButtonActionPerformed(java.awt.event.ActionEvent e){
        cmbCuentas.setVisible(true);
        salirButton1.setVisible(true);
    }

    private void regresarButton(){
        lblId.setVisible(false);
        lblNombre.setVisible(false);
        lblDui.setVisible(false);
        lblPin.setVisible(false);
        lblCuenta1.setVisible(false);
        lblCuenta2.setVisible(false);
        lblCuenta3.setVisible(false);
        lblCuenta4.setVisible(false);
        txtId.setVisible(false);
        txtDui.setVisible(false);
        txtNombre.setVisible(false);
        txtPin.setVisible(false);
        txtCuenta1.setVisible(false);
        txtCuenta2.setVisible(false);
        txtCuenta3.setVisible(false);
        txtCuenta4.setVisible(false);
        guardarButton.setVisible(false);
        regresarButton.setVisible(false);
        tblDatos.setVisible(false);
        jsdatos.setVisible(false);
    }
    private void tblDatos(MouseEvent e){
        int fila = tblDatos.rowAtPoint((e.getPoint()));
        int columna = tblDatos.columnAtPoint(e.getPoint());

        if((fila > -1) && (columna > -1)){
            txtId.setText(model.getValueAt(fila,0).toString());
            txtNombre.setText(model.getValueAt(fila,1).toString());
            txtDui.setText(model.getValueAt(fila,3).toString());
            txtPin.setText(model.getValueAt(fila,4).toString());
            txtCuenta1.setText(model.getValueAt(fila,5).toString());
            txtCuenta2.setText(model.getValueAt(fila,6).toString());
            txtCuenta3.setText(model.getValueAt(fila,7).toString());
            txtCuenta4.setText(model.getValueAt(fila,8).toString());
        }
    }
    private void tblcuentas(MouseEvent e){
        int fila = tblcuentas.rowAtPoint((e.getPoint()));
        int columna = tblcuentas.columnAtPoint(e.getPoint());

        if((fila > -1) && (columna > -1)){
            txtNombre.setText(model.getValueAt(fila,0).toString());
            txtDui.setText(model.getValueAt(fila,1).toString());
            txtCuenta1.setText(model.getValueAt(fila,2).toString());
        }
    }
    private void guardarButton(){
        String id;
        String nombre;
        String dui;
        String pin;
        String cuenta1;
        String cuenta2;
        String cuenta3;
        String cuenta4;

        id = txtId.getText();
        nombre = txtNombre.getText();
        dui = txtDui.getText();
        pin = txtPin.getText();
        cuenta1 = txtCuenta1.getText();
        cuenta2 = txtCuenta2.getText();
        cuenta3 = txtCuenta3.getText();
        cuenta4 = txtCuenta4.getText();

        JOptionPane.showMessageDialog(null,"Datos Obtenidos: \n ID: " +id+
                "\n nombre: "+ nombre+"\n Dui: "+dui+"\n Cuentas: "+cuenta1);

        Object [] newRow={
                id,
                nombre,
                dui,
                pin,
                cuenta1,
                cuenta2,
                cuenta3,
                cuenta4 };
        model.addRow(newRow);

        this.saveDataInCsv(id, nombre, dui, pin, cuenta1, cuenta2, cuenta3, cuenta4);
    }
    private void crearClienteButtonActionPerformed(java.awt.event.ActionEvent e){
        lblId.setVisible(true);
        lblDui.setVisible(true);
        lblNombre.setVisible(true);
        lblCuenta4.setVisible(true);
        lblPin.setVisible(true);
        lblCuenta3.setVisible(true);
        lblCuenta2.setVisible(true);
        lblCuenta1.setVisible(true);
        txtId.setVisible(true);
        txtNombre.setVisible(true);
        txtDui.setVisible(true);
        txtPin.setVisible(true);
        txtCuenta4.setVisible(true);
        txtCuenta3.setVisible(true);
        txtCuenta2.setVisible(true);
        txtCuenta1.setVisible(true);
        guardarButton.setVisible(true);
        regresarButton.setVisible(true);
        tblDatos.setVisible(true);
        jsdatos.setVisible(true);
    }

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent e) {
        //JOptionPane.showMessageDialog(null, "Usuario o clave no válidos");
        Datos datosCuenta = new Datos();
        if(!datosCuenta.validarUsuario(txtUsuario.getText(), new String(txtClave.getPassword()))) {
            JOptionPane.showMessageDialog(null, "Usuario o clave no válidos");
            txtUsuario.setText("");
            txtClave.setText("");
            txtUsuario.requestFocusInWindow();
            return;
        }
        crearClienteButton.setVisible(true);
        movimientosDeCuentasButton.setVisible(true);
        //salirButton.setVisible(true);
        lblop.setVisible(true);
        lblUsuario.setVisible(false);
        lblClave.setVisible(false);
        txtClave.setVisible(false);
        txtUsuario.setVisible(false);
        btnIngresar.setVisible(false);
    }


    private void loadDataFromCsvToTable(){
        FileReader fileCsv = null;
        String path = System.getProperty("user.dir");
        BufferedReader br = null;

        this.model.setRowCount(0);

        try{
            fileCsv = new FileReader(path + "/src/sv/edu/udb/util/personas.csv");
            br = new BufferedReader(fileCsv);
            String line = br.readLine();
            while(line != null){
                String[] fields = line.split(",");

                String id = fields[0];
                String nombre = fields[1];
                String dui = fields[2];
                String pin = fields[3];
                String cuenta1 = fields[4];
                String cuenta2 = fields[5];
                String cuenta3 = fields[6];
                String cuenta4 = fields[7];

                Object[] newRow={id, nombre, dui, pin, cuenta1, cuenta2, cuenta3, cuenta4};
                this.model.addRow(newRow);
                line = br.readLine();
            }
        }
        catch(Exception e){
            System.out.print(e.toString());
        }
    }

    private void saveDataInCsv(String id, String nombre, String dui, String pin, String cuenta1, String cuenta2, String cuenta3, String cuenta4){
        FileWriter fileCsv = null;
        String path = System.getProperty("user.dir");
        BufferedReader br = null;

        try{
            fileCsv = new FileWriter(path + "/src/sv/edu/udb/util/personas.csv", true);
            PrintWriter writer = new PrintWriter(fileCsv);

            StringBuilder sb = new StringBuilder();
            sb.append("\n");
            sb.append(id+","+nombre+","+dui+","+pin+","+cuenta1+","+cuenta2+","+cuenta3+","+cuenta4 );

            writer.write(sb.toString());
            writer.close();

            this.loadDataFromCsvToTable();
        }
        catch(Exception e){
            System.out.print(e.toString());
        }
    }

    private void saveDataInCsvCuentas(String nombre, String dui,String cuenta1){
        FileWriter fileCsv = null;
        String path = System.getProperty("user.dir");
        BufferedReader br = null;

        try{
            fileCsv = new FileWriter(path + "/src/sv/edu/udb/util/cuentas.csv", true);
            PrintWriter writer = new PrintWriter(fileCsv);

            StringBuilder sb = new StringBuilder();
            sb.append("\n");
            sb.append(nombre+","+dui+","+cuenta1);

            writer.write(sb.toString());
            writer.close();

            //this.loadDataFromCsvToTable();
        }
        catch(Exception e){
            System.out.print(e.toString());
        }
    }

    private void saveDataInCsvMovimientos(String nombre, String dui,String cuenta1){
        FileWriter fileCsv = null;
        String path = System.getProperty("user.dir");
        BufferedReader br = null;

        try{
            fileCsv = new FileWriter(path + "/src/sv/edu/udb/util/movimientos.csv", true);
            PrintWriter writer = new PrintWriter(fileCsv);

            StringBuilder sb = new StringBuilder();
            sb.append("\n");
            sb.append(nombre+","+dui+","+cuenta1);

            writer.write(sb.toString());
            writer.close();

            //this.loadDataFromCsvToTable();
        }
        catch(Exception e){
            System.out.print(e.toString());
        }
    }

}