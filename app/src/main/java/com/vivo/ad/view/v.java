package com.vivo.ad.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.vivo.ad.model.x;
import com.vivo.ad.model.z;
import com.vivo.ad.view.t;
import com.vivo.mobilead.lottie.TextDelegate;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class v {

    /* renamed from: a */
    private Context f27103a;

    /* renamed from: b */
    private View f27104b;

    /* renamed from: c */
    private k f27105c;

    /* renamed from: d */
    private com.vivo.mobilead.unified.base.view.u.b f27106d;

    /* renamed from: e */
    private com.vivo.ad.model.b f27107e;

    /* renamed from: f */
    private com.vivo.mobilead.unified.base.view.u.a f27108f;

    /* renamed from: g */
    private t f27109g;

    class a implements View.OnTouchListener {

        /* renamed from: a */
        public float f27110a;

        /* renamed from: b */
        public float f27111b;

        /* renamed from: c */
        final /* synthetic */ com.vivo.ad.model.d f27112c;

        /* renamed from: d */
        final /* synthetic */ com.vivo.ad.model.b f27113d;

        /* renamed from: e */
        final /* synthetic */ com.vivo.ad.model.k f27114e;

        /* renamed from: f */
        final /* synthetic */ com.vivo.ad.model.k f27115f;

        a(com.vivo.ad.model.d dVar, com.vivo.ad.model.b bVar, com.vivo.ad.model.k kVar, com.vivo.ad.model.k kVar2) {
            this.f27112c = dVar;
            this.f27113d = bVar;
            this.f27114e = kVar;
            this.f27115f = kVar2;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f27112c.g() == 5) {
                return false;
            }
            if (this.f27112c.g() == 3 && this.f27113d.l() != 2) {
                return false;
            }
            if (motionEvent.getAction() == 0) {
                this.f27110a = motionEvent.getRawX();
                this.f27111b = motionEvent.getRawY();
                if (v.this.f27108f != null) {
                    v.this.f27108f.a();
                    v.this.f27108f.a(new Pair<>(Float.valueOf(this.f27110a), Float.valueOf(this.f27111b)));
                }
            }
            if (motionEvent.getAction() == 1) {
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (v.this.f27108f != null) {
                    v.this.f27108f.a(new Pair<>(Float.valueOf(rawX), Float.valueOf(rawY)));
                }
                if (Math.sqrt(Math.pow(rawX - this.f27110a, 2.0d) + Math.pow(rawY - this.f27111b, 2.0d)) <= 24.0d) {
                    if (this.f27112c.a() && this.f27114e != null && this.f27115f != null) {
                        float x = motionEvent.getX();
                        float y = motionEvent.getY();
                        if (y >= this.f27114e.c() && y <= this.f27115f.a() && y <= this.f27114e.a() + this.f27114e.c() && x >= this.f27114e.b() && x <= this.f27115f.d() && x <= this.f27114e.d() + this.f27114e.b() && v.this.f27105c != null) {
                            v.this.f27105c.a(v.this.f27104b, (int) motionEvent.getRawX(), (int) motionEvent.getRawY(), (int) motionEvent.getX(), (int) motionEvent.getY(), true);
                        }
                    }
                    return true;
                }
                if (this.f27112c.k() && v.this.f27108f != null) {
                    double a2 = v.this.f27108f.a(this.f27112c);
                    if (v.this.f27108f.a(a2)) {
                        int i2 = (this.f27112c.g() == 1 || this.f27112c.g() == 2) ? 1 : -1;
                        if (v.this.f27106d != null) {
                            v.this.f27106d.a(i2, a2, view, (int) motionEvent.getRawX(), (int) motionEvent.getRawY(), (int) motionEvent.getX(), (int) motionEvent.getY());
                        }
                        return true;
                    }
                }
            } else if (motionEvent.getAction() == 2) {
                float rawX2 = motionEvent.getRawX();
                float rawY2 = motionEvent.getRawY();
                if (v.this.f27108f != null) {
                    v.this.f27108f.a(new Pair<>(Float.valueOf(rawX2), Float.valueOf(rawY2)));
                }
            }
            return true;
        }
    }

    class b implements t.a {
        b() {
        }

        @Override // com.vivo.ad.view.t.a
        public void a(double d2, double d3) {
            if (v.this.f27106d != null) {
                v.this.f27106d.a(d2, d3);
            }
        }
    }

    public v(Context context, com.vivo.ad.model.b bVar, k kVar, com.vivo.mobilead.unified.base.view.u.b bVar2) {
        this.f27103a = context;
        this.f27107e = bVar;
        this.f27105c = kVar;
        this.f27106d = bVar2;
        com.vivo.ad.model.d b2 = bVar.b();
        if (b2 != null && b2.l() && com.vivo.mobilead.h.b.a().e(b2.h())) {
            a(b2, bVar);
        } else if (bVar.l() == 2) {
            a(bVar);
        }
    }

    public boolean e() {
        return !(this.f27104b instanceof h);
    }

    public void f() {
        View a2 = a();
        if (a2 instanceof h) {
            ((h) a2).pauseAnimation();
        }
    }

    public void g() {
        View a2 = a();
        if (a2 instanceof h) {
            ((h) a2).a();
        }
    }

    public void h() {
        View a2 = a();
        if (a2 instanceof h) {
            ((h) a2).resumeAnimation();
        }
    }

    private x b(com.vivo.ad.model.b bVar) {
        HashMap<Integer, HashMap<String, x>> hashMap = com.vivo.mobilead.manager.e.c().b().f29586j;
        x xVar = new x();
        xVar.a("#FFFFFFFF");
        xVar.c(18);
        xVar.b(16);
        xVar.a(24);
        if (hashMap != null) {
            HashMap<String, x> hashMap2 = hashMap.get(2);
            if (hashMap2 == null) {
                a(bVar, xVar);
            } else if (bVar.b0() || bVar.Z()) {
                x xVar2 = hashMap2.get("website");
                if (xVar2 != null) {
                    xVar.a(xVar2.a());
                    xVar.b(xVar2.b());
                    xVar.c(xVar2.d());
                    xVar.a(xVar2.c());
                    if (TextUtils.isEmpty(xVar2.g())) {
                        xVar.c("点击跳转详情页或其他应用");
                    } else {
                        xVar.c(xVar2.g());
                    }
                } else {
                    xVar.c("点击跳转详情页或其他应用");
                }
            } else {
                com.vivo.ad.model.q y = bVar.y();
                boolean b2 = com.vivo.mobilead.util.j.b(this.f27103a, y == null ? "" : y.a());
                if (bVar.U()) {
                    x xVar3 = hashMap2.get("appointmentGame");
                    if (xVar3 != null) {
                        if (TextUtils.isEmpty(xVar3.e())) {
                            xVar3.b("点击跳转详情页或其他应用");
                        }
                        if (TextUtils.isEmpty(xVar3.g())) {
                            xVar3.d("点击跳转详情页或其他应用");
                        }
                        a(xVar, xVar3, b2);
                    } else if (b2) {
                        xVar.c("点击跳转详情页或其他应用");
                    } else {
                        xVar.c("点击跳转详情页或其他应用");
                    }
                } else if (bVar.V()) {
                    x xVar4 = hashMap2.get("deeplink");
                    if (xVar4 != null) {
                        if (TextUtils.isEmpty(xVar4.e())) {
                            xVar4.b("点击跳转详情页或其他应用");
                        }
                        if (TextUtils.isEmpty(xVar4.g())) {
                            xVar4.d("点击跳转详情页或其他应用");
                        }
                        a(xVar, xVar4, b2);
                    } else if (b2) {
                        xVar.c("点击跳转详情页或其他应用");
                    } else {
                        xVar.c("点击跳转详情页或其他应用");
                    }
                } else {
                    x xVar5 = hashMap2.get("download");
                    if (xVar5 != null) {
                        if (TextUtils.isEmpty(xVar5.e())) {
                            xVar5.b("点击跳转详情页或其他应用");
                        }
                        if (TextUtils.isEmpty(xVar5.g())) {
                            xVar5.d("点击跳转详情页或其他应用");
                        }
                        a(xVar, xVar5, b2);
                    } else if (b2) {
                        xVar.c("点击跳转详情页或其他应用");
                    } else {
                        xVar.c("点击跳转详情页或其他应用");
                    }
                }
            }
        } else {
            a(bVar, xVar);
        }
        return xVar;
    }

    public void a(com.vivo.mobilead.unified.base.view.u.a aVar) {
        this.f27108f = aVar;
    }

    public double c() {
        com.vivo.ad.model.b bVar;
        if (this.f27108f == null || (bVar = this.f27107e) == null || this.f27103a == null) {
            return 0.0d;
        }
        return this.f27108f.a(bVar.b());
    }

    public double d() {
        t tVar = this.f27109g;
        if (tVar != null) {
            return tVar.c();
        }
        return 0.0d;
    }

    private void a(com.vivo.ad.model.d dVar, com.vivo.ad.model.b bVar) {
        try {
            h hVar = new h(this.f27103a);
            this.f27104b = hVar;
            hVar.a(com.vivo.mobilead.h.b.a().a(this.f27103a, dVar.h()), dVar.h());
            hVar.loop(true);
            TextDelegate textDelegate = new TextDelegate(hVar);
            hVar.setTextDelegate(textDelegate);
            textDelegate.setCacheText(true);
            com.vivo.ad.model.k b2 = dVar.b();
            com.vivo.ad.model.k c2 = dVar.c();
            com.vivo.ad.model.k e2 = dVar.e();
            z f2 = dVar.f();
            float b3 = com.vivo.mobilead.util.m.b(this.f27103a);
            if (b2 != null) {
                b2.a(b3);
            }
            if (c2 != null) {
                c2.a(b3);
            }
            if (e2 != null) {
                e2.a(b3);
            }
            if (f2 != null) {
                f2.a(b3);
            }
            this.f27104b.setOnTouchListener(new a(dVar, bVar, c2, b2));
            if (dVar.j()) {
                t tVar = new t(this.f27103a);
                this.f27109g = tVar;
                if (f2 != null) {
                    tVar.a(f2.b());
                    this.f27109g.b(f2.f());
                    this.f27109g.b(f2.d());
                    this.f27109g.a(f2.a());
                }
                this.f27109g.a(new b());
                hVar.setShakeManager(this.f27109g);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) b2.d(), (int) b2.a());
            if (dVar.d() == 1) {
                layoutParams.addRule(14);
            } else {
                layoutParams.addRule(12);
                layoutParams.addRule(9);
            }
            layoutParams.leftMargin = (int) b2.b();
            layoutParams.bottomMargin = (int) b2.c();
            this.f27104b.setLayoutParams(layoutParams);
            bVar.a(true);
        } catch (Exception unused) {
            a(bVar);
        }
    }

    protected void a(com.vivo.ad.model.b bVar) {
        x b2 = b(bVar);
        f fVar = new f(this.f27103a);
        this.f27104b = fVar;
        fVar.setTextColor(com.vivo.mobilead.util.i.a(b2.c()));
        fVar.setGravity(17);
        fVar.setMaxLines(1);
        fVar.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        if (b2.d() <= 0) {
            fVar.setTextSize(1, 18.0f);
        } else {
            fVar.setTextSize(1, b2.d());
        }
        fVar.setBackground(com.vivo.ad.h.b.f.b(this.f27103a, 23.3f, "#66000000"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        int b3 = com.vivo.mobilead.util.m.b(this.f27103a, b2.a());
        int b4 = com.vivo.mobilead.util.m.b(this.f27103a, b2.b());
        fVar.setPadding(b3, b4, b3, b4);
        layoutParams.bottomMargin = com.vivo.mobilead.util.m.b(this.f27103a, 33.3f);
        fVar.setLayoutParams(layoutParams);
        String f2 = b2.f();
        if (!TextUtils.isEmpty(f2) && f2.length() > 12) {
            f2 = f2.substring(0, 12);
        }
        fVar.setText(f2 + "  ");
        Drawable b5 = com.vivo.mobilead.util.g.b(this.f27103a, "vivo_module_splash_next.png");
        if (b5 != null) {
            b5.setBounds(0, 0, com.vivo.mobilead.util.m.a(this.f27103a, 6.0f), com.vivo.mobilead.util.m.a(this.f27103a, 10.0f));
            fVar.setCompoundDrawables(null, null, b5, null);
        }
        fVar.setOnADWidgetClickListener(this.f27105c);
    }

    public double b() {
        t tVar = this.f27109g;
        if (tVar != null) {
            return tVar.b();
        }
        return 0.0d;
    }

    private void a(com.vivo.ad.model.b bVar, x xVar) {
        if (!bVar.b0() && !bVar.Z()) {
            com.vivo.ad.model.q y = bVar.y();
            boolean b2 = com.vivo.mobilead.util.j.b(this.f27103a, y == null ? "" : y.a());
            if (bVar.U()) {
                if (b2) {
                    xVar.c("点击跳转详情页或其他应用");
                    return;
                } else {
                    xVar.c("点击跳转详情页或其他应用");
                    return;
                }
            }
            if (bVar.V()) {
                if (b2) {
                    xVar.c("点击跳转详情页或其他应用");
                    return;
                } else {
                    xVar.c("点击跳转详情页或其他应用");
                    return;
                }
            }
            if (b2) {
                xVar.c("点击跳转详情页或其他应用");
                return;
            } else {
                xVar.c("点击跳转详情页或其他应用");
                return;
            }
        }
        xVar.c("点击跳转详情页或其他应用");
    }

    private void a(x xVar, x xVar2, boolean z) {
        xVar.a(xVar2.a());
        xVar.b(xVar2.b());
        xVar.c(xVar2.d());
        xVar.a(xVar2.c());
        xVar.d(xVar2.g());
        xVar.b(xVar2.e());
        if (z) {
            xVar.c(xVar2.e());
        } else {
            xVar.c(xVar2.g());
        }
    }

    public View a() {
        return this.f27104b;
    }
}
