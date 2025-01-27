package com.nostra13.universalimageloader.core.assist.deque;

/* loaded from: classes4.dex */
public class LIFOLinkedBlockingDeque<T> extends LinkedBlockingDeque<T> {
    private static final long serialVersionUID = -4114786347960826192L;

    @Override // com.nostra13.universalimageloader.core.assist.deque.LinkedBlockingDeque, java.util.Queue, com.nostra13.universalimageloader.core.assist.deque.a, java.util.concurrent.BlockingQueue, com.nostra13.universalimageloader.core.assist.deque.b
    public boolean offer(T t) {
        return super.offerFirst(t);
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.LinkedBlockingDeque, java.util.AbstractQueue, java.util.Queue, com.nostra13.universalimageloader.core.assist.deque.a, com.nostra13.universalimageloader.core.assist.deque.b
    public T remove() {
        return (T) super.removeFirst();
    }
}
