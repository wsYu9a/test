package com.google.zxing.multi.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.b;
import com.google.zxing.common.d;
import com.google.zxing.common.f;
import com.google.zxing.k;
import com.google.zxing.l;
import com.google.zxing.s.c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class QRCodeMultiReader extends com.google.zxing.u.a implements c {

    /* renamed from: c */
    private static final k[] f8452c = new k[0];

    /* renamed from: d */
    private static final l[] f8453d = new l[0];

    private static final class SAComparator implements Serializable, Comparator<k> {
        private SAComparator() {
        }

        /* synthetic */ SAComparator(a aVar) {
            this();
        }

        @Override // java.util.Comparator
        public int compare(k kVar, k kVar2) {
            Map<ResultMetadataType, Object> e2 = kVar.e();
            ResultMetadataType resultMetadataType = ResultMetadataType.STRUCTURED_APPEND_SEQUENCE;
            int intValue = ((Integer) e2.get(resultMetadataType)).intValue();
            int intValue2 = ((Integer) kVar2.e().get(resultMetadataType)).intValue();
            if (intValue < intValue2) {
                return -1;
            }
            return intValue > intValue2 ? 1 : 0;
        }
    }

    private static List<k> h(List<k> list) {
        boolean z;
        Iterator<k> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            if (it.next().e().containsKey(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE)) {
                z = true;
                break;
            }
        }
        if (!z) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<k> arrayList2 = new ArrayList();
        for (k kVar : list) {
            arrayList.add(kVar);
            if (kVar.e().containsKey(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE)) {
                arrayList2.add(kVar);
            }
        }
        Collections.sort(arrayList2, new SAComparator());
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        int i3 = 0;
        for (k kVar2 : arrayList2) {
            sb.append(kVar2.g());
            i2 += kVar2.d().length;
            Map<ResultMetadataType, Object> e2 = kVar2.e();
            ResultMetadataType resultMetadataType = ResultMetadataType.BYTE_SEGMENTS;
            if (e2.containsKey(resultMetadataType)) {
                Iterator it2 = ((Iterable) kVar2.e().get(resultMetadataType)).iterator();
                while (it2.hasNext()) {
                    i3 += ((byte[]) it2.next()).length;
                }
            }
        }
        byte[] bArr = new byte[i2];
        byte[] bArr2 = new byte[i3];
        int i4 = 0;
        int i5 = 0;
        for (k kVar3 : arrayList2) {
            System.arraycopy(kVar3.d(), 0, bArr, i4, kVar3.d().length);
            i4 += kVar3.d().length;
            Map<ResultMetadataType, Object> e3 = kVar3.e();
            ResultMetadataType resultMetadataType2 = ResultMetadataType.BYTE_SEGMENTS;
            if (e3.containsKey(resultMetadataType2)) {
                for (byte[] bArr3 : (Iterable) kVar3.e().get(resultMetadataType2)) {
                    System.arraycopy(bArr3, 0, bArr2, i5, bArr3.length);
                    i5 += bArr3.length;
                }
            }
        }
        k kVar4 = new k(sb.toString(), bArr, f8453d, BarcodeFormat.QR_CODE);
        if (i3 > 0) {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(bArr2);
            kVar4.j(ResultMetadataType.BYTE_SEGMENTS, arrayList3);
        }
        arrayList.add(kVar4);
        return arrayList;
    }

    @Override // com.google.zxing.s.c
    public k[] b(b bVar) throws NotFoundException {
        return d(bVar, null);
    }

    @Override // com.google.zxing.s.c
    public k[] d(b bVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        ArrayList arrayList = new ArrayList();
        for (f fVar : new com.google.zxing.multi.qrcode.detector.a(bVar.b()).n(map)) {
            try {
                d c2 = f().c(fVar.a(), map);
                l[] b2 = fVar.b();
                if (c2.f() instanceof com.google.zxing.qrcode.decoder.f) {
                    ((com.google.zxing.qrcode.decoder.f) c2.f()).a(b2);
                }
                k kVar = new k(c2.j(), c2.g(), b2, BarcodeFormat.QR_CODE);
                List<byte[]> a2 = c2.a();
                if (a2 != null) {
                    kVar.j(ResultMetadataType.BYTE_SEGMENTS, a2);
                }
                String b3 = c2.b();
                if (b3 != null) {
                    kVar.j(ResultMetadataType.ERROR_CORRECTION_LEVEL, b3);
                }
                if (c2.k()) {
                    kVar.j(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(c2.i()));
                    kVar.j(ResultMetadataType.STRUCTURED_APPEND_PARITY, Integer.valueOf(c2.h()));
                }
                arrayList.add(kVar);
            } catch (ReaderException unused) {
            }
        }
        if (arrayList.isEmpty()) {
            return f8452c;
        }
        List<k> h2 = h(arrayList);
        return (k[]) h2.toArray(new k[h2.size()]);
    }
}
