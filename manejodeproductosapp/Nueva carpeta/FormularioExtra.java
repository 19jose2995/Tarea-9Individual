package manejodeproductosapp;

import javax.swing.*;

public class FormularioExtra extends JFrame {
    private JButton btnVolver;

    public FormularioExtra() {
        setTitle("Formulario Extra");
        setLayout(null);
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel lbl = new JLabel("Este es el segundo formulario.");
        lbl.setBounds(100, 50, 250, 20);
        add(lbl);

        btnVolver = new JButton("Volver");
        btnVolver.setBounds(150, 100, 100, 30);
        add(btnVolver);
        btnVolver.addActionListener(e -> {
            new FormularioProductos().setVisible(true);
            this.dispose();
        });
    }
}