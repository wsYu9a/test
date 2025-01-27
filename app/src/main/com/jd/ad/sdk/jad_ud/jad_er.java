package com.jd.ad.sdk.jad_ud;

import androidx.annotation.NonNull;
import com.jd.ad.sdk.jad_lu.jad_zm;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class jad_er {

    @NonNull
    public final jad_dq jad_an;

    public jad_er(@NonNull jad_dq jad_dqVar) {
        this.jad_an = jad_dqVar;
    }

    public File jad_an(String str, InputStream inputStream, jad_cp jad_cpVar) {
        File file = new File(jad_an(), jad_an(str, jad_cpVar, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        return file;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
            } catch (Throwable th2) {
                fileOutputStream.close();
                throw th2;
            }
        } finally {
            inputStream.close();
        }
    }

    public static String jad_an(String str, jad_cp jad_cpVar, boolean z10) {
        String str2;
        StringBuilder jad_an = jad_zm.jad_an("lottie_cache_");
        jad_an.append(str.replaceAll("\\W+", ""));
        if (z10) {
            jad_cpVar.getClass();
            StringBuilder jad_an2 = jad_zm.jad_an(".temp");
            jad_an2.append(jad_cpVar.jad_an);
            str2 = jad_an2.toString();
        } else {
            str2 = jad_cpVar.jad_an;
        }
        jad_an.append(str2);
        return jad_an.toString();
    }

    public final File jad_an() {
        com.jd.ad.sdk.jad_lu.jad_cp jad_cpVar = (com.jd.ad.sdk.jad_lu.jad_cp) this.jad_an;
        jad_cpVar.getClass();
        File file = new File(jad_cpVar.jad_an.getCacheDir(), "lottie_network_cache");
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
