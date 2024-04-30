import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class VentanaPrincipal extends JFrame {
    private List<Registro> registros;

    public VentanaPrincipal() {
        setTitle("Centro CIES");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        registros = new ArrayList<>();
        
        JButton ProgramaInvestigacionButton = new JButton("Programa Investigacion");
        JButton ProgramaInnovacionButton = new JButton("Programa Innovacion");
        JButton ProgramaDesarrolloTecnologicoButton = new JButton("Programa Desarrollo Tecnologico");
        
        ProgramaInvestigacionButton.addActionListener(e -> mostrarFormulario(new ProgramaInvestigacion(this)));
        ProgramaInnovacionButton.addActionListener(e -> mostrarFormulario(new ProgramaInnovacion(this)));
        ProgramaDesarrolloTecnologicoButton.addActionListener(e -> mostrarFormulario(new ProgramaDesarrolloTecnologico(this)));
        

        JPanel panel = new JPanel(new GridLayout(3, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(40, 50, 10, 50));
        
        panel.add(ProgramaInvestigacionButton);
        panel.add(ProgramaInnovacionButton);
        panel.add(ProgramaDesarrolloTecnologicoButton);
        
        add(panel);

        setVisible(true);
    }

    private void mostrarFormulario(JFrame formulario) {
        setVisible(false);
        formulario.setVisible(true);
    }

    private void mostrarRegistrados() {
        if (registros.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay registros.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (Registro registro : registros) {
            sb.append("Nombre: ").append(registro.getNombre()).append(", Apellido: ").append(registro.getApellido())
                    .append("\n");
        }

        JOptionPane.showMessageDialog(this, sb.toString(), "Registros", JOptionPane.INFORMATION_MESSAGE);
    }

    public void agregarRegistro(Registro registro) {
        registros.add(registro);
    }

    public void mostrarEvidencias() {
    Evidencias evidenciasFrame = new Evidencias(this);
    evidenciasFrame.setVisible(true);
}


    public static void main(String[] args) {
        new VentanaPrincipal();
    }
}

class ProgramaInvestigacion extends JFrame {
    private JTextField inputA, inputB, inputC, inputD;
    private JButton registrarButton;
    private JComboBox<String> tipoDocumentoComboBox;
    public ProgramaInvestigacion(VentanaPrincipal ventanaPrincipal) {
        setTitle("Inicio de sesion");
        setSize(500, 350);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        inputA = new JTextField(10);
        inputB = new JTextField(10);
        inputC = new JTextField(10);
        inputD = new JTextField(10);
        
        registrarButton = new JButton("Iniciar Sesion");

        tipoDocumentoComboBox = new JComboBox<>();
        tipoDocumentoComboBox.addItem("Cedula de Ciudadania");
        tipoDocumentoComboBox.addItem("Tarjeta de Identidad");
        tipoDocumentoComboBox.addItem("Cedula de Extranjeria");
        tipoDocumentoComboBox.addItem("Pasaporte");
        

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        panel.add(new JLabel("Nombre: "), gbc);
        gbc.gridx = 1;
        panel.add(inputA, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Ficha: "), gbc);
        gbc.gridx = 1;
        panel.add(inputB, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Tipo de documento de identidad: "), gbc);
        gbc.gridx = 1;
        panel.add(tipoDocumentoComboBox, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Numero de documento de identidad: "), gbc);
        gbc.gridx = 1;
        panel.add(inputC, gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("Contraseña: "), gbc);
        gbc.gridx = 1;
        panel.add(inputD, gbc);
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        panel.add(registrarButton, gbc);

        registrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = inputA.getText();
                String apellido = inputB.getText();
                String numeroDocumento = inputC.getText(); // Capturar número de documento
                String numeroFicha = inputD.getText(); // Capturar número de ficha
        
                Registro registro = new Registro(nombre, apellido, numeroDocumento, numeroFicha);
                ventanaPrincipal.agregarRegistro(registro);
                JOptionPane.showMessageDialog(null, "Inicio de sesión exitosamente");
                Evidencias evidenciasFrame = new Evidencias(ventanaPrincipal);
                evidenciasFrame.setVisible(true);
        
                dispose();
            }
        });
        

        setLayout(new BorderLayout());
        add(panel, BorderLayout.NORTH);
    }
}

class ProgramaInnovacion extends JFrame {
    private JTextField inputA, inputB, inputC, inputD;
    private JButton registrarButton;
    private JComboBox<String> tipoDocumentoComboBox;
    public ProgramaInnovacion(VentanaPrincipal ventanaPrincipal) {
        setTitle("Inicio de sesion");
        setSize(500, 350);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        inputA = new JTextField(10);
        inputB = new JTextField(10);
        inputC = new JTextField(10);
        inputD = new JTextField(10);
        
        registrarButton = new JButton("Iniciar Sesion");

        tipoDocumentoComboBox = new JComboBox<>();
        tipoDocumentoComboBox.addItem("Cedula de Ciudadania");
        tipoDocumentoComboBox.addItem("Tarjeta de Identidad");
        tipoDocumentoComboBox.addItem("Cedula de Extranjeria");
        tipoDocumentoComboBox.addItem("Pasaporte");
        

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        panel.add(new JLabel("Nombre: "), gbc);
        gbc.gridx = 1;
        panel.add(inputA, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Ficha: "), gbc);
        gbc.gridx = 1;
        panel.add(inputB, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Tipo de documento de identidad: "), gbc);
        gbc.gridx = 1;
        panel.add(tipoDocumentoComboBox, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Numero de documento de identidad: "), gbc);
        gbc.gridx = 1;
        panel.add(inputC, gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("Contraseña: "), gbc);
        gbc.gridx = 1;
        panel.add(inputD, gbc);
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        panel.add(registrarButton, gbc);

        registrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = inputA.getText();
                String apellido = inputB.getText();
                String numeroDocumento = inputC.getText(); // Capturar número de documento
                String numeroFicha = inputD.getText(); // Capturar número de ficha
        
                Registro registro = new Registro(nombre, apellido, numeroDocumento, numeroFicha);
                ventanaPrincipal.agregarRegistro(registro);
                JOptionPane.showMessageDialog(null, "Inicio de sesión exitosamente");
                Evidencias evidenciasFrame = new Evidencias(ventanaPrincipal);
                evidenciasFrame.setVisible(true);
        
                dispose();
            }
        });
        

        setLayout(new BorderLayout());
        add(panel, BorderLayout.NORTH);
    }
}

class Evidencias extends JFrame {
    private JLabel evidenciasLabel;

    public Evidencias(VentanaPrincipal ventanaPrincipal) {
        setTitle("Evidencias");
        setSize(500, 350);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton subirEvidenciaButton = new JButton("Subir Evidencia");
        subirEvidenciaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos de imagen", "jpg", "jpeg", "png"));
                int resultado = fileChooser.showOpenDialog(Evidencias.this);
                if (resultado == JFileChooser.APPROVE_OPTION) {
                    String nombreArchivo = fileChooser.getSelectedFile().getName();
                    evidenciasLabel.setText("Archivo seleccionado: " + nombreArchivo);
                }
            }
        });

        evidenciasLabel = new JLabel("Seleccione un archivo...");

        JPanel panel = new JPanel();
        panel.add(subirEvidenciaButton);
        panel.add(evidenciasLabel);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
    }
}

