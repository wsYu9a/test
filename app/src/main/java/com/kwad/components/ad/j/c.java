package com.kwad.components.ad.j;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.i.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ad;
import com.martian.mibook.mvvm.tts.service.BaseReadAloudService;
import java.util.List;

/* loaded from: classes2.dex */
public final class c implements Runnable {

    /* renamed from: pj */
    private static final Handler f11641pj = new Handler(Looper.getMainLooper());
    private static volatile boolean pn;

    /* renamed from: pk */
    private final long f11642pk;
    private final AdTemplate pl;
    private boolean pm = false;

    @Nullable
    private d po;

    /* renamed from: com.kwad.components.ad.j.c$1 */
    public class AnonymousClass1 implements a.InterfaceC0432a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.i.a.InterfaceC0432a
        public final void e(@Nullable List<com.kwad.components.core.i.c> list) {
            com.kwad.sdk.core.d.c.d("PushAdManager", "onInnerAdLoad: " + list);
            if (list == null || list.size() <= 0) {
                c.access$002(false);
                return;
            }
            AdTemplate adTemplate = list.get(0).getAdTemplate();
            if (!com.kwad.sdk.core.response.b.a.da(com.kwad.sdk.core.response.b.e.eb(adTemplate))) {
                c.access$002(false);
                com.kwad.sdk.core.d.c.d("PushAdManager", "pushAdInfo templateId invalid");
            } else {
                com.kwad.sdk.core.d.c.d("PushAdManager", "loadPushTK");
                c.this.po = new d(ServiceProvider.getContext(), adTemplate);
            }
        }

        @Override // com.kwad.components.core.i.a.InterfaceC0432a
        public final void onError(int i10, String str) {
            com.kwad.sdk.core.d.c.d("PushAdManager", "onError: " + str);
            c.access$002(false);
        }

