package com.martian.mibook.lib.model.d;

import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterContent;

/* loaded from: classes3.dex */
public interface e {
    void a(Chapter chapter, String content);

    void b(ChapterContent chapterContent);

    void c(ChapterContent chapterContent);

    void onLoading(boolean loading);

    void onResultError(b.d.c.b.c errorResult);
}
