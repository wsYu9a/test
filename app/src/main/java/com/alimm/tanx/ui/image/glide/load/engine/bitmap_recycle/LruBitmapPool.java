package com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import ok.a;

/* loaded from: classes.dex */
public class LruBitmapPool implements BitmapPool {
    private static final Bitmap.Config DEFAULT_CONFIG = Bitmap.Config.ARGB_8888;
    private static final String TAG = "LruBitmapPool";
    private final Set<Bitmap.Config> allowedConfigs;
    private int currentSize;
    private int evictions;
    private int hits;
    private final int initialMaxSize;
    private int maxSize;
    private int misses;
    private int puts;
    private final LruPoolStrategy strategy;
    private final BitmapTracker tracker;

    public interface BitmapTracker {
        void add(Bitmap bitmap);

        void remove(Bitmap bitmap);
    }

    public static class NullBitmapTracker implements BitmapTracker {
        private NullBitmapTracker() {
        }

        @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void add(Bitmap bitmap) {
        }

        @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void remove(Bitmap bitmap) {
        }

        public /* synthetic */ NullBitmapTracker(AnonymousClass1 anonymousClass1) {
        }
    }

    public static class ThrowingBitmapTracker implements BitmapTracker {
        private final Set<Bitmap> bitmaps = Collections.synchronizedSet(new HashSet());

        private ThrowingBitmapTracker() {
        }

        @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void add(Bitmap bitmap) {
            if (!this.bitmaps.contains(bitmap)) {
                this.bitmaps.add(bitmap);
                return;
            }
            throw new IllegalStateException("Can't add already added bitmap: " + bitmap + " [" + bitmap.getWidth() + "x" + bitmap.getHeight() + "]");
        }

        @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void remove(Bitmap bitmap) {
            if (!this.bitmaps.contains(bitmap)) {
                throw new IllegalStateException("Cannot remove bitmap not in tracker");
            }
            this.bitmaps.remove(bitmap);
        }
    }

    public LruBitmapPool(int i10, LruPoolStrategy lruPoolStrategy, Set<Bitmap.Config> set) {
        this.initialMaxSize = i10;
        this.maxSize = i10;
        this.strategy = lruPoolStrategy;
        this.allowedConfigs = set;
        this.tracker = new NullBitmapTracker(null);
    }

    private void dump() {
        if (Log.isLoggable(TAG, 2)) {
            dumpUnchecked();
        }
    }

    private void dumpUnchecked() {
        StringBuilder a10 = a.a("Hits=");
        a10.append(this.hits);
        a10.append(", misses=");
        a10.append(this.misses);
        a10.append(", puts=");
        a10.append(this.puts);
        a10.append(", evictions=");
        a10.append(this.evictions);
        a10.append(", currentSize=");
        a10.append(this.currentSize);
        a10.append(", maxSize=");
        a10.append(this.maxSize);
        a10.append("\nStrategy=");
        a10.append(this.strategy);
        Log.v(TAG, a10.toString());
    }

    private void evict() {
        trimToSize(this.maxSize);
    }

    private static Set<Bitmap.Config> getDefaultAllowedConfigs() {
        HashSet hashSet = new HashSet();
        hashSet.addAll(Arrays.asList(Bitmap.Config.values()));
        hashSet.add(null);
        return Collections.unmodifiableSet(hashSet);
    }

    private static LruPoolStrategy getDefaultStrategy() {
        return new SizeConfigStrategy();
    }

    private synchronized void trimToSize(int i10) {
        while (this.currentSize > i10) {
            try {
                Bitmap removeLast = this.strategy.removeLast();
                if (removeLast == null) {
                    if (Log.isLoggable(TAG, 5)) {
                        Log.w(TAG, "Size mismatch, resetting");
                        dumpUnchecked();
                    }
                    this.currentSize = 0;
                    return;
                }
                this.tracker.remove(removeLast);
                this.currentSize -= this.strategy.getSize(removeLast);
                removeLast.recycle();
                this.evictions++;
                if (Log.isLoggable(TAG, 3)) {
                    StringBuilder a10 = a.a("Evicting bitmap=");
                    a10.append(this.strategy.logBitmap(removeLast));
                    Log.d(TAG, a10.toString());
                }
                dump();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool
    public void clearMemory() {
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "clearMemory");
        }
        trimToSize(0);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool
    public synchronized Bitmap get(int i10, int i11, Bitmap.Config config) {
        Bitmap dirty;
        dirty = getDirty(i10, i11, config);
        if (dirty != null) {
            dirty.eraseColor(0);
        }
        return dirty;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool
    @TargetApi(12)
    public synchronized Bitmap getDirty(int i10, int i11, Bitmap.Config config) {
        Bitmap bitmap;
        try {
            bitmap = this.strategy.get(i10, i11, config != null ? config : DEFAULT_CONFIG);
            if (bitmap == null) {
                if (Log.isLoggable(TAG, 3)) {
                    StringBuilder a10 = a.a("Missing bitmap=");
                    a10.append(this.strategy.logBitmap(i10, i11, config));
                    Log.d(TAG, a10.toString());
                }
                this.misses++;
            } else {
                this.hits++;
                this.currentSize -= this.strategy.getSize(bitmap);
                this.tracker.remove(bitmap);
                bitmap.setHasAlpha(true);
            }
            if (Log.isLoggable(TAG, 2)) {
                StringBuilder a11 = a.a("Get bitmap=");
                a11.append(this.strategy.logBitmap(i10, i11, config));
                Log.v(TAG, a11.toString());
            }
            dump();
        } catch (Throwable th2) {
            throw th2;
        }
        return bitmap;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool
    public int getMaxSize() {
        return this.maxSize;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool
    public synchronized boolean put(Bitmap bitmap) {
        try {
            if (bitmap == null) {
                throw new NullPointerException("Bitmap must not be null");
            }
            if (bitmap.isMutable() && this.strategy.getSize(bitmap) <= this.maxSize && this.allowedConfigs.contains(bitmap.getConfig())) {
                int size = this.strategy.getSize(bitmap);
                this.strategy.put(bitmap);
                this.tracker.add(bitmap);
                this.puts++;
                this.currentSize += size;
                if (Log.isLoggable(TAG, 2)) {
                    StringBuilder a10 = a.a("Put bitmap in pool=");
                    a10.append(this.strategy.logBitmap(bitmap));
                    Log.v(TAG, a10.toString());
                }
                dump();
                evict();
                return true;
            }
            if (Log.isLoggable(TAG, 2)) {
                StringBuilder a11 = a.a("Reject bitmap from pool, bitmap: ");
                a11.append(this.strategy.logBitmap(bitmap));
                a11.append(", is mutable: ");
                a11.append(bitmap.isMutable());
                a11.append(", is allowed config: ");
                a11.append(this.allowedConfigs.contains(bitmap.getConfig()));
                Log.v(TAG, a11.toString());
            }
            return false;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool
    public synchronized void setSizeMultiplier(float f10) {
        this.maxSize = Math.round(this.initialMaxSize * f10);
        evict();
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool
    @SuppressLint({"InlinedApi"})
    public void trimMemory(int i10) {
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "trimMemory, level=" + i10);
        }
        if (i10 >= 60) {
            clearMemory();
        } else if (i10 >= 40) {
            trimToSize(this.maxSize / 2);
        }
    }

    public LruBitmapPool(int i10) {
        this(i10, getDefaultStrategy(), getDefaultAllowedConfigs());
    }

    public LruBitmapPool(int i10, Set<Bitmap.Config> set) {
        this(i10, getDefaultStrategy(), set);
    }
}
