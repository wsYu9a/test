package com.nostra13.universalimageloader.core.assist.deque;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import okhttp3.HttpUrl;

/* loaded from: classes3.dex */
public class LinkedBlockingDeque<E> extends AbstractQueue<E> implements bf.a<E>, Serializable {
    private static final long serialVersionUID = -387911632671998426L;
    private final int capacity;
    private transient int count;
    transient e<E> first;
    transient e<E> last;
    final ReentrantLock lock;
    private final Condition notEmpty;
    private final Condition notFull;

    public abstract class b implements Iterator<E> {

        /* renamed from: b */
        public e<E> f16331b;

        /* renamed from: c */
        public E f16332c;

        /* renamed from: d */
        public e<E> f16333d;

        public b() {
            ReentrantLock reentrantLock = LinkedBlockingDeque.this.lock;
            reentrantLock.lock();
            try {
                e<E> b10 = b();
                this.f16331b = b10;
                this.f16332c = b10 == null ? null : b10.f16337a;
            } finally {
                reentrantLock.unlock();
            }
        }

        public void a() {
            ReentrantLock reentrantLock = LinkedBlockingDeque.this.lock;
            reentrantLock.lock();
            try {
                e<E> d10 = d(this.f16331b);
                this.f16331b = d10;
                this.f16332c = d10 == null ? null : d10.f16337a;
            } finally {
                reentrantLock.unlock();
            }
        }

        public abstract e<E> b();

        public abstract e<E> c(e<E> eVar);

