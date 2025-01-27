package com.martian.mibook.lib.account.request;

import com.martian.libcomm.http.requests.d.a;

/* loaded from: classes3.dex */
public class ReaderBookParams extends TYHttpGetParams {

    @a
    private String sourceId;

    @a
    private String sourceName;

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "ty/reader_book";
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public String getSourceName() {
        return this.sourceName;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }
}
