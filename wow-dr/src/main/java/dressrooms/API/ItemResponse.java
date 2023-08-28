/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dressrooms.API;

/**
 *
 * @author ivanr
 */
public class ItemResponse {

    private int id;
    private String name;
    private ItemSubclass item_subclass;
    private InventoryType inventory_type;
    private Quality quality;

    public ItemResponse() {
    }

    public ItemResponse(int id, String name, ItemSubclass item_subclass, InventoryType inventory_type,
            Quality quality) {
        this.id = id;
        this.name = name;
        this.item_subclass = item_subclass;
        this.inventory_type = inventory_type;
        this.quality = quality;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemSubclass getItem_subclass() {
        return item_subclass;
    }

    public void setItem_subclass(ItemSubclass item_subclass) {
        this.item_subclass = item_subclass;
    }

    public InventoryType getInventory_type() {
        return inventory_type;
    }

    public void setInventory_type(InventoryType inventory_type) {
        this.inventory_type = inventory_type;
    }

    public Quality getQuality() {
        return quality;
    }

    public void setQuality(Quality quality) {
        this.quality = quality;
    }

}