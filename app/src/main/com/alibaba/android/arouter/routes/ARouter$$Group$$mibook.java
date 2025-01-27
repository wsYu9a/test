package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.martian.mibook.mvvm.book.activity.BookDetailActivity;
import com.martian.mibook.mvvm.book.activity.SearchBookActivity;
import com.martian.mibook.mvvm.category.activity.BookCategoryActivity;
import com.martian.mibook.mvvm.home.activity.HomeActivity;
import com.martian.mibook.mvvm.payment.activity.VipPayActivity;
import com.martian.mibook.mvvm.read.activity.BookShelfListActivity;
import com.martian.mibook.mvvm.read.activity.ReadingNewActivity;
import com.martian.mibook.mvvm.read.activity.RecommendBookFriendsActivity;
import com.martian.mibook.mvvm.tts.activity.AudiobookActivity;
import com.martian.mibook.mvvm.tts.activity.TtsOptimizeActivity;
import com.martian.mibook.mvvm.yuewen.activity.BookRankActivity;
import com.martian.mibook.mvvm.yuewen.activity.IncomeActivity;
import com.martian.mibook.mvvm.yuewen.activity.ReadingRecordActivity;
import com.martian.mibook.mvvm.yuewen.activity.SimilarityBookActivity;
import com.martian.mibook.mvvm.yuewen.activity.YWTagsActivity;
import java.util.Map;
import kc.a;

/* loaded from: classes.dex */
public class ARouter$$Group$$mibook implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put(a.f27751g, RouteMeta.build(routeType, AudiobookActivity.class, "/mibook/audiobookactivity", "mibook", null, -1, Integer.MIN_VALUE));
        map.put(a.f27748d, RouteMeta.build(routeType, BookCategoryActivity.class, "/mibook/bookcategoryactivity", "mibook", null, -1, Integer.MIN_VALUE));
        map.put(a.f27755k, RouteMeta.build(routeType, BookDetailActivity.class, "/mibook/bookdetailactivity", "mibook", null, -1, Integer.MIN_VALUE));
        map.put(a.f27749e, RouteMeta.build(routeType, BookRankActivity.class, "/mibook/bookrankactivity", "mibook", null, -1, Integer.MIN_VALUE));
        map.put(a.f27760p, RouteMeta.build(routeType, BookShelfListActivity.class, "/mibook/bookshelflistactivity", "mibook", null, -1, Integer.MIN_VALUE));
        map.put(a.f27761q, RouteMeta.build(routeType, HomeActivity.class, "/mibook/homeactivity", "mibook", null, -1, Integer.MIN_VALUE));
        map.put(a.f27753i, RouteMeta.build(routeType, IncomeActivity.class, "/mibook/incomeactivity", "mibook", null, -1, Integer.MIN_VALUE));
        map.put(a.f27754j, RouteMeta.build(routeType, ReadingNewActivity.class, "/mibook/readingnewactivity", "mibook", null, -1, Integer.MIN_VALUE));
        map.put(a.f27757m, RouteMeta.build(routeType, ReadingRecordActivity.class, "/mibook/readingrecordactivity", "mibook", null, -1, Integer.MIN_VALUE));
        map.put(a.f27759o, RouteMeta.build(routeType, RecommendBookFriendsActivity.class, "/mibook/recommendbookfriendsactivity", "mibook", null, -1, Integer.MIN_VALUE));
        map.put(a.f27756l, RouteMeta.build(routeType, SearchBookActivity.class, "/mibook/searchbookactivity", "mibook", null, -1, Integer.MIN_VALUE));
        map.put(a.f27752h, RouteMeta.build(routeType, SimilarityBookActivity.class, "/mibook/similaritybookactivity", "mibook", null, -1, Integer.MIN_VALUE));
        map.put(a.f27758n, RouteMeta.build(routeType, TtsOptimizeActivity.class, "/mibook/ttsoptimizeactivity", "mibook", null, -1, Integer.MIN_VALUE));
        map.put(a.f27762r, RouteMeta.build(routeType, VipPayActivity.class, "/mibook/vippayactivity", "mibook", null, -1, Integer.MIN_VALUE));
        map.put(a.f27747c, RouteMeta.build(routeType, YWTagsActivity.class, "/mibook/ywtagsactivity", "mibook", null, -1, Integer.MIN_VALUE));
    }
}
