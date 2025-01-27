package com.google.zxing.multi.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.ResultMetadataType;
import h6.c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import t5.b;
import t5.k;
import t5.l;
import t6.e;
import z5.d;
import z5.f;

/* loaded from: classes2.dex */
public final class QRCodeMultiReader extends s6.a implements c {

    /* renamed from: c */
    public static final k[] f10566c = new k[0];

    /* renamed from: d */
    public static final l[] f10567d = new l[0];

    public static final class SAComparator implements Serializable, Comparator<k> {
        private SAComparator() {
        }

        public /* synthetic */ SAComparator(a aVar) {
            this();
        }

        @Override // java.util.Comparator
        public int compare(k kVar, k kVar2) {
            Map<ResultMetadataType, Object> e10 = kVar.e();
            ResultMetadataType resultMetadataType = ResultMetadataType.STRUCTURED_APPEND_SEQUENCE;
            int intValue = ((Integer) e10.get(resultMetadataType)).intValue();
            int intValue2 = ((Integer) kVar2.e().get(resultMetadataType)).intValue();
            if (intValue < intValue2) {
                return -1;
            }
            return intValue > intValue2 ? 1 : 0;
        }
    }

    public static List<k> h(List<k> list) {
        Iterator<k> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().e().containsKey(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE)) {
                ArrayList arrayList = new ArrayList();
                ArrayList<k> arrayList2 = new ArrayList();
                for (k kVar : list) {
                    arrayList.add(kVar);
                    if (kVar.e().containsKey(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE)) {
                        arrayList2.add(kVar);
                    }
                }
                Collections.sort(arrayList2, new SAComparator());
                StringBuilder sb2 = new StringBuilder();
                int i10 = 0;
                int i11 = 0;
                for (k kVar2 : arrayList2) {
                    sb2.append(kVar2.g());
                    i10 += kVar2.d().length;
                    Map<ResultMetadataType, Object> e10 = kVar2.e();
                    ResultMetadataType resultMetadataType = ResultMetadataType.BYTE_SEGMENTS;
                    if (e10.containsKey(resultMetadataType)) {
                        Iterator it2 = ((Iterable) kVar2.e().get(resultMetadataType)).iterator();
                        while (it2.hasNext()) {
                            i11 += ((byte[]) it2.next()).length;
                        }
                    }
                }
                byte[] bArr = new byte[i10];
                byte[] bArr2 = new byte[i11];
                int i12 = 0;
                int i13 = 0;
                for (k kVar3 : arrayList2) {
                    System.arraycopy(kVar3.d(), 0, bArr, i12, kVar3.d().length);
                    i12 += kVar3.d().length;
                    Map<ResultMetadataType, Object> e11 = kVar3.e();
                    ResultMetadataType resultMetadataType2 = ResultMetadataType.BYTE_SEGMENTS;
                    if (e11.containsKey(resultMetadataType2)) {
                        for (byte[] bArr3 : (Iterable) kVar3.e().get(resultMetadataType2)) {
                            System.arraycopy(bArr3, 0, bArr2, i13, bArr3.length);
                            i13 += bArr3.length;
                        }
                    }
                }
                k kVar4 = new k(sb2.toString(), bArr, f10567d, BarcodeFormat.QR_CODE);
                if (i11 > 0) {
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(bArr2);
                    kVar4.j(ResultMetadataType.BYTE_SEGMENTS, arrayList3);
                }
                arrayList.add(kVar4);
                return arrayList;
            }
        }
        return list;
    }

    @Override // h6.c
    public k[] c(b bVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        ArrayList arrayList = new ArrayList();
        for (f fVar : new i6.a(bVar.b()).n(map)) {
            try {
                d d10 = f().d(fVar.a(), map);
                l[] b10 = fVar.b();
                if (d10.f() instanceof e) {
                    ((e) d10.f()).a(b10);
                }
                k kVar = new k(d10.j(), d10.g(), b10, BarcodeFormat.QR_CODE);
                List<byte[]> a10 = d10.a();
                if (a10 != null) {
                    kVar.j(ResultMetadataType.BYTE_SEGMENTS, a10);
                }
                String b11 = d10.b();
                if (b11 != null) {
                    kVar.j(ResultMetadataType.ERROR_CORRECTION_LEVEL, b11);
                }
                if (d10.k()) {
                    kVar.j(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(d10.i()));
                    kVar.j(ResultMetadataType.STRUCTURED_APPEND_PARITY, Integer.valueOf(d10.h()));
                }
                arrayList.add(kVar);
            } catch (ReaderException unused) {
            }
        }
        if (arrayList.isEmpty()) {
            return f10566c;
        }
        List<k> h10 = h(arrayList);
        return (k[]) h10.toArray(new k[h10.size()]);
    }

    @Override // h6.c
    public k[] d(b bVar) throws NotFoundException {
        return c(bVar, null);
    }
}
