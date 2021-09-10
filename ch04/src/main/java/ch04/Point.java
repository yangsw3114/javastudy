package ch04;

import java.util.Objects;

public class Point {
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}

	
	//////////////////소스 탭에서 아래 메서드 생성가능
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		return x == other.x && y == other.y;
	}
}
