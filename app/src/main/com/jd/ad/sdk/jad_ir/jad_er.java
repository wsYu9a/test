package com.jd.ad.sdk.jad_ir;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class jad_er {
    public static final Executor jad_an = new jad_an();
    public static final Executor jad_bo = new jad_bo();

    public class jad_an implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            jad_ly.jad_bo().post(runnable);
        }
    }

    public class jad_bo implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            runnable.run();
        }
    }
}
