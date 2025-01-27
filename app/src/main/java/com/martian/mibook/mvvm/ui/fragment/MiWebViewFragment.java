package com.martian.mibook.mvvm.ui.fragment;

import ac.a;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.WebView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import ba.m;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.libmars.activity.PermissionActivity;
import com.martian.libmars.activity.WebViewActivity;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.widget.MTWebView;
import com.martian.libsupport.data.NightModeChangeParams;
import com.martian.libxianplay.view.DownLoadReceiver;
import com.martian.mibook.activity.base.MiWebViewActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.FragmentWebviewBinding;
import com.martian.mibook.lib.account.MiUserManager;
import com.martian.mibook.lib.account.response.AliRechargeOrder;
import com.martian.mibook.lib.account.response.WXRechargeOrder;
import com.martian.mibook.lib.account.response.WebRechargeParams;
import com.martian.mibook.lib.model.data.Source;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.net.ErrorResult;
import com.martian.mibook.mvvm.tts.NonStickyLiveData;
import com.martian.mibook.mvvm.ui.fragment.MiWebViewFragment;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import com.martian.mibook.mvvm.ui.viewmodel.WebViewViewModel;
import com.martian.rpauth.response.MartianRPAccount;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.umeng.analytics.pro.bt;
import e8.b;
import i8.g;
import je.i;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import l9.t0;
import oe.f;
import xi.k;
import xi.l;
import z7.b;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 k2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002lSB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\t\u0010\u0005J!\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0005J\u000f\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u0005J+\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ+\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u001b\u0010\u001aJ\u0017\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\fH\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\fH\u0002¢\u0006\u0004\b'\u0010&J\u001f\u0010)\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\f2\u0006\u0010(\u001a\u00020\fH\u0002¢\u0006\u0004\b)\u0010*J)\u0010-\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\f2\b\u0010+\u001a\u0004\u0018\u00010\u00152\u0006\u0010,\u001a\u00020\u0015H\u0002¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\fH\u0002¢\u0006\u0004\b/\u0010&J\u0019\u00101\u001a\u00020\u00062\b\b\u0002\u00100\u001a\u00020\u0010H\u0002¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u0006H\u0016¢\u0006\u0004\b3\u0010\u0005J\u0019\u00106\u001a\u00020\u00062\b\u00105\u001a\u0004\u0018\u000104H\u0016¢\u0006\u0004\b6\u00107J\u0015\u00109\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u0010¢\u0006\u0004\b9\u00102J\u000f\u0010:\u001a\u00020\u0006H\u0014¢\u0006\u0004\b:\u0010\u0005J\u0017\u0010<\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u0010H\u0014¢\u0006\u0004\b<\u00102J#\u0010?\u001a\u00020\u00062\b\u0010=\u001a\u0004\u0018\u00010\f2\b\u0010>\u001a\u0004\u0018\u00010\fH\u0014¢\u0006\u0004\b?\u0010*J#\u0010B\u001a\u00020\u00062\b\u0010@\u001a\u0004\u0018\u00010\f2\b\u0010A\u001a\u0004\u0018\u00010\fH\u0014¢\u0006\u0004\bB\u0010*J\u0019\u0010D\u001a\u00020\u00062\b\u0010C\u001a\u0004\u0018\u00010\fH\u0014¢\u0006\u0004\bD\u0010&J3\u0010E\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\fH\u0014¢\u0006\u0004\bE\u0010FJ!\u0010H\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010G\u001a\u00020\u0010H\u0014¢\u0006\u0004\bH\u0010IJ#\u0010J\u001a\u00020\u00102\b\u0010=\u001a\u0004\u0018\u00010\f2\b\u0010>\u001a\u0004\u0018\u00010\fH\u0014¢\u0006\u0004\bJ\u0010KJ7\u0010N\u001a\u00020\u00062\b\u0010=\u001a\u0004\u0018\u00010\f2\b\u0010>\u001a\u0004\u0018\u00010\f2\b\u0010L\u001a\u0004\u0018\u00010\f2\b\u0010M\u001a\u0004\u0018\u00010\fH\u0014¢\u0006\u0004\bN\u0010OJ#\u0010S\u001a\u00020\u00062\b\u0010Q\u001a\u0004\u0018\u00010P2\b\u0010R\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\bS\u0010TJ)\u0010Y\u001a\u00020\u00062\u0006\u0010U\u001a\u00020\u00152\u0006\u0010V\u001a\u00020\u00152\b\u0010X\u001a\u0004\u0018\u00010WH\u0016¢\u0006\u0004\bY\u0010ZJ\u000f\u0010[\u001a\u00020\u0006H\u0016¢\u0006\u0004\b[\u0010\u0005J\u0017\u0010^\u001a\u00020\u00062\b\u0010]\u001a\u0004\u0018\u00010\\¢\u0006\u0004\b^\u0010_J\u000f\u0010`\u001a\u00020\u0006H\u0016¢\u0006\u0004\b`\u0010\u0005R\u0018\u0010d\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010h\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010]\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010j¨\u0006m"}, d2 = {"Lcom/martian/mibook/mvvm/ui/fragment/MiWebViewFragment;", "Lcom/martian/mibook/mvvm/ui/fragment/WebViewFragment;", "Lcom/martian/mibook/databinding/FragmentWebviewBinding;", "Lcom/martian/mibook/mvvm/ui/viewmodel/WebViewViewModel;", "<init>", "()V", "", "T1", "Y1", "o2", "Landroid/app/Activity;", TTDownloadField.TT_ACTIVITY, "", "url", "e2", "(Landroid/app/Activity;Ljava/lang/String;)V", "", "g2", "()Z", "f2", "s2", "", "money", "productId", "extra", "W1", "(ILjava/lang/String;Ljava/lang/String;)V", "X1", "Lcom/martian/mibook/lib/account/response/AliRechargeOrder;", "aliRechargeOrder", "q2", "(Lcom/martian/mibook/lib/account/response/AliRechargeOrder;)V", "Lcom/martian/mibook/lib/account/response/WXRechargeOrder;", "tyRechargeWeixinOrder", "r2", "(Lcom/martian/mibook/lib/account/response/WXRechargeOrder;)V", "orderJson", "j2", "(Ljava/lang/String;)V", "h2", "errStr", "i2", "(Ljava/lang/String;Ljava/lang/String;)V", "roid", h3.e.f26414s, "k2", "(Ljava/lang/String;Ljava/lang/Integer;I)V", "l2", "updateTaskAccount", "m2", "(Z)V", "F0", "Landroid/os/Bundle;", "savedInstanceState", "q", "(Landroid/os/Bundle;)V", "isNight", "V1", "e1", "loginDirectly", "X0", "sourceName", "sourceId", "g1", PermissionActivity.f12046p, "value", "Z0", "rechargeParams", "j1", "i1", "(IILjava/lang/String;Ljava/lang/String;)V", "fullscreen", "h1", "(Ljava/lang/String;Z)V", "W0", "(Ljava/lang/String;Ljava/lang/String;)Z", "recommendId", "recommend", "L0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/webkit/WebView;", "view", "title", "b", "(Landroid/webkit/WebView;Ljava/lang/String;)V", "requestCode", "resultCode", "Landroid/content/Intent;", h3.e.f26408m, "onActivityResult", "(IILandroid/content/Intent;)V", "close", "Lcom/martian/mibook/mvvm/ui/fragment/MiWebViewFragment$b;", "onWebViewEventListener", "p2", "(Lcom/martian/mibook/mvvm/ui/fragment/MiWebViewFragment$b;)V", "onDestroy", "Lcom/martian/libxianplay/view/DownLoadReceiver;", "y", "Lcom/martian/libxianplay/view/DownLoadReceiver;", "downLoadReceiver", "Le9/c;", bt.aJ, "Le9/c;", "rxManager", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/martian/mibook/mvvm/ui/fragment/MiWebViewFragment$b;", "B", "a", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nMiWebViewFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MiWebViewFragment.kt\ncom/martian/mibook/mvvm/ui/fragment/MiWebViewFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,609:1\n1#2:610\n*E\n"})
/* loaded from: classes3.dex */
public final class MiWebViewFragment extends WebViewFragment<FragmentWebviewBinding, WebViewViewModel> {

