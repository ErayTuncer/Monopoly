package command;

import controller.Controller;

public class LogInfoCommand implements Command {
	
	private String info;
	
	public LogInfoCommand(String info) {
		this.info = info;
	}

	@Override
	public void execute(Controller controller) {
		// TODO Auto-generated method stub
		
	}

}
