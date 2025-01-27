package com.martian.ttbook.b.c.a.a.b.a.d.b.b;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.martian.ttbook.b.c.a.a.c.l.d;
import com.martian.ttbook.b.c.a.a.d.b.d;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.l;
import com.martian.ttbook.b.c.a.a.e.i;
import com.umeng.union.UMNativeAD;
import com.umeng.union.widget.UMNativeLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class a extends b {
    public a(UMNativeAD uMNativeAD, d dVar, e eVar, Map<String, Object> map) {
        super(uMNativeAD, dVar, eVar, map);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.b.b.b
    public View j(@NonNull Context context, @NonNull View view, FrameLayout.LayoutParams layoutParams, List<View> list, View view2, View view3, @NonNull d.a aVar) {
        String str;
        String str2;
        com.martian.ttbook.b.c.a.a.e.d.g(b.m, "esp enter v = " + view + ", r = " + view3);
        if (list == null) {
            list = new ArrayList<>();
        }
        if (view3 == null) {
            view3 = view;
        }
        if (list.contains(view3)) {
            str = b.m;
            str2 = "ovov + true";
        } else {
            str = b.m;
            str2 = "ovov + false";
        }
        com.martian.ttbook.b.c.a.a.e.d.g(str, str2);
        if (i.g(this.f15213d) && !list.contains(view3)) {
            com.martian.ttbook.b.c.a.a.e.d.g(b.m, "ovov ");
            list.add(view3);
        }
        this.f15211b = aVar;
        if (!(view instanceof UMNativeLayout)) {
            aVar.a(new com.martian.ttbook.b.c.a.a.d.b.i(-1001, "AdContainer must be UMNativeLayout！"));
            return null;
        }
        com.martian.ttbook.b.c.a.a.e.d.g(b.m, "esp nativ");
        l.c(view, this.f15218j);
        m(context, (UMNativeLayout) view, list, aVar);
        View[] viewArr = view2 != null ? new View[]{view2} : new View[0];
        this.q = new WeakReference<>(view);
        o(view, viewArr);
        com.martian.ttbook.b.c.a.a.e.d.g(b.m, "exit");
        return view;
    }
}
