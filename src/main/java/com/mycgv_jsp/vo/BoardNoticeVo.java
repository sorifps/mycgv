package com.mycgv_jsp.vo;

import java.util.ArrayList;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class BoardNoticeVo {
	String bnid, bntitle, bncontent, bndate, nfile1, nsfile1, nfile2, nsfile2;
	int rno, bnhits;
	CommonsMultipartFile[] files;
	ArrayList<String> nfile = new ArrayList<String>();
	ArrayList<String> nsfile = new ArrayList<String>();
	
	public String getNfile1() {
		return nfile1;
	}
	public void setNfile1(String nfile1) {
		this.nfile1 = nfile1;
	}
	public String getNsfile1() {
		return nsfile1;
	}
	public void setNsfile1(String nsfile1) {
		this.nsfile1 = nsfile1;
	}
	public String getNfile2() {
		return nfile2;
	}
	public void setNfile2(String nfile2) {
		this.nfile2 = nfile2;
	}
	public String getNsfile2() {
		return nsfile2;
	}
	public void setNsfile2(String nsfile2) {
		this.nsfile2 = nsfile2;
	}
	public ArrayList<String> getNfile() {
		return nfile;
	}
	public void setNfile(ArrayList<String> nfile) {
		this.nfile = nfile;
	}
	public ArrayList<String> getNsfile() {
		return nsfile;
	}
	public void setNsfile(ArrayList<String> nsfile) {
		this.nsfile = nsfile;
	}
	public CommonsMultipartFile[] getFiles() {
		return files;
	}
	public void setFiles(CommonsMultipartFile[] files) {
		this.files = files;
	}
	public String getBnid() {
		return bnid;
	}
	public void setBnid(String bnid) {
		this.bnid = bnid;
	}
	public String getBntitle() {
		return bntitle;
	}
	public void setBntitle(String bntitle) {
		this.bntitle = bntitle;
	}
	public String getBncontent() {
		return bncontent;
	}
	public void setBncontent(String bncontent) {
		this.bncontent = bncontent;
	}
	public String getBndate() {
		return bndate;
	}
	public void setBndate(String bndate) {
		this.bndate = bndate;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getBnhits() {
		return bnhits;
	}
	public void setBnhits(int bnhits) {
		this.bnhits = bnhits;
	}
	
	
}
