package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JRadioButton;
import javax.swing.border.BevelBorder;
import javax.swing.ButtonGroup;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaConfiguracionSimulacion extends JFrame implements KeyListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelCentral;
	private JPanel panelSur;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel panelCentralIzq;
	private JPanel panelCentralDer;
	private JRadioButton rdbtnConfigurar;
	private JRadioButton rdbtnUsarConfig;
	private JPanel panelCentralDerInterior;
	private JLabel lblCantChoferes;
	private JTextField textFieldCantChoferes;
	private JLabel lblCantClientes;
	private JTextField textFieldCantClientes;
	private JLabel lblCantViajesChofer;
	private JTextField textFieldCantMAxViajesChofer;
	private JLabel lblCantpedidosClientes;
	private JTextField textFieldCantPedidosClientes;
	private JLabel lblCantAutos;
	private JTextField textFieldCantAucot;
	private JLabel lblCantCombis;
	private JTextField textFieldCantCombis;
	private JLabel lblCantMotos;
	private JTextField textFieldCantMotos;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_10;
	private JPanel panel_11;
	private JPanel panel_12;
	private JPanel panel_13;
	private JPanel panelSurInterno;
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaConfiguracionSimulacion frame = new VentanaConfiguracionSimulacion();
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
	public VentanaConfiguracionSimulacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		this.panelCentral = new JPanel();
		this.panelCentral.setBorder(new TitledBorder(null, "Configuracion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.contentPane.add(this.panelCentral, BorderLayout.CENTER);
		this.panelCentral.setLayout(new GridLayout(1, 2, 0, 0));
		
		this.panelCentralIzq = new JPanel();
		this.panelCentral.add(this.panelCentralIzq);
		this.panelCentralIzq.setLayout(new GridLayout(2, 1, 0, 0));
		
		this.rdbtnUsarConfig = new JRadioButton("Usar Configuracion Existente");
		buttonGroup.add(this.rdbtnUsarConfig);
		this.panelCentralIzq.add(this.rdbtnUsarConfig);
		
		this.rdbtnConfigurar = new JRadioButton("Configurar Simulacion");
		buttonGroup.add(this.rdbtnConfigurar);
		this.panelCentralIzq.add(this.rdbtnConfigurar);
		
		this.panelCentralDer = new JPanel();
		this.panelCentralDer.setBorder(new TitledBorder(null, "Configurar Simulacion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panelCentral.add(this.panelCentralDer);
		this.panelCentralDer.setLayout(new BorderLayout(0, 0));
		
		this.panelCentralDerInterior = new JPanel();
		this.panelCentralDer.add(this.panelCentralDerInterior, BorderLayout.CENTER);
		this.panelCentralDerInterior.setLayout(new GridLayout(7, 2, 0, 0));
		
		this.panel = new JPanel();
		this.panelCentralDerInterior.add(this.panel);
		
		this.lblCantChoferes = new JLabel("Cantidad de Choferes");
		this.panel.add(this.lblCantChoferes);
		
		this.panel_1 = new JPanel();
		this.panelCentralDerInterior.add(this.panel_1);
		
		this.textFieldCantChoferes = new JTextField();
		this.panel_1.add(this.textFieldCantChoferes);
		this.textFieldCantChoferes.setColumns(10);
		
		this.panel_2 = new JPanel();
		this.panelCentralDerInterior.add(this.panel_2);
		
		this.lblCantClientes = new JLabel("Cantidad de Clientes");
		this.panel_2.add(this.lblCantClientes);
		
		this.panel_3 = new JPanel();
		this.panelCentralDerInterior.add(this.panel_3);
		
		this.textFieldCantClientes = new JTextField();
		this.panel_3.add(this.textFieldCantClientes);
		this.textFieldCantClientes.setColumns(10);
		
		this.panel_4 = new JPanel();
		this.panelCentralDerInterior.add(this.panel_4);
		
		this.lblCantViajesChofer = new JLabel("Cantidad maxima de viajes por chofer");
		this.panel_4.add(this.lblCantViajesChofer);
		
		this.panel_5 = new JPanel();
		this.panelCentralDerInterior.add(this.panel_5);
		
		this.textFieldCantMAxViajesChofer = new JTextField();
		this.panel_5.add(this.textFieldCantMAxViajesChofer);
		this.textFieldCantMAxViajesChofer.setColumns(10);
		
		this.panel_6 = new JPanel();
		this.panelCentralDerInterior.add(this.panel_6);
		
		this.lblCantpedidosClientes = new JLabel("Cantidad maxima de pedidos por cliente");
		this.panel_6.add(this.lblCantpedidosClientes);
		
		this.panel_7 = new JPanel();
		this.panelCentralDerInterior.add(this.panel_7);
		
		this.textFieldCantPedidosClientes = new JTextField();
		this.panel_7.add(this.textFieldCantPedidosClientes);
		this.textFieldCantPedidosClientes.setColumns(10);
		
		this.panel_8 = new JPanel();
		this.panelCentralDerInterior.add(this.panel_8);
		
		this.lblCantAutos = new JLabel("Cantidad de autos");
		this.panel_8.add(this.lblCantAutos);
		
		this.panel_9 = new JPanel();
		this.panelCentralDerInterior.add(this.panel_9);
		
		this.textFieldCantAucot = new JTextField();
		this.panel_9.add(this.textFieldCantAucot);
		this.textFieldCantAucot.setColumns(10);
		
		this.panel_10 = new JPanel();
		this.panelCentralDerInterior.add(this.panel_10);
		
		this.lblCantCombis = new JLabel("Cantidad de combis");
		this.panel_10.add(this.lblCantCombis);
		
		this.panel_11 = new JPanel();
		this.panelCentralDerInterior.add(this.panel_11);
		
		this.textFieldCantCombis = new JTextField();
		this.panel_11.add(this.textFieldCantCombis);
		this.textFieldCantCombis.setColumns(10);
		
		this.panel_12 = new JPanel();
		this.panelCentralDerInterior.add(this.panel_12);
		
		this.lblCantMotos = new JLabel("Cantidad de motos");
		this.panel_12.add(this.lblCantMotos);
		
		this.panel_13 = new JPanel();
		this.panelCentralDerInterior.add(this.panel_13);
		
		this.textFieldCantMotos = new JTextField();
		this.panel_13.add(this.textFieldCantMotos);
		this.textFieldCantMotos.setColumns(10);
		
		this.panelSur = new JPanel();
		this.contentPane.add(this.panelSur, BorderLayout.SOUTH);
		this.panelSur.setLayout(new BorderLayout(0, 0));
		
		this.panelSurInterno = new JPanel();
		this.panelSur.add(this.panelSurInterno, BorderLayout.NORTH);
		
		this.btnAceptar = new JButton("Aceptar");
		this.panelSurInterno.add(this.btnAceptar);
		this.btnAceptar.setEnabled(false);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(this.rdbtnUsarConfig.isSelected()) {
			this.textFieldCantChoferes.setEditable(false);
			this.textFieldCantClientes.setEditable(false);
			this.textFieldCantMAxViajesChofer.setEditable(false);
			this.textFieldCantPedidosClientes.setEditable(false);
			this.textFieldCantAucot.setEditable(false);
			this.textFieldCantCombis.setEditable(false);
			this.textFieldCantMotos.setEditable(false);
			this.btnAceptar.setEnabled(true);
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
