package com.covid.main.entity;

public class CovidData {

	private String state;
	private String country;
	private int totalCases;
	private int diffFromPrevDay;

	public CovidData(String country, int totalCases) {
		super();
		this.country = country;
		this.totalCases = totalCases;
	}

	public CovidData(String state, String country, int totalCases) {
		super();
		this.state = state;
		this.country = country;
		this.totalCases = totalCases;
	}

	public CovidData(String state, String country, int totalCases, int diffFromPrevDay) {
		super();
		this.state = state;
		this.country = country;
		this.totalCases = totalCases;
		this.diffFromPrevDay = diffFromPrevDay;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getTotalCases() {
		return totalCases;
	}

	public void setTotalCases(int totalCases) {
		this.totalCases = totalCases;
	}

	public int getDiffFromPrevDay() {
		return diffFromPrevDay;
	}

	public void setDiffFromPrevDay(int diffFromPrevDay) {
		this.diffFromPrevDay = diffFromPrevDay;
	}

	@Override
	public String toString() {
		return "CovidData [state=" + state + ", country=" + country + ", totalCases=" + totalCases + "]";
	}

}
