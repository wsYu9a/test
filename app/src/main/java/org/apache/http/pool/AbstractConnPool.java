package org.apache.http.pool;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.pool.PoolEntry;

@ThreadSafe
/* loaded from: classes5.dex */
public abstract class AbstractConnPool<T, C, E extends PoolEntry<T, C>> implements ConnPool<T, E>, ConnPoolControl<T> {
    private final LinkedList<E> available;
    private final ConnFactory<T, C> connFactory;
    private volatile int defaultMaxPerRoute;
    private volatile boolean isShutDown;
    private final Set<E> leased;
    private final Lock lock;
    private final Map<T, Integer> maxPerRoute;
    private volatile int maxTotal;
    private final LinkedList<PoolEntryFuture<E>> pending;
    private final Map<T, RouteSpecificPool<T, C, E>> routeToPool;

    /* renamed from: org.apache.http.pool.AbstractConnPool$1 */
    class AnonymousClass1 extends RouteSpecificPool<T, C, E> {
        final /* synthetic */ Object val$route;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Object obj, Object obj2) {
            super(obj);
            t = obj2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.apache.http.pool.RouteSpecificPool
        protected E createEntry(C c2) {
            return (E) AbstractConnPool.this.createEntry(t, c2);
        }
    }

    /* renamed from: org.apache.http.pool.AbstractConnPool$2 */
    class AnonymousClass2 extends PoolEntryFuture<E> {
        final /* synthetic */ Object val$route;
        final /* synthetic */ Object val$state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Lock lock, FutureCallback futureCallback, Object obj, Object obj2) throws TimeoutException, InterruptedException, IOException {
            super(lock, futureCallback);
            t = obj;
            obj = obj2;
        }

