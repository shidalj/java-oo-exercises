package Baseball;

public class AverageHittingStrategy implements BattingStrategy {

	@Override
	public int simulateAtBat() {
		double d = Math.random();
		int outcome = 0;
		if(d <= 0.3){
			outcome++;
			if (d <= 0.015){
				outcome++;
			}
		}
		return outcome;
	}

}
