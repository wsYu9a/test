package com.tencent.open.a;

import android.annotation.SuppressLint;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import java.text.SimpleDateFormat;

/* loaded from: classes4.dex */
public class d {

    public static final class a {
        public static final boolean a(int i2, int i3) {
            return i3 == (i2 & i3);
        }
    }

    public static final class b {
        public static boolean a() {
            String externalStorageState = Environment.getExternalStorageState();
            return "mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState);
        }

        public static c b() {
            if (a()) {
                return c.b(Environment.getExternalStorageDirectory());
            }
            return null;
        }
    }

    public static class c {

        /* renamed from: a */
        private File f25427a;

        /* renamed from: b */
        private long f25428b;

        /* renamed from: c */
        private long f25429c;

        public File a() {
            return this.f25427a;
        }

        public long b() {
            return this.f25428b;
        }

        public long c() {
            return this.f25429c;
        }

        public String toString() {
            return String.format("[%s : %d / %d]", a().getAbsolutePath(), Long.valueOf(c()), Long.valueOf(b()));
        }

        public void a(File file) {
            this.f25427a = file;
        }

        public void b(long j2) {
            this.f25429c = j2;
        }

        public static c b(File file) {
            c cVar = new c();
            cVar.a(file);
            StatFs statFs = new StatFs(file.getAbsolutePath());
            long blockSize = statFs.getBlockSize();
            long blockCount = statFs.getBlockCount();
            long availableBlocks = statFs.getAvailableBlocks();
            cVar.a(blockCount * blockSize);
            cVar.b(availableBlocks * blockSize);
            return cVar;
        }

        public void a(long j2) {
            this.f25428b = j2;
        }
    }

    /* renamed from: com.tencent.open.a.d$d */
    public static final class C0531d {
        @SuppressLint({"SimpleDateFormat"})
        public static SimpleDateFormat a(String str) {
            return new SimpleDateFormat(str);
        }
    }
}
