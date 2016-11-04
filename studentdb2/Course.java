import java.io.Serializable;

public class Course implements Serializable{ 
	private String courseCode;
	private String courseDescripiton;


	public Course(){

	}

	public Course(String courseCode, String courseDescripiton){
		setCourseCode(courseCode);
		setCourseDescription(courseDescripiton);
	}

	public String getCourseCode(){
		return courseCode;
	}

	public void setCourseCode(String courseCode){
		this.courseCode = courseCode;
	}

	public String getCourseDescription(){
		return courseDescripiton;
	}

	public void setCourseDescription(String courseDescripiton){
		this.courseDescripiton = courseDescripiton;
	}

	@Override
	public String toString(){
		return "\nCourse Code: " + courseCode + 
		"\n" + "Course Descripiton: " + courseDescripiton;
	}
}