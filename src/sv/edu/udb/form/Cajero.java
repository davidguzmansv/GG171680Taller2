package sv.edu.udb.form;

import clases.Datos;

import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Cajero extends JFrame {
    private JPanel pnlCajero;
    private JButton crearClienteButton;
    private JButton btningresaraCuentas;
    private JButton salirButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton crearCuentaButton;
    private JButton retirosButton;
    private JButton abonosButton;
    private JButton consultaXCuentaButton;
    private JButton detalleDeCuentasButton;
    private JButton transaccionesXCuentaButton;
    private JButton salirButton1;
    private JTextField textField5;
    private JTextField textField6;
    private JButton agregarButton;
    private JTextField textField7;
    private JTextField textField8;
    private JButton retirarButton;
    private JTextField textField9;
    private JTextField textField10;
    private JButton abonarButton;
    private JTable table1;
    private JTable table2;
    private JTable table3;
    private JTextField textField11;
    private JTextField textField12;
    private JComboBox cmbMenu1;
    private JTextField txtUsuario;
    private JLabel lblClave;
    private JLabel lblUsuario;
    private JPasswordField txtClave;
    private JButton btnIngresar;

    public Cajero(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlCajero);
        this.setMinimumSize(new Dimension(600, 500));
        this.setLocationRelativeTo(getParent());
        this.setSize(1300,600);

        // crear objetos
        btningresaraCuentas = new JButton("Ingresar a cuentas");
        txtUsuario = new JTextField(("Usuario"));
        txtClave = new JPasswordField("***");


        // Definir propiedades de los objetos
        btningresaraCuentas.setToolTipText("Ingresar a la informacion de las cuentas");
        btnIngresar.setToolTipText("Ingresar a la informacion de las cuentas");

        // Agregar eventos a los objetos
        btningresaraCuentas.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btningresaraCuentasActionPerformed(e);
            }
        }));

        btnIngresar.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnIngresarActionPerformed(e);
            }
        }));

    }

    private void btningresaraCuentasActionPerformed(ActionEvent e) {
        Datos datosCuenta = new Datos();
        if(!datosCuenta.validarUsuario(txtUsuario.getText(), new String((txtClave.getPassword())))) {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña no validos");
            txtUsuario.setText((""));
            txtClave.setText("");
            txtUsuario.requestFocusInWindow();
            return;
        }

    }

    private void btnIngresarActionPerformed(ActionEvent e) {
        Datos datosCuenta = new Datos();
        if(!datosCuenta.validarUsuario(txtUsuario.getText(), new String((txtClave.getPassword())))) {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña no validos");
            txtUsuario.setText((""));
            txtClave.setText("");
            txtUsuario.requestFocusInWindow();
            return;
        }

    }






}
