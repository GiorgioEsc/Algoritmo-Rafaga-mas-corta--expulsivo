package Vista.Comando;

import java.awt.Color;
import java.awt.Graphics;

import Vista.Medidas;
import java.awt.Font;

public class PintarNombreProceso implements ComandoGraficar {

	private String nombre;
	private int iteracion;

	public PintarNombreProceso() {
		this.nombre = "";
		this.iteracion = 0;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setIteracion(int iteracion) {
		this.iteracion = iteracion;
	}

	@Override
	public void pintar(Graphics g) {
		g.setColor(Color.BLACK);
                Font fuente = new Font("Calibri", 3, 19);
                g.setFont(fuente);
		g.drawString(this.nombre, Medidas.SEGMENTO_HORIZONTAL - 7,
			(this.iteracion + 3) * Medidas.SEGMENTO_VERTICAL - 7);
	}

}
