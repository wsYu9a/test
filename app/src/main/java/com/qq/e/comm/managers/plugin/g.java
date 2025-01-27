package com.qq.e.comm.managers.plugin;

import android.text.TextUtils;
import com.qq.e.comm.managers.plugin.c;
import com.qq.e.comm.util.GDTLogger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* loaded from: classes4.dex */
class g {

    /* renamed from: a */
    private final File f24037a;

    /* renamed from: b */
    private final File f24038b;

    /* renamed from: c */
    private String f24039c;

    /* renamed from: d */
    private int f24040d;

    /* renamed from: e */
    private String f24041e;

    public g(File file, File file2) {
        this.f24037a = file;
        this.f24038b = file2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.BufferedReader] */
    private String a(File file) throws IOException {
        Throwable th;
        ?? r1 = 0;
        if (file != null) {
            try {
                if (file.exists()) {
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
                        try {
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb.append(readLine);
                            }
                            String sb2 = sb.toString();
                            try {
                                bufferedReader.close();
                            } catch (Exception unused) {
                                GDTLogger.d("Exception while close bufferreader");
                            }
                            return sb2;
                        } catch (IOException e2) {
                            throw e2;
                        }
                    } catch (IOException e3) {
                        throw e3;
                    } catch (Throwable th2) {
                        th = th2;
                        if (r1 != 0) {
                            try {
                                r1.close();
                            } catch (Exception unused2) {
                                GDTLogger.d("Exception while close bufferreader");
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                r1 = file;
                th = th3;
            }
        }
        return null;
    }

    boolean a() {
        int i2;
        try {
            if (this.f24038b.exists() && this.f24037a.exists()) {
                String a2 = a(this.f24038b);
                this.f24041e = a2;
                if (TextUtils.isEmpty(a2)) {
                    return false;
                }
                String[] split = this.f24041e.split("#####");
                if (split.length == 2) {
                    String str = split[1];
                    try {
                        i2 = Integer.parseInt(split[0]);
                    } catch (Throwable unused) {
                        i2 = 0;
                    }
                    if (c.b.f24035a.a(str, this.f24037a)) {
                        this.f24039c = str;
                        this.f24040d = i2;
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable unused2) {
            GDTLogger.d("Exception while checking plugin");
            return false;
        }
    }

    boolean a(File file, File file2) {
        return (file.equals(this.f24037a) || h.a(this.f24037a, file)) && (file2.equals(this.f24038b) || h.a(this.f24038b, file2));
    }

    String b() {
        return this.f24039c;
    }

    int c() {
        return this.f24040d;
    }

    public String d() {
        return this.f24041e;
    }
}
