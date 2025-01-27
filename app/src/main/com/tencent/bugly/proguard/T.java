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
    private static T f22643a;

    /* renamed from: c */
    private final Context f22645c;

    /* renamed from: d */
    public P f22646d;

    /* renamed from: f */
    private long f22648f;

    /* renamed from: g */
    private long f22649g;

    /* renamed from: e */
    private Map<Integer, Long> f22647e = new HashMap();

    /* renamed from: h */
    private LinkedBlockingQueue<Runnable> f22650h = new LinkedBlockingQueue<>();

    /* renamed from: i */
    private LinkedBlockingQueue<Runnable> f22651i = new LinkedBlockingQueue<>();

    /* renamed from: j */
    private final Object f22652j = new Object();

    /* renamed from: k */
    private long f22653k = 0;

    /* renamed from: l */
    private int f22654l = 0;

    /* renamed from: b */
    private final J f22644b = J.a();

    public T(Context context) {
        this.f22645c = context;
    }

    public static /* synthetic */ int b(T t10) {
        int i10 = t10.f22654l - 1;
        t10.f22654l = i10;
        return i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0070 A[Catch: all -> 0x0053, TRY_LEAVE, TryCatch #0 {all -> 0x0053, blocks: (B:10:0x0021, B:14:0x004c, B:15:0x0051, B:21:0x0066, B:25:0x0070, B:31:0x0092, B:34:0x0087, B:39:0x0097, B:45:0x00b9, B:48:0x00ae, B:51:0x00bb, B:103:0x005d, B:105:0x0061, B:28:0x007b, B:42:0x00a2), top: B:9:0x0021, inners: #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0097 A[Catch: all -> 0x0053, TRY_LEAVE, TryCatch #0 {all -> 0x0053, blocks: (B:10:0x0021, B:14:0x004c, B:15:0x0051, B:21:0x0066, B:25:0x0070, B:31:0x0092, B:34:0x0087, B:39:0x0097, B:45:0x00b9, B:48:0x00ae, B:51:0x00bb, B:103:0x005d, B:105:0x0061, B:28:0x007b, B:42:0x00a2), top: B:9:0x0021, inners: #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(int r14) {
        /*
            Method dump skipped, instructions count: 351
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.T.c(int):void");
    }

    public static synchronized T a(Context context) {
        T t10;
        synchronized (T.class) {
            try {
                if (f22643a == null) {
                    f22643a = new T(context);
                }
                t10 = f22643a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return t10;
    }

    public synchronized long b(int i10) {
        if (i10 >= 0) {
            Long l10 = this.f22647e.get(Integer.valueOf(i10));
            if (l10 != null) {
                return l10.longValue();
            }
        } else {
            X.b("[UploadManager] Unknown upload ID: %d", Integer.valueOf(i10));
        }
        return 0L;
    }

    public static synchronized T a() {
        T t10;
        synchronized (T.class) {
            t10 = f22643a;
        }
        return t10;
    }

    public void a(int i10, int i11, byte[] bArr, String str, String str2, P p10, long j10, boolean z10) {
        try {
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            a(new U(this.f22645c, i10, i11, bArr, str, str2, p10, true, z10), true, true, j10);
        } catch (Throwable th3) {
            th = th3;
            if (X.b(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public void a(int i10, pa paVar, String str, String str2, P p10, long j10, boolean z10) {
        a(i10, paVar.f22808i, M.a((Object) paVar), str, str2, p10, j10, z10);
    }

    public void a(int i10, int i11, byte[] bArr, String str, String str2, P p10, int i12, int i13, boolean z10, Map<String, String> map) {
        try {
            try {
                a(new U(this.f22645c, i10, i11, bArr, str, str2, p10, true, i12, i13, false, map), z10, false, 0L);
            } catch (Throwable th2) {
                th = th2;
                if (X.b(th)) {
                    return;
                }
                th.printStackTrace();
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public void a(int i10, int i11, byte[] bArr, String str, String str2, P p10, boolean z10, Map<String, String> map) {
        a(i10, i11, bArr, str, str2, p10, 0, 0, z10, map);
    }

    public void a(int i10, pa paVar, String str, String str2, P p10, boolean z10) {
        a(i10, paVar.f22808i, M.a((Object) paVar), str, str2, p10, 0, 0, z10, null);
    }

    public long a(boolean z10) {
        long j10;
        long b10 = ca.b();
        int i10 = z10 ? 5 : 3;
        List<L> a10 = this.f22644b.a(i10);
        if (a10 != null && a10.size() > 0) {
            j10 = 0;
            try {
                L l10 = a10.get(0);
                if (l10.f22632e >= b10) {
                    j10 = ca.b(l10.f22634g);
                    if (i10 == 3) {
                        this.f22648f = j10;
                    } else {
                        this.f22649g = j10;
                    }
                    a10.remove(l10);
                }
            } catch (Throwable th2) {
                X.b(th2);
            }
            if (a10.size() > 0) {
                this.f22644b.a(a10);
            }
        } else {
            j10 = z10 ? this.f22649g : this.f22648f;
        }
        X.a("[UploadManager] Local network consume: %d KB", Long.valueOf(j10 / 1024));
        return j10;
    }

    public synchronized void a(long j10, boolean z10) {
        int i10 = z10 ? 5 : 3;
        try {
            L l10 = new L();
            l10.f22629b = i10;
            l10.f22632e = ca.b();
            l10.f22630c = "";
            l10.f22631d = "";
            l10.f22634g = ca.b(j10);
            this.f22644b.b(i10);
            this.f22644b.c(l10);
            if (z10) {
                this.f22649g = j10;
            } else {
                this.f22648f = j10;
            }
            X.a("[UploadManager] Network total consume: %d KB", Long.valueOf(j10 / 1024));
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void a(int i10, long j10) {
        try {
            if (i10 >= 0) {
                this.f22647e.put(Integer.valueOf(i10), Long.valueOf(j10));
                L l10 = new L();
                l10.f22629b = i10;
                l10.f22632e = j10;
                l10.f22630c = "";
                l10.f22631d = "";
                l10.f22634g = new byte[0];
                this.f22644b.b(i10);
                this.f22644b.c(l10);
                X.a("[UploadManager] Uploading(ID:%d) time: %s", Integer.valueOf(i10), ca.a(j10));
            } else {
                X.b("[UploadManager] Unknown uploading ID: %d", Integer.valueOf(i10));
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public boolean a(int i10) {
        if (com.tencent.bugly.b.f22066c) {
            X.a("Uploading frequency will not be checked if SDK is in debug mode.", new Object[0]);
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - b(i10);
        X.a("[UploadManager] Time interval is %d seconds since last uploading(ID: %d).", Long.valueOf(currentTimeMillis / 1000), Integer.valueOf(i10));
        if (currentTimeMillis >= 30000) {
            return true;
        }
        X.c("[UploadManager] Data only be uploaded once in %d seconds.", 30L);
        return false;
    }

    private boolean a(Runnable runnable, boolean z10) {
        if (runnable == null) {
            X.c("[UploadManager] Upload task should not be null", new Object[0]);
            return false;
        }
        try {
            X.a("[UploadManager] Add upload task to queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            synchronized (this.f22652j) {
                try {
                    if (z10) {
                        this.f22650h.put(runnable);
                    } else {
                        this.f22651i.put(runnable);
                    }
                } finally {
                }
            }
            return true;
        } catch (Throwable th2) {
            X.b("[UploadManager] Failed to add upload task to queue: %s", th2.getMessage());
            return false;
        }
    }

    private void a(Runnable runnable, long j10) {
        if (runnable == null) {
            X.e("[UploadManager] Upload task should not be null", new Object[0]);
            return;
        }
        X.a("[UploadManager] Execute synchronized upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        Thread a10 = ca.a(runnable, "BUGLY_SYNC_UPLOAD");
        if (a10 == null) {
            X.b("[UploadManager] Failed to start a thread to execute synchronized upload task, add it to queue.", new Object[0]);
            a(runnable, true);
            return;
        }
        try {
            a10.join(j10);
        } catch (Throwable th2) {
            X.b("[UploadManager] Failed to join upload synchronized task with message: %s. Add it to queue.", th2.getMessage());
            a(runnable, true);
            c(0);
        }
    }

    private void a(Runnable runnable, boolean z10, boolean z11, long j10) {
        if (runnable == null) {
            X.e("[UploadManager] Upload task should not be null", new Object[0]);
        }
        X.a("[UploadManager] Add upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        if (z11) {
            a(runnable, j10);
        } else {
            a(runnable, z10);
            c(0);
        }
    }
}
