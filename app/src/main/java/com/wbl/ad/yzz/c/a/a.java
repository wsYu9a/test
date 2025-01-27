package com.wbl.ad.yzz.c.a;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.XNativeView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.kuaishou.weapon.p0.t;
import com.martian.mibook.application.MiConfigSingleton;
import com.opos.mobad.activity.VideoActivity;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.util.AdError;
import com.umeng.analytics.pro.am;
import com.vivo.advv.Color;
import com.wbl.ad.yzz.R;
import com.wbl.ad.yzz.adapter.base.viewholder.BaseViewHolder;
import com.wbl.ad.yzz.adapter.c.b;
import com.wbl.ad.yzz.adapter.d.a;
import com.wbl.ad.yzz.bean.r;
import com.wbl.ad.yzz.help.e;
import com.wbl.ad.yzz.network.b.b.u;
import com.wbl.ad.yzz.wigdet.wblplayer.WblTextureMediaPlayer;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\t\u0018\u0000 \u0084\u00012\u00020\u0001:\t\u000f\u0085\u0001\u0086\u0001\u0087\u0001\u0088\u0001B#\u0012\u0010\u0010\u0081\u0001\u001a\u000b\u0012\u0004\u0012\u00020X\u0018\u00010\u0080\u0001\u0012\u0006\u0010b\u001a\u00020_¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J9\u0010\r\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u000eJ9\u0010\u000f\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJS\u0010\r\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\r\u0010\u0015J#\u0010\r\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\r\u0010\u0017J7\u0010\r\u001a\u00020\u00022\n\u0010\u0019\u001a\u00060\u0018R\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u000b\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u001eJA\u0010\r\u001a\u00020\u00022\n\u0010\u0019\u001a\u00060\u0018R\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u000b\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010 JA\u0010\r\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010#J#\u0010\r\u001a\u00020\u00022\n\u0010\u0019\u001a\u00060\u0018R\u00020\u00002\u0006\u0010$\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010%JK\u0010\r\u001a\u00020\u00022\n\u0010\u0019\u001a\u00060\u0018R\u00020\u00002\b\u0010'\u001a\u0004\u0018\u00010&2\b\u0010)\u001a\u0004\u0018\u00010(2\b\u0010*\u001a\u0004\u0018\u00010\u001a2\b\u0010+\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u000b\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010,JS\u0010\r\u001a\u00020\u00022\b\u0010.\u001a\u0004\u0018\u00010-2\b\u00100\u001a\u0004\u0018\u00010/2\b\u00102\u001a\u0004\u0018\u0001012\n\u0010\u0019\u001a\u00060\u0018R\u00020\u00002\b\u00103\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u00104JU\u0010\r\u001a\u00020\u00022\u0006\u00105\u001a\u00020\u00132\u0006\u00106\u001a\u00020\u00132\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010\b\u001a\u00020\u00072\b\u00103\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u00107J7\u0010\r\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u00108J?\u0010\r\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u00109J+\u0010\r\u001a\u00020\u00022\b\u00103\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\r\u0010:J-\u0010\u000f\u001a\u00020\u00022\b\u00103\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u000f\u0010:J#\u0010\r\u001a\u00020\u00022\b\u00103\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\r\u0010;J\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010<\u001a\u00020\u00132\u0006\u0010=\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\r\u0010>J\u000f\u0010?\u001a\u00020\u0002H\u0002¢\u0006\u0004\b?\u0010\u0004J\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010A\u001a\u00020@H\u0016¢\u0006\u0004\b\r\u0010BJ\u0019\u0010\r\u001a\u00020\u00022\b\u0010D\u001a\u0004\u0018\u00010CH\u0016¢\u0006\u0004\b\r\u0010EJ\u0019\u0010\r\u001a\u00020\u00022\b\u0010F\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\r\u0010GJ\u0019\u0010\r\u001a\u00020\u00022\b\u0010I\u001a\u0004\u0018\u00010HH\u0016¢\u0006\u0004\b\r\u0010JJ\u0019\u0010\r\u001a\u00020\u00022\b\u0010L\u001a\u0004\u0018\u00010KH\u0016¢\u0006\u0004\b\r\u0010MJ\u0011\u0010O\u001a\u0004\u0018\u00010NH\u0016¢\u0006\u0004\bO\u0010PJ\u000f\u0010Q\u001a\u00020\u0002H\u0016¢\u0006\u0004\bQ\u0010\u0004J\u000f\u0010R\u001a\u00020\u0002H\u0016¢\u0006\u0004\bR\u0010\u0004J\u001f\u0010\u000f\u001a\u00020V2\u0006\u0010T\u001a\u00020S2\u0006\u0010U\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u000f\u0010WJ\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020V2\u0006\u0010Y\u001a\u00020XH\u0014¢\u0006\u0004\b\r\u0010ZJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020VH\u0016¢\u0006\u0004\b\r\u0010[R\u0018\u0010^\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010b\u001a\u00020_8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u0018\u0010e\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010A\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010dR\u0018\u0010i\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010hR\u0018\u0010l\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010p\u001a\u00020m8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bn\u0010oR\u0018\u0010s\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010w\u001a\u00020t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bu\u0010vR%\u0010\u007f\u001a\u000e\u0012\u0004\u0012\u00020y\u0012\u0004\u0012\u00020z0x8\u0006@\u0006¢\u0006\f\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~¨\u0006\u0089\u0001"}, d2 = {"Lcom/wbl/ad/yzz/c/a/a;", "Lcom/wbl/ad/yzz/adapter/d/a;", "", am.aD, "()V", "Lcom/wbl/ad/yzz/bean/b;", "bean", "", "position", "", VideoActivity.EXTRA_KEY_ACTION_TYPE, "adType", "clickType", "a", "(Lcom/wbl/ad/yzz/bean/b;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "b", "Lcom/wbl/ad/yzz/bean/r;", "yzzAdBean", "channel", "", "isRepeat", "(Lcom/wbl/ad/yzz/bean/b;Lcom/wbl/ad/yzz/bean/r;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "url", "(Lcom/wbl/ad/yzz/bean/b;Ljava/lang/String;)V", "Lcom/wbl/ad/yzz/c/a/a$f;", "holder", "Landroid/view/View;", "mContainer", "Landroid/widget/TextView;", "mIvDownApp", "(Lcom/wbl/ad/yzz/c/a/a$f;Landroid/view/View;Landroid/widget/TextView;Ljava/lang/String;)V", "clickableView", "(Lcom/wbl/ad/yzz/c/a/a$f;Landroid/view/View;Landroid/view/View;Landroid/widget/TextView;Ljava/lang/String;)V", "Lcom/wbl/ad/yzz/help/e$b;", "pair", "(Lcom/wbl/ad/yzz/help/e$b;Lcom/wbl/ad/yzz/bean/b;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "csj_muban_adType", "(Lcom/wbl/ad/yzz/c/a/a$f;Ljava/lang/String;)V", "Lcom/qq/e/ads/nativ/widget/NativeAdContainer;", "mItemTypeOneContainer", "Lcom/qq/e/ads/nativ/MediaView;", "mTencentVideoViewT", "containerT", "tvDownApp", "(Lcom/wbl/ad/yzz/c/a/a$f;Lcom/qq/e/ads/nativ/widget/NativeAdContainer;Lcom/qq/e/ads/nativ/MediaView;Landroid/view/View;Landroid/widget/TextView;Ljava/lang/String;)V", "Lcom/wbl/ad/yzz/bean/j;", "ad", "Lcom/bytedance/sdk/openadsdk/TTNativeExpressAd;", "ttNativeExpressAd", "Lcom/wbl/ad/yzz/help/e;", "downLoadApkHelper", "uniq_id", "(Lcom/wbl/ad/yzz/bean/j;Lcom/bytedance/sdk/openadsdk/TTNativeExpressAd;Lcom/wbl/ad/yzz/help/e;Lcom/wbl/ad/yzz/c/a/a$f;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "isCustom", "isDownload", "(ZZLcom/wbl/ad/yzz/bean/b;Lcom/wbl/ad/yzz/help/e$b;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Lcom/wbl/ad/yzz/bean/b;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Lcom/wbl/ad/yzz/bean/b;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;Lcom/wbl/ad/yzz/bean/b;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "isShowMore", "isDownloadTips", "(ZZ)V", IAdInterListener.AdReqParam.WIDTH, "Lcom/wbl/ad/yzz/adapter/c/b;", "itemListener", "(Lcom/wbl/ad/yzz/adapter/c/b;)V", "Lcom/wbl/ad/yzz/adapter/d/a$a;", "onQuickAdapterListener", "(Lcom/wbl/ad/yzz/adapter/d/a$a;)V", "color", "(Ljava/lang/String;)V", "Lcom/wbl/ad/yzz/network/b/b/u$b;", "conf", "(Lcom/wbl/ad/yzz/network/b/b/u$b;)V", "Lcom/wbl/ad/yzz/innerconfig/d/j;", "sceneDataInfoWrap", "(Lcom/wbl/ad/yzz/innerconfig/d/j;)V", "Lcom/wbl/ad/yzz/innerconfig/d/d;", "y", "()Lcom/wbl/ad/yzz/innerconfig/d/d;", "t", t.k, "Landroid/view/ViewGroup;", "parent", "viewType", "Lcom/wbl/ad/yzz/adapter/base/viewholder/BaseViewHolder;", "(Landroid/view/ViewGroup;I)Lcom/wbl/ad/yzz/adapter/base/viewholder/BaseViewHolder;", "Lcom/wbl/ad/yzz/adapter/d/b;", "item", "(Lcom/wbl/ad/yzz/adapter/base/viewholder/BaseViewHolder;Lcom/wbl/ad/yzz/adapter/d/b;)V", "(Lcom/wbl/ad/yzz/adapter/base/viewholder/BaseViewHolder;)V", ExifInterface.LONGITUDE_EAST, "Lcom/wbl/ad/yzz/adapter/d/a$a;", "mOnQuickAdapterListener", "Landroid/app/Activity;", "L", "Landroid/app/Activity;", "mContext", "I", "Lcom/wbl/ad/yzz/adapter/c/b;", "mStartUpHelperItemListener", "D", "K", "Lcom/wbl/ad/yzz/innerconfig/d/d;", "mISceneCache", "J", "Lcom/wbl/ad/yzz/innerconfig/d/j;", "mSceneDataInfoWrap", "Lcom/wbl/ad/yzz/help/l;", "H", "Lcom/wbl/ad/yzz/help/l;", "mStartUpHelper", "F", "Ljava/lang/String;", "mBgColor", "Lcom/wbl/ad/yzz/manager/f;", "G", "Lcom/wbl/ad/yzz/manager/f;", "mDownLoadApkManager", "", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/bytedance/sdk/openadsdk/TTAppDownloadListener;", "C", "Ljava/util/Map;", "x", "()Ljava/util/Map;", "mTTAppDownloadListenerMap", "", MiConfigSingleton.t0, "<init>", "(Ljava/util/List;Landroid/app/Activity;)V", "O", "c", "d", com.kwad.sdk.ranger.e.TAG, "f", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class a extends com.wbl.ad.yzz.adapter.d.a {

    @f.b.a.d
    public static final String M = "QuickAdapter";

    @f.b.a.d
    public static final String N = "数据为空";

    /* renamed from: O, reason: from kotlin metadata */
    @f.b.a.d
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @f.b.a.d
    public final Map<RecyclerView.ViewHolder, TTAppDownloadListener> mTTAppDownloadListenerMap;

    /* renamed from: D, reason: from kotlin metadata */
    public b itemListener;

    /* renamed from: E */
    public a.InterfaceC0679a mOnQuickAdapterListener;

    /* renamed from: F, reason: from kotlin metadata */
    public String mBgColor;

    /* renamed from: G, reason: from kotlin metadata */
    public final com.wbl.ad.yzz.manager.f mDownLoadApkManager;

    /* renamed from: H, reason: from kotlin metadata */
    public final com.wbl.ad.yzz.help.l mStartUpHelper;

    /* renamed from: I, reason: from kotlin metadata */
    public final b mStartUpHelperItemListener;

    /* renamed from: J, reason: from kotlin metadata */
    public com.wbl.ad.yzz.innerconfig.d.j mSceneDataInfoWrap;

    /* renamed from: K, reason: from kotlin metadata */
    public com.wbl.ad.yzz.innerconfig.d.d mISceneCache;

    /* renamed from: L, reason: from kotlin metadata */
    public final Activity mContext;

    /* renamed from: com.wbl.ad.yzz.c.a.a$a */
    public static final class C0692a implements b {
        public C0692a() {
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15088, this, Integer.valueOf(i2));
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(com.wbl.ad.yzz.bean.b bVar, String str, String str2, String str3, String str4) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15087, this, bVar, str, str2, str3, str4);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(com.wbl.ad.yzz.bean.b bVar, String str, String str2, String str3, String str4, String str5) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15082, this, bVar, str, str2, str3, str4, str5);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15081, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(String str, String str2, com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15084, this, str, str2, bVar);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(boolean z, boolean z2, String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15083, this, Boolean.valueOf(z), Boolean.valueOf(z2), str);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void b(String str, String str2, com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15078, this, str, str2, bVar);
        }
    }

    /* renamed from: com.wbl.ad.yzz.c.a.a$b, reason: from kotlin metadata */
    public static final class Companion {
        public Companion() {
        }

        public final String a() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15077, this, null);
        }

        public final String b() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15080, this, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final class c extends f {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a aVar, @f.b.a.d int i2, View view) {
            super(aVar, i2, view);
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    public final class d extends f {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(a aVar, @f.b.a.d int i2, View view) {
            super(aVar, i2, view);
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    public final class e extends f {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(a aVar, @f.b.a.d int i2, View view) {
            super(aVar, i2, view);
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    public class f extends BaseViewHolder implements com.wbl.ad.yzz.wigdet.k.b {

        @f.b.a.e
        public final TextView A;

        @f.b.a.e
        public TextView B;

        @f.b.a.e
        public final ImageView C;

        @f.b.a.e
        public final TextView D;

        @f.b.a.e
        public final FrameLayout E;

        @f.b.a.e
        public final View F;

        @f.b.a.e
        public final TextView G;

        @f.b.a.e
        public final ImageView H;

        @f.b.a.e
        public com.wbl.ad.yzz.help.e I;

        @f.b.a.e
        public final FrameLayout J;
        public final /* synthetic */ a K;

        /* renamed from: a */
        public final int f31634a;

        /* renamed from: b */
        @f.b.a.e
        public com.wbl.ad.yzz.bean.b f31635b;

        /* renamed from: c */
        @f.b.a.e
        public final View f31636c;

        /* renamed from: d */
        @f.b.a.e
        public final NativeAdContainer f31637d;

        /* renamed from: e */
        @f.b.a.e
        public final View f31638e;

        /* renamed from: f */
        @f.b.a.e
        public final ImageView f31639f;

        /* renamed from: g */
        @f.b.a.e
        public final FrameLayout f31640g;

        /* renamed from: h */
        @f.b.a.e
        public final ImageView f31641h;

        /* renamed from: i */
        @f.b.a.e
        public final MediaView f31642i;

        /* renamed from: j */
        @f.b.a.e
        public WblTextureMediaPlayer f31643j;

        @f.b.a.e
        public TextView k;

        @f.b.a.e
        public final XNativeView l;

        @f.b.a.e
        public final View m;

        @f.b.a.e
        public final ImageView n;

        @f.b.a.e
        public final ImageView o;

        @f.b.a.e
        public final View p;

        @f.b.a.e
        public final ImageView q;

        @f.b.a.e
        public final ImageView r;

        @f.b.a.e
        public final ImageView s;

        @f.b.a.e
        public final ImageView t;

        @f.b.a.e
        public final ImageView u;

        @f.b.a.e
        public final ImageView v;

        @f.b.a.e
        public final View w;

        @f.b.a.e
        public final TextView x;

        @f.b.a.e
        public final TextView y;

        @f.b.a.e
        public final ImageView z;

        /* renamed from: com.wbl.ad.yzz.c.a.a$f$a */
        public static final class ViewOnClickListenerC0693a implements View.OnClickListener {

            /* renamed from: b */
            public final /* synthetic */ com.wbl.ad.yzz.adapter.d.b f31645b;

            /* renamed from: c */
            public final /* synthetic */ int f31646c;

            public ViewOnClickListenerC0693a(com.wbl.ad.yzz.adapter.d.b bVar, int i2) {
                this.f31645b = bVar;
                this.f31646c = i2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15074, this, view);
            }
        }

        public static final class a0 implements View.OnClickListener {
            public a0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15079, this, view);
            }
        }

        public static final class b implements View.OnClickListener {
            public b() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15076, this, view);
            }
        }

        public static final class b0 implements View.OnClickListener {
            public b0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15073, this, view);
            }
        }

        public static final class c implements View.OnClickListener {
            public c() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15102, this, view);
            }
        }

        public static final class c0 implements View.OnClickListener {

            /* renamed from: b */
            public final /* synthetic */ View f31652b;

            public c0(View view) {
                this.f31652b = view;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15075, this, view);
            }
        }

        public static final class d implements View.OnClickListener {
            public d() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15104, this, view);
            }
        }

        public static final class d0 implements View.OnClickListener {

            /* renamed from: b */
            public final /* synthetic */ View f31655b;

            public d0(View view) {
                this.f31655b = view;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15101, this, view);
            }
        }

        public static final class e implements com.wbl.ad.yzz.help.n.f {
            public e() {
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(float f2, com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15098, this, Float.valueOf(f2), bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15097, this, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(String str, com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15100, this, str, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(boolean z, boolean z2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15099, this, Boolean.valueOf(z), Boolean.valueOf(z2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void b(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15094, this, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void c(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15093, this, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void d(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15096, this, bVar, Integer.valueOf(i2));
            }
        }

        public static final class e0 implements View.OnClickListener {

            /* renamed from: a */
            public final /* synthetic */ View.OnClickListener f31657a;

            public e0(View.OnClickListener onClickListener) {
                this.f31657a = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15103, this, view);
            }
        }

        /* renamed from: com.wbl.ad.yzz.c.a.a$f$f */
        public static final class C0694f implements com.wbl.ad.yzz.help.n.f {
            public C0694f() {
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(float f2, com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15090, this, Float.valueOf(f2), bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15089, this, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(String str, com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15092, this, str, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(boolean z, boolean z2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15091, this, Boolean.valueOf(z), Boolean.valueOf(z2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void b(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15054, this, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void c(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15053, this, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void d(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15056, this, bVar, Integer.valueOf(i2));
            }
        }

        public static final class f0 implements View.OnClickListener {

            /* renamed from: a */
            public final /* synthetic */ View.OnClickListener f31659a;

            public f0(View.OnClickListener onClickListener) {
                this.f31659a = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15095, this, view);
            }
        }

        public static final class g implements View.OnClickListener {
            public g() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15052, this, view);
            }
        }

        public static final class g0 implements com.wbl.ad.yzz.wigdet.k.c {
            public g0() {
            }

            @Override // com.wbl.ad.yzz.wigdet.k.c
            public void a() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15055, this, null);
            }

            @Override // com.wbl.ad.yzz.wigdet.k.c
            public void b() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15050, this, null);
            }

            @Override // com.wbl.ad.yzz.wigdet.k.c
            public void c() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15049, this, null);
            }
        }

        public static final class h implements View.OnClickListener {
            public h() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15051, this, view);
            }
        }

        public static final class i implements View.OnClickListener {
            public i() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15046, this, view);
            }
        }

        public static final class j implements View.OnClickListener {

            /* renamed from: b */
            public final /* synthetic */ com.wbl.ad.yzz.bean.e f31665b;

            public j(com.wbl.ad.yzz.bean.e eVar) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15045, this, view);
            }
        }

        public static final class k implements View.OnClickListener {
            public k() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15048, this, view);
            }
        }

        public static final class l implements View.OnClickListener {
            public l() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15047, this, view);
            }
        }

        public static final class m implements View.OnClickListener {
            public m() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15042, this, view);
            }
        }

        public static final class n implements View.OnClickListener {

            /* renamed from: b */
            public final /* synthetic */ com.wbl.ad.yzz.bean.e f31670b;

            public n(com.wbl.ad.yzz.bean.e eVar) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15041, this, view);
            }
        }

        public static final class o implements View.OnClickListener {
            public o() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15044, this, view);
            }
        }

        public static final class p implements View.OnClickListener {
            public p() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15043, this, view);
            }
        }

        public static final class q implements View.OnClickListener {
            public q() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15070, this, view);
            }
        }

        public static final class r implements View.OnClickListener {
            public r() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15069, this, view);
            }
        }

        public static final class s implements View.OnClickListener {
            public s() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15072, this, view);
            }
        }

        public static final class t implements View.OnClickListener {
            public t() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15071, this, view);
            }
        }

        public static final class u implements View.OnClickListener {
            public u() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15066, this, view);
            }
        }

        public static final class v implements View.OnClickListener {

            /* renamed from: b */
            public final /* synthetic */ com.wbl.ad.yzz.bean.e f31679b;

            public v(com.wbl.ad.yzz.bean.e eVar) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15065, this, view);
            }
        }

        public static final class w implements View.OnClickListener {
            public w() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15068, this, view);
            }
        }

        public static final class x implements View.OnClickListener {
            public x() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15067, this, view);
            }
        }

        public static final class y implements View.OnClickListener {
            public y() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15062, this, view);
            }
        }

        public static final class z implements com.wbl.ad.yzz.help.n.f {
            public z() {
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(float f2, com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15061, this, Float.valueOf(f2), bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15064, this, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(String str, com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15063, this, str, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(boolean z, boolean z2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15058, this, Boolean.valueOf(z), Boolean.valueOf(z2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void b(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15057, this, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void c(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15060, this, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void d(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15059, this, bVar, Integer.valueOf(i2));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(a aVar, @f.b.a.d int i2, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.K = aVar;
            this.f31634a = i2;
            view.findViewById(R.id.nativeAdContainer);
            this.J = (FrameLayout) view.findViewById(R.id.videoFrameLayout);
            this.f31636c = view.findViewById(R.id.container);
            if (i2 == 1112 || i2 == 4) {
                this.f31637d = null;
                this.f31638e = null;
            } else {
                this.f31637d = (NativeAdContainer) view.findViewById(R.id.native_ad_container_t);
                this.f31638e = view.findViewById(R.id.container_t);
            }
            this.B = (TextView) view.findViewById(R.id.gdt_top_ad_info);
            this.z = (ImageView) view.findViewById(R.id.iv_logo);
            this.A = (TextView) view.findViewById(R.id.iv_logo2);
            this.F = view.findViewById(R.id.ll_limit_hongbao_container);
            this.G = (TextView) view.findViewById(R.id.tv_limit_hongbao_num);
            this.H = (ImageView) view.findViewById(R.id.iv_limit_hongbao_icon);
            this.x = (TextView) view.findViewById(R.id.tv_ad_title);
            this.y = (TextView) view.findViewById(R.id.tv_ad_desc);
            this.D = (TextView) view.findViewById(R.id.tv_download);
            this.C = (ImageView) view.findViewById(R.id.iv_close);
            if (i2 == 1 || i2 == 1115 || i2 == 1116) {
                this.f31640g = (FrameLayout) view.findViewById(R.id.csj_video);
                this.f31642i = (MediaView) view.findViewById(R.id.tecent_video_view_t);
                this.f31639f = (ImageView) view.findViewById(R.id.iv_big_pic);
                this.f31641h = (ImageView) view.findViewById(R.id.iv_big_pic_t);
                this.f31643j = (WblTextureMediaPlayer) view.findViewById(R.id.wbl_video_player);
                this.k = (TextView) view.findViewById(R.id.tv_good_book);
                this.m = view.findViewById(R.id.ll_content_container);
                this.l = null;
            } else if (i2 == 1112) {
                this.f31640g = null;
                this.f31642i = null;
                this.f31639f = null;
                this.f31641h = null;
                XNativeView xNativeView = (XNativeView) view.findViewById(R.id.baidu_video_view);
                this.l = xNativeView;
                this.m = view.findViewById(R.id.ll_content_container);
                if (xNativeView != null) {
                    xNativeView.setShowProgress(true);
                }
                if (xNativeView != null) {
                    xNativeView.setProgressBarColor(Color.GRAY);
                }
                if (xNativeView != null) {
                    xNativeView.setProgressBackgroundColor(-16777216);
                }
                if (xNativeView != null) {
                    xNativeView.setProgressHeightInDp(1);
                }
            } else {
                this.f31640g = null;
                this.f31642i = null;
                this.l = null;
                this.f31639f = null;
                this.f31641h = null;
                this.m = null;
            }
            if (i2 == 2 || i2 == 1117) {
                this.n = (ImageView) view.findViewById(R.id.iv_pic_t);
                this.o = (ImageView) view.findViewById(R.id.iv_pic);
                this.p = view.findViewById(R.id.rl_right_container);
            } else {
                this.n = null;
                this.o = null;
                this.p = null;
            }
            if (i2 == 3) {
                this.q = (ImageView) view.findViewById(R.id.iv_pic_one);
                this.r = (ImageView) view.findViewById(R.id.iv_pic_two);
                this.s = (ImageView) view.findViewById(R.id.iv_pic_three);
                this.t = (ImageView) view.findViewById(R.id.iv_pic_one_t);
                this.u = (ImageView) view.findViewById(R.id.iv_pic_two_t);
                this.v = (ImageView) view.findViewById(R.id.iv_pic_three_t);
                this.w = view.findViewById(R.id.ll_content_container);
            } else {
                this.q = null;
                this.r = null;
                this.s = null;
                this.t = null;
                this.u = null;
                this.v = null;
                this.w = null;
            }
            if (i2 == 4) {
                this.E = (FrameLayout) view.findViewById(R.id.csj_mo_ban_frame);
            } else {
                this.E = null;
            }
        }

        public final com.wbl.ad.yzz.help.n.f a(com.wbl.ad.yzz.bean.b bVar, int i2) {
            return (com.wbl.ad.yzz.help.n.f) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15150, this, bVar, Integer.valueOf(i2));
        }

        @Override // com.wbl.ad.yzz.wigdet.k.b
        public WblTextureMediaPlayer a() {
            return (WblTextureMediaPlayer) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15149, this, null);
        }

        public final String a(NativeResponse nativeResponse) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15152, this, nativeResponse);
        }

        public final String a(NativeUnifiedADData nativeUnifiedADData) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15151, this, nativeUnifiedADData);
        }

        public final String a(com.wbl.ad.yzz.bean.j jVar) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15146, this, jVar);
        }

        public final void a(int i2, View.OnClickListener onClickListener) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15145, this, Integer.valueOf(i2), onClickListener);
        }

        public final void a(com.wbl.ad.yzz.adapter.d.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15148, this, bVar);
        }

        public final void a(com.wbl.ad.yzz.adapter.d.b bVar, int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15147, this, bVar, Integer.valueOf(i2));
        }

        public final void a(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15142, this, bVar);
        }

        public final void a(com.wbl.ad.yzz.bean.e eVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15141, this, eVar);
        }

        public final void a(com.wbl.ad.yzz.bean.r rVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15144, this, rVar);
        }

        public final void a(com.wbl.ad.yzz.help.e eVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15143, this, eVar);
        }

        public final void a(String str, ImageView imageView) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15138, this, str, imageView);
        }

        public final void a(String str, String str2, String str3, boolean z2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15137, this, str, str2, str3, Boolean.valueOf(z2));
        }

        public final void a(String str, boolean z2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15140, this, str, Boolean.valueOf(z2));
        }

        public final void a(boolean z2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15139, this, Boolean.valueOf(z2));
        }

        public final com.wbl.ad.yzz.help.n.f b(com.wbl.ad.yzz.bean.b bVar, int i2) {
            return (com.wbl.ad.yzz.help.n.f) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15166, this, bVar, Integer.valueOf(i2));
        }

        public final String b(NativeResponse nativeResponse) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15165, this, nativeResponse);
        }

        public final String b(NativeUnifiedADData nativeUnifiedADData) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15168, this, nativeUnifiedADData);
        }

        public final String b(com.wbl.ad.yzz.bean.j jVar) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15167, this, jVar);
        }

        public final void b(int i2, View.OnClickListener onClickListener) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15162, this, Integer.valueOf(i2), onClickListener);
        }

        public final void b(com.wbl.ad.yzz.adapter.d.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15161, this, bVar);
        }

        public final void b(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15164, this, bVar);
        }

        public final void b(com.wbl.ad.yzz.bean.e eVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15163, this, eVar);
        }

        public final void b(com.wbl.ad.yzz.bean.r rVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15158, this, rVar);
        }

        public final void b(String str, boolean z2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15157, this, str, Boolean.valueOf(z2));
        }

        public final String c(NativeResponse nativeResponse) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15160, this, nativeResponse);
        }

        public final String c(NativeUnifiedADData nativeUnifiedADData) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15159, this, nativeUnifiedADData);
        }

        public final String c(com.wbl.ad.yzz.bean.j jVar) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15154, this, jVar);
        }

        public final void c(int i2, View.OnClickListener onClickListener) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15153, this, Integer.valueOf(i2), onClickListener);
        }

        public final void c(com.wbl.ad.yzz.adapter.d.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15156, this, bVar);
        }

        public final void c(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15155, this, bVar);
        }

        public final void c(com.wbl.ad.yzz.bean.e eVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15118, this, eVar);
        }

        public final void c(com.wbl.ad.yzz.bean.r rVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15117, this, rVar);
        }

        public final String d(NativeResponse nativeResponse) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15120, this, nativeResponse);
        }

        public final void d() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15119, this, null);
        }

        public final void d(com.wbl.ad.yzz.adapter.d.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15114, this, bVar);
        }

        public final void d(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15113, this, bVar);
        }

        public final void d(com.wbl.ad.yzz.bean.r rVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15116, this, rVar);
        }

        public final void e() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15115, this, null);
        }

        public final void e(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15110, this, bVar);
        }

        public final void e(com.wbl.ad.yzz.bean.r rVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15109, this, rVar);
        }

        public final void f() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15112, this, null);
        }

        public final void f(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15111, this, bVar);
        }

        public final void f(com.wbl.ad.yzz.bean.r rVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15106, this, rVar);
        }

        public final void g() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15105, this, null);
        }

        public final void g(com.wbl.ad.yzz.bean.r rVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15108, this, rVar);
        }

        public final NativeResponse h() {
            return (NativeResponse) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15107, this, null);
        }

        public final com.wbl.ad.yzz.bean.e i() {
            return (com.wbl.ad.yzz.bean.e) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15134, this, null);
        }

        public final com.wbl.ad.yzz.bean.b j() {
            return (com.wbl.ad.yzz.bean.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15133, this, null);
        }

        public final com.wbl.ad.yzz.bean.j k() {
            return (com.wbl.ad.yzz.bean.j) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15136, this, null);
        }

        public final int l() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-15135, this, null);
        }

        public final XNativeView m() {
            return (XNativeView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15130, this, null);
        }

        public final View n() {
            return (View) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15129, this, null);
        }

        public final View o() {
            return (View) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15132, this, null);
        }

        public final com.wbl.ad.yzz.help.e p() {
            return (com.wbl.ad.yzz.help.e) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15131, this, null);
        }

        public final ImageView q() {
            return (ImageView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15126, this, null);
        }

        public final TextView r() {
            return (TextView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15125, this, null);
        }

        public final ImageView s() {
            return (ImageView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15128, this, null);
        }

        public final WblTextureMediaPlayer t() {
            return (WblTextureMediaPlayer) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15127, this, null);
        }

        public final TTNativeExpressAd u() {
            return (TTNativeExpressAd) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15122, this, null);
        }

        public final String v() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15121, this, null);
        }

        public final NativeUnifiedADData w() {
            return (NativeUnifiedADData) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15124, this, null);
        }

        public final com.wbl.ad.yzz.bean.r x() {
            return (com.wbl.ad.yzz.bean.r) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15123, this, null);
        }

        public final com.wbl.ad.yzz.bean.r y() {
            return (com.wbl.ad.yzz.bean.r) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15214, this, null);
        }

        public final void z() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15213, this, null);
        }
    }

    public static final class g implements NativeResponse.AdInteractionListener {

        /* renamed from: a */
        public boolean f31684a;

        /* renamed from: c */
        public final /* synthetic */ f f31686c;

        /* renamed from: d */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f31687d;

        /* renamed from: e */
        public final /* synthetic */ String f31688e;

        /* renamed from: f */
        public final /* synthetic */ Ref.ObjectRef f31689f;

        /* renamed from: g */
        public final /* synthetic */ String f31690g;

        /* renamed from: h */
        public final /* synthetic */ NativeResponse f31691h;

        /* renamed from: i */
        public final /* synthetic */ String f31692i;

        public g(f fVar, com.wbl.ad.yzz.bean.b bVar, String str, Ref.ObjectRef objectRef, String str2, NativeResponse nativeResponse, String str3) {
            this.f31686c = fVar;
            this.f31687d = bVar;
            this.f31688e = str;
            this.f31689f = objectRef;
            this.f31690g = str2;
            this.f31691h = nativeResponse;
            this.f31692i = str3;
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onADExposed() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15216, this, null);
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onADExposureFailed(int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15215, this, Integer.valueOf(i2));
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onADStatusChanged() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15210, this, null);
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onAdClick() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15209, this, null);
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onAdUnionClick() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15212, this, null);
        }
    }

    public static final class h implements View.OnClickListener {

        /* renamed from: b */
        public final /* synthetic */ Ref.ObjectRef f31694b;

        /* renamed from: c */
        public final /* synthetic */ com.wbl.ad.yzz.help.e f31695c;

        /* renamed from: d */
        public final /* synthetic */ int f31696d;

        /* renamed from: e */
        public final /* synthetic */ NativeResponse f31697e;

        /* renamed from: f */
        public final /* synthetic */ View f31698f;

        /* renamed from: com.wbl.ad.yzz.c.a.a$h$a */
        public static final class C0695a implements e.c {
            public C0695a() {
            }

            @Override // com.wbl.ad.yzz.help.e.c
            public void a() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15211, this, null);
            }

            @Override // com.wbl.ad.yzz.help.e.c
            public void b() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15206, this, null);
            }

            @Override // com.wbl.ad.yzz.help.e.c
            public void c() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15205, this, null);
            }
        }

        public h(Ref.ObjectRef objectRef, com.wbl.ad.yzz.help.e eVar, int i2, NativeResponse nativeResponse, View view) {
            this.f31694b = objectRef;
            this.f31695c = eVar;
            this.f31696d = i2;
            this.f31697e = nativeResponse;
            this.f31698f = view;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15208, this, view);
        }
    }

    public static final class i implements View.OnClickListener {

        /* renamed from: b */
        public final /* synthetic */ TextView f31701b;

        /* renamed from: c */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f31702c;

        /* renamed from: d */
        public final /* synthetic */ View f31703d;

        public i(TextView textView, com.wbl.ad.yzz.bean.b bVar, View view) {
            this.f31701b = textView;
            this.f31702c = bVar;
            this.f31703d = view;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15207, this, view);
        }
    }

    public static final class j implements TTNativeAd.AdInteractionListener {

        /* renamed from: b */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f31705b;

        /* renamed from: c */
        public final /* synthetic */ String f31706c;

        /* renamed from: d */
        public final /* synthetic */ f f31707d;

        /* renamed from: e */
        public final /* synthetic */ e.b f31708e;

        /* renamed from: f */
        public final /* synthetic */ int f31709f;

        /* renamed from: g */
        public final /* synthetic */ String f31710g;

        /* renamed from: h */
        public final /* synthetic */ String f31711h;

        public j(com.wbl.ad.yzz.bean.b bVar, String str, f fVar, e.b bVar2, int i2, String str2, String str3) {
            this.f31705b = bVar;
            this.f31706c = str;
            this.f31707d = fVar;
            this.f31708e = bVar2;
            this.f31709f = i2;
            this.f31710g = str2;
            this.f31711h = str3;
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdClicked(View view, TTNativeAd tTNativeAd) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15202, this, view, tTNativeAd);
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15201, this, view, tTNativeAd);
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdShow(TTNativeAd tTNativeAd) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15204, this, tTNativeAd);
        }
    }

    public static final class k implements TTNativeExpressAd.ExpressAdInteractionListener {

        /* renamed from: b */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f31713b;

        /* renamed from: c */
        public final /* synthetic */ String f31714c;

        /* renamed from: d */
        public final /* synthetic */ String f31715d;

        /* renamed from: e */
        public final /* synthetic */ String f31716e;

        public k(com.wbl.ad.yzz.bean.b bVar, String str, String str2, String str3) {
            this.f31713b = bVar;
            this.f31714c = str;
            this.f31715d = str2;
            this.f31716e = str3;
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onAdClicked(View view, int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15203, this, view, Integer.valueOf(i2));
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onAdShow(View view, int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15230, this, view, Integer.valueOf(i2));
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onRenderFail(View view, String str, int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15229, this, view, str, Integer.valueOf(i2));
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onRenderSuccess(View view, float f2, float f3) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15232, this, view, Float.valueOf(f2), Float.valueOf(f3));
        }
    }

    public static final class l extends com.wbl.ad.yzz.bean.i {

        /* renamed from: f */
        public final /* synthetic */ f f31718f;

        /* renamed from: g */
        public final /* synthetic */ com.wbl.ad.yzz.bean.k f31719g;

        /* renamed from: h */
        public final /* synthetic */ String f31720h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(f fVar, com.wbl.ad.yzz.bean.k kVar, String str, com.wbl.ad.yzz.bean.b bVar, boolean z, e.b bVar2, int i2, String str2, String str3, com.wbl.ad.yzz.bean.b bVar3, TextView textView, TTAppDownloadListener tTAppDownloadListener) {
            super(bVar3, textView, tTAppDownloadListener);
            this.f31718f = fVar;
            this.f31719g = kVar;
            this.f31720h = str;
        }

        @Override // com.wbl.ad.yzz.bean.h
        public void a(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15231, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.bean.h
        public boolean d() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-15226, this, null);
        }
    }

    public static final class m implements TTAppDownloadListener {

        /* renamed from: b */
        public final /* synthetic */ String f31722b;

        /* renamed from: c */
        public final /* synthetic */ com.wbl.ad.yzz.bean.k f31723c;

        /* renamed from: d */
        public final /* synthetic */ boolean f31724d;

        /* renamed from: e */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f31725e;

        /* renamed from: f */
        public final /* synthetic */ e.b f31726f;

        /* renamed from: g */
        public final /* synthetic */ int f31727g;

        /* renamed from: h */
        public final /* synthetic */ String f31728h;

        /* renamed from: i */
        public final /* synthetic */ String f31729i;

        /* renamed from: j */
        public final /* synthetic */ f f31730j;

        public m(String str, com.wbl.ad.yzz.bean.k kVar, boolean z, com.wbl.ad.yzz.bean.b bVar, e.b bVar2, int i2, String str2, String str3, f fVar) {
            this.f31722b = str;
            this.f31723c = kVar;
            this.f31724d = z;
            this.f31725e = bVar;
            this.f31726f = bVar2;
            this.f31727g = i2;
            this.f31728h = str2;
            this.f31729i = str3;
            this.f31730j = fVar;
        }

        public final boolean a() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-15225, this, null);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadActive(long j2, long j3, String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15228, this, Long.valueOf(j2), Long.valueOf(j3), str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFailed(long j2, long j3, String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15227, this, Long.valueOf(j2), Long.valueOf(j3), str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFinished(long j2, String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15222, this, Long.valueOf(j2), str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadPaused(long j2, long j3, String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15221, this, Long.valueOf(j2), Long.valueOf(j3), str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onIdle() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15224, this, null);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onInstalled(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15223, this, str, str2);
        }
    }

    public static final class n implements e.c {

        /* renamed from: b */
        public final /* synthetic */ com.wbl.ad.yzz.help.e f31732b;

        /* renamed from: c */
        public final /* synthetic */ int f31733c;

        /* renamed from: d */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f31734d;

        /* renamed from: e */
        public final /* synthetic */ String f31735e;

        /* renamed from: f */
        public final /* synthetic */ String f31736f;

        /* renamed from: g */
        public final /* synthetic */ String f31737g;

        public n(com.wbl.ad.yzz.help.e eVar, int i2, com.wbl.ad.yzz.bean.b bVar, String str, String str2, String str3) {
            this.f31732b = eVar;
            this.f31733c = i2;
            this.f31734d = bVar;
            this.f31735e = str;
            this.f31736f = str2;
            this.f31737g = str3;
        }

        @Override // com.wbl.ad.yzz.help.e.c
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15218, this, null);
        }

        @Override // com.wbl.ad.yzz.help.e.c
        public void b() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15217, this, null);
        }

        @Override // com.wbl.ad.yzz.help.e.c
        public void c() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15220, this, null);
        }
    }

    public static final class o implements View.OnClickListener {

        /* renamed from: b */
        public final /* synthetic */ TextView f31739b;

        /* renamed from: c */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f31740c;

        /* renamed from: d */
        public final /* synthetic */ View f31741d;

        public o(TextView textView, com.wbl.ad.yzz.bean.b bVar, View view) {
            this.f31739b = textView;
            this.f31740c = bVar;
            this.f31741d = view;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15219, this, view);
        }
    }

    public static final class p implements NativeADEventListener {

        /* renamed from: a */
        public boolean f31742a;

        /* renamed from: c */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f31744c;

        /* renamed from: d */
        public final /* synthetic */ String f31745d;

        /* renamed from: e */
        public final /* synthetic */ String f31746e;

        /* renamed from: f */
        public final /* synthetic */ String f31747f;

        /* renamed from: g */
        public final /* synthetic */ f f31748g;

        /* renamed from: h */
        public final /* synthetic */ boolean f31749h;

        /* renamed from: i */
        public final /* synthetic */ int f31750i;

        /* renamed from: j */
        public final /* synthetic */ String f31751j;
        public final /* synthetic */ NativeUnifiedADData k;

        public p(com.wbl.ad.yzz.bean.b bVar, String str, String str2, String str3, f fVar, boolean z, int i2, String str4, NativeUnifiedADData nativeUnifiedADData) {
            this.f31744c = bVar;
            this.f31745d = str;
            this.f31746e = str2;
            this.f31747f = str3;
            this.f31748g = fVar;
            this.f31749h = z;
            this.f31750i = i2;
            this.f31751j = str4;
            this.k = nativeUnifiedADData;
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADClicked() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15182, this, null);
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADError(AdError adError) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15181, this, adError);
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADExposed() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15184, this, null);
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADStatusChanged() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15183, this, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@f.b.a.e List<com.wbl.ad.yzz.adapter.d.b> list, @f.b.a.d Activity mContext) {
        super(list);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
        this.mTTAppDownloadListenerMap = new WeakHashMap();
        com.wbl.ad.yzz.manager.f fVar = new com.wbl.ad.yzz.manager.f();
        this.mDownLoadApkManager = fVar;
        this.mStartUpHelper = new com.wbl.ad.yzz.help.l();
        fVar.a(mContext);
        this.mStartUpHelperItemListener = new C0692a();
    }

    public static final /* synthetic */ Context b(a aVar) {
        return (Context) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15200, null, aVar);
    }

    public static final /* synthetic */ Activity c(a aVar) {
        return (Activity) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15193, null, aVar);
    }

    public static final /* synthetic */ com.wbl.ad.yzz.manager.f d(a aVar) {
        return (com.wbl.ad.yzz.manager.f) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15196, null, aVar);
    }

    public static final /* synthetic */ a.InterfaceC0679a e(a aVar) {
        return (a.InterfaceC0679a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15195, null, aVar);
    }

    public static final /* synthetic */ String u() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15190, null, null);
    }

    public static final /* synthetic */ String v() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15189, null, null);
    }

    @Override // com.wbl.ad.yzz.adapter.base.BaseQuickAdapter
    public void a(BaseViewHolder holder) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15192, this, holder);
    }

    public void a(BaseViewHolder holder, com.wbl.ad.yzz.adapter.d.b item) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15191, this, holder, item);
    }

    @Override // com.wbl.ad.yzz.adapter.base.BaseQuickAdapter
    public /* bridge */ /* synthetic */ void a(BaseViewHolder baseViewHolder, Object obj) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15186, this, baseViewHolder, obj);
    }

    @Override // com.wbl.ad.yzz.adapter.d.a
    public void a(b itemListener) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15185, this, itemListener);
    }

    @Override // com.wbl.ad.yzz.adapter.d.a
    public void a(a.InterfaceC0679a onQuickAdapterListener) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15188, this, onQuickAdapterListener);
    }

    public final void a(com.wbl.ad.yzz.bean.b bean, int position, String r5, String adType, String clickType) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15187, this, bean, Integer.valueOf(position), r5, adType, clickType);
    }

    public final void a(com.wbl.ad.yzz.bean.b bean, r yzzAdBean, String channel, int position, String r7, String adType, String clickType, boolean isRepeat) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15278, this, bean, yzzAdBean, channel, Integer.valueOf(position), r7, adType, clickType, Boolean.valueOf(isRepeat));
    }

    public final void a(com.wbl.ad.yzz.bean.b bean, String url) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15277, this, bean, url);
    }

    public final void a(com.wbl.ad.yzz.bean.b bean, String channel, String position, String r6, String adType) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15280, this, bean, channel, position, r6, adType);
    }

    public final void a(com.wbl.ad.yzz.bean.b bean, String channel, String position, String r6, String adType, String clickType) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15279, this, bean, channel, position, r6, adType, clickType);
    }

    public final void a(com.wbl.ad.yzz.bean.j ad2, TTNativeExpressAd ttNativeExpressAd, com.wbl.ad.yzz.help.e downLoadApkHelper, f holder, String uniq_id, String r8, String adType) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15274, this, ad2, ttNativeExpressAd, downLoadApkHelper, holder, uniq_id, r8, adType);
    }

    public final void a(f holder, View mContainer, View clickableView, TextView mIvDownApp, String adType) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15273, this, holder, mContainer, clickableView, mIvDownApp, adType);
    }

    public final void a(f holder, View mContainer, TextView mIvDownApp, String adType) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15276, this, holder, mContainer, mIvDownApp, adType);
    }

    public final void a(f holder, NativeAdContainer mItemTypeOneContainer, MediaView mTencentVideoViewT, View containerT, TextView tvDownApp, String adType) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15275, this, holder, mItemTypeOneContainer, mTencentVideoViewT, containerT, tvDownApp, adType);
    }

    public final void a(f holder, String csj_muban_adType) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15270, this, holder, csj_muban_adType);
    }

    public final void a(e.b pair, com.wbl.ad.yzz.bean.b bean, int position, String r6, String adType, String clickType) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15269, this, pair, bean, Integer.valueOf(position), r6, adType, clickType);
    }

    @Override // com.wbl.ad.yzz.adapter.d.a
    public void a(com.wbl.ad.yzz.innerconfig.d.j sceneDataInfoWrap) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15272, this, sceneDataInfoWrap);
    }

    @Override // com.wbl.ad.yzz.adapter.d.a
    public void a(u.b conf) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15271, this, conf);
    }

    @Override // com.wbl.ad.yzz.adapter.d.a
    public void a(String color) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15266, this, color);
    }

    public final void a(String uniq_id, String channel) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15265, this, uniq_id, channel);
    }

    public final void a(String uniq_id, String channel, com.wbl.ad.yzz.bean.b bean) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15268, this, uniq_id, channel, bean);
    }

    public final void a(boolean isShowMore, boolean isDownloadTips) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15267, this, Boolean.valueOf(isShowMore), Boolean.valueOf(isDownloadTips));
    }

    public final void a(boolean isCustom, boolean isDownload, com.wbl.ad.yzz.bean.b bean, e.b pair, int position, String uniq_id, String r9, String adType) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15294, this, Boolean.valueOf(isCustom), Boolean.valueOf(isDownload), bean, pair, Integer.valueOf(position), uniq_id, r9, adType);
    }

    @Override // com.wbl.ad.yzz.adapter.base.BaseMultiItemQuickAdapter, com.wbl.ad.yzz.adapter.base.BaseQuickAdapter
    public BaseViewHolder b(ViewGroup parent, int viewType) {
        return (BaseViewHolder) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15293, this, parent, Integer.valueOf(viewType));
    }

    public final void b(com.wbl.ad.yzz.bean.b bean, int position, String r5, String adType, String clickType) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15296, this, bean, Integer.valueOf(position), r5, adType, clickType);
    }

    public final void b(String uniq_id, String channel, com.wbl.ad.yzz.bean.b bean) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15295, this, uniq_id, channel, bean);
    }

    @Override // com.wbl.ad.yzz.adapter.d.a
    public void r() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15290, this, null);
    }

    @Override // com.wbl.ad.yzz.adapter.d.a
    public void t() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15289, this, null);
    }

    public final void w() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15292, this, null);
    }

    public final Map<RecyclerView.ViewHolder, TTAppDownloadListener> x() {
        return (Map) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15291, this, null);
    }

    public com.wbl.ad.yzz.innerconfig.d.d y() {
        return (com.wbl.ad.yzz.innerconfig.d.d) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15286, this, null);
    }

    public final void z() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15285, this, null);
    }
}
