package com.opos.exoplayer.core.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.opos.exoplayer.core.i.u;
import com.vivo.google.android.exoplayer3.C;

@TargetApi(16)
/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a */
    private final WindowManager f19239a;

    /* renamed from: b */
    private final b f19240b;

    /* renamed from: c */
    private final a f19241c;

    /* renamed from: d */
    private long f19242d;

    /* renamed from: e */
    private long f19243e;

    /* renamed from: f */
    private long f19244f;

    /* renamed from: g */
    private long f19245g;

    /* renamed from: h */
    private long f19246h;

    /* renamed from: i */
    private boolean f19247i;

    /* renamed from: j */
    private long f19248j;
    private long k;
    private long l;

    @TargetApi(17)
    private final class a implements DisplayManager.DisplayListener {

        /* renamed from: b */
        private final DisplayManager f19250b;

        public a(DisplayManager displayManager) {
            this.f19250b = displayManager;
        }

        public void a() {
            this.f19250b.registerDisplayListener(this, null);
        }

        public void b() {
            this.f19250b.unregisterDisplayListener(this);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i2) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i2) {
            if (i2 == 0) {
                d.this.c();
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i2) {
        }
    }

    private static final class b implements Handler.Callback, Choreographer.FrameCallback {

        /* renamed from: b */
        private static final b f19251b = new b();

        /* renamed from: a */
        public volatile long f19252a = C.TIME_UNSET;

        /* renamed from: c */
        private final Handler f19253c;

        /* renamed from: d */
        private final HandlerThread f19254d;

        /* renamed from: e */
        private Choreographer f19255e;

        /* renamed from: f */
        private int f19256f;

        private b() {
            HandlerThread handlerThread = new HandlerThread("ChoreographerOwner:Handler");
            this.f19254d = handlerThread;
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper(), this);
            this.f19253c = handler;
            handler.sendEmptyMessage(0);
        }

        public static b a() {
            return f19251b;
        }

        private void d() {
            this.f19255e = Choreographer.getInstance();
        }

        private void e() {
            int i2 = this.f19256f + 1;
            this.f19256f = i2;
            if (i2 == 1) {
                this.f19255e.postFrameCallback(this);
            }
        }

        private void f() {
            int i2 = this.f19256f - 1;
            this.f19256f = i2;
            if (i2 == 0) {
                this.f19255e.removeFrameCallback(this);
                this.f19252a = C.TIME_UNSET;
            }
        }

        public void b() {
            this.f19253c.sendEmptyMessage(1);
        }

        public void c() {
            this.f19253c.sendEmptyMessage(2);
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j2) {
            this.f19252a = j2;
            this.f19255e.postFrameCallbackDelayed(this, 500L);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                d();
                return true;
            }
            if (i2 == 1) {
                e();
                return true;
            }
            if (i2 != 2) {
                return false;
            }
            f();
            return true;
        }
    }

    public d() {
        this(null);
    }

    public d(@Nullable Context context) {
        WindowManager windowManager = context == null ? null : (WindowManager) context.getSystemService("window");
        this.f19239a = windowManager;
        if (windowManager != null) {
            this.f19241c = u.f19078a >= 17 ? a(context) : null;
            this.f19240b = b.a();
        } else {
            this.f19241c = null;
            this.f19240b = null;
        }
        this.f19242d = C.TIME_UNSET;
        this.f19243e = C.TIME_UNSET;
    }

    private static long a(long j2, long j3, long j4) {
        long j5;
        long j6 = j3 + (((j2 - j3) / j4) * j4);
        if (j2 <= j6) {
            j5 = j6 - j4;
        } else {
            j6 = j4 + j6;
            j5 = j6;
        }
        return j6 - j2 < j2 - j5 ? j6 : j5;
    }

    @TargetApi(17)
    private a a(Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        if (displayManager == null) {
            return null;
        }
        return new a(displayManager);
    }

    private boolean b(long j2, long j3) {
        return Math.abs((j3 - this.f19248j) - (j2 - this.k)) > 20000000;
    }

    public void c() {
        Display defaultDisplay = this.f19239a.getDefaultDisplay();
        if (defaultDisplay != null) {
            double refreshRate = defaultDisplay.getRefreshRate();
            Double.isNaN(refreshRate);
            long j2 = (long) (1.0E9d / refreshRate);
            this.f19242d = j2;
            this.f19243e = (j2 * 80) / 100;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x003e, code lost:
    
        if (b(r0, r13) != false) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long a(long r11, long r13) {
        /*
            r10 = this;
            r0 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r11
            boolean r2 = r10.f19247i
            if (r2 == 0) goto L41
            long r2 = r10.f19244f
            int r4 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r4 == 0) goto L19
            long r2 = r10.l
            r4 = 1
            long r2 = r2 + r4
            r10.l = r2
            long r2 = r10.f19246h
            r10.f19245g = r2
        L19:
            long r2 = r10.l
            r4 = 6
            r6 = 0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 < 0) goto L3a
            long r4 = r10.k
            long r4 = r0 - r4
            long r4 = r4 / r2
            long r2 = r10.f19245g
            long r2 = r2 + r4
            boolean r4 = r10.b(r2, r13)
            if (r4 == 0) goto L33
        L30:
            r10.f19247i = r6
            goto L41
        L33:
            long r4 = r10.f19248j
            long r4 = r4 + r2
            long r6 = r10.k
            long r4 = r4 - r6
            goto L43
        L3a:
            boolean r2 = r10.b(r0, r13)
            if (r2 == 0) goto L41
            goto L30
        L41:
            r4 = r13
            r2 = r0
        L43:
            boolean r6 = r10.f19247i
            if (r6 != 0) goto L52
            r10.k = r0
            r10.f19248j = r13
            r13 = 0
            r10.l = r13
            r13 = 1
            r10.f19247i = r13
        L52:
            r10.f19244f = r11
            r10.f19246h = r2
            com.opos.exoplayer.core.video.d$b r11 = r10.f19240b
            if (r11 == 0) goto L76
            long r12 = r10.f19242d
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r14 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r14 != 0) goto L66
            goto L76
        L66:
            long r6 = r11.f19252a
            int r11 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r11 == 0) goto L76
            long r8 = r10.f19242d
            long r11 = a(r4, r6, r8)
            long r13 = r10.f19243e
            long r4 = r11 - r13
        L76:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.video.d.a(long, long):long");
    }

    public void a() {
        this.f19247i = false;
        if (this.f19239a != null) {
            this.f19240b.b();
            a aVar = this.f19241c;
            if (aVar != null) {
                aVar.a();
            }
            c();
        }
    }

    public void b() {
        if (this.f19239a != null) {
            a aVar = this.f19241c;
            if (aVar != null) {
                aVar.b();
            }
            this.f19240b.c();
        }
    }
}
