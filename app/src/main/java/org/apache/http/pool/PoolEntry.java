package org.apache.http.pool;

import java.util.concurrent.TimeUnit;
import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;

@ThreadSafe
/* loaded from: classes5.dex */
public abstract class PoolEntry<T, C> {
    private final C conn;
    private final long created;

    @GuardedBy("this")
    private long expiry;
    private final String id;
    private final T route;
    private volatile Object state;

    @GuardedBy("this")
    private long updated;
    private final long validUnit;

    public PoolEntry(String str, T t, C c2, long j2, TimeUnit timeUnit) {
        if (t == null) {
            throw new IllegalArgumentException("Route may not be null");
        }
        if (c2 == null) {
            throw new IllegalArgumentException("Connection may not be null");
        }
        if (timeUnit == null) {
            throw new IllegalArgumentException("Time unit may not be null");
        }
        this.id = str;
        this.route = t;
        this.conn = c2;
        long currentTimeMillis = System.currentTimeMillis();
        this.created = currentTimeMillis;
        if (j2 > 0) {
            this.validUnit = currentTimeMillis + timeUnit.toMillis(j2);
        } else {
            this.validUnit = Long.MAX_VALUE;
        }
        this.expiry = this.validUnit;
    }

    public abstract void close();

    public C getConnection() {
        return this.conn;
    }

    public long getCreated() {
        return this.created;
    }

    public synchronized long getExpiry() {
        return this.expiry;
    }

    public String getId() {
        return this.id;
    }

    public T getRoute() {
        return this.route;
    }

    public Object getState() {
        return this.state;
    }

    public synchronized long getUpdated() {
        return this.updated;
    }

    public long getValidUnit() {
        return this.validUnit;
    }

    public abstract boolean isClosed();

    public synchronized boolean isExpired(long j2) {
        return j2 >= this.expiry;
    }

    public void setState(Object obj) {
        this.state = obj;
    }

    public String toString() {
        return "[id:" + this.id + "][route:" + this.route + "][state:" + this.state + "]";
    }

    public synchronized void updateExpiry(long j2, TimeUnit timeUnit) {
        if (timeUnit == null) {
            throw new IllegalArgumentException("Time unit may not be null");
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.updated = currentTimeMillis;
        this.expiry = Math.min(j2 > 0 ? currentTimeMillis + timeUnit.toMillis(j2) : Long.MAX_VALUE, this.validUnit);
    }

    public PoolEntry(String str, T t, C c2) {
        this(str, t, c2, 0L, TimeUnit.MILLISECONDS);
    }
}
