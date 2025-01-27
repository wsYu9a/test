package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.z;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class p {

    /* renamed from: a */
    private static volatile p f5843a;

    /* renamed from: b */
    private List<z.a> f5844b = new CopyOnWriteArrayList();

    private p() {
    }

    public static p a() {
        if (f5843a == null) {
            synchronized (p.class) {
                if (f5843a == null) {
                    f5843a = new p();
                }
            }
        }
        return f5843a;
    }

    private void b(z.a aVar) {
        if (this.f5844b.contains(aVar)) {
            this.f5844b.remove(aVar);
        }
    }

    public void a(z.a aVar) {
        if (aVar == null || this.f5844b.contains(aVar)) {
            return;
        }
        this.f5844b.add(aVar);
    }

    public void a(int i2) {
        for (z.a aVar : this.f5844b) {
            if (i2 == 1) {
                aVar.onSuccess();
            } else if (i2 == 2) {
                aVar.onFailure();
            }
            b(aVar);
        }
    }
}
