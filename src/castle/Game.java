package castle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private Room currentRoom;
    private HashMap<String, Handler> handlers = new HashMap<>();
    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<Room> completeroom = new ArrayList<>();
    private double prob = 0.2;
        
    public Game() 
    {
    	handlers.put("go", new Handlergo(this));
    	handlers.put("help",new Handlerhelp(this));
    	handlers.put("bye",new Handlerbye(this));
    	handlers.put("search", new Handlersearch(this));
    	handlers.put("show", new Handlershow(this));
    	handlers.put("cgprob", new Handlercgprob(this));
        createRooms();
    }

    private void createRooms()
    {
        Room outside, lobby, pub, study, bedroom;
        AnyRoom anyroom;
        SuperRoom superroom;
      
        //	制造房间
        outside = new Room("城堡外");
        rooms.add(outside);
        lobby = new Room("大堂");
        rooms.add(lobby);
        pub = new Room("小酒吧");
        rooms.add(pub);
        study = new Room("书房");
        rooms.add(study);
        bedroom = new Room("卧室");
        rooms.add(bedroom);
        anyroom = new AnyRoom(outside);
        superroom = new SuperRoom(outside, this);
        
        //	初始化房间的出口
        outside.setExit("east", lobby);
        outside.setExit("south", study);
        outside.setExit("west", pub);
        lobby.setExit("west", outside);
        pub.setExit("east", outside);
        study.setExit("north", outside);
        study.setExit("east", bedroom);
        bedroom.setExit("west", study);
        outside.setExit("down", anyroom);
        outside.setExit("up", superroom);

        currentRoom = outside;  //	从城堡门外开始
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("欢迎来到城堡！");
        System.out.println("这是一个超级无聊的游戏。");
        System.out.println("如果需要帮助，请输入 'help' 。");
        System.out.println();
        showPrompt();
    }

    // 以下为用户命令

    public void goRoom(String direction) 
    {
        Room nextRoom = currentRoom.getRoom(direction);

        if (nextRoom == null) {
            System.out.println("那里没有门！");
        }
        else {
        	currentRoom = nextRoom;
        	if (currentRoom.anyRoom()) {  //如果进入了一个AnyRoom
        		AnyRoom thisroom = (AnyRoom) currentRoom;
        		currentRoom = thisroom.goAnyRoom();
        	}
            showPrompt();
        }
    }
	
    public ArrayList<Room> getRooms(Room currentroom){
    	ArrayList<Room> rtnrooms = new ArrayList<>();
    	for (Room r : rooms) {
    		if (!r.equals(currentroom)) rtnrooms.add(r);
    	}
    	return rtnrooms;
    }
    
    public ArrayList<String> getHandlers() {
    	ArrayList<String> str = new ArrayList<>();
    	for (String s : handlers.keySet()) str.add(s);
    	return str;
    }
    
    public void showPrompt() {
        System.out.println("你在" + currentRoom);
        System.out.print("出口有: ");
        System.out.print(currentRoom.getRoomDesc());
        System.out.println();
    }
    
    public void showRoomInfo() {
    	int total = rooms.size();
    	int complete = completeroom.size();
    	System.out.printf("您已找到 %d 个宝箱，共有 %d 个宝箱\n", complete, total);
    	
    }
    
    public void findChest() {
    	if (currentRoom.haveChest()) {
    		Random rand = new Random();
    		double rd = rand.nextDouble();
    		if (rd <= prob) {
    			System.out.println("找到了一个宝箱");
    			currentRoom.changeChest();
    			completeroom.add(currentRoom);
    		} else {
    			System.out.println("没有找到宝箱，请再找找");
    		}
    	} else {
    		System.out.println("已获得该房间的宝箱");
    	}
    }
    
    public void changeProb(double newprob) {
    	if (newprob <= 1 && newprob > 0) {
    		prob = newprob;
    		System.out.printf("概率修改成功，现在的概率为 %.2f\n", prob);
    	} else {
    		System.out.println("无效的概率，概率需在(0,1]区间");
    	}
    }
    
    public boolean isfinished() {
    	return completeroom.size() == rooms.size();
    }
    
    public void play() {
    	Scanner in = new Scanner(System.in);
    	while ( true ) {
    		String line = in.nextLine();
    		String[] words = line.split(" ");
    		String cmd = "";
    		if (words.length > 1) cmd = words[1];
    		Handler handler = handlers.get(words[0]);
    		if (handler != null) {
    			if (handler.bye()) break;
    			else handler.doCmd(cmd);
    		}
    		if (isfinished()) {
    			System.out.println("恭喜！您找到了所有的宝箱！");
    			break;
    		}
       }
    	in.close();
		System.out.println("感谢您的光临。再见！");
    }
    
	public static void main(String[] args) {		
		Game game = new Game();
		game.printWelcome();
		game.play();  
	}

}
