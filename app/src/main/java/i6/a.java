package i6;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.multi.qrcode.detector.MultiFinderPatternFinder;
import java.util.ArrayList;
import java.util.Map;
import t5.m;
import u6.c;
import u6.e;
import z5.b;
import z5.f;

/* loaded from: classes2.dex */
public final class a extends c {

    /* renamed from: c */
    public static final f[] f26915c = new f[0];

    public a(b bVar) {
        super(bVar);
    }

    public f[] n(Map<DecodeHintType, ?> map) throws NotFoundException {
        e[] n10 = new MultiFinderPatternFinder(h(), map == null ? null : (m) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK)).n(map);
        if (n10.length == 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        ArrayList arrayList = new ArrayList();
        for (e eVar : n10) {
            try {
                arrayList.add(j(eVar));
            } catch (ReaderException unused) {
            }
        }
        return arrayList.isEmpty() ? f26915c : (f[]) arrayList.toArray(new f[arrayList.size()]);
    }
}
