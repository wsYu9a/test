package com.martian.mibook.mvvm.ui.fragment;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.appcompat.app.AlertDialog;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import ba.m;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.gyf.immersionbar.BarHide;
import com.kuaishou.weapon.p0.t;
import com.martian.libmars.R;
import com.martian.libmars.activity.PermissionActivity;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.widget.MTWebView;
import com.martian.libsupport.data.HeightChangeParams;
import com.martian.libxianplay.util.XianWanSystemUtil;
import com.martian.libxianplay.view.DownLoadService;
import com.martian.libxianplay.wowan.WowanDetailActivity;
import com.martian.mibook.databinding.FragmentWebviewBinding;
import com.martian.mibook.mvvm.base.BaseMVVMFragment;
import com.martian.mibook.mvvm.ui.fragment.WebViewFragment;
import com.martian.mibook.mvvm.ui.viewmodel.WebViewViewModel;
import com.martian.mibook.mvvm.utils.coroutine.Coroutine;
import com.scwang.smart.refresh.header.MaterialHeader;
import com.sigmob.sdk.base.k;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.umeng.analytics.pro.bt;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import l9.i0;
import l9.k0;
import l9.l0;
import l9.t0;
import xi.l;

@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b7\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0016\u0018\u0000 Â\u0001*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u00020\u0006:\u0007Ã\u0001>Ä\u0001Å\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0003¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0019\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u0019\u0010\u000eJ!\u0010\u001b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000bH\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\tH\u0002¢\u0006\u0004\b \u0010\bJ\u0019\u0010#\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0002¢\u0006\u0004\b#\u0010$J\u0019\u0010&\u001a\u0004\u0018\u00010\u000b2\u0006\u0010%\u001a\u00020!H\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\tH\u0016¢\u0006\u0004\b(\u0010\bJ\u0019\u0010+\u001a\u00020\t2\b\u0010*\u001a\u0004\u0018\u00010)H\u0017¢\u0006\u0004\b+\u0010,J\u0017\u0010.\u001a\u00020\t2\u0006\u0010-\u001a\u00020\u001dH\u0016¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\tH\u0016¢\u0006\u0004\b0\u0010\bJ\u000f\u00101\u001a\u00020\tH\u0005¢\u0006\u0004\b1\u0010\bJ\u0019\u00102\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b2\u0010\u000eJ#\u00104\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u00103\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b4\u00105J+\u00109\u001a\u00020\t2\u0006\u00106\u001a\u00020\u00142\b\u00107\u001a\u0004\u0018\u00010\u000b2\b\u00108\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b9\u0010:J#\u0010>\u001a\u00020\t2\b\u0010<\u001a\u0004\u0018\u00010;2\b\u0010=\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b>\u0010?J!\u0010A\u001a\u00020\t2\b\u0010<\u001a\u0004\u0018\u00010;2\u0006\u0010@\u001a\u00020\u0014H\u0016¢\u0006\u0004\bA\u0010BJ#\u0010C\u001a\u00020\u001d2\b\u0010<\u001a\u0004\u0018\u00010;2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\bC\u0010DJ\u0019\u0010E\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\bE\u0010\u000eJ+\u0010H\u001a\u00020\t2\b\u0010<\u001a\u0004\u0018\u00010;2\b\u0010F\u001a\u0004\u0018\u00010\u000b2\u0006\u0010G\u001a\u00020\u001dH\u0016¢\u0006\u0004\bH\u0010IJ-\u0010K\u001a\u00020\u001d2\b\u0010<\u001a\u0004\u0018\u00010;2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010J\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\bK\u0010LJ-\u0010O\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010M\u001a\u0004\u0018\u00010\u000b2\b\u0010N\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\bO\u0010PJ3\u0010U\u001a\u00020\t2\u000e\u0010R\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010Q2\b\u0010S\u001a\u0004\u0018\u00010\u000b2\b\u0010T\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\bU\u0010VJ9\u0010\\\u001a\u00020\t2\b\u0010W\u001a\u0004\u0018\u00010;2\u0014\u0010Y\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0X\u0018\u00010Q2\b\u0010[\u001a\u0004\u0018\u00010ZH\u0016¢\u0006\u0004\b\\\u0010]J-\u0010b\u001a\u00020\t2\b\u0010<\u001a\u0004\u0018\u00010;2\b\u0010_\u001a\u0004\u0018\u00010^2\b\u0010a\u001a\u0004\u0018\u00010`H\u0016¢\u0006\u0004\bb\u0010cJ/\u0010h\u001a\u00020\t2\u0006\u0010d\u001a\u00020\u00142\u0006\u0010e\u001a\u00020\u00142\u0006\u0010f\u001a\u00020\u00142\u0006\u0010g\u001a\u00020\u0014H\u0016¢\u0006\u0004\bh\u0010iJ\u000f\u0010j\u001a\u00020\tH\u0016¢\u0006\u0004\bj\u0010\bJ\r\u0010k\u001a\u00020\t¢\u0006\u0004\bk\u0010\bJ\u000f\u0010l\u001a\u00020\tH\u0014¢\u0006\u0004\bl\u0010\bJ\u0019\u0010n\u001a\u00020\t2\b\u0010m\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\bn\u0010\u000eJ\u0017\u0010p\u001a\u00020\t2\u0006\u0010o\u001a\u00020\u001dH\u0014¢\u0006\u0004\bp\u0010/J\u0019\u0010r\u001a\u00020\t2\b\u0010q\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\br\u0010\u000eJ\u000f\u0010s\u001a\u00020\tH\u0014¢\u0006\u0004\bs\u0010\bJ\u000f\u0010t\u001a\u00020\tH\u0014¢\u0006\u0004\bt\u0010\bJ\u000f\u0010u\u001a\u00020\tH\u0014¢\u0006\u0004\bu\u0010\bJ\u000f\u0010v\u001a\u00020\tH\u0014¢\u0006\u0004\bv\u0010\bJ\u000f\u0010w\u001a\u00020\tH\u0014¢\u0006\u0004\bw\u0010\bJ#\u0010z\u001a\u00020\t2\b\u0010x\u001a\u0004\u0018\u00010\u000b2\b\u0010y\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\bz\u0010\u001cJ\u0017\u0010|\u001a\u00020\t2\u0006\u0010{\u001a\u00020\u001dH\u0014¢\u0006\u0004\b|\u0010/J\u0019\u0010~\u001a\u00020\t2\b\u0010}\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b~\u0010\u000eJE\u0010\u0083\u0001\u001a\u00020\t2\b\u0010\u007f\u001a\u0004\u0018\u00010\u000b2\b\u0010}\u001a\u0004\u0018\u00010\u000b2\u0007\u0010\u0080\u0001\u001a\u00020\u00142\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\u001b\u0010\u0085\u0001\u001a\u00020\t2\b\u0010}\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0005\b\u0085\u0001\u0010\u000eJ&\u0010\u0087\u0001\u001a\u00020\t2\b\u0010=\u001a\u0004\u0018\u00010\u000b2\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0005\b\u0087\u0001\u0010\u001cJ'\u0010\u008a\u0001\u001a\u00020\t2\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0005\b\u008a\u0001\u0010\u001cJ\u001c\u0010\u008c\u0001\u001a\u00020\t2\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0005\b\u008c\u0001\u0010\u000eJ:\u0010\u0091\u0001\u001a\u00020\t2\u0007\u0010\u008d\u0001\u001a\u00020\u00142\u0007\u0010\u008e\u0001\u001a\u00020\u00142\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J%\u0010\u0094\u0001\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0007\u0010\u0093\u0001\u001a\u00020\u001dH\u0014¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J9\u0010\u009b\u0001\u001a\u00020\t2\u0007\u0010\u0096\u0001\u001a\u00020\u00142\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0099\u0001\u001a\u00030\u0098\u00012\u0007\u0010\u009a\u0001\u001a\u00020\u0014H\u0014¢\u0006\u0006\b\u009b\u0001\u0010\u009c\u0001J\u0011\u0010\u009d\u0001\u001a\u00020\tH\u0014¢\u0006\u0005\b\u009d\u0001\u0010\bJ\u0011\u0010\u009e\u0001\u001a\u00020\tH\u0014¢\u0006\u0005\b\u009e\u0001\u0010\bJE\u0010\u009f\u0001\u001a\u00020\t2\b\u0010\u007f\u001a\u0004\u0018\u00010\u000b2\b\u0010}\u001a\u0004\u0018\u00010\u000b2\u0007\u0010\u0080\u0001\u001a\u00020\u00142\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0006\b\u009f\u0001\u0010\u0084\u0001J&\u0010 \u0001\u001a\u00020\u001d2\b\u0010x\u001a\u0004\u0018\u00010\u000b2\b\u0010y\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0006\b \u0001\u0010¡\u0001J<\u0010¤\u0001\u001a\u00020\t2\b\u0010x\u001a\u0004\u0018\u00010\u000b2\b\u0010y\u001a\u0004\u0018\u00010\u000b2\t\u0010¢\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010£\u0001\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0006\b¤\u0001\u0010¥\u0001J\u0011\u0010¦\u0001\u001a\u00020\tH\u0014¢\u0006\u0005\b¦\u0001\u0010\bJ\u001e\u0010©\u0001\u001a\u00020\t2\n\u0010¨\u0001\u001a\u0005\u0018\u00010§\u0001H\u0014¢\u0006\u0006\b©\u0001\u0010ª\u0001J\u001b\u0010«\u0001\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0005\b«\u0001\u0010\u000eJ\u001b\u0010\u00ad\u0001\u001a\u00020\t2\u0007\u0010d\u001a\u00030¬\u0001H\u0016¢\u0006\u0006\b\u00ad\u0001\u0010®\u0001J0\u0010³\u0001\u001a\u00020\t2\u0007\u0010¯\u0001\u001a\u00020\u00142\u0007\u0010°\u0001\u001a\u00020\u00142\n\u0010²\u0001\u001a\u0005\u0018\u00010±\u0001H\u0016¢\u0006\u0006\b³\u0001\u0010´\u0001J\u001c\u0010¶\u0001\u001a\u00020\t2\t\u0010µ\u0001\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0005\b¶\u0001\u0010\u000eJ\u0011\u0010·\u0001\u001a\u00020\tH\u0014¢\u0006\u0005\b·\u0001\u0010\bR\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¸\u0001\u0010¹\u0001R\u001b\u0010»\u0001\u001a\u0005\u0018\u00010¬\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bd\u0010º\u0001R*\u0010Á\u0001\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b¼\u0001\u0010½\u0001\u001a\u0006\b¾\u0001\u0010¿\u0001\"\u0005\bÀ\u0001\u0010$¨\u0006Æ\u0001"}, d2 = {"Lcom/martian/mibook/mvvm/ui/fragment/WebViewFragment;", ExifInterface.GPS_DIRECTION_TRUE, "U", "Lcom/martian/mibook/mvvm/base/BaseMVVMFragment;", "Lcom/martian/mibook/databinding/FragmentWebviewBinding;", "Lcom/martian/mibook/mvvm/ui/viewmodel/WebViewViewModel;", "Lcom/martian/libmars/widget/MTWebView$c;", "<init>", "()V", "", "B0", "", "url", "t1", "(Ljava/lang/String;)V", "A1", "Landroid/graphics/Bitmap;", "bmp", r3.c.f30241d, "(Landroid/graphics/Bitmap;)V", "", "style", "z1", "(I)V", "packageName", "y1", "apkName", "x0", "(Ljava/lang/String;Ljava/lang/String;)V", "", "w0", "()Z", "n1", "Landroid/net/Uri;", "imgUri", "E0", "(Landroid/net/Uri;)V", "contentUri", "D0", "(Landroid/net/Uri;)Ljava/lang/String;", "i0", "Landroid/os/Bundle;", "savedInstanceState", "q", "(Landroid/os/Bundle;)V", "canRetryRefresh", "s1", "(Z)V", "F0", "G0", "N0", "favicon", "c0", "(Ljava/lang/String;Landroid/graphics/Bitmap;)V", MediationConstant.KEY_ERROR_CODE, "description", "failingUrl", "L", "(ILjava/lang/String;Ljava/lang/String;)V", "Landroid/webkit/WebView;", "view", "title", "b", "(Landroid/webkit/WebView;Ljava/lang/String;)V", "newProgress", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Landroid/webkit/WebView;I)V", "shouldOverrideUrlLoading", "(Landroid/webkit/WebView;Ljava/lang/String;)Z", "D", "deeplink", "canHandle", ExifInterface.LONGITUDE_EAST, "(Landroid/webkit/WebView;Ljava/lang/String;Z)V", b7.d.f1362o, "F", "(Landroid/webkit/WebView;Ljava/lang/String;Ljava/lang/String;)Z", "contentDisposition", IAdInterListener.AdReqParam.MIME_TYPE, "J", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/webkit/ValueCallback;", "callback", "acceptType", "capture", "K0", "(Landroid/webkit/ValueCallback;Ljava/lang/String;Ljava/lang/String;)V", "webView", "", "uploadMsg", "Landroid/webkit/WebChromeClient$FileChooserParams;", "fileChooserParams", "S0", "(Landroid/webkit/WebView;Landroid/webkit/ValueCallback;Landroid/webkit/WebChromeClient$FileChooserParams;)V", "Landroid/webkit/SslErrorHandler;", "handler", "Landroid/net/http/SslError;", "error", "onReceivedSslError", "(Landroid/webkit/WebView;Landroid/webkit/SslErrorHandler;Landroid/net/http/SslError;)V", t.f11204d, bt.aO, "oldl", "oldt", "onScrollChanged", "(IIII)V", "close", "o1", "e1", DBDefinition.SEGMENT_INFO, "k1", "loginDirectly", "X0", "wxAppid", "m1", "V0", "U0", "R0", "Q0", "T0", "sourceName", "sourceId", "g1", "open", "M0", "adsId", "c1", id.c.f26972i, "reward", "rewardName", "rewardExtra", "a1", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "b1", "extraBonus", "d1", PermissionActivity.f12046p, "value", "Z0", "rechargeParams", "j1", "money", h3.e.f26414s, "productId", "extra", "i1", "(IILjava/lang/String;Ljava/lang/String;)V", "fullscreen", "h1", "(Ljava/lang/String;Z)V", "coins", "errMsg", "", "extraId", "extraCoins", "f1", "(ILjava/lang/String;JI)V", "Y0", "P0", "O0", "W0", "(Ljava/lang/String;Ljava/lang/String;)Z", "recommendId", "recommend", "L0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "l1", "Ljava/io/File;", k.f18193y, "J0", "(Ljava/io/File;)V", "A0", "Lcom/martian/mibook/mvvm/ui/fragment/WebViewFragment$c;", "x1", "(Lcom/martian/mibook/mvvm/ui/fragment/WebViewFragment$c;)V", "requestCode", "resultCode", "Landroid/content/Intent;", h3.e.f26408m, "onActivityResult", "(IILandroid/content/Intent;)V", "dir", "q1", "r1", "k", "Ljava/lang/String;", "Lcom/martian/mibook/mvvm/ui/fragment/WebViewFragment$c;", "ivl", "m", "Landroid/net/Uri;", "C0", "()Landroid/net/Uri;", "w1", "mImgUri", "n", "a", "JsInterface", "c", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nWebViewFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebViewFragment.kt\ncom/martian/mibook/mvvm/ui/fragment/WebViewFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1192:1\n1#2:1193\n*E\n"})
/* loaded from: classes3.dex */
public class WebViewFragment<T, U> extends BaseMVVMFragment<FragmentWebviewBinding, WebViewViewModel> implements MTWebView.c {