        public final e<E> d(e<E> eVar) {
            while (true) {
                e<E> c10 = c(eVar);
                if (c10 == null) {
                    return null;
                }
                if (c10.f16337a != null) {
                    return c10;
                }
                if (c10 == eVar) {
                    return b();
                }
                eVar = c10;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f16331b != null;
        }

        @Override // java.util.Iterator
        public E next() {
            e<E> eVar = this.f16331b;
            if (eVar == null) {
                throw new NoSuchElementException();
            }
            this.f16333d = eVar;
            E e10 = this.f16332c;
            a();
            return e10;
        }

        @Override // java.util.Iterator
        public void remove() {
            e<E> eVar = this.f16333d;
            if (eVar == null) {
                throw new IllegalStateException();
            }
            this.f16333d = null;
            ReentrantLock reentrantLock = LinkedBlockingDeque.this.lock;
            reentrantLock.lock();
            try {
                if (eVar.f16337a != null) {
                    LinkedBlockingDeque.this.unlink(eVar);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public class c extends b {
        public c() {
            super();
        }

        @Override // com.nostra13.universalimageloader.core.assist.deque.LinkedBlockingDeque.b
        public e<E> b() {
            return LinkedBlockingDeque.this.last;
        }

        @Override // com.nostra13.universalimageloader.core.assist.deque.LinkedBlockingDeque.b
        public e<E> c(e<E> eVar) {
            return eVar.f16338b;
        }

        public /* synthetic */ c(LinkedBlockingDeque linkedBlockingDeque, a aVar) {
            this();
        }
    }

    public class d extends b {
        public d() {
            super();
        }

        @Override // com.nostra13.universalimageloader.core.assist.deque.LinkedBlockingDeque.b
        public e<E> b() {
            return LinkedBlockingDeque.this.first;
        }

        @Override // com.nostra13.universalimageloader.core.assist.deque.LinkedBlockingDeque.b
        public e<E> c(e<E> eVar) {
            return eVar.f16339c;
        }

        public /* synthetic */ d(LinkedBlockingDeque linkedBlockingDeque, a aVar) {
            this();
        }
    }

    public static final class e<E> {

        /* renamed from: a */
        public E f16337a;

        /* renamed from: b */
        public e<E> f16338b;

        /* renamed from: c */
        public e<E> f16339c;

        public e(E e10) {
            this.f16337a = e10;
        }
    }

    public LinkedBlockingDeque() {
        this(Integer.MAX_VALUE);
    }

    private boolean linkFirst(e<E> eVar) {
        int i10 = this.count;
        if (i10 >= this.capacity) {
            return false;
        }
        e<E> eVar2 = this.first;
        eVar.f16339c = eVar2;
        this.first = eVar;
        if (this.last == null) {
            this.last = eVar;
        } else {
            eVar2.f16338b = eVar;
        }
        this.count = i10 + 1;
        this.notEmpty.signal();
        return true;
    }

    private boolean linkLast(e<E> eVar) {
        int i10 = this.count;
        if (i10 >= this.capacity) {
            return false;
        }
        e<E> eVar2 = this.last;
        eVar.f16338b = eVar2;
        this.last = eVar;
        if (this.first == null) {
            this.first = eVar;
        } else {
            eVar2.f16339c = eVar;
        }
        this.count = i10 + 1;
        this.notEmpty.signal();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.count = 0;
        this.first = null;
        this.last = null;
        while (true) {
            Object readObject = objectInputStream.readObject();
            if (readObject == null) {
                return;
            } else {
                add(readObject);
            }
        }
    }

    private E unlinkFirst() {
        e<E> eVar = this.first;
        if (eVar == null) {
            return null;
        }
        e<E> eVar2 = eVar.f16339c;
        E e10 = eVar.f16337a;
        eVar.f16337a = null;
        eVar.f16339c = eVar;
        this.first = eVar2;
        if (eVar2 == null) {
            this.last = null;
        } else {
            eVar2.f16338b = null;
        }
        this.count--;
        this.notFull.signal();
        return e10;
    }

    private E unlinkLast() {
        e<E> eVar = this.last;
        if (eVar == null) {
            return null;
        }
        e<E> eVar2 = eVar.f16338b;
        E e10 = eVar.f16337a;
        eVar.f16337a = null;
        eVar.f16338b = eVar;
        this.last = eVar2;
        if (eVar2 == null) {
            this.first = null;
        } else {
            eVar2.f16339c = null;
        }
        this.count--;
        this.notFull.signal();
        return e10;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            objectOutputStream.defaultWriteObject();
            for (e<E> eVar = this.first; eVar != null; eVar = eVar.f16339c) {
                objectOutputStream.writeObject(eVar.f16337a);
            }
            objectOutputStream.writeObject(null);
            reentrantLock.unlock();
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue, bf.a, java.util.concurrent.BlockingQueue, bf.b
    public boolean add(E e10) {
        addLast(e10);
        return true;
    }

    @Override // bf.a, bf.b
    public void addFirst(E e10) {
        if (!offerFirst(e10)) {
            throw new IllegalStateException("Deque full");
        }
    }

    @Override // bf.a, bf.b
    public void addLast(E e10) {
        if (!offerLast(e10)) {
            throw new IllegalStateException("Deque full");
        }
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            e<E> eVar = this.first;
            while (eVar != null) {
                eVar.f16337a = null;
                e<E> eVar2 = eVar.f16339c;
                eVar.f16338b = null;
                eVar.f16339c = null;
                eVar = eVar2;
            }
            this.last = null;
            this.first = null;
            this.count = 0;
            this.notFull.signalAll();
            reentrantLock.unlock();
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, bf.a, java.util.concurrent.BlockingQueue, bf.b
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (e<E> eVar = this.first; eVar != null; eVar = eVar.f16339c) {
                if (obj.equals(eVar.f16337a)) {
                    reentrantLock.unlock();
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // bf.b
    public Iterator<E> descendingIterator() {
        return new c();
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection) {
        return drainTo(collection, Integer.MAX_VALUE);
    }

    @Override // java.util.AbstractQueue, java.util.Queue, bf.a, bf.b
    public E element() {
        return getFirst();
    }

    @Override // bf.b
    public E getFirst() {
        E peekFirst = peekFirst();
        if (peekFirst != null) {
            return peekFirst;
        }
        throw new NoSuchElementException();
    }

    @Override // bf.b
    public E getLast() {
        E peekLast = peekLast();
        if (peekLast != null) {
            return peekLast;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, bf.a, bf.b
    public Iterator<E> iterator() {
        return new d();
    }

    public boolean offer(E e10) {
        return offerLast(e10);
    }

    @Override // bf.a, bf.b
    public boolean offerFirst(E e10) {
        e10.getClass();
        e<E> eVar = new e<>(e10);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return linkFirst(eVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // bf.a, bf.b
    public boolean offerLast(E e10) {
        e10.getClass();
        e<E> eVar = new e<>(e10);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return linkLast(eVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.Queue, bf.a, bf.b
    public E peek() {
        return peekFirst();
    }

    @Override // bf.b
    public E peekFirst() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            e<E> eVar = this.first;
            return eVar == null ? null : eVar.f16337a;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // bf.b
    public E peekLast() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            e<E> eVar = this.last;
            return eVar == null ? null : eVar.f16337a;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.Queue, bf.a, bf.b
    public E poll() {
        return pollFirst();
    }

    @Override // bf.b
    public E pollFirst() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return unlinkFirst();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // bf.b
    public E pollLast() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return unlinkLast();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // bf.b
    public E pop() {
        return removeFirst();
    }

    @Override // bf.a, bf.b
    public void push(E e10) {
        addFirst(e10);
    }

    @Override // bf.a, java.util.concurrent.BlockingQueue
    public void put(E e10) throws InterruptedException {
        putLast(e10);
    }

    @Override // bf.a
    public void putFirst(E e10) throws InterruptedException {
        e10.getClass();
        e<E> eVar = new e<>(e10);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (!linkFirst(eVar)) {
            try {
                this.notFull.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // bf.a
    public void putLast(E e10) throws InterruptedException {
        e10.getClass();
        e<E> eVar = new e<>(e10);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (!linkLast(eVar)) {
            try {
                this.notFull.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.capacity - this.count;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractQueue, java.util.Queue, bf.a, bf.b
    public E remove() {
        return removeFirst();
    }

    @Override // bf.b
    public E removeFirst() {
        E pollFirst = pollFirst();
        if (pollFirst != null) {
            return pollFirst;
        }
        throw new NoSuchElementException();
    }

    @Override // bf.a, bf.b
    public boolean removeFirstOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (e<E> eVar = this.first; eVar != null; eVar = eVar.f16339c) {
                if (obj.equals(eVar.f16337a)) {
                    unlink(eVar);
                    reentrantLock.unlock();
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // bf.b
    public E removeLast() {
        E pollLast = pollLast();
        if (pollLast != null) {
            return pollLast;
        }
        throw new NoSuchElementException();
    }

    @Override // bf.a, bf.b
    public boolean removeLastOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (e<E> eVar = this.last; eVar != null; eVar = eVar.f16338b) {
                if (obj.equals(eVar.f16337a)) {
                    unlink(eVar);
                    reentrantLock.unlock();
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, bf.a, bf.b
    public int size() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.count;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // bf.a, java.util.concurrent.BlockingQueue
    public E take() throws InterruptedException {
        return takeFirst();
    }

    @Override // bf.a
    public E takeFirst() throws InterruptedException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (true) {
            try {
                E unlinkFirst = unlinkFirst();
                if (unlinkFirst != null) {
                    return unlinkFirst;
                }
                this.notEmpty.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // bf.a
    public E takeLast() throws InterruptedException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (true) {
            try {
                E unlinkLast = unlinkLast();
                if (unlinkLast != null) {
                    return unlinkLast;
                }
                this.notEmpty.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Object[] objArr = new Object[this.count];
            e<E> eVar = this.first;
            int i10 = 0;
            while (eVar != null) {
                int i11 = i10 + 1;
                objArr[i10] = eVar.f16337a;
                eVar = eVar.f16339c;
                i10 = i11;
            }
            return objArr;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            e<E> eVar = this.first;
            if (eVar == null) {
                return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append('[');
            while (true) {
                Object obj = eVar.f16337a;
                if (obj == this) {
                    obj = "(this Collection)";
                }
                sb2.append(obj);
                eVar = eVar.f16339c;
                if (eVar == null) {
                    sb2.append(']');
                    return sb2.toString();
                }
                sb2.append(',');
                sb2.append(b5.a.O);
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public void unlink(e<E> eVar) {
        e<E> eVar2 = eVar.f16338b;
        e<E> eVar3 = eVar.f16339c;
        if (eVar2 == null) {
            unlinkFirst();
            return;
        }
        if (eVar3 == null) {
            unlinkLast();
            return;
        }
        eVar2.f16339c = eVar3;
        eVar3.f16338b = eVar2;
        eVar.f16337a = null;
        this.count--;
        this.notFull.signal();
    }

    public LinkedBlockingDeque(int i10) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.notEmpty = reentrantLock.newCondition();
        this.notFull = reentrantLock.newCondition();
        if (i10 <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = i10;
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection, int i10) {
        collection.getClass();
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int min = Math.min(i10, this.count);
            for (int i11 = 0; i11 < min; i11++) {
                collection.add(this.first.f16337a);
                unlinkFirst();
            }
            return min;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // bf.a, java.util.concurrent.BlockingQueue
    public boolean offer(E e10, long j10, TimeUnit timeUnit) throws InterruptedException {
        return offerLast(e10, j10, timeUnit);
    }

    @Override // bf.a, java.util.concurrent.BlockingQueue
    public E poll(long j10, TimeUnit timeUnit) throws InterruptedException {
        return pollFirst(j10, timeUnit);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, bf.a, java.util.concurrent.BlockingQueue, bf.b
    public boolean remove(Object obj) {
        return removeFirstOccurrence(obj);
    }

    @Override // bf.a
    public E pollFirst(long j10, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j10);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                E unlinkFirst = unlinkFirst();
                if (unlinkFirst != null) {
                    return unlinkFirst;
                }
                if (nanos <= 0) {
                    reentrantLock.unlock();
                    return null;
                }
                nanos = this.notEmpty.awaitNanos(nanos);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // bf.a
    public E pollLast(long j10, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j10);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                E unlinkLast = unlinkLast();
                if (unlinkLast != null) {
                    return unlinkLast;
                }
                if (nanos <= 0) {
                    reentrantLock.unlock();
                    return null;
                }
                nanos = this.notEmpty.awaitNanos(nanos);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // bf.a
    public boolean offerFirst(E e10, long j10, TimeUnit timeUnit) throws InterruptedException {
        e10.getClass();
        e<E> eVar = new e<>(e10);
        long nanos = timeUnit.toNanos(j10);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (!linkFirst(eVar)) {
            try {
                if (nanos <= 0) {
                    reentrantLock.unlock();
                    return false;
                }
                nanos = this.notFull.awaitNanos(nanos);
            } catch (Throwable th2) {
                reentrantLock.unlock();
                throw th2;
            }
        }
        reentrantLock.unlock();
        return true;
    }

    @Override // bf.a
    public boolean offerLast(E e10, long j10, TimeUnit timeUnit) throws InterruptedException {
        e10.getClass();
        e<E> eVar = new e<>(e10);
        long nanos = timeUnit.toNanos(j10);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (!linkLast(eVar)) {
            try {
                if (nanos <= 0) {
                    reentrantLock.unlock();
                    return false;
                }
                nanos = this.notFull.awaitNanos(nanos);
            } catch (Throwable th2) {
                reentrantLock.unlock();
                throw th2;
            }
        }
        reentrantLock.unlock();
        return true;
    }

    public LinkedBlockingDeque(Collection<? extends E> collection) {
        this(Integer.MAX_VALUE);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (E e10 : collection) {
                if (e10 != null) {
                    if (!linkLast(new e<>(e10))) {
                        throw new IllegalStateException("Deque full");
                    }
                } else {
                    throw new NullPointerException();
                }
            }
            reentrantLock.unlock();
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (tArr.length < this.count) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.count));
            }
            e<E> eVar = this.first;
            int i10 = 0;
            while (eVar != null) {
                tArr[i10] = eVar.f16337a;
                eVar = eVar.f16339c;
                i10++;
            }
            if (tArr.length > i10) {
                tArr[i10] = null;
            }
            reentrantLock.unlock();
            return tArr;
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }
}
