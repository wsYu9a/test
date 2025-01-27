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

/* loaded from: classes2.dex */
public class ae extends bi {

    /* renamed from: a */
    public static final int f6705a = 17;

    /* renamed from: t */
    private static final String f6706t = "javascript:";
    private NativeCPUManager.CPUAdListener A;
    private NativeCPUManager B;
    private int C;
    private int D;
    private boolean E;
    private String F;

    /* renamed from: u */
    private int f6707u;

    /* renamed from: v */
    private int f6708v;

    /* renamed from: w */
    private int[] f6709w;

    /* renamed from: x */
    private boolean f6710x;

    /* renamed from: y */
    private int f6711y;

    /* renamed from: z */
    private HashMap<String, Object> f6712z;

    public ae(Context context) {
        super(context);
        this.C = 5;
        this.D = 60;
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

    private String j(String str) {
        IXAdContainerFactory c10;
        aa a10 = aa.a();
        if (a10 != null && (c10 = a10.c()) != null) {
            Object remoteParam = c10.getRemoteParam(str, new Object[0]);
            if (remoteParam instanceof String) {
                return (String) remoteParam;
            }
        }
        return null;
    }

    public void x() {
        an.b();
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void d() {
        NativeCPUManager.CPUAdListener cPUAdListener = this.A;
        if (cPUAdListener != null) {
            cPUAdListener.onExitLp();
        }
    }

    public void e() {
        an.a(this.C);
        an.b(this.D);
        an.a(new aj(this));
    }

    public Activity f() {
        return an.c();
    }

    public boolean g() {
        return an.d();
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void b(IOAdEvent iOAdEvent) {
        notifyObservers(iOAdEvent);
        setChanged();
    }

    public void a(NativeCPUManager.CPUAdListener cPUAdListener) {
        this.A = cPUAdListener;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void d(IOAdEvent iOAdEvent) {
        try {
            if (this.A == null || iOAdEvent == null) {
                return;
            }
            HashMap<String, Object> hashMap = (HashMap) iOAdEvent.getData();
            this.A.onLpCustomEventCallBack(hashMap, new ah(this, hashMap.get(TTDownloadField.TT_ACTIVITY)));
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public ae(Context context, String str, NativeCPUManager nativeCPUManager) {
        super(context);
        this.C = 5;
        this.D = 60;
        this.f6888q = str;
        this.B = nativeCPUManager;
    }

    public void a(int i10, int i11, int[] iArr, boolean z10, HashMap<String, Object> hashMap) {
        this.f6708v = i10;
        this.f6707u = i11;
        this.f6709w = iArr;
        this.f6710x = z10;
        this.f6712z = hashMap;
        this.E = an.f();
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void b() {
        NativeCPUManager.CPUAdListener cPUAdListener = this.A;
        if (cPUAdListener != null) {
            cPUAdListener.onVideoDownloadSuccess();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a() {
        if (this.f6884m == null) {
            this.f6885n = false;
            return;
        }
        this.f6885n = true;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(IAdInterListener.AdReqParam.PROD, "cpu");
            this.f6884m.createProdHandler(jSONObject3);
            m();
            this.f6884m.addEventListener("Update_fbReader_Setting", new af(this));
            this.f6884m.addEventListener("closeInterstitialAd", new ag(this));
            jSONObject.put(IAdInterListener.AdReqParam.PROD, "cpu");
            jSONObject.put("appsid", this.f6888q);
            jSONObject.put("pageIndex", this.f6708v);
            jSONObject.put("pageSize", this.f6707u);
            jSONObject.put("channels", this.f6709w);
            jSONObject.put("showAd", this.f6710x);
            jSONObject.put("openActivitylink", this.F);
            if (!TextUtils.isEmpty(this.f6888q)) {
                jSONObject.put("appid", this.f6888q);
            }
            jSONObject2.put("timeout", this.f6711y);
            HashMap<String, Object> hashMap = this.f6712z;
            if (hashMap == null || hashMap.isEmpty()) {
                ay.c().e("内容联盟元素需要传入 CPUAdRequest配置信息");
            }
            jSONObject2 = m.a(this.f6712z);
            if (jSONObject2 != null) {
                jSONObject2.put("isInitNovelSDK", this.E);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        this.f6884m.loadAd(jSONObject, jSONObject2);
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void c() {
        NativeCPUManager.CPUAdListener cPUAdListener = this.A;
        if (cPUAdListener != null) {
            cPUAdListener.onVideoDownloadFailed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void c(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            Map<String, Object> data = iOAdEvent.getData();
            Integer num = (Integer) data.get(id.c.f26972i);
            String str = (String) data.get("mislikereason");
            NativeCPUManager.CPUAdListener cPUAdListener = this.A;
            if (cPUAdListener == null || num == null || str == null) {
                return;
            }
            cPUAdListener.onDisLikeAdClick(num.intValue(), str);
        }
    }

    public void a(int i10) {
        this.f6711y = i10;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a(IOAdEvent iOAdEvent) {
        if (this.A != null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = ((List) iOAdEvent.getData().get("cpuAdList")).iterator();
            while (it.hasNext()) {
                NativeCPUAdData nativeCPUAdData = new NativeCPUAdData(this.f6880i, it.next(), this.f6712z);
                arrayList.add(nativeCPUAdData);
                addObserver(nativeCPUAdData);
            }
            this.A.onAdLoaded(arrayList);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a(String str, int i10, String str2) {
        super.a(str, i10, str2);
        NativeCPUManager.CPUAdListener cPUAdListener = this.A;
        if (cPUAdListener != null) {
            cPUAdListener.onAdError(str, i10);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a(int i10, String str, String str2) {
        super.a(i10, str, str2);
        NativeCPUManager.CPUAdListener cPUAdListener = this.A;
        if (cPUAdListener != null) {
            cPUAdListener.onAdError(str, i10);
        }
    }

    public void a(WebView webView, JSONObject jSONObject) {
        bi.a(new ai(this, jSONObject, webView));
    }

    public void a(String str) {
        this.F = str;
    }
}
