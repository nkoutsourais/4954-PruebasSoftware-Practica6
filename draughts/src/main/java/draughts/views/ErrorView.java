package draughts.views;

import draughts.models.Error;

public class ErrorView {

	static final String[] MESSAGES = { 
		"Error!!! No es una coordenada del tablero",
		"Error!!! No hay ficha que mover",
		"Error!!! No es una de tus fichas",
		"Error!!! No vas en diagonal",
		"Error!!! No está vacío el destino",
		"Error!!! No comes contrarias",
		"Error!!! No avanzas",
		"Error!!! No respetas la distancia",
		"Error!!! No te entiendo: <d><d>{,<d><d>}[0-2]"
	};

	final Error error;

	public ErrorView(Error error) {
		this.error = error;
	}

	public String getMessage() {
		return ErrorView.MESSAGES[this.error.ordinal()];
	}
}