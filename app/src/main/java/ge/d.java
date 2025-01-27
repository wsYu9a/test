package ge;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.view.View;
import com.martian.mibook.data.book.CommentCount;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes3.dex */
public class d {

    /* renamed from: n */
    public static final int f26231n = 2;

    /* renamed from: o */
    public static final int f26232o = 1;

    /* renamed from: p */
    public static final int f26233p = -1;

    /* renamed from: a */
    public final q f26234a;

    /* renamed from: b */
    public final q f26235b;

    /* renamed from: c */
    public final TextPaint f26236c;

    /* renamed from: d */
    public final TextPaint f26237d;

    /* renamed from: e */
    public int f26238e;

    /* renamed from: f */
    public int f26239f;

    /* renamed from: i */
    public View f26242i;

    /* renamed from: g */
    public boolean f26240g = false;

    /* renamed from: h */
    public boolean f26241h = false;

    /* renamed from: j */
    public int f26243j = Integer.MIN_VALUE;

    /* renamed from: k */
    public int f26244k = Integer.MIN_VALUE;

    /* renamed from: l */
    public int f26245l = Integer.MIN_VALUE;

    /* renamed from: m */
    public int f26246m = Integer.MIN_VALUE;

    public d(q qVar, q qVar2, int i10, int i11, TextPaint textPaint, TextPaint textPaint2) {
        this.f26234a = qVar;
        this.f26235b = qVar2;
        this.f26238e = i10;
        this.f26239f = i11;
        this.f26236c = textPaint;
        this.f26237d = textPaint2;
    }

    public boolean A(int i10) {
        if (i10 == 0) {
            q qVar = this.f26234a;
            return (qVar == null || qVar.G(i10) == null) ? false : true;
        }
        q qVar2 = this.f26235b;
        return (qVar2 == null || qVar2.G(i10) == null) ? false : true;
    }

    public boolean B() {
        return this.f26240g;
    }

