package com.scg.domain;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Encapsulates a time card capable of storing a consultant's billable and
 * non-billable hours for a week.
 * 
 * @author chq-alexs
 *
 */
public final class TimeCard {

	/**
	 * The Consultant whose information this TimeCard records.
	 */
	private final Consultant consultant;

	/**
	 * weekStartingDay - The date of the first work day of the week this
	 * TimeCard records information for.
	 */
	private final LocalDate weekStartingDay;

	/**
	 * billableHours - The number of billable hours on a timecard.
	 */
	private int billableHours;

	/**
	 * totalNonBillableHours - The number of nonbillable hours on a timecard.
	 */
	private int totalNonBillableHours;

	/**
	 * consultingHours - List of consulting hours in timecard.
	 */
	private List<ConsultantTime> consultingHours = new ArrayList<ConsultantTime>();

	/**
	 * totalHours - Total hours in a timecard as a int.
	 */
	private int totalHours;

	/**
	 * Creates a new instance of TimeCard
	 * 
	 * @param consultant
	 *            - The Consultant whose information this TimeCard records.
	 * 
	 * @param weekStartingDay
	 *            - The date of the first work day of the week this TimeCard
	 *            records information for.
	 * 
	 */
	public TimeCard(Consultant consultant, LocalDate weekStartingDay) {
		this.consultant = consultant;
		this.weekStartingDay = weekStartingDay;

	}

	/**
	 * Getter for property consultant.
	 * 
	 * @return Value of property consultant.
	 */
	public Consultant getConsultant() {
		return this.consultant;
	}

	/**
	 * Getter for property billableHours.
	 * 
	 * @return Value of property billableHours.
	 * 
	 */
	public int getTotalBillableHours() {
		return this.billableHours;
	}

	/**
	 * Getter for property totalNonBillableHours.
	 * 
	 * @return Value of property totalNonBillableHours.
	 * 
	 */
	public int getTotalNonBillableHours() {
		return this.totalNonBillableHours;
	}

	/**
	 * Getter for property consultingHours.
	 * 
	 * @return Value of property consultingHours.
	 * 
	 */
	public List<ConsultantTime> getConsultingHours() {
		return this.consultingHours;
	}

	/**
	 * Add a ConsultantTime object to this TimeCard.
	 * 
	 * @param consultantTime
	 *            - The ConsultantTime to add.
	 */
	public void addConsultantTime(ConsultantTime consultantTime) {

		this.consultingHours.add(consultantTime);

		this.totalHours += consultantTime.getHours();

		if (consultantTime.isBillable()) {
			this.billableHours += consultantTime.getHours();
		} else {
			this.totalNonBillableHours += consultantTime.getHours();
		}
	}

	/**
	 * Getter for property totalHours.
	 * 
	 * @return Value of property totalHours.
	 * 
	 */
	public int getTotalHours() {
		return this.totalHours;
	}

	/**
	 * Getter for property weekStartingDay.
	 * 
	 * @return Value of property weekStartingDay.
	 * 
	 */
	public LocalDate getWeekStartingDay() {
		return this.weekStartingDay;
	}

	/**
	 * Returns the billable hours (if any) in this TimeCard for the specified
	 * Client.
	 * 
	 * @param clientName
	 *            - name of the client to extract hours for.
	 * 
	 * @return list of billable hours for the client.
	 * 
	 */

	public List<ConsultantTime> getBillableHoursForClient(String clientName) {

		List<ConsultantTime> clientBillableHours = new ArrayList<ConsultantTime>();

		for (ConsultantTime temp : getConsultingHours()) {
			if (temp.getAccount().getName().equals(clientName)) {
				clientBillableHours.add(temp);
			}
		}

		// WILL NEED FURTHER RESEARCH!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		// List<ConsultantTime> billableHoursByClient;

		return clientBillableHours;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String str = this.consultant.getName().toString() + " "
				+ getWeekStartingDay().format(DateTimeFormatter.ofPattern("yyy MM dd"));
		return str;

	}

