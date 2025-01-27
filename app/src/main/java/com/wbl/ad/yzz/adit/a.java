package com.wbl.ad.yzz.adit;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.config.AdInitConfig;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a */
    public final Object f31439a = new Object();

    /* renamed from: b */
    public int f31440b = 0;

    /* renamed from: c */
    public Handler f31441c = null;

    /* renamed from: d */
    public long f31442d = 0;

    /* renamed from: com.wbl.ad.yzz.adit.a$a */
    public class RunnableC0685a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String f31443a;

        /* renamed from: b */
        public final /* synthetic */ Application f31444b;

        /* renamed from: c */
        public final /* synthetic */ String f31445c;

        public RunnableC0685a(a aVar, String str, Application application, String str2) {
            this.f31443a = str;
            this.f31444b = application;
            this.f31445c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15542, this, null);
        }
    }

    public class b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Context f31446a;

        /* renamed from: b */
        public final /* synthetic */ String f31447b;

        /* renamed from: c */
        public final /* synthetic */ AdInitConfig f31448c;

        public b(Context context, String str, AdInitConfig adInitConfig) {
            this.f31446a = context;
            this.f31447b = str;
            this.f31448c = adInitConfig;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15541, this, null);
        }
    }

    public final Handler a() {
        return (Handler) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15543, this, null);
    }

    public void a(Activity activity) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15538, this, activity);
    }

    public void a(Application application) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15537, this, application);
    }

    public void a(Application application, com.wbl.ad.yzz.network.b.b.a aVar, AdInitConfig adInitConfig) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15540, this, application, aVar, adInitConfig);
    }

    public final void a(Context context) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15539, this, context);
    }

    public final void a(Context context, String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15502, this, context, str);
    }

    public final void a(Context context, String str, AdInitConfig adInitConfig) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15501, this, context, str, adInitConfig);
    }

    public void a(Handler handler) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15504, this, handler);
    }

    public final void a(Runnable runnable) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15503, this, runnable);
    }

    public final boolean a(int i2) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-15498, this, Integer.valueOf(i2));
    }

    public final void b(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15497, this, Integer.valueOf(i2));
    }

    public final void b(Application application) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15500, this, application);
    }

    public void b(Context context) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15499, this, context);
    }

    public final void b(Context context, String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15494, this, context, str);
    }

    public final void b(Context context, String str, AdInitConfig adInitConfig) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15493, this, context, str, adInitConfig);
    }

    public boolean b() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-15496, this, null);
    }

    public void c(Context context) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15495, this, context);
    }

    public final void c(Context context, String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15490, this, context, str);
    }

    public final void d(Context context, String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15489, this, context, str);
    }
}
