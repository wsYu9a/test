package com.kwad.components.ad.reward;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.h;
import com.kwad.components.ad.reward.k.s;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.i.a;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.tachikoma.c.e;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bs;
import com.kwad.sdk.utils.bt;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class g extends com.kwad.components.core.l.a {
    public boolean hG;

    /* renamed from: hc */
    public boolean f11685hc;

    /* renamed from: hf */
    private Handler f11686hf;
    public boolean lm;
    public AdResultData mAdResultData;

    @NonNull
    public com.kwad.components.ad.reward.e.d mAdRewardStepListener;

    @Nullable
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    public boolean mCheckExposureResult;
    public long mPageEnterTime;

    @Nullable
    public JSONObject mReportExtData;
    private boolean mRewardVerifyCalled;

    @NonNull
    public AdBaseFrameLayout mRootContainer;
    public int mScreenOrientation;
    public bs mTimerHelper;

    @NonNull
    public KsVideoPlayConfig mVideoPlayConfig;
    public boolean qA;
    public List<Integer> qB;
    public int qC;
    public int qD;
    public int qE;
    public boolean qF;

    @Nullable
    public com.kwad.components.ad.reward.n.p qG;
    public boolean qH;

    @Nullable
    private PlayableSource qI;
    private boolean qJ;
    public long qK;
    private List<DialogInterface.OnDismissListener> qL;

    @Nullable
    public com.kwad.components.ad.reward.e.o qM;
    public boolean qN;

    @Nullable
    public com.kwad.components.ad.reward.l.b.a qO;

    @Nullable
    public com.kwad.components.ad.reward.l.a.a qP;
    public int qQ;
    private int qR;
    public long qS;
    public long qT;
    public boolean qU;
    private boolean qV;
    private boolean qW;
    public boolean qX;
    public boolean qY;

    @NonNull
    public LoadStrategy qZ;

    /* renamed from: qd */
    public boolean f11687qd;

    /* renamed from: qe */
    @NonNull
    public com.kwad.components.ad.reward.e.b f11688qe;

    /* renamed from: qf */
    public com.kwad.components.ad.reward.m.e f11689qf;

    /* renamed from: qg */
    @Nullable
    public IAdLiveOfflineView f11690qg;

    /* renamed from: qh */
    @Nullable
    public com.kwad.components.core.playable.a f11691qh;

    /* renamed from: qi */
    @NonNull
    public RewardActionBarControl f11692qi;

    /* renamed from: qj */
    @Nullable
    public j f11693qj;

    /* renamed from: qk */
    @Nullable
    public com.kwad.components.ad.m.a f11694qk;

    @Nullable
    public d ql;
    private final PriorityQueue<com.kwad.components.ad.reward.e.g> qm;
    public final List<com.kwad.components.ad.reward.k.a> qn;
    private final List<s> qo;
    private final List<com.kwad.components.ad.reward.m.c> qp;
    public Set<com.kwad.components.ad.reward.e.e> qq;

    @Nullable
    private com.kwad.components.core.webview.tachikoma.e.a qr;
    private boolean qs;
    private boolean qt;
    public boolean qu;
    public boolean qv;
    public boolean qw;
    public boolean qx;
    private boolean qy;
    public boolean qz;

    /* renamed from: ra */
    private RewardRenderResult f11695ra;

    /* renamed from: rb */
    private List<a> f11696rb;

    /* renamed from: rc */
    private List<b> f11697rc;

    /* renamed from: rd */
    private List<a.InterfaceC0432a> f11698rd;

    /* renamed from: com.kwad.components.ad.reward.g$1 */
    public class AnonymousClass1 implements com.kwad.components.core.l.a.a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.l.a.a
        public final void c(com.kwad.components.core.proxy.f fVar) {
            g.this.fO();
        }

        @Override // com.kwad.components.core.l.a.a
        public final void d(com.kwad.components.core.proxy.f fVar) {
            g.this.fP();
        }

        @Override // com.kwad.components.core.l.a.a
        public final void gj() {
            g.this.fN();
        }

        @Override // com.kwad.components.core.l.a.a
        public final void gk() {
            g.this.fQ();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.g$10 */
    public class AnonymousClass10 extends bd {

        /* renamed from: ri */
        final /* synthetic */ com.kwad.components.core.i.d f11701ri;

        /* renamed from: rj */
        final /* synthetic */ com.kwad.components.core.i.c f11702rj;

        public AnonymousClass10(com.kwad.components.core.i.d dVar, com.kwad.components.core.i.c cVar) {
            L = dVar;
            cVar = cVar;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            com.kwad.components.core.i.d dVar = L;
            if (dVar != null) {
                dVar.d(cVar);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.g$11 */
    public class AnonymousClass11 implements com.kwad.sdk.f.a<s> {

        /* renamed from: rk */
        final /* synthetic */ boolean f11704rk;

        public AnonymousClass11(boolean z10) {
            z10 = z10;
        }

        @Override // com.kwad.sdk.f.a
        /* renamed from: c */
        public void accept(s sVar) {
            sVar.ab(z10);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.g$12 */
    public class AnonymousClass12 implements e.a {
        final /* synthetic */ h.c rl;
        final /* synthetic */ h.a rm;

        public AnonymousClass12(h.c cVar, h.a aVar) {
            cVar = cVar;
            aVar = aVar;
        }

        @Override // com.kwad.components.core.webview.tachikoma.c.e.a
        public final boolean gn() {
            g.b(g.this, cVar, aVar);
            return true;
        }
    }

    /* renamed from: com.kwad.components.ad.reward.g$2 */
    public class AnonymousClass2 extends bd {

        /* renamed from: rf */
        final /* synthetic */ boolean f11706rf;

        /* renamed from: rg */
        final /* synthetic */ boolean f11707rg;

        public AnonymousClass2(boolean z10, boolean z11) {
            z10 = z10;
            z11 = z11;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            com.kwad.components.ad.reward.f.a ki2 = g.this.f11689qf.ki();
            if (ki2 != null) {
                ki2.setAudioEnabled(z10, z11);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.g$3 */
    public class AnonymousClass3 implements DialogInterface.OnDismissListener {
        public AnonymousClass3() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            g.this.d(dialogInterface);
            com.kwad.sdk.core.c.b.Fi();
            Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
            if (currentActivity == null || !currentActivity.equals(g.this.getActivity())) {
                return;
            }
            g.this.f11689qf.resume();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.g$4 */
    public class AnonymousClass4 extends h.b {
        public AnonymousClass4() {
        }

        @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
        public final void gl() {
            g.this.f11689qf.pause();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.g$5 */
    public class AnonymousClass5 implements com.kwad.sdk.f.a<com.kwad.components.ad.reward.m.c> {
        public AnonymousClass5() {
        }

        private static void c(com.kwad.components.ad.reward.m.c cVar) {
            cVar.iM();
        }

        @Override // com.kwad.sdk.f.a
        public final /* synthetic */ void accept(com.kwad.components.ad.reward.m.c cVar) {
            c(cVar);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.g$6 */
    public class AnonymousClass6 extends bd {
        public AnonymousClass6() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            g.this.fW();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.g$7 */
    public class AnonymousClass7 implements a.b {
        final /* synthetic */ int ls;

        /* renamed from: rh */
        final /* synthetic */ com.kwad.sdk.core.adlog.c.b f11711rh;

        public AnonymousClass7(int i10, com.kwad.sdk.core.adlog.c.b bVar) {
            i11 = i10;
            bVar = bVar;
        }

        @Override // com.kwad.components.core.e.d.a.b
        public final void onAdClicked() {
            try {
                g.this.a(i11, bVar);
            } catch (Throwable th2) {
                ServiceProvider.reportSdkCaughtException(th2);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.g$8 */
    public class AnonymousClass8 implements Callable<String> {
        public AnonymousClass8() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: gm */
        public String call() {
            com.kwad.components.ad.reward.m.e eVar = g.this.f11689qf;
            if (eVar != null) {
                return eVar.ki().getCurrentShowShopItemInfo().itemId;
            }
            return null;
        }
    }

    /* renamed from: com.kwad.components.ad.reward.g$9 */
    public class AnonymousClass9 extends bd {

        /* renamed from: ri */
        final /* synthetic */ com.kwad.components.core.i.d f11714ri;

        /* renamed from: rj */
        final /* synthetic */ com.kwad.components.core.i.c f11715rj;

        public AnonymousClass9(com.kwad.components.core.i.d dVar, com.kwad.components.core.i.c cVar) {
            L = dVar;
            cVar = cVar;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            com.kwad.components.core.i.d dVar = L;
            if (dVar != null) {
                dVar.c(cVar);
            }
        }
    }

    public interface a {
        void go();

        void gp();

        void gq();

        void gr();
    }

    public interface b {
        boolean interceptPlayCardResume();
    }

    public g(com.kwad.components.core.l.b<?> bVar) {
        super(bVar);
        this.f11687qd = false;
        this.qm = new PriorityQueue<>();
        this.qn = new CopyOnWriteArrayList();
        this.qo = new CopyOnWriteArrayList();
        this.qp = new CopyOnWriteArrayList();
        this.qq = new HashSet();
        this.qs = false;
        this.qt = false;
        this.qv = false;
        this.qw = false;
        this.qx = false;
        this.qy = false;
        this.qz = false;
        this.mRewardVerifyCalled = false;
        this.qA = false;
        this.qB = new ArrayList();
        this.mCheckExposureResult = true;
        this.qC = 1;
        this.qD = 1;
        this.qE = 0;
        this.qF = false;
        this.qH = false;
        this.qI = null;
        this.qJ = false;
        this.hG = false;
        this.qL = new CopyOnWriteArrayList();
        this.f11686hf = new Handler(Looper.getMainLooper());
        this.qN = false;
        this.qR = 2;
        this.qV = false;
        this.qW = false;
        this.qX = false;
        this.qY = false;
        this.qZ = LoadStrategy.FULL_TK;
        this.f11696rb = new CopyOnWriteArrayList();
        this.f11697rc = new CopyOnWriteArrayList();
        this.f11698rd = new CopyOnWriteArrayList();
        this.Ov.add(new com.kwad.components.core.l.a.a() { // from class: com.kwad.components.ad.reward.g.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.core.l.a.a
            public final void c(com.kwad.components.core.proxy.f fVar) {
                g.this.fO();
            }

            @Override // com.kwad.components.core.l.a.a
            public final void d(com.kwad.components.core.proxy.f fVar) {
                g.this.fP();
            }

            @Override // com.kwad.components.core.l.a.a
            public final void gj() {
                g.this.fN();
            }

            @Override // com.kwad.components.core.l.a.a
            public final void gk() {
                g.this.fQ();
            }
        });
    }

    public static boolean I(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.e.k(adTemplate, com.kwad.components.ad.reward.a.b.k(com.kwad.sdk.core.response.b.e.eb(adTemplate)));
    }

    public static boolean J(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.e.J(adTemplate);
    }

    public static boolean K(AdTemplate adTemplate) {
        if (com.kwad.sdk.core.response.b.a.cY(com.kwad.sdk.core.response.b.e.eb(adTemplate))) {
            return false;
        }
        return I(adTemplate) || J(adTemplate);
    }

    public void fN() {
        Iterator<a> it = this.f11696rb.iterator();
        while (it.hasNext()) {
            it.next().go();
        }
    }

    public void fQ() {
        Iterator<a> it = this.f11696rb.iterator();
        while (it.hasNext()) {
            it.next().gr();
        }
    }

    private void fU() {
        this.qm.clear();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.clear();
        }
        j jVar = this.f11693qj;
        if (jVar != null) {
            jVar.release();
        }
        d dVar = this.ql;
        if (dVar != null) {
            dVar.release();
        }
        Set<com.kwad.components.ad.reward.e.e> set = this.qq;
        if (set != null) {
            set.clear();
        }
    }

    public void fW() {
        try {
            int size = this.qm.size();
            for (int i10 = 0; i10 < size; i10++) {
                com.kwad.components.ad.reward.e.g poll = this.qm.poll();
                if (poll != null) {
                    poll.ch();
                }
            }
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    private static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public final void A(boolean z10) {
        this.qt = z10;
        if (z10) {
            fP();
        } else {
            fO();
        }
    }

    public final void B(boolean z10) {
        this.qW = z10;
    }

    public final void C(boolean z10) {
        this.qJ = true;
    }

    public final void D(boolean z10) {
        this.qV = true;
    }

    public final void E(boolean z10) {
        this.qs = z10;
    }

    public final void F(boolean z10) {
        if (z10 != this.mRewardVerifyCalled) {
            a(this.qo, new com.kwad.sdk.f.a<s>() { // from class: com.kwad.components.ad.reward.g.11

                /* renamed from: rk */
                final /* synthetic */ boolean f11704rk;

                public AnonymousClass11(boolean z102) {
                    z10 = z102;
                }

                @Override // com.kwad.sdk.f.a
                /* renamed from: c */
                public void accept(s sVar) {
                    sVar.ab(z10);
                }
            });
        }
        this.mRewardVerifyCalled = z102;
    }

    public final void M(int i10) {
        this.qR = i10;
    }

    public final void b(a aVar) {
        this.f11696rb.remove(aVar);
    }

    public final void d(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.qL.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
    }

    public final void fO() {
        if (this.qt || this.qs || this.qV) {
            return;
        }
        Iterator<b> it = this.f11697rc.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            z10 |= it.next().interceptPlayCardResume();
        }
        if (z10) {
            return;
        }
        Iterator<a> it2 = this.f11696rb.iterator();
        while (it2.hasNext()) {
            it2.next().gp();
        }
    }

    public final void fP() {
        Iterator<a> it = this.f11696rb.iterator();
        while (it.hasNext()) {
            it.next().gq();
        }
    }

    public final boolean fR() {
        return this.qt;
    }

    public final void fS() {
        a(this.qp, new com.kwad.sdk.f.a<com.kwad.components.ad.reward.m.c>() { // from class: com.kwad.components.ad.reward.g.5
            public AnonymousClass5() {
            }

            private static void c(com.kwad.components.ad.reward.m.c cVar) {
                cVar.iM();
            }

            @Override // com.kwad.sdk.f.a
            public final /* synthetic */ void accept(com.kwad.components.ad.reward.m.c cVar) {
                c(cVar);
            }
        });
    }

    @Nullable
    public final String fT() {
        TKAdLiveShopItemInfo tKAdLiveShopItemInfo = this.mAdTemplate.tkLiveShopItemInfo;
        if (tKAdLiveShopItemInfo == null) {
            return null;
        }
        return tKAdLiveShopItemInfo.itemId;
    }

    public final void fV() {
        if (isMainThread()) {
            fW();
        } else {
            this.f11686hf.post(new bd() { // from class: com.kwad.components.ad.reward.g.6
                public AnonymousClass6() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    g.this.fW();
                }
            });
        }
    }

    public final boolean fX() {
        return this.qW;
    }

    public final void fY() {
        com.kwad.components.core.webview.tachikoma.e.a aVar = this.qr;
        if (aVar == null) {
            return;
        }
        aVar.jv();
    }

    public final boolean fZ() {
        return this.qy;
    }

    @Nullable
    public final PlayableSource ga() {
        return this.qI;
    }

    public final boolean gb() {
        return this.qJ;
    }

    public final List<a.InterfaceC0432a> gc() {
        return this.f11698rd;
    }

    public final RewardRenderResult gd() {
        return this.f11695ra;
    }

    public final boolean ge() {
        return RewardRenderResult.NEO_TK.equals(this.f11695ra);
    }

    public final boolean gf() {
        return this.qV;
    }

    public final boolean gg() {
        return this.qs;
    }

    public final boolean gh() {
        return this.mRewardVerifyCalled;
    }

    public final void gi() {
        long j10 = this.qT;
        int i10 = j10 != 0 ? (int) (j10 / 1000) : 0;
        AdTemplate adTemplate = this.mAdTemplate;
        com.kwad.sdk.core.adlog.c.f(adTemplate, com.kwad.sdk.core.response.b.a.ae(com.kwad.sdk.core.response.b.e.eb(adTemplate)), i10);
    }

    @Override // com.kwad.components.core.l.a, com.kwad.sdk.mvp.a
    public final void release() {
        fU();
        com.kwad.components.ad.reward.m.e eVar = this.f11689qf;
        if (eVar != null) {
            eVar.release();
        }
    }

    public final void z(String str) {
        int i10 = -1;
        try {
            if (com.kwad.sdk.core.config.d.Af()) {
                i10 = com.kwad.components.ad.reward.j.a.a(getActivity());
            }
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
        }
        com.kwad.components.ad.reward.j.b.a(this.mContext, this.mAdTemplate, str, i10, this.mReportExtData);
    }

    public static boolean g(AdInfo adInfo) {
        return com.kwad.sdk.core.response.b.b.g(adInfo) && !com.kwad.components.ad.reward.a.b.k(adInfo);
    }

    public final void a(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.b.c.o(adResultData);
    }

    public final void b(b bVar) {
        this.f11697rc.remove(bVar);
    }

    @MainThread
    public final void c(com.kwad.components.ad.reward.e.g gVar) {
        this.qm.remove(gVar);
    }

    public final void e(boolean z10, boolean z11) {
        if (this.f11689qf.kh()) {
            bt.runOnUiThreadDelay(new bd() { // from class: com.kwad.components.ad.reward.g.2

                /* renamed from: rf */
                final /* synthetic */ boolean f11706rf;

                /* renamed from: rg */
                final /* synthetic */ boolean f11707rg;

                public AnonymousClass2(boolean z102, boolean z112) {
                    z10 = z102;
                    z11 = z112;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    com.kwad.components.ad.reward.f.a ki2 = g.this.f11689qf.ki();
                    if (ki2 != null) {
                        ki2.setAudioEnabled(z10, z11);
                    }
                }
            }, 500L);
        }
    }

    private static com.kwad.components.ad.reward.k.a.b c(g gVar) {
        e.b bVar = new e.b();
        bVar.a(gVar.mAdResultData);
        bVar.aZ(com.kwad.sdk.core.response.b.b.dF(gVar.mAdTemplate));
        bVar.aX(false);
        bVar.aY(true);
        return com.kwad.components.ad.reward.k.a.b.a(gVar, bVar);
    }

    public final void b(com.kwad.components.ad.reward.k.a aVar) {
        this.qn.remove(aVar);
    }

    public final void d(@Nullable PlayableSource playableSource) {
        this.qI = playableSource;
    }

    private static com.kwad.components.ad.reward.k.a.b d(g gVar) {
        if (com.kwad.sdk.core.response.b.a.ci(com.kwad.sdk.core.response.b.e.eb(gVar.mAdTemplate)) == 4 || com.kwad.sdk.core.response.b.a.ci(com.kwad.sdk.core.response.b.e.eb(gVar.mAdTemplate)) == 3) {
            return c(gVar);
        }
        return null;
    }

    public final void a(a aVar) {
        this.f11696rb.add(aVar);
    }

    public final void b(s sVar) {
        this.qo.remove(sVar);
    }

    public final void a(b bVar) {
        this.f11697rc.add(bVar);
    }

    public final void b(com.kwad.components.ad.reward.m.c cVar) {
        if (cVar != null) {
            this.qp.remove(cVar);
        }
    }

    public final void a(com.kwad.components.ad.reward.k.a aVar) {
        this.qn.add(aVar);
    }

    @MainThread
    public final void b(com.kwad.components.ad.reward.e.g gVar) {
        this.qm.offer(gVar);
    }

    public final void a(s sVar) {
        this.qo.add(sVar);
    }

    public final void b(int i10, Context context, int i11, int i12) {
        a(i10, context, i11, i12, 0L, false, null);
    }

    public final void a(com.kwad.components.ad.reward.m.c cVar) {
        if (cVar != null) {
            this.qp.add(cVar);
        }
    }

    public final void b(DialogInterface.OnDismissListener onDismissListener) {
        this.qL.remove(onDismissListener);
    }

    public static <T> void a(List<T> list, com.kwad.sdk.f.a<T> aVar) {
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                aVar.accept(it.next());
            }
        }
    }

    public final void b(com.kwad.components.ad.reward.c.b bVar) {
        com.kwad.components.ad.reward.c.a.hg().a(this.mAdTemplate, bVar);
    }

    public final void b(com.kwad.components.core.i.c cVar) {
        bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.reward.g.10

            /* renamed from: ri */
            final /* synthetic */ com.kwad.components.core.i.d f11701ri;

            /* renamed from: rj */
            final /* synthetic */ com.kwad.components.core.i.c f11702rj;

            public AnonymousClass10(com.kwad.components.core.i.d dVar, com.kwad.components.core.i.c cVar2) {
                L = dVar;
                cVar = cVar2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                com.kwad.components.core.i.d dVar = L;
                if (dVar != null) {
                    dVar.d(cVar);
                }
            }
        });
    }

    public final void a(long j10, long j11, int i10) {
        Iterator<com.kwad.components.ad.reward.e.e> it = this.qq.iterator();
        while (it.hasNext()) {
            it.next().cA();
        }
    }

    public final void a(int i10, Context context, int i11, int i12) {
        b(i10, context, i11, i12);
    }

    public final void b(a.InterfaceC0432a interfaceC0432a) {
        List<a.InterfaceC0432a> list = this.f11698rd;
        if (list != null) {
            list.remove(interfaceC0432a);
        }
    }

    public final void a(int i10, Context context, int i11, int i12, long j10) {
        a(1, context, 40, 1, j10, false, null);
    }

    public static boolean b(g gVar) {
        return gVar.qs;
    }

    public final void a(int i10, Context context, int i11, int i12, long j10, boolean z10, com.kwad.sdk.core.adlog.c.b bVar) {
        com.kwad.components.core.e.d.a.a(new a.C0427a(context).au(this.mAdTemplate).b(this.mApkDownloadHelper).ap(false).ao(i12).v(j10).an(i11).am(i10).ah(fT()).a(new Callable<String>() { // from class: com.kwad.components.ad.reward.g.8
            public AnonymousClass8() {
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: gm */
            public String call() {
                com.kwad.components.ad.reward.m.e eVar = g.this.f11689qf;
                if (eVar != null) {
                    return eVar.ki().getCurrentShowShopItemInfo().itemId;
                }
                return null;
            }
        }).a(new a.b() { // from class: com.kwad.components.ad.reward.g.7
            final /* synthetic */ int ls;

            /* renamed from: rh */
            final /* synthetic */ com.kwad.sdk.core.adlog.c.b f11711rh;

            public AnonymousClass7(int i112, com.kwad.sdk.core.adlog.c.b bVar2) {
                i11 = i112;
                bVar = bVar2;
            }

            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                try {
                    g.this.a(i11, bVar);
                } catch (Throwable th2) {
                    ServiceProvider.reportSdkCaughtException(th2);
                }
            }
        }));
    }

    public static void b(g gVar, h.c cVar, h.a aVar) {
        boolean b10 = b(gVar);
        com.kwad.sdk.core.d.c.d("RewardCallerContext", "showNativeCloseDialog isCloseDialogShowing: " + b10);
        if (b10) {
            return;
        }
        h.a(gVar.getActivity(), gVar.mAdTemplate, cVar, aVar);
    }

    public void a(int i10, com.kwad.sdk.core.adlog.c.b bVar) {
        if (bVar == null) {
            bVar = new com.kwad.sdk.core.adlog.c.b();
        }
        bVar.cL(i10);
        bVar.f(this.mRootContainer.getTouchCoords());
        com.kwad.components.ad.reward.j.b.a(this.mAdTemplate, (String) null, (String) null, bVar, this.mReportExtData);
        com.kwad.components.ad.reward.c.a.hg().c(this.mAdTemplate, com.kwad.components.ad.reward.c.b.STATUS_NONE);
        this.f11688qe.cg();
    }

    public final void a(DialogInterface.OnDismissListener onDismissListener) {
        this.qL.add(onDismissListener);
    }

    public final void a(@Nullable com.kwad.components.ad.reward.e.o oVar) {
        this.qM = oVar;
    }

    public final void a(com.kwad.components.core.webview.tachikoma.e.a aVar) {
        this.qr = aVar;
    }

    public final void a(com.kwad.components.core.i.c cVar) {
        bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.reward.g.9

            /* renamed from: ri */
            final /* synthetic */ com.kwad.components.core.i.d f11714ri;

            /* renamed from: rj */
            final /* synthetic */ com.kwad.components.core.i.c f11715rj;

            public AnonymousClass9(com.kwad.components.core.i.d dVar, com.kwad.components.core.i.c cVar2) {
                L = dVar;
                cVar = cVar2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                com.kwad.components.core.i.d dVar = L;
                if (dVar != null) {
                    dVar.c(cVar);
                }
            }
        });
    }

    public final void a(a.InterfaceC0432a interfaceC0432a) {
        List<a.InterfaceC0432a> list = this.f11698rd;
        if (list != null) {
            list.add(interfaceC0432a);
        }
    }

    @Nullable
    public static com.kwad.components.core.i.c a(List<com.kwad.components.core.i.c> list, long j10) {
        if (j10 >= 0 && list != null) {
            for (com.kwad.components.core.i.c cVar : list) {
                if (com.kwad.sdk.core.response.b.e.el(cVar.getAdTemplate()) == j10) {
                    return cVar;
                }
            }
        }
        return null;
    }

    public final void a(RewardRenderResult rewardRenderResult) {
        this.f11695ra = rewardRenderResult;
    }

    public static void a(Context context, g gVar, ViewGroup viewGroup) {
        IAdLiveOfflineView iAdLiveOfflineView;
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(gVar.mAdTemplate);
        com.kwad.components.core.n.a.a.a aVar = (com.kwad.components.core.n.a.a.a) com.kwad.sdk.components.d.f(com.kwad.components.core.n.a.a.a.class);
        if (aVar != null && aVar.pz() && com.kwad.sdk.core.response.b.a.cS(com.kwad.sdk.core.response.b.e.eb(gVar.mAdTemplate))) {
            try {
                iAdLiveOfflineView = com.kwad.components.ad.k.b.a(aVar, context, com.kwad.sdk.core.response.b.a.bf(eb2) == 8 ? 1 : 0);
            } catch (Throwable unused) {
                iAdLiveOfflineView = null;
            }
            IAdLiveOfflineView iAdLiveOfflineView2 = iAdLiveOfflineView;
            if (iAdLiveOfflineView2 != null) {
                View view = iAdLiveOfflineView2.getView();
                gVar.f11690qg = iAdLiveOfflineView2;
                viewGroup.addView(view);
                gVar.f11689qf.a(2, new com.kwad.components.ad.reward.f.a(gVar.mAdTemplate, aVar.getAdLivePlayModule(iAdLiveOfflineView2, ServiceProvider.getAppId(), String.valueOf(com.kwad.sdk.core.response.b.a.cn(eb2)), com.kwad.sdk.core.response.b.a.co(eb2), com.kwad.sdk.core.response.b.a.cp(eb2))));
            }
        }
    }

    public static long a(long j10, AdInfo adInfo) {
        return Math.min(com.kwad.sdk.core.response.b.a.ag(adInfo), j10);
    }

    public static void a(g gVar, h.c cVar, h.a aVar) {
        if (!gVar.f11689qf.kh()) {
            AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(gVar.mAdTemplate);
            r1 = (com.kwad.components.ad.reward.a.b.j(eb2) || com.kwad.sdk.core.response.b.a.ci(eb2) == 2) ? c(gVar) : null;
            if (r1 == null) {
                r1 = d(gVar);
            }
        }
        com.kwad.components.ad.reward.k.a.b bVar = r1;
        if (bVar != null) {
            com.kwad.components.ad.reward.k.a.b.a(bVar, gVar.getActivity(), gVar.f11689qf.getPlayDuration(), aVar, new e.a() { // from class: com.kwad.components.ad.reward.g.12
                final /* synthetic */ h.c rl;
                final /* synthetic */ h.a rm;

                public AnonymousClass12(h.c cVar2, h.a aVar2) {
                    cVar = cVar2;
                    aVar = aVar2;
                }

                @Override // com.kwad.components.core.webview.tachikoma.c.e.a
                public final boolean gn() {
                    g.b(g.this, cVar, aVar);
                    return true;
                }
            });
        } else {
            b(gVar, cVar2, aVar2);
        }
    }

    public static void a(Activity activity, g gVar) {
        com.kwad.sdk.core.d.c.d("RewardCallerContext", "showExtraDialog");
        com.kwad.components.ad.reward.k.a.b.a(gVar, activity, gVar.f11689qf.getPlayDuration(), new DialogInterface.OnDismissListener() { // from class: com.kwad.components.ad.reward.g.3
            public AnonymousClass3() {
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                g.this.d(dialogInterface);
                com.kwad.sdk.core.c.b.Fi();
                Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
                if (currentActivity == null || !currentActivity.equals(g.this.getActivity())) {
                    return;
                }
                g.this.f11689qf.resume();
            }
        }, new h.b() { // from class: com.kwad.components.ad.reward.g.4
            public AnonymousClass4() {
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
            public final void gl() {
                g.this.f11689qf.pause();
            }
        });
    }
}
