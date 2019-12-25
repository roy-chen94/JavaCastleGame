package castle;

public class Handler { 
	protected Game game;
	
	public Handler(Game game) {
		this.game = game;
	}
	

	public boolean bye() {
		return false;
	}
	
	public void doCmd(String cmd) {
		
	}
}
