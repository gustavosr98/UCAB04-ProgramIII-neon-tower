package com.mygdx.game;

public class GameOverListener {
    private float y;

    public void setY(float y){
        this.y = y;
    }

    public void gameOver(MyGdxGame game, Board board){
        if ( board.gameOver(y) )
            game.setScreen(game.pantallaGameOver);
    }
}
