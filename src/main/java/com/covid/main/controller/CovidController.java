package com.covid.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.covid.main.entity.CovidData;
import com.covid.main.service.DataService;

@Controller
public class CovidController {

	@Autowired
	private DataService dataService;

	@GetMapping("/")
	public String home(Model model) {
		List<CovidData> listOfConfirmedCasesData = dataService.getListOfConfirmedCasesData();
		List<CovidData> listOfDeathCasesData = dataService.getListOfDeathsData();
		List<CovidData> listOfRecoverCasesData = dataService.getListOfRecoveredData();

		List<CovidData> listOfConfirmedCasesByCountry = dataService.getListOfConfirmedCasesByCountry();
		List<CovidData> listOfdeathCasesByCountry = dataService.getListOfDeathCasesByCountry();
		List<CovidData> listOfrecoveredCasesByCountry = dataService.getListOfRecoveredCasesByCountry();

		// get total confirmed cases of covid data
		model.addAttribute("covidConfirmedListOfData", listOfConfirmedCasesData);
		model.addAttribute("totalConfirmedReportedCases", getTotalReportedCase(listOfConfirmedCasesData));
		model.addAttribute("totalConfirmedReportedNewCases", getTotalReportedNewCase(listOfConfirmedCasesData));
		model.addAttribute("confirmedCasesByCountry", listOfConfirmedCasesByCountry);

		// get total death cases of covid data
		model.addAttribute("covidDeathListOfData", listOfDeathCasesData);
		model.addAttribute("totalDeathReportedCases", getTotalReportedCase(listOfDeathCasesData));
		model.addAttribute("totalDeathReportedNewCases", getTotalReportedNewCase(listOfDeathCasesData));
		model.addAttribute("deathCasesByCountry", listOfdeathCasesByCountry);

		// get total recovered cases of covid data
		model.addAttribute("covidRecoveredListOfData", listOfRecoverCasesData);
		model.addAttribute("totalRecoveredReportedCases", getTotalReportedCase(listOfRecoverCasesData));
		model.addAttribute("totalRecoveredReportedNewCases", getTotalReportedNewCase(listOfRecoverCasesData));
		model.addAttribute("recoveredCasesByCountry", listOfrecoveredCasesByCountry);

		return "home";
	}

	private int getTotalReportedCase(List<CovidData> listOfCovidData) {
		return listOfCovidData.stream().mapToInt(data -> data.getTotalCases()).sum();
	}

	private int getTotalReportedNewCase(List<CovidData> listOfCovidData) {
		return listOfCovidData.stream().mapToInt(data -> data.getDiffFromPrevDay()).sum();
	}
}
