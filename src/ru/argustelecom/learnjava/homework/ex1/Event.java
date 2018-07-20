package ru.argustelecom.learnjava.homework.ex1;

/**
 * Параметризованное событие
 */
public class Event<T> {
	private final T data;

	public Event(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}
}
