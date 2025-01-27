package com.martian.ttbook.b.c.a.a.b.a.d.a0.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.huawei.hms.ads.Image;
import com.huawei.hms.ads.VideoOperator;
import com.huawei.hms.ads.nativead.MediaView;
import com.huawei.hms.ads.nativead.NativeAd;
import com.huawei.hms.ads.nativead.NativeAdMonitor;
import com.huawei.hms.ads.nativead.NativeView;
import com.martian.ttbook.b.c.a.a.b.a.d.f;
import com.martian.ttbook.b.c.a.a.c.h;
import com.martian.ttbook.b.c.a.a.c.l.d;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.k;
import com.martian.ttbook.b.c.a.a.d.b.l;
import com.martian.ttbook.b.c.a.a.e.i;
import com.martian.ttbook.sdk.client.AdExtras;
import com.opos.acs.st.utils.ErrorContants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class b extends f {
    protected static String m = "HWUNITAG";
    private static final Object n = new Object();
    private static final Object o = new Object();
    public NativeAd p;
    private NativeAdMonitor q;
    private VideoOperator r;
    public WeakReference s;
    public WeakReference<View> t;
    private d.a u;
    private AtomicBoolean v;

    class a extends VideoOperator.VideoLifecycleListener {

        /* renamed from: a */
        final /* synthetic */ com.martian.ttbook.b.c.a.a.c.q.a f15265a;

        a(b bVar, com.martian.ttbook.b.c.a.a.c.q.a aVar) {
            this.f15265a = aVar;
        }

        public void a() {
            this.f15265a.onVideoCompleted();
        }

        public void b(boolean z) {
        }

        public void c() {
            this.f15265a.onVideoPause();
        }

        public void d() {
            this.f15265a.onVideoResume();
        }

        public void e() {
            this.f15265a.onVideoStart();
        }
    }

    public b(NativeAd nativeAd, com.martian.ttbook.b.c.a.a.d.b.d dVar, e eVar, Map<String, Object> map) {
        super(dVar, eVar, map);
        this.v = new AtomicBoolean();
        this.p = nativeAd;
        com.martian.ttbook.b.c.a.a.b.a.c cVar = dVar.t;
        this.r = nativeAd.getVideoOperator();
        this.l.put(AdExtras.EXTRA_ECPM, nativeAd.getPrice());
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
        throw new UnsupportedOperationException("Method not decompiled: com.martian.ttbook.b.c.a.a.b.a.d.a0.b.b.l(android.view.View, android.view.View, android.view.ViewGroup):com.martian.ttbook.b.c.a.a.d.b.m.a");
    }

    private void p(NativeView nativeView, com.martian.ttbook.b.c.a.a.c.q.a aVar) {
        if (nativeView != null) {
            this.r.setVideoLifecycleListener(new a(this, aVar));
            nativeView.getMediaView().setMediaContent(this.p.getMediaContent());
            nativeView.setNativeAd(this.p);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public void a(View view) {
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public void b() {
        this.p.destroy();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.a
    public void c(com.martian.ttbook.b.c.a.a.b.a.c cVar) {
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.d
    public List<String> g() {
        ArrayList arrayList = new ArrayList();
        List images = this.p.getImages();
        if (images != null) {
            for (int i2 = 0; i2 < images.size(); i2++) {
                arrayList.add(((Image) images.get(i2)).getUri().toString());
            }
        }
        return arrayList;
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.d
    public String getDesc() {
        return this.p.getDescription();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.d
    public String getIconUrl() {
        Image icon = this.p.getIcon();
        return icon != null ? icon.getUri().toString() : "";
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public String getImageUrl() {
        List<String> g2 = g();
        return (g2 == null || g2.size() <= 0) ? "" : g2.get(0);
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.d
    public String getTitle() {
        return this.p.getTitle();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.d
    public View h(@NonNull Context context, @NonNull View view, Object obj, FrameLayout.LayoutParams layoutParams, List<View> list, View view2, @NonNull d.a aVar) {
        com.martian.ttbook.b.c.a.a.e.d.g(m, "enter tag " + obj);
        this.s = new WeakReference(obj);
        return k(context, view, layoutParams, list, view2, aVar);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public boolean isVideoAd() {
        VideoOperator videoOperator = this.r;
        if (videoOperator == null || !videoOperator.hasVideo()) {
            return super.isVideoAd();
        }
        com.martian.ttbook.b.c.a.a.e.d.g(m, "isVideoAd true");
        return true;
    }

    public View j(@NonNull Context context, @NonNull View view, FrameLayout.LayoutParams layoutParams, List<View> list, View view2, View view3, @NonNull d.a aVar) {
        String str;
        String str2;
        com.martian.ttbook.b.c.a.a.e.d.g(m, "enter");
        if (list == null) {
            list = new ArrayList<>();
        }
        List<View> list2 = list;
        View view4 = view3 != null ? view3 : view;
        if (list2.contains(view4)) {
            str = m;
            str2 = "ovov + true";
        } else {
            str = m;
            str2 = "ovov + false";
        }
        com.martian.ttbook.b.c.a.a.e.d.g(str, str2);
        this.f15211b = aVar;
        if (i.g(this.f15213d) && !list2.contains(view4)) {
            com.martian.ttbook.b.c.a.a.e.d.g(m, "ovov ");
            list2.add(view4);
        }
        FrameLayout frameLayout = new FrameLayout(context);
        com.martian.ttbook.b.c.a.a.d.b.m.a l = l(view, view3, frameLayout);
        m(context, frameLayout, layoutParams, list2, this.k, aVar);
        o(this.k.get(), view2 != null ? new View[]{view2} : new View[0]);
        return l;
    }

    public View k(@NonNull Context context, View view, FrameLayout.LayoutParams layoutParams, List<View> list, View view2, @NonNull d.a aVar) {
        return j(context, view, layoutParams, list, view2, null, aVar);
    }

    protected void m(Context context, ViewGroup viewGroup, FrameLayout.LayoutParams layoutParams, List<View> list, WeakReference<com.martian.ttbook.b.c.a.a.d.b.m.a> weakReference, d.a aVar) {
        this.u = aVar;
        if (this.p == null || viewGroup == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        for (int i2 = 0; i2 < list.size(); i2++) {
            hashMap.put(i2 + "", list.get(i2));
        }
        if (this.q == null) {
            NativeAdMonitor nativeAdMonitor = new NativeAdMonitor(viewGroup, hashMap, hashMap2);
            this.q = nativeAdMonitor;
            nativeAdMonitor.setNativeAd(this.p);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public void n(@NonNull ViewGroup viewGroup, com.martian.ttbook.b.c.a.a.c.q.a aVar) {
        com.martian.ttbook.b.c.a.a.e.d.g(m, "ENTER");
        if (viewGroup != null) {
            Object obj = o;
            NativeView findViewWithTag = viewGroup.findViewWithTag(obj);
            if (findViewWithTag == null) {
                findViewWithTag = new NativeView(viewGroup.getContext());
                MediaView mediaView = new MediaView(viewGroup.getContext());
                findViewWithTag.addView(mediaView);
                findViewWithTag.setMediaView(mediaView);
                findViewWithTag.setTag(obj);
                viewGroup.addView((View) findViewWithTag, new ViewGroup.LayoutParams(-1, -1));
            }
            p(findViewWithTag, aVar);
        }
    }

    protected void o(View view, View[] viewArr) {
        l.m(this.f15212c.f15668b, this.f15218j, h.INFORMATION_FLOW, view, viewArr, this.t, this.s);
        l.s(this.f15212c.f15668b, this.f15213d.e(), this.f15213d.b());
        byte[] h2 = this.f15212c.r.h();
        if (h2 != null) {
            l.j(this.f15212c.f15668b, h2);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public void pauseVideo() {
        this.r.pause();
    }

    public void q() {
        if (this.v.compareAndSet(false, true)) {
            com.martian.ttbook.b.c.a.a.e.d.g(m, "onADExposed ");
            HashMap hashMap = new HashMap();
            this.f15215f = System.currentTimeMillis();
            hashMap.put(com.martian.ttbook.b.c.a.a.e.h.f15836a, this.f15213d.f15700b.d(e.c.f15716f, ErrorContants.NET_ERROR));
            l.i(this.f15218j, true, true);
            new k(this.f15212c, this.f15213d).a(5).c(k.b.n, this.f15210a).c(k.b.C, getTitle()).h();
            this.u.onAdExposed();
        }
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
            this.u.onAdClicked();
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public void resumeVideo() {
        this.r.play();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public void stopVideo() {
        this.r.stop();
    }
}
