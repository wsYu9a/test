package com.martian.ttbook.b.c.a.a.d.a.d.x.e;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.martian.ttbook.b.c.a.a.c.l.d;
import com.martian.ttbook.b.c.a.a.d.b.i;
import com.martian.ttbook.b.c.a.a.d.b.l;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class a extends e {
    public a(NativeUnifiedADData nativeUnifiedADData, NativeUnifiedAD nativeUnifiedAD, com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar, Map<String, Object> map, int i2) {
        super(nativeUnifiedADData, nativeUnifiedAD, dVar, eVar, map, i2);
    }

    @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.e.e
    public View j(@NonNull Context context, @NonNull View view, FrameLayout.LayoutParams layoutParams, List<View> list, View view2, View view3, @NonNull d.a aVar) {
        String str;
        String str2;
        View view4 = view3;
        com.martian.ttbook.b.c.a.a.e.d.g(e.m, "esp enter v = " + view + ", r = " + view3);
        if (this.q == 91) {
            a(new i(30000018, "GDT ad blocked"));
            return null;
        }
        List<View> arrayList = list == null ? new ArrayList() : list;
        if (view4 == null) {
            view4 = view;
        }
        if (arrayList.contains(view4)) {
            str = e.m;
            str2 = "ovov + true";
        } else {
            str = e.m;
            str2 = "ovov + false";
        }
        com.martian.ttbook.b.c.a.a.e.d.g(str, str2);
        if (com.martian.ttbook.b.c.a.a.e.i.g(this.f15213d) && !arrayList.contains(view4)) {
            com.martian.ttbook.b.c.a.a.e.d.g(e.m, "ovov ");
            arrayList.add(view4);
        }
        this.f15211b = aVar;
        if (!(view instanceof NativeAdContainer)) {
            return null;
        }
        com.martian.ttbook.b.c.a.a.e.d.g(e.m, "esp nativ");
        l.c(view, this.f15218j);
        m(context, (NativeAdContainer) view, layoutParams, arrayList, null, aVar);
        View[] viewArr = view2 != null ? new View[]{view2} : new View[0];
        this.s = new WeakReference<>(view);
        o(view, viewArr);
        com.martian.ttbook.b.c.a.a.e.d.g(e.m, "exit");
        return view;
    }
}
