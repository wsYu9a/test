package com.martian.mibook.lib.model.data;

import android.database.Cursor;
import ba.k;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
public class MiChapterList implements ChapterList {
    private final Class<? extends Chapter> chapterClass;
    private Cursor mCursor;

    public MiChapterList(Class<? extends Chapter> cls, Cursor cursor) {
        this.chapterClass = cls;
        this.mCursor = cursor;
    }

    public Class<? extends Chapter> getChapterClass() {
        return this.chapterClass;
    }

    @Override // com.martian.mibook.lib.model.data.abs.ChapterList
    public List getChapters() {
        throw new UnsupportedOperationException("Can not get chapters in michapter list.");
    }

    @Override // com.martian.mibook.lib.model.data.abs.ChapterList
    public int getCount() {
        try {
            return this.mCursor.getCount();
        } catch (Exception unused) {
            return 0;
        }
    }

    public Cursor getCursor() {
        return this.mCursor;
    }

    @Override // com.martian.mibook.lib.model.data.abs.ChapterList
    public Chapter getItem(int i10) {
        if (this.mCursor.moveToPosition(i10)) {
            return (Chapter) k.h(this.chapterClass, this.mCursor);
        }
        if (ConfigSingleton.D().J0()) {
            throw new NoSuchElementException();
        }
        return null;
    }

    public Chapter newChapter() {
        try {
            return this.chapterClass.newInstance();
        } catch (Exception unused) {
            throw new UnsupportedOperationException();
        }
    }

    public void swapCursor(Cursor cursor) {
        try {
            Cursor cursor2 = this.mCursor;
            if (cursor2 != null) {
                cursor2.close();
            }
        } catch (Exception unused) {
        }
        this.mCursor = cursor;
    }
}
