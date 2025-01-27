package com.shu.priory.i;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.shu.priory.config.AdError;
import com.shu.priory.config.ErrorCode;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.conn.VideoDataRef;
import com.shu.priory.listener.IFLYVideoListener;
import com.shu.priory.utils.h;

/* loaded from: classes3.dex */
public class a extends com.shu.priory.b.b<VideoDataRef> {

    /* renamed from: f */
    private com.shu.priory.g.a f17121f;

    /* renamed from: g */
    private final IFLYVideoListener f17122g;

    /* renamed from: h */
    private final c f17123h;

    public a(Context context, String str, int i10, IFLYVideoListener iFLYVideoListener) {
        super(context, str);
        this.f17122g = iFLYVideoListener;
        this.f16823e.a(iFLYVideoListener);
        this.f17123h = new c(context, i10, iFLYVideoListener);
    }

    @Override // com.shu.priory.b.b
    public void a() {
        try {
            Context context = this.f16820b;
            if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
                this.f16823e.a(1, new AdError(ErrorCode.ERROR_ACTIVITY_FINISH));
                h.a(SDKConstants.TAG, "activity is finishing");
                return;
            }
            com.shu.priory.g.a aVar = this.f16821c.f17105f;
            this.f17121f = aVar;
            this.f17123h.a(new d(aVar));
            com.shu.priory.g.b bVar = this.f16821c;
            if (70200 != bVar.f17100a || bVar.f17105f == null) {
                this.f16823e.a(1, new AdError(this.f16821c.f17100a));
            } else {
                this.f16823e.a(0, new b(this.f16820b, bVar, this.f16819a, this.f17122g));
            }
        } catch (Throwable unused) {
            this.f16823e.a(1, new AdError(ErrorCode.ERROR_NETWORK));
        }
    }

    public void b(boolean z10) {
        this.f17123h.b(z10);
    }

    public void c() {
        this.f17123h.a(this.f17121f.f17083j);
    }

    public void d() {
        this.f17123h.c();
    }

    public void e() {
        this.f17123h.d();
    }

    public void f() {
        this.f17123h.e();
    }

    public void g() {
        this.f17123h.f();
    }

    public void h() {
        this.f17123h.g();
    }

    public boolean i() {
        return this.f17123h.h();
    }

    public boolean j() {
        return this.f17123h.i();
    }

    public void k() {
        this.f17123h.j();
    }

    public void l() {
        this.f17123h.k();
    }

    public ViewGroup m() {
        return this.f17123h.a();
    }

    public void a(boolean z10) {
        this.f17123h.a(z10);
    }

    public void c(boolean z10) {
        this.f17123h.c(z10);
    }

    public void a(Object... objArr) {
        this.f17123h.a(objArr);
    }
}