    /* renamed from: B, reason: from kotlin metadata */
    @k
    public static final Companion INSTANCE = new Companion(null);

    @k
    public static final String C = ExtKt.c("充值成功");

    @k
    public static final String D = ExtKt.c("充值取消了~~>_<~~");

    @k
    public static final String E = ExtKt.c("哎妈呀, 充值出错了 >_<¦¦¦, 客官再试一次呗~");

    @k
    public static final String F = ExtKt.c("充值处理中");

    /* renamed from: A */
    @l
    public b onWebViewEventListener;

    /* renamed from: y, reason: from kotlin metadata */
    @l
    public DownLoadReceiver downLoadReceiver;

    /* renamed from: z */
    @l
    public e9.c rxManager;

    @SourceDebugExtension({"SMAP\nMiWebViewFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MiWebViewFragment.kt\ncom/martian/mibook/mvvm/ui/fragment/MiWebViewFragment$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,609:1\n1#2:610\n*E\n"})
    /* renamed from: com.martian.mibook.mvvm.ui.fragment.MiWebViewFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ MiWebViewFragment e(Companion companion, String str, Integer num, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                num = null;
            }
            return companion.a(str, num);
        }

        public static /* synthetic */ MiWebViewFragment f(Companion companion, String str, boolean z10, Integer num, int i10, Object obj) {
            if ((i10 & 4) != 0) {
                num = null;
            }
            return companion.b(str, z10, num);
        }

