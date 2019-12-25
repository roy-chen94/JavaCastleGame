package castle;

public class Handlersearch extends Handler {
	public Handlersearch(Game game) {
		super(game);
	}

	@Override
	public void doCmd(String cmd) {
		// TODO Auto-generated method stub
			game.findChest();
		} 
}
	
