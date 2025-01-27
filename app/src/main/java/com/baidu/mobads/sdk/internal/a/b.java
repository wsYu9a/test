package com.baidu.mobads.sdk.internal.a;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.baidu.mobads.sdk.internal.bq;
import com.baidu.mobads.sdk.internal.concrete.RVAdapterDelegate;
import com.baidu.mobads.sdk.internal.concrete.RVViewHolderDelegate;
import com.baidu.mobads.sdk.internal.concrete.ViewCompatDelegate;
import com.baidu.mobads.sdk.internal.concrete.ViewPager2Delegate;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class b implements com.baidu.mobads.sdk.internal.a.a {

    /* renamed from: a */
    public static final String f5482a = "ViewPager2";

    /* renamed from: b */
    public static final String f5483b = "RVAdapter";

    /* renamed from: c */
    public static final String f5484c = "RVViewHolder";

    /* renamed from: d */
    public static final String f5485d = "ViewCompat";

    /* renamed from: e */
    public static final String f5486e = "p_e";

    /* renamed from: f */
    private static final String f5487f = "p_init";

    /* renamed from: g */
    private static final String f5488g = "p_set_class";

    /* renamed from: h */
    private static final String f5489h = "e_t";

    /* renamed from: i */
    private static final String f5490i = "e_n";

    /* renamed from: j */
    private static final String f5491j = "e_a";
    private static final String k = "e_r";
    private static final String l = "e_d";
    private final IAdInterListener m;

    public static class a implements IOAdEventListener {
        private com.baidu.mobads.sdk.internal.a.a a(String str, @NonNull IAdInterListener iAdInterListener, Object[] objArr) {
            if (b.f5482a.equals(str) && b.a(objArr, (Class<?>[]) new Class[]{Context.class})) {
                return new ViewPager2Delegate(iAdInterListener, (Context) objArr[0]);
            }
            if (b.f5483b.equals(str)) {
                return new RVAdapterDelegate(iAdInterListener);
            }
            if (b.f5484c.equals(str) && b.a(objArr, (Class<?>[]) new Class[]{View.class})) {
                return new RVViewHolderDelegate(iAdInterListener, (View) objArr[0]);
            }
            if (b.f5485d.equals(str)) {
                return new ViewCompatDelegate(iAdInterListener);
            }
            return null;
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEventListener
        public void run(IOAdEvent iOAdEvent) {
            Map<String, Object> data;
            com.baidu.mobads.sdk.internal.a.a a2;
            if (iOAdEvent != null) {
                try {
                    if (b.f5486e.equals(iOAdEvent.getType()) && (data = iOAdEvent.getData()) != null && !data.isEmpty()) {
                        Object obj = data.get(b.f5489h);
                        Object obj2 = data.get(b.f5490i);
                        Object obj3 = data.get(b.f5491j);
                        Object[] objArr = obj3 instanceof Object[] ? (Object[]) obj3 : null;
                        if ((obj2 instanceof String) && (obj instanceof String)) {
                            if (b.f5487f.equals((String) obj2)) {
                                Object obj4 = data.get(b.l);
                                if (!(obj4 instanceof IAdInterListener) || (a2 = a((String) obj, (IAdInterListener) obj4, objArr)) == null) {
                                    return;
                                }
                                data.put(b.k, a2);
                                return;
                            }
                            if (b.f5488g.equals((String) obj2) && (obj3 instanceof Map)) {
                                Map map = (Map) obj3;
                                map.put(b.f5482a, ViewPager2.class);
                                map.put(b.f5483b, RecyclerView.Adapter.class);
                                map.put(b.f5484c, RecyclerView.ViewHolder.class);
                            }
                        }
                    }
                } catch (Throwable th) {
                    bq.a().b(th.getMessage());
                }
            }
        }
    }

    private b(@NonNull IAdInterListener iAdInterListener, @NonNull com.baidu.mobads.sdk.internal.a.a aVar) {
        this.m = iAdInterListener;
        iAdInterListener.addEventListener(f5486e, new c(this, aVar));
    }

    public static b a(@NonNull IAdInterListener iAdInterListener, @NonNull com.baidu.mobads.sdk.internal.a.a aVar) {
        return new b(iAdInterListener, aVar);
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    @NonNull
    public IAdInterListener getDelegator() {
        return this.m;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        return this.m;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public final Object handleEvent(String str, String str2, Object[] objArr) {
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
    }

    public final void a(String str) {
        this.m.onAdTaskProcess(str);
    }

    public final Object a(String str, Object... objArr) {
        HashMap hashMap = new HashMap();
        hashMap.put(f5491j, objArr);
        this.m.onAdTaskProcess(str, hashMap);
        return hashMap.get(k);
    }

    public static boolean a(Object[] objArr, Class<?>... clsArr) {
        boolean z = objArr == null || objArr.length == 0;
        boolean z2 = clsArr == null || clsArr.length == 0;
        if (z && z2) {
            return true;
        }
        if (z || z2 || clsArr == null || objArr == null || clsArr.length != objArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < clsArr.length; i2++) {
            if (!clsArr[i2].isInstance(objArr[i2])) {
                return false;
            }
        }
        return true;
    }
}
