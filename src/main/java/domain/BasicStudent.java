package domain;

import json.*;

/**
 * Created by Andrii_Rodionov on 1/5/2017.
 */
public class BasicStudent implements Jsonable {

    protected String name;
    protected String surname;
    protected Integer year;

    public BasicStudent() {
    }

    public BasicStudent(String name, String surname, Integer year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    @Override
    public JsonObject toJsonObject() {
        JsonObject stud = new JsonObject();
        Json temp;
        if (name != null) {
            stud.add(new JsonPair("name", new JsonString(name)));
            stud.add(new JsonPair("surname", new JsonString(surname)));
            stud.add(new JsonPair("year", new JsonNumber(year)));
        }
        return stud;
    }
}
