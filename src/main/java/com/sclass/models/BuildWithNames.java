package com.sclass.models;

public class BuildWithNames {

	private int buildId;
//	private int userId;
	private String buildName;
	private String moboName;
	private String cpuName;
	private String ramName;
	private String storageName;
	private String psuName;
	private String caseName;
	private boolean hasFourRAM;
	private double totalCost;
	public BuildWithNames() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BuildWithNames(int buildId, String buildName, String moboName, String cpuName, String ramName,
			String storageName, String psuName, String caseName, boolean hasFourRAM, double totalCost) {
		super();
		this.buildId = buildId;
//		this.userId = userId;
		this.buildName = buildName;
		this.moboName = moboName;
		this.cpuName = cpuName;
		this.ramName = ramName;
		this.storageName = storageName;
		this.psuName = psuName;
		this.caseName = caseName;
		this.hasFourRAM = hasFourRAM;
		this.totalCost = totalCost;
	}
	public int getBuildId() {
		return buildId;
	}
	public void setBuildId(int buildId) {
		this.buildId = buildId;
	}
//	public int getUserId() {
//		return userId;
//	}
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
	public String getBuildName() {
		return buildName;
	}
	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}
	public String getMoboName() {
		return moboName;
	}
	public void setMoboName(String moboName) {
		this.moboName = moboName;
	}
	public String getCpuName() {
		return cpuName;
	}
	public void setCpuName(String cpuName) {
		this.cpuName = cpuName;
	}
	public String getRamName() {
		return ramName;
	}
	public void setRamName(String ramName) {
		this.ramName = ramName;
	}
	public String getStorageName() {
		return storageName;
	}
	public void setStorageName(String storageName) {
		this.storageName = storageName;
	}
	public String getPsuName() {
		return psuName;
	}
	public void setPsuName(String psuName) {
		this.psuName = psuName;
	}
	public String getCaseName() {
		return caseName;
	}
	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}
	public boolean isHasFourRAM() {
		return hasFourRAM;
	}
	public void setHasFourRAM(boolean hasFourRAM) {
		this.hasFourRAM = hasFourRAM;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	@Override
	public String toString() {
		return "BuildWithNames [buildId=" + buildId + ", buildName=" + buildName + ", moboName=" + moboName
				+ ", cpuName=" + cpuName + ", ramName=" + ramName + ", storageName=" + storageName + ", psuName="
				+ psuName + ", caseName=" + caseName + ", hasFourRAM=" + hasFourRAM + ", totalCost=" + totalCost + "]";
	}

	
	
	
	
}
