package com.mycgv_jsp.vo;
//	폼 -- > email1, email2, addr1, addr2, phone1, phone2, phone3, hobby
//	테이블 -- > rno, email, addr, pnumber, hobbyList, mdate
//	폼&테이블 -- > id, pass, name, gender, tel , intro

public class MemberVo {
	//폼에서 넘어오는 모든 name/value 저장
	String id, pass, name, gender, email1, email2, addr1, addr2, tel, phone1, phone2, phone3, intro; 
	String[] hobby;
	
	//member 테이블 컬럼 매핑
	int rno;
	String email, addr, pnumber, hobbyList, mdate, grade;
	
//	email --> 폼에서 set X, 테이블 set O
//	email --> 폼에서 get O(email1+"@'"+email2)
	
	
	public String getId() {
		return id;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getPhone3() {
		return phone3;
	}
	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getEmail() {
		if(email1 != null) { //폼에서 email 주소가 넘어온 경우 
			email = email1+"@"+email2;
		}
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddr() {
		if(addr1 != null) {
			addr = addr1 + addr2;
		}
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPnumber() {
		if(phone1 != null) {
			pnumber = phone1+"-"+phone2+"-"+phone3;
		}
		return pnumber;
	}
	public void setPnumber(String pnumber) {
		this.pnumber = pnumber;
	}
	public String getHobbyList() {
		if(hobby != null) {
			hobbyList = String.join(",", hobby);
		}
		return hobbyList;
	}
	public void setHobbyList(String hobbyList) {
		this.hobbyList = hobbyList;
	}
	public String getMdate() {
		return mdate;
	}
	public void setMdate(String mdate) {
		this.mdate = mdate;
	}
	
	
}
