package com.martian.ttbook.b.a.p;

import android.content.Context;
import android.util.Log;
import android.view.OrientationEventListener;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: a */
    private Context f15131a;

    /* renamed from: b */
    private OrientationEventListener f15132b;

    /* renamed from: c */
    private int f15133c = 20;

    /* renamed from: d */
    private long f15134d = 0;

    /* renamed from: e */
    private long f15135e = 0;

    /* renamed from: f */
    private b f15136f = b.f15140b;

    /* renamed from: g */
    private int f15137g = 1;

    /* renamed from: h */
    private c f15138h;

    class a extends OrientationEventListener {
        a(Context context, int i2) {
            super(context, i2);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i2) {
            b a2 = e.this.a(i2);
            if (a2 == null) {
                return;
            }
            int i3 = 0;
            if (a2 != e.this.f15136f) {
                e.this.m();
                e.this.f15136f = a2;
                Log.d("OrientationDetector", String.format("方向改变, 开始计时, 当前是方向为%s", a2));
                return;
            }
            e.this.e();
            if (e.this.f15134d > 1500) {
                if (a2 == b.f15142d) {
                    if (e.this.f15137g == 0) {
                        return;
                    }
                    Log.d("OrientationDetector", "switch to SCREEN_ORIENTATION_LANDSCAPE");
                    e.this.f15137g = 0;
                    if (e.this.f15138h == null) {
                        return;
                    }
                } else {
                    if (a2 == b.f15140b) {
                        if (e.this.f15137g != 1) {
                            Log.d("OrientationDetector", "switch to SCREEN_ORIENTATION_PORTRAIT");
                            e.this.f15137g = 1;
                            if (e.this.f15138h != null) {
                                e.this.f15138h.a(1, a2);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    if (a2 == b.f15141c) {
                        i3 = 9;
                        if (e.this.f15137g == 9) {
                            return;
                        }
                        Log.d("OrientationDetector", "switch to SCREEN_ORIENTATION_REVERSE_PORTRAIT");
                        e.this.f15137g = 9;
                        if (e.this.f15138h == null) {
                            return;
                        }
                    } else {
                        if (a2 != b.f15143e) {
                            return;
                        }
                        i3 = 8;
                        if (e.this.f15137g == 8) {
                            return;
                        }
                        Log.d("OrientationDetector", "switch to SCREEN_ORIENTATION_REVERSE_LANDSCAPE");
                        e.this.f15137g = 8;
                        if (e.this.f15138h == null) {
                            return;
                        }
                    }
                }
                e.this.f15138h.a(i3, a2);
            }
        }
    }

    public static final class b extends Enum<b> {

        /* renamed from: b */
        public static final b f15140b = new b("PORTRAIT", 0);

        /* renamed from: c */
        public static final b f15141c = new b("REVERSE_PORTRAIT", 1);

        /* renamed from: d */
        public static final b f15142d = new b("LANDSCAPE", 2);

        /* renamed from: e */
        public static final b f15143e = new b("REVERSE_LANDSCAPE", 3);

        private b(String str, int i2) {
            super(str, i2);
        }
    }

    public interface c {
        void a(int i2, b bVar);
    }

    public e(Context context) {
        this.f15131a = context;
    }

    public b a(int i2) {
        int i3 = this.f15133c;
        if (i2 <= i3 || i2 >= 360 - i3) {
            return b.f15140b;
        }
        if (Math.abs(i2 - 180) <= this.f15133c) {
            return b.f15141c;
        }
        if (Math.abs(i2 - 90) <= this.f15133c) {
            return b.f15143e;
        }
        if (Math.abs(i2 - 270) <= this.f15133c) {
            return b.f15142d;
        }
        return null;
    }

    public void e() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f15135e == 0) {
            this.f15135e = currentTimeMillis;
        }
        this.f15134d += currentTimeMillis - this.f15135e;
        this.f15135e = currentTimeMillis;
    }

    public void m() {
        this.f15135e = 0L;
        this.f15134d = 0L;
    }

    public void f(c cVar) {
        this.f15138h = cVar;
    }

    public void h() {
        OrientationEventListener orientationEventListener = this.f15132b;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }

    public void j() {
        if (this.f15132b == null) {
            this.f15132b = new a(this.f15131a, 2);
        }
        this.f15132b.enable();
    }
}
