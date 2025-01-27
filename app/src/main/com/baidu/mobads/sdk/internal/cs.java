package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.CPUWebAdRequestParam;
import com.baidu.mobads.sdk.api.CpuAdView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class cs extends bi {

    /* renamed from: a */
    private HashMap<String, Object> f7116a;

    /* renamed from: t */
    private int f7117t;

    /* renamed from: u */
    private RelativeLayout f7118u;

    /* renamed from: v */
    private CpuAdView.CpuAdViewInternalStatusListener f7119v;

    public cs(Context context, RelativeLayout relativeLayout, String str, int i10, CPUWebAdRequestParam cPUWebAdRequestParam) {
        super(context);
        this.f6888q = str;
        this.f7118u = relativeLayout;
        this.f7117t = i10;
        if (cPUWebAdRequestParam == null) {
            ay.c().e("内容联盟模板需要传入 CPUWebAdRequestParam配置信息");
        } else {
            this.f7116a = (HashMap) cPUWebAdRequestParam.getParameters();
        }
    }

    public void c(Map<String, Object> map) {
        if (map != null) {
            Object obj = map.get("adInnerPageInterval");
            Object obj2 = map.get("adBottomRefreshInterval");
            Object obj3 = map.get("adFrontChapterInterval");
            Object obj4 = map.get("isShowFeeds");
            Object obj5 = map.get("isAdSwitch");
            Object obj6 = map.get("showCount");
            Object obj7 = map.get("clickCount");
            if (obj != null && obj2 != null) {
                an.a(((Integer) obj).intValue());
                an.b(((Integer) obj2).intValue());
            }
            if ((obj3 instanceof Integer) && (obj4 instanceof Boolean)) {
                an.a(((Integer) obj3).intValue(), ((Boolean) obj4).booleanValue());
            }
            if (obj5 instanceof Integer) {
                an.a(((Integer) obj5).intValue() != 0);
            }
            if ((obj6 instanceof Integer) && (obj7 instanceof Integer)) {
                an.a(((Integer) obj6).intValue(), ((Integer) obj7).intValue());
            }
        }
    }

    public void g() {
        an.b();
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void d() {
        CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener = this.f7119v;
        if (cpuAdViewInternalStatusListener != null) {
            cpuAdViewInternalStatusListener.onExitLp();
        }
    }

    public Activity e() {
        return an.c();
    }

    public boolean f() {
        return an.d();
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void h(IOAdEvent iOAdEvent) {
        Boolean bool = (Boolean) iOAdEvent.getData().get("isClickFeAd");
        if (this.f7119v != null && bool != null && bool.booleanValue()) {
            this.f7119v.onAdClick();
            return;
        }
        CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener = this.f7119v;
        if (cpuAdViewInternalStatusListener == null || bool == null) {
            return;
        }
        cpuAdViewInternalStatusListener.onContentClick();
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void e(IOAdEvent iOAdEvent) {
        Map<String, Object> data = iOAdEvent.getData();
        Boolean bool = (Boolean) data.get("isImpressionFeAd");
        String str = (String) data.get("nums");
        if (this.f7119v != null && bool != null && bool.booleanValue()) {
            this.f7119v.onAdImpression(str);
            return;
        }
        CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener = this.f7119v;
        if (cpuAdViewInternalStatusListener == null || bool == null) {
            return;
        }
        cpuAdViewInternalStatusListener.onContentImpression(str);
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void d(IOAdEvent iOAdEvent) {
        if (this.f7119v == null || iOAdEvent == null) {
            return;
        }
        this.f7119v.onLpContentStatus(iOAdEvent.getData());
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a() {
        if (this.f6884m == null) {
            this.f6885n = false;
            return;
        }
        this.f6885n = true;
        JSONObject jSONObject = new JSONObject();
        if (this.f6884m != null) {
            try {
                jSONObject.put("channel", this.f7117t);
                jSONObject.put(IAdInterListener.AdReqParam.PROD, "cpu_h5");
                jSONObject.put("timeout", 10000);
                if (!TextUtils.isEmpty(this.f6888q)) {
                    jSONObject.put("appid", this.f6888q);
                }
                if (this.f7118u != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(IAdInterListener.AdReqParam.PROD, "cpu_h5");
                    this.f6884m.createProdHandler(jSONObject2);
                    this.f6884m.setAdContainer(this.f7118u);
                    m();
                    this.f6884m.addEventListener("Update_fbReader_Setting", new ct(this));
                    this.f6884m.addEventListener("closeInterstitialAd", new cu(this));
                    this.f6884m.addEventListener("feOpenFbReader", new cv(this));
                    JSONObject a10 = m.a(this.f7116a);
                    a10.put("isInitNovelSDK", an.f());
                    this.f6884m.loadAd(jSONObject, a10);
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public void a(int i10, int i11, String str, int i12, int i13, String str2) {
        an.a(i10);
        an.b(i11);
        an.a(new cw(this, i12, i13, str2));
        an.a(this.f6880i, str);
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a(String str, int i10, String str2) {
        CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener = this.f7119v;
        if (cpuAdViewInternalStatusListener != null) {
            cpuAdViewInternalStatusListener.loadDataError(str);
        }
    }

    public void a(CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener) {
        this.f7119v = cpuAdViewInternalStatusListener;
    }
}
