package com.ecsolutions.entity;

/**
 * Created by Administrator on 2017/3/29.
 */
public class ExternalRating_Entity {
    private String LCY_Rating;
    private String FCY_Rating;
    private String Rating_Date;
    private String Rating_Agency;

    public String getLCY_Rating() {
        return LCY_Rating;
    }

    public void setLCY_Rating(String LCY_Rating) {
        this.LCY_Rating = LCY_Rating;
    }

    public String getFCY_Rating() {
        return FCY_Rating;
    }

    public void setFCY_Rating(String FCY_Rating) {
        this.FCY_Rating = FCY_Rating;
    }

    public String getRating_Date() {
        return Rating_Date;
    }

    public void setRating_Date(String rating_Date) {
        Rating_Date = rating_Date;
    }

    public String getRating_Agency() {
        return Rating_Agency;
    }

    public void setRating_Agency(String rating_Agency) {
        Rating_Agency = rating_Agency;
    }
}
