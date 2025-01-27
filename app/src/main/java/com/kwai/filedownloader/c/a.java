package com.kwai.filedownloader.c;

import android.content.ContentValues;
import com.kwai.filedownloader.e.f;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.List;

/* loaded from: classes2.dex */
public final class a {
    private long aGT;
    private long aGU;
    private long aGV;
    private int id;
    private int index;

    public static long H(List<a> list) {
        long j2 = 0;
        for (a aVar : list) {
            j2 += aVar.Ix() - aVar.getStartOffset();
        }
        return j2;
    }

    public final long Ix() {
        return this.aGU;
    }

    public final long Iy() {
        return this.aGV;
    }

    public final ContentValues Iz() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(this.id));
        contentValues.put("connectionIndex", Integer.valueOf(this.index));
        contentValues.put(DBDefinition.START_OFFSET, Long.valueOf(this.aGT));
        contentValues.put("currentOffset", Long.valueOf(this.aGU));
        contentValues.put(DBDefinition.END_OFFSET, Long.valueOf(this.aGV));
        return contentValues;
    }

    public final void am(long j2) {
        this.aGU = j2;
    }

    public final void an(long j2) {
        this.aGV = j2;
    }

    public final int getId() {
        return this.id;
    }

    public final int getIndex() {
        return this.index;
    }

    public final long getStartOffset() {
        return this.aGT;
    }

    public final void setId(int i2) {
        this.id = i2;
    }

    public final void setIndex(int i2) {
        this.index = i2;
    }

    public final void setStartOffset(long j2) {
        this.aGT = j2;
    }

    public final String toString() {
        return f.j("id[%d] index[%d] range[%d, %d) current offset(%d)", Integer.valueOf(this.id), Integer.valueOf(this.index), Long.valueOf(this.aGT), Long.valueOf(this.aGV), Long.valueOf(this.aGU));
    }
}
