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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\t\u0018\u0000 \u0094\u00012\u00020\u0001:\tF\u0095\u0001\u0096\u0001\u0097\u0001\u0098\u0001B%\u0012\u0010\u0010\u0091\u0001\u001a\u000b\u0012\u0004\u0012\u00020d\u0018\u00010\u0090\u0001\u0012\b\u0010\u008d\u0001\u001a\u00030\u008a\u0001¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u0011\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\u0004J9\u0010\u0014\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0015JC\u0010\u0014\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0014\u0010\u0018JS\u0010\u0014\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u0014\u0010\u001eJ#\u0010\u0014\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0014\u0010 JA\u0010\u0014\u001a\u00020\u00052\n\u0010\"\u001a\u00060!R\u00020\u00002\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010&\u001a\u0004\u0018\u00010%2\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010\u0012\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010)JK\u0010\u0014\u001a\u00020\u00052\n\u0010\"\u001a\u00060!R\u00020\u00002\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010*\u001a\u0004\u0018\u00010#2\b\u0010&\u001a\u0004\u0018\u00010%2\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010\u0012\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010+JA\u0010\u0014\u001a\u00020\u00052\b\u0010-\u001a\u0004\u0018\u00010,2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010.J#\u0010\u0014\u001a\u00020\u00052\n\u0010\"\u001a\u00060!R\u00020\u00002\u0006\u0010/\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u00100JU\u0010\u0014\u001a\u00020\u00052\n\u0010\"\u001a\u00060!R\u00020\u00002\b\u00102\u001a\u0004\u0018\u0001012\b\u00104\u001a\u0004\u0018\u0001032\b\u00105\u001a\u0004\u0018\u00010#2\b\u00106\u001a\u0004\u0018\u00010%2\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010\u0012\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u00107JS\u0010\u0014\u001a\u00020\u00052\b\u00109\u001a\u0004\u0018\u0001082\b\u0010;\u001a\u0004\u0018\u00010:2\b\u0010=\u001a\u0004\u0018\u00010<2\n\u0010\"\u001a\u00060!R\u00020\u00002\b\u0010>\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010?JU\u0010\u0014\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u001c2\u0006\u0010A\u001a\u00020\u001c2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010-\u001a\u0004\u0018\u00010,2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010>\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010BJ7\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010CJ?\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010DJ+\u0010\u0014\u001a\u00020\u00052\b\u0010>\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001b\u001a\u00020\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0014\u0010EJ-\u0010F\u001a\u00020\u00052\b\u0010>\u001a\u0004\u0018\u00010\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\bF\u0010EJ#\u0010\u0014\u001a\u00020\u00052\b\u0010>\u001a\u0004\u0018\u00010\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0014\u0010GJ\u001f\u0010\u0014\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u0014\u0010JJ\u000f\u0010K\u001a\u00020\u0005H\u0002¢\u0006\u0004\bK\u0010\u0007J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010M\u001a\u00020LH\u0016¢\u0006\u0004\b\u0014\u0010NJ\u0019\u0010\u0014\u001a\u00020\u00052\b\u0010P\u001a\u0004\u0018\u00010OH\u0016¢\u0006\u0004\b\u0014\u0010QJ\u0019\u0010\u0014\u001a\u00020\u00052\b\u0010R\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0014\u0010SJ\u0019\u0010\u0014\u001a\u00020\u00052\b\u0010U\u001a\u0004\u0018\u00010TH\u0016¢\u0006\u0004\b\u0014\u0010VJ\u0019\u0010\u0014\u001a\u00020\u00052\b\u0010X\u001a\u0004\u0018\u00010WH\u0016¢\u0006\u0004\b\u0014\u0010YJ\u0011\u0010[\u001a\u0004\u0018\u00010ZH\u0016¢\u0006\u0004\b[\u0010\\J\u000f\u0010]\u001a\u00020\u0005H\u0016¢\u0006\u0004\b]\u0010\u0007J\u000f\u0010^\u001a\u00020\u0005H\u0016¢\u0006\u0004\b^\u0010\u0007J\u001f\u0010F\u001a\u00020b2\u0006\u0010`\u001a\u00020_2\u0006\u0010a\u001a\u00020\u0002H\u0014¢\u0006\u0004\bF\u0010cJ\u001f\u0010\u0014\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020b2\u0006\u0010e\u001a\u00020dH\u0014¢\u0006\u0004\b\u0014\u0010fJ\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020bH\u0016¢\u0006\u0004\b\u0014\u0010gR\u0016\u0010k\u001a\u00020h8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010jR\u0018\u0010n\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010mR\u0018\u0010q\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010pR\u0018\u0010M\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010rR\u0018\u0010u\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010tR\u0018\u0010w\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010mR\u0016\u0010{\u001a\u00020x8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\by\u0010zR\u0018\u0010~\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010}R+\u0010\u0085\u0001\u001a\u0010\u0012\u0005\u0012\u00030\u0080\u0001\u0012\u0005\u0012\u00030\u0081\u00010\u007f8\u0006@\u0006¢\u0006\u000f\n\u0005\b[\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001a\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0086\u0001\u0010mR\u001a\u0010\u0089\u0001\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0088\u0001\u0010rR\u001a\u0010\u008d\u0001\u001a\u00030\u008a\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R\u0018\u0010\u008f\u0001\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008e\u0001\u0010y¨\u0006\u0099\u0001"}, d2 = {"Lcom/wbl/ad/yzz/adapter/d/e;", "Lcom/wbl/ad/yzz/adapter/d/a;", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()I", "", "D", "()V", "y", "Landroid/graphics/drawable/Drawable;", "x", "()Landroid/graphics/drawable/Drawable;", "B", "Lcom/wbl/ad/yzz/bean/b;", "bean", "position", "", VideoActivity.EXTRA_KEY_ACTION_TYPE, "adType", "clickType", "a", "(Lcom/wbl/ad/yzz/bean/b;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/wbl/ad/yzz/wigdet/wblplayer/WblTextureMediaPlayer;", "player", "(Lcom/wbl/ad/yzz/bean/b;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/wbl/ad/yzz/wigdet/wblplayer/WblTextureMediaPlayer;)V", "Lcom/wbl/ad/yzz/bean/r;", "yzzAdBean", "channel", "", "isRepeat", "(Lcom/wbl/ad/yzz/bean/b;Lcom/wbl/ad/yzz/bean/r;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "url", "(Lcom/wbl/ad/yzz/bean/b;Ljava/lang/String;)V", "Lcom/wbl/ad/yzz/adapter/d/e$f;", "holder", "Landroid/view/View;", "mContainer", "Landroid/widget/TextView;", "mIvDownApp", "Landroid/widget/ImageView;", "ivClose", "(Lcom/wbl/ad/yzz/adapter/d/e$f;Landroid/view/View;Landroid/widget/TextView;Landroid/widget/ImageView;Ljava/lang/String;)V", "clickableView", "(Lcom/wbl/ad/yzz/adapter/d/e$f;Landroid/view/View;Landroid/view/View;Landroid/widget/TextView;Landroid/widget/ImageView;Ljava/lang/String;)V", "Lcom/wbl/ad/yzz/help/e$b;", "pair", "(Lcom/wbl/ad/yzz/help/e$b;Lcom/wbl/ad/yzz/bean/b;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "csj_muban_adType", "(Lcom/wbl/ad/yzz/adapter/d/e$f;Ljava/lang/String;)V", "Lcom/qq/e/ads/nativ/widget/NativeAdContainer;", "mItemTypeOneContainer", "Lcom/qq/e/ads/nativ/MediaView;", "mTencentVideoViewT", "containerT", "tvDownApp", "(Lcom/wbl/ad/yzz/adapter/d/e$f;Lcom/qq/e/ads/nativ/widget/NativeAdContainer;Lcom/qq/e/ads/nativ/MediaView;Landroid/view/View;Landroid/widget/TextView;Landroid/widget/ImageView;Ljava/lang/String;)V", "Lcom/wbl/ad/yzz/bean/j;", "ad", "Lcom/bytedance/sdk/openadsdk/TTNativeExpressAd;", "ttNativeExpressAd", "Lcom/wbl/ad/yzz/help/e;", "downLoadApkHelper", "uniq_id", "(Lcom/wbl/ad/yzz/bean/j;Lcom/bytedance/sdk/openadsdk/TTNativeExpressAd;Lcom/wbl/ad/yzz/help/e;Lcom/wbl/ad/yzz/adapter/d/e$f;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "isCustom", "isDownload", "(ZZLcom/wbl/ad/yzz/bean/b;Lcom/wbl/ad/yzz/help/e$b;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Lcom/wbl/ad/yzz/bean/b;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Lcom/wbl/ad/yzz/bean/b;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;Lcom/wbl/ad/yzz/bean/b;)V", "b", "(Ljava/lang/String;Ljava/lang/String;)V", "isShowMore", "isDownloadTips", "(ZZ)V", IAdInterListener.AdReqParam.WIDTH, "Lcom/wbl/ad/yzz/adapter/c/b;", "itemListener", "(Lcom/wbl/ad/yzz/adapter/c/b;)V", "Lcom/wbl/ad/yzz/adapter/d/a$a;", "onQuickAdapterListener", "(Lcom/wbl/ad/yzz/adapter/d/a$a;)V", "color", "(Ljava/lang/String;)V", "Lcom/wbl/ad/yzz/network/b/b/u$b;", "conf", "(Lcom/wbl/ad/yzz/network/b/b/u$b;)V", "Lcom/wbl/ad/yzz/innerconfig/d/j;", "sceneDataInfoWrap", "(Lcom/wbl/ad/yzz/innerconfig/d/j;)V", "Lcom/wbl/ad/yzz/innerconfig/d/d;", "C", "()Lcom/wbl/ad/yzz/innerconfig/d/d;", "t", t.k, "Landroid/view/ViewGroup;", "parent", "viewType", "Lcom/wbl/ad/yzz/adapter/base/viewholder/BaseViewHolder;", "(Landroid/view/ViewGroup;I)Lcom/wbl/ad/yzz/adapter/base/viewholder/BaseViewHolder;", "Lcom/wbl/ad/yzz/adapter/d/b;", "item", "(Lcom/wbl/ad/yzz/adapter/base/viewholder/BaseViewHolder;Lcom/wbl/ad/yzz/adapter/d/b;)V", "(Lcom/wbl/ad/yzz/adapter/base/viewholder/BaseViewHolder;)V", "Lcom/wbl/ad/yzz/manager/f;", "H", "Lcom/wbl/ad/yzz/manager/f;", "mDownLoadApkManager", "L", "Ljava/lang/String;", "mGuideIcon", ExifInterface.LONGITUDE_EAST, "Lcom/wbl/ad/yzz/adapter/d/a$a;", "mOnQuickAdapterListener", "Lcom/wbl/ad/yzz/adapter/c/b;", "N", "Lcom/wbl/ad/yzz/innerconfig/d/d;", "mISceneCache", "K", "mGuideContent", "Lcom/wbl/ad/yzz/help/l;", "I", "Lcom/wbl/ad/yzz/help/l;", "mStartUpHelper", "M", "Lcom/wbl/ad/yzz/innerconfig/d/j;", "mSceneDataInfoWrap", "", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/bytedance/sdk/openadsdk/TTAppDownloadListener;", "Ljava/util/Map;", am.aD, "()Ljava/util/Map;", "mTTAppDownloadListenerMap", "F", "mBgColor", "J", "mStartUpHelperItemListener", "Landroid/app/Activity;", "O", "Landroid/app/Activity;", "mContext", "G", "mBgColorInt", "", MiConfigSingleton.t0, "<init>", "(Ljava/util/List;Landroid/app/Activity;)V", "R", "c", "d", com.kwad.sdk.ranger.e.TAG, "f", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class e extends com.wbl.ad.yzz.adapter.d.a {

    @f.b.a.d
    public static final String P = "QADR";

    @f.b.a.d
    public static final String Q = "数据为空";

    /* renamed from: R, reason: from kotlin metadata */
    @f.b.a.d
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @f.b.a.d
    public final Map<RecyclerView.ViewHolder, TTAppDownloadListener> mTTAppDownloadListenerMap;

    /* renamed from: D, reason: from kotlin metadata */
    public com.wbl.ad.yzz.adapter.c.b itemListener;

    /* renamed from: E */
    public a.InterfaceC0679a mOnQuickAdapterListener;

    /* renamed from: F, reason: from kotlin metadata */
    public String mBgColor;

    /* renamed from: G, reason: from kotlin metadata */
    public int mBgColorInt;

    /* renamed from: H, reason: from kotlin metadata */
    public final com.wbl.ad.yzz.manager.f mDownLoadApkManager;

    /* renamed from: I, reason: from kotlin metadata */
    public final com.wbl.ad.yzz.help.l mStartUpHelper;

    /* renamed from: J, reason: from kotlin metadata */
    public final com.wbl.ad.yzz.adapter.c.b mStartUpHelperItemListener;

    /* renamed from: K, reason: from kotlin metadata */
    public String mGuideContent;

    /* renamed from: L, reason: from kotlin metadata */
    public String mGuideIcon;

    /* renamed from: M, reason: from kotlin metadata */
    public com.wbl.ad.yzz.innerconfig.d.j mSceneDataInfoWrap;

    /* renamed from: N, reason: from kotlin metadata */
    public com.wbl.ad.yzz.innerconfig.d.d mISceneCache;

    /* renamed from: O, reason: from kotlin metadata */
    public final Activity mContext;

    public static final class a implements com.wbl.ad.yzz.adapter.c.b {
        public a() {
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16102, this, Integer.valueOf(i2));
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(com.wbl.ad.yzz.bean.b bVar, String str, String str2, String str3, String str4) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16101, this, bVar, str, str2, str3, str4);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(com.wbl.ad.yzz.bean.b bVar, String str, String str2, String str3, String str4, String str5) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16104, this, bVar, str, str2, str3, str4, str5);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16103, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(String str, String str2, com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16098, this, str, str2, bVar);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(boolean z, boolean z2, String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16097, this, Boolean.valueOf(z), Boolean.valueOf(z2), str);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void b(String str, String str2, com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16100, this, str, str2, bVar);
        }
    }

    /* renamed from: com.wbl.ad.yzz.adapter.d.e$b, reason: from kotlin metadata */
    public static final class Companion {
        public Companion() {
        }

        public final String a() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16099, this, null);
        }

        public final String b() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16126, this, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final class c extends f {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(e eVar, @f.b.a.d int i2, View view) {
            super(eVar, i2, view);
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    public final class d extends f {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(e eVar, @f.b.a.d int i2, View view) {
            super(eVar, i2, view);
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    /* renamed from: com.wbl.ad.yzz.adapter.d.e$e */
    public final class C0680e extends f {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0680e(e eVar, @f.b.a.d int i2, View view) {
            super(eVar, i2, view);
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    public class f extends BaseViewHolder implements l.a, com.wbl.ad.yzz.wigdet.k.b {

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
        public final /* synthetic */ e P;

        /* renamed from: a */
        public final int f31200a;

        /* renamed from: b */
        @f.b.a.e
        public com.wbl.ad.yzz.bean.b f31201b;

        /* renamed from: c */
        @f.b.a.e
        public final View f31202c;

        /* renamed from: d */
        @f.b.a.e
        public final View f31203d;

        /* renamed from: e */
        @f.b.a.e
        public final View f31204e;

        /* renamed from: f */
        @f.b.a.e
        public final NativeAdContainer f31205f;

        /* renamed from: g */
        @f.b.a.e
        public final View f31206g;

        /* renamed from: h */
        @f.b.a.e
        public final ImageView f31207h;

        /* renamed from: i */
        @f.b.a.e
        public final FrameLayout f31208i;

        /* renamed from: j */
        @f.b.a.e
        public final ImageView f31209j;

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

        public static final class a implements View.OnClickListener {

            /* renamed from: b */
            public final /* synthetic */ com.wbl.ad.yzz.adapter.d.b f31211b;

            /* renamed from: c */
            public final /* synthetic */ int f31212c;

            public a(com.wbl.ad.yzz.adapter.d.b bVar, int i2) {
                this.f31211b = bVar;
                this.f31212c = i2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16128, this, view);
            }
        }

        public static final class a0 implements View.OnClickListener {
            public a0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16125, this, view);
            }
        }

        public static final class b implements View.OnClickListener {
            public b() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16120, this, view);
            }
        }

        public static final class b0 implements com.wbl.ad.yzz.help.n.f {
            public b0() {
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(float f2, com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16127, this, Float.valueOf(f2), bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16122, this, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(String str, com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16121, this, str, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(boolean z, boolean z2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16124, this, Boolean.valueOf(z), Boolean.valueOf(z2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void b(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16123, this, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void c(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16118, this, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void d(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16117, this, bVar, Integer.valueOf(i2));
            }
        }

        public static final class c implements View.OnClickListener {
            public c() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16114, this, view);
            }
        }

        public static final class c0 implements View.OnClickListener {
            public c0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16119, this, view);
            }
        }

        public static final class d implements View.OnClickListener {
            public d() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16116, this, view);
            }
        }

        public static final class d0 implements View.OnClickListener {
            public d0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16113, this, view);
            }
        }

        /* renamed from: com.wbl.ad.yzz.adapter.d.e$f$e */
        public static final class ViewOnClickListenerC0681e implements View.OnClickListener {
            public ViewOnClickListenerC0681e() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16078, this, view);
            }
        }

        public static final class e0 implements View.OnClickListener {

            /* renamed from: b */
            public final /* synthetic */ View f31222b;

            public e0(View view) {
                this.f31222b = view;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16115, this, view);
            }
        }

        /* renamed from: com.wbl.ad.yzz.adapter.d.e$f$f */
        public static final class ViewOnClickListenerC0682f implements View.OnClickListener {
            public ViewOnClickListenerC0682f() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16080, this, view);
            }
        }

        public static final class f0 implements View.OnClickListener {

            /* renamed from: b */
            public final /* synthetic */ View f31225b;

            public f0(View view) {
                this.f31225b = view;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16077, this, view);
            }
        }

        public static final class g implements View.OnClickListener {
            public g() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16074, this, view);
            }
        }

        public static final class g0 implements View.OnClickListener {
            public g0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16079, this, view);
            }
        }

        public static final class h implements View.OnClickListener {
            public h() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16070, this, view);
            }
        }

        public static final class h0 implements com.wbl.ad.yzz.wigdet.k.c {
            public h0() {
            }

            @Override // com.wbl.ad.yzz.wigdet.k.c
            public void a() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16073, this, null);
            }

            @Override // com.wbl.ad.yzz.wigdet.k.c
            public void b() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16076, this, null);
            }

            @Override // com.wbl.ad.yzz.wigdet.k.c
            public void c() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16075, this, null);
            }
        }

        public static final class i implements com.wbl.ad.yzz.help.n.f {
            public i() {
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(float f2, com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16069, this, Float.valueOf(f2), bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16072, this, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(String str, com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16071, this, str, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(boolean z, boolean z2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16066, this, Boolean.valueOf(z), Boolean.valueOf(z2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void b(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16065, this, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void c(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16068, this, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void d(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16067, this, bVar, Integer.valueOf(i2));
            }
        }

        public static final class j implements com.wbl.ad.yzz.help.n.f {
            public j() {
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(float f2, com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16094, this, Float.valueOf(f2), bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16093, this, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(String str, com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16096, this, str, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(boolean z, boolean z2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16095, this, Boolean.valueOf(z), Boolean.valueOf(z2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void b(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16090, this, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void c(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16089, this, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void d(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16092, this, bVar, Integer.valueOf(i2));
            }
        }

        public static final class k implements View.OnClickListener {
            public k() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16091, this, view);
            }
        }

        public static final class l implements View.OnClickListener {
            public l() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16086, this, view);
            }
        }

        public static final class m implements View.OnClickListener {
            public m() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16085, this, view);
            }
        }

        public static final class n implements View.OnClickListener {

            /* renamed from: b */
            public final /* synthetic */ com.wbl.ad.yzz.bean.e f31236b;

            public n(com.wbl.ad.yzz.bean.e eVar) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16088, this, view);
            }
        }

        public static final class o implements View.OnClickListener {
            public o() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16087, this, view);
            }
        }

        public static final class p implements View.OnClickListener {
            public p() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16082, this, view);
            }
        }

        public static final class q implements View.OnClickListener {
            public q() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16081, this, view);
            }
        }

        public static final class r implements View.OnClickListener {

            /* renamed from: b */
            public final /* synthetic */ com.wbl.ad.yzz.bean.e f31241b;

            public r(com.wbl.ad.yzz.bean.e eVar) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16084, this, view);
            }
        }

        public static final class s implements View.OnClickListener {
            public s() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16083, this, view);
            }
        }

        public static final class t implements View.OnClickListener {
            public t() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16174, this, view);
            }
        }

        public static final class u implements View.OnClickListener {
            public u() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16173, this, view);
            }
        }

        public static final class v implements View.OnClickListener {
            public v() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16176, this, view);
            }
        }

        public static final class w implements View.OnClickListener {
            public w() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16175, this, view);
            }
        }

        public static final class x implements View.OnClickListener {

            /* renamed from: b */
            public final /* synthetic */ com.wbl.ad.yzz.bean.e f31248b;

            public x(com.wbl.ad.yzz.bean.e eVar) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16170, this, view);
            }
        }

        public static final class y implements View.OnClickListener {
            public y() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16169, this, view);
            }
        }

        public static final class z implements View.OnClickListener {
            public z() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16172, this, view);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(e eVar, @f.b.a.d int i2, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.P = eVar;
            this.f31200a = i2;
            this.f31202c = view.findViewById(R.id.nativeAdContainer);
            this.f31203d = view.findViewById(R.id.tv_source_desc_layout);
            this.O = (FrameLayout) view.findViewById(R.id.videoFrameLayout);
            this.f31204e = view.findViewById(R.id.container);
            if (i2 == 1112 || i2 == 4) {
                this.f31205f = null;
                this.f31206g = null;
            } else {
                this.f31205f = (NativeAdContainer) view.findViewById(R.id.native_ad_container_t);
                this.f31206g = view.findViewById(R.id.container_t);
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
                this.f31208i = (FrameLayout) view.findViewById(R.id.csj_video);
                this.k = (MediaView) view.findViewById(R.id.tecent_video_view_t);
                this.f31207h = (ImageView) view.findViewById(R.id.iv_big_pic);
                this.f31209j = (ImageView) view.findViewById(R.id.iv_big_pic_t);
                this.p = view.findViewById(R.id.ll_content_container);
                this.l = (WblTextureMediaPlayer) view.findViewById(R.id.wbl_video_player);
                this.m = (ImageView) view.findViewById(R.id.img_play);
                this.n = (TextView) view.findViewById(R.id.tv_read_book);
                this.q = view.findViewById(R.id.view_watch_tips_container);
                this.r = (TextView) view.findViewById(R.id.tv_watch_tips);
                this.s = (ImageView) view.findViewById(R.id.iv_watch_icon);
                this.o = null;
            } else if (i2 == 1112) {
                this.f31208i = null;
                this.k = null;
                this.f31207h = null;
                this.f31209j = null;
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
                this.f31208i = null;
                this.k = null;
                this.o = null;
                this.f31207h = null;
                this.f31209j = null;
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
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16171, this, null);
        }

        public final com.wbl.ad.yzz.help.n.f a(com.wbl.ad.yzz.bean.b bVar, int i2) {
            return (com.wbl.ad.yzz.help.n.f) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16166, this, bVar, Integer.valueOf(i2));
        }

        @Override // com.wbl.ad.yzz.wigdet.k.b
        public WblTextureMediaPlayer a() {
            return (WblTextureMediaPlayer) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16165, this, null);
        }

        public final String a(NativeResponse nativeResponse) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16168, this, nativeResponse);
        }

        public final String a(NativeUnifiedADData nativeUnifiedADData) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16167, this, nativeUnifiedADData);
        }

        public final String a(com.wbl.ad.yzz.bean.j jVar) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16162, this, jVar);
        }

        public final void a(int i2, View.OnClickListener onClickListener) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16161, this, Integer.valueOf(i2), onClickListener);
        }

        @Override // com.wbl.ad.yzz.manager.l.a
        public void a(TextView textView) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16164, this, textView);
        }

        public final void a(com.wbl.ad.yzz.adapter.d.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16163, this, bVar);
        }

        public final void a(com.wbl.ad.yzz.adapter.d.b bVar, int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16190, this, bVar, Integer.valueOf(i2));
        }

        public final void a(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16189, this, bVar);
        }

        public final void a(com.wbl.ad.yzz.bean.e eVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16192, this, eVar);
        }

        public final void a(com.wbl.ad.yzz.bean.r rVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16191, this, rVar);
        }

        public final void a(com.wbl.ad.yzz.help.e eVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16186, this, eVar);
        }

        public final void a(String str, ImageView imageView) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16185, this, str, imageView);
        }

        public final void a(String str, String str2, String str3, boolean z2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16188, this, str, str2, str3, Boolean.valueOf(z2));
        }

        public final void a(String str, boolean z2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16187, this, str, Boolean.valueOf(z2));
        }

        public final void a(boolean z2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16182, this, Boolean.valueOf(z2));
        }

        public final com.wbl.ad.yzz.help.n.f b(com.wbl.ad.yzz.bean.b bVar, int i2) {
            return (com.wbl.ad.yzz.help.n.f) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16181, this, bVar, Integer.valueOf(i2));
        }

        public final String b(NativeResponse nativeResponse) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16184, this, nativeResponse);
        }

        public final String b(NativeUnifiedADData nativeUnifiedADData) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16183, this, nativeUnifiedADData);
        }

        public final String b(com.wbl.ad.yzz.bean.j jVar) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16178, this, jVar);
        }

        public final void b(com.wbl.ad.yzz.adapter.d.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16177, this, bVar);
        }

        public final void b(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16180, this, bVar);
        }

        public final void b(com.wbl.ad.yzz.bean.e eVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16179, this, eVar);
        }

        public final void b(com.wbl.ad.yzz.bean.r rVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16142, this, rVar);
        }

        public final void b(String str, boolean z2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16141, this, str, Boolean.valueOf(z2));
        }

        @Override // com.wbl.ad.yzz.manager.l.a
        public TextView c() {
            return (TextView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16144, this, null);
        }

        public final String c(NativeResponse nativeResponse) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16143, this, nativeResponse);
        }

        public final String c(NativeUnifiedADData nativeUnifiedADData) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16138, this, nativeUnifiedADData);
        }

        public final String c(com.wbl.ad.yzz.bean.j jVar) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16137, this, jVar);
        }

        public final void c(com.wbl.ad.yzz.adapter.d.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16140, this, bVar);
        }

        public final void c(com.wbl.ad.yzz.bean.e eVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16139, this, eVar);
        }

        public final void c(com.wbl.ad.yzz.bean.r rVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16134, this, rVar);
        }

        public final String d(NativeResponse nativeResponse) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16133, this, nativeResponse);
        }

        public final void d() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16136, this, null);
        }

        public final void d(com.wbl.ad.yzz.adapter.d.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16135, this, bVar);
        }

        public final void d(com.wbl.ad.yzz.bean.r rVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16130, this, rVar);
        }

        public final void e() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16129, this, null);
        }

        public final void e(com.wbl.ad.yzz.adapter.d.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16132, this, bVar);
        }

        public final void e(com.wbl.ad.yzz.bean.r rVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16131, this, rVar);
        }

        public final void f() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16158, this, null);
        }

        public final void f(com.wbl.ad.yzz.bean.r rVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16157, this, rVar);
        }

        public final void g() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16160, this, null);
        }

        public final void g(com.wbl.ad.yzz.bean.r rVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16159, this, rVar);
        }

        public final NativeResponse h() {
            return (NativeResponse) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16154, this, null);
        }

        public final com.wbl.ad.yzz.bean.e i() {
            return (com.wbl.ad.yzz.bean.e) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16153, this, null);
        }

        public final com.wbl.ad.yzz.bean.b j() {
            return (com.wbl.ad.yzz.bean.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16156, this, null);
        }

        public final com.wbl.ad.yzz.bean.j k() {
            return (com.wbl.ad.yzz.bean.j) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16155, this, null);
        }

        public final int l() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-16150, this, null);
        }

        public final XNativeView m() {
            return (XNativeView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16149, this, null);
        }

        public final View n() {
            return (View) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16152, this, null);
        }

        public final View o() {
            return (View) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16151, this, null);
        }

        public final com.wbl.ad.yzz.help.e p() {
            return (com.wbl.ad.yzz.help.e) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16146, this, null);
        }

        public final ImageView q() {
            return (ImageView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16145, this, null);
        }

        public final ImageView r() {
            return (ImageView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16148, this, null);
        }

        public final TextView s() {
            return (TextView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16147, this, null);
        }

        public final ImageView t() {
            return (ImageView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16238, this, null);
        }

        public final WblTextureMediaPlayer u() {
            return (WblTextureMediaPlayer) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16237, this, null);
        }

        public final TTNativeExpressAd v() {
            return (TTNativeExpressAd) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16240, this, null);
        }

        public final String w() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16239, this, null);
        }

        public final NativeUnifiedADData x() {
            return (NativeUnifiedADData) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16234, this, null);
        }

        public final com.wbl.ad.yzz.bean.r y() {
            return (com.wbl.ad.yzz.bean.r) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16233, this, null);
        }

        public final com.wbl.ad.yzz.bean.r z() {
            return (com.wbl.ad.yzz.bean.r) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16236, this, null);
        }
    }

    public static final class g implements NativeResponse.AdInteractionListener {

        /* renamed from: a */
        public boolean f31251a;

        /* renamed from: c */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f31253c;

        /* renamed from: d */
        public final /* synthetic */ String f31254d;

        /* renamed from: e */
        public final /* synthetic */ Ref.ObjectRef f31255e;

        /* renamed from: f */
        public final /* synthetic */ String f31256f;

        /* renamed from: g */
        public final /* synthetic */ NativeResponse f31257g;

        /* renamed from: h */
        public final /* synthetic */ String f31258h;

        public g(com.wbl.ad.yzz.bean.b bVar, String str, Ref.ObjectRef objectRef, String str2, NativeResponse nativeResponse, String str3) {
            this.f31253c = bVar;
            this.f31254d = str;
            this.f31255e = objectRef;
            this.f31256f = str2;
            this.f31257g = nativeResponse;
            this.f31258h = str3;
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onADExposed() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16235, this, null);
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onADExposureFailed(int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16230, this, Integer.valueOf(i2));
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onADStatusChanged() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16229, this, null);
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onAdClick() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16232, this, null);
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onAdUnionClick() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16231, this, null);
        }
    }

    public static final class h implements View.OnClickListener {

        /* renamed from: b */
        public final /* synthetic */ Ref.ObjectRef f31260b;

        /* renamed from: c */
        public final /* synthetic */ com.wbl.ad.yzz.help.e f31261c;

        /* renamed from: d */
        public final /* synthetic */ int f31262d;

        /* renamed from: e */
        public final /* synthetic */ NativeResponse f31263e;

        /* renamed from: f */
        public final /* synthetic */ View f31264f;

        public static final class a implements e.c {
            public a() {
            }

            @Override // com.wbl.ad.yzz.help.e.c
            public void a() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16226, this, null);
            }

            @Override // com.wbl.ad.yzz.help.e.c
            public void b() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16225, this, null);
            }

            @Override // com.wbl.ad.yzz.help.e.c
            public void c() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16228, this, null);
            }
        }

        public h(Ref.ObjectRef objectRef, com.wbl.ad.yzz.help.e eVar, int i2, NativeResponse nativeResponse, View view) {
            this.f31260b = objectRef;
            this.f31261c = eVar;
            this.f31262d = i2;
            this.f31263e = nativeResponse;
            this.f31264f = view;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16227, this, view);
        }
    }

    public static final class i implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ TextView f31266a;

        /* renamed from: b */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f31267b;

        /* renamed from: c */
        public final /* synthetic */ View f31268c;

        public i(TextView textView, com.wbl.ad.yzz.bean.b bVar, View view) {
            this.f31266a = textView;
            this.f31267b = bVar;
            this.f31268c = view;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16254, this, view);
        }
    }

    public static final class j implements TTNativeAd.AdInteractionListener {

        /* renamed from: b */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f31270b;

        /* renamed from: c */
        public final /* synthetic */ String f31271c;

        /* renamed from: d */
        public final /* synthetic */ e.b f31272d;

        /* renamed from: e */
        public final /* synthetic */ int f31273e;

        /* renamed from: f */
        public final /* synthetic */ String f31274f;

        /* renamed from: g */
        public final /* synthetic */ String f31275g;

        public j(com.wbl.ad.yzz.bean.b bVar, String str, e.b bVar2, int i2, String str2, String str3) {
            this.f31270b = bVar;
            this.f31271c = str;
            this.f31272d = bVar2;
            this.f31273e = i2;
            this.f31274f = str2;
            this.f31275g = str3;
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdClicked(View view, TTNativeAd tTNativeAd) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16253, this, view, tTNativeAd);
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16256, this, view, tTNativeAd);
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdShow(TTNativeAd tTNativeAd) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16255, this, tTNativeAd);
        }
    }

    public static final class k implements TTNativeExpressAd.ExpressAdInteractionListener {

        /* renamed from: b */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f31277b;

        /* renamed from: c */
        public final /* synthetic */ String f31278c;

        /* renamed from: d */
        public final /* synthetic */ String f31279d;

        /* renamed from: e */
        public final /* synthetic */ String f31280e;

        public k(com.wbl.ad.yzz.bean.b bVar, String str, String str2, String str3) {
            this.f31277b = bVar;
            this.f31278c = str;
            this.f31279d = str2;
            this.f31280e = str3;
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onAdClicked(View view, int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16250, this, view, Integer.valueOf(i2));
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onAdShow(View view, int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16249, this, view, Integer.valueOf(i2));
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onRenderFail(View view, String str, int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16252, this, view, str, Integer.valueOf(i2));
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onRenderSuccess(View view, float f2, float f3) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16251, this, view, Float.valueOf(f2), Float.valueOf(f3));
        }
    }

    public static final class l implements c.a {

        /* renamed from: b */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f31282b;

        /* renamed from: c */
        public final /* synthetic */ f f31283c;

        public l(com.wbl.ad.yzz.bean.b bVar, f fVar) {
            this.f31282b = bVar;
            this.f31283c = fVar;
        }

        @Override // com.wbl.ad.yzz.dialog.c.a
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16246, this, null);
        }
    }

    public static final class m extends com.wbl.ad.yzz.bean.i {

        /* renamed from: f */
        public final /* synthetic */ f f31285f;

        /* renamed from: g */
        public final /* synthetic */ com.wbl.ad.yzz.bean.k f31286g;

        /* renamed from: h */
        public final /* synthetic */ String f31287h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(f fVar, com.wbl.ad.yzz.bean.k kVar, String str, com.wbl.ad.yzz.bean.b bVar, boolean z, e.b bVar2, int i2, String str2, String str3, com.wbl.ad.yzz.bean.b bVar3, TextView textView, TTAppDownloadListener tTAppDownloadListener) {
            super(bVar3, textView, tTAppDownloadListener);
            this.f31285f = fVar;
            this.f31286g = kVar;
            this.f31287h = str;
        }

        @Override // com.wbl.ad.yzz.bean.h
        public void a(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16200, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.bean.h
        public boolean d() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-16199, this, null);
        }
    }

    public static final class n implements TTAppDownloadListener {

        /* renamed from: b */
        public final /* synthetic */ String f31289b;

        /* renamed from: c */
        public final /* synthetic */ com.wbl.ad.yzz.bean.k f31290c;

        /* renamed from: d */
        public final /* synthetic */ boolean f31291d;

        /* renamed from: e */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f31292e;

        /* renamed from: f */
        public final /* synthetic */ e.b f31293f;

        /* renamed from: g */
        public final /* synthetic */ int f31294g;

        /* renamed from: h */
        public final /* synthetic */ String f31295h;

        /* renamed from: i */
        public final /* synthetic */ String f31296i;

        public n(String str, com.wbl.ad.yzz.bean.k kVar, boolean z, com.wbl.ad.yzz.bean.b bVar, e.b bVar2, int i2, String str2, String str3) {
            this.f31289b = str;
            this.f31290c = kVar;
            this.f31291d = z;
            this.f31292e = bVar;
            this.f31293f = bVar2;
            this.f31294g = i2;
            this.f31295h = str2;
            this.f31296i = str3;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadActive(long j2, long j3, String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16194, this, Long.valueOf(j2), Long.valueOf(j3), str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFailed(long j2, long j3, String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16193, this, Long.valueOf(j2), Long.valueOf(j3), str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFinished(long j2, String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16196, this, Long.valueOf(j2), str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadPaused(long j2, long j3, String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16195, this, Long.valueOf(j2), Long.valueOf(j3), str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onIdle() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16222, this, null);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onInstalled(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16221, this, str, str2);
        }
    }

    public static final class o implements e.c {

        /* renamed from: b */
        public final /* synthetic */ com.wbl.ad.yzz.help.e f31298b;

        /* renamed from: c */
        public final /* synthetic */ int f31299c;

        /* renamed from: d */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f31300d;

        /* renamed from: e */
        public final /* synthetic */ String f31301e;

        /* renamed from: f */
        public final /* synthetic */ String f31302f;

        /* renamed from: g */
        public final /* synthetic */ String f31303g;

        public o(com.wbl.ad.yzz.help.e eVar, int i2, com.wbl.ad.yzz.bean.b bVar, String str, String str2, String str3) {
            this.f31298b = eVar;
            this.f31299c = i2;
            this.f31300d = bVar;
            this.f31301e = str;
            this.f31302f = str2;
            this.f31303g = str3;
        }

        @Override // com.wbl.ad.yzz.help.e.c
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16224, this, null);
        }

        @Override // com.wbl.ad.yzz.help.e.c
        public void b() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16223, this, null);
        }

        @Override // com.wbl.ad.yzz.help.e.c
        public void c() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16218, this, null);
        }
    }

    public static final class p implements View.OnClickListener {

        /* renamed from: b */
        public final /* synthetic */ TextView f31305b;

        /* renamed from: c */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f31306c;

        /* renamed from: d */
        public final /* synthetic */ View f31307d;

        public p(TextView textView, com.wbl.ad.yzz.bean.b bVar, View view) {
            this.f31305b = textView;
            this.f31306c = bVar;
            this.f31307d = view;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16217, this, view);
        }
    }

    public static final class q implements NativeADEventListener {

        /* renamed from: a */
        public boolean f31308a;

        /* renamed from: c */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f31310c;

        /* renamed from: d */
        public final /* synthetic */ String f31311d;

        /* renamed from: e */
        public final /* synthetic */ String f31312e;

        /* renamed from: f */
        public final /* synthetic */ String f31313f;

        /* renamed from: g */
        public final /* synthetic */ boolean f31314g;

        /* renamed from: h */
        public final /* synthetic */ int f31315h;

        /* renamed from: i */
        public final /* synthetic */ String f31316i;

        /* renamed from: j */
        public final /* synthetic */ NativeUnifiedADData f31317j;
        public final /* synthetic */ f k;

        public q(com.wbl.ad.yzz.bean.b bVar, String str, String str2, String str3, boolean z, int i2, String str4, NativeUnifiedADData nativeUnifiedADData, f fVar) {
            this.f31310c = bVar;
            this.f31311d = str;
            this.f31312e = str2;
            this.f31313f = str3;
            this.f31314g = z;
            this.f31315h = i2;
            this.f31316i = str4;
            this.f31317j = nativeUnifiedADData;
            this.k = fVar;
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADClicked() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16220, this, null);
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADError(AdError adError) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16219, this, adError);
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADExposed() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16214, this, null);
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADStatusChanged() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16213, this, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@f.b.a.e List<b> list, @f.b.a.d Activity mContext) {
        super(list);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
        this.mTTAppDownloadListenerMap = new WeakHashMap();
        com.wbl.ad.yzz.manager.f fVar = new com.wbl.ad.yzz.manager.f();
        this.mDownLoadApkManager = fVar;
        this.mStartUpHelper = new com.wbl.ad.yzz.help.l();
        fVar.a(mContext);
        this.mStartUpHelperItemListener = new a();
    }

    public static final /* synthetic */ Drawable b(e eVar) {
        return (Drawable) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16293, null, eVar);
    }

    public static final /* synthetic */ Context c(e eVar) {
        return (Context) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16295, null, eVar);
    }

    public static final /* synthetic */ Activity d(e eVar) {
        return (Activity) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16290, null, eVar);
    }

    public static final /* synthetic */ com.wbl.ad.yzz.manager.f e(e eVar) {
        return (com.wbl.ad.yzz.manager.f) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16289, null, eVar);
    }

    public static final /* synthetic */ String f(e eVar) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16292, null, eVar);
    }

    public static final /* synthetic */ String g(e eVar) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16291, null, eVar);
    }

    public static final /* synthetic */ a.InterfaceC0679a h(e eVar) {
        return (a.InterfaceC0679a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16318, null, eVar);
    }

    public static final /* synthetic */ String u() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16317, null, null);
    }

    public static final /* synthetic */ String v() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16320, null, null);
    }

    public final int A() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-16319, this, null);
    }

    public final int B() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-16314, this, null);
    }

    public com.wbl.ad.yzz.innerconfig.d.d C() {
        return (com.wbl.ad.yzz.innerconfig.d.d) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16313, this, null);
    }

    public final void D() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16316, this, null);
    }

    @Override // com.wbl.ad.yzz.adapter.base.BaseQuickAdapter
    public void a(BaseViewHolder holder) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16315, this, holder);
    }

    public void a(BaseViewHolder holder, b item) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16310, this, holder, item);
    }

    @Override // com.wbl.ad.yzz.adapter.base.BaseQuickAdapter
    public /* bridge */ /* synthetic */ void a(BaseViewHolder baseViewHolder, Object obj) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16309, this, baseViewHolder, obj);
    }

    @Override // com.wbl.ad.yzz.adapter.d.a
    public void a(com.wbl.ad.yzz.adapter.c.b itemListener) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16312, this, itemListener);
    }

    @Override // com.wbl.ad.yzz.adapter.d.a
    public void a(a.InterfaceC0679a onQuickAdapterListener) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16311, this, onQuickAdapterListener);
    }

    public final void a(f holder, View mContainer, View clickableView, TextView mIvDownApp, ImageView ivClose, String adType) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16306, this, holder, mContainer, clickableView, mIvDownApp, ivClose, adType);
    }

    public final void a(f holder, View mContainer, TextView mIvDownApp, ImageView ivClose, String adType) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16305, this, holder, mContainer, mIvDownApp, ivClose, adType);
    }

    public final void a(f holder, NativeAdContainer mItemTypeOneContainer, MediaView mTencentVideoViewT, View containerT, TextView tvDownApp, ImageView ivClose, String adType) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16308, this, holder, mItemTypeOneContainer, mTencentVideoViewT, containerT, tvDownApp, ivClose, adType);
    }

    public final void a(f holder, String csj_muban_adType) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16307, this, holder, csj_muban_adType);
    }

    public final void a(com.wbl.ad.yzz.bean.b bean, int position, String r5, String adType, String clickType) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16270, this, bean, Integer.valueOf(position), r5, adType, clickType);
    }

    public final void a(com.wbl.ad.yzz.bean.b bean, int position, String r5, String adType, String clickType, WblTextureMediaPlayer player) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16269, this, bean, Integer.valueOf(position), r5, adType, clickType, player);
    }

    public final void a(com.wbl.ad.yzz.bean.b bean, r yzzAdBean, String channel, int position, String r7, String adType, String clickType, boolean isRepeat) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16272, this, bean, yzzAdBean, channel, Integer.valueOf(position), r7, adType, clickType, Boolean.valueOf(isRepeat));
    }

    public final void a(com.wbl.ad.yzz.bean.b bean, String url) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16271, this, bean, url);
    }

    public final void a(com.wbl.ad.yzz.bean.b bean, String channel, String position, String r6, String adType) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16266, this, bean, channel, position, r6, adType);
    }

    public final void a(com.wbl.ad.yzz.bean.b bean, String channel, String position, String r6, String adType, String clickType) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16265, this, bean, channel, position, r6, adType, clickType);
    }

    public final void a(com.wbl.ad.yzz.bean.j ad2, TTNativeExpressAd ttNativeExpressAd, com.wbl.ad.yzz.help.e downLoadApkHelper, f holder, String uniq_id, String r8, String adType) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16268, this, ad2, ttNativeExpressAd, downLoadApkHelper, holder, uniq_id, r8, adType);
    }

    public final void a(e.b pair, com.wbl.ad.yzz.bean.b bean, int position, String r6, String adType, String clickType) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16267, this, pair, bean, Integer.valueOf(position), r6, adType, clickType);
    }

    @Override // com.wbl.ad.yzz.adapter.d.a
    public void a(com.wbl.ad.yzz.innerconfig.d.j sceneDataInfoWrap) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16262, this, sceneDataInfoWrap);
    }

    @Override // com.wbl.ad.yzz.adapter.d.a
    public void a(u.b conf) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16261, this, conf);
    }

    @Override // com.wbl.ad.yzz.adapter.d.a
    public void a(String color) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16264, this, color);
    }

    public final void a(String uniq_id, String channel) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16263, this, uniq_id, channel);
    }

    public final void a(String uniq_id, String channel, com.wbl.ad.yzz.bean.b bean) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16258, this, uniq_id, channel, bean);
    }

    public final void a(boolean isShowMore, boolean isDownloadTips) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16257, this, Boolean.valueOf(isShowMore), Boolean.valueOf(isDownloadTips));
    }

    public final void a(boolean isCustom, boolean isDownload, com.wbl.ad.yzz.bean.b bean, e.b pair, int position, String uniq_id, String r9, String adType) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16260, this, Boolean.valueOf(isCustom), Boolean.valueOf(isDownload), bean, pair, Integer.valueOf(position), uniq_id, r9, adType);
    }

    @Override // com.wbl.ad.yzz.adapter.base.BaseMultiItemQuickAdapter, com.wbl.ad.yzz.adapter.base.BaseQuickAdapter
    public BaseViewHolder b(ViewGroup parent, int viewType) {
        return (BaseViewHolder) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16259, this, parent, Integer.valueOf(viewType));
    }

    public final void b(String uniq_id, String channel, com.wbl.ad.yzz.bean.b bean) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16286, this, uniq_id, channel, bean);
    }

    @Override // com.wbl.ad.yzz.adapter.d.a
    public void r() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16285, this, null);
    }

    @Override // com.wbl.ad.yzz.adapter.d.a
    public void t() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16288, this, null);
    }

    public final void w() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16287, this, null);
    }

    public final Drawable x() {
        return (Drawable) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16282, this, null);
    }

    public final int y() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-16281, this, null);
    }

    public final Map<RecyclerView.ViewHolder, TTAppDownloadListener> z() {
        return (Map) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16284, this, null);
    }
}
