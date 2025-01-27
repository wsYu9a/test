package com.sigmob.sdk.base;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.czhj.sdk.common.models.AdStatus;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.rtb.BiddingResponse;
import com.sigmob.sdk.base.mta.PointEntitySigmobError;
import com.sigmob.sdk.videoAd.o;
import com.sigmob.sdk.videoAd.p;
import com.sigmob.sdk.videoAd.q;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdRequest;
import com.sigmob.windad.WindAds;
import com.sigmob.windad.rewardVideo.WindRewardInfo;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class m extends j {

    /* renamed from: j */
    public com.sigmob.sdk.videoAd.h f18212j;

    /* renamed from: k */
    public com.sigmob.sdk.videoAd.h f18213k;

    /* renamed from: l */
    public Handler f18214l;

    /* renamed from: m */
    public LoadAdRequest f18215m;

    /* renamed from: n */
    public o f18216n;

    /* renamed from: o */
    public boolean f18217o;

    /* renamed from: p */
    public c f18218p;

    public class a implements p {

        /* renamed from: a */
        public final /* synthetic */ p f18219a;

        /* renamed from: com.sigmob.sdk.base.m$a$a */
        public class RunnableC0570a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ WindRewardInfo f18221a;

            /* renamed from: b */
            public final /* synthetic */ String f18222b;

            public RunnableC0570a(WindRewardInfo windRewardInfo, String str) {
                this.f18221a = windRewardInfo;
                this.f18222b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (m.this.f18212j != null) {
                    m.this.f18212j.a("reward_callback", this.f18221a.getOptions());
                }
                if (a.this.f18219a != null) {
                    SigmobLog.i("onVideoAdRewarded " + this.f18222b);
                    a.this.f18219a.onVideoAdRewarded(this.f18221a, this.f18222b);
                }
            }
        }

        public a(p pVar) {
            this.f18219a = pVar;
        }

        @Override // com.sigmob.sdk.videoAd.p
        public void onVideoAdRewarded(WindRewardInfo windRewardInfo, String str) {
            m.this.f18214l.post(new RunnableC0570a(windRewardInfo, str));
        }
    }

    public class b implements q {

        /* renamed from: a */
        public final /* synthetic */ q f18224a;

        public class a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ String f18226a;

            public a(String str) {
                this.f18226a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (m.this.f18212j != null) {
                    m.this.f18212j.a("show_callback", (Map<String, String>) null);
                }
                if (b.this.f18224a != null) {
                    SigmobLog.i("onVideoAdPlayStart |" + this.f18226a);
                    b.this.f18224a.onAdShow(this.f18226a);
                }
            }
        }

        /* renamed from: com.sigmob.sdk.base.m$b$b */
        public class RunnableC0571b implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ String f18228a;

            public RunnableC0571b(String str) {
                this.f18228a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                q qVar = b.this.f18224a;
                if (qVar != null) {
                    qVar.onVideoAdPlayComplete(this.f18228a);
                }
            }
        }

        public class c implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ String f18230a;

            public c(String str) {
                this.f18230a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.f18224a != null) {
                    SigmobLog.i("onVideoAdPlayEnd |" + this.f18230a);
                    b.this.f18224a.onVideoAdPlayEnd(this.f18230a);
                }
            }
        }

        public class d implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ String f18232a;

            public d(String str) {
                this.f18232a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (m.this.f18212j != null) {
                    m.this.f18212j.a("click_callback", (Map<String, String>) null);
                }
                if (b.this.f18224a != null) {
                    SigmobLog.i("onVideoAdClicked |" + this.f18232a);
                    b.this.f18224a.onAdClicked(this.f18232a);
                }
            }
        }

        public class e implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ String f18234a;

            public e(String str) {
                this.f18234a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (m.this.f18212j != null) {
                    m.this.f18212j.a("close_callback", (Map<String, String>) null);
                }
                if (m.this.f18213k != null) {
                    if (m.this.f18212j != null) {
                        m.this.f18212j.b();
                    }
                    m mVar = m.this;
                    mVar.f18212j = mVar.f18213k;
                    m mVar2 = m.this;
                    mVar2.mADStatus = AdStatus.AdStatusReady;
                    mVar2.f18213k = null;
                }
                if (b.this.f18224a != null) {
                    SigmobLog.i("onVideoAdClosed " + this.f18234a);
                    b.this.f18224a.onAdClosed(this.f18234a);
                }
            }
        }

        public class f implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ WindAdError f18236a;

            /* renamed from: b */
            public final /* synthetic */ String f18237b;

            public f(WindAdError windAdError, String str) {
                this.f18236a = windAdError;
                this.f18237b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (m.this.f18213k != null) {
                    if (m.this.f18212j != null) {
                        m.this.f18212j.b();
                    }
                    m mVar = m.this;
                    mVar.f18212j = mVar.f18213k;
                    m mVar2 = m.this;
                    mVar2.mADStatus = AdStatus.AdStatusReady;
                    mVar2.f18213k = null;
                }
                if (b.this.f18224a != null) {
                    SigmobLog.i("onVideoAdPlayError " + this.f18236a.toString() + "|" + this.f18237b);
                    b.this.f18224a.onAdShowError(this.f18236a, this.f18237b);
                }
            }
        }

        public b(q qVar) {
            this.f18224a = qVar;
        }

        @Override // com.sigmob.sdk.videoAd.q
        public void onAdClicked(String str) {
            m.this.f18214l.post(new d(str));
        }

        @Override // com.sigmob.sdk.videoAd.q
        public void onAdClosed(String str) {
            m mVar = m.this;
            mVar.mADStatus = AdStatus.AdStatusClose;
            mVar.f18214l.post(new e(str));
        }

        @Override // com.sigmob.sdk.videoAd.q
        public void onAdShow(String str) {
            m mVar = m.this;
            mVar.mADStatus = AdStatus.AdStatusPlaying;
            mVar.f18214l.post(new a(str));
        }

        @Override // com.sigmob.sdk.videoAd.q
        public void onAdShowError(WindAdError windAdError, String str) {
            m mVar = m.this;
            mVar.mADStatus = AdStatus.AdStatusClose;
            mVar.f18214l.post(new f(windAdError, str));
        }

        @Override // com.sigmob.sdk.videoAd.q
        public void onVideoAdPlayComplete(String str) {
            m.this.f18214l.post(new RunnableC0571b(str));
        }

        @Override // com.sigmob.sdk.videoAd.q
        public void onVideoAdPlayEnd(String str) {
            m.this.f18214l.post(new c(str));
        }
    }

    public class c implements o {

        /* renamed from: a */
        public o f18239a;

        public class a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ String f18241a;

            public a(String str) {
                this.f18241a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (c.this.f18239a != null) {
                    c.this.f18239a.onAdLoadSuccess(this.f18241a);
                }
            }
        }

        public class b implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ String f18243a;

            public b(String str) {
                this.f18243a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (c.this.f18239a != null) {
                    SigmobLog.i("onVideoAdPreLoadSuccess |" + this.f18243a);
                    c.this.f18239a.onAdPreLoadSuccess(this.f18243a);
                }
            }
        }

        /* renamed from: com.sigmob.sdk.base.m$c$c */
        public class RunnableC0572c implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ WindAdError f18245a;

            /* renamed from: b */
            public final /* synthetic */ String f18246b;

            public RunnableC0572c(WindAdError windAdError, String str) {
                this.f18245a = windAdError;
                this.f18246b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (c.this.f18239a != null) {
                    c.this.f18239a.onAdPreLoadFail(this.f18245a, this.f18246b);
                }
            }
        }

        public class d implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ WindAdError f18248a;

            /* renamed from: b */
            public final /* synthetic */ String f18249b;

            public d(WindAdError windAdError, String str) {
                this.f18248a = windAdError;
                this.f18249b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (c.this.f18239a != null) {
                    c.this.f18239a.onAdLoadError(this.f18248a, this.f18249b);
                }
            }
        }

        public c(o oVar) {
            this.f18239a = oVar;
        }

        @Override // com.sigmob.sdk.videoAd.o
        public void onAdLoadError(WindAdError windAdError, String str) {
            SigmobLog.i("onVideoAdLoadError |" + str + "|" + m.this.mADStatus + "|" + windAdError.getErrorCode() + "|" + windAdError.getMessage());
            m mVar = m.this;
            if (mVar.mADStatus != AdStatus.AdStatusPlaying) {
                mVar.mADStatus = AdStatus.AdStatusNone;
            }
            mVar.f18214l.post(new d(windAdError, str));
        }

        @Override // com.sigmob.sdk.videoAd.o
        public void onAdLoadSuccess(String str) {
            SigmobLog.i("onVideoAdLoadSuccess |" + str + "|" + m.this.mADStatus);
            m mVar = m.this;
            if (mVar.mADStatus != AdStatus.AdStatusPlaying) {
                mVar.mADStatus = AdStatus.AdStatusReady;
            }
            mVar.f18214l.post(new a(str));
        }

        @Override // com.sigmob.sdk.videoAd.o
        public void onAdPreLoadFail(WindAdError windAdError, String str) {
            SigmobLog.i("onVideoAdPreLoadFail |" + str + "|" + m.this.mADStatus + "|" + windAdError.getErrorCode() + "|" + windAdError.getMessage());
            m mVar = m.this;
            if (mVar.mADStatus != AdStatus.AdStatusPlaying) {
                mVar.mADStatus = AdStatus.AdStatusNone;
            }
            mVar.f18214l.post(new RunnableC0572c(windAdError, str));
        }

        @Override // com.sigmob.sdk.videoAd.o
        public void onAdPreLoadSuccess(String str) {
            m.this.f18214l.post(new b(str));
        }

        public void a() {
            this.f18239a = null;
        }
    }

    public m(WindAdRequest windAdRequest, boolean z10) {
        super(windAdRequest, z10);
        com.sigmob.sdk.base.common.h.s().a(b(), windAdRequest.getAdType());
        this.f18217o = z10;
        this.f18212j = new com.sigmob.sdk.videoAd.h(z10);
        this.f18214l = new Handler(Looper.getMainLooper());
    }

    public void destroy() {
        WindAdRequest windAdRequest = this.f18160e;
        SigmobLog.i(String.format("video ad %s is Destroy", windAdRequest != null ? windAdRequest.getPlacementId() : "null"));
        com.sigmob.sdk.videoAd.h hVar = this.f18212j;
        if (hVar != null) {
            hVar.b();
            this.f18212j = null;
        }
        com.sigmob.sdk.videoAd.h hVar2 = this.f18213k;
        if (hVar2 != null) {
            hVar2.b();
            this.f18213k = null;
        }
        c cVar = this.f18218p;
        if (cVar != null) {
            cVar.a();
            this.f18218p = null;
        }
        this.f18216n = null;
    }

    public final boolean e() {
        try {
            if (!loadAdFilter()) {
                return false;
            }
            c cVar = this.f18218p;
            if (cVar != null) {
                cVar.a();
                this.f18218p = null;
            }
            this.f18218p = new c(this.f18216n);
            com.sigmob.sdk.videoAd.h hVar = this.f18212j;
            if (hVar == null) {
                this.f18212j = new com.sigmob.sdk.videoAd.h(this.f18217o);
            } else if (hVar.k() && this.mADStatus == AdStatus.AdStatusReady) {
                this.f18218p.onAdPreLoadSuccess(b());
                this.f18218p.onAdLoadSuccess(b());
                return true;
            }
            LoadAdRequest loadAdRequest = new LoadAdRequest(this.f18160e);
            this.f18215m = loadAdRequest;
            loadAdRequest.setBidToken(getBid_token());
            this.f18215m.setBidFloor(getBidFloor());
            this.f18215m.setCurrency(getCurrency());
            com.sigmob.sdk.videoAd.h hVar2 = this.f18212j;
            if (hVar2 != null) {
                hVar2.a(this.f18218p);
            }
            if (this.mADStatus != AdStatus.AdStatusPlaying) {
                d();
                this.mADStatus = AdStatus.AdStatusLoading;
                this.f18212j.a(this.f18215m);
            } else if (this.f18213k == null) {
                com.sigmob.sdk.videoAd.h hVar3 = new com.sigmob.sdk.videoAd.h(this.f18217o);
                this.f18213k = hVar3;
                hVar3.a(this.f18218p);
                this.f18213k.a(this.f18215m);
                d();
            } else if (this.f18216n != null) {
                SigmobLog.i("onVideoAdLoadSuccess |" + b());
                this.f18216n.onAdLoadSuccess(b());
            }
            return true;
        } catch (Throwable th2) {
            WindAdError windAdError = WindAdError.ERROR_SIGMOB_REQUEST;
            PointEntitySigmobError SigmobError = PointEntitySigmobError.SigmobError("error", windAdError.getErrorCode(), th2.getMessage());
            SigmobError.setAdtype(String.valueOf(1));
            SigmobError.setPlacement_id(b());
            SigmobError.commit();
            if (this.f18216n != null) {
                SigmobLog.i("onVideoAdLoadError |" + b());
                this.f18216n.onAdLoadError(windAdError, b());
            }
            return false;
        }
    }

    @Override // com.sigmob.sdk.base.j
    public String getEcpm() {
        com.sigmob.sdk.videoAd.h hVar = this.f18212j;
        if (hVar != null) {
            return hVar.h();
        }
        return null;
    }

    public boolean isReady() {
        com.sigmob.sdk.videoAd.h hVar;
        return WindAds.sharedAds().isInit() && !TextUtils.isEmpty(b()) && (hVar = this.f18212j) != null && this.mADStatus == AdStatus.AdStatusReady && hVar.k();
    }

    @Override // com.sigmob.sdk.base.j
    public boolean loadAd() {
        super.loadAd();
        return e();
    }

    public void setAdLoadListener(o oVar) {
        this.f18216n = oVar;
    }

    public boolean show(HashMap<String, String> hashMap, q qVar) {
        return show(hashMap, qVar, null);
    }

    @Override // com.sigmob.sdk.base.j
    public boolean loadAd(String str) {
        super.loadAd(str);
        return e();
    }

    public boolean show(HashMap<String, String> hashMap, q qVar, p pVar) {
        LoadAdRequest loadAdRequest;
        try {
            loadAdRequest = this.f18215m;
        } catch (Throwable th2) {
            PointEntitySigmobError SigmobError = PointEntitySigmobError.SigmobError("error", WindAdError.ERROR_SIGMOB_REQUEST.getErrorCode(), th2.getMessage());
            SigmobError.setAdtype(String.valueOf(1));
            SigmobError.setPlacement_id(b());
            SigmobError.commit();
            SigmobLog.e("show Ad ", th2);
        }
        if (loadAdRequest == null) {
            WindAdError windAdError = WindAdError.ERROR_SIGMOB_PLACEMENTID_EMPTY;
            PointEntitySigmobError SigmobError2 = PointEntitySigmobError.SigmobError("error", windAdError.getErrorCode(), "loadAdRequest is null");
            SigmobError2.setAdtype(String.valueOf(1));
            SigmobError2.setPlacement_id(b());
            SigmobError2.commit();
            if (qVar == null) {
                return false;
            }
            qVar.onAdShowError(windAdError, b());
            return false;
        }
        com.sigmob.sdk.base.common.h.a(loadAdRequest.getPlacementId());
        if (hashMap != null) {
            if (hashMap.containsKey("scene_id")) {
                this.f18215m.setAd_scene_id(hashMap.get("scene_id"));
            }
            if (hashMap.containsKey("scene_desc")) {
                this.f18215m.setAd_scene_desc(hashMap.get("scene_desc"));
            }
        }
        if (this.f18160e.getAdType() == 1) {
            this.f18212j.a(new a(pVar));
        }
        this.f18212j.a(this.f18215m, new b(qVar));
        return true;
    }

    @Override // com.sigmob.sdk.base.j
    public void a(String str, String str2) {
        com.sigmob.sdk.videoAd.h hVar = this.f18212j;
        if (hVar != null) {
            hVar.a(str, str2);
        }
    }

    @Override // com.sigmob.sdk.base.j
    public Map<String, BiddingResponse> a() {
        com.sigmob.sdk.videoAd.h hVar = this.f18212j;
        if (hVar != null) {
            return hVar.d();
        }
        return null;
    }

    @Override // com.sigmob.sdk.base.j
    public void a(WindAdError windAdError) {
        if (this.mADStatus != AdStatus.AdStatusLoading) {
            this.mADStatus = AdStatus.AdStatusNone;
        }
        o oVar = this.f18216n;
        if (oVar != null) {
            oVar.onAdPreLoadFail(windAdError, b());
            this.f18216n.onAdLoadError(windAdError, b());
        }
    }
}
