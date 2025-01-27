package com.vivo.ad.nativead;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.vivo.ad.model.AdError;
import com.vivo.ad.model.AppElement;
import com.vivo.ad.model.q;
import com.vivo.ad.view.IActionView;
import com.vivo.ad.view.k;
import com.vivo.ad.view.o;
import com.vivo.ad.view.p;
import com.vivo.ad.view.v;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.model.a;
import com.vivo.mobilead.nativead.NativeAdParams;
import com.vivo.mobilead.unified.base.view.NativeVideoView;
import com.vivo.mobilead.unified.base.view.VivoNativeAdContainer;
import com.vivo.mobilead.util.VOpenLog;
import com.vivo.mobilead.util.a1;
import com.vivo.mobilead.util.b0;
import com.vivo.mobilead.util.d0;
import com.vivo.mobilead.util.j;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.l0;
import com.vivo.mobilead.util.m;
import com.vivo.mobilead.util.n;
import com.vivo.mobilead.util.w;
import com.vivo.mobilead.util.x0;
import com.vivo.mobilead.util.y0;
import com.vivo.mobilead.util.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class c extends com.vivo.ad.nativead.a {
    private static final String t = "c";
    private com.vivo.ad.model.b o;
    private NativeAdParams p;
    private com.vivo.ad.view.e q;
    private o r;
    private boolean s;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.o != null) {
                boolean z = true;
                com.vivo.ad.model.d b2 = c.this.o.b();
                if (b2 != null && b2.l()) {
                    z = com.vivo.mobilead.h.b.a().e(b2.h());
                }
                if (z) {
                    return;
                }
                try {
                    new com.vivo.mobilead.i.b(new com.vivo.mobilead.i.a(b2.h(), null)).a();
                } catch (com.vivo.mobilead.i.c unused) {
                }
            }
        }
    }

    class b extends com.vivo.mobilead.util.f1.b {

        /* renamed from: a */
        final /* synthetic */ AdError f26964a;

        b(AdError adError) {
            this.f26964a = adError;
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            c cVar = c.this;
            cVar.n.onNoAD(cVar.a(cVar.o, this.f26964a));
        }
    }

    /* renamed from: com.vivo.ad.nativead.c$c */
    private class C0560c implements NativeResponse {

        /* renamed from: a */
        private View f26966a;

        /* renamed from: b */
        private com.vivo.ad.model.b f26967b;

        /* renamed from: e */
        private com.vivo.ad.model.f f26970e;

        /* renamed from: f */
        private int f26971f;

        /* renamed from: g */
        private int f26972g;

        /* renamed from: h */
        private int f26973h;

        /* renamed from: i */
        private int f26974i;
        private NativeAdListener n;
        private int o;
        private boolean p;
        private boolean q;
        private FrameLayout.LayoutParams r;
        private FrameLayout.LayoutParams s;

        /* renamed from: c */
        private boolean f26968c = false;

        /* renamed from: d */
        private boolean f26969d = false;

        /* renamed from: j */
        private int f26975j = -999;
        private int k = -999;
        private int l = -999;
        private int m = -999;
        private View.OnClickListener t = new a();
        private View.OnClickListener u = new b();
        private View.OnClickListener v = new ViewOnClickListenerC0561c();
        private View.OnTouchListener w = new d();
        private k x = new e();
        private ViewTreeObserver.OnPreDrawListener y = new f();

        /* renamed from: com.vivo.ad.nativead.c$c$a */
        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.vivo.mobilead.util.c.a(C0560c.this.f26967b)) {
                    C0560c.this.a(com.vivo.mobilead.util.e.b(C0560c.this.f26967b), 1, 0.0d, 0.0d);
                }
            }
        }

        /* renamed from: com.vivo.ad.nativead.c$c$b */
        class b implements View.OnClickListener {
            b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C0560c.this.a(com.vivo.mobilead.util.e.c(C0560c.this.f26967b), 2, 0.0d, 0.0d);
            }
        }

        /* renamed from: com.vivo.ad.nativead.c$c$c */
        class ViewOnClickListenerC0561c implements View.OnClickListener {
            ViewOnClickListenerC0561c() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.vivo.mobilead.util.c.d(C0560c.this.f26967b)) {
                    C0560c.this.a(com.vivo.mobilead.util.e.i(C0560c.this.f26967b), 3, 0.0d, 0.0d);
                }
            }
        }

        /* renamed from: com.vivo.ad.nativead.c$c$d */
        class d implements View.OnTouchListener {
            d() {
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 1) {
                    return false;
                }
                C0560c.this.f26971f = (int) motionEvent.getRawX();
                C0560c.this.f26972g = (int) motionEvent.getRawY();
                C0560c.this.f26973h = (int) motionEvent.getX();
                C0560c.this.f26974i = (int) motionEvent.getY();
                return false;
            }
        }

        /* renamed from: com.vivo.ad.nativead.c$c$e */
        class e implements k {
            e() {
            }

            @Override // com.vivo.ad.view.k
            public void a(View view, int i2, int i3, int i4, int i5, boolean z) {
                if (z || !com.vivo.mobilead.util.c.a(view, C0560c.this.f26967b)) {
                    C0560c.this.f26971f = i2;
                    C0560c.this.f26972g = i3;
                    C0560c.this.f26973h = i4;
                    C0560c.this.f26974i = i5;
                    C0560c.this.a(com.vivo.mobilead.util.e.a(view, C0560c.this.f26967b), z ? 2 : 1, 0.0d, 0.0d);
                }
            }
        }

        /* renamed from: com.vivo.ad.nativead.c$c$f */
        class f implements ViewTreeObserver.OnPreDrawListener {
            f() {
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (C0560c.this.f26966a != null && C0560c.this.f26966a.isShown()) {
                    if (C0560c.this.f26967b != null && C0560c.this.f26967b.m() == 2 && ((C0560c.this.o <= 0 || C0560c.this.o > C0560c.this.f26967b.D()) && !C0560c.this.q)) {
                        C0560c.this.q = true;
                        C0560c c0560c = C0560c.this;
                        NativeAdListener nativeAdListener = c.this.n;
                        if (nativeAdListener != null) {
                            nativeAdListener.onNoAD(new AdError(402136, "二价计费广告位，未传入价格或传入值无效", c0560c.f26967b.P(), C0560c.this.f26967b.J()));
                        }
                    }
                    C0560c c0560c2 = C0560c.this;
                    c0560c2.a(c0560c2.f26967b, 1, C0560c.this.o, 0);
                    try {
                        C0560c.this.f26966a.getViewTreeObserver().removeOnPreDrawListener(C0560c.this.y);
                    } catch (Exception e2) {
                        x0.b(c.t, "remove OnPreDrawListener failed: " + e2.getMessage());
                    }
                    C0560c.this.b();
                }
                return true;
            }
        }

        /* renamed from: com.vivo.ad.nativead.c$c$g */
        class g implements p.h {

            /* renamed from: a */
            final /* synthetic */ com.vivo.mobilead.unified.base.view.o f26982a;

            g(com.vivo.mobilead.unified.base.view.o oVar) {
                this.f26982a = oVar;
            }

            @Override // com.vivo.ad.view.p.h
            public void dismiss() {
                if (this.f26982a == null || !c.this.s) {
                    return;
                }
                this.f26982a.d();
            }

            @Override // com.vivo.ad.view.p.h
            public void onShow() {
                com.vivo.mobilead.unified.base.view.o oVar = this.f26982a;
                if (oVar != null) {
                    c.this.s = oVar.a();
                    this.f26982a.b();
                }
            }
        }

        /* renamed from: com.vivo.ad.nativead.c$c$h */
        class h implements DialogInterface.OnShowListener {

            /* renamed from: a */
            final /* synthetic */ com.vivo.mobilead.unified.base.view.o f26984a;

            h(com.vivo.mobilead.unified.base.view.o oVar) {
                this.f26984a = oVar;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                com.vivo.mobilead.unified.base.view.o oVar = this.f26984a;
                if (oVar != null) {
                    c.this.s = oVar.a();
                    this.f26984a.b();
                }
            }
        }

        /* renamed from: com.vivo.ad.nativead.c$c$i */
        class i implements DialogInterface.OnDismissListener {

            /* renamed from: a */
            final /* synthetic */ com.vivo.mobilead.unified.base.view.o f26986a;

            i(com.vivo.mobilead.unified.base.view.o oVar) {
                this.f26986a = oVar;
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (this.f26986a == null || !c.this.s) {
                    return;
                }
                this.f26986a.d();
            }
        }

        public C0560c(com.vivo.ad.model.b bVar, NativeAdListener nativeAdListener) {
            this.f26967b = bVar;
            if (bVar != null) {
                this.f26970e = bVar.f();
            }
            this.n = nativeAdListener;
        }

        @Override // com.vivo.ad.nativead.NativeResponse
        public void bindLogoView(FrameLayout.LayoutParams layoutParams) {
            this.s = layoutParams;
            if (c.this.q == null || this.s == null) {
                return;
            }
            c.this.q.setLayoutParams(this.s);
        }

        @Override // com.vivo.ad.nativead.NativeResponse
        public void bindPrivacyView(FrameLayout.LayoutParams layoutParams) {
            this.r = layoutParams;
            if (c.this.r == null || this.r == null) {
                return;
            }
            c.this.r.setLayoutParams(this.r);
        }

        @Override // com.vivo.ad.nativead.NativeResponse
        public int getAPPStatus() {
            com.vivo.ad.model.b bVar = this.f26967b;
            if (bVar == null) {
                return -1;
            }
            if (bVar.y() != null) {
                return j.b(((com.vivo.ad.a) c.this).f26535b, com.vivo.mobilead.util.d.b(this.f26967b)) ? 1 : 0;
            }
            return 2;
        }

        @Override // com.vivo.ad.nativead.NativeResponse
        public IActionView getActionView() {
            com.vivo.ad.model.b bVar;
            if (((com.vivo.ad.a) c.this).f26535b == null || (bVar = this.f26967b) == null || bVar.b() == null || !this.f26967b.b().i()) {
                return null;
            }
            View a2 = new v(((com.vivo.ad.a) c.this).f26535b, this.f26967b, null, null).a();
            if (a2 instanceof com.vivo.ad.view.h) {
                return new com.vivo.ad.view.d((com.vivo.ad.view.h) a2);
            }
            return null;
        }

        @Override // com.vivo.ad.nativead.NativeResponse
        public Bitmap getAdLogo() {
            return com.vivo.mobilead.util.g.a(((com.vivo.ad.a) c.this).f26535b, "vivo_module_biz_ui_splash_logo_img.png");
        }

        @Override // com.vivo.ad.nativead.NativeResponse
        public String getAdMarkText() {
            com.vivo.ad.model.b bVar = this.f26967b;
            return bVar != null ? bVar.k() : "";
        }

        @Override // com.vivo.ad.nativead.NativeResponse
        public String getAdMarkUrl() {
            com.vivo.ad.model.b bVar = this.f26967b;
            return bVar != null ? bVar.e() : "";
        }

        @Override // com.vivo.ad.nativead.NativeResponse
        public String getAdTag() {
            com.vivo.ad.model.b bVar = this.f26967b;
            return bVar != null ? bVar.O() : "";
        }

        @Override // com.vivo.ad.nativead.NativeResponse
        public int getAdType() {
            com.vivo.ad.model.b bVar = this.f26967b;
            if (bVar == null) {
                return -1;
            }
            int j2 = bVar.j();
            int i2 = 1;
            if (j2 != 1) {
                i2 = 8;
                if (j2 != 8) {
                    i2 = 9;
                    if (j2 != 9) {
                        return 2;
                    }
                }
            }
            return i2;
        }

        @Override // com.vivo.ad.nativead.NativeResponse
        public AppElement getAppMiitInfo() {
            com.vivo.ad.model.b bVar = this.f26967b;
            if (bVar == null || bVar.y() == null) {
                return null;
            }
            AppElement appElement = new AppElement();
            q y = this.f26967b.y();
            appElement.setSize(y.q());
            appElement.setName(y.d());
            appElement.setDeveloper(y.g());
            appElement.setPermissionList(y.n());
            appElement.setPrivacyPolicyUrl(y.o());
            appElement.setVersionName(y.s());
            return appElement;
        }

        @Override // com.vivo.ad.nativead.NativeResponse
        public String getDesc() {
            return com.vivo.mobilead.util.d.g(this.f26967b);
        }

        @Override // com.vivo.ad.nativead.NativeResponse
        public String getIconUrl() {
            com.vivo.ad.model.b bVar = this.f26967b;
            return bVar != null ? com.vivo.mobilead.util.d.c(bVar) : "";
        }

        @Override // com.vivo.ad.nativead.NativeResponse
        public int[] getImgDimensions() {
            com.vivo.ad.model.b bVar = this.f26967b;
            if (bVar == null || bVar.f() == null || TextUtils.isEmpty(this.f26967b.f().a()) || !this.f26967b.f().a().contains("*")) {
                return new int[]{0, 0};
            }
            String[] split = this.f26967b.f().a().split("\\*");
            return new int[]{d0.a(split[0]), d0.a(split[1])};
        }

        @Override // com.vivo.ad.nativead.NativeResponse
        public List<String> getImgUrl() {
            com.vivo.ad.model.f fVar = this.f26970e;
            return fVar != null ? fVar.b() : new ArrayList();
        }

        @Override // com.vivo.ad.nativead.NativeResponse
        public int getMaterialMode() {
            return b0.a(this.f26967b);
        }

        @Override // com.vivo.ad.nativead.NativeResponse, com.vivo.mobilead.unified.IBidding
        public int getPrice() {
            com.vivo.ad.model.b bVar = this.f26967b;
            if (bVar == null) {
                return -1;
            }
            if (bVar.m() == 0) {
                return -2;
            }
            return this.f26967b.D();
        }

        @Override // com.vivo.ad.nativead.NativeResponse, com.vivo.mobilead.unified.IBidding
        public String getPriceLevel() {
            com.vivo.ad.model.b bVar = this.f26967b;
            return (bVar == null || bVar.o() == null) ? "" : this.f26967b.o();
        }

        @Override // com.vivo.ad.nativead.NativeResponse
        public String getTitle() {
            return com.vivo.mobilead.util.d.h(this.f26967b);
        }

        @Override // com.vivo.ad.nativead.NativeResponse
        public void registerView(VivoNativeAdContainer vivoNativeAdContainer, View view, NativeVideoView nativeVideoView) {
            if (vivoNativeAdContainer == null) {
                return;
            }
            this.f26966a = vivoNativeAdContainer;
            vivoNativeAdContainer.getViewTreeObserver().addOnPreDrawListener(this.y);
            this.f26966a.setOnTouchListener(this.w);
            this.f26966a.setOnClickListener(this.t);
            if (view != null) {
                view.setOnTouchListener(this.w);
                view.setOnClickListener(this.u);
            }
            com.vivo.mobilead.unified.base.view.o oVar = null;
            if (nativeVideoView != null) {
                oVar = new com.vivo.mobilead.unified.base.view.o(vivoNativeAdContainer.getContext());
                oVar.setOnADWidgetClickListener(this.x);
                com.vivo.mobilead.nativead.h hVar = new com.vivo.mobilead.nativead.h();
                hVar.a(oVar);
                nativeVideoView.setView(oVar, hVar);
                oVar.a(this.f26967b, ((com.vivo.ad.a) c.this).f26537d, c.this.c());
                nativeVideoView.setOnTouchListener(this.w);
                nativeVideoView.setOnClickListener(this.v);
            }
            b(vivoNativeAdContainer, oVar);
            a(vivoNativeAdContainer, oVar);
        }

        @Override // com.vivo.ad.nativead.NativeResponse, com.vivo.mobilead.unified.IBidding
        public void sendLossNotification(int i2, int i3) {
            com.vivo.ad.model.b bVar = this.f26967b;
            if (bVar == null || bVar.m() == 0 || this.p) {
                return;
            }
            a(this.f26967b, 0, i3, i2);
        }

        @Override // com.vivo.ad.nativead.NativeResponse, com.vivo.mobilead.unified.IBidding
        public void sendWinNotification(int i2) {
            com.vivo.ad.model.b bVar = this.f26967b;
            if (bVar == null || bVar.m() == 0 || this.p) {
                return;
            }
            if (this.f26967b.m() == 2) {
                if (i2 <= 0 || i2 > this.f26967b.D()) {
                    VOpenLog.w(c.t, "Invalid value for parameter 'price'. Current is " + i2 + ".");
                    NativeAdListener nativeAdListener = c.this.n;
                    if (nativeAdListener != null) {
                        nativeAdListener.onNoAD(new AdError(402136, "二价计费广告位，未传入价格或传入值无效", null, null));
                    }
                } else {
                    this.o = i2;
                    this.f26967b.a(i2);
                }
            } else if (this.f26967b.m() == 1) {
                i2 = this.f26967b.D();
                com.vivo.ad.model.b bVar2 = this.f26967b;
                bVar2.a(bVar2.D());
            }
            a(this.f26967b, 1, i2, 0);
        }

        public void b() {
            a();
            c.this.a(this.f26967b, this.f26975j, this.k, this.l, this.m);
            if (this.f26968c) {
                return;
            }
            NativeAdListener nativeAdListener = this.n;
            if (nativeAdListener != null) {
                nativeAdListener.onAdShow(this);
            }
            c.this.a(this.f26967b, a.EnumC0603a.SHOW, -999, -999, -999, -999, this.f26975j, this.k, this.l, this.m);
            this.f26968c = true;
        }

        public void a(com.vivo.ad.model.b bVar, int i2, int i3, int i4) {
            if (this.p) {
                return;
            }
            this.p = true;
            k0.b(bVar, i2, i3, i4, ((com.vivo.ad.a) c.this).f26537d);
            k0.a(bVar, i2, i3, i4, ((com.vivo.ad.a) c.this).f26537d);
        }

        public void a(boolean z, int i2, double d2, double d3) {
            if (!this.f26968c) {
                w.d(this.f26967b, "3002001", String.valueOf(0));
                return;
            }
            com.vivo.ad.model.b bVar = this.f26967b;
            if (bVar != null) {
                c.this.a(bVar, z, i2 == 2);
                NativeAdListener nativeAdListener = c.this.n;
                if (nativeAdListener != null) {
                    nativeAdListener.onClick(this);
                }
                c.this.a(this.f26967b, z, i2, this.f26971f, this.f26972g, this.f26973h, this.f26974i, z);
                if (this.f26969d) {
                    return;
                }
                a();
                com.vivo.ad.model.w wVar = new com.vivo.ad.model.w(this.f26967b.b());
                wVar.a(d2);
                wVar.b(d3);
                c.this.a(this.f26967b, a.EnumC0603a.CLICK, this.f26971f, this.f26972g, this.f26973h, this.f26974i, wVar, this.f26975j, this.k, this.l, this.m);
                this.f26969d = true;
            }
        }

        private View b(VivoNativeAdContainer vivoNativeAdContainer, com.vivo.mobilead.unified.base.view.o oVar) {
            y0.a((ViewGroup) vivoNativeAdContainer);
            c.this.q = new com.vivo.ad.view.e(((com.vivo.ad.a) c.this).f26535b);
            c.this.q.a(this.f26967b, ((com.vivo.ad.a) c.this).f26537d, new h(oVar), new i(oVar));
            if (this.s == null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                this.s = layoutParams;
                layoutParams.gravity = 51;
            }
            c.this.q.setLayoutParams(this.s);
            vivoNativeAdContainer.addView(c.this.q);
            return c.this.q;
        }

        @Override // com.vivo.ad.nativead.NativeResponse
        public void registerView(VivoNativeAdContainer vivoNativeAdContainer, View view) {
            if (vivoNativeAdContainer == null) {
                return;
            }
            this.f26966a = vivoNativeAdContainer;
            vivoNativeAdContainer.getViewTreeObserver().addOnPreDrawListener(this.y);
            this.f26966a.setOnTouchListener(this.w);
            this.f26966a.setOnClickListener(this.t);
            if (view != null) {
                view.setOnTouchListener(this.w);
                view.setOnClickListener(this.u);
            }
            b(vivoNativeAdContainer, (com.vivo.mobilead.unified.base.view.o) null);
            a(vivoNativeAdContainer, (com.vivo.mobilead.unified.base.view.o) null);
        }

        private void a() {
            View view;
            if ((this.f26975j == -999 || this.k == -999 || this.l == -999 || this.m == -999) && (view = this.f26966a) != null) {
                int[] a2 = n.a(view);
                int[] b2 = n.b(this.f26966a);
                if (a2 != null && a2.length >= 2) {
                    this.f26975j = a2[0];
                    this.k = a2[1];
                }
                if (b2 == null || b2.length < 2) {
                    return;
                }
                this.l = b2[0];
                this.m = b2[1];
            }
        }

        private void a(VivoNativeAdContainer vivoNativeAdContainer, com.vivo.mobilead.unified.base.view.o oVar) {
            if (c.this.p.getmIsUsePrivacyAndPermission() && com.vivo.mobilead.util.q.a(this.f26967b)) {
                c.this.r = new o(((com.vivo.ad.a) c.this).f26535b);
                c.this.r.setDialogListener(new g(oVar));
                c.this.r.a(this.f26967b, c.this.p == null ? "" : c.this.p.getSourceAppend());
                if (this.r == null) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    this.r = layoutParams;
                    layoutParams.leftMargin = m.b(((com.vivo.ad.a) c.this).f26535b, 10.0f);
                    this.r.bottomMargin = m.b(((com.vivo.ad.a) c.this).f26535b, 8.0f);
                    this.r.gravity = 85;
                }
                c.this.r.setLayoutParams(this.r);
                vivoNativeAdContainer.addView(c.this.r);
            }
        }
    }

    public c(Context context, NativeAdParams nativeAdParams, NativeAdListener nativeAdListener) {
        super(context, nativeAdParams, nativeAdListener);
        this.s = true;
        this.p = nativeAdParams;
    }

    @Override // com.vivo.ad.a
    protected int b() {
        return 2;
    }

    @Override // com.vivo.ad.nativead.a
    public void e() {
        a(5);
    }

    protected void f() {
        a1.e(new a());
    }

    @Override // com.vivo.ad.a
    protected void a(List<com.vivo.ad.model.b> list) {
        if (list != null && list.size() != 0) {
            this.o = list.get(0);
            f();
            this.o.a().a(2);
            a(this.o, a.EnumC0603a.LOADED);
            k0.a(list, 1, 0, c.a.f28912a.intValue(), this.f26538e, this.f26536c, this.f26537d, c(), d(), 2);
            ArrayList arrayList = new ArrayList();
            Iterator<com.vivo.ad.model.b> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new C0560c(it.next(), this.n));
            }
            this.n.onADLoaded(arrayList);
            com.vivo.mobilead.g.b bVar = this.f26543j;
            if (bVar != null) {
                bVar.a(new l0().a(this.o.J()).c(this.o.G()).a(true).b(this.o.d()).d(this.o.P()).a(c.a.f28912a).a(list.size()));
            }
            y0.a(this.o);
            return;
        }
        a(new AdError(40218, "没有广告，建议过一会儿重试", null, null));
    }

    @Override // com.vivo.ad.a
    protected void a(AdError adError) {
        String str;
        String str2;
        int[] iArr;
        x0.a(t, "fetchADFailure");
        a(adError, 1, 2);
        z.b().a(new b(adError));
        if (this.f26543j != null) {
            int i2 = 40215;
            String str3 = null;
            if (adError != null) {
                String errorMsg = adError.getErrorMsg();
                int errorCode = adError.getErrorCode();
                String token = adError.getToken();
                iArr = adError.getShowPriority();
                str2 = adError.getRequestId();
                str = errorMsg;
                i2 = errorCode;
                str3 = token;
            } else {
                str = "未知情况下导致的错误，请联系广告SDK对接人员处理";
                str2 = null;
                iArr = null;
            }
            this.f26543j.a(new l0().a(c.a.f28912a).d(str3).c(str2).a(iArr).a(false).b(i2).a(str));
        }
    }
}
