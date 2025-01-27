package com.vivo.ic.dm.p;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.FileFilter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.CRC32;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private static final String f28586a = "b";

    /* renamed from: b */
    private static final String f28587b = "oem/etc/domains/";

    /* renamed from: c */
    private static final String f28588c = "data/bbkcore/domains/";

    /* renamed from: d */
    private static final String f28589d = "sp_vivo_damons_domain_cache";

    /* renamed from: e */
    private static final String f28590e = "sp_key_crc_";

    /* renamed from: f */
    private static final String f28591f = "metadatas";

    /* renamed from: g */
    private static final String f28592g = "key";

    /* renamed from: h */
    private static final String f28593h = "value";

    /* renamed from: i */
    private static final String f28594i = "";

    /* renamed from: j */
    private static b f28595j;
    private Context k;
    private Map<String, List<InterfaceC0570b>> l;

    private abstract class a implements InterfaceC0570b {

        /* renamed from: a */
        String f28596a;

        public a(String str) {
            this.f28596a = str;
        }
    }

    /* renamed from: com.vivo.ic.dm.p.b$b */
    private interface InterfaceC0570b {
        String a(String str);

        boolean a();
    }

    private class c extends a implements InterfaceC0570b {

        /* renamed from: c */
        private Map<String, String> f28598c;

        public c(String str) {
            super(str);
        }

        private void b() {
            if (this.f28598c == null) {
                this.f28598c = new HashMap();
                byte[] a2 = b.this.a(new File(b.f28587b + this.f28596a));
                if (a2 == null) {
                    Log.e(b.f28586a, "read oem default error");
                    return;
                }
                try {
                    Map<? extends String, ? extends String> a3 = b.this.a(a2);
                    if (a3 != null) {
                        this.f28598c.putAll(a3);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // com.vivo.ic.dm.p.b.InterfaceC0570b
        public boolean a() {
            if (this.f28598c == null) {
                if (!new File(b.f28587b + this.f28596a).exists()) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.vivo.ic.dm.p.b.InterfaceC0570b
        public String a(String str) {
            b();
            String str2 = this.f28598c.get(str);
            return TextUtils.isEmpty(str2) ? "" : str2;
        }
    }

    private class d extends a implements InterfaceC0570b {

        /* renamed from: c */
        private Map<String, ?> f28600c;

        /* renamed from: d */
        private boolean f28601d;

        class a implements FileFilter {
            a() {
            }

            @Override // java.io.FileFilter
            public boolean accept(File file) {
                if (file == null) {
                    return false;
                }
                String path = file.getPath();
                return !TextUtils.isEmpty(path) && path.endsWith(d.this.f28596a);
            }
        }

        public d(String str) {
            super(str);
            this.f28601d = false;
        }

        private void b() {
            String name;
            int lastIndexOf;
            File[] listFiles;
            if (this.f28601d) {
                return;
            }
            this.f28601d = true;
            File file = new File(b.f28588c);
            File file2 = null;
            if (file.exists() && (listFiles = file.listFiles(new a())) != null && listFiles.length > 0) {
                file2 = listFiles[0];
            }
            if (file2 == null || !file2.exists() || (lastIndexOf = (name = file2.getName()).lastIndexOf(this.f28596a)) <= 0) {
                return;
            }
            try {
                SharedPreferences sharedPreferences = b.this.k.getSharedPreferences(b.f28589d, 0);
                String substring = name.substring(0, lastIndexOf);
                if (sharedPreferences.getString(b.f28590e + this.f28596a, "").equals(substring)) {
                    Log.i(b.f28586a, "skip read vivo damons file");
                    return;
                }
                byte[] a2 = b.this.a(file2);
                if (a2 == null) {
                    Log.e(b.f28586a, "read vivoDomainFile error");
                    return;
                }
                CRC32 crc32 = new CRC32();
                crc32.update(a2);
                String format = String.format("%08x", Long.valueOf(crc32.getValue()));
                if (!substring.equals(format)) {
                    Log.e(b.f28586a, "skip read vivo damons file");
                    return;
                }
                Map a3 = b.this.a(a2);
                if (a3 == null || a3.size() <= 0) {
                    return;
                }
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString(b.f28590e + this.f28596a, format);
                for (Map.Entry entry : a3.entrySet()) {
                    edit.putString((String) entry.getKey(), (String) entry.getValue());
                }
                if (edit.commit()) {
                    return;
                }
                Log.e(b.f28586a, "commit failed!");
            } catch (Exception e2) {
                Log.e(b.f28586a, "read or parse error", e2);
            }
        }

        @Override // com.vivo.ic.dm.p.b.InterfaceC0570b
        public boolean a() {
            b();
            return true;
        }

        @Override // com.vivo.ic.dm.p.b.InterfaceC0570b
        public String a(String str) {
            SharedPreferences sharedPreferences = b.this.k.getSharedPreferences(b.f28589d, 0);
            if (this.f28600c == null) {
                this.f28600c = sharedPreferences.getAll();
            }
            Object obj = this.f28600c.get(str);
            return (obj != null && (obj instanceof String)) ? (String) obj : "";
        }
    }

    private b() {
    }

    public static b b() {
        if (f28595j == null) {
            synchronized (b.class) {
                if (f28595j == null) {
                    f28595j = new b();
                }
            }
        }
        return f28595j;
    }

    public void a(Context context) {
        if (context == null) {
            Log.e(f28586a, "ctx is null when init");
        } else {
            this.k = context.getApplicationContext();
        }
    }

    public String a(String str, String str2) {
        return a(str, str2, "sdk_com.vivo.ic");
    }

    public synchronized String a(String str, String str2, String str3) {
        if (this.k == null) {
            Log.e(f28586a, "ctx is null when getDomain");
            return str2;
        }
        if (TextUtils.isEmpty(str)) {
            Log.e(f28586a, "key is empty");
            return str2;
        }
        if (str3 == null) {
            str3 = this.k.getPackageName();
        }
        if (this.l == null) {
            this.l = new HashMap();
        }
        Log.d(f28586a, "test: domain repo size:" + this.l.size());
        List<InterfaceC0570b> list = this.l.get(str3);
        if (list == null) {
            list = new ArrayList<>();
            list.add(new d(str3));
            list.add(new c(str3));
            this.l.put(str3, list);
        }
        String a2 = a(str, list);
        if (!TextUtils.isEmpty(a2) && !"".equals(a2)) {
            str2 = a2;
        }
        return str2;
    }

    private String a(String str, List<InterfaceC0570b> list) {
        String str2 = null;
        for (InterfaceC0570b interfaceC0570b : list) {
            if (interfaceC0570b.a()) {
                str2 = interfaceC0570b.a(str);
                if (!TextUtils.isEmpty(str2)) {
                    break;
                }
            }
        }
        return TextUtils.isEmpty(str2) ? "" : str2;
    }

    public Map<String, String> a(byte[] bArr) throws UnsupportedEncodingException, JSONException {
        JSONObject jSONObject = new JSONObject(new String(bArr, "UTF-8").trim());
        if (!jSONObject.has(f28591f)) {
            return null;
        }
        JSONArray jSONArray = jSONObject.getJSONArray(f28591f);
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
            String string = jSONObject2.getString(f28592g);
            String string2 = jSONObject2.getString("value");
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                hashMap.put(string, string2);
            }
        }
        return hashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0069 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] a(java.io.File r6) {
        /*
            r5 = this;
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r6]     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L37
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L37
            r3.<init>(r6)     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L37
        Lf:
            int r6 = r1.read(r2)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            r4 = -1
            if (r6 == r4) goto L1b
            r4 = 0
            r3.write(r2, r4, r6)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            goto Lf
        L1b:
            byte[] r6 = r3.toByteArray()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            r1.close()     // Catch: java.io.IOException -> L23
            goto L27
        L23:
            r0 = move-exception
            r0.printStackTrace()
        L27:
            r3.close()     // Catch: java.io.IOException -> L2b
            goto L2f
        L2b:
            r0 = move-exception
            r0.printStackTrace()
        L2f:
            return r6
        L30:
            r6 = move-exception
            goto L5c
        L32:
            r6 = move-exception
            goto L40
        L34:
            r6 = move-exception
            r3 = r0
            goto L5c
        L37:
            r6 = move-exception
            r3 = r0
            goto L40
        L3a:
            r6 = move-exception
            r3 = r0
            goto L5d
        L3d:
            r6 = move-exception
            r1 = r0
            r3 = r1
        L40:
            java.lang.String r2 = com.vivo.ic.dm.p.b.f28586a     // Catch: java.lang.Throwable -> L30
            java.lang.String r4 = "read or parse error"
            android.util.Log.e(r2, r4, r6)     // Catch: java.lang.Throwable -> L30
            if (r1 == 0) goto L51
            r1.close()     // Catch: java.io.IOException -> L4d
            goto L51
        L4d:
            r6 = move-exception
            r6.printStackTrace()
        L51:
            if (r3 == 0) goto L5b
            r3.close()     // Catch: java.io.IOException -> L57
            goto L5b
        L57:
            r6 = move-exception
            r6.printStackTrace()
        L5b:
            return r0
        L5c:
            r0 = r1
        L5d:
            if (r0 == 0) goto L67
            r0.close()     // Catch: java.io.IOException -> L63
            goto L67
        L63:
            r0 = move-exception
            r0.printStackTrace()
        L67:
            if (r3 == 0) goto L71
            r3.close()     // Catch: java.io.IOException -> L6d
            goto L71
        L6d:
            r0 = move-exception
            r0.printStackTrace()
        L71:
            goto L73
        L72:
            throw r6
        L73:
            goto L72
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.ic.dm.p.b.a(java.io.File):byte[]");
    }
}
