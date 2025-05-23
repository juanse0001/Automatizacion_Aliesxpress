package co.com.AutoFacebook.models;

public class ProductSearchData {
    private final String term;
    private final String category;

    public ProductSearchData(String term, String category) {
        this.term = term;
        this.category = category;
    }

    public String getTerm() { return term; }
    public String getCategory() { return category; }
}
