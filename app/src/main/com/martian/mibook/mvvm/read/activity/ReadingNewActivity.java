package com.martian.mibook.mvvm.read.activity;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBinding;
import ba.h;
import ba.m;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.czhj.sdk.common.Database.SQLiteMTAHelper;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.gyf.immersionbar.BarHide;
import com.kuaishou.weapon.p0.bq;
import com.kuaishou.weapon.p0.t;
import com.martian.libmars.activity.BaseActivity;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.widget.dialog.MartianDialogFragment;
import com.martian.libsliding.SlidingLayout;
import com.martian.libsliding.a;
import com.martian.mibook.R;
import com.martian.mibook.activity.reader.TypefaceScanActivity;
import com.martian.mibook.application.BannerAdManager;
import com.martian.mibook.application.EventManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.ReadingInstance;
import com.martian.mibook.application.RewardVideoAdManager;
import com.martian.mibook.application.b;
import com.martian.mibook.data.book.MiReadingContent;
import com.martian.mibook.data.theme.MiReadingTheme;
import com.martian.mibook.databinding.ActivityReadingNewBinding;
import com.martian.mibook.databinding.ReaderMenuAutoSlideBinding;
import com.martian.mibook.databinding.ReadingBonusBinding;
import com.martian.mibook.databinding.ReadingErrorViewBinding;
import com.martian.mibook.databinding.ReadingFirstGuideBinding;
import com.martian.mibook.databinding.ReadingNetworkOfflineBinding;
import com.martian.mibook.databinding.ReadingReadMenuBinding;
import com.martian.mibook.databinding.ReadingScrollContainerBinding;
import com.martian.mibook.databinding.ScrollReadingFirstGuideBinding;
import com.martian.mibook.databinding.TtsPositionControlViewBinding;
import com.martian.mibook.lib.model.data.MiBookMark;
import com.martian.mibook.lib.model.data.MiReadingRecord;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterContent;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import com.martian.mibook.lib.yuewen.response.TYInitialBook;
import com.martian.mibook.mvvm.base.BaseMVVMActivity;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.net.ErrorResult;
import com.martian.mibook.mvvm.net.result.TYBookTopUser;
import com.martian.mibook.mvvm.read.activity.ReadingNewActivity;
import com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter;
import com.martian.mibook.mvvm.read.dialog.BookFriendsRecommendDialogFragment;
import com.martian.mibook.mvvm.read.dialog.ReadingAddShelfRecommendBooksDialogFragment;
import com.martian.mibook.mvvm.read.dialog.ReadingExitRecommendDialogFragment;
import com.martian.mibook.mvvm.read.fragment.ReaderCommentFragment;
import com.martian.mibook.mvvm.read.popwindow.ReadingMoreItemPopupWindow;
import com.martian.mibook.mvvm.read.viewmodel.CacheStatus;
import com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel;
import com.martian.mibook.mvvm.read.widget.ReadMenu;
import com.martian.mibook.mvvm.read.widget.ReaderLoadingTip;
import com.martian.mibook.mvvm.read.widget.ReaderMinimalistModeLayout;
import com.martian.mibook.mvvm.read.widget.ReaderVipThemeLayout;
import com.martian.mibook.mvvm.read.widget.ReadingAutoSlideLayout;
import com.martian.mibook.mvvm.read.widget.ReadingColorPickerLayout;
import com.martian.mibook.mvvm.read.widget.ReadingMoreSettingLayout;
import com.martian.mibook.mvvm.read.widget.ReadingSettingLayout;
import com.martian.mibook.mvvm.read.widget.ReadingSlideModeSettingLayout;
import com.martian.mibook.mvvm.read.widget.ReadingSpaceSettingLayout;
import com.martian.mibook.mvvm.read.widget.ReadingTypeFaceSettingLayout;
import com.martian.mibook.mvvm.read.widget.a;
import com.martian.mibook.mvvm.tts.NonStickyLiveData;
import com.martian.mibook.mvvm.tts.ReadAloudBook;
import com.martian.mibook.mvvm.tts.TTSReadManager;
import com.martian.mibook.mvvm.tts.service.BaseReadAloudService;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import com.martian.mibook.mvvm.utils.ClickUtils;
import com.martian.mibook.mvvm.utils.SensorHook;
import com.martian.mibook.mvvm.widget.MiBookMarkHeader;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.mibook.ui.reader.ReaderThemeRelativeLayout;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.martian.mibook.ui.reader.page.ReaderPageView;
import com.martian.rpauth.MartianRPUserManager;
import com.martian.rpauth.response.MartianRPAccount;
import com.umeng.analytics.pro.bt;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import je.i;
import je.v0;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import l9.i0;
import l9.l0;
import l9.t0;
import lb.c;
import me.jessyan.autosize.AutoSizeCompat;
import xi.k;
import xi.l;
import ya.e0;
import ya.j2;

