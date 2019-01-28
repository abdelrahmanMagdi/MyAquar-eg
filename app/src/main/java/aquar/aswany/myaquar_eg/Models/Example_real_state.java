package aquar.aswany.myaquar_eg.Models;

public class Example_real_state   {

 private String text;

    public Example_real_state(String text, int image_real_stat) {
        this.text = text;
        this.image_real_stat = image_real_stat;
    }

    public String getText() {
        return text;
    }

    private int image_real_stat;

    public int getImage_real_stat() {
        return image_real_stat;
    }



}
