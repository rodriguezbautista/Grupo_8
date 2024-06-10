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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;

public class VentanaLogin extends JFrame implements KeyListener, IVista{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelCentral;
	private JPanel panelSur;
	private JButton btnFinalizarPedidos;
	private JPanel panel;
	private JPanel panelColumna2;
	private JPanel panelColumna3;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_19;
	private JPanel panel_20;
	private JLabel lblCantPersonas;
	private JTextField textFieldCantpersonas;
	private JPanel panel_25;
	private JButton btnSolicitarViaje;
	private JPanel panelLogeo;
	private JPanel panel1Columna1;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblUsuario;
	private JPanel panel_3;
	private JTextField textFieldLoginUsuario;
	private JPanel panel_4;
	private JLabel lblContraseña;
	private JPanel panel_5;
	private JTextField textFieldLoginContras;
	private JPanel panel_6;
	private JPanel panel_7;
	private JButton btnLogin;
	private JPanel panel2Columna2;
	private JPanel panel_10;
	private JPanel panel_11;
	private JLabel lblRegNombre;
	private JPanel panel_12;
	private JTextField textFieldRgeistNbre;
	private JPanel panel_13;
	private JLabel lblRegUsuario;
	private JPanel panel_14;
	private JTextField textFieldRegistUsuario;
	private JPanel panel_15;
	private JLabel lblRegContraseña;
	private JPanel panel_16;
	private JTextField textFieldRegistContras;
	private JPanel panel_17;
	private JPanel panel_18;
	private JButton btnRegistrarse;
	private JPanel panel_29;
	private JPanel panel_28;
	private JPanel panel_27;
	private JPanel panel_21;
	private JLabel lblZona;
	private JRadioButton estandar;
	private JRadioButton sinasfaltar;
	private JRadioButton peligrosa;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel panel_22;
	private JPanel panel_23;
	private JCheckBox llevaMascota;
	private JCheckBox usaBaul;
	private JPanel panelPagar;
	private JButton btnPagarViaje;
	private JButton persistir;
	

