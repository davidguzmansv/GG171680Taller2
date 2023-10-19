package sv.edu.udb.form;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;


public class Cajero extends JFrame {
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
        tblcuentas.setVisible(false);
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
        // crear objetos
        btningresaraCuentas = new JButton("Ingresar a cuentas");
        txtUsuario = new JTextField(("Usuario"));
        txtClave = new JPasswordField("***");

        //Arreglo de objetos para tabla Datos y crear columnas
        Object [] [] data =null;
        String [] colums= {
                "Id","Nombre","Dui","Pin","Cuenta 1","Cuenta 2","Cuenta 3","Cuenta 4"
        };

        //Instanciamos el modelo
        model =new DefaultTableModel(data, colums);
        tblDatos.setModel(model);
        // Definir propiedades de los objetos
        btningresaraCuentas.setToolTipText("Ingresar a la informacion de las cuentas");

        // Agregar eventos a los objetos
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
        cmbCuentas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cmbCuentas();
            }
        });
    }
    private void cmbCuentas(){

    }
    private void salirButton1(){
        cmbCuentas.setVisible(false);
        salirButton1.setVisible(false);
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
    }
}