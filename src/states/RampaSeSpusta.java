package states;

import java.util.concurrent.TimeUnit;

@SuppressWarnings("serial")
public class RampaSeSpusta extends StanjeRampe {

	@Override
	public StanjeRampe getSledeceStanje() {
		// TODO Auto-generated method stub
		return new RampaSpustena();
	}
	
	
	@Override
	public void entry() {
		// TODO Auto-generated method stub
		System.out.println("Rampa pocinje da se spusta.");
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
		int indikator = 3;
		while (indikator > 0) {
			
			try {
				System.out.println("Rampa se spusta...");
				TimeUnit.SECONDS.sleep(1);
				indikator--;
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub
		System.out.println();
	}

}
