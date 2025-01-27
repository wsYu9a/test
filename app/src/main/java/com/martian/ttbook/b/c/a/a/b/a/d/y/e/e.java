package com.martian.ttbook.b.c.a.a.b.a.d.y.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.martian.ttbook.b.c.a.a.c.h;
import com.martian.ttbook.b.c.a.a.c.l.d;
import com.martian.ttbook.b.c.a.a.d.b.i;
import com.martian.ttbook.b.c.a.a.d.b.k;
import com.martian.ttbook.b.c.a.a.d.b.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class e extends com.martian.ttbook.b.c.a.a.b.a.d.f {
    private static final Object m = new Object();
    public TTFeedAd n;
    List<String> o;
    public WeakReference<com.martian.ttbook.b.c.a.a.d.b.m.a> p;
    public WeakReference q;
    public WeakReference<View> r;
    private AtomicBoolean s;

    class a implements TTNativeAd.AdInteractionListener {

        /* renamed from: a */
        final /* synthetic */ d.a f15499a;

        a(d.a aVar) {
            this.f15499a = aVar;
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdClicked(View view, TTNativeAd tTNativeAd) {
            e eVar = e.this;
            k kVar = new k(eVar.f15212c, eVar.f15213d);
            k c2 = kVar.c(k.b.n, e.this.f15210a);
            e eVar2 = e.this;
            com.martian.ttbook.b.c.a.a.d.b.e eVar3 = eVar2.f15213d;
            WeakReference<com.martian.ttbook.b.c.a.a.d.b.m.a> weakReference = eVar2.p;
            com.martian.ttbook.b.c.a.a.d.b.m.a aVar = weakReference == null ? null : weakReference.get();
            e eVar4 = e.this;
            boolean g2 = c2.g(eVar3, aVar, eVar4.f15215f, eVar4.f15218j);
            kVar.h();
            l.i(e.this.f15218j, false, true);
            if (g2) {
                this.f15499a.onAdClicked();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
            onAdClicked(view, tTNativeAd);
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdShow(TTNativeAd tTNativeAd) {
            if (e.this.s.compareAndSet(false, true)) {
                e.this.f15215f = System.currentTimeMillis();
                l.i(e.this.f15218j, true, true);
                e eVar = e.this;
                new k(eVar.f15212c, eVar.f15213d).a(5).c(k.b.n, e.this.f15210a).c(k.b.C, e.this.getTitle()).h();
                this.f15499a.onAdExposed();
            }
        }
    }

    class b implements TTFeedAd.VideoAdListener {

        /* renamed from: a */
        final /* synthetic */ com.martian.ttbook.b.c.a.a.c.q.a f15501a;

        b(com.martian.ttbook.b.c.a.a.c.q.a aVar) {
            this.f15501a = aVar;
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onProgressUpdate(long j2, long j3) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoAdComplete(TTFeedAd tTFeedAd) {
            this.f15501a.onVideoCompleted();
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoAdContinuePlay(TTFeedAd tTFeedAd) {
            this.f15501a.onVideoResume();
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoAdPaused(TTFeedAd tTFeedAd) {
            this.f15501a.onVideoPause();
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoAdStartPlay(TTFeedAd tTFeedAd) {
            this.f15501a.onVideoStart();
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoError(int i2, int i3) {
            this.f15501a.a(new i(i2, "ext " + i3));
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoLoad(TTFeedAd tTFeedAd) {
            this.f15501a.onVideoLoaded((int) e.this.n.getVideoDuration());
        }
    }

    public e(TTFeedAd tTFeedAd, com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar, Map<String, Object> map) {
        super(dVar, eVar, map);
        this.p = null;
        this.s = new AtomicBoolean();
        this.n = tTFeedAd;
        com.martian.ttbook.b.c.a.a.b.a.c cVar = dVar.t;
        com.martian.ttbook.b.c.a.a.b.a.d.y.a.d(this.l, tTFeedAd, eVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.martian.ttbook.b.c.a.a.d.b.m.a k(android.view.View r12, android.view.View r13, android.view.ViewGroup r14) {
        /*
            Method dump skipped, instructions count: 271
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.ttbook.b.c.a.a.b.a.d.y.e.e.k(android.view.View, android.view.View, android.view.ViewGroup):com.martian.ttbook.b.c.a.a.d.b.m.a");
    }

    private void p(ViewGroup viewGroup, com.martian.ttbook.b.c.a.a.c.q.a aVar) {
        if (viewGroup != null) {
            this.n.setVideoAdListener(new b(aVar));
            viewGroup.removeAllViews();
            viewGroup.addView(this.n.getAdView());
        }
    }

    private TTImage q() {
        if (isVideoAd()) {
            return this.n.getVideoCoverImage();
        }
        List<TTImage> imageList = this.n.getImageList();
        if (imageList == null || imageList.size() <= 0) {
            return null;
        }
        return imageList.get(0);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public void a(View view) {
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public void b() {
        this.n.destroy();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public int c() {
        return (int) this.n.getVideoDuration();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.a
    public void c(com.martian.ttbook.b.c.a.a.b.a.c cVar) {
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public int e() {
        TTImage q = q();
        if (q != null) {
            return q.getHeight();
        }
        return -1;
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public int f() {
        TTImage q = q();
        if (q != null) {
            return q.getWidth();
        }
        return -1;
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.d
    public List<String> g() {
        List<String> list = this.o;
        if (list != null) {
            return list;
        }
        this.o = new ArrayList();
        Iterator<TTImage> it = this.n.getImageList().iterator();
        while (it.hasNext()) {
            this.o.add(it.next().getImageUrl());
        }
        return this.o;
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public int getAdPatternType() {
        return this.n.getInteractionType();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public int getAppStatus() {
        return 0;
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.d
    public String getDesc() {
        return this.n.getDescription();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.d
    public String getIconUrl() {
        return this.n.getIcon().getImageUrl();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public String getImageUrl() {
        if (isVideoAd()) {
            return this.n.getVideoCoverImage().getImageUrl();
        }
        if (g().size() > 0) {
            return g().get(0);
        }
        return null;
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.d
    public String getTitle() {
        return this.n.getTitle();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public int getVideoCurrentPosition() {
        return 0;
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.d
    public View h(@NonNull Context context, @NonNull View view, Object obj, FrameLayout.LayoutParams layoutParams, List<View> list, View view2, @NonNull d.a aVar) {
        return j(context, view, layoutParams, list, view2, null, aVar);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public boolean isAppAd() {
        return this.n.getInteractionType() == 4;
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public boolean isVideoAd() {
        return this.n.getImageMode() == 5 || this.n.getImageMode() == 15;
    }

    public View j(@NonNull Context context, @NonNull View view, FrameLayout.LayoutParams layoutParams, List<View> list, View view2, View view3, @NonNull d.a aVar) {
        if (list == null) {
            list = new ArrayList<>();
        }
        List<View> list2 = list;
        View view4 = view3 != null ? view3 : view;
        com.martian.ttbook.b.c.a.a.e.d.g("CSJUNAD", list2.contains(view4) ? "ovov + true" : "ovov + false");
        if (com.martian.ttbook.b.c.a.a.e.i.g(this.f15213d) && !list2.contains(view4)) {
            com.martian.ttbook.b.c.a.a.e.d.g("CSJUNAD", "ovov ");
            list2.add(view4);
        }
        this.f15211b = aVar;
        FrameLayout frameLayout = new FrameLayout(context);
        com.martian.ttbook.b.c.a.a.d.b.m.a k = k(view, view3, frameLayout);
        m(context, frameLayout, layoutParams, list2, view2, aVar);
        WeakReference<com.martian.ttbook.b.c.a.a.d.b.m.a> weakReference = new WeakReference<>(k);
        this.p = weakReference;
        o(weakReference.get(), view2 != null ? new View[]{view2} : new View[0]);
        return k;
    }

    protected void m(Context context, ViewGroup viewGroup, FrameLayout.LayoutParams layoutParams, List<View> list, View view, d.a aVar) {
        if (this.n == null || viewGroup == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            arrayList.addAll(list);
        }
        this.n.registerViewForInteraction(viewGroup, list, arrayList, view, new a(aVar));
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public void n(@NonNull ViewGroup viewGroup, com.martian.ttbook.b.c.a.a.c.q.a aVar) {
        com.martian.ttbook.b.c.a.a.e.d.g("BMT", "ENTER");
        if (viewGroup != null) {
            p(viewGroup, aVar);
        }
    }

    protected void o(View view, View[] viewArr) {
        l.m(this.f15212c.f15668b, this.f15218j, h.INFORMATION_FLOW, view, viewArr, this.r, this.q);
        l.s(this.f15212c.f15668b, this.f15213d.e(), this.f15213d.b());
        byte[] h2 = this.f15212c.r.h();
        if (h2 != null) {
            l.j(this.f15212c.f15668b, h2);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public void pauseAppDownload() {
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public void pauseVideo() {
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public void resume() {
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public void resumeAppDownload() {
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public void resumeVideo() {
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public void setVideoMute(boolean z) {
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public void startVideo() {
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public void stopVideo() {
    }
}
