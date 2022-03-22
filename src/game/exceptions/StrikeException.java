package game.exceptions;

import game.entities.Entity;

public abstract class StrikeException extends Exception {

    protected final Entity m_entity;

    public StrikeException(String message, Entity _entity) {
        super(message);
        this.m_entity = _entity;
    }

    @Override
    public String getMessage() {
        return m_entity.toString() + super.getMessage();
    }
}
