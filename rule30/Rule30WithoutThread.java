package rule30;


public class Rule30WithoutThread{
	
	
	public int[][] cell;
	public int cell_size;
	
	public Rule30WithoutThread(int cell_size){
		cell = new int[cell_size][cell_size];
		this.cell_size = cell_size;
	}
	
	private void printFirstGeneration(){
		int seed = cell_size / 2;
		
		for(int cols = 0; cols < cell_size; cols++){
			cell[0][cols] = 0;
		}
		
		cell[0][seed] = 1;
	}
	
	private void print_cell_value(){
		for(int rows = 1; rows < cell_size; rows++){
			for(int cols = 1; cols < cell_size; cols++)
				cell[rows][cols] = cell_state(rows, cols);
		}
	
	}
	private int cell_state(int rows, int cols){
		int printCell = 1;
		
		int m = (int) ((cols == 0) ? 0 : cell[rows - 1][cols - 1]);
		int n = (int) (cell[rows - 1][cols]);
		int o = (int) ((cols == cell_size - 1) ? 0 : cell[rows - 1][cols + 1]);
		
		
		if(m == 1){
			if(n == 1)
				printCell = 0;
		} else {
			if(n == 0 && o == 0)
				printCell = 0;
		}
		
		
		return printCell;
	}
	
	
	public void printState(){
		printFirstGeneration();
		print_cell_value();
		
		for(int i = 0; i < cell_size; i++){
			for(int j = 0; j < cell_size; j++){
				System.out.print(cell[i][j]);
			}
			
			System.out.println();
		}
	}
}
