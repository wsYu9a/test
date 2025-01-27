package com.opos.exoplayer.core;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.opos.exoplayer.core.e.e;
import com.opos.exoplayer.core.y;
import com.vivo.google.android.exoplayer3.C;

/* loaded from: classes4.dex */
final class ad {

    /* renamed from: a */
    private final y.a f17690a = new y.a();

    /* renamed from: b */
    private final y.b f17691b = new y.b();

    /* renamed from: c */
    private long f17692c;

    /* renamed from: d */
    private y f17693d;

    /* renamed from: e */
    private int f17694e;

    /* renamed from: f */
    private boolean f17695f;

    /* renamed from: g */
    private ab f17696g;

    /* renamed from: h */
    private ab f17697h;

    /* renamed from: i */
    private ab f17698i;

    /* renamed from: j */
    private int f17699j;

    private ac a(int i2, int i3, int i4, long j2, long j3) {
        e.b bVar = new e.b(i2, i3, i4, j3);
        boolean b2 = b(bVar, Long.MIN_VALUE);
        boolean a2 = a(bVar, b2);
        return new ac(bVar, i4 == this.f17690a.b(i3) ? this.f17690a.e() : 0L, Long.MIN_VALUE, j2, this.f17693d.a(bVar.f18423a, this.f17690a).c(bVar.f18424b, bVar.f18425c), b2, a2);
    }

    @Nullable
    private ac a(ab abVar, long j2) {
        int i2;
        int b2;
        long a2;
        int i3;
        long j3;
        ad adVar;
        long j4;
        long j5;
        int i4;
        long j6;
        int i5;
        long j7;
        long j8;
        ac acVar = abVar.f17680h;
        if (acVar.f17688f) {
            int a3 = this.f17693d.a(acVar.f17683a.f18423a, this.f17690a, this.f17691b, this.f17694e, this.f17695f);
            if (a3 == -1) {
                return null;
            }
            int i6 = this.f17693d.a(a3, this.f17690a, true).f19300c;
            Object obj = this.f17690a.f19299b;
            long j9 = acVar.f17683a.f18426d;
            long j10 = 0;
            if (this.f17693d.a(i6, this.f17691b).f19309f == a3) {
                Pair<Integer, Long> a4 = this.f17693d.a(this.f17691b, this.f17690a, i6, C.TIME_UNSET, Math.max(0L, (abVar.a() + acVar.f17687e) - j2));
                if (a4 == null) {
                    return null;
                }
                int intValue = ((Integer) a4.first).intValue();
                long longValue = ((Long) a4.second).longValue();
                ab abVar2 = abVar.f17681i;
                if (abVar2 == null || !abVar2.f17674b.equals(obj)) {
                    j8 = this.f17692c;
                    this.f17692c = 1 + j8;
                } else {
                    j8 = abVar.f17681i.f17680h.f17683a.f18426d;
                }
                j10 = longValue;
                j7 = j8;
                i5 = intValue;
            } else {
                i5 = a3;
                j7 = j9;
            }
            long j11 = j10;
            return a(a(i5, j11, j7), j11, j10);
        }
        e.b bVar = acVar.f17683a;
        this.f17693d.a(bVar.f18423a, this.f17690a);
        if (bVar.a()) {
            i2 = bVar.f18424b;
            int d2 = this.f17690a.d(i2);
            if (d2 == -1) {
                return null;
            }
            int a5 = this.f17690a.a(i2, bVar.f18425c);
            if (a5 >= d2) {
                i4 = bVar.f18423a;
                j6 = acVar.f17686d;
                return b(i4, j6, bVar.f18426d);
            }
            if (!this.f17690a.b(i2, a5)) {
                return null;
            }
            int i7 = bVar.f18423a;
            j4 = acVar.f17686d;
            j5 = bVar.f18426d;
            adVar = this;
            i3 = i7;
            b2 = a5;
            a2 = j4;
            j3 = j5;
        } else {
            long j12 = acVar.f17685c;
            if (j12 != Long.MIN_VALUE) {
                i2 = this.f17690a.a(j12);
                if (i2 == -1) {
                    i4 = bVar.f18423a;
                    j6 = acVar.f17685c;
                    return b(i4, j6, bVar.f18426d);
                }
                b2 = this.f17690a.b(i2);
                if (!this.f17690a.b(i2, b2)) {
                    return null;
                }
                int i8 = bVar.f18423a;
                j4 = acVar.f17685c;
                j5 = bVar.f18426d;
                adVar = this;
                i3 = i8;
                a2 = j4;
                j3 = j5;
            } else {
                int d3 = this.f17690a.d();
                if (d3 == 0) {
                    return null;
                }
                i2 = d3 - 1;
                if (this.f17690a.a(i2) != Long.MIN_VALUE || this.f17690a.c(i2)) {
                    return null;
                }
                b2 = this.f17690a.b(i2);
                if (!this.f17690a.b(i2, b2)) {
                    return null;
                }
                a2 = this.f17690a.a();
                i3 = bVar.f18423a;
                j3 = bVar.f18426d;
                adVar = this;
            }
        }
        return adVar.a(i3, i2, b2, a2, j3);
    }

