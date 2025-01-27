package com.nostra13.universalimageloader.core.assist.deque;

/* loaded from: classes3.dex */
public class LIFOLinkedBlockingDeque<T> extends LinkedBlockingDeque<T> {
    private static final long serialVersionUID = -4114786347960826192L;

    @Override // com.nostra13.universalimageloader.core.assist.deque.LinkedBlockingDeque, java.util.Queue, bf.a, java.util.concurrent.BlockingQueue, bf.b
    public boolean offer(T t10) {
        return super.offerFirst(t10);
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.LinkedBlockingDeque, java.util.AbstractQueue, java.util.Queue, bf.a, bf.b
    public T remove() {
        return (T) super.removeFirst();
    }
}
