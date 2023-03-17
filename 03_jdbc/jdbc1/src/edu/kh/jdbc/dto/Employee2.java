package edu.kh.jdbc.dto;

public class Employee2 {

	private String deptName;
	private String jobName;
	private String empName;
	private String email;
	
	public Employee2() {}
	public Employee2(String deptName, String jobName, String empName, String email) {
		this.deptName = deptName;
		this.jobName = jobName;
		this.empName = empName;
		this.email = email;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
