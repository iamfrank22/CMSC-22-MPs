package rule30;

public class Rule30WithoutThreadTester {
	public static final int RULE_SIZE = 30;
	
	public static void main(String[] args){
		long nonthreadStart, nonthreadEnd, timeNonThreaded;
        nonthreadStart = System.currentTimeMillis();
        Rule30WithoutThread non_threaded = new Rule30WithoutThread(RULE_SIZE);
        non_threaded.printState();
        nonthreadEnd = System.currentTimeMillis();
        timeNonThreaded = nonthreadEnd - nonthreadStart;
        System.out.println("\nTime for non_threaded Rule 30: " + timeNonThreaded);
	}
}
