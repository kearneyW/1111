package vo;
/**
 *
 *学生类
 *id、姓名、学号、家庭住址
 *@author 菜鸟一号 
 */

public class Student {
	private int id;
	private String studentName;
	private String empId;
	private String address;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int id, String studentName, String empId, String address) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.empId = empId;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", studentName=" + studentName
				+ ", empId=" + empId + ", address=" + address + "]";
	}
}
