package com.opentable.gc.infra.connectmigrations.model.dto.get;

import com.fasterxml.jackson.annotation.JsonProperty;



public class Restaurant{

    @JsonProperty("twitterAccountName")
    private String twitterAccountName;

    @JsonProperty("dressCodeId")
    private int dressCodeId;

    @JsonProperty("maxLargePartyID")
    private int maxLargePartyID;

    @JsonProperty("latitude")
    private String latitude;

    @JsonProperty("minOnlineOptionId")
    private int minOnlineOptionId;

    @JsonProperty("ccAccountStatusID")
    private int ccAccountStatusID;

    @JsonProperty("restaurantId")
    private int restaurantId;

    @JsonProperty("acceptsWalkins")
    private boolean acceptsWalkins;

    @JsonProperty("diningStyleId")
    private int diningStyleId;

    @JsonProperty("neighborhoodId")
    private int neighborhoodId;

    @JsonProperty("facebookUrl")
    private String facebookUrl;

    @JsonProperty("countryCode")
    private String countryCode;

    @JsonProperty("metroAreaId")
    private int metroAreaId;

    @JsonProperty("restaurantType")
    private String restaurantType;

    @JsonProperty("restaurantStateId")
    private int restaurantStateId;

    @JsonProperty("email")
    private String email;

    @JsonProperty("longitude")
    private String longitude;

    @JsonProperty("smokingId")
    private int smokingId;

    @JsonProperty("minCCPartySize")
    private int minCCPartySize;

    @JsonProperty("minPartySize")
    private int minPartySize;

    @JsonProperty("enablePrivateDining")
    private boolean enablePrivateDining;

    @JsonProperty("privatePartyEmail")
    private String privatePartyEmail;

    @JsonProperty("url")
    private String url;

    @JsonProperty("priceBandId")
    private int priceBandId;

    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @JsonProperty("showThirdPartyMenu")
    private int showThirdPartyMenu;

    @JsonProperty("menuUrl")
    private String menuUrl;

    @JsonProperty("domainName")
    private String domainName;

    @JsonProperty("maxAdvanceDaysId")
    private int maxAdvanceDaysId;

    @JsonProperty("restaurantFax")
    private String restaurantFax;

    @JsonProperty("postCode")
    private String postCode;

    @JsonProperty("hasPrivateParty")
    private boolean hasPrivateParty;

    @JsonProperty("currencyCode")
    private String currencyCode;

    @JsonProperty("publishPrivateDining")
    private boolean publishPrivateDining;

    @JsonProperty("primaryLanguage")
    private String primaryLanguage;

    public void setTwitterAccountName(String twitterAccountName){
        this.twitterAccountName = twitterAccountName;
    }

    public String getTwitterAccountName(){
        return twitterAccountName;
    }

    public void setDressCodeId(int dressCodeId){
        this.dressCodeId = dressCodeId;
    }

    public int getDressCodeId(){
        return dressCodeId;
    }

    public void setMaxLargePartyID(int maxLargePartyID){
        this.maxLargePartyID = maxLargePartyID;
    }

    public int getMaxLargePartyID(){
        return maxLargePartyID;
    }

    public void setLatitude(String latitude){
        this.latitude = latitude;
    }

    public String getLatitude(){
        return latitude;
    }

    public void setMinOnlineOptionId(int minOnlineOptionId){
        this.minOnlineOptionId = minOnlineOptionId;
    }

    public int getMinOnlineOptionId(){
        return minOnlineOptionId;
    }

    public void setCcAccountStatusID(int ccAccountStatusID){
        this.ccAccountStatusID = ccAccountStatusID;
    }

    public int getCcAccountStatusID(){
        return ccAccountStatusID;
    }

    public void setRestaurantId(int restaurantId){
        this.restaurantId = restaurantId;
    }

    public int getRestaurantId(){
        return restaurantId;
    }

    public void setAcceptsWalkins(boolean acceptsWalkins){
        this.acceptsWalkins = acceptsWalkins;
    }

    public boolean isAcceptsWalkins(){
        return acceptsWalkins;
    }

    public void setDiningStyleId(int diningStyleId){
        this.diningStyleId = diningStyleId;
    }

    public int getDiningStyleId(){
        return diningStyleId;
    }

    public void setNeighborhoodId(int neighborhoodId){
        this.neighborhoodId = neighborhoodId;
    }

    public int getNeighborhoodId(){
        return neighborhoodId;
    }

    public void setFacebookUrl(String facebookUrl){
        this.facebookUrl = facebookUrl;
    }

    public String getFacebookUrl(){
        return facebookUrl;
    }

    public void setCountryCode(String countryCode){
        this.countryCode = countryCode;
    }

    public String getCountryCode(){
        return countryCode;
    }

    public void setMetroAreaId(int metroAreaId){
        this.metroAreaId = metroAreaId;
    }

    public int getMetroAreaId(){
        return metroAreaId;
    }

    public void setRestaurantType(String restaurantType){
        this.restaurantType = restaurantType;
    }

    public String getRestaurantType(){
        return restaurantType;
    }

    public void setRestaurantStateId(int restaurantStateId){
        this.restaurantStateId = restaurantStateId;
    }

