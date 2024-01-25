import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class form1 {
    private JPasswordField passwordField;
    private JTextField usuarioField;
    public JPanel inicio;
    private JButton INGRESARButton;
    static JFrame frame2 = new JFrame("Pantalla");
    public form1() {
        INGRESARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario="Admin";
                String pass="admin";
                if (usuarioField.getText().equals(usuario)&&String.valueOf(passwordField.getPassword()).equals(pass)){
                    frame2.setContentPane(new form2().pantalla);
                    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame2.setLocationRelativeTo(Main.frame);
                    frame2.setSize(400,400);
                    frame2.setVisible(true);
                    Main.frame.dispose();
                }else {
                    JOptionPane.showMessageDialog(null,"Ingrese las credenciales correctas!");
                }
            }
        });
    }
}
