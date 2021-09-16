package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalHost {

	public static void main(String[] args) {
		try {
			InetAddress inetaddress = InetAddress.getLocalHost();
			
			String hostname = inetaddress.getHostName();
			String hostAddress = inetaddress.getHostAddress();
			
			System.out.println(hostname);
			System.out.println(hostAddress);
			
			byte[] addresses = inetaddress.getAddress();
			for(byte address : addresses) {
				System.out.print(address & 0x000000ff);
				System.out.print('.');
			}
			
		} catch (UnknownHostException e) {
			
		}
	}

}
