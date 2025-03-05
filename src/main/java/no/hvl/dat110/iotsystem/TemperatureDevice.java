package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;

public class TemperatureDevice {

	private static final int COUNT = 10;

	public static void main(String[] args) {

		// simulated / virtual temperature sensor
		TemperatureSensor sn = new TemperatureSensor();

		// TODO - start

		// create a client object and use it to
		

		// - connect to the broker - user "sensor" as the user name
		// - publish the temperature(s)
		// - disconnect from the broker

		
		Client client = new Client("sensor", Common.BROKERHOST, Common.BROKERPORT);
		
		if(client.connect()) {
			
			for(int i = 0; i < COUNT; i++) {
				
				String temp = Integer.toString(sn.read());
				System.out.println("READING: " + temp);
				
				client.publish(Common.TEMPTOPIC, temp);
				
				try {
					Thread.sleep(2000);
					
				} catch(InterruptedException  e) {
					e.printStackTrace();
				}
			}
			
			client.disconnect();
			

			System.out.println("Temperature device stopping ... ");
		}
		



	}
}
