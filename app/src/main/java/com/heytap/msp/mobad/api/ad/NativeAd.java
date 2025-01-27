package com.heytap.msp.mobad.api.ad;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.heytap.msp.mobad.api.listener.INativeAdListener;
import com.heytap.msp.mobad.api.listener.INativeRewardAdListener;
import com.heytap.msp.mobad.api.params.INativeAdData;
import com.heytap.msp.mobad.api.params.INativeAdFile;
import com.heytap.msp.mobad.api.params.INativeComplianceInfo;
import com.heytap.msp.mobad.api.params.NativeAdError;
import com.heytap.msp.mobad.api.params.NativeAdParams;
import com.opos.mobad.ad.c.e;
import com.opos.mobad.ad.c.f;
import com.opos.mobad.ad.c.m;
import com.opos.mobad.ad.c.q;
import com.opos.mobad.ad.c.r;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class NativeAd {
    public static final int REWARD_SCENE_INSTALL_COMPLETE = 1;
    public static final int REWARD_SCENE_LAUNCH_APP = 2;
    public static final int REWARD_SCENE_NO = 0;
    public static final String TAG = "NativeAd";
    private Context mContext;
    private c mListener;
    private volatile com.opos.mobad.ad.c.c mNativeAdImpl;
    private String mPosId;
    private d mRewardListener;
    private int mRewardScene;

    private static class a implements INativeAdData {

        /* renamed from: a */
        private final com.opos.mobad.ad.c.d f8981a;

        /* renamed from: b */
        private final INativeComplianceInfo f8982b;

        /* renamed from: com.heytap.msp.mobad.api.ad.NativeAd$a$1 */
        class AnonymousClass1 implements INativeComplianceInfo {
            AnonymousClass1() {
            }

            @Override // com.heytap.msp.mobad.api.params.INativeComplianceInfo
            public String getAppVersion() {
                return a.this.f8981a.l().a();
            }

            @Override // com.heytap.msp.mobad.api.params.INativeComplianceInfo
            public String getDeveloperName() {
                return a.this.f8981a.l().b();
            }

            @Override // com.heytap.msp.mobad.api.params.INativeComplianceInfo
            public String getPermissionUrl() {
                return a.this.f8981a.l().d();
            }

            @Override // com.heytap.msp.mobad.api.params.INativeComplianceInfo
            public String getPrivacyUrl() {
                return a.this.f8981a.l().c();
            }
        }

        public a(com.opos.mobad.ad.c.d dVar) {
            this.f8981a = dVar;
            this.f8982b = dVar.l() != null ? new INativeComplianceInfo() { // from class: com.heytap.msp.mobad.api.ad.NativeAd.a.1
                AnonymousClass1() {
                }

                @Override // com.heytap.msp.mobad.api.params.INativeComplianceInfo
                public String getAppVersion() {
                    return a.this.f8981a.l().a();
                }

                @Override // com.heytap.msp.mobad.api.params.INativeComplianceInfo
                public String getDeveloperName() {
                    return a.this.f8981a.l().b();
                }

                @Override // com.heytap.msp.mobad.api.params.INativeComplianceInfo
                public String getPermissionUrl() {
                    return a.this.f8981a.l().d();
                }

                @Override // com.heytap.msp.mobad.api.params.INativeComplianceInfo
                public String getPrivacyUrl() {
                    return a.this.f8981a.l().c();
                }
            } : null;
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public String getClickBnText() {
            return this.f8981a.j();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public INativeComplianceInfo getComplianceInfo() {
            return this.f8982b;
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public int getCreativeType() {
            return this.f8981a.e();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public String getDesc() {
            return this.f8981a.b();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public String getExtra() {
            return this.f8981a.i();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public List<INativeAdFile> getIconFiles() {
            List<e> c2 = this.f8981a.c();
            if (c2 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (e eVar : c2) {
                if (eVar != null) {
                    arrayList.add(new b(eVar));
                }
            }
            return arrayList;
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public List<INativeAdFile> getImgFiles() {
            List<e> d2 = this.f8981a.d();
            if (d2 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (e eVar : d2) {
                if (eVar != null) {
                    arrayList.add(new b(eVar));
                }
            }
            return arrayList;
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public int getInteractionType() {
            return this.f8981a.f();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public INativeAdFile getLogoFile() {
            e g2 = this.f8981a.g();
            if (g2 != null) {
                return new b(g2);
            }
            return null;
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public String getTitle() {
            return this.f8981a.a();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public boolean isAdValid() {
            return this.f8981a.h();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public boolean isCurrentApp(String str) {
            return this.f8981a.a(str);
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public boolean launchApp() {
            return this.f8981a.k();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public void onAdClick(View view) {
            this.f8981a.b(view);
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public void onAdShow(View view) {
            this.f8981a.a(view);
        }
    }

    private static class b implements INativeAdFile {

        /* renamed from: a */
        private final e f8984a;

        public b(e eVar) {
            this.f8984a = eVar;
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdFile
        public String getMd5() {
            return this.f8984a.b();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdFile
        public String getUrl() {
            return this.f8984a.a();
        }
    }

    private static class c implements f {

        /* renamed from: a */
        private final INativeAdListener f8985a;

        public c(INativeAdListener iNativeAdListener) {
            this.f8985a = iNativeAdListener;
        }

        @Override // com.opos.mobad.ad.c.f
        public void a(q qVar) {
            if (this.f8985a == null) {
                return;
            }
            this.f8985a.onAdFailed(qVar != null ? new NativeAdError(qVar.f19478a, qVar.f19479b) : null);
        }

        @Override // com.opos.mobad.ad.c.f
        public void a(q qVar, com.opos.mobad.ad.c.d dVar) {
            if (this.f8985a == null) {
                return;
            }
            a aVar = dVar != null ? new a(dVar) : null;
            INativeAdListener iNativeAdListener = this.f8985a;
            if (iNativeAdListener != null) {
                iNativeAdListener.onAdError(new NativeAdError(qVar.f19478a, qVar.f19479b), aVar);
            }
        }

        @Override // com.opos.mobad.ad.c.f
        public void a(List<com.opos.mobad.ad.c.d> list) {
            if (this.f8985a == null) {
                return;
            }
            ArrayList arrayList = null;
            if (list != null) {
                arrayList = new ArrayList();
                for (com.opos.mobad.ad.c.d dVar : list) {
                    if (dVar != null) {
                        arrayList.add(new a(dVar));
                    }
                }
            }
            this.f8985a.onAdSuccess(arrayList);
        }
    }

    private static class d implements m {

        /* renamed from: a */
        public INativeRewardAdListener f8986a;

        public d(INativeRewardAdListener iNativeRewardAdListener) {
            this.f8986a = iNativeRewardAdListener;
        }

        @Override // com.opos.mobad.ad.c.f
        public void a(q qVar) {
            if (this.f8986a == null) {
                return;
            }
            this.f8986a.onAdFailed(qVar != null ? new NativeAdError(qVar.f19478a, qVar.f19479b) : null);
        }

        @Override // com.opos.mobad.ad.c.f
        public void a(q qVar, com.opos.mobad.ad.c.d dVar) {
            if (this.f8986a == null) {
                return;
            }
            a aVar = dVar != null ? new a(dVar) : null;
            INativeRewardAdListener iNativeRewardAdListener = this.f8986a;
            if (iNativeRewardAdListener != null) {
                iNativeRewardAdListener.onAdError(new NativeAdError(qVar.f19478a, qVar.f19479b), aVar);
            }
        }

        @Override // com.opos.mobad.ad.f
        public void a(String str) {
            INativeRewardAdListener iNativeRewardAdListener = this.f8986a;
            if (iNativeRewardAdListener != null) {
                iNativeRewardAdListener.onInstallCompleted(str);
            }
        }

        @Override // com.opos.mobad.ad.c.f
        public void a(List<com.opos.mobad.ad.c.d> list) {
            if (this.f8986a == null) {
                return;
            }
            ArrayList arrayList = null;
            if (list != null) {
                arrayList = new ArrayList();
                for (com.opos.mobad.ad.c.d dVar : list) {
                    if (dVar != null) {
                        arrayList.add(new a(dVar));
                    }
                }
            }
            this.f8986a.onAdSuccess(arrayList);
        }

        @Override // com.opos.mobad.ad.h
        public void a(Object... objArr) {
            INativeRewardAdListener iNativeRewardAdListener = this.f8986a;
            if (iNativeRewardAdListener != null) {
                iNativeRewardAdListener.onReward(objArr);
            }
        }

        @Override // com.opos.mobad.ad.c.m
        public void b(Object... objArr) {
            INativeRewardAdListener iNativeRewardAdListener = this.f8986a;
            if (iNativeRewardAdListener != null) {
                iNativeRewardAdListener.onRewardFail(objArr);
            }
        }
    }

    public NativeAd(Context context, String str, int i2, INativeRewardAdListener iNativeRewardAdListener) {
        if (context == null || TextUtils.isEmpty(str) || iNativeRewardAdListener == null) {
            Log.e(TAG, "NativeAd Constructor param context and posId and iNativeRewardAdListener can't be null.");
            return;
        }
        this.mContext = context;
        this.mPosId = str;
        this.mRewardListener = new d(iNativeRewardAdListener);
        this.mRewardScene = i2;
        initImplIfNeed();
    }

    public NativeAd(Context context, String str, INativeAdListener iNativeAdListener) {
        if (context == null || TextUtils.isEmpty(str) || iNativeAdListener == null) {
            Log.e(TAG, "NativeAd Constructor param context and posId and iNativeAdListener can't be null.");
            return;
        }
        this.mContext = context;
        this.mPosId = str;
        this.mListener = new c(iNativeAdListener);
        initImplIfNeed();
    }

    private boolean initImplIfNeed() {
        if (this.mNativeAdImpl == null) {
            if (this.mContext == null || TextUtils.isEmpty(this.mPosId)) {
                return false;
            }
            synchronized (this) {
                if (this.mNativeAdImpl == null) {
                    this.mNativeAdImpl = this.mRewardScene > 0 ? com.heytap.msp.mobad.api.a.a().a(this.mContext.getApplicationContext(), this.mPosId, this.mRewardScene, this.mRewardListener) : com.heytap.msp.mobad.api.a.a().a(this.mContext.getApplicationContext(), this.mPosId, this.mListener);
                    if (this.mNativeAdImpl == null) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void destroyAd() {
        if (this.mNativeAdImpl != null) {
            this.mNativeAdImpl.a();
        }
        this.mContext = null;
        this.mPosId = null;
    }

    public void loadAd() {
        loadAd(null);
    }

    public void loadAd(NativeAdParams nativeAdParams) {
        if (initImplIfNeed()) {
            r rVar = null;
            if (nativeAdParams != null) {
                r.a aVar = new r.a();
                aVar.a(nativeAdParams.fetchTimeout);
                rVar = aVar.a();
            }
            this.mNativeAdImpl.a(rVar);
            return;
        }
        c cVar = this.mListener;
        if (cVar != null) {
            cVar.a(new q(-1, "inter ad create fail"));
            return;
        }
        d dVar = this.mRewardListener;
        if (dVar != null) {
            dVar.a(new q(-1, "inter ad create fail"));
        }
    }
}
