package com.martian.libmars.utils;

import android.content.Context;
import android.os.Environment;
import androidx.annotation.NonNull;
import java.io.File;
import java.math.BigDecimal;

/* loaded from: classes2.dex */
public class j0 {

    static class a extends b.d.c.c.g<Void, Void> {

        /* renamed from: a */
        final /* synthetic */ Context f10152a;

        /* renamed from: b */
        final /* synthetic */ b f10153b;

        a(final Context val$listener, final b val$context) {
            this.f10152a = val$listener;
            this.f10153b = val$context;
        }

        @Override // b.d.c.c.g
        /* renamed from: f */
        public Void doInBackground(Void... params) {
            j0.c(this.f10152a.getCacheDir());
            if (!Environment.getExternalStorageState().equals("mounted")) {
                return null;
            }
            j0.c(this.f10152a.getExternalCacheDir());
            return null;
        }

        @Override // b.d.c.c.g
        /* renamed from: g */
        public void onPostExecute(Void a2) {
            super.onPostExecute(a2);
            this.f10153b.clear();
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    public interface b {
        void clear();
    }

    public static void b(@NonNull final Context context, @NonNull final b listener) {
        new a(context, listener).execute(new Void[0]);
    }

    public static boolean c(File dir) {
        String[] list;
        if (dir != null && dir.isDirectory() && (list = dir.list()) != null) {
            for (String str : list) {
                if (!c(new File(dir, str))) {
                    return false;
                }
            }
        }
        return dir != null && dir.delete();
    }

    public static long d(File file) throws Exception {
        long j2 = 0;
        try {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    j2 += file2.isDirectory() ? d(file2) : file2.length();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return j2;
    }

    public static String e(double size) {
        if (size <= 0.0d) {
            return "0.0KB";
        }
        double d2 = size / 1024.0d;
        if (d2 < 1.0d) {
            return size + "KB";
        }
        double d3 = d2 / 1024.0d;
        if (d3 < 1.0d) {
            return new BigDecimal(Double.toString(d2)).setScale(2, 4).toPlainString() + "KB";
        }
        double d4 = d3 / 1024.0d;
        if (d4 < 1.0d) {
            return new BigDecimal(Double.toString(d3)).setScale(2, 4).toPlainString() + "MB";
        }
        double d5 = d4 / 1024.0d;
        if (d5 < 1.0d) {
            return new BigDecimal(Double.toString(d4)).setScale(2, 4).toPlainString() + "GB";
        }
        return new BigDecimal(d5).setScale(2, 4).toPlainString() + "TB";
    }

    public static long f(Context context) {
        try {
            long d2 = d(context.getCacheDir());
            return Environment.getExternalStorageState().equals("mounted") ? d2 + d(context.getExternalCacheDir()) : d2;
        } catch (Exception unused) {
            return 0L;
        }
    }
}
