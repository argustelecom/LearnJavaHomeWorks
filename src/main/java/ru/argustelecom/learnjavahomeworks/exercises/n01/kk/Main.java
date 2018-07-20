package ru.argustelecom.learnjavahomeworks.exercises.n01.kk;

import ru.argustelecom.learnjavahomeworks.exercises.n01.model.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

/**
 * @author k.koropovskiy
 */
public class Main {
	/**
	 * метод concatSorted, принимающий список пар, склеивающий все значения second (можно использовать toString) в
	 * строку через запятую в порядке возрастания соответствующих им значений first. Вся операция должна быть описана в
	 * виде одного выражения с использованием Streams API.
	 *
	 * @param list
	 * @return
	 */
	static String concatSorted(List<Pair<Integer, String>> list) {
		// 1. посортировать по getFirst
		// 3. вывести в виде строки getSecond

		// list.sort(Comparator.comparing(Pair::getFirst));
/*		return list.stream().sorted(Comparator.comparing(Pair::getFirst))
				.collect(Collector.of(ArrayList<String>::new, (s, p) -> {
					s.add(p.getSecond());
				}, (s1, s2) -> {
					s1.addAll(s2);
					return s1;
				}, ArrayList<String>::toString)).replace("[", "").replace("]", "");*/
		// вернет [aa, bb] <-- как избавиться от []
		/*
		 * collect(Collector.of(StringBuilder::new, (s, p) -> s.append(p.getSecond()).append(","), (s1, s2) ->
		 * s1.append(s2), StringBuilder::toString)); // вернет aa,bb, <-- как избавиться от последней запятой - неясно
		 */
		return list.stream().sorted(Comparator.comparing(Pair::getFirst)).map(Pair::getSecond)
				.collect(Collectors.joining(","));
	}

	/**
	 * Объявить метод handle, который принимает только события с парами, у которых первое поле имеет численный тип.
	 * Первый параметр метода - событие, второй параметр - потребитель данных, java.util.function.BiConsumer, который
	 * будет принимать компоненты пары. В теле метода следует вызвать косьюмера с двумя параметрами, извлечёнными из
	 * компонентов пары из события.
	 *
	 * @param event
	 * @param consumer
	 */
	public static <A extends Integer, B> void handle(Event<Pair<A, B>> event,
			BiConsumer<? super A, ? super B> consumer) {
		consumer.accept(event.getData().getFirst(), event.getData().getSecond());
	}

	static void challenge1() {

		Pair<Integer, String> p1 = new Pair<>(2, "bb");
		Pair<Integer, String> p2 = new Pair<>(1, "aa");
		Pair<Integer, String> p3 = new Pair<>(3, "cc");

		System.out.println(concatSorted(Arrays.asList(p1, p2, p3)));
		System.out.println(concatSorted(Arrays.asList(p2, p1, p3)));
		System.out.println(concatSorted(Arrays.asList(p1)));
		System.out.println(concatSorted(Arrays.asList()));

	}

	private static void challenge2() {
		Pair<Integer, String> p = new Pair<>(1, "bb");

		// следующие вызовы должны "сходиться" без ошибок
		handle(new Event<>(p), (a, b) -> {});
		handle(new Event<>(p), (Object a, Object b) -> {});
		handle(new Event<>(p), (Object a, String b) -> {});
		handle(new Event<>(p), (Number a, Object b) -> {});
		handle(new Event<>(p), (Integer a, Object b) -> {});
		handle(new Event<>(p), (Integer a, String b) -> {});


		  Pair<Double, String> p2 = new Pair<>(1.0, "bb");
		  //handle(new Event<>(p2), (a, b) -> { });
		  // здесь должна быть ошибка так как получатель не может обработать Double

		Pair<Boolean, String> p3 = new Pair<>(true, "bb");
		//handle(new Event<>(p3), (a, b) -> {});
		// здесь должна быть ошибка так как первый параметр пары имеет нечисловой тип
	}

	public static void main(String[] args) {
		challenge1();
		challenge2();
	}

}
