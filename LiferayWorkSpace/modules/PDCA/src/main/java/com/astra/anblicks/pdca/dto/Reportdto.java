package com.astra.anblicks.pdca.dto;

public class Reportdto {
	
	private long cid;
	private long pid;
	private double value;
	private String type;
	
	public Reportdto(long cid, long pid, double value, String type) {
		super();
		this.cid = cid;
		this.pid = pid;
		this.value = value;
		this.type = type;
	}
	
	

	public Reportdto() {
		super();
		// TODO Auto-generated constructor stub
	}



	public long getCid() {
		return cid;
	}
	public void setCid(long cid) {
		this.cid = cid;
	}
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Reportdto [cid=" + cid + ", pid=" + pid + ", value=" + value + ", type=" + type + "]";
	}

}
