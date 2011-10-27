package models.enums;

public enum LengthUnit {
	MILES("Miles", 1609.34f),
	KILOMETRES("Kilometres", 1000);

	private String label;
	private float inMetres;

	LengthUnit(String label, float inMetres) {
		this.label = label;
		this.inMetres = inMetres;
	}

	public String getLabel() {
		return label;
	}

	public float getInMetres() {
		return inMetres;
	}
	
}