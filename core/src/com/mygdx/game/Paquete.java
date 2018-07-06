package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static com.mygdx.game.Constantes.PPM;


public class Paquete {
    private Color color;
    private ArrayList<Bloque> bloques = new ArrayList<Bloque>();

    public void enlazar(ArrayList<Bloque> bloquesTmp){
        Bloque bloqueA, bloqueB;

        //Enlaces horizontales
        for(int a=0; a <= 10; a+=5) {
            for (int i = 1 + a; i < 5 + a; i++) {
                bloqueA = bloquesTmp.get(i - 1);
                bloqueB = bloquesTmp.get(i);

                if ((bloqueA != bloqueB) && (bloqueA != null) && (bloqueB != null)) {
                    bloqueA.enlazar(bloqueB);
                }
            }
        }

        //Enlaces verticales
        for(int a = 0; a <= 4; a++) {
            for (int i = 5 + a; i <= 10 + a; i += 5) {
                bloqueA = bloquesTmp.get(i - 5);
                bloqueB = bloquesTmp.get(i);
                if ((bloqueA != bloqueB) && (bloqueA != null) && (bloqueB != null)) {
                    bloqueA.enlazar(bloqueB);
                }
            }
        }


    }

    public void addBloque(Bloque b) {
        bloques.add( b );
    }

    public void update(){
        for (Bloque b: bloques)
            b.update();
    }

    public boolean gameOver(float y){
        boolean x = false;
        for(Bloque b: bloques)
            if ( b.gameOver(y) )
                x = true;
        return x;
    }

    public void draw(SpriteBatch batch){
        for (Bloque b: bloques)
            b.draw(batch);
    }

    public void dispose(World world){
        for (Bloque b: bloques)
            b.dispose(world);
    }

    public boolean hayBloqueEntre(float y1, float y2){
        boolean x = false;
        for(Bloque b: bloques){
            if( b.hayBloqueEntre(y1,y2) )
                x = true;
        }
        return x;
    }
}
