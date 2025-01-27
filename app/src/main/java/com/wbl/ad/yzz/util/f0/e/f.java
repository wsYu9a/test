package com.wbl.ad.yzz.util.f0.e;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes5.dex */
public final class f {

    /* renamed from: a */
    public final Map<String, b> f34287a = new HashMap();

    /* renamed from: b */
    public final c f34288b = new c();

    public void a(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9171, this, str);
    }

    public void b(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8238, this, str);
    }

    public static class b {

        /* renamed from: a */
        public final Lock f34289a;

        /* renamed from: b */
        public int f34290b;

        public b() {
            this.f34289a = new ReentrantLock();
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public static class c {

        /* renamed from: a */
        public final Queue<b> f34291a;

        public c() {
            this.f34291a = new ArrayDeque();
        }

        public b a() {
            return (b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9169, this, null);
        }

        public void a(b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9172, this, bVar);
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }
}
