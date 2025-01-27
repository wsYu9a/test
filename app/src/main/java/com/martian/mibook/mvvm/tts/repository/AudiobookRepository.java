package com.martian.mibook.mvvm.tts.repository;

import com.martian.mibook.lib.model.data.TYSearchBookList;
import com.martian.mibook.mvvm.base.BaseRepository;
import java.util.Map;
import kotlin.coroutines.Continuation;
import xi.k;
import xi.l;

/* loaded from: classes3.dex */
public final class AudiobookRepository extends BaseRepository {
    @l
    public final Object f(@k Map<String, String> map, @k Continuation<? super TYSearchBookList> continuation) {
        return c(new AudiobookRepository$getRecommendBooks$2(this, map, null), continuation);
    }
}
