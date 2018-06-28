package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import static com.mygdx.game.Constantes.PPM;

/**
 * Created by Gustavo on 18-Jun-18.
 */

public class Piso {
    Texture imagen;
    Sprite sprite;
    Body body;

    public Piso(World world, float unidad, float width, float height){
        imagen = new Texture("Piso2.png");
        sprite = new Sprite(imagen);
        sprite.setSize(unidad*6, unidad);
        sprite.setPosition( unidad*6/2  , height - unidad);
        sprite.setColor(1,1,1,1);

        BodyDef def = new BodyDef();
        def.type = BodyDef.BodyType.StaticBody;
        def.position.set( (width- unidad*8)/PPM , (height - unidad)/PPM);
        def.fixedRotation = false;
        body = world.createBody(def);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(6*unidad/2 /PPM, unidad/2 /PPM);

        body.createFixture(shape, 1.0f);
        shape.dispose();
    }

    public void update(){
        sprite.setPosition( body.getPosition().x*PPM - sprite.getWidth()/2 , body.getPosition().y*PPM - sprite.getHeight()/2);
    }

    public void draw(SpriteBatch batch){
        sprite.draw(batch);
    }

    public void dispose (World world){
        imagen.dispose();
        world.destroyBody(body);
    }

}
