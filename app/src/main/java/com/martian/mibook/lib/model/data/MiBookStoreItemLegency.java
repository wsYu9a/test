package com.martian.mibook.lib.model.data;

import com.martian.libsupport.j;

@j.g(name = "mibookstoreitems")
/* loaded from: classes3.dex */
public class MiBookStoreItemLegency {

    @j.b
    @j.a
    @j.e(ascend = false, index = 1)
    private Integer _id;

    @j.b
    @j.h
    private String bookId;

    @j.b
    @j.e(ascend = false, index = 0)
    private Boolean flagTop;

    @j.b
    private String sourceString;

    public boolean equals(Object o) {
        if (!(o instanceof MiBookStoreItemLegency)) {
            return false;
        }
        MiBookStoreItemLegency miBookStoreItemLegency = (MiBookStoreItemLegency) o;
        String str = this.bookId;
        if (str != null) {
            String str2 = miBookStoreItemLegency.bookId;
            return str2 != null && str.equals(str2);
        }
        String str3 = miBookStoreItemLegency.sourceString;
        return str3 != null && str3.equals(this.sourceString);
    }

    public String getBookId() {
        return this.bookId;
    }

    public String getSourceString() {
        return this.sourceString;
    }

    public Integer get_id() {
        return this._id;
    }

    public int hashCode() {
        String str = this.bookId;
        return str != null ? str.hashCode() : this.sourceString.hashCode();
    }

    public boolean isFlagTop() {
        Boolean bool = this.flagTop;
        return bool != null && bool.booleanValue();
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setFlagTop(boolean flagTop) {
        this.flagTop = Boolean.valueOf(flagTop);
    }

    public void setSourceString(String zsId) {
        this.sourceString = zsId;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }
}
