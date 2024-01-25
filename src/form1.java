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
        INGRESARButton.addActionListener(new ActionListener() { //
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario="Admin"; // Datos quemados para el inicio de sesion
                String pass="admin";
                if (usuarioField.getText().equals(usuario)&&String.valueOf(passwordField.getPassword()).equals(pass)){ //se compara con los datos quemados para poder
                    // ingresar si coincide podrá acceder a la siguiente pantalla
                    frame2.setContentPane(new form2().pantalla); //se crea un objeto de la clase form2
                    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // se establece para el cierre de pantalla
                    frame2.setLocationRelativeTo(Main.frame); //se establece el posicionamiento de la pantalla al emerger
                    //en este caso cerca del frame (inicio)
                    frame2.setSize(400,400); //tamaño de la pantalla
                    frame2.setVisible(true); //hace que la pantalla sea visible
                    Main.frame.dispose();
                }else {
                    JOptionPane.showMessageDialog(null,"Ingrese las credenciales correctas!");
                    //si las credenciales no son correctas enviará un mensaje de advertencia
                }
            }
        });
    }
}
