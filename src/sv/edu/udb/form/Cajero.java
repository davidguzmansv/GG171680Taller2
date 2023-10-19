package sv.edu.udb.form;

import clases.Datos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
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
    private JButton crearCuentaButton;
    private JButton retirosButton;
    private JButton abonosButton;
    private JButton consultaXCuentaButton;
    private JButton detalleDeCuentasButton;
    private JButton transaccionesXCuentaButton;
    private JButton salirButton1;
    private JTextField txtCuenta1;
    private JTextField textField6;
    private JButton agregarButton;
    private JTextField txtCuenta2;
    private JTextField textField8;
    private JButton retirarButton;
    private JTextField txtCuenta3;
    private JTextField textField10;
    private JButton abonarButton;
    private JTable table1;
    private JTable table2;
    private JTable table3;
    private JTextField txtCuenta4;
    private JTextField textField12;
    private JComboBox cmbMenu1;
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
        crearCuentaButton.setVisible(false);
        retirosButton.setVisible(false);
        abonosButton.setVisible(false);
        consultaXCuentaButton.setVisible(false);
        detalleDeCuentasButton.setVisible(false);
        transaccionesXCuentaButton.setVisible(false);
        salirButton1.setVisible(false);

        // crear objetos
        btningresaraCuentas = new JButton("Ingresar a cuentas");
        txtUsuario = new JTextField(("Usuario"));
        txtClave = new JPasswordField("***");


        // Definir propiedades de los objetos
        btningresaraCuentas.setToolTipText("Ingresar a la informacion de las cuentas");

        // Agregar eventos a los objetos
        btningresaraCuentas.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btningresaraCuentasActionPerformed(e);
            }
        }));

        crearClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { crearClienteButtonActionPerformed(e); }
        });
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
    }
    private void btningresaraCuentasActionPerformed(java.awt.event.ActionEvent e) {
        Datos datosCuenta = new Datos();
        if(!datosCuenta.validarUsuario(txtUsuario.getText(), new String((txtClave.getPassword())))) {
            //jOptionPane.showMessageDialog(null, "Usuario o contraseña no validos");
            txtUsuario.setText((""));
            txtClave.setText("");
            txtUsuario.requestFocusInWindow();
            return;
        }

    }






}
