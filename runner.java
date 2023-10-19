public class runner{
	public static void main(String[] args){
		if(args.length != 2){
			System.out.println("\nNot the correct number of arguments!\nExpected: 2    Recieved: " + args.length + "\n");
		}
		char[] startingStates = args[0].toCharArray();
		char[] marbles = args[1].toCharArray();
		Gate[] gates = new Gate[4];
		char chute = ' ';
		String trace = "";
		for(int i = 0; i < startingStates.length; i++){
			gates[i] = new Gate(startingStates[i]);
		}
		for(int i = 0; i < marbles.length; i++){
			if(marbles[i] == '0'){
				gates[0].setToggle(0);
			}
			else if(marbles[i] == '1'){
				gates[0].setToggle(1);
			}
			else{
				System.out.println("marbles has to be 0 or 1");
				break;
			}
			trace += "" + gates[0].getState() + gates[1].getState() + gates[2].getState() + gates[3].getState() + "->";
			if(gates[0].getState() == 'L'){
				if(gates[1].getState() == 'L'){
					chute = 'B';
				}
				else{
					chute = 'C';
				}
				gates[1].toggleGate();
			}
			else if(gates[0].getState() == 'C'){
				if(gates[2].getState() == 'L'){
					chute = 'C';
				}
				else{
					chute = 'D';
				}
				gates[2].toggleGate();
			}
			else{
				if(gates[3].getState() == 'L'){
					chute = 'D';
				}
				else{
					chute = 'E';
				}
				gates[3].toggleGate();
			}
			gates[0].toggleGate();
		}
		trace = "" + trace + gates[0].getState() + gates[1].getState() + gates[2].getState() + gates[3].getState() + " " + chute;
		System.out.println(trace);
	}
}