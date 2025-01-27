package com.bumptech.glide.load.resource.bitmap;

import android.os.Build;
import com.bumptech.glide.load.Option;

/* loaded from: classes.dex */
public abstract class DownsampleStrategy {
    public static final DownsampleStrategy CENTER_OUTSIDE;
    public static final DownsampleStrategy DEFAULT;
    static final boolean IS_BITMAP_FACTORY_SCALING_SUPPORTED;
    public static final DownsampleStrategy NONE;
    public static final Option<DownsampleStrategy> OPTION;
    public static final DownsampleStrategy AT_LEAST = new AtLeast();
    public static final DownsampleStrategy AT_MOST = new AtMost();
    public static final DownsampleStrategy FIT_CENTER = new FitCenter();
    public static final DownsampleStrategy CENTER_INSIDE = new CenterInside();

    private static class AtLeast extends DownsampleStrategy {
        AtLeast() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding getSampleSizeRounding(int i2, int i3, int i4, int i5) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float getScaleFactor(int i2, int i3, int i4, int i5) {
            if (Math.min(i3 / i5, i2 / i4) == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(r1);
        }
    }

    private static class AtMost extends DownsampleStrategy {
        AtMost() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding getSampleSizeRounding(int i2, int i3, int i4, int i5) {
            return SampleSizeRounding.MEMORY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float getScaleFactor(int i2, int i3, int i4, int i5) {
            int ceil = (int) Math.ceil(Math.max(i3 / i5, i2 / i4));
            return 1.0f / (r2 << (Math.max(1, Integer.highestOneBit(ceil)) >= ceil ? 0 : 1));
        }
    }

    private static class CenterInside extends DownsampleStrategy {
        CenterInside() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding getSampleSizeRounding(int i2, int i3, int i4, int i5) {
            return getScaleFactor(i2, i3, i4, i5) == 1.0f ? SampleSizeRounding.QUALITY : DownsampleStrategy.FIT_CENTER.getSampleSizeRounding(i2, i3, i4, i5);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float getScaleFactor(int i2, int i3, int i4, int i5) {
            return Math.min(1.0f, DownsampleStrategy.FIT_CENTER.getScaleFactor(i2, i3, i4, i5));
        }
    }

    private static class CenterOutside extends DownsampleStrategy {
        CenterOutside() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding getSampleSizeRounding(int i2, int i3, int i4, int i5) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float getScaleFactor(int i2, int i3, int i4, int i5) {
            return Math.max(i4 / i2, i5 / i3);
        }
    }

    private static class FitCenter extends DownsampleStrategy {
        FitCenter() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding getSampleSizeRounding(int i2, int i3, int i4, int i5) {
            return DownsampleStrategy.IS_BITMAP_FACTORY_SCALING_SUPPORTED ? SampleSizeRounding.QUALITY : SampleSizeRounding.MEMORY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float getScaleFactor(int i2, int i3, int i4, int i5) {
            if (DownsampleStrategy.IS_BITMAP_FACTORY_SCALING_SUPPORTED) {
                return Math.min(i4 / i2, i5 / i3);
            }
            if (Math.max(i3 / i5, i2 / i4) == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(r2);
        }
    }

    private static class None extends DownsampleStrategy {
        None() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding getSampleSizeRounding(int i2, int i3, int i4, int i5) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float getScaleFactor(int i2, int i3, int i4, int i5) {
            return 1.0f;
        }
    }

    public enum SampleSizeRounding {
        MEMORY,
        QUALITY
    }

    static {
        CenterOutside centerOutside = new CenterOutside();
        CENTER_OUTSIDE = centerOutside;
        NONE = new None();
        DEFAULT = centerOutside;
        OPTION = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", centerOutside);
        IS_BITMAP_FACTORY_SCALING_SUPPORTED = Build.VERSION.SDK_INT >= 19;
    }

    public abstract SampleSizeRounding getSampleSizeRounding(int i2, int i3, int i4, int i5);

    public abstract float getScaleFactor(int i2, int i3, int i4, int i5);
}
