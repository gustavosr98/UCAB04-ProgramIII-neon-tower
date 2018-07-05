package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;

import java.util.ArrayList;

public class Control {

    private ArrayList<BotonControl> botones;

    public Control(MyGdxGame game, Stage stage) {

        botones = new ArrayList<BotonControl>();
        crearBotones(game);
        setearIdBotones();

        for (BotonControl b : botones){
            stage.addActor( b.getButton() );
        }

        enlazar();
    }

    public void setearIdBotones(){
        int a = 0;
        for (BotonControl b : botones){
            b.setId(a);
            a++;
        }
    }


    public Paquete crearPaquete(World world, float unidad, Color color, MyCamera camara){
        Paquete paquete = new Paquete();
        ArrayList<Bloque> bloques =  new ArrayList<Bloque>();
        int a;
        float x, y;

        for(BotonControl bc : botones){
            y = Gdx.graphics.getHeight()/2 - camara.getDesfaceY()*0;
            x = Gdx.graphics.getWidth()/2;

            if( bc.isOn() ) {
                a = bc.getId();

                if (a % 5 == 0)
                    x -= unidad * 2;
                else if (a % 5 == 1)
                    x -= unidad * 1;
                else if (a % 5 == 3)
                    x += unidad * 1;
                else if (a % 5 == 4)
                    x += unidad * 2;

                if (a >= 0 && a < 5)
                    y += unidad * 1;
                else if (a >= 10 && a < 15)
                    y -= unidad * 1;

                paquete.addBloque( new BloqueCuadrado(world, unidad, x, y, color) );
            }
        }

        return paquete;
    }


    public int cantBotonesOn(){
        int cant = 0;
        for(BotonControl b: botones)
            if ( b.isOn() )
                cant++;
        return cant;
    }

    public void crearBotones(MyGdxGame game){
        int x=1, y=3;
        for (int i=1; i<=15; i++) {
            if (x == 6) {
                x = 1;
                y--;
            }
            botones.add( new BotonControl(game, x, y) );
            x++;
        }
    }

    public void update(Board board, World world, float unidad, MyCamera camara, boolean pantallaTocada) {
        if (!pantallaTocada) {
            board.addPaquete( crearPaquete(world, unidad, board.getColor() , camara) );
            apagarBotones();
        }

        Button tmp;
        for (BotonControl b : botones) {
            tmp = b.getButton();
            if ( tmp.isPressed() && cantBotonesOn() == 0 ) {
                b.botonPresionado();
            }
        }

    }



    public void apagarBotones(){
        for (BotonControl b : botones) {
            b.botonSuelto();
        }
    }

    public void enlazar () {
        BotonControl botonA, botonB;

        //Enlaces horizontales
        for(int i=1; i < 5; i++){
            botonA = botones.get(i-1);
            botonB = botones.get(i);

            botonA.enlazar(botonB);
            botonB.enlazar(botonA);
        }

        for(int i=6; i < 10; i++){
            botonA = botones.get(i-1);
            botonB = botones.get(i);

            botonA.enlazar(botonB);
            botonB.enlazar(botonA);
        }

        for(int i=11; i < 15; i++){
            botonA = botones.get(i-1);
            botonB = botones.get(i);

            botonA.enlazar(botonB);
            botonB.enlazar(botonA);
        }

        //Enlaces verticales
        for (int i = 5; i <= 10; i += 5) {
            botonA = botones.get(i-5);
            botonB = botones.get(i);

            botonA.enlazar(botonB);
            botonB.enlazar(botonA);
        }

        for (int i = 6; i <= 11; i += 5) {
            botonA = botones.get(i-5);
            botonB = botones.get(i);

            botonA.enlazar(botonB);
            botonB.enlazar(botonA);
        }

        for (int i = 7; i <= 12; i += 5) {
            botonA = botones.get(i-5);
            botonB = botones.get(i);

            botonA.enlazar(botonB);
            botonB.enlazar(botonA);
        }

        for (int i = 8; i <= 13; i += 5) {
            botonA = botones.get(i-5);
            botonB = botones.get(i);

            botonA.enlazar(botonB);
            botonB.enlazar(botonA);
        }

        for (int i = 9; i <= 14; i += 5) {
            botonA = botones.get(i-5);
            botonB = botones.get(i);

            botonA.enlazar(botonB);
            botonB.enlazar(botonA);
        }

    }

}