	/**
	 * Create the frame.
	 */
	public VentanaLogin() {
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		JFrame ventana = this;
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ventana.setVisible(false);
                persistir.doClick(); 
                ventana.dispose();
            }
        });
        
        //boton invisible para persistir al cerrar la ventana
        persistir = new JButton("Persistir");
        
		setBounds(100, 100, 800, 600);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		this.panelCentral = new JPanel();
		this.contentPane.add(this.panelCentral, BorderLayout.CENTER);
		this.panelCentral.setLayout(new GridLayout(1, 0, 0, 0));
		
		this.panelColumna2 = new JPanel();
		this.panelColumna2.setBorder(new TitledBorder(null, "Pedido", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panelCentral.add(this.panelColumna2);
		panelColumna2.setLayout(new BoxLayout(panelColumna2, BoxLayout.Y_AXIS));
		
		this.panel_9 = new JPanel();
		panel_9.setMaximumSize(new Dimension(32767, 120));
		this.panelColumna2.add(this.panel_9);
		panel_9.setLayout(new BoxLayout(panel_9, BoxLayout.Y_AXIS));
		
		this.panel_20 = new JPanel();
		this.panel_9.add(this.panel_20);
		panel_20.setLayout(new BoxLayout(panel_20, BoxLayout.Y_AXIS));
		
		panel_22 = new JPanel();
		panel_20.add(panel_22);
		panel_22.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.panel_21 = new JPanel();
		panel_22.add(panel_21);
		FlowLayout flowLayout = (FlowLayout) panel_21.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		
		lblZona = new JLabel("Zona");
		panel_21.add(lblZona);
		
		this.panel_27 = new JPanel();
		panel_22.add(panel_27);
		panel_27.setLayout(new BoxLayout(panel_27, BoxLayout.Y_AXIS));
		
		estandar = new JRadioButton("Estandar");
		estandar.setActionCommand("Estandar");
		buttonGroup.add(estandar);
		panel_27.add(estandar);
		
		sinasfaltar = new JRadioButton("Sin asfaltar");
		sinasfaltar.setActionCommand("Calle sin asfaltar");
		buttonGroup.add(sinasfaltar);
		panel_27.add(sinasfaltar);
		
		peligrosa = new JRadioButton("Peligrosa");
		peligrosa.setActionCommand("Zona Peligrosa");
		buttonGroup.add(peligrosa);
		panel_27.add(peligrosa);
		
		panel_23 = new JPanel();
		panel_20.add(panel_23);
		panel_23.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.panel_28 = new JPanel();
		panel_23.add(panel_28);
		FlowLayout flowLayout_1 = (FlowLayout) panel_28.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		
		this.lblCantPersonas = new JLabel("CantPersonas");
		this.panel_28.add(this.lblCantPersonas);
		
		this.panel_29 = new JPanel();
		panel_23.add(panel_29);
		
		this.textFieldCantpersonas = new JTextField();
		this.panel_29.add(this.textFieldCantpersonas);
		this.textFieldCantpersonas.setColumns(15);
		this.textFieldCantpersonas.addKeyListener(this);
		
		this.panel_19 = new JPanel();
		panel_19.setMinimumSize(new Dimension(0, 0));
		this.panel_9.add(this.panel_19);
		panel_19.setLayout(new BoxLayout(panel_19, BoxLayout.Y_AXIS));
		
		llevaMascota = new JCheckBox("Con mascota");
		panel_19.add(llevaMascota);
		
		usaBaul = new JCheckBox("Equipaje en baul");
		panel_19.add(usaBaul);
		
		this.panel_8 = new JPanel();
		this.panelColumna2.add(this.panel_8);
		panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.Y_AXIS));

		this.panel_25 = new JPanel();
		this.panel_8.add(this.panel_25);
		
		this.btnSolicitarViaje = new JButton("Solicitar Viaje");
		panel_25.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		this.panel_25.add(this.btnSolicitarViaje);

		this.panelPagar = new JPanel();
		this.panel_8.add(this.panelPagar);
		
		this.btnPagarViaje = new JButton("Pagar Viaje");
		panelPagar.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		this.panelPagar.add(this.btnPagarViaje);
		
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
		
		this.btnFinalizarPedidos = new JButton("Finalizar Pedidos");
		this.panel.add(this.btnFinalizarPedidos);
		
		panelLogeo = new JPanel();
		panelLogeo.setBorder(null);
		contentPane.add(panelLogeo, BorderLayout.NORTH);
		panelLogeo.setLayout(new BoxLayout(panelLogeo, BoxLayout.Y_AXIS));
		
		panel1Columna1 = new JPanel();
		panel1Columna1.setBorder(new TitledBorder(null, "Login", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelLogeo.add(panel1Columna1);
		panel1Columna1.setLayout(new BoxLayout(panel1Columna1, BoxLayout.Y_AXIS));
		
		panel_1 = new JPanel();
		panel1Columna1.add(panel_1);
		panel_1.setLayout(new GridLayout(2, 2, 0, 0));
		
		panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		lblUsuario = new JLabel("Usuario");
		panel_2.add(lblUsuario);
		
		panel_3 = new JPanel();
		panel_1.add(panel_3);
		
		textFieldLoginUsuario = new JTextField();
		textFieldLoginUsuario.setColumns(10);
		panel_3.add(textFieldLoginUsuario);
		
		panel_4 = new JPanel();
		panel_1.add(panel_4);
		
		lblContraseña = new JLabel("Contraseña");
		panel_4.add(lblContraseña);
		
		panel_5 = new JPanel();
		panel_1.add(panel_5);
		
		textFieldLoginContras = new JTextField();
		textFieldLoginContras.setColumns(10);
		panel_5.add(textFieldLoginContras);
		
		panel_6 = new JPanel();
		panel1Columna1.add(panel_6);
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panel_7 = new JPanel();
		panel_6.add(panel_7);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.X_AXIS));
		
		btnLogin = new JButton("Login");
		panel_7.add(btnLogin);
		
		panel2Columna2 = new JPanel();
		panel2Columna2.setBorder(new TitledBorder(null, "Registrarse", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelLogeo.add(panel2Columna2);
		panel2Columna2.setLayout(new BoxLayout(panel2Columna2, BoxLayout.Y_AXIS));
		
		panel_10 = new JPanel();
		panel2Columna2.add(panel_10);
		panel_10.setLayout(new GridLayout(3, 2, 0, 0));
		
		panel_11 = new JPanel();
		panel_10.add(panel_11);
		
		lblRegNombre = new JLabel("Nombre");
		panel_11.add(lblRegNombre);
		
		panel_12 = new JPanel();
		panel_10.add(panel_12);
		
		textFieldRgeistNbre = new JTextField();
		textFieldRgeistNbre.setColumns(10);
		panel_12.add(textFieldRgeistNbre);
		
		panel_13 = new JPanel();
		panel_10.add(panel_13);
		
		lblRegUsuario = new JLabel("Usuario");
		panel_13.add(lblRegUsuario);
		
		panel_14 = new JPanel();
		panel_10.add(panel_14);
		
		textFieldRegistUsuario = new JTextField();
		textFieldRegistUsuario.setColumns(10);
		panel_14.add(textFieldRegistUsuario);
		
		panel_15 = new JPanel();
		panel_10.add(panel_15);
		
		lblRegContraseña = new JLabel("Contraseña");
		panel_15.add(lblRegContraseña);
		
		panel_16 = new JPanel();
		panel_10.add(panel_16);
		
		textFieldRegistContras = new JTextField();
		textFieldRegistContras.setColumns(10);
		panel_16.add(textFieldRegistContras);
		
		panel_17 = new JPanel();
		panel2Columna2.add(panel_17);
		
		panel_18 = new JPanel();
		panel_17.add(panel_18);
		
		btnRegistrarse = new JButton("Registrarse");
		panel_18.add(btnRegistrarse);
		
		this.estandar.setSelected(true);
		
		//aparte
		this.btnSolicitarViaje.setEnabled(false);
		this.btnLogin.setEnabled(false);
		this.btnRegistrarse.setEnabled(false);
		this.btnFinalizarPedidos.setEnabled(false);
		this.textFieldLoginUsuario.addKeyListener(this);
		this.textFieldLoginContras.addKeyListener(this);
		this.textFieldRgeistNbre.addKeyListener(this);
		this.textFieldRegistUsuario.addKeyListener(this);
		this.textFieldRegistContras.addKeyListener(this);
		this.panelSur.setVisible(false);
		this.panelCentral.setVisible(false);
		this.panelLogeo.setVisible(false);
	}

	
	public void limpiarCamposPedido() {
		this.estandar.setSelected(true);
		this.sinasfaltar.setSelected(false);
		this.peligrosa.setSelected(false);
		this.textFieldCantpersonas.setText("");
		this.usaBaul.setSelected(false);
		this.llevaMascota.setSelected(false);
		this.btnSolicitarViaje.setEnabled(false);
	}
	
	public void limpiarCamposRegistrarse() {
		this.textFieldRgeistNbre.setText("");
		this.textFieldRegistUsuario.setText("");
		this.textFieldRegistContras.setText("");
		this.btnRegistrarse.setEnabled(false);
	}
	
	public void limpiarCamposLogin() {
		this.textFieldLoginUsuario.setText("");
		this.textFieldLoginContras.setText("");
		this.btnLogin.setEnabled(false);
	}
	
	public void habilitarPanelLogin(boolean b) {
		this.panelLogeo.setVisible(b);
	}
	
	public void habilitarPanelPedidos(boolean b) {
		this.panelCentral.setVisible(b);
		this.panelSur.setVisible(b);
	}
	
	public void habilitarBtnFinalizarPedidos(boolean b) {
		this.btnFinalizarPedidos.setEnabled(b);
	}
	
	public void appendLog(String mensaje) {
		this.textArea.append(mensaje + "\n");
	}
	
	public void deshabilitarBotones() {
		this.btnSolicitarViaje.setEnabled(false);
		this.btnRegistrarse.setEnabled(false);
		this.btnLogin.setEnabled(false);
		this.textFieldRgeistNbre.setEditable(false);
		this.textFieldRegistUsuario.setEditable(false);
		this.textFieldRegistContras.setEditable(false);
		this.textFieldLoginUsuario.setEditable(false);
		this.textFieldLoginContras.setEditable(false);
		this.peligrosa.setEnabled(false);
		this.sinasfaltar.setEnabled(false);
		this.estandar.setEnabled(false);
		this.textFieldCantpersonas.setEditable(false);
		this.llevaMascota.setEnabled(false);
		this.usaBaul.setEnabled(false);
		this.btnPagarViaje.setEnabled(false);
		this.btnFinalizarPedidos.setEnabled(false);
	}
	
	public void setActionListener(ActionListener actionlistener) {
		this.btnFinalizarPedidos.addActionListener(actionlistener);
		this.btnSolicitarViaje.addActionListener(actionlistener);
		this.btnPagarViaje.addActionListener(actionlistener);
		this.btnLogin.addActionListener(actionlistener);
		this.btnRegistrarse.addActionListener(actionlistener);
		this.persistir.addActionListener(actionlistener);
	}
	
	public void popup(String info) {
		JOptionPane.showMessageDialog(this, info, "Error", JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Integer cantPersonas = null;
		try {			
			cantPersonas = Integer.parseInt(this.textFieldCantpersonas.getText());
		}catch(NumberFormatException nfe){
		}
		boolean enabledbtnSolicitarViaje = !(this.textFieldCantpersonas.getText().isEmpty() || cantPersonas == null || cantPersonas < 1) ;
		this.btnSolicitarViaje.setEnabled(enabledbtnSolicitarViaje);
		boolean enabledbtnLogin = !(this.textFieldLoginUsuario.getText().isEmpty()) && !(this.textFieldLoginContras.getText().isEmpty());
		this.btnLogin.setEnabled(enabledbtnLogin);
		boolean enabledbtnRegist = !(this.textFieldRgeistNbre.getText().isEmpty()) && !(this.textFieldRegistUsuario.getText().isEmpty()) && !(this.textFieldRegistContras.getText().isEmpty());
		this.btnRegistrarse.setEnabled(enabledbtnRegist);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public int getCantidadPersonas() {
		return Integer.parseInt(this.textFieldCantpersonas.getText());
	}

	public boolean getUsaBaul() {
		return this.usaBaul.isSelected();
	}

	public boolean getLlevaMascota() {
		return this.llevaMascota.isSelected();
	}

	public String getZona() {
		return this.buttonGroup.getSelection().getActionCommand();
	}

	public String getNombreRegistrado() {
		return this.textFieldRgeistNbre.getText();
	}

	public String getUsuarioRegistrado() {
		return this.textFieldRegistUsuario.getText();
	}

	public String getContraseniaRegistrado() {
		return this.textFieldRegistContras.getText();
	}

	public String getUsuarioLogeado() {
		return this.textFieldLoginUsuario.getText();
	}

	public String getContraseniaLogeado() {
		return this.textFieldLoginContras.getText();
	}
}
