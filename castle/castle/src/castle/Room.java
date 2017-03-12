package castle;

public class Room {
    public String description;
    public Room northExit;
    public Room southExit;
    public Room eastExit;
    public Room westExit;

    public Room(String description) 
    {
        this.description = description;
    }

    public void setExits(Room north, Room east, Room south, Room west) 
    {
        if(north != null)
            northExit = north;
        if(east != null)
            eastExit = east;
        if(south != null)
            southExit = south;
        if(west != null)
            westExit = west;
    }

    @Override
    public String toString()
    {
        return description;
    }
    
    public String getExitDisc(){
    	StringBuffer sb = new StringBuffer();
        if(northExit != null)
            sb.append("north ");
        if(eastExit != null)
        	sb.append("east ");
        if(southExit != null)
        	sb.append("south ");
        if(westExit != null)
        	sb.append("west ");
    	
    	return sb.toString();
    }
    
    public Room getExit(String direction){
    	Room ret = null;
    
    	 if(direction.equals("north")) {
             ret = northExit;
         }
         if(direction.equals("east")) {
             ret = eastExit;
         }
         if(direction.equals("south")) {
             ret = southExit;
         }
         if(direction.equals("west")) {
            ret = westExit;
         }
    	return ret;    	        
    }
}
