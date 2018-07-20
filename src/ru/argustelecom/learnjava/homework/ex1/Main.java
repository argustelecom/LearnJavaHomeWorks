package ru.argustelecom.learnjava.homework.ex1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.BiConsumer;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		System.out.println("start concat");
		main.testConcatSorted();
		System.out.println("start handle");
		main.testHandleEvent();
	}

	/**
	 * Написать метод concatSorted, принимающий список пар, склеивающий все значения second (можно использовать toString) в строку через
	 * запятую в порядке возрастания соответствующих им значений first. Вся операция должна быть описана в виде одного выражения
	 * с использованием Streams API.
	 */
	public void testConcatSorted() {
		Pair<Integer, String> p1 = new Pair<>(2, "bb");
		Pair<Integer, String> p2 = new Pair<>(1, "aa");

		System.out.println(concatSorted(Arrays.asList(p1, p2)));
		System.out.println(concatSorted(Arrays.asList(p2, p1)));
		System.out.println(concatSorted(Arrays.asList(p1)));
		System.out.println(concatSorted(Arrays.asList()));
	}

	private <F extends Comparable<F>> String concatSorted(List<Pair<F, ? extends CharSequence>> pairs) {
		return pairs.stream().sorted(Comparator
				.nullsLast(Comparator.comparing(Pair::getFirst, Comparable::compareTo)))
				.collect(() -> new StringJoiner(","),
						(sj, pair) -> sj.add(pair.getSecond()), (n, o) -> n = n.merge(o)).toString();
	}

	/**
	 * Объявить метод handle, который принимает только события с парами, у которых первое поле имеет численный тип.
	 * Первый параметр метода - событие, второй параметр - потребитель данных, java.util.function.BiConsumer,
	 * который будет принимать компоненты пары. В теле метода следует вызвать косьюмера с двумя параметрами, извлечёнными из компонентов пары из события.
	 */
	public void testHandleEvent() {
		Pair<Integer, String> p = new Pair<>(1, "bb");

		//  следующие вызовы должны "сходиться" без ошибок
		handle(new Event<>(p), (a, b) -> {
		});
		handle(new Event<>(p), (Object a, Object b) -> {
		});
		handle(new Event<>(p), (Object a, String b) -> {
		});
		handle(new Event<>(p), (Number a, Object b) -> {
		});
		handle(new Event<>(p), (Integer a, Object b) -> {
		});
		handle(new Event<>(p), (Integer a, String b) -> {
		});

		Pair<Double, String> p2 = new Pair<>(1.0, "bb");
		//		handle(new Event<>(p2), (Integer a, String b) -> {
		//		});   // здесь должна быть ошибка так как получатель не может обработать Double

		Pair<Boolean, String> p3 = new Pair<>(true, "bb");
		//		handle(new Event<>(p3), (a, b) -> {
		//		});   // здесь должна быть ошибка так как первый параметр пары имеет нечисловой тип
	}

	private <F extends Number, S, T extends Pair<F, S>> void handle(Event<T> event,
			BiConsumer<? super F, ? super S> consumer) {
		consumer.accept(event.getData().getFirst(), event.getData().getSecond());
	}
}
