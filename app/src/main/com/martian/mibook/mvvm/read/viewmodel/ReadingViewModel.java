package com.martian.mibook.mvvm.read.viewmodel;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import ba.h;
import ba.m;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p0.bq;
import com.kuaishou.weapon.p0.t;
import com.martian.mibook.application.EventManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.ReadingInstance;
import com.martian.mibook.data.RecordReadType;
import com.martian.mibook.data.book.ReadingInfo;
import com.martian.mibook.data.theme.MiReadingTheme;
import com.martian.mibook.lib.account.response.Bonus;
import com.martian.mibook.lib.account.response.ChapterPrice;
import com.martian.mibook.lib.model.data.BookWrapper;
import com.martian.mibook.lib.model.data.MiBookMark;
import com.martian.mibook.lib.model.data.MiReadingRecord;
import com.martian.mibook.lib.model.data.Source;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import com.martian.mibook.lib.yuewen.response.YWChapter;
import com.martian.mibook.mvvm.base.BaseViewModel;
import com.martian.mibook.mvvm.base.SingleLiveEvent;
import com.martian.mibook.mvvm.book.viewmodel.BookInfo;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.net.ErrorResult;
import com.martian.mibook.mvvm.net.request.GetCommentByScoreParams;
import com.martian.mibook.mvvm.net.result.TYBookTopUser;
import com.martian.mibook.mvvm.read.comment.Comment;
import com.martian.mibook.mvvm.read.repository.ReadingRepository;
import com.martian.mibook.mvvm.tts.NonStickyLiveData;
import com.martian.mibook.mvvm.tts.TTSReadManager;
import com.martian.mibook.mvvm.tts.service.BaseReadAloudService;
import com.martian.mibook.mvvm.utils.coroutine.Coroutine;
import com.martian.rpauth.MartianRPUserManager;
import com.sigmob.sdk.base.mta.PointCategory;
import com.umeng.analytics.pro.bt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import l9.t0;
import xi.k;
import xi.l;
import ya.b1;

