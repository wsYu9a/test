package com.sigmob.sdk.newInterstitial;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.czhj.sdk.common.models.AdStatus;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.j;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.rtb.BiddingResponse;
import com.sigmob.sdk.base.mta.PointEntitySigmobError;
import com.sigmob.sdk.videoAd.o;
import com.sigmob.sdk.videoAd.q;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdRequest;
import com.sigmob.windad.WindAds;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class i extends j {

    /* renamed from: j */
    public com.sigmob.sdk.newInterstitial.a f20257j;

    /* renamed from: k */
    public com.sigmob.sdk.newInterstitial.a f20258k;

    /* renamed from: l */
    public Handler f20259l;

    /* renamed from: m */
    public LoadAdRequest f20260m;

    /* renamed from: n */
    public o f20261n;

    /* renamed from: o */
    public b f20262o;

    public class a implements q {

        /* renamed from: a */
        public final /* synthetic */ q f20263a;

        /* renamed from: com.sigmob.sdk.newInterstitial.i$a$a */
        public class RunnableC0619a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ String f20265a;

            public RunnableC0619a(String str) {
                this.f20265a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (i.this.f20257j != null) {
                    i.this.f20257j.a("show_callback", (Map<String, String>) null);
                }
                if (a.this.f20263a != null) {
                    SigmobLog.i("onVideoAdPlayStart |" + this.f20265a);
                    a.this.f20263a.onAdShow(this.f20265a);
                }
            }
        }

        public class b implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ String f20267a;

            public b(String str) {
                this.f20267a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f20263a != null) {
                    SigmobLog.i("onVideoAdPlayComplete " + this.f20267a);
                    a.this.f20263a.onVideoAdPlayComplete(this.f20267a);
                }
            }
        }

        public class c implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ String f20269a;

            public c(String str) {
                this.f20269a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f20263a != null) {
                    SigmobLog.i("onVideoAdPlayEnd |" + this.f20269a);
                    a.this.f20263a.onVideoAdPlayEnd(this.f20269a);
                }
            }
        }

        public class d implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ String f20271a;

            public d(String str) {
                this.f20271a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (i.this.f20257j != null) {
                    i.this.f20257j.a("click_callback", (Map<String, String>) null);
                }
                if (a.this.f20263a != null) {
                    SigmobLog.i("onVideoAdClicked |" + this.f20271a);
                    a.this.f20263a.onAdClicked(this.f20271a);
                }
            }
        }

        public class e implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ String f20273a;

            public e(String str) {
                this.f20273a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (i.this.f20257j != null) {
                    i.this.f20257j.a("close_callback", (Map<String, String>) null);
                }
                if (i.this.f20258k != null) {
                    if (i.this.f20257j != null) {
                        i.this.f20257j.b();
                    }
                    i iVar = i.this;
                    iVar.f20257j = iVar.f20258k;
                    i iVar2 = i.this;
                    iVar2.mADStatus = AdStatus.AdStatusReady;
                    iVar2.f20258k = null;
                }
                if (a.this.f20263a != null) {
                    SigmobLog.i("onVideoAdClosed " + this.f20273a);
                    a.this.f20263a.onAdClosed(this.f20273a);
                }
            }
        }

        public class f implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ WindAdError f20275a;

            /* renamed from: b */
            public final /* synthetic */ String f20276b;

            public f(WindAdError windAdError, String str) {
                this.f20275a = windAdError;
                this.f20276b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (i.this.f20258k != null) {
                    if (i.this.f20257j != null) {
                        i.this.f20257j.b();
                    }
                    i iVar = i.this;
                    iVar.f20257j = iVar.f20258k;
                    i iVar2 = i.this;
                    iVar2.mADStatus = AdStatus.AdStatusReady;
                    iVar2.f20258k = null;
                }
                if (a.this.f20263a != null) {
                    SigmobLog.i("onVideoAdPlayError " + this.f20275a.toString() + "|" + this.f20276b);
                    a.this.f20263a.onAdShowError(this.f20275a, this.f20276b);
                }
            }
        }

        public a(q qVar) {
            this.f20263a = qVar;
        }

        @Override // com.sigmob.sdk.videoAd.q
        public void onAdClicked(String str) {
            i.this.f20259l.post(new d(str));
        }

        @Override // com.sigmob.sdk.videoAd.q
        public void onAdClosed(String str) {
            i iVar = i.this;
            iVar.mADStatus = AdStatus.AdStatusClose;
            iVar.f20259l.post(new e(str));
        }

        @Override // com.sigmob.sdk.videoAd.q
        public void onAdShow(String str) {
            i iVar = i.this;
            iVar.mADStatus = AdStatus.AdStatusPlaying;
            iVar.f20259l.post(new RunnableC0619a(str));
        }

        @Override // com.sigmob.sdk.videoAd.q
        public void onAdShowError(WindAdError windAdError, String str) {
            i iVar = i.this;
            iVar.mADStatus = AdStatus.AdStatusClose;
            iVar.f20259l.post(new f(windAdError, str));
        }

        @Override // com.sigmob.sdk.videoAd.q
        public void onVideoAdPlayComplete(String str) {
            i.this.f20259l.post(new b(str));
        }

        @Override // com.sigmob.sdk.videoAd.q
        public void onVideoAdPlayEnd(String str) {
            i.this.f20259l.post(new c(str));
        }
    }

    public class b implements o {

        /* renamed from: a */
        public o f20278a;

        public class a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ String f20280a;

            public a(String str) {
                this.f20280a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.f20278a != null) {
                    b.this.f20278a.onAdLoadSuccess(this.f20280a);
                }
            }
        }

        /* renamed from: com.sigmob.sdk.newInterstitial.i$b$b */
        public class RunnableC0620b implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ String f20282a;

            public RunnableC0620b(String str) {
                this.f20282a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.f20278a != null) {
                    SigmobLog.i("onVideoAdPreLoadSuccess |" + this.f20282a);
                    b.this.f20278a.onAdPreLoadSuccess(this.f20282a);
                }
            }
        }

        public class c implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ WindAdError f20284a;

            /* renamed from: b */
            public final /* synthetic */ String f20285b;

            public c(WindAdError windAdError, String str) {
                this.f20284a = windAdError;
                this.f20285b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.f20278a != null) {
                    b.this.f20278a.onAdPreLoadFail(this.f20284a, this.f20285b);
                }
            }
        }

        public class d implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ WindAdError f20287a;

            /* renamed from: b */
            public final /* synthetic */ String f20288b;

            public d(WindAdError windAdError, String str) {
                this.f20287a = windAdError;
                this.f20288b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.f20278a != null) {
                    b.this.f20278a.onAdLoadError(this.f20287a, this.f20288b);
                }
            }
        }

        public b(o oVar) {
            this.f20278a = oVar;
        }

        @Override // com.sigmob.sdk.videoAd.o
        public void onAdLoadError(WindAdError windAdError, String str) {
            SigmobLog.i("onVideoAdLoadError |" + str + "|" + i.this.mADStatus + "|" + windAdError.getErrorCode() + "|" + windAdError.getMessage());
            i iVar = i.this;
            if (iVar.mADStatus != AdStatus.AdStatusPlaying) {
                iVar.mADStatus = AdStatus.AdStatusNone;
            }
            iVar.f20259l.post(new d(windAdError, str));
        }

        @Override // com.sigmob.sdk.videoAd.o
        public void onAdLoadSuccess(String str) {
            SigmobLog.i("onVideoAdLoadSuccess |" + str + "|" + i.this.mADStatus);
            i iVar = i.this;
            if (iVar.mADStatus != AdStatus.AdStatusPlaying) {
                iVar.mADStatus = AdStatus.AdStatusReady;
            }
            iVar.f20259l.post(new a(str));
        }

        @Override // com.sigmob.sdk.videoAd.o
        public void onAdPreLoadFail(WindAdError windAdError, String str) {
            SigmobLog.i("onVideoAdPreLoadFail |" + str + "|" + i.this.mADStatus + "|" + windAdError.getErrorCode() + "|" + windAdError.getMessage());
            i iVar = i.this;
            if (iVar.mADStatus != AdStatus.AdStatusPlaying) {
                iVar.mADStatus = AdStatus.AdStatusNone;
            }
            iVar.f20259l.post(new c(windAdError, str));
        }

        @Override // com.sigmob.sdk.videoAd.o
        public void onAdPreLoadSuccess(String str) {
            i.this.f20259l.post(new RunnableC0620b(str));
        }

        public void a() {
            this.f20278a = null;
        }
    }

    public i(WindAdRequest windAdRequest) {
        super(windAdRequest, false);
        com.sigmob.sdk.base.common.h.s().a(b(), windAdRequest.getAdType());
        this.f20257j = new com.sigmob.sdk.newInterstitial.a();
        this.f20259l = new Handler(Looper.getMainLooper());
    }

    public void destroy() {
        com.sigmob.sdk.newInterstitial.a aVar = this.f20257j;
        if (aVar != null) {
            aVar.b();
            this.f20257j = null;
        }
        com.sigmob.sdk.newInterstitial.a aVar2 = this.f20258k;
        if (aVar2 != null) {
            aVar2.b();
            this.f20258k = null;
        }
        b bVar = this.f20262o;
        if (bVar != null) {
            bVar.a();
            this.f20262o = null;
        }
        this.f20261n = null;
    }

    public final boolean e() {
        try {
            if (!loadAdFilter()) {
                return false;
            }
            b bVar = this.f20262o;
            if (bVar != null) {
                bVar.a();
                this.f20262o = null;
            }
            this.f20262o = new b(this.f20261n);
            com.sigmob.sdk.newInterstitial.a aVar = this.f20257j;
            if (aVar == null) {
                this.f20257j = new com.sigmob.sdk.newInterstitial.a();
            } else if (aVar.k() && this.mADStatus == AdStatus.AdStatusReady) {
                this.f20262o.onAdPreLoadSuccess(b());
                this.f20262o.onAdLoadSuccess(b());
                return true;
            }
            LoadAdRequest loadAdRequest = new LoadAdRequest(this.f18160e);
            this.f20260m = loadAdRequest;
            loadAdRequest.setBidToken(getBid_token());
            this.f20260m.setBidFloor(getBidFloor());
            this.f20260m.setCurrency(getCurrency());
            com.sigmob.sdk.newInterstitial.a aVar2 = this.f20257j;
            if (aVar2 != null) {
                aVar2.a(this.f20262o);
            }
            if (this.mADStatus != AdStatus.AdStatusPlaying) {
                d();
                this.mADStatus = AdStatus.AdStatusLoading;
                this.f20257j.a(this.f20260m);
            } else if (this.f20258k == null) {
                com.sigmob.sdk.newInterstitial.a aVar3 = new com.sigmob.sdk.newInterstitial.a();
                this.f20258k = aVar3;
                aVar3.a(this.f20262o);
                this.f20258k.a(this.f20260m);
                d();
            } else if (this.f20261n != null) {
                SigmobLog.i("onVideoAdLoadSuccess |" + b());
                this.f20261n.onAdLoadSuccess(b());
            }
            return true;
        } catch (Throwable th2) {
            WindAdError windAdError = WindAdError.ERROR_SIGMOB_REQUEST;
            PointEntitySigmobError SigmobError = PointEntitySigmobError.SigmobError("error", windAdError.getErrorCode(), th2.getMessage());
            SigmobError.setAdtype(String.valueOf(1));
            SigmobError.setPlacement_id(b());
            SigmobError.commit();
            if (this.f20261n != null) {
                SigmobLog.i("onVideoAdLoadError |" + b() + "|" + this.mADStatus + "|" + th2.getMessage());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onVideoAdLoadError |");
                sb2.append(b());
                SigmobLog.i(sb2.toString());
                this.f20261n.onAdLoadError(windAdError, b());
            }
            return false;
        }
    }

    @Override // com.sigmob.sdk.base.j
    public String getEcpm() {
        com.sigmob.sdk.newInterstitial.a aVar = this.f20257j;
        if (aVar != null) {
            return aVar.h();
        }
        return null;
    }

    public boolean isReady() {
        com.sigmob.sdk.newInterstitial.a aVar;
        return WindAds.sharedAds().isInit() && !TextUtils.isEmpty(b()) && (aVar = this.f20257j) != null && this.mADStatus == AdStatus.AdStatusReady && aVar.k();
    }

    @Override // com.sigmob.sdk.base.j
    public boolean loadAd() {
        super.loadAd();
        return e();
    }

    public void setAdLoadListener(o oVar) {
        this.f20261n = oVar;
    }

    public boolean show(HashMap<String, String> hashMap, q qVar) {
        try {
        } catch (Throwable th2) {
            PointEntitySigmobError SigmobError = PointEntitySigmobError.SigmobError("error", WindAdError.ERROR_SIGMOB_REQUEST.getErrorCode(), th2.getMessage());
            SigmobError.setAdtype(String.valueOf(1));
            SigmobError.setPlacement_id(b());
            SigmobError.commit();
            SigmobLog.e("show Ad ", th2);
        }
        if (this.f20260m != null) {
            if (hashMap != null) {
                if (hashMap.containsKey("scene_id")) {
                    this.f20260m.setAd_scene_id(hashMap.get("scene_id"));
                }
                if (hashMap.containsKey("scene_desc")) {
                    this.f20260m.setAd_scene_desc(hashMap.get("scene_desc"));
                }
            }
            this.f20257j.a(this.f20260m, new a(qVar));
            return true;
        }
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

    @Override // com.sigmob.sdk.base.j
    public boolean loadAd(String str) {
        super.loadAd(str);
        return e();
    }

    @Override // com.sigmob.sdk.base.j
    public void a(String str, String str2) {
        com.sigmob.sdk.newInterstitial.a aVar = this.f20257j;
        if (aVar != null) {
            aVar.a(str, str2);
        }
    }

    @Override // com.sigmob.sdk.base.j
    public Map<String, BiddingResponse> a() {
        com.sigmob.sdk.newInterstitial.a aVar = this.f20257j;
        if (aVar != null) {
            return aVar.d();
        }
        return null;
    }

    @Override // com.sigmob.sdk.base.j
    public void a(WindAdError windAdError) {
        if (this.mADStatus != AdStatus.AdStatusLoading) {
            this.mADStatus = AdStatus.AdStatusNone;
        }
        o oVar = this.f20261n;
        if (oVar != null) {
            oVar.onAdPreLoadFail(windAdError, b());
            this.f20261n.onAdLoadError(windAdError, b());
        }
    }
}
