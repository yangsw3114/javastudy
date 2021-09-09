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
		if(!power)
			return;
		
		if(num<1) {
			num=255;
		}
		else if(num>255) {
			num=1;
		}
		this.channel=num;
	}
	public void channel(boolean tf) {
		channel(channel + (tf?1:-1));

	}
	
	public void volume(int num) {
		if(!power)
			return;
		
		if(num<0) {
			num=100;
		}
		else if(num>100) {
			num=0;
		}
		
		this.volume=num;
	}
	public void volume(boolean tf) {
		volume(volume+(tf?1:-1));
	}
}
