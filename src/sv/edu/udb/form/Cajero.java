package sv.edu.udb.form;

import javax.swing.*;
import java.awt.*;
public class Cajero extends JFrame{
    private JPanel pnlCajero;
    private JButton crearClienteButton;
    private JButton ingresaraCuentasButton;
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
    private JComboBox comboBox1;

    public Cajero(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlCajero);
        this.setMinimumSize(new Dimension(600, 500));
        this.setLocationRelativeTo(getParent());
    }
}
