import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Student {

	final String filename = "file.txt";

	private String firstName;
	private String lastName;

	public Student() {

		firstName = "John";
		lastName = "Doe";

	}

	public Student(String fn, String ln) {

		firstName = fn;
		lastName = ln;

	}

	public String setFirstName() { return firstName;}
	public void getFirstName(String fn) { firstName = fn;}
	public String setLastName() {return lastName;}
	public void getLastName(String ln) {lastName = ln;}

}


public class Client {


	static final String filename = "file.txt";

	public static void main(String args[]) {

		ArrayList<Student> stud = new ArrayList<Student>();
		ArrayList<Student> studIn = new ArrayList<Student>();

		stud.add( new Student("Cy", "Bunayog"));
		stud.add( new Student("Joseph", "Tang"));
		stud.add( new Student("Seth", "Wheeler"));
		stud.add( new Student("Timothy", "Lim"));


		FileOutputStream fos = null;
		PrintWriter pw = null;

		try {

			fos = new FileOutputStream(filename);
			pw = new PrintWriter(fos);

			for(Student s : stud)
				pw.print(s.getFirstName() + "-");
			pw.println(s.getLastName());
		} catch(FileNotFoundException e) {
			System.out.println("ERROR: File not found");
		} catch(Exception e) {
			System.out.println("ERROR: Unknown error occured.");
		} finally {
			try{
				if(pw != null)
					pw.close();
				if(fos != null)
					fos.close();

			} catch(Exception e) {
				System.out.println("ERROR: Unknown error occured.");
			}
		}

		FileInputStream fis = null;
		Scanner fS = null;

		try {
			fis = new FileInputStream(filename);
			fS = new Scanner(fis);

			while(fS.hasNextLine())
				String line = fS.nextLine();

			Scanner lS = new Scanner(line);
			lS.useDelimiter("-");
			String firstName = lS.next().trim();
			String lastName = lS.next().trim();
			//for integer ---> int i = Integer.parseInteger
			//for boolean ---> int j = Boolean.parseBoolean
			//for double  ---> int d = Double.parseDouble
			studIn.add( new Student(firstName, lastName) )
		} catch (FileNotFoundException e){
			System.out.println("ERROR: File not found.");
		} catch (Exception e) {
			System.out.println("ERROR: Unknown error occured.");
		} finally {
			try {
				if (fS != null)
					fS.close();
				if (fis != null)
					fis.close()
			} catch (Exception e) {
				System.out.println("ERROR: Unknown error occured.");
			}
			for(Student s: stuIn)
				System.out.println(s);
		}
	}
}
