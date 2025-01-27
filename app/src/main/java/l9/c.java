package l9;

import android.content.Context;
import android.os.Environment;
import androidx.annotation.NonNull;
import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;

/* loaded from: classes3.dex */
public class c {

    public interface b {
        void clear();
    }

    public static void b(Context context, @NonNull b bVar) {
        if (context == null) {
            return;
        }
        new a(context, bVar).executeSerial(new Void[0]);
    }

    public static boolean c(File file) {
        String[] list;
        if (file != null && file.isDirectory() && (list = file.list()) != null) {
            for (String str : list) {
                if (!c(new File(file, str))) {
                    return false;
                }
            }
        }
        return file != null && file.delete();
    }

    public static long d(File file) throws Exception {
        long j10 = 0;
        try {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    j10 += file2.isDirectory() ? d(file2) : file2.length();
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return j10;
    }

    public static String e(double d10) {
        if (d10 <= l5.c.f27899e) {
            return "0.0KB";
        }
        double d11 = d10 / 1024.0d;
        if (d11 < 1.0d) {
            return d10 + "KB";
        }
        double d12 = d11 / 1024.0d;
        if (d12 < 1.0d) {
            return new BigDecimal(Double.toString(d11)).setScale(2, RoundingMode.HALF_UP).toPlainString() + "KB";
        }
        double d13 = d12 / 1024.0d;
        if (d13 < 1.0d) {
            return new BigDecimal(Double.toString(d12)).setScale(2, RoundingMode.HALF_UP).toPlainString() + "MB";
        }
        double d14 = d13 / 1024.0d;
        if (d14 < 1.0d) {
            return new BigDecimal(Double.toString(d13)).setScale(2, RoundingMode.HALF_UP).toPlainString() + "GB";
        }
        return new BigDecimal(d14).setScale(2, RoundingMode.HALF_UP).toPlainString() + "TB";
    }

    public static long f(Context context) {
        try {
            long d10 = d(context.getCacheDir());
            return Environment.getExternalStorageState().equals("mounted") ? d10 + d(context.getExternalCacheDir()) : d10;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public class a extends y8.f<Void, Void> {

        /* renamed from: a */
        public final /* synthetic */ Context f27964a;

        /* renamed from: b */
        public final /* synthetic */ b f27965b;

        public a(Context context, b bVar) {
            this.f27964a = context;
            this.f27965b = bVar;
        }

        @Override // y8.f
        /* renamed from: f */
        public Void doInBackground(Void... voidArr) {
            c.c(this.f27964a.getCacheDir());
            if (!Environment.getExternalStorageState().equals("mounted")) {
                return null;
            }
            c.c(this.f27964a.getExternalCacheDir());
            return null;
        }

        @Override // y8.f
        /* renamed from: g */
        public void onPostExecute(Void r12) {
            super.onPostExecute(r12);
            this.f27965b.clear();
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }
    }
}
