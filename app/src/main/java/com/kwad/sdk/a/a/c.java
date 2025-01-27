package com.kwad.sdk.a.a;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.kwad.sdk.a.a.b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.u;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class c {
    private e aoS;
    private final Map<String, Integer> aoT;
    private final Map<String, Integer> aoU;
    private final Stack<AdTemplate> aoV;
    private volatile boolean aoW;
    public volatile boolean aoX;
    public volatile boolean aoY;

    /* renamed from: com.kwad.sdk.a.a.c$1 */
    public class AnonymousClass1 extends bd {
        final /* synthetic */ AdTemplate cP;
        final /* synthetic */ AdInfo tK;

        public AnonymousClass1(AdInfo adInfo, AdTemplate adTemplate) {
            eb2 = adInfo;
            adTemplate = adTemplate;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            int i10 = eb2.status;
            if (i10 == 12 || i10 == 10 || !u.gF(com.kwad.sdk.core.download.a.H(com.kwad.sdk.core.response.b.e.eb(adTemplate)))) {
                return;
            }
            c.this.e(adTemplate, true);
        }
    }

    /* renamed from: com.kwad.sdk.a.a.c$2 */
    public class AnonymousClass2 implements Runnable {
        final /* synthetic */ AdTemplate cP;
        final /* synthetic */ AdInfo tK;

        public AnonymousClass2(AdInfo adInfo, AdTemplate adTemplate) {
            eb2 = adInfo;
            adTemplate = adTemplate;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (ap.ap(ServiceProvider.getContext(), com.kwad.sdk.core.response.b.a.ay(eb2)) == 1) {
                return;
            }
            c.this.e(adTemplate, false);
        }
    }

    /* renamed from: com.kwad.sdk.a.a.c$3 */
    public class AnonymousClass3 extends bd {
        final /* synthetic */ boolean apa;
        final /* synthetic */ AdTemplate cP;

        /* renamed from: com.kwad.sdk.a.a.c$3$1 */
        public class AnonymousClass1 implements DialogInterface.OnClickListener {
            public AnonymousClass1() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                if (i10 == -1) {
                    com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                    bVar.cN(29);
                    bVar.cU(23);
                    com.kwad.sdk.core.adlog.c.e(adTemplate, (JSONObject) null, bVar);
                    com.kwad.sdk.a.a.a.Bb();
                    return;
                }
                if (i10 == -2) {
                    AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                    c cVar = c.this;
                    c.g(adTemplate, 1);
                }
            }
        }

        public AnonymousClass3(boolean z10, AdTemplate adTemplate) {
            z10 = z10;
            adTemplate = adTemplate;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            int Dn = com.kwad.sdk.core.config.d.Dn();
            boolean z10 = z10;
            if (z10 && Dn == 2) {
                c.this.a(adTemplate, (DialogInterface.OnDismissListener) null, new DialogInterface.OnClickListener() { // from class: com.kwad.sdk.a.a.c.3.1
                    public AnonymousClass1() {
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i10) {
                        if (i10 == -1) {
                            com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                            bVar.cN(29);
                            bVar.cU(23);
                            com.kwad.sdk.core.adlog.c.e(adTemplate, (JSONObject) null, bVar);
                            com.kwad.sdk.a.a.a.Bb();
                            return;
                        }
                        if (i10 == -2) {
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            c cVar = c.this;
                            c.g(adTemplate, 1);
                        }
                    }
                });
            } else {
                c.this.a(adTemplate, z10, Dn, false);
            }
        }
    }

    /* renamed from: com.kwad.sdk.a.a.c$4 */
    public class AnonymousClass4 implements b.a {

        /* renamed from: com.kwad.sdk.a.a.c$4$1 */
        public class AnonymousClass1 extends bd {
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                if (c.this.aoW) {
                    c.this.aoY = true;
                } else {
                    c.this.Bk();
                }
            }
        }

        public AnonymousClass4() {
        }

        @Override // com.kwad.sdk.a.a.b.a
        public final void Bf() {
            com.kwad.sdk.core.d.c.d("InstallTipsManager", "showInitDelayDialog failed");
        }

        @Override // com.kwad.sdk.a.a.b.a
        public final void gJ() {
            bt.runOnUiThreadDelay(new bd() { // from class: com.kwad.sdk.a.a.c.4.1
                public AnonymousClass1() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    if (c.this.aoW) {
                        c.this.aoY = true;
                    } else {
                        c.this.Bk();
                    }
                }
            }, com.kwad.sdk.core.config.d.Dp());
        }
    }

    /* renamed from: com.kwad.sdk.a.a.c$5 */
    public class AnonymousClass5 extends bd {
        public AnonymousClass5() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            c.this.Bk();
        }
    }

    /* renamed from: com.kwad.sdk.a.a.c$6 */
    public class AnonymousClass6 implements Runnable {
        public AnonymousClass6() {
        }

        @Override // java.lang.Runnable
        @SuppressLint({"WrongConstant"})
        public final void run() {
            try {
                AdTemplate Be = b.Bd().Be();
                if (Be == null || com.kwad.sdk.core.config.d.Do() == 0) {
                    return;
                }
                c.this.aoX = true;
                com.kwad.sdk.core.c.b.Fi();
                com.kwad.sdk.a.a.a.b.I(com.kwad.sdk.core.c.b.getCurrentActivity());
                c.this.aY(Be);
            } catch (Throwable th2) {
                com.kwad.components.core.d.a.reportSdkCaughtException(th2);
            }
        }
    }

    /* renamed from: com.kwad.sdk.a.a.c$7 */
    public class AnonymousClass7 implements DialogInterface.OnClickListener {
        final /* synthetic */ AdTemplate cP;

        public AnonymousClass7(AdTemplate adTemplate) {
            adTemplate = adTemplate;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i10) {
            try {
                if (i10 == -1) {
                    com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                    bVar.cN(29);
                    bVar.cU(23);
                    com.kwad.sdk.core.adlog.c.e(adTemplate, (JSONObject) null, bVar);
                    com.kwad.sdk.a.a.a.Bb();
                } else {
                    if (i10 != -2) {
                        return;
                    }
                    c cVar = c.this;
                    c.g(adTemplate, 1);
                }
            } catch (Throwable th2) {
                ServiceProvider.reportSdkCaughtException(th2);
            }
        }
    }

    /* renamed from: com.kwad.sdk.a.a.c$8 */
    public class AnonymousClass8 extends bd {
        final /* synthetic */ AdTemplate cP;

        public AnonymousClass8(AdTemplate adTemplate) {
            adTemplate = adTemplate;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            if (com.kwad.sdk.a.a.a.Bb()) {
                c cVar = c.this;
                c.g(adTemplate, 2);
            }
        }
    }

    /* renamed from: com.kwad.sdk.a.a.c$9 */
    public class AnonymousClass9 extends bd {
        final /* synthetic */ AdTemplate cP;

        public AnonymousClass9(AdTemplate adTemplate) {
            adTemplate = adTemplate;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            if (c.this.aoS != null) {
                c.this.aoS.dismiss();
                c.a(c.this, (e) null);
                c cVar = c.this;
                c.g(adTemplate, 2);
            }
        }
    }

    public static final class a {
        static final c apd = new c((byte) 0);
    }

    public /* synthetic */ c(byte b10) {
        this();
    }

    public static c Bg() {
        return a.apd;
    }

    public void Bk() {
        if (!this.aoX && com.kwad.sdk.a.a.a.b.di() <= 0) {
            bt.runOnUiThread(new Runnable() { // from class: com.kwad.sdk.a.a.c.6
                public AnonymousClass6() {
                }

                @Override // java.lang.Runnable
                @SuppressLint({"WrongConstant"})
                public final void run() {
                    try {
                        AdTemplate Be = b.Bd().Be();
                        if (Be == null || com.kwad.sdk.core.config.d.Do() == 0) {
                            return;
                        }
                        c.this.aoX = true;
                        com.kwad.sdk.core.c.b.Fi();
                        com.kwad.sdk.a.a.a.b.I(com.kwad.sdk.core.c.b.getCurrentActivity());
                        c.this.aY(Be);
                    } catch (Throwable th2) {
                        com.kwad.components.core.d.a.reportSdkCaughtException(th2);
                    }
                }
            });
        }
    }

    public static /* synthetic */ e a(c cVar, e eVar) {
        cVar.aoS = null;
        return null;
    }

    private static boolean aT(AdTemplate adTemplate) {
        String H;
        if (adTemplate == null) {
            return false;
        }
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        if (ap.ao(ServiceProvider.getContext(), com.kwad.sdk.core.response.b.a.ay(eb2)) || (H = com.kwad.sdk.core.download.a.H(eb2)) == null || TextUtils.isEmpty(H)) {
            return false;
        }
        return new File(H).exists();
    }

    public void aY(AdTemplate adTemplate) {
        a(adTemplate, (DialogInterface.OnDismissListener) null, new DialogInterface.OnClickListener() { // from class: com.kwad.sdk.a.a.c.7
            final /* synthetic */ AdTemplate cP;

            public AnonymousClass7(AdTemplate adTemplate2) {
                adTemplate = adTemplate2;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                try {
                    if (i10 == -1) {
                        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                        bVar.cN(29);
                        bVar.cU(23);
                        com.kwad.sdk.core.adlog.c.e(adTemplate, (JSONObject) null, bVar);
                        com.kwad.sdk.a.a.a.Bb();
                    } else {
                        if (i10 != -2) {
                            return;
                        }
                        c cVar = c.this;
                        c.g(adTemplate, 1);
                    }
                } catch (Throwable th2) {
                    ServiceProvider.reportSdkCaughtException(th2);
                }
            }
        });
        bt.runOnUiThreadDelay(new bd() { // from class: com.kwad.sdk.a.a.c.8
            final /* synthetic */ AdTemplate cP;

            public AnonymousClass8(AdTemplate adTemplate2) {
                adTemplate = adTemplate2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                if (com.kwad.sdk.a.a.a.Bb()) {
                    c cVar = c.this;
                    c.g(adTemplate, 2);
                }
            }
        }, 5000L);
    }

    public void e(AdTemplate adTemplate, boolean z10) {
        bt.runOnUiThread(new bd() { // from class: com.kwad.sdk.a.a.c.3
            final /* synthetic */ boolean apa;
            final /* synthetic */ AdTemplate cP;

            /* renamed from: com.kwad.sdk.a.a.c$3$1 */
            public class AnonymousClass1 implements DialogInterface.OnClickListener {
                public AnonymousClass1() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    if (i10 == -1) {
                        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                        bVar.cN(29);
                        bVar.cU(23);
                        com.kwad.sdk.core.adlog.c.e(adTemplate, (JSONObject) null, bVar);
                        com.kwad.sdk.a.a.a.Bb();
                        return;
                    }
                    if (i10 == -2) {
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        c cVar = c.this;
                        c.g(adTemplate, 1);
                    }
                }
            }

            public AnonymousClass3(boolean z102, AdTemplate adTemplate2) {
                z10 = z102;
                adTemplate = adTemplate2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                int Dn = com.kwad.sdk.core.config.d.Dn();
                boolean z102 = z10;
                if (z102 && Dn == 2) {
                    c.this.a(adTemplate, (DialogInterface.OnDismissListener) null, new DialogInterface.OnClickListener() { // from class: com.kwad.sdk.a.a.c.3.1
                        public AnonymousClass1() {
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i10) {
                            if (i10 == -1) {
                                com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                                bVar.cN(29);
                                bVar.cU(23);
                                com.kwad.sdk.core.adlog.c.e(adTemplate, (JSONObject) null, bVar);
                                com.kwad.sdk.a.a.a.Bb();
                                return;
                            }
                            if (i10 == -2) {
                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                c cVar = c.this;
                                c.g(adTemplate, 1);
                            }
                        }
                    });
                } else {
                    c.this.a(adTemplate, z102, Dn, false);
                }
            }
        });
    }

    public static void g(AdTemplate adTemplate, int i10) {
        com.kwad.sdk.core.adlog.c.e(adTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().cN(69).cU(23).cY(i10));
    }

    @Nullable
    public final AdTemplate Bh() {
        AdTemplate adTemplate = null;
        while (!this.aoV.isEmpty()) {
            AdTemplate pop = this.aoV.pop();
            if (aT(pop)) {
                adTemplate = pop;
            }
        }
        if (adTemplate != null) {
            this.aoV.add(0, adTemplate);
        }
        return adTemplate;
    }

    @SuppressLint({"WrongConstant"})
    public final void Bi() {
        b.Bd().a(new b.a() { // from class: com.kwad.sdk.a.a.c.4

            /* renamed from: com.kwad.sdk.a.a.c$4$1 */
            public class AnonymousClass1 extends bd {
                public AnonymousClass1() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    if (c.this.aoW) {
                        c.this.aoY = true;
                    } else {
                        c.this.Bk();
                    }
                }
            }

            public AnonymousClass4() {
            }

            @Override // com.kwad.sdk.a.a.b.a
            public final void Bf() {
                com.kwad.sdk.core.d.c.d("InstallTipsManager", "showInitDelayDialog failed");
            }

            @Override // com.kwad.sdk.a.a.b.a
            public final void gJ() {
                bt.runOnUiThreadDelay(new bd() { // from class: com.kwad.sdk.a.a.c.4.1
                    public AnonymousClass1() {
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        if (c.this.aoW) {
                            c.this.aoY = true;
                        } else {
                            c.this.Bk();
                        }
                    }
                }, com.kwad.sdk.core.config.d.Dp());
            }
        });
    }

    public final void Bj() {
        bk(false);
        if (this.aoX || !this.aoY) {
            return;
        }
        bt.runOnUiThreadDelay(new bd() { // from class: com.kwad.sdk.a.a.c.5
            public AnonymousClass5() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                c.this.Bk();
            }
        }, 5000L);
    }

    public final void Bl() {
        this.aoS = null;
    }

    public final void aU(AdTemplate adTemplate) {
        if (aT(adTemplate)) {
            this.aoV.add(adTemplate);
        }
    }

    public final void aV(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        this.aoV.remove(adTemplate);
    }

    public final void aW(AdTemplate adTemplate) {
        int i10;
        int Dm = com.kwad.sdk.core.config.d.Dm();
        if (adTemplate == null || Dm <= 0) {
            return;
        }
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        if (adTemplate.mAdScene.getAdStyle() == 0) {
            return;
        }
        String valueOf = String.valueOf(com.kwad.sdk.core.response.b.e.el(adTemplate));
        if (this.aoT.containsKey(valueOf)) {
            Integer num = this.aoT.get(valueOf);
            i10 = num.intValue();
            this.aoT.put(valueOf, num);
        } else {
            i10 = 0;
        }
        if (i10 > 0) {
            return;
        }
        h.schedule(new bd() { // from class: com.kwad.sdk.a.a.c.1
            final /* synthetic */ AdTemplate cP;
            final /* synthetic */ AdInfo tK;

            public AnonymousClass1(AdInfo eb22, AdTemplate adTemplate2) {
                eb2 = eb22;
                adTemplate = adTemplate2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                int i102 = eb2.status;
                if (i102 == 12 || i102 == 10 || !u.gF(com.kwad.sdk.core.download.a.H(com.kwad.sdk.core.response.b.e.eb(adTemplate)))) {
                    return;
                }
                c.this.e(adTemplate, true);
            }
        }, Dm, TimeUnit.SECONDS);
    }

    public final void aX(AdTemplate adTemplate) {
        int i10;
        int Dz = com.kwad.sdk.core.config.d.Dz();
        if (Dz < 0) {
            return;
        }
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        String valueOf = String.valueOf(eb2.adBaseInfo.creativeId);
        if (this.aoU.containsKey(valueOf)) {
            Integer num = this.aoU.get(valueOf);
            i10 = num.intValue();
            this.aoU.put(valueOf, num);
        } else {
            i10 = 0;
        }
        if (i10 > 0) {
            return;
        }
        h.schedule(new Runnable() { // from class: com.kwad.sdk.a.a.c.2
            final /* synthetic */ AdTemplate cP;
            final /* synthetic */ AdInfo tK;

            public AnonymousClass2(AdInfo eb22, AdTemplate adTemplate2) {
                eb2 = eb22;
                adTemplate = adTemplate2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (ap.ap(ServiceProvider.getContext(), com.kwad.sdk.core.response.b.a.ay(eb2)) == 1) {
                    return;
                }
                c.this.e(adTemplate, false);
            }
        }, Dz, TimeUnit.SECONDS);
    }

    public final void bk(boolean z10) {
        this.aoW = z10;
    }

    public final void dismiss() {
        com.kwad.sdk.a.a.a.Bb();
        e eVar = this.aoS;
        if (eVar != null) {
            eVar.dismiss();
            this.aoS = null;
        }
    }

    private c() {
        this.aoT = new HashMap();
        this.aoU = new HashMap();
        this.aoV = new Stack<>();
        this.aoW = false;
        this.aoX = false;
        this.aoY = false;
    }

    private static void b(Map<String, Integer> map, String str) {
        if (map.containsKey(str)) {
            map.put(str, Integer.valueOf(map.get(str).intValue() + 1));
        } else {
            map.put(str, 1);
        }
    }

    @MainThread
    public void a(AdTemplate adTemplate, DialogInterface.OnDismissListener onDismissListener, DialogInterface.OnClickListener onClickListener) {
        if (com.kwad.sdk.a.a.a.of()) {
            return;
        }
        com.kwad.sdk.core.c.b.Fi();
        Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
        if (currentActivity != null && com.kwad.sdk.a.a.a.a(currentActivity, adTemplate, onDismissListener, onClickListener)) {
            a(adTemplate, true, true);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000e, code lost:
    
        if (r4 == 1) goto L44;
     */
    @androidx.annotation.MainThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.kwad.sdk.core.response.model.AdTemplate r2, boolean r3, int r4, boolean r5) {
        /*
            r1 = this;
            com.kwad.sdk.a.a.e r0 = r1.aoS
            if (r0 != 0) goto L15
            boolean r0 = com.kwad.components.core.e.c.b.of()
            if (r0 == 0) goto Lb
            goto L15
        Lb:
            if (r3 == 0) goto L11
            r0 = 1
            if (r4 != r0) goto L11
            goto L12
        L11:
            r0 = 0
        L12:
            r1.a(r2, r3, r0, r5)
        L15:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.a.a.c.a(com.kwad.sdk.core.response.model.AdTemplate, boolean, int, boolean):void");
    }

    @UiThread
    private void a(AdTemplate adTemplate, boolean z10, boolean z11, boolean z12) {
        Context context;
        Context wrapContextIfNeed;
        com.kwad.sdk.core.c.b.Fi();
        Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
        if (currentActivity == null || (context = ((f) ServiceProvider.get(f.class)).getContext()) == null || (wrapContextIfNeed = m.wrapContextIfNeed(context)) == null) {
            return;
        }
        e eVar = new e(wrapContextIfNeed, adTemplate, z10, z11, z12);
        View findViewById = currentActivity.getWindow().getDecorView().findViewById(R.id.content);
        if (findViewById instanceof FrameLayout) {
            eVar.b((FrameLayout) findViewById);
            this.aoS = eVar;
            a(adTemplate, z10, z12);
        }
        if (z12) {
            com.kwad.sdk.core.c.b.Fi();
            com.kwad.sdk.a.a.a.b.I(com.kwad.sdk.core.c.b.getCurrentActivity());
            bt.runOnUiThreadDelay(new bd() { // from class: com.kwad.sdk.a.a.c.9
                final /* synthetic */ AdTemplate cP;

                public AnonymousClass9(AdTemplate adTemplate2) {
                    adTemplate = adTemplate2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    if (c.this.aoS != null) {
                        c.this.aoS.dismiss();
                        c.a(c.this, (e) null);
                        c cVar = c.this;
                        c.g(adTemplate, 2);
                    }
                }
            }, 5000L);
        }
    }

    private void a(AdTemplate adTemplate, boolean z10, boolean z11) {
        String valueOf = String.valueOf(com.kwad.sdk.core.response.b.e.el(adTemplate));
        if (z10) {
            b(this.aoT, valueOf);
            com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
            if (z11) {
                bVar.cU(23);
                bVar.cN(191);
            } else {
                bVar.cN(92);
            }
            com.kwad.sdk.core.adlog.c.d(adTemplate, (JSONObject) null, bVar);
            return;
        }
        com.kwad.sdk.core.adlog.c.c(adTemplate, 93, (JSONObject) null);
        b(this.aoU, valueOf);
    }
}
