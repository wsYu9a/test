package com.vivo.ad.e;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.vivo.ad.e.d;
import com.vivo.ad.view.p;
import com.vivo.mobilead.util.m;
import com.vivo.mobilead.util.w0;
import com.vivo.mobilead.util.y0;

/* loaded from: classes4.dex */
public class e extends FrameLayout {

    /* renamed from: a */
    private boolean f26651a;

    /* renamed from: b */
    private boolean f26652b;

    /* renamed from: c */
    private DialogInterface.OnDismissListener f26653c;

    /* renamed from: d */
    private DialogInterface.OnShowListener f26654d;

    /* renamed from: e */
    private com.vivo.ad.model.b f26655e;

    /* renamed from: f */
    private String f26656f;

    /* renamed from: g */
    private com.vivo.ad.view.c f26657g;

    /* renamed from: h */
    private d.InterfaceC0555d f26658h;

    /* renamed from: i */
    private p.h f26659i;

    /* renamed from: j */
    private DialogInterface.OnShowListener f26660j;
    private DialogInterface.OnDismissListener k;
    private d.InterfaceC0555d l;

    class a implements DialogInterface.OnShowListener {

        /* renamed from: a */
        final /* synthetic */ g f26661a;

        a(g gVar) {
            this.f26661a = gVar;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            e.this.f26657g.setFeedbackIndicator("vivo_module_feedback_arrow_up.png");
            e.this.f26651a = true;
            DialogInterface.OnShowListener onShowListener = this.f26661a.f26675g;
            if (onShowListener != null) {
                onShowListener.onShow(dialogInterface);
            }
        }
    }

    class b implements DialogInterface.OnDismissListener {

        /* renamed from: a */
        final /* synthetic */ g f26663a;

        b(g gVar) {
            this.f26663a = gVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            e.this.f26657g.setFeedbackIndicator("vivo_module_feedback_arrow_down.png");
            e.this.f26651a = false;
            DialogInterface.OnDismissListener onDismissListener = this.f26663a.f26676h;
            if (onDismissListener != null) {
                onDismissListener.onDismiss(dialogInterface);
            }
        }
    }

    class c extends com.vivo.mobilead.g.c {
        c() {
        }

        @Override // com.vivo.mobilead.g.c
        public void a(View view) {
            if (e.this.getContext() instanceof Activity) {
                new d.c((Activity) e.this.getContext()).a(e.this.f26656f).a(e.this.f26655e).a(e.this.k).a(e.this.f26660j).a(e.this.l).a(e.this.f26659i).a(e.this.f26652b).a();
            }
        }
    }

