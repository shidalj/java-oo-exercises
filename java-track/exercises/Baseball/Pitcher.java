package Baseball;

public class Pitcher extends Player{
	
	private double inningsPitched;
	private int earnedRuns;
	private int wins;
	private int losses;

	public Pitcher(String name, int number){
		super(name,number);
		this.inningsPitched = 0.0;
		this.earnedRuns = 0;
		this.wins = 0;
		this.losses = 0;
	}

	public double calculateEra(){
		double inningsOver9 = this.inningsPitched/9.0;
		double era = this.earnedRuns / inningsOver9;
		era = Math.round(era * 100) / 100.0;
		return era;
	}
	
	public void updateStats(double innings, int runs, int wins, int losses){
		this.inningsPitched += innings;
		this.earnedRuns += runs;
		this.wins += wins;
		this.losses += losses;
	}
	
	public String toString(){
		return "Pitcher " + super.toString() + " record: " + this.wins + "-" + this.losses + " era:" + this.calculateEra();
 	}
}
