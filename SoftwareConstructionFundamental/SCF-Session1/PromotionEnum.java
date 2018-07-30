import java.util.Date;

/**
 * This Enum has promocodes with their starting date and end date.
 * 
 * @author Shubham Jain
 *
 */
public enum PromotionEnum {

	Enum1("ABCD", "01-01-2018", "12-10-2018"), 
	Enum2("EFGH", "01-03-2018", "12-11-2018"),
	Enum3("IJKL", "01-05-2018", "12-12-2018"), 
	Enum4("MNOP", "01-07-2018", "22-12-2018");

	private String code;
	private String startDate;
	private String endDate;

	/**
	 * It will set the code, start date and end date of promo codes.
	 * @param code
	 * @param startDate
	 * @param endDate
	 */
	private PromotionEnum(String code, String startDate, String endDate) {
		this.code = code;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getCode() {
		return code;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}
}
