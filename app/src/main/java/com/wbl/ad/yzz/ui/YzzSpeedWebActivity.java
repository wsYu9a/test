package com.wbl.ad.yzz.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.informationad.a;
import com.wbl.ad.yzz.network.b.b.k;
import com.wbl.ad.yzz.network.b.b.m;
import com.wbl.ad.yzz.ui.presenter.YzzSpeedPresenter;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 Z2\u00020\u00012\u00020\u0002:\u0002[\\B\u0007¢\u0006\u0004\bY\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\n\u0010\u0005J\u000f\u0010\u000b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\u0005J-\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u001c\u0010\u0005J\u000f\u0010\u001d\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u001d\u0010\u0005J\u000f\u0010\u001e\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u001e\u0010\u0005J\u0011\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b \u0010!J#\u0010&\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b&\u0010'J#\u0010(\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b(\u0010'J\u000f\u0010)\u001a\u00020\u0003H\u0016¢\u0006\u0004\b)\u0010\u0005J\u0019\u0010,\u001a\u00020\u00032\b\u0010+\u001a\u0004\u0018\u00010*H\u0016¢\u0006\u0004\b,\u0010-J\u0015\u0010/\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u0019¢\u0006\u0004\b/\u00100J\r\u00101\u001a\u00020\u0019¢\u0006\u0004\b1\u00102J\r\u00103\u001a\u00020\u0003¢\u0006\u0004\b3\u0010\u0005R\u0016\u00104\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u00107\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010>\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010@\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u00105R\u0018\u0010A\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010?R\u0016\u0010B\u001a\u0002098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010;R\u0016\u0010C\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u00105R\u0018\u0010E\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010H\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010K\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010N\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010Q\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010T\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010W\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010X¨\u0006]"}, d2 = {"Lcom/wbl/ad/yzz/ui/YzzSpeedWebActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/wbl/ad/yzz/d/d/d;", "", "initIntentData", "()V", "initView", "initData", "dismissDialog", "getDetailAd", "getNextBannerDetailAd", "sendNextBannerDetailAd", "sendInitNextBannerDetailAd", "", "eventName", "", "map", "trackEvent", "(Ljava/lang/String;Ljava/util/Map;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "onResume", "onPause", "onDestroy", "Landroid/content/Context;", "getCustomContext", "()Landroid/content/Context;", "Lcom/wbl/ad/yzz/network/b/b/m;", "detailAd", "Lcom/wbl/ad/yzz/bean/b;", "adDataBean", "onPopup", "(Lcom/wbl/ad/yzz/network/b/b/m;Lcom/wbl/ad/yzz/bean/b;)V", "onBanner", "onPopupFail", "Lcom/wbl/ad/yzz/network/b/b/k;", "bean", "onConf", "(Lcom/wbl/ad/yzz/network/b/b/k;)V", "polling", "setPolling", "(Z)V", "isPolling", "()Z", "sendUpdateDetailAd", "mIsNotLoadInformationAd", "Z", "Landroid/widget/ProgressBar;", "webProgressBar", "Landroid/widget/ProgressBar;", "", "MSG_UDPATE_DETAIL_AD$1", "I", "MSG_UDPATE_DETAIL_AD", "Landroid/widget/ImageView;", "webViewClose", "Landroid/widget/ImageView;", "mIsPolling", "webViewBack", "mAdSpaceTime", "mIsResume", "Landroid/webkit/WebView;", "webWebView", "Landroid/webkit/WebView;", "Lcom/wbl/ad/yzz/ui/YzzSpeedWebActivity$b;", "mHanlder", "Lcom/wbl/ad/yzz/ui/YzzSpeedWebActivity$b;", "Lcom/wbl/ad/yzz/innerconfig/d/d;", "mSceneCache", "Lcom/wbl/ad/yzz/innerconfig/d/d;", "Landroid/view/GestureDetector;", "mGestureDetector", "Landroid/view/GestureDetector;", "Lcom/wbl/ad/yzz/informationad/e;", "mInformationBottomAdWrap", "Lcom/wbl/ad/yzz/informationad/e;", "Lcom/wbl/ad/yzz/ui/presenter/YzzSpeedPresenter;", "mYzzSpeedPresenter", "Lcom/wbl/ad/yzz/ui/presenter/YzzSpeedPresenter;", "Lcom/wbl/ad/yzz/informationad/b;", "mInformationAdDialog", "Lcom/wbl/ad/yzz/informationad/b;", "<init>", "Companion", "a", "b", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class YzzSpeedWebActivity extends AppCompatActivity implements com.wbl.ad.yzz.d.d.d {

    /* renamed from: Companion, reason: from kotlin metadata */
    @f.b.a.d
    public static final Companion INSTANCE = new Companion(null);

    @f.b.a.d
    public static final String IS_NOT_LOAD_INFORMATIONAD = "IsNotLoadInformationAd";
    private static final int MSG_UDPATE_BANNNER_DETAIL_AD = 4712;
    private static final int MSG_UDPATE_DETAIL_AD = 4711;
    private int mAdSpaceTime;
    private GestureDetector mGestureDetector;
    private b mHanlder;
    private com.wbl.ad.yzz.informationad.b mInformationAdDialog;
    private com.wbl.ad.yzz.informationad.e mInformationBottomAdWrap;
    private boolean mIsNotLoadInformationAd;
    private boolean mIsPolling;
    private com.wbl.ad.yzz.innerconfig.d.d mSceneCache;
    private YzzSpeedPresenter mYzzSpeedPresenter;
    private ProgressBar webProgressBar;
    private ImageView webViewBack;
    private ImageView webViewClose;
    private WebView webWebView;

    /* renamed from: MSG_UDPATE_DETAIL_AD$1, reason: from kotlin metadata */
    private final int MSG_UDPATE_DETAIL_AD = MSG_UDPATE_DETAIL_AD;
    private boolean mIsResume = true;

    /* renamed from: com.wbl.ad.yzz.ui.YzzSpeedWebActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion() {
        }

        public final int a() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-10218, this, null);
        }

        public final int b() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-10217, this, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b extends Handler {

        /* renamed from: a */
        @f.b.a.e
        public final WeakReference<YzzSpeedWebActivity> f33946a;

        public b(@f.b.a.e YzzSpeedWebActivity yzzSpeedWebActivity) {
            if (yzzSpeedWebActivity != null) {
                this.f33946a = new WeakReference<>(yzzSpeedWebActivity);
            } else {
                this.f33946a = null;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10220, this, message);
        }
    }

    public static final class c extends WebChromeClient {
        public c() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10219, this, webView, Integer.valueOf(i2));
        }
    }

    public static final class d implements DownloadListener {
        public d() {
        }

        @Override // android.webkit.DownloadListener
        public final void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10214, this, str, str2, str3, str4, Long.valueOf(j2));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/wbl/ad/yzz/ui/YzzSpeedWebActivity$e", "Landroid/webkit/WebViewClient;", "Landroid/webkit/WebView;", "webView", "", "url", "", "shouldOverrideUrlLoading", "(Landroid/webkit/WebView;Ljava/lang/String;)Z", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class e extends WebViewClient {
        public e() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String url) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10213, this, webView, url);
        }
    }

    public static final class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10216, this, view);
        }
    }

    public static final class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10215, this, view);
        }
    }

    public static final class h implements GestureDetector.OnGestureListener {
        public h() {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10210, this, motionEvent);
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10209, this, motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3));
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10212, this, motionEvent);
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10211, this, motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3));
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10238, this, motionEvent);
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10237, this, motionEvent);
        }
    }

    public static final class i implements a.InterfaceC0750a {
        public i() {
        }

        @Override // com.wbl.ad.yzz.informationad.a.InterfaceC0750a
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10240, this, null);
        }

        @Override // com.wbl.ad.yzz.informationad.a.InterfaceC0750a
        public void b() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10239, this, null);
        }
    }

    public static final class j implements a.InterfaceC0750a {
        public j() {
        }

        @Override // com.wbl.ad.yzz.informationad.a.InterfaceC0750a
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10234, this, null);
        }

        @Override // com.wbl.ad.yzz.informationad.a.InterfaceC0750a
        public void b() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10233, this, null);
        }
    }

    public static final /* synthetic */ com.wbl.ad.yzz.innerconfig.d.d access$getMSceneCache$p(YzzSpeedWebActivity yzzSpeedWebActivity) {
        return (com.wbl.ad.yzz.innerconfig.d.d) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10231, null, yzzSpeedWebActivity);
    }

    public static final /* synthetic */ ProgressBar access$getWebProgressBar$p(YzzSpeedWebActivity yzzSpeedWebActivity) {
        return (ProgressBar) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10225, null, yzzSpeedWebActivity);
    }

    public static final /* synthetic */ WebView access$getWebWebView$p(YzzSpeedWebActivity yzzSpeedWebActivity) {
        return (WebView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10228, null, yzzSpeedWebActivity);
    }

    private final void dismissDialog() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10185, this, null);
    }

    private final void getDetailAd() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10188, this, null);
    }

    private final void getNextBannerDetailAd() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10187, this, null);
    }

    private final void initData() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10182, this, null);
    }

    private final void initIntentData() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10181, this, null);
    }

    private final void initView() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10184, this, null);
    }

    private final void sendInitNextBannerDetailAd() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10183, this, null);
    }

    private final void sendNextBannerDetailAd() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10178, this, null);
    }

    private final void trackEvent(String eventName, Map<String, String> map) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10177, this, eventName, map);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10180, this, ev);
    }

    public Context getCustomContext() {
        return (Context) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10179, this, null);
    }

    public final boolean isPolling() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10206, this, null);
    }

    @Override // com.wbl.ad.yzz.d.d.d
    public void onBanner(m detailAd, com.wbl.ad.yzz.bean.b adDataBean) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10205, this, detailAd, adDataBean);
    }

    @Override // com.wbl.ad.yzz.d.d.d
    public void onConf(k bean) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10208, this, bean);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10207, this, savedInstanceState);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10202, this, null);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10201, this, null);
    }

    @Override // com.wbl.ad.yzz.d.d.d
    public void onPopup(m detailAd, com.wbl.ad.yzz.bean.b adDataBean) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10204, this, detailAd, adDataBean);
    }

    @Override // com.wbl.ad.yzz.d.d.d
    public void onPopupFail() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10203, this, null);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10198, this, null);
    }

    public final void sendUpdateDetailAd() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10197, this, null);
    }

    public final void setPolling(boolean polling) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10200, this, Boolean.valueOf(polling));
    }
}
