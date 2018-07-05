package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;


public class MyCamera extends OrthographicCamera {
    private boolean sensor;
    private float tiempoSensorActivo;
    private float desfaceY = 0;
    private float unidad;

    public MyCamera(float w, float h, float unidad){
        this.viewportWidth = w;
        this.viewportHeight = h;
        this.unidad = unidad;
    }

    public void revisarSensor(boolean x){
        this.sensor = x;

        if (sensor) {
            tiempoSensorActivo += Gdx.graphics.getDeltaTime();
            if (tiempoSensorActivo >= 3) {
                moverY();
                tiempoSensorActivo = 0;
            }
        } else tiempoSensorActivo = 0;
    }

    public void moverY(){
        this.position.add(0,-unidad,0);
        desfaceY += unidad;
    }

    public float getDesfaceY(){
        return desfaceY;
    }

}
