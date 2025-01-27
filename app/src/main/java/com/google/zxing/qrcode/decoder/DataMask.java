package com.google.zxing.qrcode.decoder;

/* loaded from: classes.dex */
enum DataMask {
    DATA_MASK_000 { // from class: com.google.zxing.qrcode.decoder.DataMask.1
        @Override // com.google.zxing.qrcode.decoder.DataMask
        boolean isMasked(int i2, int i3) {
            return ((i2 + i3) & 1) == 0;
        }
    },
    DATA_MASK_001 { // from class: com.google.zxing.qrcode.decoder.DataMask.2
        @Override // com.google.zxing.qrcode.decoder.DataMask
        boolean isMasked(int i2, int i3) {
            return (i2 & 1) == 0;
        }
    },
    DATA_MASK_010 { // from class: com.google.zxing.qrcode.decoder.DataMask.3
        @Override // com.google.zxing.qrcode.decoder.DataMask
        boolean isMasked(int i2, int i3) {
            return i3 % 3 == 0;
        }
    },
    DATA_MASK_011 { // from class: com.google.zxing.qrcode.decoder.DataMask.4
        @Override // com.google.zxing.qrcode.decoder.DataMask
        boolean isMasked(int i2, int i3) {
            return (i2 + i3) % 3 == 0;
        }
    },
    DATA_MASK_100 { // from class: com.google.zxing.qrcode.decoder.DataMask.5
        @Override // com.google.zxing.qrcode.decoder.DataMask
        boolean isMasked(int i2, int i3) {
            return (((i2 / 2) + (i3 / 3)) & 1) == 0;
        }
    },
    DATA_MASK_101 { // from class: com.google.zxing.qrcode.decoder.DataMask.6
        @Override // com.google.zxing.qrcode.decoder.DataMask
        boolean isMasked(int i2, int i3) {
            return (i2 * i3) % 6 == 0;
        }
    },
    DATA_MASK_110 { // from class: com.google.zxing.qrcode.decoder.DataMask.7
        @Override // com.google.zxing.qrcode.decoder.DataMask
        boolean isMasked(int i2, int i3) {
            return (i2 * i3) % 6 < 3;
        }
    },
    DATA_MASK_111 { // from class: com.google.zxing.qrcode.decoder.DataMask.8
        @Override // com.google.zxing.qrcode.decoder.DataMask
        boolean isMasked(int i2, int i3) {
            return (((i2 + i3) + ((i2 * i3) % 3)) & 1) == 0;
        }
    };

    /* renamed from: com.google.zxing.qrcode.decoder.DataMask$1 */
    enum AnonymousClass1 extends DataMask {
        @Override // com.google.zxing.qrcode.decoder.DataMask
        boolean isMasked(int i2, int i3) {
            return ((i2 + i3) & 1) == 0;
        }
    }

    /* renamed from: com.google.zxing.qrcode.decoder.DataMask$2 */
    enum AnonymousClass2 extends DataMask {
        @Override // com.google.zxing.qrcode.decoder.DataMask
        boolean isMasked(int i2, int i3) {
            return (i2 & 1) == 0;
        }
    }

    /* renamed from: com.google.zxing.qrcode.decoder.DataMask$3 */
    enum AnonymousClass3 extends DataMask {
        @Override // com.google.zxing.qrcode.decoder.DataMask
        boolean isMasked(int i2, int i3) {
            return i3 % 3 == 0;
        }
    }

    /* renamed from: com.google.zxing.qrcode.decoder.DataMask$4 */
    enum AnonymousClass4 extends DataMask {
        @Override // com.google.zxing.qrcode.decoder.DataMask
        boolean isMasked(int i2, int i3) {
            return (i2 + i3) % 3 == 0;
        }
    }

    /* renamed from: com.google.zxing.qrcode.decoder.DataMask$5 */
    enum AnonymousClass5 extends DataMask {
        @Override // com.google.zxing.qrcode.decoder.DataMask
        boolean isMasked(int i2, int i3) {
            return (((i2 / 2) + (i3 / 3)) & 1) == 0;
        }
    }

    /* renamed from: com.google.zxing.qrcode.decoder.DataMask$6 */
    enum AnonymousClass6 extends DataMask {
        @Override // com.google.zxing.qrcode.decoder.DataMask
        boolean isMasked(int i2, int i3) {
            return (i2 * i3) % 6 == 0;
        }
    }

    /* renamed from: com.google.zxing.qrcode.decoder.DataMask$7 */
    enum AnonymousClass7 extends DataMask {
        @Override // com.google.zxing.qrcode.decoder.DataMask
        boolean isMasked(int i2, int i3) {
            return (i2 * i3) % 6 < 3;
        }
    }

    /* renamed from: com.google.zxing.qrcode.decoder.DataMask$8 */
    enum AnonymousClass8 extends DataMask {
        @Override // com.google.zxing.qrcode.decoder.DataMask
        boolean isMasked(int i2, int i3) {
            return (((i2 + i3) + ((i2 * i3) % 3)) & 1) == 0;
        }
    }

    abstract boolean isMasked(int i2, int i3);

    final void unmaskBitMatrix(com.google.zxing.common.b bVar, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i2; i4++) {
                if (isMasked(i3, i4)) {
                    bVar.d(i4, i3);
                }
            }
        }
    }

    /* synthetic */ DataMask(AnonymousClass1 anonymousClass1) {
        this();
    }
}
