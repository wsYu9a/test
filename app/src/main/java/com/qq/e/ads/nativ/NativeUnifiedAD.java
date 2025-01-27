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

/* loaded from: classes4.dex */
public class NativeUnifiedAD extends NativeAbstractAD<NUADI> {

    /* renamed from: g */
    private AdListenerAdapter f23948g;

    /* renamed from: h */
    private NativeADUnifiedListener f23949h;

    /* renamed from: i */
    private List<Integer> f23950i = new ArrayList();

    /* renamed from: j */
    private List<String> f23951j;
    private volatile int k;
    private volatile int l;
    private String m;
    private LoadAdParams n;

    private static class AdListenerAdapter implements ADListener {

        /* renamed from: a */
        private NativeADUnifiedListener f23952a;

        public AdListenerAdapter(NativeADUnifiedListener nativeADUnifiedListener) {
            this.f23952a = nativeADUnifiedListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            Integer num;
            if (this.f23952a != null) {
                int type = aDEvent.getType();
                if (type != 100) {
                    if (type == 101 && (num = (Integer) aDEvent.getParam(Integer.class)) != null) {
                        this.f23952a.onNoAD(AdErrorConvertor.formatErrorCode(num.intValue()));
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
                this.f23952a.onADLoaded(arrayList);
            }
        }
    }

    public NativeUnifiedAD(Context context, String str, NativeADUnifiedListener nativeADUnifiedListener) {
        this.f23949h = nativeADUnifiedListener;
        this.f23948g = new AdListenerAdapter(nativeADUnifiedListener);
        a(context, str);
    }

    public NativeUnifiedAD(Context context, String str, NativeADUnifiedListener nativeADUnifiedListener, String str2) {
        this.f23949h = nativeADUnifiedListener;
        this.f23948g = new AdListenerAdapter(nativeADUnifiedListener);
        a(context, str, str2);
    }

    private void a(int i2, boolean z) {
        if (a()) {
            if (!b()) {
                if (z) {
                    this.f23950i.add(Integer.valueOf(i2));
                    return;
                }
                return;
            }
            T t = this.f23859a;
            if (t != 0) {
                LoadAdParams loadAdParams = this.n;
                NUADI nuadi = (NUADI) t;
                if (loadAdParams != null) {
                    nuadi.loadData(i2, loadAdParams);
                } else {
                    nuadi.loadData(i2);
                }
            }
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    protected Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getNativeAdManagerDelegate(context, str, str2, str3, this.f23948g);
    }

    @Override // com.qq.e.ads.NativeAbstractAD, com.qq.e.ads.AbstractAD
    public void a(NUADI nuadi) {
        super.a((NativeUnifiedAD) nuadi);
        nuadi.setMinVideoDuration(this.k);
        nuadi.setMaxVideoDuration(this.l);
        nuadi.setVastClassName(this.m);
        List<String> list = this.f23951j;
        if (list != null) {
            setCategories(list);
        }
        Iterator<Integer> it = this.f23950i.iterator();
        while (it.hasNext()) {
            a(it.next().intValue(), false);
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    protected void b(int i2) {
        NativeADUnifiedListener nativeADUnifiedListener = this.f23949h;
        if (nativeADUnifiedListener != null) {
            nativeADUnifiedListener.onNoAD(AdErrorConvertor.formatErrorCode(i2));
        }
    }

    public String getAdNetWorkName() {
        T t = this.f23859a;
        if (t != 0) {
            return ((NUADI) t).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public void loadData(int i2) {
        a(i2, true);
    }

    public void loadData(int i2, LoadAdParams loadAdParams) {
        this.n = loadAdParams;
        loadData(i2);
    }

    public void setCategories(List<String> list) {
        this.f23951j = list;
        T t = this.f23859a;
        if (t == 0 || list == null) {
            return;
        }
        ((NUADI) t).setCategories(list);
    }

    public void setMaxVideoDuration(int i2) {
        this.l = i2;
        if (this.l > 0 && this.k > this.l) {
            GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        T t = this.f23859a;
        if (t != 0) {
            ((NUADI) t).setMaxVideoDuration(this.l);
        }
    }

    public void setMinVideoDuration(int i2) {
        this.k = i2;
        if (this.l > 0 && this.k > this.l) {
            GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        T t = this.f23859a;
        if (t != 0) {
            ((NUADI) t).setMinVideoDuration(this.k);
        }
    }

    public void setVastClassName(String str) {
        if (TextUtils.isEmpty(str)) {
            GDTLogger.e("Vast class name 不能为空");
            return;
        }
        this.m = str;
        T t = this.f23859a;
        if (t != 0) {
            ((NUADI) t).setVastClassName(str);
        }
    }
}
