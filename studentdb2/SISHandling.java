import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.lang.*;

/**
 * Created by Arniel, Frank, Daniel on 10/14/2016.
 */


public class SISHandling extends StudentInformation {


	private static final String FILE_NAME = "/Users/dcs-madl14/Desktop/Frankieee/StudentInformation.ser";


	List<StudentInformation> myList = new ArrayList<StudentInformation>();

	public static int toInteger( String given ){
		int result = 0;
		for ( int i = 0; i < given.length(); i++ ){
			if ( given.charAt(i) >= '0' && given.charAt(i) <= '9'){
				result = (result * 10) + (given.charAt(i) - 48);
			} else{
				throw new IllegalArgumentException("Invalid number. Contains non-integers!!");
			}
		}

		return result;
	}


	FileOutputStream fos = null;
    ObjectOutputStream oos = null;
    FileInputStream fis = null;
    ObjectInputStream ois = null;


	//stores all StudentInformation from a file to myList
	public SISHandling(){


		//BufferedReader br = null;

        try {
        	File fin = new File(FILE_NAME);
			if(fin.length() == 0) {

            }
            else{
	            fis = new FileInputStream(fin);
	            ois = new ObjectInputStream(fis);



	        	myList = (ArrayList<StudentInformation>) ois.readObject();


	        	System.out.println(myList);
	        	ois.close();

	        	fis.close();
			}

        } catch (IOException e) {
            e.printStackTrace();
        } catch( ClassNotFoundException ce){  
        	ce.printStackTrace();
        } 
	}

	public boolean isStudentNumExisting( String studentNumber ){
		int x = 0;
		StudentInformation current = new StudentInformation();
		while ( x < myList.size() ){
			if ( ( (current = myList.get(x)).getStudentNumber() ).equals(studentNumber) ){
				return true;
			}
			x++;
		}

		return false;

	}

	public void RegisterStudent( String studentNumber ){
		int x = 1;
		StudentInformation student = new StudentInformation();
		Scanner sc = new Scanner(System.in);
		String scanned = "";
	    
		System.out.print("First name: ");
		scanned = sc.nextLine();
		String firstName = scanned;
		System.out.print("Middle Initial: ");
		scanned = sc.nextLine();
		char middleInitial = scanned.charAt(0);
		System.out.print("Last Name: ");
		scanned = sc.nextLine();
		String lastName = scanned;
		System.out.print("Course: ");
		scanned = sc.nextLine();
		String course = scanned;
		System.out.print("Year Level: ");
		scanned = sc.nextLine();
		int yearLevel = toInteger(scanned);

		System.out.print("Crush name: ");
		scanned = sc.nextLine();
		String crushName = scanned;

		System.out.print("Favorite Subject: ");
		scanned = sc.nextLine();
		String faveSubject = scanned;

		System.out.print("Favorite Course Description: ");
		scanned = sc.nextLine();
		String faveCourseDesc = scanned;




		student = new StudentInformation(studentNumber, firstName, middleInitial, lastName, course, yearLevel, crushName, new Course(faveSubject, faveCourseDesc));
		myList.add(student);
		System.out.println();
		System.out.println("Student added!");

	}

	public void RetrieveInformation( String studentNumber ){
		int x = 0;
		StudentInformation current = new StudentInformation();
		while ( x < myList.size() ){
			current = myList.get(x);
			if ( ( current.getStudentNumber() ).equals(studentNumber) ){
				System.out.println(current);
				break;
			}

			x++;
		}

	}

	public void DeleteStudent( String studentNumber ){
		int x = 0;
		StudentInformation current = new StudentInformation();
		while ( x < myList.size() ){
			if ( ( (current = myList.get(x)).getStudentNumber() ).equals(studentNumber) ){
				myList.remove(x);
				System.out.println("Student " + studentNumber + " deleted!");
				break;
			}

			x++;
		}

	}

	public void UpdateStudent( String studentNumber ){
		int x = 0;
		StudentInformation current = new StudentInformation();
		while ( x < myList.size() ){
			if ( ( (current = myList.get(x)).getStudentNumber() ).equals(studentNumber) ){

				Scanner sc = new Scanner(System.in);
				String scanned = "";
			    
				System.out.print("First name: ");
				scanned = sc.nextLine();
				String firstName = scanned;

				System.out.print("Middle Initial: ");
				scanned = sc.nextLine();
				char middleInitial = scanned.charAt(0);
				System.out.print("Last Name: ");
				scanned = sc.nextLine();
				String lastName = scanned;
				System.out.print("Course: ");
				scanned = sc.nextLine();
				String course = scanned;

				System.out.print("Year Level: ");
				scanned = sc.nextLine();
				int yearLevel = toInteger(scanned);

				System.out.print("Crush name: ");
				scanned = sc.nextLine();
				String crushName = scanned;

				System.out.print("Favorite Subject: ");
				scanned = sc.nextLine();
				String faveSubject = scanned;

				System.out.print("Favorite Course Description: ");
				scanned = sc.nextLine();
				String faveCourseDesc = scanned;


				current = new StudentInformation(studentNumber, firstName, middleInitial, lastName, course, yearLevel, crushName, new Course(faveSubject, faveCourseDesc));
				myList.remove(x);
				myList.add(x, current);
				System.out.println("Student " + studentNumber + " updated!");
			}

			x++;
		}

	}

	public void save( ){

		try {

			System.out.println(myList);


			File fout = new File(FILE_NAME);

	        fos = new FileOutputStream(fout);
	        oos = new ObjectOutputStream(fos);

	        oos.writeObject(myList);

	        oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
	}
}