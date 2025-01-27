package com.jd.ad.sdk.jad_zm;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.nio.charset.StandardCharsets;
import java.util.StringTokenizer;
import java.util.TimeZone;
import m5.h;

/* loaded from: classes2.dex */
public class jad_ob implements Closeable {
    public String jad_an;
    public BufferedInputStream jad_bo;

    public jad_ob(String str, BufferedInputStream bufferedInputStream) {
        this.jad_an = str;
        this.jad_bo = bufferedInputStream;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.jad_bo.close();
    }

    public String jad_bo() {
        String str;
        String str2 = this.jad_an;
        TimeZone timeZone = jad_fs.jad_bo;
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(h.f28414g)) {
            StringTokenizer stringTokenizer = new StringTokenizer(str2, ";");
            while (stringTokenizer.hasMoreElements()) {
                String nextToken = stringTokenizer.nextToken();
                int indexOf = nextToken.indexOf(61);
                if (indexOf > 0 && h.f28414g.equalsIgnoreCase(nextToken.substring(0, indexOf).trim())) {
                    str = nextToken.substring(indexOf + 1).trim();
                    break;
                }
            }
        }
        str = "UTF-8";
        return TextUtils.isEmpty(str) ? new String(com.jd.ad.sdk.jad_fq.jad_jt.jad_an(this.jad_bo), StandardCharsets.UTF_8) : new String(com.jd.ad.sdk.jad_fq.jad_jt.jad_an(this.jad_bo), str);
    }
}
