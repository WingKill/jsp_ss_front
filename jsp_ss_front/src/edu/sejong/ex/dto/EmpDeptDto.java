package edu.sejong.ex.dto;

public class EmpDeptDto {

	private int empNo;
	private String ename;
	private String job;
	private String mgr;
	private String hiredate;
	private int sal;
	private String comm;
	private int deptno;
	
	private DeptVo deptVo;
	
	
	public EmpDeptDto() {
		// TODO Auto-generated constructor stub
	}
	
	public EmpDeptDto(int empNo,String ename,String job,String mgr,String hiredate,int sal,String comm,int deptno, DeptVo deptVo) {
		this.empNo = empNo;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
		this.deptVo = deptVo;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getMgr() {
		return mgr;
	}

	public void setMgr(String mgr) {
		this.mgr = mgr;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public String getComm() {
		return comm;
	}

	public void setComm(String comm) {
		this.comm = comm;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public DeptVo getDeptVo() {
		return deptVo;
	}

	public void setDeptVo(DeptVo deptVo) {
		this.deptVo = deptVo;
	}
}