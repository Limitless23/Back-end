package dailyCodeProblem;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class City {
	public String cityName;
	private Set<String> connectingCities; 
	
	public City(String city) {
		this.cityName = city;
		this.connectingCities = new HashSet<String>();
	}
	
	public void addConnectingCity(String conCity) {
		connectingCities.add(conCity);
	}
	
	public void showConnCities() {
		for(String con: connectingCities) {
			System.out.println(this.cityName+" -> "+con);
		}
	}
	
	public Set<String> getConCities(){
		return this.connectingCities;
	}
}


public class Itenerary {
	
	static HashMap<String, City> map = new HashMap<String, City>();
	static String start;
	public  void find(City city) {
		
		ArrayList<String> visited = new ArrayList<String>();
		if((map.get(city.cityName).getConCities().size()==1) && !map.containsKey(map.get(city.cityName).getConCities()))
		{
			System.out.println("NULLLL!");
			return;
		}
		findConnections(city, visited );
		
		
	}
	
	

	public  void findConnections(City city, ArrayList<String> visited) {
			
		
			if(visited.contains(city.cityName)) {
				for(String cit: visited) {
					System.out.print(cit + " -> ");
					
				}
				System.out.print("END!");
				System.out.println("");
				//if(visited.size()>1)
				//	visited.remove(visited.size()-1);
				return;
			}
			
			
		
			visited.add(city.cityName);
			
			for(String cities: map.get(city.cityName).getConCities()) {
				
				if(!map.containsKey(cities)) {
					//System.out.println("it is here");
					for(String cit: visited) {
						System.out.print(cit + " -> ");
						
					}
					System.out.print(cities+ " -> END!");
					System.out.println();
					continue;
				}
				
				if(cities.contentEquals(start))
					return;
				
				findConnections(map.get(cities), visited);
			}
			
			//if(visited.size()>1)
			//	visited.remove(visited.size()-1);
			return;
		
	}



	public static void main(String[] args) throws IOException {
		
		//Scanner scan = new Scanner(System.in);
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		
		String[] srcdst = new String[2];
		System.out.println("Enter the src dst pairs");
		String word = " ";
		while( (word=read.readLine())!=null) {
			if(word.equals(""))
				break;
			srcdst = word.split(" ");
			
			if(map.containsKey(srcdst[0])) {
				map.get(srcdst[0]).addConnectingCity(srcdst[1]);
			}
			else {
				map.put(srcdst[0], new City(srcdst[0]));
				map.get(srcdst[0]).addConnectingCity(srcdst[1]);
			}
		}
		
		System.out.println("Enter the starting city: ");
		start = read.readLine();
		
		Itenerary iten = new Itenerary();
		iten.find((map.get(start)));
		
		//System.out.println("The entries are: ");
		//for(String city: map.keySet()) {
			//System.out.println(city);
		//	map.get(city).showConnCities();
		}

	}


