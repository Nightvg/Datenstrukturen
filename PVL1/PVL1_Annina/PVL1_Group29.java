package PVL1_Annina;

import java.util.ArrayList;


public class PVL1_Group29 {
	
	//private ArrayList<Integer> valid_transitions;
	private int zustaende; //Variable fuer Zustandsuebergaenge 
	private ArrayList <Integer> uebergaenge; // Feld das die genauen Uebergangseingaben speichert
	private int [][] array; //speichert von welchem Zustand zu welchem Folgezustand
	private boolean canI = true;
	
	//Konstruktor, anhand des Arrays den Automaten konstruieren, siehe form
	public PVL1_Group29(int [][] data) {
		//this.valid_transitions = new ArrayList<Integer>();
		
		this.zustaende = data[0][0];
		this.uebergaenge = new ArrayList<Integer>(); 
		
		for (int i=0; i< data[2].length; i++) { //speichern der uerbergaenge
			this.uebergaenge.add(data[2][i]);
		}
		
		//array have to be larger, because of the false state --- do i really need it? dont think so, but overthink it please
		this.array = new int [this.zustaende][this.uebergaenge.size()]; //new int [this.zustaende+1]
		for (int i = 0; i<array.length; i++) {
			for (int j = 0; j<array[i].length; j++) {
				array[i][j] = -1;
			}
		}
		
		//filling array
		int tmp = 0;
		for (int i=3; i<data.length; i++ ) {  
			for (int j = 0; j<data[i].length; j++) { //besser j<uebergaenge.length*2
				
				if (j%2 == 0) { //schau mir die Nummer des Zustandes an
					//extra prove if one transition is missing then i should lead to a false state 
					if(!uebergaenge.contains(data[i][j])) {
						System.out.println("Fehler in Transitions, Konstruktor fehlgeschlagen");
						return;
					}
					
					tmp = uebergaenge.indexOf(data[i][j]);
					array[i-3][tmp] = data[i][j+1];
					
				}
				
			}	
		}
			
	} // End of constructor
	
	//dem Automaten einen Zustandsuebergang hinzufuegen/ ueberschreiben
	public void setTransition(int state, int transition, int to) {
		//check if state and to are available and possible states 
		if(!testState(state) || !testState(to)) return;
		
		/*if (state < array.length || state > array.length || to < array.length || to > array.length) {
			System.out.println("Fehler, false state");
			return;
		}*/
		
		
		int temp = 0; 
		//check if transition is possible 
		if (!uebergaenge.contains(transition)) {
			System.out.println("Fehler, false transition");
			return;
		}
		temp = uebergaenge.indexOf(transition);
		
		//hinzufuegen bzw ueberschreiben der transition
		array[state][temp] = to;
	}
	
	
	private boolean testState (int s) {
		if (s < 0 || s > array.length-1) {
			System.out.println("Fehler: false state");
			return false;
		}
		return true;
	}
	//Automaten den Zustandsuebergang loeschen 
	public void deleteTransition(int state, int transition) {
		if(!testState(state)) return;
		
		int temp = 0; 
		//check if transition is possible 
		if (!uebergaenge.contains(transition)) {
			System.out.println("Fehler, false transition");
			return;
		}
		temp = uebergaenge.indexOf(transition);
		//wird quasi ueberschrieben und zeigt somit auf fehler
		array[state][temp] = -1;
		
	}
	
	//soll Zustandsuebergaenge durchfuehren und den Endzustand ausgeben; ungueltig -1
	public int traverse_input (int startState, int [] transitions) {
		if(!testState(startState)) {
			System.out.println("Fehler, invalid startstate");
			return -1; //test valid startstate
		}
		
		int tempstate = startState;
		int transnumber = 0;
		this.canI = false;
		for (int i=0; i<transitions.length; i++) {
			for (int j=0; j<uebergaenge.size(); j++) { //search for right index in array
				if (transitions[i] == uebergaenge.get(j)) {
					transnumber = j;
					canI = true;
				}
			}
			if (tempstate == -1) return -1;
			if (!canI) return -1; //valid transition was'nt found
			tempstate = array[tempstate][transnumber];
		}
		return tempstate; //is endstate
		
	}
	
}
