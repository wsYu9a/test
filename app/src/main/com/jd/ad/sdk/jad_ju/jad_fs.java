package com.jd.ad.sdk.jad_ju;

import androidx.annotation.NonNull;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public interface jad_fs {

    public static /* synthetic */ class jad_an {
        public static final /* synthetic */ int[] jad_an;

        static {
            int[] iArr = new int[jad_bo.values().length];
            jad_an = iArr;
            try {
                iArr[6] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                jad_an[5] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                jad_an[7] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum jad_bo {
        GIF(true),
        JPEG(false),
        /* JADX INFO: Fake field, exist only in values array */
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        ANIMATED_WEBP(true),
        AVIF(true),
        UNKNOWN(false);

        public final boolean jad_an;

        /* renamed from: EF4 */
        jad_bo RAW;

        /* renamed from: EF4 */
        jad_bo RAW;

        jad_bo(boolean z10) {
            this.jad_an = z10;
        }
    }

    int jad_an(@NonNull InputStream inputStream, @NonNull com.jd.ad.sdk.jad_ny.jad_bo jad_boVar);

    int jad_an(@NonNull ByteBuffer byteBuffer, @NonNull com.jd.ad.sdk.jad_ny.jad_bo jad_boVar);

    @NonNull
    jad_bo jad_an(@NonNull InputStream inputStream);

    @NonNull
    jad_bo jad_an(@NonNull ByteBuffer byteBuffer);
}
