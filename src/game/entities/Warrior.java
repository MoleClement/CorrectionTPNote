package game.entities;


public class Warrior extends Character {

    private final int m_defense;

    public Warrior(String _name, int _damage, int _health,
                   int _age, String _city,
                   int _defense) {
        super(_name, _damage, _health,
                _age, _city);
        this.m_defense = _defense;
    }

    @Override
    protected void receiveDamageFrom(Entity _entity) {
        this.setHealth(_entity.getDamage() - this.m_defense);
    }

    private float getDefense() {
        return this.m_defense;
    }

    @Override
    public String toString() {
        return super.toString() + " | Defense: " + this.getDefense();
    }
}
