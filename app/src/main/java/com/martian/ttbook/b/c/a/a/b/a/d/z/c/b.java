package com.martian.ttbook.b.c.a.a.b.a.d.z.c;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import b.d.e.c.a.f.e;
import b.d.e.c.a.h.c;
import com.martian.ttbook.b.c.a.a.b.a.d.f;
import com.martian.ttbook.b.c.a.a.c.h;
import com.martian.ttbook.b.c.a.a.c.l.d;
import com.martian.ttbook.b.c.a.a.d.b.i;
import com.martian.ttbook.b.c.a.a.d.b.k;
import com.martian.ttbook.b.c.a.a.d.b.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class b extends f {
    private static final Object m = new Object();
    private String n;
    private c o;
    public WeakReference<View> p;
    public WeakReference q;

    class a implements b.d.e.c.a.h.f {

        /* renamed from: a */
        final /* synthetic */ d.a f15547a;

        a(d.a aVar) {
            this.f15547a = aVar;
        }

        @Override // b.d.e.c.a.g.b
        public void b(e eVar) {
            b.this.a(new i(eVar.a(), eVar.b()));
        }

        @Override // b.d.e.c.a.h.f
        public void onADClicked() {
            b bVar = b.this;
            k kVar = new k(bVar.f15212c, bVar.f15213d);
            k c2 = kVar.c(k.b.n, b.this.f15210a);
            b bVar2 = b.this;
            com.martian.ttbook.b.c.a.a.d.b.e eVar = bVar2.f15213d;
            WeakReference<com.martian.ttbook.b.c.a.a.d.b.m.a> weakReference = bVar2.k;
            com.martian.ttbook.b.c.a.a.d.b.m.a aVar = weakReference == null ? null : weakReference.get();
            b bVar3 = b.this;
            boolean g2 = c2.g(eVar, aVar, bVar3.f15215f, bVar3.f15218j);
            kVar.h();
            if (g2) {
                this.f15547a.onAdClicked();
            }
        }

        @Override // b.d.e.c.a.h.f
        public void onADExposed() {
            b.this.f15215f = System.currentTimeMillis();
            l.i(b.this.f15218j, true, true);
            b bVar = b.this;
            new k(bVar.f15212c, bVar.f15213d).a(5).c(k.b.n, b.this.f15210a).c(k.b.C, b.this.getTitle()).h();
            this.f15547a.onAdExposed();
        }
    }

    public b(c cVar, com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar, Map<String, Object> map) {
        super(dVar, eVar, map);
        this.n = "ADHTAG";
        this.o = cVar;
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
        throw new UnsupportedOperationException("Method not decompiled: com.martian.ttbook.b.c.a.a.b.a.d.z.c.b.l(android.view.View, android.view.View, android.view.ViewGroup):com.martian.ttbook.b.c.a.a.d.b.m.a");
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public void a(View view) {
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public void b() {
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public int c() {
        return 0;
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.a
    public void c(com.martian.ttbook.b.c.a.a.b.a.c cVar) {
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public int e() {
        return 0;
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public int f() {
        return 0;
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.d
    public List<String> g() {
        return this.o.getImageList();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public int getAdPatternType() {
        return 0;
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public int getAppStatus() {
        return 0;
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.d
    public String getDesc() {
        return this.o.getDesc();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.d
    public String getIconUrl() {
        return this.o.getIconUrl();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public String getImageUrl() {
        return this.o.getImageUrl();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.d
    public String getTitle() {
        return this.o.getTitle();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public int getVideoCurrentPosition() {
        return 0;
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.d
    public View h(@NonNull Context context, @NonNull View view, Object obj, FrameLayout.LayoutParams layoutParams, List<View> list, View view2, @NonNull d.a aVar) {
        this.q = new WeakReference(obj);
        return k(context, view, layoutParams, list, view2, aVar);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public boolean isAppAd() {
        return this.o.isAppAd();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public boolean isVideoAd() {
        return false;
    }

    public View j(@NonNull Context context, @NonNull View view, FrameLayout.LayoutParams layoutParams, List<View> list, View view2, View view3, @NonNull d.a aVar) {
        String str;
        String str2;
        if (list == null) {
            list = new ArrayList<>();
        }
        View view4 = view3 != null ? view3 : view;
        if (list.contains(view4)) {
            str = this.n;
            str2 = "ovov + true";
        } else {
            str = this.n;
            str2 = "ovov + false";
        }
        com.martian.ttbook.b.c.a.a.e.d.g(str, str2);
        if (com.martian.ttbook.b.c.a.a.e.i.g(this.f15213d) && !list.contains(view4)) {
            com.martian.ttbook.b.c.a.a.e.d.g(this.n, "ovov ");
            list.add(view4);
        }
        this.f15211b = aVar;
        com.martian.ttbook.b.a.q.b bVar = new com.martian.ttbook.b.a.q.b(context);
        com.martian.ttbook.b.c.a.a.d.b.m.a l = l(view, view3, bVar);
        this.o.b(bVar, list, new a(aVar));
        m(this.k.get(), view2 != null ? new View[]{view2} : new View[0]);
        return l;
    }

    public View k(@NonNull Context context, @NonNull View view, FrameLayout.LayoutParams layoutParams, List<View> list, View view2, @NonNull d.a aVar) {
        return j(context, view, layoutParams, list, view2, null, aVar);
    }

    protected void m(View view, View[] viewArr) {
        l.m(this.f15212c.f15668b, this.f15218j, h.INFORMATION_FLOW, view, viewArr, this.p, this.q);
        l.s(this.f15212c.f15668b, this.f15213d.e(), this.f15213d.b());
        byte[] h2 = this.f15212c.r.h();
        if (h2 != null) {
            l.j(this.f15212c.f15668b, h2);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.f, com.martian.ttbook.b.c.a.a.c.l.d
    public void n(@NonNull ViewGroup viewGroup, com.martian.ttbook.b.c.a.a.c.q.a aVar) {
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
