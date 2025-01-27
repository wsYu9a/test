package com.martian.mibook.mvvm.book.repository;

import com.martian.mibook.lib.yuewen.response.TYSearchRecommedInfo;
import com.martian.mibook.lib.yuewen.response.YWCategoryBookList;
import com.martian.mibook.lib.yuewen.response.YWFreeTypeList;
import com.martian.mibook.mvvm.base.BaseRepository;
import com.martian.mibook.mvvm.net.result.SearchBooksResult;
import java.util.Map;
import kotlin.coroutines.Continuation;
import xi.k;
import xi.l;

/* loaded from: classes3.dex */
public final class SearchRepository extends BaseRepository {
    @l
    public final Object f(int i10, @k Continuation<? super TYSearchRecommedInfo> continuation) {
        return c(new SearchRepository$getSearchRecommendInfo$2(this, i10, null), continuation);
    }

    @l
    public final Object g(@k Map<String, String> map, @k Continuation<? super SearchBooksResult> continuation) {
        return c(new SearchRepository$searchBooks$2(this, map, null), continuation);
    }

    @l
    public final Object h(@k Map<String, String> map, @k Continuation<? super YWCategoryBookList> continuation) {
        return c(new SearchRepository$searchBooksByCategory$2(this, map, null), continuation);
    }

    @l
    public final Object i(@k Continuation<? super YWFreeTypeList> continuation) {
        return c(new SearchRepository$syncAllCategories$2(this, null), continuation);
    }
}
