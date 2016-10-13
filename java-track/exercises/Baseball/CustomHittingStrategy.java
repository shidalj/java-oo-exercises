package Baseball;

public class CustomHittingStrategy implements BattingStrategy {
	
	double battingAverage;
	double homeRunRate;
	
	public CustomHittingStrategy(double ba, double hrr){
		if(ba < 0 || ba > 1 || hrr < 0 || hrr > 1){
			throw new IllegalArgumentException();
		}
		this.battingAverage = ba;
		this.homeRunRate = hrr;
	}

	@Override
	public int simulateAtBat() {
		double d = Math.random();
		int outcome = 0;
		if(d <= this.battingAverage){
			outcome++;
			if (d <= this.battingAverage * this.homeRunRate){
				outcome++;
			}
		}
		return outcome;
	}

}
