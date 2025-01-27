package com.vivo.mobilead.unified.interstitial.l;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.vivo.ad.model.a0;
import com.vivo.ad.view.k;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.model.a;
import com.vivo.mobilead.util.g;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.m;
import com.vivo.mobilead.util.p;
import com.vivo.mobilead.util.u0;
import com.vivo.mobilead.util.x0;
import com.vivo.mobilead.util.z;

/* loaded from: classes4.dex */
public class a extends RelativeLayout {

    /* renamed from: a */
    private int f30363a;

    /* renamed from: b */
    private int f30364b;

    /* renamed from: c */
    private int f30365c;

    /* renamed from: d */
    private int f30366d;

    /* renamed from: e */
    private ImageView f30367e;

    /* renamed from: f */
    private com.vivo.mobilead.d.e f30368f;

    /* renamed from: g */
    private ImageView f30369g;

    /* renamed from: h */
    private boolean f30370h;

    /* renamed from: i */
    private boolean f30371i;

    /* renamed from: j */
    private boolean f30372j;
    private com.vivo.ad.model.b k;
    private String l;
    private String m;
    private boolean n;
    private boolean o;
    private boolean p;
    private final com.vivo.mobilead.d.a q;

    /* renamed from: com.vivo.mobilead.unified.interstitial.l.a$a */
    class ViewOnClickListenerC0652a implements View.OnClickListener {
        ViewOnClickListenerC0652a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.setMute(!r2.f30372j);
        }
    }

    class b implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ k f30374a;

        b(k kVar) {
            this.f30374a = kVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            k kVar = this.f30374a;
            if (kVar != null) {
                kVar.a(view, a.this.f30363a, a.this.f30364b, a.this.f30365c, a.this.f30366d, false);
            }
        }
    }

    class c extends com.vivo.mobilead.util.b1.a.c.b {
        c() {
        }

        @Override // com.vivo.mobilead.util.b1.a.c.b, com.vivo.mobilead.util.b1.a.c.a
        public void a(String str, Bitmap bitmap) {
            a.this.a(bitmap);
        }
    }

    class e implements com.vivo.mobilead.d.a {

        /* renamed from: com.vivo.mobilead.unified.interstitial.l.a$e$a */
        class C0653a extends com.vivo.mobilead.util.f1.b {
            C0653a() {
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                if (a.this.f30368f != null) {
                    a.this.f30368f.setLoadingViewVisible(true);
                }
            }
        }

        e() {
        }

        @Override // com.vivo.mobilead.d.a
        public void a() {
        }

        @Override // com.vivo.mobilead.d.a
        public void a(int i2) {
        }

        @Override // com.vivo.mobilead.d.a
        public void a(int i2, int i3, String str) {
            x0.e("HalfScreenVideoView", "onVideoError: what:" + i2 + ", extra:" + i3 + ", desc:" + str);
            z.b().a().postDelayed(new C0653a(), 10L);
            if (a.this.o) {
                return;
            }
            a.this.o = true;
            k0.a(a.this.k, 1, a.this.l, a.this.m);
        }

        @Override // com.vivo.mobilead.d.a
        public void a(long j2, long j3) {
        }

        @Override // com.vivo.mobilead.d.a
        public void b() {
        }

        @Override // com.vivo.mobilead.d.a
        public void onVideoCompletion() {
            a.this.f30367e.setVisibility(0);
            if (!a.this.p) {
                a.this.p = true;
                u0.a(a.this.k, a.EnumC0603a.PLAYEND, a.this.l);
            }
            k0.b(a.this.k, a.this.getDuration(), -1, 1, a.this.l, a.this.m);
        }

        @Override // com.vivo.mobilead.d.a
        public void onVideoPause() {
        }

        @Override // com.vivo.mobilead.d.a
        public void onVideoResume() {
        }

        @Override // com.vivo.mobilead.d.a
        public void onVideoStart() {
            if (!a.this.n) {
                a.this.n = true;
                u0.a(a.this.k, a.EnumC0603a.STARTPLAY, a.this.l);
            }
            k0.c(a.this.k, a.this.l, a.this.m, c.a.f28912a + "");
        }
    }

    public a(Context context) {
        this(context, null);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    public int getCurrentPosition() {
        com.vivo.mobilead.d.e eVar = this.f30368f;
        if (eVar != null) {
            return eVar.getCurrentPosition();
        }
        return 0;
    }

    public int getDuration() {
        com.vivo.mobilead.d.e eVar = this.f30368f;
        if (eVar != null) {
            return eVar.getDuration();
        }
        return 0;
    }

    public View getMuteView() {
        return this.f30369g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.f30363a = (int) motionEvent.getRawX();
            this.f30364b = (int) motionEvent.getRawY();
            this.f30365c = (int) motionEvent.getX();
            this.f30366d = (int) motionEvent.getY();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i2) {
        super.onVisibilityChanged(view, i2);
        h();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        h();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        h();
    }

    public void setMute(boolean z) {
        this.f30372j = z;
        ImageView imageView = this.f30369g;
        if (imageView != null) {
            imageView.setImageBitmap(g.a(getContext(), this.f30372j ? "vivo_module_video_mute.png" : "vivo_module_video_unmute.png"));
        }
        com.vivo.mobilead.d.e eVar = this.f30368f;
        if (eVar != null) {
            eVar.setMute(z);
        }
    }

    public void setOnAdWidgetClickListener(k kVar) {
        setOnClickListener(new b(kVar));
    }

    class d implements p.b {
        d() {
        }

        @Override // com.vivo.mobilead.util.p.b
        public void a(Bitmap bitmap) {
            if (a.this.f30368f != null) {
                a.this.f30368f.setBackground(new BitmapDrawable(bitmap));
            }
        }

        @Override // com.vivo.mobilead.util.p.b
        public void a() {
            x0.b("HalfScreenVideoView", "fastBlur error");
        }
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void e() {
        ImageView imageView = new ImageView(getContext());
        this.f30367e = imageView;
        imageView.setVisibility(8);
        addView(this.f30367e, -1, -1);
    }

    private void f() {
        this.f30369g = new ImageView(getContext());
        int a2 = m.a(getContext(), 23.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a2, a2);
        layoutParams.leftMargin = m.a(getContext(), 10.0f);
        layoutParams.bottomMargin = m.a(getContext(), 10.0f);
        layoutParams.addRule(9);
        layoutParams.addRule(12);
        this.f30369g.setOnClickListener(new ViewOnClickListenerC0652a());
        addView(this.f30369g, layoutParams);
        setMute(false);
    }

    private void g() {
        com.vivo.mobilead.d.e eVar = new com.vivo.mobilead.d.e(getContext());
        this.f30368f = eVar;
        eVar.setNeedLooper(false);
        addView(this.f30368f, -1, -1);
    }

    private void h() {
        if (this.f30368f == null) {
            return;
        }
        boolean z = getVisibility() == 0;
        boolean z2 = getWindowVisibility() == 0;
        boolean hasWindowFocus = hasWindowFocus();
        if (!this.f30370h && !this.f30371i && z && z2 && hasWindowFocus && isShown()) {
            if (this.f30368f.c()) {
                return;
            }
            this.f30368f.h();
        } else if (this.f30368f.c()) {
            this.f30368f.d();
        }
    }

    private void i() {
        g();
        e();
        f();
        setTag(7);
    }

    public void d() {
        com.vivo.mobilead.d.e eVar = this.f30368f;
        if (eVar != null) {
            eVar.g();
        }
    }

    public a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.q = new e();
        i();
    }

    public boolean b() {
        return this.p;
    }

    public boolean c() {
        com.vivo.mobilead.d.e eVar = this.f30368f;
        if (eVar != null) {
            return eVar.c();
        }
        return false;
    }

    public void a(com.vivo.ad.model.b bVar, String str, String str2) {
        if (bVar == null || this.f30368f == null) {
            return;
        }
        a0 Q = bVar.Q();
        if (Q == null) {
            x0.a("HalfScreenVideoView", "setData: video is null");
            return;
        }
        String g2 = Q.g();
        if (TextUtils.isEmpty(g2)) {
            x0.a("HalfScreenVideoView", "setData: videoUrl empty");
            return;
        }
        this.k = bVar;
        this.l = str;
        this.m = str2;
        this.f30368f.setMediaCallback(this.q);
        this.f30368f.a(g2, bVar.C(), bVar.G());
        this.f30368f.e();
        a(bVar);
    }

    public void b(boolean z) {
        this.f30371i = z;
        h();
    }

    public boolean a() {
        return this.o;
    }

    private void a(com.vivo.ad.model.b bVar) {
        a0 Q = bVar.Q();
        if (Q == null) {
            x0.e("HalfScreenVideoView", "Interstitial VideoPreviewImg loading failed. No video");
            return;
        }
        String d2 = Q.d();
        Bitmap a2 = com.vivo.mobilead.h.b.a().a(d2);
        if (a2 != null) {
            a(a2);
        } else {
            com.vivo.mobilead.util.b1.a.b.b().a(d2, new c());
        }
    }

    public void a(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f30367e.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.f30367e.setImageBitmap(bitmap);
            p.a(bitmap, 0.4f, 20, new d());
            return;
        }
        x0.e("HalfScreenVideoView", "VideoPreviewImg bitmap loading failed.");
    }

    public void a(boolean z) {
        this.f30370h = z;
        h();
    }
}
