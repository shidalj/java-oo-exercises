package Baseball;

import java.util.ArrayList;
import java.util.List;

public class Team {

	private String name;
	// List is an interface
	private List<Player> roster;
	private int totalSalary;
	
	public Team(String name){
		this.name = name;
		// create an ArrayList (implements the List interface) instance
		this.roster = new ArrayList<Player>();
		this.totalSalary = 0;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void addPlayer(Player p, int salary){
		p.sign(this,salary);
		roster.add(p);
		this.totalSalary += p.getSalary();
	}
	
	public void listRoster(){
		for(int i = 0; i < roster.size(); i++){
			System.out.println(this.roster.get(i));
		}
	}
	
	public String toString(){
		return "Team: " + this.name + "   Total salary: " + this.totalSalary;
	}
	
	
	public static void main(String args[]){
		Team cards = new Team("Cardinals");
		FieldPlayer fp = new FieldPlayer("Yadier Molina", 4, new PowerHittingStrategy());
		Pitcher p = new Pitcher("Adam Wainwright", 50);
		// doesn't work because Player is abstract
		// Player a = new Player("jon", 10);
		cards.addPlayer(fp, 15000000);
		cards.addPlayer(p, 19500000);
		System.out.println(cards);
		for(int i = 0; i < cards.roster.size(); i++){
			for(int j = 0; j < 400; j++){
				cards.roster.get(i).simulateAtBat();
			}
		}
		cards.listRoster();
	}
}
