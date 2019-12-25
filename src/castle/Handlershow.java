package castle;

public class Handlershow extends Handler {
	public Handlershow(Game game) {
		super(game);
	}
	
	@Override
	public void doCmd(String cmd) {
		// TODO Auto-generated method stub
		game.showRoomInfo();
	}

}
