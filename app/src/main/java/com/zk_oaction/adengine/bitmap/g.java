package com.zk_oaction.adengine.bitmap;

import android.graphics.Bitmap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes5.dex */
public class g extends c implements h, i {
    private com.zk_oaction.adengine.lk_sdkwrapper.d x;
    private HashMap<String, f> y = new HashMap<>();
    private HashSet<e> z = new HashSet<>();

    public e C(int i2, int i3, Bitmap.Config config) {
        e eVar = new e(i2, i3, config);
        this.z.add(eVar);
        return eVar;
    }

    public void D(com.zk_oaction.adengine.lk_sdkwrapper.d dVar) {
        this.x = dVar;
    }

    public f E(String str, float f2, int i2) {
        f fVar;
        synchronized (this) {
            a(str, f2, i2);
            String p = p(str, f2);
            fVar = this.y.get(p);
            if (fVar == null) {
                fVar = new f(this, str, f2);
                this.y.put(p, fVar);
            }
        }
        return fVar;
    }

    @Override // com.zk_oaction.adengine.bitmap.h
    public void b(String str, float f2, boolean z) {
        if (z) {
            try {
                f fVar = this.y.get(p(str, f2));
                if (fVar != null) {
                    this.x.t().g(fVar);
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.zk_oaction.adengine.bitmap.i
    public int c(String str, float f2) {
        return h(str, f2).g();
    }

    @Override // com.zk_oaction.adengine.bitmap.i
    public int d(String str, float f2) {
        return h(str, f2).h();
    }

    @Override // com.zk_oaction.adengine.bitmap.c
    public void j() {
        Iterator<e> it = this.z.iterator();
        while (it.hasNext()) {
            it.next().e();
        }
        super.j();
    }

    @Override // com.zk_oaction.adengine.bitmap.c
    public void w() {
        synchronized (this) {
            super.w();
            this.y = null;
            this.x = null;
        }
    }
}
