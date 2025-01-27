package com.opos.cmn.func.a.a;

import android.content.Context;
import com.opos.cmn.an.g.f;
import com.opos.cmn.an.g.g;
import com.opos.cmn.an.g.h;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.apache.http.HttpHeaders;

/* loaded from: classes4.dex */
public class c implements Runnable {

    /* renamed from: a */
    private Context f17032a;

    /* renamed from: b */
    private com.opos.cmn.func.a.a f17033b;

    /* renamed from: c */
    private long f17034c;

    /* renamed from: d */
    private long f17035d;

    /* renamed from: e */
    private CountDownLatch f17036e;

    /* renamed from: f */
    private boolean f17037f = false;

    /* renamed from: g */
    private long f17038g;

    /* renamed from: h */
    private int f17039h;

    protected class a {

        /* renamed from: b */
        private RandomAccessFile f17041b;

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
                this.f17041b = randomAccessFile;
                randomAccessFile.seek(j2);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("DownloadThread", "", e2);
            }
        }

        public int a(byte[] bArr, int i2, int i3) {
            synchronized (this) {
                RandomAccessFile randomAccessFile = this.f17041b;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.write(bArr, i2, i3);
                    } catch (IOException e2) {
                        com.opos.cmn.an.f.a.c("DownloadThread", "", e2);
                    }
                }
                i3 = -1;
            }
            return i3;
        }

        public void a() {
            synchronized (this) {
                RandomAccessFile randomAccessFile = this.f17041b;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e2) {
                        com.opos.cmn.an.f.a.c("DownloadThread", "", e2);
                    }
                }
            }
        }
    }

    public c(Context context, com.opos.cmn.func.a.a aVar, long j2, long j3, long j4, CountDownLatch countDownLatch) {
        this.f17039h = -1;
        this.f17032a = context.getApplicationContext();
        this.f17033b = aVar;
        this.f17038g = j2;
        this.f17034c = j3;
        this.f17035d = j4;
        this.f17036e = countDownLatch;
        this.f17039h = hashCode();
    }

    public long a() {
        return this.f17034c;
    }

    public long b() {
        return this.f17035d;
    }

    public boolean c() {
        return this.f17037f;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j2;
        long j3;
        long j4;
        String str;
        com.opos.cmn.an.f.a.b("DownloadThread", "threadId=" + this.f17039h + " start.");
        com.opos.cmn.an.f.a.b("DownloadThread", "threadId=" + this.f17039h + " ,startPos=" + this.f17034c + ",endPos=" + this.f17035d);
        try {
            try {
                if (this.f17035d + 1 > this.f17034c) {
                    long a2 = h.a();
                    HashMap hashMap = new HashMap();
                    Map<String, String> map = this.f17033b.f17014a.f16496d;
                    if (map != null) {
                        hashMap.putAll(map);
                    }
                    String str2 = "bytes=" + this.f17034c + "-" + this.f17035d;
                    com.opos.cmn.an.f.a.b("DownloadThread", "rangeProperty=" + str2);
                    hashMap.put(HttpHeaders.RANGE, str2);
                    g a3 = h.a(this.f17032a, a2, new f.a().a(this.f17033b.f17014a.f16493a).b(this.f17033b.f17014a.f16495c).a(hashMap).a(this.f17033b.f17014a.f16494b).a(this.f17033b.f17014a.f16499g).a(this.f17033b.f17014a.f16501i).a(this.f17033b.f17014a.f16500h).b(this.f17033b.f17014a.f16497e).c(this.f17033b.f17014a.f16498f).a());
                    if (a3 != null) {
                        com.opos.cmn.an.f.a.b("DownloadThread", "httpResponseEntity.getResponseCode()=" + a3.f16511a);
                        int i2 = a3.f16511a;
                        if (206 != i2 && 200 != i2) {
                            str = "httpResponseEntity.getResponseCode()=" + a3.f16511a;
                        }
                        InputStream inputStream = a3.f16513c;
                        if (inputStream != null) {
                            a aVar = new a(d.b(this.f17032a, this.f17033b), this.f17034c);
                            byte[] bArr = new byte[4096];
                            while (true) {
                                try {
                                    try {
                                        int read = inputStream.read(bArr);
                                        if (-1 == read || this.f17034c >= this.f17035d) {
                                            break;
                                        }
                                        int a4 = aVar.a(bArr, 0, read);
                                        com.opos.cmn.an.f.a.b("DownloadThread", "threadId=" + this.f17039h + ", pro=" + a4);
                                        this.f17034c = this.f17034c + ((long) a4);
                                        com.opos.cmn.an.f.a.b("DownloadThread", "threadId=" + this.f17039h + " ,startPos=" + this.f17034c);
                                    } catch (Exception e2) {
                                        com.opos.cmn.an.f.a.c("DownloadThread", "", e2);
                                    }
                                } finally {
                                    aVar.a();
                                }
                            }
                        } else {
                            str = "InputStream is null.";
                        }
                    } else {
                        str = "httpResponseEntity is null.";
                    }
                    com.opos.cmn.an.f.a.b("DownloadThread", str);
                }
                com.opos.cmn.an.f.a.b("DownloadThread", "threadId=" + this.f17039h + " ,startPos=" + this.f17034c + ",endPos=" + this.f17035d);
                j2 = this.f17035d;
                j3 = 1 + j2;
                j4 = this.f17034c;
            } catch (Exception e3) {
                com.opos.cmn.an.f.a.c("DownloadThread", "DownloadThread run", e3);
            }
            if (j3 == j4) {
                com.opos.cmn.an.f.a.b("DownloadThread", "start=endPos+1,download success.");
            } else {
                if (this.f17038g != j2 || j2 != j4) {
                    com.opos.cmn.an.f.a.b("DownloadThread", "start!=endPos,download fail.");
                    this.f17036e.countDown();
                    com.opos.cmn.an.f.a.b("DownloadThread", "threadId=" + this.f17039h + " end.");
                }
                com.opos.cmn.an.f.a.b("DownloadThread", "start=endPos=contentLength,download success.");
            }
            this.f17037f = true;
            this.f17036e.countDown();
            com.opos.cmn.an.f.a.b("DownloadThread", "threadId=" + this.f17039h + " end.");
        } catch (Throwable th) {
            this.f17036e.countDown();
            throw th;
        }
    }
}
