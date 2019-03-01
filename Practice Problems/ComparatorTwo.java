package zip;

import java.util.*;

class Student{
	private int id;
	private String fname;
	private double cgpa;
	public Student(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}
}


public class ComparatorTwo
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
        
		int testCases = Integer.parseInt(in.nextLine());
		
		List<Student> studentList = new ArrayList<Student>();
		while(testCases>0){
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();
			
			Student st = new Student(id, fname, cgpa);
			studentList.add(st);
			
			testCases--;
		}
        
		/* didnt work
        studentList.sort((Comparator.comparing(Student::getId)));
        studentList.sort((s1,s2) -> s1.getFname().compareToIgnoreCase(s2.getFname()));
        studentList.sort((Comparator.comparing(Student::getCgpa)).reversed());
        */
		
		//worked
        Collections.sort(studentList, (a,b)->
        Comparator.comparing(Student::getCgpa)
        .reversed().thenComparing(Student::getFname)
        .thenComparing(Student::getId).compare(a ,b));
        
      	for(Student st: studentList){
			System.out.println(st.getFname());
		}
	}
}




