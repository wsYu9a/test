package com.vivo.mobilead.unified.base.view.t;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.vivo.ad.h.b.l;
import com.vivo.ad.view.v;
import com.vivo.mobilead.model.BackUrlInfo;
import com.vivo.mobilead.model.a;
import com.vivo.mobilead.unified.base.callback.MediaListener;
import com.vivo.mobilead.unified.reward.UnifiedVivoRewardVideoAdListener;
import com.vivo.mobilead.util.j;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.m;
import com.vivo.mobilead.util.u;
import com.vivo.mobilead.util.u0;

/* loaded from: classes4.dex */
public class h extends i {
    private boolean A0;
    private com.vivo.mobilead.unified.base.view.r.d v0;
    private boolean w0;
    private com.vivo.mobilead.unified.base.view.r.c x0;
    private int y0;
    private int z0;

    class a implements com.vivo.mobilead.unified.base.view.r.b {
        a() {
        }

        @Override // com.vivo.mobilead.unified.base.view.r.b
        public void a(String str) {
            h.this.w0 = false;
        }

        @Override // com.vivo.mobilead.unified.base.view.r.b
        public void b() {
        }

        @Override // com.vivo.mobilead.unified.base.view.r.b
        public void a() {
            h.this.w0 = true;
        }

        @Override // com.vivo.mobilead.unified.base.view.r.b
        public void a(int i2, boolean z) {
            h.this.a(-999, -999, -999, -999, 0.0d, 0.0d, 6, 1, false, "", z);
            UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener = h.this.u;
            if (unifiedVivoRewardVideoAdListener != null) {
                unifiedVivoRewardVideoAdListener.onAdClick();
            }
        }
    }

    class b implements com.vivo.mobilead.unified.base.callback.h {
        b() {
        }

        @Override // com.vivo.mobilead.unified.base.callback.h
        public void a(View view, float f2, float f3, float f4, float f5) {
            boolean c2 = com.vivo.mobilead.util.e.c(h.this.z);
            h hVar = h.this;
            Context context = hVar.getContext();
            h hVar2 = h.this;
            com.vivo.ad.model.b bVar = hVar2.z;
            String str = hVar2.B;
            String i2 = bVar.i();
            h hVar3 = h.this;
            hVar.E = u.a(context, bVar, c2, true, str, i2, hVar3.A, 1, hVar3.C);
            h.this.a((int) f2, (int) f3, (int) f4, (int) f5, 0.0d, 0.0d, 5, 2, false, "", c2);
            UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener = h.this.u;
            if (unifiedVivoRewardVideoAdListener != null) {
                unifiedVivoRewardVideoAdListener.onAdClick();
            }
        }
    }

    public h(Context context) {
        this(context, null);
    }

