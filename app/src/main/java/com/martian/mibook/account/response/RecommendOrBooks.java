package com.martian.mibook.account.response;

import com.martian.mibook.lib.original.data.ORBook;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class RecommendOrBooks {
    public final List<ORBook> orBookList = new ArrayList();

    public List<ORBook> getOrBooks() {
        return this.orBookList;
    }
}
