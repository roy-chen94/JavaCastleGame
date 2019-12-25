package castle;

public class Handlercgprob extends Handler {

	public Handlercgprob(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doCmd(String cmd) {
		// TODO Auto-generated method stub
	try {
	   game.changeProb(Double.parseDouble(cmd));
	} catch(NumberFormatException e) {
		System.out.println("无效的概率输入");
	}
		
	}
	
	
}
