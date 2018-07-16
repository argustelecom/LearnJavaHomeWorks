package ru.argustelecom.learnjavahomeworks.exercises.n01.mike;

import java.util.Comparator;

import ru.argustelecom.learnjavahomeworks.exercises.n01.model.Pair;

public class PairComparator<T extends Pair<? extends Integer,?>> implements Comparator<T> {
	/* Как бы здесь уйти от явного extends Integer ? 
	 * Если использовать Comparable<?>, компилятор не даёт использовать compareTo:
	 * 
	 * public class PairComparator<T extends Pair<Comparable<?>, ?>> implements Comparator<T>
	 * ...
	 * return p1.getFirst().compareTo(p2.getFirst());
	 * 
	 * >> The method compareTo(capture#2-of ?) in the type Comparable<capture#2-of ?> 
	 *     is not applicable for the arguments (Comparable<capture#4-of ?>)
	 */
	public int compare(T p1, T p2) {
		return p1.getFirst().compareTo(p2.getFirst());
  }
}