        @Override // org.apache.http.pool.PoolEntryFuture
        public E getPoolEntry(long j2, TimeUnit timeUnit) throws InterruptedException, TimeoutException, IOException {
            return (E) AbstractConnPool.this.getPoolEntryBlocking(t, obj, j2, timeUnit, this);
        }
    }

    public AbstractConnPool(ConnFactory<T, C> connFactory, int i2, int i3) {
        if (connFactory == null) {
            throw new IllegalArgumentException("Connection factory may not null");
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("Max per route value may not be negative or zero");
        }
        if (i3 <= 0) {
            throw new IllegalArgumentException("Max total value may not be negative or zero");
        }
        this.lock = new ReentrantLock();
        this.connFactory = connFactory;
        this.routeToPool = new HashMap();
        this.leased = new HashSet();
        this.available = new LinkedList<>();
        this.pending = new LinkedList<>();
        this.maxPerRoute = new HashMap();
        this.defaultMaxPerRoute = i2;
        this.maxTotal = i3;
    }

    private int getMax(T t) {
        Integer num = this.maxPerRoute.get(t);
        return num != null ? num.intValue() : this.defaultMaxPerRoute;
    }

    private RouteSpecificPool<T, C, E> getPool(T t) {
        RouteSpecificPool<T, C, E> routeSpecificPool = this.routeToPool.get(t);
        if (routeSpecificPool != null) {
            return routeSpecificPool;
        }
        AnonymousClass1 anonymousClass1 = new RouteSpecificPool<T, C, E>(t) { // from class: org.apache.http.pool.AbstractConnPool.1
            final /* synthetic */ Object val$route;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(Object t2, Object t22) {
                super(t22);
                t = t22;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // org.apache.http.pool.RouteSpecificPool
            protected E createEntry(C c2) {
                return (E) AbstractConnPool.this.createEntry(t, c2);
            }
        };
        this.routeToPool.put(t22, anonymousClass1);
        return anonymousClass1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public E getPoolEntryBlocking(T t, Object obj, long j2, TimeUnit timeUnit, PoolEntryFuture<E> poolEntryFuture) throws IOException, InterruptedException, TimeoutException {
        E e2 = null;
        Date date = j2 > 0 ? new Date(System.currentTimeMillis() + timeUnit.toMillis(j2)) : null;
        this.lock.lock();
        try {
            RouteSpecificPool pool = getPool(t);
            while (e2 == null) {
                if (this.isShutDown) {
                    throw new IllegalStateException("Connection pool shut down");
                }
                while (true) {
                    e2 = (E) pool.getFree(obj);
                    if (e2 == null) {
                        break;
                    }
                    if (!e2.isClosed() && !e2.isExpired(System.currentTimeMillis())) {
                        break;
                    }
                    e2.close();
                    this.available.remove(e2);
                    pool.free(e2, false);
                }
                if (e2 != null) {
                    this.available.remove(e2);
                    this.leased.add(e2);
                    return e2;
                }
                int max = getMax(t);
                int max2 = Math.max(0, (pool.getAllocatedCount() + 1) - max);
                if (max2 > 0) {
                    for (int i2 = 0; i2 < max2; i2++) {
                        PoolEntry lastUsed = pool.getLastUsed();
                        if (lastUsed == null) {
                            break;
                        }
                        lastUsed.close();
                        this.available.remove(lastUsed);
                        pool.remove(lastUsed);
                    }
                }
                if (pool.getAllocatedCount() < max) {
                    int max3 = Math.max(this.maxTotal - this.leased.size(), 0);
                    if (max3 > 0) {
                        if (this.available.size() > max3 - 1 && !this.available.isEmpty()) {
                            E removeLast = this.available.removeLast();
                            removeLast.close();
                            getPool(removeLast.getRoute()).remove(removeLast);
                        }
                        E e3 = (E) pool.add(this.connFactory.create(t));
                        this.leased.add(e3);
                        return e3;
                    }
                }
                try {
                    pool.queue(poolEntryFuture);
                    this.pending.add(poolEntryFuture);
                    if (!poolEntryFuture.await(date) && date != null && date.getTime() <= System.currentTimeMillis()) {
                        break;
                    }
                } finally {
                    pool.unqueue(poolEntryFuture);
                    this.pending.remove(poolEntryFuture);
                }
            }
            throw new TimeoutException("Timeout waiting for connection");
        } finally {
            this.lock.unlock();
        }
    }

    private void notifyPending(RouteSpecificPool<T, C, E> routeSpecificPool) {
        PoolEntryFuture<E> nextPending = routeSpecificPool.nextPending();
        if (nextPending != null) {
            this.pending.remove(nextPending);
        } else {
            nextPending = this.pending.poll();
        }
        if (nextPending != null) {
            nextPending.wakeup();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void closeExpired() {
        long currentTimeMillis = System.currentTimeMillis();
        this.lock.lock();
        try {
            Iterator<E> it = this.available.iterator();
            while (it.hasNext()) {
                E next = it.next();
                if (next.isExpired(currentTimeMillis)) {
                    next.close();
                    RouteSpecificPool pool = getPool(next.getRoute());
                    pool.remove(next);
                    it.remove();
                    notifyPending(pool);
                }
            }
        } finally {
            this.lock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void closeIdle(long j2, TimeUnit timeUnit) {
        if (timeUnit == null) {
            throw new IllegalArgumentException("Time unit must not be null.");
        }
        long millis = timeUnit.toMillis(j2);
        if (millis < 0) {
            millis = 0;
        }
        long currentTimeMillis = System.currentTimeMillis() - millis;
        this.lock.lock();
        try {
            Iterator<E> it = this.available.iterator();
            while (it.hasNext()) {
                E next = it.next();
                if (next.getUpdated() <= currentTimeMillis) {
                    next.close();
                    RouteSpecificPool pool = getPool(next.getRoute());
                    pool.remove(next);
                    it.remove();
                    notifyPending(pool);
                }
            }
        } finally {
            this.lock.unlock();
        }
    }

    protected abstract E createEntry(T t, C c2);

    @Override // org.apache.http.pool.ConnPoolControl
    public int getDefaultMaxPerRoute() {
        this.lock.lock();
        try {
            return this.defaultMaxPerRoute;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.apache.http.pool.ConnPoolControl
    public int getMaxPerRoute(T t) {
        if (t == null) {
            throw new IllegalArgumentException("Route may not be null");
        }
        this.lock.lock();
        try {
            return getMax(t);
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.apache.http.pool.ConnPoolControl
    public int getMaxTotal() {
        this.lock.lock();
        try {
            return this.maxTotal;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.apache.http.pool.ConnPoolControl
    public PoolStats getStats(T t) {
        if (t == null) {
            throw new IllegalArgumentException("Route may not be null");
        }
        this.lock.lock();
        try {
            RouteSpecificPool<T, C, E> pool = getPool(t);
            return new PoolStats(pool.getLeasedCount(), pool.getPendingCount(), pool.getAvailableCount(), getMax(t));
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.apache.http.pool.ConnPoolControl
    public PoolStats getTotalStats() {
        this.lock.lock();
        try {
            return new PoolStats(this.leased.size(), this.pending.size(), this.available.size(), this.maxTotal);
        } finally {
            this.lock.unlock();
        }
    }

    public boolean isShutdown() {
        return this.isShutDown;
    }

    @Override // org.apache.http.pool.ConnPool
    public Future<E> lease(T t, Object obj, FutureCallback<E> futureCallback) {
        if (t == null) {
            throw new IllegalArgumentException("Route may not be null");
        }
        if (this.isShutDown) {
            throw new IllegalStateException("Connection pool shut down");
        }
        return new PoolEntryFuture<E>(this.lock, futureCallback) { // from class: org.apache.http.pool.AbstractConnPool.2
            final /* synthetic */ Object val$route;
            final /* synthetic */ Object val$state;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(Lock lock, FutureCallback futureCallback2, Object t2, Object obj2) throws TimeoutException, InterruptedException, IOException {
                super(lock, futureCallback2);
                t = t2;
                obj = obj2;
            }

            @Override // org.apache.http.pool.PoolEntryFuture
            public E getPoolEntry(long j2, TimeUnit timeUnit) throws InterruptedException, TimeoutException, IOException {
                return (E) AbstractConnPool.this.getPoolEntryBlocking(t, obj, j2, timeUnit, this);
            }
        };
    }

    @Override // org.apache.http.pool.ConnPoolControl
    public void setDefaultMaxPerRoute(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("Max value may not be negative or zero");
        }
        this.lock.lock();
        try {
            this.defaultMaxPerRoute = i2;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.apache.http.pool.ConnPoolControl
    public void setMaxPerRoute(T t, int i2) {
        if (t == null) {
            throw new IllegalArgumentException("Route may not be null");
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("Max value may not be negative or zero");
        }
        this.lock.lock();
        try {
            this.maxPerRoute.put(t, Integer.valueOf(i2));
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.apache.http.pool.ConnPoolControl
    public void setMaxTotal(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("Max value may not be negative or zero");
        }
        this.lock.lock();
        try {
            this.maxTotal = i2;
        } finally {
            this.lock.unlock();
        }
    }

    public void shutdown() throws IOException {
        if (this.isShutDown) {
            return;
        }
        this.isShutDown = true;
        this.lock.lock();
        try {
            Iterator<E> it = this.available.iterator();
            while (it.hasNext()) {
                it.next().close();
            }
            Iterator<E> it2 = this.leased.iterator();
            while (it2.hasNext()) {
                it2.next().close();
            }
            Iterator<RouteSpecificPool<T, C, E>> it3 = this.routeToPool.values().iterator();
            while (it3.hasNext()) {
                it3.next().shutdown();
            }
            this.routeToPool.clear();
            this.leased.clear();
            this.available.clear();
        } finally {
            this.lock.unlock();
        }
    }

    public String toString() {
        return "[leased: " + this.leased + "][available: " + this.available + "][pending: " + this.pending + "]";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.http.pool.ConnPool
    public void release(E e2, boolean z) {
        this.lock.lock();
        try {
            if (this.leased.remove(e2)) {
                RouteSpecificPool pool = getPool(e2.getRoute());
                pool.free(e2, z);
                if (!z || this.isShutDown) {
                    e2.close();
                } else {
                    this.available.addFirst(e2);
                }
                notifyPending(pool);
            }
        } finally {
            this.lock.unlock();
        }
    }

    public Future<E> lease(T t, Object obj) {
        return lease(t, obj, null);
    }
}
