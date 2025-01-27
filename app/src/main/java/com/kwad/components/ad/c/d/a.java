package com.kwad.components.ad.c.d;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.ay;
import com.kwad.components.core.webview.jshandler.y;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.a.o;
import com.kwad.components.core.webview.tachikoma.b.m;
import com.kwad.components.core.widget.a;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.s;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.utils.bd;

/* loaded from: classes2.dex */
public final class a extends c {
    private FrameLayout cS;
    private boolean cT;
    private ay cU;
    private o cV;

    /* renamed from: cn */
    private boolean f11405cn;
    private Context mContext;

    /* renamed from: com.kwad.components.ad.c.d.a$1 */
    public class AnonymousClass1 implements a.InterfaceC0457a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.widget.a.InterfaceC0457a
        public final void Z() {
        }

        @Override // com.kwad.components.core.widget.a.InterfaceC0457a
        public final void aa() {
        }

        @Override // com.kwad.components.core.widget.a.InterfaceC0457a
        public final void ax() {
            com.kwad.sdk.core.d.c.e("BannerFullTKCardPresenter ", "onViewFirstInVisible");
        }

        @Override // com.kwad.components.core.widget.a.InterfaceC0457a
        public final void c(View view) {
            com.kwad.sdk.core.d.c.e("BannerFullTKCardPresenter ", "onViewVisible");
        }

        @Override // com.kwad.components.core.widget.a.InterfaceC0457a
        public final void onWindowFocusChanged(boolean z10) {
            if (a.this.cU != null) {
                if (!z10) {
                    a aVar = a.this;
                    aVar.f(aVar.cA.mAdTemplate.mIsAudioEnable);
                    a.this.cU.tz();
                    return;
                }
                a.this.cU.ty();
                m mVar = new m();
                if (a.this.cT) {
                    a aVar2 = a.this;
                    mVar.adu = !aVar2.f(aVar2.cA.mAdTemplate.mIsAudioEnable);
                } else {
                    mVar.adu = false;
                }
                a.this.cV.c(mVar);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.c.d.a$2 */
    public class AnonymousClass2 implements com.kwad.sdk.core.webview.d.a.a {

        /* renamed from: com.kwad.components.ad.c.d.a$2$1 */
        public class AnonymousClass1 extends bd {
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                a.this.cA.W();
            }
        }

        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            if (aVar != null) {
                a.this.cA.bG.post(new bd() { // from class: com.kwad.components.ad.c.d.a.2.1
                    public AnonymousClass1() {
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        a.this.cA.W();
                    }
                });
            }
        }
    }

