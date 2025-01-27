package com.sigmob.sdk.nativead;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sigmob.sdk.base.common.b0;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.rtb.BiddingResponse;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.network.d;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.natives.WindNativeAdData;
import com.sigmob.windad.natives.WindNativeAdRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class v implements d.a {

    /* renamed from: g */
    public static final int f20063g = 1;

    /* renamed from: h */
    public static final int f20064h = 2;

    /* renamed from: i */
    public static final int f20065i = 3;

    /* renamed from: b */
    public x f20067b;

    /* renamed from: c */
    public WindNativeAdRequest f20068c;

    /* renamed from: d */
    public boolean f20069d;

    /* renamed from: f */
    public List<BaseAdUnit> f20071f;

    /* renamed from: e */
    public final int f20070e = 20481;

    /* renamed from: a */
    public Handler f20066a = new a(Looper.getMainLooper());

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 20481 && v.this.f20069d) {
                v.this.f20066a.removeMessages(20481);
                v vVar = v.this;
                WindAdError windAdError = WindAdError.ERROR_SIGMOB_AD_TIME_OUT;
                vVar.a(null, windAdError.getErrorCode(), windAdError.getMessage());
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ int f20073a;

        /* renamed from: b */
        public final /* synthetic */ String f20074b;

        /* renamed from: c */
        public final /* synthetic */ List f20075c;

        public b(int i10, String str, List list) {
            this.f20073a = i10;
            this.f20074b = str;
            this.f20075c = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (v.this.f20067b != null) {
                if (this.f20073a != 0) {
                    v.this.f20067b.onNativeAdLoadFail(this.f20073a, this.f20074b);
                } else {
                    v.this.f20067b.onNativeAdLoaded(this.f20075c);
                }
            }
        }
    }

    public class c implements b0.g {

        /* renamed from: a */
        public final /* synthetic */ List f20077a;

        public c(List list) {
            this.f20077a = list;
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                HashMap hashMap = new HashMap();
                hashMap.put("ad_count", String.valueOf(this.f20077a.size()));
                ((PointEntitySigmob) obj).setOptions(hashMap);
            }
        }
    }

    public v(WindNativeAdRequest windNativeAdRequest, x xVar) {
        this.f20068c = windNativeAdRequest;
        this.f20067b = xVar;
    }

    public String b() {
        BaseAdUnit baseAdUnit;
        BiddingResponse biddingResponse;
        List<BaseAdUnit> list = this.f20071f;
        if (list == null || list.size() <= 0 || (baseAdUnit = this.f20071f.get(0)) == null || (biddingResponse = baseAdUnit.bidding_response) == null) {
            return null;
        }
        return String.valueOf(biddingResponse.ecpm);
    }

    public void a(String str, String str2) {
        BaseAdUnit baseAdUnit;
        List<BaseAdUnit> list = this.f20071f;
        if (list == null || (baseAdUnit = list.get(0)) == null || baseAdUnit.bidding_response == null) {
            return;
        }
        baseAdUnit.getMacroCommon().addMarcoKey(str, str2);
    }

    public Map<String, BiddingResponse> a() {
        BaseAdUnit baseAdUnit;
        List<BaseAdUnit> list = this.f20071f;
        if (list == null || (baseAdUnit = list.get(0)) == null || baseAdUnit.bidding_response == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(baseAdUnit.getRequestId(), baseAdUnit.bidding_response);
        return hashMap;
    }

    public final WindNativeAdData a(BaseAdUnit baseAdUnit) {
        return new d0(baseAdUnit);
    }

    public void a(int i10, String str, int i11, String str2) {
        this.f20069d = true;
        this.f20066a.sendEmptyMessageDelayed(20481, com.sigmob.sdk.base.l.w().g0());
        LoadAdRequest loadAdRequest = new LoadAdRequest(this.f20068c);
        loadAdRequest.setBidToken(str);
        loadAdRequest.setBidFloor(i11);
        loadAdRequest.setCurrency(str2);
        loadAdRequest.setAd_count(i10);
        com.sigmob.sdk.base.network.d.a(loadAdRequest, this);
    }

    public final void a(List<WindNativeAdData> list, int i10, String str) {
        this.f20069d = false;
        this.f20066a.removeMessages(20481);
        this.f20066a.post(new b(i10, str, list));
    }

    @Override // com.sigmob.sdk.base.network.d.a
    public void a(int i10, String str, String str2, LoadAdRequest loadAdRequest) {
        com.sigmob.sdk.base.common.b0.a(PointCategory.RESPOND, "0", loadAdRequest);
        a(null, i10, str);
    }

    @Override // com.sigmob.sdk.base.network.d.a
    public void a(List<BaseAdUnit> list, LoadAdRequest loadAdRequest) {
        this.f20071f = list;
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            BaseAdUnit baseAdUnit = list.get(i10);
            arrayList.add(a(baseAdUnit));
            if (baseAdUnit.getAd_source_channel().equalsIgnoreCase("1000")) {
                com.sigmob.sdk.base.common.h.s().b(baseAdUnit);
            }
        }
        com.sigmob.sdk.base.common.b0.a(PointCategory.RESPOND, "1", (BaseAdUnit) null, loadAdRequest, new c(list));
        com.sigmob.sdk.base.common.b0.a(PointCategory.READY, (String) null, list.get(0), loadAdRequest, (b0.g) null);
        a(arrayList, 0, null);
    }
}
