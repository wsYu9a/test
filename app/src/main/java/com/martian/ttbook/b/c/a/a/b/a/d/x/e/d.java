package com.martian.ttbook.b.c.a.a.b.a.d.x.e;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.INativeVideoListener;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.XNativeView;
import com.martian.ttbook.b.c.a.a.b.a.d.f;
import com.martian.ttbook.b.c.a.a.c.l.d;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.i;
import com.martian.ttbook.b.c.a.a.d.b.k;
import com.martian.ttbook.b.c.a.a.d.b.l;
import com.martian.ttbook.b.c.a.a.e.h;
import com.opos.acs.st.utils.ErrorContants;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class d extends f {
    protected static String m = "BDUNITAG";
    private static final Object n = new Object();
    private static final Object o = new Object();
    public NativeResponse p;
    public WeakReference q;
    public WeakReference<View> r;
    private WeakReference<XNativeView> s;

    class a implements NativeResponse.AdInteractionListener {

        /* renamed from: a */
        final /* synthetic */ WeakReference f15453a;

        /* renamed from: b */
        final /* synthetic */ d.a f15454b;

        a(WeakReference weakReference, d.a aVar) {
            this.f15453a = weakReference;
            this.f15454b = aVar;
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onADExposed() {
            com.martian.ttbook.b.c.a.a.e.d.g(d.m, "onADExposed ");
            HashMap hashMap = new HashMap();
            d.this.f15215f = System.currentTimeMillis();
            hashMap.put(h.f15836a, d.this.f15213d.f15700b.d(e.c.f15716f, ErrorContants.NET_ERROR));
            l.i(d.this.f15218j, true, true);
            d dVar = d.this;
            new k(dVar.f15212c, dVar.f15213d).a(5).c(k.b.n, d.this.f15210a).c(k.b.C, d.this.getTitle()).h();
            this.f15454b.onAdExposed();
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onADExposureFailed(int i2) {
            com.martian.ttbook.b.c.a.a.e.d.c(d.m, "onADError %d", Integer.valueOf(i2));
            d.this.a(new i(-3000, String.valueOf(i2)));
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onADStatusChanged() {
            com.martian.ttbook.b.c.a.a.e.d.g(d.m, "onADStatusChanged");
            if (this.f15454b instanceof d.b) {
                int downloadStatus = d.this.p.getDownloadStatus();
                int j2 = d.this.j(downloadStatus);
                ((d.b) this.f15454b).onADStatusChanged(j2);
                if (j2 == 4) {
                    ((d.b) this.f15454b).onLoadApkProgress(downloadStatus);
                }
            }
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onAdClick() {
            com.martian.ttbook.b.c.a.a.e.d.g(d.m, "onADClicked");
            d dVar = d.this;
            dVar.f15214e++;
            k kVar = new k(dVar.f15212c, dVar.f15213d);
            k c2 = kVar.c(k.b.n, d.this.f15210a);
            com.martian.ttbook.b.c.a.a.d.b.e eVar = d.this.f15213d;
            WeakReference weakReference = this.f15453a;
            com.martian.ttbook.b.c.a.a.d.b.m.a aVar = weakReference == null ? null : (com.martian.ttbook.b.c.a.a.d.b.m.a) weakReference.get();
            d dVar2 = d.this;
            boolean g2 = c2.g(eVar, aVar, dVar2.f15215f, dVar2.f15218j);
            kVar.h();
            l.i(d.this.f15218j, false, true);
            if (g2) {
                this.f15454b.onAdClicked();
            }
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onAdUnionClick() {
        }
    }

    class b implements XNativeView.INativeViewClickListener {

        /* renamed from: a */
        final /* synthetic */ com.martian.ttbook.b.c.a.a.c.q.a f15456a;

        b(d dVar, com.martian.ttbook.b.c.a.a.c.q.a aVar) {
            this.f15456a = aVar;
        }

        @Override // com.baidu.mobads.sdk.api.XNativeView.INativeViewClickListener
        public void onNativeViewClick(XNativeView xNativeView) {
            this.f15456a.onVideoClicked();
        }
    }

    class c implements INativeVideoListener {

        /* renamed from: a */
        final /* synthetic */ com.martian.ttbook.b.c.a.a.c.q.a f15457a;

        c(d dVar, com.martian.ttbook.b.c.a.a.c.q.a aVar) {
            this.f15457a = aVar;
        }

        @Override // com.baidu.mobads.sdk.api.INativeVideoListener
        public void onCompletion() {
            this.f15457a.onVideoCompleted();
        }

        @Override // com.baidu.mobads.sdk.api.INativeVideoListener
        public void onError() {
            this.f15457a.a(new i(-3000, "广告展示失败"));
        }

        @Override // com.baidu.mobads.sdk.api.INativeVideoListener
        public void onPause() {
            this.f15457a.onVideoPause();
        }

        @Override // com.baidu.mobads.sdk.api.INativeVideoListener
        public void onRenderingStart() {
            this.f15457a.onVideoStart();
        }

        @Override // com.baidu.mobads.sdk.api.INativeVideoListener
        public void onResume() {
            this.f15457a.onVideoResume();
        }
    }

    /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.x.e.d$d */
    static /* synthetic */ class C0324d {

        /* renamed from: a */
        static final /* synthetic */ int[] f15458a;

        static {
            int[] iArr = new int[NativeResponse.MaterialType.values().length];
            f15458a = iArr;
            try {
                iArr[NativeResponse.MaterialType.VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15458a[NativeResponse.MaterialType.HTML.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15458a[NativeResponse.MaterialType.NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public d(NativeResponse nativeResponse, BaiduNativeManager baiduNativeManager, com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar, Map<String, Object> map) {
        super(dVar, eVar, map);
        this.p = nativeResponse;
        com.martian.ttbook.b.c.a.a.b.a.c cVar = dVar.t;
        com.martian.ttbook.b.c.a.a.b.a.d.x.a.g(this.l, com.martian.ttbook.b.c.a.a.b.a.d.x.a.b(nativeResponse), eVar);
    }

    public int j(int i2) {
        if (i2 > 0 && i2 <= 100) {
            return 4;
        }
        if (i2 == 101) {
            return 8;
        }
        if (i2 == 102) {
            return 32;
        }
        if (i2 == 103) {
            return 1;
        }
        return i2 == 104 ? 16 : 0;
    }

    private int k(NativeResponse nativeResponse) {
        int i2 = C0324d.f15458a[nativeResponse.getMaterialType().ordinal()];
        if (i2 == 1) {
            return 2;
        }
        if (i2 != 3) {
            return 0;
        }
        if (!TextUtils.isEmpty(nativeResponse.getImageUrl())) {
            return 5;
        }
        List<String> multiPicUrls = nativeResponse.getMultiPicUrls();
        return (multiPicUrls == null || multiPicUrls.size() <= 0) ? 0 : 3;
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
    private com.martian.ttbook.b.c.a.a.d.b.m.a p(android.view.View r12, android.view.View r13, android.view.ViewGroup r14) {
        /*
            Method dump skipped, instructions count: 279
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.ttbook.b.c.a.a.b.a.d.x.e.d.p(android.view.View, android.view.View, android.view.ViewGroup):com.martian.ttbook.b.c.a.a.d.b.m.a");
    }

    private void s(XNativeView xNativeView, com.martian.ttbook.b.c.a.a.c.q.a aVar) {
        if (xNativeView != null) {
            this.s = new WeakReference<>(xNativeView);
            com.martian.ttbook.b.c.a.a.c.q.b bVar = this.f15212c.s;
            if (bVar != null) {
                xNativeView.setVideoMute(bVar.k());
            }
            xNativeView.setNativeItem(this.p);
            xNativeView.setNativeViewClickListener(new b(this, aVar));
            xNativeView.setNativeVideoListener(new c(this, aVar));
            xNativeView.render();
        }
    }

    private com.martian.ttbook.b.c.a.a.c.c t() {
        try {
            return com.martian.ttbook.b.c.a.a.c.c.a(this.p.getBrandName(), this.p.getPublisher(), this.p.getAppSize(), this.p.getAppPermissionLink(), this.p.getAppPrivacyLink(), this.p.getAppVersion());
        } catch (Exception e2) {
            com.martian.ttbook.b.c.a.a.e.d.g(m, "err " + e2);
            return null;
        }
    }

    private XNativeView u() {
        WeakReference<XNativeView> weakReference = this.s;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.a
    public void a(int i2, int i3, String str) {
        NativeResponse nativeResponse = this.p;
        if (nativeResponse != null) {
            nativeResponse.biddingFail("203");
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public int c() {
        return this.p.getDuration();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.a
    public void c(com.martian.ttbook.b.c.a.a.b.a.c cVar) {
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public com.martian.ttbook.b.c.a.a.c.c d() {
        return t();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public int e() {
        return this.p.getMainPicHeight();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public int f() {
        return this.p.getMainPicWidth();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.d
    public List<String> g() {
        return this.p.getMultiPicUrls();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public int getAdPatternType() {
        return k(this.p);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public int getAppStatus() {
        return j(this.p.getDownloadStatus());
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
        List<String> g2;
        String imageUrl = this.p.getImageUrl();
        return (!TextUtils.isEmpty(imageUrl) || (g2 = g()) == null || g2.size() <= 0) ? imageUrl : g2.get(0);
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.d
    public String getTitle() {
        return this.p.getTitle();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.d
    public View h(@NonNull Context context, @NonNull View view, Object obj, FrameLayout.LayoutParams layoutParams, List<View> list, View view2, @NonNull d.a aVar) {
        com.martian.ttbook.b.c.a.a.e.d.g(m, "enter tag " + obj);
        this.q = new WeakReference(obj);
        return o(context, view, layoutParams, list, view2, aVar);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public boolean isAppAd() {
        return this.p.getAdActionType() == 2;
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public boolean isVideoAd() {
        return this.p.getMaterialType() == NativeResponse.MaterialType.VIDEO;
    }

    public View m(@NonNull Context context, @NonNull View view, FrameLayout.LayoutParams layoutParams, List<View> list, View view2, View view3, @NonNull d.a aVar) {
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
        NativeAdContainer nativeAdContainer = new NativeAdContainer(context);
        com.martian.ttbook.b.c.a.a.d.b.m.a p = p(view, view3, nativeAdContainer);
        q(context, nativeAdContainer, layoutParams, list2, this.k, aVar);
        r(this.k.get(), view2 != null ? new View[]{view2} : new View[0]);
        return p;
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public void n(@NonNull ViewGroup viewGroup, com.martian.ttbook.b.c.a.a.c.q.a aVar) {
        com.martian.ttbook.b.c.a.a.e.d.g(m, "ENTER");
        if (viewGroup != null) {
            Object obj = o;
            XNativeView xNativeView = (XNativeView) viewGroup.findViewWithTag(obj);
            if (xNativeView == null) {
                xNativeView = new XNativeView(viewGroup.getContext());
                xNativeView.setTag(obj);
                viewGroup.addView(xNativeView, new ViewGroup.LayoutParams(-1, -1));
            }
            s(xNativeView, aVar);
        }
    }

    public View o(@NonNull Context context, View view, FrameLayout.LayoutParams layoutParams, List<View> list, View view2, @NonNull d.a aVar) {
        return m(context, view, layoutParams, list, view2, null, aVar);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public void pauseAppDownload() {
        try {
            NativeResponse nativeResponse = this.p;
            if (nativeResponse != null) {
                nativeResponse.pauseAppDownload();
            }
        } catch (Exception e2) {
            com.martian.ttbook.b.c.a.a.e.d.c(m, "p err %s", e2);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public void pauseVideo() {
        XNativeView u = u();
        if (u != null) {
            u.pause();
        }
    }

    protected void q(Context context, ViewGroup viewGroup, FrameLayout.LayoutParams layoutParams, List<View> list, WeakReference<com.martian.ttbook.b.c.a.a.d.b.m.a> weakReference, d.a aVar) {
        if (this.p == null || viewGroup == null) {
            return;
        }
        this.p.registerViewForInteraction(viewGroup, list, new ArrayList(), new a(weakReference, aVar));
    }

    protected void r(View view, View[] viewArr) {
        l.m(this.f15212c.f15668b, this.f15218j, com.martian.ttbook.b.c.a.a.c.h.INFORMATION_FLOW, view, viewArr, this.r, this.q);
        l.s(this.f15212c.f15668b, this.f15213d.e(), this.f15213d.b());
        byte[] h2 = this.f15212c.r.h();
        if (h2 != null) {
            l.j(this.f15212c.f15668b, h2);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public void resume() {
        XNativeView u = u();
        if (u != null) {
            u.resume();
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public void resumeAppDownload() {
        try {
            NativeResponse nativeResponse = this.p;
            if (nativeResponse != null) {
                nativeResponse.resumeAppDownload();
            }
        } catch (Exception e2) {
            com.martian.ttbook.b.c.a.a.e.d.c(m, "r err %s", e2);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public void resumeVideo() {
        XNativeView u = u();
        if (u != null) {
            u.resume();
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.a
    public void sendWinNotification(int i2) {
        com.martian.ttbook.b.c.a.a.e.d.h("win " + i2);
        NativeResponse nativeResponse = this.p;
        if (nativeResponse != null) {
            nativeResponse.biddingSuccess(String.valueOf(i2));
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public void setVideoMute(boolean z) {
        XNativeView u = u();
        if (u != null) {
            u.setVideoMute(z);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public void startVideo() {
        XNativeView u = u();
        if (u != null) {
            u.render();
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public void stopVideo() {
        XNativeView u = u();
        if (u != null) {
            u.stop();
        }
    }
}
