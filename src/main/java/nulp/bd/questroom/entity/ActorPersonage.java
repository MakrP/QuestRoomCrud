package nulp.bd.questroom.entity;

import java.util.HashMap;
import java.util.Map;

public class ActorPersonage {
    private Map<Personage, Actor> personageActorMap = new HashMap<>();

    public Map<Personage, Actor> getPersonageActorMap() {
        return personageActorMap;
    }

    public void setPersonageActorMap(Map<Personage, Actor> personageActorMap) {
        this.personageActorMap = personageActorMap;
    }
}
