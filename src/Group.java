import entities.*;

import java.util.ArrayList;
import java.util.Random;


public class Group {

    private final ArrayList<Entity> m_entities;

    public Group() {
        m_entities = new ArrayList<>();
    }

    public void addToGroup(Entity _entity) {
        this.m_entities.add(_entity);
    }

    public ArrayList<Entity> getGroup() {
        return this.m_entities;
    }

    public Entity getOneEntity() {
        if (this.m_entities.size() == 0) return null;
        Random random = new Random();
        return this.m_entities.get(random.nextInt(m_entities.size()));
    }

}
