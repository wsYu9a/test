package com.martian.mibook.mvvm.yuewen.repository;

import com.martian.mibook.lib.model.data.TYSearchBookList;
import com.martian.mibook.mvvm.base.BaseRepository;
import java.util.Map;
import kotlin.coroutines.Continuation;
import xi.k;
import xi.l;

/* loaded from: classes3.dex */
public final class SimilarityBookRepository extends BaseRepository {
    @l
    public final Object f(@k Map<String, String> map, @k Continuation<? super TYSearchBookList> continuation) {
        return c(new SimilarityBookRepository$getRecommendBooks$2(this, map, null), continuation);
    }
}
