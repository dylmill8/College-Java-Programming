public class Shoe {

    private int retailPrice;
    private int resalePrice;
    private String resellerMarket;
    private String shoeName;

    public Shoe(String shoeName, int retailPrice, String resellerMarket) {
        this.shoeName = shoeName;
        this.retailPrice = retailPrice;
        this.resellerMarket = resellerMarket;
        this.resalePrice = (2 * this.retailPrice) + 50;
    }

    public int getRetailPrice() {
        return this.retailPrice;
    }

    public int getResalePrice() {
        return this.resalePrice;
    }

    public String getShoeName() {
        return this.shoeName;
    }

    public String getResellerMarket() {
        return this.resellerMarket;
    }

    public void setShoeName(String shoeName) {
        this.shoeName = shoeName;
    }

    public void setRetailPrice(int retailPrice) {
        this.retailPrice = retailPrice;
    }

    public void setResalePrice(int resalePrice) {
        this.resalePrice = resalePrice;
    }

    public void setResellerMarket(String resellerMarket) {
        this.resellerMarket = resellerMarket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }

        Shoe s = (Shoe) o;
        return this.resalePrice == s.getResalePrice() && this.getRetailPrice() == s.getRetailPrice() &&
                this.getShoeName().equals(s.getShoeName()) && this.getResellerMarket().equals(s.getResellerMarket());
    }
}
