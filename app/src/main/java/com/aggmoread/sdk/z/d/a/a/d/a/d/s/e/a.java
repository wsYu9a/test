package com.aggmoread.sdk.z.d.a.a.d.a.d.s.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.aggmoread.sdk.z.d.a.a.c.o.f;
import com.aggmoread.sdk.z.d.a.a.d.b.d;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.l;
import com.aggmoread.sdk.z.d.a.a.e.m;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class a extends b {
    public a(TTFeedAd tTFeedAd, d dVar, e eVar, Map<String, Object> map) {
        super(tTFeedAd, dVar, eVar, map);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.s.e.b, com.aggmoread.sdk.z.d.a.a.d.a.d.d
    public View a(@NonNull Context context, @NonNull View view, FrameLayout.LayoutParams layoutParams, List<View> list, View view2, List<View> list2, View view3, @NonNull f.a aVar) {
        View view4 = view3;
        com.aggmoread.sdk.z.d.a.a.e.e.b("CSJUNAD", "esp enter v = " + view + ", r = " + view4);
        List<View> arrayList = list == null ? new ArrayList() : list;
        if (view4 == null) {
            view4 = view;
        }
        com.aggmoread.sdk.z.d.a.a.e.e.b("CSJUNAD", arrayList.contains(view4) ? "ovov + true" : "ovov + false");
        if (m.a(this.f5276i) && !arrayList.contains(view4)) {
            com.aggmoread.sdk.z.d.a.a.e.e.b("CSJUNAD", "ovov ");
            arrayList.add(view4);
        }
        this.f5274g = aVar;
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        com.aggmoread.sdk.z.d.a.a.e.e.b("CSJUNAD", "esp nativ");
        l.a(view, this.f5281n);
        a(context, (ViewGroup) view, layoutParams, arrayList, null, aVar);
        View[] viewArr = view2 != null ? new View[]{view2} : new View[0];
        this.f5322s = new WeakReference<>(view);
        a(view, viewArr);
        com.aggmoread.sdk.z.d.a.a.e.e.b("CSJUNAD", r3.d.A);
        return view;
    }
}
