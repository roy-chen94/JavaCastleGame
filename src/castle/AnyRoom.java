package castle;

import java.util.ArrayList;

public class AnyRoom extends Room {
	private ArrayList<String> exits;  //ǰһ���������ͨ���������������䣨������AnyRoom�����б�
	protected Room beforeroom;  //ǰһ������
	protected int cnt = 0;  //�����������ڼ�¼�������÷����ĸ�����
	protected int exitnum; //����ͨ�����������������

	public AnyRoom (Room beforeroom) {
		super("AnyRoom");
		this.beforeroom = beforeroom;
	}
	
	@Override	
    public boolean anyRoom() {  //����������ڷ�����������Ƿ���AnyRoom
    	return true;   
    }
	
	public Room goAnyRoom() {  //ѡ��һ���������䲢����
		exits = beforeroom.getKeys();
		exitnum = exits.size();
		Room rtroom = beforeroom.getRoom(exits.get(cnt));  //Ҫ����ķ���
		cnt++;  //������+1����ת����һ������
		if (cnt >= exitnum) cnt = 0;  //����Ѿ���ת�������з��䣨�������������ޣ��������������
		return rtroom;
	}
}
