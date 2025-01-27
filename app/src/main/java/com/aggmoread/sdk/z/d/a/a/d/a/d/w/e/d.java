package com.aggmoread.sdk.z.d.a.a.d.a.d.w.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.aggmoread.sdk.z.b.g.e;
import com.aggmoread.sdk.z.b.l.e;
import com.aggmoread.sdk.z.b.l.f;
import com.aggmoread.sdk.z.b.t.e;
import com.aggmoread.sdk.z.b.u.g;
import com.aggmoread.sdk.z.d.a.a.c.o.f;
import com.aggmoread.sdk.z.d.a.a.d.b.i;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import com.aggmoread.sdk.z.d.a.a.d.b.l;
import com.aggmoread.sdk.z.d.a.a.e.m;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class d extends com.aggmoread.sdk.z.d.a.a.d.a.d.d {

    /* renamed from: w */
    private com.aggmoread.sdk.z.b.l.c f5823w;

    /* renamed from: x */
    private String f5824x;

    public class a implements f {

        /* renamed from: f */
        final /* synthetic */ f.a f5825f;

        public a(f.a aVar) {
            this.f5825f = aVar;
        }

        @Override // com.aggmoread.sdk.z.b.i.b
        public void a(e eVar) {
            d.this.a(new i(eVar.a(), eVar.b()));
        }

        @Override // com.aggmoread.sdk.z.b.l.f
        public void onADClicked() {
            d dVar = d.this;
            k kVar = new k(dVar.f5275h, dVar.f5276i);
            k a10 = kVar.a(k.b.f6046n, d.this.f5273f);
            d dVar2 = d.this;
            com.aggmoread.sdk.z.d.a.a.d.b.e eVar = dVar2.f5276i;
            WeakReference<com.aggmoread.sdk.z.d.a.a.d.b.m.a> weakReference = dVar2.f5282o;
            com.aggmoread.sdk.z.d.a.a.d.b.m.a aVar = weakReference == null ? null : weakReference.get();
            d dVar3 = d.this;
            boolean a11 = a10.a(eVar, aVar, dVar3.f5278k, dVar3.f5281n);
            kVar.b();
            if (a11) {
                this.f5825f.onAdClicked();
            }
        }

        @Override // com.aggmoread.sdk.z.b.l.f
        public void onADExposed() {
            d.this.f5278k = System.currentTimeMillis();
            l.a((Object) d.this.f5281n, true, true);
            d.this.a(this.f5825f);
        }
    }

    public class b implements e.a {

        /* renamed from: a */
        final /* synthetic */ com.aggmoread.sdk.z.d.a.a.c.t.a f5827a;

        public b(com.aggmoread.sdk.z.d.a.a.c.t.a aVar) {
            this.f5827a = aVar;
        }

        @Override // com.aggmoread.sdk.z.b.l.e.a
        public void a() {
            com.aggmoread.sdk.z.d.a.a.e.e.b(d.this.f5824x, "onMediaStart");
            com.aggmoread.sdk.z.d.a.a.c.t.a aVar = this.f5827a;
            if (aVar != null) {
                aVar.onVideoStart();
            }
        }

        @Override // com.aggmoread.sdk.z.b.l.e.a
        public void b() {
            com.aggmoread.sdk.z.d.a.a.e.e.b(d.this.f5824x, "onMediaReady ");
            com.aggmoread.sdk.z.d.a.a.c.t.a aVar = this.f5827a;
            if (aVar != null) {
                aVar.onVideoReady();
            }
        }

        @Override // com.aggmoread.sdk.z.b.l.e.a
        public void c() {
            com.aggmoread.sdk.z.d.a.a.e.e.b(d.this.f5824x, "onMediaCompleted ");
            com.aggmoread.sdk.z.d.a.a.c.t.a aVar = this.f5827a;
            if (aVar != null) {
                aVar.onVideoCompleted();
            }
        }

        @Override // com.aggmoread.sdk.z.b.l.e.a
        public void d() {
            com.aggmoread.sdk.z.d.a.a.e.e.b(d.this.f5824x, "onMediaLoading");
            com.aggmoread.sdk.z.d.a.a.c.t.a aVar = this.f5827a;
            if (aVar != null) {
                aVar.onVideoLoading();
            }
        }

        @Override // com.aggmoread.sdk.z.b.l.e.a
        public void e() {
            com.aggmoread.sdk.z.d.a.a.e.e.b(d.this.f5824x, "onMediaResume");
            com.aggmoread.sdk.z.d.a.a.c.t.a aVar = this.f5827a;
            if (aVar != null) {
                aVar.onVideoResume();
            }
        }

        @Override // com.aggmoread.sdk.z.b.l.e.a
        public void f() {
            com.aggmoread.sdk.z.d.a.a.e.e.b(d.this.f5824x, "onMediaPause ");
            com.aggmoread.sdk.z.d.a.a.c.t.a aVar = this.f5827a;
            if (aVar != null) {
                aVar.onVideoPause();
            }
        }

        @Override // com.aggmoread.sdk.z.b.l.e.a
        public void a(int i10) {
            com.aggmoread.sdk.z.d.a.a.e.e.b(d.this.f5824x, "onMediaLoaded");
            com.aggmoread.sdk.z.d.a.a.c.t.a aVar = this.f5827a;
            if (aVar != null) {
                aVar.onVideoLoaded(i10);
            }
        }

        @Override // com.aggmoread.sdk.z.b.l.e.a
        public void a(com.aggmoread.sdk.z.b.g.e eVar) {
            com.aggmoread.sdk.z.d.a.a.e.e.b(d.this.f5824x, " onMediaError err " + eVar.toString());
            com.aggmoread.sdk.z.d.a.a.c.t.a aVar = this.f5827a;
            if (aVar != null) {
                aVar.a(new i(eVar.a(), eVar.b()));
            }
        }
    }

    public d(com.aggmoread.sdk.z.b.l.c cVar, com.aggmoread.sdk.z.d.a.a.d.b.d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar, Map<String, Object> map) {
        super(dVar, eVar, map);
        this.f5824x = "AMHTAG";
        this.f5823w = cVar;
        if (cVar instanceof com.aggmoread.sdk.z.e.i.b) {
            com.aggmoread.sdk.z.d.a.a.d.a.d.w.a.b(this.f5319p, ((com.aggmoread.sdk.z.e.i.b) cVar).g(), eVar);
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d
    public View a(@NonNull Context context, @NonNull View view, FrameLayout.LayoutParams layoutParams, List<View> list, View view2, List<View> list2, View view3, @NonNull f.a aVar) {
        String str;
        String str2;
        com.aggmoread.sdk.z.d.a.a.d.b.m.a aVar2;
        com.aggmoread.sdk.z.b.u.d dVar;
        if (list == null) {
            list = new ArrayList<>();
        }
        View view4 = view3 != null ? view3 : view;
        if (list.contains(view4)) {
            str = this.f5824x;
            str2 = "ovov + true";
        } else {
            str = this.f5824x;
            str2 = "ovov + false";
        }
        com.aggmoread.sdk.z.d.a.a.e.e.b(str, str2);
        if (m.a(this.f5276i) && !list.contains(view4)) {
            com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5824x, "ovov ");
            list.add(view4);
        }
        this.f5274g = aVar;
        if ((view instanceof com.aggmoread.sdk.z.d.a.a.d.b.m.a) && this.f5323t) {
            aVar2 = (com.aggmoread.sdk.z.d.a.a.d.b.m.a) view;
            dVar = (com.aggmoread.sdk.z.b.u.d) aVar2.findViewWithTag(com.aggmoread.sdk.z.d.a.a.d.a.d.d.f5317u);
            com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5824x, "f n " + dVar);
        } else {
            aVar2 = null;
            dVar = null;
        }
        if (aVar2 == null || dVar == null) {
            dVar = (com.aggmoread.sdk.z.b.u.d) a(context);
            aVar2 = a(view, view3, dVar);
        }
        this.f5823w.a(dVar, list, new a(aVar));
        a(this.f5282o.get(), view2 != null ? new View[]{view2} : new View[0]);
        return aVar2;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d
    public ViewGroup b(Context context) {
        return new g(context);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public void destroy() {
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public int f() {
        return this.f5823w.getVideoDuration();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public int getAdPatternType() {
        return 0;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public double getAppPrice() {
        return l5.c.f27899e;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public int getAppScore() {
        return 0;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public int getAppStatus() {
        return 0;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public String getDesc() {
        return this.f5823w.getDesc();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public long getDownloadCount() {
        return 0L;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public String getIconUrl() {
        return this.f5823w.getIconUrl();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public String getImageUrl() {
        return this.f5823w.getImageUrl();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public List<String> getImageUrlList() {
        return this.f5823w.b();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public int getPictureHeight() {
        return 0;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public int getPictureWidth() {
        return 0;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public int getProgress() {
        return 0;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public String getTitle() {
        return this.f5823w.getTitle();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public int getVideoCurrentPosition() {
        return this.f5823w.getVideoCurrentPosition();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public boolean isAppAd() {
        return this.f5823w.isAppAd();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public boolean isVideoAd() {
        return this.f5823w.isVideoAd();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public void pauseVideo() {
        this.f5823w.pauseVideo();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public void resume() {
        this.f5823w.resume();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public void resumeVideo() {
        this.f5823w.resumeVideo();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public void setVideoMute(boolean z10) {
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public void startVideo() {
        this.f5823w.startVideo();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public void stopVideo() {
        this.f5823w.stopVideo();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d
    public ViewGroup a(Context context) {
        return new com.aggmoread.sdk.z.b.u.d(context);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d
    public void b(ViewGroup viewGroup, com.aggmoread.sdk.z.d.a.a.c.t.a aVar) {
        com.aggmoread.sdk.z.d.a.a.c.t.b bVar = this.f5275h.f5873s;
        e.b bVar2 = new e.b();
        if (bVar != null) {
            bVar2.a(bVar.d());
            bVar2.a(bVar.a());
            bVar2.b(bVar.f());
            bVar2.c(bVar.g());
            bVar2.d(bVar.h());
        }
        if (viewGroup instanceof g) {
            this.f5823w.a((g) viewGroup, bVar2.a(), new b(aVar));
        }
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
        return view instanceof g;
    }
}
