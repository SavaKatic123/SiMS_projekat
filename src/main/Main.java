package main;

import utility.Login;

public class Main {

	public static void main(String[] args) {
		Aplikacija.getInstance();
		
		Login.citajIzFajla();
		boolean uspesno = Login.logIn();
		
		if (uspesno) {
			
		}
	}

}