@Route(path = kc.a.f27754j)
@Metadata(d1 = {"\u0000\u0086\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\b\u0012\u0004\u0012\u00020\t0\bB\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u000bJ\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0015\u0010\u000bJ\u001b\u0010\u0018\u001a\u00020\u000e2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001a\u0010\u000bJ\u000f\u0010\u001b\u001a\u00020\u000eH\u0003¢\u0006\u0004\b\u001b\u0010\u000bJ\u0019\u0010\u001e\u001a\u00020\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u000eH\u0002¢\u0006\u0004\b \u0010\u000bJ\u000f\u0010!\u001a\u00020\u000eH\u0002¢\u0006\u0004\b!\u0010\u000bJ\u000f\u0010\"\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\"\u0010\u0014J\u000f\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u000eH\u0002¢\u0006\u0004\b&\u0010\u000bJ\u000f\u0010'\u001a\u00020\u000eH\u0002¢\u0006\u0004\b'\u0010\u000bJ!\u0010+\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020\u00122\b\u0010*\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u000eH\u0002¢\u0006\u0004\b-\u0010\u000bJ+\u00102\u001a\u00020\u000e2\b\u0010/\u001a\u0004\u0018\u00010.2\b\u00100\u001a\u0004\u0018\u00010.2\u0006\u00101\u001a\u00020.H\u0002¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u000eH\u0002¢\u0006\u0004\b4\u0010\u000bJ\u000f\u00105\u001a\u00020\u000eH\u0002¢\u0006\u0004\b5\u0010\u000bJ\u000f\u00106\u001a\u00020\u000eH\u0002¢\u0006\u0004\b6\u0010\u000bJ\u0019\u00108\u001a\u00020\u000e2\b\b\u0002\u00107\u001a\u00020\u0012H\u0002¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\u000eH\u0002¢\u0006\u0004\b:\u0010\u000bJ\u000f\u0010;\u001a\u00020\u000eH\u0002¢\u0006\u0004\b;\u0010\u000bJ\u000f\u0010<\u001a\u00020\u000eH\u0002¢\u0006\u0004\b<\u0010\u000bJ\u000f\u0010=\u001a\u00020\u000eH\u0002¢\u0006\u0004\b=\u0010\u000bJ\u000f\u0010>\u001a\u00020.H\u0002¢\u0006\u0004\b>\u0010?J\u000f\u0010@\u001a\u00020\u000eH\u0002¢\u0006\u0004\b@\u0010\u000bJ\u000f\u0010A\u001a\u00020\u000eH\u0002¢\u0006\u0004\bA\u0010\u000bJ\u000f\u0010B\u001a\u00020\u000eH\u0003¢\u0006\u0004\bB\u0010\u000bJ\u000f\u0010C\u001a\u00020\u000eH\u0002¢\u0006\u0004\bC\u0010\u000bJ\u0011\u0010E\u001a\u0004\u0018\u00010DH\u0002¢\u0006\u0004\bE\u0010FJ\u000f\u0010G\u001a\u00020\u0012H\u0002¢\u0006\u0004\bG\u0010\u0014J\u001f\u0010J\u001a\u00020\u000e2\u0006\u0010H\u001a\u00020\u00122\u0006\u0010I\u001a\u00020\u0012H\u0002¢\u0006\u0004\bJ\u0010KJ\u0017\u0010N\u001a\u00020\u000e2\u0006\u0010M\u001a\u00020LH\u0002¢\u0006\u0004\bN\u0010OJ\u0017\u0010Q\u001a\u00020\u000e2\u0006\u0010P\u001a\u00020\u0012H\u0002¢\u0006\u0004\bQ\u00109J\u001f\u0010R\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020.H\u0002¢\u0006\u0004\bR\u0010SJ'\u0010V\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020.2\u0006\u0010T\u001a\u00020.2\u0006\u0010U\u001a\u00020.H\u0002¢\u0006\u0004\bV\u0010WJ\u001f\u0010X\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020.H\u0002¢\u0006\u0004\bX\u0010SJ\u0019\u0010Z\u001a\u00020\u000e2\b\u0010Y\u001a\u0004\u0018\u00010LH\u0002¢\u0006\u0004\bZ\u0010OJ\u0017\u0010\\\u001a\u00020\u000e2\u0006\u0010[\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\\\u00109J\u000f\u0010]\u001a\u00020\u000eH\u0002¢\u0006\u0004\b]\u0010\u000bJ\u001f\u0010^\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020.H\u0002¢\u0006\u0004\b^\u0010SJ\u0017\u0010`\u001a\u00020\u000e2\u0006\u0010_\u001a\u00020.H\u0002¢\u0006\u0004\b`\u0010aJ\u000f\u0010b\u001a\u00020\u000eH\u0002¢\u0006\u0004\bb\u0010\u000bJ\u000f\u0010c\u001a\u00020\u000eH\u0002¢\u0006\u0004\bc\u0010\u000bJ\u000f\u0010d\u001a\u00020\u000eH\u0002¢\u0006\u0004\bd\u0010\u000bJ\u001f\u0010g\u001a\u00020\u00122\u0006\u0010e\u001a\u00020.2\u0006\u0010f\u001a\u00020.H\u0002¢\u0006\u0004\bg\u0010hJ\u0017\u0010j\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020.H\u0002¢\u0006\u0004\bj\u0010aJ\u000f\u0010k\u001a\u00020\u000eH\u0002¢\u0006\u0004\bk\u0010\u000bJ\u000f\u0010l\u001a\u00020\u000eH\u0002¢\u0006\u0004\bl\u0010\u000bJ\u001f\u0010o\u001a\u00020\u000e2\u0006\u0010m\u001a\u00020\u00122\u0006\u0010n\u001a\u00020\u0012H\u0002¢\u0006\u0004\bo\u0010KJ\u000f\u0010p\u001a\u00020\u000eH\u0002¢\u0006\u0004\bp\u0010\u000bJ\u000f\u0010q\u001a\u00020\u0012H\u0002¢\u0006\u0004\bq\u0010\u0014J\u0019\u0010t\u001a\u00020\u000e2\b\u0010s\u001a\u0004\u0018\u00010rH\u0016¢\u0006\u0004\bt\u0010uJ\u0017\u0010x\u001a\u00020\u000e2\u0006\u0010w\u001a\u00020vH\u0016¢\u0006\u0004\bx\u0010yJ\u0019\u0010z\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0014¢\u0006\u0004\bz\u0010\u0019J\u000f\u0010{\u001a\u00020\u000eH\u0016¢\u0006\u0004\b{\u0010\u000bJ\u000f\u0010|\u001a\u00020\u000eH\u0016¢\u0006\u0004\b|\u0010\u000bJ\u000f\u0010}\u001a\u00020\u000eH\u0016¢\u0006\u0004\b}\u0010\u000bJ\u001c\u0010\u0080\u0001\u001a\u00020\u000e2\b\u0010\u007f\u001a\u0004\u0018\u00010~H\u0016¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u001a\u0010\u0083\u0001\u001a\u00020\u000e2\u0007\u0010\u0082\u0001\u001a\u00020LH\u0016¢\u0006\u0005\b\u0083\u0001\u0010OJ\u0011\u0010\u0084\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\b\u0084\u0001\u0010\u000bJ\u001a\u0010\u0085\u0001\u001a\u00020\u000e2\u0006\u0010\u007f\u001a\u00020~H\u0016¢\u0006\u0006\b\u0085\u0001\u0010\u0081\u0001J\u0011\u0010\u0086\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\b\u0086\u0001\u0010\u000bJ\u0011\u0010\u0087\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\b\u0087\u0001\u0010\u000bJ\u0011\u0010\u0088\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\b\u0088\u0001\u0010\u000bJ\u0011\u0010\u0089\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\b\u0089\u0001\u0010\u000bJ\u0011\u0010\u008a\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\b\u008a\u0001\u0010\u000bJ\u0011\u0010\u008b\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\b\u008b\u0001\u0010\u000bJ\u0011\u0010\u008c\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\b\u008c\u0001\u0010\u000bJ\u0011\u0010\u008d\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\b\u008d\u0001\u0010\u000bJ\u0011\u0010\u008e\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\b\u008e\u0001\u0010\u000bJ\u0011\u0010\u008f\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\b\u008f\u0001\u0010\u000bJ\u0011\u0010\u0090\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\b\u0090\u0001\u0010\u000bJ\u0011\u0010\u0091\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\b\u0091\u0001\u0010\u000bJ\u001a\u0010\u0093\u0001\u001a\u00020\u000e2\u0007\u0010\u0092\u0001\u001a\u00020\u0012H\u0016¢\u0006\u0005\b\u0093\u0001\u00109J\u0011\u0010\u0094\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\b\u0094\u0001\u0010\u000bJ\u0019\u0010\u0095\u0001\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\u0012H\u0016¢\u0006\u0005\b\u0095\u0001\u00109J\u0011\u0010\u0096\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\b\u0096\u0001\u0010\u000bJ\u0011\u0010\u0097\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\b\u0097\u0001\u0010\u000bJ\u0011\u0010\u0098\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\b\u0098\u0001\u0010\u000bJ\u0011\u0010\u0099\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\b\u0099\u0001\u0010\u000bJ\u0011\u0010\u009a\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\b\u009a\u0001\u0010\u000bJ\u0011\u0010\u009b\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\b\u009b\u0001\u0010\u000bJ\u0011\u0010\u009c\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\b\u009c\u0001\u0010\u000bJ\u0011\u0010\u009d\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\b\u009d\u0001\u0010\u000bJ$\u0010 \u0001\u001a\u00020\u000e2\u0010\u0010\u009f\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u009e\u0001H\u0016¢\u0006\u0006\b \u0001\u0010¡\u0001J\u0011\u0010¢\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\b¢\u0001\u0010\u000bJ\u0011\u0010£\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\b£\u0001\u0010\u000bJ#\u0010¦\u0001\u001a\u00020\u000e2\u0007\u0010¤\u0001\u001a\u00020.2\u0007\u0010¥\u0001\u001a\u00020.H\u0016¢\u0006\u0005\b¦\u0001\u0010SJ\u0011\u0010§\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\b§\u0001\u0010\u000bJ\u001a\u0010©\u0001\u001a\u00020\u000e2\u0007\u0010¨\u0001\u001a\u00020\u0012H\u0016¢\u0006\u0005\b©\u0001\u00109J\u0011\u0010ª\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\bª\u0001\u0010\u000bJ\u0011\u0010«\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\b«\u0001\u0010\u000bJ'\u0010¯\u0001\u001a\u00020\u00122\u0007\u0010¬\u0001\u001a\u00020\u00122\n\u0010®\u0001\u001a\u0005\u0018\u00010\u00ad\u0001H\u0016¢\u0006\u0006\b¯\u0001\u0010°\u0001J\u0011\u0010±\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\b±\u0001\u0010\u000bJ\u001a\u0010³\u0001\u001a\u00020\u000e2\u0007\u0010²\u0001\u001a\u00020\u0012H\u0016¢\u0006\u0005\b³\u0001\u00109J\u001a\u0010µ\u0001\u001a\u00020\u000e2\u0007\u0010´\u0001\u001a\u00020\u0012H\u0016¢\u0006\u0005\bµ\u0001\u00109J\u001a\u0010¶\u0001\u001a\u00020\u000e2\u0007\u0010´\u0001\u001a\u00020\u0012H\u0016¢\u0006\u0005\b¶\u0001\u00109J\u0011\u0010·\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\b·\u0001\u0010\u000bJ#\u0010¹\u0001\u001a\u00020\u000e2\u0007\u0010´\u0001\u001a\u00020\u00122\u0007\u0010¸\u0001\u001a\u00020\u0012H\u0016¢\u0006\u0005\b¹\u0001\u0010KJ%\u0010½\u0001\u001a\u00020\u000e2\b\u0010»\u0001\u001a\u00030º\u00012\u0007\u0010¼\u0001\u001a\u00020\u0012H\u0016¢\u0006\u0006\b½\u0001\u0010¾\u0001J\u0011\u0010¿\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\b¿\u0001\u0010\u000bJ\u001a\u0010Á\u0001\u001a\u00020\u000e2\u0007\u0010À\u0001\u001a\u00020LH\u0016¢\u0006\u0005\bÁ\u0001\u0010OJ*\u0010Ã\u0001\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020.2\u0007\u0010Â\u0001\u001a\u00020.H\u0016¢\u0006\u0005\bÃ\u0001\u0010WJ\u0011\u0010Ä\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\bÄ\u0001\u0010\u000bJ\u0011\u0010Å\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\bÅ\u0001\u0010\u000bJ\u0011\u0010Æ\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\bÆ\u0001\u0010\u000bJ\u0011\u0010Ç\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\bÇ\u0001\u0010\u000bJ\u0011\u0010È\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\bÈ\u0001\u0010\u000bJ\u0011\u0010É\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\bÉ\u0001\u0010\u000bJ\u0011\u0010Ê\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\bÊ\u0001\u0010\u000bJ\u001d\u0010Ì\u0001\u001a\u00020\u000e2\t\u0010Ë\u0001\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0006\bÌ\u0001\u0010Í\u0001J\u0012\u0010Î\u0001\u001a\u0004\u0018\u00010L¢\u0006\u0006\bÎ\u0001\u0010Ï\u0001J\u000f\u0010Ð\u0001\u001a\u00020\u000e¢\u0006\u0005\bÐ\u0001\u0010\u000bJ\u0011\u0010Ñ\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\bÑ\u0001\u0010\u000bJ&\u0010Ô\u0001\u001a\u00020\u000e2\t\u0010Ò\u0001\u001a\u0004\u0018\u00010~2\u0007\u0010Ó\u0001\u001a\u00020.H\u0016¢\u0006\u0006\bÔ\u0001\u0010Õ\u0001J\u0011\u0010Ö\u0001\u001a\u00020.H\u0016¢\u0006\u0005\bÖ\u0001\u0010?J\u0011\u0010×\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\b×\u0001\u0010\u000bJ\u001c\u0010Ú\u0001\u001a\u00020\u000e2\b\u0010Ù\u0001\u001a\u00030Ø\u0001H\u0016¢\u0006\u0006\bÚ\u0001\u0010Û\u0001J\u001a\u0010Ü\u0001\u001a\u00020\u000e2\u0007\u0010´\u0001\u001a\u00020\u0012H\u0016¢\u0006\u0005\bÜ\u0001\u00109J\u0011\u0010Ý\u0001\u001a\u00020\u0012H\u0016¢\u0006\u0005\bÝ\u0001\u0010\u0014J\u0018\u0010e\u001a\u00020\u000e2\u0007\u0010´\u0001\u001a\u00020\u0012H\u0016¢\u0006\u0004\be\u00109J\u0011\u0010Þ\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\bÞ\u0001\u0010\u000bJ!\u0010ß\u0001\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020.H\u0016¢\u0006\u0005\bß\u0001\u0010SJ\u0011\u0010à\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\bà\u0001\u0010\u000bJ\u001a\u0010á\u0001\u001a\u00020\u000e2\u0007\u0010²\u0001\u001a\u00020\u0012H\u0016¢\u0006\u0005\bá\u0001\u00109J\u001e\u0010ä\u0001\u001a\u00020\u000e2\n\u0010ã\u0001\u001a\u0005\u0018\u00010â\u0001H\u0016¢\u0006\u0006\bä\u0001\u0010å\u0001J\u001a\u0010æ\u0001\u001a\u00020\u000e2\u0007\u0010¸\u0001\u001a\u00020\u0012H\u0016¢\u0006\u0005\bæ\u0001\u00109J\u0011\u0010ç\u0001\u001a\u00020\u0012H\u0016¢\u0006\u0005\bç\u0001\u0010\u0014J\u0011\u0010è\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\bè\u0001\u0010\u000bJ\u0011\u0010é\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\bé\u0001\u0010\u000bJ\u001c\u0010ì\u0001\u001a\u00020\u000e2\b\u0010ë\u0001\u001a\u00030ê\u0001H\u0016¢\u0006\u0006\bì\u0001\u0010í\u0001J\u0013\u0010ï\u0001\u001a\u00030î\u0001H\u0016¢\u0006\u0006\bï\u0001\u0010ð\u0001J\u0013\u0010ò\u0001\u001a\u00030ñ\u0001H\u0016¢\u0006\u0006\bò\u0001\u0010ó\u0001J\u0013\u0010õ\u0001\u001a\u00030ô\u0001H\u0016¢\u0006\u0006\bõ\u0001\u0010ö\u0001J\"\u0010f\u001a\u00020\u000e2\u0007\u0010÷\u0001\u001a\u00020\u00122\u0007\u0010ø\u0001\u001a\u00020LH\u0016¢\u0006\u0005\bf\u0010ù\u0001J\u0011\u0010ú\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\bú\u0001\u0010\u000bJ\u0011\u0010û\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\bû\u0001\u0010\u000bJ\u0011\u0010ü\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\bü\u0001\u0010\u000bJ\u0011\u0010ý\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\bý\u0001\u0010\u000bJ\u0011\u0010þ\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\bþ\u0001\u0010\u000bJ\u0011\u0010ÿ\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\bÿ\u0001\u0010\u000bJ\u0011\u0010\u0080\u0002\u001a\u00020\u000eH\u0016¢\u0006\u0005\b\u0080\u0002\u0010\u000bJ\u001c\u0010\u0083\u0002\u001a\u00020\u000e2\b\u0010\u0082\u0002\u001a\u00030\u0081\u0002H\u0016¢\u0006\u0006\b\u0083\u0002\u0010\u0084\u0002J\u0011\u0010\u0085\u0002\u001a\u00020\u000eH\u0014¢\u0006\u0005\b\u0085\u0002\u0010\u000bJ\u0011\u0010\u0086\u0002\u001a\u00020\u000eH\u0014¢\u0006\u0005\b\u0086\u0002\u0010\u000bJ\u001a\u0010\u0088\u0002\u001a\u00020\u000e2\u0007\u0010\u0087\u0002\u001a\u00020\u0012H\u0016¢\u0006\u0005\b\u0088\u0002\u00109J/\u0010\u008c\u0002\u001a\u00020\u000e2\u0007\u0010\u0089\u0002\u001a\u00020.2\u0007\u0010\u008a\u0002\u001a\u00020.2\t\u0010\u008b\u0002\u001a\u0004\u0018\u00010\u0016H\u0014¢\u0006\u0006\b\u008c\u0002\u0010\u008d\u0002J&\u0010\u0090\u0002\u001a\u00020\u00122\u0007\u0010\u008e\u0002\u001a\u00020.2\t\u0010M\u001a\u0005\u0018\u00010\u008f\u0002H\u0016¢\u0006\u0006\b\u0090\u0002\u0010\u0091\u0002J&\u0010\u0092\u0002\u001a\u00020\u00122\u0007\u0010\u008e\u0002\u001a\u00020.2\t\u0010M\u001a\u0005\u0018\u00010\u008f\u0002H\u0016¢\u0006\u0006\b\u0092\u0002\u0010\u0091\u0002J\u0011\u0010\u0093\u0002\u001a\u00020\u000eH\u0016¢\u0006\u0005\b\u0093\u0002\u0010\u000bJ\u0011\u0010\u0094\u0002\u001a\u00020\u000eH\u0014¢\u0006\u0005\b\u0094\u0002\u0010\u000bR#\u0010\u0098\u0002\u001a\f\u0012\u0005\u0012\u00030\u0096\u0002\u0018\u00010\u0095\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÔ\u0001\u0010\u0097\u0002R\u001c\u0010\u009b\u0002\u001a\u0005\u0018\u00010\u0099\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u009a\u0002R\u001b\u0010\u009d\u0002\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u009c\u0002R\u001c\u0010 \u0002\u001a\u0005\u0018\u00010\u009e\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u009f\u0002R\u001b\u0010¢\u0002\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009a\u0001\u0010¡\u0002R\u001c\u0010¥\u0002\u001a\u0005\u0018\u00010£\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0091\u0001\u0010¤\u0002R\u001c\u0010¨\u0002\u001a\u0005\u0018\u00010¦\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008e\u0001\u0010§\u0002R\u001c\u0010«\u0002\u001a\u0005\u0018\u00010©\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bµ\u0001\u0010ª\u0002R\u001c\u0010¯\u0002\u001a\u0005\u0018\u00010¬\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u00ad\u0002\u0010®\u0002R\u001c\u0010²\u0002\u001a\u0005\u0018\u00010°\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÊ\u0001\u0010±\u0002R\u001c\u0010µ\u0002\u001a\u0005\u0018\u00010³\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÝ\u0001\u0010´\u0002R\u001c\u0010¸\u0002\u001a\u0005\u0018\u00010¶\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bì\u0001\u0010·\u0002R\u001c\u0010»\u0002\u001a\u0005\u0018\u00010¹\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b©\u0001\u0010º\u0002R\u001c\u0010¾\u0002\u001a\u0005\u0018\u00010¼\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b£\u0001\u0010½\u0002R\u001c\u0010Á\u0002\u001a\u0005\u0018\u00010¿\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÇ\u0001\u0010À\u0002R\u0018\u0010Ä\u0002\u001a\u00030Â\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÁ\u0001\u0010Ã\u0002R\u001b\u0010Ç\u0002\u001a\u0005\u0018\u00010Å\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\be\u0010Æ\u0002R&\u0010Ë\u0002\u001a\u0012\u0012\r\u0012\u000b É\u0002*\u0004\u0018\u00010\u00160\u00160È\u00028\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bf\u0010Ê\u0002R'\u0010Ì\u0002\u001a\u0012\u0012\r\u0012\u000b É\u0002*\u0004\u0018\u00010\u00160\u00160È\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0098\u0001\u0010Ê\u0002R'\u0010Í\u0002\u001a\u0012\u0012\r\u0012\u000b É\u0002*\u0004\u0018\u00010\u00160\u00160È\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bª\u0001\u0010Ê\u0002R\u0019\u0010Î\u0002\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010×\u0001R\u0019\u0010Ï\u0002\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÜ\u0001\u0010É\u0001R\u0019\u0010Ñ\u0002\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÐ\u0002\u0010É\u0001R\u0019\u0010Ó\u0002\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÒ\u0002\u0010×\u0001R\u0019\u0010Õ\u0002\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÔ\u0002\u0010×\u0001R\u0019\u0010Ö\u0002\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0001\u0010×\u0001R\u001c\u0010Ù\u0002\u001a\u0005\u0018\u00010×\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0001\u0010Ø\u0002R\u001c\u0010Ü\u0002\u001a\u0005\u0018\u00010Ú\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÉ\u0001\u0010Û\u0002R\u0019\u0010Þ\u0002\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÝ\u0002\u0010×\u0001R\u001a\u0010à\u0002\u001a\u00030ß\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010Ý\u0002¨\u0006á\u0002"}, d2 = {"Lcom/martian/mibook/mvvm/read/activity/ReadingNewActivity;", "Lcom/martian/mibook/mvvm/base/BaseMVVMActivity;", "Lcom/martian/mibook/databinding/ActivityReadingNewBinding;", "Lcom/martian/mibook/mvvm/read/viewmodel/ReadingViewModel;", "Lcom/martian/libsliding/a$a;", "Lcom/martian/mibook/mvvm/read/widget/a;", "Lgd/a;", "Lgd/b;", "Landroidx/lifecycle/Observer;", "Lcom/martian/mibook/mvvm/tts/ReadAloudBook$ReadAloudPlayerStatus;", "<init>", "()V", "Landroidx/viewbinding/ViewBinding;", "viewBinding", "", "p4", "(Landroidx/viewbinding/ViewBinding;)V", "S3", "", "A4", "()Z", "N3", "Landroid/content/Intent;", "intent", "O3", "(Landroid/content/Intent;)V", "f3", "q3", "Lcom/martian/mibook/lib/model/data/abs/ChapterList;", "chapterList", "r4", "(Lcom/martian/mibook/lib/model/data/abs/ChapterList;)V", "R4", "Q3", "B4", "Lcom/martian/mibook/application/BannerAdManager;", "d3", "()Lcom/martian/mibook/application/BannerAdManager;", "U3", "S4", "showErrorView", "Lcom/martian/mibook/mvvm/net/ErrorResult;", "errorResult", "z4", "(ZLcom/martian/mibook/mvvm/net/ErrorResult;)V", "P4", "", BaseReadAloudService.f15168x, BaseReadAloudService.f15169y, "recordType", "M3", "(Ljava/lang/Integer;Ljava/lang/Integer;I)V", "T3", "u4", "o3", "refreshViewListenerColor", "n4", "(Z)V", "m4", "Q4", "a3", "b3", "h3", "()I", "t4", "T4", "v4", "G4", "Lcom/martian/mibook/application/RewardVideoAdManager;", "i3", "()Lcom/martian/mibook/application/RewardVideoAdManager;", "X3", "fullscreen", "enableImmersion", "s4", "(ZZ)V", "", NotificationCompat.CATEGORY_EVENT, "g4", "(Ljava/lang/String;)V", "initial", "V3", "I4", "(II)V", "conPos", "endPos", "k4", "(III)V", "Z3", "sourceString", "h4", "hide", "k3", "M4", "j4", "minutes", "j3", "(I)V", "e4", "f4", "H4", "x", "y", "c3", "(II)Z", "duration", "W2", "X2", "D4", "hasRecommendBooks", "hasBookFriendRecommendBooks", "C4", "J4", "Y3", "Landroid/os/Bundle;", "savedInstanceState", "c1", "(Landroid/os/Bundle;)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "onNewIntent", "U", "r0", ExifInterface.LATITUDE_SOUTH, "Landroid/view/View;", "view", "onBackClick", "(Landroid/view/View;)V", t8.a.f30751f, "F0", "i0", "onMoreItemClick", "d", "I0", "j", "B", "N", "H", "K", "u0", "n", ExifInterface.GPS_DIRECTION_TRUE, "G", "m", "forceUpdate", "k", "A0", "d0", "i", "y0", bt.aJ, com.kwad.sdk.m.e.TAG, t.f11204d, "P", "G0", "Y", "Lkotlin/Function0;", "onMenuOutEnd", "O", "(Lkotlin/jvm/functions/Function0;)V", "q0", "u", "oldSlideMode", "newSlideMode", "C0", "v0", "showBonusFloat", bt.aO, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "o0", "isAddBookMark", "Lcom/martian/mibook/lib/model/data/MiBookMark;", "bookMark", "Q", "(ZLcom/martian/mibook/lib/model/data/MiBookMark;)Z", "f0", "showMenu", "a0", "show", "o", "B0", "L0", "withToast", "f", "Lcom/martian/mibook/application/ReadingInstance$ScreenOffTime;", "screenOffTime", "saveTime", "j0", "(Lcom/martian/mibook/application/ReadingInstance$ScreenOffTime;Z)V", "b0", "source", IAdInterListener.AdReqParam.WIDTH, "contentSize", "t0", "P0", "M", "X", "v", "q1", "I", "q", "status", "c4", "(Lcom/martian/mibook/mvvm/tts/ReadAloudBook$ReadAloudPlayerStatus;)V", "g3", "()Ljava/lang/String;", "i4", "R0", "titleView", "paddingBottom", "h", "(Landroid/view/View;I)V", "l0", "Z", "Lcom/martian/mibook/application/ReadingInstance$d;", "listener", "x0", "(Lcom/martian/mibook/application/ReadingInstance$d;)V", "C", t.f11211k, "H0", "Q0", "n0", "h0", "Lcom/martian/mibook/application/RewardVideoAdManager$VideoType;", "type", "J0", "(Lcom/martian/mibook/application/RewardVideoAdManager$VideoType;)V", "e0", "m0", "M0", "a", "Lcom/martian/libsliding/SlidingLayout$TouchBlockType;", "touchBlockType", "s", "(Lcom/martian/libsliding/SlidingLayout$TouchBlockType;)V", "Lcom/martian/mibook/ui/reader/page/ReaderPageView;", "E0", "()Lcom/martian/mibook/ui/reader/page/ReaderPageView;", "Landroid/widget/TextView;", "z0", "()Landroid/widget/TextView;", "Lcom/martian/libsliding/SlidingLayout;", "D0", "()Lcom/martian/libsliding/SlidingLayout;", "loading", "msg", "(ZLjava/lang/String;)V", "k0", "c", "s0", bq.f10843g, ExifInterface.LONGITUDE_WEST, "R", "O0", "Landroid/graphics/Point;", SQLiteMTAHelper.TABLE_POINT, "g0", "(Landroid/graphics/Point;)V", "onResume", "onPause", "hasFocus", "onWindowFocusChanged", "requestCode", "resultCode", h3.e.f26408m, "onActivityResult", "(IILandroid/content/Intent;)V", "keyCode", "Landroid/view/KeyEvent;", "onKeyUp", "(ILandroid/view/KeyEvent;)Z", "onKeyDown", "finish", "onDestroy", "", "Lcom/martian/mibook/lib/model/data/MiReadingRecord;", "Ljava/util/List;", "previousReadingRecords", "Lcom/martian/mibook/mvvm/read/adapter/ReaderSlidingAdapter;", "Lcom/martian/mibook/mvvm/read/adapter/ReaderSlidingAdapter;", "mSlidingAdapter", "Lcom/martian/mibook/application/RewardVideoAdManager;", "videoAdManager", "Lae/a;", "Lae/a;", "autoSliderController", "Lcom/martian/mibook/application/BannerAdManager;", "bannerAdManager", "Lcom/martian/libmars/widget/dialog/MartianDialogFragment;", "Lcom/martian/libmars/widget/dialog/MartianDialogFragment;", "cacheAdsDialogFragment", "Lcom/martian/mibook/databinding/ReadingReadMenuBinding;", "Lcom/martian/mibook/databinding/ReadingReadMenuBinding;", "readMenuBinding", "Lcom/martian/mibook/mvvm/read/popwindow/ReadingMoreItemPopupWindow;", "Lcom/martian/mibook/mvvm/read/popwindow/ReadingMoreItemPopupWindow;", "menuPopupWindow", "Lcom/martian/mibook/databinding/ReadingFirstGuideBinding;", "p", "Lcom/martian/mibook/databinding/ReadingFirstGuideBinding;", "firstGuideBinding", "Lcom/martian/mibook/databinding/ScrollReadingFirstGuideBinding;", "Lcom/martian/mibook/databinding/ScrollReadingFirstGuideBinding;", "firstScrollModeGuideBinding", "Lcom/martian/mibook/databinding/ReadingErrorViewBinding;", "Lcom/martian/mibook/databinding/ReadingErrorViewBinding;", "errorViewBinding", "Lcom/martian/mibook/databinding/TtsPositionControlViewBinding;", "Lcom/martian/mibook/databinding/TtsPositionControlViewBinding;", "positionControlViewBinding", "Lcom/martian/mibook/databinding/ReadingNetworkOfflineBinding;", "Lcom/martian/mibook/databinding/ReadingNetworkOfflineBinding;", "networkOfflineBinding", "Lcom/martian/mibook/databinding/ReaderMenuAutoSlideBinding;", "Lcom/martian/mibook/databinding/ReaderMenuAutoSlideBinding;", "autoSlideBinding", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "screenOffRunnable", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View$OnLayoutChangeListener;", "mRtvPageLayoutChangeListener", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", "Landroidx/activity/result/ActivityResultLauncher;", "photoLibraryActivityResultLauncher", "notificationSettingActivityResultLauncher", "typefaceScanActivityResultLauncher", "mTtsPosSyncOn", "mTtsChapterIndex", "D", "mTtsContentPos", ExifInterface.LONGITUDE_EAST, "hideTtsControl", "F", "forceHideTtsPositionControl", "bannerAdShow", "Landroid/app/ProgressDialog;", "Landroid/app/ProgressDialog;", "loadingDialog", "Landroid/app/AlertDialog;", "Landroid/app/AlertDialog;", "volumeSlideAlertDialog", "J", "notCurrentlyOpenVip", "", "lastRecommendBooksTime", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nReadingNewActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReadingNewActivity.kt\ncom/martian/mibook/mvvm/read/activity/ReadingNewActivity\n+ 2 ViewGroup.kt\nandroidx/core/view/ViewGroupKt\n*L\n1#1,2798:1\n62#2,4:2799\n*S KotlinDebug\n*F\n+ 1 ReadingNewActivity.kt\ncom/martian/mibook/mvvm/read/activity/ReadingNewActivity\n*L\n220#1:2799,4\n*E\n"})
/* loaded from: classes3.dex */
public final class ReadingNewActivity extends BaseMVVMActivity<ActivityReadingNewBinding, ReadingViewModel> implements a.InterfaceC0522a, com.martian.mibook.mvvm.read.widget.a, gd.a, gd.b, Observer<ReadAloudBook.ReadAloudPlayerStatus> {

    /* renamed from: A */
    @k
    public final ActivityResultLauncher<Intent> typefaceScanActivityResultLauncher;

    /* renamed from: B, reason: from kotlin metadata */
    public boolean mTtsPosSyncOn;

    /* renamed from: C, reason: from kotlin metadata */
    public int mTtsChapterIndex;

    /* renamed from: D, reason: from kotlin metadata */
    public int mTtsContentPos;

    /* renamed from: E */
    public boolean hideTtsControl;

    /* renamed from: F, reason: from kotlin metadata */
    public boolean forceHideTtsPositionControl;

    /* renamed from: G, reason: from kotlin metadata */
    public boolean bannerAdShow;

    /* renamed from: H, reason: from kotlin metadata */
    @l
    public ProgressDialog loadingDialog;

    /* renamed from: I, reason: from kotlin metadata */
    @l
    public AlertDialog volumeSlideAlertDialog;

    /* renamed from: J, reason: from kotlin metadata */
    public boolean notCurrentlyOpenVip;

    /* renamed from: K, reason: from kotlin metadata */
    public long lastRecommendBooksTime;

    /* renamed from: h, reason: from kotlin metadata */
    @l
    public List<MiReadingRecord> previousReadingRecords;

    /* renamed from: i, reason: from kotlin metadata */
    @l
    public ReaderSlidingAdapter mSlidingAdapter;

    /* renamed from: j, reason: from kotlin metadata */
    @l
    public RewardVideoAdManager videoAdManager;

    /* renamed from: k, reason: from kotlin metadata */
    @l
    public ae.a autoSliderController;

    /* renamed from: l */
    @l
    public BannerAdManager bannerAdManager;

    /* renamed from: m, reason: from kotlin metadata */
    @l
    public MartianDialogFragment cacheAdsDialogFragment;

    /* renamed from: n, reason: from kotlin metadata */
    @l
    public ReadingReadMenuBinding readMenuBinding;

    /* renamed from: o, reason: from kotlin metadata */
    @l
    public ReadingMoreItemPopupWindow menuPopupWindow;

    /* renamed from: p, reason: from kotlin metadata */
    @l
    public ReadingFirstGuideBinding firstGuideBinding;

    /* renamed from: q, reason: from kotlin metadata */
    @l
    public ScrollReadingFirstGuideBinding firstScrollModeGuideBinding;

    /* renamed from: r */
    @l
    public ReadingErrorViewBinding errorViewBinding;

    /* renamed from: s, reason: from kotlin metadata */
    @l
    public TtsPositionControlViewBinding positionControlViewBinding;

    /* renamed from: t */
    @l
    public ReadingNetworkOfflineBinding networkOfflineBinding;

    /* renamed from: u, reason: from kotlin metadata */
    @l
    public ReaderMenuAutoSlideBinding autoSlideBinding;

    /* renamed from: v, reason: from kotlin metadata */
    @l
    public Handler handler = new Handler(Looper.getMainLooper());

