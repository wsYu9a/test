package com.aggmoread.sdk.z.d.a.a.d.a.d.s.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.aggmoread.sdk.z.d.a.a.c.c;
import com.aggmoread.sdk.z.d.a.a.c.o.f;
import com.aggmoread.sdk.z.d.a.a.d.a.d.d;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.i;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import com.aggmoread.sdk.z.d.a.a.d.b.l;
import com.aggmoread.sdk.z.d.a.a.e.m;
import com.bytedance.sdk.openadsdk.ComplianceInfo;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class b extends d {

    /* renamed from: w */
    public TTFeedAd f5646w;

    /* renamed from: x */
    List<String> f5647x;

    /* renamed from: y */
    private AtomicBoolean f5648y;

    public class a implements TTNativeAd.AdInteractionListener {

        /* renamed from: a */
        final /* synthetic */ f.a f5649a;

        public a(f.a aVar) {
            this.f5649a = aVar;
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdClicked(View view, TTNativeAd tTNativeAd) {
            b bVar = b.this;
            k kVar = new k(bVar.f5275h, bVar.f5276i);
            k a10 = kVar.a(k.b.f6046n, b.this.f5273f);
            b bVar2 = b.this;
            e eVar = bVar2.f5276i;
            WeakReference<com.aggmoread.sdk.z.d.a.a.d.b.m.a> weakReference = bVar2.f5282o;
            com.aggmoread.sdk.z.d.a.a.d.b.m.a aVar = weakReference == null ? null : weakReference.get();
            b bVar3 = b.this;
            boolean a11 = a10.a(eVar, aVar, bVar3.f5278k, bVar3.f5281n);
            kVar.b();
            l.a((Object) b.this.f5281n, false, true);
            if (a11) {
                this.f5649a.onAdClicked();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
            onAdClicked(view, tTNativeAd);
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdShow(TTNativeAd tTNativeAd) {
            if (b.this.f5648y.compareAndSet(false, true)) {
                b.this.f5278k = System.currentTimeMillis();
                l.a((Object) b.this.f5281n, true, true);
                b.this.a(this.f5649a);
            }
        }
    }

    /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.s.e.b$b */
    public class C0156b implements TTFeedAd.VideoAdListener {

        /* renamed from: a */
        final /* synthetic */ com.aggmoread.sdk.z.d.a.a.c.t.a f5651a;

        public C0156b(com.aggmoread.sdk.z.d.a.a.c.t.a aVar) {
            this.f5651a = aVar;
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onProgressUpdate(long j10, long j11) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoAdComplete(TTFeedAd tTFeedAd) {
            this.f5651a.onVideoCompleted();
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoAdContinuePlay(TTFeedAd tTFeedAd) {
            this.f5651a.onVideoResume();
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoAdPaused(TTFeedAd tTFeedAd) {
            this.f5651a.onVideoPause();
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoAdStartPlay(TTFeedAd tTFeedAd) {
            this.f5651a.onVideoStart();
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoError(int i10, int i11) {
            this.f5651a.a(new i(i10, "ext " + i11));
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoLoad(TTFeedAd tTFeedAd) {
            this.f5651a.onVideoLoaded((int) b.this.f5646w.getVideoDuration());
        }
    }

    public b(TTFeedAd tTFeedAd, com.aggmoread.sdk.z.d.a.a.d.b.d dVar, e eVar, Map<String, Object> map) {
        super(dVar, eVar, map);
        this.f5648y = new AtomicBoolean();
        this.f5646w = tTFeedAd;
        com.aggmoread.sdk.z.d.a.a.d.a.c cVar = dVar.f5874t;
        com.aggmoread.sdk.z.d.a.a.d.a.d.s.a.a(this.f5319p, tTFeedAd, eVar);
    }

    private TTImage e() {
        if (isVideoAd()) {
            return this.f5646w.getVideoCoverImage();
        }
        List<TTImage> imageList = this.f5646w.getImageList();
        if (imageList == null || imageList.size() <= 0) {
            return null;
        }
        return imageList.get(0);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d
    public View a(@NonNull Context context, @NonNull View view, FrameLayout.LayoutParams layoutParams, List<View> list, View view2, List<View> list2, View view3, @NonNull f.a aVar) {
        com.aggmoread.sdk.z.d.a.a.d.b.m.a aVar2;
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        if (list == null) {
            list = new ArrayList<>();
        }
        List<View> list3 = list;
        View view4 = view3 != null ? view3 : view;
        com.aggmoread.sdk.z.d.a.a.e.e.b("CSJUNAD", list3.contains(view4) ? "ovov + true" : "ovov + false");
        if (m.a(this.f5276i) && !list3.contains(view4)) {
            com.aggmoread.sdk.z.d.a.a.e.e.b("CSJUNAD", "ovov ");
            list3.add(view4);
        }
        this.f5274g = aVar;
        if ((view instanceof com.aggmoread.sdk.z.d.a.a.d.b.m.a) && this.f5323t) {
            aVar2 = (com.aggmoread.sdk.z.d.a.a.d.b.m.a) view;
            viewGroup = (ViewGroup) aVar2.findViewWithTag(d.f5317u);
            com.aggmoread.sdk.z.d.a.a.e.e.b("CSJUNAD", "f n " + viewGroup);
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
        a(context, viewGroup2, layoutParams, list3, view2, aVar);
        a(this.f5282o.get(), view2 != null ? new View[]{view2} : new View[0]);
        return aVar2;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d
    public void b(ViewGroup viewGroup, com.aggmoread.sdk.z.d.a.a.c.t.a aVar) {
        if (viewGroup != null) {
            this.f5646w.setVideoAdListener(new C0156b(aVar));
            viewGroup.removeAllViews();
            viewGroup.addView(this.f5646w.getAdView());
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public void destroy() {
        this.f5646w.destroy();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public int f() {
        return (int) this.f5646w.getVideoDuration();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public com.aggmoread.sdk.z.d.a.a.c.c g() {
        return a(this.f5646w);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public int getAdPatternType() {
        return this.f5646w.getInteractionType();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public double getAppPrice() {
        return l5.c.f27899e;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public int getAppScore() {
        return this.f5646w.getAppScore();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public int getAppStatus() {
        return 0;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public String getDesc() {
        return this.f5646w.getDescription();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public long getDownloadCount() {
        return 1L;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public String getIconUrl() {
        return this.f5646w.getIcon().getImageUrl();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public String getImageUrl() {
        if (isVideoAd()) {
            return this.f5646w.getVideoCoverImage().getImageUrl();
        }
        if (getImageUrlList().size() > 0) {
            return getImageUrlList().get(0);
        }
        return null;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public List<String> getImageUrlList() {
        List<String> list = this.f5647x;
        if (list != null) {
            return list;
        }
        this.f5647x = new ArrayList();
        Iterator<TTImage> it = this.f5646w.getImageList().iterator();
        while (it.hasNext()) {
            this.f5647x.add(it.next().getImageUrl());
        }
        return this.f5647x;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public int getPictureHeight() {
        TTImage e10 = e();
        if (e10 != null) {
            return e10.getHeight();
        }
        return -1;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public int getPictureWidth() {
        TTImage e10 = e();
        if (e10 != null) {
            return e10.getWidth();
        }
        return -1;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public int getProgress() {
        return 0;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public String getTitle() {
        return this.f5646w.getTitle();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public int getVideoCurrentPosition() {
        return 0;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public boolean isAppAd() {
        return this.f5646w.getInteractionType() == 4;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public boolean isVideoAd() {
        return this.f5646w.getImageMode() == 5 || this.f5646w.getImageMode() == 15;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public void pauseVideo() {
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public void resume() {
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public void resumeVideo() {
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public void setVideoMute(boolean z10) {
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public void startVideo() {
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public void stopVideo() {
    }

    private com.aggmoread.sdk.z.d.a.a.c.c a(TTFeedAd tTFeedAd) {
        ArrayList arrayList;
        if (tTFeedAd == null) {
            return null;
        }
        try {
            ComplianceInfo complianceInfo = tTFeedAd.getComplianceInfo();
            if (complianceInfo == null) {
                return null;
            }
            String appName = complianceInfo.getAppName();
            String appVersion = complianceInfo.getAppVersion();
            String developerName = complianceInfo.getDeveloperName();
            String privacyUrl = complianceInfo.getPrivacyUrl();
            Map<String, String> permissionsMap = complianceInfo.getPermissionsMap();
            if (permissionsMap == null || permissionsMap.isEmpty()) {
                arrayList = null;
            } else {
                ArrayList arrayList2 = new ArrayList();
                for (Map.Entry<String, String> entry : permissionsMap.entrySet()) {
                    arrayList2.add(new c.a(entry.getKey(), entry.getValue()));
                }
                arrayList = arrayList2;
            }
            return com.aggmoread.sdk.z.d.a.a.c.c.a(appName, developerName, -1L, arrayList, privacyUrl, appVersion);
        } catch (Exception e10) {
            com.aggmoread.sdk.z.d.a.a.e.e.b("CSJUNAD", "appMiiInfo err " + e10);
            return null;
        }
    }

    public void a(Context context, ViewGroup viewGroup, FrameLayout.LayoutParams layoutParams, List<View> list, View view, f.a aVar) {
        if (this.f5646w == null || viewGroup == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            arrayList.addAll(list);
        }
        this.f5646w.registerViewForInteraction(viewGroup, list, arrayList, view, new a(aVar));
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
}
