package codazen;

public class Student {
	private String firstName;
	private String lastName;
	private int age;

	/** Create a student object. */
	public Student(String firstName, String lastName, int age) {
		// automatically convert strings to uppercase in the case someone 
		// types in name weird. edge case
		this.firstName = firstName.toUpperCase();
		this.lastName = lastName.toUpperCase();
		this.age = age;
	}

	/** Getter method for student first name. */
	public String getFirstName() {
		return firstName;
	}

	/** Getter method for student last name. */
	public String getLastName() {
		return lastName;
	}

	/** Getter method for student age. */
	public int getAge() {
		return age;
	}

	/** Create full concatenation of student profile.
	  * The reason I do this is to have a little hack instead of making a comparable, etc.
	  * If I had more time, I would do a more professional job instead of this. */
	public String studentString() {
		return getFirstName() + getLastName() + getAge();
	}

	/** Tostring method of student for debugging, etc. */
	public String toString() {
		return "Student " + firstName + " " + lastName + " is " + age + " years old.";
	}
		
}