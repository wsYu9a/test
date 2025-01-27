package com.alimm.tanx.ui.image.glide.load.engine.cache;

import com.alimm.tanx.ui.image.glide.load.Key;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
final class DiskCacheWriteLocker {
    private final Map<Key, WriteLock> locks = new HashMap();
    private final WriteLockPool writeLockPool = new WriteLockPool();

    public void acquire(Key key) {
        WriteLock writeLock;
        synchronized (this) {
            try {
                writeLock = this.locks.get(key);
                if (writeLock == null) {
                    writeLock = this.writeLockPool.obtain();
                    this.locks.put(key, writeLock);
                }
                writeLock.interestedThreads++;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        writeLock.lock.lock();
    }

    public void release(Key key) {
        WriteLock writeLock;
        int i10;
        synchronized (this) {
            try {
                writeLock = this.locks.get(key);
                if (writeLock != null && (i10 = writeLock.interestedThreads) > 0) {
                    int i11 = i10 - 1;
                    writeLock.interestedThreads = i11;
                    if (i11 == 0) {
                        WriteLock remove = this.locks.remove(key);
                        if (!remove.equals(writeLock)) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Removed the wrong lock, expected to remove: ");
                            sb2.append(writeLock);
                            sb2.append(", but actually removed: ");
                            sb2.append(remove);
                            sb2.append(", key: ");
                            sb2.append(key);
                            throw new IllegalStateException(sb2.toString());
                        }
                        this.writeLockPool.offer(remove);
                    }
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Cannot release a lock that is not held, key: ");
                sb3.append(key);
                sb3.append(", interestedThreads: ");
                sb3.append(writeLock == null ? 0 : writeLock.interestedThreads);
                throw new IllegalArgumentException(sb3.toString());
            } finally {
            }
        }
        writeLock.lock.unlock();
    }

    public static class WriteLock {
        int interestedThreads;
        final Lock lock;

        private WriteLock() {
            this.lock = new ReentrantLock();
        }

        public /* synthetic */ WriteLock(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static class WriteLockPool {
        private static final int MAX_POOL_SIZE = 10;
        private final Queue<WriteLock> pool;

        private WriteLockPool() {
            this.pool = new ArrayDeque();
        }

        public WriteLock obtain() {
            WriteLock poll;
            synchronized (this.pool) {
                poll = this.pool.poll();
            }
            return poll == null ? new WriteLock() : poll;
        }

        public void offer(WriteLock writeLock) {
            synchronized (this.pool) {
                try {
                    if (this.pool.size() < 10) {
                        this.pool.offer(writeLock);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public /* synthetic */ WriteLockPool(AnonymousClass1 anonymousClass1) {
            this();
        }
    }
}
