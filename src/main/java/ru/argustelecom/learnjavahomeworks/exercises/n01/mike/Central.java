import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collection;
import java.util.function.BiConsumer;
import java.time.LocalDateTime;


public class Central {
	private <A, B, T extends Pair<A, B>> String pairToString(T pair) {
		return "a = " + pair.getFirst().toString() + "; b = " + pair.getSecond().toString();
	}
	
	private <T extends Pair<? extends Integer, ?>> String concatSorted(Collection<T> srcList) {
		return srcList.stream()
		  .sorted(new PairComparator<T>())
		  .collect( ArrayList<String>::new,
				   (list, item) -> list.add(item.getSecond().toString()), 
				   (list1, list2) -> list1.addAll(list2) )
		  .toString();
	}
	
	private void exercise01a() {
		System.out.println("exercise 01.a");
		
		Pair<Integer, String> p1 = new Pair<>(2, "bb");
		Pair<Integer, String> p2 = new Pair<>(1, "aa");
		System.out.println(concatSorted(Arrays.asList(p1, p2)));
		
		System.out.println(concatSorted(Arrays.asList(p2, p1)));
		System.out.println(concatSorted(Arrays.asList(p1)));
		System.out.println(concatSorted(Arrays.asList()));		
	}

	
	private <N extends Number, X, T extends Pair<N, X>> void handle(Event<T> event, BiConsumer<? super N, ? super X> consumer) {
		/* метод `handle`, который принимает только события с парами, у которых первое поле имеет численный тип. 
		 * Первый параметр метода - событие, второй параметр - потребитель данных BiConsumer, который будет принимать компоненты пары.  
		 * В теле метода следует вызвать косьюмера с двумя параметрами, извлечёнными из компонентов пары из события.
		 * */ 
		consumer.accept(event.getData().getFirst(), event.getData().getSecond());
 	}


	private void exercise01b() {
		System.out.println("exercise 01.b");

	    Pair<Integer, String> p = new Pair<>(1, "bb");

	    //  следующие вызовы должны "сходиться" без ошибок
	    handle(new Event<>(p), (a, b) -> {});
	    handle(new Event<>(p), (Object a, Object b) -> {});
	    handle(new Event<>(p), (Object a, String b) -> {});
	    handle(new Event<>(p), (Number a, Object b) -> {});
	    handle(new Event<>(p), (Integer a, Object b) -> {});
	    handle(new Event<>(p), (Integer a, String b) -> {});

	    Pair<Double, String> p2 = new Pair<>(1.0, "bb");
	    //handle(new Event<>(p2), (Integer a, String b) -> {});   // здесь должна быть ошибка так как получатель не может обработать Double

	    Pair<Boolean, String> p3 = new Pair<>(true, "bb");
	    //handle(new Event<>(p3), (a, b) -> {});   // здесь должна быть ошибка так как первый параметр пары имеет нечисловой тип		

		System.out.println("p: " + pairToString(p));
		System.out.println("p2: " + pairToString(p2));
		System.out.println("p3: " + pairToString(p3));	
	}
	
	public static void main(String[] args) {
		Central app = new Central();
		System.out.println("--- " + LocalDateTime.now());
		app.exercise01a();
		app.exercise01b();
		System.out.println("done");
	}
}
