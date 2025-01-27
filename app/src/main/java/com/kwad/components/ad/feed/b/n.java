package com.kwad.components.ad.feed.b;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.feed.d;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.j.a;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.ay;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.webview.jshandler.w;
import com.kwad.components.core.webview.jshandler.y;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.a.o;
import com.kwad.components.core.webview.tachikoma.a.p;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.components.core.webview.tachikoma.b.x;
import com.kwad.components.core.widget.b;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.s;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.widget.KSFrameLayout;
import com.tencent.bugly.beta.tinker.TinkerReport;

/* loaded from: classes2.dex */
public final class n extends com.kwad.components.core.widget.b<AdResultData, AdTemplate> implements com.kwad.sdk.widget.c {
    private KsAdVideoPlayConfig bS;
    private o cV;
    private d.b fC;
    private d.InterfaceC0369d fD;
    private long fQ;
    private float fR;
    private float fS;
    private a.b gr;
    private a hA;

    /* renamed from: hb */
    private com.kwad.components.core.widget.b f11499hb;

    /* renamed from: hc */
    private boolean f11500hc;
    private b.a hm;
    private com.kwad.components.core.webview.tachikoma.i hw;
    private KSFrameLayout hx;
    private ay hy;
    private com.kwad.sdk.core.webview.c.c hz;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private int mHeight;
    private boolean mIsNative;
    private int mWidth;

    /* renamed from: com.kwad.components.ad.feed.b.n$1 */
    public class AnonymousClass1 extends com.kwad.sdk.core.c.d {
        final /* synthetic */ Context hB;

