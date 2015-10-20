package comapps.com.thegingerman.menu;

public class MenuListObject {

    private String item;
    private String group;
    private String description;
    private String price;


    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "MenuList [item=" + item + ", " + "description=" + description + "group=" + group + "price=" + price +"]";
    }


}
