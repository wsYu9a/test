package com.jd.ad.sdk.jad_uf;

import androidx.annotation.NonNull;
import com.jd.ad.sdk.jad_kv.jad_er;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class jad_an implements jad_er<ByteBuffer> {
    public final ByteBuffer jad_an;

    /* renamed from: com.jd.ad.sdk.jad_uf.jad_an$jad_an */
    public static class C0354jad_an implements jad_er.jad_an<ByteBuffer> {
        @Override // com.jd.ad.sdk.jad_kv.jad_er.jad_an
        @NonNull
        public Class<ByteBuffer> jad_an() {
            return ByteBuffer.class;
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_er.jad_an
        @NonNull
        public jad_er<ByteBuffer> jad_an(ByteBuffer byteBuffer) {
            return new jad_an(byteBuffer);
        }
    }

    public jad_an(ByteBuffer byteBuffer) {
        this.jad_an = byteBuffer;
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_er
    @NonNull
    public ByteBuffer jad_an() {
        this.jad_an.position(0);
        return this.jad_an;
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_er
    public void jad_bo() {
    }
}
