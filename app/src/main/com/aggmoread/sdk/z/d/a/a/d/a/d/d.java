package com.aggmoread.sdk.z.d.a.a.d.a.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.aggmoread.sdk.client.AMConst;
import com.aggmoread.sdk.z.d.a.a.c.o.f;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class d extends com.aggmoread.sdk.z.d.a.a.d.a.a implements com.aggmoread.sdk.z.d.a.a.c.o.f {

    /* renamed from: u */
    protected static final Object f5317u = new Object();

    /* renamed from: v */
    protected static final Object f5318v = new Object();

    /* renamed from: p */
    public Map<String, Object> f5319p;

    /* renamed from: q */
    public WeakReference f5320q;

    /* renamed from: r */
    protected com.aggmoread.sdk.z.d.a.a.d.a.c f5321r;

    /* renamed from: s */
    public WeakReference<View> f5322s;

    /* renamed from: t */
    protected boolean f5323t;

    public d(com.aggmoread.sdk.z.d.a.a.d.b.d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar, Map<String, Object> map) {
        super(dVar, eVar);
        this.f5319p = new HashMap();
        this.f5323t = false;
        if (map != null) {
            map.put(AMConst.ExtrasKey.AD_ID, this.f5273f);
            this.f5319p.putAll(map);
        }
    }

    public abstract View a(@NonNull Context context, @NonNull View view, FrameLayout.LayoutParams layoutParams, List<View> list, View view2, List<View> list2, View view3, @NonNull f.a aVar);

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public View a(@NonNull Context context, @NonNull View view, FrameLayout.LayoutParams layoutParams, List<View> list, View view2, List<View> list2, @NonNull f.a aVar) {
        return a(context, view, layoutParams, list, view2, list2, null, aVar);
    }

    public ViewGroup b(Context context) {
        return new FrameLayout(context);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public void bindCTAViews(List<View> list) {
    }

    public com.aggmoread.sdk.z.d.a.a.d.a.c c() {
        com.aggmoread.sdk.z.d.a.a.d.a.c cVar = this.f5321r;
        return cVar != null ? cVar : this.f5275h.f5874t;
    }

    public void d() {
        new com.aggmoread.sdk.z.d.a.a.d.b.k(this.f5275h, this.f5276i).a(6).a(k.b.f6046n, this.f5273f).a(k.b.C, getTitle()).a(k.b.f6049q, com.aggmoread.sdk.z.d.a.a.e.m.a(this.f5275h, this.f5276i, this.f5319p)).b();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public void destroy() {
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public com.aggmoread.sdk.z.d.a.a.c.c g() {
        return null;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public double getAppPrice() {
        return l5.c.f27899e;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public int getAppScore() {
        return 0;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public int getAppStatus() {
        return 0;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public String getCTAText() {
        return "";
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public long getDownloadCount() {
        return 0L;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.a
    public String getID() {
        return this.f5273f;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public int getPictureHeight() {
        return 0;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public int getPictureWidth() {
        return 0;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public int getProgress() {
        return 0;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public abstract String getTitle();

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public int getVideoCurrentPosition() {
        return 0;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.a
    public Map<String, Object> h() {
        return com.aggmoread.sdk.z.d.a.a.e.m.a(this.f5319p);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public void pauseVideo() {
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public View renderView(View view) {
        if (view == null) {
            return null;
        }
        this.f5323t = true;
        return a(view, (View) null, a(this.f5275h.f5858d.getApplicationContext()));
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public void resume() {
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public void resumeVideo() {
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public void setVideoMute(boolean z10) {
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public void startVideo() {
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public void stopVideo() {
    }

    public ViewGroup a(Context context) {
        return new FrameLayout(context);
    }

    public void b(int i10) {
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.aggmoread.sdk.z.d.a.a.d.b.m.a a(android.view.View r12, android.view.View r13, android.view.ViewGroup r14) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aggmoread.sdk.z.d.a.a.d.a.d.d.a(android.view.View, android.view.View, android.view.ViewGroup):com.aggmoread.sdk.z.d.a.a.d.b.m.a");
    }

    public void b(int i10, int i11, String str) {
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.a
    public final void a(int i10) {
        if (com.aggmoread.sdk.z.d.a.a.e.m.h(this.f5276i)) {
            b(i10);
        }
    }

    public void b(ViewGroup viewGroup, com.aggmoread.sdk.z.d.a.a.c.t.a aVar) {
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.a
    public final void a(int i10, int i11, String str) {
        if (com.aggmoread.sdk.z.d.a.a.e.m.h(this.f5276i)) {
            b(i10, i11, str);
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.f
    public void a(@NonNull ViewGroup viewGroup, com.aggmoread.sdk.z.d.a.a.c.t.a aVar) {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMHTAG", "bindMedia ");
        if (viewGroup != null) {
            Object obj = f5318v;
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewWithTag(obj);
            if (viewGroup2 == null || !a(viewGroup2)) {
                com.aggmoread.sdk.z.d.a.a.e.e.b("AMHTAG", " new ");
                if (viewGroup2 != null) {
                    viewGroup.removeView(viewGroup2);
                }
                viewGroup2 = b(viewGroup.getContext());
                viewGroup2.setTag(obj);
                viewGroup.addView(viewGroup2, new ViewGroup.LayoutParams(-1, -1));
            }
            b(viewGroup2, aVar);
        }
    }

    public void a(f.a aVar) {
        com.aggmoread.sdk.z.d.a.a.e.e.a("exposure");
        d();
        if (com.aggmoread.sdk.z.d.a.a.e.m.e()) {
            com.aggmoread.sdk.z.d.a.a.e.m.a(this.f5319p, getTitle());
        }
        if (com.aggmoread.sdk.z.d.a.a.e.m.b(this.f5276i)) {
            aVar.onAdExposed();
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.a
    public void a(com.aggmoread.sdk.z.d.a.a.d.a.c cVar) {
        this.f5321r = cVar;
    }

    public boolean a(View view) {
        return view instanceof FrameLayout;
    }
}
