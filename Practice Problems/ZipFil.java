package zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class ZipFil {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the zipfile you wanna open: ");
		String fil = scan.nextLine();
		
		Path filePath = Paths.get("F:\\Java workspace\\Violent Jav\\src\\zip\\"+fil);
		Path destPath = Paths.get("F:\\Java workspace\\Violent Jav\\src\\zip\\"+"extracted");
		
		
		File dir = new File(destPath.toString());
		if(!dir.exists()) {
			dir.mkdir();
		}
		
		byte[] buffer = new byte[1024];
		 
		try (FileInputStream fis = new FileInputStream(filePath.toString());
				ZipInputStream zis = new ZipInputStream(fis);)
		{
			
			ZipEntry ze = zis.getNextEntry();
			
			while(ze!=null) {
				
				String fileName = ze.getName();
				File newFile = new File(destPath.toString() +File.separator + fileName);
				System.out.println("Extracting to "+newFile.getAbsolutePath());
				
				FileOutputStream fos = new FileOutputStream(newFile);
				int len;
				while((len = zis.read(buffer))>0) {
					fos.write(buffer, 0, len);
				}
				fos.close();
				zis.closeEntry();
				ze=zis.getNextEntry();
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		

	}

}
