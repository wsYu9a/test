package com.martian.mibook.mvvm.ui.viewmodel;

import android.app.Application;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import ba.g;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p0.t;
import com.martian.libmars.activity.PermissionActivity;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.VipStatusRetryInfo;
import com.martian.mibook.lib.account.response.BonusPool;
import com.martian.mibook.lib.account.response.CheckinResult;
import com.martian.mibook.lib.account.response.ExchangeMoney;
import com.martian.mibook.lib.account.response.IntervalBonus;
import com.martian.mibook.lib.account.response.MiTaskAccount;
import com.martian.mibook.lib.yuewen.response.TYInitialBook;
import com.martian.mibook.mvvm.base.AppBaseViewModel;
import com.martian.mibook.mvvm.net.ErrorResult;
import com.martian.mibook.mvvm.tts.NonStickyLiveData;
import com.martian.mibook.mvvm.ui.repository.AppRepository;
import com.martian.rpauth.response.MartianRPAccount;
import com.umeng.analytics.pro.bt;
import java.io.File;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;
import y8.c;
import z8.e;

@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ%\u0010\u000e\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u0015\u0010\u0014J\r\u0010\u0016\u001a\u00020\u0007¢\u0006\u0004\b\u0016\u0010\tJ\r\u0010\u0017\u001a\u00020\u0007¢\u0006\u0004\b\u0017\u0010\tJ\r\u0010\u0018\u001a\u00020\u0007¢\u0006\u0004\b\u0018\u0010\tJ\r\u0010\u0019\u001a\u00020\u0007¢\u0006\u0004\b\u0019\u0010\tJ\r\u0010\u001a\u001a\u00020\u0007¢\u0006\u0004\b\u001a\u0010\tJ\u0015\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\f¢\u0006\u0004\b\u001c\u0010\u0014J\r\u0010\u001d\u001a\u00020\u0007¢\u0006\u0004\b\u001d\u0010\tJ\u0015\u0010 \u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001a\u00020\u0007¢\u0006\u0004\b$\u0010\tJ\u0019\u0010'\u001a\u0004\u0018\u00010&2\b\b\u0002\u0010%\u001a\u00020\f¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\u0007¢\u0006\u0004\b)\u0010\tJ+\u0010-\u001a\u00020\u00072\b\u0010*\u001a\u0004\u0018\u00010&2\u0006\u0010+\u001a\u00020&2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010&¢\u0006\u0004\b-\u0010.J\u0017\u00100\u001a\u00020\u00072\b\b\u0002\u0010/\u001a\u00020\f¢\u0006\u0004\b0\u0010\u0014J\r\u00101\u001a\u00020\u0007¢\u0006\u0004\b1\u0010\tJ\r\u00102\u001a\u00020\u0007¢\u0006\u0004\b2\u0010\tJ%\u00107\u001a\u00020\u00072\n\b\u0002\u00104\u001a\u0004\u0018\u0001032\n\b\u0002\u00106\u001a\u0004\u0018\u000105¢\u0006\u0004\b7\u00108J\u001d\u0010;\u001a\u00020\u00072\u0006\u00109\u001a\u00020&2\u0006\u0010:\u001a\u000203¢\u0006\u0004\b;\u0010<J\u0017\u0010>\u001a\u00020\u00072\b\u0010=\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b>\u0010?J\r\u0010@\u001a\u00020\u0007¢\u0006\u0004\b@\u0010\tJ\u000f\u0010A\u001a\u00020\u0007H\u0014¢\u0006\u0004\bA\u0010\tR\u001c\u0010F\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010C0B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u001f\u0010J\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010C0B8\u0006¢\u0006\f\n\u0004\bG\u0010E\u001a\u0004\bH\u0010IR\u001a\u0010M\u001a\b\u0012\u0004\u0012\u00020K0B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010ER\u001d\u0010P\u001a\b\u0012\u0004\u0012\u00020K0B8\u0006¢\u0006\f\n\u0004\bN\u0010E\u001a\u0004\bO\u0010IR\u001c\u0010S\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010Q0B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010ER\u001f\u0010V\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010Q0B8\u0006¢\u0006\f\n\u0004\bT\u0010E\u001a\u0004\bU\u0010IR\u001a\u0010X\u001a\b\u0012\u0004\u0012\u00020K0B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010ER\u001d\u0010[\u001a\b\u0012\u0004\u0012\u00020K0B8\u0006¢\u0006\f\n\u0004\bY\u0010E\u001a\u0004\bZ\u0010IR\u001c\u0010^\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\\0B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010ER\u001f\u0010a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\\0B8\u0006¢\u0006\f\n\u0004\b_\u0010E\u001a\u0004\b`\u0010IR\u001a\u0010c\u001a\b\u0012\u0004\u0012\u00020K0B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bb\u0010ER\u001d\u0010f\u001a\b\u0012\u0004\u0012\u00020K0B8\u0006¢\u0006\f\n\u0004\bd\u0010E\u001a\u0004\be\u0010IR\u001c\u0010i\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010g0B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010ER\u001f\u0010l\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010g0B8\u0006¢\u0006\f\n\u0004\bj\u0010E\u001a\u0004\bk\u0010IR\u001c\u0010o\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010m0B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bn\u0010ER\u001f\u0010r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010m0B8\u0006¢\u0006\f\n\u0004\bp\u0010E\u001a\u0004\bq\u0010IR\u001a\u0010t\u001a\b\u0012\u0004\u0012\u00020K0B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bs\u0010ER\u001d\u0010w\u001a\b\u0012\u0004\u0012\u00020K0B8\u0006¢\u0006\f\n\u0004\bu\u0010E\u001a\u0004\bv\u0010IR\u001c\u0010y\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010m0B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bx\u0010ER\u001f\u0010|\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010m0B8\u0006¢\u0006\f\n\u0004\bz\u0010E\u001a\u0004\b{\u0010IR\u001c\u0010\u007f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010}0B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b~\u0010ER\"\u0010\u0082\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010}0B8\u0006¢\u0006\u000e\n\u0005\b\u0080\u0001\u0010E\u001a\u0005\b\u0081\u0001\u0010IR\u001c\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00020K0B8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0083\u0001\u0010ER \u0010\u0087\u0001\u001a\b\u0012\u0004\u0012\u00020K0B8\u0006¢\u0006\u000e\n\u0005\b\u0085\u0001\u0010E\u001a\u0005\b\u0086\u0001\u0010IR\u001e\u0010\u008b\u0001\u001a\t\u0012\u0004\u0012\u00020\f0\u0088\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R#\u0010\u008f\u0001\u001a\t\u0012\u0004\u0012\u00020\f0\u0088\u00018\u0006¢\u0006\u0010\n\u0006\b\u008c\u0001\u0010\u008a\u0001\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R\u001e\u0010\u0091\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070\u0088\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u008a\u0001R\"\u0010\u0093\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070\u0088\u00018\u0006¢\u0006\u000f\n\u0005\b\u0019\u0010\u008a\u0001\u001a\u0006\b\u0092\u0001\u0010\u008e\u0001R\u001f\u0010\u0094\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0088\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0017\u0010\u008a\u0001R$\u0010\u0096\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0088\u00018\u0006¢\u0006\u000f\n\u0005\b-\u0010\u008a\u0001\u001a\u0006\b\u0095\u0001\u0010\u008e\u0001R \u0010\u0098\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0088\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u008a\u0001R$\u0010\u009a\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0088\u00018\u0006¢\u0006\u000f\n\u0005\b\u0018\u0010\u008a\u0001\u001a\u0006\b\u0099\u0001\u0010\u008e\u0001R0\u0010\u009c\u0001\u001a\u001c\u0012\u0017\u0012\u0015\u0012\u0006\u0012\u0004\u0018\u000103\u0012\u0006\u0012\u0004\u0018\u000105\u0018\u00010\u009b\u00010\u0088\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bv\u0010\u008a\u0001R5\u0010\u009e\u0001\u001a\u001c\u0012\u0017\u0012\u0015\u0012\u0006\u0012\u0004\u0018\u000103\u0012\u0006\u0012\u0004\u0018\u000105\u0018\u00010\u009b\u00010\u0088\u00018\u0006¢\u0006\u000f\n\u0005\bq\u0010\u008a\u0001\u001a\u0006\b\u009d\u0001\u0010\u008e\u0001R*\u0010\u009f\u0001\u001a\u0016\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u0002030\u009b\u00010\u0088\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bk\u0010\u008a\u0001R/\u0010¡\u0001\u001a\u0016\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u0002030\u009b\u00010\u0088\u00018\u0006¢\u0006\u000f\n\u0005\be\u0010\u008a\u0001\u001a\u0006\b \u0001\u0010\u008e\u0001R&\u0010£\u0001\u001a\u0012\u0012\r\u0012\u000b\u0012\u0004\u0012\u00020&\u0018\u00010¢\u00010\u0088\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b`\u0010\u008a\u0001R,\u0010¦\u0001\u001a\u0012\u0012\r\u0012\u000b\u0012\u0004\u0012\u00020&\u0018\u00010¢\u00010\u0088\u00018\u0006¢\u0006\u0010\n\u0006\b¤\u0001\u0010\u008a\u0001\u001a\u0006\b¥\u0001\u0010\u008e\u0001R4\u0010©\u0001\u001a\u0017\u0012\u0013\u0012\u0011\u0012\u0004\u0012\u000203\u0012\u0006\u0012\u0004\u0018\u0001050\u009b\u00010B8BX\u0082\u0084\u0002¢\u0006\u000f\n\u0006\b\u0086\u0001\u0010§\u0001\u001a\u0005\b¨\u0001\u0010IR/\u0010ª\u0001\u001a\u0017\u0012\u0013\u0012\u0011\u0012\u0004\u0012\u000203\u0012\u0006\u0012\u0004\u0018\u0001050\u009b\u00010B8\u0006¢\u0006\u000e\n\u0005\b\u0081\u0001\u0010E\u001a\u0005\b¤\u0001\u0010IR\u001e\u0010«\u0001\u001a\t\u0012\u0004\u0012\u00020\f0\u0088\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008a\u0001R\"\u0010\u00ad\u0001\u001a\t\u0012\u0004\u0012\u00020\f0\u0088\u00018\u0006¢\u0006\u000f\n\u0005\b{\u0010\u008a\u0001\u001a\u0006\b¬\u0001\u0010\u008e\u0001R\u001f\u0010®\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u0088\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bO\u0010\u008a\u0001R$\u0010°\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u0088\u00018\u0006¢\u0006\u000f\n\u0005\bH\u0010\u008a\u0001\u001a\u0006\b¯\u0001\u0010\u008e\u0001R\u001f\u0010±\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0088\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bZ\u0010\u008a\u0001R$\u0010³\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0088\u00018\u0006¢\u0006\u000f\n\u0005\bU\u0010\u008a\u0001\u001a\u0006\b²\u0001\u0010\u008e\u0001R\u001e\u0010´\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070B8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b²\u0001\u0010ER \u0010¶\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070B8\u0006¢\u0006\u000e\n\u0005\b¬\u0001\u0010E\u001a\u0005\bµ\u0001\u0010IR\u0018\u0010·\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¥\u0001\u0010ZR\u001c\u0010º\u0001\u001a\u0005\u0018\u00010¸\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0001\u0010¹\u0001R\u0018\u0010»\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009d\u0001\u0010ZR\"\u0010½\u0001\u001a\u000b\u0012\u0004\u0012\u00020&\u0018\u00010¢\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b \u0001\u0010¼\u0001R\u0018\u0010¾\u0001\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0092\u0001\u0010\u0019R\u0018\u0010¿\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0095\u0001\u0010ZR\u001c\u0010Â\u0001\u001a\u0005\u0018\u00010À\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0001\u0010Á\u0001¨\u0006Ã\u0001"}, d2 = {"Lcom/martian/mibook/mvvm/ui/viewmodel/AppViewModel;", "Lcom/martian/mibook/mvvm/base/AppBaseViewModel;", "Lcom/martian/mibook/mvvm/ui/repository/AppRepository;", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "", "E0", "()V", "Landroidx/fragment/app/FragmentActivity;", TTDownloadField.TT_ACTIVITY, "", "immediately", "K0", "(Landroidx/fragment/app/FragmentActivity;Ljava/lang/Boolean;)V", "u0", "()Lcom/martian/mibook/mvvm/ui/repository/AppRepository;", "retry", "l0", "(Z)V", "F0", "n0", "J", "M", "I", "J0", "enable", "M0", "s0", "Lcom/martian/mibook/lib/yuewen/response/TYInitialBook;", "tyInitialBook", "H0", "(Lcom/martian/mibook/lib/yuewen/response/TYInitialBook;)V", "t0", "(Landroidx/fragment/app/FragmentActivity;)V", "q0", "isAddIndex", "", "o0", "(Z)Ljava/lang/String;", "I0", TTDownloadField.TT_DOWNLOAD_URL, TTDownloadField.TT_FILE_PATH, "suffix", "K", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "isUpdateViewTheme", "v0", "x0", "y0", "", PermissionActivity.f12046p, "", "value", "z0", "(Ljava/lang/Integer;Ljava/lang/Object;)V", "sourceString", "score", "B0", "(Ljava/lang/String;I)V", "isReset", "D0", "(Ljava/lang/Boolean;)V", "C0", "onCleared", "Lcom/martian/mibook/mvvm/tts/NonStickyLiveData;", "Lcom/martian/rpauth/response/MartianRPAccount;", "h", "Lcom/martian/mibook/mvvm/tts/NonStickyLiveData;", "_mMiRpAccountLiveData", "i", "Y", "()Lcom/martian/mibook/mvvm/tts/NonStickyLiveData;", "mMiRpAccountLiveData", "Lcom/martian/mibook/mvvm/net/ErrorResult;", "j", "_mMiRpAccountErrorLiveData", "k", "X", "mMiRpAccountErrorLiveData", "Lcom/martian/mibook/lib/account/response/MiTaskAccount;", t.f11204d, "_mMiTaskAccountLiveData", "m", "a0", "mMiTaskAccountLiveData", "n", "_mMiTaskAccountErrorLiveData", "o", "Z", "mMiTaskAccountErrorLiveData", "Lcom/martian/mibook/lib/account/response/CheckinResult;", "p", "_mCheckInResultLiveData", "q", "R", "mCheckInResultLiveData", t.f11211k, "_mCheckInErrorLiveData", "s", "Q", "mCheckInErrorLiveData", "Lcom/martian/mibook/lib/account/response/BonusPool;", bt.aO, "_mBonusPoolLiveData", "u", "P", "mBonusPoolLiveData", "Lcom/martian/mibook/lib/account/response/IntervalBonus;", "v", "_mAcquireIntervalBonusLiveData", IAdInterListener.AdReqParam.WIDTH, "O", "mAcquireIntervalBonusLiveData", "x", "_mAcquireIntervalBonusErrorLiveData", "y", "N", "mAcquireIntervalBonusErrorLiveData", bt.aJ, "_mIntervalBonusLiveData", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, ExifInterface.LONGITUDE_WEST, "mIntervalBonusLiveData", "Lcom/martian/mibook/lib/account/response/ExchangeMoney;", "B", "_mGrabFreshRedPaperLiveData", "C", "U", "mGrabFreshRedPaperLiveData", "D", "_mGrabFreshRedPaperErrorLiveData", ExifInterface.LONGITUDE_EAST, ExifInterface.GPS_DIRECTION_TRUE, "mGrabFreshRedPaperErrorLiveData", "Landroidx/lifecycle/MutableLiveData;", "F", "Landroidx/lifecycle/MutableLiveData;", "_mInitBookShelfLiveData", "G", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "()Landroidx/lifecycle/MutableLiveData;", "mInitBookShelfLiveData", "H", "_mUpdateNightModeLiveData", "h0", "mUpdateNightModeLiveData", "_mUpdateReaderThemeViewLiveData", "i0", "mUpdateReaderThemeViewLiveData", "L", "_mUpdateReaderTypefaceLiveData", "j0", "mUpdateReaderTypefaceLiveData", "Lkotlin/Pair;", "_mUpdateCommentLiveData", "f0", "mUpdateCommentLiveData", "_mUpdateCommentingStarLiveData", "g0", "mUpdateCommentingStarLiveData", "", "_mSearchTipsLiveData", ExifInterface.LATITUDE_SOUTH, "d0", "mSearchTipsLiveData", "Lkotlin/Lazy;", "r0", "_mDownloadGoogleTtsLiveData", "mDownloadGoogleTtsLiveData", "_mReadAloudServiceStartStatusLiveData", "c0", "mReadAloudServiceStartStatusLiveData", "_mShowBookPromoteWindowLiveData", "e0", "mShowBookPromoteWindowLiveData", "_mNotifyVipThemeTypeFaceExpiredTips", "b0", "mNotifyVipThemeTypeFaceExpiredTips", "_mVipDialogClosedEventLiveData", "k0", "mVipDialogClosedEventLiveData", "bonusAcquiring", "Lcom/martian/mibook/data/VipStatusRetryInfo;", "Lcom/martian/mibook/data/VipStatusRetryInfo;", "vipStatusRetryInfo", "miRpAccountLoading", "Ljava/util/List;", "searchTips", "searchTipsIndex", "isDownloadingGoogleTts", "Ly8/c;", "Ly8/c;", "fileDownloadTask", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class AppViewModel extends AppBaseViewModel<AppRepository> {

    /* renamed from: A */
    @k
    public final NonStickyLiveData<IntervalBonus> mIntervalBonusLiveData;

    /* renamed from: B, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<ExchangeMoney> _mGrabFreshRedPaperLiveData;

    /* renamed from: C, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<ExchangeMoney> mGrabFreshRedPaperLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<ErrorResult> _mGrabFreshRedPaperErrorLiveData;

    /* renamed from: E */
    @k
    public final NonStickyLiveData<ErrorResult> mGrabFreshRedPaperErrorLiveData;

    /* renamed from: F, reason: from kotlin metadata */
    @k
    public final MutableLiveData<Boolean> _mInitBookShelfLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    @k
    public final MutableLiveData<Boolean> mInitBookShelfLiveData;

    /* renamed from: H, reason: from kotlin metadata */
    @k
    public final MutableLiveData<Unit> _mUpdateNightModeLiveData;

    /* renamed from: I, reason: from kotlin metadata */
    @k
    public final MutableLiveData<Unit> mUpdateNightModeLiveData;

    /* renamed from: J, reason: from kotlin metadata */
    @k
    public final MutableLiveData<Unit> _mUpdateReaderThemeViewLiveData;

    /* renamed from: K, reason: from kotlin metadata */
    @k
    public final MutableLiveData<Unit> mUpdateReaderThemeViewLiveData;

    /* renamed from: L, reason: from kotlin metadata */
    @k
    public final MutableLiveData<Unit> _mUpdateReaderTypefaceLiveData;

    /* renamed from: M, reason: from kotlin metadata */
    @k
    public final MutableLiveData<Unit> mUpdateReaderTypefaceLiveData;

    /* renamed from: N, reason: from kotlin metadata */
    @k
    public final MutableLiveData<Pair<Integer, Object>> _mUpdateCommentLiveData;

    /* renamed from: O, reason: from kotlin metadata */
    @k
    public final MutableLiveData<Pair<Integer, Object>> mUpdateCommentLiveData;

    /* renamed from: P, reason: from kotlin metadata */
    @k
    public final MutableLiveData<Pair<String, Integer>> _mUpdateCommentingStarLiveData;

    /* renamed from: Q, reason: from kotlin metadata */
    @k
    public final MutableLiveData<Pair<String, Integer>> mUpdateCommentingStarLiveData;

    /* renamed from: R, reason: from kotlin metadata */
    @k
    public final MutableLiveData<List<String>> _mSearchTipsLiveData;

    /* renamed from: S */
    @k
    public final MutableLiveData<List<String>> mSearchTipsLiveData;

    /* renamed from: T */
    @k
    public final Lazy _mDownloadGoogleTtsLiveData;

    /* renamed from: U, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<Pair<Integer, Object>> mDownloadGoogleTtsLiveData;

    /* renamed from: V */
    @k
    public final MutableLiveData<Boolean> _mReadAloudServiceStartStatusLiveData;

    /* renamed from: W */
    @k
    public final MutableLiveData<Boolean> mReadAloudServiceStartStatusLiveData;

    /* renamed from: X, reason: from kotlin metadata */
    @k
    public final MutableLiveData<TYInitialBook> _mShowBookPromoteWindowLiveData;

    /* renamed from: Y, reason: from kotlin metadata */
    @k
    public final MutableLiveData<TYInitialBook> mShowBookPromoteWindowLiveData;

    /* renamed from: Z, reason: from kotlin metadata */
    @k
    public final MutableLiveData<Boolean> _mNotifyVipThemeTypeFaceExpiredTips;

    /* renamed from: a0, reason: from kotlin metadata */
    @k
    public final MutableLiveData<Boolean> mNotifyVipThemeTypeFaceExpiredTips;

    /* renamed from: b0, reason: from kotlin metadata */
    @k
    public NonStickyLiveData<Unit> _mVipDialogClosedEventLiveData;

    /* renamed from: c0, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<Unit> mVipDialogClosedEventLiveData;

    /* renamed from: d0, reason: from kotlin metadata */
    public boolean bonusAcquiring;

    /* renamed from: e0, reason: from kotlin metadata */
    @l
    public VipStatusRetryInfo vipStatusRetryInfo;

    /* renamed from: f0, reason: from kotlin metadata */
    public boolean miRpAccountLoading;

    /* renamed from: g0, reason: from kotlin metadata */
    @l
    public List<String> searchTips;

    /* renamed from: h, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<MartianRPAccount> _mMiRpAccountLiveData;

    /* renamed from: h0, reason: from kotlin metadata */
    public int searchTipsIndex;

    /* renamed from: i, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<MartianRPAccount> mMiRpAccountLiveData;

    /* renamed from: i0, reason: from kotlin metadata */
    public boolean isDownloadingGoogleTts;

    /* renamed from: j, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<ErrorResult> _mMiRpAccountErrorLiveData;

    /* renamed from: j0, reason: from kotlin metadata */
    @l
    public c fileDownloadTask;

    /* renamed from: k, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<ErrorResult> mMiRpAccountErrorLiveData;

    /* renamed from: l */
    @k
    public final NonStickyLiveData<MiTaskAccount> _mMiTaskAccountLiveData;

    /* renamed from: m, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<MiTaskAccount> mMiTaskAccountLiveData;

    /* renamed from: n, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<ErrorResult> _mMiTaskAccountErrorLiveData;

    /* renamed from: o, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<ErrorResult> mMiTaskAccountErrorLiveData;

    /* renamed from: p, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<CheckinResult> _mCheckInResultLiveData;

    /* renamed from: q, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<CheckinResult> mCheckInResultLiveData;

    /* renamed from: r */
    @k
    public final NonStickyLiveData<ErrorResult> _mCheckInErrorLiveData;

    /* renamed from: s, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<ErrorResult> mCheckInErrorLiveData;

    /* renamed from: t */
    @k
    public final NonStickyLiveData<BonusPool> _mBonusPoolLiveData;

    /* renamed from: u, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<BonusPool> mBonusPoolLiveData;

    /* renamed from: v, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<IntervalBonus> _mAcquireIntervalBonusLiveData;

    /* renamed from: w */
    @k
    public final NonStickyLiveData<IntervalBonus> mAcquireIntervalBonusLiveData;

    /* renamed from: x, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<ErrorResult> _mAcquireIntervalBonusErrorLiveData;

    /* renamed from: y, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<ErrorResult> mAcquireIntervalBonusErrorLiveData;

    /* renamed from: z */
    @k
    public final NonStickyLiveData<IntervalBonus> _mIntervalBonusLiveData;

    public static final class a implements e.b {

        /* renamed from: b */
        public final /* synthetic */ String f15288b;

        /* renamed from: c */
        public final /* synthetic */ String f15289c;

        /* renamed from: d */
        public final /* synthetic */ String f15290d;

        public a(String str, String str2, String str3) {
            this.f15288b = str;
            this.f15289c = str2;
            this.f15290d = str3;
        }

        @Override // z8.e.b
        public void a(int i10, int i11) {
            AppViewModel.this.isDownloadingGoogleTts = true;
            AppViewModel.this.r0().postValue(new Pair(1, Integer.valueOf((int) ((i10 * 100) / i11))));
        }

        @Override // z8.e.b
        public void b(int i10) {
            AppViewModel.this.r0().postValue(new Pair(2, Unit.INSTANCE));
            File C = g.C(this.f15288b, this.f15290d);
            if (C != null && C.exists()) {
                i8.g.k(AppViewModel.this.getApplication(), C);
            }
            AppViewModel.this.isDownloadingGoogleTts = false;
        }

        @Override // z8.e.b
        public void c(@l x8.c cVar) {
            AppViewModel.this.isDownloadingGoogleTts = false;
            AppViewModel.this.r0().postValue(new Pair(4, cVar != null ? cVar.d() : null));
        }

        @Override // z8.e.b
        public void onCancel() {
            AppViewModel.this.isDownloadingGoogleTts = false;
            AppViewModel.this.r0().postValue(new Pair(3, Unit.INSTANCE));
        }

        @Override // z8.e.b
        public void onStart() {
            AppViewModel.this.isDownloadingGoogleTts = true;
            File file = new File(this.f15288b);
            if (file.exists()) {
                file.delete();
            }
            File file2 = new File(this.f15289c);
            if (file2.exists()) {
                file2.delete();
            }
            AppViewModel.this.r0().postValue(new Pair(1, 0));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppViewModel(@k Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        NonStickyLiveData<MartianRPAccount> nonStickyLiveData = new NonStickyLiveData<>();
        this._mMiRpAccountLiveData = nonStickyLiveData;
        this.mMiRpAccountLiveData = nonStickyLiveData;
        NonStickyLiveData<ErrorResult> nonStickyLiveData2 = new NonStickyLiveData<>();
        this._mMiRpAccountErrorLiveData = nonStickyLiveData2;
        this.mMiRpAccountErrorLiveData = nonStickyLiveData2;
        NonStickyLiveData<MiTaskAccount> nonStickyLiveData3 = new NonStickyLiveData<>();
        this._mMiTaskAccountLiveData = nonStickyLiveData3;
        this.mMiTaskAccountLiveData = nonStickyLiveData3;
        NonStickyLiveData<ErrorResult> nonStickyLiveData4 = new NonStickyLiveData<>();
        this._mMiTaskAccountErrorLiveData = nonStickyLiveData4;
        this.mMiTaskAccountErrorLiveData = nonStickyLiveData4;
        NonStickyLiveData<CheckinResult> nonStickyLiveData5 = new NonStickyLiveData<>();
        this._mCheckInResultLiveData = nonStickyLiveData5;
        this.mCheckInResultLiveData = nonStickyLiveData5;
        NonStickyLiveData<ErrorResult> nonStickyLiveData6 = new NonStickyLiveData<>();
        this._mCheckInErrorLiveData = nonStickyLiveData6;
        this.mCheckInErrorLiveData = nonStickyLiveData6;
        NonStickyLiveData<BonusPool> nonStickyLiveData7 = new NonStickyLiveData<>();
        this._mBonusPoolLiveData = nonStickyLiveData7;
        this.mBonusPoolLiveData = nonStickyLiveData7;
        NonStickyLiveData<IntervalBonus> nonStickyLiveData8 = new NonStickyLiveData<>();
        this._mAcquireIntervalBonusLiveData = nonStickyLiveData8;
        this.mAcquireIntervalBonusLiveData = nonStickyLiveData8;
        NonStickyLiveData<ErrorResult> nonStickyLiveData9 = new NonStickyLiveData<>();
        this._mAcquireIntervalBonusErrorLiveData = nonStickyLiveData9;
        this.mAcquireIntervalBonusErrorLiveData = nonStickyLiveData9;
        NonStickyLiveData<IntervalBonus> nonStickyLiveData10 = new NonStickyLiveData<>();
        this._mIntervalBonusLiveData = nonStickyLiveData10;
        this.mIntervalBonusLiveData = nonStickyLiveData10;
        NonStickyLiveData<ExchangeMoney> nonStickyLiveData11 = new NonStickyLiveData<>();
        this._mGrabFreshRedPaperLiveData = nonStickyLiveData11;
        this.mGrabFreshRedPaperLiveData = nonStickyLiveData11;
        NonStickyLiveData<ErrorResult> nonStickyLiveData12 = new NonStickyLiveData<>();
        this._mGrabFreshRedPaperErrorLiveData = nonStickyLiveData12;
        this.mGrabFreshRedPaperErrorLiveData = nonStickyLiveData12;
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this._mInitBookShelfLiveData = mutableLiveData;
        this.mInitBookShelfLiveData = mutableLiveData;
        MutableLiveData<Unit> mutableLiveData2 = new MutableLiveData<>();
        this._mUpdateNightModeLiveData = mutableLiveData2;
        this.mUpdateNightModeLiveData = mutableLiveData2;
        MutableLiveData<Unit> mutableLiveData3 = new MutableLiveData<>();
        this._mUpdateReaderThemeViewLiveData = mutableLiveData3;
        this.mUpdateReaderThemeViewLiveData = mutableLiveData3;
        MutableLiveData<Unit> mutableLiveData4 = new MutableLiveData<>();
        this._mUpdateReaderTypefaceLiveData = mutableLiveData4;
        this.mUpdateReaderTypefaceLiveData = mutableLiveData4;
        MutableLiveData<Pair<Integer, Object>> mutableLiveData5 = new MutableLiveData<>();
        this._mUpdateCommentLiveData = mutableLiveData5;
        this.mUpdateCommentLiveData = mutableLiveData5;
        MutableLiveData<Pair<String, Integer>> mutableLiveData6 = new MutableLiveData<>();
        this._mUpdateCommentingStarLiveData = mutableLiveData6;
        this.mUpdateCommentingStarLiveData = mutableLiveData6;
        MutableLiveData<List<String>> mutableLiveData7 = new MutableLiveData<>();
        this._mSearchTipsLiveData = mutableLiveData7;
        this.mSearchTipsLiveData = mutableLiveData7;
        this._mDownloadGoogleTtsLiveData = LazyKt.lazy(AppViewModel$_mDownloadGoogleTtsLiveData$2.INSTANCE);
        this.mDownloadGoogleTtsLiveData = r0();
        MutableLiveData<Boolean> mutableLiveData8 = new MutableLiveData<>();
        this._mReadAloudServiceStartStatusLiveData = mutableLiveData8;
        this.mReadAloudServiceStartStatusLiveData = mutableLiveData8;
        MutableLiveData<TYInitialBook> mutableLiveData9 = new MutableLiveData<>();
        this._mShowBookPromoteWindowLiveData = mutableLiveData9;
        this.mShowBookPromoteWindowLiveData = mutableLiveData9;
        MutableLiveData<Boolean> mutableLiveData10 = new MutableLiveData<>();
        this._mNotifyVipThemeTypeFaceExpiredTips = mutableLiveData10;
        this.mNotifyVipThemeTypeFaceExpiredTips = mutableLiveData10;
        NonStickyLiveData<Unit> nonStickyLiveData13 = new NonStickyLiveData<>();
        this._mVipDialogClosedEventLiveData = nonStickyLiveData13;
        this.mVipDialogClosedEventLiveData = nonStickyLiveData13;
        this.searchTipsIndex = -1;
    }

    public static /* synthetic */ void A0(AppViewModel appViewModel, Integer num, Object obj, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            num = 0;
        }
        if ((i10 & 2) != 0) {
            obj = null;
        }
        appViewModel.z0(num, obj);
    }

    public static /* synthetic */ void G0(AppViewModel appViewModel, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        appViewModel.F0(z10);
    }

    public static /* synthetic */ void L(AppViewModel appViewModel, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str3 = ".temp";
        }
        appViewModel.K(str, str2, str3);
    }

    public static /* synthetic */ void L0(AppViewModel appViewModel, FragmentActivity fragmentActivity, Boolean bool, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            bool = Boolean.FALSE;
        }
        appViewModel.K0(fragmentActivity, bool);
    }

    public static /* synthetic */ void m0(AppViewModel appViewModel, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        appViewModel.l0(z10);
    }

    public static /* synthetic */ String p0(AppViewModel appViewModel, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        return appViewModel.o0(z10);
    }

    public static /* synthetic */ void w0(AppViewModel appViewModel, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        appViewModel.v0(z10);
    }

    public final void B0(@k String sourceString, int score) {
        Intrinsics.checkNotNullParameter(sourceString, "sourceString");
        this._mUpdateCommentingStarLiveData.postValue(TuplesKt.to(sourceString, Integer.valueOf(score)));
    }

    public final void C0() {
        this._mVipDialogClosedEventLiveData.postValue(Unit.INSTANCE);
    }

    public final void D0(@l Boolean isReset) {
        this._mNotifyVipThemeTypeFaceExpiredTips.postValue(isReset);
    }

    public final void E0() {
        VipStatusRetryInfo vipStatusRetryInfo = this.vipStatusRetryInfo;
        Long valueOf = vipStatusRetryInfo != null ? Long.valueOf(vipStatusRetryInfo.getVipStatusRetryDelay()) : null;
        if (valueOf == null || valueOf.longValue() <= 0) {
            return;
        }
        AppBaseViewModel.k(this, new AppViewModel$retryGetMiRpAccountInfo$1(valueOf, this, null), null, false, 6, null);
    }

    public final void F0(boolean retry) {
        if (this.vipStatusRetryInfo == null) {
            this.vipStatusRetryInfo = new VipStatusRetryInfo();
        }
        VipStatusRetryInfo vipStatusRetryInfo = this.vipStatusRetryInfo;
        if (vipStatusRetryInfo != null) {
            vipStatusRetryInfo.setVipStatusRetryInfo(retry);
        }
    }

    public final void H0(@k TYInitialBook tyInitialBook) {
        Intrinsics.checkNotNullParameter(tyInitialBook, "tyInitialBook");
        this._mShowBookPromoteWindowLiveData.postValue(tyInitialBook);
    }

    public final void I() {
        if (this.bonusAcquiring) {
            this._mAcquireIntervalBonusErrorLiveData.postValue(new ErrorResult(12, "奖励领取中", null, 4, null));
        } else {
            j(new AppViewModel$acquireIntervalBonus$1(this, null), new AppViewModel$acquireIntervalBonus$2(this, null), true);
        }
    }

    public final void I0() {
        c cVar = this.fileDownloadTask;
        if (cVar != null) {
            cVar.cancel(true);
        }
        this.fileDownloadTask = null;
    }

    public final void J() {
        AppBaseViewModel.k(this, new AppViewModel$checkIn$1(this, null), new AppViewModel$checkIn$2(this, null), false, 4, null);
    }

    public final void J0() {
        if (MiConfigSingleton.b2().e2().C() >= 0 || !MiConfigSingleton.b2().F2()) {
            this._mIntervalBonusLiveData.postValue(null);
        } else {
            j(new AppViewModel$syncIntervalBonus$1(this, null), new AppViewModel$syncIntervalBonus$2(null), false);
        }
    }

    public final void K(@l String r32, @k String r42, @l String suffix) {
        Intrinsics.checkNotNullParameter(r42, "filePath");
        if (this.isDownloadingGoogleTts) {
            return;
        }
        String str = r42 + suffix;
        this.fileDownloadTask = e.c(r32, str, new a(str, r42, suffix));
    }

    public final void K0(FragmentActivity r82, Boolean immediately) {
        if (MiConfigSingleton.b2().M1().q2()) {
            AppBaseViewModel.k(this, new AppViewModel$tryPromoteBook$1(immediately, this, r82, null), new AppViewModel$tryPromoteBook$2(null), false, 4, null);
        }
    }

    public final void M() {
        AppBaseViewModel.k(this, new AppViewModel$getCheckInInfo$1(this, null), null, false, 6, null);
    }

    public final void M0(boolean enable) {
        AppBaseViewModel.k(this, new AppViewModel$updateCheckInNotify$1(this, enable, null), null, false, 6, null);
    }

    @k
    public final NonStickyLiveData<ErrorResult> N() {
        return this.mAcquireIntervalBonusErrorLiveData;
    }

    @k
    public final NonStickyLiveData<IntervalBonus> O() {
        return this.mAcquireIntervalBonusLiveData;
    }

    @k
    public final NonStickyLiveData<BonusPool> P() {
        return this.mBonusPoolLiveData;
    }

    @k
    public final NonStickyLiveData<ErrorResult> Q() {
        return this.mCheckInErrorLiveData;
    }

    @k
    public final NonStickyLiveData<CheckinResult> R() {
        return this.mCheckInResultLiveData;
    }

    @k
    public final NonStickyLiveData<Pair<Integer, Object>> S() {
        return this.mDownloadGoogleTtsLiveData;
    }

    @k
    public final NonStickyLiveData<ErrorResult> T() {
        return this.mGrabFreshRedPaperErrorLiveData;
    }

    @k
    public final NonStickyLiveData<ExchangeMoney> U() {
        return this.mGrabFreshRedPaperLiveData;
    }

    @k
    public final MutableLiveData<Boolean> V() {
        return this.mInitBookShelfLiveData;
    }

    @k
    public final NonStickyLiveData<IntervalBonus> W() {
        return this.mIntervalBonusLiveData;
    }

    @k
    public final NonStickyLiveData<ErrorResult> X() {
        return this.mMiRpAccountErrorLiveData;
    }

    @k
    public final NonStickyLiveData<MartianRPAccount> Y() {
        return this.mMiRpAccountLiveData;
    }

    @k
    public final NonStickyLiveData<ErrorResult> Z() {
        return this.mMiTaskAccountErrorLiveData;
    }

    @k
    public final NonStickyLiveData<MiTaskAccount> a0() {
        return this.mMiTaskAccountLiveData;
    }

    @k
    public final MutableLiveData<Boolean> b0() {
        return this.mNotifyVipThemeTypeFaceExpiredTips;
    }

    @k
    public final MutableLiveData<Boolean> c0() {
        return this.mReadAloudServiceStartStatusLiveData;
    }

    @k
    public final MutableLiveData<List<String>> d0() {
        return this.mSearchTipsLiveData;
    }

    @k
    public final MutableLiveData<TYInitialBook> e0() {
        return this.mShowBookPromoteWindowLiveData;
    }

    @k
    public final MutableLiveData<Pair<Integer, Object>> f0() {
        return this.mUpdateCommentLiveData;
    }

    @k
    public final MutableLiveData<Pair<String, Integer>> g0() {
        return this.mUpdateCommentingStarLiveData;
    }

    @k
    public final MutableLiveData<Unit> h0() {
        return this.mUpdateNightModeLiveData;
    }

    @k
    public final MutableLiveData<Unit> i0() {
        return this.mUpdateReaderThemeViewLiveData;
    }

    @k
    public final MutableLiveData<Unit> j0() {
        return this.mUpdateReaderTypefaceLiveData;
    }

    @k
    public final NonStickyLiveData<Unit> k0() {
        return this.mVipDialogClosedEventLiveData;
    }

    public final void l0(boolean retry) {
        if (this.miRpAccountLoading) {
            return;
        }
        j(new AppViewModel$getMiRpAccountInfo$1(this, retry, null), new AppViewModel$getMiRpAccountInfo$2(this, null), false);
    }

    public final void n0() {
        j(new AppViewModel$getMiTaskAccountInfo$1(this, null), new AppViewModel$getMiTaskAccountInfo$2(this, null), false);
    }

    @l
    public final String o0(boolean isAddIndex) {
        List<String> list = this.searchTips;
        if (list == null || list.isEmpty()) {
            return null;
        }
        if (isAddIndex) {
            this.searchTipsIndex++;
        }
        int i10 = this.searchTipsIndex;
        List<String> list2 = this.searchTips;
        Intrinsics.checkNotNull(list2);
        int size = i10 % list2.size();
        this.searchTipsIndex = size;
        List<String> list3 = this.searchTips;
        if (list3 != null) {
            return list3.get(size);
        }
        return null;
    }

    @Override // com.martian.mibook.mvvm.base.AppBaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this._mMiRpAccountLiveData.a();
        this._mMiRpAccountErrorLiveData.a();
        this._mMiTaskAccountLiveData.a();
        this._mMiTaskAccountErrorLiveData.a();
        this._mCheckInResultLiveData.a();
        this._mCheckInErrorLiveData.a();
        this._mBonusPoolLiveData.a();
        this._mAcquireIntervalBonusLiveData.a();
        this._mAcquireIntervalBonusErrorLiveData.a();
        this._mIntervalBonusLiveData.a();
        this._mGrabFreshRedPaperLiveData.a();
        this._mGrabFreshRedPaperErrorLiveData.a();
    }

    public final void q0() {
        AppBaseViewModel.k(this, new AppViewModel$getSearchTips$1(this, null), new AppViewModel$getSearchTips$2(this, null), false, 4, null);
    }

    public final NonStickyLiveData<Pair<Integer, Object>> r0() {
        return (NonStickyLiveData) this._mDownloadGoogleTtsLiveData.getValue();
    }

    public final void s0() {
        AppBaseViewModel.k(this, new AppViewModel$grabFreshRedPaper$1(this, null), new AppViewModel$grabFreshRedPaper$2(this, null), false, 4, null);
    }

    public final void t0(@l FragmentActivity r92) {
        boolean o12 = MiConfigSingleton.b2().M1().o1();
        boolean X1 = MiConfigSingleton.b2().M1().X1(r92);
        if (o12 || !X1) {
            AppBaseViewModel.k(this, new AppViewModel$initBookShelf$1(this, o12, r92, null), new AppViewModel$initBookShelf$2(this, null), false, 4, null);
        } else {
            this._mInitBookShelfLiveData.postValue(Boolean.FALSE);
        }
        K0(r92, Boolean.TRUE);
    }

    @Override // com.martian.mibook.mvvm.base.AppBaseViewModel
    @k
    /* renamed from: u0 */
    public AppRepository i() {
        return new AppRepository();
    }

    public final void v0(boolean isUpdateViewTheme) {
        if (isUpdateViewTheme) {
            ConfigSingleton.D().q1();
        }
        this._mUpdateNightModeLiveData.postValue(Unit.INSTANCE);
    }

    public final void x0() {
        this._mUpdateReaderThemeViewLiveData.postValue(Unit.INSTANCE);
    }

    public final void y0() {
        ConfigSingleton.D().q1();
        this._mUpdateReaderTypefaceLiveData.postValue(Unit.INSTANCE);
    }

    public final void z0(@l Integer r22, @l Object value) {
        this._mUpdateCommentLiveData.postValue(TuplesKt.to(r22, value));
    }
}
