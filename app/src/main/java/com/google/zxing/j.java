package com.google.zxing;

import java.util.Map;

/* loaded from: classes.dex */
public interface j {
    k a(b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException;

    k c(b bVar) throws NotFoundException, ChecksumException, FormatException;

    void reset();
}