        public AnonymousClass1(Context context) {
            context = context;
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityDestroyed */
        public final void b(@NonNull Activity activity) {
            Context context = context;
            if ((context instanceof Activity) && context.equals(activity)) {
                if (n.this.hw != null) {
                    n.this.hw.jK();
                }
                if (n.this.hy != null) {
                    n.this.hy.onDestroy();
                }
                com.kwad.sdk.core.c.b.Fi();
                com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.feed.b.n$2 */
    public class AnonymousClass2 implements com.kwad.components.core.webview.tachikoma.j {

        /* renamed from: com.kwad.components.ad.feed.b.n$2$1 */
        public class AnonymousClass1 extends com.kwad.components.core.webview.tachikoma.a.n {
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.a.w, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                n.this.hz = cVar;
                n.this.cc();
            }
        }

        /* renamed from: com.kwad.components.ad.feed.b.n$2$2 */
        public class C03672 extends w {
            public C03672() {
            }

            @Override // com.kwad.components.core.webview.jshandler.w
            public final void a(x xVar) {
                super.a(xVar);
                if (com.kwad.components.core.s.a.av(n.this.mContext).sa() && n.this.cV != null) {
                    com.kwad.components.core.webview.tachikoma.b.m mVar = new com.kwad.components.core.webview.tachikoma.b.m();
                    mVar.adu = true;
                    n.this.cV.c(mVar);
                }
                com.kwad.components.core.j.a.pv().a(n.this.getCurrentVoiceItem());
                com.kwad.components.ad.feed.monitor.b.a(n.this.mAdTemplate, 1, 1, com.kwad.sdk.core.response.b.a.K(n.this.mAdInfo), null, SystemClock.elapsedRealtime() - n.this.fQ);
            }

            @Override // com.kwad.components.core.webview.jshandler.w
            public final void b(x xVar) {
                super.b(xVar);
                com.kwad.components.ad.feed.monitor.b.a(n.this.mAdTemplate, 2, 1, com.kwad.sdk.core.response.b.a.K(n.this.mAdInfo), xVar.errorReason, SystemClock.elapsedRealtime() - n.this.fQ);
                com.kwad.components.core.o.a.ri().d(n.this.mAdTemplate, xVar.errorCode, xVar.ub());
            }

            @Override // com.kwad.components.core.webview.jshandler.w
            public final void c(x xVar) {
                super.c(xVar);
                com.kwad.components.core.j.a.pv().c(n.this.gr);
            }
        }

        /* renamed from: com.kwad.components.ad.feed.b.n$2$3 */
        public class AnonymousClass3 implements ba.a {
            public AnonymousClass3() {
            }

            @Override // com.kwad.components.core.webview.jshandler.ba.a
            public final void ca() {
                n.this.bU();
            }
        }

        /* renamed from: com.kwad.components.ad.feed.b.n$2$4 */
        public class AnonymousClass4 implements aw.b {
            public AnonymousClass4() {
            }

            @Override // com.kwad.components.core.webview.jshandler.aw.b
            public final void c(com.kwad.components.core.webview.tachikoma.e.d dVar) {
                n.this.a(dVar);
            }

            @Override // com.kwad.components.core.webview.jshandler.aw.b
            public final void d(com.kwad.components.core.webview.tachikoma.e.d dVar) {
                n.this.b(dVar);
            }

            @Override // com.kwad.components.core.webview.jshandler.aw.b
            public final void e(com.kwad.components.core.webview.tachikoma.e.d dVar) {
                n.this.a(dVar);
                n.this.b(dVar);
            }
        }

        /* renamed from: com.kwad.components.ad.feed.b.n$2$5 */
        public class AnonymousClass5 implements o.a {
            public AnonymousClass5() {
            }

            /* JADX WARN: Code restructure failed: missing block: B:14:0x0033, code lost:
            
                if (com.kwad.components.core.j.a.b(com.kwad.components.ad.feed.b.n.this.gr) == false) goto L47;
             */
            /* JADX WARN: Removed duplicated region for block: B:8:0x007b  */
            @Override // com.kwad.components.core.webview.tachikoma.a.o.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final boolean isMuted() {
                /*
                    r3 = this;
                    boolean r0 = com.kwad.sdk.core.config.d.gN()
                    r1 = 1
                    if (r0 != 0) goto L1a
                    com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                    com.kwad.components.ad.feed.b.n r0 = com.kwad.components.ad.feed.b.n.this
                    android.content.Context r0 = com.kwad.components.ad.feed.b.n.A(r0)
                    com.kwad.components.core.s.a r0 = com.kwad.components.core.s.a.av(r0)
                    boolean r0 = r0.sa()
                    if (r0 == 0) goto L1a
                    goto L70
                L1a:
                    com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                    com.kwad.components.ad.feed.b.n r0 = com.kwad.components.ad.feed.b.n.this
                    com.kwad.components.core.j.a$b r0 = com.kwad.components.ad.feed.b.n.r(r0)
                    if (r0 == 0) goto L36
                    com.kwad.components.core.j.a.pv()
                    com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                    com.kwad.components.ad.feed.b.n r0 = com.kwad.components.ad.feed.b.n.this
                    com.kwad.components.core.j.a$b r0 = com.kwad.components.ad.feed.b.n.r(r0)
                    boolean r0 = com.kwad.components.core.j.a.b(r0)
                    if (r0 != 0) goto L36
                    goto L70
                L36:
                    com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                    com.kwad.components.ad.feed.b.n r0 = com.kwad.components.ad.feed.b.n.this
                    com.kwad.sdk.api.KsAdVideoPlayConfig r0 = com.kwad.components.ad.feed.b.n.B(r0)
                    boolean r0 = r0 instanceof com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl
                    if (r0 == 0) goto L60
                    com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                    com.kwad.components.ad.feed.b.n r0 = com.kwad.components.ad.feed.b.n.this
                    com.kwad.sdk.api.KsAdVideoPlayConfig r0 = com.kwad.components.ad.feed.b.n.B(r0)
                    com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl r0 = (com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl) r0
                    int r0 = r0.getVideoSoundValue()
                    if (r0 == 0) goto L60
                    com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                    com.kwad.components.ad.feed.b.n r0 = com.kwad.components.ad.feed.b.n.this
                    com.kwad.sdk.api.KsAdVideoPlayConfig r0 = com.kwad.components.ad.feed.b.n.B(r0)
                    boolean r0 = r0.isVideoSoundEnable()
                    r0 = r0 ^ r1
                    goto L71
                L60:
                    com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                    com.kwad.components.ad.feed.b.n r0 = com.kwad.components.ad.feed.b.n.this
                    com.kwad.sdk.core.response.model.AdInfo r0 = com.kwad.components.ad.feed.b.n.C(r0)
                    boolean r0 = com.kwad.sdk.core.response.b.a.bZ(r0)
                    if (r0 != 0) goto L6f
                    goto L70
                L6f:
                    r1 = 0
                L70:
                    r0 = r1
                L71:
                    com.kwad.components.ad.feed.b.n$2 r1 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                    com.kwad.components.ad.feed.b.n r1 = com.kwad.components.ad.feed.b.n.this
                    com.kwad.sdk.core.response.model.AdTemplate r1 = com.kwad.components.ad.feed.b.n.D(r1)
                    if (r1 == 0) goto L87
                    com.kwad.components.ad.feed.b.n$2 r1 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                    com.kwad.components.ad.feed.b.n r1 = com.kwad.components.ad.feed.b.n.this
                    com.kwad.sdk.core.response.model.AdTemplate r1 = com.kwad.components.ad.feed.b.n.E(r1)
                    r2 = r0 ^ 1
                    r1.mIsAudioEnable = r2
                L87:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.feed.b.n.AnonymousClass2.AnonymousClass5.isMuted():boolean");
            }
        }

        /* renamed from: com.kwad.components.ad.feed.b.n$2$6 */
        public class AnonymousClass6 extends bd {
            public AnonymousClass6() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                n.this.us();
            }
        }

        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.j
        public final void a(p pVar) {
        }

        @Override // com.kwad.components.core.webview.tachikoma.j
        public final void ay() {
            if (n.this.hA != null) {
                n.this.hA.d(3, "");
            }
        }

        @Override // com.kwad.components.core.webview.tachikoma.j
        public final void az() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.j
        public final FrameLayout getTKContainer() {
            return n.this.hx;
        }

        @Override // com.kwad.components.core.webview.tachikoma.j
        public final String getTKReaderScene() {
            return "tk_feed_tk_card";
        }

        @Override // com.kwad.components.core.webview.tachikoma.j
        public final String getTkTemplateId() {
            return com.kwad.sdk.core.response.b.b.dL(n.this.mAdTemplate);
        }

        @Override // com.kwad.components.core.webview.tachikoma.j
        public final com.kwad.sdk.widget.e getTouchCoordsView() {
            return null;
        }

        @Override // com.kwad.components.core.webview.tachikoma.j
        public final void a(com.kwad.components.core.webview.tachikoma.b.m mVar) {
        }

        @Override // com.kwad.components.core.webview.tachikoma.j
        public final void a(t tVar) {
        }

        @Override // com.kwad.components.core.webview.tachikoma.j
        public final void a(TKRenderFailReason tKRenderFailReason) {
            n.this.cd();
        }

        @Override // com.kwad.components.core.webview.tachikoma.j
        public final void a(s sVar, com.kwad.sdk.core.webview.b bVar) {
            sVar.c(new y(bVar, n.this.mApkDownloadHelper, (com.kwad.sdk.core.webview.d.a.a) n.this.hw, true));
            sVar.c(new com.kwad.components.core.webview.tachikoma.a.n() { // from class: com.kwad.components.ad.feed.b.n.2.1
                public AnonymousClass1() {
                }

                @Override // com.kwad.components.core.webview.tachikoma.a.w, com.kwad.sdk.core.webview.c.a
                public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                    super.a(str, cVar);
                    n.this.hz = cVar;
                    n.this.cc();
                }
            });
            sVar.c(new w() { // from class: com.kwad.components.ad.feed.b.n.2.2
                public C03672() {
                }

                @Override // com.kwad.components.core.webview.jshandler.w
                public final void a(x xVar) {
                    super.a(xVar);
                    if (com.kwad.components.core.s.a.av(n.this.mContext).sa() && n.this.cV != null) {
                        com.kwad.components.core.webview.tachikoma.b.m mVar = new com.kwad.components.core.webview.tachikoma.b.m();
                        mVar.adu = true;
                        n.this.cV.c(mVar);
                    }
                    com.kwad.components.core.j.a.pv().a(n.this.getCurrentVoiceItem());
                    com.kwad.components.ad.feed.monitor.b.a(n.this.mAdTemplate, 1, 1, com.kwad.sdk.core.response.b.a.K(n.this.mAdInfo), null, SystemClock.elapsedRealtime() - n.this.fQ);
                }

                @Override // com.kwad.components.core.webview.jshandler.w
                public final void b(x xVar) {
                    super.b(xVar);
                    com.kwad.components.ad.feed.monitor.b.a(n.this.mAdTemplate, 2, 1, com.kwad.sdk.core.response.b.a.K(n.this.mAdInfo), xVar.errorReason, SystemClock.elapsedRealtime() - n.this.fQ);
                    com.kwad.components.core.o.a.ri().d(n.this.mAdTemplate, xVar.errorCode, xVar.ub());
                }

                @Override // com.kwad.components.core.webview.jshandler.w
                public final void c(x xVar) {
                    super.c(xVar);
                    com.kwad.components.core.j.a.pv().c(n.this.gr);
                }
            });
            ba baVar = new ba(new ba.a() { // from class: com.kwad.components.ad.feed.b.n.2.3
                public AnonymousClass3() {
                }

                @Override // com.kwad.components.core.webview.jshandler.ba.a
                public final void ca() {
                    n.this.bU();
                }
            });
            aw awVar = new aw(new aw.b() { // from class: com.kwad.components.ad.feed.b.n.2.4
                public AnonymousClass4() {
                }

                @Override // com.kwad.components.core.webview.jshandler.aw.b
                public final void c(com.kwad.components.core.webview.tachikoma.e.d dVar) {
                    n.this.a(dVar);
                }

                @Override // com.kwad.components.core.webview.jshandler.aw.b
                public final void d(com.kwad.components.core.webview.tachikoma.e.d dVar) {
                    n.this.b(dVar);
                }

                @Override // com.kwad.components.core.webview.jshandler.aw.b
                public final void e(com.kwad.components.core.webview.tachikoma.e.d dVar) {
                    n.this.a(dVar);
                    n.this.b(dVar);
                }
            });
            sVar.c(baVar);
            sVar.c(awVar);
        }

        @Override // com.kwad.components.core.webview.tachikoma.j
        public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
            if (n.this.aer != null) {
                n.this.aer.onAdClicked();
            }
            n.this.bV();
        }

        @Override // com.kwad.components.core.webview.tachikoma.j
        public final void a(ad.a aVar) {
            aVar.width = com.kwad.sdk.c.a.a.px2dip(n.this.mContext, n.this.mWidth);
            aVar.height = com.kwad.sdk.c.a.a.px2dip(n.this.mContext, n.this.mHeight);
        }

        @Override // com.kwad.components.core.webview.tachikoma.j
        public final void a(o oVar) {
            n.this.cV = oVar;
            n.this.cV.a(new o.a() { // from class: com.kwad.components.ad.feed.b.n.2.5
                public AnonymousClass5() {
                }

                @Override // com.kwad.components.core.webview.tachikoma.a.o.a
                public final boolean isMuted() {
                    /*
                        this = this;
                        boolean r0 = com.kwad.sdk.core.config.d.gN()
                        r1 = 1
                        if (r0 != 0) goto L1a
                        com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                        com.kwad.components.ad.feed.b.n r0 = com.kwad.components.ad.feed.b.n.this
                        android.content.Context r0 = com.kwad.components.ad.feed.b.n.A(r0)
                        com.kwad.components.core.s.a r0 = com.kwad.components.core.s.a.av(r0)
                        boolean r0 = r0.sa()
                        if (r0 == 0) goto L1a
                        goto L70
                    L1a:
                        com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                        com.kwad.components.ad.feed.b.n r0 = com.kwad.components.ad.feed.b.n.this
                        com.kwad.components.core.j.a$b r0 = com.kwad.components.ad.feed.b.n.r(r0)
                        if (r0 == 0) goto L36
                        com.kwad.components.core.j.a.pv()
                        com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                        com.kwad.components.ad.feed.b.n r0 = com.kwad.components.ad.feed.b.n.this
                        com.kwad.components.core.j.a$b r0 = com.kwad.components.ad.feed.b.n.r(r0)
                        boolean r0 = com.kwad.components.core.j.a.b(r0)
                        if (r0 != 0) goto L36
                        goto L70
                    L36:
                        com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                        com.kwad.components.ad.feed.b.n r0 = com.kwad.components.ad.feed.b.n.this
                        com.kwad.sdk.api.KsAdVideoPlayConfig r0 = com.kwad.components.ad.feed.b.n.B(r0)
                        boolean r0 = r0 instanceof com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl
                        if (r0 == 0) goto L60
                        com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                        com.kwad.components.ad.feed.b.n r0 = com.kwad.components.ad.feed.b.n.this
                        com.kwad.sdk.api.KsAdVideoPlayConfig r0 = com.kwad.components.ad.feed.b.n.B(r0)
                        com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl r0 = (com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl) r0
                        int r0 = r0.getVideoSoundValue()
                        if (r0 == 0) goto L60
                        com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                        com.kwad.components.ad.feed.b.n r0 = com.kwad.components.ad.feed.b.n.this
                        com.kwad.sdk.api.KsAdVideoPlayConfig r0 = com.kwad.components.ad.feed.b.n.B(r0)
                        boolean r0 = r0.isVideoSoundEnable()
                        r0 = r0 ^ r1
                        goto L71
                    L60:
                        com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                        com.kwad.components.ad.feed.b.n r0 = com.kwad.components.ad.feed.b.n.this
                        com.kwad.sdk.core.response.model.AdInfo r0 = com.kwad.components.ad.feed.b.n.C(r0)
                        boolean r0 = com.kwad.sdk.core.response.b.a.bZ(r0)
                        if (r0 != 0) goto L6f
                        goto L70
                    L6f:
                        r1 = 0
                    L70:
                        r0 = r1
                    L71:
                        com.kwad.components.ad.feed.b.n$2 r1 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                        com.kwad.components.ad.feed.b.n r1 = com.kwad.components.ad.feed.b.n.this
                        com.kwad.sdk.core.response.model.AdTemplate r1 = com.kwad.components.ad.feed.b.n.D(r1)
                        if (r1 == 0) goto L87
                        com.kwad.components.ad.feed.b.n$2 r1 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                        com.kwad.components.ad.feed.b.n r1 = com.kwad.components.ad.feed.b.n.this
                        com.kwad.sdk.core.response.model.AdTemplate r1 = com.kwad.components.ad.feed.b.n.E(r1)
                        r2 = r0 ^ 1
                        r1.mIsAudioEnable = r2
                    L87:
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.feed.b.n.AnonymousClass2.AnonymousClass5.isMuted():boolean");
                }
            });
        }

        @Override // com.kwad.components.core.webview.tachikoma.j
        public final void a(WebCloseStatus webCloseStatus) {
            if (n.this.hy != null) {
                n.this.hy.tw();
                n.this.hy.tx();
            }
            bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.feed.b.n.2.6
                public AnonymousClass6() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    n.this.us();
                }
            });
        }

        @Override // com.kwad.components.core.webview.tachikoma.j
        public final void a(ay ayVar) {
            n.this.hy = ayVar;
        }

        @Override // com.kwad.components.core.webview.tachikoma.j
        public final void a(a.C0448a c0448a) {
            if (n.this.aer != null) {
                String str = c0448a.YC;
                str.hashCode();
                switch (str) {
                    case "adShowCallback":
                        n.this.aer.onAdShow();
                        break;
                    case "adDownloadConfirmTipCancel":
                    case "adDownloadConfirmTipDismiss":
                        n.this.aer.onDownloadTipsDialogDismiss();
                        break;
                    case "adCloseCallback":
                        n.this.aer.onDislikeClicked();
                        break;
                    case "adDownloadConfirmTipShow":
                        n.this.aer.onDownloadTipsDialogShow();
                        break;
                    case "adClickCallback":
                        n.this.aer.onAdClicked();
                        break;
                }
            }
        }
    }

    /* renamed from: com.kwad.components.ad.feed.b.n$4 */
    public class AnonymousClass4 implements b.a {
        public AnonymousClass4() {
        }

        @Override // com.kwad.components.core.widget.b.a
        public final void onAdClicked() {
            if (n.this.aer != null) {
                n.this.aer.onAdClicked();
            }
            com.kwad.components.ad.feed.monitor.b.a(n.this.mAdTemplate, 1, n.this.getStayTime());
        }

        @Override // com.kwad.components.core.widget.b.a
        public final void onAdShow() {
            if (n.this.mIsNative) {
                if (n.this.aer != null) {
                    n.this.aer.onAdShow();
                }
                com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                a.C0484a c0484a = new a.C0484a();
                FeedType fromInt = FeedType.fromInt(n.this.mAdTemplate.type);
                if (fromInt == FeedType.FEED_TYPE_TEXT_NEW) {
                    fromInt = FeedType.FEED_TYPE_TEXT_BELOW;
                }
                c0484a.templateId = String.valueOf(fromInt.getType());
                bVar.b(c0484a);
                bVar.v(n.this.getHeight(), n.this.mWidth);
                com.kwad.components.core.s.b.sc().a(n.this.mAdTemplate, null, bVar);
                com.kwad.components.ad.feed.monitor.b.a(n.this.mAdTemplate, 1, 3);
            }
        }

        @Override // com.kwad.components.core.widget.b.a
        public final void onDislikeClicked() {
            if (n.this.aer != null) {
                n.this.aer.onDislikeClicked();
            }
        }

        @Override // com.kwad.components.core.widget.b.a
        public final void onDownloadTipsDialogDismiss() {
            if (n.this.aer != null) {
                n.this.aer.onDownloadTipsDialogDismiss();
            }
        }

        @Override // com.kwad.components.core.widget.b.a
        public final void onDownloadTipsDialogShow() {
            if (n.this.aer != null) {
                n.this.aer.onDownloadTipsDialogShow();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.feed.b.n$5 */
    public class AnonymousClass5 implements a.c {
        public AnonymousClass5() {
        }

        @Override // com.kwad.components.core.j.a.c
        public final void bM() {
        }
    }

    /* renamed from: com.kwad.components.ad.feed.b.n$6 */
    public class AnonymousClass6 implements d.InterfaceC0369d {

        /* renamed from: com.kwad.components.ad.feed.b.n$6$1 */
        public class AnonymousClass1 implements a.b {
            final /* synthetic */ double hu;

            public AnonymousClass1(double d10) {
                d10 = d10;
            }

            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.d.c.d("TKFeedView", "convertEnable End" + com.kwad.sdk.core.response.b.e.el(n.this.mAdTemplate));
                com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                bVar.l(d10);
                bVar.cL(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META);
                n.this.c(bVar);
            }
        }

        public AnonymousClass6() {
        }

        @Override // com.kwad.components.ad.feed.d.InterfaceC0369d
        public final boolean b(double d10) {
            if (!bw.o(n.this.hx, (int) (com.kwad.sdk.core.config.d.DL() * 100.0f)) || !n.this.uq() || !com.kwad.components.ad.feed.d.bs()) {
                return false;
            }
            com.kwad.components.core.e.d.a.a(new a.C0427a(n.this.getContext()).au(n.this.mAdTemplate).b(n.this.mApkDownloadHelper).ao(2).ap(false).ar(false).an(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META).am(5).at(true).a(new a.b() { // from class: com.kwad.components.ad.feed.b.n.6.1
                final /* synthetic */ double hu;

                public AnonymousClass1(double d102) {
                    d10 = d102;
                }

                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    com.kwad.sdk.core.d.c.d("TKFeedView", "convertEnable End" + com.kwad.sdk.core.response.b.e.el(n.this.mAdTemplate));
                    com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                    bVar.l(d10);
                    bVar.cL(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META);
                    n.this.c(bVar);
                }
            }));
            return true;
        }
    }

    /* renamed from: com.kwad.components.ad.feed.b.n$7 */
    public class AnonymousClass7 implements d.InterfaceC0369d {
        final /* synthetic */ com.kwad.components.core.webview.tachikoma.e.d hF;

        public AnonymousClass7(com.kwad.components.core.webview.tachikoma.e.d dVar) {
            dVar = dVar;
        }

        @Override // com.kwad.components.ad.feed.d.InterfaceC0369d
        public final boolean b(double d10) {
            if (!bw.o(n.this.hx, (int) (com.kwad.sdk.core.config.d.DL() * 100.0f)) || !n.this.uq() || !com.kwad.components.ad.feed.d.bs()) {
                return false;
            }
            dVar.p(2, Double.toString(d10));
            return true;
        }
    }

    /* renamed from: com.kwad.components.ad.feed.b.n$8 */
    public class AnonymousClass8 implements d.b {
        final /* synthetic */ com.kwad.components.core.webview.tachikoma.e.d hF;

        public AnonymousClass8(com.kwad.components.core.webview.tachikoma.e.d dVar) {
            dVar = dVar;
        }

        @Override // com.kwad.components.ad.feed.d.b
        public final boolean p(String str) {
            if (!bw.o(n.this.hx, (int) (com.kwad.sdk.core.config.d.DL() * 100.0f)) || !n.this.uq() || !com.kwad.components.ad.feed.d.bs()) {
                return false;
            }
            dVar.p(1, str);
            return true;
        }
    }

    public interface a {
        void d(int i10, String str);
    }

    public n(@NonNull Context context) {
        this(context, null);
    }

    public void bU() {
        float cT = com.kwad.sdk.core.response.b.b.cT(this.mAdTemplate);
        if (this.fD == null) {
            this.fD = new d.InterfaceC0369d() { // from class: com.kwad.components.ad.feed.b.n.6

                /* renamed from: com.kwad.components.ad.feed.b.n$6$1 */
                public class AnonymousClass1 implements a.b {
                    final /* synthetic */ double hu;

                    public AnonymousClass1(double d102) {
                        d10 = d102;
                    }

                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        com.kwad.sdk.core.d.c.d("TKFeedView", "convertEnable End" + com.kwad.sdk.core.response.b.e.el(n.this.mAdTemplate));
                        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                        bVar.l(d10);
                        bVar.cL(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META);
                        n.this.c(bVar);
                    }
                }

                public AnonymousClass6() {
                }

                @Override // com.kwad.components.ad.feed.d.InterfaceC0369d
                public final boolean b(double d102) {
                    if (!bw.o(n.this.hx, (int) (com.kwad.sdk.core.config.d.DL() * 100.0f)) || !n.this.uq() || !com.kwad.components.ad.feed.d.bs()) {
                        return false;
                    }
                    com.kwad.components.core.e.d.a.a(new a.C0427a(n.this.getContext()).au(n.this.mAdTemplate).b(n.this.mApkDownloadHelper).ao(2).ap(false).ar(false).an(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META).am(5).at(true).a(new a.b() { // from class: com.kwad.components.ad.feed.b.n.6.1
                        final /* synthetic */ double hu;

                        public AnonymousClass1(double d1022) {
                            d10 = d1022;
                        }

                        @Override // com.kwad.components.core.e.d.a.b
                        public final void onAdClicked() {
                            com.kwad.sdk.core.d.c.d("TKFeedView", "convertEnable End" + com.kwad.sdk.core.response.b.e.el(n.this.mAdTemplate));
                            com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                            bVar.l(d10);
                            bVar.cL(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META);
                            n.this.c(bVar);
                        }
                    }));
                    return true;
                }
            };
        }
        com.kwad.components.ad.feed.d.a(cT, this.mContext, this.fD);
    }

    public void bV() {
        if (this.f11500hc) {
            return;
        }
        this.f11500hc = true;
        com.kwad.components.ad.feed.monitor.b.a(this.mAdTemplate, 3, getStayTime());
    }

    public void cc() {
        if (this.hz == null) {
            return;
        }
        bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.feed.b.n.3
            public AnonymousClass3() {
            }

            private boolean a(boolean z10, boolean z11, KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl, int i10) {
                if (i10 == 1) {
                    return z10;
                }
                if (i10 == 2) {
                    return z11;
                }
                if (i10 != 3) {
                    return kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0 ? kSAdVideoPlayConfigImpl.isDataFlowAutoStart() ? z10 : z11 : a(z10, z11);
                }
                return false;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                com.kwad.components.core.webview.tachikoma.b.d dVar = new com.kwad.components.core.webview.tachikoma.b.d();
                boolean isNetworkConnected = al.isNetworkConnected(n.this.mContext);
                boolean isWifiConnected = al.isWifiConnected(n.this.mContext);
                if (n.this.bS instanceof KSAdVideoPlayConfigImpl) {
                    KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) n.this.bS;
                    dVar.adn = a(isNetworkConnected, isWifiConnected, kSAdVideoPlayConfigImpl, kSAdVideoPlayConfigImpl.getVideoAutoPlayType());
                } else {
                    dVar.adn = a(isNetworkConnected, isWifiConnected);
                }
                n.this.hz.a(dVar);
            }

            private boolean a(boolean z10, boolean z11) {
                AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(n.this.mAdTemplate);
                if (com.kwad.sdk.core.response.b.a.cb(eb2)) {
                    return z10;
                }
                if (com.kwad.sdk.core.response.b.a.cc(eb2)) {
                    return z11;
                }
                if (com.kwad.sdk.core.response.b.a.cd(eb2)) {
                    return false;
                }
                return com.kwad.sdk.core.config.d.DE() ? z10 : z11;
            }
        });
    }

    public void cd() {
        if (this.f11499hb == null) {
            this.mIsNative = true;
            com.kwad.components.core.widget.b a10 = com.kwad.components.ad.feed.b.a(this.mContext, FeedType.fromInt(this.mAdTemplate.type), com.kwad.sdk.core.response.b.a.be(this.mAdInfo));
            this.f11499hb = a10;
            if (a10 != null) {
                this.f11499hb.setMargin(com.kwad.sdk.c.a.a.a(this.mContext, 16.0f));
                this.hx.removeAllViews();
                this.f11499hb.setInnerAdInteractionListener(this.hm);
                this.hx.addView(this.f11499hb);
                this.hA.d(1, "");
                this.f11499hb.c((com.kwad.components.core.widget.b) this.mAdResultData);
                com.kwad.components.core.widget.b bVar = this.f11499hb;
                if (bVar instanceof c) {
                    ((c) bVar).b(this.bS);
                }
            }
        }
    }

    public a.b getCurrentVoiceItem() {
        if (this.gr == null) {
            this.gr = new a.b(new a.c() { // from class: com.kwad.components.ad.feed.b.n.5
                public AnonymousClass5() {
                }

                @Override // com.kwad.components.core.j.a.c
                public final void bM() {
                }
            });
        }
        return this.gr;
    }

    private void init(Context context) {
        int a10 = com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.awq);
        this.hw = new com.kwad.components.core.webview.tachikoma.i(context, a10, a10);
        com.kwad.sdk.core.c.b.Fi();
        com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.ad.feed.b.n.1
            final /* synthetic */ Context hB;

            public AnonymousClass1(Context context2) {
                context = context2;
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            /* renamed from: onActivityDestroyed */
            public final void b(@NonNull Activity activity) {
                Context context2 = context;
                if ((context2 instanceof Activity) && context2.equals(activity)) {
                    if (n.this.hw != null) {
                        n.this.hw.jK();
                    }
                    if (n.this.hy != null) {
                        n.this.hy.onDestroy();
                    }
                    com.kwad.sdk.core.c.b.Fi();
                    com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
                }
            }
        });
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
    }

