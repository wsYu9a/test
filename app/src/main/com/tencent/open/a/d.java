package com.tencent.open.a;

import android.annotation.SuppressLint;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import java.text.SimpleDateFormat;

/* loaded from: classes4.dex */
public class d {

    public static final class a {
        public static final boolean a(int i10, int i11) {
            return i11 == (i10 & i11);
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
        private File f23160a;

        /* renamed from: b */
        private long f23161b;

        /* renamed from: c */
        private long f23162c;

        public File a() {
            return this.f23160a;
        }

        public long b() {
            return this.f23161b;
        }

        public long c() {
            return this.f23162c;
        }

        public String toString() {
            return String.format("[%s : %d / %d]", a().getAbsolutePath(), Long.valueOf(c()), Long.valueOf(b()));
        }

        public void a(File file) {
            this.f23160a = file;
        }

        public void b(long j10) {
            this.f23162c = j10;
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

        public void a(long j10) {
            this.f23161b = j10;
        }
    }

    /* renamed from: com.tencent.open.a.d$d */
    public static final class C0660d {
        @SuppressLint({"SimpleDateFormat"})
        public static SimpleDateFormat a(String str) {
            return new SimpleDateFormat(str);
        }
    }
}
