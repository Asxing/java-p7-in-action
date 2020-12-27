package com.holddie.design.pattern.p3behavior.iterator.modeOne;

public class SnapshotArrayIterator<E> implements Iterator<E> {

	private int cursor;
	private ArrayList snapshot;
	
	public SnapshotArrayIterator(ArrayList arrayList) {
		this.cursor = 0;
		this.snapshot = new ArrayList<>();
		this.snapshot.addAll(arrayList);
	}

	@Override
	public boolean hasNext() {
		return cursor < snapshot.size();
	}

	@Override
	public E next() {
		E currentItem = (E) snapshot.get(cursor);
		cursor++;
		return currentItem;
	}
}
