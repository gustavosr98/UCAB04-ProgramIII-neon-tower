package com.mygdx.game;

public class Color {
	float red;
	float green;
	float blue;
	float transparency;

	public Color(){
		this.transparency = 1;
	}

	public Color(float r, float g, float b){
		this.red = r;
		this.green = g;
		this.blue = b;
		this.transparency = 1f;
	}

	
}