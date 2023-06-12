package com.example.it114watch;

import java.util.Calendar;

public class Watch {

//create attributes for watch class


        private String brand;
        private String serial;
        private String movement;
        private int waterRes;
        private int manufactureYr;
        private double price;
        private int age;
        private String imageURL;

        @Override
        //create toString to display watches when called
        public String toString() {
            return "Watch: " + '\n' + "Brand: " + brand + '\n' + "Serial #: " + serial + '\n' + "Movement: " + movement
                    + '\n' + "Water Resistance Depth: " + waterRes + '\n' + "Year Manufactured: " + manufactureYr + '\n'
                    + "Price: " + price + '\n';
        }
    //create output specifically for when the serial # is given in the findWatch activity
    public String serialOutput() {
        return "Watch: " + '\n' + "Brand: " + brand + '\n' +  "Movement: " + movement
                + '\n' + "Water Resistance Depth: " + waterRes + '\n' + "Year Manufactured: " + manufactureYr + '\n'
                + "Price: " + price + '\n' + this.getAge() + '\n' + "Is a Dive Watch?: " + this.isDiveWatch() + '\n';
    }
    //create output specific to the findBrand activity
    public String allBrand ()
    {
        return brand + " Watch: " +  '\n' + "Movement: " + movement + '\n' + "Serial Number: " + serial + '\n'
                + "Water Resistance Depth: " + waterRes + '\n' + "Price: " + price + '\n';
    }

        //threshhold used to determine if dive watch
        private int diveThreshold = 200;
//getters and setters for watch information
        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getSerial() {
            return serial;
        }

        public void setSerial(String serial) {
            this.serial = serial;
        }

        public String getMovement() {
            return movement;
        }

        public void setMovement(String movement) {
            this.movement = movement;
        }

        public int getWaterRes() {
            return waterRes;
        }

        public void setWaterRes(int waterRes) {
            this.waterRes = waterRes;
        }

        public int getManufactureYr() {
            return manufactureYr;
        }

        public void setManufactureYr(int manufactureYr) {
            this.manufactureYr = manufactureYr;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getImageURL() {
            return imageURL;
        }

        public void setImageURL(String imageURL) {
            this.imageURL = imageURL;
        }


        // getAge method that uses Calendar object to get current year
        //current year - the year the watch was manufactured = age of the watch
        public String getAge() {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            if (year - manufactureYr > 0)
            {
                age = year -manufactureYr;
                return "Watch Age: " + age;
            }
            else
            {
                return "Brand New";
            }
        }
        //isDiveWatch method to determine if the watch is a dive watch
        //use the diveThreshold and use a boolean as output;
        public boolean isDiveWatch (){
            return waterRes >= diveThreshold;
        }



    }


