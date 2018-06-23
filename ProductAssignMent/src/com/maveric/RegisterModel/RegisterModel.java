package com.maveric.RegisterModel;

public class RegisterModel {

	
	private String empId;
	private String empName;
	private String deptCode;
	private String doj;
	private int active;
	private String password;
	
	private String logUserName;
	private String logPwd;
	
	
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLogUserName() {
		return logUserName;
	}
	public void setLogUserName(String logUserName) {
		this.logUserName = logUserName;
	}
	public String getLogPwd() {
		return logPwd;
	}
	public void setLogPwd(String logPwd) {
		this.logPwd = logPwd;
	}
	
}
