package vb;

import android.database.Cursor;
import com.martian.mibook.lib.model.data.MiReadingRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import wb.f;
import yb.k;
import yb.l;

/* loaded from: classes3.dex */
public class d {

    /* renamed from: a */
    public final k f31293a = k.K();

    /* renamed from: b */
    public final yb.e f31294b = yb.e.K();

    public boolean a(f fVar) {
        MiReadingRecord miReadingRecord = new MiReadingRecord();
        miReadingRecord.setSourceString(e.k(fVar));
        return this.f31293a.delete(miReadingRecord);
    }

    public MiReadingRecord b(String str) {
        MiReadingRecord miReadingRecord = new MiReadingRecord();
        miReadingRecord.setSourceString(str);
        if (this.f31293a.w(miReadingRecord)) {
            return miReadingRecord;
        }
        return null;
    }

    public MiReadingRecord c(String str, String str2) {
        MiReadingRecord b10 = b(e.j(str, str2));
        return b10 == null ? b(str2) : b10;
    }

    public MiReadingRecord d(f fVar) {
        return c(fVar.getSourceName(), fVar.getSourceId());
    }

    public List<MiReadingRecord> e(int i10, int i11) {
        Cursor query = this.f31293a.query(i10 * i11, i11, "lastReadingTime DESC");
        ArrayList arrayList = new ArrayList(i11);
        this.f31293a.E(arrayList, query);
        return arrayList;
    }

    public List<MiReadingRecord> f(List<String> list) {
        k kVar = this.f31293a;
        return kVar.v(kVar.l(), list);
    }

    public void g() {
        l lVar = new l();
        LinkedList linkedList = new LinkedList();
        try {
            if (!lVar.m(linkedList) || linkedList.size() <= 0) {
                return;
            }
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                this.f31293a.q((MiReadingRecord) it.next());
            }
        } catch (Exception unused) {
        }
    }

    public void h(MiReadingRecord miReadingRecord, boolean z10) {
        if (z10) {
            miReadingRecord.setLastReadingTime(Long.valueOf(System.currentTimeMillis()));
        }
        this.f31293a.q(miReadingRecord);
    }
}
