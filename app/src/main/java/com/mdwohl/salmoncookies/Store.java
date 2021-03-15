package com.mdwohl.salmoncookies;

public class Store {

    private String location;
    private Float averageCookiesPerCustomer;
    private Integer min;
    private Integer max;

    public Store(String location, Float averageCookiesPerCustomer, Integer min, Integer max) {
        this.location = location;
        this.averageCookiesPerCustomer = averageCookiesPerCustomer;
        this.min = min;
        this.max = max;
    }

    public Store(){
        location = "Seattle";
        averageCookiesPerCustomer = 6.3f;
        min = 23;
        max = 65;

    };

    public Integer getHourlyCustomers(){
       return Utility.randomIntInRange(this.min, this.max);
    }
    public int getHourlySales(){
        Integer hourlyCustomers = getHourlyCustomers();
        Float hourlySales = hourlyCustomers * averageCookiesPerCustomer;
        return (int) Math.floor(hourlySales);
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
}
