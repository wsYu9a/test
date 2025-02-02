package com.martian.mibook.lib.model.data;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class MiReadingRecordList {
    private List<MiReadingRecord> miReadingRecords;

    public List<MiReadingRecord> getMiReadingRecords() {
        if (this.miReadingRecords == null) {
            this.miReadingRecords = new ArrayList();
        }
        return this.miReadingRecords;
    }

    public void setMiReadingRecords(List<MiReadingRecord> list) {
        this.miReadingRecords = list;
    }
}
