package com.martian.mibook.mvvm.read.repository;

import com.martian.mibook.data.book.MiBookCommentItemList;
import com.martian.mibook.data.book.MiBookGetCommentByScoreItemList;
import com.martian.mibook.data.book.MiBookGetCommentByTimeItemList;
import com.martian.mibook.data.book.ReadingInfo;
import com.martian.mibook.lib.account.response.Bonus;
import com.martian.mibook.lib.account.response.BookAdsInfo;
import com.martian.mibook.lib.account.response.ChapterPrice;
import com.martian.mibook.lib.model.data.TYSearchBookList;
import com.martian.mibook.mvvm.base.BaseRepository;
import com.martian.mibook.mvvm.net.result.TYBookTopUser;
import com.martian.mibook.mvvm.read.comment.CommentDetail;
import java.util.List;
import java.util.Map;
import kotlin.coroutines.Continuation;
import xi.k;
import xi.l;

/* loaded from: classes3.dex */
public final class ReadingRepository extends BaseRepository {
    @l
    public final Object f(@k String str, @k String str2, @k Continuation<? super BookAdsInfo> continuation) {
        return c(new ReadingRepository$getBookAdsInfo$2(this, str, str2, null), continuation);
    }

    @l
    public final Object g(@k Map<String, String> map, @k Continuation<? super MiBookGetCommentByTimeItemList> continuation) {
        return c(new ReadingRepository$getBookComment$2(this, map, null), continuation);
    }

    @l
    public final Object h(@k String str, @k String str2, @k Continuation<? super MiBookCommentItemList> continuation) {
        return c(new ReadingRepository$getBookScoresAndTopComments$2(this, str, str2, null), continuation);
    }

    @l
    public final Object i(int i10, int i11, int i12, @k Continuation<? super CommentDetail> continuation) {
        return c(new ReadingRepository$getCommentDetail$2(this, i10, i11, i12, null), continuation);
    }

    @l
    public final Object j(@k Map<String, String> map, @k Continuation<? super MiBookGetCommentByScoreItemList> continuation) {
        return c(new ReadingRepository$getHotBookComment$2(this, map, null), continuation);
    }

    @l
    public final Object k(@k String str, @k String str2, @k Continuation<? super ReadingInfo> continuation) {
        return c(new ReadingRepository$getReaderBook$2(this, str, str2, null), continuation);
    }

    @l
    public final Object l(@k String str, @k String str2, int i10, int i11, @l Integer num, @l Integer num2, @k Continuation<? super List<TYBookTopUser>> continuation) {
        return c(new ReadingRepository$getRecommendBookFriends$2(this, str, str2, i10, i11, num, num2, null), continuation);
    }

    @l
    public final Object n(@k Map<String, String> map, @k Continuation<? super TYSearchBookList> continuation) {
        return c(new ReadingRepository$getRecommendBooks$2(this, map, null), continuation);
    }

    @l
    public final Object o(int i10, @k Continuation<? super Boolean> continuation) {
        return c(new ReadingRepository$modifyChargeUser$2(this, i10, null), continuation);
    }

    @l
    public final Object p(@k Map<String, String> map, @k Continuation<? super Bonus> continuation) {
        return c(new ReadingRepository$rtBonus$2(this, map, null), continuation);
    }

    @l
    public final Object q(@k Map<String, String> map, @k Continuation<? super ChapterPrice> continuation) {
        return c(new ReadingRepository$videoBonusComplete$2(this, map, null), continuation);
    }
}