class ProgramaDesarrolloTecnologico extends JFrame {
    private JTextField inputA, inputB, inputC, inputD;
    private JButton registrarButton;
    private JComboBox<String> tipoDocumentoComboBox;
    public ProgramaDesarrolloTecnologico(VentanaPrincipal ventanaPrincipal) {
        setTitle("Inicio de sesion");
        setSize(500, 350);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        inputA = new JTextField(10);
        inputB = new JTextField(10);
        inputC = new JTextField(10);
        inputD = new JTextField(10);
        
        registrarButton = new JButton("Iniciar Sesion");

        tipoDocumentoComboBox = new JComboBox<>();
        tipoDocumentoComboBox.addItem("Cedula de Ciudadania");
        tipoDocumentoComboBox.addItem("Tarjeta de Identidad");
        tipoDocumentoComboBox.addItem("Cedula de Extranjeria");
        tipoDocumentoComboBox.addItem("Pasaporte");
        

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        panel.add(new JLabel("Nombre: "), gbc);
        gbc.gridx = 1;
        panel.add(inputA, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Ficha: "), gbc);
        gbc.gridx = 1;
        panel.add(inputB, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Tipo de documento de identidad: "), gbc);
        gbc.gridx = 1;
        panel.add(tipoDocumentoComboBox, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Numero de documento de identidad: "), gbc);
        gbc.gridx = 1;
        panel.add(inputC, gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("Contraseña: "), gbc);
        gbc.gridx = 1;
        panel.add(inputD, gbc);
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        panel.add(registrarButton, gbc);

        registrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = inputA.getText();
                String apellido = inputB.getText();
                String numeroDocumento = inputC.getText(); // Capturar número de documento
                String numeroFicha = inputD.getText(); // Capturar número de ficha
        
                Registro registro = new Registro(nombre, apellido, numeroDocumento, numeroFicha);
                ventanaPrincipal.agregarRegistro(registro);
                JOptionPane.showMessageDialog(null, "Inicio de sesión exitosamente");
                Evidencias evidenciasFrame = new Evidencias(ventanaPrincipal);
                evidenciasFrame.setVisible(true);
        
                dispose();
            }
        });
        

        setLayout(new BorderLayout());
        add(panel, BorderLayout.NORTH);
    }
}

class Registro {
    private String nombre;
    private String apellido;
    private String numeroDocumento;
    private String numeroFicha;

    public Registro(String nombre, String apellido, String numeroDocumento, String numeroFicha) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroDocumento = numeroDocumento;
        this.numeroFicha = numeroFicha;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public String getNumeroFicha() {
        return numeroFicha;
    }
}

