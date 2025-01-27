package androidx.core.view;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* loaded from: classes.dex */
public final class GestureDetectorCompat {

    /* renamed from: a, reason: collision with root package name */
    private final GestureDetectorCompatImpl f2023a;

    interface GestureDetectorCompatImpl {
        boolean isLongpressEnabled();

        boolean onTouchEvent(MotionEvent motionEvent);

        void setIsLongpressEnabled(boolean z);

        void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener);
    }

    static class GestureDetectorCompatImplBase implements GestureDetectorCompatImpl {

        /* renamed from: a, reason: collision with root package name */
        private static final int f2024a = ViewConfiguration.getLongPressTimeout();

        /* renamed from: b, reason: collision with root package name */
        private static final int f2025b = ViewConfiguration.getTapTimeout();

        /* renamed from: c, reason: collision with root package name */
        private static final int f2026c = ViewConfiguration.getDoubleTapTimeout();

        /* renamed from: d, reason: collision with root package name */
        private static final int f2027d = 1;

        /* renamed from: e, reason: collision with root package name */
        private static final int f2028e = 2;

        /* renamed from: f, reason: collision with root package name */
        private static final int f2029f = 3;
        private VelocityTracker A;

        /* renamed from: g, reason: collision with root package name */
        private int f2030g;

        /* renamed from: h, reason: collision with root package name */
        private int f2031h;

        /* renamed from: i, reason: collision with root package name */
        private int f2032i;

        /* renamed from: j, reason: collision with root package name */
        private int f2033j;
        private final Handler k;
        final GestureDetector.OnGestureListener l;
        GestureDetector.OnDoubleTapListener m;
        boolean n;
        boolean o;
        private boolean p;
        private boolean q;
        private boolean r;
        MotionEvent s;
        private MotionEvent t;
        private boolean u;
        private float v;
        private float w;
        private float x;
        private float y;
        private boolean z;

        GestureDetectorCompatImplBase(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            if (handler != null) {
                this.k = new GestureHandler(handler);
            } else {
                this.k = new GestureHandler();
            }
            this.l = onGestureListener;
            if (onGestureListener instanceof GestureDetector.OnDoubleTapListener) {
                setOnDoubleTapListener((GestureDetector.OnDoubleTapListener) onGestureListener);
            }
            d(context);
        }

        private void a() {
            this.k.removeMessages(1);
            this.k.removeMessages(2);
            this.k.removeMessages(3);
            this.A.recycle();
            this.A = null;
            this.u = false;
            this.n = false;
            this.q = false;
            this.r = false;
            this.o = false;
            if (this.p) {
                this.p = false;
            }
        }

        private void b() {
            this.k.removeMessages(1);
            this.k.removeMessages(2);
            this.k.removeMessages(3);
            this.u = false;
            this.q = false;
            this.r = false;
            this.o = false;
            if (this.p) {
                this.p = false;
            }
        }

        private void d(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null");
            }
            if (this.l == null) {
                throw new IllegalArgumentException("OnGestureListener must not be null");
            }
            this.z = true;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
            int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
            this.f2032i = viewConfiguration.getScaledMinimumFlingVelocity();
            this.f2033j = viewConfiguration.getScaledMaximumFlingVelocity();
            this.f2030g = scaledTouchSlop * scaledTouchSlop;
            this.f2031h = scaledDoubleTapSlop * scaledDoubleTapSlop;
        }

        private boolean e(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
            if (!this.r || motionEvent3.getEventTime() - motionEvent2.getEventTime() > f2026c) {
                return false;
            }
            int x = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
            int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
            return (x * x) + (y * y) < this.f2031h;
        }

        void c() {
            this.k.removeMessages(3);
            this.o = false;
            this.p = true;
            this.l.onLongPress(this.s);
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public boolean isLongpressEnabled() {
            return this.z;
        }

        /* JADX WARN: Removed duplicated region for block: B:114:0x0208  */
        /* JADX WARN: Removed duplicated region for block: B:117:0x021f  */
        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onTouchEvent(android.view.MotionEvent r13) {
            /*
                Method dump skipped, instructions count: 591
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImplBase.onTouchEvent(android.view.MotionEvent):boolean");
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public void setIsLongpressEnabled(boolean z) {
            this.z = z;
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.m = onDoubleTapListener;
        }

        private class GestureHandler extends Handler {
            GestureHandler() {
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i2 = message.what;
                if (i2 == 1) {
                    GestureDetectorCompatImplBase gestureDetectorCompatImplBase = GestureDetectorCompatImplBase.this;
                    gestureDetectorCompatImplBase.l.onShowPress(gestureDetectorCompatImplBase.s);
                    return;
                }
                if (i2 == 2) {
                    GestureDetectorCompatImplBase.this.c();
                    return;
                }
                if (i2 != 3) {
                    throw new RuntimeException("Unknown message " + message);
                }
                GestureDetectorCompatImplBase gestureDetectorCompatImplBase2 = GestureDetectorCompatImplBase.this;
                GestureDetector.OnDoubleTapListener onDoubleTapListener = gestureDetectorCompatImplBase2.m;
                if (onDoubleTapListener != null) {
                    if (gestureDetectorCompatImplBase2.n) {
                        gestureDetectorCompatImplBase2.o = true;
                    } else {
                        onDoubleTapListener.onSingleTapConfirmed(gestureDetectorCompatImplBase2.s);
                    }
                }
            }

            GestureHandler(Handler handler) {
                super(handler.getLooper());
            }
        }
    }

    static class GestureDetectorCompatImplJellybeanMr2 implements GestureDetectorCompatImpl {

        /* renamed from: a, reason: collision with root package name */
        private final GestureDetector f2035a;

        GestureDetectorCompatImplJellybeanMr2(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.f2035a = new GestureDetector(context, onGestureListener, handler);
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public boolean isLongpressEnabled() {
            return this.f2035a.isLongpressEnabled();
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return this.f2035a.onTouchEvent(motionEvent);
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public void setIsLongpressEnabled(boolean z) {
            this.f2035a.setIsLongpressEnabled(z);
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.f2035a.setOnDoubleTapListener(onDoubleTapListener);
        }
    }

    public GestureDetectorCompat(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public boolean isLongpressEnabled() {
        return this.f2023a.isLongpressEnabled();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f2023a.onTouchEvent(motionEvent);
    }

    public void setIsLongpressEnabled(boolean z) {
        this.f2023a.setIsLongpressEnabled(z);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f2023a.setOnDoubleTapListener(onDoubleTapListener);
    }

    public GestureDetectorCompat(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        if (Build.VERSION.SDK_INT > 17) {
            this.f2023a = new GestureDetectorCompatImplJellybeanMr2(context, onGestureListener, handler);
        } else {
            this.f2023a = new GestureDetectorCompatImplBase(context, onGestureListener, handler);
        }
    }
}
