/**
 * This interface is for FixedOrderPromotion and FixedProductPromotion
 * 
 * @author Shubham Jain
 *
 */
public interface Promotion {

	void setMinimumPrice(int minPrice);

	void setFixedDiscount(int discount);

	int getFixedDiscount();

	int getMinimumPrice();

	boolean isPromotionApplicable(String code);
	
}
