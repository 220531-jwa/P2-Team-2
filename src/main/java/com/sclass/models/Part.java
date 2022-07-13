package com.sclass.models;

public class Part {

	public enum partType {
		MOBO {
			@Override
			public String toString() {
				return "Motherboard";
			}
		},
		CPU {
			@Override
			public String toString() {
				return "CPU";
			}
		},
		RAM {
			@Override
			public String toString() {
				return "RAM";
			}
		},
		STORAGE {
			@Override
			public String toString() {
				return "Storage";
			}
		},
		PSU {
			@Override
			public String toString() {
				return "Power Supply Unit";
			}
		},
		CASE {
			@Override
			public String toString() {
				return "Case";
			}
		}
	}

	public enum manufacturer {
		AMD {
			@Override
			public String toString() {
				return "AMD";
			}
		},
		INTEL {
			@Override
			public String toString() {
				return "Intel";
			}
		}
	}

	private int partId;
	private String partName;
	private partType partType;
	private int partWattage;
	private double partPrice;
	private manufacturer manufacturer;
	private int ramSlots;

	public Part() {
	}

	public Part(int partId, String partName, Part.partType partType, int partWattage, double partPrice,
			Part.manufacturer manufacturer, int ramSlots) {
		super();
		this.partId = partId;
		this.partName = partName;
		this.partType = partType;
		this.partWattage = partWattage;
		this.partPrice = partPrice;
		this.manufacturer = manufacturer;
		this.ramSlots = ramSlots;
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

	public int getRamSlots() {
		return ramSlots;
	}

	public void setRamSlots(int ramSlots) {
		this.ramSlots = ramSlots;
	}

	@Override
	public String toString() {
		return "Part [partId=" + partId + ", partName=" + partName + ", partType=" + partType + ", partWattage="
				+ partWattage + ", partPrice=" + partPrice + ", manufacturer=" + manufacturer + ", ramSlots=" + ramSlots
				+ "]";
	}
}
