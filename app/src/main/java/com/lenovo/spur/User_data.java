package com.lenovo.spur;

/**
 * Created by lenovo on 4/9/2018.
 */

public class User_data {


    String first_name, last_name, address, gender, blood_group, category , facilities;


    User_data(String first_name_s, String last_name_s, String address_s, String blood_group_s, String gender)
    {

    }

    User_data(String first_name, String last_name, String address, String gender , String blood_group, String category, String facilities)
    {

        this.first_name = first_name;

        this.last_name = last_name;

        this.address = address;

        this.gender= gender;

        this.blood_group= blood_group;

        this.category = category;

        this.facilities = facilities;



    }


}
