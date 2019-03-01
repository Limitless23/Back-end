package zip;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
/*
 * Create the Student and Priorities classes here.
 * 
 * input:
 * 
 * 12
ENTER John 3.75 50
ENTER Mark 3.8 24
ENTER Shafaet 3.7 35
SERVED
SERVED
ENTER Samiha 3.85 36
SERVED
ENTER Ashley 3.9 42
ENTER Maria 3.6 46
ENTER Anik 3.95 49
ENTER Dan 3.95 50
SERVED
 */
 class Stud{
	 
	 String name;
	 double cgpa;
	 int id;
	 
	 public Stud(int id, String name, double cgpa) {
		 this.id = id;
		 this.name = name;
		 this.cgpa = cgpa;
	 }
	 
	 int getId() {
		 
		 return this.id;
		 
	 }
     
	 String getName() {
		 return this.name;
	 }
	 
	 double getCGPA() {
		 return this.cgpa;
	 }
 }

class Priorities {
	
	Comparator<Stud> compareStuds = Comparator.comparing(Stud::getCGPA)
		    .reversed().thenComparing(Stud::getName)
		    .thenComparing(Stud::getId);
	
	
	PriorityQueue pq = new PriorityQueue(compareStuds);
	
	List<Stud> getStudents(List<String> events){
		for(int i=0;i<events.size();i++) {
			String data[] = events.get(i).split(" ");
			if(data[0].equals("ENTER")) {
				Stud newStudent = new Stud(Integer.parseInt(data[3]),data[1],Double.parseDouble(data[2]));
				pq.add(newStudent);
			}
			else {
				Stud served = (Stud) pq.poll();
				//System.out.println(served.name);
			}
		}
		
		List<Stud> remainingStuds = new ArrayList<Stud>();
		while(pq.size()>0) {
			remainingStuds.add((Stud)pq.poll());
		}
		
		return remainingStuds;
		
	}
}

public class PriorityQue {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        
        List<Stud> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Stud st: students) {
                System.out.println(st.getName());
            }
        }
    }
}
