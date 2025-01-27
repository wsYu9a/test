package com.umeng.commonsdk.statistics.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a */
    private static d f26306a = null;

    /* renamed from: b */
    private static Context f26307b = null;

    /* renamed from: c */
    private static String f26308c = null;

    /* renamed from: e */
    private static final String f26309e = "mobclick_agent_user_";

    /* renamed from: f */
    private static final String f26310f = "mobclick_agent_header_";

    /* renamed from: g */
    private static final String f26311g = "mobclick_agent_cached_";

    /* renamed from: d */
    private a f26312d;

    public static class a {

        /* renamed from: a */
        private final int f26313a;

        /* renamed from: b */
        private File f26314b;

        /* renamed from: c */
        private FilenameFilter f26315c;

        /* renamed from: com.umeng.commonsdk.statistics.common.d$a$1 */
        class AnonymousClass1 implements FilenameFilter {
            AnonymousClass1() {
            }

            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.startsWith("um");
            }
        }

        public a(Context context) {
            this(context, ".um");
        }

        public boolean a() {
            File[] listFiles = this.f26314b.listFiles();
            return listFiles != null && listFiles.length > 0;
        }

        public void b() {
            File[] listFiles = this.f26314b.listFiles(this.f26315c);
            if (listFiles == null || listFiles.length <= 0) {
                return;
            }
            for (File file : listFiles) {
                file.delete();
            }
        }

        public int c() {
            File[] listFiles = this.f26314b.listFiles(this.f26315c);
            if (listFiles == null || listFiles.length <= 0) {
                return 0;
            }
            return listFiles.length;
        }

        public a(Context context, String str) {
            this.f26313a = 10;
            this.f26315c = new FilenameFilter() { // from class: com.umeng.commonsdk.statistics.common.d.a.1
                AnonymousClass1() {
                }

                @Override // java.io.FilenameFilter
                public boolean accept(File file, String str2) {
                    return str2.startsWith("um");
                }
            };
            File file = new File(context.getFilesDir(), str);
            this.f26314b = file;
            if (file.exists() && this.f26314b.isDirectory()) {
                return;
            }
            this.f26314b.mkdir();
        }

        public void a(b bVar) {
            File file;
            File[] listFiles = this.f26314b.listFiles(this.f26315c);
            if (listFiles != null && listFiles.length >= 10) {
                Arrays.sort(listFiles);
                int length = listFiles.length - 10;
                for (int i2 = 0; i2 < length; i2++) {
                    listFiles[i2].delete();
                }
            }
            if (listFiles == null || listFiles.length <= 0) {
                return;
            }
            bVar.a(this.f26314b);
            int length2 = listFiles.length;
            for (int i3 = 0; i3 < length2; i3++) {
                try {
                } catch (Throwable unused) {
                    file = listFiles[i3];
                }
                if (bVar.b(listFiles[i3])) {
                    file = listFiles[i3];
                    file.delete();
                }
            }
            bVar.c(this.f26314b);
        }

        public void a(byte[] bArr) {
            if (bArr == null || bArr.length == 0) {
                return;
            }
            try {
                HelperUtils.writeFile(new File(this.f26314b, String.format(Locale.US, "um_cache_%d.env", Long.valueOf(System.currentTimeMillis()))), bArr);
            } catch (Exception unused) {
            }
        }
    }

    public interface b {
        void a(File file);

        boolean b(File file);

        void c(File file);
    }

    public d(Context context) {
        this.f26312d = new a(context);
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            f26307b = context.getApplicationContext();
            f26308c = context.getPackageName();
            if (f26306a == null) {
                f26306a = new d(context);
            }
            dVar = f26306a;
        }
        return dVar;
    }

    private SharedPreferences f() {
        return f26307b.getSharedPreferences(f26309e + f26308c, 0);
    }

    public String b() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f26307b);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("st", null);
        }
        return null;
    }

    public boolean c() {
        return UMFrUtils.envelopeFileNumber(f26307b) > 0;
    }

    public String[] d() {
        try {
            SharedPreferences f2 = f();
            String string = f2.getString("au_p", null);
            String string2 = f2.getString("au_u", null);
            if (string != null && string2 != null) {
                return new String[]{string, string2};
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public void e() {
        f().edit().remove("au_p").remove("au_u").commit();
    }

    public void a(int i2) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f26307b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("vt", i2).commit();
        }
    }

    public int a() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f26307b);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("vt", 0);
        }
        return 0;
    }

    public void a(String str) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f26307b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("st", str).commit();
        }
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferences.Editor edit = f().edit();
        edit.putString("au_p", str);
        edit.putString("au_u", str2);
        edit.commit();
    }
}
