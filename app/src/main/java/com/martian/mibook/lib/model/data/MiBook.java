package com.martian.mibook.lib.model.data;

import com.martian.libsupport.j;
import com.martian.mibook.lib.model.data.abs.UrlItem;

@j.g(name = "mibooks")
/* loaded from: classes3.dex */
public class MiBook implements UrlItem {

    @j.b
    private String authorName;

    @j.b
    @j.f
    private String bookId;

    @j.b
    private String bookName;

    @j.b(name = "zsId")
    private String sourceString;

    @j.b
    private String url;

    public boolean equals(Object o) {
        return (o instanceof MiBook) && this.bookId.equals(((MiBook) o).getBookId());
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public String getBookId() {
        return this.bookId;
    }

    public String getBookName() {
        return this.bookName;
    }

    public String getSourceString() {
        return this.sourceString;
    }

    @Override // com.martian.mibook.lib.model.data.abs.UrlItem
    public String getTitle() {
        return this.bookName;
    }

    @Override // com.martian.mibook.lib.model.data.abs.UrlItem
    public String getUrl() {
        return this.url;
    }

    public String getWebBookId() {
        String str = this.bookId;
        return str.substring(str.indexOf("_") + 1);
    }

    public int hashCode() {
        return this.bookId.hashCode();
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setBookId(String id) {
        this.bookId = id;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setSourceString(String zsId) {
        this.sourceString = zsId;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
