package com.kwad.sdk.kwai.kwai;

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
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.report.i;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.j.k;
import com.kwad.sdk.kwai.kwai.b;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.g;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class c {
    private e YK;
    private final Map<String, Integer> YL;
    private final Map<String, Integer> YM;
    private final Stack<AdTemplate> YN;
    private volatile boolean YO;
    public volatile boolean YP;
    public volatile boolean YQ;

    /* renamed from: com.kwad.sdk.kwai.kwai.c$1 */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ AdTemplate eI;
        final /* synthetic */ AdInfo rX;

        AnonymousClass1(AdInfo adInfo, AdTemplate adTemplate) {
            cb = adInfo;
            adTemplate = adTemplate;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i2 = cb.status;
            if (i2 == 12 || i2 == 10) {
                return;
            }
            c.this.f(adTemplate, true);
        }
    }

    /* renamed from: com.kwad.sdk.kwai.kwai.c$2 */
    final class AnonymousClass2 implements Runnable {
        final /* synthetic */ AdTemplate eI;
        final /* synthetic */ AdInfo rX;

        AnonymousClass2(AdInfo adInfo, AdTemplate adTemplate) {
            cb = adInfo;
            adTemplate = adTemplate;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (ak.ai(ServiceProvider.getContext(), com.kwad.sdk.core.response.a.a.aq(cb)) == 1) {
                return;
            }
            c.this.f(adTemplate, false);
        }
    }

    /* renamed from: com.kwad.sdk.kwai.kwai.c$3 */
    final class AnonymousClass3 implements Runnable {
        final /* synthetic */ boolean YS;
        final /* synthetic */ AdTemplate eI;

        /* renamed from: com.kwad.sdk.kwai.kwai.c$3$1 */
        final class AnonymousClass1 implements DialogInterface.OnClickListener {
            AnonymousClass1() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                if (i2 == -1) {
                    i iVar = new i();
                    iVar.bl(29);
                    iVar.bp(23);
                    com.kwad.sdk.core.report.a.a(adTemplate, iVar);
                    com.kwad.sdk.kwai.kwai.a.sU();
                    return;
                }
                if (i2 == -2) {
                    AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                    c cVar = c.this;
                    c.h(adTemplate, 1);
                }
            }
        }

        AnonymousClass3(boolean z, AdTemplate adTemplate) {
            z = z;
            adTemplate = adTemplate;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int uj = com.kwad.sdk.core.config.d.uj();
            boolean z = z;
            if (z && uj == 2) {
                c.this.a(adTemplate, (DialogInterface.OnDismissListener) null, new DialogInterface.OnClickListener() { // from class: com.kwad.sdk.kwai.kwai.c.3.1
                    AnonymousClass1() {
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        if (i2 == -1) {
                            i iVar = new i();
                            iVar.bl(29);
                            iVar.bp(23);
                            com.kwad.sdk.core.report.a.a(adTemplate, iVar);
                            com.kwad.sdk.kwai.kwai.a.sU();
                            return;
                        }
                        if (i2 == -2) {
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            c cVar = c.this;
                            c.h(adTemplate, 1);
                        }
                    }
                });
            } else {
                c.this.a(adTemplate, z, uj, false);
            }
        }
    }

    /* renamed from: com.kwad.sdk.kwai.kwai.c$4 */
    final class AnonymousClass4 implements b.a {

        /* renamed from: com.kwad.sdk.kwai.kwai.c$4$1 */
        final class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (c.this.YO) {
                    c.this.YQ = true;
                } else {
                    c.this.td();
                }
            }
        }

        AnonymousClass4() {
        }

        @Override // com.kwad.sdk.kwai.kwai.b.a
        public final void gv() {
            bi.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.c.4.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (c.this.YO) {
                        c.this.YQ = true;
                    } else {
                        c.this.td();
                    }
                }
            }, com.kwad.sdk.core.config.d.ul());
        }

        @Override // com.kwad.sdk.kwai.kwai.b.a
        public final void sY() {
            com.kwad.sdk.core.d.b.d("InstallTipsManager", "showInitDelayDialog failed");
        }
    }

    /* renamed from: com.kwad.sdk.kwai.kwai.c$5 */
    final class AnonymousClass5 implements Runnable {
        AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            c.this.td();
        }
    }

    /* renamed from: com.kwad.sdk.kwai.kwai.c$6 */
    final class AnonymousClass6 implements Runnable {
        AnonymousClass6() {
        }

        @Override // java.lang.Runnable
        @SuppressLint({"WrongConstant"})
        public final void run() {
            try {
                AdTemplate sX = b.sW().sX();
                if (sX == null || com.kwad.sdk.core.config.d.uk() == 0) {
                    return;
                }
                c.this.YP = true;
                com.kwad.sdk.core.b.b.vS();
                com.kwad.sdk.kwai.kwai.kwai.b.J(com.kwad.sdk.core.b.b.getCurrentActivity());
                c.this.aj(sX);
            } catch (Throwable th) {
                com.kwad.components.core.c.a.b(th);
            }
        }
    }

    /* renamed from: com.kwad.sdk.kwai.kwai.c$7 */
    final class AnonymousClass7 implements DialogInterface.OnClickListener {
        final /* synthetic */ AdTemplate eI;

        AnonymousClass7(AdTemplate adTemplate) {
            adTemplate = adTemplate;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i2) {
            if (i2 != -1) {
                if (i2 == -2) {
                    c cVar = c.this;
                    c.h(adTemplate, 1);
                    return;
                }
                return;
            }
            i iVar = new i();
            iVar.bl(29);
            iVar.bp(23);
            com.kwad.sdk.core.report.a.a(adTemplate, iVar);
            com.kwad.sdk.kwai.kwai.a.sU();
        }
    }

    /* renamed from: com.kwad.sdk.kwai.kwai.c$8 */
    final class AnonymousClass8 implements Runnable {
        final /* synthetic */ AdTemplate eI;

        AnonymousClass8(AdTemplate adTemplate) {
            adTemplate = adTemplate;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.kwad.sdk.kwai.kwai.a.sU()) {
                c cVar = c.this;
                c.h(adTemplate, 2);
            }
        }
    }

    /* renamed from: com.kwad.sdk.kwai.kwai.c$9 */
    final class AnonymousClass9 implements Runnable {
        final /* synthetic */ AdTemplate eI;

        AnonymousClass9(AdTemplate adTemplate) {
            adTemplate = adTemplate;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (c.this.YK != null) {
                c.this.YK.dismiss();
                c.a(c.this, (e) null);
                c cVar = c.this;
                c.h(adTemplate, 2);
            }
        }
    }

    static final class a {
        static final c YV = new c((byte) 0);
    }

    private c() {
        this.YL = new HashMap();
        this.YM = new HashMap();
        this.YN = new Stack<>();
        this.YO = false;
        this.YP = false;
        this.YQ = false;
    }

    /* synthetic */ c(byte b2) {
        this();
    }

    static /* synthetic */ e a(c cVar, e eVar) {
        cVar.YK = null;
        return null;
    }

    @MainThread
    public void a(AdTemplate adTemplate, DialogInterface.OnDismissListener onDismissListener, DialogInterface.OnClickListener onClickListener) {
        if (com.kwad.sdk.kwai.kwai.a.mF()) {
            return;
        }
        com.kwad.sdk.core.b.b.vS();
        Activity currentActivity = com.kwad.sdk.core.b.b.getCurrentActivity();
        if (currentActivity != null && com.kwad.sdk.kwai.kwai.a.a(currentActivity, adTemplate, onDismissListener, onClickListener)) {
            a(adTemplate, true, true);
        }
    }

    @MainThread
    public void a(AdTemplate adTemplate, boolean z, int i2, boolean z2) {
        if (this.YK != null || com.kwad.components.core.d.a.b.mF()) {
            return;
        }
        a(adTemplate, z, z && i2 == 1, z2);
    }

    private void a(AdTemplate adTemplate, boolean z, boolean z2) {
        int i2;
        String valueOf = String.valueOf(com.kwad.sdk.core.response.a.d.cl(adTemplate));
        if (!z) {
            com.kwad.sdk.core.report.a.c(adTemplate, 93, (JSONObject) null);
            a(this.YM, valueOf);
            return;
        }
        a(this.YL, valueOf);
        i iVar = new i();
        if (z2) {
            iVar.bp(23);
            i2 = 191;
        } else {
            i2 = 92;
        }
        iVar.bl(i2);
        com.kwad.sdk.core.report.a.d(adTemplate, (JSONObject) null, iVar);
    }

    @UiThread
    private void a(AdTemplate adTemplate, boolean z, boolean z2, boolean z3) {
        Context context;
        Context wrapContextIfNeed;
        com.kwad.sdk.core.b.b.vS();
        Activity currentActivity = com.kwad.sdk.core.b.b.getCurrentActivity();
        if (currentActivity == null || (context = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext()) == null || (wrapContextIfNeed = k.wrapContextIfNeed(context)) == null) {
            return;
        }
        e eVar = new e(wrapContextIfNeed, adTemplate, z, z2, z3);
        View findViewById = currentActivity.getWindow().getDecorView().findViewById(R.id.content);
        if (findViewById instanceof FrameLayout) {
            eVar.a((FrameLayout) findViewById);
            this.YK = eVar;
            a(adTemplate, z, z3);
        }
        if (z3) {
            com.kwad.sdk.core.b.b.vS();
            com.kwad.sdk.kwai.kwai.kwai.b.J(com.kwad.sdk.core.b.b.getCurrentActivity());
            bi.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.c.9
                final /* synthetic */ AdTemplate eI;

                AnonymousClass9(AdTemplate adTemplate2) {
                    adTemplate = adTemplate2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (c.this.YK != null) {
                        c.this.YK.dismiss();
                        c.a(c.this, (e) null);
                        c cVar = c.this;
                        c.h(adTemplate, 2);
                    }
                }
            }, 5000L);
        }
    }

    private static void a(Map<String, Integer> map, String str) {
        map.put(str, map.containsKey(str) ? Integer.valueOf(map.get(str).intValue() + 1) : 1);
    }

    private static boolean ae(AdTemplate adTemplate) {
        String A;
        if (adTemplate == null) {
            return false;
        }
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null || ak.ah(context, com.kwad.sdk.core.response.a.a.aq(cb)) || (A = com.kwad.sdk.core.download.a.A(cb)) == null || TextUtils.isEmpty(A)) {
            return false;
        }
        return new File(A).exists();
    }

    public void aj(AdTemplate adTemplate) {
        a(adTemplate, (DialogInterface.OnDismissListener) null, new DialogInterface.OnClickListener() { // from class: com.kwad.sdk.kwai.kwai.c.7
            final /* synthetic */ AdTemplate eI;

            AnonymousClass7(AdTemplate adTemplate2) {
                adTemplate = adTemplate2;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                if (i2 != -1) {
                    if (i2 == -2) {
                        c cVar = c.this;
                        c.h(adTemplate, 1);
                        return;
                    }
                    return;
                }
                i iVar = new i();
                iVar.bl(29);
                iVar.bp(23);
                com.kwad.sdk.core.report.a.a(adTemplate, iVar);
                com.kwad.sdk.kwai.kwai.a.sU();
            }
        });
        bi.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.c.8
            final /* synthetic */ AdTemplate eI;

            AnonymousClass8(AdTemplate adTemplate2) {
                adTemplate = adTemplate2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (com.kwad.sdk.kwai.kwai.a.sU()) {
                    c cVar = c.this;
                    c.h(adTemplate, 2);
                }
            }
        }, 5000L);
    }

    public void f(AdTemplate adTemplate, boolean z) {
        bi.runOnUiThread(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.c.3
            final /* synthetic */ boolean YS;
            final /* synthetic */ AdTemplate eI;

            /* renamed from: com.kwad.sdk.kwai.kwai.c$3$1 */
            final class AnonymousClass1 implements DialogInterface.OnClickListener {
                AnonymousClass1() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    if (i2 == -1) {
                        i iVar = new i();
                        iVar.bl(29);
                        iVar.bp(23);
                        com.kwad.sdk.core.report.a.a(adTemplate, iVar);
                        com.kwad.sdk.kwai.kwai.a.sU();
                        return;
                    }
                    if (i2 == -2) {
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        c cVar = c.this;
                        c.h(adTemplate, 1);
                    }
                }
            }

            AnonymousClass3(boolean z2, AdTemplate adTemplate2) {
                z = z2;
                adTemplate = adTemplate2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int uj = com.kwad.sdk.core.config.d.uj();
                boolean z2 = z;
                if (z2 && uj == 2) {
                    c.this.a(adTemplate, (DialogInterface.OnDismissListener) null, new DialogInterface.OnClickListener() { // from class: com.kwad.sdk.kwai.kwai.c.3.1
                        AnonymousClass1() {
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            if (i2 == -1) {
                                i iVar = new i();
                                iVar.bl(29);
                                iVar.bp(23);
                                com.kwad.sdk.core.report.a.a(adTemplate, iVar);
                                com.kwad.sdk.kwai.kwai.a.sU();
                                return;
                            }
                            if (i2 == -2) {
                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                c cVar = c.this;
                                c.h(adTemplate, 1);
                            }
                        }
                    });
                } else {
                    c.this.a(adTemplate, z2, uj, false);
                }
            }
        });
    }

    public static void h(AdTemplate adTemplate, int i2) {
        com.kwad.sdk.core.report.a.a(adTemplate, new i().bl(69).bp(23).bt(i2));
    }

    public static c sZ() {
        return a.YV;
    }

    public void td() {
        if (!this.YP && com.kwad.sdk.kwai.kwai.kwai.b.cO() <= 0) {
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.c.6
                AnonymousClass6() {
                }

                @Override // java.lang.Runnable
                @SuppressLint({"WrongConstant"})
                public final void run() {
                    try {
                        AdTemplate sX = b.sW().sX();
                        if (sX == null || com.kwad.sdk.core.config.d.uk() == 0) {
                            return;
                        }
                        c.this.YP = true;
                        com.kwad.sdk.core.b.b.vS();
                        com.kwad.sdk.kwai.kwai.kwai.b.J(com.kwad.sdk.core.b.b.getCurrentActivity());
                        c.this.aj(sX);
                    } catch (Throwable th) {
                        com.kwad.components.core.c.a.b(th);
                    }
                }
            });
        }
    }

    public final void aU(boolean z) {
        this.YO = z;
    }

    public final void af(AdTemplate adTemplate) {
        if (ae(adTemplate)) {
            this.YN.add(adTemplate);
        }
    }

    public final void ag(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        this.YN.remove(adTemplate);
    }

    public final void ah(AdTemplate adTemplate) {
        int ui = com.kwad.sdk.core.config.d.ui();
        if (adTemplate == null || ui <= 0) {
            return;
        }
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        if (adTemplate.mAdScene.getAdStyle() == 0) {
            return;
        }
        String valueOf = String.valueOf(com.kwad.sdk.core.response.a.d.cl(adTemplate));
        int i2 = 0;
        if (this.YL.containsKey(valueOf)) {
            i2 = this.YL.get(valueOf).intValue();
            this.YL.put(valueOf, Integer.valueOf(i2));
        }
        if (i2 > 0) {
            return;
        }
        g.schedule(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.c.1
            final /* synthetic */ AdTemplate eI;
            final /* synthetic */ AdInfo rX;

            AnonymousClass1(AdInfo cb2, AdTemplate adTemplate2) {
                cb = cb2;
                adTemplate = adTemplate2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int i22 = cb.status;
                if (i22 == 12 || i22 == 10) {
                    return;
                }
                c.this.f(adTemplate, true);
            }
        }, ui, TimeUnit.SECONDS);
    }

    public final void ai(AdTemplate adTemplate) {
        int ut = com.kwad.sdk.core.config.d.ut();
        if (ut < 0) {
            return;
        }
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        String valueOf = String.valueOf(cb.adBaseInfo.creativeId);
        int i2 = 0;
        if (this.YM.containsKey(valueOf)) {
            i2 = this.YM.get(valueOf).intValue();
            this.YM.put(valueOf, Integer.valueOf(i2));
        }
        if (i2 > 0) {
            return;
        }
        g.schedule(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.c.2
            final /* synthetic */ AdTemplate eI;
            final /* synthetic */ AdInfo rX;

            AnonymousClass2(AdInfo cb2, AdTemplate adTemplate2) {
                cb = cb2;
                adTemplate = adTemplate2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (ak.ai(ServiceProvider.getContext(), com.kwad.sdk.core.response.a.a.aq(cb)) == 1) {
                    return;
                }
                c.this.f(adTemplate, false);
            }
        }, ut, TimeUnit.SECONDS);
    }

    public final void dismiss() {
        com.kwad.sdk.kwai.kwai.a.sU();
        e eVar = this.YK;
        if (eVar != null) {
            eVar.dismiss();
            this.YK = null;
        }
    }

    @Nullable
    public final AdTemplate ta() {
        AdTemplate adTemplate = null;
        while (!this.YN.isEmpty()) {
            AdTemplate pop = this.YN.pop();
            if (ae(pop)) {
                adTemplate = pop;
            }
        }
        if (adTemplate != null) {
            this.YN.add(0, adTemplate);
        }
        return adTemplate;
    }

    @SuppressLint({"WrongConstant"})
    public final void tb() {
        b.sW().a(new b.a() { // from class: com.kwad.sdk.kwai.kwai.c.4

            /* renamed from: com.kwad.sdk.kwai.kwai.c$4$1 */
            final class AnonymousClass1 implements Runnable {
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (c.this.YO) {
                        c.this.YQ = true;
                    } else {
                        c.this.td();
                    }
                }
            }

            AnonymousClass4() {
            }

            @Override // com.kwad.sdk.kwai.kwai.b.a
            public final void gv() {
                bi.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.c.4.1
                    AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        if (c.this.YO) {
                            c.this.YQ = true;
                        } else {
                            c.this.td();
                        }
                    }
                }, com.kwad.sdk.core.config.d.ul());
            }

            @Override // com.kwad.sdk.kwai.kwai.b.a
            public final void sY() {
                com.kwad.sdk.core.d.b.d("InstallTipsManager", "showInitDelayDialog failed");
            }
        });
    }

    public final void tc() {
        aU(false);
        if (this.YP || !this.YQ) {
            return;
        }
        bi.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.c.5
            AnonymousClass5() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                c.this.td();
            }
        }, 5000L);
    }

    public final void te() {
        this.YK = null;
    }
}