    public int getRestaurantStateId(){
        return restaurantStateId;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setLongitude(String longitude){
        this.longitude = longitude;
    }

    public String getLongitude(){
        return longitude;
    }

    public void setSmokingId(int smokingId){
        this.smokingId = smokingId;
    }

    public int getSmokingId(){
        return smokingId;
    }

    public void setMinCCPartySize(int minCCPartySize){
        this.minCCPartySize = minCCPartySize;
    }

    public int getMinCCPartySize(){
        return minCCPartySize;
    }

    public void setMinPartySize(int minPartySize){
        this.minPartySize = minPartySize;
    }

    public int getMinPartySize(){
        return minPartySize;
    }

    public void setEnablePrivateDining(boolean enablePrivateDining){
        this.enablePrivateDining = enablePrivateDining;
    }

    public boolean isEnablePrivateDining(){
        return enablePrivateDining;
    }

    public void setPrivatePartyEmail(String privatePartyEmail){
        this.privatePartyEmail = privatePartyEmail;
    }

    public String getPrivatePartyEmail(){
        return privatePartyEmail;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public String getUrl(){
        return url;
    }

    public void setPriceBandId(int priceBandId){
        this.priceBandId = priceBandId;
    }

    public int getPriceBandId(){
        return priceBandId;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setShowThirdPartyMenu(int showThirdPartyMenu){
        this.showThirdPartyMenu = showThirdPartyMenu;
    }

    public int getShowThirdPartyMenu(){
        return showThirdPartyMenu;
    }

    public void setMenuUrl(String menuUrl){
        this.menuUrl = menuUrl;
    }

    public String getMenuUrl(){
        return menuUrl;
    }

    public void setDomainName(String domainName){
        this.domainName = domainName;
    }

    public String getDomainName(){
        return domainName;
    }

    public void setMaxAdvanceDaysId(int maxAdvanceDaysId){
        this.maxAdvanceDaysId = maxAdvanceDaysId;
    }

    public int getMaxAdvanceDaysId(){
        return maxAdvanceDaysId;
    }

    public void setRestaurantFax(String restaurantFax){
        this.restaurantFax = restaurantFax;
    }

    public String getRestaurantFax(){
        return restaurantFax;
    }

    public void setPostCode(String postCode){
        this.postCode = postCode;
    }

    public String getPostCode(){
        return postCode;
    }

    public void setHasPrivateParty(boolean hasPrivateParty){
        this.hasPrivateParty = hasPrivateParty;
    }

    public boolean isHasPrivateParty(){
        return hasPrivateParty;
    }

    public void setCurrencyCode(String currencyCode){
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode(){
        return currencyCode;
    }

    public void setPublishPrivateDining(boolean publishPrivateDining){
        this.publishPrivateDining = publishPrivateDining;
    }

    public boolean isPublishPrivateDining(){
        return publishPrivateDining;
    }

    public void setPrimaryLanguage(String primaryLanguage){
        this.primaryLanguage = primaryLanguage;
    }

    public String getPrimaryLanguage(){
        return primaryLanguage;
    }

    @Override
    public String toString(){
        return
            "Restaurant{" +
            "twitterAccountName = '" + twitterAccountName + '\'' +
            ",dressCodeId = '" + dressCodeId + '\'' +
            ",maxLargePartyID = '" + maxLargePartyID + '\'' +
            ",latitude = '" + latitude + '\'' +
            ",minOnlineOptionId = '" + minOnlineOptionId + '\'' +
            ",ccAccountStatusID = '" + ccAccountStatusID + '\'' +
            ",restaurantId = '" + restaurantId + '\'' +
            ",acceptsWalkins = '" + acceptsWalkins + '\'' +
            ",diningStyleId = '" + diningStyleId + '\'' +
            ",neighborhoodId = '" + neighborhoodId + '\'' +
            ",facebookUrl = '" + facebookUrl + '\'' +
            ",countryCode = '" + countryCode + '\'' +
            ",metroAreaId = '" + metroAreaId + '\'' +
            ",restaurantType = '" + restaurantType + '\'' +
            ",restaurantStateId = '" + restaurantStateId + '\'' +
            ",email = '" + email + '\'' +
            ",longitude = '" + longitude + '\'' +
            ",smokingId = '" + smokingId + '\'' +
            ",minCCPartySize = '" + minCCPartySize + '\'' +
            ",minPartySize = '" + minPartySize + '\'' +
            ",enablePrivateDining = '" + enablePrivateDining + '\'' +
            ",privatePartyEmail = '" + privatePartyEmail + '\'' +
            ",url = '" + url + '\'' +
            ",priceBandId = '" + priceBandId + '\'' +
            ",phoneNumber = '" + phoneNumber + '\'' +
            ",showThirdPartyMenu = '" + showThirdPartyMenu + '\'' +
            ",menuUrl = '" + menuUrl + '\'' +
            ",domainName = '" + domainName + '\'' +
            ",maxAdvanceDaysId = '" + maxAdvanceDaysId + '\'' +
            ",restaurantFax = '" + restaurantFax + '\'' +
            ",postCode = '" + postCode + '\'' +
            ",hasPrivateParty = '" + hasPrivateParty + '\'' +
            ",currencyCode = '" + currencyCode + '\'' +
            ",publishPrivateDining = '" + publishPrivateDining + '\'' +
            ",primaryLanguage = '" + primaryLanguage + '\'' +
            "}";
        }
}
