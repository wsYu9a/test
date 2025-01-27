package com.vivo.mobilead.unified.base.view.u;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.vivo.ad.model.d;
import com.vivo.ad.model.k;
import com.vivo.ad.view.v;
import com.vivo.mobilead.unified.base.view.n;
import com.vivo.mobilead.util.a0;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class c implements a {

    /* renamed from: a */
    private com.vivo.ad.model.b f30258a;

    /* renamed from: b */
    private double f30259b = 200.0d;

    /* renamed from: c */
    private List<Pair<Float, Float>> f30260c = new ArrayList();

    /* renamed from: d */
    private View f30261d;

    public c(View view, com.vivo.ad.model.b bVar) {
        this.f30261d = view;
        this.f30258a = bVar;
    }

    @Override // com.vivo.mobilead.unified.base.view.u.a
    public boolean a(double d2) {
        return d2 >= this.f30259b;
    }

    @Override // com.vivo.mobilead.unified.base.view.u.a
    public void b(double d2) {
        this.f30259b = d2;
    }

    @Override // com.vivo.mobilead.unified.base.view.u.a
    public void a() {
        this.f30260c.clear();
    }

    @Override // com.vivo.mobilead.unified.base.view.u.a
    public void a(Pair<Float, Float> pair) {
        com.vivo.ad.model.b bVar;
        d b2;
        Pair<Float, Float> pair2;
        if (this.f30261d == null || pair == null || pair.first == null || pair.second == null || (bVar = this.f30258a) == null || (b2 = bVar.b()) == null) {
            return;
        }
        if (!this.f30260c.isEmpty() && (pair2 = this.f30260c.get(0)) != null && pair2.first != null && pair2.second != null) {
            if (b2.g() == 1) {
                if (((Float) pair.second).floatValue() > ((Float) pair2.second).floatValue()) {
                    return;
                }
            } else if (b2.g() == 2 && ((Float) pair.first).floatValue() < ((Float) pair2.first).floatValue()) {
                return;
            }
        }
        k b3 = b2.b();
        k e2 = b2.e();
        if (b3 == null || e2 == null) {
            return;
        }
        this.f30261d.getLocationOnScreen(new int[2]);
        float floatValue = ((Float) pair.first).floatValue();
        float floatValue2 = ((Float) pair.second).floatValue();
        if (a0.a(e2.e(), -1.0f) || a0.a(e2.f(), -1.0f)) {
            this.f30260c.add(pair);
        } else {
            if (floatValue2 < ((r1[1] + this.f30261d.getHeight()) - e2.c()) - e2.a() || floatValue2 > (r1[1] + this.f30261d.getHeight()) - e2.c() || floatValue < r1[0] + e2.b() || floatValue > r1[0] + e2.b() + e2.d()) {
                return;
            }
            this.f30260c.add(pair);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007c A[SYNTHETIC] */
    @Override // com.vivo.mobilead.unified.base.view.u.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public double a(com.vivo.ad.model.d r14) {
        /*
            r13 = this;
            java.util.List<android.util.Pair<java.lang.Float, java.lang.Float>> r0 = r13.f30260c
            boolean r0 = r0.isEmpty()
            r1 = 0
            if (r0 != 0) goto L7f
            java.util.List<android.util.Pair<java.lang.Float, java.lang.Float>> r0 = r13.f30260c
            r3 = 0
            java.lang.Object r0 = r0.get(r3)
            android.util.Pair r0 = (android.util.Pair) r0
            java.lang.Object r0 = r0.first
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            java.util.List<android.util.Pair<java.lang.Float, java.lang.Float>> r4 = r13.f30260c
            java.lang.Object r3 = r4.get(r3)
            android.util.Pair r3 = (android.util.Pair) r3
            java.lang.Object r3 = r3.second
            java.lang.Float r3 = (java.lang.Float) r3
            float r3 = r3.floatValue()
            r4 = 1
            r5 = 1
        L2d:
            java.util.List<android.util.Pair<java.lang.Float, java.lang.Float>> r6 = r13.f30260c
            int r6 = r6.size()
            if (r5 >= r6) goto L7f
            java.util.List<android.util.Pair<java.lang.Float, java.lang.Float>> r6 = r13.f30260c
            java.lang.Object r6 = r6.get(r5)
            android.util.Pair r6 = (android.util.Pair) r6
            java.lang.Object r7 = r6.first
            java.lang.Float r7 = (java.lang.Float) r7
            float r7 = r7.floatValue()
            java.lang.Object r6 = r6.second
            java.lang.Float r6 = (java.lang.Float) r6
            float r6 = r6.floatValue()
            int r8 = r14.g()
            if (r8 != r4) goto L58
            int r8 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r8 < 0) goto L64
            goto L7c
        L58:
            int r8 = r14.g()
            r9 = 2
            if (r8 != r9) goto L64
            int r8 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r8 > 0) goto L64
            goto L7c
        L64:
            float r7 = r7 - r0
            double r7 = (double) r7
            r9 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r7 = java.lang.Math.pow(r7, r9)
            float r6 = r6 - r3
            double r11 = (double) r6
            double r9 = java.lang.Math.pow(r11, r9)
            double r7 = r7 + r9
            double r6 = java.lang.Math.sqrt(r7)
            int r8 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r8 <= 0) goto L7c
            r1 = r6
        L7c:
            int r5 = r5 + 1
            goto L2d
        L7f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.mobilead.unified.base.view.u.c.a(com.vivo.ad.model.d):double");
    }

    public static int a(b bVar, int i2, com.vivo.ad.model.b bVar2, Context context, RelativeLayout relativeLayout, v vVar) {
        d b2;
        View findViewById;
        if (bVar2 == null || context == null || (b2 = bVar2.b()) == null || !b2.k() || vVar.e()) {
            return i2;
        }
        if (i2 != -1 && (findViewById = relativeLayout.findViewById(i2)) != null) {
            relativeLayout.removeView(findViewById);
        }
        View frameLayout = new FrameLayout(context);
        int generateViewId = View.generateViewId();
        frameLayout.setId(generateViewId);
        c cVar = new c(frameLayout, bVar2);
        n nVar = new n(context, bVar2, cVar);
        if (b2.f() != null) {
            cVar.b(r7.c());
        }
        frameLayout.setOnTouchListener(nVar);
        nVar.a(bVar);
        frameLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.addView(frameLayout);
        vVar.a(cVar);
        return generateViewId;
    }
}
