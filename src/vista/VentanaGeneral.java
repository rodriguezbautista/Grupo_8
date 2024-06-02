package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaGeneral extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelCentral;
	private JPanel panelColumna1;
	private JPanel panelColumna2;
	private JPanel panelColumna3;
	private JScrollPane scrollPaneCol1;
	private JScrollPane scrollPaneCol2;
	private JScrollPane scrollPaneCol3;
	private JTextArea textAreaGeneral;
	private JTextArea textAreaChofer;
	private JTextArea textAreaCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaGeneral frame = new VentanaGeneral();
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
	public VentanaGeneral() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 444);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		this.panelCentral = new JPanel();
		this.contentPane.add(this.panelCentral, BorderLayout.CENTER);
		this.panelCentral.setLayout(new GridLayout(0, 3, 0, 0));
		
		this.panelColumna1 = new JPanel();
		this.panelColumna1.setBorder(new TitledBorder(null, "General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panelCentral.add(this.panelColumna1);
		this.panelColumna1.setLayout(new BorderLayout(0, 0));
		
		this.scrollPaneCol1 = new JScrollPane();
		this.panelColumna1.add(this.scrollPaneCol1, BorderLayout.CENTER);
		
		this.textAreaGeneral = new JTextArea();
		this.scrollPaneCol1.setViewportView(this.textAreaGeneral);
		
		this.panelColumna2 = new JPanel();
		this.panelColumna2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Chofer", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		this.panelCentral.add(this.panelColumna2);
		this.panelColumna2.setLayout(new BorderLayout(0, 0));
		
		this.scrollPaneCol2 = new JScrollPane();
		this.panelColumna2.add(this.scrollPaneCol2, BorderLayout.CENTER);
		
		this.textAreaChofer = new JTextArea();
		this.scrollPaneCol2.setViewportView(this.textAreaChofer);
		
		this.panelColumna3 = new JPanel();
		this.panelColumna3.setBorder(new TitledBorder(null, "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panelCentral.add(this.panelColumna3);
		this.panelColumna3.setLayout(new BorderLayout(0, 0));
		
		this.scrollPaneCol3 = new JScrollPane();
		this.panelColumna3.add(this.scrollPaneCol3, BorderLayout.CENTER);
		
		this.textAreaCliente = new JTextArea();
		this.scrollPaneCol3.setViewportView(this.textAreaCliente);
	}
	
	public void appendTextGeneral(String arg) {
		this.textAreaGeneral.append(arg + "\n");
	}
	
	public void appendTextChofer(String arg) {
		this.textAreaChofer.append(arg + "\n");
	}
	
	public void appendTextCliente(String arg) {
		this.textAreaCliente.append(arg + "\n");
	}
}
