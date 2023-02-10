package tfip.ssf.day15.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Cart implements Serializable{
    private List<Item> contents = new LinkedList<>();

    public List<Item> getContents() {
        return contents;
    }

    public void setContents(List<Item> contents) {
        this.contents = contents;
    }

    public void addItemToCart(Item item){
        this.contents.add(item);
    }
}
