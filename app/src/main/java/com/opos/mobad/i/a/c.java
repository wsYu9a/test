package com.opos.mobad.i.a;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes4.dex */
public class c implements Runnable {

    /* renamed from: a */
    private Context f20999a;

    /* renamed from: b */
    private com.opos.mobad.i.a f21000b;

    /* renamed from: c */
    private long f21001c;

    /* renamed from: d */
    private long f21002d;

    /* renamed from: e */
    private CountDownLatch f21003e;

    /* renamed from: f */
    private boolean f21004f = false;

    /* renamed from: g */
    private long f21005g;

    /* renamed from: h */
    private int f21006h;

    protected class a {

        /* renamed from: b */
        private RandomAccessFile f21008b;

        public a(File file, long j2) {
            if (file == null || -1 == j2) {
                return;
            }
            com.opos.cmn.an.f.a.b("DownloadThread", "seekPos=" + j2);
            try {
                File parentFile = file.getParentFile();
                if (parentFile != null && !parentFile.exists()) {
                    parentFile.mkdirs();
                }
                if (!file.exists()) {
                    file.createNewFile();
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                this.f21008b = randomAccessFile;
                randomAccessFile.seek(j2);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("DownloadThread", "", (Throwable) e2);
            }
        }

        public int a(byte[] bArr, int i2, int i3) {
            synchronized (this) {
                RandomAccessFile randomAccessFile = this.f21008b;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.write(bArr, i2, i3);
                    } catch (IOException e2) {
                        com.opos.cmn.an.f.a.a("DownloadThread", "", (Throwable) e2);
                    }
                }
                i3 = -1;
            }
            return i3;
        }

        public void a() {
            synchronized (this) {
                RandomAccessFile randomAccessFile = this.f21008b;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e2) {
                        com.opos.cmn.an.f.a.a("DownloadThread", "", (Throwable) e2);
                    }
                }
            }
        }
    }

    public c(Context context, com.opos.mobad.i.a aVar, long j2, long j3, long j4, CountDownLatch countDownLatch) {
        this.f21006h = -1;
        this.f20999a = context.getApplicationContext();
        this.f21000b = aVar;
        this.f21005g = j2;
        this.f21001c = j3;
        this.f21002d = j4;
        this.f21003e = countDownLatch;
        this.f21006h = hashCode();
    }

    public long a() {
        return this.f21001c;
    }

    public long b() {
        return this.f21002d;
    }

    public boolean c() {
        return this.f21004f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0181, code lost:
    
        if (0 == 0) goto L134;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 520
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.i.a.c.run():void");
    }
}
