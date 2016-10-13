package Baseball;

public class FieldPlayer extends Player{

	private int atBats;
	private int hits;
	private int homeRuns;
	private BattingStrategy bs;
	
	public FieldPlayer(String name, int number, BattingStrategy bs){
		super(name,number);
		this.atBats = 0;
		this.hits = 0;
		this.homeRuns = 0;
		this.bs = bs;
	}

	public double calculateAverage(){
		double avg = (double) this.hits / (double) this.atBats;
		avg = Math.round(avg * 1000) / 1000.0;
		return avg;
	}
	
	public void updateStats(int hits, int atBats, int homeRuns){
		this.hits += hits;
		this.atBats += atBats;
		this.homeRuns += homeRuns;
	}
	
	public void simulateAtBat(){
		int outcome = this.bs.simulateAtBat();
		if(outcome > 1){
			this.homeRuns++;
		}
		if(outcome > 0){
			this.hits++;
		}
		this.atBats++;
	}

	public String toString(){
		return super.toString() + "   batting average: " + calculateAverage() + "  Home Runs: " + this.homeRuns;
	}
	
	public static void main(String[] args){
		Team cards = new Team("Cardinals");
		PowerHittingStrategy ph = new PowerHittingStrategy();
		FieldPlayer fp = new FieldPlayer("Matt Holliday", 7, ph);
		AverageHittingStrategy ah = new AverageHittingStrategy();
		FieldPlayer fp1 = new FieldPlayer("Matt Carpenter", 13, ah);
		CustomHittingStrategy ch;
		try{
		    ch = new CustomHittingStrategy(0.290,0.25);
		}
		catch (IllegalArgumentException e){
			System.out.println("illegal argument given");
			e.printStackTrace();
			return;
		}
		catch(Exception e){
			System.out.println("unexpected exception");
			e.printStackTrace();
			return;
		}
		FieldPlayer fp2 = new FieldPlayer("Yadier Molina", 4, ch);
		cards.addPlayer(fp, 10000000);
		cards.addPlayer(fp1, 6500000);
		cards.addPlayer(fp2, 8000000);
		for(int i = 0; i < 400; i++){
			fp.simulateAtBat();
			fp1.simulateAtBat();
			fp2.simulateAtBat();
		}
		System.out.println(fp);
		System.out.println(fp1);
		System.out.println(fp2);
	}
}
