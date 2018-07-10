package states;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class StanjeElektronskeNaplate implements Serializable {
	abstract public void entry ();
	abstract public void execute ();
}
