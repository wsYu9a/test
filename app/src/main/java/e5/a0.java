package e5;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Deque;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@m
@a5.c
/* loaded from: classes2.dex */
public abstract class a0<E> extends m0<E> implements Deque<E> {
    @Override // java.util.Deque
    public void addFirst(@d1 E e10) {
        delegate().addFirst(e10);
    }

    @Override // java.util.Deque
    public void addLast(@d1 E e10) {
        delegate().addLast(e10);
    }

    @Override // java.util.Deque
    public Iterator<E> descendingIterator() {
        return delegate().descendingIterator();
    }

    @Override // e5.m0, e5.y, e5.l0
    /* renamed from: e */
    public abstract Deque<E> delegate();

    @Override // java.util.Deque
    @d1
    public E getFirst() {
        return delegate().getFirst();
    }

    @Override // java.util.Deque
    @d1
    public E getLast() {
        return delegate().getLast();
    }

    @Override // java.util.Deque
    @CanIgnoreReturnValue
    public boolean offerFirst(@d1 E e10) {
        return delegate().offerFirst(e10);
    }

    @Override // java.util.Deque
    @CanIgnoreReturnValue
    public boolean offerLast(@d1 E e10) {
        return delegate().offerLast(e10);
    }

    @Override // java.util.Deque
    @CheckForNull
    public E peekFirst() {
        return delegate().peekFirst();
    }

    @Override // java.util.Deque
    @CheckForNull
    public E peekLast() {
        return delegate().peekLast();
    }

    @Override // java.util.Deque
    @CanIgnoreReturnValue
    @CheckForNull
    public E pollFirst() {
        return delegate().pollFirst();
    }

    @Override // java.util.Deque
    @CanIgnoreReturnValue
    @CheckForNull
    public E pollLast() {
        return delegate().pollLast();
    }

    @Override // java.util.Deque
    @CanIgnoreReturnValue
    @d1
    public E pop() {
        return delegate().pop();
    }

    @Override // java.util.Deque
    public void push(@d1 E e10) {
        delegate().push(e10);
    }

    @Override // java.util.Deque
    @CanIgnoreReturnValue
    @d1
    public E removeFirst() {
        return delegate().removeFirst();
    }

    @Override // java.util.Deque
    @CanIgnoreReturnValue
    public boolean removeFirstOccurrence(@CheckForNull Object obj) {
        return delegate().removeFirstOccurrence(obj);
    }

    @Override // java.util.Deque
    @CanIgnoreReturnValue
    @d1
    public E removeLast() {
        return delegate().removeLast();
    }

    @Override // java.util.Deque
    @CanIgnoreReturnValue
    public boolean removeLastOccurrence(@CheckForNull Object obj) {
        return delegate().removeLastOccurrence(obj);
    }
}
