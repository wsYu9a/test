package com.alimm.tanx.ui.image.glide.load.engine;

import android.util.Log;
import com.alimm.tanx.ui.image.glide.Priority;
import com.alimm.tanx.ui.image.glide.load.engine.executor.Prioritized;
import com.alimm.tanx.ui.image.glide.request.ResourceCallback;

/* loaded from: classes.dex */
class EngineRunnable implements Runnable, Prioritized {
    private static final String TAG = "EngineRunnable";
    private final DecodeJob<?, ?, ?> decodeJob;
    private volatile boolean isCancelled;
    private final EngineRunnableManager manager;
    private final Priority priority;
    private Stage stage = Stage.CACHE;

    public interface EngineRunnableManager extends ResourceCallback {
        void submitForSource(EngineRunnable engineRunnable);
    }

    public enum Stage {
        CACHE,
        SOURCE
    }

    public EngineRunnable(EngineRunnableManager engineRunnableManager, DecodeJob<?, ?, ?> decodeJob, Priority priority) {
        this.manager = engineRunnableManager;
        this.decodeJob = decodeJob;
        this.priority = priority;
    }

    private Resource<?> decode() throws Exception {
        return isDecodingFromCache() ? decodeFromCache() : decodeFromSource();
    }

    private Resource<?> decodeFromCache() throws Exception {
        Resource<?> resource;
        try {
            resource = this.decodeJob.decodeResultFromCache();
        } catch (Exception e10) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Exception decoding result from cache: " + e10);
            }
            resource = null;
        }
        return resource == null ? this.decodeJob.decodeSourceFromCache() : resource;
    }

    private Resource<?> decodeFromSource() throws Exception {
        return this.decodeJob.decodeFromSource();
    }

    private boolean isDecodingFromCache() {
        return this.stage == Stage.CACHE;
    }

    private void onLoadComplete(Resource resource) {
        this.manager.onResourceReady(resource);
    }

    private void onLoadFailed(Exception exc) {
        if (!isDecodingFromCache()) {
            this.manager.onException(exc);
        } else {
            this.stage = Stage.SOURCE;
            this.manager.submitForSource(this);
        }
    }

    public void cancel() {
        this.isCancelled = true;
        this.decodeJob.cancel();
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.executor.Prioritized
    public int getPriority() {
        return this.priority.ordinal();
    }

    @Override // java.lang.Runnable
    public void run() {
        Exception errorWrappingGlideException;
        if (this.isCancelled) {
            return;
        }
        Resource<?> resource = null;
        try {
            resource = decode();
            errorWrappingGlideException = null;
        } catch (Exception e10) {
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Exception decoding", e10);
            }
            errorWrappingGlideException = e10;
        } catch (OutOfMemoryError e11) {
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Out Of Memory Error decoding", e11);
            }
            errorWrappingGlideException = new ErrorWrappingGlideException(e11);
        }
        if (this.isCancelled) {
            if (resource != null) {
                resource.recycle();
            }
        } else if (resource == null) {
            onLoadFailed(errorWrappingGlideException);
        } else {
            this.manager.onResourceReady(resource);
        }
    }
}
