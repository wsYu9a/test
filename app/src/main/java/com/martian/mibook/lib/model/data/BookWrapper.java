package com.martian.mibook.lib.model.data;

import android.text.TextUtils;
import com.martian.mibook.lib.model.data.abs.Book;

/* loaded from: classes3.dex */
public class BookWrapper {
    public Book book;
    public Object customData;
    public MiBookStoreItem item;
    public MiBook mibook;
    public boolean isAdderItem = false;
    public boolean isAdsItem = false;
    public boolean updateCategoryRading = false;
    private boolean isSelect = false;
    public boolean hasChapterUpdate = false;
    public boolean isCaching = false;
    public long cacheIndex = -1;
    public long cacheSize = -1;
    public String lastestCachedChapterTitle = null;
    public boolean hasCache = false;

    public BookWrapper(MiBookStoreItem item, MiBook mibook, Book book) {
        this.item = item;
        this.mibook = mibook;
        this.book = book;
    }

    public void clearCacheInfo() {
        this.cacheSize = 0L;
        this.cacheIndex = 0L;
        this.lastestCachedChapterTitle = null;
    }

    public boolean equals(Object o) {
        if (o instanceof BookWrapper) {
            return this.item.equals(((BookWrapper) o).item);
        }
        return false;
    }

    public String getBookName() {
        MiBook miBook;
        MiBookStoreItem miBookStoreItem;
        Book book = this.book;
        String bookName = book != null ? book.getBookName() : null;
        if (TextUtils.isEmpty(bookName) && (miBookStoreItem = this.item) != null) {
            bookName = miBookStoreItem.getBookName();
        }
        if (TextUtils.isEmpty(bookName) && (miBook = this.mibook) != null) {
            bookName = miBook.getBookName();
        }
        return TextUtils.isEmpty(bookName) ? "" : bookName;
    }

    public String getCover() {
        MiBookStoreItem miBookStoreItem = this.item;
        if (miBookStoreItem != null && !TextUtils.isEmpty(miBookStoreItem.getCoverUrl())) {
            return this.item.getCoverUrl();
        }
        Book book = this.book;
        return book != null ? book.getCover() : "";
    }

    public Object getCustomData() {
        return this.customData;
    }

    public boolean hasUpdate() {
        return this.item.hasUpdate();
    }

    public int hashCode() {
        return this.item.hashCode();
    }

    public boolean isSelect() {
        return this.isSelect;
    }

    public boolean isUpdateCategoryRading() {
        return this.updateCategoryRading;
    }

    public void resetTempInfo() {
        this.isCaching = false;
        this.cacheIndex = -1L;
        this.cacheSize = -1L;
        this.lastestCachedChapterTitle = null;
        this.hasCache = false;
        this.hasChapterUpdate = false;
    }

    public void setCover(String cover) {
        MiBookStoreItem miBookStoreItem = this.item;
        if (miBookStoreItem != null) {
            miBookStoreItem.setCoverUrl(cover);
        }
        Book book = this.book;
        if (book != null) {
            book.setCover(cover);
        }
    }

    public void setHasUpdate(boolean hasUpdate) {
        this.item.setHasUpdate(hasUpdate);
    }

    public void setSelect(boolean select) {
        this.isSelect = select;
    }

    public void setUpdateCategoryRading(boolean reading) {
        this.updateCategoryRading = reading;
    }
}
