package b.i.a.b.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import b.i.a.a.a.i;
import b.i.a.b.a.b;
import java.io.File;
import java.util.Map;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    private String f5087a;

    /* renamed from: b */
    private String f5088b;

    /* renamed from: c */
    private boolean f5089c;

    /* renamed from: d */
    private boolean f5090d;

    /* renamed from: e */
    private boolean f5091e;

    /* renamed from: f */
    private SharedPreferences f5092f;

    /* renamed from: g */
    private b f5093g;

    /* renamed from: h */
    private SharedPreferences.Editor f5094h = null;

    /* renamed from: i */
    private b.a f5095i = null;

    /* renamed from: j */
    private Context f5096j;
    private d k;
    private boolean l;

    /* JADX WARN: Removed duplicated region for block: B:16:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0164 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0180 A[Catch: Exception -> 0x018a, TRY_LEAVE, TryCatch #3 {Exception -> 0x018a, blocks: (B:37:0x017c, B:39:0x0180), top: B:36:0x017c }] */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public c(android.content.Context r10, java.lang.String r11, java.lang.String r12, boolean r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 395
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: b.i.a.b.a.c.<init>(android.content.Context, java.lang.String, java.lang.String, boolean, boolean):void");
    }

    private d a(String str) {
        File b2 = b(str);
        if (b2 == null) {
            return null;
        }
        d dVar = new d(b2.getAbsolutePath());
        this.k = dVar;
        return dVar;
    }

    private File b(String str) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory == null) {
            return null;
        }
        File file = new File(String.format("%s%s%s", externalStorageDirectory.getAbsolutePath(), File.separator, str));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private void c(SharedPreferences sharedPreferences, b bVar) {
        b.a a2;
        if (sharedPreferences == null || bVar == null || (a2 = bVar.a()) == null) {
            return;
        }
        a2.b();
        for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                a2.a(key, (String) value);
            } else if (value instanceof Integer) {
                a2.a(key, ((Integer) value).intValue());
            } else if (value instanceof Long) {
                a2.a(key, ((Long) value).longValue());
            } else if (value instanceof Float) {
                a2.a(key, ((Float) value).floatValue());
            } else if (value instanceof Boolean) {
                a2.a(key, ((Boolean) value).booleanValue());
            }
        }
        a2.commit();
    }

    private void d(b bVar, SharedPreferences sharedPreferences) {
        SharedPreferences.Editor edit;
        if (bVar == null || sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        edit.clear();
        for (Map.Entry<String, ?> entry : bVar.getAll().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                edit.putString(key, (String) value);
            } else if (value instanceof Integer) {
                edit.putInt(key, ((Integer) value).intValue());
            } else if (value instanceof Long) {
                edit.putLong(key, ((Long) value).longValue());
            } else if (value instanceof Float) {
                edit.putFloat(key, ((Float) value).floatValue());
            } else if (value instanceof Boolean) {
                edit.putBoolean(key, ((Boolean) value).booleanValue());
            }
        }
        edit.commit();
    }

    private boolean e() {
        b bVar = this.f5093g;
        if (bVar == null) {
            return false;
        }
        boolean mo36a = bVar.mo36a();
        if (!mo36a) {
            g();
        }
        return mo36a;
    }

    private void f() {
        b bVar;
        SharedPreferences sharedPreferences;
        if (this.f5094h == null && (sharedPreferences = this.f5092f) != null) {
            this.f5094h = sharedPreferences.edit();
        }
        if (this.f5091e && this.f5095i == null && (bVar = this.f5093g) != null) {
            this.f5095i = bVar.a();
        }
        e();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:0|1|(4:3|(1:7)|8|(9:10|11|(1:15)|16|17|18|19|(4:21|(2:23|(2:25|(3:27|(1:29)(1:31)|30))(2:32|(1:36)))|37|(3:43|44|(1:46)))|49))|54|11|(2:13|15)|16|17|18|19|(0)|49) */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0037, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0038, code lost:
    
        r2.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean g() {
        /*
            r6 = this;
            long r0 = java.lang.System.currentTimeMillis()
            android.content.SharedPreferences$Editor r2 = r6.f5094h
            r3 = 0
            if (r2 == 0) goto L20
            boolean r4 = r6.l
            if (r4 != 0) goto L16
            android.content.SharedPreferences r4 = r6.f5092f
            if (r4 == 0) goto L16
            java.lang.String r4 = "t"
            r2.putLong(r4, r0)
        L16:
            android.content.SharedPreferences$Editor r0 = r6.f5094h
            boolean r0 = r0.commit()
            if (r0 != 0) goto L20
            r0 = 0
            goto L21
        L20:
            r0 = 1
        L21:
            android.content.SharedPreferences r1 = r6.f5092f
            if (r1 == 0) goto L31
            android.content.Context r1 = r6.f5096j
            if (r1 == 0) goto L31
            java.lang.String r2 = r6.f5087a
            android.content.SharedPreferences r1 = r1.getSharedPreferences(r2, r3)
            r6.f5092f = r1
        L31:
            r1 = 0
            java.lang.String r1 = android.os.Environment.getExternalStorageState()     // Catch: java.lang.Exception -> L37
            goto L3b
        L37:
            r2 = move-exception
            r2.printStackTrace()
        L3b:
            boolean r2 = b.i.a.a.a.i.b(r1)
            if (r2 != 0) goto L9e
            java.lang.String r2 = "mounted"
            boolean r4 = r1.equals(r2)
            if (r4 == 0) goto L80
            b.i.a.b.a.b r4 = r6.f5093g
            if (r4 != 0) goto L75
            java.lang.String r4 = r6.f5088b
            b.i.a.b.a.d r4 = r6.a(r4)
            if (r4 == 0) goto L80
            java.lang.String r5 = r6.f5087a
            b.i.a.b.a.b r4 = r4.a(r5, r3)
            r6.f5093g = r4
            boolean r5 = r6.l
            if (r5 != 0) goto L67
            android.content.SharedPreferences r5 = r6.f5092f
            r6.c(r5, r4)
            goto L6c
        L67:
            android.content.SharedPreferences r5 = r6.f5092f
            r6.d(r4, r5)
        L6c:
            b.i.a.b.a.b r4 = r6.f5093g
            b.i.a.b.a.b$a r4 = r4.a()
            r6.f5095i = r4
            goto L80
        L75:
            b.i.a.b.a.b$a r4 = r6.f5095i
            if (r4 == 0) goto L80
            boolean r4 = r4.commit()
            if (r4 != 0) goto L80
            r0 = 0
        L80:
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L92
            java.lang.String r2 = "mounted_ro"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L9e
            b.i.a.b.a.b r1 = r6.f5093g
            if (r1 == 0) goto L9e
        L92:
            b.i.a.b.a.d r1 = r6.k     // Catch: java.lang.Exception -> L9e
            if (r1 == 0) goto L9e
            java.lang.String r2 = r6.f5087a     // Catch: java.lang.Exception -> L9e
            b.i.a.b.a.b r1 = r1.a(r2, r3)     // Catch: java.lang.Exception -> L9e
            r6.f5093g = r1     // Catch: java.lang.Exception -> L9e
        L9e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b.i.a.b.a.c.g():boolean");
    }

    public String h(String str) {
        e();
        SharedPreferences sharedPreferences = this.f5092f;
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString(str, "");
            if (!i.b(string)) {
                return string;
            }
        }
        b bVar = this.f5093g;
        return bVar != null ? bVar.getString(str, "") : "";
    }

    public void i(String str, String str2) {
        if (i.b(str) || str.equals("t")) {
            return;
        }
        f();
        SharedPreferences.Editor editor = this.f5094h;
        if (editor != null) {
            editor.putString(str, str2);
        }
        b.a aVar = this.f5095i;
        if (aVar != null) {
            aVar.a(str, str2);
        }
    }

    public void j(String str) {
        if (i.b(str) || str.equals("t")) {
            return;
        }
        f();
        SharedPreferences.Editor editor = this.f5094h;
        if (editor != null) {
            editor.remove(str);
        }
        b.a aVar = this.f5095i;
        if (aVar != null) {
            aVar.a(str);
        }
    }
}
