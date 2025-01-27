package com.zk_oaction.adengine.lk_sdkwrapper;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.wrapper_oaction.ZkViewSDK;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public class e {

    /* renamed from: a */
    protected HashMap<String, com.zk_oaction.adengine.lk_sdkwrapper.a> f34947a = new HashMap<>();

    /* renamed from: b */
    private Context f34948b;

    class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ com.zk_oaction.adengine.lk_sdkwrapper.a f34949a;

        /* renamed from: b */
        final /* synthetic */ int f34950b;

        /* renamed from: c */
        final /* synthetic */ int f34951c;

        /* renamed from: d */
        final /* synthetic */ boolean f34952d;

        a(com.zk_oaction.adengine.lk_sdkwrapper.a aVar, int i2, int i3, boolean z) {
            this.f34949a = aVar;
            this.f34950b = i2;
            this.f34951c = i3;
            this.f34952d = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.f34949a != null && e.this.f34948b != null) {
                    this.f34949a.i(this.f34950b, this.f34951c);
                    HashMap<String, com.zk_oaction.adengine.lk_sdkwrapper.a> hashMap = e.this.f34947a;
                    if (hashMap != null) {
                        hashMap.put(this.f34949a.P(), this.f34949a);
                    }
                    if (this.f34952d) {
                        this.f34949a.I();
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public View b(String str, int i2, int i3, boolean z, HashMap<ZkViewSDK.KEY, Object> hashMap, ZkViewSDK.a aVar, int i4, Map map, int i5) {
        if (this.f34948b == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("/native_match_w");
        com.zk_oaction.adengine.lk_sdkwrapper.a c2 = new File(sb.toString()).exists() ? c(str, hashMap, aVar, i4, map, i5) : new com.zk_oaction.adengine.lk_sdkwrapper.a(this.f34948b, i5, str, hashMap, i4, map, aVar);
        c2.i(i2, i3);
        HashMap<String, com.zk_oaction.adengine.lk_sdkwrapper.a> hashMap2 = this.f34947a;
        if (hashMap2 != null) {
            hashMap2.put(c2.P(), c2);
        }
        if (!z) {
            return c2;
        }
        c2.I();
        return c2;
    }

    public com.zk_oaction.adengine.lk_sdkwrapper.a c(String str, HashMap<ZkViewSDK.KEY, Object> hashMap, ZkViewSDK.a aVar, int i2, Map map, int i3) {
        return new b(this.f34948b, i3, str, hashMap, i2, map, aVar);
    }

    public void d(Context context) {
        synchronized (this) {
            this.f34948b = context;
        }
    }

    public void e(View view) {
        synchronized (this) {
            if (view != null) {
                try {
                    if (view instanceof com.zk_oaction.adengine.lk_sdkwrapper.a) {
                        ((com.zk_oaction.adengine.lk_sdkwrapper.a) view).I();
                    }
                } finally {
                }
            }
        }
    }

    public void f(View view, HashMap<ZkViewSDK.KEY, Object> hashMap) {
        if (view != null) {
            try {
                if (view instanceof com.zk_oaction.adengine.lk_sdkwrapper.a) {
                    ((com.zk_oaction.adengine.lk_sdkwrapper.a) view).o(hashMap);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void g(View view, boolean z) {
        if (view != null) {
            try {
                if (view instanceof com.zk_oaction.adengine.lk_sdkwrapper.a) {
                    ((com.zk_oaction.adengine.lk_sdkwrapper.a) view).p(z);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public View h(String str, int i2, int i3, boolean z, HashMap<ZkViewSDK.KEY, Object> hashMap, ZkViewSDK.a aVar, int i4, Map map, int i5) {
        if (this.f34948b == null) {
            return null;
        }
        c cVar = new c(this.f34948b, i5, str, hashMap, i4, map, aVar);
        new Handler(Looper.getMainLooper()).post(new a(cVar, i2, i3, z));
        return cVar;
    }

    public void i(View view) {
        synchronized (this) {
            if (view != null) {
                try {
                    if (view instanceof com.zk_oaction.adengine.lk_sdkwrapper.a) {
                        ((com.zk_oaction.adengine.lk_sdkwrapper.a) view).L();
                    }
                } finally {
                }
            }
        }
    }

    public void j(View view) {
        synchronized (this) {
            if (view != null) {
                try {
                    if (view instanceof com.zk_oaction.adengine.lk_sdkwrapper.a) {
                        ((com.zk_oaction.adengine.lk_sdkwrapper.a) view).y();
                        HashMap<String, com.zk_oaction.adengine.lk_sdkwrapper.a> hashMap = this.f34947a;
                        if (hashMap != null && hashMap.containsKey(((com.zk_oaction.adengine.lk_sdkwrapper.a) view).P())) {
                            this.f34947a.remove(((com.zk_oaction.adengine.lk_sdkwrapper.a) view).P());
                        }
                    }
                } finally {
                }
            }
        }
    }
}
