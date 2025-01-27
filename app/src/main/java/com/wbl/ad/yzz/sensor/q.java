package com.wbl.ad.yzz.sensor;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* loaded from: classes5.dex */
public class q {

    /* renamed from: a */
    public final Executor f33830a = Executors.newSingleThreadExecutor();

    public static class a implements Callable<SharedPreferences> {

        /* renamed from: a */
        public final Context f33831a;

        /* renamed from: b */
        public final String f33832b;

        /* renamed from: c */
        public final b f33833c;

        public a(Context context, String str, b bVar) {
            this.f33831a = context;
            this.f33832b = str;
            this.f33833c = bVar;
        }

        @Override // java.util.concurrent.Callable
        public SharedPreferences call() {
            return (SharedPreferences) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9788, this, null);
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [android.content.SharedPreferences, java.lang.Object] */
        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ SharedPreferences call() throws Exception {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9787, this, null);
        }
    }

    public interface b {
        void a(SharedPreferences sharedPreferences);
    }

    public Future<SharedPreferences> a(Context context, String str, b bVar) {
        return (Future) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9782, this, context, str, bVar);
    }
}
