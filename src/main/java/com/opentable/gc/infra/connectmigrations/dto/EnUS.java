package com.opentable.gc.infra.connectmigrations.dto;

public class EnUS{
    private String address2;
    private String city;
    private String restaurantName;
    private String address1;
    private String sortableRestaurantName;
    private String state;
    private String crossStreet;
    private boolean isActive;
    private String executiveChef;
    private boolean locked;
    private int version;
    private String message;
    private String messageSource;

    public void setAddress2(String address2){
        this.address2 = address2;
    }

    public String getAddress2(){
        return address2;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getCity(){
        return city;
    }

    public void setRestaurantName(String restaurantName){
        this.restaurantName = restaurantName;
    }

    public String getRestaurantName(){
        return restaurantName;
    }

    public void setAddress1(String address1){
        this.address1 = address1;
    }

    public String getAddress1(){
        return address1;
    }

    public void setSortableRestaurantName(String sortableRestaurantName){
        this.sortableRestaurantName = sortableRestaurantName;
    }

    public String getSortableRestaurantName(){
        return sortableRestaurantName;
    }

    public void setState(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }

    public void setCrossStreet(String crossStreet){
        this.crossStreet = crossStreet;
    }

    public String getCrossStreet(){
        return crossStreet;
    }

    public void setIsActive(boolean isActive){
        this.isActive = isActive;
    }

    public boolean isIsActive(){
        return isActive;
    }

    public void setExecutiveChef(String executiveChef){
        this.executiveChef = executiveChef;
    }

    public String getExecutiveChef(){
        return executiveChef;
    }

    public void setLocked(boolean locked){
        this.locked = locked;
    }

    public boolean isLocked(){
        return locked;
    }

    public void setVersion(int version){
        this.version = version;
    }

    public int getVersion(){
        return version;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public void setMessageSource(String messageSource){
        this.messageSource = messageSource;
    }

    public String getMessageSource(){
        return messageSource;
    }

    @Override
    public String toString(){
        return
            "EnUS{" +
            "address2 = '" + address2 + '\'' +
            ",city = '" + city + '\'' +
            ",restaurantName = '" + restaurantName + '\'' +
            ",address1 = '" + address1 + '\'' +
            ",sortableRestaurantName = '" + sortableRestaurantName + '\'' +
            ",state = '" + state + '\'' +
            ",crossStreet = '" + crossStreet + '\'' +
            ",isActive = '" + isActive + '\'' +
            ",executiveChef = '" + executiveChef + '\'' +
            ",locked = '" + locked + '\'' +
            ",version = '" + version + '\'' +
            ",message = '" + message + '\'' +
            ",messageSource = '" + messageSource + '\'' +
            "}";
        }
}
