package com.martian.mibook.lib.local.txt.data;

import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import java.util.List;

/* loaded from: classes3.dex */
public class TXTChapterList implements ChapterList {
    List<TXTChapter> chapters;

    @Override // com.martian.mibook.lib.model.data.abs.ChapterList
    public List<TXTChapter> getChapters() {
        return this.chapters;
    }

    @Override // com.martian.mibook.lib.model.data.abs.ChapterList
    public int getCount() {
        List<TXTChapter> list = this.chapters;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // com.martian.mibook.lib.model.data.abs.ChapterList
    public Chapter getItem(int position) {
        return this.chapters.get(position);
    }

    public void setChapters(List<TXTChapter> chapters) {
        this.chapters = chapters;
    }
}
