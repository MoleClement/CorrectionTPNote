package game.exceptions;

import game.entities.Entity;

public class StrikeConditionNotMetException extends StrikeException {
    public StrikeConditionNotMetException(String _message, Entity _entity) {
        super(_message, _entity);
    }
}