    private ac a(ac acVar, e.b bVar) {
        long j2;
        long a2;
        long j3 = acVar.f17684b;
        long j4 = acVar.f17685c;
        boolean b2 = b(bVar, j4);
        boolean a3 = a(bVar, b2);
        this.f17693d.a(bVar.f18423a, this.f17690a);
        if (bVar.a()) {
            a2 = this.f17690a.c(bVar.f18424b, bVar.f18425c);
        } else {
            if (j4 != Long.MIN_VALUE) {
                j2 = j4;
                return new ac(bVar, j3, j4, acVar.f17686d, j2, b2, a3);
            }
            a2 = this.f17690a.a();
        }
        j2 = a2;
        return new ac(bVar, j3, j4, acVar.f17686d, j2, b2, a3);
    }

    private ac a(ae aeVar) {
        return a(aeVar.f17702c, aeVar.f17704e, aeVar.f17703d);
    }

    private ac a(e.b bVar, long j2, long j3) {
        this.f17693d.a(bVar.f18423a, this.f17690a);
        if (!bVar.a()) {
            return b(bVar.f18423a, j3, bVar.f18426d);
        }
        if (this.f17690a.b(bVar.f18424b, bVar.f18425c)) {
            return a(bVar.f18423a, bVar.f18424b, bVar.f18425c, j2, bVar.f18426d);
        }
        return null;
    }

    private e.b a(int i2, long j2, long j3) {
        this.f17693d.a(i2, this.f17690a);
        int a2 = this.f17690a.a(j2);
        return a2 == -1 ? new e.b(i2, j3) : new e.b(i2, a2, this.f17690a.b(a2), j3);
    }

    private boolean a(ab abVar, ac acVar) {
        ac acVar2 = abVar.f17680h;
        return acVar2.f17684b == acVar.f17684b && acVar2.f17685c == acVar.f17685c && acVar2.f17683a.equals(acVar.f17683a);
    }

