package castle;

import java.util.ArrayList;
import java.util.HashMap;

public class Room {
	
    public String description;
    private HashMap<String, Room> exits = new HashMap<>();
    private boolean chest = true;
    
    public Room(String description) 
    {
        this.description = description;
    }

    public String getRoomDesc() {
    	StringBuffer sb = new StringBuffer();
    	for (String s: exits.keySet()) {
    		sb.append(s);
    		sb.append(" ");
    	}
        return sb.toString();
    }
    
    public void setExit(String dir, Room room){
    	exits.put(dir, room);
    }
    
    public boolean anyRoom() {
    	return false;
    }
    
    public Room getRoom(String direction) {
    	return exits.get(direction);
    }

    @Override
    public String toString()
    {
        return description;
    }
    
    protected ArrayList<String> getKeys() {
    	ArrayList<String> str = new ArrayList<>();
    	for (String s : exits.keySet()) {
    		if (!exits.get(s).anyRoom()) str.add(s);
    	}
    	return str;
    }
    
    public boolean haveChest() {
    	return chest;
    }
    
    public void changeChest() {
    	chest = false;
    }
}
