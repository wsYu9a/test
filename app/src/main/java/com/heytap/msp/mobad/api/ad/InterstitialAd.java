package com.heytap.msp.mobad.api.ad;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.heytap.msp.mobad.api.listener.IInterstitialAdListener;
import com.opos.mobad.ad.b.b;

/* loaded from: classes.dex */
public class InterstitialAd implements IBidding {
    private static final String TAG = "InterstitialAd";
    private Activity mActivity;
    private volatile com.opos.mobad.ad.b.a mInterstitialAdImpl;
    private a mListenerWrapper = new a(null);
    private String mPosId;

    private static final class a implements b {

        /* renamed from: b */
        private IInterstitialAdListener f8978b;

        public a(IInterstitialAdListener iInterstitialAdListener) {
            this.f8978b = iInterstitialAdListener;
        }

        @Override // com.opos.mobad.ad.b.a
        public void a() {
            IInterstitialAdListener iInterstitialAdListener = this.f8978b;
            if (iInterstitialAdListener != null) {
                iInterstitialAdListener.onAdReady();
            }
        }

        @Override // com.opos.mobad.ad.b.a
        public void a(int i2, String str) {
            IInterstitialAdListener iInterstitialAdListener = this.f8978b;
            if (iInterstitialAdListener != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("code=");
                sb.append(i2);
                sb.append(",msg=");
                sb.append(str != null ? str : "");
                iInterstitialAdListener.onAdFailed(sb.toString());
            }
            IInterstitialAdListener iInterstitialAdListener2 = this.f8978b;
            if (iInterstitialAdListener2 != null) {
                iInterstitialAdListener2.onAdFailed(i2, str);
            }
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(long j2) {
            IInterstitialAdListener iInterstitialAdListener = this.f8978b;
            if (iInterstitialAdListener != null) {
                iInterstitialAdListener.onAdClick();
            }
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
            IInterstitialAdListener iInterstitialAdListener = this.f8978b;
            if (iInterstitialAdListener != null) {
                iInterstitialAdListener.onAdShow();
            }
        }

        @Override // com.opos.mobad.ad.b.a
        public void b() {
            IInterstitialAdListener iInterstitialAdListener = this.f8978b;
            if (iInterstitialAdListener != null) {
                iInterstitialAdListener.onAdClose();
            }
        }
    }

    public InterstitialAd(Activity activity, String str) {
        if (activity == null || TextUtils.isEmpty(str)) {
            Log.e("InterstitialAd", "InterstitialAd Constructor param activity and posId can't be null.");
            return;
        }
        this.mActivity = activity;
        this.mPosId = str;
        initImplIfNeed();
    }

    private boolean initImplIfNeed() {
        if (this.mInterstitialAdImpl == null) {
            if (this.mActivity == null || TextUtils.isEmpty(this.mPosId)) {
                return false;
            }
            synchronized (this) {
                if (this.mInterstitialAdImpl == null) {
                    this.mInterstitialAdImpl = com.heytap.msp.mobad.api.a.a().a(this.mActivity, this.mPosId, this.mListenerWrapper);
                    if (this.mInterstitialAdImpl == null) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void closePopupWindow() {
    }

    public void destroyAd() {
        if (this.mInterstitialAdImpl != null) {
            this.mInterstitialAdImpl.b();
        }
        this.mActivity = null;
        this.mPosId = null;
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public int getECPM() {
        if (this.mInterstitialAdImpl != null) {
            return this.mInterstitialAdImpl.g();
        }
        return 0;
    }

    public void loadAd() {
        if (initImplIfNeed()) {
            this.mInterstitialAdImpl.a();
        } else {
            this.mListenerWrapper.a(-1, "inter ad create fail");
        }
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void notifyRankLoss(int i2, String str, int i3) {
        if (this.mInterstitialAdImpl != null) {
            this.mInterstitialAdImpl.a(i2, str, i3);
        }
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void notifyRankWin(int i2) {
        if (this.mInterstitialAdImpl != null) {
            this.mInterstitialAdImpl.b(i2);
        }
    }

    public void setAdListener(IInterstitialAdListener iInterstitialAdListener) {
        if (iInterstitialAdListener == null) {
            this.mListenerWrapper.f8978b = null;
        } else {
            this.mListenerWrapper.f8978b = iInterstitialAdListener;
        }
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void setBidECPM(int i2) {
        if (this.mInterstitialAdImpl != null) {
            this.mInterstitialAdImpl.c(i2);
        }
    }

    public void showAd() {
        if (initImplIfNeed()) {
            this.mInterstitialAdImpl.a(this.mActivity);
        } else {
            this.mListenerWrapper.a(-1, "inter ad create fail");
        }
    }

    public void showAsPopupWindow() {
    }
}
