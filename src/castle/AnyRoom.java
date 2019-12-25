package castle;

import java.util.ArrayList;

public class AnyRoom extends Room {
	private ArrayList<String> exits;  //前一个房间可以通往的所有正常房间（即不是AnyRoom）的列表
	protected Room beforeroom;  //前一个房间
	protected int cnt = 0;  //计数器，用于记录接下来该访问哪个房间
	protected int exitnum; //可以通往的正常房间的数量

	public AnyRoom (Room beforeroom) {
		super("AnyRoom");
		this.beforeroom = beforeroom;
	}
	
	@Override	
    public boolean anyRoom() {  //这个函数用于返回这个房间是否是AnyRoom
    	return true;   
    }
	
	public Room goAnyRoom() {  //选择一个正常房间并进入
		exits = beforeroom.getKeys();
		exitnum = exits.size();
		Room rtroom = beforeroom.getRoom(exits.get(cnt));  //要进入的房间
		cnt++;  //计数器+1，轮转到下一个房间
		if (cnt >= exitnum) cnt = 0;  //如果已经轮转过了所有房间（计数器到达上限），则计数器归零
		return rtroom;
	}
}
