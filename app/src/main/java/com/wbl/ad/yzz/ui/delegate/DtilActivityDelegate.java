package com.wbl.ad.yzz.ui.delegate;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.cdo.oaps.ad.OapsKey;
import com.kuaishou.weapon.p0.t;
import com.martian.mibook.application.MiConfigSingleton;
import com.umeng.analytics.pro.am;
import com.wbl.ad.yzz.d.b.e.a;
import com.wbl.ad.yzz.network.b.b.t;
import com.wbl.ad.yzz.network.bean.request.GetAdDetLinfReq;
import com.wbl.ad.yzz.ui.DtilActivity;
import com.wbl.ad.yzz.wigdet.wblplayer.WblTextureMediaPlayerImp;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000e2\u00020\u00012\u00020\u0002:\u0004\f\u0082\u0001\u0011B\u0013\u0012\b\u0010\u007f\u001a\u0004\u0018\u00010[¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\u0005J\u0019\u0010\f\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000e\u0010\u0005J\u0017\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\f\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\f\u0010\u0015J\u000f\u0010\f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\u0005J'\u0010\f\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\f\u0010\u001aJ\u000f\u0010\u0011\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0011\u0010\u0005J\u001f\u0010\f\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\f\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001e\u0010\u0005J\u0017\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u0011\u0010 J\u000f\u0010!\u001a\u00020\u0018H\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0003H\u0002¢\u0006\u0004\b#\u0010\u0005J\u000f\u0010$\u001a\u00020\u0003H\u0002¢\u0006\u0004\b$\u0010\u0005J\u0019\u0010\t\u001a\u00020\u00032\b\u0010&\u001a\u0004\u0018\u00010%H\u0002¢\u0006\u0004\b\t\u0010'J\u0017\u0010\u0011\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0011\u0010\u0015J!\u0010\f\u001a\u00020\u00032\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010+\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\f\u0010,J\u0017\u0010#\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0018H\u0002¢\u0006\u0004\b#\u0010 J'\u0010\f\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\f\u00100J\u0019\u0010\u0011\u001a\u00020\u00032\b\u00102\u001a\u0004\u0018\u000101H\u0002¢\u0006\u0004\b\u0011\u00103J\u0017\u0010\u0011\u001a\u00020\u00032\u0006\u00104\u001a\u00020%H\u0002¢\u0006\u0004\b\u0011\u0010'J\u0019\u0010\f\u001a\u00020\u00182\b\u00105\u001a\u0004\u0018\u00010%H\u0002¢\u0006\u0004\b\f\u00106J\u0017\u0010\f\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\f\u0010\u0012J\u000f\u00107\u001a\u00020\u0003H\u0002¢\u0006\u0004\b7\u0010\u0005J\u000f\u00108\u001a\u00020\u0003H\u0002¢\u0006\u0004\b8\u0010\u0005J\u001f\u0010\f\u001a\u00020\u00032\u0006\u00109\u001a\u00020\u00132\u0006\u0010/\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\f\u0010:J\u0019\u00107\u001a\u00020\u00032\b\u00104\u001a\u0004\u0018\u00010%H\u0002¢\u0006\u0004\b7\u0010'J\u000f\u0010;\u001a\u00020\u0018H\u0002¢\u0006\u0004\b;\u0010\"J\u000f\u0010<\u001a\u00020\u0003H\u0002¢\u0006\u0004\b<\u0010\u0005J\u000f\u0010(\u001a\u00020\u0003H\u0002¢\u0006\u0004\b(\u0010\u0005J\u000f\u0010=\u001a\u00020\u0003H\u0002¢\u0006\u0004\b=\u0010\u0005J\u0019\u0010#\u001a\u00020\u00032\b\u0010&\u001a\u0004\u0018\u00010%H\u0002¢\u0006\u0004\b#\u0010'J-\u0010\f\u001a\u00020\u00032\u0006\u0010>\u001a\u00020%2\u0014\u0010@\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%\u0018\u00010?H\u0002¢\u0006\u0004\b\f\u0010AJ\u000f\u0010B\u001a\u00020\u0003H\u0016¢\u0006\u0004\bB\u0010\u0005J\u000f\u0010C\u001a\u00020\u0013H\u0016¢\u0006\u0004\bC\u0010DJ\u0011\u0010F\u001a\u0004\u0018\u00010EH\u0016¢\u0006\u0004\bF\u0010GJ\u0019\u0010\f\u001a\u00020\u00032\b\u00102\u001a\u0004\u0018\u000101H\u0016¢\u0006\u0004\b\f\u00103J\u000f\u0010H\u001a\u00020\u0003H\u0016¢\u0006\u0004\bH\u0010\u0005J\u000f\u0010I\u001a\u00020\u0003H\u0016¢\u0006\u0004\bI\u0010\u0005J\u000f\u0010J\u001a\u00020\u0003H\u0016¢\u0006\u0004\bJ\u0010\u0005J\u000f\u0010K\u001a\u00020\u0003H\u0016¢\u0006\u0004\bK\u0010\u0005J\r\u0010L\u001a\u00020\u0003¢\u0006\u0004\bL\u0010\u0005J\r\u0010M\u001a\u00020\u0003¢\u0006\u0004\bM\u0010\u0005J\r\u0010N\u001a\u00020\u0003¢\u0006\u0004\bN\u0010\u0005J\u0015\u0010\f\u001a\u00020\u00032\u0006\u0010O\u001a\u00020\u0018¢\u0006\u0004\b\f\u0010 J\r\u0010P\u001a\u00020\u0003¢\u0006\u0004\bP\u0010\u0005R\u0018\u0010S\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010RR\u0018\u0010V\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010UR\u0018\u0010Y\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010XR\u0018\u0010Z\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010RR\u0018\u0010]\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\\R\u0016\u0010_\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010^R\u0018\u0010`\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010RR\u0016\u0010b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010aR\u0018\u0010c\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u0010XR\"\u0010g\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020e0d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010fR\u0018\u0010h\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010RR\u0018\u0010i\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010UR\u0018\u0010l\u001a\u0004\u0018\u00010j8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010kR\u0016\u0010m\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010^R\u0018\u0010n\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010RR\u0018\u0010q\u001a\u0004\u0018\u00010o8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010pR\u0016\u0010t\u001a\u00020r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010sR\u0016\u0010w\u001a\u00020u8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010vR\u0016\u0010x\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010aR\u0018\u0010y\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010UR\u0018\u0010|\u001a\u0004\u0018\u00010z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010{R\u0018\u0010}\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010RR\u0018\u0010~\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010X¨\u0006\u0083\u0001"}, d2 = {"Lcom/wbl/ad/yzz/ui/delegate/DtilActivityDelegate;", "", "Lcom/wbl/ad/yzz/d/d/b;", "", com.opos.mobad.f.a.j.f20763a, "()V", "k", "i", "h", com.kwad.sdk.ranger.e.TAG, "Lcom/wbl/ad/yzz/network/bean/request/GetAdDetLinfReq;", "getAdDetLinfReq", "a", "(Lcom/wbl/ad/yzz/network/bean/request/GetAdDetLinfReq;)V", "x", "", com.alipay.mobilesecuritysdk.deviceID.c.y, "b", "(J)V", "", "type", "(I)V", "Lcom/wbl/ad/yzz/bean/b;", "adDataBean", "", "isShowErrorTips", "(Lcom/wbl/ad/yzz/bean/b;IZ)V", "isShow", "isShowPlay", "(ZZ)V", "y", "isPlaying", "(Z)V", "m", "()Z", "c", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "str", "(Ljava/lang/String;)V", "v", "Lcom/wbl/ad/yzz/network/b/b/t$a;", MiConfigSingleton.t0, "isShowAnim", "(Lcom/wbl/ad/yzz/network/b/b/t$a;Z)V", "start", "end", "duration", "(JJJ)V", "Lcom/wbl/ad/yzz/network/b/b/t;", "bean", "(Lcom/wbl/ad/yzz/network/b/b/t;)V", "url", "content", "(Ljava/lang/String;)Z", "d", "B", "current", "(II)V", t.f9404d, am.aD, IAdInterListener.AdReqParam.WIDTH, "eventName", "", "map", "(Ljava/lang/String;Ljava/util/Map;)V", OapsKey.KEY_GRADE, "f", "()I", "Landroid/content/Context;", "getActivity", "()Landroid/content/Context;", "s", t.k, "t", "o", "p", "u", "q", "isDeep", "n", "Landroid/view/View;", "Landroid/view/View;", "mPlayerParentContainer", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "mIvClose", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "mTvNewWatch", "mProgressContainer", "Lcom/wbl/ad/yzz/ui/DtilActivity;", "Lcom/wbl/ad/yzz/ui/DtilActivity;", "mActivity", "I", "mProgressWidth", "mCloseContainer", "Z", "mIsDestroy", "mTvNewDownload", "Lcom/wbl/ad/yzz/d/b/e/b;", "Lcom/wbl/ad/yzz/d/a/b;", "Lcom/wbl/ad/yzz/d/b/e/b;", "mPresenter", "mGuideAnimContainer", "mIvPlay", "Lcom/wbl/ad/yzz/ui/delegate/DtilActivityDelegate$b;", "Lcom/wbl/ad/yzz/ui/delegate/DtilActivityDelegate$b;", "mHandler", "lastPlayPosition", "mPlayControllerContainer", "Lcom/wbl/ad/yzz/wigdet/wblplayer/WblTextureMediaPlayerImp;", "Lcom/wbl/ad/yzz/wigdet/wblplayer/WblTextureMediaPlayerImp;", "mVideoPlayer", "Lcom/wbl/ad/yzz/ui/delegate/DtilActivityDelegate$DataCache;", "Lcom/wbl/ad/yzz/ui/delegate/DtilActivityDelegate$DataCache;", "mData", "Lcom/wbl/ad/yzz/help/l;", "Lcom/wbl/ad/yzz/help/l;", "mStartUpHelper", "mIsDownloadClicked", "mIvGuideAnim", "Landroid/webkit/WebView;", "Landroid/webkit/WebView;", "mWebWebView", "mProgressView", "mTvGuideDouble", TTDownloadField.TT_ACTIVITY, "<init>", "(Lcom/wbl/ad/yzz/ui/DtilActivity;)V", "DataCache", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class DtilActivityDelegate implements com.wbl.ad.yzz.d.d.b {

    /* renamed from: x, reason: from kotlin metadata */
    @f.b.a.d
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    public final DtilActivity mActivity;

    /* renamed from: b, reason: from kotlin metadata */
    public View mCloseContainer;

    /* renamed from: c, reason: from kotlin metadata */
    public ImageView mIvClose;

    /* renamed from: d, reason: from kotlin metadata */
    public TextView mTvNewDownload;

    /* renamed from: e */
    public View mPlayerParentContainer;

    /* renamed from: f, reason: from kotlin metadata */
    public WblTextureMediaPlayerImp mVideoPlayer;

    /* renamed from: g */
    public WebView mWebWebView;

    /* renamed from: h, reason: from kotlin metadata */
    public View mPlayControllerContainer;

    /* renamed from: i, reason: from kotlin metadata */
    public ImageView mIvPlay;

    /* renamed from: j */
    public TextView mTvNewWatch;

    /* renamed from: k, reason: from kotlin metadata */
    public View mProgressContainer;

    /* renamed from: l */
    public View mProgressView;

    /* renamed from: m, reason: from kotlin metadata */
    public View mGuideAnimContainer;

    /* renamed from: n, reason: from kotlin metadata */
    public TextView mTvGuideDouble;

    /* renamed from: o, reason: from kotlin metadata */
    public ImageView mIvGuideAnim;

    /* renamed from: p, reason: from kotlin metadata */
    public boolean mIsDestroy;

    /* renamed from: t, reason: from kotlin metadata */
    public int mProgressWidth;

    /* renamed from: v, reason: from kotlin metadata */
    public boolean mIsDownloadClicked;

    /* renamed from: w */
    public int lastPlayPosition;

    /* renamed from: q, reason: from kotlin metadata */
    public final com.wbl.ad.yzz.d.b.e.b<com.wbl.ad.yzz.d.d.b, com.wbl.ad.yzz.d.a.b> mPresenter = new a(com.wbl.ad.yzz.d.a.d.f31815b.b());

    /* renamed from: r */
    public final DataCache mData = new DataCache();

    /* renamed from: u, reason: from kotlin metadata */
    public final com.wbl.ad.yzz.help.l mStartUpHelper = new com.wbl.ad.yzz.help.l();

    /* renamed from: s, reason: from kotlin metadata */
    public b mHandler = new b(this);

    public static final class DataCache {

        /* renamed from: a */
        @f.b.a.e
        public com.wbl.ad.yzz.network.b.b.t f34065a;

        /* renamed from: b */
        @f.b.a.e
        public com.wbl.ad.yzz.bean.b f34066b;

        /* renamed from: c */
        public boolean f34067c;

        /* renamed from: d */
        @f.b.a.e
        public com.wbl.ad.yzz.innerconfig.d.d f34068d;

        /* renamed from: e */
        @f.b.a.d
        public final Lazy f34069e;

        /* renamed from: f */
        @f.b.a.d
        public final Lazy f34070f;

        public DataCache() {
            Lazy lazy;
            Lazy lazy2;
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.wbl.ad.yzz.ui.delegate.DtilActivityDelegate$DataCache$userId$2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final int invoke2() {
                    return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-9696, this, null);
                }

                /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Integer, java.lang.Object] */
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Integer invoke() {
                    return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9695, this, null);
                }
            });
            this.f34069e = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.wbl.ad.yzz.ui.delegate.DtilActivityDelegate$DataCache$callType$2
                {
                    super(0);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final int invoke2() {
                    return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-9694, this, null);
                }

                /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Integer, java.lang.Object] */
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Integer invoke() {
                    return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9693, this, null);
                }
            });
            this.f34070f = lazy2;
        }

        public final com.wbl.ad.yzz.bean.b a() {
            return (com.wbl.ad.yzz.bean.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9690, this, null);
        }

        public final void a(com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9689, this, bVar);
        }

        public final void a(com.wbl.ad.yzz.innerconfig.d.d dVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9692, this, dVar);
        }

        public final void a(com.wbl.ad.yzz.network.b.b.t tVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9691, this, tVar);
        }

        public final String b() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9686, this, null);
        }

        public final long c() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.j(-9685, this, null);
        }

        public final com.wbl.ad.yzz.network.b.b.t d() {
            return (com.wbl.ad.yzz.network.b.b.t) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9688, this, null);
        }

        public final int e() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-9687, this, null);
        }

        public final com.wbl.ad.yzz.innerconfig.d.d f() {
            return (com.wbl.ad.yzz.innerconfig.d.d) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9682, this, null);
        }

        public final String g() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9681, this, null);
        }

        public final int h() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-9684, this, null);
        }

        public final String i() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9683, this, null);
        }

        public final boolean j() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-8750, this, null);
        }

        public final boolean k() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-8749, this, null);
        }
    }

    /* renamed from: com.wbl.ad.yzz.ui.delegate.DtilActivityDelegate$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion() {
        }

        public final String a() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8752, this, null);
        }

        public final String b() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8751, this, null);
        }

        public final String c() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8746, this, null);
        }

        public final String d() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8745, this, null);
        }

        public final String e() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8748, this, null);
        }

        public final String f() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8747, this, null);
        }

        public final String g() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8742, this, null);
        }

        public final String h() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8741, this, null);
        }

        public final String i() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8744, this, null);
        }

        public final String j() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8743, this, null);
        }

        public final String k() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8738, this, null);
        }

        public final String l() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8737, this, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b extends Handler {

        /* renamed from: a */
        public final WeakReference<DtilActivityDelegate> f34071a;

        public b(@f.b.a.e DtilActivityDelegate dtilActivityDelegate) {
            this.f34071a = new WeakReference<>(dtilActivityDelegate);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8740, this, message);
        }
    }

    public static final class c implements com.wbl.ad.yzz.adapter.c.b {
        public c() {
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8739, this, Integer.valueOf(i2));
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(com.wbl.ad.yzz.bean.b bVar, String str, String str2, String str3, String str4) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8766, this, bVar, str, str2, str3, str4);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(com.wbl.ad.yzz.bean.b bVar, String str, String str2, String str3, String str4, String str5) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8765, this, bVar, str, str2, str3, str4, str5);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8768, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(String str, String str2, com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8767, this, str, str2, bVar);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(boolean z, boolean z2, String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8762, this, Boolean.valueOf(z), Boolean.valueOf(z2), str);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void b(String str, String str2, com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8761, this, str, str2, bVar);
        }
    }

    public static final class d implements Runnable {

        /* renamed from: b */
        public final /* synthetic */ t.a f34074b;

        /* renamed from: c */
        public final /* synthetic */ long f34075c;

        public d(t.a aVar, long j2) {
            this.f34074b = aVar;
            this.f34075c = j2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8764, this, null);
        }
    }

    public static final class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8763, this, null);
        }
    }

    public static final class f implements com.wbl.ad.yzz.wigdet.k.a {
        public f() {
        }

        @Override // com.wbl.ad.yzz.wigdet.k.a
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8758, this, null);
        }

        @Override // com.wbl.ad.yzz.wigdet.k.a
        public void a(int i2, int i3) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8757, this, Integer.valueOf(i2), Integer.valueOf(i3));
        }

        @Override // com.wbl.ad.yzz.wigdet.k.a
        public void b() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8760, this, null);
        }

        @Override // com.wbl.ad.yzz.wigdet.k.a
        public void c() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8759, this, null);
        }

        @Override // com.wbl.ad.yzz.wigdet.k.a
        public void d() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8754, this, null);
        }

        @Override // com.wbl.ad.yzz.wigdet.k.a
        public void e() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8753, this, null);
        }
    }

    public static final class g extends WebChromeClient {
        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8756, this, webView, Integer.valueOf(i2));
        }
    }

    public static final class h extends WebViewClient {
    }

    public static final class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8755, this, view);
        }
    }

    public static final class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8718, this, view);
        }
    }

    public static final class k implements View.OnClickListener {
        public k() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8717, this, view);
        }
    }

    public static final class l implements View.OnClickListener {
        public l() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8720, this, view);
        }
    }

    public static final class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8719, this, view);
        }
    }

    public DtilActivityDelegate(@f.b.a.e DtilActivity dtilActivity) {
        this.mActivity = dtilActivity;
    }

    public static final /* synthetic */ b d(DtilActivityDelegate dtilActivityDelegate) {
        return (b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8711, null, dtilActivityDelegate);
    }

    public static final /* synthetic */ ImageView f(DtilActivityDelegate dtilActivityDelegate) {
        return (ImageView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8705, null, dtilActivityDelegate);
    }

    public final void A() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8734, this, null);
    }

    public final void B() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8733, this, null);
    }

    public final void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8736, this, null);
    }

    public final void a(int type) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8735, this, Integer.valueOf(type));
    }

    public final void a(int current, int duration) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8730, this, Integer.valueOf(current), Integer.valueOf(duration));
    }

    public final void a(long start) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8729, this, Long.valueOf(start));
    }

    public final void a(long start, long end, long duration) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8732, this, Long.valueOf(start), Long.valueOf(end), Long.valueOf(duration));
    }

    public final void a(com.wbl.ad.yzz.bean.b adDataBean, int type, boolean isShowErrorTips) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8731, this, adDataBean, Integer.valueOf(type), Boolean.valueOf(isShowErrorTips));
    }

    public final void a(t.a r3, boolean isShowAnim) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8726, this, r3, Boolean.valueOf(isShowAnim));
    }

    @Override // com.wbl.ad.yzz.d.d.b
    public void a(com.wbl.ad.yzz.network.b.b.t bean) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8725, this, bean);
    }

    public final void a(GetAdDetLinfReq getAdDetLinfReq) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8728, this, getAdDetLinfReq);
    }

    public final void a(String eventName, Map<String, String> map) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8727, this, eventName, map);
    }

    public final void a(boolean isDeep) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8722, this, Boolean.valueOf(isDeep));
    }

    public final void a(boolean isShow, boolean isShowPlay) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8721, this, Boolean.valueOf(isShow), Boolean.valueOf(isShowPlay));
    }

    public final boolean a(String content) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-8724, this, content);
    }

    public final void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8723, this, null);
    }

    public final void b(int v) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8814, this, Integer.valueOf(v));
    }

    public final void b(long r2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8813, this, Long.valueOf(r2));
    }

    public final void b(com.wbl.ad.yzz.network.b.b.t bean) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8816, this, bean);
    }

    public final void b(String url) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8815, this, url);
    }

    public final void b(boolean isPlaying) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8810, this, Boolean.valueOf(isPlaying));
    }

    public final void c() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8809, this, null);
    }

    public final void c(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8812, this, str);
    }

    public final void c(boolean isShow) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8811, this, Boolean.valueOf(isShow));
    }

    public final void d() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8806, this, null);
    }

    public final void d(String url) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8805, this, url);
    }

    public final void e() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8808, this, null);
    }

    public final void e(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8807, this, str);
    }

    public int f() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-8802, this, null);
    }

    public void g() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8801, this, null);
    }

    @Override // com.wbl.ad.yzz.d.d.b
    public Context getActivity() {
        return (Context) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8804, this, null);
    }

    public final void h() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8803, this, null);
    }

    public final void i() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8830, this, null);
    }

    public final void j() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8829, this, null);
    }

    public final void k() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8832, this, null);
    }

    public final boolean l() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-8831, this, null);
    }

    public final boolean m() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-8826, this, null);
    }

    public final void n() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8825, this, null);
    }

    public void o() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8828, this, null);
    }

    public final void p() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8827, this, null);
    }

    public final void q() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8822, this, null);
    }

    public void r() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8821, this, null);
    }

    public void s() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8824, this, null);
    }

    public void t() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8823, this, null);
    }

    public final void u() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8818, this, null);
    }

    public final void v() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8817, this, null);
    }

    public final void w() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8820, this, null);
    }

    public final void x() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8819, this, null);
    }

    public final void y() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8782, this, null);
    }

    public final void z() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8781, this, null);
    }
}
