package com.vivo.mobilead.unified.exitFloat;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.vivo.mobilead.unified.base.VivoAdError;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: a */
    private long f30300a;

    /* renamed from: b */
    private f f30301b;

    /* renamed from: c */
    private boolean f30302c = true;

    private static class a {

        /* renamed from: a */
        private static final e f30303a = new e();
    }

    public static e c() {
        return a.f30303a;
    }

    private void d() {
        this.f30300a = System.currentTimeMillis();
        f fVar = new f(com.vivo.mobilead.manager.f.j().c());
        this.f30301b = fVar;
        fVar.b();
    }

    public void a(Activity activity, d dVar) {
        if (dVar != null) {
            f fVar = this.f30301b;
            if (fVar == null) {
                dVar.onAdFailed(new VivoAdError(40218, "没有广告，建议过一会儿重试"));
            } else if (fVar.a()) {
                dVar.onAdFailed(new VivoAdError(402134, "广告展示超时"));
            } else {
                this.f30301b.a(dVar);
                this.f30301b.a(activity);
            }
        }
    }

    public void b() {
        if (this.f30302c) {
            f fVar = this.f30301b;
            if (fVar == null) {
                if (System.currentTimeMillis() - TTAdConstant.AD_MAX_EVENT_TIME > this.f30300a) {
                    d();
                }
            } else {
                if (!fVar.a() || System.currentTimeMillis() - TTAdConstant.AD_MAX_EVENT_TIME <= this.f30300a) {
                    return;
                }
                d();
            }
        }
    }

    public boolean a() {
        f fVar;
        return (!this.f30302c || (fVar = this.f30301b) == null || fVar.a()) ? false : true;
    }

    public void a(boolean z) {
        this.f30302c = z;
    }
}
