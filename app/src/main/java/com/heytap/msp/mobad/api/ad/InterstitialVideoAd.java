package com.heytap.msp.mobad.api.ad;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.heytap.msp.mobad.api.listener.IInterstitialVideoAdListener;
import com.opos.mobad.ad.b.c;
import com.opos.mobad.ad.b.d;

/* loaded from: classes.dex */
public class InterstitialVideoAd implements IBidding {
    private static final String TAG = "InterstitialVideoAd";
    private Activity mActivity;
    private volatile c mInstance;
    private a mListener;
    private String mPosId;

    public static class a implements d {

        /* renamed from: a */
        private IInterstitialVideoAdListener f8979a;

        public a(IInterstitialVideoAdListener iInterstitialVideoAdListener) {
            this.f8979a = iInterstitialVideoAdListener;
        }

        @Override // com.opos.mobad.ad.b.a
        public void a() {
            IInterstitialVideoAdListener iInterstitialVideoAdListener = this.f8979a;
            if (iInterstitialVideoAdListener != null) {
                iInterstitialVideoAdListener.onAdReady();
            }
        }

        @Override // com.opos.mobad.ad.b.a
        public void a(int i2, String str) {
            IInterstitialVideoAdListener iInterstitialVideoAdListener = this.f8979a;
            if (iInterstitialVideoAdListener != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("code=");
                sb.append(i2);
                sb.append(",msg=");
                sb.append(str != null ? str : "");
                iInterstitialVideoAdListener.onAdFailed(sb.toString());
                this.f8979a.onAdFailed(i2, str);
            }
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(long j2) {
            IInterstitialVideoAdListener iInterstitialVideoAdListener = this.f8979a;
            if (iInterstitialVideoAdListener != null) {
                iInterstitialVideoAdListener.onAdClick();
            }
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
            IInterstitialVideoAdListener iInterstitialVideoAdListener = this.f8979a;
            if (iInterstitialVideoAdListener != null) {
                iInterstitialVideoAdListener.onAdShow();
            }
        }

        @Override // com.opos.mobad.ad.b.a
        public void b() {
            IInterstitialVideoAdListener iInterstitialVideoAdListener = this.f8979a;
            if (iInterstitialVideoAdListener != null) {
                iInterstitialVideoAdListener.onAdClose();
            }
        }

        @Override // com.opos.mobad.ad.b.d
        public void c() {
            IInterstitialVideoAdListener iInterstitialVideoAdListener = this.f8979a;
            if (iInterstitialVideoAdListener != null) {
                iInterstitialVideoAdListener.onVideoPlayComplete();
            }
        }
    }

    public InterstitialVideoAd(Activity activity, String str, IInterstitialVideoAdListener iInterstitialVideoAdListener) {
        if (activity == null || TextUtils.isEmpty(str)) {
            Log.e(TAG, "InterstitialAd Constructor param activity and posId can't be null.");
            return;
        }
        this.mActivity = activity;
        this.mPosId = str;
        this.mListener = new a(iInterstitialVideoAdListener);
        initImplIfNeed();
    }

    private boolean initImplIfNeed() {
        if (this.mInstance == null) {
            if (this.mActivity == null || TextUtils.isEmpty(this.mPosId)) {
                return false;
            }
            synchronized (this) {
                if (this.mInstance == null) {
                    this.mInstance = com.heytap.msp.mobad.api.a.a().a(this.mActivity, this.mPosId, this.mListener);
                    if (this.mInstance == null) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void destroyAd() {
        if (this.mInstance != null) {
            this.mInstance.b();
        }
        this.mActivity = null;
        this.mPosId = null;
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public int getECPM() {
        if (this.mInstance != null) {
            return this.mInstance.g();
        }
        return 0;
    }

    public void loadAd() {
        if (initImplIfNeed()) {
            this.mInstance.a();
            return;
        }
        a aVar = this.mListener;
        if (aVar != null) {
            aVar.a(-1, "inter ad create fail");
        }
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void notifyRankLoss(int i2, String str, int i3) {
        if (this.mInstance != null) {
            this.mInstance.a(i2, str, i3);
        }
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void notifyRankWin(int i2) {
        if (this.mInstance != null) {
            this.mInstance.b(i2);
        }
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void setBidECPM(int i2) {
        if (this.mInstance != null) {
            this.mInstance.c(i2);
        }
    }

    public void showAd() {
        if (initImplIfNeed()) {
            this.mInstance.a(this.mActivity);
            return;
        }
        a aVar = this.mListener;
        if (aVar != null) {
            aVar.a(-1, "inter ad create fail");
        }
    }
}