    private void b(Context context) {
        com.vivo.mobilead.unified.base.view.r.d dVar = new com.vivo.mobilead.unified.base.view.r.d(context);
        this.v0 = dVar;
        dVar.setWebCallback(new a());
        addView(this.v0, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void q() {
        com.vivo.mobilead.unified.base.view.p.a aVar = this.h0;
        if (aVar != null) {
            this.f30185c.removeView(aVar);
        }
        com.vivo.mobilead.unified.base.view.t.a aVar2 = this.i0;
        if (aVar2 != null) {
            this.f30185c.removeView(aVar2);
        }
        View view = this.g0;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.g0);
            }
        }
    }

    private void r() {
        this.A0 = true;
        m();
        l();
        l lVar = this.f30184b;
        if (lVar != null) {
            removeView(lVar);
        }
        q();
        this.f30185c.c();
        this.f30185c.setCloseClickable(true);
        this.f30185c.setMuteClickable(true);
        this.f30185c.setMuteUi(this.w);
        this.f30185c.setMute(0);
        this.f30185c.g();
        com.vivo.ad.h.b.a aVar = this.f30188f;
        if (aVar != null) {
            removeView(aVar);
        }
        com.vivo.ad.view.c cVar = this.f30189g;
        if (cVar != null) {
            removeView(cVar);
        }
        this.v0.c();
        this.v0.setMute(this.w);
        if (this.y0 == 1) {
            a(true);
        }
    }

    @Override // com.vivo.mobilead.unified.base.view.t.i, com.vivo.mobilead.unified.base.view.t.c
    public void c() {
        com.vivo.mobilead.unified.base.view.r.d dVar = this.v0;
        if (dVar != null) {
            dVar.destroy();
        }
        super.c();
    }

    @Override // com.vivo.mobilead.unified.base.view.t.i, com.vivo.mobilead.unified.base.view.t.c
    public void d() {
        if (this.A0) {
            return;
        }
        o();
    }

    @Override // com.vivo.mobilead.unified.base.view.t.i, com.vivo.mobilead.unified.base.view.t.c
    public void e() {
        if (this.A0) {
            this.v0.b();
        } else {
            super.e();
        }
    }

    @Override // com.vivo.mobilead.unified.base.view.t.i, com.vivo.mobilead.unified.base.view.t.c
    public void f() {
        if (this.L) {
            return;
        }
        if (this.A0) {
            this.v0.c();
        } else {
            super.f();
        }
    }

    @Override // com.vivo.mobilead.unified.base.view.t.i
    protected void g() {
        if (this.w0) {
            super.g();
            return;
        }
        MediaListener mediaListener = this.t;
        if (mediaListener != null) {
            mediaListener.onVideoCompletion();
        }
        com.vivo.mobilead.d.e eVar = this.f30183a;
        int duration = eVar == null ? 0 : eVar.getDuration();
        com.vivo.ad.model.b bVar = this.z;
        k0.b(bVar, duration, -1, 1, this.B, bVar.i());
        if (!this.I) {
            this.I = true;
            u0.a(this.z, a.EnumC0603a.PLAYEND, this.B);
        }
        l();
        if (!this.O) {
            this.O = true;
            UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener = this.u;
            if (unifiedVivoRewardVideoAdListener != null) {
                unifiedVivoRewardVideoAdListener.onRewardVerify();
            }
        }
        this.f30185c.c();
        r();
    }

    @Override // com.vivo.mobilead.unified.base.view.t.i
    protected void h() {
        if (!this.A0) {
            if (this.w0 || this.z0 != 1) {
                super.h();
                return;
            } else if (this.O) {
                r();
                return;
            } else {
                this.f30185c.d();
                return;
            }
        }
        UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener = this.u;
        if (unifiedVivoRewardVideoAdListener != null) {
            unifiedVivoRewardVideoAdListener.onAdClose();
        }
        com.vivo.mobilead.d.e eVar = this.f30183a;
        int currentPosition = eVar == null ? 0 : eVar.getCurrentPosition();
        com.vivo.ad.model.b bVar = this.z;
        k0.a(bVar, this.B, bVar.i(), 1, currentPosition, 7);
        if (getContext() instanceof Activity) {
            ((Activity) getContext()).finish();
        }
    }

    @Override // com.vivo.mobilead.unified.base.view.t.i
    protected void i() {
        if (this.w0 || this.z0 != 1) {
            super.i();
        } else {
            r();
        }
    }

    @Override // com.vivo.mobilead.unified.base.view.t.i
    protected void j() {
        if (this.w0 || this.z0 != 1) {
            super.j();
        } else {
            removeView(this.f30187e);
            r();
        }
    }

    @Override // com.vivo.mobilead.unified.base.view.t.i
    protected void n() {
        if (!this.A0) {
            super.n();
            return;
        }
        boolean z = !this.w;
        this.w = z;
        this.v0.setMute(z);
    }

    @Override // com.vivo.mobilead.unified.base.view.t.i, com.vivo.mobilead.unified.base.view.t.c
    public void setMediaListener(MediaListener mediaListener) {
        super.setMediaListener(mediaListener);
    }

    @Override // com.vivo.mobilead.unified.base.view.t.i, com.vivo.mobilead.unified.base.view.t.c
    public void setRewardVideoAdListener(UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener) {
        super.setRewardVideoAdListener(unifiedVivoRewardVideoAdListener);
    }

    public h(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.vivo.mobilead.unified.base.view.t.i
    protected void a(Context context) {
        b(context);
        super.a(context);
    }

    public h(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.w0 = false;
        this.A0 = false;
    }

    @Override // com.vivo.mobilead.unified.base.view.t.i, com.vivo.mobilead.unified.base.view.t.c
    public void a(com.vivo.ad.model.b bVar, BackUrlInfo backUrlInfo, String str, int i2, int i3) {
        super.a(bVar, backUrlInfo, str, i2, i3);
        if (bVar.c() != null) {
            int b2 = bVar.c().b();
            this.y0 = j.a(b2, 2);
            this.z0 = j.a(b2, 1);
        }
        this.v0.a(bVar, str, backUrlInfo, i3, i2);
    }

    private void a(boolean z) {
        if (z) {
            if (this.x0 == null && getContext() != null) {
                Context context = getContext();
                v vVar = this.n0;
                if (vVar != null) {
                    vVar.g();
                }
                com.vivo.mobilead.unified.base.view.r.c cVar = new com.vivo.mobilead.unified.base.view.r.c(getContext());
                this.x0 = cVar;
                cVar.setImageBitmap(com.vivo.mobilead.util.g.a(context, "vivo_module_web_download.png"));
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(m.b(context, 52.0f), m.b(context, 52.0f));
                layoutParams.addRule(11);
                layoutParams.addRule(12);
                com.vivo.ad.model.b bVar = this.z;
                if (bVar != null && bVar.t() != null && this.z.t().b().intValue() == 2) {
                    layoutParams.bottomMargin = m.b(context, 86.0f);
                } else {
                    layoutParams.bottomMargin = m.b(context, 126.0f);
                }
                this.x0.setScaleType(ImageView.ScaleType.CENTER_CROP);
                addView(this.x0, layoutParams);
                this.x0.setDownloadListener(new b());
            }
            com.vivo.mobilead.unified.base.view.r.c cVar2 = this.x0;
            if (cVar2 == null || cVar2.getVisibility() == 0) {
                return;
            }
            this.x0.setVisibility(0);
            return;
        }
        com.vivo.mobilead.unified.base.view.r.c cVar3 = this.x0;
        if (cVar3 == null || cVar3.getVisibility() == 8) {
            return;
        }
        this.x0.setVisibility(8);
    }
}
