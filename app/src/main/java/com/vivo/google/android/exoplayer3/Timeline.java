package com.vivo.google.android.exoplayer3;

/* loaded from: classes4.dex */
public abstract class Timeline {
    public static final Timeline EMPTY = new a();

    public static final class Period {
        public long durationUs;
        public Object id;
        public boolean isAd;
        public long positionInWindowUs;
        public Object uid;
        public int windowIndex;

        public long getDurationMs() {
            return C.usToMs(this.durationUs);
        }

        public long getDurationUs() {
            return this.durationUs;
        }

        public long getPositionInWindowMs() {
            return C.usToMs(this.positionInWindowUs);
        }

        public long getPositionInWindowUs() {
            return this.positionInWindowUs;
        }

        public Period set(Object obj, Object obj2, int i2, long j2, long j3, boolean z) {
            this.id = obj;
            this.uid = obj2;
            this.windowIndex = i2;
            this.durationUs = j2;
            this.positionInWindowUs = j3;
            this.isAd = z;
            return this;
        }
    }

    public static final class Window {
        public long defaultPositionUs;
        public long durationUs;
        public int firstPeriodIndex;
        public Object id;
        public boolean isDynamic;
        public boolean isSeekable;
        public int lastPeriodIndex;
        public long positionInFirstPeriodUs;
        public long presentationStartTimeMs;
        public long windowStartTimeMs;

        public long getDefaultPositionMs() {
            return C.usToMs(this.defaultPositionUs);
        }

        public long getDefaultPositionUs() {
            return this.defaultPositionUs;
        }

        public long getDurationMs() {
            return C.usToMs(this.durationUs);
        }

        public long getDurationUs() {
            return this.durationUs;
        }

        public long getPositionInFirstPeriodMs() {
            return C.usToMs(this.positionInFirstPeriodUs);
        }

        public long getPositionInFirstPeriodUs() {
            return this.positionInFirstPeriodUs;
        }

        public Window set(Object obj, long j2, long j3, boolean z, boolean z2, long j4, long j5, int i2, int i3, long j6) {
            this.id = obj;
            this.presentationStartTimeMs = j2;
            this.windowStartTimeMs = j3;
            this.isSeekable = z;
            this.isDynamic = z2;
            this.defaultPositionUs = j4;
            this.durationUs = j5;
            this.firstPeriodIndex = i2;
            this.lastPeriodIndex = i3;
            this.positionInFirstPeriodUs = j6;
            return this;
        }
    }

    public static class a extends Timeline {
        @Override // com.vivo.google.android.exoplayer3.Timeline
        public int getIndexOfPeriod(Object obj) {
            return -1;
        }

        @Override // com.vivo.google.android.exoplayer3.Timeline
        public Period getPeriod(int i2, Period period, boolean z) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.vivo.google.android.exoplayer3.Timeline
        public int getPeriodCount() {
            return 0;
        }

        @Override // com.vivo.google.android.exoplayer3.Timeline
        public Window getWindow(int i2, Window window, boolean z, long j2) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.vivo.google.android.exoplayer3.Timeline
        public int getWindowCount() {
            return 0;
        }
    }

    public abstract int getIndexOfPeriod(Object obj);

    public final Period getPeriod(int i2, Period period) {
        return getPeriod(i2, period, false);
    }

    public abstract Period getPeriod(int i2, Period period, boolean z);

    public abstract int getPeriodCount();

    public final Window getWindow(int i2, Window window) {
        return getWindow(i2, window, false);
    }

    public Window getWindow(int i2, Window window, boolean z) {
        return getWindow(i2, window, z, 0L);
    }

    public abstract Window getWindow(int i2, Window window, boolean z, long j2);

    public abstract int getWindowCount();

    public final boolean isEmpty() {
        return getWindowCount() == 0;
    }
}
