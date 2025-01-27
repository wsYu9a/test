package com.opos.mobad.l;

import android.app.Activity;
import com.opos.mobad.ad.i;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public abstract class k extends j implements com.opos.mobad.ad.i {

    /* renamed from: a */
    private i.a f21216a;

    /* renamed from: com.opos.mobad.l.k$1 */
    class AnonymousClass1 implements Callable<Boolean> {

        /* renamed from: a */
        final /* synthetic */ Activity f21217a;

        AnonymousClass1(Activity activity) {
            activity = activity;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            return Boolean.valueOf(k.this.b(activity));
        }
    }

    public k(i.a aVar) {
        super(aVar);
        this.f21216a = aVar;
    }

    @Override // com.opos.mobad.ad.i
    public void a(Activity activity) {
        d(new Callable<Boolean>() { // from class: com.opos.mobad.l.k.1

            /* renamed from: a */
            final /* synthetic */ Activity f21217a;

            AnonymousClass1(Activity activity2) {
                activity = activity2;
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                return Boolean.valueOf(k.this.b(activity));
            }
        });
    }

    protected abstract boolean b(Activity activity);

    final void d(Callable<Boolean> callable) {
        i.a aVar;
        int i2;
        String str;
        int a2 = this.f21203f.a(3, callable);
        com.opos.cmn.an.f.a.b("SyncStateController", "showAd state=" + a2 + ",Ad =" + this);
        switch (a2) {
            case 0:
            case 1:
            case 6:
                aVar = this.f21216a;
                if (aVar != null) {
                    i2 = 10006;
                    str = "ad data is null";
                    break;
                } else {
                    return;
                }
            case 2:
            case 3:
                return;
            case 4:
                aVar = this.f21216a;
                if (aVar != null) {
                    i2 = 10008;
                    str = "ad had showd, please reload";
                    break;
                } else {
                    return;
                }
            case 5:
                aVar = this.f21216a;
                if (aVar != null) {
                    i2 = 11001;
                    str = "ad has destroyed.";
                    break;
                } else {
                    return;
                }
            default:
                i.a aVar2 = this.f21216a;
                if (aVar2 != null) {
                    aVar2.a(-1, "show with illegal state:" + a2);
                    return;
                }
                return;
        }
        aVar.a(i2, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opos.mobad.l.j
    public void i_() {
        i.a aVar;
        if (4 != this.f21203f.a(4) || (aVar = this.f21216a) == null) {
            return;
        }
        aVar.b();
    }

    @Override // com.opos.mobad.l.j
    void n() {
        this.f21203f = l.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void p() {
        i.a aVar;
        if (5 == d() || (aVar = this.f21216a) == null) {
            return;
        }
        aVar.a(0L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void q() {
        i.a aVar;
        if (5 == d() || (aVar = this.f21216a) == null) {
            return;
        }
        aVar.a("");
    }
}
