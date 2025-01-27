package com.google.common.hash;

import b5.z;
import i5.h;
import i5.r;
import java.util.concurrent.atomic.AtomicLong;

@h
/* loaded from: classes2.dex */
public final class LongAddables {

    /* renamed from: a */
    public static final z<r> f10059a;

    public static final class PureJavaLongAddable extends AtomicLong implements r {
        private PureJavaLongAddable() {
        }

        @Override // i5.r
        public void add(long j10) {
            getAndAdd(j10);
        }

        @Override // i5.r
        public void increment() {
            getAndIncrement();
        }

        @Override // i5.r
        public long sum() {
            return get();
        }

        public /* synthetic */ PureJavaLongAddable(a aVar) {
            this();
        }
    }

    public class a implements z<r> {
        @Override // b5.z
        /* renamed from: a */
        public r get() {
            return new LongAdder();
        }
    }

    public class b implements z<r> {
        @Override // b5.z
        /* renamed from: a */
        public r get() {
            return new PureJavaLongAddable(null);
        }
    }

    static {
        z<r> bVar;
        try {
            new LongAdder();
            bVar = new a();
        } catch (Throwable unused) {
            bVar = new b();
        }
        f10059a = bVar;
    }

    public static r a() {
        return f10059a.get();
    }
}
