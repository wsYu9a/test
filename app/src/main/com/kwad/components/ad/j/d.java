package com.kwad.components.ad.j;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.ay;
import com.kwad.components.core.webview.jshandler.y;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.a.o;
import com.kwad.components.core.webview.tachikoma.a.p;
import com.kwad.components.core.webview.tachikoma.b.m;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.components.core.webview.tachikoma.i;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.s;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: classes2.dex */
public final class d extends KSFrameLayout implements j, com.kwad.sdk.core.h.c {
    public static String pq = "PUSH_VIEW_TAG";

    /* renamed from: dh */
    private final com.kwad.components.core.widget.a.b f11643dh;

    /* renamed from: ed */
    private ay f11644ed;
    private i hw;
    private AdTemplate pr;
    private com.kwad.components.ad.b.a.b ps;
    private boolean pt;
    private ViewGroup pu;
    private boolean pv;

    /* renamed from: com.kwad.components.ad.j.d$1 */
    public class AnonymousClass1 extends i {

        /* renamed from: com.kwad.components.ad.j.d$1$1 */
        public class C03861 extends y {
            public C03861(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, com.kwad.sdk.core.webview.d.a.a aVar) {
                super(bVar, cVar, aVar);
            }

            @Override // com.kwad.components.core.webview.jshandler.y
            public final void L(int i10) {
                super.L(i10);
                if (i10 == 3) {
                    d.this.a((WebCloseStatus) null);
                }
            }
        }

        public AnonymousClass1(long j10, Context context) {
            super(-1L, context);
        }

        @Override // com.kwad.components.core.webview.tachikoma.i
        public final void a(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, s sVar, ViewGroup viewGroup) {
            super.a(bVar, cVar, sVar, viewGroup);
            sVar.c(new y(bVar, cVar, this) { // from class: com.kwad.components.ad.j.d.1.1
                public C03861(com.kwad.sdk.core.webview.b bVar2, com.kwad.components.core.e.d.c cVar2, com.kwad.sdk.core.webview.d.a.a this) {
                    super(bVar2, cVar2, this);
                }

                @Override // com.kwad.components.core.webview.jshandler.y
                public final void L(int i10) {
                    super.L(i10);
                    if (i10 == 3) {
                        d.this.a((WebCloseStatus) null);
                    }
                }
            });
        }
    }

    /* renamed from: com.kwad.components.ad.j.d$2 */
    public class AnonymousClass2 extends com.kwad.sdk.core.c.d {
        final /* synthetic */ Activity py;

        public AnonymousClass2(Activity activity) {
            currentActivity = activity;
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityDestroyed */
        public final void b(Activity activity) {
            super.b(activity);
            com.kwad.sdk.core.c.b.Fi();
            com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
            if (activity.equals(currentActivity)) {
                d.this.fk();
            }
        }
    }

    public d(@NonNull Context context, AdTemplate adTemplate) {
        super(context);
        this.pt = false;
        setTag(pq);
        this.pr = adTemplate;
        this.f11643dh = new com.kwad.components.core.widget.a.b(this, 100);
        this.hw = new i(-1L, getContext()) { // from class: com.kwad.components.ad.j.d.1

            /* renamed from: com.kwad.components.ad.j.d$1$1 */
            public class C03861 extends y {
                public C03861(com.kwad.sdk.core.webview.b bVar2, com.kwad.components.core.e.d.c cVar2, com.kwad.sdk.core.webview.d.a.a this) {
                    super(bVar2, cVar2, this);
                }

                @Override // com.kwad.components.core.webview.jshandler.y
                public final void L(int i10) {
                    super.L(i10);
                    if (i10 == 3) {
                        d.this.a((WebCloseStatus) null);
                    }
                }
            }

            public AnonymousClass1(long j10, Context context2) {
                super(-1L, context2);
            }

            @Override // com.kwad.components.core.webview.tachikoma.i
            public final void a(com.kwad.sdk.core.webview.b bVar2, com.kwad.components.core.e.d.c cVar2, s sVar, ViewGroup viewGroup) {
                super.a(bVar2, cVar2, sVar, viewGroup);
                sVar.c(new y(bVar2, cVar2, this) { // from class: com.kwad.components.ad.j.d.1.1
                    public C03861(com.kwad.sdk.core.webview.b bVar22, com.kwad.components.core.e.d.c cVar22, com.kwad.sdk.core.webview.d.a.a this) {
                        super(bVar22, cVar22, this);
                    }

                    @Override // com.kwad.components.core.webview.jshandler.y
                    public final void L(int i10) {
                        super.L(i10);
                        if (i10 == 3) {
                            d.this.a((WebCloseStatus) null);
                        }
                    }
                });
            }
        };
        this.hw.a((Activity) null, com.kwad.sdk.core.response.b.c.dM(this.pr), this);
    }

