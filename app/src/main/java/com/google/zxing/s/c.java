package com.google.zxing.s;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.k;
import java.util.Map;

/* loaded from: classes.dex */
public interface c {
    k[] b(com.google.zxing.b bVar) throws NotFoundException;

    k[] d(com.google.zxing.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException;
}
