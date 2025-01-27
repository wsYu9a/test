package e5;

import com.google.common.collect.Synchronized;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

@a5.b(emulated = true)
@m
/* loaded from: classes2.dex */
public final class f1 {
    @a5.a
    @CanIgnoreReturnValue
    @a5.c
    public static <E> int a(BlockingQueue<E> blockingQueue, Collection<? super E> collection, int i10, long j10, TimeUnit timeUnit) throws InterruptedException {
        b5.u.E(collection);
        long nanoTime = System.nanoTime() + timeUnit.toNanos(j10);
        int i11 = 0;
        while (i11 < i10) {
            i11 += blockingQueue.drainTo(collection, i10 - i11);
            if (i11 < i10) {
                E poll = blockingQueue.poll(nanoTime - System.nanoTime(), TimeUnit.NANOSECONDS);
                if (poll == null) {
                    break;
                }
                collection.add(poll);
                i11++;
            }
        }
        return i11;
    }

    @CanIgnoreReturnValue
    @a5.a
    @a5.c
    public static <E> int b(BlockingQueue<E> blockingQueue, Collection<? super E> collection, int i10, long j10, TimeUnit timeUnit) {
        E poll;
        b5.u.E(collection);
        long nanoTime = System.nanoTime() + timeUnit.toNanos(j10);
        int i11 = 0;
        boolean z10 = false;
        while (i11 < i10) {
            try {
                i11 += blockingQueue.drainTo(collection, i10 - i11);
                if (i11 < i10) {
                    while (true) {
                        try {
                            poll = blockingQueue.poll(nanoTime - System.nanoTime(), TimeUnit.NANOSECONDS);
                            break;
                        } catch (InterruptedException unused) {
                            z10 = true;
                        }
                    }
                    if (poll == null) {
                        break;
                    }
                    collection.add(poll);
                    i11++;
                }
            } finally {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        return i11;
    }

    @a5.c
    public static <E> ArrayBlockingQueue<E> c(int i10) {
        return new ArrayBlockingQueue<>(i10);
    }

    public static <E> ArrayDeque<E> d() {
        return new ArrayDeque<>();
    }

    public static <E> ArrayDeque<E> e(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new ArrayDeque<>((Collection) iterable);
        }
        ArrayDeque<E> arrayDeque = new ArrayDeque<>();
        u0.a(arrayDeque, iterable);
        return arrayDeque;
    }

    @a5.c
    public static <E> ConcurrentLinkedQueue<E> f() {
        return new ConcurrentLinkedQueue<>();
    }

    @a5.c
    public static <E> ConcurrentLinkedQueue<E> g(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new ConcurrentLinkedQueue<>((Collection) iterable);
        }
        ConcurrentLinkedQueue<E> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        u0.a(concurrentLinkedQueue, iterable);
        return concurrentLinkedQueue;
    }

    @a5.c
    public static <E> LinkedBlockingDeque<E> h() {
        return new LinkedBlockingDeque<>();
    }

    @a5.c
    public static <E> LinkedBlockingDeque<E> i(int i10) {
        return new LinkedBlockingDeque<>(i10);
    }

    @a5.c
    public static <E> LinkedBlockingDeque<E> j(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new LinkedBlockingDeque<>((Collection) iterable);
        }
        LinkedBlockingDeque<E> linkedBlockingDeque = new LinkedBlockingDeque<>();
        u0.a(linkedBlockingDeque, iterable);
        return linkedBlockingDeque;
    }

    @a5.c
    public static <E> LinkedBlockingQueue<E> k() {
        return new LinkedBlockingQueue<>();
    }

    @a5.c
    public static <E> LinkedBlockingQueue<E> l(int i10) {
        return new LinkedBlockingQueue<>(i10);
    }

    @a5.c
    public static <E> LinkedBlockingQueue<E> m(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new LinkedBlockingQueue<>((Collection) iterable);
        }
        LinkedBlockingQueue<E> linkedBlockingQueue = new LinkedBlockingQueue<>();
        u0.a(linkedBlockingQueue, iterable);
        return linkedBlockingQueue;
    }

    @a5.c
    public static <E extends Comparable> PriorityBlockingQueue<E> n() {
        return new PriorityBlockingQueue<>();
    }

    @a5.c
    public static <E extends Comparable> PriorityBlockingQueue<E> o(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new PriorityBlockingQueue<>((Collection) iterable);
        }
        PriorityBlockingQueue<E> priorityBlockingQueue = new PriorityBlockingQueue<>();
        u0.a(priorityBlockingQueue, iterable);
        return priorityBlockingQueue;
    }

    public static <E extends Comparable> PriorityQueue<E> p() {
        return new PriorityQueue<>();
    }

    public static <E extends Comparable> PriorityQueue<E> q(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new PriorityQueue<>((Collection) iterable);
        }
        PriorityQueue<E> priorityQueue = new PriorityQueue<>();
        u0.a(priorityQueue, iterable);
        return priorityQueue;
    }

    @a5.c
    public static <E> SynchronousQueue<E> r() {
        return new SynchronousQueue<>();
    }

    public static <E> Deque<E> s(Deque<E> deque) {
        return Synchronized.i(deque, null);
    }

    public static <E> Queue<E> t(Queue<E> queue) {
        return Synchronized.t(queue, null);
    }
}
