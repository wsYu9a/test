package com.google.zxing.qrcode.decoder;

import z5.b;

/* loaded from: classes2.dex */
enum DataMask {
    DATA_MASK_000 { // from class: com.google.zxing.qrcode.decoder.DataMask.1
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public boolean isMasked(int i10, int i11) {
            return ((i10 + i11) & 1) == 0;
        }
    },
    DATA_MASK_001 { // from class: com.google.zxing.qrcode.decoder.DataMask.2
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public boolean isMasked(int i10, int i11) {
            return (i10 & 1) == 0;
        }
    },
    DATA_MASK_010 { // from class: com.google.zxing.qrcode.decoder.DataMask.3
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public boolean isMasked(int i10, int i11) {
            return i11 % 3 == 0;
        }
    },
    DATA_MASK_011 { // from class: com.google.zxing.qrcode.decoder.DataMask.4
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public boolean isMasked(int i10, int i11) {
            return (i10 + i11) % 3 == 0;
        }
    },
    DATA_MASK_100 { // from class: com.google.zxing.qrcode.decoder.DataMask.5
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public boolean isMasked(int i10, int i11) {
            return (((i10 / 2) + (i11 / 3)) & 1) == 0;
        }
    },
    DATA_MASK_101 { // from class: com.google.zxing.qrcode.decoder.DataMask.6
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public boolean isMasked(int i10, int i11) {
            return (i10 * i11) % 6 == 0;
        }
    },
    DATA_MASK_110 { // from class: com.google.zxing.qrcode.decoder.DataMask.7
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public boolean isMasked(int i10, int i11) {
            return (i10 * i11) % 6 < 3;
        }
    },
    DATA_MASK_111 { // from class: com.google.zxing.qrcode.decoder.DataMask.8
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public boolean isMasked(int i10, int i11) {
            return (((i10 + i11) + ((i10 * i11) % 3)) & 1) == 0;
        }
    };

    /* renamed from: com.google.zxing.qrcode.decoder.DataMask$1 */
    public enum AnonymousClass1 extends DataMask {
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public boolean isMasked(int i10, int i11) {
            return ((i10 + i11) & 1) == 0;
        }
    }

    /* renamed from: com.google.zxing.qrcode.decoder.DataMask$2 */
    public enum AnonymousClass2 extends DataMask {
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public boolean isMasked(int i10, int i11) {
            return (i10 & 1) == 0;
        }
    }

    /* renamed from: com.google.zxing.qrcode.decoder.DataMask$3 */
    public enum AnonymousClass3 extends DataMask {
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public boolean isMasked(int i10, int i11) {
            return i11 % 3 == 0;
        }
    }

    /* renamed from: com.google.zxing.qrcode.decoder.DataMask$4 */
    public enum AnonymousClass4 extends DataMask {
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public boolean isMasked(int i10, int i11) {
            return (i10 + i11) % 3 == 0;
        }
    }

    /* renamed from: com.google.zxing.qrcode.decoder.DataMask$5 */
    public enum AnonymousClass5 extends DataMask {
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public boolean isMasked(int i10, int i11) {
            return (((i10 / 2) + (i11 / 3)) & 1) == 0;
        }
    }

    /* renamed from: com.google.zxing.qrcode.decoder.DataMask$6 */
    public enum AnonymousClass6 extends DataMask {
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public boolean isMasked(int i10, int i11) {
            return (i10 * i11) % 6 == 0;
        }
    }

    /* renamed from: com.google.zxing.qrcode.decoder.DataMask$7 */
    public enum AnonymousClass7 extends DataMask {
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public boolean isMasked(int i10, int i11) {
            return (i10 * i11) % 6 < 3;
        }
    }

    /* renamed from: com.google.zxing.qrcode.decoder.DataMask$8 */
    public enum AnonymousClass8 extends DataMask {
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public boolean isMasked(int i10, int i11) {
            return (((i10 + i11) + ((i10 * i11) % 3)) & 1) == 0;
        }
    }

    public abstract boolean isMasked(int i10, int i11);

    public final void unmaskBitMatrix(b bVar, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            for (int i12 = 0; i12 < i10; i12++) {
                if (isMasked(i11, i12)) {
                    bVar.d(i12, i11);
                }
            }
        }
    }

    /* synthetic */ DataMask(AnonymousClass1 anonymousClass1) {
        this();
    }
}
