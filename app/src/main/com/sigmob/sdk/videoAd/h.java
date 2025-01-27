package com.sigmob.sdk.videoAd;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.czhj.sdk.common.models.AdStatus;
import com.czhj.sdk.common.track.AdTracker;
import com.czhj.sdk.common.track.TrackManager;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.NetworkResponse;
import com.czhj.volley.VolleyError;
import com.sigmob.sdk.Sigmob;
import com.sigmob.sdk.base.common.b0;
import com.sigmob.sdk.base.common.h;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.models.rtb.BiddingResponse;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.mta.PointEntitySigmobError;
import com.sigmob.sdk.base.network.d;
import com.sigmob.sdk.videoAd.k;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdRequest;
import com.sigmob.windad.WindAds;
import com.sigmob.windad.rewardVideo.WindRewardInfo;
import com.umeng.analytics.pro.q;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class h implements k.b, d.a, h.f {

    /* renamed from: b */
    public o f20429b;

    /* renamed from: c */
    public int f20430c;

    /* renamed from: d */
    public AdStatus f20431d;

    /* renamed from: e */
    public List<BaseAdUnit> f20432e;

    /* renamed from: f */
    public BaseAdUnit f20433f;

    /* renamed from: g */
    public long f20434g;

    /* renamed from: h */
    public long f20435h;

    /* renamed from: i */
    public LoadAdRequest f20436i;

    /* renamed from: k */
    public String f20438k;

    /* renamed from: l */
    public k f20439l;

    /* renamed from: m */
    public q f20440m;

    /* renamed from: n */
    public p f20441n;

    /* renamed from: q */
    public boolean f20444q;

    /* renamed from: j */
    public final int f20437j = q.a.f24121r;

    /* renamed from: o */
    public String f20442o = null;

    /* renamed from: p */
    public String f20443p = null;

    /* renamed from: a */
    public final Handler f20428a = new a(Looper.getMainLooper());

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 8193 && h.this.f20431d == AdStatus.AdStatusLoading) {
                h.this.f20428a.removeMessages(q.a.f24121r);
                h.this.a(WindAdError.ERROR_SIGMOB_AD_TIME_OUT);
            }
        }
    }

    public class b implements b0.g {

        /* renamed from: a */
        public final /* synthetic */ Map f20446a;

        public b(Map map) {
            this.f20446a = map;
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                if (this.f20446a != null) {
                    pointEntitySigmob.getOptions().putAll(this.f20446a);
                }
            }
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
        public final /* synthetic */ List f20449a;

        public d(List list) {
            this.f20449a = list;
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                HashMap hashMap = new HashMap();
                hashMap.put("ad_count", String.valueOf(this.f20449a.size()));
                ((PointEntitySigmob) obj).setOptions(hashMap);
            }
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar = h.this;
            hVar.b(hVar.f20436i);
        }
    }

    public class f implements TrackManager.Listener {
        public f() {
        }

        @Override // com.czhj.sdk.common.track.TrackManager.Listener
        public void onErrorResponse(AdTracker adTracker, VolleyError volleyError) {
            if (h.this.f20430c == 1) {
                h.this.f20430c = 2;
                if (h.this.f20441n != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(WindAds.TRANS_ID, h.this.f20442o);
                    hashMap.put(WindAds.SERVER_ARRIVED, "0");
                    hashMap.put(WindAds.REWARD_TYPE, "1");
                    h.this.f20441n.onVideoAdRewarded(new WindRewardInfo(true, hashMap), h.this.f20438k);
                }
            }
        }

        @Override // com.czhj.sdk.common.track.TrackManager.Listener
        public void onSuccess(AdTracker adTracker, NetworkResponse networkResponse) {
            if (h.this.f20430c == 1) {
                h.this.f20430c = 2;
                if (h.this.f20441n != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(WindAds.TRANS_ID, h.this.f20442o);
                    hashMap.put(WindAds.SERVER_ARRIVED, "1");
                    hashMap.put(WindAds.REWARD_TYPE, "1");
                    h.this.f20441n.onVideoAdRewarded(new WindRewardInfo(true, hashMap), h.this.f20438k);
                }
            }
        }
    }

    public class g implements d.a {

        public class a implements b0.g {

            /* renamed from: a */
            public final /* synthetic */ List f20454a;

            public a(List list) {
                this.f20454a = list;
            }

            @Override // com.sigmob.sdk.base.common.b0.g
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmob) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("ad_count", String.valueOf(this.f20454a.size()));
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
                h.this.f20428a.removeMessages(q.a.f24121r);
                b0.a(PointCategory.LOADEND, TextUtils.isEmpty(str) ? "1" : "0", baseAdUnit, (WindAdRequest) null, h.this.f20436i, (b0.g) null);
                if (baseAdUnit == null || baseAdUnit.getPlayMode() != 0) {
                    return;
                }
                if (TextUtils.isEmpty(str)) {
                    h.this.f20434g = baseAdUnit.getAdExpiredTime().intValue();
                    h.this.f20435h = System.currentTimeMillis();
                } else {
                    WindAdError windAdError = WindAdError.ERROR_SIGMOB_FILE_DOWNLOAD;
                    windAdError.setMessage(str);
                    h.this.a(baseAdUnit, "load", baseAdUnit.getAd_type(), baseAdUnit.getAdslot_id(), baseAdUnit.getLoad_id(), windAdError);
                    h.this.a();
                }
            }

            @Override // com.sigmob.sdk.base.common.h.f
            public void i(BaseAdUnit baseAdUnit) {
                b0.a(PointCategory.LOADSTART, (String) null, baseAdUnit, (WindAdRequest) null, h.this.f20436i, (b0.g) null);
                com.sigmob.sdk.base.network.f.a(baseAdUnit, "load");
            }
        }

        public g() {
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
            h.this.f20432e = list;
            h.this.f20443p = baseAdUnit.getRequestId();
            b0.a(PointCategory.RESPOND, "1", (BaseAdUnit) null, loadAdRequest, new a(list));
            if (!h.this.f20439l.a(baseAdUnit)) {
                h.this.a(WindAdError.ERROR_SIGMOB_INFORMATION_LOSE);
                return;
            }
            if (baseAdUnit.getAd_source_channel().equalsIgnoreCase("1000")) {
                com.sigmob.sdk.base.common.h.s().b(baseAdUnit);
            }
            if (baseAdUnit.getPlayMode() != 0) {
                h.this.f20434g = baseAdUnit.getAdExpiredTime().intValue();
                h.this.f20435h = System.currentTimeMillis();
            }
            com.sigmob.sdk.base.common.h.a(list);
            b bVar = new b();
            if (baseAdUnit.getCreativeType() == com.sigmob.sdk.base.common.m.CreativeTypeMRAIDTWO.b()) {
                if (new com.sigmob.sdk.base.common.e(list, bVar, h.this.f20436i).a(false)) {
                    h.this.f20439l.a(new HashMap(), baseAdUnit);
                    return;
                }
                return;
            }
            if (baseAdUnit.getPlayMode() != 2) {
                h.this.f20439l.a(new HashMap(), baseAdUnit);
                com.sigmob.sdk.base.common.h.s().a(baseAdUnit, bVar);
            }
        }
    }

    /* renamed from: com.sigmob.sdk.videoAd.h$h */
    public class C0622h implements b0.g {

        /* renamed from: a */
        public final /* synthetic */ String f20457a;

        /* renamed from: b */
        public final /* synthetic */ String f20458b;

        /* renamed from: c */
        public final /* synthetic */ int f20459c;

        public C0622h(String str, String str2, int i10) {
            this.f20457a = str;
            this.f20458b = str2;
            this.f20459c = i10;
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            if (obj instanceof PointEntitySigmobError) {
                PointEntitySigmobError pointEntitySigmobError = (PointEntitySigmobError) obj;
                pointEntitySigmobError.setLoad_id(this.f20457a);
                pointEntitySigmobError.setPlacement_id(this.f20458b);
                pointEntitySigmobError.setAdtype(String.valueOf(this.f20459c));
            }
        }
    }

    public h(boolean z10) {
        this.f20444q = z10;
    }

    public boolean k() {
        k kVar;
        List<BaseAdUnit> list = this.f20432e;
        if (list != null && list.size() > 0) {
            BaseAdUnit baseAdUnit = this.f20432e.get(0);
            if (baseAdUnit != null && !i() && m(baseAdUnit) && (kVar = this.f20439l) != null && kVar.a(baseAdUnit)) {
                return true;
            }
            if (baseAdUnit != null) {
                com.sigmob.sdk.base.common.h.s().e(baseAdUnit);
            }
        }
        return false;
    }

    public final void l() {
        o oVar;
        if (this.f20431d == AdStatus.AdStatusLoading && (oVar = this.f20429b) != null) {
            oVar.onAdPreLoadSuccess(this.f20438k);
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

    public final void n(BaseAdUnit baseAdUnit) {
        if (baseAdUnit != null) {
            String rvCallBackUrl = baseAdUnit.getRvCallBackUrl();
            if (!TextUtils.isEmpty(rvCallBackUrl)) {
                AdTracker adTracker = new AdTracker(AdTracker.MessageType.TRACKING_URL, rvCallBackUrl, "reward_server", baseAdUnit.getRequestId());
                adTracker.setRetryNum(Integer.valueOf(baseAdUnit.getTrackingRetryNum()));
                com.sigmob.sdk.base.network.f.a(adTracker, baseAdUnit, false, true, true, new f());
                return;
            }
        }
        this.f20430c = 2;
        if (this.f20441n != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(WindAds.TRANS_ID, this.f20442o);
            hashMap.put(WindAds.SERVER_ARRIVED, "0");
            hashMap.put(WindAds.REWARD_TYPE, "0");
            this.f20441n.onVideoAdRewarded(new WindRewardInfo(true, hashMap), this.f20438k);
        }
    }

    public final void c(WindAdError windAdError) {
        o oVar;
        if (this.f20431d == AdStatus.AdStatusLoading && (oVar = this.f20429b) != null) {
            oVar.onAdPreLoadFail(windAdError, this.f20438k);
        }
    }

    public Map<String, BiddingResponse> d() {
        BaseAdUnit baseAdUnit;
        List<BaseAdUnit> list = this.f20432e;
        if (list == null || list.size() <= 0 || (baseAdUnit = this.f20432e.get(0)) == null || baseAdUnit.bidding_response == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(baseAdUnit.getRequestId(), baseAdUnit.bidding_response);
        return hashMap;
    }

    @Override // com.sigmob.sdk.videoAd.k.b
    public void e(BaseAdUnit baseAdUnit) {
        SigmobLog.d("onVideoPlay() called");
    }

    @Override // com.sigmob.sdk.videoAd.k.b
    public void f(BaseAdUnit baseAdUnit) {
        q qVar = this.f20440m;
        if (qVar != null) {
            qVar.onVideoAdPlayEnd(this.f20438k);
        }
        if (!baseAdUnit.getDisableAutoLoad() && TextUtils.isEmpty(this.f20436i.getBidToken()) && baseAdUnit.bidding_response == null) {
            SigmobLog.d(baseAdUnit.getPlayMode() + " adsRequest onVideoClose: " + this.f20436i.getBidToken());
            if (baseAdUnit.getPlayMode() == 0 || !TextUtils.isEmpty(this.f20436i.getBidToken())) {
                return;
            }
            this.f20436i.setLastCampid(baseAdUnit.getCamp_id());
            this.f20436i.setLastCrid(baseAdUnit.getCrid());
            b(this.f20436i);
        }
    }

    @Override // com.sigmob.sdk.base.common.o.b
    public void g(BaseAdUnit baseAdUnit) {
        SigmobLog.d("onInterstitialClicked() called");
        q qVar = this.f20440m;
        if (qVar != null) {
            qVar.onAdClicked(this.f20438k);
        }
    }

    public String h() {
        List<BaseAdUnit> list = this.f20432e;
        if (list == null || list.size() <= 0 || this.f20432e.get(0) == null || this.f20432e.get(0).bidding_response == null) {
            return null;
        }
        return String.valueOf(this.f20432e.get(0).bidding_response.ecpm);
    }

    public final boolean i() {
        return (this.f20434g == 0 || this.f20435h == 0 || System.currentTimeMillis() - this.f20435h <= this.f20434g) ? false : true;
    }

    @Override // com.sigmob.sdk.videoAd.k.b
    public void k(BaseAdUnit baseAdUnit) {
        SigmobLog.d("onVideoComplete() called");
        this.f20430c = 1;
        q qVar = this.f20440m;
        if (qVar != null) {
            qVar.onVideoAdPlayComplete(this.f20438k);
        }
        n(baseAdUnit);
    }

    @Override // com.sigmob.sdk.base.common.o.b
    public void l(BaseAdUnit baseAdUnit) {
        SigmobLog.d("onInterstitialDismissed() called");
        AdStatus adStatus = this.f20431d;
        AdStatus adStatus2 = AdStatus.AdStatusClose;
        if (adStatus == adStatus2) {
            return;
        }
        this.f20431d = adStatus2;
        k kVar = this.f20439l;
        if (kVar != null) {
            kVar.b(baseAdUnit);
        }
        if (this.f20430c == 1) {
            this.f20430c = 0;
            if (this.f20441n != null) {
                HashMap hashMap = new HashMap();
                hashMap.put(WindAds.TRANS_ID, this.f20442o);
                hashMap.put(WindAds.SERVER_ARRIVED, "0");
                hashMap.put(WindAds.REWARD_TYPE, "1");
                this.f20441n.onVideoAdRewarded(new WindRewardInfo(true, hashMap), this.f20438k);
            }
        }
        q qVar = this.f20440m;
        if (qVar != null) {
            qVar.onAdClosed(this.f20438k);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.sigmob.sdk.videoAd.k m() {
        /*
            r5 = this;
            com.sigmob.windad.WindAdError r0 = com.sigmob.windad.WindAdError.ERROR_SIGMOB_AD_PLAY_CHECK_FAIL
            com.czhj.sdk.common.models.AdStatus r1 = r5.f20431d
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
            java.util.List<com.sigmob.sdk.base.models.BaseAdUnit> r1 = r5.f20432e
            if (r1 == 0) goto L59
            java.lang.Object r1 = r1.get(r3)
            if (r1 != 0) goto L1f
            goto L59
        L1f:
            com.czhj.sdk.common.models.AdStatus r1 = r5.f20431d
            com.czhj.sdk.common.models.AdStatus r2 = com.czhj.sdk.common.models.AdStatus.AdStatusReady
            if (r1 == r2) goto L28
            java.lang.String r1 = "ad status is not ready"
            goto L10
        L28:
            com.sigmob.sdk.videoAd.k r1 = r5.f20439l
            if (r1 != 0) goto L2f
            java.lang.String r1 = "interstitial object is null"
            goto L10
        L2f:
            java.util.List<com.sigmob.sdk.base.models.BaseAdUnit> r1 = r5.f20432e
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
            com.sigmob.sdk.videoAd.k r2 = r5.f20439l
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
            com.sigmob.sdk.base.models.LoadAdRequest r2 = r5.f20436i
            java.lang.String r3 = "play"
            com.sigmob.sdk.base.common.b0.a(r3, r0, r1, r2)
            return r4
        L6a:
            com.sigmob.sdk.videoAd.k r0 = r5.f20439l
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.videoAd.h.m():com.sigmob.sdk.videoAd.k");
    }

    public void b() {
        if (!TextUtils.isEmpty(this.f20442o)) {
            com.sigmob.sdk.base.common.h.i(this.f20442o);
        }
        if (!TextUtils.isEmpty(this.f20443p)) {
            com.sigmob.sdk.base.common.h.i(this.f20443p);
        }
        a();
        this.f20440m = null;
        this.f20429b = null;
        this.f20441n = null;
        this.f20433f = null;
    }

    @Override // com.sigmob.sdk.videoAd.k.b
    public void c(BaseAdUnit baseAdUnit, String str) {
        if (baseAdUnit != null && baseAdUnit.getAd_source_channel().equalsIgnoreCase("1000")) {
            com.sigmob.sdk.base.common.h.s().e(baseAdUnit);
        }
        WindAdError windAdError = WindAdError.ERROR_SIGMOB_AD_PLAY;
        windAdError.setMessage(str);
        b(windAdError);
        a(baseAdUnit, "play", this.f20436i.getAdType(), this.f20438k, this.f20436i.getLoadId(), windAdError);
        SigmobLog.d("onVideoPlayFail() called");
    }

    @Override // com.sigmob.sdk.base.common.h.f
    public void d(BaseAdUnit baseAdUnit, String str) {
        SigmobLog.d("onInterstitialLoaded() called");
        com.sigmob.sdk.base.network.f.a(baseAdUnit, TextUtils.isEmpty(str) ? com.sigmob.sdk.base.common.a.B : com.sigmob.sdk.base.common.a.C);
        this.f20428a.removeMessages(q.a.f24121r);
        b0.a(PointCategory.LOADEND, TextUtils.isEmpty(str) ? "1" : "0", baseAdUnit, (WindAdRequest) null, this.f20436i, (b0.g) null);
        if (baseAdUnit == null || baseAdUnit.getPlayMode() != 0) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.f20434g = baseAdUnit.getAdExpiredTime().intValue();
            this.f20435h = System.currentTimeMillis();
            a((WindAdError) null);
        } else {
            WindAdError windAdError = WindAdError.ERROR_SIGMOB_FILE_DOWNLOAD;
            windAdError.setMessage(str);
            a(baseAdUnit, "load", baseAdUnit.getAd_type(), baseAdUnit.getAdslot_id(), baseAdUnit.getLoad_id(), windAdError);
            a(windAdError);
            a();
        }
    }

    @Override // com.sigmob.sdk.base.common.h.f
    public void i(BaseAdUnit baseAdUnit) {
        b0.a(PointCategory.LOADSTART, (String) null, baseAdUnit, (WindAdRequest) null, this.f20436i, (b0.g) null);
        com.sigmob.sdk.base.network.f.a(baseAdUnit, "load");
    }

    public final void b(WindAdError windAdError) {
        if (this.f20431d != AdStatus.AdStatusLoading) {
            a();
            this.f20431d = AdStatus.AdStatusNone;
        }
        q qVar = this.f20440m;
        if (qVar == null || windAdError == null) {
            return;
        }
        qVar.onAdShowError(windAdError, this.f20438k);
    }

    @Override // com.sigmob.sdk.videoAd.k.b
    public void c(BaseAdUnit baseAdUnit) {
        SigmobLog.d("onVideoSkip() called");
    }

    @Override // com.sigmob.sdk.base.common.o.b
    public void d(BaseAdUnit baseAdUnit) {
        SigmobLog.d("onInterstitialShown() called");
        this.f20430c = 0;
        a();
        q qVar = this.f20440m;
        if (qVar != null) {
            qVar.onAdShow(this.f20438k);
        }
        if (baseAdUnit == null || baseAdUnit.getDisableAutoLoad() || !TextUtils.isEmpty(this.f20436i.getBidToken()) || baseAdUnit.bidding_response != null) {
            return;
        }
        SigmobLog.d(baseAdUnit.getPlayMode() + " adsRequest onInterstitialShown: " + this.f20436i.getBidToken());
        if (baseAdUnit.getPlayMode() == 0 && TextUtils.isEmpty(this.f20436i.getBidToken())) {
            this.f20436i.setLastCampid(baseAdUnit.getCamp_id());
            this.f20436i.setLastCrid(baseAdUnit.getCrid());
            this.f20428a.post(new e());
        }
    }

    @Override // com.sigmob.sdk.base.common.o.b
    public void b(BaseAdUnit baseAdUnit, String str) {
        this.f20428a.removeMessages(q.a.f24121r);
        SigmobLog.d("onInterstitialFailed() called with: errorCode = [" + str + "]");
        b0.a(PointCategory.LOADEND, "0", baseAdUnit, (WindAdRequest) null, this.f20436i, (b0.g) null);
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
        a(loadAdRequest, com.sigmob.sdk.rewardVideoAd.a.AutoNextPreload, new g());
    }

    public final void a(LoadAdRequest loadAdRequest, com.sigmob.sdk.rewardVideoAd.a aVar, d.a aVar2) {
        String placementId = loadAdRequest.getPlacementId();
        a();
        loadAdRequest.setRequest_scene_type(aVar.b().intValue());
        if (aVar != com.sigmob.sdk.rewardVideoAd.a.NormalRequest) {
            b0.a("request", "play", (BaseAdUnit) null, (WindAdRequest) null, loadAdRequest, new c());
        }
        loadAdRequest.setExpired(i());
        com.sigmob.sdk.base.network.d.a(loadAdRequest, aVar2);
        SigmobLog.d("adsRequest loadAdRequest = [" + loadAdRequest + "], placementId = [" + placementId + "]");
    }

    public void a(String str, Map<String, String> map) {
        if (com.sigmob.sdk.base.l.w().e()) {
            b0.a(str, (String) null, this.f20433f, new b(map));
        }
    }

    public final void a() {
        List<BaseAdUnit> list = this.f20432e;
        if (list != null && list.size() > 0) {
            for (BaseAdUnit baseAdUnit : this.f20432e) {
                if (baseAdUnit != null) {
                    if (baseAdUnit.getAd_source_channel().equalsIgnoreCase("1000")) {
                        com.sigmob.sdk.base.common.h.s().e(baseAdUnit);
                    }
                    com.sigmob.sdk.base.common.h.d(baseAdUnit);
                }
            }
        }
        this.f20432e = null;
    }

    public void a(String str, String str2) {
        BaseAdUnit baseAdUnit;
        List<BaseAdUnit> list = this.f20432e;
        if (list == null || list.size() <= 0 || (baseAdUnit = this.f20432e.get(0)) == null || baseAdUnit.bidding_response == null) {
            return;
        }
        baseAdUnit.getMacroCommon().addMarcoKey(str, str2);
    }

    public void a(LoadAdRequest loadAdRequest) {
        WindAdError sigMobError;
        this.f20431d = AdStatus.AdStatusLoading;
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
        this.f20438k = loadAdRequest.getPlacementId();
        this.f20436i = loadAdRequest;
        if (this.f20439l == null) {
            this.f20439l = new k(this, this.f20444q);
        }
        if (k()) {
            this.f20439l.a((Map<String, Object>) null, this.f20432e.get(0));
            SigmobLog.d("adsRequest isReady  placementId = [" + this.f20438k + "]");
            l();
            a((WindAdError) null);
            return;
        }
        if (!TextUtils.isEmpty(this.f20442o)) {
            com.sigmob.sdk.base.common.h.i(this.f20442o);
        }
        if (!TextUtils.isEmpty(this.f20443p)) {
            com.sigmob.sdk.base.common.h.i(this.f20443p);
        }
        loadAdRequest.setLastCampid(com.sigmob.sdk.base.common.h.s().p());
        loadAdRequest.setLastCrid(com.sigmob.sdk.base.common.h.s().q());
        this.f20428a.sendEmptyMessageDelayed(q.a.f24121r, com.sigmob.sdk.base.l.w().h0());
        a(loadAdRequest, com.sigmob.sdk.rewardVideoAd.a.NormalRequest, this);
    }

    public final void a(BaseAdUnit baseAdUnit, String str, int i10, String str2, String str3, WindAdError windAdError) {
        b0.a(str, windAdError, baseAdUnit, new C0622h(str3, str2, i10));
    }

    public final void a(WindAdError windAdError) {
        if (this.f20431d != AdStatus.AdStatusLoading) {
            return;
        }
        if (windAdError == null) {
            this.f20431d = AdStatus.AdStatusReady;
            List<BaseAdUnit> list = this.f20432e;
            if (list != null && list.size() > 0) {
                b0.a(PointCategory.READY, (String) null, this.f20432e.get(0), this.f20436i, (b0.g) null);
            }
        } else {
            this.f20431d = AdStatus.AdStatusNone;
        }
        o oVar = this.f20429b;
        if (oVar != null) {
            if (windAdError != null) {
                oVar.onAdLoadError(windAdError, this.f20438k);
            } else {
                oVar.onAdLoadSuccess(this.f20438k);
            }
        }
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
                    this.f20432e = list;
                    this.f20442o = baseAdUnit.getRequestId();
                    b0.a(PointCategory.RESPOND, "1", (BaseAdUnit) null, loadAdRequest, new d(list));
                    if (this.f20439l == null) {
                        this.f20439l = new k(this, this.f20444q);
                    }
                    if (!this.f20439l.a(baseAdUnit)) {
                        a(WindAdError.ERROR_SIGMOB_INFORMATION_LOSE);
                        return;
                    }
                    l();
                    com.sigmob.sdk.base.common.h.a(list);
                    for (BaseAdUnit baseAdUnit2 : this.f20432e) {
                        if (baseAdUnit2.getAd_source_channel().equalsIgnoreCase("1000")) {
                            com.sigmob.sdk.base.common.h.s().b(baseAdUnit2);
                        }
                    }
                    if (baseAdUnit.getPlayMode() != 0) {
                        this.f20434g = baseAdUnit.getAdExpiredTime().intValue();
                        this.f20435h = System.currentTimeMillis();
                        a((WindAdError) null);
                    }
                    if (baseAdUnit.getCreativeType() == com.sigmob.sdk.base.common.m.CreativeTypeMRAIDTWO.b()) {
                        if (new com.sigmob.sdk.base.common.e(list, this, this.f20436i).a(false)) {
                            this.f20439l.a(new HashMap(), baseAdUnit);
                            return;
                        }
                        return;
                    }
                    if (baseAdUnit.getPlayMode() != 2) {
                        this.f20439l.a(new HashMap(), baseAdUnit);
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

    public void a(o oVar) {
        this.f20429b = oVar;
    }

    public void a(p pVar) {
        this.f20441n = pVar;
    }

    public void a(LoadAdRequest loadAdRequest, q qVar) {
        this.f20440m = qVar;
        this.f20436i = loadAdRequest;
        k m10 = m();
        if (m10 == null) {
            return;
        }
        BaseAdUnit baseAdUnit = this.f20432e.get(0);
        this.f20433f = baseAdUnit;
        this.f20442o = baseAdUnit.getRequestId();
        this.f20433f.setLoad_id(this.f20436i.getLoadId());
        this.f20433f.setBid_token(this.f20436i.getBidToken());
        this.f20433f.setAd_scene_id(this.f20436i.getAdSceneId());
        this.f20433f.setAd_scene_desc(this.f20436i.getAdSceneDesc());
        SigMacroCommon macroCommon = this.f20433f.getMacroCommon();
        if (macroCommon instanceof SigMacroCommon) {
            if (!TextUtils.isEmpty(this.f20436i.getAdSceneDesc())) {
                macroCommon.addMarcoKey(SigMacroCommon._ADSCENE_, this.f20436i.getAdSceneDesc());
            }
            if (!TextUtils.isEmpty(this.f20436i.getAdSceneId())) {
                macroCommon.addMarcoKey(SigMacroCommon._ADSCENEID_, this.f20436i.getAdSceneId());
            }
            if (!TextUtils.isEmpty(this.f20433f.getVideo_url())) {
                macroCommon.addMarcoKey(SigMacroCommon._VMD5_, com.sigmob.sdk.base.common.h.s().h(this.f20433f.getVideoPath()));
                try {
                    macroCommon.addMarcoKey(SigMacroCommon._VURL_, URLEncoder.encode(this.f20433f.getVideo_url(), "UTF-8"));
                } catch (UnsupportedEncodingException e10) {
                    SigmobLog.e(e10.getMessage());
                }
            }
        }
        if (this.f20433f.getCreativeType() == com.sigmob.sdk.base.common.m.CreativeTypeMRAIDTWO.b()) {
            if (!new com.sigmob.sdk.base.common.e(this.f20432e, this, this.f20436i).a(true)) {
                m10.a(new HashMap(), this.f20433f);
            }
        } else if (this.f20433f.getPlayMode() == 2) {
            m10.a(new HashMap(), this.f20433f);
            com.sigmob.sdk.base.common.h.s().a(this.f20433f, this);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(com.sigmob.sdk.base.k.f18189u, this.f20436i.isEnable_keep_on() || com.sigmob.sdk.base.l.w().d0());
        bundle.putBoolean(com.sigmob.sdk.base.k.f18188t, this.f20436i.isEnable_screen_lock_displayad() || com.sigmob.sdk.base.l.w().c0());
        m10.a(this.f20433f, bundle);
        this.f20435h = 0L;
        this.f20434g = 0L;
        this.f20431d = AdStatus.AdStatusPlaying;
    }
}
