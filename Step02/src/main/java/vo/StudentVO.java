package vo;

// 학생 저장할 필드 선언, 기본 생성자, 전체 필드 초기화하는 생성자, set/get, toString
public class StudentVO {
	private String studentNo;
	private String studentName;
	private String majorName;
	private double studentScore;

	public StudentVO() {
	}
	
	public StudentVO(String studentNo, String studentName, String majorName, double studentScore) {
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.majorName = majorName;
		this.studentScore = studentScore;
	}


	@Override
	public String toString() {
		return "학번 = " + studentNo + ", 이름 = " + studentName + ", 학과 = " + majorName
				+ ", 학점 = " + studentScore;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public double getStudentScore() {
		return studentScore;
	}

	public void setStudentScore(double studentScore) {
		this.studentScore = studentScore;
	}

}