        public static /* synthetic */ MiWebViewFragment g(Companion companion, String str, boolean z10, String str2, boolean z11, String str3, Integer num, int i10, Object obj) {
            if ((i10 & 32) != 0) {
                num = null;
            }
            return companion.c(str, z10, str2, z11, str3, num);
        }

        @k
        public final MiWebViewFragment a(@l String str, @l Integer num) {
            return b(str, false, num);
        }

        @k
        public final MiWebViewFragment b(@l String str, boolean z10, @l Integer num) {
            return c(str, z10, "", false, "", num);
        }

        @k
        public final MiWebViewFragment c(@l String str, boolean z10, @l String str2, boolean z11, @l String str3, @l Integer num) {
            return d(str, z10, str2, z11, str3, false, num);
        }

        @k
        public final MiWebViewFragment d(@l String str, boolean z10, @l String str2, boolean z11, @l String str3, boolean z12, @l Integer num) {
            MiWebViewFragment miWebViewFragment = new MiWebViewFragment();
            Bundle bundle = new Bundle();
            bundle.putString("LIBMARS_INTENT_WEBVIEW_URL", str);
            if (!ba.l.q(str2)) {
                bundle.putString("INTENT_WEBVIEW_SHARE_URL", str2);
            }
            bundle.putBoolean("LIBMARS_INTENT_DOWNLOAD_HINT", z10);
            bundle.putBoolean("INTENT_SHAREABLE", z11);
            if (!ba.l.q(str3)) {
                bundle.putString("INTENT_SHARE_IMAGE_URL", str3);
            }
            bundle.putBoolean("INTENT_FULLSCREEN", z12);
            if (num != null) {
                bundle.putInt(WebViewFragment.f15239t, num.intValue());
            }
            miWebViewFragment.setArguments(bundle);
            return miWebViewFragment;
        }

