package com.aggmoread.sdk.z.d.a.a.d.a.d.q.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.aggmoread.sdk.z.d.a.a.c.o.f;
import com.aggmoread.sdk.z.d.a.a.d.b.l;
import com.aggmoread.sdk.z.d.a.a.e.m;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.NativeResponse;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class a extends d {
    public a(NativeResponse nativeResponse, BaiduNativeManager baiduNativeManager, com.aggmoread.sdk.z.d.a.a.d.b.d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar, Map<String, Object> map) {
        super(nativeResponse, baiduNativeManager, dVar, eVar, map);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.q.e.d, com.aggmoread.sdk.z.d.a.a.d.a.d.d
    public View a(@NonNull Context context, @NonNull View view, FrameLayout.LayoutParams layoutParams, List<View> list, View view2, List<View> list2, View view3, @NonNull f.a aVar) {
        String str;
        String str2;
        View view4 = view3;
        com.aggmoread.sdk.z.d.a.a.e.e.b(d.f5483y, "esp enter v = " + view + ", r = " + view4);
        List<View> arrayList = list == null ? new ArrayList() : list;
        if (view4 == null) {
            view4 = view;
        }
        if (arrayList.contains(view4)) {
            str = d.f5483y;
            str2 = "ovov + true";
        } else {
            str = d.f5483y;
            str2 = "ovov + false";
        }
        com.aggmoread.sdk.z.d.a.a.e.e.b(str, str2);
        if (m.a(this.f5276i) && !arrayList.contains(view4)) {
            com.aggmoread.sdk.z.d.a.a.e.e.b(d.f5483y, "ovov ");
            arrayList.add(view4);
        }
        this.f5274g = aVar;
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        com.aggmoread.sdk.z.d.a.a.e.e.b(d.f5483y, "esp nativ");
        l.a(view, this.f5281n);
        a(context, (ViewGroup) view, layoutParams, arrayList, list2, (WeakReference<com.aggmoread.sdk.z.d.a.a.d.b.m.a>) null, aVar);
        View[] viewArr = view2 != null ? new View[]{view2} : new View[0];
        this.f5322s = new WeakReference<>(view);
        a(view, viewArr);
        com.aggmoread.sdk.z.d.a.a.e.e.b(d.f5483y, r3.d.A);
        return view;
    }
}
