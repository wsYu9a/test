package com.wbl.ad.yzz.sensor;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import java.util.concurrent.Future;

@SuppressLint({"CommitPrefEdits"})
/* loaded from: classes5.dex */
public abstract class g<T> {

    /* renamed from: a */
    public final Future<SharedPreferences> f33814a;

    /* renamed from: b */
    public final a f33815b;

    /* renamed from: c */
    public final String f33816c;

    /* renamed from: d */
    public T f33817d;

    public interface a<T> {
        T a();

        T a(String str);

        String a(T t);
    }

    public g(Future<SharedPreferences> future, String str, a<T> aVar) {
        this.f33814a = future;
        this.f33815b = aVar;
        this.f33816c = str;
    }

    public T a() {
        return (T) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10694, this, null);
    }

    public void a(T t) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10693, this, t);
    }
}
