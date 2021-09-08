package tv;

public class TV {
	private int channel; //1~255
	private int volume;
	private boolean power;
	
	public TV(int ch, int vo, boolean pwr) {
		this.channel=ch;
		this.volume=vo;
		this.power=pwr;
	}
	
	public void status(){
		System.out.println("TV [channel=" + channel + ", volume=" + volume + ", power=" + power + "]");
	}

	public int getChannel() {
		return channel;
	}

	public int getVolume() {
		return volume;
	}
	
	public void power(boolean tf) {
		this.power=tf;
	}
	
	public void channel(int num) {
		this.channel=num;
	}
	public void channel(boolean tf) {
		this.channel+=1;
	}
	
	public void volume(int num) {
		this.volume=num;
	}
	public void volume(boolean tf) {
		this.volume+=1;
	}
}
