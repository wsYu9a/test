package com.czhj.wire;

import java.io.IOException;
import java.net.ProtocolException;

/* loaded from: classes2.dex */
public enum FieldEncoding {
    VARINT(0),
    FIXED64(1),
    LENGTH_DELIMITED(2),
    FIXED32(5);

    final int value;

    /* renamed from: com.czhj.wire.FieldEncoding$1 */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        public static final /* synthetic */ int[] f8849a;

        static {
            int[] iArr = new int[FieldEncoding.values().length];
            f8849a = iArr;
            try {
                iArr[FieldEncoding.VARINT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8849a[FieldEncoding.FIXED32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8849a[FieldEncoding.FIXED64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8849a[FieldEncoding.LENGTH_DELIMITED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    FieldEncoding(int i10) {
        this.value = i10;
    }

    public ProtoAdapter<?> rawProtoAdapter() {
        int i10 = AnonymousClass1.f8849a[ordinal()];
        if (i10 == 1) {
            return ProtoAdapter.UINT64;
        }
        if (i10 == 2) {
            return ProtoAdapter.FIXED32;
        }
        if (i10 == 3) {
            return ProtoAdapter.FIXED64;
        }
        if (i10 == 4) {
            return ProtoAdapter.BYTES;
        }
        throw new AssertionError();
    }

    public static FieldEncoding a(int i10) throws IOException {
        if (i10 == 0) {
            return VARINT;
        }
        if (i10 == 1) {
            return FIXED64;
        }
        if (i10 == 2) {
            return LENGTH_DELIMITED;
        }
        if (i10 == 5) {
            return FIXED32;
        }
        throw new ProtocolException("Unexpected FieldEncoding: " + i10);
    }
}
