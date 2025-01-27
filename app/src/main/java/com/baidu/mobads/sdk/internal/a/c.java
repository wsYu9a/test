package com.baidu.mobads.sdk.internal.a;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.baidu.mobads.sdk.internal.bt;
import com.baidu.mobads.sdk.internal.concrete.FragmentDelegate;
import com.baidu.mobads.sdk.internal.concrete.FragmentV4Delegate;
import com.baidu.mobads.sdk.internal.concrete.RLRecyclerViewDelegate;
import com.baidu.mobads.sdk.internal.concrete.RVAdapterDelegate;
import com.baidu.mobads.sdk.internal.concrete.RVViewHolderDelegate;
import com.baidu.mobads.sdk.internal.concrete.ViewCompatDelegate;
import com.baidu.mobads.sdk.internal.concrete.ViewPager2Delegate;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class c implements com.baidu.mobads.sdk.internal.a.a {

    /* renamed from: a */
    public static final String f6670a = "ViewPager2";

    /* renamed from: b */
    public static final String f6671b = "RVAdapter";

    /* renamed from: c */
    public static final String f6672c = "RVViewHolder";

    /* renamed from: d */
    public static final String f6673d = "ViewCompat";

    /* renamed from: e */
    public static final String f6674e = "Fragment";

    /* renamed from: f */
    public static final String f6675f = "FragmentV4";

    /* renamed from: g */
    public static final String f6676g = "RLRecyclerView";

    /* renamed from: h */
    public static final String f6677h = "p_e";

    /* renamed from: i */
    private static final String f6678i = "p_init";

    /* renamed from: j */
    private static final String f6679j = "p_set_class";

    /* renamed from: k */
    private static final String f6680k = "e_t";

    /* renamed from: l */
    private static final String f6681l = "e_n";

    /* renamed from: m */
    private static final String f6682m = "e_a";

    /* renamed from: n */
    private static final String f6683n = "e_r";

    /* renamed from: o */
    private static final String f6684o = "e_d";

    /* renamed from: p */
    private final IAdInterListener f6685p;

    public static class a implements IOAdEventListener {
        private com.baidu.mobads.sdk.internal.a.a a(String str, @NonNull IAdInterListener iAdInterListener, Object[] objArr) {
            if (c.f6670a.equals(str) && c.a(objArr, (Class<?>[]) new Class[]{Context.class})) {
                return new ViewPager2Delegate(iAdInterListener, (Context) objArr[0]);
            }
            if (c.f6671b.equals(str)) {
                return new RVAdapterDelegate(iAdInterListener);
            }
            if (c.f6672c.equals(str) && c.a(objArr, (Class<?>[]) new Class[]{View.class})) {
                return new RVViewHolderDelegate(iAdInterListener, (View) objArr[0]);
            }
            if (c.f6673d.equals(str)) {
                return new ViewCompatDelegate(iAdInterListener);
            }
            if (c.f6674e.equals(str)) {
                return new FragmentDelegate().setDispatcher(iAdInterListener);
            }
            if (c.f6675f.equals(str)) {
                return new FragmentV4Delegate().setDispatcher(iAdInterListener);
            }
            if (c.f6676g.equals(str)) {
                return new RLRecyclerViewDelegate(iAdInterListener, objArr);
            }
            return null;
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEventListener
        public void run(IOAdEvent iOAdEvent) {
            Map<String, Object> data;
            com.baidu.mobads.sdk.internal.a.a a10;
            if (iOAdEvent != null) {
                try {
                    if (c.f6677h.equals(iOAdEvent.getType()) && (data = iOAdEvent.getData()) != null && !data.isEmpty()) {
                        Object obj = data.get(c.f6680k);
                        Object obj2 = data.get(c.f6681l);
                        Object obj3 = data.get(c.f6682m);
                        Object[] objArr = obj3 instanceof Object[] ? (Object[]) obj3 : null;
                        if ((obj2 instanceof String) && (obj instanceof String)) {
                            if (c.f6678i.equals((String) obj2)) {
                                Object obj4 = data.get(c.f6684o);
                                if (!(obj4 instanceof IAdInterListener) || (a10 = a((String) obj, (IAdInterListener) obj4, objArr)) == null) {
                                    return;
                                }
                                data.put(c.f6683n, a10);
                                return;
                            }
                            if (c.f6679j.equals((String) obj2) && (obj3 instanceof Map)) {
                                Map map = (Map) obj3;
                                map.put(c.f6670a, ViewPager2.class);
                                map.put(c.f6671b, RecyclerView.Adapter.class);
                                map.put(c.f6672c, RecyclerView.ViewHolder.class);
                            }
                        }
                    }
                } catch (Throwable th2) {
                    bt.a().b(th2.getMessage());
                }
            }
        }
    }

    private c(@NonNull IAdInterListener iAdInterListener, @NonNull com.baidu.mobads.sdk.internal.a.a aVar) {
        this.f6685p = iAdInterListener;
        iAdInterListener.addEventListener(f6677h, new d(this, aVar));
    }

    public static c a(@NonNull IAdInterListener iAdInterListener, @NonNull com.baidu.mobads.sdk.internal.a.a aVar) {
        return new c(iAdInterListener, aVar);
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
        return this.f6685p;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        return this.f6685p;
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
        this.f6685p.onAdTaskProcess(str);
    }

    public final Object a(String str, Object... objArr) {
        HashMap hashMap = new HashMap();
        hashMap.put(f6682m, objArr);
        this.f6685p.onAdTaskProcess(str, hashMap);
        return hashMap.get(f6683n);
    }

    public static boolean a(Object[] objArr, Class<?>... clsArr) {
        boolean z10 = objArr == null || objArr.length == 0;
        boolean z11 = clsArr == null || clsArr.length == 0;
        if (z10 && z11) {
            return true;
        }
        if (z10 || z11 || clsArr == null || objArr == null || clsArr.length != objArr.length) {
            return false;
        }
        for (int i10 = 0; i10 < clsArr.length; i10++) {
            if (!clsArr[i10].isInstance(objArr[i10])) {
                return false;
            }
        }
        return true;
    }
}
