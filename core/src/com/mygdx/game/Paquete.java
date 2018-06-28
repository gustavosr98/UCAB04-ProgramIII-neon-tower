package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;

import java.util.ArrayList;

/**
 * Created by Gustavo on 27-Jun-18.
 */

public class Paquete {
    Color color;
    ArrayList<Bloque> bloques;

    public Paquete(World world, float unidad, float x , float y, Color c){
        this.color = c;
        bloques = new ArrayList<Bloque>();
        nuevoBloque(world, unidad,x,y-unidad);
        nuevoBloque(world, unidad,x,y);
        nuevoBloque(world, unidad,x+unidad,y);
        nuevoBloque(world, unidad,x+unidad*2,y);

        conectar();
    }

    public void conectar(){
        Bloque bA, bB;

        if (bloques.size() >= 2){
            for(int i = 1; i < bloques.size() ; i++){
                bA = bloques.get(i-1);
                bB = bloques.get(i);
                bA.conectar(bB);
            }
        }
    }


    public void nuevoBloque(World world, float unidad, float x, float y) {
        bloques.add( new BloqueCuadrado(world, unidad, x , y, color) );
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
}
