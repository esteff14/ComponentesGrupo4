import javax.swing.*;
import java.awt.*;

public class Main {
    static JFrame frame = new JFrame("Inicio de Sesion"); //Se crea un objeto
    public static void main(String[] args) {
        frame.setContentPane(new form1().inicio);// creacion de un objeto en el panel de contenido del frame inicio
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // centrar la ventana
        frame.getContentPane().setBackground(Color.LIGHT_GRAY); //color al fondo de la ventana
        frame.setSize(400,400);
        frame.setVisible(true);
    }
}