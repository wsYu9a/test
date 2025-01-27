package com.martian.mibook.lib.model.data;

import ba.k;

@k.h(name = "mibookstoreitems")
/* loaded from: classes3.dex */
public class MiBookStoreItemLegency {

    @k.a
    @k.b
    @k.f(ascend = false, index = 1)
    private Integer _id;

    @k.i
    @k.b
    private String bookId;

    @k.b
    @k.f(ascend = false, index = 0)
    private Boolean flagTop;

    @k.b
    private String sourceString;

    public boolean equals(Object obj) {
        if (!(obj instanceof MiBookStoreItemLegency)) {
            return false;
        }
        MiBookStoreItemLegency miBookStoreItemLegency = (MiBookStoreItemLegency) obj;
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
        if (str != null) {
            return str.hashCode();
        }
        String str2 = this.sourceString;
        if (str2 == null) {
            return 0;
        }
        return str2.hashCode();
    }

    public boolean isFlagTop() {
        Boolean bool = this.flagTop;
        return bool != null && bool.booleanValue();
    }

    public void setBookId(String str) {
        this.bookId = str;
    }

    public void setFlagTop(boolean z10) {
        this.flagTop = Boolean.valueOf(z10);
    }

    public void setSourceString(String str) {
        this.sourceString = str;
    }

    public void set_id(Integer num) {
        this._id = num;
    }
}
