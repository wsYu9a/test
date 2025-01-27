package com.bumptech.glide.load.engine;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.EngineResource;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
class EngineJob<R> implements DecodeJob.Callback<R>, FactoryPools.Poolable {
    private static final EngineResourceFactory DEFAULT_FACTORY = new EngineResourceFactory();
    private final GlideExecutor animationExecutor;
    final ResourceCallbacksAndExecutors cbs;
    DataSource dataSource;
    private DecodeJob<R> decodeJob;
    private final GlideExecutor diskCacheExecutor;
    private final EngineJobListener engineJobListener;
    EngineResource<?> engineResource;
    private final EngineResourceFactory engineResourceFactory;
    GlideException exception;
    private boolean hasLoadFailed;
    private boolean hasResource;
    private boolean isCacheable;
    private volatile boolean isCancelled;
    private Key key;
    private boolean onlyRetrieveFromCache;
    private final AtomicInteger pendingCallbacks;
    private final Pools.Pool<EngineJob<?>> pool;
    private Resource<?> resource;
    private final EngineResource.ResourceListener resourceListener;
    private final GlideExecutor sourceExecutor;
    private final GlideExecutor sourceUnlimitedExecutor;
    private final StateVerifier stateVerifier;
    private boolean useAnimationPool;
    private boolean useUnlimitedSourceGeneratorPool;

    public class CallLoadFailed implements Runnable {

        /* renamed from: cb */
        private final ResourceCallback f7403cb;

