package vc;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.martian.libugrowth.data.UpgradeInfo;
import com.martian.mibook.data.book.MiBookCommentItemList;
import com.martian.mibook.data.book.MiBookGetCommentByScoreItemList;
import com.martian.mibook.data.book.MiBookGetCommentByTimeItemList;
import com.martian.mibook.data.book.ReadingInfo;
import com.martian.mibook.lib.account.response.AliRechargeOrder;
import com.martian.mibook.lib.account.response.Bonus;
import com.martian.mibook.lib.account.response.BonusPool;
import com.martian.mibook.lib.account.response.BookAdsInfo;
import com.martian.mibook.lib.account.response.BooksUpdateInfo;
import com.martian.mibook.lib.account.response.ChapterPrice;
import com.martian.mibook.lib.account.response.CheckinResult;
import com.martian.mibook.lib.account.response.ExchangeMoney;
import com.martian.mibook.lib.account.response.IntervalBonus;
import com.martian.mibook.lib.account.response.MiRechargeOrder;
import com.martian.mibook.lib.account.response.MiTaskAccount;
import com.martian.mibook.lib.account.response.TYBonus;
import com.martian.mibook.lib.account.response.TYChapterContent;
import com.martian.mibook.lib.account.response.WXRechargeOrder;
import com.martian.mibook.lib.account.response.WithdrawRankList;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.model.data.TYSearchBookList;
import com.martian.mibook.lib.yuewen.response.TYCategoryTagGroup;
import com.martian.mibook.lib.yuewen.response.TYInitialBook;
import com.martian.mibook.lib.yuewen.response.TYInitialBookList;
import com.martian.mibook.lib.yuewen.response.TYSearchRecommedInfo;
import com.martian.mibook.lib.yuewen.response.YWBookMall;
import com.martian.mibook.lib.yuewen.response.YWCategoryBookList;
import com.martian.mibook.lib.yuewen.response.YWChannelBookList;
import com.martian.mibook.lib.yuewen.response.YWFreeTypeList;
import com.martian.mibook.mvvm.net.result.SearchBooksResult;
import com.martian.mibook.mvvm.net.result.TYBookTopUser;
import com.martian.mibook.mvvm.payment.data.VipInfo;
import com.martian.mibook.mvvm.read.comment.CommentDetail;
import com.martian.rpauth.response.MartianRPAccount;
import com.umeng.analytics.pro.bt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import uc.d;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000¨\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J&\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0004H§@¢\u0006\u0004\b\n\u0010\u000bJ,\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00042\u0014\b\u0001\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH§@¢\u0006\u0004\b\u0010\u0010\u0011J.\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00042\u0014\b\u0001\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH§@¢\u0006\u0004\b\u0013\u0010\u0011J.\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00042\u0014\b\u0001\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH§@¢\u0006\u0004\b\u0015\u0010\u0011J,\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00042\b\b\u0001\u0010\u0016\u001a\u00020\u00022\b\b\u0001\u0010\u0018\u001a\u00020\u0017H§@¢\u0006\u0004\b\u001a\u0010\u001bJ*\u0010\u001e\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u00010\u001c0\u00042\b\b\u0001\u0010\u0016\u001a\u00020\u0002H§@¢\u0006\u0004\b\u001e\u0010\bJ,\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00140\u00042\u0014\b\u0001\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH§@¢\u0006\u0004\b\u001f\u0010\u0011J.\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u00042\u0014\b\u0001\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH§@¢\u0006\u0004\b!\u0010\u0011J.\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0\u00042\u0014\b\u0001\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH§@¢\u0006\u0004\b#\u0010\u0011J.\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$0\u00042\u0014\b\u0001\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH§@¢\u0006\u0004\b%\u0010\u0011J\u0018\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0\u0004H§@¢\u0006\u0004\b'\u0010\u000bJ\u0018\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0\u0004H§@¢\u0006\u0004\b)\u0010\u000bJ\u0018\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010*0\u0004H§@¢\u0006\u0004\b+\u0010\u000bJ\u0018\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010*0\u0004H§@¢\u0006\u0004\b,\u0010\u000bJ(\u0010/\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020.\u0018\u00010\u001c0\u00042\b\b\u0001\u0010-\u001a\u00020\rH§@¢\u0006\u0004\b/\u00100J\"\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001020\u00042\b\b\u0001\u00101\u001a\u00020\u0017H§@¢\u0006\u0004\b3\u00104J\"\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00042\b\b\u0001\u00105\u001a\u00020\u0002H§@¢\u0006\u0004\b6\u0010\bJ\u0018\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001070\u0004H§@¢\u0006\u0004\b8\u0010\u000bJ\u0018\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001090\u0004H§@¢\u0006\u0004\b:\u0010\u000bJ\"\u0010<\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00042\b\b\u0001\u0010;\u001a\u00020\u0017H§@¢\u0006\u0004\b<\u00104J0\u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010?0\u00042\n\b\u0001\u0010=\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010>\u001a\u0004\u0018\u00010\u0002H§@¢\u0006\u0004\b@\u0010AJ\u0018\u0010B\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010?0\u0004H§@¢\u0006\u0004\bB\u0010\u000bJ.\u0010E\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010D0\u00042\u0014\b\u0001\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH§@¢\u0006\u0004\bE\u0010\u0011J\u0018\u0010G\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010F0\u0004H§@¢\u0006\u0004\bG\u0010\u000bJ,\u0010K\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010J0\u00042\b\b\u0001\u0010H\u001a\u00020\r2\b\b\u0001\u0010I\u001a\u00020\rH§@¢\u0006\u0004\bK\u0010LJ.\u0010N\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010M0\u00042\u0014\b\u0001\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH§@¢\u0006\u0004\bN\u0010\u0011J.\u0010P\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010O0\u00042\u0014\b\u0001\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH§@¢\u0006\u0004\bP\u0010\u0011J.\u0010R\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010Q0\u00042\u0014\b\u0001\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH§@¢\u0006\u0004\bR\u0010\u0011J4\u0010W\u001a\b\u0012\u0004\u0012\u00020V0\u00042\b\b\u0001\u0010S\u001a\u00020\u00022\b\b\u0001\u0010T\u001a\u00020\u00022\b\b\u0001\u0010U\u001a\u00020\u0002H§@¢\u0006\u0004\bW\u0010XJ,\u0010Z\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010Y0\u00042\b\b\u0001\u0010H\u001a\u00020\r2\b\b\u0001\u0010I\u001a\u00020\rH§@¢\u0006\u0004\bZ\u0010LJ0\u0010\\\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010[0\u00042\u0016\b\u0001\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\r0\fH§@¢\u0006\u0004\b\\\u0010\u0011J,\u0010^\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010]0\u00042\b\b\u0001\u0010H\u001a\u00020\r2\b\b\u0001\u0010I\u001a\u00020\rH§@¢\u0006\u0004\b^\u0010LJ8\u0010a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010`0\u00042\b\b\u0001\u0010H\u001a\u00020\r2\b\b\u0001\u0010I\u001a\u00020\r2\n\b\u0001\u0010_\u001a\u0004\u0018\u00010\rH§@¢\u0006\u0004\ba\u0010bJ\"\u0010d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010c0\u00042\b\b\u0001\u0010\u0016\u001a\u00020\u0002H§@¢\u0006\u0004\bd\u0010\bJ0\u0010f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010e0\u00042\u0016\b\u0001\u0010C\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\r0\fH§@¢\u0006\u0004\bf\u0010\u0011J<\u0010g\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u001c0\u00042\b\b\u0001\u0010\u0016\u001a\u00020\u00022\b\b\u0001\u0010T\u001a\u00020\u00022\b\b\u0001\u0010U\u001a\u00020\u0002H§@¢\u0006\u0004\bg\u0010XJ^\u0010k\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020j\u0018\u00010\u001c0\u00042\b\b\u0001\u0010H\u001a\u00020\r2\b\b\u0001\u0010I\u001a\u00020\r2\b\b\u0001\u0010T\u001a\u00020\u00022\b\b\u0001\u0010U\u001a\u00020\u00022\n\b\u0001\u0010h\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010i\u001a\u0004\u0018\u00010\u0002H§@¢\u0006\u0004\bk\u0010lJP\u0010o\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020n\u0018\u00010\u001c0\u00042\b\b\u0001\u0010H\u001a\u00020\r2\b\b\u0001\u0010I\u001a\u00020\r2\b\b\u0001\u0010m\u001a\u00020\r2\b\b\u0001\u0010T\u001a\u00020\u00022\b\b\u0001\u0010U\u001a\u00020\u0002H§@¢\u0006\u0004\bo\u0010pJ$\u0010s\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010r0\u00042\n\b\u0001\u0010q\u001a\u0004\u0018\u00010\rH§@¢\u0006\u0004\bs\u00100J$\u0010v\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010u0\u00042\n\b\u0001\u0010t\u001a\u0004\u0018\u00010\u0002H§@¢\u0006\u0004\bv\u0010w¨\u0006x"}, d2 = {"Lvc/a;", "", "", "freeType", "Luc/d;", "", "Lcom/martian/mibook/lib/yuewen/response/TYCategoryTagGroup;", "B", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/martian/mibook/lib/yuewen/response/YWFreeTypeList;", "M", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "", "param", "Lcom/martian/mibook/lib/yuewen/response/YWCategoryBookList;", "I", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/martian/mibook/lib/yuewen/response/YWBookMall;", "s", "Lcom/martian/mibook/lib/yuewen/response/YWChannelBookList;", "m", "ctype", "", "newUser", "Lcom/martian/mibook/lib/yuewen/response/TYInitialBookList;", "g", "(IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lcom/martian/mibook/lib/yuewen/response/TYInitialBook;", bt.aJ, "H", "Lcom/martian/mibook/lib/model/data/TYSearchBookList;", "k", "Lcom/martian/mibook/lib/account/response/AliRechargeOrder;", "n", "Lcom/martian/mibook/lib/account/response/WXRechargeOrder;", "a", "Lcom/martian/rpauth/response/MartianRPAccount;", t.f11211k, "Lcom/martian/mibook/lib/account/response/MiTaskAccount;", "C", "Lcom/martian/mibook/lib/account/response/IntervalBonus;", "y", "F", "sourceStrings", "Lcom/martian/mibook/lib/account/response/BooksUpdateInfo;", "J", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "force", "Lcom/martian/libugrowth/data/UpgradeInfo;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "chargeUser", "L", "Lcom/martian/mibook/lib/account/response/BonusPool;", "x", "Lcom/martian/mibook/lib/account/response/CheckinResult;", "D", "enable", "d", "coins", "money", "Lcom/martian/mibook/lib/account/response/ExchangeMoney;", "h", "(Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "N", "params", "Lcom/martian/mibook/lib/account/response/WithdrawRankList;", "G", "Lcom/martian/mibook/lib/account/response/TYBonus;", "j", "sourceName", "sourceId", "Lcom/martian/mibook/data/book/ReadingInfo;", "u", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/martian/mibook/lib/account/response/Bonus;", "i", "Lcom/martian/mibook/data/book/MiBookGetCommentByScoreItemList;", "v", "Lcom/martian/mibook/data/book/MiBookGetCommentByTimeItemList;", "K", "cid", "page", "pageSize", "Lcom/martian/mibook/mvvm/read/comment/CommentDetail;", "f", "(IIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/martian/mibook/lib/account/response/BookAdsInfo;", "o", "Lcom/martian/mibook/lib/account/response/ChapterPrice;", "b", "Lcom/martian/mibook/data/book/MiBookCommentItemList;", "c", "chapterId", "Lcom/martian/mibook/lib/account/response/TYChapterContent;", t.f11204d, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/martian/mibook/lib/yuewen/response/TYSearchRecommedInfo;", e.TAG, "Lcom/martian/mibook/mvvm/net/result/SearchBooksResult;", "q", "O", "seed", com.umeng.ccg.a.f24233j, "Lcom/martian/mibook/mvvm/net/result/TYBookTopUser;", IAdInterListener.AdReqParam.WIDTH, "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/Integer;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cuid", "Lcom/martian/mibook/lib/model/data/TYBookItem;", bt.aO, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "source", "Lcom/martian/mibook/mvvm/payment/data/VipInfo;", ExifInterface.LONGITUDE_EAST, "roid", "Lcom/martian/mibook/lib/account/response/MiRechargeOrder;", "p", "(Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public interface a {
    @FormUrlEncoded
    @POST("upgrade/check")
    @l
    Object A(@Field("force") boolean z10, @k Continuation<? super d<UpgradeInfo>> continuation);

    @GET("authopt/category_tag_list")
    @l
    Object B(@Query("freeType") int i10, @k Continuation<? super d<List<TYCategoryTagGroup>>> continuation);

    @GET("auth/task_account.do")
    @l
    Object C(@k Continuation<? super d<MiTaskAccount>> continuation);

    @GET("auth/bonus_pool/checkin")
    @l
    Object D(@k Continuation<? super d<CheckinResult>> continuation);

    @GET("authopt/vip_info")
    @l
    Object E(@l @Query("source") String str, @k Continuation<? super d<VipInfo>> continuation);

    @GET("auth/interval_bonus.do")
    @l
    Object F(@k Continuation<? super d<IntervalBonus>> continuation);

    @GET("withdraw_rank")
    @l
    Object G(@QueryMap @k Map<String, String> map, @k Continuation<? super d<WithdrawRankList>> continuation);

    @GET("book_mall/book_rank")
    @l
    Object H(@QueryMap @k Map<String, String> map, @k Continuation<? super d<YWChannelBookList>> continuation);

    @GET("ty/search_by_category")
    @l
    Object I(@QueryMap @k Map<String, String> map, @k Continuation<? super d<YWCategoryBookList>> continuation);

    @FormUrlEncoded
    @POST("ty/books/update_info")
    @l
    Object J(@k @Field("sourceStrings") String str, @k Continuation<? super d<List<BooksUpdateInfo>>> continuation);

    @GET("get_comments_by_time.do")
    @l
    Object K(@QueryMap @k Map<String, String> map, @k Continuation<? super d<MiBookGetCommentByTimeItemList>> continuation);

    @FormUrlEncoded
    @POST("auth/account/charge_user")
    @l
    Object L(@Field("chargeUser") int i10, @k Continuation<? super d<Boolean>> continuation);

    @GET("ty/all_categories")
    @l
    Object M(@k Continuation<? super d<YWFreeTypeList>> continuation);

    @GET("auth/grab_fresh_redpaper")
    @l
    Object N(@k Continuation<? super d<ExchangeMoney>> continuation);

    @GET("book_mall/search_tips")
    @l
    Object O(@Query("ctype") int i10, @Query("page") int i11, @Query("pageSize") int i12, @k Continuation<? super d<List<String>>> continuation);

    @GET("auth/wxprepay_recharge")
    @l
    Object a(@QueryMap @k Map<String, String> map, @k Continuation<? super d<WXRechargeOrder>> continuation);

    @GET("auth/ty/vbuy_chapter")
    @l
    Object b(@QueryMap @k Map<String, String> map, @k Continuation<? super d<ChapterPrice>> continuation);

    @GET("get_book_scores_and_top_comments.do")
    @l
    Object c(@k @Query("sourceName") String str, @k @Query("sourceId") String str2, @k Continuation<? super d<MiBookCommentItemList>> continuation);

    @GET("auth/update_checkin_notify")
    @l
    Object d(@Query("enable") boolean z10, @k Continuation<? super d<Boolean>> continuation);

    @GET("authopt/search_recommend")
    @l
    Object e(@Query("ctype") int i10, @k Continuation<? super d<TYSearchRecommedInfo>> continuation);

    @GET("authopt/get_comment_detail.do")
    @l
    Object f(@Query("cid") int i10, @Query("page") int i11, @Query("pageSize") int i12, @k Continuation<? super d<CommentDetail>> continuation);

    @GET("book_mall/initial_books")
    @l
    Object g(@Query("ctype") int i10, @Query("newUser") boolean z10, @k Continuation<? super d<TYInitialBookList>> continuation);

    @GET("auth/exchange_duration.do")
    @l
    Object h(@l @Query("coins") Integer num, @l @Query("money") Integer num2, @k Continuation<? super d<ExchangeMoney>> continuation);

    @GET("auth/v3/rt.do")
    @l
    Object i(@QueryMap @k Map<String, String> map, @k Continuation<? super d<Bonus>> continuation);

    @GET("auth/five_star.do")
    @l
    Object j(@k Continuation<? super d<TYBonus>> continuation);

    @GET("authopt/ty/recommend_books")
    @l
    Object k(@QueryMap @k Map<String, String> map, @k Continuation<? super d<TYSearchBookList>> continuation);

    @GET("authopt/ty/chapter_content")
    @l
    Object l(@k @Query("sourceName") String str, @k @Query("sourceId") String str2, @l @Query("chapterId") String str3, @k Continuation<? super d<TYChapterContent>> continuation);

    @GET("book_mall/channel_books")
    @l
    Object m(@QueryMap @k Map<String, String> map, @k Continuation<? super d<YWChannelBookList>> continuation);

    @GET("auth/apprepay_recharge")
    @l
    Object n(@QueryMap @k Map<String, String> map, @k Continuation<? super d<AliRechargeOrder>> continuation);

    @GET("ty/book_ads")
    @l
    Object o(@k @Query("sourceName") String str, @k @Query("sourceId") String str2, @k Continuation<? super d<BookAdsInfo>> continuation);

    @GET("auth/recharge_order.do")
    @l
    Object p(@l @Query("roid") Integer num, @k Continuation<? super d<MiRechargeOrder>> continuation);

    @GET("authopt/ty/search_books")
    @l
    Object q(@QueryMap @k Map<String, String> map, @k Continuation<? super d<SearchBooksResult>> continuation);

    @GET("auth/account.do")
    @l
    Object r(@k Continuation<? super d<MartianRPAccount>> continuation);

    @GET("authopt/book_mall")
    @l
    Object s(@QueryMap @k Map<String, String> map, @k Continuation<? super d<YWBookMall>> continuation);

    @GET("authopt/get_top_user_books")
    @l
    Object t(@k @Query("sourceName") String str, @k @Query("sourceId") String str2, @k @Query("cuid") String str3, @Query("page") int i10, @Query("pageSize") int i11, @k Continuation<? super d<List<TYBookItem>>> continuation);

    @GET("ty/reader_book")
    @l
    Object u(@k @Query("sourceName") String str, @k @Query("sourceId") String str2, @k Continuation<? super d<ReadingInfo>> continuation);

    @GET("get_comments_by_score.do")
    @l
    Object v(@QueryMap @k Map<String, String> map, @k Continuation<? super d<MiBookGetCommentByScoreItemList>> continuation);

    @GET("authopt/get_book_top_users")
    @l
    Object w(@k @Query("sourceName") String str, @k @Query("sourceId") String str2, @Query("page") int i10, @Query("pageSize") int i11, @l @Query("seed") Integer num, @l @Query("scene") Integer num2, @k Continuation<? super d<List<TYBookTopUser>>> continuation);

    @GET("authopt/bonus_pool")
    @l
    Object x(@k Continuation<? super d<BonusPool>> continuation);

    @GET("auth/acquire_interval_bonus.do")
    @l
    Object y(@k Continuation<? super d<IntervalBonus>> continuation);

    @GET("authopt/get_promote_book")
    @l
    Object z(@Query("ctype") int i10, @k Continuation<? super d<List<TYInitialBook>>> continuation);
}
