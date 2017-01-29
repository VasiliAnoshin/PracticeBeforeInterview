package ThreadsSyncCode.ThreadLock;

import java.util.ArrayList;
import java.util.List;

import sun.launcher.resources.launcher;

public class App {

	public ArrayList<Integer> getNumb(ArrayList<Integer> p){
		List<Integer> l = p;
		return (ArrayList)l;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Worker().main();
	}

}
