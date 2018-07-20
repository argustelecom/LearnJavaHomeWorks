package ru.argustelecom.learnjavahomeworks.exercises.n01.kk;

import org.junit.Test;
import ru.argustelecom.learnjavahomeworks.exercises.n01.model.Event;
import ru.argustelecom.learnjavahomeworks.exercises.n01.model.Pair;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MainTest {

	@Test
	public void handle() {
		Pair<Integer, String> p = new Pair<>(1, "bb");

		// следующие вызовы должны "сходиться" без ошибок
		final String[] s = new String[1];
		Main.handle(new Event<>(p), (a, b) -> { s[0] =(a+","+b);}); assertEquals(s[0],"1,bb");
		Main.handle(new Event<>(p), (Object a, Object b) -> { s[0] =(a+"|"+b);}); assertEquals(s[0],"1|bb");
		Main.handle(new Event<>(p), (Object a, String b) -> { s[0] =(a+"x"+b);}); assertEquals(s[0],"1xbb");
		Main.handle(new Event<>(p), (Number a, Object b) -> { s[0] =(a+"c"+b);}); assertEquals(s[0],"1cbb");
		Main.handle(new Event<>(p), (Integer a, Object b) -> { s[0] =(a+"v"+b);}); assertEquals(s[0],"1vbb");
		Main.handle(new Event<>(p), (Integer a, String b) -> { s[0] =(a+"b"+b);}); assertEquals(s[0],"1bbb");
	}

	@Test
	public void concatSorted() {
		Pair<Integer, String> p1 = new Pair<>(2, "bb");
		Pair<Integer, String> p2 = new Pair<>(1, "aa");

		assertEquals(Main.concatSorted(Arrays.asList(p1, p2)),"aa,bb");
		assertEquals(Main.concatSorted(Arrays.asList(p2, p1)),"aa,bb");
		assertEquals(Main.concatSorted(Arrays.asList(p1)),"bb");
		assertEquals(Main.concatSorted(Arrays.asList()),"");
	}

}