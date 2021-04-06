package com.mdwohl.salmoncookies;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "table")

public class Store {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;


    @ColumnInfo(name = "store_location") private String location;
    @ColumnInfo(name = "average_cookies_per_customer") private Float averageCookiesPerCustomer;
    private Integer min;
    private Integer max;
    private List<Integer> dailySalesTotals;
    private Integer totalsPerStore;

    public Store(String location, Float averageCookiesPerCustomer, Integer min, Integer max) {
        this.location = location;
        this.averageCookiesPerCustomer = averageCookiesPerCustomer;
        this.min = min;
        this.max = max;
        this.dailySalesTotals = getDailySales();
        this.totalsPerStore = sumHourlySalesPerStore();
    }

    public Integer getHourlyCustomers(){
       return Utility.randomIntInRange(this.min, this.max);
    }
    public int getHourSales(){
        Integer hourlyCustomers = getHourlyCustomers();
        Float hourlySales = hourlyCustomers * averageCookiesPerCustomer;
        return (int) Math.floor(hourlySales);
    }
    private ArrayList<Integer> getDailySales(){
        ArrayList<Integer> dailySales = new ArrayList();
        for(int i = 0; i < 14; i++){
            int hourly = getHourSales();
            dailySales.add(hourly);
        }
        return dailySales;

    }

    public Integer sumHourlySalesPerStore(){
        Integer salesTotalsPerStore = 0;
        for(Integer hour:this.dailySalesTotals){
            salesTotalsPerStore = salesTotalsPerStore + hour;
        };
        return salesTotalsPerStore;
    }

    public String getLocation() {
        return location;
    }

    public Float getAverageCookiesPerCustomer() {
        return averageCookiesPerCustomer;
    }

    public Integer getMin() {
        return min;
    }

    public Integer getMax() {
        return max;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setAverageCookiesPerCustomer(Float averageCookiesPerCustomer) {
        this.averageCookiesPerCustomer = averageCookiesPerCustomer;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public List<Integer> getDailySalesTotals() {
        return dailySalesTotals;
    }

    public void setDailySalesTotals(ArrayList<Integer> dailySalesTotals) {
        this.dailySalesTotals = dailySalesTotals;
    }

    public Integer getTotalsPerStore() {
        return totalsPerStore;
    }

    public void setId(int id) {
        this.id = id;
    }
}