    /* renamed from: w */
    @k
    public final Runnable screenOffRunnable = new Runnable() { // from class: bd.n0
        public /* synthetic */ n0() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ReadingNewActivity.q4(ReadingNewActivity.this);
        }
    };

    /* renamed from: x, reason: from kotlin metadata */
    @l
    public View.OnLayoutChangeListener mRtvPageLayoutChangeListener;

    /* renamed from: y, reason: from kotlin metadata */
    @k
    public final ActivityResultLauncher<Intent> photoLibraryActivityResultLauncher;

    /* renamed from: z */
    @k
    public final ActivityResultLauncher<Intent> notificationSettingActivityResultLauncher;

    public static final class a implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: c */
        public final /* synthetic */ ReadMenu f14357c;

        public a(ReadMenu readMenu) {
            this.f14357c = readMenu;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(@l SeekBar seekBar, int i10, boolean z10) {
            ChapterList chapterList = ReadingNewActivity.this.m1().getChapterList();
            if (chapterList == null || chapterList.getCount() <= 0) {
                t0.b(ReadingNewActivity.this, "请等待数据加载完毕");
            } else {
                this.f14357c.x0(i10, chapterList);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(@l SeekBar seekBar) {
            List list;
            if (!this.f14357c.Q() && (list = ReadingNewActivity.this.previousReadingRecords) != null) {
                list.clear();
            }
            this.f14357c.setVisibleReadingChapterSeek(0);
            if (ReadingNewActivity.this.previousReadingRecords == null) {
                ReadingNewActivity.this.previousReadingRecords = new ArrayList();
            }
            MiReadingRecord miReadingRecord = new MiReadingRecord();
            MiReadingRecord record = ReadingNewActivity.this.m1().getRecord();
            miReadingRecord.setChapterIndex(record != null ? Integer.valueOf(record.getChapterIndex()) : null);
            MiReadingRecord record2 = ReadingNewActivity.this.m1().getRecord();
            miReadingRecord.setContentPos(record2 != null ? record2.getContentPos() : null);
            MiReadingRecord record3 = ReadingNewActivity.this.m1().getRecord();
            miReadingRecord.setContentLength(record3 != null ? record3.getContentLength() : null);
            MiReadingRecord record4 = ReadingNewActivity.this.m1().getRecord();
            miReadingRecord.setRecordType(record4 != null ? record4.getRecordType() : 0);
            List list2 = ReadingNewActivity.this.previousReadingRecords;
            if (list2 != null) {
                list2.add(0, miReadingRecord);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(@l SeekBar seekBar) {
            if (ReadingNewActivity.this.mSlidingAdapter == null || ReadingNewActivity.this.m1().getChapterList() == null) {
                t0.b(ReadingNewActivity.this, "请等待数据加载完毕");
                return;
            }
            ReadingNewActivity.this.g4("章节进度条-拖动");
            if (seekBar != null) {
                ReadMenu readMenu = this.f14357c;
                ReadingNewActivity readingNewActivity = ReadingNewActivity.this;
                readingNewActivity.M3(Integer.valueOf(readMenu.J(seekBar.getProgress())), 0, 0);
                readingNewActivity.P4();
            }
            this.f14357c.X();
        }
    }

    public static final class b implements SlidingLayout.a {
        public b() {
        }

        @Override // com.martian.libsliding.SlidingLayout.a
        public void a(@l Object obj) {
            ae.a aVar;
            if (obj != null && (obj instanceof MiReadingContent.MiContentCursor)) {
                MiReadingContent.MiContentCursor miContentCursor = (MiReadingContent.MiContentCursor) obj;
                if (miContentCursor.getContent() == null || !miContentCursor.getContent().isReady()) {
                    return;
                }
                int chapterIndex = miContentCursor.getContent().getChapterIndex();
                if (ReadingNewActivity.this.m1().Z1()) {
                    if (ReadingNewActivity.this.mTtsChapterIndex == chapterIndex && miContentCursor.isPosIn(ReadingNewActivity.this.mTtsContentPos)) {
                        ReadingNewActivity.this.mTtsPosSyncOn = true;
                        ReadingNewActivity.this.k3(true);
                    } else {
                        ReadingNewActivity.this.mTtsPosSyncOn = false;
                        ReadingNewActivity.this.k3(false);
                    }
                }
                int startContentPos = miContentCursor.getStartContentPos();
                Chapter chapter = miContentCursor.getContent().getChapter();
                String title = chapter != null ? chapter.getTitle() : null;
                MiReadingRecord record = ReadingNewActivity.this.m1().getRecord();
                if (record != null) {
                    record.setChapterIndex(Integer.valueOf(chapterIndex));
                    record.setContentPos(Integer.valueOf(startContentPos));
                    record.setChapterTitle(title);
                }
                if (!ReadingNewActivity.this.m0() || (aVar = ReadingNewActivity.this.autoSliderController) == null) {
                    return;
                }
                aVar.e();
            }
        }

        @Override // com.martian.libsliding.SlidingLayout.a
        public void b(int i10) {
            if (i10 <= 1) {
                ReadingNewActivity.this.h0(false);
                ReadingNewActivity.this.m1().h2(ReadingNewActivity.this);
                ReaderSlidingAdapter readerSlidingAdapter = ReadingNewActivity.this.mSlidingAdapter;
                if (readerSlidingAdapter != null) {
                    readerSlidingAdapter.B0();
                }
            }
        }
    }

    public static final class c implements c.i {
        public c() {
        }

        @Override // lb.c.i
        public void a(@k x8.c errorResult) {
            Intrinsics.checkNotNullParameter(errorResult, "errorResult");
            ReaderSlidingAdapter readerSlidingAdapter = ReadingNewActivity.this.mSlidingAdapter;
            if (readerSlidingAdapter != null) {
                ReaderSlidingAdapter readerSlidingAdapter2 = ReadingNewActivity.this.mSlidingAdapter;
                readerSlidingAdapter.A2(readerSlidingAdapter2 != null ? readerSlidingAdapter2.Q0() : null);
            }
            ReaderSlidingAdapter readerSlidingAdapter3 = ReadingNewActivity.this.mSlidingAdapter;
            if (readerSlidingAdapter3 != null) {
                ReaderSlidingAdapter readerSlidingAdapter4 = ReadingNewActivity.this.mSlidingAdapter;
                readerSlidingAdapter3.A2(readerSlidingAdapter4 != null ? readerSlidingAdapter4.X0() : null);
            }
        }

        @Override // lb.c.i
        public void b(@k MartianRPAccount rpAccount) {
            Intrinsics.checkNotNullParameter(rpAccount, "rpAccount");
            ReaderSlidingAdapter readerSlidingAdapter = ReadingNewActivity.this.mSlidingAdapter;
            if (readerSlidingAdapter != null) {
                ReaderSlidingAdapter readerSlidingAdapter2 = ReadingNewActivity.this.mSlidingAdapter;
                readerSlidingAdapter.A2(readerSlidingAdapter2 != null ? readerSlidingAdapter2.Q0() : null);
            }
            ReaderSlidingAdapter readerSlidingAdapter3 = ReadingNewActivity.this.mSlidingAdapter;
            if (readerSlidingAdapter3 != null) {
                ReaderSlidingAdapter readerSlidingAdapter4 = ReadingNewActivity.this.mSlidingAdapter;
                readerSlidingAdapter3.A2(readerSlidingAdapter4 != null ? readerSlidingAdapter4.X0() : null);
            }
        }
    }

    public static final class d implements ReadingInstance.d {

        /* renamed from: b */
        public final /* synthetic */ ReadingInstance.d f14361b;

        public d(ReadingInstance.d dVar) {
            this.f14361b = dVar;
        }

        public static final void c() {
        }

        @Override // com.martian.mibook.application.ReadingInstance.d
        public void a() {
            ac.a.p(ReadingNewActivity.this, "看插屏免广告-失败");
            this.f14361b.a();
        }

        @Override // com.martian.mibook.application.ReadingInstance.d
        public void onAdExposed() {
            int I1 = MiConfigSingleton.b2().I1(ReadingNewActivity.this.m1().getAdHiding());
            ReadingNewActivity.this.k0();
            ac.a.p(ReadingNewActivity.this, "看插屏免广告-成功");
            this.f14361b.onAdExposed();
            ReadingNewActivity readingNewActivity = ReadingNewActivity.this;
            i0.z0(readingNewActivity, readingNewActivity.getString(R.string.bonus_title), ExtKt.c(I1 + "分钟免广告时间"), new i0.l() { // from class: bd.y0
                @Override // l9.i0.l
                public final void a() {
                    ReadingNewActivity.d.c();
                }
            });
        }
    }

    public static final class e implements MartianDialogFragment.b {
        @Override // com.martian.libmars.widget.dialog.MartianDialogFragment.b
        public void a(@k DialogFragment dialogFragment) {
            Intrinsics.checkNotNullParameter(dialogFragment, "dialogFragment");
            boolean A0 = MiConfigSingleton.b2().A0();
            com.gyf.immersionbar.d.y3(dialogFragment).T2(!A0).G1(!A0).v1(ConfigSingleton.D().L(), 0.0f).a1();
        }
    }

    public static final class f extends BottomSheetBehavior.BottomSheetCallback {
        public f() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(@k View bottomSheet, float f10) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(@k View bottomSheet, int i10) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            if (ReadingNewActivity.this.m0()) {
                if (i10 == 3) {
                    ae.a aVar = ReadingNewActivity.this.autoSliderController;
                    if (aVar != null) {
                        aVar.c();
                    }
                    ReadingNewActivity.this.m1().U2(true, 1);
                    return;
                }
                if (i10 != 5) {
                    return;
                }
                ae.a aVar2 = ReadingNewActivity.this.autoSliderController;
                if (aVar2 != null) {
                    aVar2.d();
                }
                ReadingNewActivity.this.m1().U2(false, 1);
            }
        }
    }

    public static final class g implements v0.k {
        public g() {
        }

        @Override // je.v0.k
        public void a() {
        }

        @Override // je.v0.k
        public void b() {
            ReadingNewActivity.this.J0(RewardVideoAdManager.VideoType.AUTO_SLIDE);
        }
    }

    public ReadingNewActivity() {
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: bd.o0
            public /* synthetic */ o0() {
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ReadingNewActivity.l4(ReadingNewActivity.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.photoLibraryActivityResultLauncher = registerForActivityResult;
        ActivityResultLauncher<Intent> registerForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: bd.p0
            public /* synthetic */ p0() {
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ReadingNewActivity.a4(ReadingNewActivity.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult2, "registerForActivityResult(...)");
        this.notificationSettingActivityResultLauncher = registerForActivityResult2;
        ActivityResultLauncher<Intent> registerForActivityResult3 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: bd.q0
            public /* synthetic */ q0() {
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ReadingNewActivity.O4(ReadingNewActivity.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult3, "registerForActivityResult(...)");
        this.typefaceScanActivityResultLauncher = registerForActivityResult3;
        this.mTtsChapterIndex = -1;
        this.mTtsContentPos = -1;
        this.hideTtsControl = true;
        this.lastRecommendBooksTime = -1L;
    }

    public static final void A3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void B3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void C3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void D3(ReadingNewActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (MiConfigSingleton.b2().G1().g(this$0, 1021)) {
            this$0.g4("点击赚钱模式");
            kc.b.n(0, "阅读页");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ActivityReadingNewBinding E2(ReadingNewActivity readingNewActivity) {
        return (ActivityReadingNewBinding) readingNewActivity.a1();
    }

    public static final void E3(ReadingNewActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h0(true);
        this$0.m1().V2(ExtKt.c("点击屏幕中央可以呼出菜单"));
    }

    public static final void E4(ReadingNewActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.F0("音量键翻页");
    }

    public static final void F3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void F4(ReadingNewActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.notCurrentlyOpenVip = true;
    }

    public static final void G3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void H3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void I3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void J3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void K3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void K4(ReadingNewActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.w("弹窗-点击");
        super.finish();
    }

    public static final void L3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void L4(ReadingNewActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        super.finish();
    }

    public static final void N4(ReadingNewActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TTSReadManager.l(this$0);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0), Dispatchers.getDefault(), null, new ReadingNewActivity$tryStartTts$1$1(this$0, null), 2, null);
    }

    public static final void O4(ReadingNewActivity this$0, ActivityResult activityResult) {
        ReadingReadMenuBinding readingReadMenuBinding;
        ReadMenu root;
        ReadingTypeFaceSettingLayout readingTypeFaceSettingLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (activityResult.getResultCode() != -1 || (readingReadMenuBinding = this$0.readMenuBinding) == null || (root = readingReadMenuBinding.getRoot()) == null || (readingTypeFaceSettingLayout = (ReadingTypeFaceSettingLayout) root.L(ReadingTypeFaceSettingLayout.class)) == null) {
            return;
        }
        readingTypeFaceSettingLayout.m();
    }

    public static /* synthetic */ void P3(ReadingNewActivity readingNewActivity, Intent intent, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            intent = null;
        }
        readingNewActivity.O3(intent);
    }

    public static final void R3(ReadingNewActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.H0();
    }

    public static final void W3(ReadingNewActivity this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ReadAloudBook readAloudBook = ReadAloudBook.f15003a;
        this$0.k4(readAloudBook.c(), readAloudBook.f(), readAloudBook.l());
    }

    public static final void Y2(ReadingNewActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ac.a.H(this$0, "无网络-关闭");
        this$0.m1().A2(true);
        ReadingNetworkOfflineBinding readingNetworkOfflineBinding = this$0.networkOfflineBinding;
        ReaderThemeRelativeLayout root = readingNetworkOfflineBinding != null ? readingNetworkOfflineBinding.getRoot() : null;
        if (root == null) {
            return;
        }
        root.setVisibility(8);
    }

    public static final void Z2(ReadingNewActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ac.a.H(this$0, "无网络-点击");
        try {
            this$0.startActivity(new Intent("android.settings.SETTINGS"));
        } catch (Exception unused) {
        }
    }

    public static final void a4(ReadingNewActivity this$0, ActivityResult activityResult) {
        ReadMenu root;
        ReadingMoreSettingLayout readingMoreSettingLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (activityResult.getResultCode() == -1) {
            if (h.e(this$0)) {
                ac.a.I(this$0, "未完待续:" + this$0.m1().getNotificationStatus() + "-开启");
                this$0.m1().M2("开启");
                t0.b(this$0, "开启成功");
            } else {
                ac.a.I(this$0, "未完待续:" + this$0.m1().getNotificationStatus() + "-关闭");
                this$0.m1().M2("关闭");
                t0.b(this$0, "开启失败");
            }
            ReadingReadMenuBinding readingReadMenuBinding = this$0.readMenuBinding;
            if (readingReadMenuBinding != null && (root = readingReadMenuBinding.getRoot()) != null && (readingMoreSettingLayout = (ReadingMoreSettingLayout) root.L(ReadingMoreSettingLayout.class)) != null) {
                readingMoreSettingLayout.R();
            }
            MiConfigSingleton.b2().e2().S0(this$0);
        }
    }

    public static final void b4(ReadingNewActivity this$0, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i13 - i11 != i17 - i15) {
            ReaderSlidingAdapter readerSlidingAdapter = this$0.mSlidingAdapter;
            if (readerSlidingAdapter != null) {
                readerSlidingAdapter.A1();
            }
            if (view != null) {
                view.removeOnLayoutChangeListener(this$0.mRtvPageLayoutChangeListener);
            }
            this$0.mRtvPageLayoutChangeListener = null;
        }
    }

    public static final void d4(ReadingNewActivity this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ReadAloudBook readAloudBook = ReadAloudBook.f15003a;
        this$0.k4(readAloudBook.c(), readAloudBook.f(), readAloudBook.l());
    }

    public static final void e3(ReadingNewActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ReaderSlidingAdapter readerSlidingAdapter = this$0.mSlidingAdapter;
        if (readerSlidingAdapter != null) {
            readerSlidingAdapter.L1();
        }
    }

    public static final void l3(ReadingNewActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.i4();
    }

    public static final void l4(ReadingNewActivity this$0, ActivityResult activityResult) {
        Intent data;
        Uri data2;
        ReadMenu root;
        ReadingColorPickerLayout readingColorPickerLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (activityResult.getResultCode() != -1 || (data = activityResult.getData()) == null || (data2 = data.getData()) == null) {
            return;
        }
        String b10 = Intrinsics.areEqual("content", data2.getScheme()) ? l0.b(this$0, data2) : data2.getPath();
        MiReadingTheme customTheme = this$0.m1().getCustomTheme();
        if (customTheme != null) {
            customTheme.setCustomBackgroundImage(b10);
        }
        ReadingReadMenuBinding readingReadMenuBinding = this$0.readMenuBinding;
        if (readingReadMenuBinding != null && (root = readingReadMenuBinding.getRoot()) != null && (readingColorPickerLayout = (ReadingColorPickerLayout) root.L(ReadingColorPickerLayout.class)) != null) {
            readingColorPickerLayout.A();
        }
        a.C0540a.a(this$0, false, 1, null);
    }

    public static final void m3(ReadingNewActivity this$0, View view) {
        ReaderSlidingAdapter readerSlidingAdapter;
        MiReadingContent Q0;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ReaderSlidingAdapter readerSlidingAdapter2 = this$0.mSlidingAdapter;
        if (readerSlidingAdapter2 != null) {
            if ((readerSlidingAdapter2 != null ? readerSlidingAdapter2.Q0() : null) == null || (readerSlidingAdapter = this$0.mSlidingAdapter) == null || (Q0 = readerSlidingAdapter.Q0()) == null || !Q0.isReady()) {
                return;
            }
            int i10 = this$0.m1().getCom.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String();
            ReaderSlidingAdapter readerSlidingAdapter3 = this$0.mSlidingAdapter;
            this$0.j4(i10, readerSlidingAdapter3 != null ? readerSlidingAdapter3.S0() : 0);
        }
    }

    public static final void n3(ReadingNewActivity this$0, View view) {
        ReadMenu root;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ReadingReadMenuBinding readingReadMenuBinding = this$0.readMenuBinding;
        if (readingReadMenuBinding != null && (root = readingReadMenuBinding.getRoot()) != null) {
            root.a0();
        }
        ReadingFirstGuideBinding readingFirstGuideBinding = this$0.firstGuideBinding;
        RelativeLayout root2 = readingFirstGuideBinding != null ? readingFirstGuideBinding.getRoot() : null;
        if (root2 == null) {
            return;
        }
        root2.setVisibility(8);
    }

    public static /* synthetic */ void o4(ReadingNewActivity readingNewActivity, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        readingNewActivity.n4(z10);
    }

    public static final void p3(ReadingNewActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ScrollReadingFirstGuideBinding scrollReadingFirstGuideBinding = this$0.firstScrollModeGuideBinding;
        RelativeLayout root = scrollReadingFirstGuideBinding != null ? scrollReadingFirstGuideBinding.getRoot() : null;
        if (root == null) {
            return;
        }
        root.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SetTextI18n"})
    private final void q3() {
        MutableLiveData<Boolean> b02;
        MutableLiveData<Unit> j02;
        MutableLiveData<Unit> i02;
        MutableLiveData<Pair<Integer, Object>> f02;
        NonStickyLiveData<Unit> k02;
        MutableLiveData<TYInitialBook> e02;
        NonStickyLiveData<MartianRPAccount> Y;
        m1().S0().observe(this, new Observer() { // from class: bd.v0
            public /* synthetic */ v0() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReadingNewActivity.r3(Function1.this, obj);
            }
        });
        m1().G0().observe(this, new Observer() { // from class: bd.o
            public /* synthetic */ o() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReadingNewActivity.s3(Function1.this, obj);
            }
        });
        m1().R0().observe(this, new Observer() { // from class: bd.r
            public /* synthetic */ r() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReadingNewActivity.t3(Function1.this, obj);
            }
        });
        m1().Q0().observe(this, new Observer() { // from class: bd.s
            public /* synthetic */ s() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReadingNewActivity.u3(Function1.this, obj);
            }
        });
        m1().V0().observe(this, new Observer() { // from class: bd.t
            public /* synthetic */ t() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReadingNewActivity.v3(Function1.this, obj);
            }
        });
        m1().h().observe(this, new Observer() { // from class: bd.u
            public /* synthetic */ u() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReadingNewActivity.w3(Function1.this, obj);
            }
        });
        m1().U0().observe(this, new Observer() { // from class: bd.v
            public /* synthetic */ v() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReadingNewActivity.x3(Function1.this, obj);
            }
        });
        m1().W0().observe(this, new Observer() { // from class: bd.w
            public /* synthetic */ w() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReadingNewActivity.y3(Function1.this, obj);
            }
        });
        m1().a1().observe(this, new Observer() { // from class: bd.x
            public /* synthetic */ x() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReadingNewActivity.z3(Function1.this, obj);
            }
        });
        AppViewModel l12 = l1();
        if (l12 != null && (Y = l12.Y()) != null) {
            Y.observe(this, new Observer() { // from class: bd.y
                public /* synthetic */ y() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ReadingNewActivity.A3(Function1.this, obj);
                }
            });
        }
        AppViewModel l13 = l1();
        if (l13 != null && (e02 = l13.e0()) != null) {
            e02.observe(this, new Observer() { // from class: bd.w0
                public /* synthetic */ w0() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ReadingNewActivity.B3(Function1.this, obj);
                }
            });
        }
        AppViewModel l14 = l1();
        if (l14 != null && (k02 = l14.k0()) != null) {
            k02.observe(this, new Observer() { // from class: bd.x0
                public /* synthetic */ x0() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ReadingNewActivity.C3(Function1.this, obj);
                }
            });
        }
        ((ActivityReadingNewBinding) a1()).readingScrollContainer.readingBonus.lyDurationCountFloat.setOnClickListener(new View.OnClickListener() { // from class: bd.g
            public /* synthetic */ g() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingNewActivity.D3(ReadingNewActivity.this, view);
            }
        });
        ((ActivityReadingNewBinding) a1()).readingScrollContainer.readingBonus.floatMenu.setOnClickListener(new View.OnClickListener() { // from class: bd.h
            public /* synthetic */ h() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingNewActivity.E3(ReadingNewActivity.this, view);
            }
        });
        m1().b1().observe(this, new Observer() { // from class: bd.i
            public /* synthetic */ i() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReadingNewActivity.F3(Function1.this, obj);
            }
        });
        m1().I0().observe(this, new Observer() { // from class: bd.j
            public /* synthetic */ j() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReadingNewActivity.G3(Function1.this, obj);
            }
        });
        AppViewModel l15 = l1();
        if (l15 != null && (f02 = l15.f0()) != null) {
            f02.observe(this, new Observer() { // from class: bd.k
                public /* synthetic */ k() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ReadingNewActivity.H3(Function1.this, obj);
                }
            });
        }
        m1().K0().observe(this, new Observer() { // from class: bd.l
            public /* synthetic */ l() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReadingNewActivity.I3(Function1.this, obj);
            }
        });
        AppViewModel l16 = l1();
        if (l16 != null && (i02 = l16.i0()) != null) {
            i02.observe(this, new Observer() { // from class: bd.m
                public /* synthetic */ m() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ReadingNewActivity.J3(Function1.this, obj);
                }
            });
        }
        AppViewModel l17 = l1();
        if (l17 != null && (j02 = l17.j0()) != null) {
            j02.observe(this, new Observer() { // from class: bd.n
                public /* synthetic */ n() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ReadingNewActivity.K3(Function1.this, obj);
                }
            });
        }
        AppViewModel l18 = l1();
        if (l18 == null || (b02 = l18.b0()) == null) {
            return;
        }
        b02.observe(this, new Observer() { // from class: bd.p
            public /* synthetic */ p() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReadingNewActivity.L3(Function1.this, obj);
            }
        });
    }

    public static final void q4(ReadingNewActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b3();
    }

    public static final void r3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void s3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void t3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void u3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void v3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void w3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void w4(ReadingNewActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MartianDialogFragment martianDialogFragment = this$0.cacheAdsDialogFragment;
        if (martianDialogFragment != null) {
            martianDialogFragment.dismiss();
        }
    }

    public static final void x3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void x4(ReadingNewActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MartianDialogFragment martianDialogFragment = this$0.cacheAdsDialogFragment;
        if (martianDialogFragment != null) {
            martianDialogFragment.dismiss();
        }
        this$0.F0("缓存");
    }

    public static final void y3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void y4(ProgressBar progressBar, ReadingNewActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (progressBar == null || progressBar.getVisibility() != 4) {
            return;
        }
        progressBar.setVisibility(0);
        MartianDialogFragment martianDialogFragment = this$0.cacheAdsDialogFragment;
        if (martianDialogFragment != null) {
            martianDialogFragment.dismiss();
        }
        this$0.J0(RewardVideoAdManager.VideoType.CACHE_CHAPTERS);
    }

    public static final void z3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.martian.mibook.mvvm.read.widget.a
    public void A() {
        ReadMenu root;
        ReadMenu root2;
        ReaderMinimalistModeLayout readerMinimalistModeLayout;
        ReadingReadMenuBinding readingReadMenuBinding = this.readMenuBinding;
        if (readingReadMenuBinding != null && (root2 = readingReadMenuBinding.getRoot()) != null && (readerMinimalistModeLayout = (ReaderMinimalistModeLayout) root2.L(ReaderMinimalistModeLayout.class)) != null) {
            readerMinimalistModeLayout.s();
        }
        ReadingReadMenuBinding readingReadMenuBinding2 = this.readMenuBinding;
        if (readingReadMenuBinding2 == null || (root = readingReadMenuBinding2.getRoot()) == null) {
            return;
        }
        root.F0(ReaderMinimalistModeLayout.class, true);
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMActivity, k9.b
    public void A0() {
        n4(true);
    }

    public final boolean A4() {
        if (MiConfigSingleton.b2().C2() || ConfigSingleton.D().Y() < 10 || ConfigSingleton.D().F("PARAGRAPH_GUIDE")) {
            return false;
        }
        m1().C2();
        ConfigSingleton.D().v0("PARAGRAPH_GUIDE");
        v0.V0(this);
        return true;
    }

    @Override // gd.a
    public void B() {
        g4("查看评论-菜单");
        ReaderCommentFragment.INSTANCE.b(this, m1().w3());
        ReadingMoreItemPopupWindow readingMoreItemPopupWindow = this.menuPopupWindow;
        if (readingMoreItemPopupWindow != null) {
            readingMoreItemPopupWindow.dismiss();
        }
    }

    @Override // com.martian.mibook.mvvm.read.widget.a
    public void B0(boolean show) {
        ReaderSlidingAdapter readerSlidingAdapter = this.mSlidingAdapter;
        if (readerSlidingAdapter != null) {
            readerSlidingAdapter.W1(show);
        }
    }

    public final boolean B4() {
        if (ReadingInstance.z().o()) {
            return ReadingInstance.z().j(this, null);
        }
        ReaderSlidingAdapter readerSlidingAdapter = this.mSlidingAdapter;
        if (readerSlidingAdapter == null || !readerSlidingAdapter.A0()) {
            return false;
        }
        MiConfigSingleton.b2().H1().H0(this, e0.V, null);
        return true;
    }

    @Override // gd.a
    public void C(boolean show) {
        if (this.bannerAdShow == show) {
            return;
        }
        this.bannerAdShow = show;
        BannerAdManager bannerAdManager = this.bannerAdManager;
        if (bannerAdManager != null) {
            bannerAdManager.g1(this, show);
        }
        if (m1().Z1()) {
            this.forceHideTtsPositionControl = !show;
            k3(!this.bannerAdShow);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.mvvm.read.widget.a
    public void C0(int oldSlideMode, int newSlideMode) {
        ReaderSlidingAdapter readerSlidingAdapter;
        U3();
        ((ActivityReadingNewBinding) a1()).readingScrollContainer.slReadingContainer.setSlider(ReadingInstance.z().C(this));
        Q3();
        f0();
        m1().g2();
        ReadingInstance.SlideMode slideMode = ReadingInstance.SlideMode.SCROLL_SLIDER;
        if ((oldSlideMode == slideMode.getSlideMode() || newSlideMode == slideMode.getSlideMode()) && (readerSlidingAdapter = this.mSlidingAdapter) != null) {
            if (readerSlidingAdapter != null) {
                readerSlidingAdapter.M1(((ActivityReadingNewBinding) a1()).readingScrollContainer.llScrollReadingContainer);
            }
            ReaderSlidingAdapter readerSlidingAdapter2 = this.mSlidingAdapter;
            if (readerSlidingAdapter2 != null) {
                readerSlidingAdapter2.v1();
            }
            this.mRtvPageLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: bd.h0
                public /* synthetic */ h0() {
                }

                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                    ReadingNewActivity.b4(ReadingNewActivity.this, view, i10, i11, i12, i13, i14, i15, i16, i17);
                }
            };
            ((ActivityReadingNewBinding) a1()).readingScrollContainer.lyFakeReadingLayout.llReadingContent.rtvPage.addOnLayoutChangeListener(this.mRtvPageLayoutChangeListener);
        }
    }

    public final void C4(boolean hasRecommendBooks, boolean hasBookFriendRecommendBooks) {
        if (hasRecommendBooks && hasBookFriendRecommendBooks) {
            if (Random.INSTANCE.nextBoolean()) {
                ReadingExitRecommendDialogFragment.INSTANCE.c(this);
                return;
            } else {
                BookFriendsRecommendDialogFragment.INSTANCE.a(this);
                return;
            }
        }
        if (hasRecommendBooks) {
            ReadingExitRecommendDialogFragment.INSTANCE.c(this);
        } else if (hasBookFriendRecommendBooks) {
            BookFriendsRecommendDialogFragment.INSTANCE.a(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // gd.a
    @k
    public SlidingLayout D0() {
        SlidingLayout slReadingContainer = ((ActivityReadingNewBinding) a1()).readingScrollContainer.slReadingContainer;
        Intrinsics.checkNotNullExpressionValue(slReadingContainer, "slReadingContainer");
        return slReadingContainer;
    }

    public final void D4() {
        AlertDialog alertDialog = this.volumeSlideAlertDialog;
        if (alertDialog == null || !(alertDialog == null || alertDialog.isShowing())) {
            this.volumeSlideAlertDialog = i0.x0(this, "音量键翻页", "音量键翻页为会员专属功能，开通会员后可用", "暂不开通", "立即开通", true, new i0.l() { // from class: bd.z
                public /* synthetic */ z() {
                }

                @Override // l9.i0.l
                public final void a() {
                    ReadingNewActivity.E4(ReadingNewActivity.this);
                }
            }, new i0.k() { // from class: bd.a0
                public /* synthetic */ a0() {
                }

                @Override // l9.i0.k
                public final void a() {
                    ReadingNewActivity.F4(ReadingNewActivity.this);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // gd.a
    @k
    public ReaderPageView E0() {
        ReaderPageView rtvPage = ((ActivityReadingNewBinding) a1()).readingScrollContainer.lyFakeReadingLayout.llReadingContent.rtvPage;
        Intrinsics.checkNotNullExpressionValue(rtvPage, "rtvPage");
        return rtvPage;
    }

    @Override // com.martian.mibook.mvvm.read.widget.a
    public void F0(@k String r32) {
        Intrinsics.checkNotNullParameter(r32, "path");
        i.e0(this, r32, m1().getSourceName(), m1().getSourceId());
    }

    @Override // com.martian.mibook.mvvm.read.widget.a
    public void G() {
        g4("下一章");
        if (m1().getChapterList() == null) {
            t0.b(this, "请等待数据加载完毕");
        } else {
            M3(Integer.valueOf(m1().getCom.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String() + 1), 0, 0);
            P4();
        }
    }

    @Override // com.martian.mibook.mvvm.read.widget.a
    public void G0() {
        if (MiConfigSingleton.b2().K2()) {
            G4();
            return;
        }
        if (MiConfigSingleton.b2().r0("function_auto_read") <= 3 || !ReadingInstance.z().z0(this) || MiConfigSingleton.b2().B0() || MiConfigSingleton.b2().E2()) {
            G4();
        } else if (MiConfigSingleton.b2().C2()) {
            F0("自动阅读");
        } else {
            v0.O0(this, getString(R.string.auto_sliding), getString(R.string.auto_read_video), getString(R.string.vip_for_auto_read), "自动阅读", m1().getSourceName(), m1().getSourceId(), new g());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void G4() {
        ReadingAutoSlideLayout readingAutoSlideLayout;
        ReadingAutoSlideLayout readingAutoSlideLayout2;
        ReadMenu root;
        ReadMenu root2;
        if (!m0()) {
            f4();
            g4("自动阅读");
            ReadingReadMenuBinding readingReadMenuBinding = this.readMenuBinding;
            if (readingReadMenuBinding != null && (root2 = readingReadMenuBinding.getRoot()) != null) {
                root2.U(false);
            }
            ReadingReadMenuBinding readingReadMenuBinding2 = this.readMenuBinding;
            if (readingReadMenuBinding2 != null && (root = readingReadMenuBinding2.getRoot()) != null) {
                ReadMenu.c0(root, null, 1, null);
            }
            S4();
            M0();
            j0(ReadingInstance.ScreenOffTime.AlwaysLight, false);
            return;
        }
        if (this.autoSlideBinding == null) {
            ((ActivityReadingNewBinding) a1()).autoSlideViewStub.setLayoutResource(R.layout.reader_menu_auto_slide);
            ReaderMenuAutoSlideBinding bind = ReaderMenuAutoSlideBinding.bind(((ActivityReadingNewBinding) a1()).autoSlideViewStub.inflate());
            this.autoSlideBinding = bind;
            if (bind != null && (readingAutoSlideLayout2 = bind.readingAutoSlideLayout) != null) {
                BottomSheetBehavior from = BottomSheetBehavior.from(readingAutoSlideLayout2);
                Intrinsics.checkNotNullExpressionValue(from, "from(...)");
                from.setDraggable(true);
                from.setSkipCollapsed(true);
                from.setState(5);
                from.addBottomSheetCallback(new f());
            }
            ae.a aVar = this.autoSliderController;
            if (aVar != null) {
                aVar.c();
            }
            m1().U2(true, 1);
        }
        ReaderMenuAutoSlideBinding readerMenuAutoSlideBinding = this.autoSlideBinding;
        if (readerMenuAutoSlideBinding == null || (readingAutoSlideLayout = readerMenuAutoSlideBinding.readingAutoSlideLayout) == null) {
            return;
        }
        if (BottomSheetBehavior.from(readingAutoSlideLayout).getState() == 3) {
            BottomSheetBehavior.from(readingAutoSlideLayout).setState(5);
        } else {
            BottomSheetBehavior.from(readingAutoSlideLayout).setState(3);
        }
    }

    @Override // gd.a
    public void H() {
        ReaderSlidingAdapter readerSlidingAdapter;
        MiReadingContent Q0;
        g4("举报");
        Book book = m1().getBook();
        ReaderSlidingAdapter readerSlidingAdapter2 = this.mSlidingAdapter;
        Chapter chapter = null;
        if (readerSlidingAdapter2 != null) {
            if ((readerSlidingAdapter2 != null ? readerSlidingAdapter2.Q0() : null) != null && (readerSlidingAdapter = this.mSlidingAdapter) != null && (Q0 = readerSlidingAdapter.Q0()) != null) {
                chapter = Q0.getChapter();
            }
        }
        i.M(this, book, chapter);
        ReadingMoreItemPopupWindow readingMoreItemPopupWindow = this.menuPopupWindow;
        if (readingMoreItemPopupWindow != null) {
            readingMoreItemPopupWindow.dismiss();
        }
    }

    @Override // gd.a
    public void H0() {
        if (A4() || m1().getIsVip() || m0()) {
            return;
        }
        if (m1().getAdHiding() && !ReadingInstance.z().y0(this)) {
            if (MiConfigSingleton.b2().C2()) {
                O0();
            } else {
                RewardVideoAdManager i32 = i3();
                if (i32 != null && i32.o(true)) {
                    m1().C2();
                    return;
                }
                O0();
            }
        }
        if (MiConfigSingleton.b2().C2() || ReadingInstance.z().y0(this) || m1().P1()) {
            return;
        }
        if (B4()) {
            m1().C2();
            return;
        }
        RewardVideoAdManager i33 = i3();
        Intrinsics.checkNotNull(i33);
        if (i33.n()) {
            m1().C2();
            return;
        }
        RewardVideoAdManager i34 = i3();
        Intrinsics.checkNotNull(i34);
        if (i34.o(false)) {
            m1().C2();
        }
    }

    public final void H4() {
        if (m1().u3(this)) {
            return;
        }
        d3().l1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // gd.a
    public void I() {
        if (this.mSlidingAdapter != null) {
            if (MiConfigSingleton.b2().E2()) {
                ((ActivityReadingNewBinding) a1()).readingScrollContainer.slReadingContainer.D(false);
            } else {
                F0("底通-关闭广告");
            }
        }
    }

    @Override // gd.a
    public void I0() {
        m1().l2();
        a.C0540a.c(this, true, null, 2, null);
        ReadingMoreItemPopupWindow readingMoreItemPopupWindow = this.menuPopupWindow;
        if (readingMoreItemPopupWindow != null) {
            readingMoreItemPopupWindow.dismiss();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void I4(int r32, int r42) {
        MiReadingContent Q0;
        ReaderSlidingAdapter readerSlidingAdapter = this.mSlidingAdapter;
        if (readerSlidingAdapter == null) {
            return;
        }
        if (r32 < 0 || !(readerSlidingAdapter == null || (Q0 = readerSlidingAdapter.Q0()) == null || !Q0.isReady())) {
            if (r32 < 0) {
                ((ActivityReadingNewBinding) a1()).readingScrollContainer.slReadingContainer.D(false);
                r32 = 0;
            }
            h0(false);
            j0(ReadingInstance.ScreenOffTime.AlwaysLight, false);
            this.mTtsChapterIndex = r32;
            this.mTtsContentPos = r42;
            V3(false);
            f4();
        }
    }

    @Override // gd.a
    public void J0(@l RewardVideoAdManager.VideoType type) {
        RewardVideoAdManager i32 = i3();
        if (i32 != null) {
            i32.q(type);
        }
    }

    public final void J4() {
        List<TYBookItem> readBooks;
        boolean R1 = m1().R1();
        List<TYBookItem> u12 = m1().u1();
        boolean z10 = (u12 != null ? u12.size() : 0) >= ReadingExitRecommendDialogFragment.INSTANCE.b(this);
        TYBookTopUser tyBookTopUser = m1().getTyBookTopUser();
        boolean z11 = ((tyBookTopUser == null || (readBooks = tyBookTopUser.getReadBooks()) == null) ? 0 : readBooks.size()) > 0;
        boolean z12 = m1().getTotalSeconds() > 1200;
        boolean z13 = m1().getTotalSeconds() < 30;
        if (R1) {
            if (!z10 && !z11) {
                super.finish();
                return;
            } else if (Y3()) {
                super.finish();
                return;
            } else {
                C4(z10, z11);
                return;
            }
        }
        if (z12 && ReadingInstance.z().K(this)) {
            w("自动");
            if (!z10 && !z11) {
                super.finish();
                return;
            } else if (Y3()) {
                super.finish();
                return;
            } else {
                C4(z10, z11);
                return;
            }
        }
        if (z10) {
            if (Y3()) {
                super.finish();
                return;
            } else {
                ReadingAddShelfRecommendBooksDialogFragment.INSTANCE.d(this);
                return;
            }
        }
        if (m1().getChapterList() == null || z13) {
            super.finish();
        } else {
            g4("加入书架-弹窗-展示");
            i0.x0(this, getResources().getString(R.string.save_information), getResources().getString(R.string.save_information_hint), getResources().getString(R.string.search_close), getResources().getString(R.string.add_to_book_store), true, new i0.l() { // from class: bd.t0
                public /* synthetic */ t0() {
                }

                @Override // l9.i0.l
                public final void a() {
                    ReadingNewActivity.K4(ReadingNewActivity.this);
                }
            }, new i0.k() { // from class: bd.u0
                public /* synthetic */ u0() {
                }

                @Override // l9.i0.k
                public final void a() {
                    ReadingNewActivity.L4(ReadingNewActivity.this);
                }
            });
        }
    }

    @Override // com.martian.mibook.mvvm.read.widget.a
    public void K() {
        MiReadingContent Q0;
        if (ClickUtils.INSTANCE.isClickable(1000L)) {
            g4("听书");
            ReaderSlidingAdapter readerSlidingAdapter = this.mSlidingAdapter;
            if (readerSlidingAdapter == null || ((this.mTtsChapterIndex >= 0 && (readerSlidingAdapter == null || (Q0 = readerSlidingAdapter.Q0()) == null || !Q0.isReady())) || m1().getChapterList() == null)) {
                t0.b(this, "请等待数据加载完毕");
            } else {
                M4();
            }
        }
    }

    @Override // com.martian.mibook.mvvm.read.widget.a
    public void L0() {
        ReaderSlidingAdapter readerSlidingAdapter = this.mSlidingAdapter;
        if (readerSlidingAdapter != null) {
            readerSlidingAdapter.A1();
        }
    }

    @Override // com.martian.mibook.mvvm.read.widget.a
    public void M() {
        g4("追更推送");
        this.notificationSettingActivityResultLauncher.launch(h.a(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.mvvm.read.widget.a
    public void M0() {
        if (this.autoSliderController == null) {
            this.autoSliderController = new ae.a(((ActivityReadingNewBinding) a1()).readingScrollContainer.slReadingContainer);
        }
        m1().U2(false, 1);
        ae.a aVar = this.autoSliderController;
        if (aVar != null) {
            aVar.f(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void M3(Integer r32, Integer r42, int recordType) {
        int intValue = r32 != null ? r32.intValue() : 0;
        int intValue2 = r42 != null ? r42.intValue() : 0;
        if (this.mSlidingAdapter != null) {
            Z3(intValue, intValue2);
            return;
        }
        m1().x2(intValue);
        ReaderSlidingAdapter readerSlidingAdapter = new ReaderSlidingAdapter(this);
        this.mSlidingAdapter = readerSlidingAdapter;
        readerSlidingAdapter.K1(intValue2, recordType);
        if (MiConfigSingleton.b2().t0("READING_PAGE") == 2) {
            U();
        }
        if (intValue >= 0 || this.firstGuideBinding != null) {
            h0(false);
        } else if (!TTSReadManager.q()) {
            m1().C2();
        }
        if (intValue < 0) {
            l9.a.a(this, ((ActivityReadingNewBinding) a1()).readingScrollContainer.readingBonus.getRoot(), false, l9.a.f27957c);
        }
        T3();
        a.C0540a.a(this, false, 1, null);
        H4();
    }

    public final void M4() {
        int i10 = m1().getCom.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String();
        ReaderSlidingAdapter readerSlidingAdapter = this.mSlidingAdapter;
        Q0(i10, readerSlidingAdapter != null ? readerSlidingAdapter.S0() : 0);
    }

    @Override // gd.a
    public void N() {
        if (m1().T1()) {
            t0.b(this, "本地书籍不支持详情");
            return;
        }
        g4(wd.a.f31697f);
        i.E(this, m1().getBook());
        ReadingMoreItemPopupWindow readingMoreItemPopupWindow = this.menuPopupWindow;
        if (readingMoreItemPopupWindow != null) {
            readingMoreItemPopupWindow.dismiss();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void N3() {
        ReadMenu root;
        ReadMenu root2;
        if (this.readMenuBinding == null) {
            ((ActivityReadingNewBinding) a1()).readMenuViewStub.setLayoutResource(R.layout.reading_read_menu);
            ReadingReadMenuBinding bind = ReadingReadMenuBinding.bind(((ActivityReadingNewBinding) a1()).readMenuViewStub.inflate());
            this.readMenuBinding = bind;
            if (bind != null && (root2 = bind.getRoot()) != null) {
                root2.setOnUpdatePullDownBookMark(new Function0<Unit>() { // from class: com.martian.mibook.mvvm.read.activity.ReadingNewActivity$initReadMenuView$1$1
                    public ReadingNewActivity$initReadMenuView$1$1() {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke */
                    public final void invoke2() {
                        ReadingNewActivity.this.f0();
                    }
                });
                View statusView = root2.getStatusView();
                com.gyf.immersionbar.d.l2(this, statusView);
                statusView.setBackgroundColor(MiConfigSingleton.b2().h2().h());
                ReadMenu.N(root2, false, 1, null);
                root2.setCacheModeVisible(m1().U1() ? 0 : 8);
                root2.setWithCommentsVisible((m1().U1() && MiConfigSingleton.b2().p3()) ? 0 : 8);
                root2.setVipViewVisible(MiConfigSingleton.b2().E2() ? 8 : 0);
                t4();
                root2.setOnChapterSeekBarChangeListener(new a(root2));
                root2.setVisibleReadingChapterSeek(8);
                List<MiReadingRecord> list = this.previousReadingRecords;
                if (list != null) {
                    list.clear();
                }
                if (m1().getCacheStatus() == CacheStatus.None) {
                    root2.setVisibleReadingCacheStatus(8);
                }
                long r10 = ReadingInstance.z().r();
                if (MiConfigSingleton.b2().C2() || r10 <= 0 || r10 <= MartianRPUserManager.a()) {
                    root2.setVisibleReadingHideAdView(8);
                    root2.B0();
                } else {
                    root2.setVisibleReadingHideAdView(0);
                    root2.y0(r10, new Function0<Unit>() { // from class: com.martian.mibook.mvvm.read.activity.ReadingNewActivity$initReadMenuView$1$4
                        public ReadingNewActivity$initReadMenuView$1$4() {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke */
                        public final void invoke2() {
                            ReadMenu.this.setVisibleReadingHideAdView(8);
                        }
                    });
                    root2.setHideAdCountDownTextColor(MiConfigSingleton.b2().h2().q());
                    root2.setHideAdMoreText(ExtKt.c("看视频加" + MiConfigSingleton.b2().I1(m1().getAdHiding()) + "分钟"));
                }
                root2.setNightModeStatus(MiConfigSingleton.b2().H0());
                P4();
            }
        }
        ReadingReadMenuBinding readingReadMenuBinding = this.readMenuBinding;
        if (readingReadMenuBinding == null || (root = readingReadMenuBinding.getRoot()) == null) {
            return;
        }
        root.N0();
    }

    @Override // com.martian.mibook.mvvm.read.widget.a
    public void O(@l Function0<Unit> onMenuOutEnd) {
        ReadMenu root;
        ReadingMoreItemPopupWindow readingMoreItemPopupWindow = this.menuPopupWindow;
        if (readingMoreItemPopupWindow != null) {
            readingMoreItemPopupWindow.dismiss();
        }
        ReadingReadMenuBinding readingReadMenuBinding = this.readMenuBinding;
        if (readingReadMenuBinding == null || (root = readingReadMenuBinding.getRoot()) == null) {
            return;
        }
        root.b0(onMenuOutEnd);
    }

    @Override // gd.b
    public void O0() {
        int Q = MiConfigSingleton.b2().H1().Q(this) + 1;
        ReadingInstance.z().m0(this, MiConfigSingleton.b2().c2().getAdsDialogIntervalMinutes().intValue() * Q);
        MiConfigSingleton.b2().H1().N0(this, Q);
        m1().n2(false);
        if (!MiConfigSingleton.b2().C2()) {
            m1().V2(getString(R.string.click_for_ad_block));
        }
        H4();
    }

    public final void O3(Intent intent) {
        Integer intOrNull;
        Integer intOrNull2;
        Integer intOrNull3;
        String stringExtra = intent != null ? intent.getStringExtra(e0.L0) : null;
        if (!TextUtils.isEmpty(stringExtra)) {
            Uri parse = Uri.parse(stringExtra);
            String queryParameter = parse.getQueryParameter("sourceId");
            String queryParameter2 = parse.getQueryParameter("sourceName");
            if (ba.l.q(queryParameter) || ba.l.q(queryParameter2)) {
                z4(true, new ErrorResult(-1, "信息获取失败", null, 4, null));
                return;
            }
            String queryParameter3 = parse.getQueryParameter(BaseReadAloudService.f15168x);
            int i10 = 0;
            int intValue = (queryParameter3 == null || (intOrNull3 = StringsKt.toIntOrNull(queryParameter3)) == null) ? 0 : intOrNull3.intValue();
            String queryParameter4 = parse.getQueryParameter(BaseReadAloudService.f15169y);
            int intValue2 = (queryParameter4 == null || (intOrNull2 = StringsKt.toIntOrNull(queryParameter4)) == null) ? 0 : intOrNull2.intValue();
            String queryParameter5 = parse.getQueryParameter("contentLength");
            if (queryParameter5 != null && (intOrNull = StringsKt.toIntOrNull(queryParameter5)) != null) {
                i10 = intOrNull.intValue();
            }
            String queryParameter6 = parse.getQueryParameter("recContext");
            String queryParameter7 = parse.getQueryParameter("recommend");
            String queryParameter8 = parse.getQueryParameter("recommendId");
            ReadingViewModel m12 = m1();
            Intrinsics.checkNotNull(queryParameter);
            Intrinsics.checkNotNull(queryParameter2);
            m12.O1(this, queryParameter, queryParameter2, Integer.valueOf(intValue), Integer.valueOf(intValue2), Integer.valueOf(i10), queryParameter6, queryParameter7, queryParameter8);
            return;
        }
        String stringExtra2 = intent != null ? intent.getStringExtra(e0.I0) : null;
        if (ba.l.q(stringExtra2)) {
            f3();
            return;
        }
        if (StringsKt.equals(stringExtra2, m1().getSourceString(), true)) {
            return;
        }
        if (!TTSReadManager.r(stringExtra2)) {
            MiReadingRecord Z = MiConfigSingleton.b2().M1().Z();
            if (!StringsKt.equals(stringExtra2, Z != null ? Z.getSourceString() : null, true)) {
                z4(true, new ErrorResult(-1, "信息获取失败", null, 4, null));
                return;
            }
            ac.a.I(this, "通知栏-阅读记录-阅读");
            Book I = MiConfigSingleton.b2().M1().I(vb.e.l(Z != null ? Z.getSourceString() : null));
            if (intent != null) {
                intent.putExtra("intent_book", I);
            }
            if (intent != null) {
                intent.putExtra(e0.H0, true);
            }
            MiConfigSingleton.b2().V1().k(EventManager.f13207j, stringExtra2);
            f3();
            return;
        }
        ReadAloudBook readAloudBook = ReadAloudBook.f15003a;
        if (TextUtils.isEmpty(readAloudBook.b())) {
            return;
        }
        MiReadingRecord J = MiConfigSingleton.b2().M1().J(stringExtra2);
        if (J != null) {
            kc.b.q(this, J);
            return;
        }
        ChapterContent i11 = readAloudBook.i();
        Book a10 = readAloudBook.a();
        int c10 = readAloudBook.c();
        int f10 = readAloudBook.f();
        if (a10 != null) {
            kc.b.s(this, a10, Integer.valueOf(c10), Integer.valueOf(f10), i11 != null ? Integer.valueOf(i11.getContentLength()) : null, true);
        }
    }

    @Override // com.martian.mibook.mvvm.read.widget.a
    public void P() {
        ReadMenu root;
        ReadingReadMenuBinding readingReadMenuBinding = this.readMenuBinding;
        if (readingReadMenuBinding == null || (root = readingReadMenuBinding.getRoot()) == null) {
            return;
        }
        root.F0(ReadingSlideModeSettingLayout.class, true);
    }

    @Override // com.martian.mibook.mvvm.read.widget.a
    public void P0() {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setDataAndType(MediaStore.Images.Media.INTERNAL_CONTENT_URI, "image/*");
        this.photoLibraryActivityResultLauncher.launch(intent);
    }

    public final void P4() {
        ReadingReadMenuBinding readingReadMenuBinding;
        ReadMenu root;
        if (this.mSlidingAdapter == null || (readingReadMenuBinding = this.readMenuBinding) == null || (root = readingReadMenuBinding.getRoot()) == null) {
            return;
        }
        int i10 = m1().getCom.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String();
        ChapterList chapterList = m1().getChapterList();
        root.f0(i10, chapterList != null ? Integer.valueOf(chapterList.getCount()) : null);
    }

    @Override // com.martian.mibook.mvvm.read.widget.a
    public boolean Q(boolean isAddBookMark, @l MiBookMark bookMark) {
        ReaderSlidingAdapter readerSlidingAdapter = this.mSlidingAdapter;
        if (readerSlidingAdapter != null) {
            return readerSlidingAdapter.f1(isAddBookMark, bookMark);
        }
        return false;
    }

    @Override // gd.a
    public void Q0(int r22, int r32) {
        this.mTtsChapterIndex = r22;
        this.mTtsContentPos = r32;
        if (m1().Z1()) {
            j4(r22, r32);
        } else if (TTSReadManager.q()) {
            i0.z0(this, getString(R.string.confirm_message), getString(R.string.tts_another), new i0.l() { // from class: bd.k0
                public /* synthetic */ k0() {
                }

                @Override // l9.i0.l
                public final void a() {
                    ReadingNewActivity.N4(ReadingNewActivity.this);
                }
            });
        } else {
            I4(this.mTtsChapterIndex, this.mTtsContentPos);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Q3() {
        ReadingReadMenuBinding readingReadMenuBinding;
        ReadMenu root;
        ReadMenu root2;
        ReadMenu root3;
        R4();
        MiReadingRecord record = m1().getRecord();
        Integer valueOf = record != null ? Integer.valueOf(record.getChapterIndex()) : null;
        MiReadingRecord record2 = m1().getRecord();
        Integer contentIndex = record2 != null ? record2.getContentIndex() : null;
        MiReadingRecord record3 = m1().getRecord();
        M3(valueOf, contentIndex, record3 != null ? record3.getRecordType() : 0);
        if (this.mSlidingAdapter != null) {
            ReadingReadMenuBinding readingReadMenuBinding2 = this.readMenuBinding;
            if (readingReadMenuBinding2 != null && (root3 = readingReadMenuBinding2.getRoot()) != null) {
                ChapterList chapterList = m1().getChapterList();
                root3.setOnChapterSeekBarMax(chapterList != null ? Integer.valueOf(chapterList.getCount()) : null);
            }
            ReadingReadMenuBinding readingReadMenuBinding3 = this.readMenuBinding;
            if (readingReadMenuBinding3 != null && (root2 = readingReadMenuBinding3.getRoot()) != null) {
                root2.setOnChapterSeekBarProgress(m1().getCom.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String());
            }
            ReaderSlidingAdapter readerSlidingAdapter = this.mSlidingAdapter;
            if (readerSlidingAdapter != null) {
                readerSlidingAdapter.C1();
            }
        }
        if (m1().getCacheStatus() == CacheStatus.None && (readingReadMenuBinding = this.readMenuBinding) != null && (root = readingReadMenuBinding.getRoot()) != null) {
            root.setVisibleReadingCacheStatus(8);
        }
        ((ActivityReadingNewBinding) a1()).readingScrollContainer.readingBonus.floatMenu.post(new Runnable() { // from class: bd.q
            public /* synthetic */ q() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                ReadingNewActivity.R3(ReadingNewActivity.this);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Q4() {
        ReadingBonusBinding readingBonusBinding = ((ActivityReadingNewBinding) a1()).readingScrollContainer.readingBonus;
        readingBonusBinding.durationBonus.setVisibility(0);
        readingBonusBinding.durationBonusView.setVisibility(8);
        readingBonusBinding.durationCoins.setImageResource(R.drawable.icon_reading_coins);
        if (MiConfigSingleton.b2().G0()) {
            readingBonusBinding.durationCoins.setImageResource(R.drawable.icon_reading_coins_hint);
            readingBonusBinding.durationBonus.setText(getString(R.string.wait_network));
        } else {
            if (!MiConfigSingleton.b2().F2()) {
                readingBonusBinding.durationBonus.setText(getString(R.string.login_click));
                return;
            }
            if (m1().getTotalCoins() <= 0) {
                readingBonusBinding.durationBonus.setText(getString(R.string.bonus_opened));
                return;
            }
            readingBonusBinding.durationBonus.setVisibility(8);
            readingBonusBinding.durationBonusView.setVisibility(0);
            readingBonusBinding.durationBonusNum.setNumberText(m1().getTotalCoins());
            readingBonusBinding.durationBonusUnit.setVisibility(m1().getTotalCoins() >= 1000 ? 8 : 0);
        }
    }

    @Override // gd.b
    public void R() {
        MiConfigSingleton.b2().v0(m1().getSourceString());
        a();
    }

    @Override // gd.a
    public void R0() {
        BannerAdManager bannerAdManager = this.bannerAdManager;
        if (bannerAdManager != null) {
            bannerAdManager.f0();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R4() {
        ((ActivityReadingNewBinding) a1()).readingScrollContainer.lyFakeReadingLayout.lyReadingBackground.setPadding(0, 0, 0, m1().U() ? 0 : ConfigSingleton.i(64.0f));
    }

    @Override // gd.a
    public void S() {
        g4("去书架");
        m1().l2();
        kc.b.l(null, Integer.valueOf(j2.f33271l), 67108864);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ReadingNewActivity$onBookShelfClick$1(this, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S3() {
        g4("阅读界面-展示");
        if (getIsPortrait() != m1().getIsPortrait()) {
            i.B(this);
        }
        ((ActivityReadingNewBinding) a1()).readingScrollContainer.readingBonus.bonusFloatView.setPadding(0, m1().getReadingNotchHeight() + ConfigSingleton.i(12.0f), 0, 0);
        ReadingScrollContainerBinding readingScrollContainerBinding = ((ActivityReadingNewBinding) a1()).readingScrollContainer;
        h(readingScrollContainerBinding.lyFakeReadingLayout.llReadingContent.tvReadingTitleView, 13);
        h(readingScrollContainerBinding.tvScrollReadingTitleView, 0);
        m1().U2(ReadingInstance.z().N(this), 1);
        ((ActivityReadingNewBinding) a1()).readingScrollContainer.refreshLayout.setFixTouchEvent(true);
        pf.d refreshHeader = ((ActivityReadingNewBinding) a1()).readingScrollContainer.refreshLayout.getRefreshHeader();
        MiBookMarkHeader miBookMarkHeader = refreshHeader instanceof MiBookMarkHeader ? (MiBookMarkHeader) refreshHeader : null;
        if (miBookMarkHeader != null) {
            miBookMarkHeader.setOnRefreshListener(new MiBookMarkHeader.a() { // from class: com.martian.mibook.mvvm.read.activity.ReadingNewActivity$initReadingView$2
                public ReadingNewActivity$initReadingView$2() {
                }

                @Override // com.martian.mibook.mvvm.widget.MiBookMarkHeader.a
                public void a(boolean z10) {
                    BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(ReadingNewActivity.this), null, null, new ReadingNewActivity$initReadingView$2$onBookMark$1(z10, ReadingNewActivity.this, null), 3, null);
                }
            });
        }
        t(m1().getPrefShowFloatBonus());
        a0(m1().getPrefShowFloatMenu());
        ReadingSettingLayout.INSTANCE.e(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S4() {
        ((ActivityReadingNewBinding) a1()).readingScrollContainer.tvScrollReadingTitleView.setVisibility(m1().getIsScrollMode() ? 0 : 8);
        ((ActivityReadingNewBinding) a1()).readingScrollContainer.lyFakeReadingLayout.llReadingContent.tvReadingTitleView.setVisibility(m1().getIsScrollMode() ? 8 : 4);
        ((ActivityReadingNewBinding) a1()).readingScrollContainer.lyFakeReadingLayout.lyReadingBottomStatus.getRoot().setVisibility(m1().getIsScrollMode() ? 8 : 4);
    }

    @Override // com.martian.mibook.mvvm.read.widget.a
    public void T() {
        g4("上一章");
        if (m1().getChapterList() == null) {
            t0.b(this, "请等待数据加载完毕");
        } else {
            M3(Integer.valueOf(m1().getCom.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String() - 1), 0, 0);
            P4();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void T3() {
        S4();
        ((ActivityReadingNewBinding) a1()).readingScrollContainer.slReadingContainer.setAdapter(this.mSlidingAdapter);
        ((ActivityReadingNewBinding) a1()).readingScrollContainer.slReadingContainer.setSlider(ReadingInstance.z().C(this));
        ((ActivityReadingNewBinding) a1()).readingScrollContainer.slReadingContainer.setOnSlideChangeListener(new b());
        ((ActivityReadingNewBinding) a1()).readingScrollContainer.slReadingContainer.setOnTapListener(this);
    }

    public final void T4() {
        ReadMenu root;
        String sourceId;
        boolean r10 = TTSReadManager.r(m1().getSourceString());
        if (MiConfigSingleton.b2().C2() && (sourceId = m1().getSourceId()) != null && StringsKt.contains$default((CharSequence) sourceId, (CharSequence) "xmly", false, 2, (Object) null)) {
            r10 = true;
        }
        ReadingReadMenuBinding readingReadMenuBinding = this.readMenuBinding;
        if (readingReadMenuBinding == null || (root = readingReadMenuBinding.getRoot()) == null) {
            return;
        }
        root.setVisibleTtsIcon(r10 ? 8 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.mvvm.read.widget.a
    public void U() {
        RelativeLayout relativeLayout;
        u4();
        if (this.firstGuideBinding == null) {
            g4("阅读引导-展示");
            m1().C2();
            ((ActivityReadingNewBinding) a1()).firstGuideView.setLayoutResource(R.layout.reading_first_guide);
            ReadingFirstGuideBinding bind = ReadingFirstGuideBinding.bind(((ActivityReadingNewBinding) a1()).firstGuideView.inflate());
            this.firstGuideBinding = bind;
            l9.a.c(bind != null ? bind.guideHandIcon : null);
            ReadingFirstGuideBinding readingFirstGuideBinding = this.firstGuideBinding;
            if (readingFirstGuideBinding != null && (relativeLayout = readingFirstGuideBinding.guideView) != null) {
                relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: bd.r0
                    public /* synthetic */ r0() {
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ReadingNewActivity.n3(ReadingNewActivity.this, view);
                    }
                });
            }
        }
        ReadingFirstGuideBinding readingFirstGuideBinding2 = this.firstGuideBinding;
        RelativeLayout root = readingFirstGuideBinding2 != null ? readingFirstGuideBinding2.getRoot() : null;
        if (root == null) {
            return;
        }
        root.setVisibility(0);
    }

    public final void U3() {
        m1().e3(ReadingInstance.z().P(this));
        S4();
        o3();
        v0();
    }

    public final void V3(boolean initial) {
        this.mTtsPosSyncOn = true;
        if (!initial && m1().getBook() != null) {
            kc.b.f(m1().getBook(), this.mTtsChapterIndex, this.mTtsContentPos, true, null, 16, null);
        }
        TTSReadManager.t(this);
        TTSReadManager.x(this, new Observer() { // from class: bd.c0
            public /* synthetic */ c0() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReadingNewActivity.W3(ReadingNewActivity.this, (Boolean) obj);
            }
        });
    }

    @Override // gd.b
    public void W() {
        ReaderSlidingAdapter readerSlidingAdapter = this.mSlidingAdapter;
        if (readerSlidingAdapter != null) {
            readerSlidingAdapter.O2();
        }
    }

    public final void W2(int duration) {
        if (duration <= 6 || !MiConfigSingleton.b2().F2()) {
            return;
        }
        ReadingViewModel m12 = m1();
        ReaderSlidingAdapter readerSlidingAdapter = this.mSlidingAdapter;
        boolean z10 = false;
        if (readerSlidingAdapter != null && readerSlidingAdapter.p1()) {
            z10 = true;
        }
        Boolean valueOf = Boolean.valueOf(z10);
        ReaderSlidingAdapter readerSlidingAdapter2 = this.mSlidingAdapter;
        m12.k2(duration, valueOf, readerSlidingAdapter2 != null ? readerSlidingAdapter2.M0(null) : null);
    }

    @Override // com.martian.mibook.mvvm.read.widget.a
    public void X() {
        if (!MiConfigSingleton.b2().K2()) {
            F0("导入字体");
        } else {
            this.typefaceScanActivityResultLauncher.launch(new Intent(this, (Class<?>) TypefaceScanActivity.class));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void X2() {
        TextView textView;
        ImageView imageView;
        if (m1().getCloseNetworkOffCheck()) {
            return;
        }
        if (MiConfigSingleton.b2().G0()) {
            ac.a.H(this, "无网络-展示");
            if (this.networkOfflineBinding == null) {
                ((ActivityReadingNewBinding) a1()).networkOfflineView.setLayoutResource(R.layout.reading_network_offline);
                ReadingNetworkOfflineBinding bind = ReadingNetworkOfflineBinding.bind(((ActivityReadingNewBinding) a1()).networkOfflineView.inflate());
                this.networkOfflineBinding = bind;
                TextView textView2 = bind != null ? bind.tvNetworkOffline : null;
                if (textView2 != null) {
                    textView2.setText(ExtKt.c("网络无法连接，请检查您的网络设置"));
                }
                ReadingNetworkOfflineBinding readingNetworkOfflineBinding = this.networkOfflineBinding;
                if (readingNetworkOfflineBinding != null && (imageView = readingNetworkOfflineBinding.ivNativeCloseIcon) != null) {
                    imageView.setOnClickListener(new View.OnClickListener() { // from class: bd.i0
                        public /* synthetic */ i0() {
                        }

                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ReadingNewActivity.Y2(ReadingNewActivity.this, view);
                        }
                    });
                }
                ReadingNetworkOfflineBinding readingNetworkOfflineBinding2 = this.networkOfflineBinding;
                if (readingNetworkOfflineBinding2 != null && (textView = readingNetworkOfflineBinding2.tvNetworkOffline) != null) {
                    textView.setOnClickListener(new View.OnClickListener() { // from class: bd.j0
                        public /* synthetic */ j0() {
                        }

                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ReadingNewActivity.Z2(ReadingNewActivity.this, view);
                        }
                    });
                }
            }
            ReadingNetworkOfflineBinding readingNetworkOfflineBinding3 = this.networkOfflineBinding;
            ReaderThemeRelativeLayout root = readingNetworkOfflineBinding3 != null ? readingNetworkOfflineBinding3.getRoot() : null;
            if (root != null) {
                root.setVisibility(0);
            }
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getDefault(), null, new ReadingNewActivity$checkNetworkStatus$3(this, null), 2, null);
        } else {
            ReadingNetworkOfflineBinding readingNetworkOfflineBinding4 = this.networkOfflineBinding;
            ReaderThemeRelativeLayout root2 = readingNetworkOfflineBinding4 != null ? readingNetworkOfflineBinding4.getRoot() : null;
            if (root2 != null) {
                root2.setVisibility(8);
            }
        }
        Q4();
    }

    public final boolean X3() {
        ReadMenu root;
        boolean z10 = false;
        if (m.D(this)) {
            return false;
        }
        ReadingReadMenuBinding readingReadMenuBinding = this.readMenuBinding;
        if (readingReadMenuBinding != null && (root = readingReadMenuBinding.getRoot()) != null && root.getVisibility() == 0) {
            z10 = true;
        }
        return !z10;
    }

    @Override // com.martian.mibook.mvvm.read.widget.a
    public void Y() {
        ReadMenu root;
        g4("更多设置");
        ReadingReadMenuBinding readingReadMenuBinding = this.readMenuBinding;
        if (readingReadMenuBinding == null || (root = readingReadMenuBinding.getRoot()) == null) {
            return;
        }
        root.F0(ReadingMoreSettingLayout.class, true);
    }

    public final boolean Y3() {
        if (System.currentTimeMillis() - this.lastRecommendBooksTime < 5000) {
            return true;
        }
        this.lastRecommendBooksTime = System.currentTimeMillis();
        return false;
    }

    @Override // gd.a
    public void Z() {
        if (!m1().getAdHiding()) {
            m1().C2();
        }
        RewardVideoAdManager i32 = i3();
        if (i32 != null) {
            i32.p(this, m1().getSourceString(), m1().getAdHiding());
        }
    }

    public final void Z3(int r32, int r42) {
        MiReadingRecord record;
        ChapterList chapterList = m1().getChapterList();
        int count = chapterList != null ? chapterList.getCount() : 0;
        if (r32 >= 0 && count > 0 && r32 < count) {
            MiReadingRecord record2 = m1().getRecord();
            if (record2 != null) {
                record2.setChapterIndex(Integer.valueOf(r32));
            }
            MiReadingRecord record3 = m1().getRecord();
            if (record3 != null) {
                record3.setContentPos(Integer.valueOf(r42));
            }
        }
        if (r32 >= 0 && m1().getChapterList() != null) {
            ChapterList chapterList2 = m1().getChapterList();
            Intrinsics.checkNotNull(chapterList2);
            if (r32 < chapterList2.getCount()) {
                ChapterList chapterList3 = m1().getChapterList();
                Chapter item = chapterList3 != null ? chapterList3.getItem(r32) : null;
                if (item != null && (record = m1().getRecord()) != null) {
                    record.setChapterTitle(item.getTitle());
                }
            }
        }
        ReaderSlidingAdapter readerSlidingAdapter = this.mSlidingAdapter;
        if (readerSlidingAdapter != null) {
            readerSlidingAdapter.s1(r32, r42);
        }
    }

    @Override // gd.a
    public void a() {
        ReaderSlidingAdapter readerSlidingAdapter = this.mSlidingAdapter;
        if (readerSlidingAdapter != null) {
            readerSlidingAdapter.u();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.mvvm.read.widget.a
    public void a0(boolean showMenu) {
        ((ActivityReadingNewBinding) a1()).readingScrollContainer.readingBonus.floatMenu.setVisibility(showMenu ? 0 : 8);
        ReaderSlidingAdapter readerSlidingAdapter = this.mSlidingAdapter;
        if (readerSlidingAdapter != null) {
            readerSlidingAdapter.N2();
        }
    }

    public final void a3() {
        ReadingInstance.z().k(this, this.handler, this.screenOffRunnable);
    }

    @Override // com.martian.mibook.mvvm.read.widget.a
    public void b0() {
        ae.a aVar = this.autoSliderController;
        if (aVar != null) {
            Intrinsics.checkNotNull(aVar);
            if (!aVar.g() || this.mSlidingAdapter == null) {
                return;
            }
            S4();
            t0.b(this, "已退出自动阅读模式");
            j0(ReadingInstance.ScreenOffTime.Init, false);
            m1().U2(ReadingInstance.z().N(this), 1);
        }
    }

    public final void b3() {
        ReadingInstance.z().l(this, this.handler, this.screenOffRunnable);
    }

    @Override // gd.b
    public void c() {
        m1().R(this);
        ReadingViewModel m12 = m1();
        MiReadingRecord record = m1().getRecord();
        m12.v3(this, record != null ? record.getChapterIndex() : 0);
    }

    @Override // com.martian.mibook.mvvm.base.BaseActivity
    public void c1(@l Bundle savedInstanceState) {
        g(false);
        q3();
        O3(getIntent());
        S3();
        U3();
        if (MiConfigSingleton.b2().C2()) {
            SensorHook.INSTANCE.getInstance().disableSensor();
        }
    }

    public final boolean c3(int x10, int y10) {
        int i10 = getResources().getDisplayMetrics().widthPixels;
        int i11 = getResources().getDisplayMetrics().heightPixels;
        if (!m1().getIsScrollMode()) {
            int w10 = ReadingInstance.z().w(this);
            if (w10 == ReadingInstance.ClickRule.RULE_3.getClickRuleValue() || w10 == ReadingInstance.ClickRule.RULE_4.getClickRuleValue()) {
                if (x10 <= i10 / 3 || x10 >= (i10 * 2) / 3) {
                    return false;
                }
            } else if (x10 <= i10 / 3 || x10 >= (i10 * 2) / 3 || y10 <= i11 / 3 || y10 >= (i11 * 2) / 3) {
                return false;
            }
        } else if (ReadingInstance.z().U(this) && (y10 <= i11 / 3 || y10 >= (i11 * 2) / 3)) {
            return false;
        }
        return true;
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: c4 */
    public void onChanged(@l ReadAloudBook.ReadAloudPlayerStatus status) {
        ReadMenu root;
        FrameLayout ttsFloatView;
        ReadMenu root2;
        ReadAloudBook.ReadAloudPlayerStatus readAloudPlayerStatus = ReadAloudBook.ReadAloudPlayerStatus.STATE_PRE_PLAY;
        if (status != readAloudPlayerStatus && status != ReadAloudBook.ReadAloudPlayerStatus.STATE_PAUSED) {
            if (status == ReadAloudBook.ReadAloudPlayerStatus.STATE_STOPPED) {
                h4(ReadAloudBook.f15003a.b());
                return;
            }
            return;
        }
        ReadingReadMenuBinding readingReadMenuBinding = this.readMenuBinding;
        if (readingReadMenuBinding != null && (root = readingReadMenuBinding.getRoot()) != null && (ttsFloatView = root.getTtsFloatView()) != null && ttsFloatView.getChildCount() == 0) {
            ReadingReadMenuBinding readingReadMenuBinding2 = this.readMenuBinding;
            id.i.a(this, (readingReadMenuBinding2 == null || (root2 = readingReadMenuBinding2.getRoot()) == null) ? null : root2.getTtsFloatView());
            T4();
        }
        if (status == readAloudPlayerStatus) {
            TTSReadManager.x(this, new Observer() { // from class: bd.g0
                public /* synthetic */ g0() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ReadingNewActivity.d4(ReadingNewActivity.this, (Boolean) obj);
                }
            });
        }
    }

    @Override // com.martian.mibook.mvvm.read.widget.a
    public void d() {
        ac.a.y(this, "阅读菜单-点击");
        kc.b.v(m1().getSourceName(), m1().getSourceId());
    }

    @Override // com.martian.mibook.mvvm.read.widget.a
    public void d0(boolean refreshViewListenerColor) {
        n4(refreshViewListenerColor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final BannerAdManager d3() {
        BannerAdManager bannerAdManager;
        if (this.bannerAdManager == null) {
            this.bannerAdManager = new BannerAdManager(this, m1().getSourceString(), ((ActivityReadingNewBinding) a1()).readingScrollContainer.readingBanner, this.mSlidingAdapter, m1().getEnableBaeAdInfo(), MiConfigSingleton.b2().M1().z1(this, m1().getBook()));
            if (m1().getCom.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String() < 0 && (bannerAdManager = this.bannerAdManager) != null) {
                bannerAdManager.e1();
            }
            BannerAdManager bannerAdManager2 = this.bannerAdManager;
            if (bannerAdManager2 != null) {
                bannerAdManager2.h0(new b.c() { // from class: bd.l0
                    public /* synthetic */ l0() {
                    }

                    @Override // com.martian.mibook.application.b.c
                    public final void a() {
                        ReadingNewActivity.e3(ReadingNewActivity.this);
                    }
                });
            }
        }
        BannerAdManager bannerAdManager3 = this.bannerAdManager;
        Intrinsics.checkNotNull(bannerAdManager3);
        return bannerAdManager3;
    }

    @Override // com.martian.mibook.mvvm.read.widget.a
    public void e() {
        ReadMenu root;
        ReadingReadMenuBinding readingReadMenuBinding = this.readMenuBinding;
        if (readingReadMenuBinding == null || (root = readingReadMenuBinding.getRoot()) == null) {
            return;
        }
        root.F0(ReadingTypeFaceSettingLayout.class, true);
    }

    @Override // gd.a
    public void e0(boolean withToast) {
        m1().d3(true);
        AppViewModel l12 = l1();
        if (l12 != null) {
            l12.l0(true);
        }
        m1().s3(false);
        ReaderSlidingAdapter readerSlidingAdapter = this.mSlidingAdapter;
        if (readerSlidingAdapter != null) {
            readerSlidingAdapter.E2(withToast);
        }
        H4();
    }

    public final void e4() {
        BannerAdManager bannerAdManager = this.bannerAdManager;
        if (bannerAdManager != null) {
            bannerAdManager.N0();
        }
        ReaderSlidingAdapter readerSlidingAdapter = this.mSlidingAdapter;
        if (readerSlidingAdapter != null) {
            readerSlidingAdapter.E1();
        }
        f4();
    }

    @Override // com.martian.mibook.mvvm.read.widget.a
    public void f(boolean show, boolean withToast) {
        ReadMenu root;
        ReaderSlidingAdapter readerSlidingAdapter;
        if (withToast) {
            t0.b(this, ExtKt.c(show ? "已显示评论内容" : "已隐藏评论内容"));
        }
        g4("章评-" + (withToast ? "显示" : "隐藏"));
        ReadingInstance.z().s0(this, show);
        m1().i3(show);
        if (!show && (readerSlidingAdapter = this.mSlidingAdapter) != null) {
            readerSlidingAdapter.C0();
        }
        a();
        ReadingReadMenuBinding readingReadMenuBinding = this.readMenuBinding;
        if (readingReadMenuBinding == null || (root = readingReadMenuBinding.getRoot()) == null) {
            return;
        }
        root.M0(ReadingInstance.z().B0(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // gd.a
    public void f0() {
        ((ActivityReadingNewBinding) a1()).readingScrollContainer.refreshLayout.j0(m1().getPullDownMarkFlag() == 3);
    }

    public final void f3() {
        Intent intent = getIntent();
        Serializable serializableExtra = intent != null ? intent.getSerializableExtra("intent_book") : null;
        Book book = serializableExtra instanceof Book ? (Book) serializableExtra : null;
        Intent intent2 = getIntent();
        Integer valueOf = intent2 != null ? Integer.valueOf(intent2.getIntExtra(e0.E0, 0)) : null;
        Intent intent3 = getIntent();
        Integer valueOf2 = intent3 != null ? Integer.valueOf(intent3.getIntExtra(e0.F0, 0)) : null;
        Intent intent4 = getIntent();
        Integer valueOf3 = intent4 != null ? Integer.valueOf(intent4.getIntExtra(e0.G0, 0)) : null;
        Intent intent5 = getIntent();
        boolean booleanExtra = intent5 != null ? intent5.getBooleanExtra(e0.H0, false) : false;
        if (book == null || TextUtils.isEmpty(book.getSourceName()) || TextUtils.isEmpty(book.getSourceId())) {
            z4(true, new ErrorResult(-1, "信息获取失败", null, 4, null));
            return;
        }
        m1().N1(this, book, valueOf, valueOf2, valueOf3, booleanExtra);
        if (TTSReadManager.q()) {
            V3(true);
        }
        m1().b0();
        MiConfigSingleton.b2().M1().T2(m1().getSourceString());
        m1().W();
    }

    public final void f4() {
        ReaderSlidingAdapter readerSlidingAdapter = this.mSlidingAdapter;
        if (readerSlidingAdapter == null) {
            return;
        }
        if (readerSlidingAdapter != null) {
            readerSlidingAdapter.E0();
        }
        a();
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMActivity, android.app.Activity
    public void finish() {
        ComponentName componentName;
        String className;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        if (m1().getTotalCoins() > 0) {
            Intent intent = new Intent();
            intent.putExtra(e0.f33179u0, m1().getTotalCoins());
            setResult(-1, intent);
        }
        if (m1().getFromIntent()) {
            Object systemService = getSystemService(TTDownloadField.TT_ACTIVITY);
            ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
            ActivityManager.RunningTaskInfo runningTaskInfo = (activityManager == null || (runningTasks = activityManager.getRunningTasks(1)) == null) ? null : runningTasks.get(0);
            if ((runningTaskInfo != null ? runningTaskInfo.baseActivity : null) == null) {
                J4();
                return;
            }
            componentName = runningTaskInfo.baseActivity;
            if (Intrinsics.areEqual((componentName == null || (className = componentName.getClassName()) == null) ? null : Boolean.valueOf(StringsKt.contains$default((CharSequence) className, (CharSequence) "HomeActivity", false, 2, (Object) null)), Boolean.FALSE)) {
                if (!m1().R1()) {
                    w("intent");
                }
                kc.b.m(null, null, null, 7, null);
                BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getDefault(), null, new ReadingNewActivity$finish$1(this, null), 2, null);
                return;
            }
        }
        J4();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.libsliding.a.InterfaceC0522a
    public void g0(@k Point r52) {
        ReaderSlidingAdapter readerSlidingAdapter;
        ReadMenu root;
        Intrinsics.checkNotNullParameter(r52, "point");
        ReaderSlidingAdapter readerSlidingAdapter2 = this.mSlidingAdapter;
        if ((readerSlidingAdapter2 != null && readerSlidingAdapter2.m1()) || (((readerSlidingAdapter = this.mSlidingAdapter) != null && !readerSlidingAdapter.p()) || m0())) {
            n0();
            return;
        }
        ReadingReadMenuBinding readingReadMenuBinding = this.readMenuBinding;
        if (readingReadMenuBinding != null && (root = readingReadMenuBinding.getRoot()) != null && root.getShowMenu()) {
            h0(false);
            return;
        }
        if (c3(r52.x, r52.y)) {
            h0(true);
            return;
        }
        if (m1().getIsScrollMode() || r52.y >= com.gyf.immersionbar.d.H0(this) + ConfigSingleton.i(64.0f)) {
            if (ReadingInstance.z().L(this)) {
                ((ActivityReadingNewBinding) a1()).readingScrollContainer.slReadingContainer.D(true);
                return;
            }
            int i10 = getResources().getDisplayMetrics().widthPixels;
            int i11 = getResources().getDisplayMetrics().heightPixels;
            if (m1().getIsScrollMode()) {
                if (ReadingInstance.z().U(this)) {
                    if (r52.y > (i11 * 2) / 3) {
                        ((ActivityReadingNewBinding) a1()).readingScrollContainer.slReadingContainer.D(true);
                        return;
                    } else {
                        ((ActivityReadingNewBinding) a1()).readingScrollContainer.slReadingContainer.E(true);
                        return;
                    }
                }
                return;
            }
            int w10 = ReadingInstance.z().w(this);
            if (w10 == ReadingInstance.ClickRule.RULE_2.getClickRuleValue() || w10 == ReadingInstance.ClickRule.RULE_4.getClickRuleValue()) {
                ((ActivityReadingNewBinding) a1()).readingScrollContainer.slReadingContainer.D(true);
            } else if (r52.x > i10 / 2) {
                ((ActivityReadingNewBinding) a1()).readingScrollContainer.slReadingContainer.D(true);
            } else {
                ((ActivityReadingNewBinding) a1()).readingScrollContainer.slReadingContainer.E(true);
            }
        }
    }

    @l
    public final String g3() {
        return m1().getSourceString();
    }

    public final void g4(String r12) {
        ac.a.L(this, r12);
    }

    @Override // gd.a
    public void h(@l View titleView, int paddingBottom) {
        if (titleView != null) {
            titleView.setPadding(ConfigSingleton.i(24.0f), m1().getReadingNotchHeight() + ConfigSingleton.i(13.0f), h3(), ConfigSingleton.i(paddingBottom));
        }
    }

    @Override // gd.a
    public void h0(boolean showMenu) {
        ReadMenu root;
        ReadMenu root2;
        ReadMenu root3;
        ReadMenu root4;
        if (!showMenu) {
            ReadingMoreItemPopupWindow readingMoreItemPopupWindow = this.menuPopupWindow;
            if (readingMoreItemPopupWindow != null) {
                readingMoreItemPopupWindow.dismiss();
            }
            ReadingReadMenuBinding readingReadMenuBinding = this.readMenuBinding;
            if (readingReadMenuBinding == null || (root = readingReadMenuBinding.getRoot()) == null) {
                return;
            }
            ReadMenu.c0(root, null, 1, null);
            return;
        }
        N3();
        if (m0()) {
            G4();
            return;
        }
        if (this.mSlidingAdapter != null) {
            ReadingReadMenuBinding readingReadMenuBinding2 = this.readMenuBinding;
            if (readingReadMenuBinding2 != null && (root4 = readingReadMenuBinding2.getRoot()) != null) {
                ChapterList chapterList = m1().getChapterList();
                root4.setOnChapterSeekBarMax(chapterList != null ? Integer.valueOf(chapterList.getCount()) : null);
            }
            ReadingReadMenuBinding readingReadMenuBinding3 = this.readMenuBinding;
            if (readingReadMenuBinding3 != null && (root3 = readingReadMenuBinding3.getRoot()) != null) {
                root3.setOnChapterSeekBarProgress(m1().getCom.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String());
            }
        }
        ReadingReadMenuBinding readingReadMenuBinding4 = this.readMenuBinding;
        if (readingReadMenuBinding4 == null || (root2 = readingReadMenuBinding4.getRoot()) == null) {
            return;
        }
        root2.a0();
    }

    public final int h3() {
        int i10 = m1().getPrefShowFloatMenu() ? 80 : 20;
        if (m1().getPrefShowFloatBonus()) {
            i10 += 78;
        }
        return ConfigSingleton.i(i10);
    }

    public final void h4(String sourceString) {
        if (!ba.l.q(sourceString) && StringsKt.equals(sourceString, m1().getSourceString(), true)) {
            j0(ReadingInstance.ScreenOffTime.Init, false);
            ReaderSlidingAdapter readerSlidingAdapter = this.mSlidingAdapter;
            if (readerSlidingAdapter != null) {
                readerSlidingAdapter.D1();
            }
            k3(true);
            if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED)) {
                t0.b(this, "已退出语音朗读");
            }
        }
        id.i.f(this);
        T4();
    }

    @Override // com.martian.mibook.mvvm.read.widget.a
    public void i() {
        ReaderSlidingAdapter readerSlidingAdapter = this.mSlidingAdapter;
        if (readerSlidingAdapter != null) {
            readerSlidingAdapter.u1();
        }
    }

    @Override // com.martian.mibook.mvvm.read.widget.a
    public void i0() {
        if (m1().S(this)) {
            return;
        }
        v4();
    }

    public final RewardVideoAdManager i3() {
        if (this.videoAdManager == null) {
            this.videoAdManager = new RewardVideoAdManager(this);
        }
        return this.videoAdManager;
    }

    public final void i4() {
        int i10;
        int i11;
        if ((this.mSlidingAdapter != null || m1().Z1()) && (i10 = this.mTtsChapterIndex) >= 0 && (i11 = this.mTtsContentPos) >= 0) {
            Z3(i10, i11);
            k3(true);
        }
    }

    @Override // gd.a
    public void j() {
        a.C0540a.c(this, false, null, 2, null);
        ReadingMoreItemPopupWindow readingMoreItemPopupWindow = this.menuPopupWindow;
        if (readingMoreItemPopupWindow != null) {
            readingMoreItemPopupWindow.dismiss();
        }
    }

    @Override // com.martian.mibook.mvvm.read.widget.a
    public void j0(@k ReadingInstance.ScreenOffTime screenOffTime, boolean saveTime) {
        Intrinsics.checkNotNullParameter(screenOffTime, "screenOffTime");
        ReadingInstance.z().p0(this, screenOffTime, saveTime);
        b3();
        a3();
    }

    public final void j3(int minutes) {
        ReadMenu root;
        if (minutes <= 0) {
            return;
        }
        ReadingInstance.z().Z(this, minutes);
        m1().n2(true);
        ReadingReadMenuBinding readingReadMenuBinding = this.readMenuBinding;
        if (readingReadMenuBinding != null && (root = readingReadMenuBinding.getRoot()) != null && root.getShowMenu()) {
            Z();
        }
        e4();
    }

    public final void j4(int r12, int r22) {
        TTSReadManager.f(this, r12, r22);
    }

    @Override // com.martian.mibook.mvvm.read.widget.a
    public void k(boolean forceUpdate) {
        ReadingReadMenuBinding readingReadMenuBinding;
        ReadMenu root;
        boolean X3 = X3();
        boolean f10 = ReadingInstance.z().f(this);
        boolean z10 = false;
        int i10 = (X3 ? 0 : 2) + (f10 ? 1 : 0);
        if (m1().getStatusBarMode() != i10 || forceUpdate) {
            m1().n3(i10);
            s4(X3, !f10);
            boolean s10 = MiConfigSingleton.b2().h2().s();
            MiReadingTheme k10 = MiConfigSingleton.b2().h2().k();
            ReadingReadMenuBinding readingReadMenuBinding2 = this.readMenuBinding;
            if (((readingReadMenuBinding2 != null ? readingReadMenuBinding2.getRoot() : null) == null || ((readingReadMenuBinding = this.readMenuBinding) != null && (root = readingReadMenuBinding.getRoot()) != null && !root.getShowMenu())) && MiConfigSingleton.b2().K2()) {
                z10 = true;
            }
            int navigationBarBackgroundColor = k10.getNavigationBarBackgroundColor(z10);
            if (m1().getStatusBarMode() == 1 || m1().getStatusBarMode() == 3) {
                com.gyf.immersionbar.d.q3(this).W0(BarHide.FLAG_SHOW_BAR).T2(!s10).G1(!s10).B1(navigationBarBackgroundColor, 0.0f).a1();
                if (m1().getStatusBarMode() == 1) {
                    com.gyf.immersionbar.d.q3(this).W0(BarHide.FLAG_HIDE_STATUS_BAR).a1();
                    return;
                }
                return;
            }
            if (m1().getStatusBarMode() == 2) {
                com.gyf.immersionbar.d.q3(this).W0(BarHide.FLAG_HIDE_NAVIGATION_BAR).T2(!s10).G1(true ^ s10).B1(navigationBarBackgroundColor, 0.0f).a1();
            } else {
                com.gyf.immersionbar.d.q3(this).W0(BarHide.FLAG_HIDE_BAR).T2(!s10).G1(true ^ s10).B1(navigationBarBackgroundColor, 0.0f).a1();
            }
        }
    }

    @Override // gd.b
    public void k0() {
        j3(MiConfigSingleton.b2().I1(m1().getAdHiding()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void k3(boolean hide) {
        ReaderThemeLinearLayout readerThemeLinearLayout;
        ReaderThemeImageView readerThemeImageView;
        if (this.hideTtsControl == hide) {
            return;
        }
        if ((this.forceHideTtsPositionControl || !m1().Z1()) && !hide) {
            return;
        }
        this.hideTtsControl = hide;
        if (hide && this.positionControlViewBinding == null) {
            return;
        }
        if (this.positionControlViewBinding == null) {
            ((ActivityReadingNewBinding) a1()).readingScrollContainer.readingTtsPosition.setLayoutResource(R.layout.tts_position_control_view);
            TtsPositionControlViewBinding bind = TtsPositionControlViewBinding.bind(((ActivityReadingNewBinding) a1()).readingScrollContainer.readingTtsPosition.inflate());
            this.positionControlViewBinding = bind;
            if (bind != null && (readerThemeImageView = bind.ttsPositionBack) != null) {
                readerThemeImageView.setOnClickListener(new View.OnClickListener() { // from class: bd.b0
                    public /* synthetic */ b0() {
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ReadingNewActivity.l3(ReadingNewActivity.this, view);
                    }
                });
            }
            TtsPositionControlViewBinding ttsPositionControlViewBinding = this.positionControlViewBinding;
            if (ttsPositionControlViewBinding != null && (readerThemeLinearLayout = ttsPositionControlViewBinding.ttsReadCurrentPage) != null) {
                readerThemeLinearLayout.setOnClickListener(new View.OnClickListener() { // from class: bd.m0
                    public /* synthetic */ m0() {
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ReadingNewActivity.m3(ReadingNewActivity.this, view);
                    }
                });
            }
        }
        TtsPositionControlViewBinding ttsPositionControlViewBinding2 = this.positionControlViewBinding;
        RelativeLayout root = ttsPositionControlViewBinding2 != null ? ttsPositionControlViewBinding2.getRoot() : null;
        if (root == null) {
            return;
        }
        root.setVisibility(hide ? 8 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void k4(int r52, int conPos, int endPos) {
        ReaderSlidingAdapter readerSlidingAdapter;
        MiReadingContent Q0;
        ReaderSlidingAdapter readerSlidingAdapter2;
        if (m1().Z1() && this.mSlidingAdapter != null) {
            this.mTtsChapterIndex = r52;
            this.mTtsContentPos = conPos;
            int max = (int) Math.max(l5.c.f27899e, conPos);
            ReaderSlidingAdapter readerSlidingAdapter3 = this.mSlidingAdapter;
            if (readerSlidingAdapter3 != null) {
                readerSlidingAdapter3.O1(this.mTtsChapterIndex, this.mTtsContentPos, endPos);
            }
            ReaderSlidingAdapter readerSlidingAdapter4 = this.mSlidingAdapter;
            if ((readerSlidingAdapter4 != null ? readerSlidingAdapter4.Q0() : null) == null || (readerSlidingAdapter = this.mSlidingAdapter) == null || (Q0 = readerSlidingAdapter.Q0()) == null) {
                return;
            }
            boolean z10 = true;
            if (Q0.isReady()) {
                if (m1().getCom.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String() == r52 && (readerSlidingAdapter2 = this.mSlidingAdapter) != null && readerSlidingAdapter2.n1(max)) {
                    this.mTtsPosSyncOn = true;
                    k3(true);
                } else {
                    z10 = false;
                }
                if (this.mTtsPosSyncOn && !((ActivityReadingNewBinding) a1()).readingScrollContainer.slReadingContainer.getSlider().e()) {
                    Z3(r52, max);
                    if (max == 0) {
                        P4();
                    }
                }
                if (z10 || ((ActivityReadingNewBinding) a1()).readingScrollContainer.slReadingContainer.getSlider().e()) {
                    return;
                }
                k3(false);
            }
        }
    }

    @Override // com.martian.mibook.mvvm.read.widget.a
    public void l() {
        ReadMenu root;
        ReadingReadMenuBinding readingReadMenuBinding = this.readMenuBinding;
        if (readingReadMenuBinding == null || (root = readingReadMenuBinding.getRoot()) == null) {
            return;
        }
        root.F0(ReadingSpaceSettingLayout.class, true);
    }

    @Override // gd.a
    public int l0() {
        if (m.q(this)) {
            return com.gyf.immersionbar.d.H0(this);
        }
        return 0;
    }

    @Override // com.martian.mibook.mvvm.read.widget.a
    public void m() {
        ReadMenu root;
        boolean z10 = !ConfigSingleton.D().H0();
        g4("切换日夜间-" + (z10 ? "夜间" : "日间"));
        float v10 = ReadingInstance.z().V() ? -1.0f : ReadingInstance.z().v();
        ConfigSingleton.D().d1(z10);
        ReadingSettingLayout.INSTANCE.g(this, v10, new Function0<Unit>() { // from class: com.martian.mibook.mvvm.read.activity.ReadingNewActivity$onNightModeClick$1
            public ReadingNewActivity$onNightModeClick$1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke */
            public final void invoke2() {
                AppViewModel l12 = ReadingNewActivity.this.l1();
                if (l12 != null) {
                    l12.v0(false);
                }
            }
        });
        ReadingReadMenuBinding readingReadMenuBinding = this.readMenuBinding;
        if (readingReadMenuBinding == null || (root = readingReadMenuBinding.getRoot()) == null) {
            return;
        }
        root.L0();
    }

    @Override // gd.a
    public boolean m0() {
        ae.a aVar = this.autoSliderController;
        return aVar != null && aVar.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void m4() {
        ReadMenu root;
        k(true);
        MiConfigSingleton b22 = MiConfigSingleton.b2();
        ReadingReadMenuBinding readingReadMenuBinding = this.readMenuBinding;
        if (readingReadMenuBinding != null && (root = readingReadMenuBinding.getRoot()) != null) {
            root.setNightModeStatus(b22.H0());
            root.getStatusView().setBackgroundColor(b22.h2().h());
        }
        com.gyf.immersionbar.d.q3(this).T2(true ^ b22.h2().s()).a1();
        ReaderSlidingAdapter readerSlidingAdapter = this.mSlidingAdapter;
        if (readerSlidingAdapter != null) {
            if (m1().getIsScrollMode()) {
                readerSlidingAdapter.M1(((ActivityReadingNewBinding) a1()).readingScrollContainer.llScrollReadingContainer);
            } else if (ReadingInstance.z().E(this) == ReadingInstance.SlideMode.SIM_SLIDER.getSlideMode()) {
                readerSlidingAdapter.M1(((ActivityReadingNewBinding) a1()).clMainContainer);
            }
            readerSlidingAdapter.w1();
        }
        this.menuPopupWindow = null;
    }

    @Override // com.martian.mibook.mvvm.read.widget.a
    public void n() {
        J0(RewardVideoAdManager.VideoType.BLOCK_AD_MANUAL);
    }

    @Override // gd.a
    public void n0() {
        ReadMenu root;
        ReadingReadMenuBinding readingReadMenuBinding = this.readMenuBinding;
        h0(readingReadMenuBinding == null || !(readingReadMenuBinding == null || (root = readingReadMenuBinding.getRoot()) == null || root.getShowMenu()));
    }

    public final void n4(boolean refreshViewListenerColor) {
        super.A0();
        if (refreshViewListenerColor) {
            ConfigSingleton.D().q1();
        }
        m1().f3(true);
        AppViewModel l12 = l1();
        if (l12 != null) {
            l12.x0();
        }
        m4();
    }

    @Override // com.martian.mibook.mvvm.read.widget.a
    public void o(boolean show) {
        ReaderSlidingAdapter readerSlidingAdapter = this.mSlidingAdapter;
        if (readerSlidingAdapter != null) {
            readerSlidingAdapter.s2(show);
        }
    }

    @Override // com.martian.mibook.mvvm.read.widget.a
    public void o0() {
        ReadMenu root;
        ReadingMoreSettingLayout readingMoreSettingLayout;
        ReadingReadMenuBinding readingReadMenuBinding = this.readMenuBinding;
        if (readingReadMenuBinding == null || (root = readingReadMenuBinding.getRoot()) == null || (readingMoreSettingLayout = (ReadingMoreSettingLayout) root.L(ReadingMoreSettingLayout.class)) == null) {
            return;
        }
        readingMoreSettingLayout.S();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void o3() {
        RelativeLayout relativeLayout;
        if (m1().getIsScrollMode() && MiConfigSingleton.b2().E0("SCROLL_SLIDER")) {
            m1().C2();
            u4();
            if (this.firstScrollModeGuideBinding == null) {
                ((ActivityReadingNewBinding) a1()).firstGuideScrollModeView.setLayoutResource(R.layout.scroll_reading_first_guide);
                ScrollReadingFirstGuideBinding bind = ScrollReadingFirstGuideBinding.bind(((ActivityReadingNewBinding) a1()).firstGuideScrollModeView.inflate());
                this.firstScrollModeGuideBinding = bind;
                if (bind != null && (relativeLayout = bind.guideView) != null) {
                    relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: bd.s0
                        public /* synthetic */ s0() {
                        }

                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ReadingNewActivity.p3(ReadingNewActivity.this, view);
                        }
                    });
                }
                h0(false);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @l Intent r72) {
        super.onActivityResult(requestCode, resultCode, r72);
        if ((requestCode == 10001 || requestCode == 10003 || requestCode == 1005 || requestCode == 1006 || requestCode == 1019 || requestCode == 1020) && resultCode == -1) {
            ac.a.D(this, MiConfigSingleton.b2().G1().k("登录成功", requestCode));
            if (requestCode == 10003) {
                ReaderSlidingAdapter readerSlidingAdapter = this.mSlidingAdapter;
                if (readerSlidingAdapter != null) {
                    readerSlidingAdapter.A2(readerSlidingAdapter != null ? readerSlidingAdapter.Q0() : null);
                }
            } else {
                h0(true);
            }
            AppViewModel l12 = l1();
            if (l12 != null) {
                l12.l0(false);
                return;
            }
            return;
        }
        if (requestCode == 100 && resultCode == -1) {
            MiConfigSingleton.b2().G1().C(this, true, new c());
            return;
        }
        if (requestCode == 10024 || requestCode == 800) {
            AppViewModel l13 = l1();
            if (l13 != null) {
                l13.l0(resultCode == -1);
                return;
            }
            return;
        }
        if (requestCode == 777 && resultCode == -1) {
            setResult(205);
            ReaderSlidingAdapter readerSlidingAdapter2 = this.mSlidingAdapter;
            if (readerSlidingAdapter2 != null) {
                readerSlidingAdapter2.B2(true);
            }
        }
    }

    @Override // com.martian.mibook.mvvm.read.widget.a
    public void onBackClick(@l View view) {
        finish();
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMActivity, com.martian.mibook.mvvm.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@k Configuration newConfig) {
        ReadMenu root;
        ReadMenu root2;
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        if (getIsPortrait() != m1().getIsPortrait()) {
            m1().N2(getIsPortrait());
            if (getIsPortrait()) {
                AutoSizeCompat.autoConvertDensity(super.getResources(), 360.0f, true);
            }
            ReadingReadMenuBinding readingReadMenuBinding = this.readMenuBinding;
            if (readingReadMenuBinding != null && (root2 = readingReadMenuBinding.getRoot()) != null) {
                root2.M(true);
            }
            ReadingReadMenuBinding readingReadMenuBinding2 = this.readMenuBinding;
            if (readingReadMenuBinding2 != null && (root = readingReadMenuBinding2.getRoot()) != null) {
                root.Y(ReaderVipThemeLayout.class);
            }
            ReaderSlidingAdapter readerSlidingAdapter = this.mSlidingAdapter;
            if (readerSlidingAdapter != null) {
                readerSlidingAdapter.v();
            }
            this.mSlidingAdapter = null;
            Q3();
            p4(this.firstGuideBinding);
            p4(this.firstScrollModeGuideBinding);
            p4(this.errorViewBinding);
            p4(this.positionControlViewBinding);
            p4(this.networkOfflineBinding);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.mvvm.base.BaseMVVMActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            MartianDialogFragment martianDialogFragment = this.cacheAdsDialogFragment;
            if (martianDialogFragment != null) {
                martianDialogFragment.dismiss();
            }
            this.cacheAdsDialogFragment = null;
            m1().x3();
            TTSReadManager.z(this);
            id.i.f(this);
            ae.a aVar = this.autoSliderController;
            if (aVar != null) {
                aVar.a();
            }
            ((ActivityReadingNewBinding) a1()).readingScrollContainer.slReadingContainer.s();
            BannerAdManager bannerAdManager = this.bannerAdManager;
            if (bannerAdManager != null) {
                bannerAdManager.m();
            }
            RewardVideoAdManager rewardVideoAdManager = this.videoAdManager;
            if (rewardVideoAdManager != null) {
                rewardVideoAdManager.j();
            }
            MiConfigSingleton.b2().i2().a();
            Handler handler = this.handler;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.handler = null;
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, @l KeyEvent r72) {
        ReadingAutoSlideLayout readingAutoSlideLayout;
        ReadMenu root;
        boolean z10 = (!ReadingInstance.z().i(this) || m0() || TTSReadManager.q()) ? false : true;
        if (keyCode == 82 && this.mSlidingAdapter != null) {
            n0();
            return true;
        }
        if (keyCode == 24 || keyCode == 25) {
            if (!z10) {
                return false;
            }
            if (m1().getIsVip()) {
                if (keyCode == 25) {
                    ((ActivityReadingNewBinding) a1()).readingScrollContainer.slReadingContainer.D(false);
                } else {
                    ((ActivityReadingNewBinding) a1()).readingScrollContainer.slReadingContainer.E(false);
                }
            } else {
                if (this.notCurrentlyOpenVip) {
                    return false;
                }
                D4();
            }
            return true;
        }
        if (keyCode == 4) {
            ReadingMoreItemPopupWindow readingMoreItemPopupWindow = this.menuPopupWindow;
            if (readingMoreItemPopupWindow != null) {
                readingMoreItemPopupWindow.dismiss();
            }
            ReadingReadMenuBinding readingReadMenuBinding = this.readMenuBinding;
            if (readingReadMenuBinding != null && (root = readingReadMenuBinding.getRoot()) != null && root.S()) {
                return true;
            }
            if (this.mSlidingAdapter != null && m0()) {
                ReaderMenuAutoSlideBinding readerMenuAutoSlideBinding = this.autoSlideBinding;
                if (readerMenuAutoSlideBinding != null && (readingAutoSlideLayout = readerMenuAutoSlideBinding.readingAutoSlideLayout) != null && BottomSheetBehavior.from(readingAutoSlideLayout).getState() == 3) {
                    BottomSheetBehavior.from(readingAutoSlideLayout).setState(5);
                }
                b0();
                return true;
            }
        }
        return super.onKeyDown(keyCode, r72);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int keyCode, @l KeyEvent r32) {
        if ((keyCode == 24 || keyCode == 25) && !m0() && !TTSReadManager.q() && ReadingInstance.z().i(this)) {
            return true;
        }
        return super.onKeyUp(keyCode, r32);
    }

    @Override // com.martian.mibook.mvvm.read.widget.a
    public void onMoreItemClick(@k View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (this.menuPopupWindow == null) {
            g4("查看更多");
            this.menuPopupWindow = new ReadingMoreItemPopupWindow(this);
        }
        ReadingMoreItemPopupWindow readingMoreItemPopupWindow = this.menuPopupWindow;
        if (readingMoreItemPopupWindow != null) {
            readingMoreItemPopupWindow.showAsDropDown(view, 0, 0);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(@l Intent intent) {
        super.onNewIntent(intent);
        O3(intent);
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        W2(m1().getProcessSeconds());
        BannerAdManager bannerAdManager = this.bannerAdManager;
        if (bannerAdManager != null) {
            bannerAdManager.c1();
        }
        m1().l2();
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacks(this.screenOffRunnable);
        }
        b3();
        if (m0()) {
            h0(true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.mvvm.base.BaseMVVMActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        BannerAdManager bannerAdManager = this.bannerAdManager;
        if (bannerAdManager != null) {
            bannerAdManager.d1(m1().getCom.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String() < 0);
        }
        Q4();
        if (m0()) {
            h0(false);
        }
        ((ActivityReadingNewBinding) a1()).readingScrollContainer.slReadingContainer.setBlockType(SlidingLayout.TouchBlockType.DEFAULT);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            k(true);
        }
    }

    @Override // gd.b
    public void p0() {
        ReadingInstance.z().d0(this);
        G4();
    }

    public final void p4(ViewBinding viewBinding) {
        if (viewBinding != null) {
            View root = viewBinding.getRoot();
            ViewGroup viewGroup = root instanceof ViewGroup ? (ViewGroup) root : null;
            if (viewGroup != null) {
                int childCount = viewGroup.getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    View childAt = viewGroup.getChildAt(i10);
                    Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(index)");
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    viewGroup.removeView(childAt);
                    viewGroup.addView(childAt, i10, layoutParams);
                }
            }
        }
    }

    @Override // gd.a
    public void q() {
        ac.a.L(this, "广告-看视频免广告-点击");
        J0(RewardVideoAdManager.VideoType.BLOCK_AD_MANUAL);
    }

    @Override // com.martian.mibook.mvvm.read.widget.a
    public void q0() {
        ReadMenu root;
        ReadingReadMenuBinding readingReadMenuBinding = this.readMenuBinding;
        if (readingReadMenuBinding == null || (root = readingReadMenuBinding.getRoot()) == null) {
            return;
        }
        root.U(true);
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMActivity
    public void q1() {
        MiReadingTheme k10 = MiConfigSingleton.b2().h2().k();
        boolean s10 = MiConfigSingleton.b2().h2().s();
        com.gyf.immersionbar.d.q3(this).T2(!s10).G1(!s10).B1(k10.getNavigationBarBackgroundColor(true), 0.0f).a1();
    }

    @Override // gd.a
    public boolean r() {
        BannerAdManager bannerAdManager;
        return (m1().getIsVip() || (bannerAdManager = this.bannerAdManager) == null || !bannerAdManager.G0()) ? false : true;
    }

    @Override // gd.a
    public void r0() {
        g4("去书城");
        m1().l2();
        kc.b.l(1, Integer.valueOf(j2.f33272m), 67108864);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ReadingNewActivity$onBookMallClick$1(this, null), 3, null);
    }

    public final void r4(ChapterList chapterList) {
        m1().y2(chapterList);
        int count = chapterList != null ? chapterList.getCount() : 0;
        if (count <= 0 || m1().getCom.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String() < count) {
            return;
        }
        m1().x2(count - 1);
        ReaderSlidingAdapter readerSlidingAdapter = this.mSlidingAdapter;
        if (readerSlidingAdapter != null) {
            readerSlidingAdapter.G1();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // gd.a
    public void s(@k SlidingLayout.TouchBlockType touchBlockType) {
        Intrinsics.checkNotNullParameter(touchBlockType, "touchBlockType");
        ((ActivityReadingNewBinding) a1()).readingScrollContainer.slReadingContainer.setBlockType(touchBlockType);
    }

    @Override // gd.b
    public void s0() {
        ReadingInstance.z().w0(this);
        M4();
    }

    public final void s4(boolean fullscreen, boolean enableImmersion) {
        if (fullscreen) {
            getWindow().addFlags(1024);
            getWindow().clearFlags(2048);
        } else {
            getWindow().addFlags(2048);
            getWindow().clearFlags(1024);
        }
        if (enableImmersion) {
            if (fullscreen) {
                getWindow().getDecorView().setSystemUiVisibility(BaseActivity.f12020n);
            } else {
                getWindow().getDecorView().setSystemUiVisibility(BaseActivity.f12021o);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.mvvm.read.widget.a
    public void t(boolean z10) {
        ((ActivityReadingNewBinding) a1()).readingScrollContainer.readingBonus.lyDurationCountFloat.setVisibility(z10 ? 0 : 8);
        ReaderSlidingAdapter readerSlidingAdapter = this.mSlidingAdapter;
        if (readerSlidingAdapter != null) {
            readerSlidingAdapter.N2();
        }
    }

    @Override // com.martian.mibook.mvvm.read.widget.a
    public void t0(int r12, int r22, int contentSize) {
        M3(Integer.valueOf(r12), Integer.valueOf(r22), 1);
    }

    public final void t4() {
        ReadMenu root;
        if (TTSReadManager.q() && !id.i.e(this)) {
            ReadingReadMenuBinding readingReadMenuBinding = this.readMenuBinding;
            id.i.a(this, (readingReadMenuBinding == null || (root = readingReadMenuBinding.getRoot()) == null) ? null : root.getTtsFloatView());
        }
        T4();
    }

    @Override // com.martian.mibook.mvvm.read.widget.a
    public void u() {
        ReadMenu root;
        ReadingReadMenuBinding readingReadMenuBinding = this.readMenuBinding;
        if (readingReadMenuBinding == null || (root = readingReadMenuBinding.getRoot()) == null) {
            return;
        }
        root.F0(ReaderVipThemeLayout.class, true);
    }

    @Override // com.martian.mibook.mvvm.read.widget.a
    public void u0() {
        ReadingReadMenuBinding readingReadMenuBinding;
        ReadMenu root;
        ReadMenu root2;
        if (this.previousReadingRecords == null || !(!r0.isEmpty())) {
            g4("章节进度条-后退-到底");
            t0.b(this, "没有更多记录了");
        } else {
            g4("章节进度条-后退");
            List<MiReadingRecord> list = this.previousReadingRecords;
            Intrinsics.checkNotNull(list);
            MiReadingRecord miReadingRecord = list.get(0);
            ReadingReadMenuBinding readingReadMenuBinding2 = this.readMenuBinding;
            if (readingReadMenuBinding2 != null && (root2 = readingReadMenuBinding2.getRoot()) != null) {
                root2.setOnChapterSeekBarProgress(miReadingRecord.getChapterIndex());
            }
            M3(Integer.valueOf(miReadingRecord.getChapterIndex()), miReadingRecord.getContentPos(), miReadingRecord.getRecordType());
            List<MiReadingRecord> list2 = this.previousReadingRecords;
            if (list2 != null) {
                list2.remove(0);
            }
        }
        List<MiReadingRecord> list3 = this.previousReadingRecords;
        if (list3 != null && list3.size() == 0 && (readingReadMenuBinding = this.readMenuBinding) != null && (root = readingReadMenuBinding.getRoot()) != null) {
            root.setVisibleReadingChapterSeek(8);
        }
        P4();
    }

    public final void u4() {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.flags |= 768;
        getWindow().setAttributes(attributes);
    }

    @Override // com.martian.mibook.mvvm.read.widget.a
    public void v() {
        super.finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.mvvm.read.widget.a
    public void v0() {
        if (ReadingInstance.z().S(this)) {
            aa.f slider = ((ActivityReadingNewBinding) a1()).readingScrollContainer.slReadingContainer.getSlider();
            if (slider instanceof aa.b) {
                ((aa.b) slider).w(ReadingInstance.z().T(this));
            }
        }
    }

    @SuppressLint({"InflateParams"})
    public final void v4() {
        if (MiConfigSingleton.b2().C2()) {
            F0("缓存");
            return;
        }
        MartianDialogFragment martianDialogFragment = this.cacheAdsDialogFragment;
        if (martianDialogFragment == null || martianDialogFragment == null || !martianDialogFragment.isVisible()) {
            com.martian.libmars.widget.dialog.b a10 = MartianDialogFragment.INSTANCE.a();
            View inflate = getLayoutInflater().inflate(R.layout.fragment_audio_book_cache_ads_dialog, (ViewGroup) null);
            ((ImageView) inflate.findViewById(R.id.iv_close)).setOnClickListener(new View.OnClickListener() { // from class: bd.d0
                public /* synthetic */ d0() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReadingNewActivity.w4(ReadingNewActivity.this, view);
                }
            });
            ((TextView) inflate.findViewById(R.id.tv_activate_vip)).setOnClickListener(new View.OnClickListener() { // from class: bd.e0
                public /* synthetic */ e0() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReadingNewActivity.x4(ReadingNewActivity.this, view);
                }
            });
            ((RelativeLayout) inflate.findViewById(R.id.rl_show_ad)).setOnClickListener(new View.OnClickListener() { // from class: bd.f0

                /* renamed from: b */
                public final /* synthetic */ ProgressBar f1523b;

                /* renamed from: c */
                public final /* synthetic */ ReadingNewActivity f1524c;

                public /* synthetic */ f0(ProgressBar progressBar, ReadingNewActivity this) {
                    progressBar = progressBar;
                    this = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReadingNewActivity.y4(progressBar, this, view);
                }
            });
            this.cacheAdsDialogFragment = com.martian.libmars.widget.dialog.b.H(a10.Q(inflate).I(false).J(false).P(com.martian.libmars.R.style.MartianDialogFragmentFullScreenStyle).M(new e()), this, null, "reading_book_cache_ads_dialog", false, 10, null);
        }
    }

    @Override // com.martian.mibook.mvvm.read.widget.a
    public void w(@k String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (m1().R1()) {
            t0.b(this, "已在书架");
            return;
        }
        if (m1().getBook() == null) {
            return;
        }
        MiConfigSingleton.b2().M1().g(this, m1().getBook());
        MiConfigSingleton.b2().V1().g(3, m1().getSourceName(), m1().getSourceId(), m1().getRecommendId(), m1().getRecommend(), "阅读加书架");
        t0.b(this, "已加入书架");
        g4("加入书架-" + source);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // gd.a
    public void x(boolean show) {
        if (m1().getShowFloatItems() == show) {
            return;
        }
        m1().j3(show);
        l9.a.a(this, ((ActivityReadingNewBinding) a1()).readingScrollContainer.readingBonus.getRoot(), show, l9.a.f27957c);
    }

    @Override // gd.a
    public void x0(@k ReadingInstance.d listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ac.a.p(this, "看插屏免广告");
        ReadingInstance.z().l0(0);
        ReadingInstance.z().j(this, new d(listener));
    }

    @Override // gd.b
    public void y(boolean loading, @k String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (isDestroyed() || isFinishing()) {
            return;
        }
        if (this.loadingDialog == null) {
            this.loadingDialog = new ProgressDialog(this);
        }
        ProgressDialog progressDialog = this.loadingDialog;
        if (progressDialog != null) {
            progressDialog.setMessage(msg);
        }
        if (loading) {
            ProgressDialog progressDialog2 = this.loadingDialog;
            if (progressDialog2 != null) {
                progressDialog2.show();
                return;
            }
            return;
        }
        ProgressDialog progressDialog3 = this.loadingDialog;
        if (progressDialog3 != null) {
            progressDialog3.dismiss();
        }
    }

    @Override // com.martian.mibook.mvvm.read.widget.a
    public void y0() {
        ReaderSlidingAdapter readerSlidingAdapter = this.mSlidingAdapter;
        if (readerSlidingAdapter != null) {
            readerSlidingAdapter.u1();
        }
    }

    @Override // com.martian.mibook.mvvm.read.widget.a
    public void z() {
        ReadMenu root;
        ReadingColorPickerLayout readingColorPickerLayout;
        ReadMenu root2;
        ReadingReadMenuBinding readingReadMenuBinding = this.readMenuBinding;
        if (readingReadMenuBinding != null && (root2 = readingReadMenuBinding.getRoot()) != null) {
            root2.F0(ReadingColorPickerLayout.class, true);
        }
        ReadingReadMenuBinding readingReadMenuBinding2 = this.readMenuBinding;
        if (readingReadMenuBinding2 == null || (root = readingReadMenuBinding2.getRoot()) == null || (readingColorPickerLayout = (ReadingColorPickerLayout) root.L(ReadingColorPickerLayout.class)) == null) {
            return;
        }
        readingColorPickerLayout.x();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // gd.a
    @k
    public TextView z0() {
        ReaderThemeTextView tvScrollReadingTitle = ((ActivityReadingNewBinding) a1()).readingScrollContainer.tvScrollReadingTitle;
        Intrinsics.checkNotNullExpressionValue(tvScrollReadingTitle, "tvScrollReadingTitle");
        return tvScrollReadingTitle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void z4(boolean showErrorView, ErrorResult errorResult) {
        ReaderLoadingTip readerLoadingTip;
        ReaderLoadingTip readerLoadingTip2;
        ReaderLoadingTip readerLoadingTip3;
        ReaderLoadingTip readerLoadingTip4;
        ReaderThemeImageView readerThemeImageView;
        if (showErrorView || this.errorViewBinding != null) {
            if (this.errorViewBinding == null) {
                ((ActivityReadingNewBinding) a1()).readingErrorView.setLayoutResource(R.layout.reading_error_view);
                ReadingErrorViewBinding bind = ReadingErrorViewBinding.bind(((ActivityReadingNewBinding) a1()).readingErrorView.inflate());
                this.errorViewBinding = bind;
                ViewGroup.LayoutParams layoutParams = (bind == null || (readerThemeImageView = bind.readingErrorBack) == null) ? null : readerThemeImageView.getLayoutParams();
                ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
                if (marginLayoutParams != null) {
                    marginLayoutParams.setMargins(0, com.gyf.immersionbar.d.H0(this), 0, 0);
                }
                if (errorResult == null) {
                    ReadingErrorViewBinding readingErrorViewBinding = this.errorViewBinding;
                    if (readingErrorViewBinding != null && (readerLoadingTip = readingErrorViewBinding.readerLoadingTip) != null) {
                        readerLoadingTip.setLoadingTip(ReaderLoadingTip.LoadStatus.network_error);
                    }
                } else if (errorResult.getErrorCode() == -1) {
                    ReadingErrorViewBinding readingErrorViewBinding2 = this.errorViewBinding;
                    if (readingErrorViewBinding2 != null && (readerLoadingTip4 = readingErrorViewBinding2.readerLoadingTip) != null) {
                        readerLoadingTip4.e(ReaderLoadingTip.LoadStatus.serverError, errorResult.getErrorMsg());
                    }
                } else {
                    ReadingErrorViewBinding readingErrorViewBinding3 = this.errorViewBinding;
                    if (readingErrorViewBinding3 != null && (readerLoadingTip3 = readingErrorViewBinding3.readerLoadingTip) != null) {
                        readerLoadingTip3.e(ReaderLoadingTip.LoadStatus.network_error, errorResult.getErrorMsg());
                    }
                }
                ReadingErrorViewBinding readingErrorViewBinding4 = this.errorViewBinding;
                if (readingErrorViewBinding4 != null && (readerLoadingTip2 = readingErrorViewBinding4.readerLoadingTip) != null) {
                    readerLoadingTip2.setOnReloadListener(new ReadingNewActivity$showErrorView$2(this));
                }
            }
            ReadingErrorViewBinding readingErrorViewBinding5 = this.errorViewBinding;
            RelativeLayout root = readingErrorViewBinding5 != null ? readingErrorViewBinding5.getRoot() : null;
            if (root == null) {
                return;
            }
            root.setVisibility(showErrorView ? 0 : 8);
        }
    }
}
