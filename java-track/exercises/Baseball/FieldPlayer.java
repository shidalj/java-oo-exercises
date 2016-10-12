package Baseball;

public class FieldPlayer extends Player{

	private int atBats;
	private int hits;
	
	public FieldPlayer(String name, int number){
		super(name,number);
		this.atBats = 0;
		this.hits = 0;
	}

	public double calculateAverage(){
		double avg = (double) this.hits / (double) this.atBats;
		avg = Math.round(avg * 1000) / 1000.0;
		return avg;
	}
	
	public void updateStats(int hits, int atBats){
		this.hits += hits;
		this.atBats += atBats;
	}
	
	public String toString(){
		return super.toString() + "   batting average: " + calculateAverage();
	}
}
