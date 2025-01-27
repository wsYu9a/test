package com.martian.mibook.lib.local.base.data;

import com.martian.mibook.lib.model.data.abs.Book;
import java.io.File;

/* loaded from: classes3.dex */
public abstract class LocalBook extends Book {
    public boolean exists() {
        return new File(getFilePath()).exists();
    }

    public abstract String getCharset();

    public abstract String getFilePath();

    public abstract Long getFileSize();

    @Override // com.martian.mibook.lib.model.data.abs.Book, wb.f
    public String getSourceId() {
        return getFilePath();
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public boolean isLocal() {
        return true;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setShortIntro(String str) {
    }
}
