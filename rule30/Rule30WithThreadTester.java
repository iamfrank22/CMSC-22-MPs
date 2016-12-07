package rule30;

public class Rule30WithThreadTester {
	public static final int RULE_SIZE = 30;
	
	
	public static void main (String[] args) {
		long threadStart, threadEnd, timeThreaded;
        threadStart = System.currentTimeMillis();
        Rule30WithThread threaded = new Rule30WithThread(RULE_SIZE);
        threaded.dislpay();
        threadEnd = System.currentTimeMillis();
        timeThreaded = threadEnd - threadStart;
        System.out.println("\nTime for threaded Rule 30: " + timeThreaded);
	}
}
