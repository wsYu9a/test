package com.martian.ttbook.b.c.a.a.b.a.d.b0.d;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import com.martian.ttbook.b.c.a.a.b.a.d.b0.d.f;
import com.martian.ttbook.b.c.a.a.c.l.d;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.i;
import com.martian.ttbook.b.c.a.a.d.b.k;
import com.martian.ttbook.b.c.a.a.d.b.l;
import com.martian.ttbook.b.c.a.a.e.h;
import com.opos.acs.st.utils.ErrorContants;
import com.qq.e.ads.nativ.MediaView;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class d extends com.martian.ttbook.b.c.a.a.b.a.d.f {
    protected static String m = "KSUNITAG";
    private static final Object n = new Object();
    private static final Object o = new Object();
    public KsNativeAd p;
    public WeakReference q;
    public WeakReference<View> r;

    class a implements KsAppDownloadListener {

        /* renamed from: a */
        final /* synthetic */ d.a f15319a;

        a(d dVar, d.a aVar) {
            this.f15319a = aVar;
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFailed() {
            d.a aVar = this.f15319a;
            if (aVar instanceof d.b) {
                ((d.b) aVar).onADStatusChanged(16);
            }
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFinished() {
            d.a aVar = this.f15319a;
            if (aVar instanceof d.b) {
                ((d.b) aVar).onADStatusChanged(8);
            }
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadStarted() {
            d.a aVar = this.f15319a;
            if (aVar instanceof d.b) {
                ((d.b) aVar).onADStatusChanged(4);
            }
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onIdle() {
            d.a aVar = this.f15319a;
            if (aVar instanceof d.b) {
                ((d.b) aVar).onADStatusChanged(0);
            }
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onInstalled() {
            d.a aVar = this.f15319a;
            if (aVar instanceof d.b) {
                ((d.b) aVar).onADStatusChanged(1);
            }
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onProgressUpdate(int i2) {
            com.martian.ttbook.b.c.a.a.e.d.g(d.m, "onADStatusChanged");
            d.a aVar = this.f15319a;
            if (aVar instanceof d.b) {
                ((d.b) aVar).onLoadApkProgress(i2);
            }
        }
    }

    class b implements e {

        /* renamed from: a */
        final /* synthetic */ WeakReference f15320a;

        /* renamed from: b */
        final /* synthetic */ d.a f15321b;

        b(WeakReference weakReference, d.a aVar) {
            this.f15320a = weakReference;
            this.f15321b = aVar;
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.b0.d.d.e
        public void a(KsNativeAd ksNativeAd) {
            com.martian.ttbook.b.c.a.a.e.d.g(d.m, "onADExposed ");
            HashMap hashMap = new HashMap();
            d.this.f15215f = System.currentTimeMillis();
            hashMap.put(h.f15836a, d.this.f15213d.f15700b.d(e.c.f15716f, ErrorContants.NET_ERROR));
            l.i(d.this.f15218j, true, true);
            d dVar = d.this;
            new k(dVar.f15212c, dVar.f15213d).a(5).c(k.b.n, d.this.f15210a).c(k.b.C, d.this.getTitle()).h();
            this.f15321b.onAdExposed();
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.b0.d.d.e
        public boolean b(DialogInterface.OnClickListener onClickListener) {
            return false;
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.b0.d.d.e
        public void c(View view, KsNativeAd ksNativeAd) {
            com.martian.ttbook.b.c.a.a.e.d.g(d.m, "onADClicked");
            d dVar = d.this;
            dVar.f15214e++;
            k kVar = new k(dVar.f15212c, dVar.f15213d);
            k c2 = kVar.c(k.b.n, d.this.f15210a);
            com.martian.ttbook.b.c.a.a.d.b.e eVar = d.this.f15213d;
            WeakReference weakReference = this.f15320a;
            com.martian.ttbook.b.c.a.a.d.b.m.a aVar = weakReference == null ? null : (com.martian.ttbook.b.c.a.a.d.b.m.a) weakReference.get();
            d dVar2 = d.this;
            boolean g2 = c2.g(eVar, aVar, dVar2.f15215f, dVar2.f15218j);
            kVar.h();
            l.i(d.this.f15218j, false, true);
            if (g2) {
                this.f15321b.onAdClicked();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.b0.d.d.e
        public void onDownloadTipsDialogDismiss() {
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.b0.d.d.e
        public void onDownloadTipsDialogShow() {
        }
    }

    class c implements f.a {

        /* renamed from: a */
        final /* synthetic */ com.martian.ttbook.b.c.a.a.c.q.a f15323a;

        c(d dVar, com.martian.ttbook.b.c.a.a.c.q.a aVar) {
            this.f15323a = aVar;
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.b0.d.f.a
        public void a() {
            this.f15323a.onVideoCompleted();
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.b0.d.f.a
        public void b() {
            this.f15323a.onVideoReady();
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.b0.d.f.a
        public void c() {
            this.f15323a.onVideoPause();
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.b0.d.f.a
        public void d() {
            this.f15323a.onVideoResume();
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.b0.d.f.a
        public void onVideoPlayError(int i2, int i3) {
            this.f15323a.a(new i(i2, "msg:" + i3));
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.b0.d.f.a
        public void onVideoPlayStart() {
            this.f15323a.onVideoStart();
        }
    }

    /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.b0.d.d$d */
    private class C0306d implements InvocationHandler {

        /* renamed from: a */
        private e f15324a;

        public C0306d(d dVar, e eVar) {
            this.f15324a = eVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            if ("onAdClicked".equals(name)) {
                this.f15324a.c((View) objArr[0], (KsNativeAd) objArr[1]);
                return null;
            }
            if ("onAdShow".equals(name)) {
                this.f15324a.a((KsNativeAd) objArr[0]);
                return null;
            }
            if ("handleDownloadDialog".equals(name)) {
                return Boolean.valueOf(this.f15324a.b((DialogInterface.OnClickListener) objArr[0]));
            }
            if ("onDownloadTipsDialogShow".equals(name)) {
                this.f15324a.onDownloadTipsDialogShow();
                return null;
            }
            if (!"onDownloadTipsDialogDismiss".equals(name)) {
                return null;
            }
            this.f15324a.onDownloadTipsDialogDismiss();
            return null;
        }
    }

    private interface e {
        void a(KsNativeAd ksNativeAd);

        boolean b(DialogInterface.OnClickListener onClickListener);

        void c(View view, KsNativeAd ksNativeAd);

        void onDownloadTipsDialogDismiss();

        void onDownloadTipsDialogShow();
    }

    public d(KsNativeAd ksNativeAd, com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar, Map<String, Object> map) {
        super(dVar, eVar, map);
        this.p = ksNativeAd;
        com.martian.ttbook.b.c.a.a.b.a.c cVar = dVar.t;
        com.martian.ttbook.b.c.a.a.b.a.d.b0.b.h(this.l, com.martian.ttbook.b.c.a.a.b.a.d.b0.b.b(ksNativeAd), eVar);
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
        throw new UnsupportedOperationException("Method not decompiled: com.martian.ttbook.b.c.a.a.b.a.d.b0.d.d.l(android.view.View, android.view.View, android.view.ViewGroup):com.martian.ttbook.b.c.a.a.d.b.m.a");
    }

    private void p(MediaView mediaView, com.martian.ttbook.b.c.a.a.c.q.a aVar) {
        if (mediaView != null) {
            mediaView.removeAllViews();
            this.p.setVideoPlayListener(new f().a(new c(this, aVar)));
            com.martian.ttbook.b.c.a.a.c.q.b bVar = this.f15212c.s;
            KsAdVideoPlayConfig ksAdVideoPlayConfig = null;
            if (bVar != null) {
                KsAdVideoPlayConfig.Builder builder = new KsAdVideoPlayConfig.Builder();
                builder.videoSoundEnable(!bVar.k());
                builder.dataFlowAutoStart(bVar.a() == 1);
                ksAdVideoPlayConfig = builder.build();
            }
            mediaView.addView(this.p.getVideoView(mediaView.getContext(), ksAdVideoPlayConfig));
        }
    }

    private com.martian.ttbook.b.c.a.a.c.c q() {
        try {
            return com.martian.ttbook.b.c.a.a.c.c.a(this.p.getAppName(), this.p.getProductName(), this.p.getAppPackageSize(), this.p.getPermissionInfoUrl(), this.p.getAppPrivacyUrl(), this.p.getAppVersion());
        } catch (Exception e2) {
            com.martian.ttbook.b.c.a.a.e.d.g(m, "err " + e2);
            return null;
        }
    }

    private void r() {
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.a
    public void a(int i2, int i3, String str) {
        com.martian.ttbook.b.c.a.a.b.a.d.b0.b.e(this.p, i3);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public int c() {
        return this.p.getVideoDuration();
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
        List<KsImage> imageList = this.p.getImageList();
        return (imageList == null || imageList.size() <= 0) ? super.e() : imageList.get(0).getHeight();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public int f() {
        List<KsImage> imageList = this.p.getImageList();
        return (imageList == null || imageList.size() <= 0) ? super.f() : imageList.get(0).getWidth();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.d
    public List<String> g() {
        ArrayList arrayList = new ArrayList();
        if (this.p.getImageList() != null) {
            Iterator<KsImage> it = this.p.getImageList().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getImageUrl());
            }
        }
        return arrayList;
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public int getAdPatternType() {
        return com.martian.ttbook.b.c.a.a.b.a.d.b0.c.a(this.p.getMaterialType());
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.d
    public String getDesc() {
        return this.p.getAdDescription();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.d
    public String getIconUrl() {
        return this.p.getAppIconUrl();
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
        String appName = this.p.getAppName();
        return !TextUtils.isEmpty(appName) ? appName : this.p.getProductName();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public String getVideoCoverImage() {
        KsImage videoCoverImage = this.p.getVideoCoverImage();
        return videoCoverImage != null ? videoCoverImage.getImageUrl() : super.getVideoCoverImage();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.d
    public View h(@NonNull Context context, @NonNull View view, Object obj, FrameLayout.LayoutParams layoutParams, List<View> list, View view2, @NonNull d.a aVar) {
        com.martian.ttbook.b.c.a.a.e.d.g(m, "enter tag " + obj);
        this.q = new WeakReference(obj);
        return k(context, view, layoutParams, list, view2, aVar);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public boolean isAppAd() {
        return this.p.getInteractionType() == 1;
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public boolean isVideoAd() {
        return this.p.getMaterialType() == 1;
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
        if (com.martian.ttbook.b.c.a.a.e.i.g(this.f15213d) && !list2.contains(view4)) {
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
        KsNativeAd ksNativeAd = this.p;
        if (ksNativeAd == null || viewGroup == null) {
            return;
        }
        ksNativeAd.setDownloadListener(new a(this, aVar));
        KsNativeAd.AdInteractionListener adInteractionListener = (KsNativeAd.AdInteractionListener) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{KsNativeAd.AdInteractionListener.class}, new C0306d(this, new b(weakReference, aVar)));
        r();
        this.p.registerViewForInteraction(viewGroup, list, adInteractionListener);
        for (View view : list) {
            com.martian.ttbook.b.c.a.a.e.d.g(m, "clickView " + view);
        }
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

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.a
    public void sendWinNotification(int i2) {
        super.sendWinNotification(i2);
        com.martian.ttbook.b.c.a.a.b.a.d.b0.b.g(this.p, i2);
    }
}
