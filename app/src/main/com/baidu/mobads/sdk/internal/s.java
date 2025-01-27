package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.aa;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public class s {

    /* renamed from: a */
    private static volatile s f7247a;

    /* renamed from: b */
    private List<aa.a> f7248b = new CopyOnWriteArrayList();

    private s() {
    }

    public static s a() {
        if (f7247a == null) {
            synchronized (s.class) {
                try {
                    if (f7247a == null) {
                        f7247a = new s();
                    }
                } finally {
                }
            }
        }
        return f7247a;
    }

    private void b(aa.a aVar) {
        if (this.f7248b.contains(aVar)) {
            this.f7248b.remove(aVar);
        }
    }

    public void a(aa.a aVar) {
        if (aVar == null || this.f7248b.contains(aVar)) {
            return;
        }
        this.f7248b.add(aVar);
    }

    public void a(int i10) {
        for (aa.a aVar : this.f7248b) {
            if (i10 == 1) {
                aVar.onSuccess();
            } else if (i10 == 2) {
                aVar.onFailure();
            }
            b(aVar);
        }
    }
}
