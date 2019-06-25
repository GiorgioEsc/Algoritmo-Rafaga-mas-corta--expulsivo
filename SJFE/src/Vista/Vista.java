package Vista;

import Vista.Comando.PintarConvenciones;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import logica.calculos.Calculos;
import logica.calculos.RegistroCalculo;
import logica.fabricaPlanificadores.Generador;

public class Vista extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private Calculos calculos;
	private Generador generador;
                
	private JPanel contentPane;
	private JButton btnAgregar;
	private JButton btnDerecha;
	private JButton btnIzquierda;

	private CanvasGantt canvas;
	private JTable tbCalculos;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Vista();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Vista() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1600, 740);
                                    this.setTitle("Rafaga mas corta expulsiva");
                                    PintarConvenciones pc = new PintarConvenciones();
                                    
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnAgregar = new JButton("Iniciar");
		btnAgregar.setBounds(800, 610, 250, 30);
		btnAgregar.setActionCommand("ag");
		btnAgregar.addActionListener(this);
		contentPane.add(btnAgregar);

		btnDerecha = new JButton("Mover Derecha");
		btnDerecha.setBounds(930, 570, 150, 30);
		btnDerecha.setActionCommand("de");
		btnDerecha.addActionListener(this);
		contentPane.add(btnDerecha);

		btnIzquierda = new JButton("Mover Izquierda");
		btnIzquierda.setBounds(750, 570, 150, 30);
		btnIzquierda.setActionCommand("iz");
		btnIzquierda.addActionListener(this);
		contentPane.add(btnIzquierda);

		tbCalculos = new JTable();
		tbCalculos.setBounds(10, 570, 500, 490);
		contentPane.add(tbCalculos);

		canvas = new CanvasGantt();
		canvas.setBounds(10, 20, 1250, 540);
		contentPane.add(canvas);

		calculos = new Calculos();
		generador = new Generador();
		calculos.setPlanificador(generador.getPlanificador("SJFE"));
		this.setFocusable(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("ag")) {
			calculos.agregar();
			calculos.calcular();
			canvas.setRegistro(calculos.getRegistros());
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("Nombre");
			model.addColumn("T. Llegada");
			model.addColumn("T. Rafaga");
                      //  model.addColumn("prioridad");
			model.addColumn("T. Final");
			model.addColumn("T. Espera");
			model.addColumn("tras");
			model.addRow(new Object[] { "T.Proceso", "T.Llegada", "T.Rafaga", 
                            "T.Finalizacion", "T.Espera",
					"T.Retorno" });
                                        for (int i = 0; i < calculos.getRegistros().size(); i++) {
				if (calculos.getRegistros().containsKey("" + i)) {
					RegistroCalculo rc = calculos.getRegistros().get("" + i);
					model.addRow(new Object[] { rc.getNombre(), rc.getLlegada(), rc.getRafada(),
                                            //rc.getPrioridad(),
							rc.getFinalizacion(), rc.getEspera(), rc.getTranscurrido() });
				}
			}
			tbCalculos.setModel(model);
		}  else if (e.getActionCommand().equals("de")) {
			canvas.getRecuadro().moverDerecha();
			canvas.repaint();
		} else if (e.getActionCommand().equals("iz")) {
			canvas.getRecuadro().moverIzquierda();
			canvas.repaint();
		}
		this.setFocusable(true);
	}
}