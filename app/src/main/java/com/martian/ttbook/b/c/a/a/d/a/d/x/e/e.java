package com.martian.ttbook.b.c.a.a.d.a.d.x.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.martian.ttbook.b.c.a.a.c.l.d;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.i;
import com.martian.ttbook.b.c.a.a.d.b.k;
import com.martian.ttbook.b.c.a.a.d.b.l;
import com.martian.ttbook.b.c.a.a.e.h;
import com.martian.ttbook.sdk.client.AdExtras;
import com.opos.acs.st.utils.ErrorContants;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.util.AdError;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class e extends com.martian.ttbook.b.c.a.a.b.a.d.f {
    protected static String m = "GDTUNITAG";
    private static final Object n = new Object();
    private static final Object o = new Object();
    public NativeUnifiedADData p;
    public int q;
    public WeakReference r;
    public WeakReference<View> s;
    private com.martian.ttbook.b.c.a.a.b.a.c t;

    class a implements NativeADEventListener {

        /* renamed from: a */
        final /* synthetic */ WeakReference f15627a;

        /* renamed from: b */
        final /* synthetic */ d.a f15628b;

        a(WeakReference weakReference, d.a aVar) {
            this.f15627a = weakReference;
            this.f15628b = aVar;
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADClicked() {
            com.martian.ttbook.b.c.a.a.e.d.g(e.m, "onADClicked");
            e eVar = e.this;
            eVar.f15214e++;
            k kVar = new k(eVar.f15212c, eVar.f15213d);
            k c2 = kVar.c(k.b.n, e.this.f15210a);
            com.martian.ttbook.b.c.a.a.d.b.e eVar2 = e.this.f15213d;
            WeakReference weakReference = this.f15627a;
            com.martian.ttbook.b.c.a.a.d.b.m.a aVar = weakReference == null ? null : (com.martian.ttbook.b.c.a.a.d.b.m.a) weakReference.get();
            e eVar3 = e.this;
            boolean g2 = c2.g(eVar2, aVar, eVar3.f15215f, eVar3.f15218j);
            kVar.h();
            l.i(e.this.f15218j, false, true);
            if (g2) {
                this.f15628b.onAdClicked();
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADError(AdError adError) {
            com.martian.ttbook.b.c.a.a.e.d.c(e.m, "onADError %s", adError);
            e.this.a(new i(adError.getErrorCode(), adError.getErrorMsg()));
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADExposed() {
            com.martian.ttbook.b.c.a.a.e.d.g(e.m, "onADExposed ");
            HashMap hashMap = new HashMap();
            e.this.f15215f = System.currentTimeMillis();
            hashMap.put(h.f15836a, e.this.f15213d.f15700b.d(e.c.f15716f, ErrorContants.NET_ERROR));
            l.i(e.this.f15218j, true, true);
            e eVar = e.this;
            new k(eVar.f15212c, eVar.f15213d).a(5).c(k.b.n, e.this.f15210a).c(k.b.C, e.this.getTitle()).h();
            this.f15628b.onAdExposed();
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADStatusChanged() {
            com.martian.ttbook.b.c.a.a.e.d.g(e.m, "onADStatusChanged");
            d.a aVar = this.f15628b;
            if (aVar instanceof d.b) {
                ((d.b) aVar).onADStatusChanged(e.this.p.getAppStatus());
                if (e.this.p.getAppStatus() == 4) {
                    ((d.b) this.f15628b).onLoadApkProgress(e.this.p.getProgress());
                }
            }
        }
    }

    class b implements NativeADMediaListener {

        /* renamed from: a */
        final /* synthetic */ com.martian.ttbook.b.c.a.a.c.q.a f15630a;

        b(e eVar, com.martian.ttbook.b.c.a.a.c.q.a aVar) {
            this.f15630a = aVar;
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoClicked() {
            this.f15630a.onVideoClicked();
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoCompleted() {
            this.f15630a.onVideoCompleted();
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoError(AdError adError) {
            this.f15630a.a(new i(adError.getErrorCode(), adError.getErrorMsg()));
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoInit() {
            this.f15630a.onVideoInit();
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoLoaded(int i2) {
            this.f15630a.onVideoLoaded(i2);
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoLoading() {
            this.f15630a.onVideoLoading();
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoPause() {
            this.f15630a.onVideoPause();
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoReady() {
            this.f15630a.onVideoReady();
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoResume() {
            this.f15630a.onVideoResume();
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoStart() {
            this.f15630a.onVideoStart();
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoStop() {
            this.f15630a.onVideoStop();
        }
    }

    public e(NativeUnifiedADData nativeUnifiedADData, NativeUnifiedAD nativeUnifiedAD, com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar, Map<String, Object> map, int i2) {
        super(dVar, eVar, map);
        this.p = nativeUnifiedADData;
        this.q = i2;
        this.t = dVar.t;
        this.l.put(AdExtras.EXTRA_APP_INFOURL, com.martian.ttbook.b.c.a.a.d.a.d.x.a.b(nativeUnifiedADData));
        NativeUnifiedADData nativeUnifiedADData2 = this.p;
        if (nativeUnifiedADData2 != null) {
            com.martian.ttbook.b.c.a.a.d.a.d.x.c.d(this.l, nativeUnifiedADData2, eVar);
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
    private com.martian.ttbook.b.c.a.a.d.b.m.a l(android.view.View r12, android.view.View r13, android.view.ViewGroup r14) {
        /*
            Method dump skipped, instructions count: 279
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.ttbook.b.c.a.a.d.a.d.x.e.e.l(android.view.View, android.view.View, android.view.ViewGroup):com.martian.ttbook.b.c.a.a.d.b.m.a");
    }

    private void p(MediaView mediaView, com.martian.ttbook.b.c.a.a.c.q.a aVar) {
        if (mediaView != null) {
            com.martian.ttbook.b.c.a.a.c.q.b bVar = this.f15212c.s;
            VideoOption.Builder builder = new VideoOption.Builder();
            if (bVar != null) {
                builder.setAutoPlayMuted(bVar.k());
                builder.setAutoPlayPolicy(bVar.a());
                builder.setEnableDetailPage(bVar.m());
                builder.setNeedCoverImage(bVar.o());
                builder.setNeedProgressBar(bVar.q());
            }
            this.p.bindMediaView(mediaView, builder.build(), new b(this, aVar));
        }
    }

    private com.martian.ttbook.b.c.a.a.c.c q() {
        try {
            Object invoke = this.p.getClass().getMethod("getAppMiitInfo", new Class[0]).invoke(this.p, new Object[0]);
            Class<?> cls = Class.forName("com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo");
            Method method = cls.getMethod("getAppName", new Class[0]);
            Method method2 = cls.getMethod("getAuthorName", new Class[0]);
            Method method3 = cls.getMethod("getPackageSizeBytes", new Class[0]);
            Method method4 = cls.getMethod("getPermissionsUrl", new Class[0]);
            Method method5 = cls.getMethod("getPrivacyAgreement", new Class[0]);
            Method method6 = cls.getMethod("getVersionName", new Class[0]);
            Object invoke2 = method.invoke(invoke, new Object[0]);
            Object invoke3 = method2.invoke(invoke, new Object[0]);
            Object invoke4 = method3.invoke(invoke, new Object[0]);
            Object invoke5 = method4.invoke(invoke, new Object[0]);
            Object invoke6 = method5.invoke(invoke, new Object[0]);
            Object invoke7 = method6.invoke(invoke, new Object[0]);
            return com.martian.ttbook.b.c.a.a.c.c.a(invoke2 instanceof String ? (String) invoke2 : null, invoke3 instanceof String ? (String) invoke3 : null, invoke4 instanceof Long ? ((Long) invoke4).longValue() : 0L, invoke5 instanceof String ? (String) invoke5 : null, invoke6 instanceof String ? (String) invoke6 : null, invoke7 instanceof String ? (String) invoke7 : null);
        } catch (Exception e2) {
            com.martian.ttbook.b.c.a.a.e.d.g(m, "err " + e2);
            return null;
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.a
    public void a(int i2, int i3, String str) {
        com.martian.ttbook.b.c.a.a.e.i.d(this.p, i3, i2, str);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public void a(View view) {
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public void b() {
        this.p.destroy();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public int c() {
        return this.p.getVideoDuration();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.a
    public void c(com.martian.ttbook.b.c.a.a.b.a.c cVar) {
        this.t = cVar;
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public com.martian.ttbook.b.c.a.a.c.c d() {
        return com.martian.ttbook.b.c.a.a.e.i.i("4.380") ? q() : super.d();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public int e() {
        return this.p.getPictureHeight();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public int f() {
        return this.p.getPictureWidth();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.d
    public List<String> g() {
        return this.p.getImgList();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public int getAdPatternType() {
        return this.p.getAdPatternType();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public int getAppStatus() {
        return this.p.getAppStatus();
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
        return this.p.getImgUrl();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.d
    public String getTitle() {
        return this.p.getTitle();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public int getVideoCurrentPosition() {
        return this.p.getVideoCurrentPosition();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.d
    public View h(@NonNull Context context, @NonNull View view, Object obj, FrameLayout.LayoutParams layoutParams, List<View> list, View view2, @NonNull d.a aVar) {
        com.martian.ttbook.b.c.a.a.e.d.g(m, "enter tag " + obj);
        this.r = new WeakReference(obj);
        return k(context, view, layoutParams, list, view2, aVar);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public boolean isAppAd() {
        return this.p.isAppAd();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public boolean isVideoAd() {
        return this.p.getAdPatternType() == 2;
    }

    public View j(@NonNull Context context, @NonNull View view, FrameLayout.LayoutParams layoutParams, List<View> list, View view2, View view3, @NonNull d.a aVar) {
        String str;
        String str2;
        com.martian.ttbook.b.c.a.a.e.d.g(m, "enter " + view);
        if (this.q == 91) {
            a(new i(30000018, "GDT ad blocked"));
            return null;
        }
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
        com.martian.ttbook.b.c.a.a.d.b.m.a l = l(view, view3, nativeAdContainer);
        m(context, nativeAdContainer, layoutParams, list2, this.k, aVar);
        o(this.k.get(), view2 != null ? new View[]{view2} : new View[0]);
        return l;
    }

    public View k(@NonNull Context context, View view, FrameLayout.LayoutParams layoutParams, List<View> list, View view2, @NonNull d.a aVar) {
        return j(context, view, layoutParams, list, view2, null, aVar);
    }

    protected void m(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list, WeakReference<com.martian.ttbook.b.c.a.a.d.b.m.a> weakReference, d.a aVar) {
        NativeUnifiedADData nativeUnifiedADData = this.p;
        if (nativeUnifiedADData == null || nativeAdContainer == null) {
            return;
        }
        com.martian.ttbook.b.c.a.a.d.a.d.x.a.e(nativeUnifiedADData, this.t);
        this.p.setNativeAdEventListener(new a(weakReference, aVar));
        for (View view : list) {
            com.martian.ttbook.b.c.a.a.e.d.g(m, "clickView " + view);
        }
        this.p.bindAdToView(context, nativeAdContainer, layoutParams, list);
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
        l.m(this.f15212c.f15668b, this.f15218j, com.martian.ttbook.b.c.a.a.c.h.INFORMATION_FLOW, view, viewArr, this.s, this.r);
        l.s(this.f15212c.f15668b, this.f15213d.e(), this.f15213d.b());
        byte[] h2 = this.f15212c.r.h();
        if (h2 != null) {
            l.j(this.f15212c.f15668b, h2);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public void pauseAppDownload() {
        Method method;
        try {
            NativeUnifiedADData nativeUnifiedADData = this.p;
            if (nativeUnifiedADData == null || (method = nativeUnifiedADData.getClass().getMethod("pauseAppDownload", new Class[0])) == null) {
                return;
            }
            method.invoke(this.p, new Object[0]);
        } catch (Exception e2) {
            com.martian.ttbook.b.c.a.a.e.d.c(m, "p err %s", e2);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public void pauseVideo() {
        this.p.pauseVideo();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public void resume() {
        this.p.resume();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public void resumeAppDownload() {
        Method method;
        try {
            NativeUnifiedADData nativeUnifiedADData = this.p;
            if (nativeUnifiedADData == null || (method = nativeUnifiedADData.getClass().getMethod("resumeAppDownload", new Class[0])) == null) {
                return;
            }
            method.invoke(this.p, new Object[0]);
        } catch (Exception e2) {
            com.martian.ttbook.b.c.a.a.e.d.c(m, "r err %s", e2);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public void resumeVideo() {
        this.p.resumeVideo();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.a
    public void sendWinNotification(int i2) {
        com.martian.ttbook.b.c.a.a.e.i.c(this.p, i2);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public void setVideoMute(boolean z) {
        this.p.setVideoMute(z);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public void startVideo() {
        this.p.startVideo();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public void stopVideo() {
        this.p.stopVideo();
    }
}
