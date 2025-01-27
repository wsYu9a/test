package com.opos.exoplayer.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.opos.exoplayer.core.k;
import com.opos.exoplayer.core.q;
import com.opos.exoplayer.core.y;
import com.vivo.google.android.exoplayer3.C;
import com.vivo.ic.dm.Constants;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Locale;

/* loaded from: classes4.dex */
public class b extends FrameLayout {

    /* renamed from: a */
    private final ViewOnClickListenerC0397b f17449a;

    /* renamed from: b */
    private final StringBuilder f17450b;

    /* renamed from: c */
    private final Formatter f17451c;

    /* renamed from: d */
    private final y.a f17452d;

    /* renamed from: e */
    private final y.b f17453e;

    /* renamed from: f */
    private q f17454f;

    /* renamed from: g */
    private com.opos.exoplayer.core.c f17455g;

    /* renamed from: h */
    private a f17456h;

    /* renamed from: i */
    private boolean f17457i;

    /* renamed from: j */
    private boolean f17458j;
    private boolean k;
    private int l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private long q;
    private long[] r;
    private boolean[] s;
    private long[] t;
    private boolean[] u;
    private final Runnable v;
    private final Runnable w;

    /* renamed from: com.opos.exoplayer.a.b$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.l();
        }
    }

    /* renamed from: com.opos.exoplayer.a.b$2 */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.c();
        }
    }

    public interface a {
        void a(int i2);
    }

    /* renamed from: com.opos.exoplayer.a.b$b */
    private final class ViewOnClickListenerC0397b extends q.a implements View.OnClickListener {
        private ViewOnClickListenerC0397b() {
        }

        /* synthetic */ ViewOnClickListenerC0397b(b bVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.opos.exoplayer.core.q.a, com.opos.exoplayer.core.q.b
        public void a(int i2) {
            b.this.i();
            b.this.h();
        }

        @Override // com.opos.exoplayer.core.q.a, com.opos.exoplayer.core.q.b
        public void a(y yVar, Object obj, int i2) {
            b.this.h();
            b.this.k();
            b.this.l();
        }

        @Override // com.opos.exoplayer.core.q.a, com.opos.exoplayer.core.q.b
        public void a(boolean z, int i2) {
            b.this.g();
            b.this.l();
        }

        @Override // com.opos.exoplayer.core.q.a, com.opos.exoplayer.core.q.b
        public void b(int i2) {
            b.this.h();
            b.this.l();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            q unused = b.this.f17454f;
            b.this.e();
        }
    }

    static {
        k.a("goog.exo.ui");
    }

    public b(Context context, AttributeSet attributeSet, int i2, AttributeSet attributeSet2) {
        super(context, attributeSet, i2);
        this.v = new Runnable() { // from class: com.opos.exoplayer.a.b.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.l();
            }
        };
        this.w = new Runnable() { // from class: com.opos.exoplayer.a.b.2
            AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.c();
            }
        };
        this.l = 5000;
        this.m = Constants.DEFAULT_READ_TIMEOUT;
        this.n = 5000;
        this.o = 0;
        this.q = C.TIME_UNSET;
        this.p = false;
        this.f17452d = new y.a();
        this.f17453e = new y.b();
        StringBuilder sb = new StringBuilder();
        this.f17450b = sb;
        this.f17451c = new Formatter(sb, Locale.getDefault());
        this.r = new long[0];
        this.s = new boolean[0];
        this.t = new long[0];
        this.u = new boolean[0];
        this.f17449a = new ViewOnClickListenerC0397b();
        this.f17455g = new com.opos.exoplayer.core.d();
        setDescendantFocusability(262144);
    }

    private void a(int i2, long j2) {
        if (this.f17455g.a(this.f17454f, i2, j2)) {
            return;
        }
        l();
    }

    private void a(long j2) {
        a(this.f17454f.i(), j2);
    }

    private static boolean a(y yVar, y.b bVar) {
        if (yVar.b() > 100) {
            return false;
        }
        int b2 = yVar.b();
        for (int i2 = 0; i2 < b2; i2++) {
            if (yVar.a(i2, bVar).f19312i == C.TIME_UNSET) {
                return false;
            }
        }
        return true;
    }

    @SuppressLint({"InlinedApi"})
    private static boolean b(int i2) {
        return i2 == 90 || i2 == 89 || i2 == 85 || i2 == 126 || i2 == 127 || i2 == 87 || i2 == 88;
    }

    public void e() {
        removeCallbacks(this.w);
        if (this.n <= 0) {
            this.q = C.TIME_UNSET;
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        int i2 = this.n;
        this.q = uptimeMillis + i2;
        if (this.f17457i) {
            postDelayed(this.w, i2);
        }
    }

    private void f() {
        g();
        h();
        i();
        j();
        l();
    }

    public void g() {
        if (d() && this.f17457i) {
            r();
        }
    }

    public void h() {
        if (d() && this.f17457i) {
            q qVar = this.f17454f;
            y h2 = qVar != null ? qVar.h() : null;
            if (!((h2 == null || h2.a()) ? false : true) || this.f17454f.o()) {
                return;
            }
            h2.a(this.f17454f.i(), this.f17453e);
            y.b bVar = this.f17453e;
            if (!bVar.f19307d && bVar.f19308e) {
                this.f17454f.k();
            }
            if (this.f17453e.f19308e) {
                return;
            }
            this.f17454f.j();
        }
    }

    public void i() {
    }

    private void j() {
    }

    public void k() {
        q qVar = this.f17454f;
        if (qVar == null) {
            return;
        }
        this.k = this.f17458j && a(qVar.h(), this.f17453e);
    }

    public void l() {
        long j2;
        long j3;
        long j4;
        long m;
        long j5;
        int i2;
        y.b bVar;
        int i3;
        if (d() && this.f17457i) {
            q qVar = this.f17454f;
            long j6 = 0;
            boolean z = true;
            if (qVar != null) {
                y h2 = qVar.h();
                if (h2.a()) {
                    j3 = 0;
                    j4 = 0;
                } else {
                    int i4 = this.f17454f.i();
                    boolean z2 = this.k;
                    int i5 = z2 ? 0 : i4;
                    if (z2) {
                        i2 = h2.b() - 1;
                        j4 = 0;
                        j5 = 0;
                    } else {
                        j4 = 0;
                        j5 = 0;
                        i2 = i4;
                    }
                    int i6 = 0;
                    while (true) {
                        if (i5 > i2) {
                            break;
                        }
                        if (i5 == i4) {
                            j4 = j5;
                        }
                        h2.a(i5, this.f17453e);
                        y.b bVar2 = this.f17453e;
                        int i7 = i5;
                        if (bVar2.f19312i == C.TIME_UNSET) {
                            com.opos.exoplayer.core.i.a.b(this.k ^ z);
                            break;
                        }
                        int i8 = bVar2.f19309f;
                        while (true) {
                            bVar = this.f17453e;
                            if (i8 <= bVar.f19310g) {
                                h2.a(i8, this.f17452d);
                                int d2 = this.f17452d.d();
                                int i9 = 0;
                                while (i9 < d2) {
                                    long a2 = this.f17452d.a(i9);
                                    if (a2 == Long.MIN_VALUE) {
                                        i3 = i4;
                                        long j7 = this.f17452d.f19301d;
                                        if (j7 == C.TIME_UNSET) {
                                            i9++;
                                            i4 = i3;
                                            j6 = 0;
                                        } else {
                                            a2 = j7;
                                        }
                                    } else {
                                        i3 = i4;
                                    }
                                    long c2 = this.f17452d.c() + a2;
                                    if (c2 >= j6 && c2 <= this.f17453e.f19312i) {
                                        long[] jArr = this.r;
                                        if (i6 == jArr.length) {
                                            int length = jArr.length == 0 ? 1 : jArr.length * 2;
                                            this.r = Arrays.copyOf(jArr, length);
                                            this.s = Arrays.copyOf(this.s, length);
                                        }
                                        this.r[i6] = com.opos.exoplayer.core.b.a(c2 + j5);
                                        this.s[i6] = this.f17452d.c(i9);
                                        i6++;
                                    }
                                    i9++;
                                    i4 = i3;
                                    j6 = 0;
                                }
                                i8++;
                                j6 = 0;
                            }
                        }
                        j5 += bVar.f19312i;
                        i5 = i7 + 1;
                        j6 = 0;
                        z = true;
                    }
                    j3 = j5;
                }
                com.opos.exoplayer.core.b.a(j3);
                long a3 = com.opos.exoplayer.core.b.a(j4);
                if (this.f17454f.o()) {
                    m = a3 + this.f17454f.p();
                } else {
                    m = a3 + this.f17454f.m();
                    this.f17454f.n();
                }
                j2 = m;
            } else {
                j2 = 0;
            }
            removeCallbacks(this.v);
            q qVar2 = this.f17454f;
            int c3 = qVar2 == null ? 1 : qVar2.c();
            if (c3 == 1 || c3 == 4) {
                return;
            }
            long j8 = 1000;
            if (this.f17454f.d() && c3 == 3) {
                float f2 = this.f17454f.e().f19185b;
                if (f2 > 0.1f) {
                    if (f2 <= 5.0f) {
                        long max = 1000 / Math.max(1, Math.round(1.0f / f2));
                        long j9 = max - (j2 % max);
                        if (j9 < max / 5) {
                            j9 += max;
                        }
                        j8 = f2 != 1.0f ? (long) (j9 / f2) : j9;
                    } else {
                        j8 = 200;
                    }
                }
            }
            postDelayed(this.v, j8);
        }
    }

    private void m() {
        r();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0035, code lost:
    
        if (r1.f19307d == false) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void n() {
        /*
            r6 = this;
            com.opos.exoplayer.core.q r0 = r6.f17454f
            com.opos.exoplayer.core.y r0 = r0.h()
            boolean r1 = r0.a()
            if (r1 == 0) goto Ld
            goto L45
        Ld:
            com.opos.exoplayer.core.q r1 = r6.f17454f
            int r1 = r1.i()
            com.opos.exoplayer.core.y$b r2 = r6.f17453e
            r0.a(r1, r2)
            com.opos.exoplayer.core.q r0 = r6.f17454f
            int r0 = r0.k()
            r1 = -1
            if (r0 == r1) goto L40
            com.opos.exoplayer.core.q r1 = r6.f17454f
            long r1 = r1.m()
            r3 = 3000(0xbb8, double:1.482E-320)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L37
            com.opos.exoplayer.core.y$b r1 = r6.f17453e
            boolean r2 = r1.f19308e
            if (r2 == 0) goto L40
            boolean r1 = r1.f19307d
            if (r1 != 0) goto L40
        L37:
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6.a(r0, r1)
            goto L45
        L40:
            r0 = 0
            r6.a(r0)
        L45:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.a.b.n():void");
    }

    private void o() {
        y h2 = this.f17454f.h();
        if (h2.a()) {
            return;
        }
        int i2 = this.f17454f.i();
        int j2 = this.f17454f.j();
        if (j2 != -1) {
            a(j2, C.TIME_UNSET);
        } else if (h2.a(i2, this.f17453e, false).f19308e) {
            a(i2, C.TIME_UNSET);
        }
    }

    private void p() {
        if (this.l <= 0) {
            return;
        }
        a(Math.max(this.f17454f.m() - this.l, 0L));
    }

    private void q() {
        if (this.m <= 0) {
            return;
        }
        long l = this.f17454f.l();
        long m = this.f17454f.m() + this.m;
        if (l != C.TIME_UNSET) {
            m = Math.min(m, l);
        }
        a(m);
    }

    private boolean r() {
        q qVar = this.f17454f;
        return (qVar == null || qVar.c() == 4 || this.f17454f.c() == 1 || !this.f17454f.d()) ? false : true;
    }

    public int a() {
        return this.n;
    }

    public void a(int i2) {
        this.n = i2;
        if (d()) {
            e();
        }
    }

    public void a(q qVar) {
        q qVar2 = this.f17454f;
        if (qVar2 == qVar) {
            return;
        }
        if (qVar2 != null) {
            qVar2.b(this.f17449a);
        }
        this.f17454f = qVar;
        if (qVar != null) {
            qVar.a(this.f17449a);
        }
        f();
    }

    public boolean a(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (this.f17454f == null || !b(keyCode)) {
            return false;
        }
        if (keyEvent.getAction() == 0) {
            if (keyCode == 90) {
                q();
            } else if (keyCode == 89) {
                p();
            } else if (keyEvent.getRepeatCount() == 0) {
                if (keyCode == 85) {
                    this.f17455g.a(this.f17454f, !r0.d());
                } else if (keyCode == 87) {
                    o();
                } else if (keyCode == 88) {
                    n();
                } else if (keyCode == 126) {
                    this.f17455g.a(this.f17454f, true);
                } else if (keyCode == 127) {
                    this.f17455g.a(this.f17454f, false);
                }
            }
        }
        return true;
    }

    public void b() {
        if (!d()) {
            setVisibility(0);
            a aVar = this.f17456h;
            if (aVar != null) {
                aVar.a(getVisibility());
            }
            f();
            m();
        }
        e();
    }

    public void c() {
        if (d()) {
            setVisibility(8);
            a aVar = this.f17456h;
            if (aVar != null) {
                aVar.a(getVisibility());
            }
            removeCallbacks(this.v);
            removeCallbacks(this.w);
            this.q = C.TIME_UNSET;
        }
    }

    public boolean d() {
        return getVisibility() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return a(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f17457i = true;
        long j2 = this.q;
        if (j2 != C.TIME_UNSET) {
            long uptimeMillis = j2 - SystemClock.uptimeMillis();
            if (uptimeMillis <= 0) {
                c();
            } else {
                postDelayed(this.w, uptimeMillis);
            }
        } else if (d()) {
            e();
        }
        f();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f17457i = false;
        removeCallbacks(this.v);
        removeCallbacks(this.w);
    }
}
