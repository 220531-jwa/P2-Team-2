package com.sclass.models;

public class Build {

	private int buildId;
	private int userId;
	private String buildName;
	private int moboId;
	private int cpuId;
	private int ramId;
	private int storageId;
	private int psuId;
	private int caseId;
	private boolean hasFourRAM;
	
	public Build() {}
	
	public Build(int buildId, int userId, String buildName, int moboId, int cpuId, int ramId, int storageId, int psuId, 
			int caseId, boolean hasFourRAM) {
		super();
		this.buildId = buildId;
		this.userId = userId;
		this.buildName = buildName;
		this.moboId = moboId;
		this.cpuId = cpuId;
		this.ramId = ramId;
		this.storageId = storageId;
		this.psuId = psuId;
		this.caseId = caseId;
		this.hasFourRAM = hasFourRAM;
	}

	public int getBuildId() {
		return buildId;
	}

	public void setBuildId(int buildId) {
		this.buildId = buildId;
	}

	public String getBuildName() {
		return buildName;
	}

	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}

	public int getMoboId() {
		return moboId;
	}

	public void setMoboId(int moboId) {
		this.moboId = moboId;
	}

	public int getCpuId() {
		return cpuId;
	}

	public void setCpuId(int cpuId) {
		this.cpuId = cpuId;
	}

	public int getRamId() {
		return ramId;
	}

	public void setRamId(int ramId) {
		this.ramId = ramId;
	}

	public int getStorageId() {
		return storageId;
	}

	public void setStorageId(int storageId) {
		this.storageId = storageId;
	}

	public int getPsuId() {
		return psuId;
	}

	public void setPsuId(int psuId) {
		this.psuId = psuId;
	}

	public int getCaseId() {
		return caseId;
	}

	public void setCaseId(int caseId) {
		this.caseId = caseId;
	}

	public boolean isHasFourRAM() {
		return hasFourRAM;
	}

	public void setHasFourRAM(boolean hasFourRAM) {
		this.hasFourRAM = hasFourRAM;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Build [buildId=" + buildId + ", userId=" + userId + ", buildName=" + buildName + ", moboId=" + moboId
				+ ", cpuId=" + cpuId + ", ramId=" + ramId + ", storageId=" + storageId + ", psuId=" + psuId
				+ ", caseId=" + caseId + ", hasFourRAM=" + hasFourRAM + "]";
	}
}
