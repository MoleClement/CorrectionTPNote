package game.entities;


public abstract class Character extends Entity {

    private final int m_age;

    private final String m_city;

    public Character(String _name, int _damage, int _health,
                     int _age, String _city) {
        super(_name, _damage, _health);
        this.m_age = _age;
        this.m_city = _city;
    }

    public int getAge() {
        return this.m_age;
    }

    public String getCity() {
        return this.m_city;
    }

    @Override
    public String toString() {
        return super.toString() +
                " | Age: " + this.getAge() +
                " | From: " + this.getCity();
    }

}