        public Companion() {
        }
    }

    public interface b {

        public static final class a {
            public static boolean a(@k b bVar) {
                return true;
            }
        }

        boolean a();

        void b(@l WebView webView, @l String str);

        void close();
    }

    public static final class c implements xb.b {

        /* renamed from: b */
        public final /* synthetic */ String f15225b;

        /* renamed from: c */
        public final /* synthetic */ String f15226c;

        public c(String str, String str2) {
            this.f15225b = str;
            this.f15226c = str2;
        }

        @Override // xb.b
        public void a(@l Book book) {
            if (book == null) {
                t0.b(MiWebViewFragment.this.getContext(), "加入失败，请重试");
                return;
            }
            MiConfigSingleton.b2().M1().g(MiWebViewFragment.this.getActivity(), book);
            t0.b(MiWebViewFragment.this.getContext(), "已加入书架");
            MiConfigSingleton.b2().V1().g(3, book.getSourceName(), book.getSourceId(), this.f15225b, this.f15226c, "书单加书架");
        }

        @Override // xb.b
        public void onLoading(boolean z10) {
        }

        @Override // xb.b
        public void onResultError(@k x8.c errorResult) {
            Intrinsics.checkNotNullParameter(errorResult, "errorResult");
            t0.b(MiWebViewFragment.this.getContext(), "加入失败，请重试");
        }
    }

    public static final class d implements b.c {

        /* renamed from: b */
        public final /* synthetic */ String f15228b;

        /* renamed from: c */
        public final /* synthetic */ AliRechargeOrder f15229c;

        public d(String str, AliRechargeOrder aliRechargeOrder) {
            this.f15228b = str;
            this.f15229c = aliRechargeOrder;
        }

        @Override // e8.b.c
        public void a(@l String str) {
            throw new NotImplementedError("An operation is not implemented: Not yet implemented");
        }

        @Override // e8.b.c
        public void b(@k String out_trade_no, @k String fee_value) {
            Intrinsics.checkNotNullParameter(out_trade_no, "out_trade_no");
            Intrinsics.checkNotNullParameter(fee_value, "fee_value");
        }

        @Override // e8.b.c
        public void c(@k String rawResult) {
            Intrinsics.checkNotNullParameter(rawResult, "rawResult");
        }

        @Override // e8.b.c
        public void d(@k String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            MiWebViewFragment miWebViewFragment = MiWebViewFragment.this;
            String orderJson = this.f15228b;
            Intrinsics.checkNotNullExpressionValue(orderJson, "$orderJson");
            miWebViewFragment.j2(orderJson);
        }

        @Override // e8.b.c
        public void e() {
            throw new NotImplementedError("An operation is not implemented: Not yet implemented");
        }

        @Override // e8.b.c
        public void f(@k String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            MiWebViewFragment miWebViewFragment = MiWebViewFragment.this;
            String orderJson = this.f15228b;
            Intrinsics.checkNotNullExpressionValue(orderJson, "$orderJson");
            miWebViewFragment.h2(orderJson);
        }

        @Override // e8.b.c
        public void onFailure(@k String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            MiWebViewFragment miWebViewFragment = MiWebViewFragment.this;
            String orderJson = this.f15228b;
            Intrinsics.checkNotNullExpressionValue(orderJson, "$orderJson");
            miWebViewFragment.i2(orderJson, message);
        }

        @Override // e8.b.c
        public void onSuccess() {
            MiWebViewFragment miWebViewFragment = MiWebViewFragment.this;
            String orderJson = this.f15228b;
            Intrinsics.checkNotNullExpressionValue(orderJson, "$orderJson");
            miWebViewFragment.k2(orderJson, this.f15229c.getRechargeOrder() == null ? null : this.f15229c.getRechargeOrder().getRoid(), 1);
        }
    }

    public static final class e implements b.c {

        /* renamed from: b */
        public final /* synthetic */ String f15231b;

        /* renamed from: c */
        public final /* synthetic */ WXRechargeOrder f15232c;

        public e(String str, WXRechargeOrder wXRechargeOrder) {
            this.f15231b = str;
            this.f15232c = wXRechargeOrder;
        }

        @Override // z7.b.c
        public void a(@k String errStr) {
            Intrinsics.checkNotNullParameter(errStr, "errStr");
            MiWebViewFragment miWebViewFragment = MiWebViewFragment.this;
            String orderJson = this.f15231b;
            Intrinsics.checkNotNullExpressionValue(orderJson, "$orderJson");
            miWebViewFragment.i2(orderJson, errStr);
        }

        @Override // z7.b.c
        public void b(@k String out_trade_no, @k String fee_value) {
            Intrinsics.checkNotNullParameter(out_trade_no, "out_trade_no");
            Intrinsics.checkNotNullParameter(fee_value, "fee_value");
            MiWebViewFragment miWebViewFragment = MiWebViewFragment.this;
            String orderJson = this.f15231b;
            Intrinsics.checkNotNullExpressionValue(orderJson, "$orderJson");
            miWebViewFragment.j2(orderJson);
        }

        @Override // z7.b.c
        public void c() {
            MiWebViewFragment miWebViewFragment = MiWebViewFragment.this;
            String orderJson = this.f15231b;
            Intrinsics.checkNotNullExpressionValue(orderJson, "$orderJson");
            miWebViewFragment.k2(orderJson, this.f15232c.getRechargeOrder() == null ? null : this.f15232c.getRechargeOrder().getRoid(), 0);
        }

        @Override // z7.b.c
        public void d() {
            MiWebViewFragment miWebViewFragment = MiWebViewFragment.this;
            String orderJson = this.f15231b;
            Intrinsics.checkNotNullExpressionValue(orderJson, "$orderJson");
            miWebViewFragment.h2(orderJson);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ FragmentWebviewBinding L1(MiWebViewFragment miWebViewFragment) {
        return (FragmentWebviewBinding) miWebViewFragment.n();
    }

    private final void T1() {
        e9.c cVar = new e9.c();
        this.rxManager = cVar;
        cVar.c(e9.d.f25790b, new wj.b() { // from class: pd.f
            public /* synthetic */ f() {
            }

            @Override // wj.b
            public final void call(Object obj) {
                MiWebViewFragment.U1(MiWebViewFragment.this, obj);
            }
        });
    }

    public static final void U1(MiWebViewFragment this$0, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.s2();
    }

    private final void W1(int money, String productId, String extra) {
        I().p(money, productId, extra);
    }

    private final void Y1() {
        NonStickyLiveData<MartianRPAccount> Y;
        NonStickyLiveData<AliRechargeOrder> t10 = I().t();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        t10.observe(viewLifecycleOwner, new Observer() { // from class: pd.a
            public /* synthetic */ a() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MiWebViewFragment.a2(Function1.this, obj);
            }
        });
        NonStickyLiveData<ErrorResult> s10 = I().s();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        s10.observe(viewLifecycleOwner2, new Observer() { // from class: pd.b
            public /* synthetic */ b() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MiWebViewFragment.b2(Function1.this, obj);
            }
        });
        NonStickyLiveData<WXRechargeOrder> y10 = I().y();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        y10.observe(viewLifecycleOwner3, new Observer() { // from class: pd.c
            public /* synthetic */ c() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MiWebViewFragment.c2(Function1.this, obj);
            }
        });
        NonStickyLiveData<ErrorResult> x10 = I().x();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        x10.observe(viewLifecycleOwner4, new Observer() { // from class: pd.d
            public /* synthetic */ d() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MiWebViewFragment.d2(Function1.this, obj);
            }
        });
        AppViewModel G = G();
        if (G == null || (Y = G.Y()) == null) {
            return;
        }
        Y.observe(this, new Observer() { // from class: pd.e
            public /* synthetic */ e() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MiWebViewFragment.Z1(Function1.this, obj);
            }
        });
    }

    public static final void Z1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void a2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void b2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void c2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void d2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void e2(Activity r82, String url) {
        if (MiConfigSingleton.b2().F2() && g.q(url) && MiConfigSingleton.b2().V0()) {
            try {
                String t22 = MiConfigSingleton.b2().t2();
                String token = MiConfigSingleton.b2().u2().s().getToken();
                String str = MiConfigSingleton.b2().l().f26178a;
                String A3 = WebViewActivity.A3(url);
                CookieManager cookieManager = CookieManager.getInstance();
                cookieManager.setCookie(A3, "uid=" + t22);
                if (!ba.l.q(token)) {
                    cookieManager.setCookie(A3, "token=" + token);
                }
                if (!ba.l.q(str)) {
                    cookieManager.setCookie(A3, "appid=" + str);
                }
                if (m.q(r82)) {
                    cookieManager.setCookie(A3, "notchHeight=" + ConfigSingleton.W0(com.gyf.immersionbar.d.H0(r82)));
                }
                cookieManager.setCookie(A3, "device_id=" + ConfigSingleton.D().y());
                cookieManager.setCookie(A3, "brand=" + ConfigSingleton.D().o());
                cookieManager.setCookie(A3, "osversion=" + ConfigSingleton.D().k());
                cookieManager.setCookie(A3, "screen_height=" + ConfigSingleton.D().a0());
                cookieManager.setCookie(A3, "screen_width=" + ConfigSingleton.D().b0());
                cookieManager.setCookie(A3, "wx_appid=" + ConfigSingleton.D().q0().f33705a);
                cookieManager.setCookie(A3, "version_code=" + ConfigSingleton.D().o0());
                cookieManager.setCookie(A3, "versionCode=" + ConfigSingleton.D().o0());
                cookieManager.setCookie(A3, "version_name=" + ConfigSingleton.D().p0());
                cookieManager.setCookie(A3, "package_name=" + ConfigSingleton.D().getPackageName());
                cookieManager.setCookie(A3, "channel=" + ConfigSingleton.D().r());
                cookieManager.setCookie(A3, "ostype=0");
                cookieManager.setCookie(A3, "optype=" + ConfigSingleton.D().P());
                cookieManager.setCookie(A3, "conntype=" + ConfigSingleton.D().u());
                cookieManager.setCookie(A3, "guest=" + MiConfigSingleton.b2().D2());
                String queryParameter = Uri.parse(url).getQueryParameter("night_mode");
                if (TextUtils.isEmpty(queryParameter)) {
                    cookieManager.setCookie(A3, "night_mode=" + ConfigSingleton.D().A0());
                } else {
                    cookieManager.setCookie(A3, "night_mode=" + queryParameter);
                }
                cookieManager.setCookie(A3, "traditional=" + ConfigSingleton.D().M0());
                CookieManager.getInstance().flush();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void f2() {
        FragmentActivity activity = getActivity();
        if (activity == null || ba.l.q(I().getMUrl())) {
            return;
        }
        e2(activity, I().getMUrl());
        ((FragmentWebviewBinding) n()).webview.reload();
    }

    private final boolean g2() {
        String mUrl;
        if (ba.l.q(I().getMUrl())) {
            return false;
        }
        String mUrl2 = I().getMUrl();
        return (mUrl2 != null && StringsKt.contains$default((CharSequence) mUrl2, (CharSequence) "xianwan", false, 2, (Object) null)) || ((mUrl = I().getMUrl()) != null && StringsKt.contains$default((CharSequence) mUrl, (CharSequence) "wowan", false, 2, (Object) null));
    }

    public final void h2(String orderJson) {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new MiWebViewFragment$paymentCanceled$1(this, orderJson, null), 2, null);
    }

    public final void i2(String orderJson, String errStr) {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new MiWebViewFragment$paymentError$1(this, errStr, orderJson, null), 2, null);
    }

    public final void j2(String orderJson) {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new MiWebViewFragment$paymentStarted$1(this, orderJson, null), 2, null);
    }

    public final void k2(String orderJson, Integer roid, int r12) {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new MiWebViewFragment$paymentSuccess$1(this, r12, orderJson, roid, null), 2, null);
    }

    public static /* synthetic */ void n2(MiWebViewFragment miWebViewFragment, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        miWebViewFragment.m2(z10);
    }

    @SuppressLint({"UnspecifiedRegisterReceiverFlag"})
    private final void o2() {
        this.downLoadReceiver = new DownLoadReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DOWNLOAD_COMPLETE");
        intentFilter.addAction("android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED");
        Context context = getContext();
        if (context != null) {
            context.registerReceiver(this.downLoadReceiver, intentFilter);
        }
    }

    @Override // com.martian.mibook.mvvm.ui.fragment.WebViewFragment
    public void F0() {
        super.F0();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            e2(activity, I().getMUrl());
        }
        WebViewViewModel I = I();
        Bundle arguments = getArguments();
        I.F(arguments != null ? Integer.valueOf(arguments.getInt(WebViewFragment.f15239t)) : null);
    }

    @Override // com.martian.mibook.mvvm.ui.fragment.WebViewFragment
    public void L0(@l String sourceName, @l String sourceId, @l String recommendId, @l String recommend) {
        if (MiConfigSingleton.b2().M1().j0(sourceName, sourceId)) {
            return;
        }
        MiConfigSingleton.b2().M1().k(new Source(sourceName, sourceId), new c(recommendId, recommend));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V1(boolean isNight) {
        if (!isAdded() || getView() == null) {
            return;
        }
        MTWebView mTWebView = ((FragmentWebviewBinding) n()).webview;
        NightModeChangeParams nightModeChangeParams = new NightModeChangeParams();
        nightModeChangeParams.setNightMode(isNight);
        Unit unit = Unit.INSTANCE;
        mTWebView.loadUrl(mTWebView.d(nightModeChangeParams));
    }

    @Override // com.martian.mibook.mvvm.ui.fragment.WebViewFragment
    public boolean W0(@l String sourceName, @l String sourceId) {
        return MiConfigSingleton.b2().M1().j0(sourceName, sourceId);
    }

    @Override // com.martian.mibook.mvvm.ui.fragment.WebViewFragment
    public void X0(boolean loginDirectly) {
        int i10 = loginDirectly ? 200 : 202;
        if (MiConfigSingleton.b2().C2()) {
            t0.b(getContext(), ExtKt.c("请先登录"));
            i10 = 10001;
        }
        MiConfigSingleton.b2().G1().j(getActivity(), i10);
    }

    public final void X1(int money, String productId, String extra) {
        I().q(money, productId, extra);
    }

    @Override // com.martian.mibook.mvvm.ui.fragment.WebViewFragment
    public void Z0(@l String r22, @l String value) {
        if (ba.l.q(r22) || ba.l.q(value)) {
            return;
        }
        a.a0(getActivity(), r22, value);
    }

    @Override // com.martian.mibook.mvvm.ui.fragment.WebViewFragment, com.martian.libmars.widget.MTWebView.c
    public void b(@l WebView view, @l String title) {
        super.b(view, title);
        b bVar = this.onWebViewEventListener;
        if (bVar != null) {
            bVar.b(view, title);
        }
    }

    @Override // com.martian.mibook.mvvm.ui.fragment.WebViewFragment
    public void close() {
        super.close();
        b bVar = this.onWebViewEventListener;
        if (bVar != null) {
            bVar.close();
        }
    }

    @Override // com.martian.mibook.mvvm.ui.fragment.WebViewFragment
    public void e1() {
    }

    @Override // com.martian.mibook.mvvm.ui.fragment.WebViewFragment
    public void g1(@l String sourceName, @l String sourceId) {
        if (ba.l.q(sourceName) || ba.l.q(sourceId)) {
            return;
        }
        i.G(getActivity(), sourceId, sourceName, "deeplink", "");
    }

    @Override // com.martian.mibook.mvvm.ui.fragment.WebViewFragment
    public void h1(@l String url, boolean fullscreen) {
        MiWebViewActivity.I5(getActivity(), url, false, "", false, "", fullscreen);
    }

    @Override // com.martian.mibook.mvvm.ui.fragment.WebViewFragment
    public void i1(int money, int r42, @l String productId, @l String extra) {
        if (MiConfigSingleton.b2().G1().f(getActivity())) {
            if (r42 == 1) {
                W1(money, productId, extra);
            } else if (g.p(getContext())) {
                X1(money, productId, extra);
            } else {
                t0.b(getContext(), "请先安装微信");
            }
        }
    }

    @Override // com.martian.mibook.mvvm.ui.fragment.WebViewFragment
    public void j1(@l String rechargeParams) {
        try {
            WebRechargeParams webRechargeParams = (WebRechargeParams) GsonUtils.b().fromJson(rechargeParams, WebRechargeParams.class);
            if (webRechargeParams != null) {
                Integer money = webRechargeParams.getMoney();
                Intrinsics.checkNotNullExpressionValue(money, "getMoney(...)");
                i1(money.intValue(), webRechargeParams.getMethod(), webRechargeParams.getProductId(), webRechargeParams.getExtra());
            } else {
                t0.b(getContext(), "数据解析出错");
            }
        } catch (Exception e10) {
            t0.b(getContext(), "数据解析出错");
            e10.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void l2(String orderJson) {
        ((FragmentWebviewBinding) n()).webview.loadUrl("javascript:rechargeResult(1, " + orderJson + ")");
    }

    public final void m2(boolean updateTaskAccount) {
        AppViewModel G;
        AppViewModel G2 = G();
        if (G2 != null) {
            AppViewModel.m0(G2, false, 1, null);
        }
        if (!updateTaskAccount || (G = G()) == null) {
            return;
        }
        G.n0();
    }

    @Override // com.martian.mibook.mvvm.ui.fragment.WebViewFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @l Intent r42) {
        super.onActivityResult(requestCode, resultCode, r42);
        if ((requestCode == 10001 || requestCode == 200 || requestCode == 1021 || requestCode == 202 || requestCode == 10025) && resultCode == -1) {
            s2();
        } else if (requestCode == 2 && resultCode == -1) {
            t0.b(getContext(), "分享成功");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        Context context;
        super.onDestroy();
        e9.c cVar = this.rxManager;
        if (cVar != null) {
            cVar.b();
        }
        this.rxManager = null;
        if (this.downLoadReceiver == null || (context = getContext()) == null) {
            return;
        }
        context.unregisterReceiver(this.downLoadReceiver);
    }

    public final void p2(@l b onWebViewEventListener) {
        this.onWebViewEventListener = onWebViewEventListener;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.mvvm.ui.fragment.WebViewFragment, com.martian.mibook.mvvm.base.BaseFragment
    public void q(@l Bundle savedInstanceState) {
        b bVar = this.onWebViewEventListener;
        if (bVar != null) {
            ((FragmentWebviewBinding) n()).refreshLayout.j0(bVar.a());
        }
        super.q(savedInstanceState);
        Integer webHeight = I().getWebHeight();
        if (webHeight != null) {
            ((FragmentWebviewBinding) n()).webview.getLayoutParams().height = webHeight.intValue();
        }
        if (g2()) {
            o2();
        }
        Y1();
        T1();
    }

    public final void q2(AliRechargeOrder aliRechargeOrder) {
        e8.a o10 = MiUserManager.o(aliRechargeOrder, f.n(Integer.valueOf(aliRechargeOrder.money)));
        if (o10 == null) {
            return;
        }
        e8.b.b(getActivity(), o10, new d(GsonUtils.b().toJson(aliRechargeOrder), aliRechargeOrder));
    }

    public final void r2(WXRechargeOrder tyRechargeWeixinOrder) {
        String valueOf = String.valueOf(tyRechargeWeixinOrder.money);
        PayReq p10 = MiUserManager.p(tyRechargeWeixinOrder);
        if (p10 == null) {
            t0.b(getContext(), "请求失败");
        } else {
            z7.b.d().x(getContext(), MiConfigSingleton.b2().c2().getRechargeWxAppid(), valueOf, p10, new e(GsonUtils.b().toJson(tyRechargeWeixinOrder), tyRechargeWeixinOrder));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void s2() {
        a.D(getContext(), "登录成功-网页内登录");
        f2();
        ((FragmentWebviewBinding) n()).webview.reload();
        m2(true);
    }
}
