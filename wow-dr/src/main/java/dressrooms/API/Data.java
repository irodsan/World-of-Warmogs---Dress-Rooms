/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dressrooms.API;

/**
 *
 * @author ivanr
 */
public class Data {

    public int level;
    public int required_level;
    public int sell_price;
    public ItemSubclass item_subclass;
    public boolean is_equippable;
    public int purchase_quantity;
    public Media media;
    public ItemClass item_class;
    public Quality quality;
    public int max_count;
    public boolean is_stackable;
    public Name name;
    public int purchase_price;
    public int id;
    public InventoryType inventory_type;

    public Data(int level, int required_level, int sell_price, ItemSubclass item_subclass, boolean is_equippable,
            int purchase_quantity, Media media, ItemClass item_class, Quality quality, int max_count,
            boolean is_stackable, Name name, int purchase_price, int id, InventoryType inventory_type) {
        this.level = level;
        this.required_level = required_level;
        this.sell_price = sell_price;
        this.item_subclass = item_subclass;
        this.is_equippable = is_equippable;
        this.purchase_quantity = purchase_quantity;
        this.media = media;
        this.item_class = item_class;
        this.quality = quality;
        this.max_count = max_count;
        this.is_stackable = is_stackable;
        this.name = name;
        this.purchase_price = purchase_price;
        this.id = id;
        this.inventory_type = inventory_type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getRequired_level() {
        return required_level;
    }

    public void setRequired_level(int required_level) {
        this.required_level = required_level;
    }

    public int getSell_price() {
        return sell_price;
    }

    public void setSell_price(int sell_price) {
        this.sell_price = sell_price;
    }

    public ItemSubclass getItem_subclass() {
        return item_subclass;
    }

    public void setItem_subclass(ItemSubclass item_subclass) {
        this.item_subclass = item_subclass;
    }

    public boolean isIs_equippable() {
        return is_equippable;
    }

    public void setIs_equippable(boolean is_equippable) {
        this.is_equippable = is_equippable;
    }

    public int getPurchase_quantity() {
        return purchase_quantity;
    }

    public void setPurchase_quantity(int purchase_quantity) {
        this.purchase_quantity = purchase_quantity;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public ItemClass getItem_class() {
        return item_class;
    }

    public void setItem_class(ItemClass item_class) {
        this.item_class = item_class;
    }

    public Quality getQuality() {
        return quality;
    }

    public void setQuality(Quality quality) {
        this.quality = quality;
    }

    public int getMax_count() {
        return max_count;
    }

    public void setMax_count(int max_count) {
        this.max_count = max_count;
    }

    public boolean isIs_stackable() {
        return is_stackable;
    }

    public void setIs_stackable(boolean is_stackable) {
        this.is_stackable = is_stackable;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public int getPurchase_price() {
        return purchase_price;
    }

    public void setPurchase_price(int purchase_price) {
        this.purchase_price = purchase_price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public InventoryType getInventory_type() {
        return inventory_type;
    }

    public void setInventory_type(InventoryType inventory_type) {
        this.inventory_type = inventory_type;
    }

}
