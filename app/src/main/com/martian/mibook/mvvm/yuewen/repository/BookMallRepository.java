package com.martian.mibook.mvvm.yuewen.repository;

import com.martian.mibook.lib.yuewen.response.YWBookMall;
import com.martian.mibook.lib.yuewen.response.YWChannelBookList;
import com.martian.mibook.mvvm.base.BaseRepository;
import java.util.Map;
import kotlin.coroutines.Continuation;
import uc.d;
import xi.k;
import xi.l;

/* loaded from: classes3.dex */
public final class BookMallRepository extends BaseRepository {
    @l
    public final Object f(@k Map<String, String> map, @k Continuation<? super YWChannelBookList> continuation) {
        return c(new BookMallRepository$getBookMallChannelBooks$2(this, map, null), continuation);
    }

    @l
    public final Object g(@k Map<String, String> map, @k Continuation<? super d<YWBookMall>> continuation) {
        return d(new BookMallRepository$getBookMallData$2(this, map, null), continuation);
    }
}
