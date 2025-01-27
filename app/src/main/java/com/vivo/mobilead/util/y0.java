package com.vivo.mobilead.util;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.opos.acs.st.utils.ErrorContants;
import com.vivo.ad.model.AdError;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class y0 {

    /* renamed from: a */
    private static final AtomicInteger f30793a = new AtomicInteger(1);

    static class a extends com.vivo.mobilead.util.f1.b {

        /* renamed from: a */
        final /* synthetic */ String f30794a;

        a(String str) {
            this.f30794a = str;
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            try {
                int intValue = ((Integer) a1.a(new com.vivo.mobilead.i.q(ErrorContants.NET_ERROR, this.f30794a, null)).get(800L, TimeUnit.MILLISECONDS)).intValue();
                x0.c(com.vivo.mobilead.util.f1.b.TAG, "fetch icon result = " + intValue);
                if (intValue == 0) {
                    x0.c(com.vivo.mobilead.util.f1.b.TAG, "fetch icon success!");
                } else {
                    x0.c(com.vivo.mobilead.util.f1.b.TAG, "fetch icon failed!");
                }
            } catch (Exception unused) {
                x0.c(com.vivo.mobilead.util.f1.b.TAG, "fetch icon failed!");
            }
        }
    }

    static class b extends com.vivo.mobilead.util.f1.b {

        /* renamed from: a */
        private boolean f30795a = false;

        /* renamed from: b */
        final /* synthetic */ com.vivo.ad.model.b f30796b;

        /* renamed from: c */
        final /* synthetic */ String f30797c;

        /* renamed from: d */
        final /* synthetic */ com.vivo.mobilead.i.m f30798d;

        /* renamed from: e */
        final /* synthetic */ long f30799e;

        /* renamed from: com.vivo.mobilead.util.y0$b$b */
        class C0673b extends com.vivo.mobilead.util.f1.b {
            C0673b() {
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                int[] iArr;
                String str;
                String str2;
                com.vivo.ad.model.b bVar = b.this.f30796b;
                if (bVar != null) {
                    String G = bVar.G();
                    String P = b.this.f30796b.P();
                    iArr = b.this.f30796b.J();
                    str2 = P;
                    str = G;
                } else {
                    iArr = null;
                    str = "";
                    str2 = str;
                }
                b.this.f30798d.a(new AdError(402110, "素材加载超时", str, str2, iArr));
            }
        }

        b(com.vivo.ad.model.b bVar, String str, com.vivo.mobilead.i.m mVar, long j2) {
            this.f30796b = bVar;
            this.f30797c = str;
            this.f30798d = mVar;
            this.f30799e = j2;
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            com.vivo.ad.model.b bVar = this.f30796b;
            try {
                a1.a(new com.vivo.mobilead.i.q(bVar != null ? bVar.d() : "", this.f30797c, new a())).get(this.f30799e, TimeUnit.MILLISECONDS);
            } catch (Exception unused) {
                x0.c(com.vivo.mobilead.util.f1.b.TAG, "fetch icon time out!");
                if (this.f30795a) {
                    return;
                }
                this.f30795a = true;
                z.b().a(new C0673b());
            }
        }

        class a implements com.vivo.mobilead.i.m {

            /* renamed from: com.vivo.mobilead.util.y0$b$a$a */
            class C0671a extends com.vivo.mobilead.util.f1.b {
                C0671a() {
                }

                @Override // com.vivo.mobilead.util.f1.b
                public void safelyRun() {
                    b.this.f30798d.a();
                }
            }

            /* renamed from: com.vivo.mobilead.util.y0$b$a$b */
            class C0672b extends com.vivo.mobilead.util.f1.b {

                /* renamed from: a */
                final /* synthetic */ AdError f30802a;

                C0672b(AdError adError) {
                    this.f30802a = adError;
                }

                @Override // com.vivo.mobilead.util.f1.b
                public void safelyRun() {
                    b.this.f30798d.a(this.f30802a);
                }
            }

            a() {
            }

            @Override // com.vivo.mobilead.i.m
            public void a() {
                if (b.this.f30795a) {
                    return;
                }
                b.this.f30795a = true;
                z.b().a(new C0671a());
            }

            @Override // com.vivo.mobilead.i.m
            public void a(AdError adError) {
                if (b.this.f30795a) {
                    return;
                }
                b.this.f30795a = true;
                z.b().a(new C0672b(adError));
            }
        }
    }

    static class c extends com.vivo.mobilead.util.f1.b {

        /* renamed from: a */
        final /* synthetic */ com.vivo.mobilead.i.m f30805a;

        c(com.vivo.mobilead.i.m mVar) {
            this.f30805a = mVar;
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            this.f30805a.a(new AdError(402122, "没有logo数据", null, null));
        }
    }

    static class d extends com.vivo.mobilead.util.f1.b {

        /* renamed from: a */
        final /* synthetic */ com.vivo.ad.model.b f30806a;

        /* renamed from: b */
        final /* synthetic */ com.vivo.mobilead.i.m f30807b;

        class a extends com.vivo.mobilead.util.f1.b {
            a() {
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                d.this.f30807b.a();
            }
        }

        class b extends com.vivo.mobilead.util.f1.b {
            b() {
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                AdError adError = new AdError(402122, "没有logo数据", d.this.f30806a.P(), d.this.f30806a.J());
                adError.setADID(d.this.f30806a.d());
                d.this.f30807b.a(adError);
            }
        }

        class c extends com.vivo.mobilead.util.f1.b {

            /* renamed from: a */
            final /* synthetic */ AdError f30810a;

            c(AdError adError) {
                this.f30810a = adError;
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                d.this.f30807b.a(this.f30810a);
            }
        }

        d(com.vivo.ad.model.b bVar, com.vivo.mobilead.i.m mVar) {
            this.f30806a = bVar;
            this.f30807b = mVar;
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            try {
                int intValue = ((Integer) a1.a(new com.vivo.mobilead.i.q(this.f30806a.d(), this.f30806a.e(), null)).get(800L, TimeUnit.MILLISECONDS)).intValue();
                x0.c(com.vivo.mobilead.util.f1.b.TAG, "fetchADMarkLogo result = " + intValue);
                if (this.f30807b != null) {
                    if (intValue == 0) {
                        z.b().a(new a());
                    } else {
                        z.b().a(new b());
                    }
                }
            } catch (Exception e2) {
                if (this.f30807b != null) {
                    AdError adError = new AdError(402122, "没有logo数据", this.f30806a.P(), this.f30806a.J());
                    adError.setADID(this.f30806a.d());
                    z.b().a(new c(adError));
                } else {
                    x0.b(com.vivo.mobilead.util.f1.b.TAG, "fetchADMarkLogo timeout, " + e2.getMessage());
                }
            }
        }
    }

    public static int a() {
        AtomicInteger atomicInteger;
        int i2;
        int i3;
        if (Build.VERSION.SDK_INT > 17) {
            return View.generateViewId();
        }
        do {
            atomicInteger = f30793a;
            i2 = atomicInteger.get();
            i3 = i2 + 1;
            if (i3 > 16777215) {
                i3 = 1;
            }
        } while (!atomicInteger.compareAndSet(i2, i3));
        return i2;
    }

    public static Drawable b(Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(m.a(context, 12.0f));
        gradientDrawable.setColor(Color.parseColor("#CD474747"));
        return gradientDrawable;
    }

    public static void b(com.vivo.ad.model.b bVar) {
        if (!TextUtils.isEmpty(bVar.L())) {
            a(bVar.L(), bVar);
        }
        com.vivo.ad.model.q y = bVar.y();
        if (y != null && !TextUtils.isEmpty(y.b())) {
            a(y.b(), bVar);
        }
        com.vivo.ad.model.u H = bVar.H();
        if (H != null && !TextUtils.isEmpty(H.b())) {
            a(H.b(), bVar);
        }
        com.vivo.ad.model.a0 Q = bVar.Q();
        if (Q != null && !TextUtils.isEmpty(Q.d())) {
            a(Q.d(), bVar);
        }
        if (TextUtils.isEmpty(bVar.e())) {
            return;
        }
        a(bVar.e(), bVar);
    }

    public static boolean a(View view, int i2) {
        if (view == null || !view.isAttachedToWindow() || !view.isShown()) {
            return false;
        }
        Rect rect = new Rect();
        view.getLocalVisibleRect(rect);
        int width = rect.width();
        int height = rect.height();
        return Math.round((((float) width) / ((float) view.getMeasuredWidth())) * 100.0f) > i2 && Math.round((((float) height) / ((float) view.getMeasuredHeight())) * 100.0f) > i2;
    }

    public static int a(View view) {
        if (view != null && view.isAttachedToWindow() && view.isShown()) {
            Rect rect = new Rect();
            if (!view.getLocalVisibleRect(rect)) {
                return 0;
            }
            int width = rect.width();
            int height = rect.height();
            float width2 = view.getWidth();
            float height2 = view.getHeight();
            if (width2 != 0.0f && height2 != 0.0f) {
                return Math.min(Math.round((width / width2) * 100.0f), Math.round((height / height2) * 100.0f));
            }
        }
        return 0;
    }

    public static Drawable a(Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(m.a(context, 16.0f));
        gradientDrawable.setColor(-1);
        return gradientDrawable;
    }

    public static void a(com.vivo.ad.model.b bVar) {
        com.vivo.ad.model.q y = bVar.y();
        if (y == null || TextUtils.isEmpty(y.b())) {
            return;
        }
        a(y.b(), bVar);
    }

    private static void a(String str, com.vivo.ad.model.b bVar) {
        if (bVar.s()) {
            com.vivo.mobilead.util.b1.a.b.b().a(str);
        } else {
            a1.e(new a(str));
        }
    }

    public static void a(com.vivo.ad.model.b bVar, String str, long j2, com.vivo.mobilead.i.m mVar) {
        if (TextUtils.isEmpty(str) || mVar == null) {
            return;
        }
        a1.e(new b(bVar, str, mVar, j2));
    }

    public static void a(com.vivo.ad.model.b bVar, com.vivo.mobilead.i.m mVar) {
        if (bVar != null && !TextUtils.isEmpty(bVar.e())) {
            a1.e(new d(bVar, mVar));
        } else if (mVar != null) {
            z.b().a(new c(mVar));
        }
    }

    public static void a(ViewGroup viewGroup) {
        View findViewWithTag;
        if (viewGroup == null || (findViewWithTag = viewGroup.findViewWithTag("feedback")) == null) {
            return;
        }
        viewGroup.removeView(findViewWithTag);
    }
}
