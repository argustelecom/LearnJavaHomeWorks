Дано: параметеризованная немодифицируемая пара Pair с полями A и B. Событие Event с полем data, параметеризованное, немодифицируемое.

```java
public class Event<T> {
    private final T data;

    public Event(T data) {
        this.data = data;
    }

    public T getData() { return data; }
}

public class Pair<A, B> {
    private final A first;
    private final B second;

    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }
}
```

Справка:
Начиная с Java 8 существует интерфейс  java.util.function.BiConsumer. Он предствляет сущность, принимающую два объекта и выглядит следующим образом:

```java
public interface BiConsumer<T, U> {
    void accept(T t, U u);
}
```

Поскольку BiConsumer является функциональным интерфейсом, то его можно реализовать через лямюду. Например,

`BiConsumer<Integer, String> c = (i, s) -> { ... };`

Обратите внимание, что у пары два компонента, а у BiConsumer также два параметра.

Задания: 
1. Написать метод concatSorted, принимающий список пар, склеивающий все значения second (можно использовать toString) в строку через запятую в порядке возрастания соответствующих им значений first. Вся операция должна быть описана в виде одного выражения с использованием Streams API.

Проверка: следующий код 

```java
Pair<Integer, String> p1 = new Pair<>(2, "bb");
Pair<Integer, String> p2 = new Pair<>(1, "aa");

System.out.println(concatSorted(Arrays.asList(p1, p2)));
System.out.println(concatSorted(Arrays.asList(p2, p1)));
System.out.println(concatSorted(Arrays.asList(p1)));
System.out.println(concatSorted(Arrays.asList()));
```

должен напечатать

```
aa,bb
aa,bb
bb

```

Подсказка: используйте Comparable для ограничения типа компоненты пары, можно также использовать `Comparator.comparing` для упрощения описания критерия сортировки.

2. Объявить метод `handle`, который принимает только события с парами, у которых первое поле имеет численный тип. Первый параметр метода - событие, второй параметр - потребитель данных, `java.util.function.BiConsumer`, который будет принимать компоненты пары.  В теле метода следует вызвать косьюмера с двумя параметрами, извлечёнными из компонентов пары из события. 

Примерный вид метода

```java
public <..... > void handle(Event<.....> event, BiConsumer<...> consumer) {
    consumer.accept(event.getData().getFirst(), event.getData().getSecond());
}
```

Проверка: следующий код поможет проверить полученную декларацию

```java
void test() {
    Pair<Integer, String> p = new Pair<>(1, "bb");

    //  следующие вызовы должны "сходиться" без ошибок
    handle(new Event<>(p), (a, b) -> {});
    handle(new Event<>(p), (Object a, Object b) -> {});
    handle(new Event<>(p), (Object a, String b) -> {});
    handle(new Event<>(p), (Number a, Object b) -> {});
    handle(new Event<>(p), (Integer a, Object b) -> {});
    handle(new Event<>(p), (Integer a, String b) -> {});

    Pair<Double, String> p2 = new Pair<>(1.0, "bb");
    handle(new Event<>(p2), (Integer a, String b) -> {});   // здесь должна быть ошибка так как получатель не может обработать Double

    Pair<Boolean, String> p2 = new Pair<>(true, "bb");
    handle(new Event<>(p2), (a, b) -> {});   // здесь должна быть ошибка так как первый параметр пары имеет нечисловой тип
}
```
