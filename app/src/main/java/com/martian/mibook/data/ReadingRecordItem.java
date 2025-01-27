package com.martian.mibook.data;

import bb.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.martian.mibook.lib.model.data.MiReadingRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J?\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000f\"\u0004\b\u0012\u0010\u0011R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006$"}, d2 = {"Lcom/martian/mibook/data/ReadingRecordItem;", "", "readingRecord", "Lcom/martian/mibook/lib/model/data/MiReadingRecord;", "bookCover", "", "isInBookStore", "", "localBook", "isSelected", "(Lcom/martian/mibook/lib/model/data/MiReadingRecord;Ljava/lang/String;ZZZ)V", "getBookCover", "()Ljava/lang/String;", "setBookCover", "(Ljava/lang/String;)V", "()Z", "setInBookStore", "(Z)V", "setSelected", "getLocalBook", "setLocalBook", "getReadingRecord", "()Lcom/martian/mibook/lib/model/data/MiReadingRecord;", "setReadingRecord", "(Lcom/martian/mibook/lib/model/data/MiReadingRecord;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", AdnName.OTHER, TTDownloadField.TT_HASHCODE, "", "toString", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ReadingRecordItem {

    @l
    private String bookCover;
    private boolean isInBookStore;
    private boolean isSelected;
    private boolean localBook;

    @l
    private MiReadingRecord readingRecord;

    public ReadingRecordItem() {
        this(null, null, false, false, false, 31, null);
    }

    public static /* synthetic */ ReadingRecordItem copy$default(ReadingRecordItem readingRecordItem, MiReadingRecord miReadingRecord, String str, boolean z10, boolean z11, boolean z12, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            miReadingRecord = readingRecordItem.readingRecord;
        }
        if ((i10 & 2) != 0) {
            str = readingRecordItem.bookCover;
        }
        String str2 = str;
        if ((i10 & 4) != 0) {
            z10 = readingRecordItem.isInBookStore;
        }
        boolean z13 = z10;
        if ((i10 & 8) != 0) {
            z11 = readingRecordItem.localBook;
        }
        boolean z14 = z11;
        if ((i10 & 16) != 0) {
            z12 = readingRecordItem.isSelected;
        }
        return readingRecordItem.copy(miReadingRecord, str2, z13, z14, z12);
    }

    @l
    /* renamed from: component1, reason: from getter */
    public final MiReadingRecord getReadingRecord() {
        return this.readingRecord;
    }

    @l
    /* renamed from: component2, reason: from getter */
    public final String getBookCover() {
        return this.bookCover;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsInBookStore() {
        return this.isInBookStore;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getLocalBook() {
        return this.localBook;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    @k
    public final ReadingRecordItem copy(@l MiReadingRecord readingRecord, @l String bookCover, boolean isInBookStore, boolean localBook, boolean isSelected) {
        return new ReadingRecordItem(readingRecord, bookCover, isInBookStore, localBook, isSelected);
    }

    public boolean equals(@l Object r52) {
        if (this == r52) {
            return true;
        }
        if (!(r52 instanceof ReadingRecordItem)) {
            return false;
        }
        ReadingRecordItem readingRecordItem = (ReadingRecordItem) r52;
        return Intrinsics.areEqual(this.readingRecord, readingRecordItem.readingRecord) && Intrinsics.areEqual(this.bookCover, readingRecordItem.bookCover) && this.isInBookStore == readingRecordItem.isInBookStore && this.localBook == readingRecordItem.localBook && this.isSelected == readingRecordItem.isSelected;
    }

    @l
    public final String getBookCover() {
        return this.bookCover;
    }

    public final boolean getLocalBook() {
        return this.localBook;
    }

    @l
    public final MiReadingRecord getReadingRecord() {
        return this.readingRecord;
    }

    public int hashCode() {
        MiReadingRecord miReadingRecord = this.readingRecord;
        int hashCode = (miReadingRecord == null ? 0 : miReadingRecord.hashCode()) * 31;
        String str = this.bookCover;
        return ((((((hashCode + (str != null ? str.hashCode() : 0)) * 31) + a.a(this.isInBookStore)) * 31) + a.a(this.localBook)) * 31) + a.a(this.isSelected);
    }

    public final boolean isInBookStore() {
        return this.isInBookStore;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setBookCover(@l String str) {
        this.bookCover = str;
    }

    public final void setInBookStore(boolean z10) {
        this.isInBookStore = z10;
    }

    public final void setLocalBook(boolean z10) {
        this.localBook = z10;
    }

    public final void setReadingRecord(@l MiReadingRecord miReadingRecord) {
        this.readingRecord = miReadingRecord;
    }

    public final void setSelected(boolean z10) {
        this.isSelected = z10;
    }

    @k
    public String toString() {
        return "ReadingRecordItem(readingRecord=" + this.readingRecord + ", bookCover=" + this.bookCover + ", isInBookStore=" + this.isInBookStore + ", localBook=" + this.localBook + ", isSelected=" + this.isSelected + ")";
    }

    public ReadingRecordItem(@l MiReadingRecord miReadingRecord, @l String str, boolean z10, boolean z11, boolean z12) {
        this.readingRecord = miReadingRecord;
        this.bookCover = str;
        this.isInBookStore = z10;
        this.localBook = z11;
        this.isSelected = z12;
    }

    public /* synthetic */ ReadingRecordItem(MiReadingRecord miReadingRecord, String str, boolean z10, boolean z11, boolean z12, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : miReadingRecord, (i10 & 2) == 0 ? str : null, (i10 & 4) != 0 ? false : z10, (i10 & 8) != 0 ? false : z11, (i10 & 16) != 0 ? false : z12);
    }
}
