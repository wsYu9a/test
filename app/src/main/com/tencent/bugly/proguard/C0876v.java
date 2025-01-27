package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.text.TextUtils;
import com.tencent.bugly.beta.download.DownloadTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: com.tencent.bugly.proguard.v */
/* loaded from: classes4.dex */
public class C0876v implements com.tencent.bugly.beta.download.c {

    /* renamed from: a */
    public static C0876v f22882a = new C0876v();

    /* renamed from: b */
    public ConcurrentHashMap<String, DownloadTask> f22883b = new ConcurrentHashMap<>(3);

    /* renamed from: c */
    private ScheduledExecutorService f22884c;

    public C0876v() {
        this.f22884c = null;
        try {
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(3, new ThreadFactoryC0875u(this));
            this.f22884c = newScheduledThreadPool;
            if (newScheduledThreadPool.isShutdown()) {
                throw new IllegalArgumentException("ScheduledExecutorService is not available!");
            }
        } catch (Exception e10) {
            X.b(e10);
        }
    }

    @Override // com.tencent.bugly.beta.download.c
    public DownloadTask a(String str, String str2, String str3, String str4) {
        RunnableC0877w runnableC0877w = null;
        if (TextUtils.isEmpty(str)) {
            X.b("downloadUrl is null!", new Object[0]);
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            X.b("saveDir is null!", new Object[0]);
            return null;
        }
        if (this.f22883b.get(str) != null) {
            return this.f22883b.get(str);
        }
        ContentValues c10 = C0871p.f22799a.c(str);
        if (c10 != null && c10.get("_dUrl") != null && c10.getAsString("_sFile") != null && c10.getAsLong("_sLen") != null && c10.getAsLong("_tLen") != null && c10.getAsString("_MD5") != null) {
            runnableC0877w = new RunnableC0877w((String) c10.get("_dUrl"), c10.getAsString("_sFile"), c10.getAsLong("_sLen").longValue(), c10.getAsLong("_tLen").longValue(), c10.getAsString("_MD5"));
            if (c10.getAsLong("_DLTIME") != null) {
                runnableC0877w.f22886l = c10.getAsLong("_DLTIME").longValue();
            }
        }
        return runnableC0877w == null ? new RunnableC0877w(str, str2, str3, str4) : runnableC0877w;
    }

    public synchronized boolean a(Runnable runnable) {
        ScheduledExecutorService scheduledExecutorService = this.f22884c;
        if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown()) {
            if (runnable == null) {
                X.e("async task = null", new Object[0]);
                return false;
            }
            X.e("task start %s", runnable.getClass().getName());
            this.f22884c.execute(runnable);
            return true;
        }
        X.e("async handler was closed , should not post task!", new Object[0]);
        return false;
    }
}
