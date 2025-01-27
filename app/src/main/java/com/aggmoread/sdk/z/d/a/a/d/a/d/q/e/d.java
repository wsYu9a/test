package com.aggmoread.sdk.z.d.a.a.d.a.d.q.e;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.aggmoread.sdk.z.d.a.a.c.o.f;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.i;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import com.aggmoread.sdk.z.d.a.a.d.b.l;
import com.aggmoread.sdk.z.d.a.a.e.k;
import com.aggmoread.sdk.z.d.a.a.e.m;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.INativeVideoListener;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.XNativeView;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class d extends com.aggmoread.sdk.z.d.a.a.d.a.d.d {

    /* renamed from: y */
    protected static String f5483y = "AMUTAGBD";

    /* renamed from: w */
    public NativeResponse f5484w;

    /* renamed from: x */
    private WeakReference<XNativeView> f5485x;

    public class a implements NativeResponse.AdInteractionListener {

        /* renamed from: a */
        private boolean f5486a = false;

        /* renamed from: b */
        final /* synthetic */ WeakReference f5487b;

        /* renamed from: c */
        final /* synthetic */ f.a f5488c;

        /* renamed from: d */
        final /* synthetic */ ViewGroup f5489d;

        /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.q.e.d$a$a */
        public class RunnableC0131a implements Runnable {
            public RunnableC0131a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f5486a) {
                    com.aggmoread.sdk.z.d.a.a.e.e.b(d.f5483y, "onADError return ");
                } else {
                    d.this.a(new i(-1000, "1"));
                }
            }
        }

        public a(WeakReference weakReference, f.a aVar, ViewGroup viewGroup) {
            this.f5487b = weakReference;
            this.f5488c = aVar;
            this.f5489d = viewGroup;
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onADExposed() {
            com.aggmoread.sdk.z.d.a.a.e.e.b(d.f5483y, "onADExposed ");
            this.f5486a = true;
            HashMap hashMap = new HashMap();
            d.this.f5278k = System.currentTimeMillis();
            hashMap.put(k.f6102a, d.this.f5276i.f5906b.a(e.c.f5928f, "-1"));
            l.a((Object) d.this.f5281n, true, true);
            d.this.a(this.f5488c);
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onADExposureFailed(int i10) {
            com.aggmoread.sdk.z.d.a.a.e.e.a(d.f5483y, "onADError %d", Integer.valueOf(i10));
            if (i10 == 1) {
                this.f5489d.postDelayed(new RunnableC0131a(), qe.a.f30009d);
            } else {
                d.this.a(new i(-1000, String.valueOf(i10)));
            }
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onADStatusChanged() {
            com.aggmoread.sdk.z.d.a.a.e.e.b(d.f5483y, "onADStatusChanged");
            if (this.f5488c instanceof f.b) {
                int downloadStatus = d.this.f5484w.getDownloadStatus();
                int c10 = d.this.c(downloadStatus);
                ((f.b) this.f5488c).onADStatusChanged(c10);
                if (c10 == 4) {
                    ((f.b) this.f5488c).onLoadApkProgress(downloadStatus);
                }
            }
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onAdClick() {
            com.aggmoread.sdk.z.d.a.a.e.e.b(d.f5483y, "onADClicked");
            d dVar = d.this;
            dVar.f5277j++;
            com.aggmoread.sdk.z.d.a.a.d.b.k kVar = new com.aggmoread.sdk.z.d.a.a.d.b.k(dVar.f5275h, dVar.f5276i);
            com.aggmoread.sdk.z.d.a.a.d.b.k a10 = kVar.a(k.b.f6046n, d.this.f5273f);
            com.aggmoread.sdk.z.d.a.a.d.b.e eVar = d.this.f5276i;
            WeakReference weakReference = this.f5487b;
            com.aggmoread.sdk.z.d.a.a.d.b.m.a aVar = weakReference == null ? null : (com.aggmoread.sdk.z.d.a.a.d.b.m.a) weakReference.get();
            d dVar2 = d.this;
            boolean a11 = a10.a(eVar, aVar, dVar2.f5278k, dVar2.f5281n);
            kVar.b();
            l.a((Object) d.this.f5281n, false, true);
            if (a11) {
                this.f5488c.onAdClicked();
            }
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onAdUnionClick() {
        }
    }

    public class b implements XNativeView.INativeViewClickListener {

        /* renamed from: a */
        final /* synthetic */ com.aggmoread.sdk.z.d.a.a.c.t.a f5492a;

        public b(d dVar, com.aggmoread.sdk.z.d.a.a.c.t.a aVar) {
            this.f5492a = aVar;
        }

        @Override // com.baidu.mobads.sdk.api.XNativeView.INativeViewClickListener
        public void onNativeViewClick(XNativeView xNativeView) {
            this.f5492a.onVideoClicked();
        }
    }

    public class c implements INativeVideoListener {

        /* renamed from: a */
        final /* synthetic */ com.aggmoread.sdk.z.d.a.a.c.t.a f5493a;

        public c(d dVar, com.aggmoread.sdk.z.d.a.a.c.t.a aVar) {
            this.f5493a = aVar;
        }

        @Override // com.baidu.mobads.sdk.api.INativeVideoListener
        public void onCompletion() {
            this.f5493a.onVideoCompleted();
        }

        @Override // com.baidu.mobads.sdk.api.INativeVideoListener
        public void onError() {
            this.f5493a.a(new i(-1000, "广告展示失败"));
        }

        @Override // com.baidu.mobads.sdk.api.INativeVideoListener
        public void onPause() {
            this.f5493a.onVideoPause();
        }

        @Override // com.baidu.mobads.sdk.api.INativeVideoListener
        public void onRenderingStart() {
            this.f5493a.onVideoStart();
        }

        @Override // com.baidu.mobads.sdk.api.INativeVideoListener
        public void onResume() {
            this.f5493a.onVideoResume();
        }
    }

    /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.q.e.d$d */
    public static /* synthetic */ class C0132d {

        /* renamed from: a */
        static final /* synthetic */ int[] f5494a;

        static {
            int[] iArr = new int[NativeResponse.MaterialType.values().length];
            f5494a = iArr;
            try {
                iArr[NativeResponse.MaterialType.VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5494a[NativeResponse.MaterialType.HTML.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5494a[NativeResponse.MaterialType.NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public d(NativeResponse nativeResponse, BaiduNativeManager baiduNativeManager, com.aggmoread.sdk.z.d.a.a.d.b.d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar, Map<String, Object> map) {
        super(dVar, eVar, map);
        this.f5484w = nativeResponse;
        com.aggmoread.sdk.z.d.a.a.d.a.c cVar = dVar.f5874t;
        com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.b(this.f5319p, com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(nativeResponse), eVar);
    }

    public int c(int i10) {
        if (i10 > 0 && i10 <= 100) {
            return 4;
        }
        if (i10 == 101) {
            return 8;
        }
        if (i10 == 102) {
            return 32;
        }
        if (i10 == 103) {
            return 1;
        }
        return i10 == 104 ? 16 : 0;
    }

    private com.aggmoread.sdk.z.d.a.a.c.c e() {
        try {
            com.aggmoread.sdk.z.d.a.a.c.c a10 = com.aggmoread.sdk.z.d.a.a.c.c.a(this.f5484w.getBrandName(), this.f5484w.getPublisher(), this.f5484w.getAppSize(), this.f5484w.getAppPermissionLink(), this.f5484w.getAppPrivacyLink(), this.f5484w.getAppVersion());
            a10.c(this.f5484w.getAppPackage());
            a10.a(this.f5484w.getAppFunctionLink());
            return a10;
        } catch (Exception e10) {
            com.aggmoread.sdk.z.d.a.a.e.e.b(f5483y, "err " + e10);
            return null;
        }
    }

    private XNativeView i() {
        WeakReference<XNativeView> weakReference = this.f5485x;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d
    public ViewGroup b(Context context) {
        return new XNativeView(context);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public int f() {
        return this.f5484w.getDuration();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public com.aggmoread.sdk.z.d.a.a.c.c g() {
        return e();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public int getAdPatternType() {
        return a(this.f5484w);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public int getAppStatus() {
        return c(this.f5484w.getDownloadStatus());
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public String getCTAText() {
        return this.f5484w.getActButtonString();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public String getDesc() {
        return this.f5484w.getDesc();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public String getIconUrl() {
        return this.f5484w.getIconUrl();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public String getImageUrl() {
        List<String> imageUrlList;
        String imageUrl = this.f5484w.getImageUrl();
        return (!TextUtils.isEmpty(imageUrl) || (imageUrlList = getImageUrlList()) == null || imageUrlList.size() <= 0) ? imageUrl : imageUrlList.get(0);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public List<String> getImageUrlList() {
        return this.f5484w.getMultiPicUrls();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public int getPictureHeight() {
        return this.f5484w.getMainPicHeight();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public int getPictureWidth() {
        return this.f5484w.getMainPicWidth();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public int getProgress() {
        return this.f5484w.getDownloadStatus();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public String getTitle() {
        return this.f5484w.getTitle();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public boolean isAppAd() {
        return this.f5484w.getAdActionType() == 2;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public boolean isVideoAd() {
        return this.f5484w.getMaterialType() == NativeResponse.MaterialType.VIDEO;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public void pauseVideo() {
        XNativeView i10 = i();
        if (i10 != null) {
            i10.pause();
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public void resume() {
        XNativeView i10 = i();
        if (i10 != null) {
            i10.resume();
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public void resumeVideo() {
        XNativeView i10 = i();
        if (i10 != null) {
            i10.resume();
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public void setVideoMute(boolean z10) {
        XNativeView i10 = i();
        if (i10 != null) {
            i10.setVideoMute(z10);
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public void startVideo() {
        XNativeView i10 = i();
        if (i10 != null) {
            i10.render();
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public void stopVideo() {
        XNativeView i10 = i();
        if (i10 != null) {
            i10.stop();
        }
    }

    private int a(NativeResponse nativeResponse) {
        int i10 = C0132d.f5494a[nativeResponse.getMaterialType().ordinal()];
        if (i10 == 1) {
            return 2;
        }
        if (i10 != 3) {
            return 0;
        }
        if (!TextUtils.isEmpty(nativeResponse.getImageUrl())) {
            return 5;
        }
        List<String> multiPicUrls = nativeResponse.getMultiPicUrls();
        return (multiPicUrls == null || multiPicUrls.size() <= 0) ? 0 : 3;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d
    public void b(int i10) {
        com.aggmoread.sdk.z.d.a.a.e.e.c("win " + i10);
        com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(this.f5484w, i10);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d
    public View a(@NonNull Context context, @NonNull View view, FrameLayout.LayoutParams layoutParams, List<View> list, View view2, List<View> list2, View view3, @NonNull f.a aVar) {
        String str;
        String str2;
        com.aggmoread.sdk.z.d.a.a.d.b.m.a aVar2;
        NativeAdContainer nativeAdContainer;
        NativeAdContainer nativeAdContainer2;
        com.aggmoread.sdk.z.d.a.a.d.b.m.a a10;
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5483y, "enter");
        List<View> arrayList = list == null ? new ArrayList() : list;
        View view4 = view3 != null ? view3 : view;
        if (arrayList.contains(view4)) {
            str = f5483y;
            str2 = "ovov + true";
        } else {
            str = f5483y;
            str2 = "ovov + false";
        }
        com.aggmoread.sdk.z.d.a.a.e.e.b(str, str2);
        if (m.a(this.f5276i) && !arrayList.contains(view4)) {
            com.aggmoread.sdk.z.d.a.a.e.e.b(f5483y, "ovov ");
            arrayList.add(view4);
        }
        this.f5274g = aVar;
        if ((view instanceof com.aggmoread.sdk.z.d.a.a.d.b.m.a) && this.f5323t) {
            aVar2 = (com.aggmoread.sdk.z.d.a.a.d.b.m.a) view;
            nativeAdContainer = (NativeAdContainer) aVar2.findViewWithTag(com.aggmoread.sdk.z.d.a.a.d.a.d.d.f5317u);
            com.aggmoread.sdk.z.d.a.a.e.e.b(f5483y, "f n " + nativeAdContainer);
        } else {
            aVar2 = null;
            nativeAdContainer = null;
        }
        if (aVar2 == null || nativeAdContainer == null) {
            nativeAdContainer2 = (NativeAdContainer) a(context);
            a10 = a(view, view3, nativeAdContainer2);
        } else {
            a10 = aVar2;
            nativeAdContainer2 = nativeAdContainer;
        }
        a(context, nativeAdContainer2, layoutParams, arrayList, list2, this.f5282o, aVar);
        a(this.f5282o.get(), view2 != null ? new View[]{view2} : new View[0]);
        return a10;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d
    public void b(int i10, int i11, String str) {
        com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(this.f5484w, "203");
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d
    public ViewGroup a(Context context) {
        return new NativeAdContainer(context);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d
    public void b(ViewGroup viewGroup, com.aggmoread.sdk.z.d.a.a.c.t.a aVar) {
        if (viewGroup instanceof XNativeView) {
            XNativeView xNativeView = (XNativeView) viewGroup;
            this.f5485x = new WeakReference<>(xNativeView);
            com.aggmoread.sdk.z.d.a.a.c.t.b bVar = this.f5275h.f5873s;
            if (bVar != null) {
                xNativeView.setVideoMute(bVar.d());
            }
            xNativeView.setNativeItem(this.f5484w);
            xNativeView.setNativeViewClickListener(new b(this, aVar));
            xNativeView.setNativeVideoListener(new c(this, aVar));
            xNativeView.render();
        }
    }

    public void a(Context context, ViewGroup viewGroup, FrameLayout.LayoutParams layoutParams, List<View> list, List<View> list2, WeakReference<com.aggmoread.sdk.z.d.a.a.d.b.m.a> weakReference, f.a aVar) {
        NativeResponse nativeResponse = this.f5484w;
        if (nativeResponse == null || viewGroup == null) {
            return;
        }
        nativeResponse.registerViewForInteraction(viewGroup, list, list2, new a(weakReference, aVar, viewGroup));
    }

    public void a(View view, View[] viewArr) {
        l.a(this.f5275h.f5856b, this.f5281n, com.aggmoread.sdk.z.d.a.a.c.i.INFORMATION_FLOW, view, viewArr, this.f5322s, this.f5320q);
        l.b(this.f5275h.f5856b, this.f5276i.e(), this.f5276i.b());
        byte[] b10 = this.f5275h.f5872r.b();
        if (b10 != null) {
            l.a(this.f5275h.f5856b, b10);
        }
        l.a(this.f5281n, this.f5276i);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.a
    public void a(com.aggmoread.sdk.z.d.a.a.d.a.c cVar) {
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d
    public boolean a(View view) {
        String str = f5483y;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(" checkCustomMediaView bd ");
        boolean z10 = view instanceof XNativeView;
        sb2.append(z10);
        com.aggmoread.sdk.z.d.a.a.e.e.b(str, sb2.toString());
        return z10;
    }
}