    /* renamed from: o */
    @xi.k
    public static final String f15234o = "LIBMARS_INTENT_WEBVIEW_URL";

    /* renamed from: p */
    @xi.k
    public static final String f15235p = "INTENT_WEBVIEW_SHARE_URL";

    /* renamed from: q */
    @xi.k
    public static final String f15236q = "LIBMARS_INTENT_DOWNLOAD_HINT";

    /* renamed from: r */
    @xi.k
    public static final String f15237r = "INTENT_SHAREABLE";

    /* renamed from: s */
    @xi.k
    public static final String f15238s = "INTENT_FULLSCREEN";

    /* renamed from: t */
    @xi.k
    public static final String f15239t = "INTENT_WEB_HEIGHT";

    /* renamed from: u */
    @xi.k
    public static final String f15240u = "INTENT_SHARE_IMAGE_URL";

    /* renamed from: v */
    @xi.k
    public static final String f15241v = "INTENT_WEBVIEW_URL_REFERER";

    /* renamed from: w */
    public static final int f15242w = 885;

    /* renamed from: x */
    public static final int f15243x = 886;

    /* renamed from: k, reason: from kotlin metadata */
    @l
    public String apkName;

    /* renamed from: l */
    @l
    public c ivl;

    /* renamed from: m, reason: from kotlin metadata */
    @l
    public Uri mImgUri;

