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
import com.kwad.components.ad.reward.h.s;
import com.kwad.components.ad.reward.k;
import com.kwad.components.ad.reward.presenter.e;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.g.a;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.webview.a.b.d;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bi;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class j extends com.kwad.components.core.j.a {
    public boolean fO;

    @NonNull
    public com.kwad.components.ad.reward.d.b mAdOpenInteractionListener;

    @NonNull
    public com.kwad.components.ad.reward.d.d mAdRewardStepListener;

    @Nullable
    public com.kwad.components.core.d.b.c mApkDownloadHelper;
    public boolean mCheckExposureResult;
    private Handler mHandler;
    public long mPageEnterTime;

    @Nullable
    public JSONObject mReportExtData;
    private boolean mRewardVerifyCalled;

    @NonNull
    public AdBaseFrameLayout mRootContainer;
    public int mScreenOrientation;
    public bh mTimerHelper;

    @NonNull
    public KsVideoPlayConfig mVideoPlayConfig;
    public DetailVideoView oM;

    @NonNull
    public com.kwad.components.ad.reward.j.b oN;

    @Nullable
    public IAdLiveOfflineView oO;

    @Nullable
    public com.kwad.components.core.playable.a oP;

    @NonNull
    public RewardActionBarControl oQ;

    @Nullable
    public l oR;

    @Nullable
    public com.kwad.components.ad.i.b oS;

    @Nullable
    public com.kwad.components.ad.i.a oT;

    @Nullable
    public g oU;
    private final PriorityQueue<com.kwad.components.ad.reward.d.f> oV;
    public final List<com.kwad.components.ad.reward.h.a> oW;
    private final List<s> oX;
    public Set<com.kwad.components.ad.reward.d.e> oY;

    @Nullable
    private com.kwad.components.ad.reward.g.c oZ;
    public long pA;
    public long pB;
    public boolean pC;
    private boolean pD;
    private boolean pE;
    public boolean pF;
    public boolean pG;
    public boolean pH;

    @NonNull
    public LoadStrategy pI;
    private RewardRenderResult pJ;
    private List<a> pK;
    private List<b> pL;
    private List<a.InterfaceC0176a> pM;

    @Nullable
    private com.kwad.components.core.webview.a.d.a pa;

    @Nullable
    private e.a pb;
    private boolean pc;
    private boolean pd;
    private boolean pe;
    public boolean pf;
    public boolean pg;
    public boolean ph;
    public boolean pi;
    private boolean pj;
    public boolean pk;
    public boolean pl;
    public List<Integer> pm;
    public int pn;
    public boolean po;

    @Nullable
    public com.kwad.components.ad.reward.k.o pp;
    public boolean pq;

    @Nullable
    private PlayableSource pr;
    private boolean ps;
    private List<DialogInterface.OnDismissListener> pt;

    @Nullable
    public com.kwad.components.ad.reward.d.m pu;
    public boolean pv;

    @Nullable
    public com.kwad.components.ad.reward.i.a.a pw;

    @Nullable
    public com.kwad.components.ad.reward.i.kwai.a px;
    public int py;
    private int pz;

    /* renamed from: com.kwad.components.ad.reward.j$1 */
    final class AnonymousClass1 implements com.kwad.components.core.j.kwai.a {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.j.kwai.a
        public final void a(com.kwad.components.core.l.d dVar) {
            j.this.fB();
        }

        @Override // com.kwad.components.core.j.kwai.a
        public final void b(com.kwad.components.core.l.d dVar) {
            j.this.fC();
        }

        @Override // com.kwad.components.core.j.kwai.a
        public final void c(com.kwad.components.core.l.d dVar) {
            j.this.fD();
        }

        @Override // com.kwad.components.core.j.kwai.a
        public final void fY() {
            j.this.fA();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.j$10 */
    static class AnonymousClass10 implements DialogInterface.OnDismissListener {
        AnonymousClass10() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            j.this.d(dialogInterface);
            com.kwad.sdk.core.b.b.vS();
            Activity currentActivity = com.kwad.sdk.core.b.b.getCurrentActivity();
            if (currentActivity == null || !currentActivity.equals(j.this.getActivity())) {
                return;
            }
            j.this.oN.resume();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.j$2 */
    static class AnonymousClass2 extends k.b {
        AnonymousClass2() {
        }

        @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.core.webview.a.d.c
        public final void fZ() {
            j.this.oN.pause();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.j$3 */
    final class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            j.this.fI();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.j$4 */
    final class AnonymousClass4 implements a.b {
        final /* synthetic */ int jM;
        final /* synthetic */ com.kwad.sdk.core.report.i pO;

        AnonymousClass4(int i2, com.kwad.sdk.core.report.i iVar) {
            i3 = i2;
            iVar = iVar;
        }

        @Override // com.kwad.components.core.d.b.a.b
        public final void onAdClicked() {
            j.this.a(i3, iVar);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.j$5 */
    final class AnonymousClass5 implements Runnable {
        final /* synthetic */ com.kwad.components.core.g.d pP;
        final /* synthetic */ com.kwad.components.core.g.c pQ;

        AnonymousClass5(com.kwad.components.core.g.d dVar, com.kwad.components.core.g.c cVar) {
            H = dVar;
            cVar = cVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.components.core.g.d dVar = H;
            if (dVar != null) {
                dVar.c(cVar);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.j$6 */
    final class AnonymousClass6 implements Runnable {
        final /* synthetic */ com.kwad.components.core.g.d pP;
        final /* synthetic */ com.kwad.components.core.g.c pQ;

        AnonymousClass6(com.kwad.components.core.g.d dVar, com.kwad.components.core.g.c cVar) {
            H = dVar;
            cVar = cVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.components.core.g.d dVar = H;
            if (dVar != null) {
                dVar.d(cVar);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.j$7 */
    final class AnonymousClass7 implements com.kwad.sdk.e.a<s> {
        final /* synthetic */ boolean pR;

        AnonymousClass7(boolean z) {
            z = z;
        }

        @Override // com.kwad.sdk.e.a
        /* renamed from: c */
        public void accept(s sVar) {
            sVar.af(z);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.j$8 */
    static class AnonymousClass8 implements d.a {
        final /* synthetic */ k.c pS;
        final /* synthetic */ k.a pT;

        AnonymousClass8(k.c cVar, k.a aVar) {
            cVar = cVar;
            aVar = aVar;
        }

        @Override // com.kwad.components.core.webview.a.b.d.a
        public final boolean ga() {
            j.b(j.this, cVar, aVar);
            return true;
        }
    }

    /* renamed from: com.kwad.components.ad.reward.j$9 */
    final class AnonymousClass9 implements Runnable {
        final /* synthetic */ boolean pU;
        final /* synthetic */ boolean pV;

        AnonymousClass9(boolean z, boolean z2) {
            z = z;
            z2 = z2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            j.this.oN.jG().setAudioEnabled(z, z2);
        }
    }

    public interface a {
        void gb();

        void gc();

        void gd();

        void ge();
    }

    public interface b {
        boolean interceptPlayCardResume();
    }

    public j(com.kwad.components.core.j.b<?> bVar) {
        super(bVar);
        this.oV = new PriorityQueue<>();
        this.oW = new CopyOnWriteArrayList();
        this.oX = new CopyOnWriteArrayList();
        this.oY = new HashSet();
        this.pc = false;
        this.pd = false;
        this.pe = false;
        this.pg = false;
        this.ph = false;
        this.pi = false;
        this.pj = false;
        this.pk = false;
        this.mRewardVerifyCalled = false;
        this.pl = false;
        this.pm = new ArrayList();
        this.mCheckExposureResult = true;
        this.pn = 0;
        this.po = false;
        this.pq = false;
        this.pr = null;
        this.ps = false;
        this.pt = new CopyOnWriteArrayList();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.pv = false;
        this.pz = 2;
        this.pD = false;
        this.pE = false;
        this.pF = false;
        this.pG = false;
        this.pH = false;
        this.pI = LoadStrategy.FULL_TK;
        this.pK = new CopyOnWriteArrayList();
        this.pL = new CopyOnWriteArrayList();
        this.pM = new CopyOnWriteArrayList();
        this.JT.add(new com.kwad.components.core.j.kwai.a() { // from class: com.kwad.components.ad.reward.j.1
            AnonymousClass1() {
            }

            @Override // com.kwad.components.core.j.kwai.a
            public final void a(com.kwad.components.core.l.d dVar) {
                j.this.fB();
            }

            @Override // com.kwad.components.core.j.kwai.a
            public final void b(com.kwad.components.core.l.d dVar) {
                j.this.fC();
            }

            @Override // com.kwad.components.core.j.kwai.a
            public final void c(com.kwad.components.core.l.d dVar) {
                j.this.fD();
            }

            @Override // com.kwad.components.core.j.kwai.a
            public final void fY() {
                j.this.fA();
            }
        });
    }

    public static long a(long j2, AdInfo adInfo) {
        return Math.min(com.kwad.sdk.core.response.a.a.X(adInfo), j2);
    }

    @Nullable
    public static com.kwad.components.core.g.c a(List<com.kwad.components.core.g.c> list, long j2) {
        if (j2 >= 0 && list != null) {
            for (com.kwad.components.core.g.c cVar : list) {
                if (com.kwad.sdk.core.response.a.d.cl(cVar.getAdTemplate()) == j2) {
                    return cVar;
                }
            }
        }
        return null;
    }

    public void a(int i2, com.kwad.sdk.core.report.i iVar) {
        if (iVar == null) {
            iVar = new com.kwad.sdk.core.report.i();
        }
        iVar.bj(i2);
        iVar.c(this.mRootContainer.getTouchCoords());
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, iVar.wY(), this.mReportExtData);
        com.kwad.components.ad.reward.b.a.gQ().d(this.mAdTemplate, com.kwad.components.ad.reward.b.b.STATUS_NONE);
        this.mAdOpenInteractionListener.bN();
    }

    public static void a(Activity activity, j jVar) {
        com.kwad.components.ad.reward.h.kwai.b.a(jVar, activity, jVar.oN.getPlayDuration(), new DialogInterface.OnDismissListener() { // from class: com.kwad.components.ad.reward.j.10
            AnonymousClass10() {
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                j.this.d(dialogInterface);
                com.kwad.sdk.core.b.b.vS();
                Activity currentActivity = com.kwad.sdk.core.b.b.getCurrentActivity();
                if (currentActivity == null || !currentActivity.equals(j.this.getActivity())) {
                    return;
                }
                j.this.oN.resume();
            }
        }, new k.b() { // from class: com.kwad.components.ad.reward.j.2
            AnonymousClass2() {
            }

            @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.core.webview.a.d.c
            public final void fZ() {
                j.this.oN.pause();
            }
        });
    }

    public static void a(Context context, j jVar, ViewGroup viewGroup) {
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(jVar.mAdTemplate);
        com.kwad.components.core.offline.api.kwai.a aVar = (com.kwad.components.core.offline.api.kwai.a) com.kwad.sdk.components.c.f(com.kwad.components.core.offline.api.kwai.a.class);
        if (aVar != null && aVar.hasLiveCompoReady() && com.kwad.sdk.core.response.a.a.cq(com.kwad.sdk.core.response.a.d.cb(jVar.mAdTemplate))) {
            IAdLiveOfflineView view = aVar.getView(context, com.kwad.sdk.core.response.a.a.aX(cb) == 8 ? 1 : 0);
            View view2 = view.getView();
            jVar.oO = view;
            viewGroup.addView(view2);
            jVar.oN.a(aVar.getAdLivePlayModule(view, KsAdSDKImpl.get().getAppId(), String.valueOf(com.kwad.sdk.core.response.a.a.bN(cb))));
        }
    }

    public static void a(j jVar, k.c cVar, k.a aVar) {
        if (!jVar.oN.jF()) {
            AdInfo cb = com.kwad.sdk.core.response.a.d.cb(jVar.mAdTemplate);
            r1 = com.kwad.components.ad.reward.kwai.b.k(cb) || com.kwad.sdk.core.response.a.a.ci(cb) ? f(jVar) : null;
            if (r1 == null) {
                r1 = g(jVar);
            }
        }
        com.kwad.components.ad.reward.h.kwai.b bVar = r1;
        if (bVar != null) {
            com.kwad.components.ad.reward.h.kwai.b.a(bVar, jVar.getActivity(), jVar.oN.getPlayDuration(), aVar, new d.a() { // from class: com.kwad.components.ad.reward.j.8
                final /* synthetic */ k.c pS;
                final /* synthetic */ k.a pT;

                AnonymousClass8(k.c cVar2, k.a aVar2) {
                    cVar = cVar2;
                    aVar = aVar2;
                }

                @Override // com.kwad.components.core.webview.a.b.d.a
                public final boolean ga() {
                    j.b(j.this, cVar, aVar);
                    return true;
                }
            });
        } else {
            b(jVar, cVar2, aVar2);
        }
    }

    public static <T> void a(List<T> list, com.kwad.sdk.e.a<T> aVar) {
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                aVar.accept(it.next());
            }
        }
    }

    public static boolean a(j jVar) {
        AdMatrixInfo.FullScreenInfo bJ;
        return com.kwad.sdk.core.config.d.isCanUseTk() && (bJ = com.kwad.sdk.core.response.a.b.bJ(jVar.mAdTemplate)) != null && bJ.renderType == 1 && !com.kwad.sdk.core.response.a.a.aI(jVar.mAdTemplate);
    }

    public static void b(j jVar, k.c cVar, k.a aVar) {
        boolean e2 = e(jVar);
        new StringBuilder("showNativeCloseDialog isCloseDialogShowing: ").append(e2);
        if (e2) {
            return;
        }
        k.a(jVar.getActivity(), jVar.mAdTemplate, cVar, aVar);
    }

    public static boolean b(j jVar) {
        boolean z = false;
        if (jVar.oN.jF() || !com.kwad.sdk.core.config.d.isCanUseTk() || com.kwad.sdk.components.c.f(com.kwad.components.core.offline.api.a.c.class) == null) {
            return false;
        }
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(jVar.mAdTemplate);
        boolean z2 = (com.kwad.sdk.core.response.a.a.ck(cb) || (com.kwad.sdk.core.response.a.a.bv(cb) && com.kwad.components.ad.reward.kwai.b.gD()) || com.kwad.sdk.core.response.a.d.cn(jVar.mAdTemplate)) ? false : true;
        jVar.ph = z2 && !jVar.pG;
        if (z2 && !jVar.pG) {
            z = true;
        }
        jVar.E(z);
        return z2;
    }

    public static boolean c(j jVar) {
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(jVar.mAdTemplate);
        boolean z = false;
        if (jVar.oN.jF() || com.kwad.sdk.core.response.a.a.cq(cb) || !com.kwad.sdk.core.config.d.isCanUseTk() || com.kwad.sdk.components.c.f(com.kwad.components.core.offline.api.a.c.class) == null || a(jVar)) {
            return false;
        }
        boolean z2 = com.kwad.components.ad.reward.kwai.b.k(cb) || !(com.kwad.components.ad.reward.kwai.b.j(cb) || com.kwad.sdk.core.response.a.d.co(jVar.mAdTemplate) || com.kwad.sdk.core.response.a.a.ck(cb));
        if (z2 && !jVar.pG) {
            z = true;
        }
        jVar.ph = z;
        return z2;
    }

    public static boolean d(j jVar) {
        if (jVar.oN.jF() || !com.kwad.sdk.core.config.d.isCanUseTk() || com.kwad.sdk.components.c.f(com.kwad.components.core.offline.api.a.c.class) == null || jVar.pF) {
            return false;
        }
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(jVar.mAdTemplate);
        if (com.kwad.sdk.core.response.a.a.cv(cb)) {
            return true;
        }
        return (o(jVar.mAdTemplate) || p(jVar.mAdTemplate) || !(com.kwad.components.ad.reward.kwai.b.k(cb) || (!com.kwad.components.ad.reward.kwai.b.j(cb) && !com.kwad.sdk.core.response.a.a.ck(cb) && !(com.kwad.sdk.core.response.a.a.bv(cb) && com.kwad.components.ad.reward.kwai.b.gD()) && !com.kwad.sdk.core.response.a.d.co(jVar.mAdTemplate) && !com.kwad.sdk.core.response.a.a.aI(jVar.mAdTemplate)))) ? false : true;
    }

    public static boolean e(j jVar) {
        return jVar.pc;
    }

    private static com.kwad.components.ad.reward.h.kwai.b f(j jVar) {
        d.b bVar = new d.b();
        bVar.setAdTemplate(jVar.mAdTemplate);
        bVar.aP("ksad-video-confirm-card");
        bVar.aQ(false);
        bVar.aR(true);
        return com.kwad.components.ad.reward.h.kwai.b.a(jVar, bVar);
    }

    public void fA() {
        Iterator<a> it = this.pK.iterator();
        while (it.hasNext()) {
            it.next().gb();
        }
    }

    public void fB() {
        if (this.pd || this.pc || this.pD) {
            return;
        }
        boolean z = false;
        Iterator<b> it = this.pL.iterator();
        while (it.hasNext()) {
            z |= it.next().interceptPlayCardResume();
        }
        if (z) {
            return;
        }
        Iterator<a> it2 = this.pK.iterator();
        while (it2.hasNext()) {
            it2.next().gc();
        }
    }

    public void fC() {
        Iterator<a> it = this.pK.iterator();
        while (it.hasNext()) {
            it.next().gd();
        }
    }

    public void fD() {
        Iterator<a> it = this.pK.iterator();
        while (it.hasNext()) {
            it.next().ge();
        }
    }

    private void fG() {
        this.JT.clear();
        this.oV.clear();
        com.kwad.components.core.d.b.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.clear();
        }
        l lVar = this.oR;
        if (lVar != null) {
            lVar.release();
        }
        g gVar = this.oU;
        if (gVar != null) {
            gVar.release();
        }
        Set<com.kwad.components.ad.reward.d.e> set = this.oY;
        if (set != null) {
            set.clear();
        }
    }

    public void fI() {
        int size = this.oV.size();
        for (int i2 = 0; i2 < size; i2++) {
            com.kwad.components.ad.reward.d.f poll = this.oV.poll();
            if (poll != null) {
                poll.bM();
            }
        }
    }

    private static com.kwad.components.ad.reward.h.kwai.b g(j jVar) {
        if (!com.kwad.sdk.core.response.a.a.cp(com.kwad.sdk.core.response.a.d.cb(jVar.mAdTemplate)) && !com.kwad.sdk.core.response.a.a.cr(com.kwad.sdk.core.response.a.d.cb(jVar.mAdTemplate))) {
            return null;
        }
        d.b bVar = new d.b();
        bVar.setAdTemplate(jVar.mAdTemplate);
        bVar.aP("ksad-video-confirm-card");
        bVar.aQ(false);
        bVar.aR(true);
        return com.kwad.components.ad.reward.h.kwai.b.a(jVar, bVar);
    }

    public static boolean h(AdInfo adInfo) {
        return com.kwad.sdk.core.response.a.b.h(adInfo) && !com.kwad.components.ad.reward.kwai.b.l(adInfo);
    }

    private static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static boolean o(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.a.d.g(adTemplate, com.kwad.components.ad.reward.kwai.b.l(com.kwad.sdk.core.response.a.d.cb(adTemplate)));
    }

    public static boolean p(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.a.d.p(adTemplate);
    }

    public static boolean q(AdTemplate adTemplate) {
        if (com.kwad.sdk.core.response.a.a.cv(com.kwad.sdk.core.response.a.d.cb(adTemplate))) {
            return false;
        }
        return o(adTemplate) || p(adTemplate);
    }

    public final void A(boolean z) {
        this.pd = z;
        if (z) {
            fC();
        } else {
            fB();
        }
    }

    public final void B(boolean z) {
        com.kwad.components.ad.reward.g.c cVar = this.oZ;
        if (cVar == null) {
            return;
        }
        cVar.onPlayAgainClick(z);
    }

    public final void C(boolean z) {
        this.pE = z;
    }

    public final void D(boolean z) {
        this.pe = true;
    }

    public final void E(boolean z) {
        this.pj = z;
    }

    public final void F(boolean z) {
        this.ps = true;
    }

    public final void G(boolean z) {
        this.pD = true;
    }

    public final void H(boolean z) {
        this.pc = z;
    }

    public final void I(boolean z) {
        if (z != this.mRewardVerifyCalled) {
            a(this.oX, new com.kwad.sdk.e.a<s>() { // from class: com.kwad.components.ad.reward.j.7
                final /* synthetic */ boolean pR;

                AnonymousClass7(boolean z2) {
                    z = z2;
                }

                @Override // com.kwad.sdk.e.a
                /* renamed from: c */
                public void accept(s sVar) {
                    sVar.af(z);
                }
            });
        }
        this.mRewardVerifyCalled = z2;
    }

    public final void N(int i2) {
        this.pz = i2;
    }

    public final void a(int i2, Context context, int i3, int i4) {
        b(i2, context, i3, i4);
    }

    public final void a(int i2, Context context, int i3, int i4, long j2) {
        a(1, context, 40, 1, j2, false, null);
    }

    public final void a(int i2, Context context, int i3, int i4, long j2, boolean z, com.kwad.sdk.core.report.i iVar) {
        com.kwad.components.core.d.b.a.a(new a.C0172a(context).I(this.mAdTemplate).b(this.mApkDownloadHelper).ao(false).ap(i4).q(j2).ao(i3).an(i2).ap(fF()).b(this.oN.jG()).a(new a.b() { // from class: com.kwad.components.ad.reward.j.4
            final /* synthetic */ int jM;
            final /* synthetic */ com.kwad.sdk.core.report.i pO;

            AnonymousClass4(int i32, com.kwad.sdk.core.report.i iVar2) {
                i3 = i32;
                iVar = iVar2;
            }

            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                j.this.a(i3, iVar);
            }
        }));
    }

    public final void a(long j2, long j3, int i2) {
        Iterator<com.kwad.components.ad.reward.d.e> it = this.oY.iterator();
        while (it.hasNext()) {
            it.next().cg();
        }
    }

    public final void a(DialogInterface.OnDismissListener onDismissListener) {
        this.pt.add(onDismissListener);
    }

    public final void a(RewardRenderResult rewardRenderResult) {
        this.pJ = rewardRenderResult;
    }

    public final void a(@Nullable com.kwad.components.ad.reward.d.m mVar) {
        this.pu = mVar;
    }

    public final void a(com.kwad.components.ad.reward.g.c cVar) {
        this.oZ = cVar;
    }

    public final void a(com.kwad.components.ad.reward.h.a aVar) {
        this.oW.add(aVar);
    }

    public final void a(s sVar) {
        this.oX.add(sVar);
    }

    public final void a(a aVar) {
        this.pK.add(aVar);
    }

    public final void a(b bVar) {
        this.pL.add(bVar);
    }

    public final void a(@Nullable e.a aVar) {
        this.pb = aVar;
    }

    public final void a(a.InterfaceC0176a interfaceC0176a) {
        List<a.InterfaceC0176a> list = this.pM;
        if (list != null) {
            list.add(interfaceC0176a);
        }
    }

    public final void a(com.kwad.components.core.g.c cVar) {
        bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.j.5
            final /* synthetic */ com.kwad.components.core.g.d pP;
            final /* synthetic */ com.kwad.components.core.g.c pQ;

            AnonymousClass5(com.kwad.components.core.g.d dVar, com.kwad.components.core.g.c cVar2) {
                H = dVar;
                cVar = cVar2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.components.core.g.d dVar = H;
                if (dVar != null) {
                    dVar.c(cVar);
                }
            }
        });
    }

    public final void a(com.kwad.components.core.webview.a.d.a aVar) {
        this.pa = aVar;
    }

    public final void b(int i2, Context context, int i3, int i4) {
        a(i2, context, i3, i4, 0L, false, null);
    }

    public final void b(DialogInterface.OnDismissListener onDismissListener) {
        this.pt.remove(onDismissListener);
    }

    public final void b(com.kwad.components.ad.reward.b.b bVar) {
        com.kwad.components.ad.reward.b.a.gQ().a(this.mAdTemplate, bVar);
    }

    @MainThread
    public final void b(com.kwad.components.ad.reward.d.f fVar) {
        this.oV.offer(fVar);
    }

    public final void b(com.kwad.components.ad.reward.h.a aVar) {
        this.oW.remove(aVar);
    }

    public final void b(s sVar) {
        this.oX.remove(sVar);
    }

    public final void b(a aVar) {
        this.pK.remove(aVar);
    }

    public final void b(b bVar) {
        this.pL.remove(bVar);
    }

    public final void b(a.InterfaceC0176a interfaceC0176a) {
        List<a.InterfaceC0176a> list = this.pM;
        if (list != null) {
            list.remove(interfaceC0176a);
        }
    }

    public final void b(com.kwad.components.core.g.c cVar) {
        bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.j.6
            final /* synthetic */ com.kwad.components.core.g.d pP;
            final /* synthetic */ com.kwad.components.core.g.c pQ;

            AnonymousClass6(com.kwad.components.core.g.d dVar, com.kwad.components.core.g.c cVar2) {
                H = dVar;
                cVar = cVar2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.components.core.g.d dVar = H;
                if (dVar != null) {
                    dVar.d(cVar);
                }
            }
        });
    }

    @MainThread
    public final void c(com.kwad.components.ad.reward.d.f fVar) {
        this.oV.remove(fVar);
    }

    public final void c(boolean z, boolean z2) {
        if (this.oN.jF()) {
            bi.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.j.9
                final /* synthetic */ boolean pU;
                final /* synthetic */ boolean pV;

                AnonymousClass9(boolean z3, boolean z22) {
                    z = z3;
                    z2 = z22;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    j.this.oN.jG().setAudioEnabled(z, z2);
                }
            }, 500L);
        }
    }

    public final void d(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.pt.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
    }

    public final void d(@Nullable PlayableSource playableSource) {
        this.pr = playableSource;
    }

    public final boolean fE() {
        return this.pd;
    }

    @Nullable
    public final String fF() {
        TKAdLiveShopItemInfo tKAdLiveShopItemInfo = this.mAdTemplate.tkLiveShopItemInfo;
        if (tKAdLiveShopItemInfo == null) {
            return null;
        }
        return tKAdLiveShopItemInfo.itemId;
    }

    public final void fH() {
        if (isMainThread()) {
            fI();
        } else {
            this.mHandler.post(new Runnable() { // from class: com.kwad.components.ad.reward.j.3
                AnonymousClass3() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    j.this.fI();
                }
            });
        }
    }

    public final int fJ() {
        return this.pz;
    }

    public final boolean fK() {
        return this.pE;
    }

    public final void fL() {
        com.kwad.components.core.webview.a.d.a aVar = this.pa;
        if (aVar == null) {
            return;
        }
        aVar.cr();
    }

    public final boolean fM() {
        return this.pe;
    }

    public final boolean fN() {
        return this.pj;
    }

    @Nullable
    public final PlayableSource fO() {
        return this.pr;
    }

    public final boolean fP() {
        return this.ps;
    }

    public final List<a.InterfaceC0176a> fQ() {
        return this.pM;
    }

    @Nullable
    public final e.a fR() {
        return this.pb;
    }

    public final RewardRenderResult fS() {
        return this.pJ;
    }

    public final boolean fT() {
        return RewardRenderResult.NEO_TK.equals(this.pJ);
    }

    public final boolean fU() {
        return RewardRenderResult.LIVE_TK.equals(this.pJ);
    }

    public final boolean fV() {
        return this.pD;
    }

    public final boolean fW() {
        return this.pc;
    }

    public final boolean fX() {
        return this.mRewardVerifyCalled;
    }

    @Override // com.kwad.components.core.j.a, com.kwad.sdk.mvp.a
    public final void release() {
        fG();
        this.oN.release();
    }

    public final void releaseSync() {
        fG();
        this.oN.releaseSync();
    }
}