    private void destroy() {
        this.hw.jK();
        ViewGroup viewGroup = this.pu;
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this);
        }
    }

    public void fk() {
        if (this.pv) {
            return;
        }
        this.pv = true;
        fn();
        destroy();
    }

    private void fl() {
        com.kwad.components.ad.b.a.b bVar = this.ps;
        if (bVar != null) {
            bVar.T();
        }
        ay ayVar = this.f11644ed;
        if (ayVar != null) {
            ayVar.tu();
            this.f11644ed.tv();
        }
    }

    private void fn() {
        com.kwad.components.ad.b.a.b bVar = this.ps;
        if (bVar != null) {
            bVar.U();
        }
        ay ayVar = this.f11644ed;
        if (ayVar != null) {
            ayVar.tw();
            this.f11644ed.tx();
        }
    }

    private boolean fo() {
        try {
            com.kwad.sdk.core.c.b.Fi();
            Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
            if (currentActivity != null && !currentActivity.isFinishing()) {
                View findViewById = currentActivity.getWindow().getDecorView().findViewById(R.id.content);
                if (!(findViewById instanceof ViewGroup)) {
                    return false;
                }
                this.pu = (ViewGroup) findViewById;
                this.pu.addView(this, new ViewGroup.LayoutParams(-1, -1));
                com.kwad.sdk.core.c.b.Fi();
                com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.ad.j.d.2
                    final /* synthetic */ Activity py;

                    public AnonymousClass2(Activity currentActivity2) {
                        currentActivity = currentActivity2;
                    }

                    @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                    /* renamed from: onActivityDestroyed */
                    public final void b(Activity activity) {
                        super.b(activity);
                        com.kwad.sdk.core.c.b.Fi();
                        com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
                        if (activity.equals(currentActivity)) {
                            d.this.fk();
                        }
                    }
                });
                return true;
            }
            return false;
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTrace(th2);
            return false;
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void Z() {
        super.Z();
        this.f11643dh.a(this);
        this.f11643dh.uE();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(a.C0448a c0448a) {
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void aa() {
        super.aa();
        this.f11643dh.release();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void ay() {
        com.kwad.sdk.core.d.c.d("PushAdView", "onTkLoadSuccess");
        this.pt = true;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void az() {
    }

    @Override // com.kwad.sdk.core.h.c
    public final void bl() {
        com.kwad.sdk.core.d.c.d("PushAdView", "onPageVisible: ");
        ay ayVar = this.f11644ed;
        if (ayVar != null) {
            ayVar.ty();
        }
    }

    @Override // com.kwad.sdk.core.h.c
    public final void bm() {
        com.kwad.sdk.core.d.c.d("PushAdView", "onPageInvisible: ");
        ay ayVar = this.f11644ed;
        if (ayVar != null) {
            ayVar.tz();
        }
    }

    public final boolean c(com.kwad.components.ad.b.a.b bVar) {
        this.ps = bVar;
        if (!this.pt || !fo()) {
            return false;
        }
        fl();
        return true;
    }

    public final boolean fm() {
        return this.pt;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_push_ad";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.dJ(this.pr);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final com.kwad.sdk.widget.e getTouchCoordsView() {
        return this;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(m mVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(s sVar, com.kwad.sdk.core.webview.b bVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        com.kwad.sdk.core.d.c.d("PushAdView", "onTkLoadFailed");
        this.pt = false;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
        com.kwad.sdk.core.d.c.d("PushAdView", "onAdClicked");
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ad.a aVar) {
        float ba2 = com.kwad.sdk.c.a.a.ba(getContext());
        float screenHeight = com.kwad.sdk.c.a.a.getScreenHeight(getContext());
        aVar.width = (int) ((com.kwad.sdk.c.a.a.getScreenWidth(getContext()) / ba2) + 0.5f);
        aVar.height = (int) ((screenHeight / ba2) + 0.5f);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ay ayVar) {
        this.f11644ed = ayVar;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable WebCloseStatus webCloseStatus) {
        fk();
    }
}
