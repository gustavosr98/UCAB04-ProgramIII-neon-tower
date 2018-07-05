package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;

import java.util.ArrayList;

import static com.mygdx.game.Constantes.PPM;


public class Paquete {
    private Color color;
    private ArrayList<Bloque> bloques = new ArrayList<Bloque>();

    public void conectar(){
        if (bloques.size() >= 2){
            for(Bloque bA: bloques)
                for(Bloque bB: bloques){
                    if ((bA != bB) && ( Math.abs (bA.getPhisicX() - bB.getPhisicX()) <= bB.getGraphicWidth()/PPM ) && ( Math.abs (bA.getPhisicY() - bA.getPhisicY()) <= bB.getGraphicWidth()/PPM ) ){
                        bA.conectar(bB);
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

    public void draw(SpriteBatch batch){
        for (Bloque b: bloques)
            b.draw(batch);
    }

    public void dispose(World world){
        for (Bloque b: bloques)
            b.dispose(world);
    }

    public boolean hayBloqueArriba(float y){
        boolean x = false;
        for(Bloque b: bloques){
            if( b.hayBloqueArriba(y) )
                x = true;
        }
        return x;
    }
}
