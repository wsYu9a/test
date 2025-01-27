package com.bytedance.sdk.openadsdk;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class AdSlot implements SlotType {

    /* renamed from: a */
    private String f7868a;

    /* renamed from: b */
    private int f7869b;

    /* renamed from: c */
    private int f7870c;

    /* renamed from: d */
    private float f7871d;

    /* renamed from: e */
    private float f7872e;

    /* renamed from: f */
    private int f7873f;

    /* renamed from: g */
    private boolean f7874g;

    /* renamed from: h */
    private boolean f7875h;

    /* renamed from: i */
    private boolean f7876i;

    /* renamed from: j */
    private String f7877j;

    /* renamed from: k */
    private String f7878k;

    /* renamed from: l */
    private int f7879l;

    /* renamed from: m */
    private int f7880m;

    /* renamed from: n */
    private int f7881n;

    /* renamed from: o */
    private boolean f7882o;

    /* renamed from: p */
    private int[] f7883p;

    /* renamed from: q */
    private int f7884q;

    /* renamed from: r */
    private String f7885r;

    /* renamed from: s */
    private String f7886s;

    /* renamed from: t */
    private String f7887t;

    /* renamed from: u */
    private String f7888u;

    /* renamed from: v */
    private String f7889v;

    /* renamed from: w */
    private String f7890w;

    /* renamed from: x */
    private TTAdLoadType f7891x;

    /* renamed from: y */
    private int f7892y;

    /* renamed from: z */
    private String f7893z;

    public static class Builder {

        /* renamed from: a */
        private String f7894a;

        /* renamed from: h */
        private String f7901h;

        /* renamed from: k */
        private int f7904k;

        /* renamed from: l */
        private int f7905l;

        /* renamed from: m */
        private float f7906m;

        /* renamed from: n */
        private float f7907n;

        /* renamed from: p */
        private int[] f7909p;

        /* renamed from: q */
        private int f7910q;

        /* renamed from: r */
        private String f7911r;

        /* renamed from: s */
        private String f7912s;

        /* renamed from: t */
        private String f7913t;

        /* renamed from: v */
        private String f7915v;

        /* renamed from: w */
        private String f7916w;

        /* renamed from: x */
        private String f7917x;

        /* renamed from: y */
        private int f7918y;

        /* renamed from: z */
        private String f7919z;

        /* renamed from: b */
        private int f7895b = 640;

        /* renamed from: c */
        private int f7896c = 320;

        /* renamed from: d */
        private boolean f7897d = true;

        /* renamed from: e */
        private boolean f7898e = false;

        /* renamed from: f */
        private boolean f7899f = false;

        /* renamed from: g */
        private int f7900g = 1;

        /* renamed from: i */
        private String f7902i = "defaultUser";

        /* renamed from: j */
        private int f7903j = 2;

        /* renamed from: o */
        private boolean f7908o = true;

        /* renamed from: u */
        private TTAdLoadType f7914u = TTAdLoadType.UNKNOWN;

        public AdSlot build() {
            AdSlot adSlot = new AdSlot();
            adSlot.f7868a = this.f7894a;
            adSlot.f7873f = this.f7900g;
            adSlot.f7874g = this.f7897d;
            adSlot.f7875h = this.f7898e;
            adSlot.f7876i = this.f7899f;
            adSlot.f7869b = this.f7895b;
            adSlot.f7870c = this.f7896c;
            adSlot.f7871d = this.f7906m;
            adSlot.f7872e = this.f7907n;
            adSlot.f7877j = this.f7901h;
            adSlot.f7878k = this.f7902i;
            adSlot.f7879l = this.f7903j;
            adSlot.f7881n = this.f7904k;
            adSlot.f7882o = this.f7908o;
            adSlot.f7883p = this.f7909p;
            adSlot.f7884q = this.f7910q;
            adSlot.f7885r = this.f7911r;
            adSlot.f7887t = this.f7915v;
            adSlot.f7888u = this.f7916w;
            adSlot.f7889v = this.f7917x;
            adSlot.f7880m = this.f7905l;
            adSlot.f7886s = this.f7912s;
            adSlot.f7890w = this.f7913t;
            adSlot.f7891x = this.f7914u;
            adSlot.f7893z = this.f7919z;
            adSlot.f7892y = this.f7918y;
            return adSlot;
        }

        public Builder setAdCount(int i10) {
            if (i10 <= 0) {
                i10 = 1;
            }
            if (i10 > 20) {
                i10 = 20;
            }
            this.f7900g = i10;
            return this;
        }

        public Builder setAdId(String str) {
            this.f7915v = str;
            return this;
        }

        public Builder setAdLoadType(TTAdLoadType tTAdLoadType) {
            this.f7914u = tTAdLoadType;
            return this;
        }

        public Builder setAdType(int i10) {
            this.f7905l = i10;
            return this;
        }

        public Builder setAdloadSeq(int i10) {
            this.f7910q = i10;
            return this;
        }

        public Builder setCodeId(String str) {
            this.f7894a = str;
            return this;
        }

        public Builder setCreativeId(String str) {
            this.f7916w = str;
            return this;
        }

        public Builder setExpressViewAcceptedSize(float f10, float f11) {
            this.f7906m = f10;
            this.f7907n = f11;
            return this;
        }

        public Builder setExt(String str) {
            this.f7917x = str;
            return this;
        }

        public Builder setExternalABVid(int... iArr) {
            this.f7909p = iArr;
            return this;
        }

        public Builder setImageAcceptedSize(int i10, int i11) {
            this.f7895b = i10;
            this.f7896c = i11;
            return this;
        }

        public Builder setIsAutoPlay(boolean z10) {
            this.f7908o = z10;
            return this;
        }

        public Builder setMediaExtra(String str) {
            this.f7901h = str;
            return this;
        }

        @Deprecated
        public Builder setNativeAdType(int i10) {
            this.f7904k = i10;
            return this;
        }

        public Builder setOrientation(int i10) {
            this.f7903j = i10;
            return this;
        }

        public Builder setPrimeRit(String str) {
            this.f7911r = str;
            return this;
        }

        public Builder setRewardAmount(int i10) {
            this.f7918y = i10;
            return this;
        }

        public Builder setRewardName(String str) {
            this.f7919z = str;
            return this;
        }

        public Builder setSupportDeepLink(boolean z10) {
            this.f7897d = z10;
            return this;
        }

        public Builder setUserData(String str) {
            this.f7913t = str;
            return this;
        }

        public Builder setUserID(String str) {
            this.f7902i = str;
            return this;
        }

        public Builder supportIconStyle() {
            this.f7899f = true;
            return this;
        }

        public Builder supportRenderControl() {
            this.f7898e = true;
            return this;
        }

        public Builder withBid(String str) {
            if (str == null) {
                return this;
            }
            this.f7912s = str;
            return this;
        }
    }

    public /* synthetic */ AdSlot(AnonymousClass1 anonymousClass1) {
        this();
    }

    public int getAdCount() {
        return this.f7873f;
    }

    public String getAdId() {
        return this.f7887t;
    }

    public TTAdLoadType getAdLoadType() {
        return this.f7891x;
    }

    public int getAdType() {
        return this.f7880m;
    }

    public int getAdloadSeq() {
        return this.f7884q;
    }

    public String getBidAdm() {
        return this.f7886s;
    }

    public String getCodeId() {
        return this.f7868a;
    }

    public String getCreativeId() {
        return this.f7888u;
    }

    public float getExpressViewAcceptedHeight() {
        return this.f7872e;
    }

    public float getExpressViewAcceptedWidth() {
        return this.f7871d;
    }

    public String getExt() {
        return this.f7889v;
    }

    public int[] getExternalABVid() {
        return this.f7883p;
    }

    public int getImgAcceptedHeight() {
        return this.f7870c;
    }

    public int getImgAcceptedWidth() {
        return this.f7869b;
    }

    public String getMediaExtra() {
        return this.f7877j;
    }

    @Deprecated
    public int getNativeAdType() {
        return this.f7881n;
    }

    public int getOrientation() {
        return this.f7879l;
    }

    public String getPrimeRit() {
        String str = this.f7885r;
        return str == null ? "" : str;
    }

    public int getRewardAmount() {
        return this.f7892y;
    }

    public String getRewardName() {
        return this.f7893z;
    }

    public String getUserData() {
        return this.f7890w;
    }

    public String getUserID() {
        return this.f7878k;
    }

    public boolean isAutoPlay() {
        return this.f7882o;
    }

    public boolean isSupportDeepLink() {
        return this.f7874g;
    }

    public boolean isSupportIconStyle() {
        return this.f7876i;
    }

    public boolean isSupportRenderConrol() {
        return this.f7875h;
    }

    public void setAdCount(int i10) {
        this.f7873f = i10;
    }

    public void setAdLoadType(TTAdLoadType tTAdLoadType) {
        this.f7891x = tTAdLoadType;
    }

    public void setExternalABVid(int... iArr) {
        this.f7883p = iArr;
    }

    public void setGroupLoadMore(int i10) {
        this.f7877j = a(this.f7877j, i10);
    }

    public void setNativeAdType(int i10) {
        this.f7881n = i10;
    }

    public void setUserData(String str) {
        this.f7890w = str;
    }

    public JSONObject toJsonObj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mCodeId", this.f7868a);
            jSONObject.put("mIsAutoPlay", this.f7882o);
            jSONObject.put("mImgAcceptedWidth", this.f7869b);
            jSONObject.put("mImgAcceptedHeight", this.f7870c);
            jSONObject.put("mExpressViewAcceptedWidth", this.f7871d);
            jSONObject.put("mExpressViewAcceptedHeight", this.f7872e);
            jSONObject.put("mAdCount", this.f7873f);
            jSONObject.put("mSupportDeepLink", this.f7874g);
            jSONObject.put("mSupportRenderControl", this.f7875h);
            jSONObject.put("mSupportIconStyle", this.f7876i);
            jSONObject.put("mMediaExtra", this.f7877j);
            jSONObject.put("mUserID", this.f7878k);
            jSONObject.put("mOrientation", this.f7879l);
            jSONObject.put("mNativeAdType", this.f7881n);
            jSONObject.put("mAdloadSeq", this.f7884q);
            jSONObject.put("mPrimeRit", this.f7885r);
            jSONObject.put("mAdId", this.f7887t);
            jSONObject.put("mCreativeId", this.f7888u);
            jSONObject.put("mExt", this.f7889v);
            jSONObject.put("mBidAdm", this.f7886s);
            jSONObject.put("mUserData", this.f7890w);
            jSONObject.put("mAdLoadType", this.f7891x);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public String toString() {
        return "AdSlot{mCodeId='" + this.f7868a + "', mImgAcceptedWidth=" + this.f7869b + ", mImgAcceptedHeight=" + this.f7870c + ", mExpressViewAcceptedWidth=" + this.f7871d + ", mExpressViewAcceptedHeight=" + this.f7872e + ", mAdCount=" + this.f7873f + ", mSupportDeepLink=" + this.f7874g + ", mSupportRenderControl=" + this.f7875h + ", mSupportIconStyle=" + this.f7876i + ", mMediaExtra='" + this.f7877j + "', mUserID='" + this.f7878k + "', mOrientation=" + this.f7879l + ", mNativeAdType=" + this.f7881n + ", mIsAutoPlay=" + this.f7882o + ", mPrimeRit" + this.f7885r + ", mAdloadSeq" + this.f7884q + ", mAdId" + this.f7887t + ", mCreativeId" + this.f7888u + ", mExt" + this.f7889v + ", mUserData" + this.f7890w + ", mAdLoadType" + this.f7891x + '}';
    }

    private AdSlot() {
        this.f7879l = 2;
        this.f7882o = true;
    }

    private String a(String str, int i10) {
        JSONObject jSONObject;
        if (i10 < 1) {
            return str;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(str);
            }
            jSONObject.put("_tt_group_load_more", i10);
            return jSONObject.toString();
        } catch (JSONException e10) {
            e10.printStackTrace();
            return str;
        }
    }
}
