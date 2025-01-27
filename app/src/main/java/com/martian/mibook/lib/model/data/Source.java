package com.martian.mibook.lib.model.data;

import com.martian.mibook.lib.model.c.g;

/* loaded from: classes3.dex */
public class Source implements g {
    private String sourceId;
    private String sourceName;

    public Source() {
    }

    public boolean equals(Object o) {
        if (!(o instanceof g)) {
            return false;
        }
        g gVar = (g) o;
        return gVar.getSourceName().equals(getSourceName()) && gVar.getSourceId().equals(getSourceId());
    }

    @Override // com.martian.mibook.lib.model.c.g
    public String getSourceId() {
        return this.sourceId;
    }

    @Override // com.martian.mibook.lib.model.c.g
    public String getSourceName() {
        return this.sourceName;
    }

    public int hashCode() {
        return (getSourceName() + getSourceId()).hashCode();
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public Source(String sourceName, String sourceId) {
        this.sourceName = sourceName;
        this.sourceId = sourceId;
    }
}
