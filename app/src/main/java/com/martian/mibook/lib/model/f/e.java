package com.martian.mibook.lib.model.f;

import b.d.c.c.g;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.ChapterList;

/* loaded from: classes3.dex */
public class e extends g<Void, Void> {

    /* renamed from: a */
    private final Book f14015a;

    /* renamed from: b */
    private final ChapterList f14016b;

    /* renamed from: c */
    private final com.martian.mibook.lib.model.c.b f14017c;

    public e(Book book, ChapterList chapterList, com.martian.mibook.lib.model.c.b bookProvider) {
        this.f14015a = book;
        this.f14016b = chapterList;
        this.f14017c = bookProvider;
    }

    @Override // b.d.c.c.g
    /* renamed from: f */
    public Void doInBackground(Void... params) {
        this.f14017c.E().S0(this.f14015a, this.f14016b);
        return null;
    }

    @Override // b.d.c.c.g
    protected void showLoading(boolean show) {
    }
}
