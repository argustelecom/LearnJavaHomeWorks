package ru.argustelecom.learnjavahomeworks.exercises.n01.model;

public class Event<T> {
    private final T data;

    public Event(T data) {
        this.data = data;
    }

    public T getData() { return data; }
}