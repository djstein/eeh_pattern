package com.ibm.mq.exc;

public class Parameter {
	
	private String name;
	private String descr;
	private String member;
	private String type;
	
	public Parameter(String strName, String strDescr) {
		this.setName(strName);
		this.setDescr(strDescr);
	}
	
	public Parameter(String strName, String strMember, String strType){
		this.setName(strName);
		this.setMember(strMember);
		this.setType(strType);
	}

	public String getName() {
		return name;
	}
	
	private void setName(String strName) {
		this.name = strName;
	}
	public String getDescr() {
		return descr;
	}
	
	private void setDescr(String strDescr) {
		this.descr = strDescr;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}
	
}
