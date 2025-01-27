package com.martian.mibook.lib.model.manager;

import android.database.Cursor;
import android.text.TextUtils;
import com.martian.mibook.lib.model.c.g;
import com.martian.mibook.lib.model.data.MiBook;
import com.martian.mibook.lib.model.data.MiBookMark;
import com.martian.mibook.lib.model.data.MiReadingRecord;
import com.martian.mibook.lib.model.e.f;
import com.martian.mibook.lib.model.e.l;
import com.martian.mibook.lib.model.e.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes3.dex */
public class c {

    /* renamed from: a */
    private final l f14047a = l.a();

    /* renamed from: b */
    private final f f14048b = f.q();

    c() {
    }

    public boolean a(MiBookMark bookMark) {
        return this.f14048b.o(bookMark);
    }

    public boolean b(MiBookMark bookMark) {
        return this.f14048b.delete(bookMark);
    }

    public boolean c(g sourceProvider) {
        MiReadingRecord miReadingRecord = new MiReadingRecord();
        miReadingRecord.setSourceString(d.i(sourceProvider));
        return this.f14047a.delete(miReadingRecord);
    }

    public MiReadingRecord d(MiBook mibook) {
        if (TextUtils.isEmpty(mibook.getSourceString())) {
            return null;
        }
        return f(mibook.getSourceString());
    }

    public MiReadingRecord e(g sourceProvider) {
        return g(sourceProvider.getSourceName(), sourceProvider.getSourceId());
    }

    public MiReadingRecord f(String sourceString) {
        MiReadingRecord miReadingRecord = new MiReadingRecord();
        miReadingRecord.setSourceString(sourceString);
        if (this.f14047a.load((l) miReadingRecord)) {
            return miReadingRecord;
        }
        return null;
    }

    public MiReadingRecord g(String sourceName, String sourceId) {
        MiReadingRecord f2 = f(d.j(sourceName, sourceId));
        return f2 == null ? f(sourceId) : f2;
    }

    public List<MiReadingRecord> h(int page, int pageSize) {
        Cursor query = this.f14047a.query(page * pageSize, pageSize, "lastReadingTime DESC");
        ArrayList arrayList = new ArrayList(pageSize);
        this.f14047a.load(arrayList, query);
        return arrayList;
    }

    public void i() {
        m mVar = new m();
        LinkedList linkedList = new LinkedList();
        try {
            if (!mVar.i(linkedList) || linkedList.size() <= 0) {
                return;
            }
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                this.f14047a.insertOrUpdate((l) it.next());
            }
        } catch (Exception unused) {
        }
    }

    public Cursor j(String sourceString) {
        return this.f14048b.r(sourceString);
    }

    public void k(MiReadingRecord record, boolean updateTime) {
        if (updateTime) {
            record.setLastReadingTime(Long.valueOf(System.currentTimeMillis()));
        }
        this.f14047a.insertOrUpdate((l) record);
    }
}
