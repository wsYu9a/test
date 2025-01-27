package com.vivo.google.android.exoplayer3;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.WindowManager;

@TargetApi(16)
/* loaded from: classes4.dex */
public final class z6 {

    /* renamed from: a */
    public final a f28326a;

    /* renamed from: b */
    public final boolean f28327b;

    /* renamed from: c */
    public final long f28328c;

    /* renamed from: d */
    public final long f28329d;

    /* renamed from: e */
    public long f28330e;

    /* renamed from: f */
    public long f28331f;

    /* renamed from: g */
    public long f28332g;

    /* renamed from: h */
    public boolean f28333h;

    /* renamed from: i */
    public long f28334i;

    /* renamed from: j */
    public long f28335j;
    public long k;

    public static final class a implements Choreographer.FrameCallback, Handler.Callback {

        /* renamed from: f */
        public static final a f28336f = new a();

        /* renamed from: a */
        public volatile long f28337a;

        /* renamed from: b */
        public final Handler f28338b;

        /* renamed from: c */
        public final HandlerThread f28339c;

        /* renamed from: d */
        public Choreographer f28340d;

        /* renamed from: e */
        public int f28341e;

        public a() {
            HandlerThread handlerThread = new HandlerThread("ChoreographerOwner:Handler");
            this.f28339c = handlerThread;
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper(), this);
            this.f28338b = handler;
            handler.sendEmptyMessage(0);
        }

        public static a a() {
            return f28336f;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j2) {
            this.f28337a = j2;
            this.f28340d.postFrameCallbackDelayed(this, 500L);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                this.f28340d = Choreographer.getInstance();
                return true;
            }
            if (i2 == 1) {
                int i3 = this.f28341e + 1;
                this.f28341e = i3;
                if (i3 == 1) {
                    this.f28340d.postFrameCallback(this);
                }
                return true;
            }
            if (i2 != 2) {
                return false;
            }
            int i4 = this.f28341e - 1;
            this.f28341e = i4;
            if (i4 == 0) {
                this.f28340d.removeFrameCallback(this);
                this.f28337a = 0L;
            }
            return true;
        }
    }

    public z6(double d2, boolean z) {
        long j2;
        this.f28327b = z;
        if (z) {
            this.f28326a = a.a();
            long j3 = (long) (1.0E9d / d2);
            this.f28328c = j3;
            j2 = (j3 * 80) / 100;
        } else {
            this.f28326a = null;
            j2 = -1;
            this.f28328c = -1L;
        }
        this.f28329d = j2;
    }

    public z6(Context context) {
        this(a(context), true);
    }

    public static float a(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRefreshRate();
    }

    public final boolean a(long j2, long j3) {
        return Math.abs((j3 - this.f28334i) - (j2 - this.f28335j)) > 20000000;
    }
}
