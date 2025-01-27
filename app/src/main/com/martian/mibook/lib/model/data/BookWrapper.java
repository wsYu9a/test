package com.martian.mibook.lib.model.data;

import ba.l;
import com.martian.mibook.lib.model.data.abs.Book;

/* loaded from: classes3.dex */
public class BookWrapper {
    public Book book;
    public MiBookStoreItem item;
    public Type type = Type.BOOK;
    private boolean isSelect = false;
    public boolean txtChapterLoading = false;

    public enum Type {
        BOOK,
        ADDER,
        AD
    }

    public BookWrapper(MiBookStoreItem miBookStoreItem, Book book) {
        this.item = miBookStoreItem;
        this.book = book;
    }

    public boolean equals(Object obj) {
        MiBookStoreItem miBookStoreItem;
        return (obj instanceof BookWrapper) && (miBookStoreItem = this.item) != null && miBookStoreItem.equals(((BookWrapper) obj).item);
    }

    public String getBookName() {
        MiBookStoreItem miBookStoreItem;
        Book book = this.book;
        String bookName = book != null ? book.getBookName() : "";
        return (!l.q(bookName) || (miBookStoreItem = this.item) == null) ? bookName : miBookStoreItem.getBookName();
    }

    public String getCover() {
        MiBookStoreItem miBookStoreItem = this.item;
        if (miBookStoreItem != null && !l.q(miBookStoreItem.getCoverUrl())) {
            return this.item.getCoverUrl();
        }
        Book book = this.book;
        return book != null ? book.getCover() : "";
    }

    public int getUpdateChapterCount() {
        int lastReadChapterSize = this.item.getLastReadChapterSize();
        Integer chapterSize = this.item.getChapterSize();
        if (chapterSize == null || lastReadChapterSize <= 0 || lastReadChapterSize >= chapterSize.intValue()) {
            return 0;
        }
        return chapterSize.intValue() - lastReadChapterSize;
    }

    public boolean hasUpdate() {
        return this.item.hasUpdate();
    }

    public int hashCode() {
        MiBookStoreItem miBookStoreItem = this.item;
        if (miBookStoreItem == null) {
            return 0;
        }
        return miBookStoreItem.hashCode();
    }

    public boolean isAdItem() {
        return this.type == Type.AD;
    }

    public boolean isAdderItem() {
        return this.type == Type.ADDER;
    }

    public boolean isSelect() {
        return this.isSelect;
    }

    public boolean notBookItem() {
        return this.type != Type.BOOK;
    }

    public void resetTempInfo() {
        this.txtChapterLoading = false;
    }

    public void setCover(String str) {
        MiBookStoreItem miBookStoreItem = this.item;
        if (miBookStoreItem != null) {
            miBookStoreItem.setCoverUrl(str);
        }
        Book book = this.book;
        if (book != null) {
            book.setCover(str);
        }
    }

    public void setHasUpdate(boolean z10) {
        this.item.setHasUpdate(z10);
    }

    public void setSelect(boolean z10) {
        this.isSelect = z10;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void updateLastReadChapterSize() {
        MiBookStoreItem miBookStoreItem = this.item;
        miBookStoreItem.setLastReadChapterSize(miBookStoreItem.getChapterSize());
    }
}
