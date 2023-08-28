package dressrooms.controller;

import org.springframework.stereotype.Controller;

import dressrooms.API.ItemIcon;
import dressrooms.API.ItemIconResponse;
import dressrooms.API.ItemResponse;
import dressrooms.API.Item;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@Controller
public class APIController {

    public static void cargarItem(Integer inicio, Integer fin, String token) throws Exception {

        for (int id = inicio; id < fin; id++) {
            System.out.println("PROCESANDO ID: " + id);
            // String token = "EUdtf1IPJJ2zgz1FnlJINlc1QQWYd288gA";
            String URL = "https://eu.api.blizzard.com/data/wow/media/item/" + id
                    + "?namespace=static-eu&locale=es_ES&access_token=" + token;
            String jsonResponse = peticionHttpGet("https://eu.api.blizzard.com/data/wow/item/" + id
                    + "?namespace=static-eu&locale=es_ES&access_token=" + token);

            if (!jsonResponse.equals("")) {
                Gson gson = new Gson();
                ItemResponse ir = gson.fromJson(jsonResponse, ItemResponse.class);

                Item it = new Item(ir.getId(), ir.getName(), ir.getInventory_type().getType(),
                        ir.getItem_subclass().getName(), ir.getQuality().getType());

                System.out.println(it);
                if (!it.getRanura().equals("NON_EQUIP")) {
                    // saveItem(it);
                }
            }

            if (id % 10 == 0) {
                try {
                    Thread.sleep(1000); // Wait for 2 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void cargarItemIcon(Integer inicio, Integer fin, String token) throws Exception {
        for (int id = inicio; id < fin; id++) {
            System.out.println("PROCESANDO ID: " + id);
            String jsonResponse = peticionHttpGet("https://eu.api.blizzard.com/data/wow/media/item/" + id
                    + "?namespace=static-eu&locale=es_ES&access_token=EUnpU5Psx7K91296wSmkbTLmQtK8Vdz4Dw");

            if (!jsonResponse.equals("")) {
                Gson gson = new Gson();
                ItemIconResponse iir = gson.fromJson(jsonResponse, ItemIconResponse.class);

                if (iir.getAssets() != null) {
                    ItemIcon ii = new ItemIcon(iir.getId(), iir.getAssets()[0].getValue());
                    // saveItemIcon(ii);
                }
            }

            if (id % 10 == 0) {
                try {
                    Thread.sleep(2000); // Wait for 2 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static String peticionHttpGet(String urlParaVisitar) throws Exception {
        StringBuilder resultado = new StringBuilder();
        URL url = new URL(urlParaVisitar);
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("GET");

        if (conexion.getResponseCode() == 200) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream(), "UTF-8"));
            String linea;

            while ((linea = rd.readLine()) != null) {
                resultado.append(linea);
            }
            rd.close();
        }
        return resultado.toString();
    }

    public static void saveItem(Item it) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wowdr", "root", "");
            Statement stmt = con.createStatement();
            String q = "INSERT INTO `items_icons`(`id`, `url`) VALUES ('" + it.getId() + "','" + it.getNombre() + "','"
                    + it.getRanura() + "','" + it.getTipo() + "','" + it.getQuality() + "')";

            int rs = stmt.executeUpdate(q);

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void saveItemIcon(ItemIcon ii) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wowdr", "root", "");
            Statement stmt = con.createStatement();
            String q = "INSERT INTO `items_icons`(`id`, `url`) VALUES ('" + ii.getId() + "','" + ii.getUrl() + "')";

            int rs = stmt.executeUpdate(q);

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
