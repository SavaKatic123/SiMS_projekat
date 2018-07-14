package states;

import java.util.concurrent.TimeUnit;

@SuppressWarnings("serial")
public class RampaSpustena extends StanjeRampe {

	@Override
	public StanjeRampe getSledeceStanje() {
		// TODO Auto-generated method stub
		return new RampaSeDize();
	}
	
	
	@Override
	public void entry() {
		// TODO Auto-generated method stub
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub
	}
	
}
