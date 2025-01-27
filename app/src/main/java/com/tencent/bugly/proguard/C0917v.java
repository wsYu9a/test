package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.text.TextUtils;
import com.tencent.bugly.beta.download.DownloadTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: com.tencent.bugly.proguard.v */
/* loaded from: classes4.dex */
public class C0917v implements com.tencent.bugly.beta.download.c {

    /* renamed from: a */
    public static C0917v f25173a = new C0917v();

    /* renamed from: b */
    public ConcurrentHashMap<String, DownloadTask> f25174b = new ConcurrentHashMap<>(3);

    /* renamed from: c */
    private ScheduledExecutorService f25175c;

    public C0917v() {
        this.f25175c = null;
        try {
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(3, new ThreadFactoryC0916u(this));
            this.f25175c = newScheduledThreadPool;
            if (newScheduledThreadPool.isShutdown()) {
                throw new IllegalArgumentException("ScheduledExecutorService is not available!");
            }
        } catch (Exception e2) {
            X.b(e2);
        }
    }

    @Override // com.tencent.bugly.beta.download.c
    public DownloadTask a(String str, String str2, String str3, String str4) {
        RunnableC0918w runnableC0918w = null;
        if (TextUtils.isEmpty(str)) {
            X.b("downloadUrl is null!", new Object[0]);
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            X.b("saveDir is null!", new Object[0]);
            return null;
        }
        if (this.f25174b.get(str) != null) {
            return this.f25174b.get(str);
        }
        ContentValues c2 = C0912p.f25111a.c(str);
        if (c2 != null && c2.get("_dUrl") != null && c2.getAsString("_sFile") != null && c2.getAsLong("_sLen") != null && c2.getAsLong("_tLen") != null && c2.getAsString("_MD5") != null) {
            runnableC0918w = new RunnableC0918w((String) c2.get("_dUrl"), c2.getAsString("_sFile"), c2.getAsLong("_sLen").longValue(), c2.getAsLong("_tLen").longValue(), c2.getAsString("_MD5"));
            if (c2.getAsLong("_DLTIME") != null) {
                runnableC0918w.l = c2.getAsLong("_DLTIME").longValue();
            }
        }
        return runnableC0918w == null ? new RunnableC0918w(str, str2, str3, str4) : runnableC0918w;
    }

    public synchronized boolean a(Runnable runnable) {
        ScheduledExecutorService scheduledExecutorService = this.f25175c;
        if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown()) {
            if (runnable == null) {
                X.e("async task = null", new Object[0]);
                return false;
            }
            X.e("task start %s", runnable.getClass().getName());
            this.f25175c.execute(runnable);
            return true;
        }
        X.e("async handler was closed , should not post task!", new Object[0]);
        return false;
    }
}
