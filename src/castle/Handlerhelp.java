package castle;

import java.util.ArrayList;

public class Handlerhelp extends Handler {

	public Handlerhelp(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doCmd(String cmd) {
		// TODO Auto-generated method stub
		ArrayList<String> handlers = game.getHandlers();
		System.out.print("��·������������������У�");
		for (String s : handlers) {
			if (!s.equals("cgprob")) System.out.print(s + " ");
		}
        System.out.println("�磺\tgo east");
	}

}