    @Override // com.kwad.components.core.widget.b
    public final void bE() {
        this.hx = (KSFrameLayout) findViewById(R.id.ksad_container);
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.h.c
    public final void bl() {
        super.bl();
        com.kwad.components.core.j.a.pv().a(getCurrentVoiceItem());
        ay ayVar = this.hy;
        if (ayVar != null) {
            ayVar.ty();
        }
        com.kwad.components.ad.feed.d.C(this.mContext);
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.h.c
    public final void bm() {
        super.bm();
        ay ayVar = this.hy;
        if (ayVar != null) {
            ayVar.tz();
            com.kwad.components.core.j.a.pv().c(this.gr);
        }
        com.kwad.components.ad.feed.d.D(this.mContext);
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.ksad_feed_tkview;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (!com.kwad.sdk.core.config.d.DP() || !com.kwad.sdk.core.response.b.d.dQ(this.mAdTemplate)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (com.kwad.sdk.core.response.b.b.cn(this.mAdTemplate) == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        a(motionEvent);
        if ((action == 2 || action == 3) && this.hx != null && !this.mIsNative && Math.abs(motionEvent.getX() - this.fR) > 0.0f) {
            this.hx.requestDisallowInterceptTouchEvent(true);
            double abs = Math.abs(motionEvent.getX() - this.fR);
            double abs2 = Math.abs(motionEvent.getY() - this.fS);
            if (Math.tan(r1.maxRange) * abs < abs2 || Math.tan(r1.minRange) * abs < abs2) {
                this.hx.requestDisallowInterceptTouchEvent(false);
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public final void setTKLoadListener(a aVar) {
        a aVar2 = this.hA;
        if (aVar2 != null) {
            aVar2.d(this.mIsNative ? 1 : 3, "");
        }
        this.hA = aVar;
    }

    public final void setVideoPlayConfig(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        this.bS = ksAdVideoPlayConfig;
        cc();
    }

    public final void setWidth(int i10) {
        if (i10 <= 0) {
            i10 = getContext().getResources().getDisplayMetrics().widthPixels;
        }
        this.mWidth = i10;
    }

    private n(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, null, 0);
    }

    @Override // com.kwad.components.core.widget.b
    public final void V() {
        if (this.mAdTemplate.mPvReported || this.mAdTemplate.mHasAdShow) {
            return;
        }
        ay ayVar = this.hy;
        if (ayVar != null) {
            ayVar.tu();
            this.hy.tv();
            com.kwad.components.ad.feed.monitor.b.a((AdTemplate) this.mAdTemplate, 3, 3);
        }
        b.a aVar = this.aer;
        if (aVar != null) {
            aVar.onAdShow();
            this.mAdTemplate.mHasAdShow = true;
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void Z() {
        super.Z();
        if (this.fD != null) {
            com.kwad.components.ad.feed.d.a(com.kwad.sdk.core.response.b.b.cT(this.mAdTemplate), this.mContext, this.fD);
        }
        if (this.fC != null) {
            com.kwad.components.ad.feed.d.a(com.kwad.sdk.core.response.b.b.dd(this.mAdTemplate), this.mContext, this.fC);
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void aa() {
        super.aa();
        d.InterfaceC0369d interfaceC0369d = this.fD;
        if (interfaceC0369d != null) {
            com.kwad.components.ad.feed.d.a(interfaceC0369d);
        }
        d.b bVar = this.fC;
        if (bVar != null) {
            com.kwad.components.ad.feed.d.a(bVar);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void c(@NonNull AdResultData adResultData) {
        super.c((n) adResultData);
        com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate);
        this.mApkDownloadHelper = cVar;
        cVar.setOnShowListener(this);
        this.mApkDownloadHelper.setOnDismissListener(this);
        this.fQ = SystemClock.elapsedRealtime();
        if (com.kwad.sdk.core.response.b.b.cU(this.mAdTemplate) > l5.c.f27899e) {
            this.mHeight = (int) (this.mWidth * com.kwad.sdk.core.response.b.b.cU(this.mAdTemplate));
        } else {
            this.mHeight = this.hx.getHeight();
        }
        this.hw.a(com.kwad.sdk.n.m.dH(this.mContext), adResultData, new com.kwad.components.core.webview.tachikoma.j() { // from class: com.kwad.components.ad.feed.b.n.2

            /* renamed from: com.kwad.components.ad.feed.b.n$2$1 */
            public class AnonymousClass1 extends com.kwad.components.core.webview.tachikoma.a.n {
                public AnonymousClass1() {
                }

                @Override // com.kwad.components.core.webview.tachikoma.a.w, com.kwad.sdk.core.webview.c.a
                public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                    super.a(str, cVar);
                    n.this.hz = cVar;
                    n.this.cc();
                }
            }

            /* renamed from: com.kwad.components.ad.feed.b.n$2$2 */
            public class C03672 extends w {
                public C03672() {
                }

                @Override // com.kwad.components.core.webview.jshandler.w
                public final void a(x xVar) {
                    super.a(xVar);
                    if (com.kwad.components.core.s.a.av(n.this.mContext).sa() && n.this.cV != null) {
                        com.kwad.components.core.webview.tachikoma.b.m mVar = new com.kwad.components.core.webview.tachikoma.b.m();
                        mVar.adu = true;
                        n.this.cV.c(mVar);
                    }
                    com.kwad.components.core.j.a.pv().a(n.this.getCurrentVoiceItem());
                    com.kwad.components.ad.feed.monitor.b.a(n.this.mAdTemplate, 1, 1, com.kwad.sdk.core.response.b.a.K(n.this.mAdInfo), null, SystemClock.elapsedRealtime() - n.this.fQ);
                }

                @Override // com.kwad.components.core.webview.jshandler.w
                public final void b(x xVar) {
                    super.b(xVar);
                    com.kwad.components.ad.feed.monitor.b.a(n.this.mAdTemplate, 2, 1, com.kwad.sdk.core.response.b.a.K(n.this.mAdInfo), xVar.errorReason, SystemClock.elapsedRealtime() - n.this.fQ);
                    com.kwad.components.core.o.a.ri().d(n.this.mAdTemplate, xVar.errorCode, xVar.ub());
                }

                @Override // com.kwad.components.core.webview.jshandler.w
                public final void c(x xVar) {
                    super.c(xVar);
                    com.kwad.components.core.j.a.pv().c(n.this.gr);
                }
            }

            /* renamed from: com.kwad.components.ad.feed.b.n$2$3 */
            public class AnonymousClass3 implements ba.a {
                public AnonymousClass3() {
                }

                @Override // com.kwad.components.core.webview.jshandler.ba.a
                public final void ca() {
                    n.this.bU();
                }
            }

            /* renamed from: com.kwad.components.ad.feed.b.n$2$4 */
            public class AnonymousClass4 implements aw.b {
                public AnonymousClass4() {
                }

                @Override // com.kwad.components.core.webview.jshandler.aw.b
                public final void c(com.kwad.components.core.webview.tachikoma.e.d dVar) {
                    n.this.a(dVar);
                }

                @Override // com.kwad.components.core.webview.jshandler.aw.b
                public final void d(com.kwad.components.core.webview.tachikoma.e.d dVar) {
                    n.this.b(dVar);
                }

                @Override // com.kwad.components.core.webview.jshandler.aw.b
                public final void e(com.kwad.components.core.webview.tachikoma.e.d dVar) {
                    n.this.a(dVar);
                    n.this.b(dVar);
                }
            }

            /* renamed from: com.kwad.components.ad.feed.b.n$2$5 */
            public class AnonymousClass5 implements o.a {
                public AnonymousClass5() {
                }

                @Override // com.kwad.components.core.webview.tachikoma.a.o.a
                public final boolean isMuted() {
                    /*
                        this = this;
                        boolean r0 = com.kwad.sdk.core.config.d.gN()
                        r1 = 1
                        if (r0 != 0) goto L1a
                        com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                        com.kwad.components.ad.feed.b.n r0 = com.kwad.components.ad.feed.b.n.this
                        android.content.Context r0 = com.kwad.components.ad.feed.b.n.A(r0)
                        com.kwad.components.core.s.a r0 = com.kwad.components.core.s.a.av(r0)
                        boolean r0 = r0.sa()
                        if (r0 == 0) goto L1a
                        goto L70
                    L1a:
                        com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                        com.kwad.components.ad.feed.b.n r0 = com.kwad.components.ad.feed.b.n.this
                        com.kwad.components.core.j.a$b r0 = com.kwad.components.ad.feed.b.n.r(r0)
                        if (r0 == 0) goto L36
                        com.kwad.components.core.j.a.pv()
                        com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                        com.kwad.components.ad.feed.b.n r0 = com.kwad.components.ad.feed.b.n.this
                        com.kwad.components.core.j.a$b r0 = com.kwad.components.ad.feed.b.n.r(r0)
                        boolean r0 = com.kwad.components.core.j.a.b(r0)
                        if (r0 != 0) goto L36
                        goto L70
                    L36:
                        com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                        com.kwad.components.ad.feed.b.n r0 = com.kwad.components.ad.feed.b.n.this
                        com.kwad.sdk.api.KsAdVideoPlayConfig r0 = com.kwad.components.ad.feed.b.n.B(r0)
                        boolean r0 = r0 instanceof com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl
                        if (r0 == 0) goto L60
                        com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                        com.kwad.components.ad.feed.b.n r0 = com.kwad.components.ad.feed.b.n.this
                        com.kwad.sdk.api.KsAdVideoPlayConfig r0 = com.kwad.components.ad.feed.b.n.B(r0)
                        com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl r0 = (com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl) r0
                        int r0 = r0.getVideoSoundValue()
                        if (r0 == 0) goto L60
                        com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                        com.kwad.components.ad.feed.b.n r0 = com.kwad.components.ad.feed.b.n.this
                        com.kwad.sdk.api.KsAdVideoPlayConfig r0 = com.kwad.components.ad.feed.b.n.B(r0)
                        boolean r0 = r0.isVideoSoundEnable()
                        r0 = r0 ^ r1
                        goto L71
                    L60:
                        com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                        com.kwad.components.ad.feed.b.n r0 = com.kwad.components.ad.feed.b.n.this
                        com.kwad.sdk.core.response.model.AdInfo r0 = com.kwad.components.ad.feed.b.n.C(r0)
                        boolean r0 = com.kwad.sdk.core.response.b.a.bZ(r0)
                        if (r0 != 0) goto L6f
                        goto L70
                    L6f:
                        r1 = 0
                    L70:
                        r0 = r1
                    L71:
                        com.kwad.components.ad.feed.b.n$2 r1 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                        com.kwad.components.ad.feed.b.n r1 = com.kwad.components.ad.feed.b.n.this
                        com.kwad.sdk.core.response.model.AdTemplate r1 = com.kwad.components.ad.feed.b.n.D(r1)
                        if (r1 == 0) goto L87
                        com.kwad.components.ad.feed.b.n$2 r1 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                        com.kwad.components.ad.feed.b.n r1 = com.kwad.components.ad.feed.b.n.this
                        com.kwad.sdk.core.response.model.AdTemplate r1 = com.kwad.components.ad.feed.b.n.E(r1)
                        r2 = r0 ^ 1
                        r1.mIsAudioEnable = r2
                    L87:
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.feed.b.n.AnonymousClass2.AnonymousClass5.isMuted():boolean");
                }
            }

            /* renamed from: com.kwad.components.ad.feed.b.n$2$6 */
            public class AnonymousClass6 extends bd {
                public AnonymousClass6() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    n.this.us();
                }
            }

            public AnonymousClass2() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(p pVar) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void ay() {
                if (n.this.hA != null) {
                    n.this.hA.d(3, "");
                }
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void az() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final FrameLayout getTKContainer() {
                return n.this.hx;
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final String getTKReaderScene() {
                return "tk_feed_tk_card";
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final String getTkTemplateId() {
                return com.kwad.sdk.core.response.b.b.dL(n.this.mAdTemplate);
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final com.kwad.sdk.widget.e getTouchCoordsView() {
                return null;
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(com.kwad.components.core.webview.tachikoma.b.m mVar) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(t tVar) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(TKRenderFailReason tKRenderFailReason) {
                n.this.cd();
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(s sVar, com.kwad.sdk.core.webview.b bVar) {
                sVar.c(new y(bVar, n.this.mApkDownloadHelper, (com.kwad.sdk.core.webview.d.a.a) n.this.hw, true));
                sVar.c(new com.kwad.components.core.webview.tachikoma.a.n() { // from class: com.kwad.components.ad.feed.b.n.2.1
                    public AnonymousClass1() {
                    }

                    @Override // com.kwad.components.core.webview.tachikoma.a.w, com.kwad.sdk.core.webview.c.a
                    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar2) {
                        super.a(str, cVar2);
                        n.this.hz = cVar2;
                        n.this.cc();
                    }
                });
                sVar.c(new w() { // from class: com.kwad.components.ad.feed.b.n.2.2
                    public C03672() {
                    }

                    @Override // com.kwad.components.core.webview.jshandler.w
                    public final void a(x xVar) {
                        super.a(xVar);
                        if (com.kwad.components.core.s.a.av(n.this.mContext).sa() && n.this.cV != null) {
                            com.kwad.components.core.webview.tachikoma.b.m mVar = new com.kwad.components.core.webview.tachikoma.b.m();
                            mVar.adu = true;
                            n.this.cV.c(mVar);
                        }
                        com.kwad.components.core.j.a.pv().a(n.this.getCurrentVoiceItem());
                        com.kwad.components.ad.feed.monitor.b.a(n.this.mAdTemplate, 1, 1, com.kwad.sdk.core.response.b.a.K(n.this.mAdInfo), null, SystemClock.elapsedRealtime() - n.this.fQ);
                    }

                    @Override // com.kwad.components.core.webview.jshandler.w
                    public final void b(x xVar) {
                        super.b(xVar);
                        com.kwad.components.ad.feed.monitor.b.a(n.this.mAdTemplate, 2, 1, com.kwad.sdk.core.response.b.a.K(n.this.mAdInfo), xVar.errorReason, SystemClock.elapsedRealtime() - n.this.fQ);
                        com.kwad.components.core.o.a.ri().d(n.this.mAdTemplate, xVar.errorCode, xVar.ub());
                    }

                    @Override // com.kwad.components.core.webview.jshandler.w
                    public final void c(x xVar) {
                        super.c(xVar);
                        com.kwad.components.core.j.a.pv().c(n.this.gr);
                    }
                });
                ba baVar = new ba(new ba.a() { // from class: com.kwad.components.ad.feed.b.n.2.3
                    public AnonymousClass3() {
                    }

                    @Override // com.kwad.components.core.webview.jshandler.ba.a
                    public final void ca() {
                        n.this.bU();
                    }
                });
                aw awVar = new aw(new aw.b() { // from class: com.kwad.components.ad.feed.b.n.2.4
                    public AnonymousClass4() {
                    }

                    @Override // com.kwad.components.core.webview.jshandler.aw.b
                    public final void c(com.kwad.components.core.webview.tachikoma.e.d dVar) {
                        n.this.a(dVar);
                    }

                    @Override // com.kwad.components.core.webview.jshandler.aw.b
                    public final void d(com.kwad.components.core.webview.tachikoma.e.d dVar) {
                        n.this.b(dVar);
                    }

                    @Override // com.kwad.components.core.webview.jshandler.aw.b
                    public final void e(com.kwad.components.core.webview.tachikoma.e.d dVar) {
                        n.this.a(dVar);
                        n.this.b(dVar);
                    }
                });
                sVar.c(baVar);
                sVar.c(awVar);
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
                if (n.this.aer != null) {
                    n.this.aer.onAdClicked();
                }
                n.this.bV();
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(ad.a aVar) {
                aVar.width = com.kwad.sdk.c.a.a.px2dip(n.this.mContext, n.this.mWidth);
                aVar.height = com.kwad.sdk.c.a.a.px2dip(n.this.mContext, n.this.mHeight);
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(o oVar) {
                n.this.cV = oVar;
                n.this.cV.a(new o.a() { // from class: com.kwad.components.ad.feed.b.n.2.5
                    public AnonymousClass5() {
                    }

                    @Override // com.kwad.components.core.webview.tachikoma.a.o.a
                    public final boolean isMuted() {
                        /*
                            this = this;
                            boolean r0 = com.kwad.sdk.core.config.d.gN()
                            r1 = 1
                            if (r0 != 0) goto L1a
                            com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                            com.kwad.components.ad.feed.b.n r0 = com.kwad.components.ad.feed.b.n.this
                            android.content.Context r0 = com.kwad.components.ad.feed.b.n.A(r0)
                            com.kwad.components.core.s.a r0 = com.kwad.components.core.s.a.av(r0)
                            boolean r0 = r0.sa()
                            if (r0 == 0) goto L1a
                            goto L70
                        L1a:
                            com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                            com.kwad.components.ad.feed.b.n r0 = com.kwad.components.ad.feed.b.n.this
                            com.kwad.components.core.j.a$b r0 = com.kwad.components.ad.feed.b.n.r(r0)
                            if (r0 == 0) goto L36
                            com.kwad.components.core.j.a.pv()
                            com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                            com.kwad.components.ad.feed.b.n r0 = com.kwad.components.ad.feed.b.n.this
                            com.kwad.components.core.j.a$b r0 = com.kwad.components.ad.feed.b.n.r(r0)
                            boolean r0 = com.kwad.components.core.j.a.b(r0)
                            if (r0 != 0) goto L36
                            goto L70
                        L36:
                            com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                            com.kwad.components.ad.feed.b.n r0 = com.kwad.components.ad.feed.b.n.this
                            com.kwad.sdk.api.KsAdVideoPlayConfig r0 = com.kwad.components.ad.feed.b.n.B(r0)
                            boolean r0 = r0 instanceof com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl
                            if (r0 == 0) goto L60
                            com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                            com.kwad.components.ad.feed.b.n r0 = com.kwad.components.ad.feed.b.n.this
                            com.kwad.sdk.api.KsAdVideoPlayConfig r0 = com.kwad.components.ad.feed.b.n.B(r0)
                            com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl r0 = (com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl) r0
                            int r0 = r0.getVideoSoundValue()
                            if (r0 == 0) goto L60
                            com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                            com.kwad.components.ad.feed.b.n r0 = com.kwad.components.ad.feed.b.n.this
                            com.kwad.sdk.api.KsAdVideoPlayConfig r0 = com.kwad.components.ad.feed.b.n.B(r0)
                            boolean r0 = r0.isVideoSoundEnable()
                            r0 = r0 ^ r1
                            goto L71
                        L60:
                            com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                            com.kwad.components.ad.feed.b.n r0 = com.kwad.components.ad.feed.b.n.this
                            com.kwad.sdk.core.response.model.AdInfo r0 = com.kwad.components.ad.feed.b.n.C(r0)
                            boolean r0 = com.kwad.sdk.core.response.b.a.bZ(r0)
                            if (r0 != 0) goto L6f
                            goto L70
                        L6f:
                            r1 = 0
                        L70:
                            r0 = r1
                        L71:
                            com.kwad.components.ad.feed.b.n$2 r1 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                            com.kwad.components.ad.feed.b.n r1 = com.kwad.components.ad.feed.b.n.this
                            com.kwad.sdk.core.response.model.AdTemplate r1 = com.kwad.components.ad.feed.b.n.D(r1)
                            if (r1 == 0) goto L87
                            com.kwad.components.ad.feed.b.n$2 r1 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                            com.kwad.components.ad.feed.b.n r1 = com.kwad.components.ad.feed.b.n.this
                            com.kwad.sdk.core.response.model.AdTemplate r1 = com.kwad.components.ad.feed.b.n.E(r1)
                            r2 = r0 ^ 1
                            r1.mIsAudioEnable = r2
                        L87:
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.feed.b.n.AnonymousClass2.AnonymousClass5.isMuted():boolean");
                    }
                });
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(WebCloseStatus webCloseStatus) {
                if (n.this.hy != null) {
                    n.this.hy.tw();
                    n.this.hy.tx();
                }
                bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.feed.b.n.2.6
                    public AnonymousClass6() {
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        n.this.us();
                    }
                });
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(ay ayVar) {
                n.this.hy = ayVar;
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(a.C0448a c0448a) {
                if (n.this.aer != null) {
                    String str = c0448a.YC;
                    str.hashCode();
                    switch (str) {
                        case "adShowCallback":
                            n.this.aer.onAdShow();
                            break;
                        case "adDownloadConfirmTipCancel":
                        case "adDownloadConfirmTipDismiss":
                            n.this.aer.onDownloadTipsDialogDismiss();
                            break;
                        case "adCloseCallback":
                            n.this.aer.onDislikeClicked();
                            break;
                        case "adDownloadConfirmTipShow":
                            n.this.aer.onDownloadTipsDialogShow();
                            break;
                        case "adClickCallback":
                            n.this.aer.onAdClicked();
                            break;
                    }
                }
            }
        });
    }

    /* renamed from: com.kwad.components.ad.feed.b.n$3 */
    public class AnonymousClass3 extends bd {
        public AnonymousClass3() {
        }

        private boolean a(boolean z10, boolean z11, KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl, int i10) {
            if (i10 == 1) {
                return z10;
            }
            if (i10 == 2) {
                return z11;
            }
            if (i10 != 3) {
                return kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0 ? kSAdVideoPlayConfigImpl.isDataFlowAutoStart() ? z10 : z11 : a(z10, z11);
            }
            return false;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            com.kwad.components.core.webview.tachikoma.b.d dVar = new com.kwad.components.core.webview.tachikoma.b.d();
            boolean isNetworkConnected = al.isNetworkConnected(n.this.mContext);
            boolean isWifiConnected = al.isWifiConnected(n.this.mContext);
            if (n.this.bS instanceof KSAdVideoPlayConfigImpl) {
                KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) n.this.bS;
                dVar.adn = a(isNetworkConnected, isWifiConnected, kSAdVideoPlayConfigImpl, kSAdVideoPlayConfigImpl.getVideoAutoPlayType());
            } else {
                dVar.adn = a(isNetworkConnected, isWifiConnected);
            }
            n.this.hz.a(dVar);
        }

        private boolean a(boolean z10, boolean z11) {
            AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(n.this.mAdTemplate);
            if (com.kwad.sdk.core.response.b.a.cb(eb2)) {
                return z10;
            }
            if (com.kwad.sdk.core.response.b.a.cc(eb2)) {
                return z11;
            }
            if (com.kwad.sdk.core.response.b.a.cd(eb2)) {
                return false;
            }
            return com.kwad.sdk.core.config.d.DE() ? z10 : z11;
        }
    }

    private n(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, 0);
        this.mWidth = getContext().getResources().getDisplayMetrics().widthPixels;
        this.mIsNative = false;
        this.hm = new b.a() { // from class: com.kwad.components.ad.feed.b.n.4
            public AnonymousClass4() {
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onAdClicked() {
                if (n.this.aer != null) {
                    n.this.aer.onAdClicked();
                }
                com.kwad.components.ad.feed.monitor.b.a(n.this.mAdTemplate, 1, n.this.getStayTime());
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onAdShow() {
                if (n.this.mIsNative) {
                    if (n.this.aer != null) {
                        n.this.aer.onAdShow();
                    }
                    com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                    a.C0484a c0484a = new a.C0484a();
                    FeedType fromInt = FeedType.fromInt(n.this.mAdTemplate.type);
                    if (fromInt == FeedType.FEED_TYPE_TEXT_NEW) {
                        fromInt = FeedType.FEED_TYPE_TEXT_BELOW;
                    }
                    c0484a.templateId = String.valueOf(fromInt.getType());
                    bVar.b(c0484a);
                    bVar.v(n.this.getHeight(), n.this.mWidth);
                    com.kwad.components.core.s.b.sc().a(n.this.mAdTemplate, null, bVar);
                    com.kwad.components.ad.feed.monitor.b.a(n.this.mAdTemplate, 1, 3);
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDislikeClicked() {
                if (n.this.aer != null) {
                    n.this.aer.onDislikeClicked();
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogDismiss() {
                if (n.this.aer != null) {
                    n.this.aer.onDownloadTipsDialogDismiss();
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogShow() {
                if (n.this.aer != null) {
                    n.this.aer.onDownloadTipsDialogShow();
                }
            }
        };
        init(context);
    }

    public void b(com.kwad.components.core.webview.tachikoma.e.d dVar) {
        AdMatrixInfo.RotateInfo dd2 = com.kwad.sdk.core.response.b.b.dd(this.mAdTemplate);
        if (this.fC == null) {
            this.fC = new d.b() { // from class: com.kwad.components.ad.feed.b.n.8
                final /* synthetic */ com.kwad.components.core.webview.tachikoma.e.d hF;

                public AnonymousClass8(com.kwad.components.core.webview.tachikoma.e.d dVar2) {
                    dVar = dVar2;
                }

                @Override // com.kwad.components.ad.feed.d.b
                public final boolean p(String str) {
                    if (!bw.o(n.this.hx, (int) (com.kwad.sdk.core.config.d.DL() * 100.0f)) || !n.this.uq() || !com.kwad.components.ad.feed.d.bs()) {
                        return false;
                    }
                    dVar.p(1, str);
                    return true;
                }
            };
        }
        com.kwad.components.ad.feed.d.a(dd2, this.mContext, this.fC);
    }

    private void a(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            this.fR = motionEvent.getX();
            this.fS = motionEvent.getY();
        }
    }

    public void a(com.kwad.components.core.webview.tachikoma.e.d dVar) {
        float cT = com.kwad.sdk.core.response.b.b.cT(this.mAdTemplate);
        if (this.fD == null) {
            this.fD = new d.InterfaceC0369d() { // from class: com.kwad.components.ad.feed.b.n.7
                final /* synthetic */ com.kwad.components.core.webview.tachikoma.e.d hF;

                public AnonymousClass7(com.kwad.components.core.webview.tachikoma.e.d dVar2) {
                    dVar = dVar2;
                }

                @Override // com.kwad.components.ad.feed.d.InterfaceC0369d
                public final boolean b(double d10) {
                    if (!bw.o(n.this.hx, (int) (com.kwad.sdk.core.config.d.DL() * 100.0f)) || !n.this.uq() || !com.kwad.components.ad.feed.d.bs()) {
                        return false;
                    }
                    dVar.p(2, Double.toString(d10));
                    return true;
                }
            };
        }
        com.kwad.components.ad.feed.d.a(cT, this.mContext, this.fD);
    }
}
