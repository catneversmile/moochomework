package castle;

public class monster  {
	private String name = "¹ÖÎï";
	private int power = 0;
	public monster(int a){
		power = (int)(a*Math.random()*1.8);
	}
	
	public String getName(){
		return name;
	}
	
	public int getPower(){
		return power;
	}	
}
