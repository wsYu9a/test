package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes4.dex */
public class T {

    /* renamed from: a */
    private static T f24994a;

    /* renamed from: c */
    private final Context f24996c;

    /* renamed from: d */
    public P f24997d;

    /* renamed from: f */
    private long f24999f;

    /* renamed from: g */
    private long f25000g;

    /* renamed from: e */
    private Map<Integer, Long> f24998e = new HashMap();

    /* renamed from: h */
    private LinkedBlockingQueue<Runnable> f25001h = new LinkedBlockingQueue<>();

    /* renamed from: i */
    private LinkedBlockingQueue<Runnable> f25002i = new LinkedBlockingQueue<>();

    /* renamed from: j */
    private final Object f25003j = new Object();
    private long k = 0;
    private int l = 0;

    /* renamed from: b */
    private final J f24995b = J.a();

    protected T(Context context) {
        this.f24996c = context;
    }

    static /* synthetic */ int b(T t) {
        int i2 = t.l - 1;
        t.l = i2;
        return i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006c A[Catch: all -> 0x015c, TRY_LEAVE, TryCatch #4 {, blocks: (B:10:0x001f, B:14:0x004b, B:15:0x0050, B:21:0x0062, B:25:0x006c, B:31:0x008e, B:34:0x0083, B:39:0x0094, B:45:0x00b6, B:48:0x00ab, B:51:0x00b9, B:103:0x0059, B:105:0x005d, B:28:0x0077, B:42:0x009f), top: B:9:0x001f, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0094 A[Catch: all -> 0x015c, TRY_LEAVE, TryCatch #4 {, blocks: (B:10:0x001f, B:14:0x004b, B:15:0x0050, B:21:0x0062, B:25:0x006c, B:31:0x008e, B:34:0x0083, B:39:0x0094, B:45:0x00b6, B:48:0x00ab, B:51:0x00b9, B:103:0x0059, B:105:0x005d, B:28:0x0077, B:42:0x009f), top: B:9:0x001f, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(int r13) {
        /*
            Method dump skipped, instructions count: 353
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.T.c(int):void");
    }

    public static synchronized T a(Context context) {
        T t;
        synchronized (T.class) {
            if (f24994a == null) {
                f24994a = new T(context);
            }
            t = f24994a;
        }
        return t;
    }

    public synchronized long b(int i2) {
        if (i2 >= 0) {
            Long l = this.f24998e.get(Integer.valueOf(i2));
            if (l != null) {
                return l.longValue();
            }
        } else {
            X.b("[UploadManager] Unknown upload ID: %d", Integer.valueOf(i2));
        }
        return 0L;
    }

    public static synchronized T a() {
        T t;
        synchronized (T.class) {
            t = f24994a;
        }
        return t;
    }

    public void a(int i2, int i3, byte[] bArr, String str, String str2, P p, long j2, boolean z) {
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            a(new U(this.f24996c, i2, i3, bArr, str, str2, p, true, z), true, true, j2);
        } catch (Throwable th2) {
            th = th2;
            if (X.b(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public void a(int i2, pa paVar, String str, String str2, P p, long j2, boolean z) {
        a(i2, paVar.f25120i, M.a((Object) paVar), str, str2, p, j2, z);
    }

    public void a(int i2, int i3, byte[] bArr, String str, String str2, P p, int i4, int i5, boolean z, Map<String, String> map) {
        try {
            try {
                a(new U(this.f24996c, i2, i3, bArr, str, str2, p, true, i4, i5, false, map), z, false, 0L);
            } catch (Throwable th) {
                th = th;
                if (X.b(th)) {
                    return;
                }
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void a(int i2, int i3, byte[] bArr, String str, String str2, P p, boolean z, Map<String, String> map) {
        a(i2, i3, bArr, str, str2, p, 0, 0, z, map);
    }

    public void a(int i2, pa paVar, String str, String str2, P p, boolean z) {
        a(i2, paVar.f25120i, M.a((Object) paVar), str, str2, p, 0, 0, z, null);
    }

    public long a(boolean z) {
        long j2;
        long b2 = ca.b();
        int i2 = z ? 5 : 3;
        List<L> a2 = this.f24995b.a(i2);
        if (a2 != null && a2.size() > 0) {
            j2 = 0;
            try {
                L l = a2.get(0);
                if (l.f24983e >= b2) {
                    j2 = ca.b(l.f24985g);
                    if (i2 == 3) {
                        this.f24999f = j2;
                    } else {
                        this.f25000g = j2;
                    }
                    a2.remove(l);
                }
            } catch (Throwable th) {
                X.b(th);
            }
            if (a2.size() > 0) {
                this.f24995b.a(a2);
            }
        } else {
            j2 = z ? this.f25000g : this.f24999f;
        }
        X.a("[UploadManager] Local network consume: %d KB", Long.valueOf(j2 / 1024));
        return j2;
    }

    protected synchronized void a(long j2, boolean z) {
        int i2 = z ? 5 : 3;
        L l = new L();
        l.f24980b = i2;
        l.f24983e = ca.b();
        l.f24981c = "";
        l.f24982d = "";
        l.f24985g = ca.b(j2);
        this.f24995b.b(i2);
        this.f24995b.c(l);
        if (z) {
            this.f25000g = j2;
        } else {
            this.f24999f = j2;
        }
        X.a("[UploadManager] Network total consume: %d KB", Long.valueOf(j2 / 1024));
    }

    public synchronized void a(int i2, long j2) {
        if (i2 >= 0) {
            this.f24998e.put(Integer.valueOf(i2), Long.valueOf(j2));
            L l = new L();
            l.f24980b = i2;
            l.f24983e = j2;
            l.f24981c = "";
            l.f24982d = "";
            l.f24985g = new byte[0];
            this.f24995b.b(i2);
            this.f24995b.c(l);
            X.a("[UploadManager] Uploading(ID:%d) time: %s", Integer.valueOf(i2), ca.a(j2));
        } else {
            X.b("[UploadManager] Unknown uploading ID: %d", Integer.valueOf(i2));
        }
    }

    public boolean a(int i2) {
        if (com.tencent.bugly.b.f24588c) {
            X.a("Uploading frequency will not be checked if SDK is in debug mode.", new Object[0]);
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - b(i2);
        X.a("[UploadManager] Time interval is %d seconds since last uploading(ID: %d).", Long.valueOf(currentTimeMillis / 1000), Integer.valueOf(i2));
        if (currentTimeMillis >= 30000) {
            return true;
        }
        X.c("[UploadManager] Data only be uploaded once in %d seconds.", 30L);
        return false;
    }

    private boolean a(Runnable runnable, boolean z) {
        if (runnable == null) {
            X.c("[UploadManager] Upload task should not be null", new Object[0]);
            return false;
        }
        try {
            X.a("[UploadManager] Add upload task to queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            synchronized (this.f25003j) {
                if (z) {
                    this.f25001h.put(runnable);
                } else {
                    this.f25002i.put(runnable);
                }
            }
            return true;
        } catch (Throwable th) {
            X.b("[UploadManager] Failed to add upload task to queue: %s", th.getMessage());
            return false;
        }
    }

    private void a(Runnable runnable, long j2) {
        if (runnable == null) {
            X.e("[UploadManager] Upload task should not be null", new Object[0]);
            return;
        }
        X.a("[UploadManager] Execute synchronized upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        Thread a2 = ca.a(runnable, "BUGLY_SYNC_UPLOAD");
        if (a2 == null) {
            X.b("[UploadManager] Failed to start a thread to execute synchronized upload task, add it to queue.", new Object[0]);
            a(runnable, true);
            return;
        }
        try {
            a2.join(j2);
        } catch (Throwable th) {
            X.b("[UploadManager] Failed to join upload synchronized task with message: %s. Add it to queue.", th.getMessage());
            a(runnable, true);
            c(0);
        }
    }

    private void a(Runnable runnable, boolean z, boolean z2, long j2) {
        if (runnable == null) {
            X.e("[UploadManager] Upload task should not be null", new Object[0]);
        }
        X.a("[UploadManager] Add upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        if (z2) {
            a(runnable, j2);
        } else {
            a(runnable, z);
            c(0);
        }
    }
}
