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

/* loaded from: classes4.dex */
public class LinkedBlockingDeque<E> extends AbstractQueue<E> implements com.nostra13.universalimageloader.core.assist.deque.a<E>, Serializable {
    private static final long serialVersionUID = -387911632671998426L;
    private final int capacity;
    private transient int count;
    transient e<E> first;
    transient e<E> last;
    final ReentrantLock lock;
    private final Condition notEmpty;
    private final Condition notFull;

    private abstract class b implements Iterator<E> {

        /* renamed from: a */
        e<E> f15921a;

        /* renamed from: b */
        E f15922b;

        /* renamed from: c */
        private e<E> f15923c;

        b() {
            ReentrantLock reentrantLock = LinkedBlockingDeque.this.lock;
            reentrantLock.lock();
            try {
                e<E> b2 = b();
                this.f15921a = b2;
                this.f15922b = b2 == null ? null : b2.f15927a;
            } finally {
                reentrantLock.unlock();
            }
        }

        private e<E> d(e<E> eVar) {
            while (true) {
                e<E> c2 = c(eVar);
                if (c2 == null) {
                    return null;
                }
                if (c2.f15927a != null) {
                    return c2;
                }
                if (c2 == eVar) {
                    return b();
                }
                eVar = c2;
            }
        }

        void a() {
            ReentrantLock reentrantLock = LinkedBlockingDeque.this.lock;
            reentrantLock.lock();
            try {
                e<E> d2 = d(this.f15921a);
                this.f15921a = d2;
                this.f15922b = d2 == null ? null : d2.f15927a;
            } finally {
                reentrantLock.unlock();
            }
        }

        abstract e<E> b();

        abstract e<E> c(e<E> eVar);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f15921a != null;
        }

        @Override // java.util.Iterator
        public E next() {
            e<E> eVar = this.f15921a;
            if (eVar == null) {
                throw new NoSuchElementException();
            }
            this.f15923c = eVar;
            E e2 = this.f15922b;
            a();
            return e2;
        }

