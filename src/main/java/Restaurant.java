
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    // Return True if Restaurant Open at a given time
    public boolean isRestaurantOpen(LocalTime time) {
        if(time.isAfter(openingTime)&&time.isBefore(closingTime)){
            return true;
        } else {
            return false;
        }
    }

    public LocalTime getCurrentTime(){ return  LocalTime.now(); }

    // Return the list of Menu items
    public List<Item> getMenu() {
        return menu;
    }

    private Item findItemByName(String itemName){
        for(Item item: menu) {
            if(item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name,price);
        menu.add(newItem);
    }
    
    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }

    // getTotalCost Method will take a list<String> as parameter and return total amount of items in list
    public int getTotalCost(List<String> item){
        int totalCost = 0;
        for(Item item1: menu){
            for(int i=0;i< item.size();i++){
                if(item1.getName().equals(item.get(i))){
                    totalCost += item1.getPrice();
                }
            }
        }
        return totalCost;
    }

    public void displayDetails(){
        System.out.println("Restaurant:"+ name + "\n"
                +"Location:"+ location + "\n"
                +"Opening time:"+ openingTime +"\n"
                +"Closing time:"+ closingTime +"\n"
                +"Menu:"+"\n"+getMenu());

    }

    public String getName() {
        return name;
    }

}
