package game.entities;


public class Monster extends Entity {

    private final float m_loot;

    public Monster(String _name, int _damage, int _health,
                   float _loot) {
        super(_name, _damage, _health);
        this.m_loot = _loot;
    }

    public Monster(Monster _monsterToCopy) {
        super(_monsterToCopy.getName(), _monsterToCopy.getDamage(), _monsterToCopy.getHealth());
        this.m_loot = _monsterToCopy.getLoot();

    }

    public float getLoot() {
        return this.m_loot;
    }

    @Override
    public String toString() {
        return super.toString() + " | Loot: " + this.getLoot();
    }
}