        @Override // com.kwad.components.core.i.a.InterfaceC0432a
        public final void onRequestResult(int i10) {
        }
    }

    /* renamed from: com.kwad.components.ad.j.c$2 */
    public class AnonymousClass2 extends com.kwad.components.core.e.a.c {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.e.a.c, com.kwad.components.core.e.a.b
        public final void fj() {
            com.kwad.components.core.e.a.e.nT().b(this);
            c.this.fh();
        }
    }

    /* renamed from: com.kwad.components.ad.j.c$3 */
    public class AnonymousClass3 implements com.kwad.components.ad.b.a.b {
        public AnonymousClass3() {
        }

        @Override // com.kwad.components.ad.b.a.b
        public final void T() {
            ad.aO(System.currentTimeMillis());
            e.fp().fl();
        }

        @Override // com.kwad.components.ad.b.a.b
        public final void U() {
            com.kwad.sdk.core.d.c.d("PushAdManager", "onAdClose: ");
            e.fp().fn();
            b.fc().a(c.this);
        }
    }

    public c(@NonNull com.kwad.components.core.internal.api.a aVar) {
        AdTemplate adTemplate = aVar.getAdTemplate();
        this.pl = adTemplate;
        long dc2 = com.kwad.sdk.core.response.b.a.dc(com.kwad.sdk.core.response.b.e.eb(adTemplate));
        this.f11642pk = dc2;
        com.kwad.sdk.core.d.c.d("PushAdManager", "PushAdManager create adTemplate: " + adTemplate.hashCode() + ", " + dc2);
    }

    public static /* synthetic */ boolean access$002(boolean z10) {
        pn = false;
        return false;
    }

    @MainThread
    public void fh() {
        d dVar;
        if (!b.fc().fe()) {
            com.kwad.sdk.core.d.c.d("PushAdManager", "run preCheckResult false");
            return;
        }
        pn = false;
        if (this.pm || (dVar = this.po) == null || !dVar.fm()) {
            return;
        }
        this.pm = true;
        this.po.c(new com.kwad.components.ad.b.a.b() { // from class: com.kwad.components.ad.j.c.3
            public AnonymousClass3() {
            }

            @Override // com.kwad.components.ad.b.a.b
            public final void T() {
                ad.aO(System.currentTimeMillis());
                e.fp().fl();
            }

            @Override // com.kwad.components.ad.b.a.b
            public final void U() {
                com.kwad.sdk.core.d.c.d("PushAdManager", "onAdClose: ");
                e.fp().fn();
                b.fc().a(c.this);
            }
        });
    }

    public final void d(com.kwad.components.core.internal.api.a aVar) {
        AdTemplate adTemplate = aVar.getAdTemplate();
        if (!adTemplate.equals(this.pl)) {
            com.kwad.sdk.core.d.c.d("PushAdManager", "onAdExit not current ad");
            return;
        }
        com.kwad.sdk.core.d.c.d("PushAdManager", "onAdExit showPushAdDelayTime: " + this.f11642pk + ", adTemplate: " + adTemplate.hashCode());
        if (aVar.supportPushAd()) {
            a(BaseReadAloudService.f15167w, this, this.f11642pk);
        }
    }

    public final void fg() {
        com.kwad.sdk.core.d.c.w("PushAdManager", "startRequestPushAd processingPush: " + pn);
        if (pn || this.pl.mAdScene == null) {
            return;
        }
        pn = true;
        com.kwad.components.core.i.a.b(this.pl.mAdScene, new a.InterfaceC0432a() { // from class: com.kwad.components.ad.j.c.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.core.i.a.InterfaceC0432a
            public final void e(@Nullable List<com.kwad.components.core.i.c> list) {
                com.kwad.sdk.core.d.c.d("PushAdManager", "onInnerAdLoad: " + list);
                if (list == null || list.size() <= 0) {
                    c.access$002(false);
                    return;
                }
                AdTemplate adTemplate = list.get(0).getAdTemplate();
                if (!com.kwad.sdk.core.response.b.a.da(com.kwad.sdk.core.response.b.e.eb(adTemplate))) {
                    c.access$002(false);
                    com.kwad.sdk.core.d.c.d("PushAdManager", "pushAdInfo templateId invalid");
                } else {
                    com.kwad.sdk.core.d.c.d("PushAdManager", "loadPushTK");
                    c.this.po = new d(ServiceProvider.getContext(), adTemplate);
                }
            }

            @Override // com.kwad.components.core.i.a.InterfaceC0432a
            public final void onError(int i10, String str) {
                com.kwad.sdk.core.d.c.d("PushAdManager", "onError: " + str);
                c.access$002(false);
            }

            @Override // com.kwad.components.core.i.a.InterfaceC0432a
            public final void onRequestResult(int i10) {
            }
        });
    }

    public final void fi() {
        com.kwad.sdk.core.d.c.d("PushAdManager", "onOutSDKPage: ");
        if (f11641pj.hasMessages(BaseReadAloudService.f15167w)) {
            return;
        }
        com.kwad.sdk.core.d.c.d("PushAdManager", "onOutSDKPage: sendMessageDelay MSG_WHAT_PAGE_OUT");
        a(1000002, this, 500L);
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (com.kwad.components.core.e.a.e.nT().isShowing()) {
            com.kwad.components.core.e.a.e.nT().a(new com.kwad.components.core.e.a.c() { // from class: com.kwad.components.ad.j.c.2
                public AnonymousClass2() {
                }

                @Override // com.kwad.components.core.e.a.c, com.kwad.components.core.e.a.b
                public final void fj() {
                    com.kwad.components.core.e.a.e.nT().b(this);
                    c.this.fh();
                }
            });
        } else {
            fh();
        }
    }

    private static void a(int i10, Runnable runnable, long j10) {
        Handler handler = f11641pj;
        Message obtain = Message.obtain(handler, runnable);
        obtain.what = i10;
        handler.sendMessageDelayed(obtain, j10);
    }
}
