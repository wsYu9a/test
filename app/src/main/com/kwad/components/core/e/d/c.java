package com.kwad.components.core.e.d;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.kwad.components.core.e.c.b;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.components.core.page.DownloadLandPageActivity;
import com.kwad.sdk.api.KsApkDownloadListener;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.core.adlog.c;
import com.kwad.sdk.core.diskcache.ApkCacheManager;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.r;
import com.kwad.sdk.utils.z;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class c implements NetworkMonitor.a, com.kwad.sdk.core.download.c, com.kwad.sdk.core.webview.a {

    @NonNull
    private AdTemplate MV;
    private boolean MW;
    private a MX;
    private DialogInterface.OnShowListener MY;
    private List<KsAppDownloadListener> MZ;
    private boolean downloadPauseEnable;

    /* renamed from: hf */
    private Handler f11924hf;

    @NonNull
    private AdInfo mAdInfo;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private JSONObject mReportExtData;

    /* renamed from: com.kwad.components.core.e.d.c$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
        }
    }

    /* renamed from: com.kwad.components.core.e.d.c$2 */
    public class AnonymousClass2 extends bd {
        final /* synthetic */ boolean Nb;

        public AnonymousClass2(boolean z10) {
            z10 = z10;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
        }
    }

    /* renamed from: com.kwad.components.core.e.d.c$3 */
    public class AnonymousClass3 extends bd {
        public AnonymousClass3() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            ArrayList<KsAppDownloadListener> arrayList = new ArrayList(c.this.MZ.size());
            arrayList.addAll(c.this.MZ);
            for (KsAppDownloadListener ksAppDownloadListener : arrayList) {
                if (ksAppDownloadListener != null) {
                    c.this.a(ksAppDownloadListener);
                }
            }
        }
    }

    /* renamed from: com.kwad.components.core.e.d.c$4 */
    public class AnonymousClass4 implements DialogInterface.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i10) {
            if (i10 == -1) {
                switch (c.this.mAdInfo.status) {
                    case 0:
                    case 1:
                    case 5:
                    case 6:
                    case 7:
                        c.this.oV();
                        break;
                    case 4:
                        c.this.oX();
                        break;
                    case 8:
                    case 9:
                    case 11:
                        c.this.oU();
                        break;
                    case 12:
                        c.this.oS();
                        break;
                }
            }
        }
    }

    /* renamed from: com.kwad.components.core.e.d.c$5 */
    public class AnonymousClass5 extends bd {
        public AnonymousClass5() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
        }
    }

    /* renamed from: com.kwad.components.core.e.d.c$6 */
    public class AnonymousClass6 implements ap.a {
        public AnonymousClass6() {
        }

        @Override // com.kwad.sdk.utils.ap.a
        public final void d(Throwable th2) {
            com.kwad.sdk.commercial.a.a.i(c.this.MV, 100003, Log.getStackTraceString(th2));
        }

        @Override // com.kwad.sdk.utils.ap.a
        public final void pa() {
            com.kwad.sdk.core.adlog.c.h(c.this.MV, 1);
            com.kwad.sdk.commercial.a.a.bf(c.this.MV);
        }
    }

    /* renamed from: com.kwad.components.core.e.d.c$7 */
    public class AnonymousClass7 extends bd {
        final /* synthetic */ KsAppDownloadListener Nc;

        public AnonymousClass7(KsAppDownloadListener ksAppDownloadListener) {
            ksAppDownloadListener = ksAppDownloadListener;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            if (c.this.MZ.contains(ksAppDownloadListener)) {
                return;
            }
            c.this.MZ.add(0, ksAppDownloadListener);
        }
    }

    /* renamed from: com.kwad.components.core.e.d.c$8 */
    public class AnonymousClass8 extends bd {
        final /* synthetic */ KsAppDownloadListener Nc;

        public AnonymousClass8(KsAppDownloadListener ksAppDownloadListener) {
            ksAppDownloadListener = ksAppDownloadListener;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            c.this.MZ.remove(ksAppDownloadListener);
        }
    }

    public interface a {
        boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener);
    }

    public c(@NonNull AdTemplate adTemplate, JSONObject jSONObject, KsAppDownloadListener ksAppDownloadListener) {
        this.f11924hf = new Handler(Looper.getMainLooper());
        this.MZ = new ArrayList();
        this.MV = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        this.mReportExtData = jSONObject;
        if (ksAppDownloadListener != null) {
            b(ksAppDownloadListener);
        }
        oJ();
        this.downloadPauseEnable = com.kwad.sdk.core.response.b.a.cI(com.kwad.sdk.core.response.b.e.eb(this.MV));
        oI();
        com.kwad.sdk.a.a.c.Bg().aU(this.MV);
    }

    public static int A(a.C0427a c0427a) {
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(c0427a.getAdTemplate());
        if (eb2.downloadSafeInfo.complianceInfo == null) {
            return 0;
        }
        int dq = c0427a.dq();
        return dq != 2 ? dq != 3 ? eb2.downloadSafeInfo.complianceInfo.actionBarType : eb2.downloadSafeInfo.complianceInfo.materialJumpType : eb2.downloadSafeInfo.complianceInfo.describeBarType;
    }

    private void oJ() {
        com.kwad.sdk.core.download.b.EI();
        int dL = com.kwad.sdk.core.download.b.dL(oL());
        if (dL != 0) {
            this.mAdInfo.status = dL;
        }
        oP();
        oO();
    }

    private boolean oN() {
        if (Build.VERSION.SDK_INT < 29) {
            if (this.MV.mIsFromContent && com.kwad.sdk.core.config.d.CS()) {
                r2 = oT();
                if (r2) {
                    com.kwad.sdk.core.adlog.c.bQ(this.MV);
                }
            } else if (!this.MV.mIsFromContent && com.kwad.sdk.core.config.d.Dy()) {
                boolean ao = com.kwad.components.core.k.b.ao(ServiceProvider.getContext());
                com.kwad.sdk.core.d.c.d("ApkDownloadHelper", "handleForceOpenApp enableForceOpen: " + ao);
                r2 = ao ? oT() : false;
                if (r2) {
                    com.kwad.sdk.core.adlog.c.bR(this.MV);
                }
            }
        }
        return r2;
    }

    private void oO() {
        this.f11924hf.post(new bd() { // from class: com.kwad.components.core.e.d.c.3
            public AnonymousClass3() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                ArrayList<KsAppDownloadListener> arrayList = new ArrayList(c.this.MZ.size());
                arrayList.addAll(c.this.MZ);
                for (KsAppDownloadListener ksAppDownloadListener : arrayList) {
                    if (ksAppDownloadListener != null) {
                        c.this.a(ksAppDownloadListener);
                    }
                }
            }
        });
    }

    private boolean oR() {
        a aVar = this.MX;
        if (aVar != null) {
            return aVar.handleDownloadDialog(new DialogInterface.OnClickListener() { // from class: com.kwad.components.core.e.d.c.4
                public AnonymousClass4() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    if (i10 == -1) {
                        switch (c.this.mAdInfo.status) {
                            case 0:
                            case 1:
                            case 5:
                            case 6:
                            case 7:
                                c.this.oV();
                                break;
                            case 4:
                                c.this.oX();
                                break;
                            case 8:
                            case 9:
                            case 11:
                                c.this.oU();
                                break;
                            case 12:
                                c.this.oS();
                                break;
                        }
                    }
                }
            });
        }
        return false;
    }

    private boolean oT() {
        Context context = ServiceProvider.getContext();
        if (d.a(new a.C0427a(context).au(this.MV), 1) == 1) {
            return true;
        }
        boolean aq = ap.aq(context, com.kwad.sdk.core.response.b.a.ay(this.mAdInfo));
        if (aq) {
            com.kwad.sdk.core.adlog.c.bP(this.MV);
        }
        return aq;
    }

    private int oY() {
        this.MV.downLoadType = 1;
        oV();
        return 5;
    }

    private boolean t(a.C0427a c0427a) {
        boolean i10 = com.kwad.sdk.utils.e.i(c0427a.getContext(), this.MV);
        if (i10) {
            com.kwad.sdk.core.adlog.c.k(this.MV, 0);
        }
        return i10;
    }

    private int u(a.C0427a c0427a) {
        Context context = c0427a.getContext();
        if (com.kwad.sdk.utils.e.a(context, com.kwad.sdk.core.response.b.a.cX(this.mAdInfo), this.MV)) {
            com.kwad.sdk.core.adlog.c.k(this.MV, 1);
            return 11;
        }
        if (t(c0427a)) {
            return 11;
        }
        if (oR()) {
            return 10;
        }
        if (!al.isNetworkConnected(context)) {
            z.P(context, ab.cp(context));
            return 2;
        }
        if (c0427a.oE() && com.kwad.sdk.core.config.d.Dk()) {
            return v(c0427a);
        }
        if (com.kwad.sdk.core.response.b.e.eq(this.MV) && c0427a.oG() != 2) {
            return d(c0427a.getContext(), c0427a.getAdTemplate());
        }
        if (c0427a.oA()) {
            return w(c0427a);
        }
        if (x(c0427a)) {
            return 8;
        }
        return oV();
    }

    private int v(a.C0427a c0427a) {
        Context context = c0427a.getContext();
        AdTemplate adTemplate = c0427a.getAdTemplate();
        int oF = c0427a.oF();
        if (oF == 1) {
            return oV();
        }
        if (oF != 2) {
            return 1;
        }
        if (!com.kwad.sdk.core.response.b.b.dg(adTemplate)) {
            return 8;
        }
        com.kwad.components.core.e.c.b.a(context, new b.a().at(adTemplate).ag(com.kwad.sdk.core.response.b.b.df(adTemplate)).a(this.MY).c(this.mOnDismissListener).oi());
        return 8;
    }

    private int w(a.C0427a c0427a) {
        Context context = c0427a.getContext();
        AdTemplate adTemplate = c0427a.getAdTemplate();
        int A = A(c0427a);
        if (A == 1) {
            if (com.kwad.sdk.core.response.b.b.dg(adTemplate)) {
                com.kwad.components.core.e.c.b.a(context, new b.a().at(adTemplate).ag(com.kwad.sdk.core.response.b.b.df(adTemplate)).a(this.MY).c(this.mOnDismissListener).oi());
            }
            return 8;
        }
        if (A == 2) {
            return d(c0427a.getContext(), c0427a.getAdTemplate());
        }
        if (A == 3) {
            return 1;
        }
        if (x(c0427a)) {
            return 8;
        }
        return oV();
    }

    private boolean x(a.C0427a c0427a) {
        if (c0427a.ox() || this.mAdInfo.status == 4 || !com.kwad.sdk.core.response.b.b.dj(this.MV) || !y(c0427a)) {
            return false;
        }
        return com.kwad.components.core.e.c.b.a(c0427a.getContext(), new b.a().at(this.MV).ag(com.kwad.sdk.core.response.b.b.di(this.MV)).a(this.MY).c(this.mOnDismissListener).oi());
    }

    private static boolean y(a.C0427a c0427a) {
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(c0427a.getAdTemplate());
        if (com.kwad.sdk.core.response.b.a.bv(eb2) && (DownloadLandPageActivity.showingAdWebViewLandPage || AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity || c0427a.getAdTemplate().isWebViewDownload)) {
            return true;
        }
        return com.kwad.sdk.core.response.b.a.bw(eb2) && !al.isWifiConnected(c0427a.getContext());
    }

    private int z(a.C0427a c0427a) {
        Activity dH = m.dH(c0427a.getContext());
        if (dH == null || !com.kwad.sdk.core.response.b.a.T(this.mAdInfo) || c0427a.oo() || c0427a.ot()) {
            return oS();
        }
        c0427a.al(1);
        com.kwad.components.core.e.e.e.a(dH, c0427a);
        return 18;
    }

    public final void at(int i10) {
        this.MV.downloadSource = i10;
    }

    @Override // com.kwad.sdk.core.download.c
    public final void b(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            if (this.mAdInfo.status != 4 && eVar.EM()) {
                com.kwad.sdk.core.adlog.c.a(this.MV, this.mReportExtData);
                eVar.EL();
                com.kwad.sdk.commercial.a.a.bb(this.MV);
            }
            this.mAdInfo.status = 4;
            oO();
        }
    }

    public final void clear() {
        oZ();
        com.kwad.sdk.core.download.b.EI().a(this);
        if (com.kwad.sdk.core.config.d.DK()) {
            NetworkMonitor.getInstance().a(this);
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void f(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            oP();
            if (eVar.EM()) {
                eVar.EL();
                com.kwad.sdk.commercial.a.a.bh(this.MV);
            }
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void g(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str) && eVar.EM()) {
            eVar.EL();
            com.kwad.sdk.core.adlog.c.bO(this.MV);
            com.kwad.sdk.commercial.a.a.be(this.MV);
        }
    }

    public final void oI() {
        com.kwad.sdk.core.download.b.EI().a(this, this.MV);
        if (com.kwad.sdk.core.config.d.DK()) {
            NetworkMonitor.getInstance().a(ServiceProvider.getContext(), this);
        }
    }

    public final int oK() {
        oP();
        int i10 = this.mAdInfo.status;
        if (i10 == 3) {
            return 2;
        }
        return i10;
    }

    @Override // com.kwad.sdk.core.download.c
    public final String oL() {
        return this.mAdInfo.downloadId;
    }

    @Override // com.kwad.sdk.core.download.c
    public final String oM() {
        return this.mAdInfo.adBaseInfo.appPackageName;
    }

    public final void oP() {
        if (ap.ao(ServiceProvider.getContext(), this.mAdInfo.adBaseInfo.appPackageName)) {
            this.mAdInfo.status = 12;
            return;
        }
        AdInfo adInfo = this.mAdInfo;
        if (adInfo.status == 12) {
            adInfo.status = 0;
            adInfo.progress = 0;
        }
        int i10 = adInfo.status;
        if (i10 == 8 || i10 == 9) {
            String str = adInfo.downloadFilePath;
            if (TextUtils.isEmpty(str) || !new File(str).exists()) {
                AdInfo adInfo2 = this.mAdInfo;
                adInfo2.status = 0;
                adInfo2.progress = 0;
            }
        }
        AdInfo adInfo3 = this.mAdInfo;
        if (adInfo3.status == 0) {
            String H = com.kwad.sdk.core.download.a.H(adInfo3);
            if (TextUtils.isEmpty(H) || !new File(H).exists()) {
                return;
            }
            AdInfo adInfo4 = this.mAdInfo;
            adInfo4.downloadFilePath = H;
            adInfo4.status = 8;
        }
    }

    @NonNull
    public final AdTemplate oQ() {
        return this.MV;
    }

    public final int oS() {
        h.execute(new bd() { // from class: com.kwad.components.core.e.d.c.5
            public AnonymousClass5() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
            }
        });
        if (!ap.aq(ServiceProvider.getContext(), com.kwad.sdk.core.response.b.a.ay(this.mAdInfo))) {
            return 6;
        }
        com.kwad.sdk.core.adlog.c.bP(this.MV);
        return 6;
    }

    public final int oU() {
        ap.a(this.mAdInfo.downloadFilePath, new ap.a() { // from class: com.kwad.components.core.e.d.c.6
            public AnonymousClass6() {
            }

            @Override // com.kwad.sdk.utils.ap.a
            public final void d(Throwable th2) {
                com.kwad.sdk.commercial.a.a.i(c.this.MV, 100003, Log.getStackTraceString(th2));
            }

            @Override // com.kwad.sdk.utils.ap.a
            public final void pa() {
                com.kwad.sdk.core.adlog.c.h(c.this.MV, 1);
                com.kwad.sdk.commercial.a.a.bf(c.this.MV);
            }
        });
        return 7;
    }

    public final int oV() {
        com.kwad.sdk.core.download.a.I(this.mAdInfo);
        return 3;
    }

    public final int oW() {
        com.kwad.sdk.core.download.a.dI(this.mAdInfo.downloadId);
        return 4;
    }

    public final int oX() {
        this.MV.downLoadType = 2;
        oV();
        return 5;
    }

    @Override // com.kwad.sdk.core.webview.a
    public final void oZ() {
        List<KsAppDownloadListener> list = this.MZ;
        if (list != null) {
            list.clear();
        }
    }

    public final int q(a.C0427a c0427a) {
        int i10 = this.mAdInfo.status;
        if (i10 != 0 && i10 != 1) {
            switch (i10) {
                case 4:
                case 5:
                case 6:
                case 7:
                    break;
                case 8:
                case 9:
                case 10:
                case 11:
                    return oU();
                case 12:
                    return z(c0427a);
                default:
                    return 0;
            }
        }
        return t(c0427a) ? 11 : 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final int r(a.C0427a c0427a) {
        this.MW = false;
        oP();
        switch (this.mAdInfo.status) {
            case 0:
            case 1:
            case 5:
            case 6:
            case 7:
                return u(c0427a);
            case 2:
            case 3:
                if (c0427a.ov() && this.downloadPauseEnable) {
                    return oW();
                }
                return 0;
            case 4:
                return oX();
            case 8:
            case 9:
            case 11:
                return oU();
            case 10:
            default:
                return 0;
            case 12:
                return z(c0427a);
        }
    }

    public final boolean s(a.C0427a c0427a) {
        return this.mAdInfo.status == 0 && t(c0427a);
    }

    public final void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public final void setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        this.MY = onShowListener;
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.status = 1;
            oO();
            if (eVar.EM()) {
                this.mAdInfo.mStartDownloadTime = SystemClock.elapsedRealtime();
                com.kwad.sdk.core.adlog.c.bN(this.MV);
                eVar.EL();
                com.kwad.sdk.commercial.a.a.s(this.MV);
            }
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void c(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            WeakHashMap<String, Integer> weakHashMap = com.kwad.sdk.core.download.b.ayj;
            Integer num = weakHashMap.get(str);
            if (num != null && num.intValue() == 2) {
                this.MV.downLoadType = 2;
                weakHashMap.remove(str);
            }
            if (this.mAdInfo.status != 2 && eVar.EM()) {
                com.kwad.sdk.core.adlog.c.b(this.MV, this.mReportExtData);
                eVar.EL();
                com.kwad.sdk.commercial.a.a.bc(this.MV);
            }
            this.mAdInfo.status = 2;
            oO();
        }
    }

    public final void d(JSONObject jSONObject) {
        this.mReportExtData = jSONObject;
    }

    @Override // com.kwad.sdk.core.download.c
    public final void e(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.status = 9;
            oO();
            if (eVar.EM()) {
                com.kwad.sdk.core.adlog.c.h(this.MV, 2);
                eVar.EL();
                com.kwad.sdk.commercial.a.a.bf(this.MV);
            }
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void d(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            if (this.mAdInfo.status != 5 && eVar.EM()) {
                com.kwad.sdk.core.adlog.c.d(this.MV, this.mReportExtData);
                eVar.EL();
                com.kwad.sdk.commercial.a.a.bd(this.MV);
            }
            com.kwad.sdk.a.a.c.Bg().aV(this.MV);
            com.kwad.sdk.a.a.b.Bd().aQ(this.MV);
            this.mAdInfo.status = 5;
            oO();
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void b(String str, String str2, com.kwad.sdk.core.download.e eVar) {
        boolean z10;
        this.mAdInfo.status = 12;
        oO();
        if (eVar.EM()) {
            com.kwad.sdk.core.adlog.c.e(this.MV, this.mReportExtData);
            eVar.EL();
            com.kwad.sdk.commercial.a.a.bg(this.MV);
            z10 = oN();
            com.kwad.sdk.a.a.c.Bg().aX(this.MV);
            com.kwad.sdk.a.a.c.Bg().aV(this.MV);
            com.kwad.sdk.a.a.b.Bd().aQ(this.MV);
            com.kwad.components.core.e.a.e.nT().aq(this.MV);
            com.kwad.sdk.core.a.CA().dh(oL());
        } else {
            z10 = false;
        }
        h.execute(new bd() { // from class: com.kwad.components.core.e.d.c.2
            final /* synthetic */ boolean Nb;

            public AnonymousClass2(boolean z102) {
                z10 = z102;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
            }
        });
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, int i10, int i11, int i12) {
        if (this.mAdInfo.downloadId.equals(str)) {
            AdInfo adInfo = this.mAdInfo;
            adInfo.status = 3;
            adInfo.progress = i10;
            adInfo.soFarBytes = i11;
            adInfo.totalBytes = i12;
            oO();
        }
    }

    public final void d(KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        oP();
        a(ksAppDownloadListener);
    }

    public c(@NonNull AdTemplate adTemplate, @NonNull KsAppDownloadListener ksAppDownloadListener) {
        this(adTemplate, null, ksAppDownloadListener);
    }

    public final void c(KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.MZ.remove(ksAppDownloadListener);
        } else {
            this.f11924hf.post(new bd() { // from class: com.kwad.components.core.e.d.c.8
                final /* synthetic */ KsAppDownloadListener Nc;

                public AnonymousClass8(KsAppDownloadListener ksAppDownloadListener2) {
                    ksAppDownloadListener = ksAppDownloadListener2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    c.this.MZ.remove(ksAppDownloadListener);
                }
            });
        }
    }

    public c(@NonNull AdTemplate adTemplate, JSONObject jSONObject) {
        this(adTemplate, jSONObject, null);
    }

    private static int d(Context context, AdTemplate adTemplate) {
        if (context == null || adTemplate == null) {
            return 9;
        }
        DownloadLandPageActivity.launch(context, adTemplate, false);
        return 9;
    }

    public c(@NonNull AdTemplate adTemplate) {
        this(adTemplate, null, null);
    }

    public c(@NonNull AdTemplate adTemplate, KsAppDownloadListener ksAppDownloadListener, String str, String str2) {
        this(adTemplate, null, null);
        AdInfo adInfo = this.mAdInfo;
        adInfo.adConversionInfo.appDownloadUrl = str;
        adInfo.adBaseInfo.appPackageName = str2;
        adInfo.downloadId = ai.by(str);
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, String str2, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            AdInfo adInfo = this.mAdInfo;
            adInfo.downloadFilePath = str2;
            adInfo.progress = 100;
            adInfo.status = 8;
            oO();
            if (eVar.EM()) {
                eVar.EL();
                com.kwad.sdk.core.adlog.c.c(this.MV, this.mReportExtData);
                com.kwad.sdk.commercial.a.a.j(this.MV, SystemClock.elapsedRealtime() - this.mAdInfo.mStartDownloadTime);
                com.kwad.sdk.core.a.CA().e(str, this.MV);
                h.execute(new Runnable() { // from class: com.kwad.components.core.e.d.c.1
                    public AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
                    }
                });
                com.kwad.sdk.a.a.c.Bg().aW(this.MV);
                com.kwad.sdk.a.a.c.Bg().aU(this.MV);
                com.kwad.sdk.a.a.b.Bd().aP(this.MV);
                ApkCacheManager.getInstance().Ev();
            }
        }
    }

    @UiThread
    public final void b(KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (!this.MZ.contains(ksAppDownloadListener)) {
                this.MZ.add(0, ksAppDownloadListener);
            }
        } else {
            this.f11924hf.post(new bd() { // from class: com.kwad.components.core.e.d.c.7
                final /* synthetic */ KsAppDownloadListener Nc;

                public AnonymousClass7(KsAppDownloadListener ksAppDownloadListener2) {
                    ksAppDownloadListener = ksAppDownloadListener2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    if (c.this.MZ.contains(ksAppDownloadListener)) {
                        return;
                    }
                    c.this.MZ.add(0, ksAppDownloadListener);
                }
            });
        }
        oP();
        a(ksAppDownloadListener2);
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, int i10, String str2, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.status = 7;
            oO();
            if (eVar.EM()) {
                c.a aVar = new c.a(i10, str2);
                com.kwad.sdk.core.adlog.c.a(this.MV, aVar);
                com.kwad.components.core.o.a.ri().a(this.MV, this.mAdInfo.adConversionInfo.appDownloadUrl, aVar.toJson().toString());
                eVar.EL();
                com.kwad.sdk.commercial.a.a.h(this.MV, i10, str2);
            }
            if (this.mAdInfo.adConversionInfo.retryH5TimeStep <= 0 || this.MW) {
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            AdInfo adInfo = this.mAdInfo;
            if (elapsedRealtime - adInfo.mStartDownloadTime >= adInfo.adConversionInfo.retryH5TimeStep || TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aS(adInfo))) {
                return;
            }
            AdWebViewActivityProxy.launch(ServiceProvider.getContext(), this.MV);
            this.MW = true;
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, Throwable th2, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.status = 11;
            oO();
            if (eVar.EM()) {
                eVar.EL();
                com.kwad.sdk.commercial.a.a.i(this.MV, 100003, Log.getStackTraceString(th2));
            }
        }
    }

    public void a(@NonNull KsAppDownloadListener ksAppDownloadListener) {
        int Ao = com.kwad.sdk.core.config.d.Ao();
        boolean An = com.kwad.sdk.core.config.d.An();
        com.kwad.sdk.core.d.c.d("ApkDownloadHelper", "DownloadProgressTransformUtil  go in updateDownloadProgress");
        AdInfo adInfo = this.mAdInfo;
        int a10 = r.a(adInfo.soFarBytes, adInfo.totalBytes, An, Ao);
        switch (this.mAdInfo.status) {
            case 0:
            case 5:
                ksAppDownloadListener.onIdle();
                break;
            case 1:
                ksAppDownloadListener.onProgressUpdate(0);
                if (ksAppDownloadListener instanceof com.kwad.sdk.core.download.a.a) {
                    ((com.kwad.sdk.core.download.a.a) ksAppDownloadListener).onDownloadStarted();
                    break;
                } else {
                    try {
                        ksAppDownloadListener.onDownloadStarted();
                        break;
                    } catch (Throwable th2) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                        return;
                    }
                }
            case 2:
            case 3:
                ksAppDownloadListener.onProgressUpdate(a10);
                break;
            case 4:
                if (ksAppDownloadListener instanceof com.kwad.sdk.core.download.a.a) {
                    ((com.kwad.sdk.core.download.a.a) ksAppDownloadListener).onPaused(a10);
                }
                try {
                    if (ksAppDownloadListener instanceof KsApkDownloadListener) {
                        ((KsApkDownloadListener) ksAppDownloadListener).onPaused(a10);
                        break;
                    }
                } catch (Throwable unused) {
                    return;
                }
                break;
            case 7:
                ksAppDownloadListener.onDownloadFailed();
                break;
            case 8:
            case 9:
                ksAppDownloadListener.onDownloadFinished();
                break;
            case 12:
                ksAppDownloadListener.onInstalled();
                break;
        }
    }

    public final void a(a aVar) {
        this.MX = aVar;
    }

    @Override // com.kwad.sdk.core.NetworkMonitor.a
    public final void a(NetworkMonitor.NetworkState networkState) {
        if (this.mAdInfo.status == 7 && networkState == NetworkMonitor.NetworkState.NETWORK_WIFI) {
            oY();
        }
    }
}
