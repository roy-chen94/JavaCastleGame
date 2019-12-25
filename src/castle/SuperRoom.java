package castle;

import java.util.ArrayList;

public class SuperRoom extends AnyRoom {
	private Game game;  //��¼��ǰ��Game
	private ArrayList<Room> rooms;  //SuperRoomֱ�Ӽ�¼�����������Ƿ�λ
	
	public SuperRoom(Room beforeroom, Game game) {
		super(beforeroom);
		this.game = game;
	}
	
	@Override
	public Room goAnyRoom() {
		rooms = game.getRooms(beforeroom);  //�õ����п��Խ���ķ��䣨������ǰһ�����䣩
		exitnum = rooms.size();
		Room rtroom = rooms.get(cnt);  //Ҫ����ķ���
		cnt++;  //������+1����ת����һ������
		if (cnt >= exitnum) cnt = 0;  //����Ѿ���ת�������з��䣨�������������ޣ��������������
		return rtroom;
	}
}
