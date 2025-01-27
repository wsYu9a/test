package com.martian.ttbook.b.c.a.a.b.a.d.c.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.martian.ttbook.b.c.a.a.b.a.d.f;
import com.martian.ttbook.b.c.a.a.b.a.d.q;
import com.martian.ttbook.b.c.a.a.c.h;
import com.martian.ttbook.b.c.a.a.c.l.d;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.i;
import com.martian.ttbook.b.c.a.a.d.b.l;
import com.martian.ttbook.b.c.a.a.e.c;
import com.martian.ttbook.b.c.a.a.e.j;
import com.vivo.ad.model.s;
import com.vivo.ad.nativead.NativeResponse;
import com.vivo.mobilead.unified.base.view.NativeVideoView;
import com.vivo.mobilead.unified.base.view.VivoNativeAdContainer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class c extends f {
    protected static String m = "VVUNITAG";
    private static final Object n = new Object();
    private static final Object o = new Object();
    public NativeResponse p;
    private NativeVideoView q;
    private WeakReference<VivoNativeAdContainer> r;
    public WeakReference s;
    public WeakReference<View> t;

    class a implements q {

        /* renamed from: a */
        final /* synthetic */ com.martian.ttbook.b.c.a.a.c.q.a f15367a;

        a(c cVar, com.martian.ttbook.b.c.a.a.c.q.a aVar) {
            this.f15367a = aVar;
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.q
        public void a() {
            this.f15367a.onVideoResume();
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.q
        public void a(i iVar) {
            this.f15367a.a(iVar);
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.q
        public void onVideoComplete() {
            this.f15367a.onVideoCompleted();
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.q
        public void onVideoPause() {
            this.f15367a.onVideoPause();
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.q
        public void onVideoReady(long j2) {
            this.f15367a.onVideoReady();
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.q
        public void onVideoStart() {
            this.f15367a.onVideoStart();
        }
    }

    class b implements c.InterfaceC0361c {

        /* renamed from: a */
        final /* synthetic */ ImageView f15368a;

        class a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Bitmap f15369a;

            a(Bitmap bitmap) {
                this.f15369a = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.martian.ttbook.b.c.a.a.e.d.g(c.m, "set mark logo");
                b.this.f15368a.setImageBitmap(this.f15369a);
            }
        }

        b(c cVar, ImageView imageView) {
            this.f15368a = imageView;
        }

        @Override // com.martian.ttbook.b.c.a.a.e.c.InterfaceC0361c
        public void a(int i2, byte[] bArr, i iVar) {
            if (iVar == null) {
                j.c(new a(b.d.e.c.a.i.a.d().c(0, 0, Bitmap.Config.ARGB_8888, ImageView.ScaleType.CENTER_INSIDE, bArr)));
            }
        }
    }

    public c(NativeResponse nativeResponse, com.martian.ttbook.b.c.a.a.d.b.d dVar, e eVar, Map<String, Object> map) {
        super(dVar, eVar, map);
        this.p = nativeResponse;
        com.martian.ttbook.b.c.a.a.b.a.d.c.b.k(this.l, com.martian.ttbook.b.c.a.a.b.a.d.c.b.c(nativeResponse), eVar);
    }

    private int j(NativeResponse nativeResponse) {
        if (nativeResponse == null) {
            return 0;
        }
        switch (nativeResponse.getMaterialMode()) {
            case 1:
                return 6;
            case 2:
            case 3:
            case 6:
                return 5;
            case 4:
            case 5:
                return 2;
            default:
                return 0;
        }
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
    private com.martian.ttbook.b.c.a.a.d.b.m.a m(android.view.View r12, android.view.View r13, android.view.ViewGroup r14) {
        /*
            Method dump skipped, instructions count: 279
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.ttbook.b.c.a.a.b.a.d.c.e.c.m(android.view.View, android.view.View, android.view.ViewGroup):com.martian.ttbook.b.c.a.a.d.b.m.a");
    }

    private void q(NativeResponse nativeResponse, VivoNativeAdContainer vivoNativeAdContainer, Context context) {
        View view;
        com.martian.ttbook.b.c.a.a.e.d.g(m, "render ad logo ");
        if (nativeResponse.getAdLogo() != null) {
            ImageView imageView = new ImageView(context);
            imageView.setImageBitmap(nativeResponse.getAdLogo());
            com.martian.ttbook.b.c.a.a.e.d.g(m, "set adLogo");
            view = imageView;
        } else if (TextUtils.isEmpty(nativeResponse.getAdMarkUrl())) {
            String adMarkText = !TextUtils.isEmpty(nativeResponse.getAdMarkText()) ? nativeResponse.getAdMarkText() : !TextUtils.isEmpty(nativeResponse.getAdTag()) ? nativeResponse.getAdTag() : "H广告";
            com.martian.ttbook.b.c.a.a.e.d.g(m, "set text logo");
            TextView textView = new TextView(context);
            textView.setText(adMarkText);
            view = textView;
        } else {
            ImageView imageView2 = new ImageView(context);
            com.martian.ttbook.b.c.a.a.e.c.e(nativeResponse.getAdMarkUrl(), null, new b(this, imageView2));
            view = imageView2;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        vivoNativeAdContainer.addView(view, layoutParams);
    }

    private void r(NativeVideoView nativeVideoView, com.martian.ttbook.b.c.a.a.c.q.a aVar) {
        WeakReference<VivoNativeAdContainer> weakReference;
        if (nativeVideoView == null || (weakReference = this.r) == null) {
            return;
        }
        this.q = nativeVideoView;
        VivoNativeAdContainer vivoNativeAdContainer = weakReference.get();
        if (vivoNativeAdContainer != null) {
            this.p.registerView(vivoNativeAdContainer, null, nativeVideoView);
            nativeVideoView.start();
            nativeVideoView.setMediaListener(com.martian.ttbook.b.c.a.a.b.a.d.c.d.a().f(new a(this, aVar)));
        }
    }

    private com.martian.ttbook.b.c.a.a.c.c s() {
        NativeResponse nativeResponse = this.p;
        if (nativeResponse == null || nativeResponse.getAppMiitInfo() == null) {
            return null;
        }
        try {
            String name = this.p.getAppMiitInfo().getName();
            String developer = this.p.getAppMiitInfo().getDeveloper();
            long size = this.p.getAppMiitInfo().getSize();
            ArrayList arrayList = new ArrayList();
            Iterator<s> it = this.p.getAppMiitInfo().getPermissionList().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getDescribe());
            }
            return com.martian.ttbook.b.c.a.a.c.c.b(name, developer, size, arrayList, this.p.getAppMiitInfo().getPrivacyPolicyUrl(), this.p.getAppMiitInfo().getVersionName());
        } catch (Exception e2) {
            com.martian.ttbook.b.c.a.a.e.d.g(m, "err " + e2);
            return null;
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.a
    public void a(int i2, int i3, String str) {
        com.martian.ttbook.b.c.a.a.b.a.d.c.b.h(this.p, i3);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public void b() {
        if (this.p != null) {
            this.p = null;
        }
        NativeVideoView nativeVideoView = this.q;
        if (nativeVideoView != null) {
            nativeVideoView.release();
            this.q = null;
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public com.martian.ttbook.b.c.a.a.c.c d() {
        return s();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.d
    public List<String> g() {
        return this.p.getImgUrl();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public int getAdPatternType() {
        return j(this.p);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public int getAppStatus() {
        return this.p.getAPPStatus();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.d
    public String getDesc() {
        return this.p.getDesc();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.d
    public String getIconUrl() {
        return this.p.getIconUrl();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public String getImageUrl() {
        List<String> g2 = g();
        return (g2 == null || g2.size() <= 0) ? super.getImageUrl() : g2.get(0);
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.d
    public String getTitle() {
        return this.p.getTitle();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.d
    public View h(@NonNull Context context, @NonNull View view, Object obj, FrameLayout.LayoutParams layoutParams, List<View> list, View view2, @NonNull d.a aVar) {
        com.martian.ttbook.b.c.a.a.e.d.g(m, "enter tag " + obj);
        this.s = new WeakReference(obj);
        return l(context, view, layoutParams, list, view2, aVar);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public boolean isAppAd() {
        return this.p.getAdType() == 2;
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public boolean isVideoAd() {
        return j(this.p) == 2;
    }

    public View k(@NonNull Context context, @NonNull View view, FrameLayout.LayoutParams layoutParams, List<View> list, View view2, View view3, @NonNull d.a aVar) {
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
        if (com.martian.ttbook.b.c.a.a.e.i.g(this.f15213d) && !list2.contains(view4)) {
            com.martian.ttbook.b.c.a.a.e.d.g(m, "ovov ");
            list2.add(view4);
        }
        this.f15211b = aVar;
        VivoNativeAdContainer vivoNativeAdContainer = new VivoNativeAdContainer(context);
        com.martian.ttbook.b.c.a.a.d.b.m.a m2 = m(view, view3, vivoNativeAdContainer);
        this.r = new WeakReference<>(vivoNativeAdContainer);
        o(context, vivoNativeAdContainer, layoutParams, list2, this.k, aVar);
        p(this.k.get(), view2 != null ? new View[]{view2} : new View[0]);
        return m2;
    }

    public View l(@NonNull Context context, View view, FrameLayout.LayoutParams layoutParams, List<View> list, View view2, @NonNull d.a aVar) {
        return k(context, view, layoutParams, list, view2, null, aVar);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public void n(@NonNull ViewGroup viewGroup, com.martian.ttbook.b.c.a.a.c.q.a aVar) {
        com.martian.ttbook.b.c.a.a.e.d.g(m, "ENTER");
        if (viewGroup != null) {
            Object obj = o;
            NativeVideoView nativeVideoView = (NativeVideoView) viewGroup.findViewWithTag(obj);
            if (nativeVideoView == null) {
                nativeVideoView = new NativeVideoView(viewGroup.getContext());
                nativeVideoView.setTag(obj);
                viewGroup.addView(nativeVideoView, new ViewGroup.LayoutParams(-1, -1));
            }
            r(nativeVideoView, aVar);
        }
    }

    protected void o(Context context, VivoNativeAdContainer vivoNativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list, WeakReference<com.martian.ttbook.b.c.a.a.d.b.m.a> weakReference, d.a aVar) {
        NativeResponse nativeResponse = this.p;
        if (nativeResponse == null || vivoNativeAdContainer == null) {
            return;
        }
        q(nativeResponse, vivoNativeAdContainer, context);
        this.p.registerView(vivoNativeAdContainer, null);
    }

    protected void p(View view, View[] viewArr) {
        l.m(this.f15212c.f15668b, this.f15218j, h.INFORMATION_FLOW, view, viewArr, this.t, this.s);
        l.s(this.f15212c.f15668b, this.f15213d.e(), this.f15213d.b());
        byte[] h2 = this.f15212c.r.h();
        if (h2 != null) {
            l.j(this.f15212c.f15668b, h2);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public void pauseVideo() {
        NativeVideoView nativeVideoView = this.q;
        if (nativeVideoView != null) {
            nativeVideoView.pause();
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.a
    public void sendWinNotification(int i2) {
        com.martian.ttbook.b.c.a.a.b.a.d.c.b.j(this.p, i2);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public void startVideo() {
        NativeVideoView nativeVideoView = this.q;
        if (nativeVideoView != null) {
            nativeVideoView.start();
        }
    }

    public void t() {
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15211b;
        if (eVar instanceof d.a) {
            ((d.a) eVar).onAdClicked();
        }
    }

    public void u() {
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15211b;
        if (eVar instanceof d.a) {
            ((d.a) eVar).onAdExposed();
        }
    }
}
