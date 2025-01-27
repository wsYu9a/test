package com.bytedance.sdk.openadsdk;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.api.j;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AdSlot implements TTAdSlot {
    private TTAdLoadType bw;

    /* renamed from: e */
    private int[] f6342e;
    private boolean ei;

    /* renamed from: f */
    private String f6343f;

    /* renamed from: g */
    private float f6344g;
    private int gm;
    private int gv;
    private String hm;

    /* renamed from: i */
    private int f6345i;

    /* renamed from: j */
    private String f6346j;
    private int k;
    private boolean lg;
    private String mx;
    private String nt;
    private int p;
    private String pa;
    private float q;
    private int r;
    private int s;
    private String t;
    private String tf;
    private String u;
    private String v;
    private int w;
    private boolean y;
    private String z;
    private int zx;

    public static class Builder {

        /* renamed from: e */
        private String f6347e;
        private int ei;

        /* renamed from: f */
        private String f6348f;
        private String gm;
        private int hm;

        /* renamed from: j */
        private String f6351j;
        private String lg;
        private String mx;
        private int nt;
        private float p;
        private int pa;
        private float r;
        private int[] s;
        private String t;
        private String tf;
        private String u;
        private String v;
        private int zx = 640;

        /* renamed from: i */
        private int f6350i = 320;

        /* renamed from: g */
        private boolean f6349g = true;
        private boolean q = false;
        private int gv = 1;
        private String y = "defaultUser";
        private int k = 2;
        private boolean w = true;
        private TTAdLoadType z = TTAdLoadType.UNKNOWN;

        public AdSlot build() {
            AdSlot adSlot = new AdSlot();
            adSlot.f6346j = this.f6351j;
            adSlot.gv = this.gv;
            adSlot.lg = this.f6349g;
            adSlot.y = this.q;
            adSlot.zx = this.zx;
            adSlot.f6345i = this.f6350i;
            float f2 = this.p;
            if (f2 <= 0.0f) {
                adSlot.f6344g = this.zx;
                adSlot.q = this.f6350i;
            } else {
                adSlot.f6344g = f2;
                adSlot.q = this.r;
            }
            adSlot.t = this.lg;
            adSlot.nt = this.y;
            adSlot.p = this.k;
            adSlot.w = this.pa;
            adSlot.ei = this.w;
            adSlot.f6342e = this.s;
            adSlot.gm = this.ei;
            adSlot.hm = this.f6347e;
            adSlot.v = this.t;
            adSlot.z = this.mx;
            adSlot.mx = this.tf;
            adSlot.tf = this.u;
            adSlot.r = this.nt;
            adSlot.f6343f = this.v;
            adSlot.u = this.gm;
            adSlot.bw = this.z;
            adSlot.k = this.hm;
            adSlot.pa = this.f6348f;
            return adSlot;
        }

        public Builder setAdCount(int i2) {
            if (i2 <= 0) {
                i2 = 1;
                j.i(TTAdConstant.TAG, "setAdCount: adCount must greater than 0 ");
            }
            if (i2 > 20) {
                j.i(TTAdConstant.TAG, "setAdCount: adCount must less than or equal to 20 ");
                i2 = 20;
            }
            this.gv = i2;
            return this;
        }

        public Builder setAdId(String str) {
            this.mx = str;
            return this;
        }

        public Builder setAdLoadType(TTAdLoadType tTAdLoadType) {
            this.z = tTAdLoadType;
            return this;
        }

        public Builder setAdType(int i2) {
            this.nt = i2;
            return this;
        }

        public Builder setAdloadSeq(int i2) {
            this.ei = i2;
            return this;
        }

        public Builder setCodeId(String str) {
            this.f6351j = str;
            return this;
        }

        public Builder setCreativeId(String str) {
            this.tf = str;
            return this;
        }

        public Builder setExpressViewAcceptedSize(float f2, float f3) {
            this.p = f2;
            this.r = f3;
            return this;
        }

        public Builder setExt(String str) {
            this.u = str;
            return this;
        }

        public Builder setExternalABVid(int... iArr) {
            this.s = iArr;
            return this;
        }

        public Builder setExtraParam(String str) {
            this.t = str;
            return this;
        }

        public Builder setImageAcceptedSize(int i2, int i3) {
            this.zx = i2;
            this.f6350i = i3;
            return this;
        }

        public Builder setIsAutoPlay(boolean z) {
            this.w = z;
            return this;
        }

        public Builder setMediaExtra(String str) {
            this.lg = str;
            return this;
        }

        public Builder setNativeAdType(int i2) {
            this.pa = i2;
            return this;
        }

        public Builder setOrientation(int i2) {
            this.k = i2;
            return this;
        }

        public Builder setPrimeRit(String str) {
            this.f6347e = str;
            return this;
        }

        public Builder setRewardAmount(int i2) {
            this.hm = i2;
            return this;
        }

        public Builder setRewardName(String str) {
            this.f6348f = str;
            return this;
        }

        public Builder setSupportDeepLink(boolean z) {
            this.f6349g = z;
            return this;
        }

        public Builder setUserData(String str) {
            this.gm = str;
            return this;
        }

        public Builder setUserID(String str) {
            this.y = str;
            return this;
        }

        public Builder supportRenderControl() {
            this.q = true;
            return this;
        }

        public Builder withBid(String str) {
            if (str == null) {
                return this;
            }
            this.v = str;
            return this;
        }
    }

    /* synthetic */ AdSlot(AnonymousClass1 anonymousClass1) {
        this();
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getAdCount() {
        return this.gv;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getAdId() {
        return this.z;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public TTAdLoadType getAdLoadType() {
        return this.bw;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getAdType() {
        return this.r;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getAdloadSeq() {
        return this.gm;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getBidAdm() {
        return this.f6343f;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getCodeId() {
        return this.f6346j;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getCreativeId() {
        return this.mx;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getDurationSlotType() {
        return this.s;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public float getExpressViewAcceptedHeight() {
        return this.q;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public float getExpressViewAcceptedWidth() {
        return this.f6344g;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getExt() {
        return this.tf;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int[] getExternalABVid() {
        return this.f6342e;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getExtraSmartLookParam() {
        return this.v;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getImgAcceptedHeight() {
        return this.f6345i;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getImgAcceptedWidth() {
        return this.zx;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getMediaExtra() {
        return this.t;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getNativeAdType() {
        return this.w;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getOrientation() {
        return this.p;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getPrimeRit() {
        String str = this.hm;
        return str == null ? "" : str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getRewardAmount() {
        return this.k;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getRewardName() {
        return this.pa;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getUserData() {
        return this.u;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getUserID() {
        return this.nt;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public boolean isAutoPlay() {
        return this.ei;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public boolean isSupportDeepLink() {
        return this.lg;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public boolean isSupportRenderConrol() {
        return this.y;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public void setAdCount(int i2) {
        this.gv = i2;
    }

    public void setAdLoadType(TTAdLoadType tTAdLoadType) {
        this.bw = tTAdLoadType;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public void setDurationSlotType(int i2) {
        this.s = i2;
    }

    public void setExternalABVid(int... iArr) {
        this.f6342e = iArr;
    }

    public void setGroupLoadMore(int i2) {
        this.t = j(this.t, i2);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public void setNativeAdType(int i2) {
        this.w = i2;
    }

    public void setUserData(String str) {
        this.u = str;
    }

    public JSONObject toJsonObj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mCodeId", this.f6346j);
            jSONObject.put("mIsAutoPlay", this.ei);
            jSONObject.put("mImgAcceptedWidth", this.zx);
            jSONObject.put("mImgAcceptedHeight", this.f6345i);
            jSONObject.put("mExpressViewAcceptedWidth", this.f6344g);
            jSONObject.put("mExpressViewAcceptedHeight", this.q);
            jSONObject.put("mAdCount", this.gv);
            jSONObject.put("mSupportDeepLink", this.lg);
            jSONObject.put("mSupportRenderControl", this.y);
            jSONObject.put("mMediaExtra", this.t);
            jSONObject.put("mUserID", this.nt);
            jSONObject.put("mOrientation", this.p);
            jSONObject.put("mNativeAdType", this.w);
            jSONObject.put("mAdloadSeq", this.gm);
            jSONObject.put("mPrimeRit", this.hm);
            jSONObject.put("mExtraSmartLookParam", this.v);
            jSONObject.put("mAdId", this.z);
            jSONObject.put("mCreativeId", this.mx);
            jSONObject.put("mExt", this.tf);
            jSONObject.put("mBidAdm", this.f6343f);
            jSONObject.put("mUserData", this.u);
            jSONObject.put("mAdLoadType", this.bw);
            jSONObject.put("mRewardName", this.pa);
            jSONObject.put("mRewardAmount", this.k);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public String toString() {
        return "AdSlot{mCodeId='" + this.f6346j + "', mImgAcceptedWidth=" + this.zx + ", mImgAcceptedHeight=" + this.f6345i + ", mExpressViewAcceptedWidth=" + this.f6344g + ", mExpressViewAcceptedHeight=" + this.q + ", mAdCount=" + this.gv + ", mSupportDeepLink=" + this.lg + ", mSupportRenderControl=" + this.y + ", mMediaExtra='" + this.t + "', mUserID='" + this.nt + "', mOrientation=" + this.p + ", mNativeAdType=" + this.w + ", mIsAutoPlay=" + this.ei + ", mPrimeRit" + this.hm + ", mAdloadSeq" + this.gm + ", mAdId" + this.z + ", mCreativeId" + this.mx + ", mExt" + this.tf + ", mUserData" + this.u + ", mAdLoadType" + this.bw + ", mRewardName" + this.pa + ", mRewardAmount" + this.k + '}';
    }

    private AdSlot() {
        this.p = 2;
        this.ei = true;
    }

    private String j(String str, int i2) {
        JSONObject jSONObject;
        if (i2 < 1) {
            return str;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(str);
            }
            jSONObject.put("_tt_group_load_more", i2);
            return jSONObject.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return str;
        }
    }
}
