package ru.argustelecom.learnjavahomeworks.exercises.n01.al;

import ru.argustelecom.learnjavahomeworks.exercises.n01.model.*;
import java.util.function.BiConsumer;

/*Объявить метод handle, который принимает только события с парами, у которых первое поле имеет численный тип.
Первый параметр метода - событие, второй параметр - потребитель данных, java.util.function.BiConsumer,
который будет принимать компоненты пары.
В теле метода следует вызвать косьюмера с двумя параметрами, извлечёнными из компонентов пары из события.
*/
public class Task02 {

    public static <T extends Number, U> void handle(Event<Pair<T,U>> event, BiConsumer<? super T, ? super U> consumer) {
        consumer.accept(event.getData().getFirst(), event.getData().getSecond());
    }

    public static void main(String[] args) {
        Pair<Integer, String> p = new Pair<>(1, "bb");

        //  следующие вызовы должны "сходиться" без ошибок
        handle(new Event<>(p), (a, b) -> {});
        handle(new Event<>(p), (Object a, Object b) -> {});
        handle(new Event<>(p), (Object a, String b) -> {});
        handle(new Event<>(p), (Number a, Object b) -> {});
        handle(new Event<>(p), (Integer a, Object b) -> {});
        handle(new Event<>(p), (Integer a, String b) -> {});
        /*
        Pair<Double, String> p2 = new Pair<>(1.0, "bb");
        handle(new Event<>(p2), (Integer a, String b) -> {});   // здесь должна быть ошибка так как получатель не может обработать Double

        Pair<Boolean, String> p2 = new Pair<>(true, "bb");
        handle(new Event<>(p2), (a, b) -> {});   // здесь должна быть ошибка так как первый параметр пары имеет нечисловой тип
        */
    }
}
