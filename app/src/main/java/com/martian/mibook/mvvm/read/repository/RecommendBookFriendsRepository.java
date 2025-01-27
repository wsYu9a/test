package com.martian.mibook.mvvm.read.repository;

import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.mvvm.base.BaseRepository;
import com.martian.mibook.mvvm.net.result.TYBookTopUser;
import java.util.List;
import kotlin.coroutines.Continuation;
import xi.k;
import xi.l;

/* loaded from: classes3.dex */
public final class RecommendBookFriendsRepository extends BaseRepository {
    @l
    public final Object f(@k String str, @k String str2, int i10, int i11, @k Continuation<? super List<TYBookTopUser>> continuation) {
        return c(new RecommendBookFriendsRepository$getRecommendBookFriends$2(this, str, str2, i10, i11, null), continuation);
    }

    @l
    public final Object g(@k String str, @k String str2, @k String str3, int i10, int i11, @k Continuation<? super List<? extends TYBookItem>> continuation) {
        return c(new RecommendBookFriendsRepository$getTopUserBooks$2(this, str, str2, str3, i10, i11, null), continuation);
    }
}
