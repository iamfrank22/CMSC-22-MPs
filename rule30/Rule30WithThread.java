package rule30;

public class Rule30WithThread {
	
	final static int THREAD_COUNT = 10;
	public int[][] cell;
	public int cell_size;
	
	
	public Rule30WithThread(int cell_size){
		cell = new int[cell_size][cell_size];
		this.cell_size = cell_size;
	}
	
	public void printFirstGeneration(){
		int seed = cell_size / 2;
		
		for(int count = 0; count < cell_size; count++){
			if(count == seed)
				cell[0][count] = 1;
			else
				cell[0][count] = 0;
		}
		
		System.out.println();
	}
	
	public void dislpay() {
		printFirstGeneration();
		int segments;
		
		if(cell_size < THREAD_COUNT)
			segments = cell_size;
		else
			segments = THREAD_COUNT;
		
		
		Rule30ThreadedParts[] parts = new Rule30ThreadedParts[segments];
		int piece = cell_size / segments;
		int leftovers = cell_size % segments;
		
		for (int k = 0; k < cell_size - 1; k++) {
            int start = 0;
            for (int i = 0; i < segments; i++) {
            	
            	if(i < leftovers){
            		parts[i] = new Rule30ThreadedParts(cell, start, piece + 1, k);
            		start = start + piece + 1;
            	} else{
            		parts[i] = new Rule30ThreadedParts(cell, start, piece, k);
            		start = start + piece;
            	}
//                parts[i] = (i < leftovers) ? new Rule30ThreadedParts(cell, start, piece + 1, k):
//                        new Rule30ThreadedParts(array, start, each, k);
            	
            	
//                start = (i < excess) ? start + each + 1 : start + each;
                parts[i].start();
                
                while(parts[i].isAlive()) {
                    try {
                        parts[i].join();
                    } catch(InterruptedException e) {
                        System.err.println("thread interrupted: " + e.getMessage());
                    }
                }
            }
            for(int i = 0, j = 0; i < parts.length; i++) {
                for (int n: parts[i].current) {
                    cell[k + 1][j] = n;
                    System.out.print(n);
                    j++;
                }
            }
            System.out.println();
        }
		
	}

}
