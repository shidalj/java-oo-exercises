package Baseball;

public interface BattingStrategy {
	
	public int simulateAtBat();
	// 0 if no hit
	// 1 if a hit, but no homerun
	// 2 if a homerun
}
