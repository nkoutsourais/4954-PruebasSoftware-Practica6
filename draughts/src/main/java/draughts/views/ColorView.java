package draughts.views;

import draughts.models.Color;

class ColorView {

    static final String[] MESSAGES = { 
        "Blancas",
        "Negras"
    };
    
    final Color color;

    ColorView(Color color) {
        this.color = color;
    }

    public String getMessage() {
		return ColorView.MESSAGES[this.color.ordinal()];
	}
}