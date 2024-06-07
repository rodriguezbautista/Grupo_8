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
	private JPanel panelColumna2;
	private JPanel panelColumna3;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JPanel panel_8;
	private JPanel panel_9;
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
	private JPanel panelLogeo;
	private JPanel panel1Columna1;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblUsuario;
	private JPanel panel_3;
	private JTextField textField;
	private JPanel panel_4;
	private JLabel lblContraseña;
	private JPanel panel_5;
	private JTextField textField_1;
	private JPanel panel_6;
	private JPanel panel_7;
	private JButton btnLogin;
	private JPanel panel2Columna2;
	private JPanel panel_10;
	private JPanel panel_11;
	private JLabel lblRegNombre;
	private JPanel panel_12;
	private JTextField textField_2;
	private JPanel panel_13;
	private JLabel lblRegUsuario;
	private JPanel panel_14;
	private JTextField textField_3;
	private JPanel panel_15;
	private JLabel lblRegContraseña;
	private JPanel panel_16;
	private JTextField textField_4;
	private JPanel panel_17;
	private JPanel panel_18;
	private JButton btnRegistrarse;
	private JPanel panel_29;
	private JPanel panel_28;
	private JPanel panel_27;
	private JPanel panel_21;
	private JPanel panel_30;

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
		this.panelCentral.setVisible(false);
		this.contentPane.add(this.panelCentral, BorderLayout.CENTER);
		this.panelCentral.setLayout(new GridLayout(1, 0, 0, 0));
		
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
		this.panelSur.setVisible(false);
		this.contentPane.add(this.panelSur, BorderLayout.SOUTH);
		this.panelSur.setLayout(new GridLayout(1, 0, 0, 0));
		
		this.panel = new JPanel();
		this.panelSur.add(this.panel);
		
		this.btnFinalizarSimulacion = new JButton("Finalizar Pedidos");
		this.btnFinalizarSimulacion.addActionListener(this);
		this.panel.add(this.btnFinalizarSimulacion);
		
		panelLogeo = new JPanel();
		panelLogeo.setBorder(null);
		contentPane.add(panelLogeo, BorderLayout.NORTH);
		panelLogeo.setLayout(new GridLayout(2, 0, 0, 0));
		
		panel1Columna1 = new JPanel();
		panel1Columna1.setBorder(new TitledBorder(null, "Login", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelLogeo.add(panel1Columna1);
		panel1Columna1.setLayout(new GridLayout(2, 1, 0, 0));
		
		panel_1 = new JPanel();
		panel1Columna1.add(panel_1);
		panel_1.setLayout(new GridLayout(2, 2, 0, 0));
		
		panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		lblUsuario = new JLabel("Usuario");
		panel_2.add(lblUsuario);
		
		panel_3 = new JPanel();
		panel_1.add(panel_3);
		
		textField = new JTextField();
		textField.setColumns(10);
		panel_3.add(textField);
		
		panel_4 = new JPanel();
		panel_1.add(panel_4);
		
		lblContraseña = new JLabel("Contraseña");
		panel_4.add(lblContraseña);
		
		panel_5 = new JPanel();
		panel_1.add(panel_5);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel_5.add(textField_1);
		
		panel_6 = new JPanel();
		panel1Columna1.add(panel_6);
		
		panel_7 = new JPanel();
		panel_6.add(panel_7);
		
		btnLogin = new JButton("Login");
		panel_7.add(btnLogin);
		
		panel2Columna2 = new JPanel();
		panel2Columna2.setBorder(new TitledBorder(null, "Registrarse", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelLogeo.add(panel2Columna2);
		panel2Columna2.setLayout(new GridLayout(2, 1, 0, 0));
		
		panel_10 = new JPanel();
		panel2Columna2.add(panel_10);
		panel_10.setLayout(new GridLayout(3, 2, 0, 0));
		
		panel_11 = new JPanel();
		panel_10.add(panel_11);
		
		lblRegNombre = new JLabel("Nombre");
		panel_11.add(lblRegNombre);
		
		panel_12 = new JPanel();
		panel_10.add(panel_12);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		panel_12.add(textField_2);
		
		panel_13 = new JPanel();
		panel_10.add(panel_13);
		
		lblRegUsuario = new JLabel("Usuario");
		panel_13.add(lblRegUsuario);
		
		panel_14 = new JPanel();
		panel_10.add(panel_14);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		panel_14.add(textField_3);
		
		panel_15 = new JPanel();
		panel_10.add(panel_15);
		
		lblRegContraseña = new JLabel("Contraseña");
		panel_15.add(lblRegContraseña);
		
		panel_16 = new JPanel();
		panel_10.add(panel_16);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		panel_16.add(textField_4);
		
		panel_17 = new JPanel();
		panel2Columna2.add(panel_17);
		
		panel_18 = new JPanel();
		panel_17.add(panel_18);
		
		btnRegistrarse = new JButton("Registrarse");
		panel_18.add(btnRegistrarse);
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
