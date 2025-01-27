package com.google.zxing;

import java.util.Map;

/* loaded from: classes.dex */
public interface n {
    com.google.zxing.common.b a(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException;

    com.google.zxing.common.b b(String str, BarcodeFormat barcodeFormat, int i2, int i3) throws WriterException;
}