    class d implements DialogInterface.OnShowListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            e.this.f26651a = true;
            if (e.this.f26654d != null) {
                e.this.f26654d.onShow(dialogInterface);
            }
        }
    }

    /* renamed from: com.vivo.ad.e.e$e */
    class DialogInterfaceOnDismissListenerC0556e implements DialogInterface.OnDismissListener {
        DialogInterfaceOnDismissListenerC0556e() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            e.this.f26651a = false;
            if (e.this.f26653c != null) {
                e.this.f26653c.onDismiss(dialogInterface);
            }
        }
    }

    class f implements d.InterfaceC0555d {
        f() {
        }

        @Override // com.vivo.ad.e.d.InterfaceC0555d
        public void a(String str, boolean z) {
            e eVar = e.this;
            eVar.f26652b = eVar.f26652b || z;
            if (e.this.f26658h != null) {
                e.this.f26658h.a(str, e.this.f26652b);
            }
        }
    }

    public static class g {

        /* renamed from: a */
        protected String f26669a;

        /* renamed from: b */
        protected String f26670b;

        /* renamed from: c */
        protected String f26671c;

        /* renamed from: d */
        protected com.vivo.ad.model.b f26672d;

        /* renamed from: e */
        protected Context f26673e;

        /* renamed from: f */
        protected String f26674f;

        /* renamed from: g */
        protected DialogInterface.OnShowListener f26675g;

        /* renamed from: h */
        protected DialogInterface.OnDismissListener f26676h;

        /* renamed from: i */
        protected int f26677i;

        /* renamed from: j */
        protected float[] f26678j;
        protected int k = 10;
        protected int l = -1;
        protected int m;
        protected int n;
        protected int o;
        protected int p;
        private d.InterfaceC0555d q;
        private p.h r;
        private boolean s;

        public g(Context context, String str, String str2, String str3) {
            this.f26673e = context;
            this.f26669a = str;
            this.f26670b = str2;
            this.f26671c = str3;
            c();
        }

        private void c() {
            this.m = m.b(this.f26673e, 5.0f);
            this.n = m.b(this.f26673e, 2.0f);
            this.o = m.b(this.f26673e, 5.0f);
            this.p = m.b(this.f26673e, 2.0f);
            this.f26677i = Color.parseColor("#80bbbbbb");
            float a2 = m.a(this.f26673e, 3.0f);
            this.f26678j = new float[]{a2, a2, a2, a2, a2, a2, a2, a2};
            w0.a(this.f26672d);
        }

        public g a(DialogInterface.OnShowListener onShowListener) {
            this.f26675g = onShowListener;
            return this;
        }

        public e b() {
            e eVar = new e(this.f26673e);
            eVar.a(this);
            return eVar;
        }

        public g a(DialogInterface.OnDismissListener onDismissListener) {
            this.f26676h = onDismissListener;
            return this;
        }

        public g a(d.InterfaceC0555d interfaceC0555d) {
            this.q = interfaceC0555d;
            return this;
        }

        public g a(p.h hVar) {
            this.r = hVar;
            return this;
        }

        public g a(boolean z) {
            this.s = z;
            return this;
        }

        public e a() {
            e eVar = new e(this.f26673e);
            eVar.a(this, this.f26669a, this.f26670b, this.f26671c);
            return eVar;
        }

        public g(Context context, com.vivo.ad.model.b bVar, String str) {
            this.f26673e = context;
            this.f26672d = bVar;
            this.f26674f = str;
            c();
        }
    }

    public e(@NonNull Context context) {
        super(context);
        this.f26652b = false;
        this.f26660j = new d();
        this.k = new DialogInterfaceOnDismissListenerC0556e();
        this.l = new f();
        b();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return super.generateDefaultLayoutParams();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
    }

    private void b() {
        setBackgroundColor(0);
    }

    public void a(g gVar, String str, String str2, String str3) {
        com.vivo.ad.view.c b2 = b(gVar);
        b2.a(com.vivo.mobilead.h.b.a().a(str), str2, str3, false);
        addView(b2);
    }

    private com.vivo.ad.view.c b(g gVar) {
        com.vivo.ad.view.c cVar = new com.vivo.ad.view.c(getContext());
        this.f26657g = cVar;
        cVar.a(gVar.k, gVar.l);
        this.f26657g.setPadding(gVar.m, gVar.n, gVar.o, gVar.p);
        this.f26657g.a(gVar.f26677i, gVar.f26678j);
        return this.f26657g;
    }

    public void a() {
        com.vivo.ad.view.c cVar = this.f26657g;
        if (cVar != null) {
            cVar.a();
            this.f26657g.setClickable(false);
        }
    }

    public void a(com.vivo.ad.model.b bVar, String str, DialogInterface.OnShowListener onShowListener, DialogInterface.OnDismissListener onDismissListener, d.InterfaceC0555d interfaceC0555d, boolean z, p.h hVar) {
        this.f26654d = onShowListener;
        this.f26653c = onDismissListener;
        this.f26655e = bVar;
        this.f26656f = str;
        this.f26658h = interfaceC0555d;
        this.f26659i = hVar;
        this.f26652b = z;
        setEnabled(true);
    }

    public void a(g gVar) {
        a(gVar, gVar.s);
    }

    public void a(g gVar, boolean z) {
        com.vivo.ad.model.b bVar;
        b(gVar);
        setId(y0.a());
        com.vivo.ad.model.b bVar2 = gVar.f26672d;
        com.vivo.ad.model.e c2 = (bVar2 == null || bVar2.c() == null) ? null : gVar.f26672d.c();
        boolean z2 = (c2 != null ? c2.B() : true) && (bVar = gVar.f26672d) != null && bVar.r() != null && gVar.f26672d.r().size() > 0;
        if (z2) {
            a(gVar.f26672d, gVar.f26674f, new a(gVar), new b(gVar), gVar.q, z, gVar.r);
        } else {
            a(null, null, null, null, null, false, null);
        }
        if (gVar.f26672d != null) {
            this.f26657g.a(com.vivo.mobilead.h.b.a().a(gVar.f26672d.e()), gVar.f26672d.k(), gVar.f26672d.O(), z2);
        }
        a(this.f26657g, z2);
    }

    public void a(View view, boolean z) {
        if (view != null) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            if (z) {
                view.setOnClickListener(new c());
            }
            removeAllViews();
            addView(view);
        }
    }
}
