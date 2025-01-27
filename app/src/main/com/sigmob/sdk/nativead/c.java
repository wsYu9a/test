package com.sigmob.sdk.nativead;

import android.content.Context;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.TouchLocation;
import com.sigmob.sdk.base.common.b0;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.models.rtb.NativeAdSetting;
import com.sigmob.sdk.base.models.rtb.SingleNativeAdSetting;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class c extends com.sigmob.sdk.base.common.i {
    public int A;
    public int B;
    public boolean C;
    public Boolean D;

    /* renamed from: w */
    public int f19923w;

    /* renamed from: x */
    public int f19924x;

    /* renamed from: y */
    public int f19925y;

    /* renamed from: z */
    public int f19926z;

    public class a implements b0.g {

        /* renamed from: a */
        public final /* synthetic */ int f19927a;

        /* renamed from: b */
        public final /* synthetic */ int f19928b;

        public a(int i10, int i11) {
            this.f19927a = i10;
            this.f19928b = i11;
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                HashMap hashMap = new HashMap();
                hashMap.put("video_time", String.valueOf(this.f19927a));
                hashMap.put("begin_time", String.valueOf(this.f19928b));
                ((PointEntitySigmob) obj).setOptions(hashMap);
            }
        }
    }

    public class b implements b0.g {

        /* renamed from: a */
        public final /* synthetic */ int f19930a;

        /* renamed from: b */
        public final /* synthetic */ int f19931b;

        /* renamed from: c */
        public final /* synthetic */ int f19932c;

        public b(int i10, int i11, int i12) {
            this.f19930a = i10;
            this.f19931b = i11;
            this.f19932c = i12;
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                HashMap hashMap = new HashMap();
                hashMap.put("video_time", String.valueOf(this.f19930a));
                hashMap.put("begin_time", String.valueOf(this.f19931b));
                hashMap.put(com.umeng.analytics.pro.f.f23909q, String.valueOf(this.f19932c));
                hashMap.put("is_first", String.valueOf(this.f19931b == 0 ? 1 : 0));
                hashMap.put("is_last", String.valueOf(this.f19932c >= this.f19930a + (-1000) ? 1 : 0));
                ((PointEntitySigmob) obj).setOptions(hashMap);
            }
        }
    }

    public static c f(BaseAdUnit baseAdUnit) {
        c cVar = new c();
        cVar.b(baseAdUnit);
        return cVar;
    }

    @Override // com.sigmob.sdk.base.common.i
    public void a(Context context, TouchLocation touchLocation, TouchLocation touchLocation2, com.sigmob.sdk.base.a aVar, BaseAdUnit baseAdUnit) {
        String str;
        SigMacroCommon macroCommon = baseAdUnit.getMacroCommon();
        if (macroCommon != null) {
            macroCommon.updateClickMarco(touchLocation, touchLocation2);
            str = macroCommon.getCoordinate();
        } else {
            str = "";
        }
        a(aVar, str, true);
    }

    @Override // com.sigmob.sdk.base.common.i
    public void b(BaseAdUnit baseAdUnit) {
        super.b(baseAdUnit);
        NativeAdSetting nativeAdSetting = baseAdUnit.getNativeAdSetting();
        SingleNativeAdSetting singleNativeSetting = baseAdUnit.getSingleNativeSetting();
        if (singleNativeSetting != null) {
            this.C = singleNativeSetting.use_na_video_component.booleanValue();
        }
        if (nativeAdSetting != null) {
            this.f19924x = nativeAdSetting.preview_page_video_mute.intValue();
            this.f19925y = nativeAdSetting.detail_page_video_mute.intValue();
            this.f19926z = nativeAdSetting.impression_percent.intValue();
            this.A = nativeAdSetting.impression_time.intValue();
            this.f19923w = nativeAdSetting.video_auto_play.intValue();
            this.B = nativeAdSetting.end_impression_time.intValue();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.sigmob.sdk.videoAd.f("play_quarter", 0.25f));
        arrayList.add(new com.sigmob.sdk.videoAd.f("play_two_quarters", 0.5f));
        arrayList.add(new com.sigmob.sdk.videoAd.f("play_three_quarters", 0.75f));
        a(arrayList);
    }

    public void c(Context context, BaseAdUnit baseAdUnit) {
        com.sigmob.sdk.base.common.b0.b("ad_show", null, baseAdUnit);
        com.sigmob.sdk.base.network.f.a(baseAdUnit, "ad_show");
    }

    public void d(Context context, BaseAdUnit baseAdUnit) {
        com.sigmob.sdk.base.common.b0.a(PointCategory.TEMPLATE_CLOSE, (String) null, baseAdUnit);
    }

    public void e(Context context, BaseAdUnit baseAdUnit) {
        com.sigmob.sdk.base.common.b0.a(PointCategory.TEMPLATE_SHOW, (String) null, baseAdUnit);
    }

    public boolean m() {
        return this.f19925y != 0;
    }

    public int n() {
        return this.B;
    }

    public int o() {
        int i10 = this.f19926z;
        if (i10 != 0) {
            return i10;
        }
        return 50;
    }

    public int p() {
        int i10 = this.A;
        if (i10 != 0) {
            return i10;
        }
        return 1;
    }

    public int q() {
        return this.f19926z;
    }

    public int r() {
        return this.A;
    }

    public boolean s() {
        Boolean bool = this.D;
        return bool != null ? bool.booleanValue() : this.f19924x == 0;
    }

    public int t() {
        return this.f19923w;
    }

    public boolean u() {
        if (t() != 0) {
            return t() == 1 && ClientMetadata.getInstance().getActiveNetworkType() == 100;
        }
        return true;
    }

    public boolean v() {
        return this.C;
    }

    public void a(BaseAdUnit baseAdUnit, int i10, int i11, int i12) {
        com.sigmob.sdk.base.common.b0.a("video_pause", (String) null, baseAdUnit, new b(i12, i11, i10));
        SigMacroCommon macroCommon = baseAdUnit.getMacroCommon();
        macroCommon.addMarcoKey(SigMacroCommon._VIDEOTIME_, String.valueOf(i12));
        macroCommon.addMarcoKey(SigMacroCommon._BEGINTIME_, String.valueOf(i11));
        macroCommon.addMarcoKey(SigMacroCommon._ENDTIME_, String.valueOf(i10));
        macroCommon.addMarcoKey(SigMacroCommon._PLAYFIRSTFRAME_, String.valueOf(i11 == 0 ? 1 : 0));
        macroCommon.addMarcoKey(SigMacroCommon._ENDTIME_, String.valueOf(i10));
        macroCommon.addMarcoKey(SigMacroCommon._ENDTIME_, String.valueOf(i10));
        com.sigmob.sdk.base.network.f.a(baseAdUnit, "video_pause");
    }

    public void f(Context context, BaseAdUnit baseAdUnit) {
        com.sigmob.sdk.base.common.b0.b("feed_click", null, baseAdUnit);
        com.sigmob.sdk.base.network.f.a(baseAdUnit, "feed_click");
    }

    public void a(BaseAdUnit baseAdUnit, int i10, int i11) {
        com.sigmob.sdk.base.common.b0.a("video_start", (String) null, baseAdUnit, new a(i10, i11));
        SigMacroCommon macroCommon = baseAdUnit.getMacroCommon();
        macroCommon.addMarcoKey(SigMacroCommon._VIDEOTIME_, String.valueOf(i11));
        macroCommon.addMarcoKey(SigMacroCommon._BEGINTIME_, String.valueOf(i10));
        com.sigmob.sdk.base.network.f.a(baseAdUnit, "video_start");
    }

    public void a(boolean z10) {
        this.D = Boolean.valueOf(z10);
    }
}
