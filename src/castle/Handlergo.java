package castle;

public class Handlergo extends Handler {

	public Handlergo(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doCmd(String cmd) {
		// TODO Auto-generated method stub
		game.goRoom(cmd);
	}


    
}
