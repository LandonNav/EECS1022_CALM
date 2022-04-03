package com.example.calm_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.*;
import java.io.*;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Adding stocks to database
        addStock("Apple, Inc.", "AAPl", 174.31);
        addStock("AirBnB, Inc.", "ABNB", 173.07);
        addStock("Biogen, Inc.", "BIIB", 210.65);
        addStock("Booking Holdings", "BKNG", 2368.83);
        addStock("Costco Holdings", "COST", 575.57);
        addStock("Cisco Systems, Inc.", "CSCO", 55.66);
        addStock("Dollar Tree, Inc.", "DLTR", 159.49);
        addStock("Docusign, Inc.", "DOCU", 108.63);
        addStock("Electronic Arts, Inc.", "EA", 125.23);
        addStock("eBay, Inc.", "EBAY", 57.71);
        addStock("Meta Platforms, Inc.", "FB", 224.85);
        addStock("Fortinet, Inc.", "FTNT", 57.71);
        addStock("Alphabet, Class A, Inc.", "GOOGL", 2814.00);
        addStock("Alphabet, Class C, Inc.", "GOOG", 2803.01);
        addStock("Honeyell International, Inc.", "HON", 196.03);
        addStock("Illumina , Inc.", "ILMN", 363.90);
        addStock("Intel Corporation", "INTC", 48.11);
        addStock("JD.com, Inc.", "JD", 59.09);
        addStock("The Kraft Heinz Company", "KHC", 39.93);
        addStock("Keurig Dr Pepper, Inc.", "KDP", 38.24);
        addStock("lululemon athletica, Inc.", "LULU", 367.44);
        addStock("Lucid Group, Inc.", "LCID", 24.55);
        addStock("Marriott International, Class A.", "MAR", 57.71);
        addStock("MercadoLibre, Inc.", "MELI", 1224.43);
        addStock("Netflix, Inc.", "NFLX", 373.47);
        addStock("NetEase, Inc.", "NTES", 95.81);
        addStock("Okta, Inc.", "OKTA", 148.79);
        addStock("O'Reily Automotive, Inc.", "ORLY", 667.43);
        addStock("PepsiCo, Inc.", "PEP", 169.76);
        addStock("PayPal Holdings, Inc.", "PYPL", 116.67);
        addStock("Qualcom, Inc.", "QCOM", 146.99);
        addStock("Regeneron Pharmaceuticals, Inc.", "REGN", 694.83);
        addStock("Ross Stores, Inc.", "ROST", 90.61);
        addStock("Starbucks Corporation.", "SBUX", 91.49);
        addStock("Seagen, Inc.", "SGEN", 148.89);
        addStock("Tesla, Inc.", "TSLA", 1084.59);
        addStock("Texas Instruments, Inc.", "TXN", 182.08);
        addStock("Verisk Analytics, Inc.", "VRSK", 214.12);
        addStock("Vertex Pharmaceuticals, Inc.", "VRTX", 266.15);
        addStock("Walgreens Boots Alliance, Inc.", "WBA", 43.86);
        addStock("Workday, Inc.", "WDAY", 237.93);
        addStock("Xcel Energy, Inc.", "XEL", 72.75);
        addStock("Zoom Video, Inc.", "ZM", 118.02);
        addStock("Zscaler, Inc.", "ZS", 246.21);
    }

    //ArrayList holding "Database" information
    static ArrayList<Stock> stockBase = new ArrayList<>();

    //Method for adding stocks to database manually
    public static void addStock(String name, String symbol, double value)
    {
        Stock s = new Stock(name, symbol, value);
        stockBase.add(s);
    }

    //Methods for navigating to different panels of the app.
    public void goToList(View w)
    {
        setContentView(R.layout.stocklist);
        String toAdd = "";

        for(int i = 0; i < 10; i++)
        {
            Stock similar = stockBase.get(i);
            toAdd += similar.getName();
            toAdd += " : " + similar.getSymbol();
            toAdd += " : Price : " + similar.getValue();
            toAdd += "\n\n";
        }

        ((TextView) findViewById(R.id.stockList_list)).setText(toAdd);
    }


    public void goToMain(View w) { setContentView(R.layout.activity_main); }

    public static boolean hasStock(String code) {
        for (int i = 0; i < stockBase.size(); i++)
        {
            if((stockBase.get(i).getSymbol()).equalsIgnoreCase(code))
            {
                return true;
            }
        }
        return false;
    }

    public void goToSearch(View w)
    {
        EditText search = (EditText) findViewById(R.id.searchLabel);
        String searchText = search.getText().toString();

        if(hasStock((search.getText()).toString()) == true)
        {
            setContentView(R.layout.searchpanel_exists);

            for(int i = 0; i < stockBase.size(); i++)
            {
                if((stockBase.get(i).getSymbol()).equalsIgnoreCase(searchText))
                {
                    ((TextView) findViewById(R.id.stockLabel_exists)).setText(stockBase.get(i).getName());
                    ((TextView) findViewById(R.id.currentPrice_exists)).setText(Double.toString(stockBase.get(i).getValue()));

                    double last = (stockBase.get(i).getValue()) * 0.04;
                    last = (stockBase.get(i).getValue()) - Math.ceil(last);

                    ((TextView) findViewById(R.id.lastPrice_exists)).setText("Last Update : " + Double.toString(last));
                }
            }
        }
        else
        {
            setContentView(R.layout.searchpanel_noresult);

            String toLook = searchText.substring(0, 1);
            String similarStocks = "";

            ((TextView) findViewById(R.id.searchLabel_noResult)).setText(searchText);
            ((TextView) findViewById(R.id.notIn_noResult)).setText("No stock: " + searchText + " exists in our database. Could you have meant any of the following");

            for(int i = 0; i < stockBase.size(); i++)
            {
                String toComp = (stockBase.get(i).getSymbol()).substring(0,1);

                if(toLook.equalsIgnoreCase(toComp))
                {
                    Stock similar = stockBase.get(i);
                    similarStocks += similar.getName();
                    similarStocks += " : " + similar.getSymbol();
                    similarStocks += " : Price : " + similar.getValue();
                    similarStocks += "\n\n";
                }

                ((TextView) findViewById(R.id.otherStocks_noResult)).setText(similarStocks);
            }
        }
    }

}