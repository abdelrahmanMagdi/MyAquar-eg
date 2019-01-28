package aquar.aswany.myaquar_eg.Models;

public class SearchLimts {

    /**
     * max_price : 6000
     * min_price : 100
     * max_area : 1000
     * min_area : 5
     */

    private int max_price;
    private int min_price;
    private int max_area;
    private int min_area;

    public int getMax_price() {
        return max_price;
    }

    public void setMax_price(int max_price) {
        this.max_price = max_price;
    }

    public int getMin_price() {
        return min_price;
    }

    public void setMin_price(int min_price) {
        this.min_price = min_price;
    }

    public int getMax_area() {
        return max_area;
    }

    public void setMax_area(int max_area) {
        this.max_area = max_area;
    }

    public int getMin_area() {
        return min_area;
    }

    public void setMin_area(int min_area) {
        this.min_area = min_area;
    }
}
