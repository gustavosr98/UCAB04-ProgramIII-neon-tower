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
        Bloque bloque;
        int a;
        float x, y;
        Bloque [][] b = new Bloque[3][5];

        for(BotonControl bc : botones){
            y = Gdx.graphics.getHeight()/3 - camara.getDesfaceY();
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

                bloque = new BloqueCuadrado(world, unidad, x, y, color);

                switch (a) {
                    case 0 : b[0][0] = bloque; break;
                    case 1 : b[0][1] = bloque; break;
                    case 2 : b[0][2] = bloque; break;
                    case 3 : b[0][3] = bloque; break;
                    case 4 : b[0][4] = bloque; break;

                    case 5 : b[1][0] = bloque; break;
                    case 6 : b[1][1] = bloque; break;
                    case 7 : b[1][2] = bloque; break;
                    case 8 : b[1][3] = bloque; break;
                    case 9 : b[1][4] = bloque; break;

                    case 10 : b[2][0] = bloque; break;
                    case 11 : b[2][1] = bloque; break;
                    case 12 : b[2][2] = bloque; break;
                    case 13 : b[2][3] = bloque; break;
                    case 14 : b[2][4] = bloque; break;

                    paquete.addBloque( bloque );
            }
        }

        paquete.conectar(b);
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
