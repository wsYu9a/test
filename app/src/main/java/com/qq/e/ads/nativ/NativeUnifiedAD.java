package com.qq.e.ads.nativ;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.ads.NativeAbstractAD;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.NUADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class NativeUnifiedAD extends NativeAbstractAD<NUADI> {

    /* renamed from: h */
    private AdListenerAdapter f16472h;

    /* renamed from: i */
    private NativeADUnifiedListener f16473i;

    /* renamed from: j */
    private List<Integer> f16474j = new ArrayList();

    /* renamed from: k */
    private List<String> f16475k;

    /* renamed from: l */
    private volatile int f16476l;

    /* renamed from: m */
    private volatile int f16477m;

    /* renamed from: n */
    private String f16478n;

    /* renamed from: o */
    private LoadAdParams f16479o;

    public static class AdListenerAdapter implements ADListener {

        /* renamed from: a */
        private NativeADUnifiedListener f16480a;

        public AdListenerAdapter(NativeADUnifiedListener nativeADUnifiedListener) {
            this.f16480a = nativeADUnifiedListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            Integer num;
            if (this.f16480a != null) {
                int type = aDEvent.getType();
                if (type != 100) {
                    if (type == 101 && (num = (Integer) aDEvent.getParam(Integer.class)) != null) {
                        this.f16480a.onNoAD(AdErrorConvertor.formatErrorCode(num.intValue()));
                        return;
                    }
                    return;
                }
                List list = (List) aDEvent.getParam(List.class);
                if (list == null || list.size() <= 0) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new NativeUnifiedADDataAdapter((NativeUnifiedADData) it.next()));
                }
                this.f16480a.onADLoaded(arrayList);
            }
        }
    }

    public NativeUnifiedAD(Context context, String str, NativeADUnifiedListener nativeADUnifiedListener) {
        this.f16473i = nativeADUnifiedListener;
        this.f16472h = new AdListenerAdapter(nativeADUnifiedListener);
        a(context, str);
    }

    private void a(int i10, boolean z10) {
        if (a()) {
            if (!b()) {
                if (z10) {
                    this.f16474j.add(Integer.valueOf(i10));
                    return;
                }
                return;
            }
            T t10 = this.f16367a;
            if (t10 != 0) {
                LoadAdParams loadAdParams = this.f16479o;
                NUADI nuadi = (NUADI) t10;
                if (loadAdParams != null) {
                    nuadi.loadData(i10, loadAdParams);
                } else {
                    nuadi.loadData(i10);
                }
            }
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i10) {
        NativeADUnifiedListener nativeADUnifiedListener = this.f16473i;
        if (nativeADUnifiedListener != null) {
            nativeADUnifiedListener.onNoAD(AdErrorConvertor.formatErrorCode(i10));
        }
    }

    public String getAdNetWorkName() {
        T t10 = this.f16367a;
        if (t10 != 0) {
            return ((NUADI) t10).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public void loadData(int i10) {
        a(i10, true);
    }

    public void setCategories(List<String> list) {
        this.f16475k = list;
        T t10 = this.f16367a;
        if (t10 == 0 || list == null) {
            return;
        }
        ((NUADI) t10).setCategories(list);
    }

    public void setMaxVideoDuration(int i10) {
        this.f16477m = i10;
        if (this.f16477m > 0 && this.f16476l > this.f16477m) {
            GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        T t10 = this.f16367a;
        if (t10 != 0) {
            ((NUADI) t10).setMaxVideoDuration(this.f16477m);
        }
    }

    public void setMinVideoDuration(int i10) {
        this.f16476l = i10;
        if (this.f16477m > 0 && this.f16476l > this.f16477m) {
            GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        T t10 = this.f16367a;
        if (t10 != 0) {
            ((NUADI) t10).setMinVideoDuration(this.f16476l);
        }
    }

    public void setVastClassName(String str) {
        if (TextUtils.isEmpty(str)) {
            GDTLogger.e("Vast class name 不能为空");
            return;
        }
        this.f16478n = str;
        T t10 = this.f16367a;
        if (t10 != 0) {
            ((NUADI) t10).setVastClassName(str);
        }
    }

    public NativeUnifiedAD(Context context, String str, NativeADUnifiedListener nativeADUnifiedListener, String str2) {
        this.f16473i = nativeADUnifiedListener;
        this.f16472h = new AdListenerAdapter(nativeADUnifiedListener);
        a(context, str, str2);
    }

    @Override // com.qq.e.ads.AbstractAD
    public Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getNativeAdManagerDelegate(context, str, str2, str3, this.f16472h);
    }

    public void loadData(int i10, LoadAdParams loadAdParams) {
        this.f16479o = loadAdParams;
        loadData(i10);
    }

    @Override // com.qq.e.ads.NativeAbstractAD, com.qq.e.ads.AbstractAD
    public void a(Object obj) {
        NUADI nuadi = (NUADI) obj;
        nuadi.setMinVideoDuration(this.f16476l);
        nuadi.setMaxVideoDuration(this.f16477m);
        nuadi.setVastClassName(this.f16478n);
        List<String> list = this.f16475k;
        if (list != null) {
            setCategories(list);
        }
        Iterator<Integer> it = this.f16474j.iterator();
        while (it.hasNext()) {
            a(it.next().intValue(), false);
        }
    }
}
