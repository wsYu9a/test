package com.sigmob.sdk.splash;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.models.AdStatus;
import com.czhj.sdk.common.utils.FileUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.BaseBroadcastReceiver;
import com.sigmob.sdk.base.common.b0;
import com.sigmob.sdk.base.common.d0;
import com.sigmob.sdk.base.common.h;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.rtb.BiddingResponse;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.network.d;
import com.sigmob.sdk.splash.f;
import com.sigmob.windad.Splash.WindSplashADListener;
import com.sigmob.windad.Splash.WindSplashAdRequest;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdRequest;
import com.sigmob.windad.WindAds;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public final class g implements d.a, f.a, h.f {

    /* renamed from: l */
    public static final int f20313l = 131073;

    /* renamed from: a */
    public final LoadAdRequest f20314a;

    /* renamed from: c */
    public Handler f20316c;

    /* renamed from: e */
    public WindSplashADListener f20318e;

    /* renamed from: f */
    public int f20319f;

    /* renamed from: h */
    public i f20321h;

    /* renamed from: i */
    public BaseAdUnit f20322i;

    /* renamed from: j */
    public int f20323j = 0;

    /* renamed from: k */
    public int f20324k = 0;

    /* renamed from: b */
    public final Runnable f20315b = new a();

    /* renamed from: g */
    public AdStatus f20320g = AdStatus.AdStatusNone;

    /* renamed from: d */
    public f f20317d = new f(this);

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g.this.f20316c != null) {
                g.this.f20316c.removeCallbacksAndMessages(null);
                if (g.this.f20321h == null) {
                    return;
                }
                if (g.this.f20319f <= 0) {
                    g.this.f20321h.setDuration(0);
                    return;
                }
                g.this.f20321h.setDuration(g.this.f20319f);
                g.d(g.this);
                g.this.f20316c.postDelayed(g.this.f20315b, 1000L);
            }
        }
    }

    public class b implements b0.g {
        public b() {
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                ((PointEntitySigmob) obj).setAdx_id(null);
            }
        }
    }

    public class c extends Handler {

        public class a implements b0.g {
            public a() {
            }

            @Override // com.sigmob.sdk.base.common.b0.g
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmob) {
                    ((PointEntitySigmob) obj).setAdx_id(null);
                }
            }
        }

        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 131073) {
                return;
            }
            WindAdError windAdError = WindAdError.ERROR_SIGMOB_SPLASH_TIMEOUT;
            b0.a("request", (String) null, windAdError.getErrorCode(), windAdError.getMessage(), (WindAdRequest) null, g.this.f20314a, (BaseAdUnit) null, new a());
            g.this.a(windAdError, true);
        }
    }

    public class d implements b0.g {
        public d() {
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                ((PointEntitySigmob) obj).setAdx_id(null);
            }
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g.this.f20318e != null) {
                g.this.f20318e.onSplashAdLoadSuccess(g.this.f20314a.getPlacementId());
            }
        }
    }

    public g(WindSplashAdRequest windSplashAdRequest, WindSplashADListener windSplashADListener) {
        this.f20314a = new LoadAdRequest(windSplashAdRequest);
        this.f20318e = windSplashADListener;
    }

    public static /* synthetic */ int d(g gVar) {
        int i10 = gVar.f20319f;
        gVar.f20319f = i10 - 1;
        return i10;
    }

    @Override // com.sigmob.sdk.base.common.o.b
    public void a(BaseAdUnit baseAdUnit) {
    }

    @Override // com.sigmob.sdk.splash.f.a
    public void e() {
    }

    public String h() {
        BiddingResponse biddingResponse;
        BaseAdUnit baseAdUnit = this.f20322i;
        if (baseAdUnit == null || (biddingResponse = baseAdUnit.bidding_response) == null) {
            return null;
        }
        return String.valueOf(biddingResponse.ecpm);
    }

    @Override // com.sigmob.sdk.base.common.h.f
    public void i(BaseAdUnit baseAdUnit) {
    }

    @Override // com.sigmob.sdk.splash.f.a
    public void j() {
        this.f20321h.setDuration(0);
        WindSplashADListener windSplashADListener = this.f20318e;
        if (windSplashADListener != null) {
            windSplashADListener.onSplashAdSkip(this.f20314a.getPlacementId());
        }
    }

    public boolean k() {
        try {
            if (this.f20322i == null) {
                Object readFromCache = FileUtil.readFromCache(com.sigmob.sdk.base.utils.d.d(this.f20314a.getPlacementId()));
                if ((readFromCache instanceof BaseAdUnit) && ((BaseAdUnit) readFromCache).getAd() != null) {
                    FileUtil.deleteFile(com.sigmob.sdk.base.utils.d.d(this.f20314a.getPlacementId()));
                    this.f20322i = (BaseAdUnit) readFromCache;
                }
            }
            if (this.f20322i != null) {
                return new File(this.f20322i.getSplashFilePath()).canRead() && !(this.f20322i.getAd().expired_time.intValue() != 0 && ((System.currentTimeMillis() - this.f20322i.getCreate_time()) > ((long) this.f20322i.getAdExpiredTime().intValue()) ? 1 : ((System.currentTimeMillis() - this.f20322i.getCreate_time()) == ((long) this.f20322i.getAdExpiredTime().intValue()) ? 0 : -1)) > 0) && this.f20317d.a(this.f20322i);
            }
        } catch (Exception e10) {
            SigmobLog.e(e10.getMessage());
        }
        return false;
    }

    public void l() {
        WindAdError windAdError = WindAdError.ERROR_SIGMOB_SPLASH_UNSUPPORT_ORIENTATION;
        b0.a("play", windAdError, this.f20322i);
        a(windAdError, false);
        o();
    }

    @Override // com.sigmob.sdk.base.common.o.c
    public void m() {
    }

    @Override // com.sigmob.sdk.base.common.o.c
    public void n() {
        BaseBroadcastReceiver.a(com.sigmob.sdk.a.d(), this.f20322i.getUuid(), IntentActions.ACTION_INTERSTITIAL_DISMISS);
    }

    public final void o() {
        d0 sessionManager;
        if (this.f20317d != null) {
            BaseAdUnit baseAdUnit = this.f20322i;
            if (baseAdUnit != null && (sessionManager = baseAdUnit.getSessionManager()) != null) {
                sessionManager.a();
            }
            this.f20317d.b(this.f20322i);
        }
        if (this.f20320g == AdStatus.AdStatusPlaying) {
            this.f20320g = AdStatus.AdStatusClose;
            WindSplashADListener windSplashADListener = this.f20318e;
            if (windSplashADListener != null) {
                windSplashADListener.onSplashAdClose(this.f20314a.getPlacementId());
            }
        }
        Handler handler = this.f20316c;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f20316c = null;
        }
        if (this.f20321h != null && !this.f20314a.isDisableAutoHideAd()) {
            com.sigmob.sdk.base.utils.e.e(this.f20321h);
            this.f20321h = null;
        }
        com.sigmob.sdk.base.common.h.d(this.f20322i);
        this.f20322i = null;
        this.f20318e = null;
    }

    public final Activity b() {
        return com.sigmob.sdk.base.utils.e.b(this.f20321h);
    }

    @Override // com.sigmob.sdk.splash.f.a
    public void c() {
        WindAdError windAdError = WindAdError.ERROR_SIGMOB_SPLASH_UNSUPPORT_RESOURCE;
        b0.a("play", windAdError, this.f20322i);
        a(windAdError, false);
        o();
    }

    public Map<String, BiddingResponse> d() {
        BaseAdUnit baseAdUnit = this.f20322i;
        if (baseAdUnit == null || baseAdUnit.bidding_response == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(this.f20322i.getRequestId(), this.f20322i.bidding_response);
        return hashMap;
    }

    @Override // com.sigmob.sdk.splash.f.a
    public void f() {
        Handler handler = this.f20316c;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f20316c = null;
        }
    }

    @Override // com.sigmob.sdk.base.common.o.b
    public void g(BaseAdUnit baseAdUnit) {
        WindSplashADListener windSplashADListener = this.f20318e;
        if (windSplashADListener != null) {
            windSplashADListener.onSplashAdClick(this.f20314a.getPlacementId());
        }
    }

    public void i() {
        if (this.f20322i.getSessionManager() == null) {
            new k().a(this.f20322i);
        }
    }

    @Override // com.sigmob.sdk.base.common.o.b
    public void l(BaseAdUnit baseAdUnit) {
        WindSplashADListener windSplashADListener = this.f20318e;
        if (windSplashADListener != null) {
            windSplashADListener.onSplashAdClose(this.f20314a.getPlacementId());
        }
        this.f20320g = AdStatus.AdStatusClose;
        o();
        if (TextUtils.isEmpty(this.f20314a.getBidToken()) && baseAdUnit.bidding_response == null) {
            a(null, 0, WindAds.CNY, 45, true);
        }
    }

    @Override // com.sigmob.sdk.base.common.o.b
    public void b(BaseAdUnit baseAdUnit, String str) {
        WindAdError windAdError = WindAdError.ERROR_SIGMOB_FILE_DOWNLOAD;
        windAdError.setMessage(str);
        a(windAdError, true);
        b0.a("load", windAdError, this.f20322i);
    }

    @Override // com.sigmob.sdk.base.common.h.f
    public void d(BaseAdUnit baseAdUnit, String str) {
        SigmobLog.d(" loadEnd");
        if (!TextUtils.isEmpty(str)) {
            b(this.f20322i, str);
            return;
        }
        b0.a(PointCategory.READY, (String) null, baseAdUnit, this.f20314a, (b0.g) null);
        if (this.f20320g == AdStatus.AdStatusClose) {
            SigmobLog.d(" next load");
            FileUtil.writeToCache(baseAdUnit, com.sigmob.sdk.base.utils.d.d(this.f20314a.getPlacementId()));
        }
        if (this.f20320g != AdStatus.AdStatusLoading) {
            return;
        }
        if (1 != ClientMetadata.getInstance().getOrientationInt().intValue()) {
            l();
            return;
        }
        Handler handler = this.f20316c;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.f20320g = AdStatus.AdStatusReady;
        WindAds.sharedAds().getHandler().post(new e());
    }

    public final boolean a(Context context, BaseAdUnit baseAdUnit) {
        if (baseAdUnit == null) {
            return false;
        }
        i iVar = new i(context.getApplicationContext());
        this.f20321h = iVar;
        iVar.m();
        this.f20321h.setShowAppLogo(this.f20323j != 0);
        return this.f20321h.a(baseAdUnit);
    }

    public void b(Activity activity) {
        if (this.f20321h == null || activity != b()) {
            return;
        }
        this.f20321h.q();
        if (this.f20316c == null) {
            this.f20316c = new Handler(Looper.getMainLooper());
        }
        this.f20316c.post(this.f20315b);
    }

    @Override // com.sigmob.sdk.base.common.o.b
    public void d(BaseAdUnit baseAdUnit) {
        this.f20320g = AdStatus.AdStatusPlaying;
        i();
        com.sigmob.sdk.base.common.h.a(baseAdUnit);
        if (this.f20321h.getDuration() > 0 && this.f20321h.getDuration() < this.f20319f) {
            this.f20319f = this.f20321h.getDuration();
        }
        i iVar = this.f20321h;
        if (iVar != null) {
            iVar.setDuration(this.f20319f);
            this.f20321h.setVisibility(0);
        }
        WindSplashADListener windSplashADListener = this.f20318e;
        if (windSplashADListener != null) {
            windSplashADListener.onSplashAdShow(this.f20314a.getPlacementId());
        }
        if (this.f20316c == null) {
            this.f20316c = new Handler(Looper.getMainLooper());
        }
        this.f20324k = this.f20319f;
        this.f20316c.post(this.f20315b);
    }

    public void a() {
        o();
    }

    public void a(String str, String str2) {
        BaseAdUnit baseAdUnit = this.f20322i;
        if (baseAdUnit == null || baseAdUnit.bidding_response == null) {
            return;
        }
        baseAdUnit.getMacroCommon().addMarcoKey(str, str2);
    }

    public final void a(WindAdError windAdError, boolean z10) {
        WindSplashADListener windSplashADListener;
        this.f20320g = AdStatus.AdStatusNone;
        Handler handler = this.f20316c;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f20316c = null;
        }
        if (this.f20314a.getRequest_scene_type() != com.sigmob.sdk.rewardVideoAd.a.SplashCloseRequest.b().intValue() && (windSplashADListener = this.f20318e) != null) {
            if (z10) {
                windSplashADListener.onSplashAdLoadFail(windAdError, this.f20314a.getPlacementId());
            } else {
                windSplashADListener.onSplashAdShowError(windAdError, this.f20314a.getPlacementId());
            }
            this.f20318e = null;
        }
        f fVar = this.f20317d;
        if (fVar != null) {
            fVar.b(this.f20322i);
        }
    }

    public void a(String str, int i10, String str2, int i11, boolean z10) {
        f fVar;
        if (z10) {
            this.f20314a.setRequest_scene_type(com.sigmob.sdk.rewardVideoAd.a.SplashCloseRequest.b().intValue());
            b0.a("request", "play", (BaseAdUnit) null, (WindAdRequest) null, this.f20314a, new b());
        } else {
            this.f20320g = AdStatus.AdStatusLoading;
            if (k() && (fVar = this.f20317d) != null) {
                fVar.a((Map<String, Object>) null, this.f20322i);
                com.sigmob.sdk.base.common.h.s().a(this.f20322i, this);
                return;
            }
            this.f20314a.setRequest_scene_type(com.sigmob.sdk.rewardVideoAd.a.NormalRequest.b().intValue());
        }
        c cVar = new c(Looper.getMainLooper());
        this.f20316c = cVar;
        cVar.sendEmptyMessageDelayed(f20313l, i11 * 1000);
        this.f20314a.setBidToken(str);
        this.f20314a.setBidFloor(i10);
        this.f20314a.setCurrency(str2);
        com.sigmob.sdk.base.network.d.a(this.f20314a, this);
    }

    @Override // com.sigmob.sdk.base.network.d.a
    public void a(int i10, String str, String str2, LoadAdRequest loadAdRequest) {
        WindAdError windAdError = WindAdError.getWindAdError(i10);
        if (windAdError == null) {
            windAdError = WindAdError.ERROR_SIGMOB_REQUEST;
            windAdError.setErrorMessage(i10, str);
        }
        b0.a(PointCategory.RESPOND, "0", loadAdRequest);
        b0.a("request", (String) null, i10, str, (WindAdRequest) null, loadAdRequest, (BaseAdUnit) null, new d());
        a(windAdError, true);
    }

    public void a(Activity activity) {
        if (this.f20321h == null || activity != b()) {
            return;
        }
        this.f20321h.p();
        Handler handler = this.f20316c;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f20316c = null;
        }
    }

    @Override // com.sigmob.sdk.base.network.d.a
    public void a(List<BaseAdUnit> list, LoadAdRequest loadAdRequest) {
        BaseAdUnit baseAdUnit = list.get(0);
        b0.b(PointCategory.RESPOND, "1", baseAdUnit);
        if (!this.f20317d.a(baseAdUnit)) {
            a(WindAdError.ERROR_SIGMOB_INFORMATION_LOSE, true);
            return;
        }
        this.f20322i = baseAdUnit;
        f fVar = this.f20317d;
        if (fVar != null) {
            fVar.a((Map<String, Object>) null, baseAdUnit);
        }
        com.sigmob.sdk.base.common.h.s().a(this.f20322i, this);
    }

    public void a(ViewGroup viewGroup) {
        if (1 != ClientMetadata.getInstance().getOrientationInt().intValue()) {
            l();
            return;
        }
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            if (!a(viewGroup.getContext(), this.f20322i)) {
                c();
                return;
            }
            viewGroup.addView(this.f20321h, new FrameLayout.LayoutParams(-1, -1));
            this.f20317d.a(this.f20322i, (Bundle) null);
            int m10 = this.f20317d.f20311d.m();
            this.f20319f = m10;
            this.f20321h.setDuration(m10);
            if (this.f20321h.n()) {
                return;
            }
        }
        c();
    }
}
