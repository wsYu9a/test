package androidx.core.app;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import android.view.FrameMetrics;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import com.vivo.google.android.exoplayer3.C;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class FrameMetricsAggregator {
    public static final int ANIMATION_DURATION = 256;
    public static final int ANIMATION_INDEX = 8;
    public static final int COMMAND_DURATION = 32;
    public static final int COMMAND_INDEX = 5;
    public static final int DELAY_DURATION = 128;
    public static final int DELAY_INDEX = 7;
    public static final int DRAW_DURATION = 8;
    public static final int DRAW_INDEX = 3;
    public static final int EVERY_DURATION = 511;
    public static final int INPUT_DURATION = 2;
    public static final int INPUT_INDEX = 1;
    public static final int LAYOUT_MEASURE_DURATION = 4;
    public static final int LAYOUT_MEASURE_INDEX = 2;
    public static final int SWAP_DURATION = 64;
    public static final int SWAP_INDEX = 6;
    public static final int SYNC_DURATION = 16;
    public static final int SYNC_INDEX = 4;
    public static final int TOTAL_DURATION = 1;
    public static final int TOTAL_INDEX = 0;

    /* renamed from: a, reason: collision with root package name */
    private static final int f1408a = 8;

    /* renamed from: b, reason: collision with root package name */
    private FrameMetricsBaseImpl f1409b;

    @RequiresApi(24)
    private static class FrameMetricsApi24Impl extends FrameMetricsBaseImpl {

        /* renamed from: a, reason: collision with root package name */
        private static final int f1410a = 1000000;

        /* renamed from: b, reason: collision with root package name */
        private static final int f1411b = 500000;

        /* renamed from: c, reason: collision with root package name */
        private static HandlerThread f1412c;

        /* renamed from: d, reason: collision with root package name */
        private static Handler f1413d;

        /* renamed from: e, reason: collision with root package name */
        int f1414e;

        /* renamed from: f, reason: collision with root package name */
        SparseIntArray[] f1415f = new SparseIntArray[9];

        /* renamed from: g, reason: collision with root package name */
        private ArrayList<WeakReference<Activity>> f1416g = new ArrayList<>();

        /* renamed from: h, reason: collision with root package name */
        Window.OnFrameMetricsAvailableListener f1417h = new Window.OnFrameMetricsAvailableListener() { // from class: androidx.core.app.FrameMetricsAggregator.FrameMetricsApi24Impl.1
            @Override // android.view.Window.OnFrameMetricsAvailableListener
            public void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i2) {
                FrameMetricsApi24Impl frameMetricsApi24Impl = FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl.f1414e & 1) != 0) {
                    frameMetricsApi24Impl.a(frameMetricsApi24Impl.f1415f[0], frameMetrics.getMetric(8));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl2 = FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl2.f1414e & 2) != 0) {
                    frameMetricsApi24Impl2.a(frameMetricsApi24Impl2.f1415f[1], frameMetrics.getMetric(1));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl3 = FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl3.f1414e & 4) != 0) {
                    frameMetricsApi24Impl3.a(frameMetricsApi24Impl3.f1415f[2], frameMetrics.getMetric(3));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl4 = FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl4.f1414e & 8) != 0) {
                    frameMetricsApi24Impl4.a(frameMetricsApi24Impl4.f1415f[3], frameMetrics.getMetric(4));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl5 = FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl5.f1414e & 16) != 0) {
                    frameMetricsApi24Impl5.a(frameMetricsApi24Impl5.f1415f[4], frameMetrics.getMetric(5));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl6 = FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl6.f1414e & 64) != 0) {
                    frameMetricsApi24Impl6.a(frameMetricsApi24Impl6.f1415f[6], frameMetrics.getMetric(7));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl7 = FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl7.f1414e & 32) != 0) {
                    frameMetricsApi24Impl7.a(frameMetricsApi24Impl7.f1415f[5], frameMetrics.getMetric(6));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl8 = FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl8.f1414e & 128) != 0) {
                    frameMetricsApi24Impl8.a(frameMetricsApi24Impl8.f1415f[7], frameMetrics.getMetric(0));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl9 = FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl9.f1414e & 256) != 0) {
                    frameMetricsApi24Impl9.a(frameMetricsApi24Impl9.f1415f[8], frameMetrics.getMetric(2));
                }
            }
        };

        FrameMetricsApi24Impl(int i2) {
            this.f1414e = i2;
        }

        void a(SparseIntArray sparseIntArray, long j2) {
            if (sparseIntArray != null) {
                int i2 = (int) ((500000 + j2) / C.MICROS_PER_SECOND);
                if (j2 >= 0) {
                    sparseIntArray.put(i2, sparseIntArray.get(i2) + 1);
                }
            }
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public void add(Activity activity) {
            if (f1412c == null) {
                HandlerThread handlerThread = new HandlerThread("FrameMetricsAggregator");
                f1412c = handlerThread;
                handlerThread.start();
                f1413d = new Handler(f1412c.getLooper());
            }
            for (int i2 = 0; i2 <= 8; i2++) {
                SparseIntArray[] sparseIntArrayArr = this.f1415f;
                if (sparseIntArrayArr[i2] == null && (this.f1414e & (1 << i2)) != 0) {
                    sparseIntArrayArr[i2] = new SparseIntArray();
                }
            }
            activity.getWindow().addOnFrameMetricsAvailableListener(this.f1417h, f1413d);
            this.f1416g.add(new WeakReference<>(activity));
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public SparseIntArray[] getMetrics() {
            return this.f1415f;
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public SparseIntArray[] remove(Activity activity) {
            Iterator<WeakReference<Activity>> it = this.f1416g.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WeakReference<Activity> next = it.next();
                if (next.get() == activity) {
                    this.f1416g.remove(next);
                    break;
                }
            }
            activity.getWindow().removeOnFrameMetricsAvailableListener(this.f1417h);
            return this.f1415f;
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public SparseIntArray[] reset() {
            SparseIntArray[] sparseIntArrayArr = this.f1415f;
            this.f1415f = new SparseIntArray[9];
            return sparseIntArrayArr;
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public SparseIntArray[] stop() {
            for (int size = this.f1416g.size() - 1; size >= 0; size--) {
                WeakReference<Activity> weakReference = this.f1416g.get(size);
                Activity activity = weakReference.get();
                if (weakReference.get() != null) {
                    activity.getWindow().removeOnFrameMetricsAvailableListener(this.f1417h);
                    this.f1416g.remove(size);
                }
            }
            return this.f1415f;
        }
    }

    private static class FrameMetricsBaseImpl {
        FrameMetricsBaseImpl() {
        }

        public void add(Activity activity) {
        }

        public SparseIntArray[] getMetrics() {
            return null;
        }

        public SparseIntArray[] remove(Activity activity) {
            return null;
        }

        public SparseIntArray[] reset() {
            return null;
        }

        public SparseIntArray[] stop() {
            return null;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface MetricType {
    }

    public FrameMetricsAggregator() {
        this(1);
    }

    public void add(@NonNull Activity activity) {
        this.f1409b.add(activity);
    }

    @Nullable
    public SparseIntArray[] getMetrics() {
        return this.f1409b.getMetrics();
    }

    @Nullable
    public SparseIntArray[] remove(@NonNull Activity activity) {
        return this.f1409b.remove(activity);
    }

    @Nullable
    public SparseIntArray[] reset() {
        return this.f1409b.reset();
    }

    @Nullable
    public SparseIntArray[] stop() {
        return this.f1409b.stop();
    }

    public FrameMetricsAggregator(int i2) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f1409b = new FrameMetricsApi24Impl(i2);
        } else {
            this.f1409b = new FrameMetricsBaseImpl();
        }
    }
}
