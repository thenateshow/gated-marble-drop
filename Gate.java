public class Gate{
	Boolean left;
	Boolean right;
	Boolean center;
	int toggle;
	public Gate(Boolean l, Boolean r, Boolean c, int t){
		left = l;
		right = r;
		center = c;
		toggle = t;
	}
	public Gate(char c){
		left = false;
		right = false;
		center = false;
		setState(c);
		toggle = -1;
	}
	public void setLeft(Boolean l){
		left = l;
	}
	public void setRight(Boolean r){
		right = r;
	}
	public void setCenter(Boolean c){
		center = c;
	}
	public void setToggle(int t){
		toggle = t;
	}
	public char getState(){
		if(left){
			return 'L';
		}
		if(right){
			return 'R';
		}
		if(center){
			return 'C';
		}
		return 'e';
	}
	public void setState(char c){
		if(c == 'L'){
			left = true;
		}
		else if(c == 'R'){
			right = true;
		}
		else if(c == 'C'){
			center = true;
		}
		else{
			System.out.println("error in setState");
		}
	}
	public int getToggle(){
		return toggle;
	}
	public void toggleGate(){
		if(toggle == -1){
			left = !left;
			right = !right;
		}
		else if(toggle == 0){
			Boolean temp = center;
			center = left;
			left = right;
			right = temp;
		}
		else{
			Boolean temp = center;
			center = right;
			right = left;
			left = temp;
		}
	}
}