package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;

public class VentanaLogin extends JFrame implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelCentral;
	private JPanel panelSur;
	private JButton btnFinalizarSimulacion;
	private JPanel panel;
	private JPanel panelColumna1;
	private JPanel panelColumna2;
	private JPanel panelColumna3;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JPanel panel2Columna2;
	private JPanel panel1Columna1;
	private JPanel panel_1;
	private JPanel panel_2;
	private JButton btnLogin;
	private JPanel panel_3;
	private JLabel lblContraseña;
	private JLabel lblUsuario;
	private JTextField textFieldContraseña;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_10;
	private JPanel panel_11;
	private JLabel lblRegNombre;
	private JLabel lblRegUsuario;
	private JTextField textFieldRegNombre;
	private JTextField textFieldRegUsuario;
	private JLabel lblRegContraseña;
	private JTextField textFieldRegContraseña;
	private JPanel panel_12;
	private JPanel panel_13;
	private JPanel panel_14;
	private JPanel panel_15;
	private JPanel panel_16;
	private JPanel panel_17;
	private JButton btnRegistrarse;
	private JPanel panel_18;
	private JPanel panel_19;
	private JPanel panel_20;
	private JLabel lblZona;
	private JTextField textFieldZona;
	private JLabel lblCantPersonas;
	private JTextField textFieldCantpersonas;
	private JPanel panel_22;
	private JPanel panel_23;
	private JPanel panel_24;
	private JRadioButton rdbtnEquipajeBaul;
	private JRadioButton rdbtnMascota;
	private JPanel panel_25;
	private JPanel panel_26;
	private JButton btnSolicitarViaje;
	private JButton btnSolicitarPedido;
	private JPanel panel_21;
	private JPanel panel_27;
	private JPanel panel_28;
	private JPanel panel_29;
	private JLabel lblFecha;
	private JPanel panel_30;
	private JTextField textFieldFecha;
	private JTextField textFieldUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin frame = new VentanaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 412);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		this.panelCentral = new JPanel();
		this.contentPane.add(this.panelCentral, BorderLayout.CENTER);
		this.panelCentral.setLayout(new GridLayout(1, 0, 0, 0));
		
		this.panelColumna1 = new JPanel();
		this.panelColumna1.setBorder(null);
		this.panelCentral.add(this.panelColumna1);
		this.panelColumna1.setLayout(new GridLayout(2, 0, 0, 0));
		
		this.panel1Columna1 = new JPanel();
		this.panel1Columna1.setBorder(new TitledBorder(null, "Login", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panelColumna1.add(this.panel1Columna1);
		this.panel1Columna1.setLayout(new GridLayout(2, 1, 0, 0));
		
		this.panel_1 = new JPanel();
		this.panel1Columna1.add(this.panel_1);
		this.panel_1.setLayout(new GridLayout(2, 2, 0, 0));
		
		this.panel_4 = new JPanel();
		this.panel_1.add(this.panel_4);
		
		this.lblUsuario = new JLabel("Usuario");
		this.panel_4.add(this.lblUsuario);
		
		this.panel_6 = new JPanel();
		this.panel_1.add(this.panel_6);
		
		this.textFieldUsuario = new JTextField();
		this.panel_6.add(this.textFieldUsuario);
		this.textFieldUsuario.setColumns(10);
		
		this.panel_5 = new JPanel();
		this.panel_1.add(this.panel_5);
		
		this.lblContraseña = new JLabel("Contraseña");
		this.panel_5.add(this.lblContraseña);
		
		this.panel_7 = new JPanel();
		this.panel_1.add(this.panel_7);
		
		this.textFieldContraseña = new JTextField();
		this.panel_7.add(this.textFieldContraseña);
		this.textFieldContraseña.setColumns(10);
		
		this.panel_2 = new JPanel();
		this.panel1Columna1.add(this.panel_2);
		
		this.panel_3 = new JPanel();
		this.panel_2.add(this.panel_3);
		
		this.btnLogin = new JButton("Login");
		this.btnLogin.addActionListener(this);
		this.panel_3.add(this.btnLogin);
		
		this.panel2Columna2 = new JPanel();
		this.panel2Columna2.setBorder(new TitledBorder(null, "Registrarse", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panelColumna1.add(this.panel2Columna2);
		this.panel2Columna2.setLayout(new GridLayout(2, 1, 0, 0));
		
		this.panel_11 = new JPanel();
		this.panel2Columna2.add(this.panel_11);
		this.panel_11.setLayout(new GridLayout(3, 2, 0, 0));
		
		this.panel_12 = new JPanel();
		this.panel_11.add(this.panel_12);
		
		this.lblRegNombre = new JLabel("Nombre");
		this.panel_12.add(this.lblRegNombre);
		
		this.panel_13 = new JPanel();
		this.panel_11.add(this.panel_13);
		
		this.textFieldRegNombre = new JTextField();
		this.panel_13.add(this.textFieldRegNombre);
		this.textFieldRegNombre.setColumns(10);
		
		this.panel_14 = new JPanel();
		this.panel_11.add(this.panel_14);
		
		this.lblRegUsuario = new JLabel("Nombre de Usuario");
		this.panel_14.add(this.lblRegUsuario);
		
		this.panel_15 = new JPanel();
		this.panel_11.add(this.panel_15);
		
		this.textFieldRegUsuario = new JTextField();
		this.panel_15.add(this.textFieldRegUsuario);
		this.textFieldRegUsuario.setColumns(10);
		
		this.panel_16 = new JPanel();
		this.panel_11.add(this.panel_16);
		
		this.lblRegContraseña = new JLabel("Contraseña");
		this.panel_16.add(this.lblRegContraseña);
		
		this.panel_17 = new JPanel();
		this.panel_11.add(this.panel_17);
		
		this.textFieldRegContraseña = new JTextField();
		this.panel_17.add(this.textFieldRegContraseña);
		this.textFieldRegContraseña.setColumns(10);
		
		this.panel_10 = new JPanel();
		this.panel2Columna2.add(this.panel_10);
		
		this.panel_18 = new JPanel();
		this.panel_10.add(this.panel_18);
		
		this.btnRegistrarse = new JButton("Registrarse");
		this.btnRegistrarse.addActionListener(this);
		this.panel_18.add(this.btnRegistrarse);
		
		this.panelColumna2 = new JPanel();
		this.panelColumna2.setBorder(new TitledBorder(null, "Pedido", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panelCentral.add(this.panelColumna2);
		this.panelColumna2.setLayout(new GridLayout(2, 1, 0, 0));
		
		this.panel_9 = new JPanel();
		this.panelColumna2.add(this.panel_9);
		this.panel_9.setLayout(new GridLayout(2, 2, 0, 0));
		
		this.panel_20 = new JPanel();
		this.panel_9.add(this.panel_20);
		this.panel_20.setLayout(new GridLayout(3, 3, 0, 0));
		
		this.panel_22 = new JPanel();
		this.panel_20.add(this.panel_22);
		
		this.panel_30 = new JPanel();
		this.panel_22.add(this.panel_30);
		
		this.lblFecha = new JLabel("Fecha");
		this.panel_30.add(this.lblFecha);
		
		this.panel_23 = new JPanel();
		this.panel_20.add(this.panel_23);
		
		this.textFieldFecha = new JTextField();
		this.panel_23.add(this.textFieldFecha);
		this.textFieldFecha.setColumns(10);
		
		this.panel_21 = new JPanel();
		this.panel_20.add(this.panel_21);
		
		this.panel_24 = new JPanel();
		this.panel_21.add(this.panel_24);
		
		this.lblZona = new JLabel("Zona");
		this.panel_24.add(this.lblZona);
		
		this.panel_27 = new JPanel();
		this.panel_20.add(this.panel_27);
		
		this.textFieldZona = new JTextField();
		this.panel_27.add(this.textFieldZona);
		this.textFieldZona.setColumns(10);
		
		this.panel_28 = new JPanel();
		this.panel_20.add(this.panel_28);
		
		this.lblCantPersonas = new JLabel("CantPersonas");
		this.panel_28.add(this.lblCantPersonas);
		
		this.panel_29 = new JPanel();
		this.panel_20.add(this.panel_29);
		
		this.textFieldCantpersonas = new JTextField();
		this.panel_29.add(this.textFieldCantpersonas);
		this.textFieldCantpersonas.setColumns(10);
		
		this.panel_19 = new JPanel();
		this.panel_9.add(this.panel_19);
		this.panel_19.setLayout(new GridLayout(2, 1, 0, 0));
		
		this.rdbtnMascota = new JRadioButton("Mascota");
		this.panel_19.add(this.rdbtnMascota);
		
		this.rdbtnEquipajeBaul = new JRadioButton("EquipajeBaul");
		this.panel_19.add(this.rdbtnEquipajeBaul);
		
		this.panel_8 = new JPanel();
		this.panelColumna2.add(this.panel_8);
		this.panel_8.setLayout(new GridLayout(2, 1, 0, 0));
		
		this.panel_25 = new JPanel();
		this.panel_8.add(this.panel_25);
		this.panel_25.setLayout(new GridLayout(2, 1, 0, 0));
		
		this.btnSolicitarPedido = new JButton("Solicitar Pedido");
		this.btnSolicitarPedido.addActionListener(this);
		this.panel_25.add(this.btnSolicitarPedido);
		
		this.btnSolicitarViaje = new JButton("Solicitar Viaje");
		this.btnSolicitarViaje.addActionListener(this);
		this.panel_25.add(this.btnSolicitarViaje);
		
		this.panel_26 = new JPanel();
		this.panel_8.add(this.panel_26);
		
		this.panelColumna3 = new JPanel();
		this.panelColumna3.setBorder(new TitledBorder(null, "Estado del Viaje", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panelCentral.add(this.panelColumna3);
		this.panelColumna3.setLayout(new BorderLayout(0, 0));
		
		this.scrollPane = new JScrollPane();
		this.panelColumna3.add(this.scrollPane, BorderLayout.CENTER);
		
		this.textArea = new JTextArea();
		this.scrollPane.setViewportView(this.textArea);
		
		this.panelSur = new JPanel();
		this.contentPane.add(this.panelSur, BorderLayout.SOUTH);
		this.panelSur.setLayout(new GridLayout(1, 0, 0, 0));
		
		this.panel = new JPanel();
		this.panelSur.add(this.panel);
		
		this.btnFinalizarSimulacion = new JButton("Finalizar Pedidos");
		this.btnFinalizarSimulacion.addActionListener(this);
		this.panel.add(this.btnFinalizarSimulacion);
	}

	public void actionPerformed(ActionEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
