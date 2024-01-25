import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
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
    private JComboBox comboBox1;
    private JLabel sizeText;
    private JButton mostrarButton;

    public form2() {
        abrirArchivo.addActionListener(new ActionListener() { //Item del menu
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser(); //creacion de un objeto de la clase filechooser
                FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT","txt"); //filtracion de archivos a txt
                fileChooser.setFileFilter(filtro);
                int resultado = fileChooser.showDialog(null,"Abrir"); //muestra el selector de archivos
                if (resultado==JFileChooser.APPROVE_OPTION){ // si el
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

        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getSource()==comboBox1){
                    int seleccionado = comboBox1.getSelectedIndex();
                    if(seleccionado==0){
                        textArea.setFont(new Font("Size10",Font.PLAIN,10));
                    } else if (seleccionado==1) {
                        textArea.setFont(new Font("Size12",Font.PLAIN,12));
                    }else if (seleccionado==2) {
                        textArea.setFont(new Font("Size14",Font.PLAIN,14));
                    }
                }
            }
        });
        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Integrantes");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                JTable table = createTable();
                JScrollPane scrollPane = new JScrollPane(table);
                frame.setLocationRelativeTo(form1.frame2);
                frame.getContentPane().add(scrollPane);
                frame.setSize(200,250);
                frame.setVisible(true);
            }
        });
    }
    public static JTable createTable()
    {
        String[] columnNames = {"Nombre", "Apellido"};
        Object[][] data = {{"Estefanía", "Sanchez"},{"Isaac", "León"},{"Francisco","Caero"}};
        JTable table = new JTable(data, columnNames);
        table.setFillsViewportHeight(true);
        return table;
    }
}
