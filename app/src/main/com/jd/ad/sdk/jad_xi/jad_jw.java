package com.jd.ad.sdk.jad_xi;

import android.util.Log;
import androidx.annotation.NonNull;
import com.jd.ad.sdk.jad_ju.jad_fs;
import com.jd.ad.sdk.jad_ju.jad_ly;
import com.jd.ad.sdk.jad_mx.jad_xk;
import com.jd.ad.sdk.logger.Logger;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes2.dex */
public class jad_jw implements jad_ly<InputStream, jad_cp> {
    public final List<com.jd.ad.sdk.jad_ju.jad_fs> jad_an;
    public final jad_ly<ByteBuffer, jad_cp> jad_bo;
    public final com.jd.ad.sdk.jad_ny.jad_bo jad_cp;

    public jad_jw(List<com.jd.ad.sdk.jad_ju.jad_fs> list, jad_ly<ByteBuffer, jad_cp> jad_lyVar, com.jd.ad.sdk.jad_ny.jad_bo jad_boVar) {
        this.jad_an = list;
        this.jad_bo = jad_lyVar;
        this.jad_cp = jad_boVar;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public jad_xk<jad_cp> jad_an(@NonNull InputStream inputStream, int i10, int i11, @NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        byte[] bArr;
        InputStream inputStream2 = inputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr2 = new byte[16384];
            while (true) {
                int read = inputStream2.read(bArr2);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
            byteArrayOutputStream.flush();
            bArr = byteArrayOutputStream.toByteArray();
        } catch (IOException e10) {
            if (Log.isLoggable("StreamGifDecoder", 5)) {
                Logger.w("StreamGifDecoder", "Error reading data from stream", e10);
            }
            bArr = null;
        }
        if (bArr == null) {
            return null;
        }
        return this.jad_bo.jad_an(ByteBuffer.wrap(bArr), i10, i11, jad_jwVar);
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public boolean jad_an(@NonNull InputStream inputStream, @NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return !((Boolean) jad_jwVar.jad_an(jad_iv.jad_bo)).booleanValue() && com.jd.ad.sdk.jad_ju.jad_jt.jad_bo(this.jad_an, inputStream, this.jad_cp) == jad_fs.jad_bo.GIF;
    }
}
