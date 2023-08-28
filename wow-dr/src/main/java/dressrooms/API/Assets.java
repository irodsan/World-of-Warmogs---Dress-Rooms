/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dressrooms.API;

/**
 *
 * @author ivanr
 */
public class Assets {

    private String key;
    private String value;
    private int file_data_id;

    public Assets(String key, String value, int file_data_id) {
        this.key = key;
        this.value = value;
        this.file_data_id = file_data_id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getFile_data_id() {
        return file_data_id;
    }

    public void setFile_data_id(int file_data_id) {
        this.file_data_id = file_data_id;
    }

    @Override
    public String toString() {
        return "Assets{" + "key=" + key + ", value=" + value + ", file_data_id=" + file_data_id + '}';
    }

}
