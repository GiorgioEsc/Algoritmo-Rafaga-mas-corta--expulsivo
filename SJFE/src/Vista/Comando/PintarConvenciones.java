package Vista.Comando;

import Vista.Recuadro;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class PintarConvenciones implements ComandoGraficar{
    
    private final Color[] colores;
    private String[] labels;
    private Graphics graphics;
    
    public PintarConvenciones() {
        
        this.colores = new Color[3];        
        this.colores[0]=Color.RED;
        this.colores[1]=Color.WHITE;
        this.colores[2]=Color.BLACK;
        this.labels = new String[3];
        this.labels[0]="Bloqueo";
        this.labels[1] = "Ejecución";
        this.labels[2] = "Espera";
        
    }    

    @Override
    public void pintar(Graphics g) {
        for(int i=0; i<3; i++){
            g.setColor(Color.BLACK);
            g.draw3DRect(10, 220, 10, 5, true);
            
        }
    }
    
}
