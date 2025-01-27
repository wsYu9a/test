package com.google.common.cache;

import b5.z;
import d5.d;
import d5.h;
import java.util.concurrent.atomic.AtomicLong;

@a5.b(emulated = true)
@d
/* loaded from: classes2.dex */
public final class LongAddables {

    /* renamed from: a */
    public static final z<h> f9277a;

    public static final class PureJavaLongAddable extends AtomicLong implements h {
        private PureJavaLongAddable() {
        }

        @Override // d5.h
        public void add(long j10) {
            getAndAdd(j10);
        }

        @Override // d5.h
        public void increment() {
            getAndIncrement();
        }

        @Override // d5.h
        public long sum() {
            return get();
        }

        public /* synthetic */ PureJavaLongAddable(a aVar) {
            this();
        }
    }

    public class a implements z<h> {
        @Override // b5.z
        /* renamed from: a */
        public h get() {
            return new LongAdder();
        }
    }

    public class b implements z<h> {
        @Override // b5.z
        /* renamed from: a */
        public h get() {
            return new PureJavaLongAddable(null);
        }
    }

    static {
        z<h> bVar;
        try {
            new LongAdder();
            bVar = new a();
        } catch (Throwable unused) {
            bVar = new b();
        }
        f9277a = bVar;
    }

    public static h a() {
        return f9277a.get();
    }
}
