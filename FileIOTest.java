import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;
public class FileIOTest {
	File file=new File("test_file.txt");
	Scanner sc=new Scanner(System.in);
	BufferedWriter bw=null;
	BufferedReader br=null;
	FileReader fr=null;
	FileWriter fw=null;
	public static void main(String[] args){
		FileIOTest ft=new FileIOTest();
		try{
			if(!ft.file.exists()){
    			ft.file.createNewFile();
    		}
		}
		catch(IOException e){
			e.printStackTrace();
		}
		ft.writeInFile();
		ft.readFile();
		ft.changeContent();
	}
	void writeInFile()
	{
		
		System.out.println("enter content to be written");
		String text=sc.nextLine();
		try{
			fw=new FileWriter(file.getName(),true);
			bw=new BufferedWriter(fw);
			bw.write("\n"+text);
			bw.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	void readFile(){
		try{
			fr=new FileReader(file.getName());
			br=new BufferedReader(fr);
			String temp;
			while((temp=br.readLine())!=null){
				System.out.println(temp);
			}
			br.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	void changeContent(){
		System.out.println("enter content to be changed");
		String text=sc.nextLine();
		System.out.println("enter new content");
		String new_text=sc.nextLine();
		StringBuffer temp=new StringBuffer();
		String t;
		try{
			fr=new FileReader(file.getName());
			br=new BufferedReader(fr);
			while((t=br.readLine())!=null){
				temp.append(t+"\n");
			}
			fw=new FileWriter(file.getName(),false);
			bw=new BufferedWriter(fw);
			
			String temp2=temp.toString().replaceAll(text,new_text);
			bw.write(temp2);
			bw.close();
			br.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		readFile();
	}
}