    public final class JsInterface {
        public JsInterface() {
        }

        public static final void c(WebViewFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            WebViewFragment.r0(this$0).webview.loadUrl("javascript:CheckInstall_Return(1)");
        }

        public static final void d(WebViewFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            WebViewFragment.r0(this$0).webview.loadUrl("javascript:CheckInstall_Return(0)");
        }

        @JavascriptInterface
        @SuppressLint({"JavascriptInterface"})
        public final void Browser(@l String str) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(WebViewFragment.this), Dispatchers.getMain(), null, new WebViewFragment$JsInterface$Browser$1(str, WebViewFragment.this, null), 2, null);
        }

        @JavascriptInterface
        @SuppressLint({"JavascriptInterface"})
        public final void CheckInstall(@l String str) {
            if (XianWanSystemUtil.isApkInstalled(WebViewFragment.this.getContext(), str)) {
                WebViewFragment.r0(WebViewFragment.this).webview.post(new Runnable() { // from class: pd.m
                    public /* synthetic */ m() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        WebViewFragment.JsInterface.c(WebViewFragment.this);
                    }
                });
            } else {
                WebViewFragment.r0(WebViewFragment.this).webview.post(new Runnable() { // from class: pd.n
                    public /* synthetic */ n() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        WebViewFragment.JsInterface.d(WebViewFragment.this);
                    }
                });
            }
        }

        @JavascriptInterface
        @SuppressLint({"JavascriptInterface"})
        public final void InstallAPP(@xi.k String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(WebViewFragment.this), Dispatchers.getMain(), null, new WebViewFragment$JsInterface$InstallAPP$1(url, WebViewFragment.this, null), 2, null);
        }

        @JavascriptInterface
        @SuppressLint({"JavascriptInterface"})
        public final void OpenAPP(@l String str) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(WebViewFragment.this), Dispatchers.getMain(), null, new WebViewFragment$JsInterface$OpenAPP$1(WebViewFragment.this, str, null), 2, null);
        }

        @JavascriptInterface
        public final void addToBookStore(@l String str, @l String str2, @l String str3, @l String str4) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(WebViewFragment.this), Dispatchers.getMain(), null, new WebViewFragment$JsInterface$addToBookStore$1(WebViewFragment.this, str, str2, str3, str4, null), 2, null);
        }

        @JavascriptInterface
        public final boolean appInstalled(@l String str) {
            if (ba.l.q(str)) {
                return false;
            }
            Context context = WebViewFragment.this.getContext();
            Intent intent = null;
            PackageManager packageManager = context != null ? context.getPackageManager() : null;
            if (packageManager != null) {
                Intrinsics.checkNotNull(str);
                intent = packageManager.getLaunchIntentForPackage(str);
            }
            return intent != null;
        }

        @JavascriptInterface
        public final void bonusMode(boolean z10) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(WebViewFragment.this), Dispatchers.getMain(), null, new WebViewFragment$JsInterface$bonusMode$1(WebViewFragment.this, z10, null), 2, null);
        }

        @JavascriptInterface
        public final void cacheVideoAd(@l String str, @l String str2, int i10, @l String str3, @l String str4) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(WebViewFragment.this), Dispatchers.getMain(), null, new WebViewFragment$JsInterface$cacheVideoAd$1(WebViewFragment.this, str, str2, i10, str3, str4, null), 2, null);
        }

        @JavascriptInterface
        public final void exitWeb() {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(WebViewFragment.this), Dispatchers.getMain(), null, new WebViewFragment$JsInterface$exitWeb$1(WebViewFragment.this, null), 2, null);
        }

        @JavascriptInterface
        public final void goNotificationSetting() {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(WebViewFragment.this), Dispatchers.getMain(), null, new WebViewFragment$JsInterface$goNotificationSetting$1(WebViewFragment.this, null), 2, null);
        }

        @JavascriptInterface
        public final void inviteQqfriend() {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(WebViewFragment.this), Dispatchers.getMain(), null, new WebViewFragment$JsInterface$inviteQqfriend$1(WebViewFragment.this, null), 2, null);
        }

        @JavascriptInterface
        public final void inviteQrcode() {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(WebViewFragment.this), Dispatchers.getMain(), null, new WebViewFragment$JsInterface$inviteQrcode$1(WebViewFragment.this, null), 2, null);
        }

        @JavascriptInterface
        public final void inviteQzone() {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(WebViewFragment.this), Dispatchers.getMain(), null, new WebViewFragment$JsInterface$inviteQzone$1(WebViewFragment.this, null), 2, null);
        }

        @JavascriptInterface
        public final void inviteWxcircle() {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(WebViewFragment.this), Dispatchers.getMain(), null, new WebViewFragment$JsInterface$inviteWxcircle$1(WebViewFragment.this, null), 2, null);
        }

        @JavascriptInterface
        public final void inviteWxfriend() {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(WebViewFragment.this), Dispatchers.getMain(), null, new WebViewFragment$JsInterface$inviteWxfriend$1(WebViewFragment.this, null), 2, null);
        }

        @JavascriptInterface
        public final boolean isInBookStore(@l String str, @l String str2) {
            return WebViewFragment.this.W0(str, str2);
        }

        @JavascriptInterface
        public final void loginClick() {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(WebViewFragment.this), Dispatchers.getMain(), null, new WebViewFragment$JsInterface$loginClick$1(WebViewFragment.this, null), 2, null);
        }

        @JavascriptInterface
        public final void loginClickV2(boolean z10) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(WebViewFragment.this), Dispatchers.getMain(), null, new WebViewFragment$JsInterface$loginClickV2$1(WebViewFragment.this, z10, null), 2, null);
        }

        @JavascriptInterface
        public final void logout() {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(WebViewFragment.this), Dispatchers.getMain(), null, new WebViewFragment$JsInterface$logout$1(WebViewFragment.this, null), 2, null);
        }

        @JavascriptInterface
        public final void marketRate() {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(WebViewFragment.this), Dispatchers.getMain(), null, new WebViewFragment$JsInterface$marketRate$1(WebViewFragment.this, null), 2, null);
        }

        @JavascriptInterface
        public final void onBackClick() {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(WebViewFragment.this), Dispatchers.getMain(), null, new WebViewFragment$JsInterface$onBackClick$1(WebViewFragment.this, null), 2, null);
        }

        @JavascriptInterface
        public final void onEvent(@l String str, @l String str2) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(WebViewFragment.this), Dispatchers.getMain(), null, new WebViewFragment$JsInterface$onEvent$1(WebViewFragment.this, str, str2, null), 2, null);
        }

        @JavascriptInterface
        @SuppressLint({"JavascriptInterface"})
        public final void openAdDetail(@l String str) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(WebViewFragment.this), Dispatchers.getMain(), null, new WebViewFragment$JsInterface$openAdDetail$1(str, WebViewFragment.this, null), 2, null);
        }

        @JavascriptInterface
        public final void playCallbackRewardVideoAd(@l String str, @l String str2, int i10, @l String str3, @l String str4) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(WebViewFragment.this), Dispatchers.getMain(), null, new WebViewFragment$JsInterface$playCallbackRewardVideoAd$1(WebViewFragment.this, str, str2, i10, str3, str4, null), 2, null);
        }

        @JavascriptInterface
        public final void playInteractionAd() {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(WebViewFragment.this), Dispatchers.getMain(), null, new WebViewFragment$JsInterface$playInteractionAd$1(WebViewFragment.this, null), 2, null);
        }

        @JavascriptInterface
        public final void playRewardVideoAd() {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(WebViewFragment.this), Dispatchers.getMain(), null, new WebViewFragment$JsInterface$playRewardVideoAd$1(WebViewFragment.this, null), 2, null);
        }

        @JavascriptInterface
        public final void rewardDetail(@l String str, @l String str2) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(WebViewFragment.this), Dispatchers.getMain(), null, new WebViewFragment$JsInterface$rewardDetail$1(WebViewFragment.this, str, str2, null), 2, null);
        }

        @JavascriptInterface
        public final void setResultOk() {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(WebViewFragment.this), Dispatchers.getMain(), null, new WebViewFragment$JsInterface$setResultOk$1(WebViewFragment.this, null), 2, null);
        }

        @JavascriptInterface
        public final void shareClick() {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(WebViewFragment.this), Dispatchers.getMain(), null, new WebViewFragment$JsInterface$shareClick$1(WebViewFragment.this, null), 2, null);
        }

        @JavascriptInterface
        public final void showBonusDialog(int i10, @l String str, long j10, int i11) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(WebViewFragment.this), Dispatchers.getMain(), null, new WebViewFragment$JsInterface$showBonusDialog$1(WebViewFragment.this, i10, str, j10, i11, null), 2, null);
        }

        @JavascriptInterface
        public final void showSoftKeyboard() {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(WebViewFragment.this), Dispatchers.getMain(), null, new WebViewFragment$JsInterface$showSoftKeyboard$1(WebViewFragment.this, null), 2, null);
        }

        @JavascriptInterface
        public final void startBookDetailActivity(@l String str, @l String str2) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(WebViewFragment.this), Dispatchers.getMain(), null, new WebViewFragment$JsInterface$startBookDetailActivity$1(WebViewFragment.this, str, str2, null), 2, null);
        }

        @JavascriptInterface
        public final void startNewActivity(@l String str, boolean z10) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(WebViewFragment.this), Dispatchers.getMain(), null, new WebViewFragment$JsInterface$startNewActivity$1(WebViewFragment.this, str, z10, null), 2, null);
        }

        @JavascriptInterface
        @SuppressLint({"JavascriptInterface"})
        public final void startRecharge(int i10, int i11) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(WebViewFragment.this), Dispatchers.getMain(), null, new WebViewFragment$JsInterface$startRecharge$1(WebViewFragment.this, i10, i11, null), 2, null);
        }

        @JavascriptInterface
        public final void startRechargeV2(int i10, int i11, @l String str) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(WebViewFragment.this), Dispatchers.getMain(), null, new WebViewFragment$JsInterface$startRechargeV2$1(WebViewFragment.this, i10, i11, str, null), 2, null);
        }

        @JavascriptInterface
        public final void startRechargeV3(@l String str) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(WebViewFragment.this), Dispatchers.getMain(), null, new WebViewFragment$JsInterface$startRechargeV3$1(WebViewFragment.this, str, null), 2, null);
        }

        @JavascriptInterface
        public final void startShare(@l String str) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(WebViewFragment.this), Dispatchers.getMain(), null, new WebViewFragment$JsInterface$startShare$1(WebViewFragment.this, str, null), 2, null);
        }

        @JavascriptInterface
        public final void statusBarStyle(int i10) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(WebViewFragment.this), Dispatchers.getMain(), null, new WebViewFragment$JsInterface$statusBarStyle$1(WebViewFragment.this, i10, null), 2, null);
        }

        @xi.k
        @JavascriptInterface
        @SuppressLint({"JavascriptInterface"})
        public String toString() {
            return "android";
        }

        @JavascriptInterface
        public final void ttsSetting() {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(WebViewFragment.this), Dispatchers.getMain(), null, new WebViewFragment$JsInterface$ttsSetting$1(WebViewFragment.this, null), 2, null);
        }

        @JavascriptInterface
        public final void wxBindV2(@l String str) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(WebViewFragment.this), Dispatchers.getMain(), null, new WebViewFragment$JsInterface$wxBindV2$1(WebViewFragment.this, str, null), 2, null);
        }

        @JavascriptInterface
        public final void playInteractionAd(@l String str) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(WebViewFragment.this), Dispatchers.getMain(), null, new WebViewFragment$JsInterface$playInteractionAd$2(WebViewFragment.this, str, null), 2, null);
        }

        @JavascriptInterface
        public final void playRewardVideoAd(@l String str) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(WebViewFragment.this), Dispatchers.getMain(), null, new WebViewFragment$JsInterface$playRewardVideoAd$2(WebViewFragment.this, str, null), 2, null);
        }
    }

    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: b */
        @xi.k
        public final MTWebView f15248b;

        /* renamed from: c */
        public int f15249c;

        public b(@xi.k MTWebView webview) {
            Intrinsics.checkNotNullParameter(webview, "webview");
            this.f15248b = webview;
            webview.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Rect rect = new Rect();
            this.f15248b.getWindowVisibleDisplayFrame(rect);
            int i10 = rect.bottom - rect.top;
            if (this.f15249c == i10) {
                return;
            }
            Rect rect2 = new Rect();
            this.f15248b.getHitRect(rect2);
            int i11 = rect2.bottom - rect2.top;
            int i12 = this.f15249c;
            float f10 = (i12 <= 0 || i12 <= i10 || i11 == 0) ? 0.0f : ((i12 - i10) * 100.0f) / i11;
            this.f15249c = i10;
            MTWebView mTWebView = this.f15248b;
            mTWebView.loadUrl(mTWebView.d(new HeightChangeParams().setRatio(f10)));
        }
    }

    public interface c {
        void a(@l Uri uri, @l String str);

        void onCancelled();
    }

    public static final class d implements View.OnTouchListener {

        /* renamed from: b */
        public float f15250b;

        /* renamed from: c */
        public float f15251c;

        /* renamed from: d */
        public final /* synthetic */ WebViewFragment<T, U> f15252d;

        /* renamed from: e */
        public final /* synthetic */ int f15253e;

        /* renamed from: f */
        public final /* synthetic */ int f15254f;

        public d(WebViewFragment<T, U> webViewFragment, int i10, int i11) {
            this.f15252d = webViewFragment;
            this.f15253e = i10;
            this.f15254f = i11;
        }

        public final float a() {
            return this.f15250b;
        }

        public final float b() {
            return this.f15251c;
        }

        public final void c(float f10) {
            this.f15250b = f10;
        }

        public final void d(float f10) {
            this.f15251c = f10;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(@l View view, @l MotionEvent motionEvent) {
            Integer valueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
            if (valueOf != null && valueOf.intValue() == 0) {
                this.f15250b = motionEvent.getX();
                this.f15251c = motionEvent.getY();
                WebViewFragment.r0(this.f15252d).refreshLayout.getParent().requestDisallowInterceptTouchEvent(true);
            } else {
                if (valueOf != null && valueOf.intValue() == 5) {
                    return true;
                }
                if (valueOf != null && valueOf.intValue() == 2) {
                    float x10 = motionEvent.getX() - this.f15250b;
                    float y10 = motionEvent.getY() - this.f15251c;
                    if (Math.abs(x10) > this.f15253e || Math.abs(y10) > this.f15254f) {
                        if (Math.abs(x10) > Math.abs(y10)) {
                            WebViewFragment.r0(this.f15252d).refreshLayout.getParent().requestDisallowInterceptTouchEvent(true);
                        } else if (Math.abs(y10) > this.f15254f) {
                            WebViewFragment.r0(this.f15252d).refreshLayout.getParent().requestDisallowInterceptTouchEvent(false);
                        }
                    }
                } else if ((valueOf != null && valueOf.intValue() == 1) || (valueOf != null && valueOf.intValue() == 3)) {
                    WebViewFragment.r0(this.f15252d).refreshLayout.getParent().requestDisallowInterceptTouchEvent(false);
                }
            }
            return false;
        }
    }

    public static final class e implements c {

        /* renamed from: a */
        public final /* synthetic */ ValueCallback<Uri> f15255a;

        public e(ValueCallback<Uri> valueCallback) {
            this.f15255a = valueCallback;
        }

        @Override // com.martian.mibook.mvvm.ui.fragment.WebViewFragment.c
        public void a(@l Uri uri, @l String str) {
            ValueCallback<Uri> valueCallback = this.f15255a;
            if (valueCallback != null) {
                valueCallback.onReceiveValue(uri);
            }
        }

        @Override // com.martian.mibook.mvvm.ui.fragment.WebViewFragment.c
        public void onCancelled() {
            ValueCallback<Uri> valueCallback = this.f15255a;
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
            }
        }
    }

    public static final class f implements i0.o {

        /* renamed from: a */
        public final /* synthetic */ WebViewFragment<T, U> f15256a;

        public f(WebViewFragment<T, U> webViewFragment) {
            this.f15256a = webViewFragment;
        }

        @Override // l9.i0.o
        public void a() {
        }

        @Override // l9.i0.o
        public void b() {
            this.f15256a.q1(ba.b.d());
        }

        @Override // l9.i0.o
        public void c() {
            this.f15256a.r1();
        }
    }

    public static final class g implements c {

        /* renamed from: a */
        public final /* synthetic */ ValueCallback<Uri[]> f15257a;

        public g(ValueCallback<Uri[]> valueCallback) {
            this.f15257a = valueCallback;
        }

        @Override // com.martian.mibook.mvvm.ui.fragment.WebViewFragment.c
        public void a(@l Uri uri, @l String str) {
            ValueCallback<Uri[]> valueCallback = this.f15257a;
            if (valueCallback != null) {
                valueCallback.onReceiveValue(uri == null ? new Uri[0] : new Uri[]{uri});
            }
        }

        @Override // com.martian.mibook.mvvm.ui.fragment.WebViewFragment.c
        public void onCancelled() {
            ValueCallback<Uri[]> valueCallback = this.f15257a;
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
            }
        }
    }

    private final void A1(String url) {
        Coroutine.onSuccess$default(Coroutine.Companion.async$default(Coroutine.INSTANCE, null, null, null, null, new WebViewFragment$url2bitmap$1(url, null), 15, null), null, new WebViewFragment$url2bitmap$2(this, null), 1, null);
    }

    private final String D0(Uri contentUri) {
        return l0.b(getContext(), contentUri);
    }

    private final void E0(Uri imgUri) {
        if (imgUri != null) {
            String D0 = Intrinsics.areEqual("content", imgUri.getScheme()) ? D0(imgUri) : imgUri.getPath();
            c cVar = this.ivl;
            if (cVar != null) {
                cVar.a(imgUri, D0);
            }
        } else {
            c cVar2 = this.ivl;
            if (cVar2 != null) {
                cVar2.onCancelled();
            }
        }
        this.mImgUri = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean H0(WebViewFragment this$0, View view) {
        String extra;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (ConfigSingleton.D().y0() || !ConfigSingleton.D().V0()) {
            return true;
        }
        WebView.HitTestResult hitTestResult = ((FragmentWebviewBinding) this$0.n()).webview.getHitTestResult();
        Intrinsics.checkNotNullExpressionValue(hitTestResult, "getHitTestResult(...)");
        if (hitTestResult.getType() != 5 || (extra = hitTestResult.getExtra()) == null) {
            return false;
        }
        this$0.t1(extra);
        return false;
    }

    public static final void I0(WebViewFragment this$0, pf.f it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.s1(true);
    }

    private final void n1() {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:com.android.providers.downloads"));
            startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
        }
    }

    public static final void p1(WebViewFragment this$0, String name, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(name, "name");
        t0.b(this$0.getContext(), "已开始下载" + name);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ FragmentWebviewBinding r0(WebViewFragment webViewFragment) {
        return (FragmentWebviewBinding) webViewFragment.n();
    }

    private final void t1(String url) {
        if (ba.l.q(url)) {
            return;
        }
        i0.z0(getActivity(), "确认信息", "保存这张图片？", new i0.l() { // from class: pd.j

            /* renamed from: b */
            public final /* synthetic */ String f29869b;

            public /* synthetic */ j(String url2) {
                url = url2;
            }

            @Override // l9.i0.l
            public final void a() {
                WebViewFragment.u1(WebViewFragment.this, url);
            }
        });
    }

    public static final void u1(WebViewFragment this$0, String url) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(url, "$url");
        this$0.A1(url);
    }

    public final void v1(Bitmap bitmap) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "Boohee");
        if (file.exists() || file.mkdir()) {
            File file2 = new File(file, System.currentTimeMillis() + ".jpg");
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                t0.b(getContext(), "图片已保存到相册");
            } catch (FileNotFoundException e10) {
                t0.b(getContext(), "保存失败");
                e10.printStackTrace();
            } catch (IOException e11) {
                t0.b(getContext(), "保存失败");
                e11.printStackTrace();
            }
            Context context = getContext();
            if (context != null) {
                context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + file2.getAbsolutePath())));
            }
        }
    }

    private final boolean w0() {
        PackageManager packageManager;
        try {
            Context context = getContext();
            Integer valueOf = (context == null || (packageManager = context.getPackageManager()) == null) ? null : Integer.valueOf(packageManager.getApplicationEnabledSetting("com.android.providers.downloads"));
            if (valueOf != null && valueOf.intValue() == 2) {
                return false;
            }
            if (valueOf.intValue() == 3) {
                return false;
            }
            if (valueOf != null) {
                if (valueOf.intValue() == 4) {
                    return false;
                }
            }
            return true;
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    @SuppressLint({"Range"})
    public final void x0(String url, String apkName) {
        DownloadManager.Query query = new DownloadManager.Query();
        Context context = getContext();
        Object systemService = context != null ? context.getSystemService("download") : null;
        DownloadManager downloadManager = systemService instanceof DownloadManager ? (DownloadManager) systemService : null;
        boolean z10 = false;
        if (downloadManager != null) {
            Cursor query2 = downloadManager.query(query);
            while (true) {
                try {
                    try {
                        if (!query2.moveToNext()) {
                            break;
                        }
                        if (Intrinsics.areEqual(url, query2.getString(query2.getColumnIndex("uri")))) {
                            try {
                                int i10 = query2.getInt(query2.getColumnIndex("status"));
                                if (i10 == 1 || i10 == 2 || i10 == 4) {
                                    Context context2 = getContext();
                                    t0.b(context2, "正在下载，已完成" + ((int) ((query2.getInt(query2.getColumnIndex("bytes_so_far")) * 100) / query2.getInt(query2.getColumnIndex("total_size")))) + "%");
                                } else if (i10 == 8) {
                                    if (TextUtils.isEmpty(apkName)) {
                                        query2.close();
                                        return;
                                    }
                                    File i11 = ba.b.i();
                                    Intrinsics.checkNotNull(apkName);
                                    File file = new File(i11, apkName);
                                    if (file.exists()) {
                                        J0(file);
                                    }
                                }
                            } catch (Exception unused) {
                            }
                            z10 = true;
                        }
                    } catch (Exception unused2) {
                    }
                } catch (Throwable th2) {
                    query2.close();
                    throw th2;
                }
            }
            query2.close();
        }
        if (z10) {
            return;
        }
        if (!w0()) {
            n1();
            return;
        }
        Context context3 = getContext();
        XianWanSystemUtil.NetState netWorkType = XianWanSystemUtil.getNetWorkType(context3 != null ? context3.getApplicationContext() : null);
        if (netWorkType == XianWanSystemUtil.NetState.NET_NO) {
            t0.b(getContext(), "现在还没有网哦！");
            return;
        }
        if (netWorkType != XianWanSystemUtil.NetState.NET_MOBILE) {
            t0.b(getContext(), "开始下载");
            DownLoadService.startActionFoo(getContext(), url);
            return;
        }
        Context context4 = getContext();
        if (context4 != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context4);
            builder.setTitle("温馨提醒");
            builder.setMessage("您现在使用的是非WiFi流量,是否继续?");
            builder.setPositiveButton("继续下载", new DialogInterface.OnClickListener() { // from class: pd.h

                /* renamed from: b */
                public final /* synthetic */ Context f29866b;

                /* renamed from: c */
                public final /* synthetic */ String f29867c;

                public /* synthetic */ h(Context context42, String url2) {
                    context4 = context42;
                    url = url2;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i12) {
                    WebViewFragment.y0(context4, url, dialogInterface, i12);
                }
            });
            builder.setNegativeButton("取消", new DialogInterface.OnClickListener() { // from class: pd.i
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i12) {
                    WebViewFragment.z0(dialogInterface, i12);
                }
            });
            builder.show();
        }
    }

    public static final void y0(Context it, String url, DialogInterface dialogInterface, int i10) {
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(url, "$url");
        t0.b(it, "开始下载");
        DownLoadService.startActionFoo(it, url);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0026 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void y1(java.lang.String r4) {
        /*
            r3 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 == 0) goto L7
            return
        L7:
            android.content.Context r0 = r3.getContext()
            r1 = 0
            if (r0 == 0) goto L13
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            goto L14
        L13:
            r0 = r1
        L14:
            if (r0 == 0) goto L23
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L1f
            r2 = 0
            android.content.pm.PackageInfo r2 = r0.getPackageInfo(r4, r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L1f
            goto L24
        L1f:
            r2 = move-exception
            r2.printStackTrace()
        L23:
            r2 = r1
        L24:
            if (r2 != 0) goto L27
            return
        L27:
            if (r0 == 0) goto L30
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            android.content.Intent r1 = r0.getLaunchIntentForPackage(r4)
        L30:
            if (r1 == 0) goto L40
            java.lang.String r4 = "android.intent.category.LAUNCHER"
            r1.addCategory(r4)
            r4 = 270532608(0x10200000, float:3.1554436E-29)
            r1.setFlags(r4)
            r3.startActivity(r1)
            goto L49
        L40:
            android.content.Context r4 = r3.getContext()
            java.lang.String r0 = "手机还未安装该应用"
            l9.t0.b(r4, r0)
        L49:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.ui.fragment.WebViewFragment.y1(java.lang.String):void");
    }

    public static final void z0(DialogInterface dialogInterface, int i10) {
    }

    public final void z1(int style) {
        String mUrl;
        String mUrl2;
        if (style != 2) {
            boolean z10 = false;
            if (style >= 0 || (mUrl2 = I().getMUrl()) == null || !StringsKt.contains$default((CharSequence) mUrl2, (CharSequence) "statusBarStyle=2", false, 2, (Object) null)) {
                com.gyf.immersionbar.d A3 = com.gyf.immersionbar.d.A3(this);
                if (style == 1 || (style < 0 && (mUrl = I().getMUrl()) != null && StringsKt.contains$default((CharSequence) mUrl, (CharSequence) "statusBarStyle=1", false, 2, (Object) null))) {
                    z10 = true;
                }
                A3.T2(z10).a1();
                return;
            }
        }
        com.gyf.immersionbar.d.A3(this).W0(BarHide.FLAG_HIDE_STATUS_BAR).a1();
    }

    public void A0(@l String url) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"ClickableViewAccessibility"})
    public final void B0() {
        Context context = getContext();
        if (context != null) {
            int scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
            ((FragmentWebviewBinding) n()).webview.setOnTouchListener(new d(this, scaledTouchSlop, scaledTouchSlop * 2));
        }
    }

    @l
    /* renamed from: C0, reason: from getter */
    public final Uri getMImgUri() {
        return this.mImgUri;
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void D(@l String url) {
        A0(url);
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void E(@l WebView webView, @l String str, boolean z10) {
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public boolean F(@l WebView view, @l String url, @l String r32) {
        return false;
    }

    public void F0() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            I().E(arguments.getString("LIBMARS_INTENT_WEBVIEW_URL"));
            I().C(arguments.getBoolean("LIBMARS_INTENT_DOWNLOAD_HINT", true));
            I().D(arguments.getString("INTENT_WEBVIEW_URL_REFERER"));
            I().B(arguments.getBoolean("INTENT_FULLSCREEN", false));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    public final void G0() {
        JsInterface jsInterface = new JsInterface();
        ((FragmentWebviewBinding) n()).webview.addJavascriptInterface(jsInterface, jsInterface.toString());
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void J(@l String url, @l String contentDisposition, @l String r92) {
        k0.d(getActivity(), url, contentDisposition, r92, new k0.a() { // from class: pd.g
            public /* synthetic */ g() {
            }

            @Override // l9.k0.a
            public final void a(String str, String str2) {
                WebViewFragment.p1(WebViewFragment.this, str, str2);
            }
        }, I().getMDownloadHint());
    }

    public void J0(@l File r42) {
        ApplicationInfo applicationInfo;
        if (r42 == null || !r42.exists()) {
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        Uri z10 = ba.g.z(getContext(), r42);
        if (z10 == null) {
            return;
        }
        intent.setFlags(268435456);
        Context context = getContext();
        int i10 = (context == null || (applicationInfo = context.getApplicationInfo()) == null) ? 0 : applicationInfo.targetSdkVersion;
        if (m.o() && i10 >= 24) {
            intent.addFlags(1);
        }
        intent.setDataAndType(z10, "application/vnd.android.package-archive");
        startActivity(intent);
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void K0(@l ValueCallback<Uri> callback, @l String acceptType, @l String capture) {
        x1(new e(callback));
        i0.H0(getActivity(), "选择图片", "从相册选择", "拍照选择", false, new f(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.libmars.widget.MTWebView.c
    public void L(int r12, @l String description, @l String failingUrl) {
        ((FragmentWebviewBinding) n()).refreshLayout.W(false);
    }

    public void L0(@l String sourceName, @l String sourceId, @l String recommendId, @l String recommend) {
    }

    public void M0(boolean open) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.libmars.widget.MTWebView.c
    public void N0(@l String url) {
        ((FragmentWebviewBinding) n()).refreshLayout.p();
    }

    public void O0(@l String r12, @l String adsId, int reward, @l String rewardName, @l String rewardExtra) {
    }

    public void P0() {
    }

    public void Q0() {
    }

    public void R0() {
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void S0(@l WebView webView, @l ValueCallback<Uri[]> uploadMsg, @l WebChromeClient.FileChooserParams fileChooserParams) {
        x1(new g(uploadMsg));
        r1();
    }

    public void T0() {
    }

    public void U0() {
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void V(@l WebView webView, int i10) {
    }

    public void V0() {
    }

    public boolean W0(@l String sourceName, @l String sourceId) {
        return false;
    }

    public void X0(boolean loginDirectly) {
    }

    public void Y0() {
    }

    public void Z0(@l String r12, @l String value) {
    }

    public void a1(@l String r12, @l String adsId, int reward, @l String rewardName, @l String rewardExtra) {
    }

    public void b(@l WebView view, @l String title) {
    }

    public void b1(@l String adsId) {
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void c0(@l String url, @l Bitmap favicon) {
    }

    public void c1(@l String adsId) {
    }

    public void close() {
    }

    public void d1(@l String title, @l String extraBonus) {
    }

    public void e1() {
    }

    public void f1(int coins, @l String errMsg, long extraId, int extraCoins) {
    }

    public void g1(@l String sourceName, @l String sourceId) {
    }

    public void h1(@l String url, boolean fullscreen) {
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMFragment
    public void i0() {
    }

    public void i1(int money, int r22, @l String productId, @l String extra) {
    }

    public void j1(@l String rechargeParams) {
    }

    public void k1(@l String r12) {
    }

    public void l1() {
    }

    public void m1(@l String wxAppid) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void o1() {
        if (((FragmentWebviewBinding) n()).webview.canGoBack()) {
            ((FragmentWebviewBinding) n()).webview.goBack();
        } else {
            close();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @l Intent r52) {
        super.onActivityResult(requestCode, resultCode, r52);
        if (requestCode == 885 && resultCode == -1) {
            E0(this.mImgUri);
        } else if (requestCode == 886 && resultCode == -1) {
            Uri data = r52 != null ? r52.getData() : null;
            this.mImgUri = data;
            E0(data);
        }
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void onReceivedSslError(@l WebView view, @l SslErrorHandler handler, @l SslError error) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.libmars.widget.MTWebView.c
    public void onScrollChanged(int r12, int r22, int oldl, int oldt) {
        ((FragmentWebviewBinding) n()).refreshLayout.setEnabled(((FragmentWebviewBinding) n()).webview.getScrollY() == 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.mvvm.base.BaseFragment
    @SuppressLint({"ClickableViewAccessibility"})
    public void q(@l Bundle savedInstanceState) {
        F0();
        B0();
        ((FragmentWebviewBinding) n()).webview.setOnPageStateChangedListener(this);
        ((FragmentWebviewBinding) n()).webview.setOnLongClickListener(new View.OnLongClickListener() { // from class: pd.k
            public /* synthetic */ k() {
            }

            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean H0;
                H0 = WebViewFragment.H0(WebViewFragment.this, view);
                return H0;
            }
        });
        MTWebView webview = ((FragmentWebviewBinding) n()).webview;
        Intrinsics.checkNotNullExpressionValue(webview, "webview");
        new b(webview);
        G0();
        MaterialHeader materialHeader = new MaterialHeader(getContext());
        materialHeader.b(getResources().getColor(R.color.theme_default));
        ((FragmentWebviewBinding) n()).refreshLayout.O(materialHeader);
        ((FragmentWebviewBinding) n()).refreshLayout.E(new sf.g() { // from class: pd.l
            public /* synthetic */ l() {
            }

            @Override // sf.g
            public final void b(pf.f fVar) {
                WebViewFragment.I0(WebViewFragment.this, fVar);
            }
        });
        if (TextUtils.isEmpty(I().getMUrl())) {
            t0.b(getContext(), "无效的URL");
            close();
        } else if (ba.l.q(I().getMReferer())) {
            s1(false);
        }
    }

    public void q1(@l String dir) {
        try {
            Uri z10 = ba.g.z(getContext(), ba.g.l("martian_", ".jpeg", dir));
            this.mImgUri = z10;
            if (z10 == null) {
                return;
            }
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            intent.putExtra("output", this.mImgUri);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.startActivityForResult(intent, 885);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void r1() {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setDataAndType(MediaStore.Images.Media.INTERNAL_CONTENT_URI, "image/*");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.startActivityForResult(intent, 886);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void s1(boolean canRetryRefresh) {
        if (!canRetryRefresh) {
            String mUrl = I().getMUrl();
            if (mUrl != null) {
                ((FragmentWebviewBinding) n()).webview.loadUrl(mUrl);
                return;
            }
            return;
        }
        String url = ((FragmentWebviewBinding) n()).webview.getUrl();
        if (url != null) {
            ((FragmentWebviewBinding) n()).webview.loadUrl(url);
            return;
        }
        String mUrl2 = I().getMUrl();
        if (mUrl2 != null) {
            ((FragmentWebviewBinding) n()).webview.loadUrl(mUrl2);
        }
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public boolean shouldOverrideUrlLoading(@l WebView view, @l String url) {
        if (!ba.l.q(url)) {
            Intrinsics.checkNotNull(url);
            if (StringsKt.contains$default((CharSequence) url, (CharSequence) "playmy", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) url, (CharSequence) "Wall_Adinfo", false, 2, (Object) null)) {
                WowanDetailActivity.startWebViewActivity(getActivity(), url);
                return true;
            }
        }
        return false;
    }

    public final void w1(@l Uri uri) {
        this.mImgUri = uri;
    }

    public void x1(@xi.k c r22) {
        Intrinsics.checkNotNullParameter(r22, "l");
        this.ivl = r22;
    }
}
