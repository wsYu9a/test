package com.wbl.ad.yzz.network.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.network.result.ActionData;
import java.lang.ref.WeakReference;

/* loaded from: classes5.dex */
public abstract class e<T> extends d {

    /* renamed from: a */
    public Class f33754a;

    /* renamed from: b */
    public WeakReference<Context> f33755b;

    /* renamed from: c */
    public String f33756c;

    /* renamed from: d */
    @SuppressLint({"HandlerLeak"})
    public Handler f33757d = new a(Looper.getMainLooper());

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10568, this, message);
        }
    }

    public e(Context context, Class cls) {
        this.f33754a = cls;
        if (context != null) {
            this.f33755b = new WeakReference<>(context);
        } else {
            this.f33755b = null;
        }
    }

    public static /* synthetic */ WeakReference a(e eVar) {
        return (WeakReference) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11220, null, eVar);
    }

    @Override // com.wbl.ad.yzz.network.d.d
    public void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11219, this, null);
    }

    public void a(ActionData actionData) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10286, this, actionData);
    }

    @Override // com.wbl.ad.yzz.network.d.d
    public void a(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10285, this, str);
    }

    public abstract void a(String str, T t);

    public abstract void a(String str, String str2);

    @Override // com.wbl.ad.yzz.network.d.d
    public void a(Throwable th) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10288, this, th);
    }

    public final void b(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10287, this, str);
    }

    @Override // com.wbl.ad.yzz.network.d.d
    public boolean b() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10282, this, null);
    }

    public void c() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10281, this, null);
    }

    public boolean d() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10284, this, null);
    }
}
