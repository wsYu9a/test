package com.martian.mibook.lib.account.request;

import com.martian.libcomm.http.requests.d.a;

/* loaded from: classes3.dex */
public class BookAlertParams extends TYAuthoptParams {

    @a
    private String sourceId;

    @a
    private String sourceName;

    @Override // com.martian.mibook.lib.account.request.TYAuthoptParams
    public String getAuthoptMethod() {
        return "ty/book_offline_free_alert";
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
