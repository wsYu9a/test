package com.martian.ttbook.b.c.a.a.b.a.d.a.c;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.martian.ttbook.b.c.a.a.b.a.d.f;
import com.martian.ttbook.b.c.a.a.c.l.d;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.k;
import com.martian.ttbook.b.c.a.a.d.b.l;
import com.martian.ttbook.b.c.a.a.e.h;
import com.martian.ttbook.b.c.a.a.e.i;
import com.opos.acs.st.utils.ErrorContants;
import com.qq.e.ads.nativ.MediaView;
import com.qumeng.advlib.core.AppInformation;
import com.qumeng.advlib.core.IMultiAdObject;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class d extends f {
    protected static String m = "QMUNITAG";
    private static final Object n = new Object();
    private static final Object o = new Object();
    public IMultiAdObject p;
    public WeakReference q;
    public WeakReference<View> r;
    private Pair<Integer, Integer> s;

    class a implements IMultiAdObject.ADEventListener {

        /* renamed from: a */
        final /* synthetic */ WeakReference f15231a;

        /* renamed from: b */
        final /* synthetic */ d.a f15232b;

        a(WeakReference weakReference, d.a aVar) {
            this.f15231a = weakReference;
            this.f15232b = aVar;
        }

        public void a() {
            com.martian.ttbook.b.c.a.a.e.d.g(d.m, "onADExposed ");
            HashMap hashMap = new HashMap();
            d.this.f15215f = System.currentTimeMillis();
            hashMap.put(h.f15836a, d.this.f15213d.f15700b.d(e.c.f15716f, ErrorContants.NET_ERROR));
            l.i(d.this.f15218j, true, true);
            d dVar = d.this;
            new k(dVar.f15212c, dVar.f15213d).a(5).c(k.b.n, d.this.f15210a).c(k.b.C, d.this.getTitle()).h();
            this.f15232b.onAdExposed();
        }

        public void b() {
            com.martian.ttbook.b.c.a.a.e.d.g(d.m, "onADClicked");
            d dVar = d.this;
            dVar.f15214e++;
            k kVar = new k(dVar.f15212c, dVar.f15213d);
            k c2 = kVar.c(k.b.n, d.this.f15210a);
            com.martian.ttbook.b.c.a.a.d.b.e eVar = d.this.f15213d;
            WeakReference weakReference = this.f15231a;
            com.martian.ttbook.b.c.a.a.d.b.m.a aVar = weakReference == null ? null : (com.martian.ttbook.b.c.a.a.d.b.m.a) weakReference.get();
            d dVar2 = d.this;
            boolean g2 = c2.g(eVar, aVar, dVar2.f15215f, dVar2.f15218j);
            kVar.h();
            l.i(d.this.f15218j, false, true);
            if (g2) {
                this.f15232b.onAdClicked();
            }
        }

        public void c(String str) {
            com.martian.ttbook.b.c.a.a.e.d.g(d.m, "onAdFailed " + str);
        }
    }

    class b implements IMultiAdObject.MediaStateListener {

        /* renamed from: a */
        final /* synthetic */ com.martian.ttbook.b.c.a.a.c.q.a f15234a;

        b(d dVar, com.martian.ttbook.b.c.a.a.c.q.a aVar) {
            this.f15234a = aVar;
        }

        public void a() {
            com.martian.ttbook.b.c.a.a.e.d.g(d.m, "onVideoCompleted ");
            com.martian.ttbook.b.c.a.a.c.q.a aVar = this.f15234a;
            if (aVar != null) {
                aVar.onVideoCompleted();
            }
        }

        public void b() {
            com.martian.ttbook.b.c.a.a.e.d.g(d.m, "onVideoPause ");
            com.martian.ttbook.b.c.a.a.c.q.a aVar = this.f15234a;
            if (aVar != null) {
                aVar.onVideoPause();
            }
        }

        public void c() {
            com.martian.ttbook.b.c.a.a.e.d.g(d.m, "onVideoReady ");
            com.martian.ttbook.b.c.a.a.c.q.a aVar = this.f15234a;
            if (aVar != null) {
                aVar.onVideoReady();
            }
        }

        public void d() {
            com.martian.ttbook.b.c.a.a.e.d.g(d.m, "onVideoResume ");
            com.martian.ttbook.b.c.a.a.c.q.a aVar = this.f15234a;
            if (aVar != null) {
                aVar.onVideoResume();
            }
        }

        public void e() {
            com.martian.ttbook.b.c.a.a.e.d.g(d.m, "onVideoStart ");
            com.martian.ttbook.b.c.a.a.c.q.a aVar = this.f15234a;
            if (aVar != null) {
                aVar.onVideoStart();
            }
        }

        public void f() {
            com.martian.ttbook.b.c.a.a.e.d.g(d.m, "onVideoStop ");
            com.martian.ttbook.b.c.a.a.c.q.a aVar = this.f15234a;
            if (aVar != null) {
                aVar.onVideoStop();
            }
        }
    }

    public d(IMultiAdObject iMultiAdObject, com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar, Map<String, Object> map) {
        super(dVar, eVar, map);
        this.p = iMultiAdObject;
        com.martian.ttbook.b.c.a.a.b.a.c cVar = dVar.t;
        this.s = iMultiAdObject.getMediaSize();
        com.martian.ttbook.b.c.a.a.b.a.d.a.b.g(this.l, com.martian.ttbook.b.c.a.a.b.a.d.a.b.c(iMultiAdObject), eVar);
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
        throw new UnsupportedOperationException("Method not decompiled: com.martian.ttbook.b.c.a.a.b.a.d.a.c.d.l(android.view.View, android.view.View, android.view.ViewGroup):com.martian.ttbook.b.c.a.a.d.b.m.a");
    }

    private void p(MediaView mediaView, com.martian.ttbook.b.c.a.a.c.q.a aVar) {
        if (mediaView != null) {
            mediaView.removeAllViews();
            this.p.setOnMediaStateListener(new b(this, aVar));
            mediaView.addView(this.p.getVideoView(mediaView.getContext()));
        }
    }

    private com.martian.ttbook.b.c.a.a.c.c q() {
        String str;
        String str2;
        String str3;
        String str4;
        try {
            AppInformation appInformation = this.p.getAppInformation();
            String appName = this.p.getAppName();
            if (appInformation != null) {
                String developers = appInformation.getDevelopers();
                String appVersion = appInformation.getAppVersion();
                String permissionProtocolUrl = appInformation.getPermissionProtocolUrl();
                str3 = appInformation.getPrivacyProtocolUrl();
                str4 = appVersion;
                str2 = permissionProtocolUrl;
                str = developers;
            } else {
                str = "";
                str2 = str;
                str3 = str2;
                str4 = str3;
            }
            return com.martian.ttbook.b.c.a.a.c.c.a(appName, str, -1L, str2, str3, str4);
        } catch (Exception e2) {
            com.martian.ttbook.b.c.a.a.e.d.g(m, "err " + e2);
            return null;
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public void b() {
        IMultiAdObject iMultiAdObject = this.p;
        if (iMultiAdObject != null) {
            iMultiAdObject.destroy();
            this.p = null;
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.a
    public void c(com.martian.ttbook.b.c.a.a.b.a.c cVar) {
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public com.martian.ttbook.b.c.a.a.c.c d() {
        return q();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public int e() {
        Pair<Integer, Integer> pair = this.s;
        return pair != null ? ((Integer) pair.second).intValue() : super.e();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public int f() {
        Pair<Integer, Integer> pair = this.s;
        return pair != null ? ((Integer) pair.first).intValue() : super.f();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.d
    public List<String> g() {
        return this.p.getImageUrls();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public int getAdPatternType() {
        return com.martian.ttbook.b.c.a.a.b.a.d.a.b.b(this.p.getMaterialType());
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.d
    public String getDesc() {
        return this.p.getDesc();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.d
    public String getIconUrl() {
        return this.p.getAppLogoUrl();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public String getImageUrl() {
        List<String> g2 = g();
        if (g2 == null || g2.size() <= 0) {
            return null;
        }
        return g2.get(0);
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.d
    public String getTitle() {
        return this.p.getTitle();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.d
    public View h(@NonNull Context context, @NonNull View view, Object obj, FrameLayout.LayoutParams layoutParams, List<View> list, View view2, @NonNull d.a aVar) {
        com.martian.ttbook.b.c.a.a.e.d.g(m, "enter tag " + obj);
        this.q = new WeakReference(obj);
        return k(context, view, layoutParams, list, view2, aVar);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public boolean isAppAd() {
        return this.p.getInteractionType() == 2;
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public boolean isVideoAd() {
        return com.martian.ttbook.b.c.a.a.b.a.d.a.b.b(this.p.getMaterialType()) == 2;
    }

    public View j(@NonNull Context context, @NonNull View view, FrameLayout.LayoutParams layoutParams, List<View> list, View view2, View view3, @NonNull d.a aVar) {
        String str;
        String str2;
        com.martian.ttbook.b.c.a.a.e.d.g(m, "enter " + view);
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
        if (i.g(this.f15213d) && !list2.contains(view4)) {
            com.martian.ttbook.b.c.a.a.e.d.g(m, "ovov ");
            list2.add(view4);
        }
        this.f15211b = aVar;
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
        if (this.p == null || viewGroup == null) {
            return;
        }
        for (View view : list) {
            com.martian.ttbook.b.c.a.a.e.d.g(m, "clickView " + view);
        }
        this.p.bindEvent(viewGroup, list, new a(weakReference, aVar));
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public void n(@NonNull ViewGroup viewGroup, com.martian.ttbook.b.c.a.a.c.q.a aVar) {
        com.martian.ttbook.b.c.a.a.e.d.g(m, "ENTER");
        if (viewGroup != null) {
            Object obj = o;
            MediaView mediaView = (MediaView) viewGroup.findViewWithTag(obj);
            if (mediaView == null) {
                mediaView = new MediaView(viewGroup.getContext());
                mediaView.setTag(obj);
                viewGroup.addView(mediaView, new ViewGroup.LayoutParams(-1, -1));
            }
            p(mediaView, aVar);
        }
    }

    protected void o(View view, View[] viewArr) {
        l.m(this.f15212c.f15668b, this.f15218j, com.martian.ttbook.b.c.a.a.c.h.INFORMATION_FLOW, view, viewArr, this.r, this.q);
        l.s(this.f15212c.f15668b, this.f15213d.e(), this.f15213d.b());
        byte[] h2 = this.f15212c.r.h();
        if (h2 != null) {
            l.j(this.f15212c.f15668b, h2);
        }
    }
}
