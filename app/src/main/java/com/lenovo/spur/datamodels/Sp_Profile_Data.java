package com.lenovo.spur.datamodels;

/**
 * Created by lenovo on 4/13/2018.
 */

public class Sp_Profile_Data {

    public   String name , shop_name ;

    public  Sp_Profile_Data()
    {

    }

    public Sp_Profile_Data(String name , String shop_name)
    {
        this.shop_name = shop_name;
        this.name = name;

    }
}
