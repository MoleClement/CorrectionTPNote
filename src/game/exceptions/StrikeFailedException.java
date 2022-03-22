package game.exceptions;

import game.entities.Entity;

public class StrikeFailedException extends StrikeException {
    public StrikeFailedException(String message, Entity _entity) {
        super(message, _entity);
    }
}