    /* renamed from: com.kwad.components.ad.c.d.a$3 */
    public class AnonymousClass3 implements o.a {
        public AnonymousClass3() {
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0064 A[Catch: all -> 0x0076, TryCatch #0 {all -> 0x0076, blocks: (B:3:0x0001, B:5:0x0008, B:9:0x005a, B:11:0x0064, B:12:0x0070, B:16:0x001c, B:18:0x0028, B:20:0x0038, B:21:0x0046), top: B:2:0x0001 }] */
        @Override // com.kwad.components.core.webview.tachikoma.a.o.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean isMuted() {
            /*
                r4 = this;
                r0 = 1
                boolean r1 = com.kwad.sdk.core.config.d.DO()     // Catch: java.lang.Throwable -> L76
                r2 = 0
                if (r1 != 0) goto L1c
                com.kwad.components.ad.c.d.a r1 = com.kwad.components.ad.c.d.a.this     // Catch: java.lang.Throwable -> L76
                com.kwad.components.ad.c.b r1 = com.kwad.components.ad.c.d.a.h(r1)     // Catch: java.lang.Throwable -> L76
                android.content.Context r1 = r1.mContext     // Catch: java.lang.Throwable -> L76
                com.kwad.components.core.s.a r1 = com.kwad.components.core.s.a.av(r1)     // Catch: java.lang.Throwable -> L76
                boolean r1 = r1.sa()     // Catch: java.lang.Throwable -> L76
                if (r1 == 0) goto L1c
            L1a:
                r2 = 1
                goto L59
            L1c:
                com.kwad.components.ad.c.d.a r1 = com.kwad.components.ad.c.d.a.this     // Catch: java.lang.Throwable -> L76
                com.kwad.components.ad.c.b r1 = com.kwad.components.ad.c.d.a.i(r1)     // Catch: java.lang.Throwable -> L76
                com.kwad.sdk.api.KsAdVideoPlayConfig r1 = r1.bI     // Catch: java.lang.Throwable -> L76
                boolean r1 = r1 instanceof com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl     // Catch: java.lang.Throwable -> L76
                if (r1 == 0) goto L46
                com.kwad.components.ad.c.d.a r1 = com.kwad.components.ad.c.d.a.this     // Catch: java.lang.Throwable -> L76
                com.kwad.components.ad.c.b r1 = com.kwad.components.ad.c.d.a.j(r1)     // Catch: java.lang.Throwable -> L76
                com.kwad.sdk.api.KsAdVideoPlayConfig r1 = r1.bI     // Catch: java.lang.Throwable -> L76
                com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl r1 = (com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl) r1     // Catch: java.lang.Throwable -> L76
                int r1 = r1.getVideoSoundValue()     // Catch: java.lang.Throwable -> L76
                if (r1 == 0) goto L46
                com.kwad.components.ad.c.d.a r1 = com.kwad.components.ad.c.d.a.this     // Catch: java.lang.Throwable -> L76
                com.kwad.components.ad.c.b r1 = com.kwad.components.ad.c.d.a.k(r1)     // Catch: java.lang.Throwable -> L76
                com.kwad.sdk.api.KsAdVideoPlayConfig r1 = r1.bI     // Catch: java.lang.Throwable -> L76
                boolean r1 = r1.isVideoSoundEnable()     // Catch: java.lang.Throwable -> L76
                r1 = r1 ^ r0
                goto L5a
            L46:
                com.kwad.components.ad.c.d.a r1 = com.kwad.components.ad.c.d.a.this     // Catch: java.lang.Throwable -> L76
                com.kwad.components.ad.c.b r1 = com.kwad.components.ad.c.d.a.l(r1)     // Catch: java.lang.Throwable -> L76
                com.kwad.sdk.core.response.model.AdTemplate r1 = r1.mAdTemplate     // Catch: java.lang.Throwable -> L76
                com.kwad.sdk.core.response.model.AdInfo r1 = com.kwad.sdk.core.response.b.e.eb(r1)     // Catch: java.lang.Throwable -> L76
                boolean r1 = com.kwad.sdk.core.response.b.a.bW(r1)     // Catch: java.lang.Throwable -> L76
                if (r1 != 0) goto L59
                goto L1a
            L59:
                r1 = r2
            L5a:
                com.kwad.components.ad.c.d.a r2 = com.kwad.components.ad.c.d.a.this     // Catch: java.lang.Throwable -> L76
                com.kwad.components.ad.c.b r2 = com.kwad.components.ad.c.d.a.m(r2)     // Catch: java.lang.Throwable -> L76
                com.kwad.sdk.core.response.model.AdTemplate r2 = r2.mAdTemplate     // Catch: java.lang.Throwable -> L76
                if (r2 == 0) goto L70
                com.kwad.components.ad.c.d.a r2 = com.kwad.components.ad.c.d.a.this     // Catch: java.lang.Throwable -> L76
                com.kwad.components.ad.c.b r2 = com.kwad.components.ad.c.d.a.n(r2)     // Catch: java.lang.Throwable -> L76
                com.kwad.sdk.core.response.model.AdTemplate r2 = r2.mAdTemplate     // Catch: java.lang.Throwable -> L76
                r3 = r1 ^ 1
                r2.mIsAudioEnable = r3     // Catch: java.lang.Throwable -> L76
            L70:
                com.kwad.components.ad.c.d.a r2 = com.kwad.components.ad.c.d.a.this     // Catch: java.lang.Throwable -> L76
                com.kwad.components.ad.c.d.a.b(r2, r1)     // Catch: java.lang.Throwable -> L76
                return r1
            L76:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.c.d.a.AnonymousClass3.isMuted():boolean");
        }
    }

    public a(Context context) {
        this.mContext = context.getApplicationContext();
    }

    @Override // com.kwad.components.ad.c.d.c, com.kwad.components.ad.c.c.a, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void ay() {
        if (this.cA.bM) {
            return;
        }
        ay ayVar = this.cU;
        if (ayVar != null) {
            ayVar.ty();
            this.cU.tu();
            this.cU.tv();
        }
        this.cS.setVisibility(0);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.cS;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_splash";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.cm(this.cA.mAdTemplate).bannerTKInfo.templateId;
    }

    @Override // com.kwad.components.ad.c.c.a, com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.banner_full_tk_card_view);
        this.cS = frameLayout;
        a((ViewGroup) frameLayout.getParent());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // com.kwad.components.ad.c.d.c, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        ay ayVar = this.cU;
        if (ayVar != null) {
            ayVar.tw();
            this.cU.tx();
        }
        super.onUnbind();
    }

    public boolean f(boolean z10) {
        if (!z10) {
            Log.d("lhhVoice ", "mHasAudioFocus:0 ");
            com.kwad.components.core.s.a.av(this.mContext).aO(false);
            return false;
        }
        if (!d.DO()) {
            Log.d("lhhVoice ", "mHasAudioFocus:1 ");
            if (com.kwad.components.core.s.a.av(this.mContext).sb()) {
                Log.d("lhhVoice ", "mHasAudioFocus:3 ");
                return !com.kwad.components.core.s.a.av(this.mContext).sa();
            }
            Log.d("lhhVoice ", "mHasAudioFocus:2 ");
            return com.kwad.components.core.s.a.av(this.mContext).aO(false);
        }
        if (!this.f11405cn) {
            Log.d("lhhVoice ", "mHasAudioFocus:4 ");
            this.f11405cn = com.kwad.components.core.s.a.av(this.mContext).aO(true);
        }
        Log.d("lhhVoice ", "mHasAudioFocus: " + this.f11405cn);
        return this.f11405cn;
    }

    private void a(ViewGroup viewGroup) {
        if (d.DN() || d.DM() < 0.0f) {
            return;
        }
        com.kwad.components.core.widget.a aVar = new com.kwad.components.core.widget.a(viewGroup.getContext(), viewGroup);
        viewGroup.addView(aVar);
        aVar.setViewCallback(new a.InterfaceC0457a() { // from class: com.kwad.components.ad.c.d.a.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.core.widget.a.InterfaceC0457a
            public final void Z() {
            }

            @Override // com.kwad.components.core.widget.a.InterfaceC0457a
            public final void aa() {
            }

            @Override // com.kwad.components.core.widget.a.InterfaceC0457a
            public final void ax() {
                com.kwad.sdk.core.d.c.e("BannerFullTKCardPresenter ", "onViewFirstInVisible");
            }

            @Override // com.kwad.components.core.widget.a.InterfaceC0457a
            public final void c(View view) {
                com.kwad.sdk.core.d.c.e("BannerFullTKCardPresenter ", "onViewVisible");
            }

            @Override // com.kwad.components.core.widget.a.InterfaceC0457a
            public final void onWindowFocusChanged(boolean z10) {
                if (a.this.cU != null) {
                    if (!z10) {
                        a aVar2 = a.this;
                        aVar2.f(aVar2.cA.mAdTemplate.mIsAudioEnable);
                        a.this.cU.tz();
                        return;
                    }
                    a.this.cU.ty();
                    m mVar = new m();
                    if (a.this.cT) {
                        a aVar22 = a.this;
                        mVar.adu = !aVar22.f(aVar22.cA.mAdTemplate.mIsAudioEnable);
                    } else {
                        mVar.adu = false;
                    }
                    a.this.cV.c(mVar);
                }
            }
        });
        aVar.up();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        ay ayVar = this.cU;
        if (ayVar != null) {
            ayVar.tw();
            this.cU.tx();
        }
        this.cS.setVisibility(8);
        com.kwad.components.ad.c.b bVar = this.cA;
        bVar.bM = true;
        bVar.bH.Y();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ad.a aVar) {
        aVar.width = com.kwad.sdk.c.a.a.px2dip(getContext(), this.cA.bG.getWidth());
        aVar.height = com.kwad.sdk.c.a.a.px2dip(getContext(), this.cA.bG.getHeight());
    }

    @Override // com.kwad.components.ad.c.d.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(ay ayVar) {
        super.a(ayVar);
        this.cU = ayVar;
    }

    @Override // com.kwad.components.ad.c.d.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(s sVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(sVar, bVar);
        sVar.c(a(bVar));
    }

    @NonNull
    private y a(com.kwad.sdk.core.webview.b bVar) {
        return new y(bVar, (com.kwad.components.core.e.d.c) null, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.c.d.a.2

            /* renamed from: com.kwad.components.ad.c.d.a$2$1 */
            public class AnonymousClass1 extends bd {
                public AnonymousClass1() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    a.this.cA.W();
                }
            }

            public AnonymousClass2() {
            }

            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (aVar != null) {
                    a.this.cA.bG.post(new bd() { // from class: com.kwad.components.ad.c.d.a.2.1
                        public AnonymousClass1() {
                        }

                        @Override // com.kwad.sdk.utils.bd
                        public final void doTask() {
                            a.this.cA.W();
                        }
                    });
                }
            }
        });
    }

    @Override // com.kwad.components.ad.c.d.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        this.cU.tx();
        this.cA.bG.removeAllViews();
        onDestroy();
        this.cA.X();
    }

    @Override // com.kwad.components.ad.c.d.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
        this.cV = oVar;
        oVar.a(new o.a() { // from class: com.kwad.components.ad.c.d.a.3
            public AnonymousClass3() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.a.o.a
            public final boolean isMuted() {
                /*
                    this = this;
                    r0 = 1
                    boolean r1 = com.kwad.sdk.core.config.d.DO()     // Catch: java.lang.Throwable -> L76
                    r2 = 0
                    if (r1 != 0) goto L1c
                    com.kwad.components.ad.c.d.a r1 = com.kwad.components.ad.c.d.a.this     // Catch: java.lang.Throwable -> L76
                    com.kwad.components.ad.c.b r1 = com.kwad.components.ad.c.d.a.h(r1)     // Catch: java.lang.Throwable -> L76
                    android.content.Context r1 = r1.mContext     // Catch: java.lang.Throwable -> L76
                    com.kwad.components.core.s.a r1 = com.kwad.components.core.s.a.av(r1)     // Catch: java.lang.Throwable -> L76
                    boolean r1 = r1.sa()     // Catch: java.lang.Throwable -> L76
                    if (r1 == 0) goto L1c
                L1a:
                    r2 = 1
                    goto L59
                L1c:
                    com.kwad.components.ad.c.d.a r1 = com.kwad.components.ad.c.d.a.this     // Catch: java.lang.Throwable -> L76
                    com.kwad.components.ad.c.b r1 = com.kwad.components.ad.c.d.a.i(r1)     // Catch: java.lang.Throwable -> L76
                    com.kwad.sdk.api.KsAdVideoPlayConfig r1 = r1.bI     // Catch: java.lang.Throwable -> L76
                    boolean r1 = r1 instanceof com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl     // Catch: java.lang.Throwable -> L76
                    if (r1 == 0) goto L46
                    com.kwad.components.ad.c.d.a r1 = com.kwad.components.ad.c.d.a.this     // Catch: java.lang.Throwable -> L76
                    com.kwad.components.ad.c.b r1 = com.kwad.components.ad.c.d.a.j(r1)     // Catch: java.lang.Throwable -> L76
                    com.kwad.sdk.api.KsAdVideoPlayConfig r1 = r1.bI     // Catch: java.lang.Throwable -> L76
                    com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl r1 = (com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl) r1     // Catch: java.lang.Throwable -> L76
                    int r1 = r1.getVideoSoundValue()     // Catch: java.lang.Throwable -> L76
                    if (r1 == 0) goto L46
                    com.kwad.components.ad.c.d.a r1 = com.kwad.components.ad.c.d.a.this     // Catch: java.lang.Throwable -> L76
                    com.kwad.components.ad.c.b r1 = com.kwad.components.ad.c.d.a.k(r1)     // Catch: java.lang.Throwable -> L76
                    com.kwad.sdk.api.KsAdVideoPlayConfig r1 = r1.bI     // Catch: java.lang.Throwable -> L76
                    boolean r1 = r1.isVideoSoundEnable()     // Catch: java.lang.Throwable -> L76
                    r1 = r1 ^ r0
                    goto L5a
                L46:
                    com.kwad.components.ad.c.d.a r1 = com.kwad.components.ad.c.d.a.this     // Catch: java.lang.Throwable -> L76
                    com.kwad.components.ad.c.b r1 = com.kwad.components.ad.c.d.a.l(r1)     // Catch: java.lang.Throwable -> L76
                    com.kwad.sdk.core.response.model.AdTemplate r1 = r1.mAdTemplate     // Catch: java.lang.Throwable -> L76
                    com.kwad.sdk.core.response.model.AdInfo r1 = com.kwad.sdk.core.response.b.e.eb(r1)     // Catch: java.lang.Throwable -> L76
                    boolean r1 = com.kwad.sdk.core.response.b.a.bW(r1)     // Catch: java.lang.Throwable -> L76
                    if (r1 != 0) goto L59
                    goto L1a
                L59:
                    r1 = r2
                L5a:
                    com.kwad.components.ad.c.d.a r2 = com.kwad.components.ad.c.d.a.this     // Catch: java.lang.Throwable -> L76
                    com.kwad.components.ad.c.b r2 = com.kwad.components.ad.c.d.a.m(r2)     // Catch: java.lang.Throwable -> L76
                    com.kwad.sdk.core.response.model.AdTemplate r2 = r2.mAdTemplate     // Catch: java.lang.Throwable -> L76
                    if (r2 == 0) goto L70
                    com.kwad.components.ad.c.d.a r2 = com.kwad.components.ad.c.d.a.this     // Catch: java.lang.Throwable -> L76
                    com.kwad.components.ad.c.b r2 = com.kwad.components.ad.c.d.a.n(r2)     // Catch: java.lang.Throwable -> L76
                    com.kwad.sdk.core.response.model.AdTemplate r2 = r2.mAdTemplate     // Catch: java.lang.Throwable -> L76
                    r3 = r1 ^ 1
                    r2.mIsAudioEnable = r3     // Catch: java.lang.Throwable -> L76
                L70:
                    com.kwad.components.ad.c.d.a r2 = com.kwad.components.ad.c.d.a.this     // Catch: java.lang.Throwable -> L76
                    com.kwad.components.ad.c.d.a.b(r2, r1)     // Catch: java.lang.Throwable -> L76
                    return r1
                L76:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.c.d.a.AnonymousClass3.isMuted():boolean");
            }
        });
    }
}
