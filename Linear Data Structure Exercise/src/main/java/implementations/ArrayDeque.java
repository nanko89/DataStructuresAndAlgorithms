package implementations;

import interfaces.Deque;

import java.util.Iterator;

public class ArrayDeque<E> implements Deque<E> {
    private static final int DEFAULT_CAPACITY = 7;
    private Object[] elements;
    private int size;
    private int tail;
    private int head;

    public ArrayDeque() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.head = this.elements.length / 2;
        this.tail = this.head;
    }

    @Override
    public void add(E element) {
        this.addLast(element);
    }

    private Object[] growSize() {
        int newCapacity = (this.elements.length * 2) + 1;

        Object[] newElements = new Object[newCapacity];

        int middle = newCapacity / 2;

        int begin = middle - this.size / 2;

        int index = this.head;


        for (int i = begin; index <= this.tail; i++) {
            newElements[i] = this.elements[index++];
        }

        this.head = begin;

        this.tail = this.head + this.size - 1;

        return newElements;
    }

    @SuppressWarnings("unchecked")
    private E getAt(int index) {
        return (E) this.elements[index];
    }

    @Override
    public void offer(E element) {
        addLast(element);
    }

    @Override
    public void addFirst(E element) {
        if (isEmpty()) {
            this.elements[this.head] = element;
        } else {
            if (this.head == 0) {
                this.elements = growSize();
            }
            this.elements[--this.head] = element;
        }
        size++;

    }

    @Override
    public void addLast(E element) {
        if (isEmpty()) {
            this.elements[this.tail] = element;
        } else {
            if (this.tail == this.elements.length - 1) {
                this.elements = growSize();
            }
            this.elements[++this.tail] = element;
        }
        this.size++;
    }

    @Override
    public void push(E element) {
       this. addFirst(element);
    }

    @Override
    public void insert(int index, E element) {
        int realIndex = this.head + index;
        isValidIndex(realIndex);

        if (realIndex - this.head < this.tail - realIndex) {
            insertAndShiftLeft(element, realIndex - 1);
        } else {
            insertAndShiftRight(element, realIndex);
        }

    }

    private void insertAndShiftRight(E element, int index) {
        E lastElement = this.getAt(this.tail);

        for (int i = this.tail; i > index; i--) {
            this.elements[i] = this.elements[i-1];
        }
        this.elements[index] = element;
        this.addLast(lastElement);

    }

    private void insertAndShiftLeft(E element, int index) {
        E firstElement = this.getAt(this.head);

        for (int i = this.head; i <= index; i++) {
            this.elements[i] = this.elements[i+1];
        }
        this.elements[index] = element;
        this.addFirst(firstElement);
    }

    private void isValidIndex(int index) {
        if (index < this.head || index > this.tail) {
            throw new IndexOutOfBoundsException("Invalid index!");
        }
    }

    @Override
    public void set(int index, E element) {
        int realIndex = this.head + index;
        this.isValidIndex(index);
        this.elements[index] = element;
    }

    @Override
    public E peek() {
        if (this.size != 0) {
            return getAt(this.head);

        }
        return null;

    }

    @Override
    public E poll() {
        return this.removeFirst();
    }

    @Override
    public E pop() {
        return this.removeLast();
    }


    @Override
    public E get(int index) {
        int realIndex = index + this.head;
        this.isValidIndex(realIndex);
        return getAt(realIndex);
    }

    @Override
    public E get(Object object) {
        if (isEmpty()){
            return null;
        }
        for (int i = this.head; i <= this.tail; i++) {
            if (this.elements[i].equals(object)) {
                return this.getAt(i);
            }
        }
        return null;
    }

    @Override
    public E remove(int index) {
        int realIndex = this.head + index;
        isValidIndex(realIndex);
        if (realIndex == head) {
            head++;
        } else if (realIndex == tail) {
            tail--;
        }
        E element = getAt(realIndex);
        elements[realIndex] = null;
        size--;
        return element;
    }

    @Override
    public E remove(Object object) {
        if(isEmpty()){
            return null;
        }
        for (int i = this.head; i <= this.tail; i++) {
            if (this.elements[i].equals(object)) {
                E element = this.getAt(i);
                this.elements[i] = null;

                for (int j = i; j <this.tail ; j++) {
                    this.elements[j] = this.elements[j-1];
                }
                this.removeLast();
                return element;
             }
        }

            size--;
       return null;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E removeElement = getAt(this.head);
        this.elements[head] = null;
        this.head++;
        this.size--;
        return removeElement;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        E removeElement = getAt(this.tail);
        this.elements[tail] = null;
        this.tail--;
        this.size--;
        return removeElement;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int capacity() {
        return this.elements.length;
    }

    @Override
    public void trimToSize() {
        Object[] newElement = new Object[size];
        for (int i = 0; i < size; i++) {
            newElement[i] = elements[head + i];
        }
        this.elements = newElement;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = head;

            @Override
            public boolean hasNext() {
                return index !=tail;
            }

            @Override
            public E next() {
                return getAt(index++);
            }
        };
    }
}
