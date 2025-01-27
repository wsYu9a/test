package com.martian.ttbook.b.c.a.a.b.a.d.y.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.martian.ttbook.b.c.a.a.c.l.d;
import com.martian.ttbook.b.c.a.a.d.b.l;
import com.martian.ttbook.b.c.a.a.e.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class b extends e {
    public b(TTFeedAd tTFeedAd, com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar, Map<String, Object> map) {
        super(tTFeedAd, dVar, eVar, map);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.y.e.e
    public View j(@NonNull Context context, @NonNull View view, FrameLayout.LayoutParams layoutParams, List<View> list, View view2, View view3, @NonNull d.a aVar) {
        View view4 = view3;
        com.martian.ttbook.b.c.a.a.e.d.g("CSJUNAD", "esp enter v = " + view + ", r = " + view4);
        List<View> arrayList = list == null ? new ArrayList() : list;
        if (view4 == null) {
            view4 = view;
        }
        com.martian.ttbook.b.c.a.a.e.d.g("CSJUNAD", arrayList.contains(view4) ? "ovov + true" : "ovov + false");
        if (i.g(this.f15213d) && !arrayList.contains(view4)) {
            com.martian.ttbook.b.c.a.a.e.d.g("CSJUNAD", "ovov ");
            arrayList.add(view4);
        }
        this.f15211b = aVar;
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        com.martian.ttbook.b.c.a.a.e.d.g("CSJUNAD", "esp nativ");
        l.c(view, this.f15218j);
        m(context, (ViewGroup) view, layoutParams, arrayList, null, aVar);
        View[] viewArr = view2 != null ? new View[]{view2} : new View[0];
        this.r = new WeakReference<>(view);
        o(view, viewArr);
        com.martian.ttbook.b.c.a.a.e.d.g("CSJUNAD", "exit");
        return view;
    }
}
