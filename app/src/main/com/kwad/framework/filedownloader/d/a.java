package com.kwad.framework.filedownloader.d;

import android.content.ContentValues;
import com.kwad.framework.filedownloader.f.f;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.List;

/* loaded from: classes3.dex */
public final class a {
    private long aiX;
    private long aiY;
    private long aiZ;

    /* renamed from: id */
    private int f11964id;
    private int index;

    public static long r(List<a> list) {
        long j10 = 0;
        for (a aVar : list) {
            j10 += aVar.xp() - aVar.getStartOffset();
        }
        return j10;
    }

    public final void R(long j10) {
        this.aiY = j10;
    }

    public final void S(long j10) {
        this.aiZ = j10;
    }

    public final int getId() {
        return this.f11964id;
    }

    public final int getIndex() {
        return this.index;
    }

    public final long getStartOffset() {
        return this.aiX;
    }

    public final void setId(int i10) {
        this.f11964id = i10;
    }

    public final void setIndex(int i10) {
        this.index = i10;
    }

    public final void setStartOffset(long j10) {
        this.aiX = j10;
    }

    public final String toString() {
        return f.b("id[%d] index[%d] range[%d, %d) current offset(%d)", Integer.valueOf(this.f11964id), Integer.valueOf(this.index), Long.valueOf(this.aiX), Long.valueOf(this.aiZ), Long.valueOf(this.aiY));
    }

    public final long xp() {
        return this.aiY;
    }

    public final long xq() {
        return this.aiZ;
    }

    public final ContentValues xr() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(this.f11964id));
        contentValues.put("connectionIndex", Integer.valueOf(this.index));
        contentValues.put(DBDefinition.START_OFFSET, Long.valueOf(this.aiX));
        contentValues.put("currentOffset", Long.valueOf(this.aiY));
        contentValues.put(DBDefinition.END_OFFSET, Long.valueOf(this.aiZ));
        return contentValues;
    }
}