	/**
	 * Create a string representation of this object, suitable for printing the
	 * entire time card.
	 * 
	 * @return this TimeCard as a formatted String.
	 * 
	 */
	public String toReportString() {

		String headerSplitter = "====================================================================";
		String consultantHeader = "Consultant: ";
		String weekHeader = "Week Starting: ";
		String billableTimeHeader = "Billable Time:";
		String accountHeader = "Account";
		String accountSplitter = "---------------------------";
		String dateHeader = "Date";
		String dateSplitter = "----------";
		String hourHeader = "Hours";
		String hourSplitter = "-----";
		String skillHeader = "Skill";
		String skillSplitter = "--------------------";
		String nonBillableTimeHeader = "Non-billable Time:";
		String summaryHeader = "Summary:";
		String totalBillable = "Total Billable:";
		String totalNonBillable = "Total Non-Billable:";
		String totalHours = "Total Hours:";

		StringBuilder reportBuilder = new StringBuilder();

		// System.out.println(headerSplitter);
		reportBuilder.append(headerSplitter + "\n");
		/*
		 * System.out.printf("%-34s %34s %n", consultantHeader +
		 * getConsultant(), weekHeader +
		 * getWeekStartingDay().format(DateTimeFormatter.ofPattern("MMM dd, yyy"
		 * )) + "\n");
		 */
		reportBuilder.append(String.format("%-34s %34s %n", consultantHeader + getConsultant(),
				weekHeader + getWeekStartingDay().format(DateTimeFormatter.ofPattern("MMM dd, yyy")) + "\n"));

		// System.out.println(billableTimeHeader);
		reportBuilder.append(billableTimeHeader + "\n");

		// System.out.printf("%-28s %-11s %-6s %-21s %n", accountHeader,
		// dateHeader, hourHeader, skillHeader);

		reportBuilder
				.append(String.format("%-28s %-11s %-6s %-21s %n", accountHeader, dateHeader, hourHeader, skillHeader));

		// System.out.printf("%-28s %-11s %-6s %-21s %n", accountSplitter,
		// dateSplitter, hourSplitter, skillSplitter);

		reportBuilder.append(
				String.format("%-28s %-11s %-6s %-21s %n", accountSplitter, dateSplitter, hourSplitter, skillSplitter));

		for (ConsultantTime temp : this.consultingHours) {

			if (temp.getAccount().isBillable()) {
				/*
				 * System.out.printf("%-28s %-11s %5s %-21s %n",
				 * temp.getAccount().getName(),
				 * temp.getDate().format(DateTimeFormatter.ofPattern("MM/dd/yyy"
				 * )), temp.getHours(), temp.getSkill());
				 */
				reportBuilder.append(String.format("%-28s %-11s %5s %-21s %n", temp.getAccount().getName(),
						temp.getDate().format(DateTimeFormatter.ofPattern("MM/dd/yyy")), temp.getHours(),
						temp.getSkill()));
			}
		}

		// System.out.println("");

		// System.out.println(nonBillableTimeHeader);
		reportBuilder.append(nonBillableTimeHeader + "\n");

		// System.out.printf("%-28s %-11s %-6s %-21s %n", accountHeader,
		// dateHeader, hourHeader, skillHeader);

		reportBuilder
				.append(String.format("%-28s %-11s %-6s %-21s %n", accountHeader, dateHeader, hourHeader, skillHeader));

		// System.out.printf("%-28s %-11s %-6s %-21s %n", accountSplitter,
		// dateSplitter, hourSplitter, skillSplitter);

		reportBuilder.append(
				String.format("%-28s %-11s %-6s %-21s %n", accountSplitter, dateSplitter, hourSplitter, skillSplitter));

		for (ConsultantTime temp : this.consultingHours) {

			if (!temp.getAccount().isBillable()) {
				/*
				 * System.out.printf("%-28s %-11s %5s %-21s %n",
				 * temp.getAccount().getName(),
				 * temp.getDate().format(DateTimeFormatter.ofPattern("MM/dd/yyy"
				 * )), temp.getHours(), temp.getSkill());
				 */
				reportBuilder.append(String.format("%-28s %-11s %5s %-21s %n", temp.getAccount().getName(),
						temp.getDate().format(DateTimeFormatter.ofPattern("MM/dd/yyy")), temp.getHours(),
						temp.getSkill()));

			}
		}

		// System.out.println("");
		reportBuilder.append("\n");

		// System.out.println(summaryHeader);
		reportBuilder.append(summaryHeader + "\n");

		// System.out.printf("%-20s %23s %n", totalBillable,
		// getTotalBillableHours());
		reportBuilder.append(String.format("%-20s %25s %n", totalBillable, getTotalBillableHours()));

		// System.out.printf("%-20s %23s %n", totalNonBillable,
		// getTotalNonBillableHours());
		reportBuilder.append(String.format("%-20s %25s %n", totalNonBillable, getTotalNonBillableHours()));

		// System.out.printf("%-20s %23s %n", totalHours, getTotalHours());
		reportBuilder.append(String.format("%-20s %25s %n", totalHours, getTotalHours()));

		// System.out.println(headerSplitter);
		reportBuilder.append(headerSplitter + "\n");

		String report = reportBuilder.toString();
		return report;
	}

}
