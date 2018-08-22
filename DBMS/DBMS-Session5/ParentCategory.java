/**
 * This class will store title of top category with their count of child
 * category
 * 
 * @author Shubham Jain
 *
 */
public class ParentCategory {
    private String categoryTitle;
    private int countOfChild;

    public ParentCategory(String categoryTitle, int countOfChild) {
        this.categoryTitle = categoryTitle;
        this.countOfChild = countOfChild;
    }

    /**
     * Returns category title
     * 
     * @return
     */
    public String getCategoryTitle() {
        return categoryTitle;
    }

    /**
     * Returns Count Of Child Category
     * 
     * @return
     */
    public int getCountOfChild() {
        return countOfChild;
    }
}