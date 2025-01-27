package com.martian.mibook.mvvm.payment.viewmodel;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModelKt;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p0.bq;
import com.kuaishou.weapon.p0.t;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.account.MiUserManager;
import com.martian.mibook.lib.account.response.AliRechargeOrder;
import com.martian.mibook.lib.account.response.MiRechargeOrder;
import com.martian.mibook.lib.account.response.WXRechargeOrder;
import com.martian.mibook.mvvm.base.BaseViewModel;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.payment.data.PriceInfo;
import com.martian.mibook.mvvm.payment.data.VipInfo;
import com.martian.mibook.mvvm.payment.data.VipProduct;
import com.martian.mibook.mvvm.payment.repository.VipPayRepository;
import com.martian.mibook.mvvm.tts.NonStickyLiveData;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.f;
import e8.b;
import h3.e;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.JobKt__JobKt;
import l5.c;
import l9.p0;
import l9.t0;
import xi.k;
import xi.l;
import z7.b;
import zc.a;
import zc.b;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\bF\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tH\u0082@¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tH\u0082@¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u0004J\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\t¢\u0006\u0004\b\u001a\u0010\u0004J\r\u0010\u001b\u001a\u00020\t¢\u0006\u0004\b\u001b\u0010\u0004J\u0017\u0010\u001e\u001a\u00020\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020 H\u0007¢\u0006\u0004\b\"\u0010#J\u0019\u0010%\u001a\u00020$2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0007¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\tH\u0014¢\u0006\u0004\b'\u0010\u0004J\u001d\u0010,\u001a\u00020\t2\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-J\u001d\u00100\u001a\u00020\t2\u0006\u0010)\u001a\u00020(2\u0006\u0010/\u001a\u00020.¢\u0006\u0004\b0\u00101J\u0017\u00103\u001a\u00020\t2\b\b\u0002\u00102\u001a\u00020\u0013¢\u0006\u0004\b3\u00104J\u001f\u00108\u001a\u00020\t2\b\u00106\u001a\u0004\u0018\u0001052\u0006\u00107\u001a\u00020\u000e¢\u0006\u0004\b8\u00109R$\u0010?\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010\u0010\"\u0004\b=\u0010>R$\u0010C\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010;\u001a\u0004\bA\u0010\u0010\"\u0004\bB\u0010>R$\u0010G\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010;\u001a\u0004\bE\u0010\u0010\"\u0004\bF\u0010>R\"\u0010K\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010\u001a\u001a\u0004\bI\u0010\u0015\"\u0004\bJ\u00104R$\u0010R\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\"\u0010Y\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\"\u0010]\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010\u001a\u001a\u0004\b[\u0010\u0015\"\u0004\b\\\u00104R*\u0010c\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010\b\"\u0004\ba\u0010bR\"\u0010g\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bd\u0010\u001a\u001a\u0004\be\u0010\u0015\"\u0004\bf\u00104R!\u0010k\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bh\u0010i\u001a\u0004\bj\u0010\bR\u0014\u0010m\u001a\u00020\u00168\u0002X\u0082D¢\u0006\u0006\n\u0004\bl\u0010TR\u001a\u0010p\u001a\u00020\u00168\u0006X\u0086D¢\u0006\f\n\u0004\bn\u0010T\u001a\u0004\bo\u0010VR\"\u0010t\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bq\u0010T\u001a\u0004\br\u0010V\"\u0004\bs\u0010XR\u0018\u0010w\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010vR\"\u0010{\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bx\u0010T\u001a\u0004\by\u0010V\"\u0004\bz\u0010XR!\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020|0\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b}\u0010i\u001a\u0004\b~\u0010\bR \u0010\u0083\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u0081\u00010\u0080\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b3\u0010\u0082\u0001R&\u0010\u0087\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u0081\u00010\u0080\u00018\u0006¢\u0006\u0010\n\u0006\b\u0084\u0001\u0010\u0082\u0001\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R\u001f\u0010\u0088\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010*0\u0080\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\f\u0010\u0082\u0001R$\u0010\u008a\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010*0\u0080\u00018\u0006¢\u0006\u000f\n\u0005\b\u001b\u0010\u0082\u0001\u001a\u0006\b\u0089\u0001\u0010\u0086\u0001R\u001f\u0010\u008b\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010.0\u0080\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\n\u0010\u0082\u0001R#\u0010\u008c\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010.0\u0080\u00018\u0006¢\u0006\u000e\n\u0005\b\r\u0010\u0082\u0001\u001a\u0005\bT\u0010\u0086\u0001R\u001f\u0010\u008d\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0080\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\"\u0010\u0082\u0001R$\u0010\u008f\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0080\u00018\u0006¢\u0006\u000f\n\u0005\bj\u0010\u0082\u0001\u001a\u0006\b\u008e\u0001\u0010\u0086\u0001R\u001f\u0010\u0090\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0080\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bN\u0010\u0082\u0001R$\u0010\u0092\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0080\u00018\u0006¢\u0006\u000f\n\u0005\b\u001e\u0010\u0082\u0001\u001a\u0006\b\u0091\u0001\u0010\u0086\u0001R\u001d\u0010\u0093\u0001\u001a\t\u0012\u0004\u0012\u00020\u00130\u0080\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u000f\u0010\u0082\u0001R\"\u0010\u0095\u0001\u001a\t\u0012\u0004\u0012\u00020\u00130\u0080\u00018\u0006¢\u0006\u000f\n\u0005\bT\u0010\u0082\u0001\u001a\u0006\b\u0094\u0001\u0010\u0086\u0001R \u0010\u0097\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0080\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0082\u0001R%\u0010\u0099\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0080\u00018\u0006¢\u0006\u0010\n\u0006\b\u0098\u0001\u0010\u0082\u0001\u001a\u0006\b\u0096\u0001\u0010\u0086\u0001R \u0010\u009a\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0080\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0082\u0001R%\u0010\u009b\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0080\u00018\u0006¢\u0006\u0010\n\u0006\b\u008e\u0001\u0010\u0082\u0001\u001a\u0006\b\u0098\u0001\u0010\u0086\u0001¨\u0006\u009c\u0001"}, d2 = {"Lcom/martian/mibook/mvvm/payment/viewmodel/VipPayViewModel;", "Lcom/martian/mibook/mvvm/base/BaseViewModel;", "Lcom/martian/mibook/mvvm/payment/repository/VipPayRepository;", "<init>", "()V", "", "Lzc/a;", "c0", "()Ljava/util/List;", "", "B", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", bt.aJ, "C", "", "H", "()Ljava/lang/String;", "d0", "()Lcom/martian/mibook/mvvm/payment/repository/VipPayRepository;", "", "f0", "()Z", "", e.f26414s, "v0", "(I)Z", "Z", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/martian/mibook/mvvm/payment/data/VipProduct;", "vipProduct", "G", "(Lcom/martian/mibook/mvvm/payment/data/VipProduct;)Ljava/lang/String;", "", "price", "D", "(D)Ljava/lang/String;", "Lcom/martian/mibook/mvvm/payment/data/PriceInfo;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Lcom/martian/mibook/mvvm/payment/data/VipProduct;)Lcom/martian/mibook/mvvm/payment/data/PriceInfo;", "onCleared", "Landroid/app/Activity;", TTDownloadField.TT_ACTIVITY, "Lcom/martian/mibook/lib/account/response/WXRechargeOrder;", "wxRechargeOrder", "u0", "(Landroid/app/Activity;Lcom/martian/mibook/lib/account/response/WXRechargeOrder;)V", "Lcom/martian/mibook/lib/account/response/AliRechargeOrder;", "aliRechargeOrder", "t0", "(Landroid/app/Activity;Lcom/martian/mibook/lib/account/response/AliRechargeOrder;)V", "withCallback", "x", "(Z)V", "Landroid/content/Context;", f.X, NotificationCompat.CATEGORY_EVENT, "h0", "(Landroid/content/Context;Ljava/lang/String;)V", "h", "Ljava/lang/String;", "Y", bq.f10843g, "(Ljava/lang/String;)V", "sourceName", "i", "X", "o0", "sourceId", "j", ExifInterface.LONGITUDE_WEST, "n0", "source", "k", "g0", "q0", "isVip", t.f11204d, "Lcom/martian/mibook/mvvm/payment/data/VipProduct;", "F", "()Lcom/martian/mibook/mvvm/payment/data/VipProduct;", "j0", "(Lcom/martian/mibook/mvvm/payment/data/VipProduct;)V", "currentVipProduct", "m", "I", "R", "()I", "k0", "(I)V", "paymentActiveCounter", "n", "e0", "i0", "isChargeUser", "o", "Ljava/util/List;", "a0", "r0", "(Ljava/util/List;)V", "vipProductList", "p", "b0", "s0", "vipRuleAgreed", "q", "Lkotlin/Lazy;", ExifInterface.LONGITUDE_EAST, "benefitItems", t.f11211k, "payMethodWeixin", "s", "Q", "payMethodAlipay", bt.aO, ExifInterface.LATITUDE_SOUTH, "l0", "paymentMethod", "u", "Ljava/lang/Integer;", "roid", "v", "U", "m0", "paymentStatus", "Lzc/b;", IAdInterListener.AdReqParam.WIDTH, ExifInterface.GPS_DIRECTION_TRUE, "paymentMethodItems", "Lcom/martian/mibook/mvvm/tts/NonStickyLiveData;", "Lcom/martian/mibook/mvvm/payment/data/VipInfo;", "Lcom/martian/mibook/mvvm/tts/NonStickyLiveData;", "_mVipInfoLiveData", "y", "O", "()Lcom/martian/mibook/mvvm/tts/NonStickyLiveData;", "mVipInfoLiveData", "_mWxPrepayLiveData", "P", "mWxPrepayLiveData", "_mAlipayPrepayLiveData", "mAlipayPrepayLiveData", "_mPayPendingLiveData", "M", "mPayPendingLiveData", "_mPaySuccessLiveData", "N", "mPaySuccessLiveData", "_mPayOrderFinishedLiveData", "L", "mPayOrderFinishedLiveData", "J", "_mPayCancelLiveData", "K", "mPayCancelLiveData", "_mPayFailureLiveData", "mPayErrorLiveData", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nVipPayViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VipPayViewModel.kt\ncom/martian/mibook/mvvm/payment/viewmodel/VipPayViewModel\n+ 2 ArrayMap.kt\nandroidx/collection/ArrayMapKt\n*L\n1#1,426:1\n22#2:427\n22#2:428\n*S KotlinDebug\n*F\n+ 1 VipPayViewModel.kt\ncom/martian/mibook/mvvm/payment/viewmodel/VipPayViewModel\n*L\n236#1:427\n303#1:428\n*E\n"})
/* loaded from: classes3.dex */
public final class VipPayViewModel extends BaseViewModel<VipPayRepository> {

    /* renamed from: A */
    @k
    public final NonStickyLiveData<WXRechargeOrder> mWxPrepayLiveData;

    /* renamed from: B, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<AliRechargeOrder> _mAlipayPrepayLiveData;

    /* renamed from: C, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<AliRechargeOrder> mAlipayPrepayLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<Unit> _mPayPendingLiveData;

    /* renamed from: E */
    @k
    public final NonStickyLiveData<Unit> mPayPendingLiveData;

    /* renamed from: F, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<Unit> _mPaySuccessLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<Unit> mPaySuccessLiveData;

    /* renamed from: H, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<Boolean> _mPayOrderFinishedLiveData;

    /* renamed from: I, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<Boolean> mPayOrderFinishedLiveData;

    /* renamed from: J, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<Unit> _mPayCancelLiveData;

    /* renamed from: K, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<Unit> mPayCancelLiveData;

    /* renamed from: L, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<String> _mPayFailureLiveData;

    /* renamed from: M, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<String> mPayErrorLiveData;

    /* renamed from: h, reason: from kotlin metadata */
    @l
    public String sourceName;

    /* renamed from: i, reason: from kotlin metadata */
    @l
    public String sourceId;

    /* renamed from: j, reason: from kotlin metadata */
    @l
    public String source;

    /* renamed from: l */
    @l
    public VipProduct currentVipProduct;

    /* renamed from: m, reason: from kotlin metadata */
    public int paymentActiveCounter;

    /* renamed from: o, reason: from kotlin metadata */
    @l
    public List<VipProduct> vipProductList;

    /* renamed from: u, reason: from kotlin metadata */
    @l
    public Integer roid;

    /* renamed from: v, reason: from kotlin metadata */
    public int paymentStatus;

    /* renamed from: x, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<VipInfo> _mVipInfoLiveData;

    /* renamed from: y, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<VipInfo> mVipInfoLiveData;

    /* renamed from: z */
    @k
    public final NonStickyLiveData<WXRechargeOrder> _mWxPrepayLiveData;

    /* renamed from: k, reason: from kotlin metadata */
    public boolean isVip = MiConfigSingleton.b2().K2();

    /* renamed from: n, reason: from kotlin metadata */
    public boolean isChargeUser = MiConfigSingleton.b2().B2();

    /* renamed from: p, reason: from kotlin metadata */
    public boolean vipRuleAgreed = !MiConfigSingleton.b2().C2();

    /* renamed from: q, reason: from kotlin metadata */
    @k
    public final Lazy benefitItems = LazyKt.lazy(new Function0<List<? extends zc.a>>() { // from class: com.martian.mibook.mvvm.payment.viewmodel.VipPayViewModel$benefitItems$2
        public VipPayViewModel$benefitItems$2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @k
        public final List<? extends a> invoke() {
            List<? extends a> c02;
            c02 = VipPayViewModel.this.c0();
            return c02;
        }
    });

    /* renamed from: r */
    public final int payMethodWeixin = 1;

    /* renamed from: s, reason: from kotlin metadata */
    public final int payMethodAlipay = 2;

    /* renamed from: t */
    public int paymentMethod = 2;

    /* renamed from: w */
    @k
    public final Lazy paymentMethodItems = LazyKt.lazy(new Function0<List<? extends zc.b>>() { // from class: com.martian.mibook.mvvm.payment.viewmodel.VipPayViewModel$paymentMethodItems$2
        public VipPayViewModel$paymentMethodItems$2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @k
        public final List<? extends b> invoke() {
            int i10;
            int i11 = R.drawable.icon_payment_method_alipay;
            String c10 = ExtKt.c("支付宝支付");
            VipProduct currentVipProduct = VipPayViewModel.this.getCurrentVipProduct();
            b bVar = new b(i11, c10, currentVipProduct != null ? currentVipProduct.getPeriodTag() : null, VipPayViewModel.this.getPayMethodAlipay());
            int i12 = R.drawable.icon_payment_method_weixin;
            String c11 = ExtKt.c("微信支付");
            VipProduct currentVipProduct2 = VipPayViewModel.this.getCurrentVipProduct();
            String periodTag = currentVipProduct2 != null ? currentVipProduct2.getPeriodTag() : null;
            i10 = VipPayViewModel.this.payMethodWeixin;
            return CollectionsKt.listOf((Object[]) new b[]{bVar, new b(i12, c11, periodTag, i10)});
        }
    });

    public static final class a implements b.c {

        /* renamed from: b */
        public final /* synthetic */ Activity f14329b;

        /* renamed from: c */
        public final /* synthetic */ AliRechargeOrder f14330c;

        public a(Activity activity, AliRechargeOrder aliRechargeOrder) {
            this.f14329b = activity;
            this.f14330c = aliRechargeOrder;
        }

        @Override // e8.b.c
        public void a(@l String str) {
            VipPayViewModel vipPayViewModel = VipPayViewModel.this;
            Activity activity = this.f14329b;
            MiRechargeOrder miRechargeOrder = this.f14330c.rechargeOrder;
            vipPayViewModel.h0(activity, "支付宝-" + (miRechargeOrder != null ? miRechargeOrder.money : null) + "-失败：" + str);
            VipPayViewModel.this.m0(0);
            VipPayViewModel.this._mPayFailureLiveData.postValue("获取授权失败");
        }

        @Override // e8.b.c
        public void b(@k String outTradeNo, @k String feeValue) {
            Intrinsics.checkNotNullParameter(outTradeNo, "outTradeNo");
            Intrinsics.checkNotNullParameter(feeValue, "feeValue");
        }

        @Override // e8.b.c
        public void c(@k String rawResult) {
            Intrinsics.checkNotNullParameter(rawResult, "rawResult");
        }

        @Override // e8.b.c
        public void d(@k String message) {
            Intrinsics.checkNotNullParameter(message, "message");
        }

        @Override // e8.b.c
        public void e() {
        }

        @Override // e8.b.c
        public void f(@k String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            VipPayViewModel vipPayViewModel = VipPayViewModel.this;
            Activity activity = this.f14329b;
            MiRechargeOrder miRechargeOrder = this.f14330c.rechargeOrder;
            vipPayViewModel.h0(activity, "支付宝-" + (miRechargeOrder != null ? miRechargeOrder.money : null) + "-取消");
            VipPayViewModel.this.m0(0);
            VipPayViewModel.this._mPayCancelLiveData.postValue(Unit.INSTANCE);
        }

        @Override // e8.b.c
        public void onFailure(@k String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            VipPayViewModel vipPayViewModel = VipPayViewModel.this;
            Activity activity = this.f14329b;
            MiRechargeOrder miRechargeOrder = this.f14330c.rechargeOrder;
            vipPayViewModel.h0(activity, "支付宝-" + (miRechargeOrder != null ? miRechargeOrder.money : null) + "-失败");
            VipPayViewModel.this.m0(0);
            VipPayViewModel.this._mPayFailureLiveData.postValue(message);
        }

        @Override // e8.b.c
        public void onSuccess() {
            VipPayViewModel vipPayViewModel = VipPayViewModel.this;
            Activity activity = this.f14329b;
            MiRechargeOrder miRechargeOrder = this.f14330c.rechargeOrder;
            vipPayViewModel.h0(activity, "支付宝-" + (miRechargeOrder != null ? miRechargeOrder.money : null) + "-成功");
            VipPayViewModel.this.m0(0);
            VipPayViewModel.this._mPaySuccessLiveData.postValue(Unit.INSTANCE);
        }
    }

    public static final class b implements b.c {

        /* renamed from: b */
        public final /* synthetic */ Activity f14332b;

        /* renamed from: c */
        public final /* synthetic */ WXRechargeOrder f14333c;

        public b(Activity activity, WXRechargeOrder wXRechargeOrder) {
            this.f14332b = activity;
            this.f14333c = wXRechargeOrder;
        }

        @Override // z7.b.c
        public void a(@k String errStr) {
            Intrinsics.checkNotNullParameter(errStr, "errStr");
            VipPayViewModel vipPayViewModel = VipPayViewModel.this;
            Activity activity = this.f14332b;
            MiRechargeOrder miRechargeOrder = this.f14333c.rechargeOrder;
            vipPayViewModel.h0(activity, "微信-" + (miRechargeOrder != null ? miRechargeOrder.money : null) + "-失败");
            VipPayViewModel.this.m0(0);
            VipPayViewModel.this._mPayFailureLiveData.postValue(errStr);
        }

        @Override // z7.b.c
        public void b(@k String outTradeNo, @k String feeValue) {
            Intrinsics.checkNotNullParameter(outTradeNo, "outTradeNo");
            Intrinsics.checkNotNullParameter(feeValue, "feeValue");
        }

        @Override // z7.b.c
        public void c() {
            VipPayViewModel vipPayViewModel = VipPayViewModel.this;
            Activity activity = this.f14332b;
            MiRechargeOrder miRechargeOrder = this.f14333c.rechargeOrder;
            vipPayViewModel.h0(activity, "微信-" + (miRechargeOrder != null ? miRechargeOrder.money : null) + "-成功");
            VipPayViewModel.this.m0(0);
            VipPayViewModel.this._mPaySuccessLiveData.postValue(Unit.INSTANCE);
        }

        @Override // z7.b.c
        public void d() {
            VipPayViewModel vipPayViewModel = VipPayViewModel.this;
            Activity activity = this.f14332b;
            MiRechargeOrder miRechargeOrder = this.f14333c.rechargeOrder;
            vipPayViewModel.h0(activity, "微信-" + (miRechargeOrder != null ? miRechargeOrder.money : null) + "-取消");
            VipPayViewModel.this.m0(0);
            VipPayViewModel.this._mPayCancelLiveData.postValue(Unit.INSTANCE);
        }
    }

    public VipPayViewModel() {
        NonStickyLiveData<VipInfo> nonStickyLiveData = new NonStickyLiveData<>();
        this._mVipInfoLiveData = nonStickyLiveData;
        this.mVipInfoLiveData = nonStickyLiveData;
        NonStickyLiveData<WXRechargeOrder> nonStickyLiveData2 = new NonStickyLiveData<>();
        this._mWxPrepayLiveData = nonStickyLiveData2;
        this.mWxPrepayLiveData = nonStickyLiveData2;
        NonStickyLiveData<AliRechargeOrder> nonStickyLiveData3 = new NonStickyLiveData<>();
        this._mAlipayPrepayLiveData = nonStickyLiveData3;
        this.mAlipayPrepayLiveData = nonStickyLiveData3;
        NonStickyLiveData<Unit> nonStickyLiveData4 = new NonStickyLiveData<>();
        this._mPayPendingLiveData = nonStickyLiveData4;
        this.mPayPendingLiveData = nonStickyLiveData4;
        NonStickyLiveData<Unit> nonStickyLiveData5 = new NonStickyLiveData<>();
        this._mPaySuccessLiveData = nonStickyLiveData5;
        this.mPaySuccessLiveData = nonStickyLiveData5;
        NonStickyLiveData<Boolean> nonStickyLiveData6 = new NonStickyLiveData<>();
        this._mPayOrderFinishedLiveData = nonStickyLiveData6;
        this.mPayOrderFinishedLiveData = nonStickyLiveData6;
        NonStickyLiveData<Unit> nonStickyLiveData7 = new NonStickyLiveData<>();
        this._mPayCancelLiveData = nonStickyLiveData7;
        this.mPayCancelLiveData = nonStickyLiveData7;
        NonStickyLiveData<String> nonStickyLiveData8 = new NonStickyLiveData<>();
        this._mPayFailureLiveData = nonStickyLiveData8;
        this.mPayErrorLiveData = nonStickyLiveData8;
    }

    public static /* synthetic */ void y(VipPayViewModel vipPayViewModel, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        vipPayViewModel.x(z10);
    }

    public final void A() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new VipPayViewModel$createPrepayOrder$1(this, null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object B(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.martian.mibook.mvvm.payment.viewmodel.VipPayViewModel$createWxPrepayOrder$1
            if (r0 == 0) goto L13
            r0 = r8
            com.martian.mibook.mvvm.payment.viewmodel.VipPayViewModel$createWxPrepayOrder$1 r0 = (com.martian.mibook.mvvm.payment.viewmodel.VipPayViewModel$createWxPrepayOrder$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.martian.mibook.mvvm.payment.viewmodel.VipPayViewModel$createWxPrepayOrder$1 r0 = new com.martian.mibook.mvvm.payment.viewmodel.VipPayViewModel$createWxPrepayOrder$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L36
            if (r2 != r4) goto L2e
            java.lang.Object r0 = r0.L$0
            com.martian.mibook.mvvm.payment.viewmodel.VipPayViewModel r0 = (com.martian.mibook.mvvm.payment.viewmodel.VipPayViewModel) r0
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Exception -> La7
            goto L97
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L36:
            kotlin.ResultKt.throwOnFailure(r8)
            com.martian.mibook.mvvm.payment.data.VipProduct r8 = r7.currentVipProduct     // Catch: java.lang.Exception -> L56
            if (r8 == 0) goto La1
            androidx.collection.ArrayMap r2 = new androidx.collection.ArrayMap     // Catch: java.lang.Exception -> L56
            r2.<init>()     // Catch: java.lang.Exception -> L56
            java.lang.Integer r5 = r8.getPrice()     // Catch: java.lang.Exception -> L56
            if (r5 == 0) goto L58
            int r5 = r5.intValue()     // Catch: java.lang.Exception -> L56
            java.lang.String r6 = "money"
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch: java.lang.Exception -> L56
            r2.put(r6, r5)     // Catch: java.lang.Exception -> L56
            goto L58
        L56:
            r0 = r7
            goto La7
        L58:
            java.lang.Integer r8 = r8.getPid()     // Catch: java.lang.Exception -> L56
            if (r8 == 0) goto L6b
            int r8 = r8.intValue()     // Catch: java.lang.Exception -> L56
            java.lang.String r5 = "productId"
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch: java.lang.Exception -> L56
            r2.put(r5, r8)     // Catch: java.lang.Exception -> L56
        L6b:
            java.lang.String r8 = "extra"
            java.lang.String r5 = r7.H()     // Catch: java.lang.Exception -> L56
            r2.put(r8, r5)     // Catch: java.lang.Exception -> L56
            java.lang.String r8 = "wx_appid"
            com.martian.mibook.application.MiConfigSingleton r5 = com.martian.mibook.application.MiConfigSingleton.b2()     // Catch: java.lang.Exception -> L56
            com.martian.mibook.data.MiOptions r5 = r5.c2()     // Catch: java.lang.Exception -> L56
            java.lang.String r5 = r5.getRechargeWxAppid()     // Catch: java.lang.Exception -> L56
            r2.put(r8, r5)     // Catch: java.lang.Exception -> L56
            com.martian.mibook.mvvm.base.BaseRepository r8 = r7.f()     // Catch: java.lang.Exception -> L56
            com.martian.mibook.mvvm.payment.repository.VipPayRepository r8 = (com.martian.mibook.mvvm.payment.repository.VipPayRepository) r8     // Catch: java.lang.Exception -> L56
            r0.L$0 = r7     // Catch: java.lang.Exception -> L56
            r0.label = r4     // Catch: java.lang.Exception -> L56
            java.lang.Object r8 = r8.g(r2, r0)     // Catch: java.lang.Exception -> L56
            if (r8 != r1) goto L96
            return r1
        L96:
            r0 = r7
        L97:
            com.martian.mibook.lib.account.response.WXRechargeOrder r8 = (com.martian.mibook.lib.account.response.WXRechargeOrder) r8     // Catch: java.lang.Exception -> La7
            com.martian.mibook.mvvm.tts.NonStickyLiveData<com.martian.mibook.lib.account.response.WXRechargeOrder> r1 = r0._mWxPrepayLiveData     // Catch: java.lang.Exception -> La7
            r1.postValue(r8)     // Catch: java.lang.Exception -> La7
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch: java.lang.Exception -> La7
            return r8
        La1:
            com.martian.mibook.mvvm.tts.NonStickyLiveData<com.martian.mibook.lib.account.response.WXRechargeOrder> r8 = r7._mWxPrepayLiveData     // Catch: java.lang.Exception -> L56
            r8.postValue(r3)     // Catch: java.lang.Exception -> L56
            goto Lac
        La7:
            com.martian.mibook.mvvm.tts.NonStickyLiveData<com.martian.mibook.lib.account.response.WXRechargeOrder> r8 = r0._mWxPrepayLiveData
            r8.postValue(r3)
        Lac:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.payment.viewmodel.VipPayViewModel.B(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void C() {
        this.paymentStatus = 1;
        BaseViewModel.k(this, new VipPayViewModel$delayShowPayPending$1(this, null), null, false, 6, null);
    }

    @k
    @SuppressLint({"DefaultLocale"})
    public final String D(double price) {
        if (price % 1 == c.f27899e) {
            return String.valueOf((int) price);
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(price)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return StringsKt.endsWith$default(format, "0", false, 2, (Object) null) ? StringsKt.dropLast(format, 1) : format;
    }

    @k
    public final List<zc.a> E() {
        return (List) this.benefitItems.getValue();
    }

    @l
    /* renamed from: F, reason: from getter */
    public final VipProduct getCurrentVipProduct() {
        return this.currentVipProduct;
    }

    @k
    public final String G(@l VipProduct vipProduct) {
        Integer price;
        if (vipProduct == null || (price = vipProduct.getPrice()) == null) {
            return "";
        }
        return "￥" + D(price.intValue() / 100.0d);
    }

    public final String H() {
        if (TextUtils.isEmpty(this.sourceName) || TextUtils.isEmpty(this.sourceId)) {
            return this.source;
        }
        return this.sourceName + "|" + this.sourceId + "-" + this.source;
    }

    @k
    public final NonStickyLiveData<AliRechargeOrder> I() {
        return this.mAlipayPrepayLiveData;
    }

    @k
    public final NonStickyLiveData<Unit> J() {
        return this.mPayCancelLiveData;
    }

    @k
    public final NonStickyLiveData<String> K() {
        return this.mPayErrorLiveData;
    }

    @k
    public final NonStickyLiveData<Boolean> L() {
        return this.mPayOrderFinishedLiveData;
    }

    @k
    public final NonStickyLiveData<Unit> M() {
        return this.mPayPendingLiveData;
    }

    @k
    public final NonStickyLiveData<Unit> N() {
        return this.mPaySuccessLiveData;
    }

    @k
    public final NonStickyLiveData<VipInfo> O() {
        return this.mVipInfoLiveData;
    }

    @k
    public final NonStickyLiveData<WXRechargeOrder> P() {
        return this.mWxPrepayLiveData;
    }

    /* renamed from: Q, reason: from getter */
    public final int getPayMethodAlipay() {
        return this.payMethodAlipay;
    }

    /* renamed from: R, reason: from getter */
    public final int getPaymentActiveCounter() {
        return this.paymentActiveCounter;
    }

    /* renamed from: S, reason: from getter */
    public final int getPaymentMethod() {
        return this.paymentMethod;
    }

    @k
    public final List<zc.b> T() {
        return (List) this.paymentMethodItems.getValue();
    }

    /* renamed from: U, reason: from getter */
    public final int getPaymentStatus() {
        return this.paymentStatus;
    }

    @k
    @SuppressLint({"DefaultLocale"})
    public final PriceInfo V(@l VipProduct vipProduct) {
        Integer price;
        return (vipProduct == null || (price = vipProduct.getPrice()) == null) ? new PriceInfo("", "") : new PriceInfo("￥", D(price.intValue() / 100.0d));
    }

    @l
    /* renamed from: W, reason: from getter */
    public final String getSource() {
        return this.source;
    }

    @l
    /* renamed from: X, reason: from getter */
    public final String getSourceId() {
        return this.sourceId;
    }

    @l
    /* renamed from: Y, reason: from getter */
    public final String getSourceName() {
        return this.sourceName;
    }

    public final void Z() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new VipPayViewModel$getVipInfo$1(this, null), 3, null);
    }

    @l
    public final List<VipProduct> a0() {
        return this.vipProductList;
    }

    /* renamed from: b0, reason: from getter */
    public final boolean getVipRuleAgreed() {
        return this.vipRuleAgreed;
    }

    public final List<zc.a> c0() {
        List<zc.a> mutableListOf = CollectionsKt.mutableListOf(new zc.a(R.drawable.icon_vip_read_ad, R.drawable.icon_vip_opened_read_ad, ExtKt.c("看书免广告"), ExtKt.c("开通VIP会员即可享受阅读无广告，畅享纯净阅读")), new zc.a(R.drawable.icon_vip_tts_ad, R.drawable.icon_vip_opened_tts_ad, ExtKt.c("听书免广告"), ExtKt.c("开通VIP会员即可无广告畅享语音听书功能")), new zc.a(R.drawable.icon_vip_cache, R.drawable.icon_vip_opened_cache, ExtKt.c("离线下载"), "开通VIP会员即可提前缓存全本内容，就算没有网络也可畅快阅读"), new zc.a(R.drawable.icon_vip_coume_slide, R.drawable.icon_vip_opened_coume_slide, ExtKt.c("音量键翻页"), "开通VIP会员即可使用音量键+-进行上/下翻页，无需屏幕翻页操作"), new zc.a(R.drawable.icon_vip_auto_read, R.drawable.icon_vip_opened_auto_read, ExtKt.c("自动阅读"), "开通VIP会员即可享受阅读完自动翻下一页，速度可调，解放双手"), new zc.a(R.drawable.icon_vip_background, R.drawable.icon_vip_opened_background, ExtKt.c("会员主题"), "开通VIP会员即可享受专属阅读背景和字体，阅读更沉浸"), new zc.a(R.drawable.icon_vip_exp_level, R.drawable.icon_vip_opened_exp_level, ExtKt.c("等级加速"), "开通VIP会员即可享受1.2倍用户等级加速，升级快人一等"), new zc.a(R.drawable.icon_vip_benefit_tag, R.drawable.icon_vip_opened_benefit_tag, ExtKt.c("尊贵标识"), "开通VIP会员即可点击尊贵VIP标识"), new zc.a(R.drawable.icon_vip_privacy_category, R.drawable.icon_vip_opened_privacy_category, ExtKt.c("私密分类"), "开通VIP会员即可使用书架私密分类，个人隐私有保障"), new zc.a(R.drawable.icon_vip_service, R.drawable.icon_vip_opened_service, ExtKt.c("专属客服"), "开通VIP会员即可享受专属微信客服，及时响应遇到的问题"));
        if (this.isChargeUser) {
            mutableListOf.add(0, new zc.a(R.drawable.icon_vip_read_free, R.drawable.icon_vip_opened_read_free, ExtKt.c("全站免费看"), "开通VIP会员即可享受全站小说免费阅读"));
            CollectionsKt.removeLast(mutableListOf);
        }
        return mutableListOf;
    }

    @Override // com.martian.mibook.mvvm.base.BaseViewModel
    @k
    /* renamed from: d0 */
    public VipPayRepository i() {
        return new VipPayRepository();
    }

    /* renamed from: e0, reason: from getter */
    public final boolean getIsChargeUser() {
        return this.isChargeUser;
    }

    public final boolean f0() {
        Integer period;
        VipProduct vipProduct = this.currentVipProduct;
        return vipProduct != null && (period = vipProduct.getPeriod()) != null && period.intValue() > 0 && this.paymentMethod == this.payMethodAlipay;
    }

    /* renamed from: g0, reason: from getter */
    public final boolean getIsVip() {
        return this.isVip;
    }

    public final void h0(@l Context r42, @k String r52) {
        Intrinsics.checkNotNullParameter(r52, "event");
        if (r42 != null) {
            p0.b(this.source + "-" + r52);
            ac.a.Z(r42, this.source + "-" + r52);
        }
    }

    public final void i0(boolean z10) {
        this.isChargeUser = z10;
    }

    public final void j0(@l VipProduct vipProduct) {
        this.currentVipProduct = vipProduct;
    }

    public final void k0(int i10) {
        this.paymentActiveCounter = i10;
    }

    public final void l0(int i10) {
        this.paymentMethod = i10;
    }

    public final void m0(int i10) {
        this.paymentStatus = i10;
    }

    public final void n0(@l String str) {
        this.source = str;
    }

    public final void o0(@l String str) {
        this.sourceId = str;
    }

    @Override // com.martian.mibook.mvvm.base.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        JobKt__JobKt.cancelChildren$default(ViewModelKt.getViewModelScope(this).getCoroutineContext(), (CancellationException) null, 1, (Object) null);
    }

    public final void p0(@l String str) {
        this.sourceName = str;
    }

    public final void q0(boolean z10) {
        this.isVip = z10;
    }

    public final void r0(@l List<VipProduct> list) {
        this.vipProductList = list;
    }

    public final void s0(boolean z10) {
        this.vipRuleAgreed = z10;
    }

    public final void t0(@k Activity r32, @k AliRechargeOrder aliRechargeOrder) {
        Intrinsics.checkNotNullParameter(r32, "activity");
        Intrinsics.checkNotNullParameter(aliRechargeOrder, "aliRechargeOrder");
        e8.a o10 = MiUserManager.o(aliRechargeOrder, oe.f.n(Integer.valueOf(aliRechargeOrder.money)));
        if (o10 == null) {
            t0.b(r32.getApplicationContext(), ExtKt.c("创建订单失败"));
            return;
        }
        MiRechargeOrder miRechargeOrder = aliRechargeOrder.rechargeOrder;
        this.roid = miRechargeOrder != null ? miRechargeOrder.roid : null;
        C();
        e8.b.b(r32, o10, new a(r32, aliRechargeOrder));
    }

    public final void u0(@k Activity r82, @k WXRechargeOrder wxRechargeOrder) {
        Intrinsics.checkNotNullParameter(r82, "activity");
        Intrinsics.checkNotNullParameter(wxRechargeOrder, "wxRechargeOrder");
        PayReq p10 = MiUserManager.p(wxRechargeOrder);
        if (p10 == null) {
            t0.b(r82.getApplicationContext(), ExtKt.c("创建订单失败"));
            return;
        }
        MiRechargeOrder miRechargeOrder = wxRechargeOrder.rechargeOrder;
        this.roid = miRechargeOrder != null ? miRechargeOrder.roid : null;
        C();
        z7.b.d().x(r82, MiConfigSingleton.b2().c2().getRechargeWxAppid(), String.valueOf(wxRechargeOrder.money), p10, new b(r82, wxRechargeOrder));
    }

    public final boolean v0(int r42) {
        VipProduct vipProduct;
        if (this.paymentActiveCounter >= 5) {
            return false;
        }
        if (r42 != this.payMethodWeixin) {
            return (r42 != this.payMethodAlipay || (vipProduct = this.currentVipProduct) == null || vipProduct.supportAliPay()) ? false : true;
        }
        VipProduct vipProduct2 = this.currentVipProduct;
        return (vipProduct2 == null || vipProduct2.supportWeixinPay()) ? false : true;
    }

    public final void x(boolean withCallback) {
        BaseViewModel.k(this, new VipPayViewModel$checkOrderStatus$1(this, withCallback, null), new VipPayViewModel$checkOrderStatus$2(withCallback, this, null), false, 4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object z(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.martian.mibook.mvvm.payment.viewmodel.VipPayViewModel$createAlipayPrepayOrder$1
            if (r0 == 0) goto L13
            r0 = r8
            com.martian.mibook.mvvm.payment.viewmodel.VipPayViewModel$createAlipayPrepayOrder$1 r0 = (com.martian.mibook.mvvm.payment.viewmodel.VipPayViewModel$createAlipayPrepayOrder$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.martian.mibook.mvvm.payment.viewmodel.VipPayViewModel$createAlipayPrepayOrder$1 r0 = new com.martian.mibook.mvvm.payment.viewmodel.VipPayViewModel$createAlipayPrepayOrder$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L36
            if (r2 != r4) goto L2e
            java.lang.Object r0 = r0.L$0
            com.martian.mibook.mvvm.payment.viewmodel.VipPayViewModel r0 = (com.martian.mibook.mvvm.payment.viewmodel.VipPayViewModel) r0
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Exception -> L96
            goto L86
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L36:
            kotlin.ResultKt.throwOnFailure(r8)
            com.martian.mibook.mvvm.payment.data.VipProduct r8 = r7.currentVipProduct     // Catch: java.lang.Exception -> L56
            if (r8 == 0) goto L90
            androidx.collection.ArrayMap r2 = new androidx.collection.ArrayMap     // Catch: java.lang.Exception -> L56
            r2.<init>()     // Catch: java.lang.Exception -> L56
            java.lang.Integer r5 = r8.getPrice()     // Catch: java.lang.Exception -> L56
            if (r5 == 0) goto L58
            int r5 = r5.intValue()     // Catch: java.lang.Exception -> L56
            java.lang.String r6 = "money"
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch: java.lang.Exception -> L56
            r2.put(r6, r5)     // Catch: java.lang.Exception -> L56
            goto L58
        L56:
            r0 = r7
            goto L96
        L58:
            java.lang.Integer r8 = r8.getPid()     // Catch: java.lang.Exception -> L56
            if (r8 == 0) goto L6b
            int r8 = r8.intValue()     // Catch: java.lang.Exception -> L56
            java.lang.String r5 = "productId"
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch: java.lang.Exception -> L56
            r2.put(r5, r8)     // Catch: java.lang.Exception -> L56
        L6b:
            java.lang.String r8 = "extra"
            java.lang.String r5 = r7.H()     // Catch: java.lang.Exception -> L56
            r2.put(r8, r5)     // Catch: java.lang.Exception -> L56
            com.martian.mibook.mvvm.base.BaseRepository r8 = r7.f()     // Catch: java.lang.Exception -> L56
            com.martian.mibook.mvvm.payment.repository.VipPayRepository r8 = (com.martian.mibook.mvvm.payment.repository.VipPayRepository) r8     // Catch: java.lang.Exception -> L56
            r0.L$0 = r7     // Catch: java.lang.Exception -> L56
            r0.label = r4     // Catch: java.lang.Exception -> L56
            java.lang.Object r8 = r8.f(r2, r0)     // Catch: java.lang.Exception -> L56
            if (r8 != r1) goto L85
            return r1
        L85:
            r0 = r7
        L86:
            com.martian.mibook.lib.account.response.AliRechargeOrder r8 = (com.martian.mibook.lib.account.response.AliRechargeOrder) r8     // Catch: java.lang.Exception -> L96
            com.martian.mibook.mvvm.tts.NonStickyLiveData<com.martian.mibook.lib.account.response.AliRechargeOrder> r1 = r0._mAlipayPrepayLiveData     // Catch: java.lang.Exception -> L96
            r1.postValue(r8)     // Catch: java.lang.Exception -> L96
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch: java.lang.Exception -> L96
            return r8
        L90:
            com.martian.mibook.mvvm.tts.NonStickyLiveData<com.martian.mibook.lib.account.response.AliRechargeOrder> r8 = r7._mAlipayPrepayLiveData     // Catch: java.lang.Exception -> L56
            r8.postValue(r3)     // Catch: java.lang.Exception -> L56
            goto L9b
        L96:
            com.martian.mibook.mvvm.tts.NonStickyLiveData<com.martian.mibook.lib.account.response.AliRechargeOrder> r8 = r0._mAlipayPrepayLiveData
            r8.postValue(r3)
        L9b:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.payment.viewmodel.VipPayViewModel.z(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
