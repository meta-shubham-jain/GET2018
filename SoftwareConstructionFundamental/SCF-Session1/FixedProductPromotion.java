import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class contains details regarding product promocode
 * 
 * @author Shubham Jain
 *
 */
public class FixedProductPromotion implements Promotion {
	private int discount;
	private int minPrice;

	public void setFixedDiscount(int discount) {
		this.discount = discount;
	}

	public void setMinimumPrice(int minPrice) {
		this.minPrice = minPrice;
	}

	public int getFixedDiscount() {
		return discount;
	}

	public int getMinimumPrice() {
		return minPrice;
	}

	/**
	 * It will check whether promocode is applicable on product or not
	 */
	public boolean isPromotionApplicable(String code) {

		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		long start = 0;
		long end = 0;
		long current = 0;

		for (PromotionEnum promo : PromotionEnum.values()) {
			try {
				Date startDate = (Date) simpleDateFormat.parse(promo.getStartDate());
				Date endDate = (Date) simpleDateFormat.parse(promo.getEndDate());

				start = startDate.getTime();
				end = endDate.getTime();
				current = date.getTime();

			} catch (Exception ex) {
				ex.printStackTrace();
			}

			if (promo.getCode().equals(code) && current < end && current > start) {
				System.out.println("Promocode Applied on Product");
				return true;
			}
		}
		return false;
	}

}
