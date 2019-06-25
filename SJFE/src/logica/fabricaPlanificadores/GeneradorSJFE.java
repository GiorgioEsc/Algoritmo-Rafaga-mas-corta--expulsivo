package logica.fabricaPlanificadores;

import logica.planificacion.Planificacion;
import logica.planificacion.SJFE;

public class GeneradorSJFE implements GeneradorPlanificador {

	@Override
	public Planificacion getPlanificador() {
		return new SJFE();
	}

}
