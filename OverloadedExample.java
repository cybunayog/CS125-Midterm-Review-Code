public class Student {
	private String name;
	private int degreeLevel;

	public Student() {
		String fname = "Joseph";
		degreeLevel = 0;
	}

	public Student(String name, int degreeLevel) {
		this.name = name;
		this.degreeLevel = degreeLevel;
	}

	public String getName() {
		return name;
	}

	public void setName(String n) {
		name = n;
	}

//probably something important to remember b/c of the instanceof command
	public boolean equals(Object obj) {
		if (!(obj instanceof Student)) {
			return false;
		} else {
			Student otherStudent = (Student) obj;
			if (name.equals(otherStudent.name))
				return true;
		}
		return false;
	}
}

public class Professor extends Student{

	private final static int bachelors = 1;
	private final static int masters = 2;
	private final static int phD = 3;

	private int degreeLevel;

	public Professor() {
		super(); // optional
	}

	public Professor(String name, int degree) {
		super(name, degree); // calling from Student superclass
	}

	public int getDegreeLevel() {
		return degreeLevel;
	}

	public void setDegreeLevel(int degree) {
		int level = 0;
		if (degree >= 1 && level <= phD)
			degreeLevel = level;
		else
			degreeLevel = 0;

	}

}
