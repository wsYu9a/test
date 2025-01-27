package com.martian.mibook.lib.model.f;

import b.d.c.b.k;
import com.martian.mibook.lib.model.c.g;
import com.martian.mibook.lib.model.data.abs.ChapterList;

/* loaded from: classes3.dex */
public abstract class d extends b.d.c.c.c<g, ChapterList> {

    /* renamed from: a */
    private final com.martian.mibook.lib.model.c.d f14014a;

    public d(com.martian.mibook.lib.model.c.d provider) {
        this.f14014a = provider;
    }

    @Override // b.d.c.c.c
    /* renamed from: f */
    public k doInBackground(g source) {
        return new b.d.c.b.b(this.f14014a.p(source));
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: g */
    public boolean onPreDataReceived(ChapterList chapterList) {
        return chapterList != null && chapterList.getCount() > 0;
    }
}
