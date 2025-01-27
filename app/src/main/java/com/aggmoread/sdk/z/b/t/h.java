package com.aggmoread.sdk.z.b.t;

import android.content.Context;
import android.util.Log;
import android.view.OrientationEventListener;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private Context f5027a;

    /* renamed from: b, reason: collision with root package name */
    private OrientationEventListener f5028b;

    /* renamed from: c, reason: collision with root package name */
    private int f5029c = 20;

    /* renamed from: d, reason: collision with root package name */
    private long f5030d = 0;

    /* renamed from: e, reason: collision with root package name */
    private long f5031e = 0;

    /* renamed from: f, reason: collision with root package name */
    private b f5032f = b.f5036b;

    /* renamed from: g, reason: collision with root package name */
    private int f5033g = 1;

    /* renamed from: h, reason: collision with root package name */
    private c f5034h;

    public class a extends OrientationEventListener {
        public a(Context context, int i10) {
            super(context, i10);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i10) {
            int i11 = 1;
            b a10 = h.this.a(i10);
            if (a10 == null) {
                return;
            }
            if (a10 != h.this.f5032f) {
                h.this.d();
                h.this.f5032f = a10;
                Log.d("OrientationDetector", String.format("方向改变, 开始计时, 当前是方向为%s", a10));
                return;
            }
            h.this.a();
            if (h.this.f5030d > qe.a.f30009d) {
                if (a10 == b.f5038d) {
                    if (h.this.f5033g != 0) {
                        Log.d("OrientationDetector", "switch to SCREEN_ORIENTATION_LANDSCAPE");
                        h.this.f5033g = 0;
                        if (h.this.f5034h != null) {
                            h.this.f5034h.a(0, a10);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (a10 == b.f5036b) {
                    if (h.this.f5033g == 1) {
                        return;
                    }
                    Log.d("OrientationDetector", "switch to SCREEN_ORIENTATION_PORTRAIT");
                    h.this.f5033g = 1;
                    if (h.this.f5034h == null) {
                        return;
                    }
                } else if (a10 == b.f5037c) {
                    i11 = 9;
                    if (h.this.f5033g == 9) {
                        return;
                    }
                    Log.d("OrientationDetector", "switch to SCREEN_ORIENTATION_REVERSE_PORTRAIT");
                    h.this.f5033g = 9;
                    if (h.this.f5034h == null) {
                        return;
                    }
                } else {
                    if (a10 != b.f5039e) {
                        return;
                    }
                    i11 = 8;
                    if (h.this.f5033g == 8) {
                        return;
                    }
                    Log.d("OrientationDetector", "switch to SCREEN_ORIENTATION_REVERSE_LANDSCAPE");
                    h.this.f5033g = 8;
                    if (h.this.f5034h == null) {
                        return;
                    }
                }
                h.this.f5034h.a(i11, a10);
            }
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class b {

        /* renamed from: b, reason: collision with root package name */
        public static final b f5036b = new b("PORTRAIT", 0);

        /* renamed from: c, reason: collision with root package name */
        public static final b f5037c = new b("REVERSE_PORTRAIT", 1);

        /* renamed from: d, reason: collision with root package name */
        public static final b f5038d = new b("LANDSCAPE", 2);

        /* renamed from: e, reason: collision with root package name */
        public static final b f5039e = new b("REVERSE_LANDSCAPE", 3);

        private b(String str, int i10) {
        }
    }

    public interface c {
        void a(int i10, b bVar);
    }

    public h(Context context) {
        this.f5027a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b a(int i10) {
        int i11 = this.f5029c;
        if (i10 <= i11 || i10 >= 360 - i11) {
            return b.f5036b;
        }
        if (Math.abs(i10 - 180) <= this.f5029c) {
            return b.f5037c;
        }
        if (Math.abs(i10 - 90) <= this.f5029c) {
            return b.f5039e;
        }
        if (Math.abs(i10 - 270) <= this.f5029c) {
            return b.f5038d;
        }
        return null;
    }

    public void c() {
        if (this.f5028b == null) {
            this.f5028b = new a(this.f5027a, 2);
        }
        this.f5028b.enable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.f5031e = 0L;
        this.f5030d = 0L;
    }

    public void b() {
        OrientationEventListener orientationEventListener = this.f5028b;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f5031e == 0) {
            this.f5031e = currentTimeMillis;
        }
        this.f5030d += currentTimeMillis - this.f5031e;
        this.f5031e = currentTimeMillis;
    }

    public void a(c cVar) {
        this.f5034h = cVar;
    }
}
