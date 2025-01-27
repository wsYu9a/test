package com.heytap.msp.mobad.api.ad;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.heytap.msp.mobad.api.listener.ISplashAdListener;
import com.heytap.msp.mobad.api.params.SplashAdParams;
import com.opos.mobad.ad.e.b;
import com.opos.mobad.ad.e.c;
import com.opos.mobad.ad.e.f;

/* loaded from: classes.dex */
public class LandSplashAd {
    private static final String TAG = "SplashAd";
    private Activity mActivity;
    private volatile b mLandSplashAdImpl;
    private a mListener;
    private String mPosId;
    private SplashAdParams mSplashAdParams;

    private static class a implements c {

        /* renamed from: a */
        private ISplashAdListener f8980a;

        public a(ISplashAdListener iSplashAdListener) {
            this.f8980a = iSplashAdListener;
        }

        @Override // com.opos.mobad.ad.b.a
        public void a() {
        }

        @Override // com.opos.mobad.ad.b.a
        public void a(int i2, String str) {
            ISplashAdListener iSplashAdListener = this.f8980a;
            StringBuilder sb = new StringBuilder();
            sb.append("code=");
            sb.append(i2);
            sb.append(",msg=");
            sb.append(str != null ? str : "");
            iSplashAdListener.onAdFailed(sb.toString());
            this.f8980a.onAdFailed(i2, str);
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(long j2) {
            this.f8980a.onAdClick();
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
            this.f8980a.onAdShow(str);
            this.f8980a.onAdShow();
        }

        @Override // com.opos.mobad.ad.b.a
        public void b() {
            this.f8980a.onAdDismissed();
        }
    }

    public LandSplashAd(Activity activity, String str, ISplashAdListener iSplashAdListener, SplashAdParams splashAdParams) throws NullPointerException {
        if (activity == null || TextUtils.isEmpty(str) || iSplashAdListener == null || splashAdParams == null) {
            Log.e(TAG, "SplashAd Constructor param activity or posId or iSplashAdListener or splashAdParams is null.");
            return;
        }
        this.mActivity = activity;
        this.mPosId = str;
        this.mSplashAdParams = splashAdParams;
        this.mListener = new a(iSplashAdListener);
        if (initImplIfNeed()) {
            this.mLandSplashAdImpl.a((int) this.mSplashAdParams.fetchTimeout);
        } else {
            this.mListener.a(-1, "inter ad create fail");
        }
    }

    private boolean initImplIfNeed() {
        if (this.mLandSplashAdImpl == null) {
            if (this.mActivity == null || TextUtils.isEmpty(this.mPosId)) {
                return false;
            }
            synchronized (this) {
                if (this.mLandSplashAdImpl == null) {
                    this.mLandSplashAdImpl = com.heytap.msp.mobad.api.a.a().a(this.mActivity, this.mPosId, (c) this.mListener, new f.a(this.mActivity).b(this.mSplashAdParams.desc).a(this.mSplashAdParams.fetchTimeout).a(this.mSplashAdParams.showPreLoadPage).b(this.mSplashAdParams.isUseSurfaceView).a(this.mSplashAdParams.title).c(false).a());
                    if (this.mLandSplashAdImpl == null) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void destroyAd() {
        if (this.mLandSplashAdImpl != null) {
            this.mLandSplashAdImpl.b();
        }
        this.mActivity = null;
        this.mPosId = null;
        this.mSplashAdParams = null;
    }
}
