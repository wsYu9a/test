package b.d.a.j;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.martian.ads.ad.AdConfig;
import com.martian.ads.ad.BaeAd;
import com.martian.ads.ad.BaseAd;
import com.martian.ads.ad.DXAd;
import com.martian.ads.ad.GDTAd;
import com.martian.ads.ad.KsAd;
import com.martian.ads.ad.TTAd;
import com.martian.ads.ad.VivoAd;
import com.martian.ads.data.AdSlot;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.data.ViewWrapper;
import com.martian.libmars.d.h;
import com.martian.libmars.utils.q0;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class b {

    /* renamed from: a */
    public static final String f4368a = "splash";

    /* renamed from: b */
    public static final String f4369b = "reader_banner";

    /* renamed from: c */
    public static final String f4370c = "reader_feeds";

    /* renamed from: d */
    public static final String f4371d = "normal_flow";

    /* renamed from: e */
    public static final String f4372e = "reader_inters";

    /* renamed from: f */
    public static final String f4373f = "rvideo_all";

    /* renamed from: g */
    public static final String f4374g = "rvideo_fresh_withdraw";

    /* renamed from: h */
    public static final String f4375h = "rvideo_author_bonus";

    /* renamed from: i */
    public static final String f4376i = "rvideo_mission_coins";

    /* renamed from: j */
    public static final String f4377j = "rvideo_flow_ad";
    public static final String k = "rvideo_dialog_ad";
    public static final String l = "text_link";
    public static final String m = "lottery_wheel";
    public static final String n = "bookshelf_feeds";
    public static final String o = "bonus_dialog_feeds";
    public static final String p = "bonus_detail_feeds";
    public static final String q = "activity_inter";
    public static final String r = "webview";
    public static String s = "adtag";

    static /* synthetic */ int D(AdConfig config1, AdConfig config2) {
        return config2.getEcpm() - config1.getEcpm();
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x01cf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void E(com.martian.ads.ad.AdConfig r6) {
        /*
            Method dump skipped, instructions count: 556
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: b.d.a.j.b.E(com.martian.ads.ad.AdConfig):void");
    }

    public static void J(AppTask appTask, b.d.a.k.a receiver) {
        if (appTask.rendered) {
            return;
        }
        receiver.a(Q(appTask));
        appTask.rendered = true;
    }

    public static AdConfig Q(AppTask appTask) {
        if (appTask == null) {
            return null;
        }
        AdConfig adTag = AdConfig.buildAdConfig(new AdSlot().setType(appTask.adsType).setUnion(appTask.source).setSid(appTask.id).setWeight(1).setEcpm(Integer.valueOf(appTask.getEcpm()))).setGid(appTask.getGid()).setBidding(appTask.getBidding()).setAdTag(appTask.getAdTag());
        adTag.setAdsPosition(appTask.adsPosition);
        return adTag;
    }

    protected abstract boolean A();

    protected abstract boolean B(AppTask appTask);

    protected abstract boolean C();

    public void F() {
        if (e()) {
            return;
        }
        if (h().isEmpty()) {
            L(null, j() + "-未配置");
            n().h();
            return;
        }
        if (A()) {
            K();
            P();
            Iterator<AdConfig> it = h().iterator();
            while (it.hasNext()) {
                E(it.next());
            }
            return;
        }
        Collections.sort(h(), new Comparator() { // from class: b.d.a.j.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return b.D((AdConfig) obj, (AdConfig) obj2);
            }
        });
        i().clear();
        i().addAll(h());
        P();
        for (int i2 = 0; i2 < Math.min(h().size(), o()); i2++) {
            R();
        }
    }

    protected abstract boolean G();

    protected abstract void H(String event);

    protected abstract void I(AppTask appTask);

    protected abstract void K();

    protected abstract void L(AdConfig config, String event);

    protected abstract void M(AppTask appTask);

    protected abstract void N(AppTask appTask);

    protected abstract void O(AppTask appTask);

    protected abstract void P();

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void R() {
        if (i().isEmpty()) {
            c();
        } else {
            E(i().remove(0));
        }
    }

    protected abstract void S(AdConfig config);

    protected abstract boolean a(AdConfig config);

    protected void b(@NonNull AdConfig config) {
        String str;
        String str2;
        if (config.getWeight() <= 0) {
            return;
        }
        config.setAdCompliance(z());
        config.setAdsPosition(j());
        config.setWifiEnv(C());
        config.setNeedNativeCompliance(G());
        h().add(config);
        if (h.F().J0()) {
            String str3 = s;
            StringBuilder sb = new StringBuilder();
            sb.append(config.getSource());
            sb.append(":");
            sb.append(config.getAdsPosition());
            sb.append("  id:");
            sb.append(config.getAdsId());
            if (config.getEcpm() > 0) {
                str = "  ecpm:" + config.getEcpm();
            } else {
                str = "";
            }
            sb.append(str);
            if (config.isBidding()) {
                str2 = " bidding";
            } else {
                str2 = " group:" + config.getGroup();
            }
            sb.append(str2);
            q0.f(str3, sb.toString());
        }
    }

    protected abstract void c();

    public void d(AppTask appTask) {
        if (appTask == null || appTask.customView != null) {
            return;
        }
        if (appTask.origin == null) {
            L(Q(appTask), AdConfig.ActionString.CLICK);
            O(appTask);
        } else if (B(appTask)) {
            M(appTask);
        }
    }

    protected abstract boolean e();

    public void f(Activity activity, final AppTask appTask, ViewGroup customContainer, View adView) {
        g(activity, appTask, customContainer, adView, null, null, false);
    }

    public void g(Activity activity, final AppTask appTask, ViewGroup adContainer, View adView, View videoView, View creativeView, boolean forceExpose) {
        ViewGroup viewGroup;
        if (appTask != null) {
            if (!appTask.exposed || forceExpose) {
                I(appTask);
                appTask.exposed = true;
                ViewWrapper viewWrapper = appTask.customView;
                if (viewWrapper != null) {
                    if (adContainer == null || viewWrapper.getView() == null) {
                        return;
                    }
                    viewWrapper.init();
                    if (TTAd.isTTFlowTempAd(appTask)) {
                        TTAd.bindFlowTempAd(activity, appTask, n());
                    }
                    if (viewWrapper.getView().getParent() != null && (viewGroup = (ViewGroup) viewWrapper.getView().getParent()) != null) {
                        viewGroup.removeAllViews();
                    }
                    if (adContainer.getChildCount() <= 0) {
                        adContainer.addView(viewWrapper.getView());
                        return;
                    } else {
                        if (adContainer.getChildAt(0) != viewWrapper.getView()) {
                            adContainer.removeAllViews();
                            adContainer.addView(viewWrapper.getView());
                            return;
                        }
                        return;
                    }
                }
                if (TTAd.isTTFlowAd(appTask)) {
                    TTAd.bindFlowAd(appTask, adContainer, adView, creativeView, n());
                    return;
                }
                if (TTAd.isTTBannerAd(appTask)) {
                    TTAd.bindBannerAd(appTask, adContainer, adView, creativeView, n());
                    return;
                }
                if (BaeAd.isBaeFlowAd(appTask)) {
                    BaeAd.bindFlowAd(appTask, adContainer, adView, creativeView, n());
                    return;
                }
                if (GDTAd.isGdtFlowAd(appTask)) {
                    GDTAd.bindFlowAd(activity, appTask, adContainer, adView, videoView != null ? (ViewGroup) videoView : null, creativeView, n());
                    return;
                }
                if (DXAd.isDxFlowAd(appTask)) {
                    DXAd.bindFlowAd(activity, appTask, adContainer, adView, videoView != null ? (ViewGroup) videoView : null, creativeView, n());
                    return;
                }
                if (KsAd.isKsFlowAd(appTask)) {
                    KsAd.bindFlowAd(activity, appTask, adContainer, adView, creativeView, n());
                    return;
                }
                if (VivoAd.isVivoAd(appTask)) {
                    VivoAd.bindFlowAd(activity, appTask, adContainer, adView, videoView != null ? (ViewGroup) videoView : null, creativeView, n());
                    return;
                }
                if (B(appTask)) {
                    N(appTask);
                    return;
                }
                if (BaseAd.isOppoFlowAd(appTask)) {
                    BaseAd.bindOppoFlowAd(activity, appTask, adContainer, adView, videoView != null ? (ViewGroup) videoView : null, creativeView, n());
                    return;
                }
                if (BaseAd.isMiFlowAd(appTask)) {
                    BaseAd.bindMiFlowAd(adContainer, appTask, n());
                } else if (BaseAd.isHwFlowAd(appTask)) {
                    BaseAd.bindHwFlowAd(activity, appTask, adContainer, adView, videoView != null ? (ViewGroup) videoView : null);
                } else {
                    J(appTask, n());
                    com.martian.apptask.g.h.b(appTask.exposeReportUrls);
                }
            }
        }
    }

    protected abstract Activity getActivity();

    protected abstract List<AdConfig> h();

    protected abstract List<AdConfig> i();

    protected abstract String j();

    protected abstract String[] k();

    protected abstract String[] l();

    protected abstract AppTask m(String adsPosition);

    protected abstract b.d.a.k.a n();

    protected abstract int o();

    protected abstract void p();

    protected abstract void q();

    protected abstract void r();

    protected abstract void s();

    protected abstract void t();

    protected abstract void u();

    protected abstract void v();

    protected abstract void w();

    protected abstract void x();

    protected abstract void y();

    protected abstract boolean z();
}
