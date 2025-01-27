package com.martian.mibook.mvvm.net.result;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.martian.mibook.lib.model.data.TYBookItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J/\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/martian/mibook/mvvm/net/result/SearchBooksResult;", "", "page", "", "maxPage", "bookList", "", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "(IILjava/util/List;)V", "getBookList", "()Ljava/util/List;", "setBookList", "(Ljava/util/List;)V", "getMaxPage", "()I", "setMaxPage", "(I)V", "getPage", "setPage", "component1", "component2", "component3", "copy", "equals", "", AdnName.OTHER, TTDownloadField.TT_HASHCODE, "toString", "", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SearchBooksResult {

    @l
    private List<? extends TYBookItem> bookList;
    private int maxPage;
    private int page;

    public SearchBooksResult(int i10, int i11, @l List<? extends TYBookItem> list) {
        this.page = i10;
        this.maxPage = i11;
        this.bookList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SearchBooksResult copy$default(SearchBooksResult searchBooksResult, int i10, int i11, List list, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = searchBooksResult.page;
        }
        if ((i12 & 2) != 0) {
            i11 = searchBooksResult.maxPage;
        }
        if ((i12 & 4) != 0) {
            list = searchBooksResult.bookList;
        }
        return searchBooksResult.copy(i10, i11, list);
    }

    /* renamed from: component1, reason: from getter */
    public final int getPage() {
        return this.page;
    }

    /* renamed from: component2, reason: from getter */
    public final int getMaxPage() {
        return this.maxPage;
    }

    @l
    public final List<TYBookItem> component3() {
        return this.bookList;
    }

    @k
    public final SearchBooksResult copy(int page, int maxPage, @l List<? extends TYBookItem> bookList) {
        return new SearchBooksResult(page, maxPage, bookList);
    }

    public boolean equals(@l Object r52) {
        if (this == r52) {
            return true;
        }
        if (!(r52 instanceof SearchBooksResult)) {
            return false;
        }
        SearchBooksResult searchBooksResult = (SearchBooksResult) r52;
        return this.page == searchBooksResult.page && this.maxPage == searchBooksResult.maxPage && Intrinsics.areEqual(this.bookList, searchBooksResult.bookList);
    }

    @l
    public final List<TYBookItem> getBookList() {
        return this.bookList;
    }

    public final int getMaxPage() {
        return this.maxPage;
    }

    public final int getPage() {
        return this.page;
    }

    public int hashCode() {
        int i10 = ((this.page * 31) + this.maxPage) * 31;
        List<? extends TYBookItem> list = this.bookList;
        return i10 + (list == null ? 0 : list.hashCode());
    }

    public final void setBookList(@l List<? extends TYBookItem> list) {
        this.bookList = list;
    }

    public final void setMaxPage(int i10) {
        this.maxPage = i10;
    }

    public final void setPage(int i10) {
        this.page = i10;
    }

    @k
    public String toString() {
        return "SearchBooksResult(page=" + this.page + ", maxPage=" + this.maxPage + ", bookList=" + this.bookList + ")";
    }

    public /* synthetic */ SearchBooksResult(int i10, int i11, List list, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 0 : i10, i11, (i12 & 4) != 0 ? null : list);
    }
}
