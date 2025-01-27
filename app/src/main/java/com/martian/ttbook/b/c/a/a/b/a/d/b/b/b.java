package com.martian.ttbook.b.c.a.a.b.a.d.b.b;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.martian.ttbook.b.c.a.a.b.a.d.f;
import com.martian.ttbook.b.c.a.a.c.l.d;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.i;
import com.martian.ttbook.b.c.a.a.d.b.k;
import com.martian.ttbook.b.c.a.a.d.b.l;
import com.martian.ttbook.b.c.a.a.e.h;
import com.martian.ttbook.b.c.a.a.e.j;
import com.martian.ttbook.sdk.client.AdExtras;
import com.opos.acs.st.utils.ErrorContants;
import com.umeng.union.UMNativeAD;
import com.umeng.union.api.UMUnionApi;
import com.umeng.union.widget.UMNativeLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class b extends f {
    protected static String m = "UMUNITAG";
    private static final Object n = new Object();
    public UMNativeAD o;
    public WeakReference p;
    public WeakReference<View> q;
    private d.a r;
    private AtomicBoolean s;

    class a extends UMUnionApi.AdEventListener {

        /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.b.b.b$a$a */
        class RunnableC0297a implements Runnable {
            RunnableC0297a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.s();
            }
        }

        /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.b.b.b$a$b */
        class RunnableC0298b implements Runnable {
            RunnableC0298b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.r();
            }
        }

        class c implements Runnable {

            /* renamed from: a */
            final /* synthetic */ int f15282a;

            /* renamed from: b */
            final /* synthetic */ String f15283b;

            c(int i2, String str) {
                this.f15282a = i2;
                this.f15283b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.a(new i(this.f15282a, this.f15283b));
            }
        }

        a() {
        }

        public void a(View view) {
            j.c(new RunnableC0298b());
        }

        public void b(int i2, String str) {
            com.martian.ttbook.b.c.a.a.e.d.c(b.m, "onADError %s", i2 + str);
            j.c(new c(i2, str));
        }

        public void c() {
            j.c(new RunnableC0297a());
        }
    }

    public b(UMNativeAD uMNativeAD, com.martian.ttbook.b.c.a.a.d.b.d dVar, e eVar, Map<String, Object> map) {
        super(dVar, eVar, map);
        this.s = new AtomicBoolean();
        this.o = uMNativeAD;
        com.martian.ttbook.b.c.a.a.b.a.c cVar = dVar.t;
        this.l.put(AdExtras.EXTRA_ECPM, String.valueOf(uMNativeAD.getPrice()));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.martian.ttbook.b.c.a.a.d.b.m.a l(android.view.View r12, android.view.View r13, android.view.ViewGroup r14) {
        /*
            Method dump skipped, instructions count: 279
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.ttbook.b.c.a.a.b.a.d.b.b.b.l(android.view.View, android.view.View, android.view.ViewGroup):com.martian.ttbook.b.c.a.a.d.b.m.a");
    }

    public void r() {
        com.martian.ttbook.b.c.a.a.e.d.g(m, "onADClicked");
        this.f15214e++;
        k kVar = new k(this.f15212c, this.f15213d);
        k c2 = kVar.c(k.b.n, this.f15210a);
        e eVar = this.f15213d;
        WeakReference<com.martian.ttbook.b.c.a.a.d.b.m.a> weakReference = this.k;
        boolean g2 = c2.g(eVar, weakReference == null ? null : weakReference.get(), this.f15215f, this.f15218j);
        kVar.h();
        l.i(this.f15218j, false, true);
        if (g2) {
            this.r.onAdClicked();
        }
    }

    public void s() {
        if (this.s.compareAndSet(false, true)) {
            com.martian.ttbook.b.c.a.a.e.d.g(m, "onADExposed ");
            HashMap hashMap = new HashMap();
            this.f15215f = System.currentTimeMillis();
            hashMap.put(h.f15836a, this.f15213d.f15700b.d(e.c.f15716f, ErrorContants.NET_ERROR));
            l.i(this.f15218j, true, true);
            new k(this.f15212c, this.f15213d).a(5).c(k.b.n, this.f15210a).c(k.b.C, getTitle()).h();
            this.r.onAdExposed();
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public void b() {
        this.o.destroy();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.a
    public void c(com.martian.ttbook.b.c.a.a.b.a.c cVar) {
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.d
    public List<String> g() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(getImageUrl());
        return arrayList;
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.d
    public String getDesc() {
        return this.o.getContent();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.d
    public String getIconUrl() {
        return this.o.getIconUrl();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public String getImageUrl() {
        return this.o.getImageUrl();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.d
    public String getTitle() {
        return this.o.getTitle();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.d
    public View h(@NonNull Context context, @NonNull View view, Object obj, FrameLayout.LayoutParams layoutParams, List<View> list, View view2, @NonNull d.a aVar) {
        com.martian.ttbook.b.c.a.a.e.d.g(m, "enter tag " + obj);
        this.p = new WeakReference(obj);
        return k(context, view, layoutParams, list, view2, aVar);
    }

    public View j(@NonNull Context context, @NonNull View view, FrameLayout.LayoutParams layoutParams, List<View> list, View view2, View view3, @NonNull d.a aVar) {
        String str;
        String str2;
        com.martian.ttbook.b.c.a.a.e.d.g(m, "enter");
        if (list == null) {
            list = new ArrayList<>();
        }
        View view4 = view3 != null ? view3 : view;
        if (list.contains(view4)) {
            str = m;
            str2 = "ovov + true";
        } else {
            str = m;
            str2 = "ovov + false";
        }
        com.martian.ttbook.b.c.a.a.e.d.g(str, str2);
        this.f15211b = aVar;
        if (com.martian.ttbook.b.c.a.a.e.i.g(this.f15213d) && !list.contains(view4)) {
            com.martian.ttbook.b.c.a.a.e.d.g(m, "ovov ");
            list.add(view4);
        }
        UMNativeLayout uMNativeLayout = new UMNativeLayout(context);
        com.martian.ttbook.b.c.a.a.d.b.m.a l = l(view, view3, uMNativeLayout);
        m(context, uMNativeLayout, list, aVar);
        o(this.k.get(), view2 != null ? new View[]{view2} : new View[0]);
        return l;
    }

    public View k(@NonNull Context context, View view, FrameLayout.LayoutParams layoutParams, List<View> list, View view2, @NonNull d.a aVar) {
        return j(context, view, layoutParams, list, view2, null, aVar);
    }

    protected void m(Context context, UMNativeLayout uMNativeLayout, List<View> list, d.a aVar) {
        this.r = aVar;
        UMNativeAD uMNativeAD = this.o;
        if (uMNativeAD == null || uMNativeLayout == null) {
            return;
        }
        uMNativeAD.setAdEventListener(new a());
        this.o.bindView(context, uMNativeLayout, list);
    }

    protected void o(View view, View[] viewArr) {
        l.m(this.f15212c.f15668b, this.f15218j, com.martian.ttbook.b.c.a.a.c.h.INFORMATION_FLOW, view, viewArr, this.q, this.p);
        l.s(this.f15212c.f15668b, this.f15213d.e(), this.f15213d.b());
        byte[] h2 = this.f15212c.r.h();
        if (h2 != null) {
            l.j(this.f15212c.f15668b, h2);
        }
    }
}
