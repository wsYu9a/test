package com.martian.mibook.mvvm.book.repository;

import com.martian.mibook.lib.account.response.TYChapterContent;
import com.martian.mibook.lib.model.data.TYSearchBookList;
import com.martian.mibook.mvvm.base.BaseRepository;
import java.util.Map;
import kotlin.coroutines.Continuation;
import xi.k;
import xi.l;

/* loaded from: classes3.dex */
public final class BookRepository extends BaseRepository {
    @l
    public final Object f(@k String str, @k String str2, @l String str3, @k Continuation<? super TYChapterContent> continuation) {
        return c(new BookRepository$getChapterContent$2(this, str, str2, str3, null), continuation);
    }

    @l
    public final Object g(@k Map<String, String> map, @k Continuation<? super TYSearchBookList> continuation) {
        return c(new BookRepository$getRecommendBooks$2(this, map, null), continuation);
    }
}