@Metadata(d1 = {"\u0000\u0088\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002Û\u0003B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ5\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0012\u0010\u0004J\u0019\u0010\u0015\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0017\u0010\u0004J\u0017\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0006\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u001f\u0010 JC\u0010$\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\"2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b$\u0010%Ja\u0010-\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00052\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010)\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\b\u0010*\u001a\u0004\u0018\u00010&2\b\u0010+\u001a\u0004\u0018\u00010&2\b\u0010,\u001a\u0004\u0018\u00010&¢\u0006\u0004\b-\u0010.J\r\u0010/\u001a\u00020\n¢\u0006\u0004\b/\u00100J\r\u00101\u001a\u00020\u0007¢\u0006\u0004\b1\u0010\u0004J\r\u00102\u001a\u00020\u0007¢\u0006\u0004\b2\u0010\u0004J\r\u00103\u001a\u00020\u0007¢\u0006\u0004\b3\u0010\u0004J\r\u00104\u001a\u00020\u0007¢\u0006\u0004\b4\u0010\u0004J!\u00107\u001a\u00020\u00072\b\u00105\u001a\u0004\u0018\u00010&2\b\u00106\u001a\u0004\u0018\u00010&¢\u0006\u0004\b7\u00108J\u001d\u0010:\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u001b2\u0006\u00109\u001a\u00020\f¢\u0006\u0004\b:\u0010;J\r\u0010<\u001a\u00020\n¢\u0006\u0004\b<\u00100J\r\u0010=\u001a\u00020\u0007¢\u0006\u0004\b=\u0010\u0004JE\u0010D\u001a\u0004\u0018\u00010C2\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010?\u001a\u0004\u0018\u00010>2\u0006\u0010\r\u001a\u00020\f2\b\u0010@\u001a\u0004\u0018\u00010&2\u0006\u0010A\u001a\u00020\f2\u0006\u0010B\u001a\u00020\f¢\u0006\u0004\bD\u0010EJ\u0017\u0010G\u001a\u00020\n2\b\u0010F\u001a\u0004\u0018\u00010C¢\u0006\u0004\bG\u0010HJ\r\u0010I\u001a\u00020\u0007¢\u0006\u0004\bI\u0010\u0004J\u0015\u0010J\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0005¢\u0006\u0004\bJ\u0010\tJ)\u0010M\u001a\u00020\u00072\u0006\u0010K\u001a\u00020\f2\b\u0010L\u001a\u0004\u0018\u00010\n2\b\u00105\u001a\u0004\u0018\u00010&¢\u0006\u0004\bM\u0010NJ\r\u0010O\u001a\u00020\n¢\u0006\u0004\bO\u00100J\r\u0010P\u001a\u00020\u0007¢\u0006\u0004\bP\u0010\u0004J\r\u0010Q\u001a\u00020\n¢\u0006\u0004\bQ\u00100J\u0017\u0010R\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\bR\u0010SJ\u0017\u0010T\u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\bT\u0010\tJ\u001f\u0010U\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u001b2\u0006\u0010A\u001a\u00020\f¢\u0006\u0004\bU\u0010;J\r\u0010V\u001a\u00020\u0007¢\u0006\u0004\bV\u0010\u0004J\u0015\u0010X\u001a\u00020\u00072\u0006\u0010W\u001a\u00020\f¢\u0006\u0004\bX\u0010\u001aJ\u001f\u0010Z\u001a\u00020\u00072\u0006\u0010Y\u001a\u00020\f2\b\b\u0002\u0010W\u001a\u00020\f¢\u0006\u0004\bZ\u0010[J\u001f\u0010^\u001a\u00020\u00072\u0006\u0010]\u001a\u00020\\2\b\b\u0002\u0010W\u001a\u00020\f¢\u0006\u0004\b^\u0010_J\r\u0010`\u001a\u00020\u0007¢\u0006\u0004\b`\u0010\u0004J!\u0010c\u001a\u00020\u00072\b\b\u0002\u0010a\u001a\u00020\n2\b\b\u0002\u0010b\u001a\u00020\n¢\u0006\u0004\bc\u0010dJ\r\u0010e\u001a\u00020\n¢\u0006\u0004\be\u00100J\r\u0010f\u001a\u00020\n¢\u0006\u0004\bf\u00100J\u0015\u0010g\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u001b¢\u0006\u0004\bg\u0010SJ\u0017\u0010i\u001a\u00020\u00072\b\b\u0002\u0010h\u001a\u00020\f¢\u0006\u0004\bi\u0010\u001aJ\r\u0010j\u001a\u00020\u0007¢\u0006\u0004\bj\u0010\u0004J\u0015\u0010l\u001a\u00020\u00072\u0006\u0010k\u001a\u00020\n¢\u0006\u0004\bl\u0010mJ\u001d\u0010p\u001a\u00020\u00072\u0006\u0010n\u001a\u00020\n2\u0006\u0010o\u001a\u00020\f¢\u0006\u0004\bp\u0010qJ\u0015\u0010r\u001a\u00020\n2\u0006\u0010o\u001a\u00020\f¢\u0006\u0004\br\u0010sJ\r\u0010t\u001a\u00020\u0007¢\u0006\u0004\bt\u0010\u0004J\r\u0010u\u001a\u00020\u0007¢\u0006\u0004\bu\u0010\u0004J\r\u0010w\u001a\u00020v¢\u0006\u0004\bw\u0010xR$\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\by\u0010z\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R+\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u007f8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0080\u0001\u0010\u0081\u0001\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001R+\u0010\u008d\u0001\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0087\u0001\u0010\u0088\u0001\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R*\u0010(\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008e\u0001\u0010\u0088\u0001\u001a\u0006\b\u008f\u0001\u0010\u008a\u0001\"\u0006\b\u0090\u0001\u0010\u008c\u0001R*\u0010'\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0091\u0001\u0010\u0088\u0001\u001a\u0006\b\u0092\u0001\u0010\u008a\u0001\"\u0006\b\u0093\u0001\u0010\u008c\u0001R,\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u0094\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0095\u0001\u0010\u0096\u0001\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001\"\u0006\b\u0099\u0001\u0010\u009a\u0001R,\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u0094\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009c\u0001\u0010\u0096\u0001\u001a\u0006\b\u009d\u0001\u0010\u0098\u0001\"\u0006\b\u009e\u0001\u0010\u009a\u0001R,\u0010§\u0001\u001a\u0005\u0018\u00010 \u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¡\u0001\u0010¢\u0001\u001a\u0006\b£\u0001\u0010¤\u0001\"\u0006\b¥\u0001\u0010¦\u0001R3\u0010°\u0001\u001a\f\u0012\u0005\u0012\u00030©\u0001\u0018\u00010¨\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bª\u0001\u0010«\u0001\u001a\u0006\b¬\u0001\u0010\u00ad\u0001\"\u0006\b®\u0001\u0010¯\u0001R'\u0010µ\u0001\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\b±\u0001\u0010²\u0001\u001a\u0005\b³\u0001\u00100\"\u0005\b´\u0001\u0010mR(\u0010»\u0001\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b¶\u0001\u0010·\u0001\u001a\u0006\b¸\u0001\u0010¹\u0001\"\u0005\bº\u0001\u0010\u001aR'\u0010¿\u0001\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\b¼\u0001\u0010²\u0001\u001a\u0005\b½\u0001\u00100\"\u0005\b¾\u0001\u0010mR'\u0010Ã\u0001\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\bÀ\u0001\u0010²\u0001\u001a\u0005\bÁ\u0001\u00100\"\u0005\bÂ\u0001\u0010mR(\u0010Ç\u0001\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\bÄ\u0001\u0010·\u0001\u001a\u0006\bÅ\u0001\u0010¹\u0001\"\u0005\bÆ\u0001\u0010\u001aR'\u0010Ë\u0001\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\bÈ\u0001\u0010²\u0001\u001a\u0005\bÉ\u0001\u00100\"\u0005\bÊ\u0001\u0010mR'\u0010Ï\u0001\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\bÌ\u0001\u0010²\u0001\u001a\u0005\bÍ\u0001\u00100\"\u0005\bÎ\u0001\u0010mR'\u0010Ó\u0001\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\bÐ\u0001\u0010²\u0001\u001a\u0005\bÑ\u0001\u00100\"\u0005\bÒ\u0001\u0010mR(\u0010×\u0001\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\bÔ\u0001\u0010·\u0001\u001a\u0006\bÕ\u0001\u0010¹\u0001\"\u0005\bÖ\u0001\u0010\u001aR,\u0010ß\u0001\u001a\u0005\u0018\u00010Ø\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÙ\u0001\u0010Ú\u0001\u001a\u0006\bÛ\u0001\u0010Ü\u0001\"\u0006\bÝ\u0001\u0010Þ\u0001R+\u0010ã\u0001\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bà\u0001\u0010\u0088\u0001\u001a\u0006\bá\u0001\u0010\u008a\u0001\"\u0006\bâ\u0001\u0010\u008c\u0001R'\u0010ç\u0001\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\bä\u0001\u0010²\u0001\u001a\u0005\bå\u0001\u00100\"\u0005\bæ\u0001\u0010mR'\u0010ë\u0001\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\bè\u0001\u0010²\u0001\u001a\u0005\bé\u0001\u00100\"\u0005\bê\u0001\u0010mR'\u0010ï\u0001\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\bì\u0001\u0010²\u0001\u001a\u0005\bí\u0001\u00100\"\u0005\bî\u0001\u0010mR'\u0010ó\u0001\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\bð\u0001\u0010²\u0001\u001a\u0005\bñ\u0001\u00100\"\u0005\bò\u0001\u0010mR'\u0010÷\u0001\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\bô\u0001\u0010²\u0001\u001a\u0005\bõ\u0001\u00100\"\u0005\bö\u0001\u0010mR(\u0010û\u0001\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\bø\u0001\u0010·\u0001\u001a\u0006\bù\u0001\u0010¹\u0001\"\u0005\bú\u0001\u0010\u001aR'\u0010ÿ\u0001\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\bü\u0001\u0010²\u0001\u001a\u0005\bý\u0001\u00100\"\u0005\bþ\u0001\u0010mR'\u0010\u0082\u0002\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\b·\u0001\u0010²\u0001\u001a\u0005\b\u0080\u0002\u00100\"\u0005\b\u0081\u0002\u0010mR\u001a\u0010\u0085\u0002\u001a\u00030\u0083\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0002\u0010\u0084\u0002R(\u0010\u0089\u0002\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b\u0086\u0002\u0010·\u0001\u001a\u0006\b\u0087\u0002\u0010¹\u0001\"\u0005\b\u0088\u0002\u0010\u001aR(\u0010\u008d\u0002\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b\u008a\u0002\u0010·\u0001\u001a\u0006\b\u008b\u0002\u0010¹\u0001\"\u0005\b\u008c\u0002\u0010\u001aR\u001f\u0010\u0090\u0002\u001a\u00020\f8\u0006X\u0086D¢\u0006\u0010\n\u0006\b\u008e\u0002\u0010·\u0001\u001a\u0006\b\u008f\u0002\u0010¹\u0001R(\u0010\u0094\u0002\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b\u0091\u0002\u0010·\u0001\u001a\u0006\b\u0092\u0002\u0010¹\u0001\"\u0005\b\u0093\u0002\u0010\u001aR&\u0010\u0097\u0002\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bD\u0010²\u0001\u001a\u0005\b\u0095\u0002\u00100\"\u0005\b\u0096\u0002\u0010mR\u0018\u0010\u0098\u0002\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b4\u0010²\u0001R*\u0010\u009b\u0002\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u0015\u0010\u0088\u0001\u001a\u0006\b\u0099\u0002\u0010\u008a\u0001\"\u0006\b\u009a\u0002\u0010\u008c\u0001R.\u0010\u009d\u0002\u001a\u0018\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\f0\u009c\u0002\u0018\u00010¨\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bT\u0010«\u0001R\u0018\u0010\u009e\u0002\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bR\u0010·\u0001R&\u0010¡\u0002\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0012\u0010²\u0001\u001a\u0005\b\u009f\u0002\u00100\"\u0005\b \u0002\u0010mR&\u0010¤\u0002\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bf\u0010²\u0001\u001a\u0005\b¢\u0002\u00100\"\u0005\b£\u0002\u0010mR&\u0010¦\u0002\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bG\u0010²\u0001\u001a\u0005\b²\u0001\u00100\"\u0005\b¥\u0002\u0010mR'\u0010©\u0002\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b3\u0010·\u0001\u001a\u0006\b§\u0002\u0010¹\u0001\"\u0005\b¨\u0002\u0010\u001aR\u0018\u0010ª\u0002\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b:\u0010·\u0001R(\u0010\u00ad\u0002\u001a\u00020\f8F@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b¢\u0002\u0010·\u0001\u001a\u0006\b«\u0002\u0010¹\u0001\"\u0005\b¬\u0002\u0010\u001aR'\u0010°\u0002\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\b²\u0001\u0010²\u0001\u001a\u0005\b®\u0002\u00100\"\u0005\b¯\u0002\u0010mR)\u0010·\u0002\u001a\u00030±\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b{\u0010²\u0002\u001a\u0006\b³\u0002\u0010´\u0002\"\u0006\bµ\u0002\u0010¶\u0002R8\u0010¾\u0002\u001a\u0012\u0012\u0004\u0012\u00020&\u0012\u0005\u0012\u00030\u0083\u0002\u0018\u00010¸\u00028F@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b2\u0010¹\u0002\u001a\u0006\bº\u0002\u0010»\u0002\"\u0006\b¼\u0002\u0010½\u0002R*\u0010+\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b³\u0001\u0010\u0088\u0001\u001a\u0006\b¿\u0002\u0010\u008a\u0001\"\u0006\bÀ\u0002\u0010\u008c\u0001R)\u0010,\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b=\u0010\u0088\u0001\u001a\u0006\bÁ\u0002\u0010\u008a\u0001\"\u0006\bÂ\u0002\u0010\u008c\u0001R\u001a\u0010*\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÃ\u0002\u0010\u0088\u0001R\u0019\u0010Ä\u0002\u001a\u00030\u0083\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bc\u0010\u0084\u0002R'\u0010È\u0002\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\bÅ\u0002\u0010²\u0001\u001a\u0005\bÆ\u0002\u00100\"\u0005\bÇ\u0002\u0010mR'\u0010Ì\u0002\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\bÉ\u0002\u0010²\u0001\u001a\u0005\bÊ\u0002\u00100\"\u0005\bË\u0002\u0010mR(\u0010Ð\u0002\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\bÍ\u0002\u0010·\u0001\u001a\u0006\bÎ\u0002\u0010¹\u0001\"\u0005\bÏ\u0002\u0010\u001aR3\u0010Õ\u0002\u001a\f\u0012\u0005\u0012\u00030Ñ\u0002\u0018\u00010¨\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÒ\u0002\u0010«\u0001\u001a\u0006\bÓ\u0002\u0010\u00ad\u0001\"\u0006\bÔ\u0002\u0010¯\u0001R\u0019\u0010×\u0002\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÖ\u0002\u0010·\u0001R,\u0010ß\u0002\u001a\u0005\u0018\u00010Ø\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÙ\u0002\u0010Ú\u0002\u001a\u0006\bÛ\u0002\u0010Ü\u0002\"\u0006\bÝ\u0002\u0010Þ\u0002R\u001a\u0010à\u0002\u001a\u00030\u0083\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bº\u0002\u0010\u0084\u0002R3\u0010å\u0002\u001a\f\u0012\u0005\u0012\u00030Ñ\u0002\u0018\u00010á\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bâ\u0002\u0010«\u0001\u001a\u0006\bã\u0002\u0010\u00ad\u0001\"\u0006\bä\u0002\u0010¯\u0001R*\u0010ê\u0002\u001a\u00030\u0083\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0097\u0001\u0010\u0084\u0002\u001a\u0006\bæ\u0002\u0010ç\u0002\"\u0006\bè\u0002\u0010é\u0002R'\u0010í\u0002\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\b¸\u0001\u0010²\u0001\u001a\u0005\bë\u0002\u00100\"\u0005\bì\u0002\u0010mR'\u0010ð\u0002\u001a\u0012\u0012\r\u0012\u000b\u0012\u0004\u0012\u00020C\u0018\u00010¨\u00010î\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÊ\u0002\u0010ï\u0002R,\u0010ó\u0002\u001a\u0012\u0012\r\u0012\u000b\u0012\u0004\u0012\u00020C\u0018\u00010¨\u00010î\u00028\u0006¢\u0006\u0010\n\u0006\bÛ\u0001\u0010ï\u0002\u001a\u0006\bñ\u0002\u0010ò\u0002R!\u0010ô\u0002\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010 \u00010î\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b®\u0002\u0010ï\u0002R%\u0010ö\u0002\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010 \u00010î\u00028\u0006¢\u0006\u000f\n\u0005\bX\u0010ï\u0002\u001a\u0006\bõ\u0002\u0010ò\u0002R!\u0010ø\u0002\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010÷\u00020î\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÆ\u0002\u0010ï\u0002R&\u0010ú\u0002\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010÷\u00020î\u00028\u0006¢\u0006\u0010\n\u0006\b\u008f\u0002\u0010ï\u0002\u001a\u0006\bù\u0002\u0010ò\u0002R\u001d\u0010û\u0002\u001a\t\u0012\u0004\u0012\u00020\f0î\u00028\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b^\u0010ï\u0002R#\u0010þ\u0002\u001a\t\u0012\u0004\u0012\u00020\f0î\u00028\u0006¢\u0006\u0010\n\u0006\bü\u0002\u0010ï\u0002\u001a\u0006\bý\u0002\u0010ò\u0002R(\u0010ÿ\u0002\u001a\u0013\u0012\u000e\u0012\f\u0012\u0005\u0012\u00030Ñ\u0002\u0018\u00010á\u00020î\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¬\u0001\u0010ï\u0002R-\u0010\u0081\u0003\u001a\u0013\u0012\u000e\u0012\f\u0012\u0005\u0012\u00030Ñ\u0002\u0018\u00010á\u00020î\u00028\u0006¢\u0006\u0010\n\u0006\b§\u0002\u0010ï\u0002\u001a\u0006\b\u0080\u0003\u0010ò\u0002R'\u0010\u0082\u0003\u001a\u0013\u0012\u000e\u0012\f\u0012\u0005\u0012\u00030Ñ\u0002\u0018\u00010á\u00020î\u00028\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bZ\u0010ï\u0002R-\u0010\u0085\u0003\u001a\u0013\u0012\u000e\u0012\f\u0012\u0005\u0012\u00030Ñ\u0002\u0018\u00010á\u00020î\u00028\u0006¢\u0006\u0010\n\u0006\b\u0083\u0003\u0010ï\u0002\u001a\u0006\b\u0084\u0003\u0010ò\u0002R\u001e\u0010\u0086\u0003\u001a\t\u0012\u0004\u0012\u00020\"0î\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bã\u0002\u0010ï\u0002R#\u0010\u0088\u0003\u001a\t\u0012\u0004\u0012\u00020\"0î\u00028\u0006¢\u0006\u0010\n\u0006\bæ\u0002\u0010ï\u0002\u001a\u0006\b\u0087\u0003\u0010ò\u0002R!\u0010\u0089\u0003\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010÷\u00020î\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÎ\u0002\u0010ï\u0002R&\u0010\u008b\u0003\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010÷\u00020î\u00028\u0006¢\u0006\u0010\n\u0006\b\u009d\u0001\u0010ï\u0002\u001a\u0006\b\u008a\u0003\u0010ò\u0002R!\u0010\u008d\u0003\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010 \u00010î\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008c\u0003\u0010ï\u0002R&\u0010\u008f\u0003\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010 \u00010î\u00028\u0006¢\u0006\u0010\n\u0006\b\u008e\u0003\u0010ï\u0002\u001a\u0006\b\u008e\u0003\u0010ò\u0002R!\u0010\u0090\u0003\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u0094\u00010î\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bý\u0002\u0010ï\u0002R&\u0010\u0093\u0003\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u0094\u00010î\u00028\u0006¢\u0006\u0010\n\u0006\b\u0091\u0003\u0010ï\u0002\u001a\u0006\b\u0092\u0003\u0010ò\u0002R!\u0010\u0095\u0003\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u0094\u00010î\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0094\u0003\u0010ï\u0002R&\u0010\u0096\u0003\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u0094\u00010î\u00028\u0006¢\u0006\u0010\n\u0006\b\u0080\u0003\u0010ï\u0002\u001a\u0006\b\u008c\u0003\u0010ò\u0002R!\u0010\u0099\u0003\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u0097\u00030î\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0098\u0003\u0010ï\u0002R&\u0010\u009c\u0003\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u0097\u00030î\u00028\u0006¢\u0006\u0010\n\u0006\b\u009a\u0003\u0010ï\u0002\u001a\u0006\b\u009b\u0003\u0010ò\u0002R\u001f\u0010\u009e\u0003\u001a\n\u0012\u0005\u0012\u00030÷\u00020î\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009d\u0003\u0010ï\u0002R$\u0010 \u0003\u001a\n\u0012\u0005\u0012\u00030÷\u00020î\u00028\u0006¢\u0006\u0010\n\u0006\b\u0084\u0003\u0010ï\u0002\u001a\u0006\b\u009f\u0003\u0010ò\u0002R \u0010¡\u0003\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\n0î\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008a\u0003\u0010ï\u0002R%\u0010¢\u0003\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\n0î\u00028\u0006¢\u0006\u0010\n\u0006\b\u0087\u0003\u0010ï\u0002\u001a\u0006\b\u0098\u0003\u0010ò\u0002R\u001e\u0010£\u0003\u001a\t\u0012\u0004\u0012\u00020\f0î\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0092\u0003\u0010ï\u0002R#\u0010¥\u0003\u001a\t\u0012\u0004\u0012\u00020\f0î\u00028\u0006¢\u0006\u0010\n\u0006\bñ\u0002\u0010ï\u0002\u001a\u0006\b¤\u0003\u0010ò\u0002R!\u0010ª\u0003\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010§\u00030¦\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¨\u0003\u0010©\u0003R&\u0010\u00ad\u0003\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010§\u00030¦\u00038\u0006¢\u0006\u0010\n\u0006\b¤\u0003\u0010©\u0003\u001a\u0006\b«\u0003\u0010¬\u0003R\u001e\u0010±\u0003\u001a\t\u0012\u0004\u0012\u00020\f0®\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¯\u0003\u0010°\u0003R#\u0010³\u0003\u001a\t\u0012\u0004\u0012\u00020\f0®\u00038\u0006¢\u0006\u0010\n\u0006\bù\u0002\u0010°\u0003\u001a\u0006\b¨\u0003\u0010²\u0003R(\u0010´\u0003\u001a\u0013\u0012\u000e\u0012\f\u0012\u0005\u0012\u00030©\u0001\u0018\u00010á\u00020î\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bõ\u0002\u0010ï\u0002R-\u0010¶\u0003\u001a\u0013\u0012\u000e\u0012\f\u0012\u0005\u0012\u00030©\u0001\u0018\u00010á\u00020î\u00028\u0006¢\u0006\u0010\n\u0006\bµ\u0003\u0010ï\u0002\u001a\u0006\b\u009a\u0003\u0010ò\u0002R#\u0010·\u0003\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010Ø\u00020î\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0003\u0010ï\u0002R&\u0010¹\u0003\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010Ø\u00020î\u00028\u0006¢\u0006\u0010\n\u0006\b¸\u0003\u0010ï\u0002\u001a\u0006\b\u0094\u0003\u0010ò\u0002R#\u0010º\u0003\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010Ø\u00020î\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009f\u0003\u0010ï\u0002R&\u0010»\u0003\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010Ø\u00020î\u00028\u0006¢\u0006\u0010\n\u0006\b\u009b\u0003\u0010ï\u0002\u001a\u0006\b\u009d\u0003\u0010ò\u0002R\"\u0010¼\u0003\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00070î\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bá\u0001\u0010ï\u0002R$\u0010½\u0003\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00070î\u00028\u0006¢\u0006\u000f\n\u0005\b\u001d\u0010ï\u0002\u001a\u0006\bµ\u0003\u0010ò\u0002R\u001f\u0010¾\u0003\u001a\t\u0012\u0004\u0012\u00020\n0î\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bu\u0010ï\u0002R#\u0010¿\u0003\u001a\t\u0012\u0004\u0012\u00020\n0î\u00028\u0006¢\u0006\u0010\n\u0006\bñ\u0001\u0010ï\u0002\u001a\u0006\b\u0091\u0003\u0010ò\u0002R \u0010À\u0003\u001a\t\u0012\u0004\u0012\u00020\f0î\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bõ\u0001\u0010ï\u0002R#\u0010Á\u0003\u001a\t\u0012\u0004\u0012\u00020\f0î\u00028\u0006¢\u0006\u0010\n\u0006\bí\u0001\u0010ï\u0002\u001a\u0006\b¯\u0003\u0010ò\u0002R+\u0010Ã\u0003\u001a\u0004\u0018\u00010&8F@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bé\u0001\u0010\u0088\u0001\u001a\u0006\bÃ\u0002\u0010\u008a\u0001\"\u0006\bÂ\u0003\u0010\u008c\u0001R/\u0010\r\u001a\u00020\f2\u0006\u0010h\u001a\u00020\f8\u0006@FX\u0086\u000e¢\u0006\u0017\n\u0006\b\u008b\u0002\u0010·\u0001\u001a\u0006\bâ\u0002\u0010¹\u0001\"\u0005\bÄ\u0003\u0010\u001aR\u001b\u0010Æ\u0003\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÕ\u0001\u0010Å\u0003R'\u0010È\u0003\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\br\u0010·\u0001\u001a\u0006\bÉ\u0002\u0010¹\u0001\"\u0005\bÇ\u0003\u0010\u001aR)\u0010Î\u0003\u001a\u00030É\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bI\u0010Ê\u0003\u001a\u0006\bÙ\u0002\u0010Ë\u0003\"\u0006\bÌ\u0003\u0010Í\u0003R(\u0010Ð\u0003\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b\u0099\u0002\u0010·\u0001\u001a\u0006\bÖ\u0002\u0010¹\u0001\"\u0005\bÏ\u0003\u0010\u001aR(\u0010Ò\u0003\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b£\u0001\u0010·\u0001\u001a\u0006\bÍ\u0002\u0010¹\u0001\"\u0005\bÑ\u0003\u0010\u001aR+\u0010Ô\u0003\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bù\u0001\u0010\u0088\u0001\u001a\u0006\bÒ\u0002\u0010\u008a\u0001\"\u0006\bÓ\u0003\u0010\u008c\u0001R\u001d\u0010Õ\u0003\u001a\t\u0012\u0004\u0012\u00020\f0î\u00028\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0010\u0010ï\u0002R#\u0010Ö\u0003\u001a\t\u0012\u0004\u0012\u00020\f0î\u00028\u0006¢\u0006\u0010\n\u0006\b¿\u0002\u0010ï\u0002\u001a\u0006\b¸\u0003\u0010ò\u0002R\u0013\u0010Ø\u0003\u001a\u00020\n8F¢\u0006\u0007\u001a\u0005\b×\u0003\u00100R\u0013\u0010Ú\u0003\u001a\u00020\n8F¢\u0006\u0007\u001a\u0005\bÙ\u0003\u00100¨\u0006Ü\u0003"}, d2 = {"Lcom/martian/mibook/mvvm/read/viewmodel/ReadingViewModel;", "Lcom/martian/mibook/mvvm/base/BaseViewModel;", "Lcom/martian/mibook/mvvm/read/repository/ReadingRepository;", "<init>", "()V", "Landroid/app/Activity;", com.umeng.analytics.pro.f.X, "", "M1", "(Landroid/app/Activity;)V", "", "recordFirst", "", BaseReadAloudService.f15168x, "contentIndex", "contentLength", "s1", "(ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/martian/mibook/mvvm/read/viewmodel/ReadingViewModel$a;", "loadBookCallback", "Q", "(Lcom/martian/mibook/mvvm/read/viewmodel/ReadingViewModel$a;)V", "i2", "seconds", "y3", "(I)V", "Landroid/content/Context;", "Lya/b1$b;", "f1", "(Landroid/content/Context;)Lya/b1$b;", "L1", "()Lcom/martian/mibook/mvvm/read/repository/ReadingRepository;", TTDownloadField.TT_ACTIVITY, "Lcom/martian/mibook/lib/model/data/abs/Book;", "book", "N1", "(Landroid/app/Activity;Lcom/martian/mibook/lib/model/data/abs/Book;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Z)V", "", "sourceId", "sourceName", BaseReadAloudService.f15169y, "recContext", "recommend", "recommendId", "O1", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "S1", "()Z", "b2", "b0", ExifInterface.LONGITUDE_WEST, "P", "chapterId", "chapterName", "z3", "(Ljava/lang/String;Ljava/lang/String;)V", "chargeUser", "X", "(Landroid/content/Context;I)V", "Z1", "d0", "Lcom/martian/mibook/lib/model/data/abs/Chapter;", "chapter", "summary", "start", PointCategory.END, "Lcom/martian/mibook/lib/model/data/MiBookMark;", "O", "(Lcom/martian/mibook/lib/model/data/abs/Book;Lcom/martian/mibook/lib/model/data/abs/Chapter;ILjava/lang/String;II)Lcom/martian/mibook/lib/model/data/MiBookMark;", "bookMark", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Lcom/martian/mibook/lib/model/data/MiBookMark;)Z", "o1", "h2", "duration", "isVipChapter", "k2", "(ILjava/lang/Boolean;Ljava/lang/String;)V", "R1", "C2", "P1", ExifInterface.LATITUDE_SOUTH, "(Landroid/content/Context;)Z", "R", "v3", "x3", "pageSize", "t0", "pageIndex", "A0", "(II)V", "Lcom/martian/mibook/mvvm/net/request/GetCommentByScoreParams;", "params", "w0", "(Lcom/martian/mibook/mvvm/net/request/GetCommentByScoreParams;I)V", "l2", "isDialog", "manual", "f0", "(ZZ)V", "c2", "U", "u3", "value", "e2", "g2", "hasBookMark", "d2", "(Z)V", "isOr", id.c.f26972i, "U2", "(ZI)V", "n1", "(I)Z", "j2", "g1", "Lcom/martian/mibook/mvvm/book/viewmodel/BookInfo;", "w3", "()Lcom/martian/mibook/mvvm/book/viewmodel/BookInfo;", "h", "Lcom/martian/mibook/lib/model/data/abs/Book;", "a0", "()Lcom/martian/mibook/lib/model/data/abs/Book;", "o2", "(Lcom/martian/mibook/lib/model/data/abs/Book;)V", "Lcom/martian/mibook/lib/model/data/MiReadingRecord;", "i", "Lcom/martian/mibook/lib/model/data/MiReadingRecord;", "w1", "()Lcom/martian/mibook/lib/model/data/MiReadingRecord;", "b3", "(Lcom/martian/mibook/lib/model/data/MiReadingRecord;)V", "record", "j", "Ljava/lang/String;", "E1", "()Ljava/lang/String;", "m3", "(Ljava/lang/String;)V", "sourceString", "k", "D1", "l3", t.f11204d, "C1", "k3", "Lcom/martian/mibook/lib/model/data/abs/ChapterList;", "m", "Lcom/martian/mibook/lib/model/data/abs/ChapterList;", "o0", "()Lcom/martian/mibook/lib/model/data/abs/ChapterList;", "y2", "(Lcom/martian/mibook/lib/model/data/abs/ChapterList;)V", "chapterList", "n", "F0", "L2", "localChapterList", "Lcom/martian/mibook/data/book/ReadingInfo;", "o", "Lcom/martian/mibook/data/book/ReadingInfo;", "q1", "()Lcom/martian/mibook/data/book/ReadingInfo;", "W2", "(Lcom/martian/mibook/data/book/ReadingInfo;)V", "readingInfo", "", "Lcom/martian/mibook/mvvm/read/comment/Comment;", "p", "Ljava/util/List;", "y0", "()Ljava/util/List;", "G2", "(Ljava/util/List;)V", "hotComments", "q", "Z", "c0", "p2", "bookInfoUpdated", t.f11211k, "I", bq.f10843g, "()I", "z2", "chapterListRetry", "s", "y1", "d3", "resetPageContent", bt.aO, "V1", "N2", "isPortrait", "u", "F1", "n3", "statusBarMode", "v", "W1", "e3", "isScrollMode", IAdInterListener.AdReqParam.WIDTH, "A1", "i3", "showChapterComment", "x", "z1", "h3", "showBookComment", "y", "m1", "T2", "pullDownMarkFlag", "Lcom/martian/mibook/data/theme/MiReadingTheme;", bt.aJ, "Lcom/martian/mibook/data/theme/MiReadingTheme;", "r0", "()Lcom/martian/mibook/data/theme/MiReadingTheme;", "B2", "(Lcom/martian/mibook/data/theme/MiReadingTheme;)V", "customTheme", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "e1", "M2", "notificationStatus", "B", "B1", "j3", "showFloatItems", "C", "k1", "R2", "prefShowFloatMenu", "D", "j1", "Q2", "prefShowFloatBonus", ExifInterface.LONGITUDE_EAST, "h1", "O2", "prefShowBottomStatus", "F", "i1", "P2", "prefShowBottomTips", "G", "r1", "X2", "readingNotchHeight", "H", "X1", "f3", "isSelfTriggeredRefreshTheme", "Y1", "g3", "isSelfTriggeredRefreshTypeface", "", "J", "lastScrollTime", "K", "H1", "p3", "totalSeconds", "L", "l1", "S2", "processSeconds", "M", "v0", "fullSeconds", "N", "G1", "o3", "totalCoins", "Q1", "E2", "isFreshUserFirstIn", "rTing", "p1", "V2", "readingHint", "Lkotlin/Pair;", "readingHintsWithWeights", "hintsTotalWeight", "a2", "s3", "isVip", "Y", "m2", "adBook", "n2", "adHiding", "z0", "H2", "interstitialInterval", "interstitialMinutes", "J1", "r3", "videoUnlockChapterIndex", "s0", "D2", "enableBaeAdInfo", "Lcom/martian/mibook/data/RecordReadType;", "Lcom/martian/mibook/data/RecordReadType;", "x1", "()Lcom/martian/mibook/data/RecordReadType;", "c3", "(Lcom/martian/mibook/data/RecordReadType;)V", "recordReadType", "", "Ljava/util/Map;", "m0", "()Ljava/util/Map;", "w2", "(Ljava/util/Map;)V", "chapterIdInfos", "t1", "Y2", r3.c.f30241d, "a3", "e0", "timeStamp", "g0", "u0", "F2", "fromIntent", "h0", "q0", "A2", "closeNetworkOffCheck", "i0", "E0", "K2", "loadingCount", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "j0", "u1", "Z2", "recommendBooks", "k0", "recommendBookPage", "Lcom/martian/mibook/mvvm/net/result/TYBookTopUser;", "l0", "Lcom/martian/mibook/mvvm/net/result/TYBookTopUser;", "I1", "()Lcom/martian/mibook/mvvm/net/result/TYBookTopUser;", "q3", "(Lcom/martian/mibook/mvvm/net/result/TYBookTopUser;)V", "tyBookTopUser", "lastBookwormBookRequestTime", "", "n0", "C0", "I2", "lastPageRecommendBooks", "D0", "()J", "J2", "(J)V", "lastPageRecommendBooksRequestTime", "K1", "t3", "waitForFreeReadWithAd", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/MutableLiveData;", "_mMarkListLiveData", "T0", "()Landroidx/lifecycle/MutableLiveData;", "mMarkListLiveData", "_mReadingInfoLiveData", "Y0", "mReadingInfoLiveData", "Lcom/martian/mibook/mvvm/net/ErrorResult;", "_mReadingErrorLiveData", "X0", "mReadingErrorLiveData", "_mChapterIndexLiveData", "x0", "I0", "mChapterIndexLiveData", "_mExitRecommendBookListLiveData", "L0", "mExitRecommendBookListLiveData", "_mLastPageRecommendBookListLiveData", "B0", "P0", "mLastPageRecommendBookListLiveData", "_mLoadBookLiveData", "R0", "mLoadBookLiveData", "_mLoadBookErrorLiveData", "Q0", "mLoadBookErrorLiveData", "G0", "_mBookScoresAndTopCommentsLiveData", "H0", "mBookScoresAndTopCommentsLiveData", "_mLocalChapterListLiveData", "J0", "S0", "mLocalChapterListLiveData", "K0", "_mAsyncChapterListLiveData", "mAsyncChapterListLiveData", "Lcom/martian/mibook/lib/account/response/ChapterPrice;", "M0", "_mVideoBonusCompleteLiveData", "N0", "d1", "mVideoBonusCompleteLiveData", "O0", "_mVideoBonusCompleteErrorLiveData", "c1", "mVideoBonusCompleteErrorLiveData", "_mFreeReadWithAdLiveData", "mFreeReadWithAdLiveData", "_mNumberOfChaptersLiveData", "V0", "mNumberOfChaptersLiveData", "Lcom/martian/mibook/mvvm/base/SingleLiveEvent;", "Lcom/martian/mibook/lib/account/response/Bonus;", "U0", "Lcom/martian/mibook/mvvm/base/SingleLiveEvent;", "_mRtBonusLiveData", "a1", "()Lcom/martian/mibook/mvvm/base/SingleLiveEvent;", "mRtBonusLiveData", "Lcom/martian/mibook/mvvm/tts/NonStickyLiveData;", "W0", "Lcom/martian/mibook/mvvm/tts/NonStickyLiveData;", "_mNotifyRefreshRecommendBookList", "()Lcom/martian/mibook/mvvm/tts/NonStickyLiveData;", "mNotifyRefreshRecommendBookList", "_mHotCommentsLiveData", "Z0", "mHotCommentsLiveData", "_mDialogBookwormLiveData", "b1", "mDialogBookwormLiveData", "_mLastPageBookwormLiveData", "mLastPageBookwormLiveData", "_mRefreshSlideModeLiveData", "mRefreshSlideModeLiveData", "_mCurrentViewBookMarkLiveData", "mCurrentViewBookMarkLiveData", "_mProcessSecondsLiveData", "mProcessSecondsLiveData", "q2", "bookName", "x2", "Lya/b1$b;", "cacheStatusChangedListener", "r2", "cacheIndex", "Lcom/martian/mibook/mvvm/read/viewmodel/CacheStatus;", "Lcom/martian/mibook/mvvm/read/viewmodel/CacheStatus;", "()Lcom/martian/mibook/mvvm/read/viewmodel/CacheStatus;", r3.c.f30242e, "(Lcom/martian/mibook/mvvm/read/viewmodel/CacheStatus;)V", "cacheStatus", "u2", "cacheStartIndex", "s2", "cacheProgress", "t2", "cacheProgressString", "_mStartCacheBookLiveData", "mStartCacheBookLiveData", "U1", "isOnlineBook", "T1", "isLocalBook", "a", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nReadingViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReadingViewModel.kt\ncom/martian/mibook/mvvm/read/viewmodel/ReadingViewModel\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1297:1\n1#2:1298\n*E\n"})
/* loaded from: classes3.dex */
public final class ReadingViewModel extends BaseViewModel<ReadingRepository> {

    /* renamed from: A */
    @l
    public String notificationStatus;

    /* renamed from: A0, reason: from kotlin metadata */
    @k
    public final MutableLiveData<List<TYBookItem>> _mLastPageRecommendBookListLiveData;

    /* renamed from: B, reason: from kotlin metadata */
    public boolean showFloatItems;

    /* renamed from: B0, reason: from kotlin metadata */
    @k
    public final MutableLiveData<List<TYBookItem>> mLastPageRecommendBookListLiveData;

    /* renamed from: C0, reason: from kotlin metadata */
    @k
    public final MutableLiveData<Book> _mLoadBookLiveData;

    /* renamed from: D0, reason: from kotlin metadata */
    @k
    public final MutableLiveData<Book> mLoadBookLiveData;

    /* renamed from: E0, reason: from kotlin metadata */
    @k
    public final MutableLiveData<ErrorResult> _mLoadBookErrorLiveData;

    /* renamed from: F0, reason: from kotlin metadata */
    @k
    public final MutableLiveData<ErrorResult> mLoadBookErrorLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    public int readingNotchHeight;

    /* renamed from: G0, reason: from kotlin metadata */
    @k
    public final MutableLiveData<ReadingInfo> _mBookScoresAndTopCommentsLiveData;

    /* renamed from: H, reason: from kotlin metadata */
    public boolean isSelfTriggeredRefreshTheme;

    /* renamed from: H0, reason: from kotlin metadata */
    @k
    public final MutableLiveData<ReadingInfo> mBookScoresAndTopCommentsLiveData;

    /* renamed from: I, reason: from kotlin metadata */
    public boolean isSelfTriggeredRefreshTypeface;

    /* renamed from: I0, reason: from kotlin metadata */
    @k
    public final MutableLiveData<ChapterList> _mLocalChapterListLiveData;

    /* renamed from: J0, reason: from kotlin metadata */
    @k
    public final MutableLiveData<ChapterList> mLocalChapterListLiveData;

    /* renamed from: K, reason: from kotlin metadata */
    public int totalSeconds;

    /* renamed from: K0, reason: from kotlin metadata */
    @k
    public final MutableLiveData<ChapterList> _mAsyncChapterListLiveData;

    /* renamed from: L, reason: from kotlin metadata */
    public int processSeconds;

    /* renamed from: L0, reason: from kotlin metadata */
    @k
    public final MutableLiveData<ChapterList> mAsyncChapterListLiveData;

    /* renamed from: M0, reason: from kotlin metadata */
    @k
    public final MutableLiveData<ChapterPrice> _mVideoBonusCompleteLiveData;

    /* renamed from: N, reason: from kotlin metadata */
    public int totalCoins;

    /* renamed from: N0, reason: from kotlin metadata */
    @k
    public final MutableLiveData<ChapterPrice> mVideoBonusCompleteLiveData;

    /* renamed from: O, reason: from kotlin metadata */
    public boolean isFreshUserFirstIn;

    /* renamed from: O0, reason: from kotlin metadata */
    @k
    public final MutableLiveData<ErrorResult> _mVideoBonusCompleteErrorLiveData;

    /* renamed from: P, reason: from kotlin metadata */
    public boolean rTing;

    /* renamed from: P0, reason: from kotlin metadata */
    @k
    public final MutableLiveData<ErrorResult> mVideoBonusCompleteErrorLiveData;

    /* renamed from: Q0, reason: from kotlin metadata */
    @k
    public final MutableLiveData<Boolean> _mFreeReadWithAdLiveData;

    /* renamed from: R, reason: from kotlin metadata */
    @l
    public List<Pair<String, Integer>> readingHintsWithWeights;

    /* renamed from: R0, reason: from kotlin metadata */
    @k
    public final MutableLiveData<Boolean> mFreeReadWithAdLiveData;

    /* renamed from: S */
    public int hintsTotalWeight;

    /* renamed from: S0, reason: from kotlin metadata */
    @k
    public final MutableLiveData<Integer> _mNumberOfChaptersLiveData;

    /* renamed from: T */
    public boolean isVip;

    /* renamed from: T0, reason: from kotlin metadata */
    @k
    public final MutableLiveData<Integer> mNumberOfChaptersLiveData;

    /* renamed from: U, reason: from kotlin metadata */
    public boolean adBook;

    /* renamed from: U0, reason: from kotlin metadata */
    @k
    public final SingleLiveEvent<Bonus> _mRtBonusLiveData;

    /* renamed from: V */
    public boolean adHiding;

    /* renamed from: V0, reason: from kotlin metadata */
    @k
    public final SingleLiveEvent<Bonus> mRtBonusLiveData;

    /* renamed from: W */
    public int interstitialInterval;

    /* renamed from: W0, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<Integer> _mNotifyRefreshRecommendBookList;

    /* renamed from: X0, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<Integer> mNotifyRefreshRecommendBookList;

    /* renamed from: Y, reason: from kotlin metadata */
    public int videoUnlockChapterIndex;

    /* renamed from: Y0, reason: from kotlin metadata */
    @k
    public final MutableLiveData<List<Comment>> _mHotCommentsLiveData;

    /* renamed from: Z, reason: from kotlin metadata */
    public boolean enableBaeAdInfo;

    /* renamed from: Z0, reason: from kotlin metadata */
    @k
    public final MutableLiveData<List<Comment>> mHotCommentsLiveData;

    /* renamed from: a1, reason: from kotlin metadata */
    @k
    public MutableLiveData<TYBookTopUser> _mDialogBookwormLiveData;

    /* renamed from: b0, reason: from kotlin metadata */
    @l
    public Map<String, Long> chapterIdInfos;

    /* renamed from: b1, reason: from kotlin metadata */
    @k
    public final MutableLiveData<TYBookTopUser> mDialogBookwormLiveData;

    /* renamed from: c0, reason: from kotlin metadata */
    @l
    public String recommend;

    /* renamed from: c1, reason: from kotlin metadata */
    @k
    public MutableLiveData<TYBookTopUser> _mLastPageBookwormLiveData;

    /* renamed from: d0, reason: from kotlin metadata */
    @l
    public String recommendId;

    /* renamed from: d1, reason: from kotlin metadata */
    @k
    public final MutableLiveData<TYBookTopUser> mLastPageBookwormLiveData;

    /* renamed from: e0, reason: from kotlin metadata */
    @l
    public String recContext;

    /* renamed from: e1, reason: from kotlin metadata */
    @k
    public MutableLiveData<Unit> _mRefreshSlideModeLiveData;

    /* renamed from: f0, reason: from kotlin metadata */
    public long timeStamp;

    /* renamed from: f1, reason: from kotlin metadata */
    @k
    public final MutableLiveData<Unit> mRefreshSlideModeLiveData;

    /* renamed from: g0, reason: from kotlin metadata */
    public boolean fromIntent;

    /* renamed from: g1, reason: from kotlin metadata */
    @k
    public MutableLiveData<Boolean> _mCurrentViewBookMarkLiveData;

    /* renamed from: h, reason: from kotlin metadata */
    @l
    public Book book;

    /* renamed from: h0, reason: from kotlin metadata */
    public boolean closeNetworkOffCheck;

    /* renamed from: h1, reason: from kotlin metadata */
    @k
    public final MutableLiveData<Boolean> mCurrentViewBookMarkLiveData;

    /* renamed from: i, reason: from kotlin metadata */
    @l
    public MiReadingRecord record;

    /* renamed from: i0, reason: from kotlin metadata */
    public int loadingCount;

    /* renamed from: i1, reason: from kotlin metadata */
    @k
    public MutableLiveData<Integer> _mProcessSecondsLiveData;

    /* renamed from: j, reason: from kotlin metadata */
    @l
    public String sourceString;

    /* renamed from: j0, reason: from kotlin metadata */
    @l
    public List<TYBookItem> recommendBooks;

    /* renamed from: j1, reason: from kotlin metadata */
    @k
    public final MutableLiveData<Integer> mProcessSecondsLiveData;

    /* renamed from: k, reason: from kotlin metadata */
    @l
    public String sourceName;

    /* renamed from: k0, reason: from kotlin metadata */
    public int recommendBookPage;

    /* renamed from: k1, reason: from kotlin metadata */
    @l
    public String bookName;

    /* renamed from: l */
    @l
    public String sourceId;

    /* renamed from: l0, reason: from kotlin metadata */
    @l
    public TYBookTopUser tyBookTopUser;

    /* renamed from: l1, reason: from kotlin metadata */
    public int com.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String;

    /* renamed from: m, reason: from kotlin metadata */
    @l
    public ChapterList chapterList;

    /* renamed from: m0, reason: from kotlin metadata */
    public long lastBookwormBookRequestTime;

    /* renamed from: m1, reason: from kotlin metadata */
    @l
    public b1.b cacheStatusChangedListener;

    /* renamed from: n, reason: from kotlin metadata */
    @l
    public ChapterList localChapterList;

    /* renamed from: n0, reason: from kotlin metadata */
    @l
    public List<? extends TYBookItem> lastPageRecommendBooks;

    /* renamed from: n1, reason: from kotlin metadata */
    public int cacheIndex;

    /* renamed from: o, reason: from kotlin metadata */
    @l
    public ReadingInfo readingInfo;

    /* renamed from: o0, reason: from kotlin metadata */
    public long lastPageRecommendBooksRequestTime;

    /* renamed from: o1, reason: from kotlin metadata */
    @k
    public CacheStatus cacheStatus;

    /* renamed from: p, reason: from kotlin metadata */
    @l
    public List<Comment> hotComments;

    /* renamed from: p0 */
    public boolean waitForFreeReadWithAd;

    /* renamed from: p1, reason: from kotlin metadata */
    public int cacheStartIndex;

    /* renamed from: q, reason: from kotlin metadata */
    public boolean bookInfoUpdated;

    /* renamed from: q0, reason: from kotlin metadata */
    @k
    public final MutableLiveData<List<MiBookMark>> _mMarkListLiveData;

    /* renamed from: q1, reason: from kotlin metadata */
    public int cacheProgress;

    /* renamed from: r */
    public int chapterListRetry;

    /* renamed from: r0, reason: from kotlin metadata */
    @k
    public final MutableLiveData<List<MiBookMark>> mMarkListLiveData;

    /* renamed from: r1, reason: from kotlin metadata */
    @l
    public String cacheProgressString;

    /* renamed from: s, reason: from kotlin metadata */
    public boolean resetPageContent;

    /* renamed from: s0, reason: from kotlin metadata */
    @k
    public final MutableLiveData<ReadingInfo> _mReadingInfoLiveData;

    /* renamed from: s1, reason: from kotlin metadata */
    @k
    public final MutableLiveData<Integer> _mStartCacheBookLiveData;

    /* renamed from: t0, reason: from kotlin metadata */
    @k
    public final MutableLiveData<ReadingInfo> mReadingInfoLiveData;

    /* renamed from: t1, reason: from kotlin metadata */
    @k
    public final MutableLiveData<Integer> mStartCacheBookLiveData;

    /* renamed from: u0, reason: from kotlin metadata */
    @k
    public final MutableLiveData<ErrorResult> _mReadingErrorLiveData;

    /* renamed from: v, reason: from kotlin metadata */
    public boolean isScrollMode;

    /* renamed from: v0, reason: from kotlin metadata */
    @k
    public final MutableLiveData<ErrorResult> mReadingErrorLiveData;

    /* renamed from: w */
    public boolean showChapterComment;

    /* renamed from: w0, reason: from kotlin metadata */
    @k
    public final MutableLiveData<Integer> _mChapterIndexLiveData;

    /* renamed from: x, reason: from kotlin metadata */
    public boolean showBookComment;

    /* renamed from: x0, reason: from kotlin metadata */
    @k
    public final MutableLiveData<Integer> mChapterIndexLiveData;

    /* renamed from: y, reason: from kotlin metadata */
    public int pullDownMarkFlag;

    /* renamed from: y0, reason: from kotlin metadata */
    @k
    public final MutableLiveData<List<TYBookItem>> _mExitRecommendBookListLiveData;

    /* renamed from: z */
    @l
    public MiReadingTheme customTheme;

    /* renamed from: z0, reason: from kotlin metadata */
    @k
    public final MutableLiveData<List<TYBookItem>> mExitRecommendBookListLiveData;

    /* renamed from: t */
    public boolean isPortrait = true;

    /* renamed from: u, reason: from kotlin metadata */
    public int statusBarMode = -1;

    /* renamed from: C, reason: from kotlin metadata */
    public boolean prefShowFloatMenu = true;

    /* renamed from: D, reason: from kotlin metadata */
    public boolean prefShowFloatBonus = true;

    /* renamed from: E */
    public boolean prefShowBottomStatus = true;

    /* renamed from: F, reason: from kotlin metadata */
    public boolean prefShowBottomTips = true;

    /* renamed from: J, reason: from kotlin metadata */
    public long lastScrollTime = System.currentTimeMillis();

    /* renamed from: M, reason: from kotlin metadata */
    public final int fullSeconds = 300;

    /* renamed from: Q, reason: from kotlin metadata */
    @l
    public String readingHint = "";

    /* renamed from: X, reason: from kotlin metadata */
    public int interstitialMinutes = 45;

    /* renamed from: a0, reason: from kotlin metadata */
    @k
    public RecordReadType recordReadType = RecordReadType.DEFAULT;

    public interface a {
        void a(@k Book book);

        void b(@k ErrorResult errorResult);
    }

    public static final class b implements a {
        public b() {
        }

        @Override // com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel.a
        public void a(@k Book book) {
            Intrinsics.checkNotNullParameter(book, "book");
            ReadingViewModel.this.i2();
        }

        @Override // com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel.a
        public void b(@k ErrorResult errorResult) {
            Intrinsics.checkNotNullParameter(errorResult, "errorResult");
            ReadingViewModel.this.i2();
        }
    }

    public static final class c implements xb.b {

        /* renamed from: b */
        public final /* synthetic */ a f14811b;

        public c(a aVar) {
            this.f14811b = aVar;
        }

        @Override // xb.b
        public void a(@l Book book) {
            if (book == null) {
                a aVar = this.f14811b;
                if (aVar != null) {
                    aVar.b(new ErrorResult(-1, "信息获取失败", null, 4, null));
                    return;
                }
                return;
            }
            ReadingViewModel.this.o2(book);
            ReadingViewModel.this.p2(true);
            a aVar2 = this.f14811b;
            if (aVar2 != null) {
                aVar2.a(book);
            }
        }

        @Override // xb.b
        public void onLoading(boolean z10) {
        }

        @Override // xb.b
        public void onResultError(@l x8.c cVar) {
            if (cVar == null) {
                a aVar = this.f14811b;
                if (aVar != null) {
                    aVar.b(new ErrorResult(-1, "信息获取失败", null, 4, null));
                    return;
                }
                return;
            }
            a aVar2 = this.f14811b;
            if (aVar2 != null) {
                int c10 = cVar.c();
                String d10 = cVar.d();
                Intrinsics.checkNotNullExpressionValue(d10, "getErrorMsg(...)");
                aVar2.b(new ErrorResult(c10, d10, null, 4, null));
            }
        }
    }

    public static final class d extends xb.f {
        public d() {
        }

        @Override // xb.f
        public void a(boolean z10) {
            ReadingViewModel.this.h().postValue(Boolean.valueOf(z10));
            if (z10) {
                ReadingViewModel.this._mLoadBookErrorLiveData.postValue(null);
            }
        }

        @Override // xb.f
        @SuppressLint({"SetTextI18n"})
        public void b(int i10) {
            ReadingViewModel.this._mNumberOfChaptersLiveData.postValue(Integer.valueOf(i10));
        }

        @Override // xb.f
        public void c(@l ChapterList chapterList) {
            if (chapterList == null || chapterList.getCount() == 0) {
                ReadingViewModel.this.L2(null);
                ReadingViewModel.this._mLocalChapterListLiveData.postValue(null);
            } else {
                ReadingViewModel.this.L2(chapterList);
                ReadingViewModel.this._mLocalChapterListLiveData.postValue(chapterList);
            }
        }

        @Override // xb.f
        public void d(@l x8.c cVar) {
            ReadingViewModel.this._mLocalChapterListLiveData.postValue(null);
        }
    }

    public static final class e implements b1.b {

        /* renamed from: c */
        public final /* synthetic */ Context f14814c;

        public e(Context context) {
            this.f14814c = context;
        }

        @Override // ya.b1.b
        public void a(@l Book book) {
            ReadingViewModel.this._mStartCacheBookLiveData.postValue(3);
            t0.b(this.f14814c, "缓存取消");
        }

        @Override // ya.b1.b
        public void c(@l Book book) {
            ReadingViewModel.this.v2(CacheStatus.Caching);
        }

        @Override // ya.b1.b
        public void d(@l Book book, @l x8.c cVar) {
            ReadingViewModel.this._mStartCacheBookLiveData.postValue(4);
            t0.b(this.f14814c, "缓存失败");
            ReadingViewModel.this.v2(CacheStatus.Error);
        }

        @Override // ya.b1.b
        public void e(@l Book book) {
            ChapterList chapterList = ReadingViewModel.this.getChapterList();
            if ((chapterList != null ? chapterList.getCount() : 0) > ReadingViewModel.this.getCacheIndex() + 1) {
                t0.b(this.f14814c, (ReadingViewModel.this.getCacheStartIndex() + 1) + "至" + (ReadingViewModel.this.getCacheIndex() + 1) + "章节缓存完成");
            } else {
                t0.b(this.f14814c, "全部章节已缓存");
            }
            ReadingViewModel.this._mStartCacheBookLiveData.postValue(5);
            ReadingViewModel.this.v2(CacheStatus.Finished);
        }

        @Override // ya.b1.b
        public void f(@l Book book) {
            ReadingViewModel.this.v2(CacheStatus.Caching);
        }

        @Override // ya.b1.b
        public void g(@l Book book, int i10) {
            ReadingViewModel.this._mStartCacheBookLiveData.postValue(6);
            t0.b(this.f14814c, i10 + " 个章节缓存失败");
            ReadingViewModel.this.v2(CacheStatus.Finished);
        }

        @Override // ya.b1.b
        public void h(@l Book book, int i10, int i11, boolean z10) {
            ReadingViewModel.this.r2(i10);
            int i12 = i10 + 1;
            ReadingViewModel.this.t2("(" + i12 + "/" + i11 + ")");
            ReadingViewModel.this.s2((int) ((((double) i12) / ((double) i11)) * ((double) 100)));
            ReadingViewModel.this._mStartCacheBookLiveData.postValue(2);
            if (ReadingViewModel.this.getCacheStatus() == CacheStatus.Abort) {
                MiConfigSingleton.b2().P1().i(book);
            }
        }

        @Override // ya.b1.b
        public void i(@l Book book) {
        }
    }

    public static final class f implements a {
        public f() {
        }

        @Override // com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel.a
        public void a(@k Book book) {
            Intrinsics.checkNotNullParameter(book, "book");
            ReadingViewModel.this._mLoadBookLiveData.postValue(book);
        }

        @Override // com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel.a
        public void b(@k ErrorResult errorResult) {
            Intrinsics.checkNotNullParameter(errorResult, "errorResult");
            ReadingViewModel.this._mLoadBookErrorLiveData.postValue(errorResult);
        }
    }

    public static final class g extends xb.f {

        /* renamed from: a */
        public final /* synthetic */ boolean f14816a;

        /* renamed from: b */
        public final /* synthetic */ ReadingViewModel f14817b;

        public g(boolean z10, ReadingViewModel readingViewModel) {
            this.f14816a = z10;
            this.f14817b = readingViewModel;
        }

        @Override // xb.f
        public void a(boolean z10) {
            if (this.f14816a) {
                this.f14817b.h().postValue(Boolean.valueOf(z10));
                if (z10) {
                    this.f14817b._mLoadBookErrorLiveData.postValue(null);
                }
            }
        }

        @Override // xb.f
        @SuppressLint({"SetTextI18n"})
        public void b(int i10) {
            if (this.f14816a) {
                this.f14817b._mNumberOfChaptersLiveData.postValue(Integer.valueOf(i10));
            }
        }

        @Override // xb.f
        public void c(@l ChapterList chapterList) {
            if (chapterList != null && chapterList.getCount() != 0) {
                this.f14817b.z2(0);
                this.f14817b.y2(chapterList);
                this.f14817b._mAsyncChapterListLiveData.postValue(chapterList);
            } else if (this.f14816a) {
                ErrorResult errorResult = new ErrorResult(-1, "信息获取失败", null, 4, null);
                errorResult.setObj(Boolean.TRUE);
                this.f14817b._mLoadBookErrorLiveData.postValue(errorResult);
            }
        }

        @Override // xb.f
        public void d(@l x8.c cVar) {
            ErrorResult errorResult;
            if (this.f14816a) {
                if (cVar == null) {
                    errorResult = new ErrorResult(-1, "信息获取失败", null, 4, null);
                } else {
                    int c10 = cVar.c();
                    String d10 = cVar.d();
                    Intrinsics.checkNotNullExpressionValue(d10, "getErrorMsg(...)");
                    errorResult = new ErrorResult(c10, d10, null, 4, null);
                }
                errorResult.setObj(Boolean.TRUE);
                this.f14817b._mLoadBookErrorLiveData.postValue(errorResult);
            }
        }
    }

    public ReadingViewModel() {
        MutableLiveData<List<MiBookMark>> mutableLiveData = new MutableLiveData<>();
        this._mMarkListLiveData = mutableLiveData;
        this.mMarkListLiveData = mutableLiveData;
        MutableLiveData<ReadingInfo> mutableLiveData2 = new MutableLiveData<>();
        this._mReadingInfoLiveData = mutableLiveData2;
        this.mReadingInfoLiveData = mutableLiveData2;
        MutableLiveData<ErrorResult> mutableLiveData3 = new MutableLiveData<>();
        this._mReadingErrorLiveData = mutableLiveData3;
        this.mReadingErrorLiveData = mutableLiveData3;
        MutableLiveData<Integer> mutableLiveData4 = new MutableLiveData<>();
        this._mChapterIndexLiveData = mutableLiveData4;
        this.mChapterIndexLiveData = mutableLiveData4;
        MutableLiveData<List<TYBookItem>> mutableLiveData5 = new MutableLiveData<>();
        this._mExitRecommendBookListLiveData = mutableLiveData5;
        this.mExitRecommendBookListLiveData = mutableLiveData5;
        MutableLiveData<List<TYBookItem>> mutableLiveData6 = new MutableLiveData<>();
        this._mLastPageRecommendBookListLiveData = mutableLiveData6;
        this.mLastPageRecommendBookListLiveData = mutableLiveData6;
        MutableLiveData<Book> mutableLiveData7 = new MutableLiveData<>();
        this._mLoadBookLiveData = mutableLiveData7;
        this.mLoadBookLiveData = mutableLiveData7;
        MutableLiveData<ErrorResult> mutableLiveData8 = new MutableLiveData<>();
        this._mLoadBookErrorLiveData = mutableLiveData8;
        this.mLoadBookErrorLiveData = mutableLiveData8;
        MutableLiveData<ReadingInfo> mutableLiveData9 = new MutableLiveData<>();
        this._mBookScoresAndTopCommentsLiveData = mutableLiveData9;
        this.mBookScoresAndTopCommentsLiveData = mutableLiveData9;
        MutableLiveData<ChapterList> mutableLiveData10 = new MutableLiveData<>();
        this._mLocalChapterListLiveData = mutableLiveData10;
        this.mLocalChapterListLiveData = mutableLiveData10;
        MutableLiveData<ChapterList> mutableLiveData11 = new MutableLiveData<>();
        this._mAsyncChapterListLiveData = mutableLiveData11;
        this.mAsyncChapterListLiveData = mutableLiveData11;
        MutableLiveData<ChapterPrice> mutableLiveData12 = new MutableLiveData<>();
        this._mVideoBonusCompleteLiveData = mutableLiveData12;
        this.mVideoBonusCompleteLiveData = mutableLiveData12;
        MutableLiveData<ErrorResult> mutableLiveData13 = new MutableLiveData<>();
        this._mVideoBonusCompleteErrorLiveData = mutableLiveData13;
        this.mVideoBonusCompleteErrorLiveData = mutableLiveData13;
        MutableLiveData<Boolean> mutableLiveData14 = new MutableLiveData<>();
        this._mFreeReadWithAdLiveData = mutableLiveData14;
        this.mFreeReadWithAdLiveData = mutableLiveData14;
        MutableLiveData<Integer> mutableLiveData15 = new MutableLiveData<>();
        this._mNumberOfChaptersLiveData = mutableLiveData15;
        this.mNumberOfChaptersLiveData = mutableLiveData15;
        SingleLiveEvent<Bonus> singleLiveEvent = new SingleLiveEvent<>();
        this._mRtBonusLiveData = singleLiveEvent;
        this.mRtBonusLiveData = singleLiveEvent;
        NonStickyLiveData<Integer> nonStickyLiveData = new NonStickyLiveData<>();
        this._mNotifyRefreshRecommendBookList = nonStickyLiveData;
        this.mNotifyRefreshRecommendBookList = nonStickyLiveData;
        MutableLiveData<List<Comment>> mutableLiveData16 = new MutableLiveData<>();
        this._mHotCommentsLiveData = mutableLiveData16;
        this.mHotCommentsLiveData = mutableLiveData16;
        MutableLiveData<TYBookTopUser> mutableLiveData17 = new MutableLiveData<>();
        this._mDialogBookwormLiveData = mutableLiveData17;
        this.mDialogBookwormLiveData = mutableLiveData17;
        MutableLiveData<TYBookTopUser> mutableLiveData18 = new MutableLiveData<>();
        this._mLastPageBookwormLiveData = mutableLiveData18;
        this.mLastPageBookwormLiveData = mutableLiveData18;
        MutableLiveData<Unit> mutableLiveData19 = new MutableLiveData<>();
        this._mRefreshSlideModeLiveData = mutableLiveData19;
        this.mRefreshSlideModeLiveData = mutableLiveData19;
        MutableLiveData<Boolean> mutableLiveData20 = new MutableLiveData<>();
        this._mCurrentViewBookMarkLiveData = mutableLiveData20;
        this.mCurrentViewBookMarkLiveData = mutableLiveData20;
        MutableLiveData<Integer> mutableLiveData21 = new MutableLiveData<>();
        this._mProcessSecondsLiveData = mutableLiveData21;
        this.mProcessSecondsLiveData = mutableLiveData21;
        this.com.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String = -1;
        this.cacheStatus = CacheStatus.None;
        MutableLiveData<Integer> mutableLiveData22 = new MutableLiveData<>();
        this._mStartCacheBookLiveData = mutableLiveData22;
        this.mStartCacheBookLiveData = mutableLiveData22;
    }

    public static /* synthetic */ void B0(ReadingViewModel readingViewModel, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 8;
        }
        readingViewModel.A0(i10, i11);
    }

    public static /* synthetic */ void f2(ReadingViewModel readingViewModel, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        readingViewModel.e2(i10);
    }

    public static /* synthetic */ void g0(ReadingViewModel readingViewModel, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        if ((i10 & 2) != 0) {
            z11 = false;
        }
        readingViewModel.f0(z10, z11);
    }

    public static /* synthetic */ void x0(ReadingViewModel readingViewModel, GetCommentByScoreParams getCommentByScoreParams, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 5;
        }
        readingViewModel.w0(getCommentByScoreParams, i10);
    }

    public final void A0(int pageIndex, int pageSize) {
        if (this.lastPageRecommendBooksRequestTime + 60000 > System.currentTimeMillis()) {
            return;
        }
        this.lastPageRecommendBooksRequestTime = System.currentTimeMillis();
        j(new ReadingViewModel$getLastPageRecommendBookList$1(pageIndex, pageSize, this, null), new ReadingViewModel$getLastPageRecommendBookList$2(this, null), false);
    }

    /* renamed from: A1, reason: from getter */
    public final boolean getShowChapterComment() {
        return this.showChapterComment;
    }

    public final void A2(boolean z10) {
        this.closeNetworkOffCheck = z10;
    }

    /* renamed from: B1, reason: from getter */
    public final boolean getShowFloatItems() {
        return this.showFloatItems;
    }

    public final void B2(@l MiReadingTheme miReadingTheme) {
        this.customTheme = miReadingTheme;
    }

    @l
    public final List<TYBookItem> C0() {
        return this.lastPageRecommendBooks;
    }

    @l
    /* renamed from: C1, reason: from getter */
    public final String getSourceId() {
        return this.sourceId;
    }

    public final void C2() {
        MiConfigSingleton.b2().e2().C0();
    }

    /* renamed from: D0, reason: from getter */
    public final long getLastPageRecommendBooksRequestTime() {
        return this.lastPageRecommendBooksRequestTime;
    }

    @l
    /* renamed from: D1, reason: from getter */
    public final String getSourceName() {
        return this.sourceName;
    }

    public final void D2(boolean z10) {
        this.enableBaeAdInfo = z10;
    }

    /* renamed from: E0, reason: from getter */
    public final int getLoadingCount() {
        return this.loadingCount;
    }

    @l
    /* renamed from: E1, reason: from getter */
    public final String getSourceString() {
        return this.sourceString;
    }

    public final void E2(boolean z10) {
        this.isFreshUserFirstIn = z10;
    }

    @l
    /* renamed from: F0, reason: from getter */
    public final ChapterList getLocalChapterList() {
        return this.localChapterList;
    }

    /* renamed from: F1, reason: from getter */
    public final int getStatusBarMode() {
        return this.statusBarMode;
    }

    public final void F2(boolean z10) {
        this.fromIntent = z10;
    }

    @k
    public final MutableLiveData<ChapterList> G0() {
        return this.mAsyncChapterListLiveData;
    }

    /* renamed from: G1, reason: from getter */
    public final int getTotalCoins() {
        return this.totalCoins;
    }

    public final void G2(@l List<Comment> list) {
        this.hotComments = list;
    }

    @k
    public final MutableLiveData<ReadingInfo> H0() {
        return this.mBookScoresAndTopCommentsLiveData;
    }

    /* renamed from: H1, reason: from getter */
    public final int getTotalSeconds() {
        return this.totalSeconds;
    }

    public final void H2(int i10) {
        this.interstitialInterval = i10;
    }

    @k
    public final MutableLiveData<Integer> I0() {
        return this.mChapterIndexLiveData;
    }

    @l
    /* renamed from: I1, reason: from getter */
    public final TYBookTopUser getTyBookTopUser() {
        return this.tyBookTopUser;
    }

    public final void I2(@l List<? extends TYBookItem> list) {
        this.lastPageRecommendBooks = list;
    }

    @k
    public final MutableLiveData<Boolean> J0() {
        return this.mCurrentViewBookMarkLiveData;
    }

    public final int J1() {
        int i10 = this.videoUnlockChapterIndex;
        if (i10 < 10) {
            return 0;
        }
        return i10;
    }

    public final void J2(long j10) {
        this.lastPageRecommendBooksRequestTime = j10;
    }

    @k
    public final MutableLiveData<TYBookTopUser> K0() {
        return this.mDialogBookwormLiveData;
    }

    /* renamed from: K1, reason: from getter */
    public final boolean getWaitForFreeReadWithAd() {
        return this.waitForFreeReadWithAd;
    }

    public final void K2(int i10) {
        this.loadingCount = i10;
    }

    @k
    public final MutableLiveData<List<TYBookItem>> L0() {
        return this.mExitRecommendBookListLiveData;
    }

    @Override // com.martian.mibook.mvvm.base.BaseViewModel
    @k
    /* renamed from: L1 */
    public ReadingRepository i() {
        return new ReadingRepository();
    }

    public final void L2(@l ChapterList chapterList) {
        this.localChapterList = chapterList;
    }

    @k
    public final MutableLiveData<Boolean> M0() {
        return this.mFreeReadWithAdLiveData;
    }

    public final void M1(Activity r32) {
        int withoutAdMinutes;
        this.isPortrait = ReadingInstance.z().O(r32);
        boolean z10 = false;
        this.readingNotchHeight = m.q(r32) ? com.gyf.immersionbar.d.H0(r32) : 0;
        this.prefShowFloatBonus = ReadingInstance.z().e(r32);
        this.prefShowFloatMenu = ReadingInstance.z().C0(r32);
        this.prefShowBottomStatus = ReadingInstance.z().Q(r32);
        this.prefShowBottomTips = ReadingInstance.z().R(r32);
        this.enableBaeAdInfo = MiConfigSingleton.b2().c2().getEnableBaeAdInfo();
        this.adHiding = ReadingInstance.z().y0(r32);
        this.isVip = MiConfigSingleton.b2().K2();
        if (!MiConfigSingleton.b2().C2() && ReadingInstance.z().B0(r32)) {
            z10 = true;
        }
        this.showChapterComment = z10;
        this.showBookComment = MiConfigSingleton.b2().p3();
        this.notificationStatus = h.e(r32) ? "开启" : "关闭";
        this.timeStamp = MartianRPUserManager.a();
        this.isFreshUserFirstIn = MiConfigSingleton.b2().G1().r();
        if (MiConfigSingleton.b2().u2().u(r32, this.isFreshUserFirstIn) && (withoutAdMinutes = MiConfigSingleton.b2().c2().getWithoutAdMinutes()) > 0) {
            ReadingInstance.z().Z(r32, withoutAdMinutes);
        }
        g1();
    }

    public final void M2(@l String str) {
        this.notificationStatus = str;
    }

    @k
    public final MutableLiveData<List<Comment>> N0() {
        return this.mHotCommentsLiveData;
    }

    public final void N1(@k Activity r82, @k Book book, @l Integer r10, @l Integer contentIndex, @l Integer contentLength, boolean recordFirst) {
        Intrinsics.checkNotNullParameter(r82, "activity");
        Intrinsics.checkNotNullParameter(book, "book");
        M1(r82);
        if (book instanceof TYBookItem) {
            TYBookItem tYBookItem = (TYBookItem) book;
            this.recommend = tYBookItem.getRecommend();
            this.recommendId = tYBookItem.getRecommendId();
            this.recContext = tYBookItem.getContext();
            ReadingInfo readingInfo = new ReadingInfo();
            readingInfo.setScore(Integer.valueOf(tYBookItem.getScore()));
            readingInfo.setClickCount(tYBookItem.getClickCount());
            readingInfo.setNComments(tYBookItem.getnComments());
            readingInfo.setReadingCount(tYBookItem.getReadingCount());
            readingInfo.setIntro(tYBookItem.getIntro());
            this.readingInfo = readingInfo;
        }
        this.sourceString = book.getSourceString();
        this.sourceName = book.getSourceName();
        this.sourceId = book.getSourceId();
        boolean z10 = true;
        if (!book.isLocal() && !book.isFreeBook()) {
            z10 = false;
        }
        this.adBook = z10;
        if (book.isLocal()) {
            this.showChapterComment = false;
            this.showBookComment = false;
        }
        MiConfigSingleton.b2().V1().g(2, this.sourceName, this.sourceId, this.recommendId, this.recommend, "点击阅读");
        Book I = MiConfigSingleton.b2().M1().I(book);
        if (I == null || I.getLastChapter() == null) {
            if (I != null) {
                book = I;
            }
            this.book = book;
            Q(null);
        } else {
            this.book = I;
        }
        s1(recordFirst, r10, contentIndex, contentLength);
        T();
    }

    public final void N2(boolean z10) {
        this.isPortrait = z10;
    }

    @l
    public final MiBookMark O(@l Book book, @l Chapter chapter, int r11, @l String summary, int start, int r14) {
        return MiConfigSingleton.b2().M1().c(book, chapter, r11, summary, start, r14);
    }

    @k
    public final MutableLiveData<TYBookTopUser> O0() {
        return this.mLastPageBookwormLiveData;
    }

    public final void O1(@k Activity r10, @k String sourceId, @k String sourceName, @l Integer r13, @l Integer r14, @l Integer contentLength, @l String recContext, @l String recommend, @l String recommendId) {
        Intrinsics.checkNotNullParameter(r10, "activity");
        Intrinsics.checkNotNullParameter(sourceId, "sourceId");
        Intrinsics.checkNotNullParameter(sourceName, "sourceName");
        M1(r10);
        this.sourceString = vb.e.j(sourceName, sourceId);
        this.sourceName = sourceName;
        this.sourceId = sourceId;
        this.fromIntent = true;
        this.recommend = recommend;
        if (!TextUtils.isEmpty(recommendId)) {
            this.recommendId = recommendId;
            MiConfigSingleton.b2().V1().k(EventManager.f13206i, recommendId);
            MiConfigSingleton.b2().V1().k(EventManager.f13205h, sourceName + "|" + sourceId);
        }
        this.recContext = recContext;
        MiConfigSingleton.b2().V1().g(2, sourceName, sourceId, recommendId, recommend, "点击阅读");
        b2();
        s1(true, r13, r14, contentLength);
        T();
    }

    public final void O2(boolean z10) {
        this.prefShowBottomStatus = z10;
    }

    public final void P() {
        if (!this.bookInfoUpdated && this.localChapterList != null && !MiConfigSingleton.b2().M1().d0(this.book)) {
            int i10 = this.com.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String + 10;
            Book book = this.book;
            Integer chapterSize = book != null ? book.getChapterSize() : null;
            if (i10 > (chapterSize == null ? 0 : chapterSize.intValue())) {
                Q(new b());
                return;
            }
        }
        i2();
    }

    @k
    public final MutableLiveData<List<TYBookItem>> P0() {
        return this.mLastPageRecommendBookListLiveData;
    }

    public final boolean P1() {
        return MiConfigSingleton.b2().e2().b0();
    }

    public final void P2(boolean z10) {
        this.prefShowBottomTips = z10;
    }

    public final void Q(a loadBookCallback) {
        MiConfigSingleton.b2().M1().k(new Source(this.sourceName, this.sourceId), new c(loadBookCallback));
    }

    @k
    public final MutableLiveData<ErrorResult> Q0() {
        return this.mLoadBookErrorLiveData;
    }

    /* renamed from: Q1, reason: from getter */
    public final boolean getIsFreshUserFirstIn() {
        return this.isFreshUserFirstIn;
    }

    public final void Q2(boolean z10) {
        this.prefShowFloatBonus = z10;
    }

    public final void R(@l Activity r32) {
        if (R1()) {
            return;
        }
        MiConfigSingleton.b2().M1().g(r32, this.book);
        t0.b(r32, "已自动将本书加入书架");
    }

    @k
    public final MutableLiveData<Book> R0() {
        return this.mLoadBookLiveData;
    }

    public final boolean R1() {
        return MiConfigSingleton.b2().M1().i0(this.sourceString);
    }

    public final void R2(boolean z10) {
        this.prefShowFloatMenu = z10;
    }

    public final boolean S(@l Context context) {
        YWChapter yWChapter;
        Integer vipflag;
        Integer freeStatus;
        if (context != null && this.chapterList != null) {
            if (T1()) {
                t0.b(context, "本地书籍不支持缓存");
                return true;
            }
            ChapterList chapterList = this.chapterList;
            int count = (chapterList == null || this.com.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String < 0 || chapterList.getCount() == 0) ? 0 : this.com.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String < chapterList.getCount() ? this.com.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String : chapterList.getCount() - 1;
            ChapterList chapterList2 = this.chapterList;
            Chapter item = chapterList2 != null ? chapterList2.getItem(count) : null;
            if (item != null && (item instanceof YWChapter) && (vipflag = (yWChapter = (YWChapter) item).getVipflag()) != null && vipflag.intValue() == 1 && (freeStatus = yWChapter.getFreeStatus()) != null && freeStatus.intValue() == 0) {
                t0.b(context, "限免书籍不支持缓存");
                return true;
            }
            if (!MiConfigSingleton.b2().K2() && !MiConfigSingleton.b2().B0() && !MiConfigSingleton.b2().E2()) {
                return false;
            }
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                R(activity);
            }
            v3(context, count);
        }
        return true;
    }

    @k
    public final MutableLiveData<ChapterList> S0() {
        return this.mLocalChapterListLiveData;
    }

    public final boolean S1() {
        int count;
        ChapterList chapterList = this.chapterList;
        if (chapterList == null) {
            count = 0;
        } else {
            Intrinsics.checkNotNull(chapterList);
            count = chapterList.getCount();
        }
        int i10 = this.com.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String;
        return i10 > 0 && i10 == count;
    }

    public final void S2(int i10) {
        this.processSeconds = i10;
    }

    public final void T() {
        BookWrapper o10 = MiConfigSingleton.b2().M1().T().o(this.sourceString);
        if (o10 == null || !o10.hasUpdate()) {
            return;
        }
        o10.setHasUpdate(false);
        MiConfigSingleton.b2().M1().T().J(o10);
    }

    @k
    public final MutableLiveData<List<MiBookMark>> T0() {
        return this.mMarkListLiveData;
    }

    public final boolean T1() {
        Book book = this.book;
        return book != null && book.isLocal();
    }

    public final void T2(int i10) {
        this.pullDownMarkFlag = i10;
    }

    public final boolean U() {
        return this.isVip || this.isScrollMode;
    }

    @k
    public final NonStickyLiveData<Integer> U0() {
        return this.mNotifyRefreshRecommendBookList;
    }

    public final boolean U1() {
        Book book = this.book;
        boolean z10 = false;
        if (book != null && book.isLocal()) {
            z10 = true;
        }
        return !z10;
    }

    public final void U2(boolean isOr, int r32) {
        this.pullDownMarkFlag = isOr ? this.pullDownMarkFlag | (1 << (r32 - 1)) : this.pullDownMarkFlag & (~(1 << (r32 - 1)));
    }

    public final boolean V(@l MiBookMark miBookMark) {
        if (miBookMark == null) {
            return false;
        }
        return MiConfigSingleton.b2().M1().v(miBookMark);
    }

    @k
    public final MutableLiveData<Integer> V0() {
        return this.mNumberOfChaptersLiveData;
    }

    /* renamed from: V1, reason: from getter */
    public final boolean getIsPortrait() {
        return this.isPortrait;
    }

    public final void V2(@l String str) {
        this.readingHint = str;
    }

    public final void W() {
        MiConfigSingleton.b2().M1().n(this.book, new d());
    }

    @k
    public final MutableLiveData<Integer> W0() {
        return this.mProcessSecondsLiveData;
    }

    /* renamed from: W1, reason: from getter */
    public final boolean getIsScrollMode() {
        return this.isScrollMode;
    }

    public final void W2(@l ReadingInfo readingInfo) {
        this.readingInfo = readingInfo;
    }

    public final void X(@k Context r82, int chargeUser) {
        Intrinsics.checkNotNullParameter(r82, "context");
        BaseViewModel.k(this, new ReadingViewModel$freeReadWithAd$1(this, chargeUser, null), new ReadingViewModel$freeReadWithAd$2(r82, null), false, 4, null);
    }

    @k
    public final MutableLiveData<ErrorResult> X0() {
        return this.mReadingErrorLiveData;
    }

    /* renamed from: X1, reason: from getter */
    public final boolean getIsSelfTriggeredRefreshTheme() {
        return this.isSelfTriggeredRefreshTheme;
    }

    public final void X2(int i10) {
        this.readingNotchHeight = i10;
    }

    /* renamed from: Y, reason: from getter */
    public final boolean getAdBook() {
        return this.adBook;
    }

    @k
    public final MutableLiveData<ReadingInfo> Y0() {
        return this.mReadingInfoLiveData;
    }

    /* renamed from: Y1, reason: from getter */
    public final boolean getIsSelfTriggeredRefreshTypeface() {
        return this.isSelfTriggeredRefreshTypeface;
    }

    public final void Y2(@l String str) {
        this.recommend = str;
    }

    /* renamed from: Z, reason: from getter */
    public final boolean getAdHiding() {
        return this.adHiding;
    }

    @k
    public final MutableLiveData<Unit> Z0() {
        return this.mRefreshSlideModeLiveData;
    }

    public final boolean Z1() {
        return TTSReadManager.r(this.sourceString);
    }

    public final void Z2(@l List<TYBookItem> list) {
        this.recommendBooks = list;
    }

    @l
    /* renamed from: a0, reason: from getter */
    public final Book getBook() {
        return this.book;
    }

    @k
    public final SingleLiveEvent<Bonus> a1() {
        return this.mRtBonusLiveData;
    }

    /* renamed from: a2, reason: from getter */
    public final boolean getIsVip() {
        return this.isVip;
    }

    public final void a3(@l String str) {
        this.recommendId = str;
    }

    public final void b0() {
        if (TextUtils.isEmpty(this.sourceName) || TextUtils.isEmpty(this.sourceId)) {
            return;
        }
        BaseViewModel.k(this, new ReadingViewModel$getBookAdsInfo$1(this, null), null, false, 6, null);
    }

    @k
    public final MutableLiveData<Integer> b1() {
        return this.mStartCacheBookLiveData;
    }

    public final void b2() {
        Book I = MiConfigSingleton.b2().M1().I(new Source(this.sourceName, this.sourceId));
        if (I == null) {
            Q(new f());
        } else {
            this.book = I;
            this._mLoadBookLiveData.postValue(I);
        }
    }

    public final void b3(@l MiReadingRecord miReadingRecord) {
        this.record = miReadingRecord;
    }

    /* renamed from: c0, reason: from getter */
    public final boolean getBookInfoUpdated() {
        return this.bookInfoUpdated;
    }

    @k
    public final MutableLiveData<ErrorResult> c1() {
        return this.mVideoBonusCompleteErrorLiveData;
    }

    public final boolean c2() {
        RecordReadType recordReadType = this.recordReadType;
        return recordReadType == RecordReadType.RECORD || recordReadType == RecordReadType.RECORD_HALFWAY;
    }

    public final void c3(@k RecordReadType recordReadType) {
        Intrinsics.checkNotNullParameter(recordReadType, "<set-?>");
        this.recordReadType = recordReadType;
    }

    public final void d0() {
        BaseViewModel.k(this, new ReadingViewModel$getBookMarks$1(this, null), new ReadingViewModel$getBookMarks$2(this, null), false, 4, null);
    }

    @k
    public final MutableLiveData<ChapterPrice> d1() {
        return this.mVideoBonusCompleteLiveData;
    }

    public final void d2(boolean hasBookMark) {
        this._mCurrentViewBookMarkLiveData.postValue(Boolean.valueOf(hasBookMark));
    }

    public final void d3(boolean z10) {
        this.resetPageContent = z10;
    }

    @l
    public final String e0() {
        if (this.book == null) {
            return "";
        }
        String str = this.bookName;
        if (str != null && str.length() != 0) {
            return "";
        }
        Book book = this.book;
        if (book != null) {
            return book.getBookName();
        }
        return null;
    }

    @l
    /* renamed from: e1, reason: from getter */
    public final String getNotificationStatus() {
        return this.notificationStatus;
    }

    public final void e2(int value) {
        this._mNotifyRefreshRecommendBookList.postValue(Integer.valueOf(value));
    }

    public final void e3(boolean z10) {
        this.isScrollMode = z10;
    }

    public final void f0(boolean isDialog, boolean manual) {
        if (TextUtils.isEmpty(this.sourceName) || TextUtils.isEmpty(this.sourceId)) {
            return;
        }
        if (manual || this.lastBookwormBookRequestTime + 60000 <= System.currentTimeMillis()) {
            this.lastBookwormBookRequestTime = System.currentTimeMillis();
            BaseViewModel.k(this, new ReadingViewModel$getBookwormRecommend$1(this, isDialog, null), new ReadingViewModel$getBookwormRecommend$2(isDialog, this, null), false, 4, null);
        }
    }

    public final b1.b f1(Context r22) {
        return new e(r22);
    }

    public final void f3(boolean z10) {
        this.isSelfTriggeredRefreshTheme = z10;
    }

    public final void g1() {
        ReadingViewModel readingViewModel;
        Integer num;
        List<Pair<String, Integer>> list;
        if (this.readingHintsWithWeights == null) {
            List<Pair<String, Integer>> mutableListOf = CollectionsKt.mutableListOf(TuplesKt.to("点击屏幕中央可以呼出菜单", 1), TuplesKt.to("长按段落可以写段评哦", 1), TuplesKt.to("菜单里可以设置夜间模式", 1), TuplesKt.to("菜单里可以启动听书", 1), TuplesKt.to("菜单里可以缓存章节", 1), TuplesKt.to("菜单-目录可以查看书籍信息", 1), TuplesKt.to("菜单-设置可以切换翻页模式", 1), TuplesKt.to("菜单-设置可以调整字体大小", 1), TuplesKt.to("菜单-设置可以调整行间距", 1), TuplesKt.to("菜单-设置可以调整屏幕亮度", 1), TuplesKt.to("菜单-设置可以调整背景和文字", 1), TuplesKt.to("菜单-设置可以设置图片背景", 1), TuplesKt.to("菜单-设置可以设置个性化字体", 1), TuplesKt.to("菜单-设置可以开启自动阅读", 1), TuplesKt.to("菜单-设置可以开启极简模式", 1), TuplesKt.to("菜单-更多里可以查看书评", 1), TuplesKt.to("菜单-更多里可以添加书签", 1), TuplesKt.to("菜单-更多设置里可以设置单手模式", 1), TuplesKt.to("菜单-更多设置里可以设置简繁体", 1), TuplesKt.to("菜单-更多设置里可以设置屏幕关闭时间", 1));
            readingViewModel = this;
            readingViewModel.readingHintsWithWeights = mutableListOf;
            if (readingViewModel.isVip) {
                if (mutableListOf != null) {
                    mutableListOf.add(TuplesKt.to("会员可以使用酷炫主题", 1));
                }
                List<Pair<String, Integer>> list2 = readingViewModel.readingHintsWithWeights;
                if (list2 != null) {
                    list2.add(TuplesKt.to("会员可以使用专属字体", 1));
                }
                List<Pair<String, Integer>> list3 = readingViewModel.readingHintsWithWeights;
                if (list3 != null) {
                    list3.add(TuplesKt.to("会员可以使用自动阅读", 1));
                }
                List<Pair<String, Integer>> list4 = readingViewModel.readingHintsWithWeights;
                if (list4 != null) {
                    list4.add(TuplesKt.to("会员可以使用音量键翻页", 1));
                }
            } else {
                if (mutableListOf != null) {
                    mutableListOf.add(TuplesKt.to("开通会员可以免广告看书", 1));
                }
                List<Pair<String, Integer>> list5 = readingViewModel.readingHintsWithWeights;
                if (list5 != null) {
                    list5.add(TuplesKt.to("开通会员可以无限听书", 1));
                }
                List<Pair<String, Integer>> list6 = readingViewModel.readingHintsWithWeights;
                if (list6 != null) {
                    list6.add(TuplesKt.to("开通会员可以缓存全部章节", 1));
                }
                List<Pair<String, Integer>> list7 = readingViewModel.readingHintsWithWeights;
                if (list7 != null) {
                    list7.add(TuplesKt.to("开通会员可以使用酷炫主题", 1));
                }
                List<Pair<String, Integer>> list8 = readingViewModel.readingHintsWithWeights;
                if (list8 != null) {
                    list8.add(TuplesKt.to("开通会员可以使用专属字体", 1));
                }
                List<Pair<String, Integer>> list9 = readingViewModel.readingHintsWithWeights;
                if (list9 != null) {
                    list9.add(TuplesKt.to("开通会员可以自动阅读", 1));
                }
                List<Pair<String, Integer>> list10 = readingViewModel.readingHintsWithWeights;
                if (list10 != null) {
                    list10.add(TuplesKt.to("开通会员可以音量键翻页", 1));
                }
            }
            if (!readingViewModel.isVip && !MiConfigSingleton.b2().C2() && (list = readingViewModel.readingHintsWithWeights) != null) {
                list.add(TuplesKt.to("点击领取免广告时长", 10));
            }
            List<Pair<String, Integer>> list11 = readingViewModel.readingHintsWithWeights;
            if (list11 != null) {
                Iterator<T> it = list11.iterator();
                int i10 = 0;
                while (it.hasNext()) {
                    i10 += ((Number) ((Pair) it.next()).getSecond()).intValue();
                }
                num = Integer.valueOf(i10);
            } else {
                num = null;
            }
            Intrinsics.checkNotNull(num);
            readingViewModel.hintsTotalWeight = num.intValue();
        } else {
            readingViewModel = this;
        }
        int nextInt = Random.INSTANCE.nextInt(0, readingViewModel.hintsTotalWeight);
        List<Pair<String, Integer>> list12 = readingViewModel.readingHintsWithWeights;
        Intrinsics.checkNotNull(list12);
        int i11 = 0;
        for (Pair<String, Integer> pair : list12) {
            String component1 = pair.component1();
            i11 += pair.component2().intValue();
            if (nextInt < i11) {
                readingViewModel.readingHint = ExtKt.c(component1);
                return;
            }
        }
    }

    public final void g2() {
        this._mRefreshSlideModeLiveData.postValue(Unit.INSTANCE);
    }

    public final void g3(boolean z10) {
        this.isSelfTriggeredRefreshTypeface = z10;
    }

    /* renamed from: h0, reason: from getter */
    public final int getCacheIndex() {
        return this.cacheIndex;
    }

    /* renamed from: h1, reason: from getter */
    public final boolean getPrefShowBottomStatus() {
        return this.prefShowBottomStatus;
    }

    public final void h2(@k Activity r82) {
        Intrinsics.checkNotNullParameter(r82, "activity");
        BaseViewModel.k(this, new ReadingViewModel$onPageSlide$1(this, r82, null), null, false, 6, null);
    }

    public final void h3(boolean z10) {
        this.showBookComment = z10;
    }

    /* renamed from: i0, reason: from getter */
    public final int getCacheProgress() {
        return this.cacheProgress;
    }

    /* renamed from: i1, reason: from getter */
    public final boolean getPrefShowBottomTips() {
        return this.prefShowBottomTips;
    }

    public final void i2() {
        boolean z10 = this.localChapterList == null;
        MiConfigSingleton.b2().M1().m(this.book, this.chapterListRetry, z10, false, new g(z10, this));
    }

    public final void i3(boolean z10) {
        this.showChapterComment = z10;
    }

    @l
    /* renamed from: j0, reason: from getter */
    public final String getCacheProgressString() {
        return this.cacheProgressString;
    }

    /* renamed from: j1, reason: from getter */
    public final boolean getPrefShowFloatBonus() {
        return this.prefShowFloatBonus;
    }

    public final void j2() {
        this.readingHintsWithWeights = null;
        g1();
    }

    public final void j3(boolean z10) {
        this.showFloatItems = z10;
    }

    /* renamed from: k0, reason: from getter */
    public final int getCacheStartIndex() {
        return this.cacheStartIndex;
    }

    /* renamed from: k1, reason: from getter */
    public final boolean getPrefShowFloatMenu() {
        return this.prefShowFloatMenu;
    }

    public final void k2(int duration, @l Boolean isVipChapter, @l String chapterId) {
        BaseViewModel.k(this, new ReadingViewModel$rtBonus$1(this, duration, isVipChapter, chapterId, null), new ReadingViewModel$rtBonus$2(this, null), false, 4, null);
    }

    public final void k3(@l String str) {
        this.sourceId = str;
    }

    @k
    /* renamed from: l0, reason: from getter */
    public final CacheStatus getCacheStatus() {
        return this.cacheStatus;
    }

    /* renamed from: l1, reason: from getter */
    public final int getProcessSeconds() {
        return this.processSeconds;
    }

    public final void l2() {
        if (Z1()) {
            return;
        }
        try {
            MiReadingRecord miReadingRecord = this.record;
            if (miReadingRecord == null || this.book == null) {
                return;
            }
            if (miReadingRecord != null) {
                miReadingRecord.setAudiobook(0);
            }
            MiConfigSingleton.b2().M1().C0(this.book, this.record);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void l3(@l String str) {
        this.sourceName = str;
    }

    @l
    public final Map<String, Long> m0() {
        if (this.chapterIdInfos == null) {
            this.chapterIdInfos = new HashMap();
        }
        return this.chapterIdInfos;
    }

    /* renamed from: m1, reason: from getter */
    public final int getPullDownMarkFlag() {
        return this.pullDownMarkFlag;
    }

    public final void m2(boolean z10) {
        this.adBook = z10;
    }

    public final void m3(@l String str) {
        this.sourceString = str;
    }

    /* renamed from: n0, reason: from getter */
    public final int getCom.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String() {
        return this.com.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String;
    }

    public final boolean n1(int r32) {
        return ((this.pullDownMarkFlag >> (r32 - 1)) & 1) > 0;
    }

    public final void n2(boolean z10) {
        this.adHiding = z10;
    }

    public final void n3(int i10) {
        this.statusBarMode = i10;
    }

    @l
    /* renamed from: o0, reason: from getter */
    public final ChapterList getChapterList() {
        return this.chapterList;
    }

    public final void o1() {
        BaseViewModel.k(this, new ReadingViewModel$getReaderBookInfo$1(this, null), new ReadingViewModel$getReaderBookInfo$2(this, null), false, 4, null);
    }

    public final void o2(@l Book book) {
        this.book = book;
    }

    public final void o3(int i10) {
        this.totalCoins = i10;
    }

    /* renamed from: p0, reason: from getter */
    public final int getChapterListRetry() {
        return this.chapterListRetry;
    }

    @l
    /* renamed from: p1, reason: from getter */
    public final String getReadingHint() {
        return this.readingHint;
    }

    public final void p2(boolean z10) {
        this.bookInfoUpdated = z10;
    }

    public final void p3(int i10) {
        this.totalSeconds = i10;
    }

    /* renamed from: q0, reason: from getter */
    public final boolean getCloseNetworkOffCheck() {
        return this.closeNetworkOffCheck;
    }

    @l
    /* renamed from: q1, reason: from getter */
    public final ReadingInfo getReadingInfo() {
        return this.readingInfo;
    }

    public final void q2(@l String str) {
        this.bookName = str;
    }

    public final void q3(@l TYBookTopUser tYBookTopUser) {
        this.tyBookTopUser = tYBookTopUser;
    }

    @l
    /* renamed from: r0, reason: from getter */
    public final MiReadingTheme getCustomTheme() {
        return this.customTheme;
    }

    /* renamed from: r1, reason: from getter */
    public final int getReadingNotchHeight() {
        return this.readingNotchHeight;
    }

    public final void r2(int i10) {
        this.cacheIndex = i10;
    }

    public final void r3(int i10) {
        this.videoUnlockChapterIndex = i10;
    }

    /* renamed from: s0, reason: from getter */
    public final boolean getEnableBaeAdInfo() {
        return this.enableBaeAdInfo;
    }

    public final void s1(boolean recordFirst, Integer r52, Integer contentIndex, Integer contentLength) {
        MiReadingRecord J = MiConfigSingleton.b2().M1().J(this.sourceString);
        if (J == null || !recordFirst) {
            int i10 = U1() ? -1 : 0;
            MiReadingRecord miReadingRecord = new MiReadingRecord();
            miReadingRecord.setRecordRead(J == null);
            miReadingRecord.setSourceString(this.sourceString);
            if (r52 != null && r52.intValue() >= 0) {
                i10 = r52.intValue();
            }
            miReadingRecord.setChapterIndex(Integer.valueOf(i10));
            miReadingRecord.setContentPos(contentIndex);
            if (contentLength != null && contentLength.intValue() > 0) {
                miReadingRecord.setContentLength(contentLength);
            }
            miReadingRecord.setBookName(e0());
            J = miReadingRecord;
        } else if (ba.l.q(J.getSourceString())) {
            J.setSourceString(this.sourceString);
            J.setChapterIndex(0);
            J.setContentPos(0);
        }
        if (J.needRecord()) {
            if (J.getContentPos() != null) {
                Integer contentPos = J.getContentPos();
                Intrinsics.checkNotNullExpressionValue(contentPos, "getContentPos(...)");
                if (contentPos.intValue() > 0) {
                    this.recordReadType = RecordReadType.RECORD_HALFWAY;
                }
            }
            this.recordReadType = RecordReadType.RECORD;
        }
        this.record = J;
    }

    public final void s2(int i10) {
        this.cacheProgress = i10;
    }

    public final void s3(boolean z10) {
        this.isVip = z10;
    }

    public final void t0(int pageSize) {
        j(new ReadingViewModel$getExitReadingRecommendBookList$1(this, pageSize, null), new ReadingViewModel$getExitReadingRecommendBookList$2(this, null), false);
    }

    @l
    /* renamed from: t1, reason: from getter */
    public final String getRecommend() {
        return this.recommend;
    }

    public final void t2(@l String str) {
        this.cacheProgressString = str;
    }

    public final void t3(boolean z10) {
        this.waitForFreeReadWithAd = z10;
    }

    /* renamed from: u0, reason: from getter */
    public final boolean getFromIntent() {
        return this.fromIntent;
    }

    @l
    public final List<TYBookItem> u1() {
        return this.recommendBooks;
    }

    public final void u2(int i10) {
        this.cacheStartIndex = i10;
    }

    public final boolean u3(@k Context r22) {
        Intrinsics.checkNotNullParameter(r22, "context");
        return this.isVip || this.adHiding || ReadingInstance.z().y0(r22);
    }

    /* renamed from: v0, reason: from getter */
    public final int getFullSeconds() {
        return this.fullSeconds;
    }

    @l
    /* renamed from: v1, reason: from getter */
    public final String getRecommendId() {
        return this.recommendId;
    }

    public final void v2(@k CacheStatus cacheStatus) {
        Intrinsics.checkNotNullParameter(cacheStatus, "<set-?>");
        this.cacheStatus = cacheStatus;
    }

    public final void v3(@l Context r12, int start) {
        ChapterList chapterList;
        if (r12 == null || (chapterList = this.chapterList) == null || (chapterList != null && chapterList.getCount() == 0)) {
            t0.b(r12, "章节信息加载失败");
            return;
        }
        CacheStatus cacheStatus = this.cacheStatus;
        CacheStatus cacheStatus2 = CacheStatus.Caching;
        if (cacheStatus == cacheStatus2) {
            t0.b(r12, "正在缓存中");
            return;
        }
        int max = Math.max(start, this.cacheIndex);
        this.cacheProgressString = "";
        this._mStartCacheBookLiveData.postValue(0);
        ChapterList chapterList2 = this.chapterList;
        Intrinsics.checkNotNull(chapterList2);
        int count = chapterList2.getCount();
        if (max >= count) {
            this._mStartCacheBookLiveData.postValue(1);
            t0.b(r12, "全部章节已缓存");
        } else {
            this.cacheStatusChangedListener = f1(r12);
            this.cacheStatus = cacheStatus2;
            Coroutine.onSuccess$default(Coroutine.Companion.async$default(Coroutine.INSTANCE, null, null, null, null, new ReadingViewModel$startCacheContents$1(max, count, this, null), 15, null), null, new ReadingViewModel$startCacheContents$2(this, null), 1, null);
        }
    }

    public final void w0(@k GetCommentByScoreParams params, int pageSize) {
        Intrinsics.checkNotNullParameter(params, "params");
        BaseViewModel.k(this, new ReadingViewModel$getHotBookComment$1(params, pageSize, this, null), new ReadingViewModel$getHotBookComment$2(this, null), false, 4, null);
    }

    @l
    /* renamed from: w1, reason: from getter */
    public final MiReadingRecord getRecord() {
        return this.record;
    }

    public final void w2(@l Map<String, Long> map) {
        this.chapterIdInfos = map;
    }

    @k
    public final BookInfo w3() {
        BookInfo bookInfo = new BookInfo(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262143, null);
        bookInfo.setRecommend(this.recommend);
        bookInfo.setRecommendId(this.recommendId);
        bookInfo.setContext(this.recContext);
        bookInfo.setSourceId(this.sourceId);
        bookInfo.setSourceName(this.sourceName);
        bookInfo.setBookName(e0());
        Book book = this.book;
        bookInfo.setAuthorName(book != null ? book.getAuthor() : null);
        return bookInfo;
    }

    @k
    /* renamed from: x1, reason: from getter */
    public final RecordReadType getRecordReadType() {
        return this.recordReadType;
    }

    public final void x2(int i10) {
        if (this.com.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String == i10) {
            this.com.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String = i10;
        } else {
            this.com.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String = i10;
            this._mChapterIndexLiveData.postValue(Integer.valueOf(i10));
        }
    }

    public final void x3() {
        if (this.cacheStatusChangedListener == null || this.cacheStatus == CacheStatus.None) {
            return;
        }
        MiConfigSingleton.b2().P1().x(this.book, this.cacheStatusChangedListener);
    }

    @l
    public final List<Comment> y0() {
        return this.hotComments;
    }

    /* renamed from: y1, reason: from getter */
    public final boolean getResetPageContent() {
        return this.resetPageContent;
    }

    public final void y2(@l ChapterList chapterList) {
        this.chapterList = chapterList;
    }

    public final void y3(int seconds) {
        this.processSeconds = seconds;
        this._mProcessSecondsLiveData.postValue(Integer.valueOf(seconds));
    }

    /* renamed from: z0, reason: from getter */
    public final int getInterstitialInterval() {
        return this.interstitialInterval;
    }

    /* renamed from: z1, reason: from getter */
    public final boolean getShowBookComment() {
        return this.showBookComment;
    }

    public final void z2(int i10) {
        this.chapterListRetry = i10;
    }

    public final void z3(@l String chapterId, @l String chapterName) {
        BaseViewModel.k(this, new ReadingViewModel$videoBonusComplete$1(this, chapterId, chapterName, null), new ReadingViewModel$videoBonusComplete$2(this, null), false, 4, null);
    }
}
