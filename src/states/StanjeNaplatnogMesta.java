package states;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class StanjeNaplatnogMesta implements Serializable {
	abstract public void entry ();
	abstract public void execute ();
	abstract public void exit ();
}
