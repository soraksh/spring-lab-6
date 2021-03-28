package com.luxoft.springcore.objects;

import com.luxoft.springcore.travel.Connection;
import com.luxoft.springcore.travel.TravellingOpportunities;
import org.springframework.beans.factory.annotation.Autowired;

public class UsualPerson implements Person {
    private int id;

    private String name;
    private City city;
    private int distanceTravelled = 0;

    private int age;
    private boolean isProgrammer;

    private TravellingOpportunities opportunities;

    public UsualPerson() {

    }

    public UsualPerson(String name, int age, City city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public UsualPerson(int id, String name, int age, City city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public City getCity() {
        return city;
    }

    public void setCountry(City city) {
        this.city = city;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(int distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    public boolean isProgrammer() {
        return isProgrammer;
    }

    public void setIsProgrammer(boolean isProgrammer) {
        this.isProgrammer = isProgrammer;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Autowired
    public void setOpportunities(TravellingOpportunities opportunities) {
        this.opportunities = opportunities;
    }

    public void travel(City source, City destination) {
        for (Connection connection : opportunities.getConnectionsList()) {
            if (connection.getSource().equals(source) && connection.getDestination().equals(destination)) {
                distanceTravelled += connection.getDistance();
                return;
            }
        }
    }

    public String toString() {
        String s = "Name: " + name + "\n"
                + "Age: " + age + "\n"
                + "City: " + city + "\n"
                + "Is Programmer?: " + isProgrammer + "\n";

        return s;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsualPerson person = (UsualPerson) o;

        if (age != person.age) return false;
        if (isProgrammer != person.isProgrammer) return false;
        if (city != null ? !city.equals(person.city) : person.city != null) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (name != null ? name.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (isProgrammer ? 1 : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }

}