package baseball;

public class PowerHittingStrategy implements BattingStrategy {

	@Override
	public int simulateAtBat() {
		int outcome = 0;
		double h = Math.random();
		if(h <= 0.25){
			outcome++;
			if(h <= 0.125){
				outcome++;
			}
		}
		return outcome;
	}
}
