package com.martian.mibook.mvvm.category.repository;

import com.martian.mibook.lib.yuewen.response.TYCategoryTagGroup;
import com.martian.mibook.mvvm.base.BaseRepository;
import java.util.List;
import kotlin.coroutines.Continuation;
import xi.k;
import xi.l;

/* loaded from: classes3.dex */
public final class CategoryRepository extends BaseRepository {
    @l
    public final Object f(int i10, @k Continuation<? super List<TYCategoryTagGroup>> continuation) {
        return c(new CategoryRepository$getCategoryTagList$2(this, i10, null), continuation);
    }
}
