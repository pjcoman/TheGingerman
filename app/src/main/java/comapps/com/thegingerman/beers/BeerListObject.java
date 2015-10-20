package comapps.com.thegingerman.beers;

public class BeerListObject {

    private String beername;
    private String beerwherefrom;
    private String group;
    private String beerstyle;
    private Double beerabv;
    private Double beerprice;
    
    public String getBeerName() {
        return beername;
    }

    public void setBeerName(String beername) {
        this. beername = beername;
    }
    
    public String getBeerWhereFrom() {
        return beerwherefrom;
    }

    public void setBeerWhereFrom(String beerwherefrom) {
        this.beerwherefrom = beerwherefrom;
    }

    public String getBeerStyle() {
        return beerstyle;
    }

    public void setBeerStyle(String beerstyle) {
        this.beerstyle = beerstyle;
    }
    
    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Double getBeerABV() {
        return beerabv;
    }

    public void setBeerABV(Double beerabv) {
        this.beerabv = beerabv;
    }

    public Double getBeerPrice() {
        return beerprice;
    }

    public void setBeerPrice(Double beerprice) {
        this.beerprice = beerprice;
    }



    @Override
    public String toString() {
        return "BeerList [beername=" +  beername + ", beerstyle=" + beerstyle + ", group=" + group +
                "beerabv" + beerabv.toString() + ", beerwhere=" + beerwherefrom + ", beerprice=" + beerprice.toString() + "]";
    }


}
