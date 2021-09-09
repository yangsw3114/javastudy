package com.douzone.paint.main;

import com.douzone.paint.point.ColorPoint;
import com.douzone.paint.point.Point;
import com.douzone.paint.shape.Circle;
import com.douzone.paint.shape.Rectangle;
import com.douzone.paint.shape.Shape;
import com.douzone.paint.shape.Triangle;

public class Main {
	public static void main(String[] args) {
		Point point1 = new Point();
		point1.setX(10);
		point1.setY(10);
		
		drawPoint(point1);
		// point1.disapear();
		point1.show(false);
		
		Point point2 = new ColorPoint();
		point2.setX(100);
		point2.setY(200);
		((ColorPoint)point2).setColor("red");
		drawPoint(point2);
		
		point2.show(false);
		point2.show(true);
		
		Triangle triangle = new Triangle();
		drawShape(triangle);
		
		Rectangle rect = new Rectangle();
		drawShape(rect);
		
		Circle cir = new Circle();
		drawShape(cir);
		
		//instanceof test
		System.out.println(cir instanceof Object);
		System.out.println(cir instanceof Shape);
		System.out.println(cir instanceof Circle);
		//System.out.println(cir instanceof Rectangle); //오류: 클래스는 hierachy상위와 하위만 instanceof 연산자를 사용할 수 있다.
		
		//interface는 hierachy와 상관없이 instanceof 연산자를 사용할 수 있다.
		System.out.println(cir instanceof Drawable);
		System.out.println(cir instanceof Runnable);
	}
	
	public static void drawPoint(Point point) {
		point.show();
	}

//	public static void drawColorPoint(ColorPoint colorPoint) {
//		colorPoint.show();
//	}
	
	public static void drawShape(Shape shape) {
		shape.draw();
	}
	

}