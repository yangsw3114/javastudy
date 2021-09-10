package prob6;
//직사각형
public class Rectangle extends Shape implements Resizable{
	private double width;
	private double height;
	
	public Rectangle(double w, double h) {
		this.width=w;
		this.height=h;	
	}

	@Override
	public Resizable resize(double s) {
		this.width=this.width*s;
		this.height=this.height*s;
		return this;
	}

	@Override
	public double getArea() {
		double area= width*height;
		return area;
	}

	@Override
	public double getPerimeter() {
		double perimeter=(width+height)*2;
		return perimeter;
	}
}
