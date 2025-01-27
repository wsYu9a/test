package com.martian.mibook.mvvm.yuewen.repository;

import com.martian.mibook.lib.yuewen.response.YWChannelBookList;
import com.martian.mibook.mvvm.base.BaseRepository;
import java.util.Map;
import kotlin.coroutines.Continuation;
import xi.k;
import xi.l;

/* loaded from: classes3.dex */
public final class YWChannelBookListRepository extends BaseRepository {
    @l
    public final Object f(@k Map<String, String> map, @k Continuation<? super YWChannelBookList> continuation) {
        return c(new YWChannelBookListRepository$getBookMallChannelBooks$2(this, map, null), continuation);
    }
}
