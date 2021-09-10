package prob6;
import java.lang.Math;
//직각삼각형
public class RectTriangle extends Shape{
	private double width;
	private double height;
	
	public RectTriangle(double w, double h) {
		this.width=w;
		this.height=h;
	}

	@Override
	public double getArea() {
		double area = (width * height)/2;
		return area;
	}

	@Override
	public double getPerimeter() {
		double perimeter = width + height + Math.sqrt(Math.pow(width,2) + Math.pow(height,2));
		return perimeter;
	}
}
