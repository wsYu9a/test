package com.aggmoread.sdk.z.d.a.a.d.a.d.t.c;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.aggmoread.sdk.z.b.g.e;
import com.aggmoread.sdk.z.b.l.c;
import com.aggmoread.sdk.z.b.l.f;
import com.aggmoread.sdk.z.d.a.a.c.o.f;
import com.aggmoread.sdk.z.d.a.a.d.a.d.d;
import com.aggmoread.sdk.z.d.a.a.d.b.i;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import com.aggmoread.sdk.z.d.a.a.d.b.l;
import com.aggmoread.sdk.z.d.a.a.e.m;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class b extends d {

    /* renamed from: w */
    private String f5656w;

    /* renamed from: x */
    private c f5657x;

    public class a implements f {

        /* renamed from: f */
        final /* synthetic */ f.a f5658f;

        public a(f.a aVar) {
            this.f5658f = aVar;
        }

        @Override // com.aggmoread.sdk.z.b.i.b
        public void a(e eVar) {
            b.this.a(new i(eVar.a(), eVar.b()));
        }

        @Override // com.aggmoread.sdk.z.b.l.f
        public void onADClicked() {
            b bVar = b.this;
            k kVar = new k(bVar.f5275h, bVar.f5276i);
            k a10 = kVar.a(k.b.f6046n, b.this.f5273f);
            b bVar2 = b.this;
            com.aggmoread.sdk.z.d.a.a.d.b.e eVar = bVar2.f5276i;
            WeakReference<com.aggmoread.sdk.z.d.a.a.d.b.m.a> weakReference = bVar2.f5282o;
            com.aggmoread.sdk.z.d.a.a.d.b.m.a aVar = weakReference == null ? null : weakReference.get();
            b bVar3 = b.this;
            boolean a11 = a10.a(eVar, aVar, bVar3.f5278k, bVar3.f5281n);
            kVar.b();
            if (a11) {
                this.f5658f.onAdClicked();
            }
        }

        @Override // com.aggmoread.sdk.z.b.l.f
        public void onADExposed() {
            b.this.f5278k = System.currentTimeMillis();
            l.a((Object) b.this.f5281n, true, true);
            b.this.a(this.f5658f);
        }
    }

    public b(c cVar, com.aggmoread.sdk.z.d.a.a.d.b.d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar, Map<String, Object> map) {
        super(dVar, eVar, map);
        this.f5656w = "AMHTAG";
        this.f5657x = cVar;
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
            str = this.f5656w;
            str2 = "ovov + true";
        } else {
            str = this.f5656w;
            str2 = "ovov + false";
        }
        com.aggmoread.sdk.z.d.a.a.e.e.b(str, str2);
        if (m.a(this.f5276i) && !list.contains(view4)) {
            com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5656w, "ovov ");
            list.add(view4);
        }
        this.f5274g = aVar;
        if ((view instanceof com.aggmoread.sdk.z.d.a.a.d.b.m.a) && this.f5323t) {
            aVar2 = (com.aggmoread.sdk.z.d.a.a.d.b.m.a) view;
            dVar = (com.aggmoread.sdk.z.b.u.d) aVar2.findViewWithTag(d.f5317u);
            com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5656w, "f n " + dVar);
        } else {
            aVar2 = null;
            dVar = null;
        }
        if (aVar2 == null || dVar == null) {
            dVar = (com.aggmoread.sdk.z.b.u.d) a(context);
            aVar2 = a(view, view3, dVar);
        }
        this.f5657x.a(dVar, list, new a(aVar));
        a(this.f5282o.get(), view2 != null ? new View[]{view2} : new View[0]);
        return aVar2;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public void destroy() {
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public int f() {
        return 0;
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
        return this.f5657x.getDesc();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public long getDownloadCount() {
        return 0L;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public String getIconUrl() {
        return this.f5657x.getIconUrl();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public String getImageUrl() {
        return this.f5657x.getImageUrl();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public List<String> getImageUrlList() {
        return this.f5657x.b();
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
        return this.f5657x.getTitle();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public int getVideoCurrentPosition() {
        return 0;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public boolean isAppAd() {
        return this.f5657x.isAppAd();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public boolean isVideoAd() {
        return false;
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

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d
    public ViewGroup a(Context context) {
        return new com.aggmoread.sdk.z.b.u.d(context);
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

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.o.f
    public void a(@NonNull ViewGroup viewGroup, com.aggmoread.sdk.z.d.a.a.c.t.a aVar) {
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.d, com.aggmoread.sdk.z.d.a.a.c.a
    public void a(com.aggmoread.sdk.z.d.a.a.d.a.c cVar) {
    }
}
