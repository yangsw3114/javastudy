package com.douzone.paint.shape;

public class Triangle extends Shape{
	private int x1, y1;
	private int x2, y2;
	private int x3, y3;
	
	@Override
	public void draw() {
		System.out.println("삼각형을 그렸습니다.");
	}
}
