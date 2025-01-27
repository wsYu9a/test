package com.google.zxing.multi.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.common.b;
import com.google.zxing.common.f;
import com.google.zxing.m;
import com.google.zxing.qrcode.detector.c;
import com.google.zxing.qrcode.detector.e;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes.dex */
public final class a extends c {

    /* renamed from: c */
    private static final f[] f8456c = new f[0];

    public a(b bVar) {
        super(bVar);
    }

    public f[] n(Map<DecodeHintType, ?> map) throws NotFoundException {
        e[] n = new MultiFinderPatternFinder(h(), map == null ? null : (m) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK)).n(map);
        if (n.length == 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        ArrayList arrayList = new ArrayList();
        for (e eVar : n) {
            try {
                arrayList.add(j(eVar));
            } catch (ReaderException unused) {
            }
        }
        return arrayList.isEmpty() ? f8456c : (f[]) arrayList.toArray(new f[arrayList.size()]);
    }
}
