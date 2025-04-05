package manejodeproductosapp;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FormularioProductos extends JFrame {
    private JTextField txtCodigo, txtNombre, txtPrecio, txtCantidad;
    private JTable tablaProductos;
    private DefaultTableModel modelo;
    private JButton btnAgregar, btnEliminar, btnIrASegundoFormulario;

    public FormularioProductos() {
        setTitle("Manejo de Productos");
        setLayout(null);
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel lblTitulo = new JLabel("Manejo de Productos");
        lblTitulo.setBounds(200, 10, 200, 20);
        add(lblTitulo);

        JLabel lblCodigo = new JLabel("Código de producto:");
        lblCodigo.setBounds(30, 50, 150, 20);
        add(lblCodigo);
        txtCodigo = new JTextField();
        txtCodigo.setBounds(180, 50, 150, 20);
        add(txtCodigo);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 80, 150, 20);
        add(lblNombre);
        txtNombre = new JTextField();
        txtNombre.setBounds(180, 80, 150, 20);
        add(txtNombre);

        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setBounds(30, 110, 150, 20);
        add(lblPrecio);
        txtPrecio = new JTextField();
        txtPrecio.setBounds(180, 110, 150, 20);
        add(txtPrecio);

        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setBounds(30, 140, 150, 20);
        add(lblCantidad);
        txtCantidad = new JTextField();
        txtCantidad.setBounds(180, 140, 150, 20);
        add(txtCantidad);

        modelo = new DefaultTableModel(new String[]{"Código", "Nombre", "Precio", "Cantidad", "Total"}, 0);
        tablaProductos = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tablaProductos);
        scroll.setBounds(30, 180, 520, 150);
        add(scroll);

        btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(100, 350, 100, 30);
        add(btnAgregar);
        btnAgregar.addActionListener(e -> agregarProducto());

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(220, 350, 100, 30);
        add(btnEliminar);
        btnEliminar.addActionListener(e -> eliminarProducto());

        btnIrASegundoFormulario = new JButton("Ir al segundo formulario");
        btnIrASegundoFormulario.setBounds(340, 350, 200, 30);
        add(btnIrASegundoFormulario);
        btnIrASegundoFormulario.addActionListener(e -> {
            new FormularioExtra().setVisible(true);
            this.setVisible(false);
        });
    }

    private void agregarProducto() {
        String codigo = txtCodigo.getText();
        String nombre = txtNombre.getText();
        double precio = Double.parseDouble(txtPrecio.getText());
        int cantidad = Integer.parseInt(txtCantidad.getText());
        double total = precio * cantidad;
        modelo.addRow(new Object[]{codigo, nombre, precio, cantidad, total});
    }

    private void eliminarProducto() {
        int fila = tablaProductos.getSelectedRow();
        if (fila >= 0) {
            modelo.removeRow(fila);
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una fila para eliminar.");
        }
    }

    public static void main(String[] args) {
        new FormularioProductos().setVisible(true);
    }
}