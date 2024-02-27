package edu.sejong.ex.dto;


//이름       널?       유형           
//-------- -------- ------------ 
//EMPNO    NOT NULL NUMBER(4)    
//ENAME             VARCHAR2(10) 
//JOB               VARCHAR2(9)  
//MGR               NUMBER(4)    
//HIREDATE          DATE         
//SAL               NUMBER(7,2)  
//COMM              NUMBER(7,2)  
//DEPTNO            NUMBER(2)
public class EmpDto {
	private int empNo;
	private String ename;
	private String job;
	private String mgr;
	private String hiredate;
	private int sal;
	private String comm;
	private int deptno;
	
	
	public EmpDto() {
	
	}
	
	public EmpDto(int empNo,String ename,String job,String mgr,String hiredate,int sal,String comm,int deptno) {
		this.empNo = empNo;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
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
	
	@Override
	public String toString() {
		return 	"-----------------------------<br>"+
				"사원번호 : "+empNo+"&nbsp&nbsp&nbsp"+
				"사원명: "+ename+"<br>"+
				"직업: "+job+"&nbsp&nbsp&nbsp"+
				"매니저번호: "+mgr+"&nbsp&nbsp&nbsp"+
				"입사일: "+hiredate+"<br>"+
				"월급: "+sal+"&nbsp&nbsp&nbsp"+
				"커미션: "+comm+"&nbsp&nbsp&nbsp"+
				"부서번호: "+deptno+"<br>";
	}
	
//	public String getEmp() {
//		String emp = toString();
//		return emp;
//	}
}