    public List<CommentCount> C(Collection<CommentCount> collection) {
        LinkedList linkedList = null;
        if (collection != null && !collection.isEmpty()) {
            for (CommentCount commentCount : collection) {
                if (commentCount.getParagraphIdx() != null) {
                    if (!A(commentCount.getParagraphIdx().intValue())) {
                        if (linkedList != null) {
                            break;
                        }
                    } else {
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                        }
                        linkedList.add(commentCount);
                    }
                }
            }
        }
        return linkedList;
    }

    public final boolean D() {
        q qVar = this.f26235b;
        if (qVar != null) {
            return qVar.U();
        }
        return false;
    }

    public final boolean E() {
        q qVar = this.f26235b;
        if (qVar != null) {
            return qVar.V();
        }
        return false;
    }

    public final boolean F(int i10, int i11) {
        q qVar = this.f26235b;
        if (qVar != null) {
            return qVar.W(i10, i11);
        }
        return false;
    }

    public void G() {
        View view;
        boolean D = D() | J();
        this.f26245l = Integer.MIN_VALUE;
        this.f26246m = Integer.MIN_VALUE;
        if (!D || (view = this.f26242i) == null) {
            return;
        }
        view.invalidate();
    }

    public void H() {
        I(true);
    }

    public void I(boolean z10) {
        View view;
        boolean E = E() | K();
        this.f26243j = Integer.MIN_VALUE;
        this.f26244k = Integer.MIN_VALUE;
        if (z10 && E && (view = this.f26242i) != null) {
            view.invalidate();
        }
    }

    public final boolean J() {
        q qVar = this.f26234a;
        if (qVar != null) {
            return qVar.U();
        }
        return false;
    }

    public final boolean K() {
        q qVar = this.f26234a;
        if (qVar != null) {
            return qVar.V();
        }
        return false;
    }

    public final boolean L(int i10, int i11) {
        q qVar = this.f26234a;
        if (qVar != null) {
            return qVar.W(i10, i11);
        }
        return false;
    }

    public void M(int i10, int i11) {
        View view;
        if ((!L(i10, i11) && !F(i10, i11)) || (view = this.f26242i) == null) {
            return;
        }
        view.invalidate();
    }

    public void N(int i10) {
        this.f26237d.setColor(i10);
    }

    public void O(boolean z10) {
        this.f26241h = z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean P(int r5, int r6) {
        /*
            r4 = this;
            r0 = 0
            if (r5 < r6) goto L4
            return r0
        L4:
            ge.q r1 = r4.f26234a
            if (r1 == 0) goto L24
            if (r5 >= 0) goto L21
            int r1 = r1.N()
            int r1 = r1 + r5
            ge.q r2 = r4.f26234a
            int r2 = r2.N()
            int r3 = java.lang.Math.min(r6, r0)
            int r2 = r2 + r3
            ge.q r3 = r4.f26234a
            boolean r1 = r3.X(r1, r2)
            goto L25
        L21:
            r1.U()
        L24:
            r1 = 0
        L25:
            ge.q r2 = r4.f26235b
            if (r2 == 0) goto L40
            int r2 = java.lang.Math.max(r5, r0)
            int r0 = java.lang.Math.max(r6, r0)
            if (r2 < r0) goto L39
            ge.q r0 = r4.f26235b
            r0.U()
            goto L40
        L39:
            ge.q r3 = r4.f26235b
            boolean r0 = r3.X(r2, r0)
            r1 = r1 | r0
        L40:
            if (r1 == 0) goto L4d
            r4.f26245l = r5
            r4.f26246m = r6
            android.view.View r5 = r4.f26242i
            if (r5 == 0) goto L4d
            r5.invalidate()
        L4d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ge.d.P(int, int):boolean");
    }

    public void Q(int i10) {
        q qVar = this.f26235b;
        if (qVar != null) {
            qVar.p().setColor(i10);
        }
        q qVar2 = this.f26234a;
        if (qVar2 != null) {
            qVar2.p().setColor(i10);
        }
    }

    public void R(boolean z10) {
        this.f26240g = z10;
    }

    public void S(int i10) {
        this.f26239f = i10;
    }

    public void T(int i10) {
        this.f26238e = i10;
    }

    public boolean U(float f10, float f11) {
        boolean z10;
        View view;
        q qVar = this.f26234a;
        if (qVar != null) {
            z10 = qVar.a0(f10, f11);
            if (z10) {
                this.f26243j = this.f26234a.J() - this.f26234a.N();
                this.f26244k = this.f26234a.H() - this.f26234a.N();
            }
        } else {
            z10 = false;
        }
        q qVar2 = this.f26235b;
        if (qVar2 != null) {
            if (z10) {
                qVar2.V();
            } else {
                z10 = qVar2.a0(f10, f11);
                if (z10) {
                    this.f26243j = this.f26235b.J();
                    this.f26244k = this.f26235b.H();
                }
            }
        }
        if (z10 && (view = this.f26242i) != null) {
            view.invalidate();
        }
        return z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean V(int r5, int r6) {
        /*
            r4 = this;
            r0 = 0
            if (r5 < r6) goto L4
            return r0
        L4:
            ge.q r1 = r4.f26234a
            if (r1 == 0) goto L24
            if (r5 >= 0) goto L21
            int r1 = r1.N()
            int r1 = r1 + r5
            ge.q r2 = r4.f26234a
            int r2 = r2.N()
            int r3 = java.lang.Math.min(r6, r0)
            int r2 = r2 + r3
            ge.q r3 = r4.f26234a
            boolean r1 = r3.b0(r1, r2)
            goto L25
        L21:
            r1.V()
        L24:
            r1 = 0
        L25:
            ge.q r2 = r4.f26235b
            if (r2 == 0) goto L40
            int r2 = java.lang.Math.max(r5, r0)
            int r0 = java.lang.Math.max(r6, r0)
            if (r2 < r0) goto L39
            ge.q r0 = r4.f26235b
            r0.V()
            goto L40
        L39:
            ge.q r3 = r4.f26235b
            boolean r0 = r3.b0(r2, r0)
            r1 = r1 | r0
        L40:
            if (r1 == 0) goto L4d
            r4.f26243j = r5
            r4.f26244k = r6
            android.view.View r5 = r4.f26242i
            if (r5 == 0) goto L4d
            r5.invalidate()
        L4d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ge.d.V(int, int):boolean");
    }

    public void W(int i10) {
        this.f26236c.setColor(i10);
    }

    public void X(int i10) {
        q qVar = this.f26234a;
        if (qVar != null) {
            qVar.d0(i10);
            return;
        }
        q qVar2 = this.f26235b;
        if (qVar2 != null) {
            qVar2.d0(i10);
        }
    }

    public void Y(boolean z10) {
        q qVar = this.f26234a;
        if (qVar != null && this.f26235b == null) {
            qVar.e0(z10);
        }
        q qVar2 = this.f26235b;
        if (qVar2 != null) {
            qVar2.e0(z10);
        }
    }

    public void Z(View view) {
        this.f26242i = view;
        q qVar = this.f26234a;
        if (qVar != null) {
            qVar.f0(view);
        }
        q qVar2 = this.f26235b;
        if (qVar2 != null) {
            qVar2.f0(view);
        }
    }

    public boolean a(int i10, int i11) {
        View view;
        if (i10 >= i11) {
            return false;
        }
        q qVar = this.f26234a;
        boolean c10 = (qVar == null || i10 >= 0) ? false : this.f26234a.c(qVar.N() + i10, this.f26234a.N() + Math.min(i11, 0));
        if (this.f26235b != null) {
            c10 |= this.f26235b.c(Math.max(i10, 0), Math.max(i11, 0));
        }
        if (c10 && (view = this.f26242i) != null) {
            view.invalidate();
        }
        return c10;
    }

    public boolean a0() {
        q qVar = this.f26234a;
        boolean g02 = qVar != null ? qVar.g0() : false;
        q qVar2 = this.f26235b;
        boolean g03 = qVar2 != null ? qVar2.g0() : false;
        return (this.f26234a == null || this.f26235b == null) ? g02 || g03 : g02 && g03;
    }

    public void b() {
        q qVar = this.f26234a;
        if (qVar != null) {
            qVar.d();
        }
        q qVar2 = this.f26235b;
        if (qVar2 != null) {
            qVar2.d();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int b0(float r9, float r10) {
        /*
            r8 = this;
            ge.q r0 = r8.f26234a
            r1 = 1
            r2 = 0
            r3 = -1
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 == 0) goto L4d
            int r0 = r0.O(r9, r10)
            if (r0 != r3) goto L3d
            ge.q r5 = r8.f26234a
            int r5 = r5.z()
            float r5 = (float) r5
            int r5 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r5 <= 0) goto L2a
            int r5 = r8.f26243j
            if (r5 >= 0) goto L2a
            ge.q r0 = r8.f26234a
            int r5 = r0.q()
            int r5 = r5 - r1
            int r0 = r0.s(r5)
            goto L3d
        L2a:
            ge.q r5 = r8.f26234a
            float r5 = r5.w(r2)
            r6 = 1106247680(0x41f00000, float:30.0)
            float r5 = r5 - r6
            int r5 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r5 >= 0) goto L3d
            ge.q r0 = r8.f26234a
            int r0 = r0.v(r2)
        L3d:
            if (r0 == r3) goto L4d
            ge.q r5 = r8.f26234a
            int r5 = r5.N()
            int r0 = r0 - r5
            int r5 = r8.f26243j
            if (r0 != r5) goto L51
            int r5 = r5 + (-1)
            goto L51
        L4d:
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
        L51:
            ge.q r6 = r8.f26235b
            if (r6 == 0) goto La0
            int r9 = r6.O(r9, r10)
            if (r9 != r3) goto L77
            ge.q r6 = r8.f26235b
            float r6 = r6.w(r2)
            int r6 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r6 >= 0) goto L7b
            if (r0 != r4) goto L6d
            ge.q r9 = r8.f26235b
            int r0 = r9.v(r2)
        L6d:
            ge.q r9 = r8.f26235b
            int r9 = r9.v(r2)
            int r9 = java.lang.Math.min(r0, r9)
        L77:
            r7 = r0
            r0 = r9
            r9 = r7
            goto L94
        L7b:
            ge.q r2 = r8.f26235b
            int r2 = r2.o()
            int r2 = r2 + 30
            float r2 = (float) r2
            int r10 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r10 <= 0) goto L77
            ge.q r9 = r8.f26235b
            int r10 = r9.q()
            int r10 = r10 - r1
            int r9 = r9.s(r10)
            goto L77
        L94:
            if (r0 == r3) goto L9f
            if (r5 != r4) goto L9a
            int r5 = r8.f26243j
        L9a:
            if (r5 != r0) goto La0
            int r5 = r5 + (-1)
            goto La0
        L9f:
            r0 = r9
        La0:
            if (r5 == r4) goto Laf
            if (r0 == r4) goto Laf
            if (r5 <= r0) goto Lab
            r8.V(r0, r5)
            r9 = 2
            return r9
        Lab:
            r8.V(r5, r0)
            return r1
        Laf:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ge.d.b0(float, float):int");
    }

    public void c(Canvas canvas) {
        q qVar = this.f26234a;
        if (qVar != null) {
            qVar.j(canvas);
        }
        q qVar2 = this.f26235b;
        if (qVar2 != null) {
            qVar2.j(canvas);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int c0(float r9, float r10) {
        /*
            r8 = this;
            ge.q r0 = r8.f26234a
            r1 = 1
            r2 = 0
            r3 = -1
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 == 0) goto L4d
            int r0 = r0.O(r9, r10)
            if (r0 != r3) goto L3d
            ge.q r5 = r8.f26234a
            int r5 = r5.z()
            float r5 = (float) r5
            int r5 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r5 <= 0) goto L2a
            int r5 = r8.f26244k
            if (r5 >= 0) goto L2a
            ge.q r0 = r8.f26234a
            int r5 = r0.q()
            int r5 = r5 - r1
            int r0 = r0.s(r5)
            goto L3d
        L2a:
            ge.q r5 = r8.f26234a
            int r5 = r5.z()
            int r5 = r5 + (-30)
            float r5 = (float) r5
            int r5 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r5 >= 0) goto L3d
            ge.q r0 = r8.f26234a
            int r0 = r0.v(r2)
        L3d:
            if (r0 == r3) goto L4d
            ge.q r5 = r8.f26234a
            int r5 = r5.N()
            int r0 = r0 - r5
            int r5 = r8.f26244k
            if (r0 != r5) goto L51
            int r0 = r0 + (-1)
            goto L51
        L4d:
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
        L51:
            ge.q r6 = r8.f26235b
            if (r6 == 0) goto La0
            int r9 = r6.O(r9, r10)
            if (r9 != r3) goto L77
            ge.q r6 = r8.f26235b
            float r6 = r6.w(r2)
            int r6 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r6 >= 0) goto L7b
            if (r0 != r4) goto L6d
            ge.q r9 = r8.f26235b
            int r0 = r9.v(r2)
        L6d:
            ge.q r9 = r8.f26235b
            int r9 = r9.v(r2)
            int r9 = java.lang.Math.min(r0, r9)
        L77:
            r7 = r0
            r0 = r9
            r9 = r7
            goto L94
        L7b:
            ge.q r2 = r8.f26235b
            int r2 = r2.o()
            int r2 = r2 + 30
            float r2 = (float) r2
            int r10 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r10 <= 0) goto L77
            ge.q r9 = r8.f26235b
            int r10 = r9.q()
            int r10 = r10 - r1
            int r9 = r9.s(r10)
            goto L77
        L94:
            if (r0 == r3) goto L9f
            if (r5 != r4) goto L9a
            int r5 = r8.f26244k
        L9a:
            if (r0 != r5) goto La0
            int r0 = r0 + (-1)
            goto La0
        L9f:
            r0 = r9
        La0:
            if (r0 == r4) goto Laf
            if (r5 == r4) goto Laf
            if (r0 <= r5) goto Lab
            r8.V(r5, r0)
            r9 = 2
            return r9
        Lab:
            r8.V(r0, r5)
            return r1
        Laf:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ge.d.c0(float, float):int");
    }

    public int d() {
        q qVar = this.f26235b;
        if (qVar == null) {
            return 0;
        }
        return qVar.s(qVar.q() - 1);
    }

    public q e() {
        return this.f26235b;
    }

    public TextPaint f() {
        return this.f26237d;
    }

    public int g() {
        q qVar = this.f26235b;
        if (qVar == null) {
            return 0;
        }
        return qVar.v(0);
    }

    public int h() {
        q qVar = this.f26235b;
        return qVar != null ? qVar.o() : this.f26234a.o();
    }

    public int i() {
        q qVar = this.f26235b;
        return qVar != null ? qVar.z() : this.f26234a.z();
    }

    public float j() {
        q qVar = this.f26235b;
        if (qVar != null) {
            return qVar.u(qVar.q());
        }
        q qVar2 = this.f26234a;
        if (qVar2 != null) {
            return qVar2.u(qVar2.q());
        }
        return 0.0f;
    }

    public int k() {
        q qVar = this.f26235b;
        if (qVar != null) {
            return qVar.s(qVar.q() - 1);
        }
        q qVar2 = this.f26234a;
        if (qVar2 == null) {
            return 0;
        }
        return qVar2.s(qVar2.q() - 1);
    }

    public int l() {
        return this.f26239f;
    }

    public int m() {
        q qVar = this.f26234a;
        if (qVar != null) {
            return qVar.v(0) - this.f26234a.N();
        }
        q qVar2 = this.f26235b;
        if (qVar2 == null) {
            return 0;
        }
        return qVar2.v(0);
    }

    public int n() {
        return this.f26238e;
    }

    public Rect o(int i10, int i11) {
        if (i10 == 0) {
            q qVar = this.f26234a;
            if (qVar != null) {
                return qVar.E(i10, i11);
            }
            return null;
        }
        q qVar2 = this.f26235b;
        if (qVar2 == null) {
            return null;
        }
        return qVar2.E(i10, i11);
    }

    public int p(int i10) {
        if (this.f26234a != null && i10 <= 0) {
            return 0;
        }
        q qVar = this.f26235b;
        if (qVar == null || i10 <= 0) {
            return -1;
        }
        return qVar.F(i10);
    }

    public String q() {
        q qVar = this.f26235b;
        if (qVar == null) {
            return null;
        }
        return qVar.L();
    }

    public int r() {
        return this.f26244k;
    }

    public RectF s() {
        q qVar = this.f26235b;
        RectF I = qVar != null ? qVar.I() : null;
        q qVar2 = this.f26234a;
        return (qVar2 == null || I != null) ? I : qVar2.I();
    }

    public int t() {
        return this.f26243j;
    }

    public RectF u() {
        q qVar = this.f26234a;
        RectF K = qVar != null ? qVar.K() : null;
        q qVar2 = this.f26235b;
        return (qVar2 == null || K != null) ? K : qVar2.K();
    }

    public String v() {
        q qVar = this.f26234a;
        if (qVar == null) {
            return null;
        }
        return qVar.L();
    }

    public q w() {
        return this.f26234a;
    }

    public TextPaint x() {
        return this.f26236c;
    }

    public View y() {
        return this.f26242i;
    }

    public boolean z() {
        return this.f26241h;
    }
}