    private boolean a(e.b bVar, boolean z) {
        return !this.f17693d.a(this.f17693d.a(bVar.f18423a, this.f17690a).f19300c, this.f17691b).f19308e && this.f17693d.b(bVar.f18423a, this.f17690a, this.f17691b, this.f17694e, this.f17695f) && z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:?, code lost:
    
        return r0.f17680h.f17683a.f18426d;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private long b(int r5) {
        /*
            r4 = this;
            com.opos.exoplayer.core.y r0 = r4.f17693d
            com.opos.exoplayer.core.y$a r1 = r4.f17690a
            r2 = 1
            com.opos.exoplayer.core.y$a r5 = r0.a(r5, r1, r2)
            java.lang.Object r5 = r5.f19299b
            com.opos.exoplayer.core.ab r0 = r4.e()
        Lf:
            if (r0 == 0) goto L23
            java.lang.Object r1 = r0.f17674b
            boolean r1 = r1.equals(r5)
            if (r1 == 0) goto L20
        L19:
            com.opos.exoplayer.core.ac r5 = r0.f17680h
            com.opos.exoplayer.core.e.e$b r5 = r5.f17683a
            long r0 = r5.f18426d
            goto L4f
        L20:
            com.opos.exoplayer.core.ab r0 = r0.f17681i
            goto Lf
        L23:
            com.opos.exoplayer.core.y$a r5 = r4.f17690a
            int r5 = r5.f19300c
            com.opos.exoplayer.core.ab r0 = r4.e()
        L2b:
            if (r0 == 0) goto L48
            com.opos.exoplayer.core.y r1 = r4.f17693d
            java.lang.Object r2 = r0.f17674b
            int r1 = r1.a(r2)
            r2 = -1
            if (r1 == r2) goto L45
            com.opos.exoplayer.core.y r2 = r4.f17693d
            com.opos.exoplayer.core.y$a r3 = r4.f17690a
            com.opos.exoplayer.core.y$a r1 = r2.a(r1, r3)
            int r1 = r1.f19300c
            if (r1 != r5) goto L45
            goto L19
        L45:
            com.opos.exoplayer.core.ab r0 = r0.f17681i
            goto L2b
        L48:
            long r0 = r4.f17692c
            r2 = 1
            long r2 = r2 + r0
            r4.f17692c = r2
        L4f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.ad.b(int):long");
    }

    private ac b(int i2, long j2, long j3) {
        e.b bVar = new e.b(i2, j3);
        this.f17693d.a(bVar.f18423a, this.f17690a);
        int b2 = this.f17690a.b(j2);
        long a2 = b2 == -1 ? Long.MIN_VALUE : this.f17690a.a(b2);
        boolean b3 = b(bVar, a2);
        return new ac(bVar, j2, a2, C.TIME_UNSET, a2 == Long.MIN_VALUE ? this.f17690a.a() : a2, b3, a(bVar, b3));
    }

    private boolean b(e.b bVar, long j2) {
        int d2 = this.f17693d.a(bVar.f18423a, this.f17690a).d();
        if (d2 != 0) {
            int i2 = d2 - 1;
            boolean a2 = bVar.a();
            if (this.f17690a.a(i2) == Long.MIN_VALUE) {
                int d3 = this.f17690a.d(i2);
                if (d3 == -1) {
                    return false;
                }
                if (!(a2 && bVar.f18424b == i2 && bVar.f18425c == d3 + (-1)) && (a2 || this.f17690a.b(i2) != d3)) {
                    return false;
                }
            } else if (a2 || j2 != Long.MIN_VALUE) {
                return false;
            }
        }
        return true;
    }

    private boolean j() {
        ab abVar;
        ab e2 = e();
        if (e2 == null) {
            return true;
        }
        while (true) {
            int a2 = this.f17693d.a(e2.f17680h.f17683a.f18423a, this.f17690a, this.f17691b, this.f17694e, this.f17695f);
            while (true) {
                abVar = e2.f17681i;
                if (abVar == null || e2.f17680h.f17688f) {
                    break;
                }
                e2 = abVar;
            }
            if (a2 == -1 || abVar == null || abVar.f17680h.f17683a.f18423a != a2) {
                break;
            }
            e2 = abVar;
        }
        boolean a3 = a(e2);
        ac acVar = e2.f17680h;
        e2.f17680h = a(acVar, acVar.f17683a);
        return (a3 && f()) ? false : true;
    }

    @Nullable
    public ac a(long j2, ae aeVar) {
        ab abVar = this.f17698i;
        return abVar == null ? a(aeVar) : a(abVar, j2);
    }

    public ac a(ac acVar, int i2) {
        return a(acVar, acVar.f17683a.a(i2));
    }

    public com.opos.exoplayer.core.e.d a(t[] tVarArr, long j2, com.opos.exoplayer.core.g.h hVar, com.opos.exoplayer.core.h.b bVar, com.opos.exoplayer.core.e.e eVar, Object obj, ac acVar) {
        long a2;
        ab abVar = this.f17698i;
        if (abVar == null) {
            a2 = acVar.f17684b + j2;
        } else {
            a2 = this.f17698i.f17680h.f17687e + abVar.a();
        }
        ab abVar2 = new ab(tVarArr, a2, hVar, bVar, eVar, obj, acVar);
        if (this.f17698i != null) {
            com.opos.exoplayer.core.i.a.b(f());
            this.f17698i.f17681i = abVar2;
        }
        this.f17698i = abVar2;
        this.f17699j++;
        return abVar2.f17673a;
    }

    public e.b a(int i2, long j2) {
        return a(i2, j2, b(i2));
    }

    public com.opos.exoplayer.core.g.i a(float f2) {
        return this.f17698i.a(f2);
    }

    public void a(long j2) {
        ab abVar = this.f17698i;
        if (abVar != null) {
            abVar.c(j2);
        }
    }

    public void a(y yVar) {
        this.f17693d = yVar;
    }

    public boolean a() {
        ab abVar = this.f17698i;
        return abVar == null || (!abVar.f17680h.f17689g && abVar.b() && this.f17698i.f17680h.f17687e != C.TIME_UNSET && this.f17699j < 100);
    }

    public boolean a(int i2) {
        this.f17694e = i2;
        return j();
    }

    public boolean a(ab abVar) {
        boolean z = false;
        com.opos.exoplayer.core.i.a.b(abVar != null);
        this.f17698i = abVar;
        while (true) {
            abVar = abVar.f17681i;
            if (abVar == null) {
                this.f17698i.f17681i = null;
                return z;
            }
            if (abVar == this.f17697h) {
                this.f17697h = this.f17696g;
                z = true;
            }
            abVar.d();
            this.f17699j--;
        }
    }

    public boolean a(com.opos.exoplayer.core.e.d dVar) {
        ab abVar = this.f17698i;
        return abVar != null && abVar.f17673a == dVar;
    }

    public boolean a(e.b bVar, long j2) {
        int i2 = bVar.f18423a;
        ab e2 = e();
        ab abVar = null;
        int i3 = i2;
        while (true) {
            if (e2 == null) {
                break;
            }
            if (abVar == null) {
                e2.f17680h = a(e2.f17680h, i3);
            } else {
                if (i3 == -1 || !e2.f17674b.equals(this.f17693d.a(i3, this.f17690a, true).f19299b)) {
                    break;
                }
                ac a2 = a(abVar, j2);
                if (a2 != null) {
                    e2.f17680h = a(e2.f17680h, i3);
                    if (!a(e2, a2)) {
                        if (a(abVar)) {
                            return false;
                        }
                    }
                } else if (a(abVar)) {
                    return false;
                }
            }
            if (e2.f17680h.f17688f) {
                i3 = this.f17693d.a(i3, this.f17690a, this.f17691b, this.f17694e, this.f17695f);
            }
            abVar = e2;
            e2 = e2.f17681i;
        }
        return !a(abVar);
    }

    public boolean a(boolean z) {
        this.f17695f = z;
        return j();
    }

    public ab b() {
        return this.f17698i;
    }

    public ab c() {
        return this.f17696g;
    }

    public ab d() {
        return this.f17697h;
    }

    public ab e() {
        return f() ? this.f17696g : this.f17698i;
    }

    public boolean f() {
        return this.f17696g != null;
    }

    public ab g() {
        ab abVar = this.f17697h;
        com.opos.exoplayer.core.i.a.b((abVar == null || abVar.f17681i == null) ? false : true);
        ab abVar2 = this.f17697h.f17681i;
        this.f17697h = abVar2;
        return abVar2;
    }

    public ab h() {
        ab abVar = this.f17696g;
        if (abVar != null) {
            if (abVar == this.f17697h) {
                this.f17697h = abVar.f17681i;
            }
            abVar.d();
            this.f17696g = this.f17696g.f17681i;
            int i2 = this.f17699j - 1;
            this.f17699j = i2;
            if (i2 == 0) {
                this.f17698i = null;
            }
        } else {
            ab abVar2 = this.f17698i;
            this.f17696g = abVar2;
            this.f17697h = abVar2;
        }
        return this.f17696g;
    }

    public void i() {
        ab e2 = e();
        if (e2 != null) {
            e2.d();
            a(e2);
        }
        this.f17696g = null;
        this.f17698i = null;
        this.f17697h = null;
        this.f17699j = 0;
    }
}
