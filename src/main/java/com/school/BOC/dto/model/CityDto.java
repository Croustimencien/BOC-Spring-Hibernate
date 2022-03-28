package com.school.BOC.dto.model;

public class CityDto {
    String nameCity;
    static long cityOwnerId;

    public CityDto(String nameCity, long cityOwnerId) {
        this.nameCity = nameCity;
        this.cityOwnerId = cityOwnerId;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public static long getCityOwnerId() {
        return cityOwnerId;
    }

    public void setCityOwnerId(long cityOwnerId) {
        this.cityOwnerId = cityOwnerId;
    }
}
