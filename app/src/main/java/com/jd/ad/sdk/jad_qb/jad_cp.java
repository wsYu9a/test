package com.jd.ad.sdk.jad_qb;

import android.util.Log;
import androidx.annotation.NonNull;
import com.jd.ad.sdk.logger.Logger;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class jad_cp implements com.jd.ad.sdk.jad_ju.jad_dq<ByteBuffer> {
    @Override // com.jd.ad.sdk.jad_ju.jad_dq
    public /* bridge */ /* synthetic */ boolean jad_an(@NonNull ByteBuffer byteBuffer, @NonNull File file, @NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return jad_an(byteBuffer, file);
    }

    public boolean jad_an(@NonNull ByteBuffer byteBuffer, @NonNull File file) {
        try {
            com.jd.ad.sdk.jad_ir.jad_an.jad_an(byteBuffer, file);
            return true;
        } catch (IOException e10) {
            if (!Log.isLoggable("ByteBufferEncoder", 3)) {
                return false;
            }
            Logger.d("ByteBufferEncoder", "Failed to write data", e10);
            return false;
        }
    }
}
