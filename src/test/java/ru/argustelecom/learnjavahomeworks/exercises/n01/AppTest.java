package ru.argustelecom.learnjavahomeworks.exercises.n01;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import ru.argustelecom.learnjavahomeworks.exercises.n01.app.App;
import ru.argustelecom.learnjavahomeworks.exercises.n01.model.Event;
import ru.argustelecom.learnjavahomeworks.exercises.n01.model.Pair;

/**
 * Unit test for simple App.
 *
 * v.semchenko
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    public void test() {
        Pair<Integer, String> p = new Pair<>(1, "bb");

        //  следующие вызовы должны "сходиться" без ошибок
        System.out.println("execute: App.handle(new Event<>(p), (a, b) -> {});");
        App.handle(new Event<>(p), (a, b) -> {});
        System.out.println("execute: App.handle(new Event<>(p), (Object a, Object b) -> {});");
        App.handle(new Event<>(p), (Object a, Object b) -> {});
        System.out.println("execute: App.handle(new Event<>(p), (Object a, String b) -> {});");
        App.handle(new Event<>(p), (Object a, String b) -> {});
        System.out.println("execute: App.handle(new Event<>(p), (Number a, Object b) -> {});");
        App.handle(new Event<>(p), (Number a, Object b) -> {});
        System.out.println("execute: App.handle(new Event<>(p), (Integer a, Object b) -> {});");
        App.handle(new Event<>(p), (Integer a, Object b) -> {});
        System.out.println("execute: App.handle(new Event<>(p), (Integer a, String b) -> {});");
        App.handle(new Event<>(p), (Integer a, String b) -> {});
        System.out.println("Success.");

        Pair<Double, String> p2 = new Pair<>(1.0, "bb");
//        App.handle(new Event<>(p2), (Integer a, String b) -> {});   // здесь должна быть ошибка так как получатель не может обработать Double

        Pair<Boolean, String> p3 = new Pair<>(true, "bb");
//        App.handle(new Event<>(p3), (a, b) -> {});   // здесь должна быть ошибка так как первый параметр пары имеет нечисловой тип
    }
}
