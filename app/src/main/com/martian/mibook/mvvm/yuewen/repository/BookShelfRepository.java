package com.martian.mibook.mvvm.yuewen.repository;

import com.martian.mibook.lib.account.response.BooksUpdateInfo;
import com.martian.mibook.mvvm.base.BaseRepository;
import java.util.List;
import kotlin.coroutines.Continuation;
import xi.k;
import xi.l;

/* loaded from: classes3.dex */
public final class BookShelfRepository extends BaseRepository {
    @l
    public final Object f(@k String str, @k Continuation<? super List<? extends BooksUpdateInfo>> continuation) {
        return c(new BookShelfRepository$getBooksUpdateInfo$2(this, str, null), continuation);
    }
}
