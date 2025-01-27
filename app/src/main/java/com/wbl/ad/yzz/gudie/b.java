package com.wbl.ad.yzz.gudie;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.XNativeView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.cdo.oaps.ad.OapsKey;
import com.martian.mibook.application.MiConfigSingleton;
import com.opos.mobad.activity.VideoActivity;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.util.AdError;
import com.vivo.advv.Color;
import com.wbl.ad.yzz.R;
import com.wbl.ad.yzz.adapter.base.BaseQuickAdapter;
import com.wbl.ad.yzz.adapter.base.viewholder.BaseViewHolder;
import com.wbl.ad.yzz.help.e;
import com.wbl.ad.yzz.network.b.b.u;
import com.wbl.ad.yzz.wigdet.wblplayer.WblTextureMediaPlayer;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0012\r\u0013\u0094\u0001\u0095\u0001:<\u0096\u0001\u0097\u0001\u0098\u0001\u0099\u0001\u009a\u0001B#\u0012\b\u0010\u0091\u0001\u001a\u00030\u0082\u0001\u0012\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010a¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J7\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000eJ?\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u0010J+\u0010\r\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\r\u0010\u0012J-\u0010\u0013\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0012J#\u0010\r\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\r\u0010\u0014J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\r\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJU\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010 H\u0002¢\u0006\u0004\b\r\u0010\"JK\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010$JA\u0010\r\u001a\u00020\f2\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010'JU\u0010\r\u001a\u00020\f2\u0006\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u00152\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010*J]\u0010\r\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010,\u001a\u0004\u0018\u00010+2\b\u0010.\u001a\u0004\u0018\u00010-2\b\u00100\u001a\u0004\u0018\u00010/2\n\u00102\u001a\u000601R\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u00103JK\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00042\b\u00105\u001a\u0004\u0018\u0001042\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u00106J\u001f\u0010\u0013\u001a\u0002072\u0006\u0010,\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0013\u00108J\u001f\u0010\r\u001a\u0002072\u0006\u0010,\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u00108J\u0017\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0013\u00109J\u000f\u0010:\u001a\u00020\bH\u0014¢\u0006\u0004\b:\u0010;J\u0017\u0010<\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b<\u0010=J\u0017\u0010\r\u001a\u00020\f2\b\u0010?\u001a\u0004\u0018\u00010>¢\u0006\u0004\b\r\u0010@J\u0017\u0010\r\u001a\u00020\f2\b\u0010B\u001a\u0004\u0018\u00010A¢\u0006\u0004\b\r\u0010CJ\u0011\u0010E\u001a\u0004\u0018\u00010DH\u0004¢\u0006\u0004\bE\u0010FJ\r\u0010G\u001a\u00020\f¢\u0006\u0004\bG\u0010\u001aJ\u001f\u0010\u0013\u001a\u00020\u00032\u0006\u0010I\u001a\u00020H2\u0006\u0010J\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0013\u0010KJ\u0017\u0010\r\u001a\u00020\f2\u0006\u00102\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010LJ\u001f\u0010\r\u001a\u00020\f2\u0006\u00102\u001a\u00020\u00032\u0006\u0010M\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\r\u0010NJ\r\u0010O\u001a\u00020\f¢\u0006\u0004\bO\u0010\u001aJ\u0017\u0010\r\u001a\u00020\f2\b\u0010Q\u001a\u0004\u0018\u00010P¢\u0006\u0004\b\r\u0010RJ\u0017\u0010\r\u001a\u00020\f2\b\u0010T\u001a\u0004\u0018\u00010S¢\u0006\u0004\b\r\u0010UJk\u0010\r\u001a\u00020\f2\n\u0010V\u001a\u000601R\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010X\u001a\u0004\u0018\u00010W2\b\u0010Z\u001a\u0004\u0018\u00010Y2\b\u0010[\u001a\u0004\u0018\u00010\u001e2\b\u0010]\u001a\u0004\u0018\u00010\\2\b\u0010^\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010_Ja\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\n\u0010`\u001a\u000601R\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010+2\f\u0010b\u001a\b\u0012\u0004\u0012\u00020\u001e0a2\u000e\u0010c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0a2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010d\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010eJY\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010g\u001a\u0004\u0018\u00010f2\n\u0010h\u001a\u000601R\u00020\u00002\b\u0010i\u001a\u0004\u0018\u00010\u001e2\b\u0010j\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010kR\u0016\u0010o\u001a\u00020l8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010nR\u0018\u0010r\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010v\u001a\u00020s8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bt\u0010uR\u0018\u0010y\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010xR\u0018\u0010|\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010{R\u0018\u0010~\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010{R\u001a\u0010\u0081\u0001\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u001a\u0010\u0085\u0001\u001a\u00030\u0082\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R-\u0010\u008d\u0001\u001a\u0011\u0012\u0005\u0012\u00030\u0087\u0001\u0012\u0005\u0012\u00030\u0088\u00010\u0086\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\b\u0089\u0001\u0010\u008a\u0001\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001R\u001b\u0010\u0090\u0001\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001¨\u0006\u009b\u0001"}, d2 = {"Lcom/wbl/ad/yzz/gudie/b;", "Lcom/wbl/ad/yzz/adapter/base/BaseQuickAdapter;", "Lcom/wbl/ad/yzz/adapter/d/b;", "Lcom/wbl/ad/yzz/adapter/base/viewholder/BaseViewHolder;", "Lcom/wbl/ad/yzz/bean/b;", "bean", "", "channel", "", "position", VideoActivity.EXTRA_KEY_ACTION_TYPE, "adType", "", "a", "(Lcom/wbl/ad/yzz/bean/b;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "clickType", "(Lcom/wbl/ad/yzz/bean/b;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "uniq_id", "(Ljava/lang/String;Ljava/lang/String;Lcom/wbl/ad/yzz/bean/b;)V", "b", "(Ljava/lang/String;Ljava/lang/String;)V", "", "isShowMore", "isDownloadTips", "(ZZ)V", "q", "()V", MiConfigSingleton.t0, "Lcom/wbl/ad/yzz/bean/r;", "yzzAdBean", "Landroid/view/View;", "clickView", "Lcom/wbl/ad/yzz/wigdet/wblplayer/WblTextureMediaPlayer;", "player", "(ILcom/wbl/ad/yzz/bean/b;Lcom/wbl/ad/yzz/bean/r;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/wbl/ad/yzz/wigdet/wblplayer/WblTextureMediaPlayer;)V", "vipAdBean", "(ILcom/wbl/ad/yzz/bean/b;Lcom/wbl/ad/yzz/bean/r;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/wbl/ad/yzz/help/e$b;", "pair", "(Lcom/wbl/ad/yzz/help/e$b;Lcom/wbl/ad/yzz/bean/b;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "isCustom", "isDownload", "(ZZLcom/wbl/ad/yzz/bean/b;Lcom/wbl/ad/yzz/help/e$b;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/wbl/ad/yzz/bean/j;", "ad", "Lcom/bytedance/sdk/openadsdk/TTNativeExpressAd;", "ttNativeExpressAd", "Lcom/wbl/ad/yzz/help/e;", "downLoadApkHelper", "Lcom/wbl/ad/yzz/gudie/b$c;", "holder", "(Lcom/wbl/ad/yzz/bean/b;Lcom/wbl/ad/yzz/bean/j;Lcom/bytedance/sdk/openadsdk/TTNativeExpressAd;Lcom/wbl/ad/yzz/help/e;Lcom/wbl/ad/yzz/gudie/b$c;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/wbl/ad/yzz/bean/e;", "bindBaiDuApi", "(ILcom/wbl/ad/yzz/bean/b;Lcom/wbl/ad/yzz/bean/e;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/wbl/ad/yzz/help/n/f;", "(Lcom/wbl/ad/yzz/bean/b;I)Lcom/wbl/ad/yzz/help/n/f;", "(I)I", com.kwad.sdk.ranger.e.TAG, "()I", "f", "(I)Lcom/wbl/ad/yzz/bean/b;", "Lcom/wbl/ad/yzz/network/b/b/u$b;", "conf", "(Lcom/wbl/ad/yzz/network/b/b/u$b;)V", "Lcom/wbl/ad/yzz/innerconfig/d/j;", "sceneDataInfoWrap", "(Lcom/wbl/ad/yzz/innerconfig/d/j;)V", "Lcom/wbl/ad/yzz/innerconfig/d/d;", "s", "()Lcom/wbl/ad/yzz/innerconfig/d/d;", "t", "Landroid/view/ViewGroup;", "parent", "viewType", "(Landroid/view/ViewGroup;I)Lcom/wbl/ad/yzz/adapter/base/viewholder/BaseViewHolder;", "(Lcom/wbl/ad/yzz/adapter/base/viewholder/BaseViewHolder;)V", "item", "(Lcom/wbl/ad/yzz/adapter/base/viewholder/BaseViewHolder;Lcom/wbl/ad/yzz/adapter/d/b;)V", "u", "Lcom/wbl/ad/yzz/adapter/c/b;", "itemListener", "(Lcom/wbl/ad/yzz/adapter/c/b;)V", "Lcom/wbl/ad/yzz/gudie/b$g;", "listener", "(Lcom/wbl/ad/yzz/gudie/b$g;)V", "hleper", "Lcom/qq/e/ads/nativ/NativeUnifiedADData;", "tencentAd", "Lcom/qq/e/ads/nativ/widget/NativeAdContainer;", "container", "mTencentVideoPosterContainer", "Lcom/qq/e/ads/nativ/MediaView;", "mTencentVideoView", "mDownLoadView", "(Lcom/wbl/ad/yzz/gudie/b$c;ILcom/wbl/ad/yzz/bean/b;Lcom/qq/e/ads/nativ/NativeUnifiedADData;Lcom/qq/e/ads/nativ/widget/NativeAdContainer;Landroid/view/View;Lcom/qq/e/ads/nativ/MediaView;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;)V", "viewHolder", "", "clickViewList", "creativeViewList", "actionTypeParams", "(ILcom/wbl/ad/yzz/gudie/b$c;Lcom/wbl/ad/yzz/bean/b;Lcom/wbl/ad/yzz/bean/j;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/baidu/mobads/sdk/api/NativeResponse;", "baiDuAdBean", "helper", "mContainer", "mDownloadView", "(ILcom/wbl/ad/yzz/bean/b;Lcom/baidu/mobads/sdk/api/NativeResponse;Lcom/wbl/ad/yzz/gudie/b$c;Landroid/view/View;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/wbl/ad/yzz/manager/f;", ExifInterface.LONGITUDE_EAST, "Lcom/wbl/ad/yzz/manager/f;", "mDownLoadApkManager", "J", "Lcom/wbl/ad/yzz/innerconfig/d/d;", "mISceneCache", "Lcom/wbl/ad/yzz/help/l;", "F", "Lcom/wbl/ad/yzz/help/l;", "mStartUpHelper", "I", "Lcom/wbl/ad/yzz/innerconfig/d/j;", "mSceneDataInfoWrap", "G", "Ljava/lang/String;", "mGuideContent", "H", "mGuideIcon", "C", "Lcom/wbl/ad/yzz/gudie/b$g;", "mOnGuideAdapterListener", "Landroid/app/Activity;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/app/Activity;", "mContext", "", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/bytedance/sdk/openadsdk/TTAppDownloadListener;", "D", "Ljava/util/Map;", com.kuaishou.weapon.p0.t.k, "()Ljava/util/Map;", "mTTAppDownloadListenerMap", "B", "Lcom/wbl/ad/yzz/adapter/c/b;", "mItemListener", "context", "<init>", "(Landroid/app/Activity;Ljava/util/List;)V", "c", "d", OapsKey.KEY_GRADE, "h", "i", com.opos.mobad.f.a.j.f20763a, "k", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class b extends BaseQuickAdapter<com.wbl.ad.yzz.adapter.d.b, BaseViewHolder> {
    public static final String K = "GuideAdapter";

    /* renamed from: A */
    public final Activity mContext;

    /* renamed from: B, reason: from kotlin metadata */
    public com.wbl.ad.yzz.adapter.c.b mItemListener;

    /* renamed from: C, reason: from kotlin metadata */
    public g mOnGuideAdapterListener;

    /* renamed from: D, reason: from kotlin metadata */
    @f.b.a.d
    public final Map<RecyclerView.ViewHolder, TTAppDownloadListener> mTTAppDownloadListenerMap;

    /* renamed from: E */
    public final com.wbl.ad.yzz.manager.f mDownLoadApkManager;

    /* renamed from: F, reason: from kotlin metadata */
    public final com.wbl.ad.yzz.help.l mStartUpHelper;

    /* renamed from: G, reason: from kotlin metadata */
    public String mGuideContent;

    /* renamed from: H, reason: from kotlin metadata */
    public String mGuideIcon;

    /* renamed from: I, reason: from kotlin metadata */
    public com.wbl.ad.yzz.innerconfig.d.j mSceneDataInfoWrap;

    /* renamed from: J, reason: from kotlin metadata */
    public com.wbl.ad.yzz.innerconfig.d.d mISceneCache;

    public final class a extends c {
        public final FrameLayout l;
        public final /* synthetic */ b m;

        /* renamed from: com.wbl.ad.yzz.gudie.b$a$a */
        public static final class ViewOnClickListenerC0730a implements View.OnClickListener {
            public ViewOnClickListenerC0730a(com.wbl.ad.yzz.bean.b bVar) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14101, this, view);
            }
        }

        /* renamed from: com.wbl.ad.yzz.gudie.b$a$b */
        public static final class C0731b implements TTNativeExpressAd.ExpressAdInteractionListener {

            /* renamed from: b */
            public final /* synthetic */ com.wbl.ad.yzz.bean.b f32416b;

            /* renamed from: c */
            public final /* synthetic */ Ref.ObjectRef f32417c;

            /* renamed from: d */
            public final /* synthetic */ String f32418d;

            public C0731b(com.wbl.ad.yzz.bean.b bVar, Ref.ObjectRef objectRef, String str) {
                this.f32416b = bVar;
                this.f32417c = objectRef;
                this.f32418d = str;
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdClicked(View view, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14104, this, view, Integer.valueOf(i2));
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdShow(View view, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14103, this, view, Integer.valueOf(i2));
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String str, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14098, this, view, str, Integer.valueOf(i2));
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(View view, float f2, float f3) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14097, this, view, Float.valueOf(f2), Float.valueOf(f3));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@f.b.a.d b bVar, @f.b.a.d Context context, View view) {
            super(bVar, context, view);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(view, "view");
            this.m = bVar;
            this.l = (FrameLayout) view.findViewById(R.id.csj_mo_ban_frame);
            a((ImageView) view.findViewById(R.id.iv_close));
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void a(int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14207, this, Integer.valueOf(i2));
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void a(int i2, com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14202, this, Integer.valueOf(i2), bVar);
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void a(View.OnClickListener onClickListener) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14201, this, onClickListener);
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void a(com.wbl.ad.yzz.adapter.d.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14204, this, bVar);
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void a(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14203, this, bVar);
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void b(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14198, this, bVar);
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void c(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14197, this, bVar);
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void f(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14200, this, bVar);
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void g(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14199, this, bVar);
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void h(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14194, this, bVar);
        }
    }

    /* renamed from: com.wbl.ad.yzz.gudie.b$b */
    public static final class C0732b extends BaseViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0732b(@f.b.a.d View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    public abstract class c extends BaseViewHolder {

        /* renamed from: a */
        @f.b.a.d
        public final Context f32419a;

        /* renamed from: b */
        public int f32420b;

        /* renamed from: c */
        @f.b.a.e
        public com.wbl.ad.yzz.help.e f32421c;

        /* renamed from: d */
        @f.b.a.e
        public com.wbl.ad.yzz.bean.b f32422d;

        /* renamed from: e */
        @f.b.a.e
        public View f32423e;

        /* renamed from: f */
        @f.b.a.e
        public TextView f32424f;

        /* renamed from: g */
        @f.b.a.e
        public ImageView f32425g;

        /* renamed from: h */
        @f.b.a.e
        public TextView f32426h;

        /* renamed from: i */
        @f.b.a.e
        public TextView f32427i;

        /* renamed from: j */
        @f.b.a.e
        public ImageView f32428j;
        public final /* synthetic */ b k;

        public static final class a implements View.OnClickListener {

            /* renamed from: b */
            public final /* synthetic */ com.wbl.ad.yzz.bean.b f32430b;

            public a(com.wbl.ad.yzz.bean.b bVar) {
                this.f32430b = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14193, this, view);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@f.b.a.d b bVar, @f.b.a.d Context context, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(view, "view");
            this.k = bVar;
            this.f32419a = context;
            this.f32420b = 0;
            this.f32427i = (TextView) view.findViewById(R.id.gdt_top_ad_info);
        }

        public abstract void a(int i2);

        public abstract void a(int i2, @f.b.a.d com.wbl.ad.yzz.bean.b bVar);

        public abstract void a(@f.b.a.e View.OnClickListener onClickListener);

        public final void a(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14100, this, view);
        }

        public final void a(ImageView imageView) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14099, this, imageView);
        }

        public void a(com.wbl.ad.yzz.adapter.d.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14190, this, bVar);
        }

        public abstract void a(@f.b.a.d com.wbl.ad.yzz.bean.b bVar);

        public final void a(com.wbl.ad.yzz.help.e eVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14189, this, eVar);
        }

        public final void a(String str, ImageView imageView) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14192, this, str, imageView);
        }

        public final void a(boolean z) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14191, this, Boolean.valueOf(z));
        }

        public final void b(int i2, com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14186, this, Integer.valueOf(i2), bVar);
        }

        public final void b(ImageView imageView) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14185, this, imageView);
        }

        public final void b(TextView textView) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14188, this, textView);
        }

        public abstract void b(@f.b.a.d com.wbl.ad.yzz.bean.b bVar);

        public final void c(TextView textView) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14187, this, textView);
        }

        public abstract void c(@f.b.a.d com.wbl.ad.yzz.bean.b bVar);

        public final com.wbl.ad.yzz.bean.b d() {
            return (com.wbl.ad.yzz.bean.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14182, this, null);
        }

        public void d(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14181, this, bVar);
        }

        public final Context e() {
            return (Context) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14184, this, null);
        }

        public void e(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14183, this, bVar);
        }

        public final com.wbl.ad.yzz.help.e f() {
            return (com.wbl.ad.yzz.help.e) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14178, this, null);
        }

        public abstract void f(@f.b.a.d com.wbl.ad.yzz.bean.b bVar);

        public final ImageView g() {
            return (ImageView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14177, this, null);
        }

        public abstract void g(@f.b.a.d com.wbl.ad.yzz.bean.b bVar);

        public final View h() {
            return (View) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14180, this, null);
        }

        public abstract void h(@f.b.a.d com.wbl.ad.yzz.bean.b bVar);

        public final TextView i() {
            return (TextView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14179, this, null);
        }

        public final int j() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-14206, this, null);
        }

        public final int k() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-14205, this, null);
        }

        public final void l() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14208, this, null);
        }
    }

    public class d extends i {
        public final /* synthetic */ b D;

        public static final class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14196, this, view);
            }
        }

        /* renamed from: com.wbl.ad.yzz.gudie.b$d$b */
        public static final class C0733b implements com.wbl.ad.yzz.help.n.f {

            /* renamed from: b */
            public final /* synthetic */ com.wbl.ad.yzz.bean.b f32433b;

            public C0733b(com.wbl.ad.yzz.bean.b bVar) {
                this.f32433b = bVar;
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(float f2, com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14195, this, Float.valueOf(f2), bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14158, this, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(String str, com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14157, this, str, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(boolean z, boolean z2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14160, this, Boolean.valueOf(z), Boolean.valueOf(z2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void b(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14159, this, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void c(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14154, this, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void d(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14153, this, bVar, Integer.valueOf(i2));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@f.b.a.d b bVar, @f.b.a.d Context context, View view) {
            super(bVar, context, view);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(view, "view");
            this.D = bVar;
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void e(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14162, this, bVar);
        }
    }

    public final class e extends k {
        public final /* synthetic */ b t;

        public static final class a implements com.wbl.ad.yzz.help.n.f {

            /* renamed from: b */
            public final /* synthetic */ com.wbl.ad.yzz.bean.b f32435b;

            public a(com.wbl.ad.yzz.bean.b bVar) {
                this.f32435b = bVar;
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(float f2, com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14161, this, Float.valueOf(f2), bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14164, this, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(String str, com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14163, this, str, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(boolean z, boolean z2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14254, this, Boolean.valueOf(z), Boolean.valueOf(z2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void b(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14253, this, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void c(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14256, this, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void d(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14255, this, bVar, Integer.valueOf(i2));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(@f.b.a.d b bVar, @f.b.a.d Context context, View view) {
            super(bVar, context, view);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(view, "view");
            this.t = bVar;
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void e(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14265, this, bVar);
        }
    }

    public final class f extends d {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(@f.b.a.d b bVar, @f.b.a.d Context context, View view) {
            super(bVar, context, view);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    public interface g {
        void a();

        void a(@f.b.a.e View view, @f.b.a.e com.wbl.ad.yzz.bean.b bVar, int i2);
    }

    public final class h extends c {
        public final TextView l;
        public final TextView m;
        public final View n;

        @f.b.a.e
        public final XNativeView o;
        public final View p;
        public final /* synthetic */ b q;

        public static final class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14268, this, view);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(@f.b.a.d b bVar, @f.b.a.d Context context, View view) {
            super(bVar, context, view);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(view, "view");
            this.q = bVar;
            this.l = (TextView) view.findViewById(R.id.tv_desc);
            this.m = (TextView) view.findViewById(R.id.tv_title);
            b((TextView) view.findViewById(R.id.tv_download));
            a((ImageView) view.findViewById(R.id.iv_close));
            b((ImageView) view.findViewById(R.id.iv_logo));
            c((TextView) view.findViewById(R.id.tv_logo));
            a(view.findViewById(R.id.ll_title_container));
            this.p = view.findViewById(R.id.rl_content_container);
            XNativeView xNativeView = (XNativeView) view.findViewById(R.id.xn_baidu_video_view_guide);
            this.o = xNativeView;
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
            this.n = view.findViewById(R.id.cl_poster_or_video_container);
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void a(int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14267, this, Integer.valueOf(i2));
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void a(int i2, com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14262, this, Integer.valueOf(i2), bVar);
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void a(View.OnClickListener onClickListener) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14261, this, onClickListener);
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void a(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14264, this, bVar);
        }

        public void a(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14263, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void b(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14258, this, bVar);
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void c(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14257, this, bVar);
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void f(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14260, this, bVar);
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void g(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14259, this, bVar);
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void h(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14222, this, bVar);
        }

        public final XNativeView m() {
            return (XNativeView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14221, this, null);
        }
    }

    public class i extends c {

        @f.b.a.e
        public final ImageView A;

        @f.b.a.e
        public final FrameLayout B;
        public final /* synthetic */ b C;
        public final ImageView l;
        public final TextView m;
        public final TextView n;

        @f.b.a.e
        public final View o;
        public final FrameLayout p;
        public final NativeAdContainer q;
        public final MediaView r;
        public final ImageView s;
        public FrameLayout t;
        public final FrameLayout u;

        @f.b.a.e
        public final View v;

        @f.b.a.e
        public WblTextureMediaPlayer w;

        @f.b.a.e
        public TextView x;

        @f.b.a.e
        public final View y;

        @f.b.a.e
        public final TextView z;

        public static final class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14224, this, view);
            }
        }

        /* renamed from: com.wbl.ad.yzz.gudie.b$i$b */
        public static final class ViewOnClickListenerC0734b implements View.OnClickListener {
            public ViewOnClickListenerC0734b() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14223, this, view);
            }
        }

        public static final class c implements View.OnClickListener {
            public c() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14218, this, view);
            }
        }

        public static final class d implements View.OnClickListener {
            public d() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14217, this, view);
            }
        }

        public static final class e implements View.OnClickListener {
            public e() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14220, this, view);
            }
        }

        public static final class f implements View.OnClickListener {
            public f() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14219, this, view);
            }
        }

        public static final class g implements com.wbl.ad.yzz.wigdet.k.c {
            public g() {
            }

            @Override // com.wbl.ad.yzz.wigdet.k.c
            public void a() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14214, this, null);
            }

            @Override // com.wbl.ad.yzz.wigdet.k.c
            public void b() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14213, this, null);
            }

            @Override // com.wbl.ad.yzz.wigdet.k.c
            public void c() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14216, this, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(@f.b.a.d b bVar, @f.b.a.d Context context, View view) {
            super(bVar, context, view);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(view, "view");
            this.C = bVar;
            this.l = (ImageView) view.findViewById(R.id.iv_default_poster);
            this.m = (TextView) view.findViewById(R.id.tv_desc);
            this.n = (TextView) view.findViewById(R.id.tv_title);
            b((TextView) view.findViewById(R.id.tv_download));
            a((ImageView) view.findViewById(R.id.iv_close));
            b((ImageView) view.findViewById(R.id.iv_logo));
            c((TextView) view.findViewById(R.id.tv_logo));
            a(view.findViewById(R.id.ll_title_container));
            this.t = (FrameLayout) view.findViewById(R.id.fl_poster_or_video_container);
            this.w = (WblTextureMediaPlayer) view.findViewById(R.id.wbl_video_player);
            this.x = (TextView) view.findViewById(R.id.tv_read_book);
            this.v = view.findViewById(R.id.rl_content_container);
            this.p = (FrameLayout) view.findViewById(R.id.csj_video_guide);
            this.o = view.findViewById(R.id.cl_poster_or_video_container);
            this.B = (FrameLayout) view.findViewById(R.id.videoFrameLayout);
            this.q = (NativeAdContainer) view.findViewById(R.id.na_tencent_container);
            this.r = (MediaView) view.findViewById(R.id.md_video_tencent);
            this.s = (ImageView) view.findViewById(R.id.iv_poster_tencent);
            this.u = (FrameLayout) view.findViewById(R.id.fl_tencent_video_poster_container);
            this.y = view.findViewById(R.id.view_watch_tips_container);
            this.z = (TextView) view.findViewById(R.id.tv_watch_tips);
            this.A = (ImageView) view.findViewById(R.id.iv_watch_icon);
        }

        public static final /* synthetic */ FrameLayout a(i iVar) {
            return (FrameLayout) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14156, null, iVar);
        }

        public static final /* synthetic */ ImageView b(i iVar) {
            return (ImageView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14155, null, iVar);
        }

        public static final /* synthetic */ FrameLayout c(i iVar) {
            return (FrameLayout) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14150, null, iVar);
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void a(int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14149, this, Integer.valueOf(i2));
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void a(int i2, com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14152, this, Integer.valueOf(i2), bVar);
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void a(View.OnClickListener onClickListener) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14151, this, onClickListener);
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void a(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14146, this, bVar);
        }

        public final void a(com.wbl.ad.yzz.bean.r rVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14145, this, rVar);
        }

        public void a(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14148, this, str, str2);
        }

        public final void a(String str, boolean z) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14147, this, str, Boolean.valueOf(z));
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void b(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14174, this, bVar);
        }

        public final void b(com.wbl.ad.yzz.bean.r rVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14173, this, rVar);
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void c(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14176, this, bVar);
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void d(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14175, this, bVar);
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void f(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14170, this, bVar);
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void g(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14169, this, bVar);
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void h(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14172, this, bVar);
        }

        public final void i(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14171, this, bVar);
        }

        public final View m() {
            return (View) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14166, this, null);
        }

        public final View n() {
            return (View) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14165, this, null);
        }

        public final WblTextureMediaPlayer o() {
            return (WblTextureMediaPlayer) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14168, this, null);
        }

        public final void p() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14167, this, null);
        }
    }

    public final class j extends c {
        public final View l;
        public final ImageView m;
        public final ImageView n;
        public final ImageView o;
        public final TextView p;
        public final TextView q;
        public final NativeAdContainer r;
        public final LinearLayout s;
        public final ImageView t;
        public final ImageView u;
        public final ImageView v;
        public final View w;
        public final /* synthetic */ b x;

        public static final class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14215, this, view);
            }
        }

        /* renamed from: com.wbl.ad.yzz.gudie.b$j$b */
        public static final class ViewOnClickListenerC0735b implements View.OnClickListener {
            public ViewOnClickListenerC0735b() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14210, this, view);
            }
        }

        public static final class c implements View.OnClickListener {
            public c() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14209, this, view);
            }
        }

        public static final class d implements View.OnClickListener {
            public d() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14212, this, view);
            }
        }

        public static final class e implements View.OnClickListener {
            public e() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14211, this, view);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(@f.b.a.d b bVar, @f.b.a.d Context context, View view) {
            super(bVar, context, view);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(view, "view");
            this.x = bVar;
            this.l = view.findViewById(R.id.ll_poster_container);
            this.m = (ImageView) view.findViewById(R.id.iv_default_poster_1);
            this.n = (ImageView) view.findViewById(R.id.iv_default_poster_2);
            this.o = (ImageView) view.findViewById(R.id.iv_default_poster_3);
            this.p = (TextView) view.findViewById(R.id.tv_desc);
            this.q = (TextView) view.findViewById(R.id.tv_title);
            b((TextView) view.findViewById(R.id.tv_download));
            a((ImageView) view.findViewById(R.id.iv_close));
            b((ImageView) view.findViewById(R.id.iv_logo));
            c((TextView) view.findViewById(R.id.tv_logo));
            this.w = view.findViewById(R.id.rl_content_container);
            a(view.findViewById(R.id.ll_title_container));
            this.r = (NativeAdContainer) view.findViewById(R.id.native_ad_tencent_container);
            this.s = (LinearLayout) view.findViewById(R.id.ll_tencent_poster_container);
            this.t = (ImageView) view.findViewById(R.id.iv_tencent_poster_1);
            this.u = (ImageView) view.findViewById(R.id.iv_tencent_poster_2);
            this.v = (ImageView) view.findViewById(R.id.iv_tencent_poster_3);
        }

        public static final /* synthetic */ LinearLayout a(j jVar) {
            return (LinearLayout) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14238, null, jVar);
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void a(int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14237, this, Integer.valueOf(i2));
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void a(int i2, com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14240, this, Integer.valueOf(i2), bVar);
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void a(View.OnClickListener onClickListener) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14239, this, onClickListener);
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void a(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14234, this, bVar);
        }

        public void a(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14233, this, str, str2);
        }

        public final void a(String str, String str2, String str3, boolean z) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14236, this, str, str2, str3, Boolean.valueOf(z));
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void b(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14235, this, bVar);
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void c(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14230, this, bVar);
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void f(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14229, this, bVar);
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void g(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14232, this, bVar);
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void h(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14231, this, bVar);
        }
    }

    public class k extends c {

        @f.b.a.e
        public final View l;

        @f.b.a.e
        public final ImageView m;

        @f.b.a.e
        public final TextView n;

        @f.b.a.e
        public final TextView o;

        @f.b.a.e
        public final NativeAdContainer p;
        public final ImageView q;

        @f.b.a.e
        public final View r;
        public final /* synthetic */ b s;

        public static final class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14226, this, view);
            }
        }

        /* renamed from: com.wbl.ad.yzz.gudie.b$k$b */
        public static final class ViewOnClickListenerC0736b implements View.OnClickListener {
            public ViewOnClickListenerC0736b() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14225, this, view);
            }
        }

        public static final class c implements View.OnClickListener {
            public c() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14228, this, view);
            }
        }

        public static final class d implements View.OnClickListener {
            public d() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14227, this, view);
            }
        }

        public static final class e implements View.OnClickListener {
            public e() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14318, this, view);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(@f.b.a.d b bVar, @f.b.a.d Context context, View view) {
            super(bVar, context, view);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(view, "view");
            this.s = bVar;
            this.l = view.findViewById(R.id.fl_poster_container);
            this.m = (ImageView) view.findViewById(R.id.iv_default_poster);
            this.n = (TextView) view.findViewById(R.id.tv_desc);
            this.o = (TextView) view.findViewById(R.id.tv_title);
            b((TextView) view.findViewById(R.id.tv_download));
            a((ImageView) view.findViewById(R.id.iv_close));
            b((ImageView) view.findViewById(R.id.iv_logo));
            c((TextView) view.findViewById(R.id.tv_logo));
            this.r = view.findViewById(R.id.rl_right_container);
            a(view.findViewById(R.id.ll_title_container));
            this.p = (NativeAdContainer) view.findViewById(R.id.native_ad_tencent_container);
            this.q = (ImageView) view.findViewById(R.id.iv_tencent_default_poster);
        }

        public static final /* synthetic */ ImageView a(k kVar) {
            return (ImageView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14250, null, kVar);
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void a(int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14249, this, Integer.valueOf(i2));
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void a(int i2, com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14252, this, Integer.valueOf(i2), bVar);
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void a(View.OnClickListener onClickListener) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14251, this, onClickListener);
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void a(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14246, this, bVar);
        }

        public void a(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14245, this, str, str2);
        }

        public final void a(String str, boolean z) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14248, this, str, Boolean.valueOf(z));
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void b(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14247, this, bVar);
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void c(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14242, this, bVar);
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void d(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14241, this, bVar);
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void f(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14244, this, bVar);
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void g(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14243, this, bVar);
        }

        @Override // com.wbl.ad.yzz.gudie.b.c
        public void h(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14270, this, bVar);
        }

        public final ImageView m() {
            return (ImageView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14269, this, null);
        }

        public final View n() {
            return (View) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14272, this, null);
        }

        public final View o() {
            return (View) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14271, this, null);
        }

        public final NativeAdContainer p() {
            return (NativeAdContainer) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14266, this, null);
        }
    }

    public static final class l implements View.OnClickListener {

        /* renamed from: b */
        public final /* synthetic */ c f32455b;

        public l(c cVar) {
            this.f32455b = cVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14317, this, view);
        }
    }

    public static final class m implements NativeResponse.AdInteractionListener {

        /* renamed from: a */
        public boolean f32456a;

        /* renamed from: c */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f32458c;

        /* renamed from: d */
        public final /* synthetic */ int f32459d;

        /* renamed from: e */
        public final /* synthetic */ String f32460e;

        /* renamed from: f */
        public final /* synthetic */ String f32461f;

        /* renamed from: g */
        public final /* synthetic */ NativeResponse f32462g;

        /* renamed from: h */
        public final /* synthetic */ String f32463h;

        public m(com.wbl.ad.yzz.bean.b bVar, int i2, String str, String str2, NativeResponse nativeResponse, String str3) {
            this.f32458c = bVar;
            this.f32459d = i2;
            this.f32460e = str;
            this.f32461f = str2;
            this.f32462g = nativeResponse;
            this.f32463h = str3;
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onADExposed() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14320, this, null);
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onADExposureFailed(int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14319, this, Integer.valueOf(i2));
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onADStatusChanged() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14314, this, null);
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onAdClick() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14313, this, null);
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onAdUnionClick() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14316, this, null);
        }
    }

    public static final class n implements View.OnClickListener {

        /* renamed from: b */
        public final /* synthetic */ String f32465b;

        /* renamed from: c */
        public final /* synthetic */ com.wbl.ad.yzz.help.e f32466c;

        /* renamed from: d */
        public final /* synthetic */ int f32467d;

        /* renamed from: e */
        public final /* synthetic */ NativeResponse f32468e;

        /* renamed from: f */
        public final /* synthetic */ View f32469f;

        public static final class a implements e.c {
            public a() {
            }

            @Override // com.wbl.ad.yzz.help.e.c
            public void a() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14315, this, null);
            }

            @Override // com.wbl.ad.yzz.help.e.c
            public void b() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14310, this, null);
            }

            @Override // com.wbl.ad.yzz.help.e.c
            public void c() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14309, this, null);
            }
        }

        public n(String str, com.wbl.ad.yzz.help.e eVar, int i2, NativeResponse nativeResponse, View view) {
            this.f32465b = str;
            this.f32466c = eVar;
            this.f32467d = i2;
            this.f32468e = nativeResponse;
            this.f32469f = view;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14312, this, view);
        }
    }

    public static final class o extends com.wbl.ad.yzz.bean.i {

        /* renamed from: f */
        public final /* synthetic */ c f32472f;

        /* renamed from: g */
        public final /* synthetic */ com.wbl.ad.yzz.bean.k f32473g;

        /* renamed from: h */
        public final /* synthetic */ Context f32474h;

        /* renamed from: i */
        public final /* synthetic */ String f32475i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(c cVar, com.wbl.ad.yzz.bean.k kVar, Context context, String str, com.wbl.ad.yzz.bean.b bVar, boolean z, e.b bVar2, int i2, String str2, String str3, com.wbl.ad.yzz.bean.b bVar3, TextView textView, TTAppDownloadListener tTAppDownloadListener) {
            super(bVar3, textView, tTAppDownloadListener);
            this.f32472f = cVar;
            this.f32473g = kVar;
            this.f32474h = context;
            this.f32475i = str;
        }

        @Override // com.wbl.ad.yzz.bean.h
        public void a(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14311, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.bean.h
        public boolean d() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14306, this, null);
        }
    }

    public static final class p implements TTAppDownloadListener {

        /* renamed from: b */
        public final /* synthetic */ com.wbl.ad.yzz.bean.k f32477b;

        /* renamed from: c */
        public final /* synthetic */ boolean f32478c;

        /* renamed from: d */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f32479d;

        /* renamed from: e */
        public final /* synthetic */ e.b f32480e;

        /* renamed from: f */
        public final /* synthetic */ int f32481f;

        /* renamed from: g */
        public final /* synthetic */ String f32482g;

        /* renamed from: h */
        public final /* synthetic */ String f32483h;

        /* renamed from: i */
        public final /* synthetic */ String f32484i;

        public p(com.wbl.ad.yzz.bean.k kVar, boolean z, com.wbl.ad.yzz.bean.b bVar, e.b bVar2, int i2, String str, String str2, String str3) {
            this.f32477b = kVar;
            this.f32478c = z;
            this.f32479d = bVar;
            this.f32480e = bVar2;
            this.f32481f = i2;
            this.f32482g = str;
            this.f32483h = str2;
            this.f32484i = str3;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadActive(long j2, long j3, String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14305, this, Long.valueOf(j2), Long.valueOf(j3), str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFailed(long j2, long j3, String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14308, this, Long.valueOf(j2), Long.valueOf(j3), str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFinished(long j2, String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14307, this, Long.valueOf(j2), str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadPaused(long j2, long j3, String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14334, this, Long.valueOf(j2), Long.valueOf(j3), str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onIdle() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14333, this, null);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onInstalled(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14336, this, str, str2);
        }
    }

    public static final class q implements com.wbl.ad.yzz.help.n.f {
        public q() {
        }

        @Override // com.wbl.ad.yzz.help.n.f
        public void a(float f2, com.wbl.ad.yzz.bean.b bVar, int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14335, this, Float.valueOf(f2), bVar, Integer.valueOf(i2));
        }

        @Override // com.wbl.ad.yzz.help.n.f
        public void a(com.wbl.ad.yzz.bean.b bVar, int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14330, this, bVar, Integer.valueOf(i2));
        }

        @Override // com.wbl.ad.yzz.help.n.f
        public void a(String str, com.wbl.ad.yzz.bean.b bVar, int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14329, this, str, bVar, Integer.valueOf(i2));
        }

        @Override // com.wbl.ad.yzz.help.n.f
        public void a(boolean z, boolean z2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14332, this, Boolean.valueOf(z), Boolean.valueOf(z2));
        }

        @Override // com.wbl.ad.yzz.help.n.f
        public void b(com.wbl.ad.yzz.bean.b bVar, int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14331, this, bVar, Integer.valueOf(i2));
        }

        @Override // com.wbl.ad.yzz.help.n.f
        public void c(com.wbl.ad.yzz.bean.b bVar, int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14326, this, bVar, Integer.valueOf(i2));
        }

        @Override // com.wbl.ad.yzz.help.n.f
        public void d(com.wbl.ad.yzz.bean.b bVar, int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14325, this, bVar, Integer.valueOf(i2));
        }
    }

    public static final class r implements View.OnClickListener {

        /* renamed from: b */
        public final /* synthetic */ Context f32487b;

        /* renamed from: c */
        public final /* synthetic */ com.wbl.ad.yzz.bean.e f32488c;

        /* renamed from: d */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f32489d;

        /* renamed from: e */
        public final /* synthetic */ int f32490e;

        /* renamed from: f */
        public final /* synthetic */ String f32491f;

        /* renamed from: g */
        public final /* synthetic */ String f32492g;

        /* renamed from: h */
        public final /* synthetic */ String f32493h;

        public r(Context context, com.wbl.ad.yzz.bean.e eVar, com.wbl.ad.yzz.bean.b bVar, int i2, String str, String str2, String str3) {
            this.f32487b = context;
            this.f32489d = bVar;
            this.f32490e = i2;
            this.f32491f = str;
            this.f32492g = str2;
            this.f32493h = str3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14328, this, view);
        }
    }

    public static final class s implements TTNativeAd.AdInteractionListener {

        /* renamed from: b */
        public final /* synthetic */ Context f32495b;

        /* renamed from: c */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f32496c;

        /* renamed from: d */
        public final /* synthetic */ String f32497d;

        /* renamed from: e */
        public final /* synthetic */ e.b f32498e;

        /* renamed from: f */
        public final /* synthetic */ int f32499f;

        /* renamed from: g */
        public final /* synthetic */ String f32500g;

        public s(Context context, com.wbl.ad.yzz.bean.b bVar, String str, e.b bVar2, int i2, String str2) {
            this.f32495b = context;
            this.f32496c = bVar;
            this.f32497d = str;
            this.f32498e = bVar2;
            this.f32499f = i2;
            this.f32500g = str2;
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdClicked(View view, TTNativeAd tTNativeAd) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14327, this, view, tTNativeAd);
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14322, this, view, tTNativeAd);
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdShow(TTNativeAd tTNativeAd) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14321, this, tTNativeAd);
        }
    }

    public static final class t implements e.c {

        /* renamed from: b */
        public final /* synthetic */ com.wbl.ad.yzz.help.e f32502b;

        /* renamed from: c */
        public final /* synthetic */ int f32503c;

        /* renamed from: d */
        public final /* synthetic */ Context f32504d;

        /* renamed from: e */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f32505e;

        /* renamed from: f */
        public final /* synthetic */ String f32506f;

        /* renamed from: g */
        public final /* synthetic */ String f32507g;

        public t(com.wbl.ad.yzz.help.e eVar, int i2, Context context, com.wbl.ad.yzz.bean.b bVar, String str, String str2) {
            this.f32502b = eVar;
            this.f32503c = i2;
            this.f32504d = context;
            this.f32505e = bVar;
            this.f32506f = str;
            this.f32507g = str2;
        }

        @Override // com.wbl.ad.yzz.help.e.c
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14324, this, null);
        }

        @Override // com.wbl.ad.yzz.help.e.c
        public void b() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14323, this, null);
        }

        @Override // com.wbl.ad.yzz.help.e.c
        public void c() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14286, this, null);
        }
    }

    public static final class u implements View.OnClickListener {

        /* renamed from: b */
        public final /* synthetic */ View f32509b;

        public u(View view) {
            this.f32509b = view;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14285, this, view);
        }
    }

    public static final class v implements NativeADEventListener {

        /* renamed from: a */
        public boolean f32510a;

        /* renamed from: c */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f32512c;

        /* renamed from: d */
        public final /* synthetic */ int f32513d;

        /* renamed from: e */
        public final /* synthetic */ String f32514e;

        /* renamed from: f */
        public final /* synthetic */ String f32515f;

        /* renamed from: g */
        public final /* synthetic */ Context f32516g;

        /* renamed from: h */
        public final /* synthetic */ boolean f32517h;

        /* renamed from: i */
        public final /* synthetic */ String f32518i;

        /* renamed from: j */
        public final /* synthetic */ NativeUnifiedADData f32519j;

        public v(com.wbl.ad.yzz.bean.b bVar, int i2, String str, String str2, Context context, boolean z, String str3, NativeUnifiedADData nativeUnifiedADData) {
            this.f32512c = bVar;
            this.f32513d = i2;
            this.f32514e = str;
            this.f32515f = str2;
            this.f32516g = context;
            this.f32517h = z;
            this.f32518i = str3;
            this.f32519j = nativeUnifiedADData;
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADClicked() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14288, this, null);
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADError(AdError adError) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14287, this, adError);
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADExposed() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14282, this, null);
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADStatusChanged() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14281, this, null);
        }
    }

    public static final class w implements View.OnClickListener {

        /* renamed from: b */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f32521b;

        /* renamed from: c */
        public final /* synthetic */ com.wbl.ad.yzz.bean.r f32522c;

        /* renamed from: d */
        public final /* synthetic */ int f32523d;

        /* renamed from: e */
        public final /* synthetic */ String f32524e;

        /* renamed from: f */
        public final /* synthetic */ String f32525f;

        /* renamed from: g */
        public final /* synthetic */ String f32526g;

        public w(com.wbl.ad.yzz.bean.b bVar, com.wbl.ad.yzz.bean.r rVar, int i2, String str, String str2, String str3) {
            this.f32521b = bVar;
            this.f32522c = rVar;
            this.f32523d = i2;
            this.f32524e = str;
            this.f32525f = str2;
            this.f32526g = str3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14284, this, view);
        }
    }

    public static final class x implements View.OnClickListener {

        /* renamed from: b */
        public final /* synthetic */ WblTextureMediaPlayer f32528b;

        /* renamed from: c */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f32529c;

        /* renamed from: d */
        public final /* synthetic */ com.wbl.ad.yzz.bean.r f32530d;

        /* renamed from: e */
        public final /* synthetic */ int f32531e;

        /* renamed from: f */
        public final /* synthetic */ String f32532f;

        /* renamed from: g */
        public final /* synthetic */ String f32533g;

        /* renamed from: h */
        public final /* synthetic */ String f32534h;

        public x(WblTextureMediaPlayer wblTextureMediaPlayer, com.wbl.ad.yzz.bean.b bVar, com.wbl.ad.yzz.bean.r rVar, int i2, String str, String str2, String str3) {
            this.f32528b = wblTextureMediaPlayer;
            this.f32529c = bVar;
            this.f32530d = rVar;
            this.f32531e = i2;
            this.f32532f = str;
            this.f32533g = str2;
            this.f32534h = str3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14283, this, view);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@f.b.a.d Activity context, @f.b.a.e List<com.wbl.ad.yzz.adapter.d.b> list) {
        super(0, list);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mTTAppDownloadListenerMap = new WeakHashMap();
        com.wbl.ad.yzz.manager.f fVar = new com.wbl.ad.yzz.manager.f();
        this.mDownLoadApkManager = fVar;
        this.mStartUpHelper = new com.wbl.ad.yzz.help.l();
        this.mContext = context;
        fVar.a(context);
    }

    public static final /* synthetic */ com.wbl.ad.yzz.help.n.f a(b bVar, com.wbl.ad.yzz.bean.b bVar2, int i2) {
        return (com.wbl.ad.yzz.help.n.f) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14278, null, bVar, bVar2, Integer.valueOf(i2));
    }

    public static final /* synthetic */ Context b(b bVar) {
        return (Context) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14297, null, bVar);
    }

    public static final /* synthetic */ Activity c(b bVar) {
        return (Activity) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14299, null, bVar);
    }

    public static final /* synthetic */ com.wbl.ad.yzz.manager.f d(b bVar) {
        return (com.wbl.ad.yzz.manager.f) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14294, null, bVar);
    }

    public static final /* synthetic */ String e(b bVar) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14293, null, bVar);
    }

    public static final /* synthetic */ String f(b bVar) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14296, null, bVar);
    }

    public static final /* synthetic */ com.wbl.ad.yzz.adapter.c.b g(b bVar) {
        return (com.wbl.ad.yzz.adapter.c.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14295, null, bVar);
    }

    public static final /* synthetic */ g h(b bVar) {
        return (g) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14290, null, bVar);
    }

    public static final /* synthetic */ com.wbl.ad.yzz.help.l i(b bVar) {
        return (com.wbl.ad.yzz.help.l) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14289, null, bVar);
    }

    public static final /* synthetic */ String p() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14292, null, null);
    }

    public final com.wbl.ad.yzz.help.n.f a(com.wbl.ad.yzz.bean.b ad2, int position) {
        return (com.wbl.ad.yzz.help.n.f) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14291, this, ad2, Integer.valueOf(position));
    }

    public final void a(int position, com.wbl.ad.yzz.bean.b bean, NativeResponse baiDuAdBean, c helper, View mContainer, View mDownloadView, String adType, String r10) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13358, this, Integer.valueOf(position), bean, baiDuAdBean, helper, mContainer, mDownloadView, adType, r10);
    }

    public final void a(int position, com.wbl.ad.yzz.bean.b r4, com.wbl.ad.yzz.bean.e bindBaiDuApi, View clickView, String r7, String adType, String clickType) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13357, this, Integer.valueOf(position), r4, bindBaiDuApi, clickView, r7, adType, clickType);
    }

    public final void a(int position, com.wbl.ad.yzz.bean.b r4, com.wbl.ad.yzz.bean.r vipAdBean, View clickView, String r7, String adType, String clickType) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13360, this, Integer.valueOf(position), r4, vipAdBean, clickView, r7, adType, clickType);
    }

    public final void a(int position, com.wbl.ad.yzz.bean.b r4, com.wbl.ad.yzz.bean.r yzzAdBean, View clickView, String r7, String adType, String clickType, WblTextureMediaPlayer player) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13359, this, Integer.valueOf(position), r4, yzzAdBean, clickView, r7, adType, clickType, player);
    }

    public final void a(int position, c viewHolder, com.wbl.ad.yzz.bean.b bean, com.wbl.ad.yzz.bean.j ad2, List<View> clickViewList, List<View> creativeViewList, String adType, String actionTypeParams) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13354, this, Integer.valueOf(position), viewHolder, bean, ad2, clickViewList, creativeViewList, adType, actionTypeParams);
    }

    @Override // com.wbl.ad.yzz.adapter.base.BaseQuickAdapter
    public void a(BaseViewHolder holder) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13353, this, holder);
    }

    /* renamed from: a */
    public void a2(BaseViewHolder holder, com.wbl.ad.yzz.adapter.d.b item) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13356, this, holder, item);
    }

    @Override // com.wbl.ad.yzz.adapter.base.BaseQuickAdapter
    public /* bridge */ /* synthetic */ void a(BaseViewHolder baseViewHolder, com.wbl.ad.yzz.adapter.d.b bVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13355, this, baseViewHolder, bVar);
    }

    public final void a(com.wbl.ad.yzz.adapter.c.b itemListener) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13350, this, itemListener);
    }

    public final void a(com.wbl.ad.yzz.bean.b bean, com.wbl.ad.yzz.bean.j ad2, TTNativeExpressAd ttNativeExpressAd, com.wbl.ad.yzz.help.e downLoadApkHelper, c holder, String uniq_id, String r9, String adType) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13349, this, bean, ad2, ttNativeExpressAd, downLoadApkHelper, holder, uniq_id, r9, adType);
    }

    public final void a(com.wbl.ad.yzz.bean.b bean, String channel, int position, String r6, String adType) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13352, this, bean, channel, Integer.valueOf(position), r6, adType);
    }

    public final void a(com.wbl.ad.yzz.bean.b bean, String channel, int position, String r6, String adType, String clickType) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13351, this, bean, channel, Integer.valueOf(position), r6, adType, clickType);
    }

    public final void a(c hleper, int position, com.wbl.ad.yzz.bean.b bean, NativeUnifiedADData tencentAd, NativeAdContainer container, View mTencentVideoPosterContainer, MediaView mTencentVideoView, View mDownLoadView, String r11, String adType) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13346, this, hleper, Integer.valueOf(position), bean, tencentAd, container, mTencentVideoPosterContainer, mTencentVideoView, mDownLoadView, r11, adType);
    }

    public final void a(g listener) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13345, this, listener);
    }

    public final void a(e.b pair, com.wbl.ad.yzz.bean.b bean, int position, String r6, String adType, String clickType) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13348, this, pair, bean, Integer.valueOf(position), r6, adType, clickType);
    }

    public final void a(com.wbl.ad.yzz.innerconfig.d.j sceneDataInfoWrap) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13347, this, sceneDataInfoWrap);
    }

    public final void a(u.b conf) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13374, this, conf);
    }

    public final void a(String uniq_id, String channel) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13373, this, uniq_id, channel);
    }

    public final void a(String uniq_id, String channel, com.wbl.ad.yzz.bean.b bean) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13376, this, uniq_id, channel, bean);
    }

    public final void a(boolean isShowMore, boolean isDownloadTips) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13375, this, Boolean.valueOf(isShowMore), Boolean.valueOf(isDownloadTips));
    }

    public final void a(boolean isCustom, boolean isDownload, com.wbl.ad.yzz.bean.b bean, e.b pair, int position, String uniq_id, String r9, String adType) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13370, this, Boolean.valueOf(isCustom), Boolean.valueOf(isDownload), bean, pair, Integer.valueOf(position), uniq_id, r9, adType);
    }

    @Override // com.wbl.ad.yzz.adapter.base.BaseQuickAdapter
    public int b(int position) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-13369, this, Integer.valueOf(position));
    }

    @Override // com.wbl.ad.yzz.adapter.base.BaseQuickAdapter
    public BaseViewHolder b(ViewGroup parent, int viewType) {
        return (BaseViewHolder) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13372, this, parent, Integer.valueOf(viewType));
    }

    public final com.wbl.ad.yzz.help.n.f b(com.wbl.ad.yzz.bean.b ad2, int position) {
        return (com.wbl.ad.yzz.help.n.f) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13371, this, ad2, Integer.valueOf(position));
    }

    public final void b(String uniq_id, String channel, com.wbl.ad.yzz.bean.b bean) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13366, this, uniq_id, channel, bean);
    }

    @Override // com.wbl.ad.yzz.adapter.base.BaseQuickAdapter
    public int e() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-13365, this, null);
    }

    public final com.wbl.ad.yzz.bean.b f(int position) {
        return (com.wbl.ad.yzz.bean.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13368, this, Integer.valueOf(position));
    }

    @Override // com.wbl.ad.yzz.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13367, this, viewHolder);
    }

    public final void q() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13362, this, null);
    }

    public final Map<RecyclerView.ViewHolder, TTAppDownloadListener> r() {
        return (Map) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13361, this, null);
    }

    public final com.wbl.ad.yzz.innerconfig.d.d s() {
        return (com.wbl.ad.yzz.innerconfig.d.d) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13364, this, null);
    }

    public final void t() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13363, this, null);
    }

    public final void u() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13326, this, null);
    }
}
