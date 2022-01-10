package domain;

import json.*;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {
    JsonObject stud_advances;

    public Student(String name, String surname, Integer year, Tuple<String, Integer>... exams) {
        stud_advances = new JsonObject();

        stud_advances.add(new JsonPair("name", new JsonString(name)));
        stud_advances.add(new JsonPair("surname", new JsonString(surname)));
        stud_advances.add(new JsonPair("year", new JsonNumber(year)));

        JsonObject array[] = new JsonObject[exams.length];

        for (int i = 0; i < exams.length; i++) {
            array[i] = new JsonObject(new JsonPair("course", new JsonString(exams[i].key)),
                new JsonPair("mark", new JsonNumber(exams[i].value)), new JsonPair("passed",
                new JsonBoolean(exams[i].value > 2)));
        }

        stud_advances.add(new JsonPair("exams", new JsonArray(array)));
    }

    @Override
    public JsonObject toJsonObject() {
        return stud_advances;
    }
}