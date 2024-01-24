import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class form2 {
    public JPanel pantalla;
    private JTextArea textArea;
    private JMenuBar menuBar;
    private JMenu archivo;
    private JMenu Sesion;
    private JMenuItem abrirArchivo;
    private JMenuItem cerrarArchivo;
    private JMenuItem cerrarSesion;
    private JScrollPane scrollPane;
    private JTable table1;

    public form2() {
        abrirArchivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT","txt");
                fileChooser.setFileFilter(filtro);
                int resultado = fileChooser.showDialog(null,"Abrir");
                if (resultado==JFileChooser.APPROVE_OPTION){
                    File fichero = fileChooser.getSelectedFile();
                    String text=fichero.getAbsolutePath();
                    textArea.setText(text);
                    try (FileReader fr = new FileReader(fichero)){
                        String cadena = "";
                        int valor = fr.read();
                        while (valor != -1){
                            cadena = cadena + (char) valor;
                            valor = fr.read();
                        }
                        textArea.setText(cadena);
                    }catch (IOException ex){
                        System.out.println(ex.getMessage());;
                    }
                }
            }
        });
        cerrarArchivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });
        cerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.setContentPane(new form1().inicio);
                Main.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Main.frame.setSize(400,400);
                Main.frame.setVisible(true);
                form1.frame2.dispose();
            }
        });
        table1.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
            }
        });
    }
}
