package game.entities;

import game.exceptions.StrikeConditionNotMetException;

public class Archer extends Character {

    private int m_arrows;

    public Archer(String _name, int _damage, int _health,
                  int _age, String _city,
                  int _arrows) {
        super(_name, _damage, _health,
                _age, _city);
        this.m_arrows = _arrows;
    }

    @Override
    public void strikeTarget(Entity _entity) throws StrikeConditionNotMetException {
        if (this.getHealth() <= 0)
            throw new StrikeConditionNotMetException(" | No more health", this);

        if (this.m_arrows < 1)
            throw new StrikeConditionNotMetException(" | No arrows left", this);

        this.m_arrows--;
        _entity.receiveDamageFrom(this);
        this.displayCombatText(_entity);

    }

    private int getArrows() {
        return this.m_arrows;
    }

    @Override
    public String toString() {
        return super.toString() + " | Arrows: " + this.getArrows();
    }
}
