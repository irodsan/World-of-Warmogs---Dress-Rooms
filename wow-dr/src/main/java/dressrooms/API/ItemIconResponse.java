/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dressrooms.API;

/**
 *
 * @author ivanr
 */
public class ItemIconResponse {
    private Assets assets[];
    private int id;

    public ItemIconResponse(Assets[] assets, int id) {
        this.assets = assets;
        this.id = id;
    }

    public Assets[] getAssets() {
        return assets;
    }

    public void setAssets(Assets[] assets) {
        this.assets = assets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ItemIcon{" + "assets=" + assets + ", id=" + id + '}';
    }

}
