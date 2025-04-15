package me.truec0der.truelib.config.base.exception;

public class EntryDeserializationException extends RuntimeException {
    public EntryDeserializationException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntryDeserializationException(String message) {
        super(message);
    }
}
