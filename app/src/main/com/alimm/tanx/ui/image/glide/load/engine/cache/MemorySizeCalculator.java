package com.alimm.tanx.ui.image.glide.load.engine.cache;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import ok.a;

/* loaded from: classes.dex */
public class MemorySizeCalculator {
    static final int BITMAP_POOL_TARGET_SCREENS = 4;
    static final int BYTES_PER_ARGB_8888_PIXEL = 4;
    static final float LOW_MEMORY_MAX_SIZE_MULTIPLIER = 0.33f;
    static final float MAX_SIZE_MULTIPLIER = 0.4f;
    static final int MEMORY_CACHE_TARGET_SCREENS = 2;
    private static final String TAG = "MemorySizeCalculator";
    private final int bitmapPoolSize;
    private final Context context;
    private final int memoryCacheSize;

    public static class DisplayMetricsScreenDimensions implements ScreenDimensions {
        private final DisplayMetrics displayMetrics;

        public DisplayMetricsScreenDimensions(DisplayMetrics displayMetrics) {
            this.displayMetrics = displayMetrics;
        }

        @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.MemorySizeCalculator.ScreenDimensions
        public int getHeightPixels() {
            return this.displayMetrics.heightPixels;
        }

        @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.MemorySizeCalculator.ScreenDimensions
        public int getWidthPixels() {
            return this.displayMetrics.widthPixels;
        }
    }

    public interface ScreenDimensions {
        int getHeightPixels();

        int getWidthPixels();
    }

    public MemorySizeCalculator(Context context) {
        this(context, (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY), new DisplayMetricsScreenDimensions(context.getResources().getDisplayMetrics()));
    }

    private static int getMaxSize(ActivityManager activityManager) {
        return Math.round(activityManager.getMemoryClass() * 1048576 * (isLowMemoryDevice(activityManager) ? LOW_MEMORY_MAX_SIZE_MULTIPLIER : MAX_SIZE_MULTIPLIER));
    }

    @TargetApi(19)
    private static boolean isLowMemoryDevice(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }

    private String toMb(int i10) {
        return Formatter.formatFileSize(this.context, i10);
    }

    public int getBitmapPoolSize() {
        return this.bitmapPoolSize;
    }

    public int getMemoryCacheSize() {
        return this.memoryCacheSize;
    }

    public MemorySizeCalculator(Context context, ActivityManager activityManager, ScreenDimensions screenDimensions) {
        this.context = context;
        int maxSize = getMaxSize(activityManager);
        int widthPixels = screenDimensions.getWidthPixels() * screenDimensions.getHeightPixels();
        int i10 = widthPixels * 16;
        int i11 = widthPixels * 8;
        int i12 = i11 + i10;
        if (i12 <= maxSize) {
            this.memoryCacheSize = i11;
            this.bitmapPoolSize = i10;
        } else {
            int round = Math.round(maxSize / 6.0f);
            this.memoryCacheSize = round * 2;
            this.bitmapPoolSize = round * 4;
        }
        if (Log.isLoggable(TAG, 3)) {
            StringBuilder a10 = a.a("Calculated memory cache size: ");
            a10.append(toMb(this.memoryCacheSize));
            a10.append(" pool size: ");
            a10.append(toMb(this.bitmapPoolSize));
            a10.append(" memory class limited? ");
            a10.append(i12 > maxSize);
            a10.append(" max size: ");
            a10.append(toMb(maxSize));
            a10.append(" memoryClass: ");
            a10.append(activityManager.getMemoryClass());
            a10.append(" isLowMemoryDevice: ");
            a10.append(isLowMemoryDevice(activityManager));
            Log.d(TAG, a10.toString());
        }
    }
}
