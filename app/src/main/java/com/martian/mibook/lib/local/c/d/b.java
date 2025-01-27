package com.martian.mibook.lib.local.c.d;

import com.martian.libsupport.j;
import com.martian.libsupport.k;
import com.martian.mibook.lib.local.txt.data.TXTChapter;
import com.martian.mibook.lib.model.c.g;
import com.martian.mibook.lib.model.e.n;

@j.g(name = "txtchapters")
/* loaded from: classes3.dex */
public class b extends n<TXTChapter> {
    public b(g book) {
        super("txt_" + k.r(book.getSourceId()) + "_chapters.db", 5, TXTChapter.class);
    }
}
