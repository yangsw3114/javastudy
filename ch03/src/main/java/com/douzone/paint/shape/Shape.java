package com.douzone.paint.shape;

import com.douzone.paint.main.Drawable;

public abstract class Shape implements Drawable{
	private String LineColor;
	private String fillColor;
	
	public abstract void draw();
}
