package com.martian.mibook.lib.model.data;

import wb.f;

/* loaded from: classes3.dex */
public class Source implements f {
    private String sourceId;
    private String sourceName;

    public Source() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return fVar.getSourceName().equals(getSourceName()) && fVar.getSourceId().equals(getSourceId());
    }

    @Override // wb.f
    public String getSourceId() {
        return this.sourceId;
    }

    @Override // wb.f
    public String getSourceName() {
        return this.sourceName;
    }

    public int hashCode() {
        String sourceName = getSourceName();
        String sourceId = getSourceId();
        StringBuilder sb2 = new StringBuilder();
        if (sourceName == null) {
            sourceName = "";
        }
        sb2.append(sourceName);
        if (sourceId == null) {
            sourceId = "";
        }
        sb2.append(sourceId);
        return sb2.toString().hashCode();
    }

    public void setSourceId(String str) {
        this.sourceId = str;
    }

    public void setSourceName(String str) {
        this.sourceName = str;
    }

    public Source(String str, String str2) {
        this.sourceName = str;
        this.sourceId = str2;
    }
}
