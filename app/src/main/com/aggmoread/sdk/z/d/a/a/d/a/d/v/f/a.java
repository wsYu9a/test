package com.aggmoread.sdk.z.d.a.a.d.a.d.v.f;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.aggmoread.sdk.z.d.a.a.c.o.f;
import com.aggmoread.sdk.z.d.a.a.d.b.l;
import com.aggmoread.sdk.z.d.a.a.e.m;
import com.kwad.sdk.api.KsNativeAd;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class a extends d {
    public a(KsNativeAd ksNativeAd, com.aggmoread.sdk.z.d.a.a.d.b.d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar, Map<String, Object> map) {
        super(ksNativeAd, dVar, eVar, map);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.v.f.d, com.aggmoread.sdk.z.d.a.a.d.a.d.d
    public View a(@NonNull Context context, @NonNull View view, FrameLayout.LayoutParams layoutParams, List<View> list, View view2, List<View> list2, View view3, @NonNull f.a aVar) {
        String str;
        String str2;
        com.aggmoread.sdk.z.d.a.a.e.e.b(d.f5766x, "esp enter v = " + view + ", r = " + view3);
        if (list == null) {
            list = new ArrayList<>();
        }
        List<View> list3 = list;
        if (view3 == null) {
            view3 = view;
        }
        if (list3.contains(view3)) {
            str = d.f5766x;
            str2 = "ovov + true";
        } else {
            str = d.f5766x;
            str2 = "ovov + false";
        }
        com.aggmoread.sdk.z.d.a.a.e.e.b(str, str2);
        if (m.a(this.f5276i) && !list3.contains(view3)) {
            com.aggmoread.sdk.z.d.a.a.e.e.b(d.f5766x, "ovov ");
            list3.add(view3);
        }
        this.f5274g = aVar;
        if (!(view instanceof NativeAdContainer)) {
            return null;
        }
        com.aggmoread.sdk.z.d.a.a.e.e.b(d.f5766x, "esp nativ");
        l.a(view, this.f5281n);
        a(context, (NativeAdContainer) view, layoutParams, list3, null, aVar);
        View[] viewArr = view2 != null ? new View[]{view2} : new View[0];
        this.f5322s = new WeakReference<>(view);
        a(view, viewArr);
        com.aggmoread.sdk.z.d.a.a.e.e.b(d.f5766x, r3.d.A);
        return view;
    }
}
