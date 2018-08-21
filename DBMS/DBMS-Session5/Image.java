/**
 * This class stores Image Url with their product Id
 * 
 * @author Shubham Jain
 *
 */
public class Image {
    private int productId;
    private String imageUrl;

    Image(int productId, String imageUrl) {
        this.productId = productId;
        this.imageUrl = imageUrl;
    }

    /**
     * Returns product Id
     * 
     * @return
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Returns Image Url
     * 
     * @return
     */
    public String getImage() {
        return imageUrl;
    }
}