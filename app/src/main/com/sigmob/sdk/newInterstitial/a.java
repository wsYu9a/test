package com.sigmob.sdk.newInterstitial;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.czhj.sdk.common.models.AdStatus;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.Sigmob;
import com.sigmob.sdk.base.common.b0;
import com.sigmob.sdk.base.common.h;
import com.sigmob.sdk.base.common.m;
import com.sigmob.sdk.base.common.o;
import com.sigmob.sdk.base.k;
import com.sigmob.sdk.base.l;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.models.rtb.BiddingResponse;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.mta.PointEntitySigmobError;
import com.sigmob.sdk.base.network.d;
import com.sigmob.sdk.newInterstitial.e;
import com.sigmob.sdk.videoAd.o;
import com.sigmob.sdk.videoAd.q;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdRequest;
import com.umeng.analytics.pro.q;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class a implements e.b, d.a, h.f {

    /* renamed from: b */
    public o f20164b;

    /* renamed from: c */
    public AdStatus f20165c;

    /* renamed from: d */
    public List<BaseAdUnit> f20166d;

    /* renamed from: e */
    public BaseAdUnit f20167e;

    /* renamed from: f */
    public long f20168f;

    /* renamed from: g */
    public long f20169g;

    /* renamed from: h */
    public LoadAdRequest f20170h;

    /* renamed from: j */
    public String f20172j;

    /* renamed from: k */
    public com.sigmob.sdk.newInterstitial.e f20173k;

    /* renamed from: l */
    public q f20174l;

    /* renamed from: m */
    public String f20175m;

    /* renamed from: n */
    public String f20176n;

    /* renamed from: i */
    public final int f20171i = q.a.f24121r;

    /* renamed from: a */
    public final Handler f20163a = new HandlerC0616a(Looper.getMainLooper());

    /* renamed from: com.sigmob.sdk.newInterstitial.a$a */
    public class HandlerC0616a extends Handler {
        public HandlerC0616a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 8193 && a.this.f20165c == AdStatus.AdStatusLoading) {
                a.this.f20163a.removeMessages(q.a.f24121r);
                a.this.a(WindAdError.ERROR_SIGMOB_AD_TIME_OUT);
            }
        }
    }

    public class b extends com.sigmob.sdk.newInterstitial.e {
        public b(o.b bVar) {
            super(bVar);
        }
    }

    public class c implements b0.g {
        public c() {
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                ((PointEntitySigmob) obj).setAdx_id(null);
            }
        }
    }

    public class d implements b0.g {

        /* renamed from: a */
        public final /* synthetic */ List f20180a;

        public d(List list) {
            this.f20180a = list;
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                HashMap hashMap = new HashMap();
                hashMap.put("ad_count", String.valueOf(this.f20180a.size()));
                ((PointEntitySigmob) obj).setOptions(hashMap);
            }
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            aVar.b(aVar.f20170h);
        }
    }

    public class f implements d.a {

        /* renamed from: com.sigmob.sdk.newInterstitial.a$f$a */
        public class C0617a implements b0.g {

            /* renamed from: a */
            public final /* synthetic */ List f20184a;

            public C0617a(List list) {
                this.f20184a = list;
            }

            @Override // com.sigmob.sdk.base.common.b0.g
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmob) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("ad_count", String.valueOf(this.f20184a.size()));
                    ((PointEntitySigmob) obj).setOptions(hashMap);
                }
            }
        }

        public class b implements h.f {
            public b() {
            }

            @Override // com.sigmob.sdk.base.common.h.f
            public void d(BaseAdUnit baseAdUnit, String str) {
                com.sigmob.sdk.base.network.f.a(baseAdUnit, TextUtils.isEmpty(str) ? com.sigmob.sdk.base.common.a.B : com.sigmob.sdk.base.common.a.C);
                a.this.f20163a.removeMessages(q.a.f24121r);
                b0.a(PointCategory.LOADEND, TextUtils.isEmpty(str) ? "1" : "0", baseAdUnit, (WindAdRequest) null, a.this.f20170h, (b0.g) null);
                if (baseAdUnit == null || baseAdUnit.getPlayMode() != 0) {
                    return;
                }
                if (TextUtils.isEmpty(str)) {
                    a.this.f20168f = baseAdUnit.getAdExpiredTime().intValue();
                    a.this.f20169g = System.currentTimeMillis();
                } else {
                    WindAdError windAdError = WindAdError.ERROR_SIGMOB_FILE_DOWNLOAD;
                    windAdError.setMessage(str);
                    a.this.a(baseAdUnit, "load", baseAdUnit.getAd_type(), baseAdUnit.getAdslot_id(), baseAdUnit.getLoad_id(), windAdError);
                    a.this.a();
                }
            }

            @Override // com.sigmob.sdk.base.common.h.f
            public void i(BaseAdUnit baseAdUnit) {
                b0.a(PointCategory.LOADSTART, (String) null, baseAdUnit, (WindAdRequest) null, a.this.f20170h, (b0.g) null);
                com.sigmob.sdk.base.network.f.a(baseAdUnit, "load");
            }
        }

        public f() {
        }

        @Override // com.sigmob.sdk.base.network.d.a
        public void a(int i10, String str, String str2, LoadAdRequest loadAdRequest) {
            b0.a(PointCategory.RESPOND, "0", loadAdRequest);
            b0.a(PointCategory.RESPOND, "0", i10, str, loadAdRequest);
        }

        @Override // com.sigmob.sdk.base.network.d.a
        public void a(List<BaseAdUnit> list, LoadAdRequest loadAdRequest) {
            if (list == null || list.size() <= 0) {
                return;
            }
            BaseAdUnit baseAdUnit = list.get(0);
            a.this.f20175m = baseAdUnit.getRequestId();
            a.this.f20166d = list;
            b0.a(PointCategory.RESPOND, "1", (BaseAdUnit) null, loadAdRequest, new C0617a(list));
            if (!a.this.f20173k.a(baseAdUnit)) {
                a.this.a(WindAdError.ERROR_SIGMOB_INFORMATION_LOSE);
                return;
            }
            for (BaseAdUnit baseAdUnit2 : a.this.f20166d) {
                if (baseAdUnit2.getAd_source_channel().equalsIgnoreCase("1000")) {
                    com.sigmob.sdk.base.common.h.s().b(baseAdUnit2);
                }
            }
            if (baseAdUnit.getPlayMode() != 0) {
                a.this.f20168f = baseAdUnit.getAdExpiredTime().intValue();
                a.this.f20169g = System.currentTimeMillis();
            }
            com.sigmob.sdk.base.common.h.a(list);
            b bVar = new b();
            if (baseAdUnit.getCreativeType() == m.CreativeTypeMRAIDTWO.b()) {
                if (new com.sigmob.sdk.base.common.e(list, bVar, a.this.f20170h).a(false)) {
                    a.this.f20173k.a(new HashMap(), baseAdUnit);
                    return;
                }
                return;
            }
            if (baseAdUnit.getPlayMode() != 2) {
                a.this.f20173k.a(new HashMap(), baseAdUnit);
                com.sigmob.sdk.base.common.h.s().a(baseAdUnit, bVar);
            }
        }
    }

    public class g implements b0.g {

        /* renamed from: a */
        public final /* synthetic */ String f20187a;

        /* renamed from: b */
        public final /* synthetic */ String f20188b;

        /* renamed from: c */
        public final /* synthetic */ int f20189c;

        public g(String str, String str2, int i10) {
            this.f20187a = str;
            this.f20188b = str2;
            this.f20189c = i10;
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            if (obj instanceof PointEntitySigmobError) {
                PointEntitySigmobError pointEntitySigmobError = (PointEntitySigmobError) obj;
                pointEntitySigmobError.setLoad_id(this.f20187a);
                pointEntitySigmobError.setPlacement_id(this.f20188b);
                pointEntitySigmobError.setAdtype(String.valueOf(this.f20189c));
            }
        }
    }

    public class h implements b0.g {

        /* renamed from: a */
        public final /* synthetic */ Map f20191a;

        public h(Map map) {
            this.f20191a = map;
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                if (this.f20191a != null) {
                    pointEntitySigmob.getOptions().putAll(this.f20191a);
                }
            }
        }
    }

    @Override // com.sigmob.sdk.newInterstitial.e.b
    public void b(BaseAdUnit baseAdUnit) {
    }

    @Override // com.sigmob.sdk.base.common.o.b
    public void g(BaseAdUnit baseAdUnit) {
        SigmobLog.d("onInterstitialClicked() called");
        com.sigmob.sdk.videoAd.q qVar = this.f20174l;
        if (qVar != null) {
            qVar.onAdClicked(this.f20172j);
        }
    }

    public String h() {
        List<BaseAdUnit> list = this.f20166d;
        if (list == null || list.size() <= 0 || this.f20166d.get(0) == null || this.f20166d.get(0).bidding_response == null) {
            return null;
        }
        return String.valueOf(this.f20166d.get(0).bidding_response.ecpm);
    }

    public final boolean i() {
        return (this.f20168f == 0 || this.f20169g == 0 || System.currentTimeMillis() - this.f20169g <= this.f20168f) ? false : true;
    }

    @Override // com.sigmob.sdk.newInterstitial.e.b
    public void j(BaseAdUnit baseAdUnit) {
        SigmobLog.d("onVideoSkip() called");
    }

    public boolean k() {
        com.sigmob.sdk.newInterstitial.e eVar;
        List<BaseAdUnit> list = this.f20166d;
        if (list != null && list.size() > 0) {
            BaseAdUnit baseAdUnit = this.f20166d.get(0);
            if (baseAdUnit != null && !i() && m(baseAdUnit) && (eVar = this.f20173k) != null && eVar.a(baseAdUnit)) {
                return true;
            }
            if (baseAdUnit != null) {
                com.sigmob.sdk.base.common.h.s().e(baseAdUnit);
            }
        }
        return false;
    }

    public final void l() {
        com.sigmob.sdk.videoAd.o oVar;
        if (this.f20165c == AdStatus.AdStatusLoading && (oVar = this.f20164b) != null) {
            oVar.onAdPreLoadSuccess(this.f20172j);
        }
    }

    public final boolean m(BaseAdUnit baseAdUnit) {
        try {
            if (baseAdUnit.getPlayMode() != 0) {
                return true;
            }
            boolean isEndCardIndexExist = baseAdUnit.isEndCardIndexExist();
            if (!isEndCardIndexExist) {
                SigmobLog.e("endIndex file not ready");
            }
            return isEndCardIndexExist;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final void c(WindAdError windAdError) {
        com.sigmob.sdk.videoAd.o oVar;
        if (this.f20165c == AdStatus.AdStatusLoading && (oVar = this.f20164b) != null) {
            oVar.onAdPreLoadFail(windAdError, this.f20172j);
        }
    }

    public Map<String, BiddingResponse> d() {
        BaseAdUnit baseAdUnit;
        List<BaseAdUnit> list = this.f20166d;
        if (list == null || list.size() <= 0 || (baseAdUnit = this.f20166d.get(0)) == null || baseAdUnit.bidding_response == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(baseAdUnit.getRequestId(), baseAdUnit.bidding_response);
        return hashMap;
    }

    @Override // com.sigmob.sdk.newInterstitial.e.b
    public void h(BaseAdUnit baseAdUnit) {
        if (this.f20165c == AdStatus.AdStatusClose) {
            return;
        }
        com.sigmob.sdk.videoAd.q qVar = this.f20174l;
        if (qVar != null) {
            qVar.onVideoAdPlayEnd(this.f20172j);
        }
        if (!baseAdUnit.getDisableAutoLoad() && TextUtils.isEmpty(this.f20170h.getBidToken()) && baseAdUnit.bidding_response == null) {
            SigmobLog.d(baseAdUnit.getPlayMode() + " adsRequest onVideoClose: " + this.f20170h.getBidToken());
            if (baseAdUnit.getPlayMode() == 0 || !TextUtils.isEmpty(this.f20170h.getBidToken())) {
                return;
            }
            this.f20170h.setLastCampid(baseAdUnit.getCamp_id());
            this.f20170h.setLastCrid(baseAdUnit.getCrid());
            b(this.f20170h);
        }
    }

    @Override // com.sigmob.sdk.base.common.h.f
    public void i(BaseAdUnit baseAdUnit) {
        b0.a(PointCategory.LOADSTART, (String) null, baseAdUnit, (WindAdRequest) null, this.f20170h, (b0.g) null);
        com.sigmob.sdk.base.network.f.a(baseAdUnit, "load");
    }

    @Override // com.sigmob.sdk.base.common.o.b
    public void l(BaseAdUnit baseAdUnit) {
        SigmobLog.d("onInterstitialDismissed() called");
        AdStatus adStatus = this.f20165c;
        AdStatus adStatus2 = AdStatus.AdStatusClose;
        if (adStatus == adStatus2) {
            return;
        }
        this.f20165c = adStatus2;
        com.sigmob.sdk.newInterstitial.e eVar = this.f20173k;
        if (eVar != null) {
            eVar.b(baseAdUnit);
        }
        com.sigmob.sdk.videoAd.q qVar = this.f20174l;
        if (qVar != null) {
            qVar.onAdClosed(this.f20172j);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.sigmob.sdk.newInterstitial.e m() {
        /*
            r5 = this;
            com.sigmob.windad.WindAdError r0 = com.sigmob.windad.WindAdError.ERROR_SIGMOB_AD_PLAY_CHECK_FAIL
            com.czhj.sdk.common.models.AdStatus r1 = r5.f20165c
            com.czhj.sdk.common.models.AdStatus r2 = com.czhj.sdk.common.models.AdStatus.AdStatusPlaying
            r3 = 0
            r4 = 0
            if (r1 != r2) goto L14
            com.sigmob.windad.WindAdError r1 = com.sigmob.windad.WindAdError.ERROR_SIGMOB_AD_PLAY_HAS_PLAYING
            java.lang.String r1 = r1.getMessage()
        L10:
            r0.setMessage(r1)
            goto L5c
        L14:
            java.util.List<com.sigmob.sdk.base.models.BaseAdUnit> r1 = r5.f20166d
            if (r1 == 0) goto L59
            java.lang.Object r1 = r1.get(r3)
            if (r1 != 0) goto L1f
            goto L59
        L1f:
            com.czhj.sdk.common.models.AdStatus r1 = r5.f20165c
            com.czhj.sdk.common.models.AdStatus r2 = com.czhj.sdk.common.models.AdStatus.AdStatusReady
            if (r1 == r2) goto L28
            java.lang.String r1 = "ad status is not ready"
            goto L10
        L28:
            com.sigmob.sdk.newInterstitial.e r1 = r5.f20173k
            if (r1 != 0) goto L2f
            java.lang.String r1 = "interstitial object is null"
            goto L10
        L2f:
            java.util.List<com.sigmob.sdk.base.models.BaseAdUnit> r1 = r5.f20166d
            java.lang.Object r1 = r1.get(r3)
            com.sigmob.sdk.base.models.BaseAdUnit r1 = (com.sigmob.sdk.base.models.BaseAdUnit) r1
            boolean r2 = r5.i()
            if (r2 == 0) goto L43
            java.lang.String r2 = "ad unit is expired"
        L3f:
            r0.setMessage(r2)
            goto L5d
        L43:
            boolean r2 = r5.m(r1)
            if (r2 != 0) goto L4c
            java.lang.String r2 = "check ad unit endcard is invalid"
            goto L3f
        L4c:
            com.sigmob.sdk.newInterstitial.e r2 = r5.f20173k
            boolean r2 = r2.a(r1)
            if (r2 != 0) goto L57
            java.lang.String r2 = "check ad unit info is invalid"
            goto L3f
        L57:
            r3 = 1
            goto L5d
        L59:
            java.lang.String r1 = "not ready adUnit"
            goto L10
        L5c:
            r1 = r4
        L5d:
            if (r3 != 0) goto L6a
            r5.b(r0)
            com.sigmob.sdk.base.models.LoadAdRequest r2 = r5.f20170h
            java.lang.String r3 = "play"
            com.sigmob.sdk.base.common.b0.a(r3, r0, r1, r2)
            return r4
        L6a:
            com.sigmob.sdk.newInterstitial.e r0 = r5.f20173k
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.newInterstitial.a.m():com.sigmob.sdk.newInterstitial.e");
    }

    @Override // com.sigmob.sdk.base.common.h.f
    public void d(BaseAdUnit baseAdUnit, String str) {
        SigmobLog.d("onInterstitialLoaded() called");
        com.sigmob.sdk.base.network.f.a(baseAdUnit, TextUtils.isEmpty(str) ? com.sigmob.sdk.base.common.a.B : com.sigmob.sdk.base.common.a.C);
        this.f20163a.removeMessages(q.a.f24121r);
        b0.a(PointCategory.LOADEND, TextUtils.isEmpty(str) ? "1" : "0", baseAdUnit, (WindAdRequest) null, this.f20170h, (b0.g) null);
        if (baseAdUnit == null || baseAdUnit.getPlayMode() != 0) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.f20168f = baseAdUnit.getAdExpiredTime().intValue();
            this.f20169g = System.currentTimeMillis();
            a((WindAdError) null);
        } else {
            WindAdError windAdError = WindAdError.ERROR_SIGMOB_FILE_DOWNLOAD;
            windAdError.setMessage(str);
            a(baseAdUnit, "load", baseAdUnit.getAd_type(), baseAdUnit.getAdslot_id(), baseAdUnit.getLoad_id(), windAdError);
            a(windAdError);
            a();
        }
    }

    public void b() {
        if (!TextUtils.isEmpty(this.f20176n)) {
            com.sigmob.sdk.base.common.h.i(this.f20176n);
        }
        if (!TextUtils.isEmpty(this.f20175m)) {
            com.sigmob.sdk.base.common.h.i(this.f20175m);
        }
        a();
        this.f20164b = null;
        this.f20174l = null;
        this.f20167e = null;
    }

    @Override // com.sigmob.sdk.base.common.o.b
    public void d(BaseAdUnit baseAdUnit) {
        SigmobLog.d("onInterstitialShown() called");
        a();
        if (baseAdUnit != null) {
            com.sigmob.sdk.videoAd.q qVar = this.f20174l;
            if (qVar != null) {
                qVar.onAdShow(this.f20172j);
            }
            if (!baseAdUnit.getDisableAutoLoad() && TextUtils.isEmpty(this.f20170h.getBidToken()) && baseAdUnit.bidding_response == null) {
                SigmobLog.d(baseAdUnit.getPlayMode() + " adsRequest onInterstitialShown: " + this.f20170h.getBidToken());
                if (baseAdUnit.getPlayMode() == 0 && TextUtils.isEmpty(this.f20170h.getBidToken())) {
                    this.f20170h.setLastCampid(baseAdUnit.getCamp_id());
                    this.f20170h.setLastCrid(baseAdUnit.getCrid());
                    this.f20163a.post(new e());
                }
            }
        }
    }

    public final void b(WindAdError windAdError) {
        if (this.f20165c != AdStatus.AdStatusLoading) {
            a();
            this.f20165c = AdStatus.AdStatusNone;
        }
        com.sigmob.sdk.videoAd.q qVar = this.f20174l;
        if (qVar == null || windAdError == null) {
            return;
        }
        qVar.onAdShowError(windAdError, this.f20172j);
    }

    @Override // com.sigmob.sdk.base.common.o.b
    public void b(BaseAdUnit baseAdUnit, String str) {
        this.f20163a.removeMessages(q.a.f24121r);
        SigmobLog.d("onInterstitialFailed() called with: errorCode = [" + str + "]");
        b0.a(PointCategory.LOADEND, "0", baseAdUnit, (WindAdRequest) null, this.f20170h, (b0.g) null);
        com.sigmob.sdk.base.network.f.a(baseAdUnit, com.sigmob.sdk.base.common.a.C);
        a();
        if (baseAdUnit == null || baseAdUnit.getPlayMode() != 0) {
            return;
        }
        WindAdError windAdError = WindAdError.ERROR_SIGMOB_FILE_DOWNLOAD;
        windAdError.setMessage(str);
        a(baseAdUnit, "load", baseAdUnit.getAd_type(), baseAdUnit.getAdslot_id(), baseAdUnit.getLoad_id(), windAdError);
        a(windAdError);
    }

    public final void b(LoadAdRequest loadAdRequest) {
        a(loadAdRequest, com.sigmob.sdk.rewardVideoAd.a.AutoNextPreload, new f());
    }

    public final void a(LoadAdRequest loadAdRequest, com.sigmob.sdk.rewardVideoAd.a aVar, d.a aVar2) {
        loadAdRequest.getPlacementId();
        a();
        loadAdRequest.setRequest_scene_type(aVar.b().intValue());
        if (aVar != com.sigmob.sdk.rewardVideoAd.a.NormalRequest) {
            b0.a("request", "play", (BaseAdUnit) null, (WindAdRequest) null, loadAdRequest, new c());
        }
        loadAdRequest.setExpired(i());
        com.sigmob.sdk.base.network.d.a(loadAdRequest, aVar2);
    }

    public void a(String str, Map<String, String> map) {
        if (l.w().e()) {
            b0.a(str, (String) null, this.f20167e, new h(map));
        }
    }

    public final void a() {
        BaseAdUnit baseAdUnit;
        List<BaseAdUnit> list = this.f20166d;
        if (list != null && list.size() > 0 && (baseAdUnit = this.f20166d.get(0)) != null && baseAdUnit.getAd_source_channel().equalsIgnoreCase("1000")) {
            com.sigmob.sdk.base.common.h.s().e(baseAdUnit);
        }
        this.f20166d = null;
    }

    public void a(String str, String str2) {
        BaseAdUnit baseAdUnit;
        List<BaseAdUnit> list = this.f20166d;
        if (list == null || list.size() <= 0 || (baseAdUnit = this.f20166d.get(0)) == null || baseAdUnit.bidding_response == null) {
            return;
        }
        baseAdUnit.getMacroCommon().addMarcoKey(str, str2);
    }

    public void a(LoadAdRequest loadAdRequest) {
        WindAdError sigMobError;
        this.f20165c = AdStatus.AdStatusLoading;
        if (loadAdRequest == null || TextUtils.isEmpty(loadAdRequest.getPlacementId())) {
            SigmobLog.e("loadAd error loadAdRequest or placementId is null");
            a(WindAdError.ERROR_SIGMOB_PLACEMENTID_EMPTY);
            return;
        }
        try {
            if (Sigmob.getInstance() != null && (sigMobError = Sigmob.getInstance().getSigMobError()) != null) {
                SigmobLog.e("check loadAd error " + sigMobError.toString());
                PointEntitySigmobError.SigmobError("load", sigMobError.getErrorCode(), sigMobError.getMessage()).commit();
                a(sigMobError);
                return;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        if (!TextUtils.isEmpty(loadAdRequest.getBidToken())) {
            a();
        }
        this.f20172j = loadAdRequest.getPlacementId();
        this.f20170h = loadAdRequest;
        if (this.f20173k == null) {
            this.f20173k = new b(this);
        }
        if (k()) {
            this.f20173k.a((Map<String, Object>) null, this.f20166d.get(0));
            SigmobLog.d("adsRequest isReady  placementId = [" + this.f20172j + "]");
            l();
            a((WindAdError) null);
            return;
        }
        if (!TextUtils.isEmpty(this.f20176n)) {
            com.sigmob.sdk.base.common.h.i(this.f20176n);
        }
        if (!TextUtils.isEmpty(this.f20175m)) {
            com.sigmob.sdk.base.common.h.i(this.f20175m);
        }
        loadAdRequest.setLastCampid(com.sigmob.sdk.base.common.h.s().p());
        loadAdRequest.setLastCrid(com.sigmob.sdk.base.common.h.s().q());
        this.f20163a.sendEmptyMessageDelayed(q.a.f24121r, l.w().h0());
        a(loadAdRequest, com.sigmob.sdk.rewardVideoAd.a.NormalRequest, this);
    }

    public final void a(BaseAdUnit baseAdUnit, String str, int i10, String str2, String str3, WindAdError windAdError) {
        b0.a(str, windAdError, baseAdUnit, new g(str3, str2, i10));
    }

    public final void a(WindAdError windAdError) {
        if (this.f20165c != AdStatus.AdStatusLoading) {
            return;
        }
        if (windAdError == null) {
            this.f20165c = AdStatus.AdStatusReady;
            List<BaseAdUnit> list = this.f20166d;
            if (list != null && list.size() > 0) {
                b0.a(PointCategory.READY, (String) null, this.f20166d.get(0), this.f20170h, (b0.g) null);
            }
        } else {
            this.f20165c = AdStatus.AdStatusNone;
        }
        com.sigmob.sdk.videoAd.o oVar = this.f20164b;
        if (oVar != null) {
            if (windAdError != null) {
                oVar.onAdLoadError(windAdError, this.f20172j);
            } else {
                oVar.onAdLoadSuccess(this.f20172j);
            }
        }
    }

    @Override // com.sigmob.sdk.newInterstitial.e.b
    public void a(BaseAdUnit baseAdUnit, String str) {
        if (baseAdUnit != null && baseAdUnit.getAd_source_channel().equalsIgnoreCase("1000")) {
            com.sigmob.sdk.base.common.h.s().e(baseAdUnit);
        }
        WindAdError windAdError = WindAdError.ERROR_SIGMOB_AD_PLAY;
        windAdError.setMessage(str);
        b(windAdError);
        a(baseAdUnit, "play", this.f20170h.getAdType(), this.f20172j, this.f20170h.getLoadId(), windAdError);
        SigmobLog.d("onAdShowFail() called");
    }

    @Override // com.sigmob.sdk.base.network.d.a
    public void a(int i10, String str, String str2, LoadAdRequest loadAdRequest) {
        b0.a(PointCategory.RESPOND, "0", loadAdRequest);
        b0.a(PointCategory.RESPOND, "0", i10, str, loadAdRequest);
        WindAdError windAdError = WindAdError.getWindAdError(i10);
        if (windAdError == null) {
            windAdError = WindAdError.ERROR_SIGMOB_REQUEST;
            windAdError.setErrorMessage(i10, str);
        }
        c(windAdError);
        a(windAdError);
    }

    @Override // com.sigmob.sdk.base.common.o.b
    public void a(BaseAdUnit baseAdUnit) {
        if (baseAdUnit != null) {
            this.f20165c = AdStatus.AdStatusPlaying;
            com.sigmob.sdk.base.common.h.s().j(baseAdUnit.getCamp_id());
            com.sigmob.sdk.base.common.h.s().k(baseAdUnit.getCrid());
            a();
        }
    }

    @Override // com.sigmob.sdk.base.network.d.a
    public void a(List<BaseAdUnit> list, LoadAdRequest loadAdRequest) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    BaseAdUnit baseAdUnit = list.get(0);
                    this.f20176n = baseAdUnit.getRequestId();
                    this.f20166d = list;
                    b0.a(PointCategory.RESPOND, "1", (BaseAdUnit) null, loadAdRequest, new d(list));
                    if (this.f20173k == null) {
                        this.f20173k = new com.sigmob.sdk.newInterstitial.e(this);
                    }
                    if (!this.f20173k.a(baseAdUnit)) {
                        a(WindAdError.ERROR_SIGMOB_INFORMATION_LOSE);
                        return;
                    }
                    l();
                    com.sigmob.sdk.base.common.h.a(list);
                    for (BaseAdUnit baseAdUnit2 : this.f20166d) {
                        if (baseAdUnit2.getAd_source_channel().equalsIgnoreCase("1000")) {
                            com.sigmob.sdk.base.common.h.s().b(baseAdUnit2);
                        }
                    }
                    if (baseAdUnit.getPlayMode() != 0) {
                        this.f20168f = baseAdUnit.getAdExpiredTime().intValue();
                        this.f20169g = System.currentTimeMillis();
                        a((WindAdError) null);
                    }
                    if (baseAdUnit.getCreativeType() == m.CreativeTypeMRAIDTWO.b()) {
                        if (new com.sigmob.sdk.base.common.e(list, this, this.f20170h).a(false)) {
                            this.f20173k.a(new HashMap(), baseAdUnit);
                            return;
                        }
                        return;
                    }
                    if (baseAdUnit.getPlayMode() != 2) {
                        this.f20173k.a(new HashMap(), baseAdUnit);
                        com.sigmob.sdk.base.common.h.s().a(baseAdUnit, this);
                        return;
                    }
                    return;
                }
            } catch (Throwable th2) {
                SigmobLog.e(th2.getMessage());
                a();
                WindAdError windAdError = WindAdError.ERROR_SIGMOB_INFORMATION_LOSE;
                windAdError.setMessage(th2.getMessage());
                b0.a(PointCategory.RESPOND, "0", windAdError.getErrorCode(), windAdError.getMessage(), loadAdRequest);
                a(windAdError);
                return;
            }
        }
        WindAdError windAdError2 = WindAdError.ERROR_SIGMOB_INFORMATION_LOSE;
        c(windAdError2);
        b0.a(PointCategory.RESPOND, "0", windAdError2.getErrorCode(), windAdError2.getMessage(), loadAdRequest);
        a(windAdError2);
    }

    public void a(com.sigmob.sdk.videoAd.o oVar) {
        this.f20164b = oVar;
    }

    public void a(LoadAdRequest loadAdRequest, com.sigmob.sdk.videoAd.q qVar) {
        this.f20174l = qVar;
        this.f20170h = loadAdRequest;
        com.sigmob.sdk.newInterstitial.e m10 = m();
        if (m10 == null) {
            return;
        }
        BaseAdUnit baseAdUnit = this.f20166d.get(0);
        this.f20167e = baseAdUnit;
        this.f20176n = baseAdUnit.getRequestId();
        this.f20167e.setLoad_id(this.f20170h.getLoadId());
        this.f20167e.setBid_token(this.f20170h.getBidToken());
        this.f20167e.setAd_scene_id(this.f20170h.getAdSceneId());
        this.f20167e.setAd_scene_desc(this.f20170h.getAdSceneDesc());
        SigMacroCommon macroCommon = this.f20167e.getMacroCommon();
        if (macroCommon instanceof SigMacroCommon) {
            if (!TextUtils.isEmpty(this.f20170h.getAdSceneDesc())) {
                macroCommon.addMarcoKey(SigMacroCommon._ADSCENE_, this.f20170h.getAdSceneDesc());
            }
            if (!TextUtils.isEmpty(this.f20170h.getAdSceneId())) {
                macroCommon.addMarcoKey(SigMacroCommon._ADSCENEID_, this.f20170h.getAdSceneId());
            }
            if (!TextUtils.isEmpty(this.f20167e.getVideo_url())) {
                macroCommon.addMarcoKey(SigMacroCommon._VMD5_, com.sigmob.sdk.base.common.h.s().h(this.f20167e.getVideoPath()));
                try {
                    macroCommon.addMarcoKey(SigMacroCommon._VURL_, URLEncoder.encode(this.f20167e.getVideo_url(), "UTF-8"));
                } catch (UnsupportedEncodingException e10) {
                    SigmobLog.e(e10.getMessage());
                }
            }
        }
        if (this.f20167e.getCreativeType() == m.CreativeTypeMRAIDTWO.b()) {
            if (!new com.sigmob.sdk.base.common.e(this.f20166d, this, this.f20170h).a(true)) {
                m10.a(new HashMap(), this.f20167e);
            }
        } else if (this.f20167e.getPlayMode() == 2) {
            m10.a(new HashMap(), this.f20167e);
            com.sigmob.sdk.base.common.h.s().a(this.f20167e, this);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(k.f18189u, this.f20170h.isEnable_keep_on() || l.w().d0());
        bundle.putBoolean(k.f18188t, this.f20170h.isEnable_screen_lock_displayad() || l.w().c0());
        m10.a(this.f20167e, bundle);
        this.f20169g = 0L;
        this.f20168f = 0L;
    }
}
