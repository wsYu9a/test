package com.martian.mibook.lib.original.data;

import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ORChapterList implements ChapterList {
    private List<ORChapter> chapterList = new ArrayList();

    public void addChapter(ORChapter oRChapter) {
        this.chapterList.add(oRChapter);
    }

    public List<ORChapter> getChapterList() {
        return this.chapterList;
    }

    @Override // com.martian.mibook.lib.model.data.abs.ChapterList
    public List getChapters() {
        return this.chapterList;
    }

    @Override // com.martian.mibook.lib.model.data.abs.ChapterList
    public int getCount() {
        return this.chapterList.size();
    }

    @Override // com.martian.mibook.lib.model.data.abs.ChapterList
    public Chapter getItem(int i10) {
        return this.chapterList.get(i10);
    }

    public void setChapterList(List<ORChapter> list) {
        this.chapterList = list;
    }
}
