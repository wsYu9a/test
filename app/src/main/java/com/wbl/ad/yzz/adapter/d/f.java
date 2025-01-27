package com.wbl.ad.yzz.adapter.d;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
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
import com.wbl.ad.yzz.adapter.d.a;
import com.wbl.ad.yzz.bean.r;
import com.wbl.ad.yzz.dialog.c;
import com.wbl.ad.yzz.help.e;
import com.wbl.ad.yzz.manager.l;
import com.wbl.ad.yzz.network.b.b.u;
import com.wbl.ad.yzz.wigdet.wblplayer.WblTextureMediaPlayer;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\b\t\u0018\u0000 \u0097\u00012\u00020\u0001:\tF\u0098\u0001\u0099\u0001\u009a\u0001\u009b\u0001B%\u0012\u0010\u0010\u0094\u0001\u001a\u000b\u0012\u0004\u0012\u00020d\u0018\u00010\u0093\u0001\u0012\b\u0010\u0084\u0001\u001a\u00030\u0081\u0001¢\u0006\u0006\b\u0095\u0001\u0010\u0096\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u0011\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\u0004J9\u0010\u0014\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0015JC\u0010\u0014\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0014\u0010\u0018JS\u0010\u0014\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u0014\u0010\u001eJ#\u0010\u0014\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0014\u0010 JA\u0010\u0014\u001a\u00020\u00052\n\u0010\"\u001a\u00060!R\u00020\u00002\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010&\u001a\u0004\u0018\u00010%2\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010\u0012\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010)JK\u0010\u0014\u001a\u00020\u00052\n\u0010\"\u001a\u00060!R\u00020\u00002\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010*\u001a\u0004\u0018\u00010#2\b\u0010&\u001a\u0004\u0018\u00010%2\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010\u0012\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010+JA\u0010\u0014\u001a\u00020\u00052\b\u0010-\u001a\u0004\u0018\u00010,2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010.J#\u0010\u0014\u001a\u00020\u00052\n\u0010\"\u001a\u00060!R\u00020\u00002\u0006\u0010/\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u00100JU\u0010\u0014\u001a\u00020\u00052\n\u0010\"\u001a\u00060!R\u00020\u00002\b\u00102\u001a\u0004\u0018\u0001012\b\u00104\u001a\u0004\u0018\u0001032\b\u00105\u001a\u0004\u0018\u00010#2\b\u00106\u001a\u0004\u0018\u00010%2\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010\u0012\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u00107JS\u0010\u0014\u001a\u00020\u00052\b\u00109\u001a\u0004\u0018\u0001082\b\u0010;\u001a\u0004\u0018\u00010:2\b\u0010=\u001a\u0004\u0018\u00010<2\n\u0010\"\u001a\u00060!R\u00020\u00002\b\u0010>\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010?JU\u0010\u0014\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u001c2\u0006\u0010A\u001a\u00020\u001c2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010-\u001a\u0004\u0018\u00010,2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010>\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010BJ7\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010CJ?\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010DJ+\u0010\u0014\u001a\u00020\u00052\b\u0010>\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001b\u001a\u00020\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0014\u0010EJ-\u0010F\u001a\u00020\u00052\b\u0010>\u001a\u0004\u0018\u00010\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\bF\u0010EJ#\u0010\u0014\u001a\u00020\u00052\b\u0010>\u001a\u0004\u0018\u00010\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0014\u0010GJ\u001f\u0010\u0014\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u0014\u0010JJ\u000f\u0010K\u001a\u00020\u0005H\u0002¢\u0006\u0004\bK\u0010\u0007J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010M\u001a\u00020LH\u0016¢\u0006\u0004\b\u0014\u0010NJ\u0019\u0010\u0014\u001a\u00020\u00052\b\u0010P\u001a\u0004\u0018\u00010OH\u0016¢\u0006\u0004\b\u0014\u0010QJ\u0019\u0010\u0014\u001a\u00020\u00052\b\u0010R\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0014\u0010SJ\u0019\u0010\u0014\u001a\u00020\u00052\b\u0010U\u001a\u0004\u0018\u00010TH\u0016¢\u0006\u0004\b\u0014\u0010VJ\u0019\u0010\u0014\u001a\u00020\u00052\b\u0010X\u001a\u0004\u0018\u00010WH\u0016¢\u0006\u0004\b\u0014\u0010YJ\u0011\u0010[\u001a\u0004\u0018\u00010ZH\u0016¢\u0006\u0004\b[\u0010\\J\u000f\u0010]\u001a\u00020\u0005H\u0016¢\u0006\u0004\b]\u0010\u0007J\u000f\u0010^\u001a\u00020\u0005H\u0016¢\u0006\u0004\b^\u0010\u0007J\u001f\u0010F\u001a\u00020b2\u0006\u0010`\u001a\u00020_2\u0006\u0010a\u001a\u00020\u0002H\u0014¢\u0006\u0004\bF\u0010cJ\u001f\u0010\u0014\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020b2\u0006\u0010e\u001a\u00020dH\u0014¢\u0006\u0004\b\u0014\u0010fJ\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020bH\u0016¢\u0006\u0004\b\u0014\u0010gR\u0018\u0010j\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010n\u001a\u00020k8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bl\u0010mR\u0016\u0010q\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010pR\u0018\u0010t\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010sR\u0018\u0010M\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010iR\u0016\u0010x\u001a\u00020v8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bp\u0010wR\u0018\u0010{\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010zR\u0018\u0010~\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010}R\u0019\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u007f\u0010sR\u001a\u0010\u0084\u0001\u001a\u00030\u0081\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R-\u0010\u008c\u0001\u001a\u0011\u0012\u0005\u0012\u00030\u0086\u0001\u0012\u0005\u0012\u00030\u0087\u00010\u0085\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\b\u0088\u0001\u0010\u0089\u0001\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001a\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008d\u0001\u0010sR\u0017\u0010\u008f\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0006\u0010sR\u001b\u0010\u0092\u0001\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001¨\u0006\u009c\u0001"}, d2 = {"Lcom/wbl/ad/yzz/adapter/d/f;", "Lcom/wbl/ad/yzz/adapter/d/a;", "", am.aD, "()I", "", "C", "()V", "x", "Landroid/graphics/drawable/Drawable;", IAdInterListener.AdReqParam.WIDTH, "()Landroid/graphics/drawable/Drawable;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/wbl/ad/yzz/bean/b;", "bean", "position", "", VideoActivity.EXTRA_KEY_ACTION_TYPE, "adType", "clickType", "a", "(Lcom/wbl/ad/yzz/bean/b;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/wbl/ad/yzz/wigdet/wblplayer/WblTextureMediaPlayer;", "player", "(Lcom/wbl/ad/yzz/bean/b;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/wbl/ad/yzz/wigdet/wblplayer/WblTextureMediaPlayer;)V", "Lcom/wbl/ad/yzz/bean/r;", "yzzAdBean", "channel", "", "isRepeat", "(Lcom/wbl/ad/yzz/bean/b;Lcom/wbl/ad/yzz/bean/r;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "url", "(Lcom/wbl/ad/yzz/bean/b;Ljava/lang/String;)V", "Lcom/wbl/ad/yzz/adapter/d/f$f;", "holder", "Landroid/view/View;", "mContainer", "Landroid/widget/TextView;", "mIvDownApp", "Landroid/widget/ImageView;", "ivClose", "(Lcom/wbl/ad/yzz/adapter/d/f$f;Landroid/view/View;Landroid/widget/TextView;Landroid/widget/ImageView;Ljava/lang/String;)V", "clickableView", "(Lcom/wbl/ad/yzz/adapter/d/f$f;Landroid/view/View;Landroid/view/View;Landroid/widget/TextView;Landroid/widget/ImageView;Ljava/lang/String;)V", "Lcom/wbl/ad/yzz/help/e$b;", "pair", "(Lcom/wbl/ad/yzz/help/e$b;Lcom/wbl/ad/yzz/bean/b;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "csj_muban_adType", "(Lcom/wbl/ad/yzz/adapter/d/f$f;Ljava/lang/String;)V", "Lcom/qq/e/ads/nativ/widget/NativeAdContainer;", "mItemTypeOneContainer", "Lcom/qq/e/ads/nativ/MediaView;", "mTencentVideoViewT", "containerT", "tvDownApp", "(Lcom/wbl/ad/yzz/adapter/d/f$f;Lcom/qq/e/ads/nativ/widget/NativeAdContainer;Lcom/qq/e/ads/nativ/MediaView;Landroid/view/View;Landroid/widget/TextView;Landroid/widget/ImageView;Ljava/lang/String;)V", "Lcom/wbl/ad/yzz/bean/j;", "ad", "Lcom/bytedance/sdk/openadsdk/TTNativeExpressAd;", "ttNativeExpressAd", "Lcom/wbl/ad/yzz/help/e;", "downLoadApkHelper", "uniq_id", "(Lcom/wbl/ad/yzz/bean/j;Lcom/bytedance/sdk/openadsdk/TTNativeExpressAd;Lcom/wbl/ad/yzz/help/e;Lcom/wbl/ad/yzz/adapter/d/f$f;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "isCustom", "isDownload", "(ZZLcom/wbl/ad/yzz/bean/b;Lcom/wbl/ad/yzz/help/e$b;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Lcom/wbl/ad/yzz/bean/b;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Lcom/wbl/ad/yzz/bean/b;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;Lcom/wbl/ad/yzz/bean/b;)V", "b", "(Ljava/lang/String;Ljava/lang/String;)V", "isShowMore", "isDownloadTips", "(ZZ)V", "v", "Lcom/wbl/ad/yzz/adapter/c/b;", "itemListener", "(Lcom/wbl/ad/yzz/adapter/c/b;)V", "Lcom/wbl/ad/yzz/adapter/d/a$a;", "onQuickAdapterListener", "(Lcom/wbl/ad/yzz/adapter/d/a$a;)V", "color", "(Ljava/lang/String;)V", "Lcom/wbl/ad/yzz/network/b/b/u$b;", "conf", "(Lcom/wbl/ad/yzz/network/b/b/u$b;)V", "Lcom/wbl/ad/yzz/innerconfig/d/j;", "sceneDataInfoWrap", "(Lcom/wbl/ad/yzz/innerconfig/d/j;)V", "Lcom/wbl/ad/yzz/innerconfig/d/d;", "B", "()Lcom/wbl/ad/yzz/innerconfig/d/d;", "t", t.k, "Landroid/view/ViewGroup;", "parent", "viewType", "Lcom/wbl/ad/yzz/adapter/base/viewholder/BaseViewHolder;", "(Landroid/view/ViewGroup;I)Lcom/wbl/ad/yzz/adapter/base/viewholder/BaseViewHolder;", "Lcom/wbl/ad/yzz/adapter/d/b;", "item", "(Lcom/wbl/ad/yzz/adapter/base/viewholder/BaseViewHolder;Lcom/wbl/ad/yzz/adapter/d/b;)V", "(Lcom/wbl/ad/yzz/adapter/base/viewholder/BaseViewHolder;)V", "K", "Lcom/wbl/ad/yzz/adapter/c/b;", "mStartUpHelperItemListener", "Lcom/wbl/ad/yzz/help/l;", "J", "Lcom/wbl/ad/yzz/help/l;", "mStartUpHelper", "H", "I", "mBgColorInt", "L", "Ljava/lang/String;", "mGuideContent", ExifInterface.LONGITUDE_EAST, "Lcom/wbl/ad/yzz/manager/f;", "Lcom/wbl/ad/yzz/manager/f;", "mDownLoadApkManager", "O", "Lcom/wbl/ad/yzz/innerconfig/d/d;", "mISceneCache", "N", "Lcom/wbl/ad/yzz/innerconfig/d/j;", "mSceneDataInfoWrap", "M", "mGuideIcon", "Landroid/app/Activity;", "P", "Landroid/app/Activity;", "mContext", "", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/bytedance/sdk/openadsdk/TTAppDownloadListener;", "D", "Ljava/util/Map;", "y", "()Ljava/util/Map;", "mTTAppDownloadListenerMap", "G", "mBgColor", "TAG", "F", "Lcom/wbl/ad/yzz/adapter/d/a$a;", "mOnQuickAdapterListener", "", MiConfigSingleton.t0, "<init>", "(Ljava/util/List;Landroid/app/Activity;)V", "R", "c", "d", com.kwad.sdk.ranger.e.TAG, "f", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class f extends com.wbl.ad.yzz.adapter.d.a {

    @f.b.a.d
    public static final String Q = "数据为空";

    /* renamed from: R, reason: from kotlin metadata */
    @f.b.a.d
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    public final String TAG;

    /* renamed from: D, reason: from kotlin metadata */
    @f.b.a.d
    public final Map<RecyclerView.ViewHolder, TTAppDownloadListener> mTTAppDownloadListenerMap;

    /* renamed from: E */
    public com.wbl.ad.yzz.adapter.c.b itemListener;

    /* renamed from: F, reason: from kotlin metadata */
    public a.InterfaceC0679a mOnQuickAdapterListener;

    /* renamed from: G, reason: from kotlin metadata */
    public String mBgColor;

    /* renamed from: H, reason: from kotlin metadata */
    public int mBgColorInt;

    /* renamed from: I, reason: from kotlin metadata */
    public final com.wbl.ad.yzz.manager.f mDownLoadApkManager;

    /* renamed from: J, reason: from kotlin metadata */
    public final com.wbl.ad.yzz.help.l mStartUpHelper;

    /* renamed from: K, reason: from kotlin metadata */
    public final com.wbl.ad.yzz.adapter.c.b mStartUpHelperItemListener;

    /* renamed from: L, reason: from kotlin metadata */
    public String mGuideContent;

    /* renamed from: M, reason: from kotlin metadata */
    public String mGuideIcon;

    /* renamed from: N, reason: from kotlin metadata */
    public com.wbl.ad.yzz.innerconfig.d.j mSceneDataInfoWrap;

    /* renamed from: O, reason: from kotlin metadata */
    public com.wbl.ad.yzz.innerconfig.d.d mISceneCache;

    /* renamed from: P, reason: from kotlin metadata */
    public final Activity mContext;

    public static final class a implements com.wbl.ad.yzz.adapter.c.b {
        public a() {
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16283, this, Integer.valueOf(i2));
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(com.wbl.ad.yzz.bean.b bVar, String str, String str2, String str3, String str4) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16278, this, bVar, str, str2, str3, str4);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(com.wbl.ad.yzz.bean.b bVar, String str, String str2, String str3, String str4, String str5) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16277, this, bVar, str, str2, str3, str4, str5);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16280, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(String str, String str2, com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16279, this, str, str2, bVar);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(boolean z, boolean z2, String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16274, this, Boolean.valueOf(z), Boolean.valueOf(z2), str);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void b(String str, String str2, com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16273, this, str, str2, bVar);
        }
    }

    /* renamed from: com.wbl.ad.yzz.adapter.d.f$b, reason: from kotlin metadata */
    public static final class Companion {
        public Companion() {
        }

        public final String a() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16276, this, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final class c extends C0683f {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(f fVar, @f.b.a.d int i2, View view) {
            super(fVar, i2, view);
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    public final class d extends C0683f {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(f fVar, @f.b.a.d int i2, View view) {
            super(fVar, i2, view);
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    public final class e extends C0683f {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(f fVar, @f.b.a.d int i2, View view) {
            super(fVar, i2, view);
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    /* renamed from: com.wbl.ad.yzz.adapter.d.f$f */
    public class C0683f extends BaseViewHolder implements l.a, com.wbl.ad.yzz.wigdet.k.b, com.wbl.ad.yzz.adapter.d.c {

        @f.b.a.e
        public final ImageView A;

        @f.b.a.e
        public final ImageView B;

        @f.b.a.e
        public final View C;

        @f.b.a.e
        public final FrameLayout D;

        @f.b.a.e
        public final TextView E;

        @f.b.a.e
        public final TextView F;

        @f.b.a.e
        public final ImageView G;

        @f.b.a.e
        public final TextView H;

        @f.b.a.e
        public TextView I;

        @f.b.a.e
        public final ImageView J;

        @f.b.a.e
        public final TextView K;

        @f.b.a.e
        public final FrameLayout L;

        @f.b.a.e
        public com.wbl.ad.yzz.help.e M;
        public TextView N;

        @f.b.a.e
        public final FrameLayout O;
        public final /* synthetic */ f P;

        /* renamed from: a */
        public final int f31319a;

        /* renamed from: b */
        @f.b.a.e
        public com.wbl.ad.yzz.bean.b f31320b;

        /* renamed from: c */
        @f.b.a.e
        public final View f31321c;

        /* renamed from: d */
        @f.b.a.e
        public final View f31322d;

        /* renamed from: e */
        @f.b.a.e
        public final View f31323e;

        /* renamed from: f */
        @f.b.a.e
        public final NativeAdContainer f31324f;

        /* renamed from: g */
        @f.b.a.e
        public final View f31325g;

        /* renamed from: h */
        @f.b.a.e
        public final ImageView f31326h;

        /* renamed from: i */
        @f.b.a.e
        public final FrameLayout f31327i;

        /* renamed from: j */
        @f.b.a.e
        public final ImageView f31328j;

        @f.b.a.e
        public final MediaView k;

        @f.b.a.e
        public WblTextureMediaPlayer l;

        @f.b.a.e
        public ImageView m;

        @f.b.a.e
        public TextView n;

        @f.b.a.e
        public final XNativeView o;

        @f.b.a.e
        public final View p;

        @f.b.a.e
        public final View q;

        @f.b.a.e
        public final TextView r;

        @f.b.a.e
        public final ImageView s;

        @f.b.a.e
        public final ImageView t;

        @f.b.a.e
        public final ImageView u;

        @f.b.a.e
        public final View v;

        @f.b.a.e
        public final ImageView w;

        @f.b.a.e
        public final ImageView x;

        @f.b.a.e
        public final ImageView y;

        @f.b.a.e
        public final ImageView z;

        /* renamed from: com.wbl.ad.yzz.adapter.d.f$f$a */
        public static final class a implements View.OnClickListener {

            /* renamed from: b */
            public final /* synthetic */ com.wbl.ad.yzz.adapter.d.b f31330b;

            /* renamed from: c */
            public final /* synthetic */ int f31331c;

            public a(com.wbl.ad.yzz.adapter.d.b bVar, int i2) {
                this.f31330b = bVar;
                this.f31331c = i2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16366, this, view);
            }
        }

        /* renamed from: com.wbl.ad.yzz.adapter.d.f$f$a0 */
        public static final class a0 implements View.OnClickListener {
            public a0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16275, this, view);
            }
        }

        /* renamed from: com.wbl.ad.yzz.adapter.d.f$f$b */
        public static final class b implements View.OnClickListener {
            public b() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16358, this, view);
            }
        }

        /* renamed from: com.wbl.ad.yzz.adapter.d.f$f$b0 */
        public static final class b0 implements com.wbl.ad.yzz.help.n.f {
            public b0() {
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(float f2, com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16365, this, Float.valueOf(f2), bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16368, this, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(String str, com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16367, this, str, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(boolean z, boolean z2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16362, this, Boolean.valueOf(z), Boolean.valueOf(z2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void b(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16361, this, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void c(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16364, this, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void d(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16363, this, bVar, Integer.valueOf(i2));
            }
        }

        /* renamed from: com.wbl.ad.yzz.adapter.d.f$f$c */
        public static final class c implements View.OnClickListener {
            public c() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16360, this, view);
            }
        }

        /* renamed from: com.wbl.ad.yzz.adapter.d.f$f$c0 */
        public static final class c0 implements View.OnClickListener {
            public c0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16357, this, view);
            }
        }

        /* renamed from: com.wbl.ad.yzz.adapter.d.f$f$d */
        public static final class d implements View.OnClickListener {
            public d() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16354, this, view);
            }
        }

        /* renamed from: com.wbl.ad.yzz.adapter.d.f$f$d0 */
        public static final class d0 implements View.OnClickListener {
            public d0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16359, this, view);
            }
        }

        /* renamed from: com.wbl.ad.yzz.adapter.d.f$f$e */
        public static final class e implements View.OnClickListener {
            public e() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16356, this, view);
            }
        }

        /* renamed from: com.wbl.ad.yzz.adapter.d.f$f$e0 */
        public static final class e0 implements View.OnClickListener {

            /* renamed from: b */
            public final /* synthetic */ View f31341b;

            public e0(View view) {
                this.f31341b = view;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16353, this, view);
            }
        }

        /* renamed from: com.wbl.ad.yzz.adapter.d.f$f$f */
        public static final class ViewOnClickListenerC0684f implements View.OnClickListener {
            public ViewOnClickListenerC0684f() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16382, this, view);
            }
        }

        /* renamed from: com.wbl.ad.yzz.adapter.d.f$f$f0 */
        public static final class f0 implements View.OnClickListener {

            /* renamed from: b */
            public final /* synthetic */ View f31344b;

            public f0(View view) {
                this.f31344b = view;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16355, this, view);
            }
        }

        /* renamed from: com.wbl.ad.yzz.adapter.d.f$f$g */
        public static final class g implements View.OnClickListener {
            public g() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16384, this, view);
            }
        }

        /* renamed from: com.wbl.ad.yzz.adapter.d.f$f$g0 */
        public static final class g0 implements View.OnClickListener {
            public g0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16381, this, view);
            }
        }

        /* renamed from: com.wbl.ad.yzz.adapter.d.f$f$h */
        public static final class h implements View.OnClickListener {
            public h() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16380, this, view);
            }
        }

        /* renamed from: com.wbl.ad.yzz.adapter.d.f$f$h0 */
        public static final class h0 implements com.wbl.ad.yzz.wigdet.k.c {
            public h0() {
            }

            @Override // com.wbl.ad.yzz.wigdet.k.c
            public void a() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16383, this, null);
            }

            @Override // com.wbl.ad.yzz.wigdet.k.c
            public void b() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16378, this, null);
            }

            @Override // com.wbl.ad.yzz.wigdet.k.c
            public void c() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16377, this, null);
            }
        }

        /* renamed from: com.wbl.ad.yzz.adapter.d.f$f$i */
        public static final class i implements com.wbl.ad.yzz.help.n.f {
            public i() {
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(float f2, com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16379, this, Float.valueOf(f2), bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16374, this, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(String str, com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16373, this, str, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(boolean z, boolean z2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16376, this, Boolean.valueOf(z), Boolean.valueOf(z2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void b(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16375, this, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void c(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16370, this, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void d(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16369, this, bVar, Integer.valueOf(i2));
            }
        }

        /* renamed from: com.wbl.ad.yzz.adapter.d.f$f$j */
        public static final class j implements com.wbl.ad.yzz.help.n.f {
            public j() {
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(float f2, com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16372, this, Float.valueOf(f2), bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16371, this, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(String str, com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16334, this, str, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(boolean z, boolean z2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16333, this, Boolean.valueOf(z), Boolean.valueOf(z2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void b(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16336, this, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void c(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16335, this, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void d(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16330, this, bVar, Integer.valueOf(i2));
            }
        }

        /* renamed from: com.wbl.ad.yzz.adapter.d.f$f$k */
        public static final class k implements View.OnClickListener {
            public k() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16329, this, view);
            }
        }

        /* renamed from: com.wbl.ad.yzz.adapter.d.f$f$l */
        public static final class l implements View.OnClickListener {
            public l() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16332, this, view);
            }
        }

        /* renamed from: com.wbl.ad.yzz.adapter.d.f$f$m */
        public static final class m implements View.OnClickListener {
            public m() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16331, this, view);
            }
        }

        /* renamed from: com.wbl.ad.yzz.adapter.d.f$f$n */
        public static final class n implements View.OnClickListener {

            /* renamed from: b */
            public final /* synthetic */ com.wbl.ad.yzz.bean.e f31355b;

            public n(com.wbl.ad.yzz.bean.e eVar) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16326, this, view);
            }
        }

        /* renamed from: com.wbl.ad.yzz.adapter.d.f$f$o */
        public static final class o implements View.OnClickListener {
            public o() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16325, this, view);
            }
        }

        /* renamed from: com.wbl.ad.yzz.adapter.d.f$f$p */
        public static final class p implements View.OnClickListener {
            public p() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16328, this, view);
            }
        }

        /* renamed from: com.wbl.ad.yzz.adapter.d.f$f$q */
        public static final class q implements View.OnClickListener {
            public q() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16327, this, view);
            }
        }

        /* renamed from: com.wbl.ad.yzz.adapter.d.f$f$r */
        public static final class r implements View.OnClickListener {

            /* renamed from: b */
            public final /* synthetic */ com.wbl.ad.yzz.bean.e f31360b;

            public r(com.wbl.ad.yzz.bean.e eVar) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16322, this, view);
            }
        }

        /* renamed from: com.wbl.ad.yzz.adapter.d.f$f$s */
        public static final class s implements View.OnClickListener {
            public s() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16321, this, view);
            }
        }

        /* renamed from: com.wbl.ad.yzz.adapter.d.f$f$t */
        public static final class t implements View.OnClickListener {
            public t() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16324, this, view);
            }
        }

        /* renamed from: com.wbl.ad.yzz.adapter.d.f$f$u */
        public static final class u implements View.OnClickListener {
            public u() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16323, this, view);
            }
        }

        /* renamed from: com.wbl.ad.yzz.adapter.d.f$f$v */
        public static final class v implements View.OnClickListener {
            public v() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16350, this, view);
            }
        }

        /* renamed from: com.wbl.ad.yzz.adapter.d.f$f$w */
        public static final class w implements View.OnClickListener {
            public w() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16349, this, view);
            }
        }

        /* renamed from: com.wbl.ad.yzz.adapter.d.f$f$x */
        public static final class x implements View.OnClickListener {

            /* renamed from: b */
            public final /* synthetic */ com.wbl.ad.yzz.bean.e f31367b;

            public x(com.wbl.ad.yzz.bean.e eVar) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16352, this, view);
            }
        }

        /* renamed from: com.wbl.ad.yzz.adapter.d.f$f$y */
        public static final class y implements View.OnClickListener {
            public y() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16351, this, view);
            }
        }

        /* renamed from: com.wbl.ad.yzz.adapter.d.f$f$z */
        public static final class z implements View.OnClickListener {
            public z() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16346, this, view);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0683f(f fVar, @f.b.a.d int i2, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.P = fVar;
            this.f31319a = i2;
            this.f31321c = view.findViewById(R.id.nativeAdContainer);
            this.f31322d = view.findViewById(R.id.tv_source_desc_layout);
            this.O = (FrameLayout) view.findViewById(R.id.videoFrameLayout);
            this.f31323e = view.findViewById(R.id.container);
            if (i2 == 1112 || i2 == 4) {
                this.f31324f = null;
                this.f31325g = null;
            } else {
                this.f31324f = (NativeAdContainer) view.findViewById(R.id.native_ad_container_t);
                this.f31325g = view.findViewById(R.id.container_t);
            }
            this.I = (TextView) view.findViewById(R.id.gdt_top_ad_info);
            this.G = (ImageView) view.findViewById(R.id.iv_logo);
            this.H = (TextView) view.findViewById(R.id.iv_logo2);
            this.D = (FrameLayout) view.findViewById(R.id.title_super_view);
            this.E = (TextView) view.findViewById(R.id.tv_ad_title);
            this.F = (TextView) view.findViewById(R.id.tv_ad_desc);
            this.K = (TextView) view.findViewById(R.id.tv_download);
            this.J = (ImageView) view.findViewById(R.id.iv_close);
            if (i2 == 1 || i2 == 1115 || i2 == 1116) {
                this.f31327i = (FrameLayout) view.findViewById(R.id.csj_video);
                this.k = (MediaView) view.findViewById(R.id.tecent_video_view_t);
                this.f31326h = (ImageView) view.findViewById(R.id.iv_big_pic);
                this.f31328j = (ImageView) view.findViewById(R.id.iv_big_pic_t);
                this.p = view.findViewById(R.id.ll_content_container);
                this.l = (WblTextureMediaPlayer) view.findViewById(R.id.wbl_video_player);
                this.m = (ImageView) view.findViewById(R.id.img_play);
                this.n = (TextView) view.findViewById(R.id.tv_read_book);
                this.q = view.findViewById(R.id.view_watch_tips_container);
                this.r = (TextView) view.findViewById(R.id.tv_watch_tips);
                this.s = (ImageView) view.findViewById(R.id.iv_watch_icon);
                this.o = null;
            } else if (i2 == 1112) {
                this.f31327i = null;
                this.k = null;
                this.f31326h = null;
                this.f31328j = null;
                XNativeView xNativeView = (XNativeView) view.findViewById(R.id.baidu_video_view);
                this.o = xNativeView;
                this.p = view.findViewById(R.id.ll_content_container);
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
                this.q = null;
                this.r = null;
                this.s = null;
            } else {
                this.f31327i = null;
                this.k = null;
                this.o = null;
                this.f31326h = null;
                this.f31328j = null;
                this.p = null;
                this.q = null;
                this.r = null;
                this.s = null;
            }
            if (i2 == 2 || i2 == 1117) {
                this.t = (ImageView) view.findViewById(R.id.iv_pic_t);
                this.u = (ImageView) view.findViewById(R.id.iv_pic);
                this.v = view.findViewById(R.id.rl_right_container);
            } else {
                this.t = null;
                this.u = null;
                this.v = null;
            }
            if (i2 == 3) {
                this.w = (ImageView) view.findViewById(R.id.iv_pic_one);
                this.x = (ImageView) view.findViewById(R.id.iv_pic_two);
                this.y = (ImageView) view.findViewById(R.id.iv_pic_three);
                this.z = (ImageView) view.findViewById(R.id.iv_pic_one_t);
                this.A = (ImageView) view.findViewById(R.id.iv_pic_two_t);
                this.B = (ImageView) view.findViewById(R.id.iv_pic_three_t);
                this.C = view.findViewById(R.id.ll_content_container);
            } else {
                this.w = null;
                this.x = null;
                this.y = null;
                this.z = null;
                this.A = null;
                this.B = null;
                this.C = null;
            }
            if (i2 == 4) {
                this.L = (FrameLayout) view.findViewById(R.id.csj_mo_ban_frame);
            } else {
                this.L = null;
            }
        }

        public final void A() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16345, this, null);
        }

        public final com.wbl.ad.yzz.help.n.f a(com.wbl.ad.yzz.bean.b bVar, int i2) {
            return (com.wbl.ad.yzz.help.n.f) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16348, this, bVar, Integer.valueOf(i2));
        }

        @Override // com.wbl.ad.yzz.wigdet.k.b
        public WblTextureMediaPlayer a() {
            return (WblTextureMediaPlayer) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16347, this, null);
        }

        public final String a(NativeResponse nativeResponse) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16342, this, nativeResponse);
        }

        public final String a(NativeUnifiedADData nativeUnifiedADData) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16341, this, nativeUnifiedADData);
        }

        public final String a(com.wbl.ad.yzz.bean.j jVar) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16344, this, jVar);
        }

        public final void a(int i2, View.OnClickListener onClickListener) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16343, this, Integer.valueOf(i2), onClickListener);
        }

        @Override // com.wbl.ad.yzz.manager.l.a
        public void a(TextView textView) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16338, this, textView);
        }

        public final void a(com.wbl.ad.yzz.adapter.d.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16337, this, bVar);
        }

        public final void a(com.wbl.ad.yzz.adapter.d.b bVar, int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16340, this, bVar, Integer.valueOf(i2));
        }

        public final void a(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16339, this, bVar);
        }

        public final void a(com.wbl.ad.yzz.bean.e eVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15406, this, eVar);
        }

        public final void a(com.wbl.ad.yzz.bean.r rVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15405, this, rVar);
        }

        public final void a(com.wbl.ad.yzz.help.e eVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15408, this, eVar);
        }

        public final void a(String str, ImageView imageView) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15407, this, str, imageView);
        }

        public final void a(String str, String str2, String str3, boolean z2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15402, this, str, str2, str3, Boolean.valueOf(z2));
        }

        public final void a(String str, boolean z2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15401, this, str, Boolean.valueOf(z2));
        }

        public final void a(boolean z2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15404, this, Boolean.valueOf(z2));
        }

        public final com.wbl.ad.yzz.help.n.f b(com.wbl.ad.yzz.bean.b bVar, int i2) {
            return (com.wbl.ad.yzz.help.n.f) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15403, this, bVar, Integer.valueOf(i2));
        }

        public final String b(NativeResponse nativeResponse) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15398, this, nativeResponse);
        }

        public final String b(NativeUnifiedADData nativeUnifiedADData) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15397, this, nativeUnifiedADData);
        }

        public final String b(com.wbl.ad.yzz.bean.j jVar) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15400, this, jVar);
        }

        @Override // com.wbl.ad.yzz.adapter.d.c
        public void b() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15399, this, null);
        }

        public final void b(com.wbl.ad.yzz.adapter.d.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15394, this, bVar);
        }

        public final void b(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15393, this, bVar);
        }

        public final void b(com.wbl.ad.yzz.bean.e eVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15396, this, eVar);
        }

        public final void b(com.wbl.ad.yzz.bean.r rVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15395, this, rVar);
        }

        public final void b(String str, boolean z2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15422, this, str, Boolean.valueOf(z2));
        }

        @Override // com.wbl.ad.yzz.manager.l.a
        public TextView c() {
            return (TextView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15421, this, null);
        }

        public final String c(NativeResponse nativeResponse) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15424, this, nativeResponse);
        }

        public final String c(NativeUnifiedADData nativeUnifiedADData) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15423, this, nativeUnifiedADData);
        }

        public final String c(com.wbl.ad.yzz.bean.j jVar) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15418, this, jVar);
        }

        public final void c(com.wbl.ad.yzz.adapter.d.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15417, this, bVar);
        }

        public final void c(com.wbl.ad.yzz.bean.e eVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15420, this, eVar);
        }

        public final void c(com.wbl.ad.yzz.bean.r rVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15419, this, rVar);
        }

        public final String d(NativeResponse nativeResponse) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15414, this, nativeResponse);
        }

        public final void d() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15413, this, null);
        }

        public final void d(com.wbl.ad.yzz.adapter.d.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15416, this, bVar);
        }

        public final void d(com.wbl.ad.yzz.bean.r rVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15415, this, rVar);
        }

        public final void e() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15410, this, null);
        }

        public final void e(com.wbl.ad.yzz.adapter.d.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15409, this, bVar);
        }

        public final void e(com.wbl.ad.yzz.bean.r rVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15412, this, rVar);
        }

        public final void f() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15411, this, null);
        }

        public final void f(com.wbl.ad.yzz.bean.r rVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15374, this, rVar);
        }

        public final void g() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15373, this, null);
        }

        public final void g(com.wbl.ad.yzz.bean.r rVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15376, this, rVar);
        }

        public final NativeResponse h() {
            return (NativeResponse) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15375, this, null);
        }

        public final com.wbl.ad.yzz.bean.e i() {
            return (com.wbl.ad.yzz.bean.e) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15370, this, null);
        }

        public final com.wbl.ad.yzz.bean.b j() {
            return (com.wbl.ad.yzz.bean.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15369, this, null);
        }

        public final com.wbl.ad.yzz.bean.j k() {
            return (com.wbl.ad.yzz.bean.j) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15372, this, null);
        }

        public final int l() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-15371, this, null);
        }

        public final XNativeView m() {
            return (XNativeView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15366, this, null);
        }

        public final View n() {
            return (View) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15365, this, null);
        }

        public final View o() {
            return (View) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15368, this, null);
        }

        public final com.wbl.ad.yzz.help.e p() {
            return (com.wbl.ad.yzz.help.e) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15367, this, null);
        }

        public final ImageView q() {
            return (ImageView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15362, this, null);
        }

        public final ImageView r() {
            return (ImageView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15361, this, null);
        }

        public final TextView s() {
            return (TextView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15364, this, null);
        }

        public final ImageView t() {
            return (ImageView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15363, this, null);
        }

        public final WblTextureMediaPlayer u() {
            return (WblTextureMediaPlayer) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15390, this, null);
        }

        public final TTNativeExpressAd v() {
            return (TTNativeExpressAd) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15389, this, null);
        }

        public final String w() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15392, this, null);
        }

        public final NativeUnifiedADData x() {
            return (NativeUnifiedADData) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15391, this, null);
        }

        public final com.wbl.ad.yzz.bean.r y() {
            return (com.wbl.ad.yzz.bean.r) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15386, this, null);
        }

        public final com.wbl.ad.yzz.bean.r z() {
            return (com.wbl.ad.yzz.bean.r) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15385, this, null);
        }
    }

    public static final class g implements NativeResponse.AdInteractionListener {

        /* renamed from: a */
        public boolean f31370a;

        /* renamed from: c */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f31372c;

        /* renamed from: d */
        public final /* synthetic */ String f31373d;

        /* renamed from: e */
        public final /* synthetic */ Ref.ObjectRef f31374e;

        /* renamed from: f */
        public final /* synthetic */ String f31375f;

        /* renamed from: g */
        public final /* synthetic */ NativeResponse f31376g;

        /* renamed from: h */
        public final /* synthetic */ String f31377h;

        public g(com.wbl.ad.yzz.bean.b bVar, String str, Ref.ObjectRef objectRef, String str2, NativeResponse nativeResponse, String str3) {
            this.f31372c = bVar;
            this.f31373d = str;
            this.f31374e = objectRef;
            this.f31375f = str2;
            this.f31376g = nativeResponse;
            this.f31377h = str3;
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onADExposed() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15388, this, null);
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onADExposureFailed(int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15387, this, Integer.valueOf(i2));
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onADStatusChanged() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15382, this, null);
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onAdClick() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15381, this, null);
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onAdUnionClick() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15384, this, null);
        }
    }

    public static final class h implements View.OnClickListener {

        /* renamed from: b */
        public final /* synthetic */ Ref.ObjectRef f31379b;

        /* renamed from: c */
        public final /* synthetic */ com.wbl.ad.yzz.help.e f31380c;

        /* renamed from: d */
        public final /* synthetic */ int f31381d;

        /* renamed from: e */
        public final /* synthetic */ NativeResponse f31382e;

        /* renamed from: f */
        public final /* synthetic */ View f31383f;

        public static final class a implements e.c {
            public a() {
            }

            @Override // com.wbl.ad.yzz.help.e.c
            public void a() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15383, this, null);
            }

            @Override // com.wbl.ad.yzz.help.e.c
            public void b() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15378, this, null);
            }

            @Override // com.wbl.ad.yzz.help.e.c
            public void c() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15377, this, null);
            }
        }

        public h(Ref.ObjectRef objectRef, com.wbl.ad.yzz.help.e eVar, int i2, NativeResponse nativeResponse, View view) {
            this.f31379b = objectRef;
            this.f31380c = eVar;
            this.f31381d = i2;
            this.f31382e = nativeResponse;
            this.f31383f = view;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15380, this, view);
        }
    }

    public static final class i implements View.OnClickListener {

        /* renamed from: b */
        public final /* synthetic */ TextView f31386b;

        /* renamed from: c */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f31387c;

        /* renamed from: d */
        public final /* synthetic */ View f31388d;

        public i(TextView textView, com.wbl.ad.yzz.bean.b bVar, View view) {
            this.f31386b = textView;
            this.f31387c = bVar;
            this.f31388d = view;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15379, this, view);
        }
    }

    public static final class j implements TTNativeAd.AdInteractionListener {

        /* renamed from: b */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f31390b;

        /* renamed from: c */
        public final /* synthetic */ String f31391c;

        /* renamed from: d */
        public final /* synthetic */ e.b f31392d;

        /* renamed from: e */
        public final /* synthetic */ int f31393e;

        /* renamed from: f */
        public final /* synthetic */ String f31394f;

        /* renamed from: g */
        public final /* synthetic */ String f31395g;

        public j(com.wbl.ad.yzz.bean.b bVar, String str, e.b bVar2, int i2, String str2, String str3) {
            this.f31390b = bVar;
            this.f31391c = str;
            this.f31392d = bVar2;
            this.f31393e = i2;
            this.f31394f = str2;
            this.f31395g = str3;
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdClicked(View view, TTNativeAd tTNativeAd) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15470, this, view, tTNativeAd);
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15469, this, view, tTNativeAd);
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdShow(TTNativeAd tTNativeAd) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15472, this, tTNativeAd);
        }
    }

    public static final class k implements TTNativeExpressAd.ExpressAdInteractionListener {

        /* renamed from: b */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f31397b;

        /* renamed from: c */
        public final /* synthetic */ String f31398c;

        /* renamed from: d */
        public final /* synthetic */ String f31399d;

        /* renamed from: e */
        public final /* synthetic */ String f31400e;

        public k(com.wbl.ad.yzz.bean.b bVar, String str, String str2, String str3) {
            this.f31397b = bVar;
            this.f31398c = str;
            this.f31399d = str2;
            this.f31400e = str3;
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onAdClicked(View view, int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15471, this, view, Integer.valueOf(i2));
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onAdShow(View view, int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15466, this, view, Integer.valueOf(i2));
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onRenderFail(View view, String str, int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15465, this, view, str, Integer.valueOf(i2));
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onRenderSuccess(View view, float f2, float f3) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15468, this, view, Float.valueOf(f2), Float.valueOf(f3));
        }
    }

    public static final class l implements c.a {

        /* renamed from: b */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f31402b;

        /* renamed from: c */
        public final /* synthetic */ C0683f f31403c;

        public l(com.wbl.ad.yzz.bean.b bVar, C0683f c0683f) {
            this.f31402b = bVar;
            this.f31403c = c0683f;
        }

        @Override // com.wbl.ad.yzz.dialog.c.a
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15467, this, null);
        }
    }

    public static final class m extends com.wbl.ad.yzz.bean.i {

        /* renamed from: f */
        public final /* synthetic */ C0683f f31405f;

        /* renamed from: g */
        public final /* synthetic */ com.wbl.ad.yzz.bean.k f31406g;

        /* renamed from: h */
        public final /* synthetic */ String f31407h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(C0683f c0683f, com.wbl.ad.yzz.bean.k kVar, String str, com.wbl.ad.yzz.bean.b bVar, boolean z, e.b bVar2, int i2, String str2, String str3, com.wbl.ad.yzz.bean.b bVar3, TextView textView, TTAppDownloadListener tTAppDownloadListener) {
            super(bVar3, textView, tTAppDownloadListener);
            this.f31405f = c0683f;
            this.f31406g = kVar;
            this.f31407h = str;
        }

        @Override // com.wbl.ad.yzz.bean.h
        public void a(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15462, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.bean.h
        public boolean d() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-15461, this, null);
        }
    }

    public static final class n implements TTAppDownloadListener {

        /* renamed from: b */
        public final /* synthetic */ String f31409b;

        /* renamed from: c */
        public final /* synthetic */ com.wbl.ad.yzz.bean.k f31410c;

        /* renamed from: d */
        public final /* synthetic */ boolean f31411d;

        /* renamed from: e */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f31412e;

        /* renamed from: f */
        public final /* synthetic */ e.b f31413f;

        /* renamed from: g */
        public final /* synthetic */ int f31414g;

        /* renamed from: h */
        public final /* synthetic */ String f31415h;

        /* renamed from: i */
        public final /* synthetic */ String f31416i;

        public n(String str, com.wbl.ad.yzz.bean.k kVar, boolean z, com.wbl.ad.yzz.bean.b bVar, e.b bVar2, int i2, String str2, String str3) {
            this.f31409b = str;
            this.f31410c = kVar;
            this.f31411d = z;
            this.f31412e = bVar;
            this.f31413f = bVar2;
            this.f31414g = i2;
            this.f31415h = str2;
            this.f31416i = str3;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadActive(long j2, long j3, String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15464, this, Long.valueOf(j2), Long.valueOf(j3), str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFailed(long j2, long j3, String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15463, this, Long.valueOf(j2), Long.valueOf(j3), str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFinished(long j2, String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15458, this, Long.valueOf(j2), str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadPaused(long j2, long j3, String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15457, this, Long.valueOf(j2), Long.valueOf(j3), str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onIdle() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15460, this, null);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onInstalled(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15459, this, str, str2);
        }
    }

    public static final class o implements e.c {

        /* renamed from: b */
        public final /* synthetic */ com.wbl.ad.yzz.help.e f31418b;

        /* renamed from: c */
        public final /* synthetic */ int f31419c;

        /* renamed from: d */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f31420d;

        /* renamed from: e */
        public final /* synthetic */ String f31421e;

        /* renamed from: f */
        public final /* synthetic */ String f31422f;

        /* renamed from: g */
        public final /* synthetic */ String f31423g;

        public o(com.wbl.ad.yzz.help.e eVar, int i2, com.wbl.ad.yzz.bean.b bVar, String str, String str2, String str3) {
            this.f31418b = eVar;
            this.f31419c = i2;
            this.f31420d = bVar;
            this.f31421e = str;
            this.f31422f = str2;
            this.f31423g = str3;
        }

        @Override // com.wbl.ad.yzz.help.e.c
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15486, this, null);
        }

        @Override // com.wbl.ad.yzz.help.e.c
        public void b() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15485, this, null);
        }

        @Override // com.wbl.ad.yzz.help.e.c
        public void c() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15488, this, null);
        }
    }

    public static final class p implements View.OnClickListener {

        /* renamed from: b */
        public final /* synthetic */ TextView f31425b;

        /* renamed from: c */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f31426c;

        /* renamed from: d */
        public final /* synthetic */ View f31427d;

        public p(TextView textView, com.wbl.ad.yzz.bean.b bVar, View view) {
            this.f31425b = textView;
            this.f31426c = bVar;
            this.f31427d = view;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15487, this, view);
        }
    }

    public static final class q implements NativeADEventListener {

        /* renamed from: a */
        public boolean f31428a;

        /* renamed from: c */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f31430c;

        /* renamed from: d */
        public final /* synthetic */ String f31431d;

        /* renamed from: e */
        public final /* synthetic */ String f31432e;

        /* renamed from: f */
        public final /* synthetic */ String f31433f;

        /* renamed from: g */
        public final /* synthetic */ boolean f31434g;

        /* renamed from: h */
        public final /* synthetic */ int f31435h;

        /* renamed from: i */
        public final /* synthetic */ String f31436i;

        /* renamed from: j */
        public final /* synthetic */ NativeUnifiedADData f31437j;
        public final /* synthetic */ C0683f k;

        public q(com.wbl.ad.yzz.bean.b bVar, String str, String str2, String str3, boolean z, int i2, String str4, NativeUnifiedADData nativeUnifiedADData, C0683f c0683f) {
            this.f31430c = bVar;
            this.f31431d = str;
            this.f31432e = str2;
            this.f31433f = str3;
            this.f31434g = z;
            this.f31435h = i2;
            this.f31436i = str4;
            this.f31437j = nativeUnifiedADData;
            this.k = c0683f;
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADClicked() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15482, this, null);
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADError(AdError adError) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15481, this, adError);
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADExposed() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15484, this, null);
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADStatusChanged() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15483, this, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@f.b.a.e List<b> list, @f.b.a.d Activity mContext) {
        super(list);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
        this.TAG = "QuickAutoAdapter";
        this.mTTAppDownloadListenerMap = new WeakHashMap();
        com.wbl.ad.yzz.manager.f fVar = new com.wbl.ad.yzz.manager.f();
        this.mDownLoadApkManager = fVar;
        this.mStartUpHelper = new com.wbl.ad.yzz.help.l();
        fVar.a(mContext);
        this.mStartUpHelperItemListener = new a();
    }

    public static final /* synthetic */ Drawable b(f fVar) {
        return (Drawable) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15435, null, fVar);
    }

    public static final /* synthetic */ Context c(f fVar) {
        return (Context) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15429, null, fVar);
    }

    public static final /* synthetic */ Activity d(f fVar) {
        return (Activity) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15432, null, fVar);
    }

    public static final /* synthetic */ com.wbl.ad.yzz.manager.f e(f fVar) {
        return (com.wbl.ad.yzz.manager.f) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15431, null, fVar);
    }

    public static final /* synthetic */ String f(f fVar) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15426, null, fVar);
    }

    public static final /* synthetic */ String g(f fVar) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15425, null, fVar);
    }

    public static final /* synthetic */ a.InterfaceC0679a h(f fVar) {
        return (a.InterfaceC0679a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15428, null, fVar);
    }

    public static final /* synthetic */ String i(f fVar) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15427, null, fVar);
    }

    public static final /* synthetic */ String u() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15454, null, null);
    }

    public final int A() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-15453, this, null);
    }

    public com.wbl.ad.yzz.innerconfig.d.d B() {
        return (com.wbl.ad.yzz.innerconfig.d.d) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15456, this, null);
    }

    public final void C() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15455, this, null);
    }

    @Override // com.wbl.ad.yzz.adapter.base.BaseQuickAdapter
    public void a(BaseViewHolder holder) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15450, this, holder);
    }

    public void a(BaseViewHolder holder, b item) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15449, this, holder, item);
    }

    @Override // com.wbl.ad.yzz.adapter.base.BaseQuickAdapter
    public /* bridge */ /* synthetic */ void a(BaseViewHolder baseViewHolder, Object obj) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15452, this, baseViewHolder, obj);
    }

    @Override // com.wbl.ad.yzz.adapter.d.a
    public void a(com.wbl.ad.yzz.adapter.c.b itemListener) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15451, this, itemListener);
    }

    @Override // com.wbl.ad.yzz.adapter.d.a
    public void a(a.InterfaceC0679a onQuickAdapterListener) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15446, this, onQuickAdapterListener);
    }

    public final void a(C0683f holder, View mContainer, View clickableView, TextView mIvDownApp, ImageView ivClose, String adType) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15445, this, holder, mContainer, clickableView, mIvDownApp, ivClose, adType);
    }

    public final void a(C0683f holder, View mContainer, TextView mIvDownApp, ImageView ivClose, String adType) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15448, this, holder, mContainer, mIvDownApp, ivClose, adType);
    }

    public final void a(C0683f holder, NativeAdContainer mItemTypeOneContainer, MediaView mTencentVideoViewT, View containerT, TextView tvDownApp, ImageView ivClose, String adType) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15447, this, holder, mItemTypeOneContainer, mTencentVideoViewT, containerT, tvDownApp, ivClose, adType);
    }

    public final void a(C0683f holder, String csj_muban_adType) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15442, this, holder, csj_muban_adType);
    }

    public final void a(com.wbl.ad.yzz.bean.b bean, int position, String r5, String adType, String clickType) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15441, this, bean, Integer.valueOf(position), r5, adType, clickType);
    }

    public final void a(com.wbl.ad.yzz.bean.b bean, int position, String r5, String adType, String clickType, WblTextureMediaPlayer player) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15444, this, bean, Integer.valueOf(position), r5, adType, clickType, player);
    }

    public final void a(com.wbl.ad.yzz.bean.b bean, r yzzAdBean, String channel, int position, String r7, String adType, String clickType, boolean isRepeat) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15443, this, bean, yzzAdBean, channel, Integer.valueOf(position), r7, adType, clickType, Boolean.valueOf(isRepeat));
    }

    public final void a(com.wbl.ad.yzz.bean.b bean, String url) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15534, this, bean, url);
    }

    public final void a(com.wbl.ad.yzz.bean.b bean, String channel, String position, String r6, String adType) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15533, this, bean, channel, position, r6, adType);
    }

    public final void a(com.wbl.ad.yzz.bean.b bean, String channel, String position, String r6, String adType, String clickType) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15536, this, bean, channel, position, r6, adType, clickType);
    }

    public final void a(com.wbl.ad.yzz.bean.j ad2, TTNativeExpressAd ttNativeExpressAd, com.wbl.ad.yzz.help.e downLoadApkHelper, C0683f holder, String uniq_id, String r8, String adType) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15535, this, ad2, ttNativeExpressAd, downLoadApkHelper, holder, uniq_id, r8, adType);
    }

    public final void a(e.b pair, com.wbl.ad.yzz.bean.b bean, int position, String r6, String adType, String clickType) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15530, this, pair, bean, Integer.valueOf(position), r6, adType, clickType);
    }

    @Override // com.wbl.ad.yzz.adapter.d.a
    public void a(com.wbl.ad.yzz.innerconfig.d.j sceneDataInfoWrap) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15529, this, sceneDataInfoWrap);
    }

    @Override // com.wbl.ad.yzz.adapter.d.a
    public void a(u.b conf) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15532, this, conf);
    }

    @Override // com.wbl.ad.yzz.adapter.d.a
    public void a(String color) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15531, this, color);
    }

    public final void a(String uniq_id, String channel) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15526, this, uniq_id, channel);
    }

    public final void a(String uniq_id, String channel, com.wbl.ad.yzz.bean.b bean) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15525, this, uniq_id, channel, bean);
    }

    public final void a(boolean isShowMore, boolean isDownloadTips) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15528, this, Boolean.valueOf(isShowMore), Boolean.valueOf(isDownloadTips));
    }

    public final void a(boolean isCustom, boolean isDownload, com.wbl.ad.yzz.bean.b bean, e.b pair, int position, String uniq_id, String r9, String adType) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15527, this, Boolean.valueOf(isCustom), Boolean.valueOf(isDownload), bean, pair, Integer.valueOf(position), uniq_id, r9, adType);
    }

    @Override // com.wbl.ad.yzz.adapter.base.BaseMultiItemQuickAdapter, com.wbl.ad.yzz.adapter.base.BaseQuickAdapter
    public BaseViewHolder b(ViewGroup parent, int viewType) {
        return (BaseViewHolder) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15522, this, parent, Integer.valueOf(viewType));
    }

    public final void b(String uniq_id, String channel, com.wbl.ad.yzz.bean.b bean) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15521, this, uniq_id, channel, bean);
    }

    @Override // com.wbl.ad.yzz.adapter.d.a
    public void r() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15524, this, null);
    }

    @Override // com.wbl.ad.yzz.adapter.d.a
    public void t() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15523, this, null);
    }

    public final void v() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15550, this, null);
    }

    public final Drawable w() {
        return (Drawable) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15549, this, null);
    }

    public final int x() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-15552, this, null);
    }

    public final Map<RecyclerView.ViewHolder, TTAppDownloadListener> y() {
        return (Map) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15551, this, null);
    }

    public final int z() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-15546, this, null);
    }
}