        public CallLoadFailed(ResourceCallback resourceCallback) {
            this.f7403cb = resourceCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f7403cb.getLock()) {
                synchronized (EngineJob.this) {
                    try {
                        if (EngineJob.this.cbs.contains(this.f7403cb)) {
                            EngineJob.this.callCallbackOnLoadFailed(this.f7403cb);
                        }
                        EngineJob.this.decrementPendingCallbacks();
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }
    }

    public class CallResourceReady implements Runnable {

        /* renamed from: cb */
        private final ResourceCallback f7404cb;

        public CallResourceReady(ResourceCallback resourceCallback) {
            this.f7404cb = resourceCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f7404cb.getLock()) {
                synchronized (EngineJob.this) {
                    try {
                        if (EngineJob.this.cbs.contains(this.f7404cb)) {
                            EngineJob.this.engineResource.acquire();
                            EngineJob.this.callCallbackOnResourceReady(this.f7404cb);
                            EngineJob.this.removeCallback(this.f7404cb);
                        }
                        EngineJob.this.decrementPendingCallbacks();
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }
    }

    @VisibleForTesting
    public static class EngineResourceFactory {
        public <R> EngineResource<R> build(Resource<R> resource, boolean z10, Key key, EngineResource.ResourceListener resourceListener) {
            return new EngineResource<>(resource, z10, true, key, resourceListener);
        }
    }

    public static final class ResourceCallbackAndExecutor {

        /* renamed from: cb */
        final ResourceCallback f7405cb;
        final Executor executor;

        public ResourceCallbackAndExecutor(ResourceCallback resourceCallback, Executor executor) {
            this.f7405cb = resourceCallback;
            this.executor = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof ResourceCallbackAndExecutor) {
                return this.f7405cb.equals(((ResourceCallbackAndExecutor) obj).f7405cb);
            }
            return false;
        }

        public int hashCode() {
            return this.f7405cb.hashCode();
        }
    }

    public static final class ResourceCallbacksAndExecutors implements Iterable<ResourceCallbackAndExecutor> {
        private final List<ResourceCallbackAndExecutor> callbacksAndExecutors;

        public ResourceCallbacksAndExecutors() {
            this(new ArrayList(2));
        }

        private static ResourceCallbackAndExecutor defaultCallbackAndExecutor(ResourceCallback resourceCallback) {
            return new ResourceCallbackAndExecutor(resourceCallback, Executors.directExecutor());
        }

        public void add(ResourceCallback resourceCallback, Executor executor) {
            this.callbacksAndExecutors.add(new ResourceCallbackAndExecutor(resourceCallback, executor));
        }

        public void clear() {
            this.callbacksAndExecutors.clear();
        }

        public boolean contains(ResourceCallback resourceCallback) {
            return this.callbacksAndExecutors.contains(defaultCallbackAndExecutor(resourceCallback));
        }

        public ResourceCallbacksAndExecutors copy() {
            return new ResourceCallbacksAndExecutors(new ArrayList(this.callbacksAndExecutors));
        }

        public boolean isEmpty() {
            return this.callbacksAndExecutors.isEmpty();
        }

        @Override // java.lang.Iterable
        @NonNull
        public Iterator<ResourceCallbackAndExecutor> iterator() {
            return this.callbacksAndExecutors.iterator();
        }

        public void remove(ResourceCallback resourceCallback) {
            this.callbacksAndExecutors.remove(defaultCallbackAndExecutor(resourceCallback));
        }

        public int size() {
            return this.callbacksAndExecutors.size();
        }

        public ResourceCallbacksAndExecutors(List<ResourceCallbackAndExecutor> list) {
            this.callbacksAndExecutors = list;
        }
    }

    public EngineJob(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener, EngineResource.ResourceListener resourceListener, Pools.Pool<EngineJob<?>> pool) {
        this(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, engineJobListener, resourceListener, pool, DEFAULT_FACTORY);
    }

    private GlideExecutor getActiveSourceExecutor() {
        return this.useUnlimitedSourceGeneratorPool ? this.sourceUnlimitedExecutor : this.useAnimationPool ? this.animationExecutor : this.sourceExecutor;
    }

    private boolean isDone() {
        return this.hasLoadFailed || this.hasResource || this.isCancelled;
    }

    private synchronized void release() {
        if (this.key == null) {
            throw new IllegalArgumentException();
        }
        this.cbs.clear();
        this.key = null;
        this.engineResource = null;
        this.resource = null;
        this.hasLoadFailed = false;
        this.isCancelled = false;
        this.hasResource = false;
        this.decodeJob.release(false);
        this.decodeJob = null;
        this.exception = null;
        this.dataSource = null;
        this.pool.release(this);
    }

    public synchronized void addCallback(ResourceCallback resourceCallback, Executor executor) {
        try {
            this.stateVerifier.throwIfRecycled();
            this.cbs.add(resourceCallback, executor);
            if (this.hasResource) {
                incrementPendingCallbacks(1);
                executor.execute(new CallResourceReady(resourceCallback));
            } else if (this.hasLoadFailed) {
                incrementPendingCallbacks(1);
                executor.execute(new CallLoadFailed(resourceCallback));
            } else {
                Preconditions.checkArgument(!this.isCancelled, "Cannot add callbacks to a cancelled EngineJob");
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @GuardedBy("this")
    public void callCallbackOnLoadFailed(ResourceCallback resourceCallback) {
        try {
            resourceCallback.onLoadFailed(this.exception);
        } catch (Throwable th2) {
            throw new CallbackException(th2);
        }
    }

    @GuardedBy("this")
    public void callCallbackOnResourceReady(ResourceCallback resourceCallback) {
        try {
            resourceCallback.onResourceReady(this.engineResource, this.dataSource);
        } catch (Throwable th2) {
            throw new CallbackException(th2);
        }
    }

    public void cancel() {
        if (isDone()) {
            return;
        }
        this.isCancelled = true;
        this.decodeJob.cancel();
        this.engineJobListener.onEngineJobCancelled(this, this.key);
    }

    public void decrementPendingCallbacks() {
        EngineResource<?> engineResource;
        synchronized (this) {
            try {
                this.stateVerifier.throwIfRecycled();
                Preconditions.checkArgument(isDone(), "Not yet complete!");
                int decrementAndGet = this.pendingCallbacks.decrementAndGet();
                Preconditions.checkArgument(decrementAndGet >= 0, "Can't decrement below 0");
                if (decrementAndGet == 0) {
                    engineResource = this.engineResource;
                    release();
                } else {
                    engineResource = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (engineResource != null) {
            engineResource.release();
        }
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    @NonNull
    public StateVerifier getVerifier() {
        return this.stateVerifier;
    }

    public synchronized void incrementPendingCallbacks(int i10) {
        EngineResource<?> engineResource;
        Preconditions.checkArgument(isDone(), "Not yet complete!");
        if (this.pendingCallbacks.getAndAdd(i10) == 0 && (engineResource = this.engineResource) != null) {
            engineResource.acquire();
        }
    }

    @VisibleForTesting
    public synchronized EngineJob<R> init(Key key, boolean z10, boolean z11, boolean z12, boolean z13) {
        this.key = key;
        this.isCacheable = z10;
        this.useUnlimitedSourceGeneratorPool = z11;
        this.useAnimationPool = z12;
        this.onlyRetrieveFromCache = z13;
        return this;
    }

    public synchronized boolean isCancelled() {
        return this.isCancelled;
    }

    public void notifyCallbacksOfException() {
        synchronized (this) {
            try {
                this.stateVerifier.throwIfRecycled();
                if (this.isCancelled) {
                    release();
                    return;
                }
                if (this.cbs.isEmpty()) {
                    throw new IllegalStateException("Received an exception without any callbacks to notify");
                }
                if (this.hasLoadFailed) {
                    throw new IllegalStateException("Already failed once");
                }
                this.hasLoadFailed = true;
                Key key = this.key;
                ResourceCallbacksAndExecutors copy = this.cbs.copy();
                incrementPendingCallbacks(copy.size() + 1);
                this.engineJobListener.onEngineJobComplete(this, key, null);
                Iterator<ResourceCallbackAndExecutor> it = copy.iterator();
                while (it.hasNext()) {
                    ResourceCallbackAndExecutor next = it.next();
                    next.executor.execute(new CallLoadFailed(next.f7405cb));
                }
                decrementPendingCallbacks();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void notifyCallbacksOfResult() {
        synchronized (this) {
            try {
                this.stateVerifier.throwIfRecycled();
                if (this.isCancelled) {
                    this.resource.recycle();
                    release();
                    return;
                }
                if (this.cbs.isEmpty()) {
                    throw new IllegalStateException("Received a resource without any callbacks to notify");
                }
                if (this.hasResource) {
                    throw new IllegalStateException("Already have resource");
                }
                this.engineResource = this.engineResourceFactory.build(this.resource, this.isCacheable, this.key, this.resourceListener);
                this.hasResource = true;
                ResourceCallbacksAndExecutors copy = this.cbs.copy();
                incrementPendingCallbacks(copy.size() + 1);
                this.engineJobListener.onEngineJobComplete(this, this.key, this.engineResource);
                Iterator<ResourceCallbackAndExecutor> it = copy.iterator();
                while (it.hasNext()) {
                    ResourceCallbackAndExecutor next = it.next();
                    next.executor.execute(new CallResourceReady(next.f7405cb));
                }
                decrementPendingCallbacks();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.Callback
    public void onLoadFailed(GlideException glideException) {
        synchronized (this) {
            this.exception = glideException;
        }
        notifyCallbacksOfException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.engine.DecodeJob.Callback
    public void onResourceReady(Resource<R> resource, DataSource dataSource) {
        synchronized (this) {
            this.resource = resource;
            this.dataSource = dataSource;
        }
        notifyCallbacksOfResult();
    }

    public boolean onlyRetrieveFromCache() {
        return this.onlyRetrieveFromCache;
    }

    public synchronized void removeCallback(ResourceCallback resourceCallback) {
        try {
            this.stateVerifier.throwIfRecycled();
            this.cbs.remove(resourceCallback);
            if (this.cbs.isEmpty()) {
                cancel();
                if (!this.hasResource) {
                    if (this.hasLoadFailed) {
                    }
                }
                if (this.pendingCallbacks.get() == 0) {
                    release();
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.Callback
    public void reschedule(DecodeJob<?> decodeJob) {
        getActiveSourceExecutor().execute(decodeJob);
    }

    public synchronized void start(DecodeJob<R> decodeJob) {
        try {
            this.decodeJob = decodeJob;
            (decodeJob.willDecodeFromCache() ? this.diskCacheExecutor : getActiveSourceExecutor()).execute(decodeJob);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @VisibleForTesting
    public EngineJob(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener, EngineResource.ResourceListener resourceListener, Pools.Pool<EngineJob<?>> pool, EngineResourceFactory engineResourceFactory) {
        this.cbs = new ResourceCallbacksAndExecutors();
        this.stateVerifier = StateVerifier.newInstance();
        this.pendingCallbacks = new AtomicInteger();
        this.diskCacheExecutor = glideExecutor;
        this.sourceExecutor = glideExecutor2;
        this.sourceUnlimitedExecutor = glideExecutor3;
        this.animationExecutor = glideExecutor4;
        this.engineJobListener = engineJobListener;
        this.resourceListener = resourceListener;
        this.pool = pool;
        this.engineResourceFactory = engineResourceFactory;
    }
}
