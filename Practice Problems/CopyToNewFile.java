package zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

public class CopyToNewFile {
	

	public static void main(String[] args) {
		System.out.println("Enter the name of the new file: ");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		
		Path path = Paths.get("");
		//System.out.println(path.toAbsolutePath().toString());
		Path paths = Paths.get(path.toAbsolutePath().toString()+"\\src\\zip\\extracted\\passwords.txt");
		//System.out.println("Path is: "+ paths.toString());
		File dest = new File(Paths.get(path.toAbsolutePath().toString()+"\\src\\zip\\extracted\\"+name).toString());
		System.out.println(dest.toString());
		UsingNio(paths,dest.toPath());
		}
	
	public static void UsingNio(Path source, Path dest) {
		
		try {
			List<String> 	list = Files.readAllLines(source);
			
			list.forEach(line -> {
				try {
					Files.write(dest, line.getBytes(),StandardOpenOption.CREATE);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
		
		
	}


