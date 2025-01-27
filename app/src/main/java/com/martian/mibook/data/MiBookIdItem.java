package com.martian.mibook.data;

import java.util.Set;

/* loaded from: classes.dex */
public class MiBookIdItem {
    public String date;
    public final Set<String> mibookId;

    public MiBookIdItem(String date, Set<String> mibookId) {
        this.date = date;
        this.mibookId = mibookId;
    }

    public void addMibookId(String bookId) {
        this.mibookId.add(bookId);
    }

    public String getDate() {
        return this.date;
    }

    public Set<String> getMibookId() {
        return this.mibookId;
    }

    public void setDate(String currentDate) {
        this.date = currentDate;
    }
}
