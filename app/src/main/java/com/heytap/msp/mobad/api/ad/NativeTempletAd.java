package com.heytap.msp.mobad.api.ad;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.heytap.msp.mobad.api.listener.INativeTempletAdListener;
import com.heytap.msp.mobad.api.params.INativeTempletAdView;
import com.heytap.msp.mobad.api.params.NativeAdError;
import com.heytap.msp.mobad.api.params.NativeAdParams;
import com.heytap.msp.mobad.api.params.NativeAdSize;
import com.opos.mobad.ad.c.n;
import com.opos.mobad.ad.c.o;
import com.opos.mobad.ad.c.p;
import com.opos.mobad.ad.c.q;
import com.opos.mobad.ad.c.s;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class NativeTempletAd {
    private static final String TAG = "NativeTempletAd";
    private Context mContext;
    private a mListener;
    private NativeAdSize mNativeAdSize;
    private volatile n mNativeTempletAdImpl;
    private String mPosId;

    private static class a implements o {

        /* renamed from: b */
        private final INativeTempletAdListener f8998b;

        /* renamed from: com.heytap.msp.mobad.api.ad.NativeTempletAd$a$a */
        private static class C0114a implements INativeTempletAdView {

            /* renamed from: a */
            private final p f8999a;

            public C0114a(p pVar) {
                this.f8999a = pVar;
            }

            @Override // com.heytap.msp.mobad.api.params.INativeTempletAdView
            public void destroy() {
                this.f8999a.c();
            }

            @Override // com.heytap.msp.mobad.api.params.INativeTempletAdView
            public View getAdView() {
                return this.f8999a.a();
            }

            @Override // com.heytap.msp.mobad.api.ad.IBidding
            public int getECPM() {
                return this.f8999a.g();
            }

            @Override // com.heytap.msp.mobad.api.ad.IBidding
            public void notifyRankLoss(int i2, String str, int i3) {
                this.f8999a.a(i2, str, i3);
            }

            @Override // com.heytap.msp.mobad.api.ad.IBidding
            public void notifyRankWin(int i2) {
                this.f8999a.b(i2);
            }

            @Override // com.heytap.msp.mobad.api.params.INativeTempletAdView
            public void render() {
                this.f8999a.b();
            }

            @Override // com.heytap.msp.mobad.api.ad.IBidding
            public void setBidECPM(int i2) {
                this.f8999a.c(i2);
            }
        }

        public a(INativeTempletAdListener iNativeTempletAdListener) {
            this.f8998b = iNativeTempletAdListener;
        }

        @Override // com.opos.mobad.ad.c.a
        public void a(int i2, String str) {
            INativeTempletAdListener iNativeTempletAdListener = this.f8998b;
            if (iNativeTempletAdListener == null) {
                return;
            }
            iNativeTempletAdListener.onAdFailed(new NativeAdError(i2, str));
        }

        @Override // com.opos.mobad.ad.c.o
        public void a(p pVar) {
            if (this.f8998b == null) {
                return;
            }
            this.f8998b.onAdClick(pVar != null ? (INativeTempletAdView) pVar.d() : null);
        }

        @Override // com.opos.mobad.ad.c.o
        public void a(q qVar, p pVar) {
            if (this.f8998b == null) {
                return;
            }
            this.f8998b.onRenderFailed(qVar != null ? new NativeAdError(qVar.f19478a, qVar.f19479b) : null, pVar != null ? (INativeTempletAdView) pVar.d() : null);
        }

        @Override // com.opos.mobad.ad.c.a
        public void a(List<p> list) {
            if (this.f8998b == null) {
                return;
            }
            ArrayList arrayList = null;
            if (list != null) {
                arrayList = new ArrayList();
                for (p pVar : list) {
                    if (pVar != null) {
                        C0114a c0114a = new C0114a(pVar);
                        pVar.a(c0114a);
                        arrayList.add(c0114a);
                    }
                }
            }
            this.f8998b.onAdSuccess(arrayList);
        }

        @Override // com.opos.mobad.ad.c.o
        public void b(p pVar) {
            if (this.f8998b == null) {
                return;
            }
            this.f8998b.onAdShow(pVar != null ? (INativeTempletAdView) pVar.d() : null);
        }

        @Override // com.opos.mobad.ad.c.o
        public void c(p pVar) {
            if (this.f8998b == null) {
                return;
            }
            this.f8998b.onAdClose(pVar != null ? (INativeTempletAdView) pVar.d() : null);
        }

        @Override // com.opos.mobad.ad.c.o
        public void d(p pVar) {
            if (this.f8998b == null) {
                return;
            }
            this.f8998b.onRenderSuccess(pVar != null ? (INativeTempletAdView) pVar.d() : null);
        }
    }

    public NativeTempletAd(Context context, String str, NativeAdSize nativeAdSize, INativeTempletAdListener iNativeTempletAdListener) {
        if (context == null || TextUtils.isEmpty(str) || iNativeTempletAdListener == null) {
            Log.e(TAG, "NativeTempletAd Constructor param context and posId and iNativeTempletAdListener can't be null.");
            return;
        }
        this.mContext = context;
        this.mPosId = str;
        this.mNativeAdSize = nativeAdSize;
        this.mListener = new a(iNativeTempletAdListener);
        initImplIfNeed();
    }

    private boolean initImplIfNeed() {
        int i2;
        int i3;
        if (this.mNativeTempletAdImpl == null) {
            if (this.mContext == null || TextUtils.isEmpty(this.mPosId)) {
                return false;
            }
            synchronized (this) {
                if (this.mNativeTempletAdImpl == null) {
                    NativeAdSize nativeAdSize = this.mNativeAdSize;
                    if (nativeAdSize != null) {
                        i3 = nativeAdSize.widthInDp;
                        i2 = nativeAdSize.heightInDp;
                    } else {
                        i2 = 0;
                        i3 = 0;
                    }
                    this.mNativeTempletAdImpl = com.heytap.msp.mobad.api.a.a().a(this.mContext.getApplicationContext(), this.mPosId, new s.a().a(i3).b(i2).a(), this.mListener);
                    if (this.mNativeTempletAdImpl == null) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void destroyAd() {
        if (this.mNativeTempletAdImpl != null) {
            this.mNativeTempletAdImpl.b();
        }
        this.mContext = null;
        this.mPosId = null;
    }

    public void loadAd() {
        loadAd(null);
    }

    public void loadAd(NativeAdParams nativeAdParams) {
        if (initImplIfNeed()) {
            if (nativeAdParams != null) {
                this.mNativeTempletAdImpl.a((int) nativeAdParams.fetchTimeout);
                return;
            } else {
                this.mNativeTempletAdImpl.a();
                return;
            }
        }
        a aVar = this.mListener;
        if (aVar != null) {
            aVar.a(-1, "inter ad create fail");
        }
    }
}
