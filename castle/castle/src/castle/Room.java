package castle;

import java.util.HashMap;

public class Room {
    private String description;
    private HashMap<String, Room> exits = new HashMap<String,Room>();
   
    public Room(String description) 
    {
        this.description = description;
    }

    public void setExit(String dir,Room room){
    	exits.put(dir, room);
    }
    
    @Override
    public String toString()
    {
        return description;
    }
    
    public String getExitDisc(){
    	StringBuffer sb = new StringBuffer();
    	for(String dir : exits.keySet()){
    		sb.append(dir);
    		sb.append(' ');
    	}
    	return sb.toString();
    }
    
    public Room getExit(String direction){
    	return exits.get(direction);    	        
    }
    
    public String getDes(){
    	return description;
    }
    //进入房间有1/10概率被传送到其它房间
    public boolean portal(){
    	boolean a = false;
    	if(Math.random()<0.3){
    		a=true;
    	}	
    	return a;
    }	
}
