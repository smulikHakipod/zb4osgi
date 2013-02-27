package it.cnr.isti.zigbee.samples.throughput.client.data;

public class Token {
	public int id;
	public long t1;
	public long t2;
	
	public Token(int id){
		this.id = id;
		t1 = 0;
		t2 = 0;
	}
}
