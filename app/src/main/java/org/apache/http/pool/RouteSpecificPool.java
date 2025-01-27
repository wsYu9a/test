package org.apache.http.pool;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.pool.PoolEntry;

@NotThreadSafe
/* loaded from: classes5.dex */
abstract class RouteSpecificPool<T, C, E extends PoolEntry<T, C>> {
    private final T route;
    private final Set<E> leased = new HashSet();
    private final LinkedList<E> available = new LinkedList<>();
    private final LinkedList<PoolEntryFuture<E>> pending = new LinkedList<>();

    RouteSpecificPool(T t) {
        this.route = t;
    }

    public E add(C c2) {
        E createEntry = createEntry(c2);
        this.leased.add(createEntry);
        return createEntry;
    }

    protected abstract E createEntry(C c2);

    public void free(E e2, boolean z) {
        if (e2 == null) {
            throw new IllegalArgumentException("Pool entry may not be null");
        }
        if (this.leased.remove(e2)) {
            if (z) {
                this.available.addFirst(e2);
            }
        } else {
            throw new IllegalStateException("Entry " + e2 + " has not been leased from this pool");
        }
    }

    public int getAllocatedCount() {
        return this.available.size() + this.leased.size();
    }

    public int getAvailableCount() {
        return this.available.size();
    }

    public E getFree(Object obj) {
        if (this.available.isEmpty()) {
            return null;
        }
        if (obj != null) {
            Iterator<E> it = this.available.iterator();
            while (it.hasNext()) {
                E next = it.next();
                if (obj.equals(next.getState())) {
                    it.remove();
                    this.leased.add(next);
                    return next;
                }
            }
        }
        Iterator<E> it2 = this.available.iterator();
        while (it2.hasNext()) {
            E next2 = it2.next();
            if (next2.getState() == null) {
                it2.remove();
                this.leased.add(next2);
                return next2;
            }
        }
        return null;
    }

    public E getLastUsed() {
        if (this.available.isEmpty()) {
            return null;
        }
        return this.available.getLast();
    }

    public int getLeasedCount() {
        return this.leased.size();
    }

    public int getPendingCount() {
        return this.pending.size();
    }

    public final T getRoute() {
        return this.route;
    }

    public PoolEntryFuture<E> nextPending() {
        return this.pending.poll();
    }

    public void queue(PoolEntryFuture<E> poolEntryFuture) {
        if (poolEntryFuture == null) {
            return;
        }
        this.pending.add(poolEntryFuture);
    }

    public boolean remove(E e2) {
        if (e2 != null) {
            return this.available.remove(e2) || this.leased.remove(e2);
        }
        throw new IllegalArgumentException("Pool entry may not be null");
    }

    public void shutdown() {
        Iterator<PoolEntryFuture<E>> it = this.pending.iterator();
        while (it.hasNext()) {
            it.next().cancel(true);
        }
        this.pending.clear();
        Iterator<E> it2 = this.available.iterator();
        while (it2.hasNext()) {
            it2.next().close();
        }
        this.available.clear();
        Iterator<E> it3 = this.leased.iterator();
        while (it3.hasNext()) {
            it3.next().close();
        }
        this.leased.clear();
    }

    public String toString() {
        return "[route: " + this.route + "][leased: " + this.leased.size() + "][available: " + this.available.size() + "][pending: " + this.pending.size() + "]";
    }

    public void unqueue(PoolEntryFuture<E> poolEntryFuture) {
        if (poolEntryFuture == null) {
            return;
        }
        this.pending.remove(poolEntryFuture);
    }
}
