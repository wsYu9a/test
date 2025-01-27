package com.martian.ttbook.b.c.a.a.b.a.d.w.d;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import b.d.e.c.a.l.d;
import com.martian.ttbook.b.a.g.c;
import com.martian.ttbook.b.c.a.a.b.a.d.k;
import com.martian.ttbook.b.c.a.a.b.a.d.w.b;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.i;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class a extends k implements d {
    private c q;
    private b.d.e.c.a.a r;

    public a(com.martian.ttbook.b.c.a.a.d.b.d dVar, e eVar) {
        super(dVar, eVar);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.k
    protected void H(View view) {
        try {
            b.a().b(this.f15662c.f15670d);
            this.q = new c.b(this.f15662c.f15670d).e(this.f15662c.m).h(true).i(this.f15662c.n).f(view).g(this.f15663d.f15701c.l(e.c.Q)).j();
            new com.martian.ttbook.b.c.a.a.d.b.k(this.f15662c, this.f15663d).a(3).h();
            this.q.l(this);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.k
    protected void I(ViewGroup viewGroup) {
        if (this.r != null) {
            Activity activity = null;
            if (viewGroup.getContext() instanceof Activity) {
                activity = (Activity) viewGroup.getContext();
            } else {
                Context context = this.f15662c.f15670d;
                if (context instanceof Activity) {
                    activity = (Activity) context;
                }
            }
            if (activity != null) {
                this.r.a(activity, viewGroup);
            } else {
                J(new i(-100, "容器页面不可见!"));
            }
        }
    }

    @Override // b.d.e.c.a.g.b
    public void b(b.d.e.c.a.f.e eVar) {
        J(new i(eVar.a(), eVar.b()));
    }

    @Override // b.d.e.c.a.l.d
    public void l(b.d.e.c.a.a aVar) {
        ArrayList arrayList = new ArrayList();
        this.r = aVar;
        arrayList.add(this);
        K(arrayList);
    }

    @Override // b.d.e.c.a.l.c
    public void onAdClicked() {
        L();
    }

    @Override // b.d.e.c.a.l.c
    public void onAdDismissed() {
        M();
    }

    @Override // b.d.e.c.a.l.c
    public void onAdExposure() {
        N();
    }

    @Override // b.d.e.c.a.l.c
    public void onAdShow() {
    }

    @Override // b.d.e.c.a.l.d
    public void onAdSkip() {
    }

    @Override // b.d.e.c.a.l.d
    public void onAdTick(long j2) {
        C(j2);
    }
}
