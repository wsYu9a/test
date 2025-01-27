package com.jd.ad.sdk.jad_zm;

import android.text.TextUtils;
import com.jd.ad.sdk.jad_zm.jad_mz;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketTimeoutException;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class jad_an {
    public URLConnection jad_an;

    public final jad_fs jad_an(Map<String, List<String>> map) {
        jad_fs jad_fsVar = new jad_fs();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (!TextUtils.isEmpty(key) && !value.isEmpty()) {
                Iterator<String> it = value.iterator();
                while (it.hasNext()) {
                    jad_fsVar.jad_an(key, it.next());
                }
            }
        }
        return jad_fsVar;
    }

    public abstract URLConnection jad_an(jad_ly jad_lyVar);

    public abstract void jad_an();

    public abstract int jad_bo();

    public jad_mz jad_bo(jad_ly jad_lyVar) {
        if (com.jd.ad.sdk.jad_jt.jad_fs.jad_an(jad_lyVar.jad_an, 2)) {
            jad_fs jad_fsVar = jad_lyVar.jad_bo;
            jad_er jad_erVar = jad_lyVar.jad_fs;
            if (jad_erVar != null && jad_fsVar != null) {
                jad_fsVar.jad_bo("Content-Length", Long.toString(jad_erVar.jad_an == null ? 0L : r3.length));
                jad_fsVar.jad_bo("Content-Type", "application/stream");
            }
            URLConnection jad_an = jad_an(jad_lyVar);
            this.jad_an = jad_an;
            if (jad_erVar != null) {
                try {
                    OutputStream outputStream = jad_an.getOutputStream();
                    BufferedOutputStream bufferedOutputStream = outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream);
                    byte[] bArr = jad_erVar.jad_an;
                    if (bArr != null) {
                        bufferedOutputStream.write(bArr);
                        bufferedOutputStream.flush();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                } catch (Exception e10) {
                    throw new com.jd.ad.sdk.jad_do.jad_cp(e10);
                }
            }
        } else {
            this.jad_an = jad_an(jad_lyVar);
        }
        try {
            int jad_bo = jad_bo();
            if (jad_bo >= 400) {
                int i10 = jad_mz.jad_er;
                jad_mz.jad_an jad_anVar = new jad_mz.jad_an();
                jad_anVar.jad_an = jad_bo;
                jad_anVar.jad_bo = null;
                jad_anVar.jad_cp = null;
                jad_anVar.jad_dq = this;
                return new jad_mz(jad_anVar);
            }
            InputStream inputStream = this.jad_an.getInputStream();
            BufferedInputStream bufferedInputStream = inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream);
            if (jad_lyVar.jad_hu == null) {
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                bufferedInputStream.close();
                jad_an();
                return null;
            }
            jad_fs jad_an2 = jad_an(this.jad_an.getHeaderFields());
            jad_ob jad_obVar = new jad_ob(jad_an2.jad_an("Content-Type"), bufferedInputStream);
            int i11 = jad_mz.jad_er;
            jad_mz.jad_an jad_anVar2 = new jad_mz.jad_an();
            jad_anVar2.jad_an = jad_bo;
            jad_anVar2.jad_bo = jad_an2;
            jad_anVar2.jad_cp = jad_obVar;
            jad_anVar2.jad_dq = this;
            return new jad_mz(jad_anVar2);
        } catch (SocketTimeoutException e11) {
            throw new com.jd.ad.sdk.jad_do.jad_bo(String.format("Read data time out: %1$s.", this.jad_an.getURL().toString()), e11);
        } catch (Exception e12) {
            if (e12 instanceof com.jd.ad.sdk.jad_do.jad_bo) {
                throw new com.jd.ad.sdk.jad_do.jad_bo(e12);
            }
            throw new com.jd.ad.sdk.jad_do.jad_bo(new Exception(jad_lyVar.jad_er, e12));
        }
    }
}
