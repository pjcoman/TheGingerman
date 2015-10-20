package comapps.com.thegingerman.drinks;

public class DrinkListObject {

    private String drinkname;
    private String drinkwherefrom;
    private String group;
    private String drinkstyle;
    private Double drinkabv;
    private Double drinkprice;

    public String getDrinkName() {
        return drinkname;
    }

    public void setDrinkName(String drinkname) {
        this. drinkname = drinkname;
    }

    public String getDrinkWhereFrom() {
        return drinkwherefrom;
    }

    public void setDrinkWhereFrom(String drinkwherefrom) {
        this.drinkwherefrom = drinkwherefrom;
    }

    public String getDrinkStyle() {
        return drinkstyle;
    }

    public void setDrinkStyle(String drinkstyle) {
        this.drinkstyle = drinkstyle;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Double getDrinkABV() {
        return drinkabv;
    }

    public void setDrinkABV(Double drinkabv) {
        this.drinkabv = drinkabv;
    }

    public Double getDrinkPrice() {
        return drinkprice;
    }

    public void setDrinkPrice(Double drinkprice) {
        this.drinkprice = drinkprice;
    }



    @Override
    public String toString() {
        return "DrinkList [drinkname=" +  drinkname + ", drinkstyle=" + drinkstyle + ", group=" + group +
                "drinkabv" + drinkabv.toString() + ", drinkwhere=" + drinkwherefrom + ", drinkprice=" + drinkprice.toString() + "]";
    }


}