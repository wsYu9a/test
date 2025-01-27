package com.vivo.mobilead.lottie.d;

import android.content.Context;
import android.util.Pair;
import com.vivo.mobilead.lottie.f.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

/* loaded from: classes4.dex */
class b {

    /* renamed from: a */
    private final Context f29414a;

    /* renamed from: b */
    private final String f29415b;

    b(Context context, String str) {
        this.f29414a = context.getApplicationContext();
        this.f29415b = str;
    }

    private File a(String str) {
        File file = new File(this.f29414a.getCacheDir(), a(str, a.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(this.f29414a.getCacheDir(), a(str, a.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    private static String a(String str, a aVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("lottie_cache_");
        sb.append(str.replaceAll("\\W+", ""));
        sb.append(z ? aVar.a() : aVar.f29413c);
        return sb.toString();
    }

    Pair<a, InputStream> a() {
        try {
            File a2 = a(this.f29415b);
            if (a2 == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(a2);
            a aVar = a2.getAbsolutePath().endsWith(".zip") ? a.ZIP : a.JSON;
            d.a("Cache hit for " + this.f29415b + " at " + a2.getAbsolutePath());
            return new Pair<>(aVar, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    File a(InputStream inputStream, a aVar) {
        File file = new File(this.f29414a.getCacheDir(), a(this.f29415b, aVar, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        fileOutputStream.flush();
                        return file;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
            } finally {
                fileOutputStream.close();
            }
        } finally {
            inputStream.close();
        }
    }

    void a(a aVar) {
        File file = new File(this.f29414a.getCacheDir(), a(this.f29415b, aVar, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean renameTo = file.renameTo(file2);
        d.a("Copying temp file to real file (" + file2 + ")");
        if (renameTo) {
            return;
        }
        d.b("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
    }
}
