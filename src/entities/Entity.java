package entities;

import exceptions.StrikeConditionNotMetException;
import exceptions.StrikeFailedException;

public abstract class Entity implements Comparable<Entity> {

    private final String m_name;

    private final int m_damage;
    private int m_health;

    public Entity(String _name, int _damage, int m_health) {
        this.m_name = _name;
        this.m_damage = _damage;
        this.m_health = m_health;
    }

    public void strikeTarget(Entity _entity) throws StrikeFailedException, StrikeConditionNotMetException {

        if (this.getHealth() <= 0)
            throw new StrikeConditionNotMetException(" | No more health", this);
        _entity.receiveDamageFrom(this);
        this.displayCombatText(_entity);
    }

    protected void displayCombatText(Entity _entity) {
        System.out.println(_entity.getName() + " struck by " + this.getName());
    }

    protected void receiveDamageFrom(Entity _entity) {

        this.setHealth(_entity.getDamage());
    }

    public String getName() {
        return this.m_name;
    }

    protected int getDamage() {
        return this.m_damage;
    }

    protected void setHealth(int _damageToHealth) {
        if (this.m_health - _damageToHealth < 0) this.m_health = 0;
        else this.m_health -= _damageToHealth;
    }

    public int getHealth() {
        return this.m_health;
    }

    @Override
    public String toString() {
        return "Name: " + this.getName() +
                " | Health: " + this.getHealth() +
                " | Damage: " + this.getDamage();
    }

    @Override
    public int compareTo(Entity _entity) {
        return Integer.compare(this.getHealth(), _entity.getHealth());
    }

}
