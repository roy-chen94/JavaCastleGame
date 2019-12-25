package castle;

import java.util.ArrayList;

public class SuperRoom extends AnyRoom {
	private Game game;  //记录当前的Game
	private ArrayList<Room> rooms;  //SuperRoom直接记录房间对象而不是方位
	
	public SuperRoom(Room beforeroom, Game game) {
		super(beforeroom);
		this.game = game;
	}
	
	@Override
	public Room goAnyRoom() {
		rooms = game.getRooms(beforeroom);  //得到所有可以进入的房间（不包括前一个房间）
		exitnum = rooms.size();
		Room rtroom = rooms.get(cnt);  //要进入的房间
		cnt++;  //计数器+1，轮转到下一个房间
		if (cnt >= exitnum) cnt = 0;  //如果已经轮转过了所有房间（计数器到达上限），则计数器归零
		return rtroom;
	}
}
