package game.entities;

import game.exceptions.StrikeConditionNotMetException;
import game.exceptions.StrikeFailedException;

import java.util.Random;

public class Rogue extends Character {

    private final float m_luckAttribute;

    public Rogue(String _name, int _damage, int _health,
                 int _age, String _city,
                 float _luckAttribute) {
        super(_name, _damage, _health,
                _age, _city);
        this.m_luckAttribute = _luckAttribute;
    }


    @Override
    public void strikeTarget(Entity _entity) throws StrikeFailedException, StrikeConditionNotMetException {
        if (this.getHealth() <= 0)
            throw new StrikeConditionNotMetException(" | No more health", this);

        Random random = new Random();
        if (random.nextFloat() < this.m_luckAttribute)
            throw new StrikeFailedException(" | Strike  Failed", this);

        for (int i = 0; i < 2; i++) {
            _entity.receiveDamageFrom(this);
            this.displayCombatText(_entity);
        }

    }

    private float getLuck() {
        return this.m_luckAttribute;
    }

    @Override
    public String toString() {
        return super.toString() + " | Luck: " + this.getLuck();
    }
}
