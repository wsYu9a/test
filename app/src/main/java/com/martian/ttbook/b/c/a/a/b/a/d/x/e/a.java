package com.martian.ttbook.b.c.a.a.b.a.d.x.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.martian.ttbook.b.c.a.a.c.l.d;
import com.martian.ttbook.b.c.a.a.d.b.l;
import com.martian.ttbook.b.c.a.a.e.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class a extends d {
    public a(NativeResponse nativeResponse, BaiduNativeManager baiduNativeManager, com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar, Map<String, Object> map) {
        super(nativeResponse, baiduNativeManager, dVar, eVar, map);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.x.e.d
    public View m(@NonNull Context context, @NonNull View view, FrameLayout.LayoutParams layoutParams, List<View> list, View view2, View view3, @NonNull d.a aVar) {
        String str;
        String str2;
        com.martian.ttbook.b.c.a.a.e.d.g(d.m, "esp enter v = " + view + ", r = " + view3);
        if (list == null) {
            list = new ArrayList<>();
        }
        List<View> list2 = list;
        if (view3 == null) {
            view3 = view;
        }
        if (list2.contains(view3)) {
            str = d.m;
            str2 = "ovov + true";
        } else {
            str = d.m;
            str2 = "ovov + false";
        }
        com.martian.ttbook.b.c.a.a.e.d.g(str, str2);
        if (i.g(this.f15213d) && !list2.contains(view3)) {
            com.martian.ttbook.b.c.a.a.e.d.g(d.m, "ovov ");
            list2.add(view3);
        }
        this.f15211b = aVar;
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        com.martian.ttbook.b.c.a.a.e.d.g(d.m, "esp nativ");
        l.c(view, this.f15218j);
        q(context, (ViewGroup) view, layoutParams, list2, null, aVar);
        View[] viewArr = view2 != null ? new View[]{view2} : new View[0];
        this.r = new WeakReference<>(view);
        r(view, viewArr);
        com.martian.ttbook.b.c.a.a.e.d.g(d.m, "exit");
        return view;
    }
}
