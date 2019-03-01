package zip;
import java.util.*;

//Write your Checker class here
class Checker implements Comparator<Player>{

	@Override
	public int compare(Player o1, Player o2) {
		// TODO Auto-generated method stub
		if(o1.score<o2.score)
			return 1;
		else if (o1.score==o2.score) {
			if(o1.name.compareToIgnoreCase(o2.name)< 0 ) {
				return -1;
				
			}
			else return 1;
		}
		else
		return -1;
	}
	
}

class Player{
 String name;
 int score;
 
 Player(String name, int score){
     this.name = name;
     this.score = score;
 }
}

class ComparatorTrial {

 public static void main(String[] args) {
     Scanner scan = new Scanner(System.in);
     int n = scan.nextInt();
     List<Player> studentList = new ArrayList<Player>();
     
     Player[] player = new Player[n];
     Checker checker = new Checker();
     
     for(int i = 0; i < n; i++){
         player[i] = new Player(scan.next(), scan.nextInt());
     }
     scan.close();
     List<Player> li = new ArrayList<Player>();
     
     Arrays.sort(player, checker);
     for(int i = 0; i < player.length; i++){
         System.out.printf("%s %s\n", player[i].name, player[i].score);
     }
 }
}