        @Override // java.util.Iterator
        public void remove() {
            e<E> eVar = this.f15923c;
            if (eVar == null) {
                throw new IllegalStateException();
            }
            this.f15923c = null;
            ReentrantLock reentrantLock = LinkedBlockingDeque.this.lock;
            reentrantLock.lock();
            try {
                if (eVar.f15927a != null) {
                    LinkedBlockingDeque.this.unlink(eVar);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    private class c extends b {
        private c() {
            super();
        }

        @Override // com.nostra13.universalimageloader.core.assist.deque.LinkedBlockingDeque.b
        e<E> b() {
            return LinkedBlockingDeque.this.last;
        }

        @Override // com.nostra13.universalimageloader.core.assist.deque.LinkedBlockingDeque.b
        e<E> c(e<E> eVar) {
            return eVar.f15928b;
        }

        /* synthetic */ c(LinkedBlockingDeque linkedBlockingDeque, a aVar) {
            this();
        }
    }

    private class d extends b {
        private d() {
            super();
        }

        @Override // com.nostra13.universalimageloader.core.assist.deque.LinkedBlockingDeque.b
        e<E> b() {
            return LinkedBlockingDeque.this.first;
        }

        @Override // com.nostra13.universalimageloader.core.assist.deque.LinkedBlockingDeque.b
        e<E> c(e<E> eVar) {
            return eVar.f15929c;
        }

        /* synthetic */ d(LinkedBlockingDeque linkedBlockingDeque, a aVar) {
            this();
        }
    }

    static final class e<E> {

        /* renamed from: a */
        E f15927a;

        /* renamed from: b */
        e<E> f15928b;

        /* renamed from: c */
        e<E> f15929c;

        e(E e2) {
            this.f15927a = e2;
        }
    }

    public LinkedBlockingDeque() {
        this(Integer.MAX_VALUE);
    }

    private boolean linkFirst(e<E> eVar) {
        int i2 = this.count;
        if (i2 >= this.capacity) {
            return false;
        }
        e<E> eVar2 = this.first;
        eVar.f15929c = eVar2;
        this.first = eVar;
        if (this.last == null) {
            this.last = eVar;
        } else {
            eVar2.f15928b = eVar;
        }
        this.count = i2 + 1;
        this.notEmpty.signal();
        return true;
    }

    private boolean linkLast(e<E> eVar) {
        int i2 = this.count;
        if (i2 >= this.capacity) {
            return false;
        }
        e<E> eVar2 = this.last;
        eVar.f15928b = eVar2;
        this.last = eVar;
        if (this.first == null) {
            this.first = eVar;
        } else {
            eVar2.f15929c = eVar;
        }
        this.count = i2 + 1;
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
        e<E> eVar2 = eVar.f15929c;
        E e2 = eVar.f15927a;
        eVar.f15927a = null;
        eVar.f15929c = eVar;
        this.first = eVar2;
        if (eVar2 == null) {
            this.last = null;
        } else {
            eVar2.f15928b = null;
        }
        this.count--;
        this.notFull.signal();
        return e2;
    }

    private E unlinkLast() {
        e<E> eVar = this.last;
        if (eVar == null) {
            return null;
        }
        e<E> eVar2 = eVar.f15928b;
        E e2 = eVar.f15927a;
        eVar.f15927a = null;
        eVar.f15928b = eVar;
        this.last = eVar2;
        if (eVar2 == null) {
            this.first = null;
        } else {
            eVar2.f15929c = null;
        }
        this.count--;
        this.notFull.signal();
        return e2;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            objectOutputStream.defaultWriteObject();
            for (e<E> eVar = this.first; eVar != null; eVar = eVar.f15929c) {
                objectOutputStream.writeObject(eVar.f15927a);
            }
            objectOutputStream.writeObject(null);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue, com.nostra13.universalimageloader.core.assist.deque.a, java.util.concurrent.BlockingQueue, com.nostra13.universalimageloader.core.assist.deque.b
    public boolean add(E e2) {
        addLast(e2);
        return true;
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.a, com.nostra13.universalimageloader.core.assist.deque.b
    public void addFirst(E e2) {
        if (!offerFirst(e2)) {
            throw new IllegalStateException("Deque full");
        }
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.a, com.nostra13.universalimageloader.core.assist.deque.b
    public void addLast(E e2) {
        if (!offerLast(e2)) {
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
                eVar.f15927a = null;
                e<E> eVar2 = eVar.f15929c;
                eVar.f15928b = null;
                eVar.f15929c = null;
                eVar = eVar2;
            }
            this.last = null;
            this.first = null;
            this.count = 0;
            this.notFull.signalAll();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.nostra13.universalimageloader.core.assist.deque.a, java.util.concurrent.BlockingQueue, com.nostra13.universalimageloader.core.assist.deque.b
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (e<E> eVar = this.first; eVar != null; eVar = eVar.f15929c) {
                if (obj.equals(eVar.f15927a)) {
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.b
    public Iterator<E> descendingIterator() {
        return new c();
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection) {
        return drainTo(collection, Integer.MAX_VALUE);
    }

    @Override // java.util.AbstractQueue, java.util.Queue, com.nostra13.universalimageloader.core.assist.deque.a, com.nostra13.universalimageloader.core.assist.deque.b
    public E element() {
        return getFirst();
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.b
    public E getFirst() {
        E peekFirst = peekFirst();
        if (peekFirst != null) {
            return peekFirst;
        }
        throw new NoSuchElementException();
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.b
    public E getLast() {
        E peekLast = peekLast();
        if (peekLast != null) {
            return peekLast;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.nostra13.universalimageloader.core.assist.deque.a, com.nostra13.universalimageloader.core.assist.deque.b
    public Iterator<E> iterator() {
        return new d();
    }

    public boolean offer(E e2) {
        return offerLast(e2);
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.a, com.nostra13.universalimageloader.core.assist.deque.b
    public boolean offerFirst(E e2) {
        e2.getClass();
        e<E> eVar = new e<>(e2);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return linkFirst(eVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.a, com.nostra13.universalimageloader.core.assist.deque.b
    public boolean offerLast(E e2) {
        e2.getClass();
        e<E> eVar = new e<>(e2);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return linkLast(eVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.Queue, com.nostra13.universalimageloader.core.assist.deque.a, com.nostra13.universalimageloader.core.assist.deque.b
    public E peek() {
        return peekFirst();
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.b
    public E peekFirst() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            e<E> eVar = this.first;
            return eVar == null ? null : eVar.f15927a;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.b
    public E peekLast() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            e<E> eVar = this.last;
            return eVar == null ? null : eVar.f15927a;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.Queue, com.nostra13.universalimageloader.core.assist.deque.a, com.nostra13.universalimageloader.core.assist.deque.b
    public E poll() {
        return pollFirst();
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.b
    public E pollFirst() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return unlinkFirst();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.b
    public E pollLast() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return unlinkLast();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.b
    public E pop() {
        return removeFirst();
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.a, com.nostra13.universalimageloader.core.assist.deque.b
    public void push(E e2) {
        addFirst(e2);
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.a, java.util.concurrent.BlockingQueue
    public void put(E e2) throws InterruptedException {
        putLast(e2);
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.a
    public void putFirst(E e2) throws InterruptedException {
        e2.getClass();
        e<E> eVar = new e<>(e2);
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

    @Override // com.nostra13.universalimageloader.core.assist.deque.a
    public void putLast(E e2) throws InterruptedException {
        e2.getClass();
        e<E> eVar = new e<>(e2);
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

    @Override // java.util.AbstractQueue, java.util.Queue, com.nostra13.universalimageloader.core.assist.deque.a, com.nostra13.universalimageloader.core.assist.deque.b
    public E remove() {
        return removeFirst();
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.b
    public E removeFirst() {
        E pollFirst = pollFirst();
        if (pollFirst != null) {
            return pollFirst;
        }
        throw new NoSuchElementException();
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.a, com.nostra13.universalimageloader.core.assist.deque.b
    public boolean removeFirstOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (e<E> eVar = this.first; eVar != null; eVar = eVar.f15929c) {
                if (obj.equals(eVar.f15927a)) {
                    unlink(eVar);
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.b
    public E removeLast() {
        E pollLast = pollLast();
        if (pollLast != null) {
            return pollLast;
        }
        throw new NoSuchElementException();
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.a, com.nostra13.universalimageloader.core.assist.deque.b
    public boolean removeLastOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (e<E> eVar = this.last; eVar != null; eVar = eVar.f15928b) {
                if (obj.equals(eVar.f15927a)) {
                    unlink(eVar);
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.nostra13.universalimageloader.core.assist.deque.a, com.nostra13.universalimageloader.core.assist.deque.b
    public int size() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.count;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.a, java.util.concurrent.BlockingQueue
    public E take() throws InterruptedException {
        return takeFirst();
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.a
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

    @Override // com.nostra13.universalimageloader.core.assist.deque.a
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
            int i2 = 0;
            e<E> eVar = this.first;
            while (eVar != null) {
                int i3 = i2 + 1;
                objArr[i2] = eVar.f15927a;
                eVar = eVar.f15929c;
                i2 = i3;
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
                return "[]";
            }
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            while (true) {
                Object obj = eVar.f15927a;
                if (obj == this) {
                    obj = "(this Collection)";
                }
                sb.append(obj);
                eVar = eVar.f15929c;
                if (eVar == null) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(',');
                sb.append(' ');
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    void unlink(e<E> eVar) {
        e<E> eVar2 = eVar.f15928b;
        e<E> eVar3 = eVar.f15929c;
        if (eVar2 == null) {
            unlinkFirst();
            return;
        }
        if (eVar3 == null) {
            unlinkLast();
            return;
        }
        eVar2.f15929c = eVar3;
        eVar3.f15928b = eVar2;
        eVar.f15927a = null;
        this.count--;
        this.notFull.signal();
    }

    public LinkedBlockingDeque(int i2) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.notEmpty = reentrantLock.newCondition();
        this.notFull = reentrantLock.newCondition();
        if (i2 <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = i2;
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection, int i2) {
        collection.getClass();
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int min = Math.min(i2, this.count);
            for (int i3 = 0; i3 < min; i3++) {
                collection.add(this.first.f15927a);
                unlinkFirst();
            }
            return min;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.a, java.util.concurrent.BlockingQueue
    public boolean offer(E e2, long j2, TimeUnit timeUnit) throws InterruptedException {
        return offerLast(e2, j2, timeUnit);
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.a, java.util.concurrent.BlockingQueue
    public E poll(long j2, TimeUnit timeUnit) throws InterruptedException {
        return pollFirst(j2, timeUnit);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.nostra13.universalimageloader.core.assist.deque.a, java.util.concurrent.BlockingQueue, com.nostra13.universalimageloader.core.assist.deque.b
    public boolean remove(Object obj) {
        return removeFirstOccurrence(obj);
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.a
    public E pollFirst(long j2, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j2);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                E unlinkFirst = unlinkFirst();
                if (unlinkFirst != null) {
                    return unlinkFirst;
                }
                if (nanos <= 0) {
                    return null;
                }
                nanos = this.notEmpty.awaitNanos(nanos);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.a
    public E pollLast(long j2, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j2);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                E unlinkLast = unlinkLast();
                if (unlinkLast != null) {
                    return unlinkLast;
                }
                if (nanos <= 0) {
                    return null;
                }
                nanos = this.notEmpty.awaitNanos(nanos);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.a
    public boolean offerFirst(E e2, long j2, TimeUnit timeUnit) throws InterruptedException {
        boolean z;
        e2.getClass();
        e<E> eVar = new e<>(e2);
        long nanos = timeUnit.toNanos(j2);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                if (linkFirst(eVar)) {
                    z = true;
                    break;
                }
                if (nanos <= 0) {
                    z = false;
                    break;
                }
                nanos = this.notFull.awaitNanos(nanos);
            } finally {
                reentrantLock.unlock();
            }
        }
        return z;
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.a
    public boolean offerLast(E e2, long j2, TimeUnit timeUnit) throws InterruptedException {
        boolean z;
        e2.getClass();
        e<E> eVar = new e<>(e2);
        long nanos = timeUnit.toNanos(j2);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                if (linkLast(eVar)) {
                    z = true;
                    break;
                }
                if (nanos <= 0) {
                    z = false;
                    break;
                }
                nanos = this.notFull.awaitNanos(nanos);
            } finally {
                reentrantLock.unlock();
            }
        }
        return z;
    }

    public LinkedBlockingDeque(Collection<? extends E> collection) {
        this(Integer.MAX_VALUE);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (E e2 : collection) {
                if (e2 != null) {
                    if (!linkLast(new e<>(e2))) {
                        throw new IllegalStateException("Deque full");
                    }
                } else {
                    throw new NullPointerException();
                }
            }
        } finally {
            reentrantLock.unlock();
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
            int i2 = 0;
            e<E> eVar = this.first;
            while (eVar != null) {
                tArr[i2] = eVar.f15927a;
                eVar = eVar.f15929c;
                i2++;
            }
            if (tArr.length > i2) {
                tArr[i2] = null;
            }
            return tArr;
        } finally {
            reentrantLock.unlock();
        }
    }
}
