package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.api.NativeCPUAdData;
import com.baidu.mobads.sdk.api.NativeCPUManager;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ad extends bf {

    /* renamed from: a */
    public static final int f5497a = 17;
    private static final String q = "javascript:";
    private int A;
    private boolean B;
    private String C;
    private int r;
    private int s;
    private int[] t;
    private boolean u;
    private int v;
    private HashMap<String, Object> w;
    private NativeCPUManager.CPUAdListener x;
    private NativeCPUManager y;
    private int z;

    public ad(Context context) {
        super(context);
        this.z = 5;
        this.A = 60;
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

    private String i(String str) {
        IXAdContainerFactory c2;
        z a2 = z.a();
        if (a2 != null && (c2 = a2.c()) != null) {
            Object remoteParam = c2.getRemoteParam(str, new Object[0]);
            if (remoteParam instanceof String) {
                return (String) remoteParam;
            }
        }
        return null;
    }

    public void w() {
        an.b();
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void b_() {
        NativeCPUManager.CPUAdListener cPUAdListener = this.x;
        if (cPUAdListener != null) {
            cPUAdListener.onVideoDownloadSuccess();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void c_() {
        NativeCPUManager.CPUAdListener cPUAdListener = this.x;
        if (cPUAdListener != null) {
            cPUAdListener.onVideoDownloadFailed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void d() {
        NativeCPUManager.CPUAdListener cPUAdListener = this.x;
        if (cPUAdListener != null) {
            cPUAdListener.onExitLp();
        }
    }

    public void f() {
        an.a(this.z);
        an.b(this.A);
        an.a(new ai(this));
    }

    public Activity g() {
        return an.c();
    }

    public boolean h() {
        return an.d();
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void b(String str, int i2) {
        super.b(str, i2);
        NativeCPUManager.CPUAdListener cPUAdListener = this.x;
        if (cPUAdListener != null) {
            cPUAdListener.onAdError(str, i2);
        }
    }

    public void a(NativeCPUManager.CPUAdListener cPUAdListener) {
        this.x = cPUAdListener;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void d(IOAdEvent iOAdEvent) {
        try {
            if (this.x == null || iOAdEvent == null) {
                return;
            }
            HashMap<String, Object> hashMap = (HashMap) iOAdEvent.getData();
            this.x.onLpCustomEventCallBack(hashMap, new ag(this, hashMap.get(TTDownloadField.TT_ACTIVITY)));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public ad(Context context, String str, NativeCPUManager nativeCPUManager) {
        super(context);
        this.z = 5;
        this.A = 60;
        this.o = str;
        this.y = nativeCPUManager;
    }

    public void a(int i2, int i3, int[] iArr, boolean z, HashMap<String, Object> hashMap) {
        this.s = i2;
        this.r = i3;
        this.t = iArr;
        this.u = z;
        this.w = hashMap;
        this.B = an.f();
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void b(IOAdEvent iOAdEvent) {
        notifyObservers(iOAdEvent);
        setChanged();
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a() {
        if (this.k == null) {
            this.l = false;
            return;
        }
        this.l = true;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(IAdInterListener.AdReqParam.PROD, "cpu");
            this.k.createProdHandler(jSONObject3);
            n();
            this.k.addEventListener("Update_fbReader_Setting", new ae(this));
            this.k.addEventListener("closeInterstitialAd", new af(this));
            jSONObject.put(IAdInterListener.AdReqParam.PROD, "cpu");
            jSONObject.put("appsid", this.o);
            jSONObject.put("pageIndex", this.s);
            jSONObject.put("pageSize", this.r);
            jSONObject.put("channels", this.t);
            jSONObject.put("showAd", this.u);
            jSONObject.put("openActivitylink", this.C);
            if (!TextUtils.isEmpty(this.o)) {
                jSONObject.put("appid", this.o);
            }
            jSONObject2.put("timeout", this.v);
            HashMap<String, Object> hashMap = this.w;
            if (hashMap == null || hashMap.isEmpty()) {
                av.c().e("内容联盟元素需要传入 CPUAdRequest配置信息");
            }
            jSONObject2 = j.a(this.w);
            if (jSONObject2 != null) {
                jSONObject2.put("isInitNovelSDK", this.B);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.k.loadAd(jSONObject, jSONObject2);
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void c(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            Map<String, Object> data = iOAdEvent.getData();
            Integer num = (Integer) data.get("position");
            String str = (String) data.get("mislikereason");
            NativeCPUManager.CPUAdListener cPUAdListener = this.x;
            if (cPUAdListener == null || num == null || str == null) {
                return;
            }
            cPUAdListener.onDisLikeAdClick(num.intValue(), str);
        }
    }

    public void a(int i2) {
        this.v = i2;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void a(IOAdEvent iOAdEvent) {
        if (this.x != null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = ((List) iOAdEvent.getData().get("cpuAdList")).iterator();
            while (it.hasNext()) {
                NativeCPUAdData nativeCPUAdData = new NativeCPUAdData(this.f5588h, it.next(), this.w);
                arrayList.add(nativeCPUAdData);
                addObserver(nativeCPUAdData);
            }
            this.x.onAdLoaded(arrayList);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void a(int i2, String str) {
        super.a(i2, str);
        NativeCPUManager.CPUAdListener cPUAdListener = this.x;
        if (cPUAdListener != null) {
            cPUAdListener.onAdError(str, i2);
        }
    }

    protected void a(WebView webView, JSONObject jSONObject) {
        bf.a(new ah(this, jSONObject, webView));
    }

    public void a(String str) {
        this.C = str;
    }
}
