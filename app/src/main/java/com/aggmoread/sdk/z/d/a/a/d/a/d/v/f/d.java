package com.aggmoread.sdk.z.d.a.a.d.a.d.v.f;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.aggmoread.sdk.z.d.a.a.c.o.f;
import com.aggmoread.sdk.z.d.a.a.d.a.d.v.f.f;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.i;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import com.aggmoread.sdk.z.d.a.a.d.b.l;
import com.aggmoread.sdk.z.d.a.a.e.m;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class d extends com.aggmoread.sdk.z.d.a.a.d.a.d.d {

    /* renamed from: x */
    protected static String f5766x = "AMUTAGKS";

    /* renamed from: w */
    public KsNativeAd f5767w;

    public class a implements KsAppDownloadListener {

        /* renamed from: a */
        final /* synthetic */ f.a f5768a;

        public a(d dVar, f.a aVar) {
            this.f5768a = aVar;
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFailed() {
            f.a aVar = this.f5768a;
            if (aVar instanceof f.b) {
                ((f.b) aVar).onADStatusChanged(16);
            }
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFinished() {
            f.a aVar = this.f5768a;
            if (aVar instanceof f.b) {
                ((f.b) aVar).onADStatusChanged(8);
            }
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadStarted() {
            f.a aVar = this.f5768a;
            if (aVar instanceof f.b) {
                ((f.b) aVar).onADStatusChanged(4);
            }
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onIdle() {
            f.a aVar = this.f5768a;
            if (aVar instanceof f.b) {
                ((f.b) aVar).onADStatusChanged(0);
            }
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onInstalled() {
            f.a aVar = this.f5768a;
            if (aVar instanceof f.b) {
                ((f.b) aVar).onADStatusChanged(1);
            }
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onProgressUpdate(int i10) {
            com.aggmoread.sdk.z.d.a.a.e.e.b(d.f5766x, "onADStatusChanged");
            f.a aVar = this.f5768a;
            if (aVar instanceof f.b) {
                ((f.b) aVar).onLoadApkProgress(i10);
            }
        }
    }

    public class b implements e {

        /* renamed from: a */
        final /* synthetic */ WeakReference f5769a;

        /* renamed from: b */
        final /* synthetic */ f.a f5770b;

        public b(WeakReference weakReference, f.a aVar) {
            this.f5769a = weakReference;
            this.f5770b = aVar;
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.v.f.d.e
        public void a(View view, KsNativeAd ksNativeAd) {
            com.aggmoread.sdk.z.d.a.a.e.e.b(d.f5766x, "onADClicked");
            d dVar = d.this;
            dVar.f5277j++;
            k kVar = new k(dVar.f5275h, dVar.f5276i);
            k a10 = kVar.a(k.b.f6046n, d.this.f5273f);
            com.aggmoread.sdk.z.d.a.a.d.b.e eVar = d.this.f5276i;
            WeakReference weakReference = this.f5769a;
            com.aggmoread.sdk.z.d.a.a.d.b.m.a aVar = weakReference == null ? null : (com.aggmoread.sdk.z.d.a.a.d.b.m.a) weakReference.get();
            d dVar2 = d.this;
            boolean a11 = a10.a(eVar, aVar, dVar2.f5278k, dVar2.f5281n);
            kVar.b();
            l.a((Object) d.this.f5281n, false, true);
            if (a11) {
                this.f5770b.onAdClicked();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.v.f.d.e
        public void onDownloadTipsDialogDismiss() {
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.v.f.d.e
        public void onDownloadTipsDialogShow() {
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.v.f.d.e
        public void a(KsNativeAd ksNativeAd) {
            com.aggmoread.sdk.z.d.a.a.e.e.b(d.f5766x, "onADExposed ");
            HashMap hashMap = new HashMap();
            d.this.f5278k = System.currentTimeMillis();
            hashMap.put(com.aggmoread.sdk.z.d.a.a.e.k.f6102a, d.this.f5276i.f5906b.a(e.c.f5928f, "-1"));
            l.a((Object) d.this.f5281n, true, true);
            d.this.a(this.f5770b);
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.v.f.d.e
        public boolean a(DialogInterface.OnClickListener onClickListener) {
            return false;
        }
    }

    public class c implements f.a {

        /* renamed from: a */
        final /* synthetic */ com.aggmoread.sdk.z.d.a.a.c.t.a f5772a;

        public c(d dVar, com.aggmoread.sdk.z.d.a.a.c.t.a aVar) {
            this.f5772a = aVar;
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.v.f.f.a
        public void a() {
            this.f5772a.onVideoCompleted();
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.v.f.f.a
        public void b() {
            this.f5772a.onVideoReady();
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.v.f.f.a
        public void c() {
            this.f5772a.onVideoPause();
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.v.f.f.a
        public void d() {
            this.f5772a.onVideoResume();
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.v.f.f.a
        public void onVideoPlayError(int i10, int i11) {
            this.f5772a.a(new i(i10, "msg:" + i11));
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.v.f.f.a
        public void onVideoPlayStart() {
            this.f5772a.onVideoStart();
        }
    }

    /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.v.f.d$d */
    public class C0172d implements InvocationHandler {

        /* renamed from: a */
        private e f5773a;

        public C0172d(d dVar, e eVar) {
            this.f5773a = eVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            if ("onAdClicked".equals(name)) {
                this.f5773a.a((View) objArr[0], (KsNativeAd) objArr[1]);
                return null;
            }
            if ("onAdShow".equals(name)) {
                this.f5773a.a((KsNativeAd) objArr[0]);
                return null;
            }
            if ("handleDownloadDialog".equals(name)) {
                return Boolean.valueOf(this.f5773a.a((DialogInterface.OnClickListener) objArr[0]));
            }
            if ("onDownloadTipsDialogShow".equals(name)) {
                this.f5773a.onDownloadTipsDialogShow();
                return null;
            }
            if (!"onDownloadTipsDialogDismiss".equals(name)) {
                return null;
            }
            this.f5773a.onDownloadTipsDialogDismiss();
            return null;
        }
    }

    public interface e {
        void a(View view, KsNativeAd ksNativeAd);

        void a(KsNativeAd ksNativeAd);

        boolean a(DialogInterface.OnClickListener onClickListener);

        void onDownloadTipsDialogDismiss();

        void onDownloadTipsDialogShow();
    }

    public d(KsNativeAd ksNativeAd, com.aggmoread.sdk.z.d.a.a.d.b.d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar, Map<String, Object> map) {
        super(dVar, eVar, map);
        this.f5767w = ksNativeAd;
        com.aggmoread.sdk.z.d.a.a.d.a.c cVar = dVar.f5874t;
        com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.b(this.f5319p, com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.a(ksNativeAd), eVar);
    }

    private com.aggmoread.sdk.z.d.a.a.c.c e() {
        try {
            com.aggmoread.sdk.z.d.a.a.c.c a10 = com.aggmoread.sdk.z.d.a.a.c.c.a(this.f5767w.getAppName(), this.f5767w.getProductName(), this.f5767w.getAppPackageSize(), this.f5767w.getPermissionInfoUrl(), this.f5767w.getAppPrivacyUrl(), this.f5767w.getAppVersion());
            a10.c(this.f5767w.getAppPackageName());
            a10.a(this.f5767w.getIntroductionInfoUrl());
            return a10;
        } catch (Exception e10) {
            com.aggmoread.sdk.z.d.a.a.e.e.b(f5766x, "err " + e10);
            return null;
        }
    }

    private void i() {
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d
    public View a(@NonNull Context context, @NonNull View view, FrameLayout.LayoutParams layoutParams, List<View> list, View view2, List<View> list2, View view3, @NonNull f.a aVar) {
        String str;
        String str2;
        com.aggmoread.sdk.z.d.a.a.d.b.m.a aVar2;
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5766x, "enter");
        if (list == null) {
            list = new ArrayList<>();
        }
        List<View> list3 = list;
        View view4 = view3 != null ? view3 : view;
        if (list3.contains(view4)) {
            str = f5766x;
            str2 = "ovov + true";
        } else {
            str = f5766x;
            str2 = "ovov + false";
        }
        com.aggmoread.sdk.z.d.a.a.e.e.b(str, str2);
        if (m.a(this.f5276i) && !list3.contains(view4)) {
            com.aggmoread.sdk.z.d.a.a.e.e.b(f5766x, "ovov ");
            list3.add(view4);
        }
        this.f5274g = aVar;
        if ((view instanceof com.aggmoread.sdk.z.d.a.a.d.b.m.a) && this.f5323t) {
            aVar2 = (com.aggmoread.sdk.z.d.a.a.d.b.m.a) view;
            viewGroup = (ViewGroup) aVar2.findViewWithTag(com.aggmoread.sdk.z.d.a.a.d.a.d.d.f5317u);
            com.aggmoread.sdk.z.d.a.a.e.e.b(f5766x, "f n " + viewGroup);
        } else {
            aVar2 = null;
            viewGroup = null;
        }
        if (aVar2 == null || viewGroup == null) {
            ViewGroup a10 = a(context);
            viewGroup2 = a10;
            aVar2 = a(view, view3, a10);
        } else {
            viewGroup2 = viewGroup;
        }
        a(context, viewGroup2, layoutParams, list3, this.f5282o, aVar);
        a(this.f5282o.get(), view2 != null ? new View[]{view2} : new View[0]);
        return aVar2;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d
    public void b(int i10) {
        super.b(i10);
        com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.b(this.f5767w, i10);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public int f() {
        return this.f5767w.getVideoDuration();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public com.aggmoread.sdk.z.d.a.a.c.c g() {
        return e();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public int getAdPatternType() {
        return com.aggmoread.sdk.z.d.a.a.d.a.d.v.d.a(this.f5767w.getMaterialType());
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public int getAppScore() {
        return (int) this.f5767w.getAppScore();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public String getCTAText() {
        return this.f5767w.getActionDescription();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public String getDesc() {
        return this.f5767w.getAdDescription();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public String getIconUrl() {
        return this.f5767w.getAppIconUrl();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public String getImageUrl() {
        List<String> imageUrlList = getImageUrlList();
        return (imageUrlList == null || imageUrlList.isEmpty()) ? "" : imageUrlList.get(0);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public List<String> getImageUrlList() {
        ArrayList arrayList = new ArrayList();
        if (this.f5767w.getImageList() != null) {
            Iterator<KsImage> it = this.f5767w.getImageList().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getImageUrl());
            }
        }
        return arrayList;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public int getPictureHeight() {
        List<KsImage> imageList = this.f5767w.getImageList();
        return (imageList == null || imageList.size() <= 0) ? super.getPictureHeight() : imageList.get(0).getHeight();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public int getPictureWidth() {
        List<KsImage> imageList = this.f5767w.getImageList();
        return (imageList == null || imageList.size() <= 0) ? super.getPictureWidth() : imageList.get(0).getWidth();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public String getTitle() {
        String appName = this.f5767w.getAppName();
        return !TextUtils.isEmpty(appName) ? appName : this.f5767w.getProductName();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public boolean isAppAd() {
        return this.f5767w.getInteractionType() == 1;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public boolean isVideoAd() {
        return this.f5767w.getMaterialType() == 1;
    }

    public void a(Context context, ViewGroup viewGroup, FrameLayout.LayoutParams layoutParams, List<View> list, WeakReference<com.aggmoread.sdk.z.d.a.a.d.b.m.a> weakReference, f.a aVar) {
        KsNativeAd ksNativeAd = this.f5767w;
        if (ksNativeAd == null || viewGroup == null) {
            return;
        }
        ksNativeAd.setDownloadListener(new a(this, aVar));
        KsNativeAd.AdInteractionListener adInteractionListener = (KsNativeAd.AdInteractionListener) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{KsNativeAd.AdInteractionListener.class}, new C0172d(this, new b(weakReference, aVar)));
        i();
        this.f5767w.registerViewForInteraction(viewGroup, list, adInteractionListener);
        for (View view : list) {
            com.aggmoread.sdk.z.d.a.a.e.e.b(f5766x, "clickView " + view);
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d
    public void b(int i10, int i11, String str) {
        com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.a(this.f5767w, i11);
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

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d
    public void b(ViewGroup viewGroup, com.aggmoread.sdk.z.d.a.a.c.t.a aVar) {
        KsAdVideoPlayConfig ksAdVideoPlayConfig;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            this.f5767w.setVideoPlayListener(new f().a(new c(this, aVar)));
            com.aggmoread.sdk.z.d.a.a.c.t.b bVar = this.f5275h.f5873s;
            if (bVar != null) {
                KsAdVideoPlayConfig.Builder builder = new KsAdVideoPlayConfig.Builder();
                builder.videoSoundEnable(!bVar.d());
                builder.dataFlowAutoStart(bVar.a() == 1);
                ksAdVideoPlayConfig = builder.build();
            } else {
                ksAdVideoPlayConfig = null;
            }
            View videoView = this.f5767w.getVideoView(viewGroup.getContext().getApplicationContext(), ksAdVideoPlayConfig);
            if (videoView != null) {
                ViewParent parent = videoView.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(videoView);
                }
                viewGroup.addView(videoView);
            }
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.a
    public void a(com.aggmoread.sdk.z.d.a.a.d.a.c cVar) {
    }
}
