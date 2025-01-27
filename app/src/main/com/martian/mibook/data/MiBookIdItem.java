package com.martian.mibook.data;

import java.util.Set;

/* loaded from: classes3.dex */
public class MiBookIdItem {
    public String date;
    public final Set<String> mibookId;

    public MiBookIdItem(String str, Set<String> set) {
        this.date = str;
        this.mibookId = set;
    }

    public void addMibookId(String str) {
        this.mibookId.add(str);
    }

    public String getDate() {
        return this.date;
    }

    public Set<String> getMibookId() {
        return this.mibookId;
    }

    public void setDate(String str) {
        this.date = str;
    }
}
