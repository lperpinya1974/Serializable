package com.exemple.profedam.serializable;

/**
 * Created by Lluis_2 on 04/11/2016.
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;

import android.os.Parcel;
import android.os.Parcelable;

public class MyObject implements Serializable {

    private  String name;
    private int age;

    public ArrayList<String> address;

    public MyObject(String name, int age, ArrayList<String> address) {
        super();
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public MyObject() {

    }

    public ArrayList<String> getAddress() {
        if (!(address == null))
            return address;
        else
            return new ArrayList<String>();
    }

    public String getName() {
        return name;

    }

    public int getAge() {
        return age;
    }

}
