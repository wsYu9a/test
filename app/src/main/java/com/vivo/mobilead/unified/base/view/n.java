package com.vivo.mobilead.unified.base.view;

import android.content.Context;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes4.dex */
public class n implements View.OnTouchListener {

    /* renamed from: a */
    private float f29917a = 0.0f;

    /* renamed from: b */
    private float f29918b = 0.0f;

    /* renamed from: c */
    private com.vivo.ad.model.b f29919c;

    /* renamed from: d */
    private Context f29920d;

    /* renamed from: e */
    private com.vivo.mobilead.unified.base.view.u.a f29921e;

    /* renamed from: f */
    private com.vivo.mobilead.unified.base.view.u.b f29922f;

    public n(Context context, com.vivo.ad.model.b bVar, com.vivo.mobilead.unified.base.view.u.a aVar) {
        this.f29920d = context;
        this.f29919c = bVar;
        this.f29921e = aVar;
    }

    public void a(com.vivo.mobilead.unified.base.view.u.b bVar) {
        this.f29922f = bVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.vivo.ad.model.b bVar;
        com.vivo.ad.model.d b2;
        if (this.f29920d == null || this.f29921e == null || (bVar = this.f29919c) == null || (b2 = bVar.b()) == null) {
            return true;
        }
        if (motionEvent.getAction() == 0) {
            this.f29917a = motionEvent.getRawX();
            this.f29918b = motionEvent.getRawY();
            this.f29921e.a();
            this.f29921e.a(new Pair<>(Float.valueOf(this.f29917a), Float.valueOf(this.f29918b)));
            return true;
        }
        if (motionEvent.getAction() == 2) {
            this.f29921e.a(new Pair<>(Float.valueOf(motionEvent.getRawX()), Float.valueOf(motionEvent.getRawY())));
            return true;
        }
        if (motionEvent.getAction() == 1) {
            this.f29921e.a(new Pair<>(Float.valueOf(motionEvent.getRawX()), Float.valueOf(motionEvent.getRawY())));
            if (Math.sqrt(Math.pow(r2 - this.f29917a, 2.0d) + Math.pow(r4 - this.f29918b, 2.0d)) < 200.0d || !b2.k()) {
                return true;
            }
            double a2 = this.f29921e.a(b2);
            if (this.f29921e.a(a2)) {
                this.f29922f.a((b2.g() == 1 || b2.g() == 2) ? 1 : -1, a2, view, (int) motionEvent.getRawX(), (int) motionEvent.getRawY(), (int) motionEvent.getX(), (int) motionEvent.getY());
            }
        }
        return true;
    }
}
