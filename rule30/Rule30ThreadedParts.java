package rule30;

public class Rule30ThreadedParts extends Thread{
	public int start;
	public int end;
	public int generation;
	public int[] parent;
	public int[] current;
	
	
	public Rule30ThreadedParts(int[][] cell, int start, int end, int generation){
		parent = new int[cell[generation].length];
		
		for(int i = 0; i < cell.length; i++){
			parent[i] = cell[generation][i];
		}
		
		this.start = start;
		this.end = end;
		this.generation = generation;
		this.current = new int[end];
	}
	
	private void printFirstGeneration(){
		
		for(int cols = 0; cols < end; cols++){
			current[cols] = cell_state(cols + start);
		}
	}
	
	private int cell_state(int cols){
		int printCell = 1;
		
		
		int m = (int) ((cols == 0) ? 0 : parent[cols - 1]);
		int n = (int) (parent[cols]);
		int o = (int) ((cols == parent.length - 1)? 0 : parent[cols + 1]);
		
		
		if(m == 1){
			if(n == 1)
				printCell = 0;
		} else {
			if(n == 0 && o == 0)
				printCell = 0;
		}
		
		
		
		return printCell;
	}
	
	public void run(){
		printFirstGeneration();
	}
	
	
}
