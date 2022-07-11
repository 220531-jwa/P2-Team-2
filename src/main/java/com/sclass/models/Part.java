package com.sclass.models;

public class Part {

	public enum partType {
		MOBO, CPU, RAM, STORAGE, PSU, CASE
	}

	public enum manufacturer {
		AMD, INTEL
	}

	private int partId;
	private String partName;
	private partType partType;
	private int partWattage;
	private double partPrice;
	private manufacturer manufacturer;

	public Part() {
	}

	public Part(int partId, String partName, Part.partType partType, int partWattage, double partPrice,
			Part.manufacturer manufacturer) {
		super();
		this.partId = partId;
		this.partName = partName;
		this.partType = partType;
		this.partWattage = partWattage;
		this.partPrice = partPrice;
		this.manufacturer = manufacturer;
	}

	public int getPartId() {
		return partId;
	}

	public void setPartId(int partId) {
		this.partId = partId;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public partType getPartType() {
		return partType;
	}

	public void setPartType(partType partType) {
		this.partType = partType;
	}

	public int getPartWattage() {
		return partWattage;
	}

	public void setPartWattage(int partWattage) {
		this.partWattage = partWattage;
	}

	public double getPartPrice() {
		return partPrice;
	}

	public void setPartPrice(double partPrice) {
		this.partPrice = partPrice;
	}

	public manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Override
	public String toString() {
		return "Part [partId=" + partId + ", partName=" + partName + ", partType=" + partType + ", partWattage="
				+ partWattage + ", partPrice=" + partPrice + ", manufacturer=" + manufacturer + "]";
	}

}
