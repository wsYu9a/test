package com.martian.mibook.mvvm.read.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewGroupKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.kuaishou.weapon.p0.t;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.widget.RoundedLayout;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.ReadingInstance;
import com.martian.mibook.databinding.ReaderMenuDirLayoutBinding;
import com.martian.mibook.databinding.ReaderMenuSecondLevelLayoutBinding;
import com.martian.mibook.databinding.ReaderMenuSettingLayoutBinding;
import com.martian.mibook.databinding.ReadingAddShelfViewBinding;
import com.martian.mibook.databinding.ViewReadMenuBinding;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.net.result.TYBookTopUser;
import com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel;
import com.martian.mibook.mvvm.read.widget.ReadMenu;
import com.martian.mibook.mvvm.read.widget.a;
import com.martian.mibook.mvvm.tts.service.BaseReadAloudService;
import com.martian.mibook.ui.IntervalCountdownTextView;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.mibook.ui.reader.ReaderThemeRelativeLayout;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.umeng.analytics.pro.bt;
import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\b¸\u0001¼\u0001À\u0001Ä\u0001\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\r\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0014\u001a\u0004\u0018\u00010\u00122\u000e\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0016\u0010\u0010J\u000f\u0010\u0017\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0017\u0010\u0010J\u0017\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001c\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001d\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001e\u0010\u001bJ\u000f\u0010\u001f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001f\u0010\u0010J\u000f\u0010 \u001a\u00020\fH\u0002¢\u0006\u0004\b \u0010\u0010J\u000f\u0010!\u001a\u00020\fH\u0002¢\u0006\u0004\b!\u0010\u0010J\u0017\u0010\"\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\"\u0010\u001bJ\u0017\u0010#\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b#\u0010\u001bJ\u000f\u0010$\u001a\u00020\u0018H\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\n2\u0006\u0010&\u001a\u00020\nH\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u0018H\u0002¢\u0006\u0004\b*\u0010\u001bJ\u0017\u0010+\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u0018H\u0002¢\u0006\u0004\b+\u0010\u001bJ\u0017\u0010-\u001a\u00020\f2\b\b\u0002\u0010,\u001a\u00020\u0018¢\u0006\u0004\b-\u0010\u001bJ\u0015\u0010/\u001a\u00020\f2\u0006\u0010.\u001a\u00020\n¢\u0006\u0004\b/\u00100J\u0015\u00101\u001a\u00020\f2\u0006\u0010.\u001a\u00020\n¢\u0006\u0004\b1\u00100J\u0015\u00102\u001a\u00020\f2\u0006\u0010.\u001a\u00020\n¢\u0006\u0004\b2\u00100J'\u00103\u001a\u00020\f2\u000e\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u00112\u0006\u0010\u0019\u001a\u00020\u0018H\u0007¢\u0006\u0004\b3\u00104J\u001d\u00105\u001a\u00020\f2\u000e\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011¢\u0006\u0004\b5\u00106J#\u00107\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u001a2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011¢\u0006\u0004\b7\u00108J\u0015\u00109\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b9\u0010\u001bJ\r\u0010:\u001a\u00020\u0018¢\u0006\u0004\b:\u0010%J\r\u0010;\u001a\u00020\f¢\u0006\u0004\b;\u0010\u0010J\u001f\u0010>\u001a\u00020\f2\u0010\b\u0002\u0010=\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010<¢\u0006\u0004\b>\u0010?J\r\u0010@\u001a\u00020\f¢\u0006\u0004\b@\u0010\u0010J\r\u0010A\u001a\u00020\u0012¢\u0006\u0004\bA\u0010BJ\r\u0010C\u001a\u00020\u0001¢\u0006\u0004\bC\u0010DJ\r\u0010E\u001a\u00020\u0012¢\u0006\u0004\bE\u0010BJ\u0015\u0010F\u001a\u00020\f2\u0006\u0010.\u001a\u00020\n¢\u0006\u0004\bF\u00100J\u0015\u0010I\u001a\u00020\f2\u0006\u0010H\u001a\u00020G¢\u0006\u0004\bI\u0010JJ\u0015\u0010L\u001a\u00020\n2\u0006\u0010K\u001a\u00020\n¢\u0006\u0004\bL\u0010(J\u0015\u0010M\u001a\u00020\f2\u0006\u0010&\u001a\u00020\n¢\u0006\u0004\bM\u00100J\u0017\u0010O\u001a\u00020\f2\b\u0010N\u001a\u0004\u0018\u00010\n¢\u0006\u0004\bO\u0010PJ\u001f\u0010T\u001a\u00020\f2\u0006\u0010Q\u001a\u00020\n2\u0006\u0010S\u001a\u00020RH\u0007¢\u0006\u0004\bT\u0010UJ\r\u0010V\u001a\u00020\f¢\u0006\u0004\bV\u0010\u0010J\u001f\u0010W\u001a\u00020\f2\u0006\u0010&\u001a\u00020\n2\b\u0010N\u001a\u0004\u0018\u00010\n¢\u0006\u0004\bW\u0010XJ\u0015\u0010Y\u001a\u00020\f2\u0006\u0010.\u001a\u00020\n¢\u0006\u0004\bY\u00100J\r\u0010Z\u001a\u00020\u0018¢\u0006\u0004\bZ\u0010%J\u0015\u0010[\u001a\u00020\f2\u0006\u0010.\u001a\u00020\n¢\u0006\u0004\b[\u00100J\u0015\u0010\\\u001a\u00020\f2\u0006\u0010.\u001a\u00020\n¢\u0006\u0004\b\\\u00100J'\u0010`\u001a\u00020\f2\u0006\u0010^\u001a\u00020]2\u0010\b\u0002\u0010_\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010<¢\u0006\u0004\b`\u0010aJ\r\u0010b\u001a\u00020\f¢\u0006\u0004\bb\u0010\u0010J\u0015\u0010d\u001a\u00020\f2\u0006\u0010c\u001a\u00020\n¢\u0006\u0004\bd\u00100J\u0017\u0010g\u001a\u00020\f2\b\u0010f\u001a\u0004\u0018\u00010e¢\u0006\u0004\bg\u0010hJ\u0015\u0010j\u001a\u00020\f2\u0006\u0010i\u001a\u00020\u0018¢\u0006\u0004\bj\u0010\u001bJ\r\u0010k\u001a\u00020\f¢\u0006\u0004\bk\u0010\u0010J\u0015\u0010m\u001a\u00020\f2\u0006\u0010l\u001a\u00020\u0018¢\u0006\u0004\bm\u0010\u001bJ\u0017\u0010o\u001a\u00020\f2\u0006\u0010n\u001a\u00020\nH\u0007¢\u0006\u0004\bo\u00100J\r\u0010p\u001a\u00020\f¢\u0006\u0004\bp\u0010\u0010J\u001f\u0010r\u001a\u00020\f2\u0010\b\u0002\u0010q\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010<¢\u0006\u0004\br\u0010?R\u0016\u0010t\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010!R\u0018\u0010x\u001a\u0004\u0018\u00010u8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010wR\u0018\u0010|\u001a\u0004\u0018\u00010y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010{R#\u0010\u0080\u0001\u001a\u000e\u0012\u0004\u0012\u00020e\u0012\u0004\u0012\u00020\u00120}8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u001c\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001c\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0085\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R \u0010q\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u0018\u0010\u008c\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008b\u0001\u0010\u000fR&\u0010\u0090\u0001\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008d\u0001\u0010\u000f\u001a\u0005\b\u008e\u0001\u0010%\"\u0005\b\u008f\u0001\u0010\u001bR\u0018\u0010\u0092\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0091\u0001\u0010!R#\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0093\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0094\u0001\u0010\u0095\u0001\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001R\u0018\u0010\u009c\u0001\u001a\u00030\u0099\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R!\u0010¡\u0001\u001a\u00030\u009d\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u009e\u0001\u0010\u0095\u0001\u001a\u0006\b\u009f\u0001\u0010 \u0001R!\u0010¤\u0001\u001a\u00030\u009d\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b¢\u0001\u0010\u0095\u0001\u001a\u0006\b£\u0001\u0010 \u0001R!\u0010§\u0001\u001a\u00030\u009d\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b¥\u0001\u0010\u0095\u0001\u001a\u0006\b¦\u0001\u0010 \u0001R!\u0010ª\u0001\u001a\u00030\u009d\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b¨\u0001\u0010\u0095\u0001\u001a\u0006\b©\u0001\u0010 \u0001R!\u0010\u00ad\u0001\u001a\u00030\u009d\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b«\u0001\u0010\u0095\u0001\u001a\u0006\b¬\u0001\u0010 \u0001R!\u0010°\u0001\u001a\u00030\u009d\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b®\u0001\u0010\u0095\u0001\u001a\u0006\b¯\u0001\u0010 \u0001R!\u0010³\u0001\u001a\u00030\u009d\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b±\u0001\u0010\u0095\u0001\u001a\u0006\b²\u0001\u0010 \u0001R!\u0010¶\u0001\u001a\u00030\u009d\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b´\u0001\u0010\u0095\u0001\u001a\u0006\bµ\u0001\u0010 \u0001R \u0010=\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b·\u0001\u0010\u008a\u0001R\u0018\u0010»\u0001\u001a\u00030¸\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¹\u0001\u0010º\u0001R\u0018\u0010¿\u0001\u001a\u00030¼\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b½\u0001\u0010¾\u0001R\u0018\u0010Ã\u0001\u001a\u00030À\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÁ\u0001\u0010Â\u0001R\u0018\u0010Ç\u0001\u001a\u00030Ä\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÅ\u0001\u0010Æ\u0001R\u001a\u0010Ë\u0001\u001a\u0005\u0018\u00010È\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bÉ\u0001\u0010Ê\u0001¨\u0006Ì\u0001"}, d2 = {"Lcom/martian/mibook/mvvm/read/widget/ReadMenu;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", com.umeng.analytics.pro.f.X, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/view/ViewGroup;", "rootView", "", "horizontalPadding", "", "g0", "(Landroid/view/ViewGroup;I)V", "Z", "()V", "Ljava/lang/Class;", "Landroid/view/View;", "clazz", "R", "(Ljava/lang/Class;)Landroid/view/View;", "O", "h0", "", "isSelected", ExifInterface.GPS_DIRECTION_TRUE, "(Z)V", "J0", "D0", "K0", "e0", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "I", "C0", "I0", "P", "()Z", BaseReadAloudService.f15168x, "K", "(I)I", "isEnable", "setChapterPreviousEnable", "setChapterNextEnable", "isResetView", "M", "visibility", "setCacheModeVisible", "(I)V", "setWithCommentsVisible", "setVipViewVisible", "F0", "(Ljava/lang/Class;Z)V", "Y", "(Ljava/lang/Class;)V", "L", "(Ljava/lang/Class;)Ljava/lang/Object;", "U", ExifInterface.LATITUDE_SOUTH, "a0", "Lkotlin/Function0;", "onMenuOutEnd", "b0", "(Lkotlin/jvm/functions/Function0;)V", "d0", "getStatusView", "()Landroid/view/View;", "getTtsFloatView", "()Landroid/widget/FrameLayout;", "getBookFriendsView", "setVisibleTtsIcon", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "onChapterSeekBarChangeListener", "setOnChapterSeekBarChangeListener", "(Landroid/widget/SeekBar$OnSeekBarChangeListener;)V", "progress", "J", "setOnChapterSeekBarProgress", "chapterCount", "setOnChapterSeekBarMax", "(Ljava/lang/Integer;)V", id.c.f26972i, "Lcom/martian/mibook/lib/model/data/abs/ChapterList;", "chapterList", "x0", "(ILcom/martian/mibook/lib/model/data/abs/ChapterList;)V", "X", "f0", "(ILjava/lang/Integer;)V", "setVisibleReadingChapterSeek", "Q", "setVisibleReadingCacheStatus", "setVisibleReadingHideAdView", "", "targetTime", "onCountDownFinish", "y0", "(JLkotlin/jvm/functions/Function0;)V", "B0", "textColor", "setHideAdCountDownTextColor", "", "text", "setHideAdMoreText", "(Ljava/lang/String;)V", "isNightMode", "setNightModeStatus", "N0", "showComment", "M0", "status", "setBottomCacheStatus", "L0", "onUpdatePullDownBookMark", "setOnUpdatePullDownBookMark", "b", "showDirOrSettingLayoutStatus", "Lcom/martian/mibook/databinding/ReaderMenuDirLayoutBinding;", "c", "Lcom/martian/mibook/databinding/ReaderMenuDirLayoutBinding;", "dirLayoutBinding", "Lcom/martian/mibook/databinding/ReaderMenuSettingLayoutBinding;", "d", "Lcom/martian/mibook/databinding/ReaderMenuSettingLayoutBinding;", "settingLayoutBinding", "", com.kwad.sdk.m.e.TAG, "Ljava/util/Map;", "secondLayoutContainerMap", "Lcom/martian/mibook/databinding/ReaderMenuSecondLevelLayoutBinding;", "f", "Lcom/martian/mibook/databinding/ReaderMenuSecondLevelLayoutBinding;", "secondLevelLayoutBinding", "Lcom/martian/mibook/databinding/ReadingAddShelfViewBinding;", "g", "Lcom/martian/mibook/databinding/ReadingAddShelfViewBinding;", "addShelfViewBinding", "h", "Lkotlin/jvm/functions/Function0;", "i", "showAddShelfView", "j", "getShowMenu", "setShowMenu", "showMenu", "k", "chapterSize", "Lcom/martian/mibook/mvvm/read/viewmodel/ReadingViewModel;", t.f11204d, "Lkotlin/Lazy;", "getMViewModel", "()Lcom/martian/mibook/mvvm/read/viewmodel/ReadingViewModel;", "mViewModel", "Lcom/martian/mibook/databinding/ViewReadMenuBinding;", "m", "Lcom/martian/mibook/databinding/ViewReadMenuBinding;", "binding", "Landroid/view/animation/Animation;", "n", "getMenuTopIn", "()Landroid/view/animation/Animation;", "menuTopIn", "o", "getMenuTopOut", "menuTopOut", "p", "getMenuBottomIn", "menuBottomIn", "q", "getMenuBottomOut", "menuBottomOut", t.f11211k, "getOnlyMenuTopOut", "onlyMenuTopOut", "s", "getOnlyMenuTopIn", "onlyMenuTopIn", bt.aO, "getAddBookShelfAnimationIn", "addBookShelfAnimationIn", "u", "getAddBookShelfAnimationOut", "addBookShelfAnimationOut", "v", "com/martian/mibook/mvvm/read/widget/ReadMenu$b", IAdInterListener.AdReqParam.WIDTH, "Lcom/martian/mibook/mvvm/read/widget/ReadMenu$b;", "menuInListener", "com/martian/mibook/mvvm/read/widget/ReadMenu$c", "x", "Lcom/martian/mibook/mvvm/read/widget/ReadMenu$c;", "menuOutListener", "com/martian/mibook/mvvm/read/widget/ReadMenu$e", "y", "Lcom/martian/mibook/mvvm/read/widget/ReadMenu$e;", "onlyMenuTopOutListener", "com/martian/mibook/mvvm/read/widget/ReadMenu$d", bt.aJ, "Lcom/martian/mibook/mvvm/read/widget/ReadMenu$d;", "onlyMenuTopInListener", "Lcom/martian/mibook/mvvm/read/widget/a;", "getReadMenuCallBack", "()Lcom/martian/mibook/mvvm/read/widget/a;", "readMenuCallBack", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nReadMenu.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReadMenu.kt\ncom/martian/mibook/mvvm/read/widget/ReadMenu\n+ 2 ViewGroup.kt\nandroidx/core/view/ViewGroupKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,1157:1\n62#2,4:1158\n62#2,4:1162\n62#2,4:1166\n62#2,4:1170\n62#2,4:1174\n215#3,2:1178\n215#3,2:1180\n*S KotlinDebug\n*F\n+ 1 ReadMenu.kt\ncom/martian/mibook/mvvm/read/widget/ReadMenu\n*L\n171#1:1158,4\n215#1:1162,4\n237#1:1166,4\n244#1:1170,4\n258#1:1174,4\n623#1:1178,2\n748#1:1180,2\n*E\n"})
/* loaded from: classes3.dex */
public final class ReadMenu extends FrameLayout {

    /* renamed from: b, reason: from kotlin metadata */
    public int showDirOrSettingLayoutStatus;

    /* renamed from: c, reason: from kotlin metadata */
    @l
    public ReaderMenuDirLayoutBinding dirLayoutBinding;

    /* renamed from: d, reason: from kotlin metadata */
    @l
    public ReaderMenuSettingLayoutBinding settingLayoutBinding;

    /* renamed from: e */
    @k
    public Map<String, View> secondLayoutContainerMap;

    /* renamed from: f, reason: from kotlin metadata */
    @l
    public ReaderMenuSecondLevelLayoutBinding secondLevelLayoutBinding;

    /* renamed from: g, reason: from kotlin metadata */
    @l
    public ReadingAddShelfViewBinding addShelfViewBinding;

    /* renamed from: h, reason: from kotlin metadata */
    @l
    public Function0<Unit> onUpdatePullDownBookMark;

    /* renamed from: i, reason: from kotlin metadata */
    public boolean showAddShelfView;

    /* renamed from: j, reason: from kotlin metadata */
    public boolean showMenu;

    /* renamed from: k, reason: from kotlin metadata */
    public int chapterSize;

    /* renamed from: l */
    @k
    public final Lazy mViewModel;

    /* renamed from: m, reason: from kotlin metadata */
    @k
    public final ViewReadMenuBinding binding;

    /* renamed from: n, reason: from kotlin metadata */
    @k
    public final Lazy menuTopIn;

    /* renamed from: o, reason: from kotlin metadata */
    @k
    public final Lazy menuTopOut;

    /* renamed from: p, reason: from kotlin metadata */
    @k
    public final Lazy menuBottomIn;

    /* renamed from: q, reason: from kotlin metadata */
    @k
    public final Lazy menuBottomOut;

    /* renamed from: r */
    @k
    public final Lazy onlyMenuTopOut;

    /* renamed from: s, reason: from kotlin metadata */
    @k
    public final Lazy onlyMenuTopIn;

    /* renamed from: t */
    @k
    public final Lazy addBookShelfAnimationIn;

    /* renamed from: u, reason: from kotlin metadata */
    @k
    public final Lazy addBookShelfAnimationOut;

    /* renamed from: v, reason: from kotlin metadata */
    @l
    public Function0<Unit> onMenuOutEnd;

    /* renamed from: w */
    @k
    public final b menuInListener;

    /* renamed from: x, reason: from kotlin metadata */
    @k
    public final c menuOutListener;

    /* renamed from: y, reason: from kotlin metadata */
    @k
    public final e onlyMenuTopOutListener;

    /* renamed from: z */
    @k
    public final d onlyMenuTopInListener;

    public static final class a extends BottomSheetBehavior.BottomSheetCallback {

        /* renamed from: a */
        public final /* synthetic */ Ref.ObjectRef<View> f14853a;

        /* renamed from: b */
        public final /* synthetic */ ReadMenu f14854b;

        public a(Ref.ObjectRef<View> objectRef, ReadMenu readMenu) {
            this.f14853a = objectRef;
            this.f14854b = readMenu;
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(@k View bottomSheet, float f10) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        @SuppressLint({"ClickableViewAccessibility"})
        public void onStateChanged(@k View bottomSheet, int i10) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            if (i10 == 4 || i10 == 5) {
                View view = this.f14853a.element;
                if (view instanceof ReadingColorPickerLayout) {
                    this.f14854b.binding.getRoot().setOnTouchListener(null);
                    ((ReadingColorPickerLayout) this.f14853a.element).z();
                    Object tag = bottomSheet.getTag();
                    Boolean bool = Boolean.TRUE;
                    if (Intrinsics.areEqual(tag, bool)) {
                        ReaderVipThemeLayout readerVipThemeLayout = (ReaderVipThemeLayout) this.f14854b.L(ReaderVipThemeLayout.class);
                        if (readerVipThemeLayout != null) {
                            readerVipThemeLayout.setTag(bool);
                            BottomSheetBehavior.from(readerVipThemeLayout).setState(3);
                            return;
                        }
                        return;
                    }
                } else if ((view instanceof ReaderVipThemeLayout) && bottomSheet.getTag() == null) {
                    return;
                } else {
                    this.f14854b.K0(false);
                }
                if (bottomSheet.getTag() == null || Intrinsics.areEqual(bottomSheet.getTag(), Boolean.TRUE)) {
                    this.f14854b.U(true);
                }
            }
        }
    }

    public static final class b implements Animation.AnimationListener {
        public b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        @SuppressLint({"RtlHardcoded"})
        public void onAnimationEnd(@k Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            com.martian.mibook.mvvm.read.widget.a readMenuCallBack = ReadMenu.this.getReadMenuCallBack();
            if (readMenuCallBack != null) {
                a.C0540a.d(readMenuCallBack, false, 1, null);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@k Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@k Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            com.martian.mibook.mvvm.read.widget.a readMenuCallBack = ReadMenu.this.getReadMenuCallBack();
            if (readMenuCallBack != null) {
                a.C0540a.d(readMenuCallBack, false, 1, null);
            }
            ReadMenu.this.binding.topMenu.setVisibility(0);
            ReadMenu.this.binding.bottomMenu.setVisibility(0);
        }
    }

    public static final class c implements Animation.AnimationListener {
        public c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@k Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            ReadMenu.this.setVisibility(4);
            ReadMenu.this.binding.topMenu.setVisibility(4);
            ReadMenu.this.binding.bottomMenu.setVisibility(4);
            ReadMenu.this.binding.readingChapterSeek.setVisibility(8);
            ReadingViewModel mViewModel = ReadMenu.this.getMViewModel();
            if (mViewModel != null) {
                mViewModel.U2(false, 3);
            }
            Function0 function0 = ReadMenu.this.onUpdatePullDownBookMark;
            if (function0 != null) {
                function0.invoke();
            }
            Function0 function02 = ReadMenu.this.onMenuOutEnd;
            if (function02 != null) {
                function02.invoke();
            }
            com.martian.mibook.mvvm.read.widget.a readMenuCallBack = ReadMenu.this.getReadMenuCallBack();
            if (readMenuCallBack != null) {
                a.C0540a.d(readMenuCallBack, false, 1, null);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@k Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@k Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    public static final class d implements Animation.AnimationListener {
        public d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@k Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@k Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@k Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            ReadMenu.this.binding.topMenu.setVisibility(0);
        }
    }

    public static final class e implements Animation.AnimationListener {
        public e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@k Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            ReadMenu.this.binding.topMenu.setVisibility(4);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@k Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@k Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    public static final class f extends BottomSheetBehavior.BottomSheetCallback {

        /* renamed from: a */
        public boolean f14861a;

        /* renamed from: c */
        public final /* synthetic */ ReadingDirectoryLayout f14863c;

        public f(ReadingDirectoryLayout readingDirectoryLayout) {
            this.f14863c = readingDirectoryLayout;
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(@k View bottomSheet, float f10) {
            ReaderMenuDirLayoutBinding readerMenuDirLayoutBinding;
            View view;
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            if (f10 > 0.0f && (readerMenuDirLayoutBinding = ReadMenu.this.dirLayoutBinding) != null && (view = readerMenuDirLayoutBinding.bottomSheetBg) != null && view.getVisibility() == 8) {
                ReaderMenuDirLayoutBinding readerMenuDirLayoutBinding2 = ReadMenu.this.dirLayoutBinding;
                View view2 = readerMenuDirLayoutBinding2 != null ? readerMenuDirLayoutBinding2.bottomSheetBg : null;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
            }
            ReaderMenuDirLayoutBinding readerMenuDirLayoutBinding3 = ReadMenu.this.dirLayoutBinding;
            View view3 = readerMenuDirLayoutBinding3 != null ? readerMenuDirLayoutBinding3.bottomSheetBg : null;
            if (view3 == null) {
                return;
            }
            view3.setAlpha(f10 * 0.5f);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(@k View bottomSheet, int i10) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            if (i10 == 3) {
                if (this.f14861a) {
                    return;
                }
                this.f14861a = true;
                this.f14863c.w();
                return;
            }
            if (i10 == 4 || i10 == 5) {
                ReadMenu.this.C0(false);
                ReaderMenuDirLayoutBinding readerMenuDirLayoutBinding = ReadMenu.this.dirLayoutBinding;
                View view = readerMenuDirLayoutBinding != null ? readerMenuDirLayoutBinding.bottomSheetBg : null;
                if (view != null) {
                    view.setVisibility(8);
                }
                this.f14861a = false;
                ReadMenu.this.d0();
            }
        }
    }

    public static final class g extends BottomSheetBehavior.BottomSheetCallback {
        public g() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(@k View bottomSheet, float f10) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(@k View bottomSheet, int i10) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            if (i10 == 4 || i10 == 5) {
                ReadMenu.this.I0(false);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReadMenu(@k Context context) {
        this(context, null, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static final void A0(Function0 function0, IntervalCountdownTextView intervalCountdownTextView) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    public static final void E0(ReadMenu this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.T(false);
    }

    public static final void G0(View container, ReadMenu this$0) {
        Intrinsics.checkNotNullParameter(container, "$container");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (container instanceof ReadingColorPickerLayout) {
            this$0.binding.getRoot().setOnTouchListener(new View.OnTouchListener() { // from class: hd.l
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean H0;
                    H0 = ReadMenu.H0(view, motionEvent);
                    return H0;
                }
            });
        }
        BottomSheetBehavior from = BottomSheetBehavior.from(container);
        Intrinsics.checkNotNullExpressionValue(from, "from(...)");
        container.setTag(Boolean.TRUE);
        from.setState(3);
    }

    public static final boolean H0(View view, MotionEvent motionEvent) {
        return true;
    }

    public static /* synthetic */ void N(ReadMenu readMenu, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        readMenu.M(z10);
    }

    public static final void W(ReadMenu this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void c0(ReadMenu readMenu, Function0 function0, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            function0 = null;
        }
        readMenu.b0(function0);
    }

    private final Animation getAddBookShelfAnimationIn() {
        Object value = this.addBookShelfAnimationIn.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Animation) value;
    }

    private final Animation getAddBookShelfAnimationOut() {
        Object value = this.addBookShelfAnimationOut.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Animation) value;
    }

    public final ReadingViewModel getMViewModel() {
        return (ReadingViewModel) this.mViewModel.getValue();
    }

    private final Animation getMenuBottomIn() {
        Object value = this.menuBottomIn.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Animation) value;
    }

    private final Animation getMenuBottomOut() {
        Object value = this.menuBottomOut.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Animation) value;
    }

    private final Animation getMenuTopIn() {
        Object value = this.menuTopIn.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Animation) value;
    }

    private final Animation getMenuTopOut() {
        Object value = this.menuTopOut.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Animation) value;
    }

    private final Animation getOnlyMenuTopIn() {
        Object value = this.onlyMenuTopIn.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Animation) value;
    }

    private final Animation getOnlyMenuTopOut() {
        Object value = this.onlyMenuTopOut.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Animation) value;
    }

    public final com.martian.mibook.mvvm.read.widget.a getReadMenuCallBack() {
        Object context = getContext();
        if (context instanceof com.martian.mibook.mvvm.read.widget.a) {
            return (com.martian.mibook.mvvm.read.widget.a) context;
        }
        return null;
    }

    public static final void i0(ReadMenu this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b0(new Function0<Unit>() { // from class: com.martian.mibook.mvvm.read.widget.ReadMenu$setListener$1$1
            final /* synthetic */ View $it;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReadMenu$setListener$1$1(View view2) {
                super(0);
                view = view2;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke */
            public final void invoke2() {
                a readMenuCallBack = ReadMenu.this.getReadMenuCallBack();
                if (readMenuCallBack != null) {
                    readMenuCallBack.onBackClick(view);
                }
            }
        });
    }

    public static final void j0(ReadMenu this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.martian.mibook.mvvm.read.widget.a readMenuCallBack = this$0.getReadMenuCallBack();
        if (readMenuCallBack != null) {
            readMenuCallBack.F0("阅读页顶部");
        }
    }

    public static final void k0(ReadMenu this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.martian.mibook.mvvm.read.widget.a readMenuCallBack = this$0.getReadMenuCallBack();
        if (readMenuCallBack != null) {
            readMenuCallBack.f(!ReadingInstance.z().B0(this$0.getContext()), true);
        }
    }

    public static final void l0(ReadMenu this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.martian.mibook.mvvm.read.widget.a readMenuCallBack = this$0.getReadMenuCallBack();
        if (readMenuCallBack != null) {
            readMenuCallBack.i0();
        }
    }

    public static final void m0(ReadMenu this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.martian.mibook.mvvm.read.widget.a readMenuCallBack = this$0.getReadMenuCallBack();
        if (readMenuCallBack != null) {
            Intrinsics.checkNotNull(view);
            readMenuCallBack.onMoreItemClick(view);
        }
    }

    public static final void n0(ReadMenu this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b0(new Function0<Unit>() { // from class: com.martian.mibook.mvvm.read.widget.ReadMenu$setListener$6$1
            public ReadMenu$setListener$6$1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke */
            public final void invoke2() {
                a readMenuCallBack = ReadMenu.this.getReadMenuCallBack();
                if (readMenuCallBack != null) {
                    readMenuCallBack.d();
                }
            }
        });
    }

    public static final void o0(ReadMenu this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b0(new Function0<Unit>() { // from class: com.martian.mibook.mvvm.read.widget.ReadMenu$setListener$7$1
            public ReadMenu$setListener$7$1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke */
            public final void invoke2() {
                a readMenuCallBack = ReadMenu.this.getReadMenuCallBack();
                if (readMenuCallBack != null) {
                    readMenuCallBack.K();
                }
            }
        });
    }

    public static final void p0(ReadMenu this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.martian.mibook.mvvm.read.widget.a readMenuCallBack = this$0.getReadMenuCallBack();
        if (readMenuCallBack != null) {
            readMenuCallBack.n();
        }
    }

    public static final void q0(ReadMenu this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.martian.mibook.mvvm.read.widget.a readMenuCallBack = this$0.getReadMenuCallBack();
        if (readMenuCallBack != null) {
            readMenuCallBack.u0();
        }
    }

    public static final void r0(ReadMenu this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.martian.mibook.mvvm.read.widget.a readMenuCallBack = this$0.getReadMenuCallBack();
        if (readMenuCallBack != null) {
            readMenuCallBack.T();
        }
    }

    public static final void s0(ReadMenu this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.martian.mibook.mvvm.read.widget.a readMenuCallBack = this$0.getReadMenuCallBack();
        if (readMenuCallBack != null) {
            readMenuCallBack.G();
        }
    }

    private final void setChapterNextEnable(boolean isEnable) {
        if (isEnable) {
            this.binding.sbChapterNext.setEnabled(true);
            this.binding.sbChapterNext.setAlpha(1.0f);
        } else {
            this.binding.sbChapterNext.setEnabled(false);
            this.binding.sbChapterNext.setAlpha(0.4f);
        }
    }

    private final void setChapterPreviousEnable(boolean isEnable) {
        if (isEnable) {
            this.binding.sbChapterPrevious.setEnabled(true);
            this.binding.sbChapterPrevious.setAlpha(1.0f);
        } else {
            this.binding.sbChapterPrevious.setEnabled(false);
            this.binding.sbChapterPrevious.setAlpha(0.4f);
        }
    }

    public static final void t0(ReadMenu this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.T(!this$0.binding.readingDir.isSelected());
    }

    public static final void u0(ReadMenu this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.martian.mibook.mvvm.read.widget.a readMenuCallBack = this$0.getReadMenuCallBack();
        if (readMenuCallBack != null) {
            readMenuCallBack.m();
        }
    }

    public static final void v0(ReadMenu this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.U(!this$0.binding.readingSetting.isSelected());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void w0(ReadMenu readMenu, Function0 function0, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            function0 = null;
        }
        readMenu.setOnUpdatePullDownBookMark(function0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void z0(ReadMenu readMenu, long j10, Function0 function0, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            function0 = null;
        }
        readMenu.y0(j10, function0);
    }

    public final void B0() {
        this.binding.readingHideAdCountdown.r();
    }

    public final void C0(boolean isSelected) {
        if (isSelected) {
            this.showDirOrSettingLayoutStatus = 1;
        } else {
            this.showDirOrSettingLayoutStatus = 0;
        }
        this.binding.readingDir.setSelected(isSelected);
    }

    public final void D0(boolean isSelected) {
        ReadingDirectoryLayout readingDirectoryLayout;
        ReadingDirectoryLayout readingDirectoryLayout2;
        CoroutineScope viewModelScope;
        View view;
        ReadingDirectoryLayout readingDirectoryLayout3;
        if (!isSelected) {
            ReaderMenuDirLayoutBinding readerMenuDirLayoutBinding = this.dirLayoutBinding;
            if (readerMenuDirLayoutBinding == null || (readingDirectoryLayout = readerMenuDirLayoutBinding.readingDirLayout) == null) {
                return;
            }
            BottomSheetBehavior.from(readingDirectoryLayout).setState(5);
            return;
        }
        ReaderMenuDirLayoutBinding readerMenuDirLayoutBinding2 = this.dirLayoutBinding;
        if (readerMenuDirLayoutBinding2 != null) {
            if (readerMenuDirLayoutBinding2 == null || (readingDirectoryLayout2 = readerMenuDirLayoutBinding2.readingDirLayout) == null) {
                return;
            }
            BottomSheetBehavior.from(readingDirectoryLayout2).setState(3);
            return;
        }
        this.binding.viewStubDir.setLayoutResource(R.layout.reader_menu_dir_layout);
        this.dirLayoutBinding = ReaderMenuDirLayoutBinding.bind(this.binding.viewStubDir.inflate());
        ReadingViewModel mViewModel = getMViewModel();
        int i10 = (mViewModel == null || mViewModel.getIsPortrait()) ? 0 : ConfigSingleton.i(40.0f);
        ReaderMenuDirLayoutBinding readerMenuDirLayoutBinding3 = this.dirLayoutBinding;
        g0(readerMenuDirLayoutBinding3 != null ? readerMenuDirLayoutBinding3.getRoot() : null, i10);
        ReaderMenuDirLayoutBinding readerMenuDirLayoutBinding4 = this.dirLayoutBinding;
        if (readerMenuDirLayoutBinding4 != null && (readingDirectoryLayout3 = readerMenuDirLayoutBinding4.readingDirLayout) != null) {
            BottomSheetBehavior from = BottomSheetBehavior.from(readingDirectoryLayout3);
            Intrinsics.checkNotNullExpressionValue(from, "from(...)");
            from.setDraggable(true);
            from.setSkipCollapsed(true);
            from.setState(5);
            from.addBottomSheetCallback(new f(readingDirectoryLayout3));
        }
        ReaderMenuDirLayoutBinding readerMenuDirLayoutBinding5 = this.dirLayoutBinding;
        if (readerMenuDirLayoutBinding5 != null && (view = readerMenuDirLayoutBinding5.bottomSheetBg) != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: hd.j
                public /* synthetic */ j() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ReadMenu.E0(ReadMenu.this, view2);
                }
            });
        }
        ReadingViewModel mViewModel2 = getMViewModel();
        if (mViewModel2 == null || (viewModelScope = ViewModelKt.getViewModelScope(mViewModel2)) == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(viewModelScope, Dispatchers.getDefault(), null, new ReadMenu$switchDirLayout$3(this, null), 2, null);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void F0(@k Class<? extends View> clazz, boolean isSelected) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        String name = clazz.getName();
        if (!isSelected) {
            View view = this.secondLayoutContainerMap.get(name);
            if (view != null) {
                BottomSheetBehavior from = BottomSheetBehavior.from(view);
                Intrinsics.checkNotNullExpressionValue(from, "from(...)");
                from.setState(5);
                return;
            }
            return;
        }
        if (this.secondLevelLayoutBinding == null) {
            this.binding.viewStubSecondLevelLayout.setLayoutResource(R.layout.reader_menu_second_level_layout);
            this.secondLevelLayoutBinding = ReaderMenuSecondLevelLayoutBinding.bind(this.binding.viewStubSecondLevelLayout.inflate());
        }
        View view2 = this.secondLayoutContainerMap.get(name);
        if (view2 == null && (view2 = R(clazz)) == null) {
            return;
        }
        boolean z10 = this.secondLayoutContainerMap.get(name) == null;
        Map<String, View> map = this.secondLayoutContainerMap;
        Intrinsics.checkNotNull(name);
        map.put(name, view2);
        K0(true);
        view2.postDelayed(new Runnable() { // from class: hd.a

            /* renamed from: b */
            public final /* synthetic */ View f26545b;

            /* renamed from: c */
            public final /* synthetic */ ReadMenu f26546c;

            public /* synthetic */ a(View view22, ReadMenu this) {
                view2 = view22;
                this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ReadMenu.G0(view2, this);
            }
        }, z10 ? 100L : 0L);
    }

    public final void I() {
        com.martian.mibook.mvvm.read.widget.a readMenuCallBack = getReadMenuCallBack();
        if (readMenuCallBack != null) {
            readMenuCallBack.w("手动");
        }
        ReadingAddShelfViewBinding readingAddShelfViewBinding = this.addShelfViewBinding;
        RelativeLayout root = readingAddShelfViewBinding != null ? readingAddShelfViewBinding.getRoot() : null;
        if (root != null) {
            root.setVisibility(8);
        }
        this.showAddShelfView = false;
    }

    public final void I0(boolean isSelected) {
        if (isSelected) {
            this.showDirOrSettingLayoutStatus = 2;
        } else {
            this.showDirOrSettingLayoutStatus = 0;
        }
        this.binding.readingSetting.setSelected(isSelected);
    }

    public final int J(int progress) {
        return progress - (P() ? 1 : 0);
    }

    public final void J0(boolean isSelected) {
        ReadingSettingLayout readingSettingLayout;
        ReadingSettingLayout readingSettingLayout2;
        CoroutineScope viewModelScope;
        ReadingSettingLayout readingSettingLayout3;
        if (!isSelected) {
            ReaderMenuSettingLayoutBinding readerMenuSettingLayoutBinding = this.settingLayoutBinding;
            if (readerMenuSettingLayoutBinding == null || (readingSettingLayout = readerMenuSettingLayoutBinding.readingSettingLayout) == null) {
                return;
            }
            BottomSheetBehavior.from(readingSettingLayout).setState(5);
            return;
        }
        ReaderMenuSettingLayoutBinding readerMenuSettingLayoutBinding2 = this.settingLayoutBinding;
        if (readerMenuSettingLayoutBinding2 != null) {
            if (readerMenuSettingLayoutBinding2 == null || (readingSettingLayout2 = readerMenuSettingLayoutBinding2.readingSettingLayout) == null) {
                return;
            }
            BottomSheetBehavior.from(readingSettingLayout2).setState(3);
            return;
        }
        this.binding.viewStubSetting.setLayoutResource(R.layout.reader_menu_setting_layout);
        this.settingLayoutBinding = ReaderMenuSettingLayoutBinding.bind(this.binding.viewStubSetting.inflate());
        ReadingViewModel mViewModel = getMViewModel();
        int i10 = (mViewModel == null || mViewModel.getIsPortrait()) ? 0 : ConfigSingleton.i(40.0f);
        ReaderMenuSettingLayoutBinding readerMenuSettingLayoutBinding3 = this.settingLayoutBinding;
        g0(readerMenuSettingLayoutBinding3 != null ? readerMenuSettingLayoutBinding3.getRoot() : null, i10);
        ReaderMenuSettingLayoutBinding readerMenuSettingLayoutBinding4 = this.settingLayoutBinding;
        if (readerMenuSettingLayoutBinding4 != null && (readingSettingLayout3 = readerMenuSettingLayoutBinding4.readingSettingLayout) != null) {
            BottomSheetBehavior from = BottomSheetBehavior.from(readingSettingLayout3);
            Intrinsics.checkNotNullExpressionValue(from, "from(...)");
            from.setDraggable(true);
            from.setSkipCollapsed(true);
            from.setState(5);
            from.addBottomSheetCallback(new g());
        }
        ReadingViewModel mViewModel2 = getMViewModel();
        if (mViewModel2 == null || (viewModelScope = ViewModelKt.getViewModelScope(mViewModel2)) == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(viewModelScope, Dispatchers.getDefault(), null, new ReadMenu$switchSettingLayout$2(this, null), 2, null);
    }

    public final int K(int r32) {
        int i10 = this.chapterSize;
        if (P()) {
            r32++;
            i10 = this.chapterSize + 2;
        }
        return RangesKt.coerceIn(r32, 0, i10 - 1);
    }

    public final void K0(boolean isSelected) {
        ReadingSettingLayout readingSettingLayout;
        ReadingDirectoryLayout readingDirectoryLayout;
        if (!isSelected) {
            d0();
            return;
        }
        e0();
        C0(false);
        I0(false);
        ReaderMenuDirLayoutBinding readerMenuDirLayoutBinding = this.dirLayoutBinding;
        if (readerMenuDirLayoutBinding != null && (readingDirectoryLayout = readerMenuDirLayoutBinding.readingDirLayout) != null) {
            BottomSheetBehavior.from(readingDirectoryLayout).setState(5);
        }
        ReaderMenuSettingLayoutBinding readerMenuSettingLayoutBinding = this.settingLayoutBinding;
        if (readerMenuSettingLayoutBinding == null || (readingSettingLayout = readerMenuSettingLayoutBinding.readingSettingLayout) == null) {
            return;
        }
        BottomSheetBehavior.from(readingSettingLayout).setState(5);
    }

    @l
    public final <T> T L(@k Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        T t10 = (T) this.secondLayoutContainerMap.get(clazz.getName());
        if (t10 == null) {
            return null;
        }
        return t10;
    }

    public final void L0() {
        ReadingSettingLayout readingSettingLayout;
        ReaderMenuSettingLayoutBinding readerMenuSettingLayoutBinding = this.settingLayoutBinding;
        if (readerMenuSettingLayoutBinding == null || (readingSettingLayout = readerMenuSettingLayoutBinding.readingSettingLayout) == null) {
            return;
        }
        readingSettingLayout.L();
    }

    public final void M(boolean isResetView) {
        ReadingViewModel mViewModel = getMViewModel();
        int i10 = (mViewModel == null || mViewModel.getIsPortrait()) ? 0 : ConfigSingleton.i(40.0f);
        ReaderThemeLinearLayout readerThemeLinearLayout = this.binding.rlTopView;
        readerThemeLinearLayout.setPadding(i10, readerThemeLinearLayout.getPaddingTop(), i10, readerThemeLinearLayout.getPaddingBottom());
        ReaderThemeRelativeLayout readerThemeRelativeLayout = this.binding.rlBottomView;
        readerThemeRelativeLayout.setPadding(i10, readerThemeRelativeLayout.getPaddingTop(), i10, readerThemeRelativeLayout.getPaddingBottom());
        ConstraintLayout constraintLayout = this.binding.readingBottomTts;
        constraintLayout.setPadding(i10, constraintLayout.getPaddingTop(), i10, constraintLayout.getPaddingBottom());
        Intrinsics.checkNotNull(constraintLayout);
        int childCount = constraintLayout.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = constraintLayout.getChildAt(i11);
            Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(index)");
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            constraintLayout.removeView(childAt);
            constraintLayout.addView(childAt, i11, layoutParams);
        }
        ReaderThemeLinearLayout readerThemeLinearLayout2 = this.binding.readingHideAdView;
        readerThemeLinearLayout2.setPadding(i10, readerThemeLinearLayout2.getPaddingTop(), i10, readerThemeLinearLayout2.getPaddingBottom());
        ReaderThemeLinearLayout readerThemeLinearLayout3 = this.binding.readingCacheStatus;
        readerThemeLinearLayout3.setPadding(i10, readerThemeLinearLayout3.getPaddingTop(), i10, readerThemeLinearLayout3.getPaddingBottom());
        ReaderThemeLinearLayout readerThemeLinearLayout4 = this.binding.readingChapterPosition;
        readerThemeLinearLayout4.setPadding(i10, readerThemeLinearLayout4.getPaddingTop(), i10, readerThemeLinearLayout4.getPaddingBottom());
        ReaderMenuSecondLevelLayoutBinding readerMenuSecondLevelLayoutBinding = this.secondLevelLayoutBinding;
        g0(readerMenuSecondLevelLayoutBinding != null ? readerMenuSecondLevelLayoutBinding.getRoot() : null, i10);
        ReaderMenuDirLayoutBinding readerMenuDirLayoutBinding = this.dirLayoutBinding;
        g0(readerMenuDirLayoutBinding != null ? readerMenuDirLayoutBinding.getRoot() : null, i10);
        ReaderMenuSettingLayoutBinding readerMenuSettingLayoutBinding = this.settingLayoutBinding;
        g0(readerMenuSettingLayoutBinding != null ? readerMenuSettingLayoutBinding.getRoot() : null, i10);
        if (isResetView) {
            Z();
        }
    }

    public final void M0(boolean showComment) {
        Context context;
        int i10;
        this.binding.withCommentsIcon.setImageResource(showComment ? R.drawable.reader_icon_comment_opened : R.drawable.reader_icon_comment_closed);
        ReaderThemeTextView readerThemeTextView = this.binding.withCommentsDesc;
        if (showComment) {
            context = readerThemeTextView.getContext();
            i10 = R.string.comment_opened;
        } else {
            context = readerThemeTextView.getContext();
            i10 = R.string.comment_closed;
        }
        readerThemeTextView.setText(context.getString(i10));
    }

    public final void N0() {
        Context context;
        int i10;
        ReaderThemeTextView readerThemeTextView = this.binding.tvVip;
        if (MiConfigSingleton.b2().K2()) {
            context = readerThemeTextView.getContext();
            i10 = R.string.vip_renew;
        } else {
            context = readerThemeTextView.getContext();
            i10 = R.string.free_ads;
        }
        readerThemeTextView.setText(context.getString(i10));
    }

    public final void O() {
        ReadingViewModel mViewModel;
        TYBookTopUser tyBookTopUser;
        List<TYBookItem> readBooks;
        ReadingViewModel mViewModel2 = getMViewModel();
        if ((mViewModel2 != null ? mViewModel2.getTyBookTopUser() : null) == null || (mViewModel = getMViewModel()) == null || (tyBookTopUser = mViewModel.getTyBookTopUser()) == null || (readBooks = tyBookTopUser.getReadBooks()) == null || !(!readBooks.isEmpty())) {
            this.binding.ivBookFriendRecommend.setVisibility(8);
        } else {
            this.binding.ivBookFriendRecommend.setVisibility(0);
        }
        if (MiConfigSingleton.b2().E2()) {
            this.binding.llCacheModeVipTag.setVisibility(8);
        } else {
            this.binding.llCacheModeVipTag.setVisibility(0);
        }
    }

    public final boolean P() {
        ReadingViewModel mViewModel = getMViewModel();
        return mViewModel != null && mViewModel.U1();
    }

    public final boolean Q() {
        return this.binding.readingChapterSeek.getVisibility() == getVisibility();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v4, types: [T, java.lang.Object] */
    public final View R(Class<? extends View> clazz) {
        CoordinatorLayout root;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        try {
            Constructor<? extends View> constructor = clazz.getConstructor(Context.class);
            Intrinsics.checkNotNullExpressionValue(constructor, "getConstructor(...)");
            ?? newInstance = constructor.newInstance(getContext());
            objectRef.element = newInstance;
            ((View) newInstance).setId(View.generateViewId());
            CoordinatorLayout.LayoutParams layoutParams = new CoordinatorLayout.LayoutParams(-1, -2);
            layoutParams.setBehavior(new BottomSheetBehavior());
            ReaderMenuSecondLevelLayoutBinding readerMenuSecondLevelLayoutBinding = this.secondLevelLayoutBinding;
            if (readerMenuSecondLevelLayoutBinding != null && (root = readerMenuSecondLevelLayoutBinding.getRoot()) != null) {
                root.addView((View) objectRef.element, layoutParams);
            }
            ReadingViewModel mViewModel = getMViewModel();
            int i10 = (mViewModel == null || mViewModel.getIsPortrait()) ? 0 : ConfigSingleton.i(40.0f);
            ReaderMenuSecondLevelLayoutBinding readerMenuSecondLevelLayoutBinding2 = this.secondLevelLayoutBinding;
            g0(readerMenuSecondLevelLayoutBinding2 != null ? readerMenuSecondLevelLayoutBinding2.getRoot() : null, i10);
            BottomSheetBehavior from = BottomSheetBehavior.from((View) objectRef.element);
            Intrinsics.checkNotNullExpressionValue(from, "from(...)");
            from.setHideable(true);
            from.setSkipCollapsed(true);
            from.setPeekHeight(0);
            from.setState(5);
            from.addBottomSheetCallback(new a(objectRef, this));
        } catch (Exception unused) {
        }
        return (View) objectRef.element;
    }

    public final boolean S() {
        ReadingSettingLayout readingSettingLayout;
        ReadingDirectoryLayout readingDirectoryLayout;
        ReaderMenuDirLayoutBinding readerMenuDirLayoutBinding = this.dirLayoutBinding;
        if (readerMenuDirLayoutBinding != null && (readingDirectoryLayout = readerMenuDirLayoutBinding.readingDirLayout) != null && BottomSheetBehavior.from(readingDirectoryLayout).getState() == 3) {
            T(false);
            return true;
        }
        ReaderMenuSettingLayoutBinding readerMenuSettingLayoutBinding = this.settingLayoutBinding;
        if (readerMenuSettingLayoutBinding != null && (readingSettingLayout = readerMenuSettingLayoutBinding.readingSettingLayout) != null && BottomSheetBehavior.from(readingSettingLayout).getState() == 3) {
            U(false);
            return true;
        }
        for (Map.Entry<String, View> entry : this.secondLayoutContainerMap.entrySet()) {
            entry.getValue().setTag(Boolean.FALSE);
            BottomSheetBehavior from = BottomSheetBehavior.from(entry.getValue());
            Intrinsics.checkNotNullExpressionValue(from, "from(...)");
            if (from.getState() == 3) {
                from.setState(5);
                return true;
            }
        }
        return false;
    }

    public final void T(boolean z10) {
        if (!z10) {
            d0();
            C0(false);
            D0(false);
        } else {
            e0();
            C0(true);
            D0(true);
            U(false);
        }
    }

    public final void U(boolean isSelected) {
        if (!isSelected) {
            I0(false);
            J0(false);
        } else {
            I0(true);
            T(false);
            J0(true);
        }
    }

    public final void V() {
        RelativeLayout root;
        ReadingAddShelfViewBinding readingAddShelfViewBinding;
        RelativeLayout root2;
        RoundedLayout roundedLayout;
        ReadingViewModel mViewModel = getMViewModel();
        boolean z10 = !(mViewModel != null ? mViewModel.R1() : true);
        this.showAddShelfView = z10;
        if (!z10) {
            ReadingAddShelfViewBinding readingAddShelfViewBinding2 = this.addShelfViewBinding;
            RelativeLayout root3 = readingAddShelfViewBinding2 != null ? readingAddShelfViewBinding2.getRoot() : null;
            if (root3 == null) {
                return;
            }
            root3.setVisibility(8);
            return;
        }
        if (this.addShelfViewBinding == null) {
            this.binding.readingAddShelfView.setLayoutResource(R.layout.reading_add_shelf_view);
            ReadingAddShelfViewBinding bind = ReadingAddShelfViewBinding.bind(this.binding.readingAddShelfView.inflate());
            this.addShelfViewBinding = bind;
            if (bind != null && (roundedLayout = bind.readingAddShelf) != null) {
                roundedLayout.setOnClickListener(new View.OnClickListener() { // from class: hd.k
                    public /* synthetic */ k() {
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ReadMenu.W(ReadMenu.this, view);
                    }
                });
            }
        }
        ReadingAddShelfViewBinding readingAddShelfViewBinding3 = this.addShelfViewBinding;
        if (readingAddShelfViewBinding3 == null || (root = readingAddShelfViewBinding3.getRoot()) == null || root.getVisibility() != 8 || (readingAddShelfViewBinding = this.addShelfViewBinding) == null || (root2 = readingAddShelfViewBinding.getRoot()) == null) {
            return;
        }
        root2.startAnimation(getAddBookShelfAnimationIn());
    }

    public final void X() {
        ReadingViewModel mViewModel;
        CoroutineScope viewModelScope;
        if (this.binding.readingExtraPageTip.getVisibility() != 0 || (mViewModel = getMViewModel()) == null || (viewModelScope = ViewModelKt.getViewModelScope(mViewModel)) == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(viewModelScope, Dispatchers.getDefault(), null, new ReadMenu$refreshReadingChapterSeekTipStatus$1(this, null), 2, null);
    }

    public final void Y(@k Class<? extends View> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        String name = clazz.getName();
        if (this.secondLayoutContainerMap.get(name) != null) {
            F0(clazz, false);
            this.secondLayoutContainerMap.remove(name);
        }
    }

    public final void Z() {
        ReaderMenuSettingLayoutBinding readerMenuSettingLayoutBinding = this.settingLayoutBinding;
        if (readerMenuSettingLayoutBinding != null) {
            CoordinatorLayout root = readerMenuSettingLayoutBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            int childCount = root.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = root.getChildAt(i10);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(index)");
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                readerMenuSettingLayoutBinding.getRoot().removeView(childAt);
                readerMenuSettingLayoutBinding.getRoot().addView(childAt, i10, layoutParams);
            }
        }
        ReaderMenuSecondLevelLayoutBinding readerMenuSecondLevelLayoutBinding = this.secondLevelLayoutBinding;
        if (readerMenuSecondLevelLayoutBinding != null) {
            CoordinatorLayout root2 = readerMenuSecondLevelLayoutBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
            int childCount2 = root2.getChildCount();
            for (int i11 = 0; i11 < childCount2; i11++) {
                View childAt2 = root2.getChildAt(i11);
                Intrinsics.checkNotNullExpressionValue(childAt2, "getChildAt(index)");
                ViewGroup.LayoutParams layoutParams2 = childAt2.getLayoutParams();
                if (layoutParams2 instanceof CoordinatorLayout.LayoutParams) {
                    BottomSheetBehavior from = BottomSheetBehavior.from(childAt2);
                    Intrinsics.checkNotNullExpressionValue(from, "from(...)");
                    if (from.getState() != 5) {
                        childAt2.setTag(Boolean.FALSE);
                        from.setState(5);
                    }
                }
                readerMenuSecondLevelLayoutBinding.getRoot().removeView(childAt2);
                readerMenuSecondLevelLayoutBinding.getRoot().addView(childAt2, i11, layoutParams2);
            }
        }
        ReaderMenuDirLayoutBinding readerMenuDirLayoutBinding = this.dirLayoutBinding;
        if (readerMenuDirLayoutBinding != null) {
            CoordinatorLayout root3 = readerMenuDirLayoutBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root3, "getRoot(...)");
            int childCount3 = root3.getChildCount();
            for (int i12 = 0; i12 < childCount3; i12++) {
                View childAt3 = root3.getChildAt(i12);
                Intrinsics.checkNotNullExpressionValue(childAt3, "getChildAt(index)");
                ViewGroup.LayoutParams layoutParams3 = childAt3.getLayoutParams();
                readerMenuDirLayoutBinding.getRoot().removeView(childAt3);
                readerMenuDirLayoutBinding.getRoot().addView(childAt3, i12, layoutParams3);
            }
        }
    }

    public final void a0() {
        if (this.showMenu) {
            return;
        }
        this.showMenu = true;
        setVisibility(0);
        this.binding.topMenu.setVisibility(0);
        ReadingViewModel mViewModel = getMViewModel();
        if (mViewModel != null) {
            mViewModel.U2(true, 3);
        }
        Function0<Unit> function0 = this.onUpdatePullDownBookMark;
        if (function0 != null) {
            function0.invoke();
        }
        this.binding.bottomMenu.setVisibility(0);
        this.binding.topMenu.startAnimation(getMenuTopIn());
        this.binding.bottomMenu.startAnimation(getMenuBottomIn());
        V();
    }

    public final void b0(@l Function0<Unit> onMenuOutEnd) {
        ReadingAddShelfViewBinding readingAddShelfViewBinding;
        RelativeLayout root;
        ReadingAddShelfViewBinding readingAddShelfViewBinding2;
        RelativeLayout root2;
        if (this.showMenu) {
            this.showMenu = false;
            this.onMenuOutEnd = onMenuOutEnd;
            if (getVisibility() == 0) {
                if (this.binding.topMenu.getVisibility() == 0) {
                    this.binding.topMenu.startAnimation(getMenuTopOut());
                }
                for (Map.Entry<String, View> entry : this.secondLayoutContainerMap.entrySet()) {
                    entry.getValue().setTag(Boolean.FALSE);
                    BottomSheetBehavior from = BottomSheetBehavior.from(entry.getValue());
                    Intrinsics.checkNotNullExpressionValue(from, "from(...)");
                    from.setState(5);
                }
                C0(false);
                D0(false);
                I0(false);
                J0(false);
                this.binding.bottomMenu.startAnimation(getMenuBottomOut());
                if (!this.showAddShelfView || (readingAddShelfViewBinding = this.addShelfViewBinding) == null || (root = readingAddShelfViewBinding.getRoot()) == null || root.getVisibility() != 0 || (readingAddShelfViewBinding2 = this.addShelfViewBinding) == null || (root2 = readingAddShelfViewBinding2.getRoot()) == null) {
                    return;
                }
                root2.startAnimation(getAddBookShelfAnimationOut());
            }
        }
    }

    public final void d0() {
        ReadingAddShelfViewBinding readingAddShelfViewBinding;
        RelativeLayout root;
        ReadingAddShelfViewBinding readingAddShelfViewBinding2;
        RelativeLayout root2;
        if (this.binding.topMenu.getVisibility() == 4 || this.binding.topMenu.getVisibility() == 8) {
            this.binding.topMenu.startAnimation(getOnlyMenuTopIn());
            if (!this.showAddShelfView || (readingAddShelfViewBinding = this.addShelfViewBinding) == null || (root = readingAddShelfViewBinding.getRoot()) == null || root.getVisibility() != 8 || (readingAddShelfViewBinding2 = this.addShelfViewBinding) == null || (root2 = readingAddShelfViewBinding2.getRoot()) == null) {
                return;
            }
            root2.startAnimation(getAddBookShelfAnimationIn());
        }
    }

    public final void e0() {
        ReadingAddShelfViewBinding readingAddShelfViewBinding;
        RelativeLayout root;
        ReadingAddShelfViewBinding readingAddShelfViewBinding2;
        RelativeLayout root2;
        if (this.binding.topMenu.getVisibility() == 0) {
            this.binding.topMenu.startAnimation(getOnlyMenuTopOut());
            if (!this.showAddShelfView || (readingAddShelfViewBinding = this.addShelfViewBinding) == null || (root = readingAddShelfViewBinding.getRoot()) == null || root.getVisibility() != 0 || (readingAddShelfViewBinding2 = this.addShelfViewBinding) == null || (root2 = readingAddShelfViewBinding2.getRoot()) == null) {
                return;
            }
            root2.startAnimation(getAddBookShelfAnimationOut());
        }
    }

    public final void f0(int r32, @l Integer chapterCount) {
        setOnChapterSeekBarMax(chapterCount);
        setOnChapterSeekBarProgress(r32);
        setChapterPreviousEnable(this.binding.sbChapterSeek.getProgress() > 0);
        setChapterNextEnable(this.binding.sbChapterSeek.getProgress() < this.binding.sbChapterSeek.getMax());
    }

    public final void g0(ViewGroup rootView, int horizontalPadding) {
        if (rootView != null) {
            int childCount = rootView.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = rootView.getChildAt(i10);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(index)");
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if ((childAt instanceof ViewGroup) && (layoutParams instanceof CoordinatorLayout.LayoutParams) && (((CoordinatorLayout.LayoutParams) layoutParams).getBehavior() instanceof BottomSheetBehavior)) {
                    View view = ViewGroupKt.get((ViewGroup) childAt, 0);
                    RoundedLayout roundedLayout = view instanceof RoundedLayout ? (RoundedLayout) view : null;
                    if (roundedLayout != null && roundedLayout.getChildCount() == 1) {
                        ViewGroupKt.get(roundedLayout, 0).setPadding(horizontalPadding, getPaddingTop(), horizontalPadding, getPaddingBottom());
                    }
                }
            }
        }
    }

    @k
    public final View getBookFriendsView() {
        ImageView ivBookFriendRecommend = this.binding.ivBookFriendRecommend;
        Intrinsics.checkNotNullExpressionValue(ivBookFriendRecommend, "ivBookFriendRecommend");
        return ivBookFriendRecommend;
    }

    public final boolean getShowMenu() {
        return this.showMenu;
    }

    @k
    public final View getStatusView() {
        View statusView = this.binding.statusView;
        Intrinsics.checkNotNullExpressionValue(statusView, "statusView");
        return statusView;
    }

    @k
    public final FrameLayout getTtsFloatView() {
        FrameLayout ttsFloatView = this.binding.ttsFloatView;
        Intrinsics.checkNotNullExpressionValue(ttsFloatView, "ttsFloatView");
        return ttsFloatView;
    }

    public final void h0() {
        this.binding.ivBack.setOnClickListener(new View.OnClickListener() { // from class: hd.n
            public /* synthetic */ n() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadMenu.i0(ReadMenu.this, view);
            }
        });
        this.binding.llVipView.setOnClickListener(new View.OnClickListener() { // from class: hd.s
            public /* synthetic */ s() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadMenu.j0(ReadMenu.this, view);
            }
        });
        this.binding.withComments.setOnClickListener(new View.OnClickListener() { // from class: hd.b
            public /* synthetic */ b() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadMenu.k0(ReadMenu.this, view);
            }
        });
        this.binding.llCacheMode.setOnClickListener(new View.OnClickListener() { // from class: hd.c
            public /* synthetic */ c() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadMenu.l0(ReadMenu.this, view);
            }
        });
        this.binding.moreItemView.setOnClickListener(new View.OnClickListener() { // from class: hd.d
            public /* synthetic */ d() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadMenu.m0(ReadMenu.this, view);
            }
        });
        this.binding.ivBookFriendRecommend.setOnClickListener(new View.OnClickListener() { // from class: hd.e
            public /* synthetic */ e() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadMenu.n0(ReadMenu.this, view);
            }
        });
        this.binding.ttsIcon.setOnClickListener(new View.OnClickListener() { // from class: hd.f
            public /* synthetic */ f() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadMenu.o0(ReadMenu.this, view);
            }
        });
        this.binding.readingHideAdMore.setOnClickListener(new View.OnClickListener() { // from class: hd.g
            public /* synthetic */ g() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadMenu.p0(ReadMenu.this, view);
            }
        });
        this.binding.llPreviousSeek.setOnClickListener(new View.OnClickListener() { // from class: hd.h
            public /* synthetic */ h() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadMenu.q0(ReadMenu.this, view);
            }
        });
        this.binding.sbChapterPrevious.setOnClickListener(new View.OnClickListener() { // from class: hd.i
            public /* synthetic */ i() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadMenu.r0(ReadMenu.this, view);
            }
        });
        this.binding.sbChapterNext.setOnClickListener(new View.OnClickListener() { // from class: hd.o
            public /* synthetic */ o() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadMenu.s0(ReadMenu.this, view);
            }
        });
        this.binding.llDir.setOnClickListener(new View.OnClickListener() { // from class: hd.p
            public /* synthetic */ p() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadMenu.t0(ReadMenu.this, view);
            }
        });
        this.binding.llNightMode.setOnClickListener(new View.OnClickListener() { // from class: hd.q
            public /* synthetic */ q() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadMenu.u0(ReadMenu.this, view);
            }
        });
        this.binding.llPageSetting.setOnClickListener(new View.OnClickListener() { // from class: hd.r
            public /* synthetic */ r() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadMenu.v0(ReadMenu.this, view);
            }
        });
    }

    @SuppressLint({"SetTextI18n"})
    public final void setBottomCacheStatus(int status) {
        if (status == 0) {
            this.binding.readingCacheStatus.setVisibility(0);
            this.binding.tvCacheStatus.setText(ExtKt.c("正在缓存: "));
            ReaderThemeTextView readerThemeTextView = this.binding.tvBookname;
            ReadingViewModel mViewModel = getMViewModel();
            readerThemeTextView.setText(mViewModel != null ? mViewModel.e0() : null);
            this.binding.tvProgress.setText("(计算中...)");
            return;
        }
        if (status == 1) {
            this.binding.tvCacheStatus.setText(ExtKt.c("全部章节已缓存"));
            this.binding.tvBookname.setText("");
            this.binding.tvProgress.setText("");
            return;
        }
        if (status == 2) {
            ReaderThemeTextView readerThemeTextView2 = this.binding.tvProgress;
            ReadingViewModel mViewModel2 = getMViewModel();
            readerThemeTextView2.setText(mViewModel2 != null ? mViewModel2.getCacheProgressString() : null);
        } else if (status == 4) {
            this.binding.tvProgress.setText("");
            this.binding.tvCacheStatus.setText(ExtKt.c("缓存失败: "));
        } else if (status == 5 || status == 6) {
            ReaderThemeTextView readerThemeTextView3 = this.binding.tvProgress;
            ReadingViewModel mViewModel3 = getMViewModel();
            readerThemeTextView3.setText(mViewModel3 != null ? mViewModel3.getCacheProgressString() : null);
            this.binding.tvCacheStatus.setText(ExtKt.c("缓存完成: "));
        }
    }

    public final void setCacheModeVisible(int visibility) {
        this.binding.clCacheMode.setVisibility(visibility);
    }

    public final void setHideAdCountDownTextColor(int textColor) {
        this.binding.readingHideAdCountdown.setTextColor(textColor);
    }

    public final void setHideAdMoreText(@l String text) {
        this.binding.readingHideAdMoreText.setText(text);
    }

    public final void setNightModeStatus(boolean isNightMode) {
        if (isNightMode) {
            this.binding.readingLightSetting.setImageResource(R.drawable.reader_day_moded_icon);
            this.binding.readingLightTitle.setText(getContext().getString(R.string.day_mode));
        } else {
            this.binding.readingLightSetting.setImageResource(R.drawable.reader_night_moded_icon);
            this.binding.readingLightTitle.setText(getContext().getString(R.string.night_mode));
        }
    }

    public final void setOnChapterSeekBarChangeListener(@k SeekBar.OnSeekBarChangeListener onChapterSeekBarChangeListener) {
        Intrinsics.checkNotNullParameter(onChapterSeekBarChangeListener, "onChapterSeekBarChangeListener");
        this.binding.sbChapterSeek.setOnSeekBarChangeListener(onChapterSeekBarChangeListener);
    }

    public final void setOnChapterSeekBarMax(@l Integer chapterCount) {
        int intValue = chapterCount != null ? chapterCount.intValue() : 0;
        this.chapterSize = intValue;
        if (intValue == 0) {
            this.binding.sbChapterSeek.setMax(0);
        } else {
            this.binding.sbChapterSeek.setMax((intValue - 1) + (P() ? 2 : 0));
        }
    }

    public final void setOnChapterSeekBarProgress(int r22) {
        this.binding.sbChapterSeek.setProgress(K(r22));
    }

    public final void setOnUpdatePullDownBookMark(@l Function0<Unit> onUpdatePullDownBookMark) {
        this.onUpdatePullDownBookMark = onUpdatePullDownBookMark;
    }

    public final void setShowMenu(boolean z10) {
        this.showMenu = z10;
    }

    public final void setVipViewVisible(int visibility) {
        this.binding.llVipView.setVisibility(visibility);
    }

    public final void setVisibleReadingCacheStatus(int visibility) {
        this.binding.readingCacheStatus.setVisibility(visibility);
    }

    public final void setVisibleReadingChapterSeek(int visibility) {
        this.binding.readingChapterSeek.setVisibility(visibility);
        this.binding.readingChapterLine.p();
    }

    public final void setVisibleReadingHideAdView(int visibility) {
        this.binding.readingHideAdView.setVisibility(visibility);
    }

    public final void setVisibleTtsIcon(int visibility) {
        this.binding.ttsIcon.setVisibility(visibility);
    }

    public final void setWithCommentsVisible(int visibility) {
        this.binding.withComments.setVisibility(visibility);
    }

    @SuppressLint({"SetTextI18n"})
    public final void x0(int r72, @k ChapterList chapterList) {
        Intrinsics.checkNotNullParameter(chapterList, "chapterList");
        boolean P = P();
        boolean z10 = r72 <= 0;
        boolean z11 = r72 >= this.chapterSize + (P ? 1 : 0);
        if (P && (z10 || z11)) {
            this.binding.readingExtraPageTip.setText(ExtKt.c(z10 ? "书封页" : "书末页"));
            this.binding.readingChapterTitle.setVisibility(4);
            this.binding.readingChapterNumber.setVisibility(4);
            this.binding.readingExtraPageTip.setVisibility(0);
            return;
        }
        this.binding.readingChapterTitle.setText(ExtKt.c(chapterList.getItem(P ? r72 - 1 : r72).getTitle()));
        this.binding.readingChapterNumber.setText((r72 + (!P ? 1 : 0)) + "/" + chapterList.getCount());
        this.binding.readingExtraPageTip.setVisibility(4);
        this.binding.readingChapterTitle.setVisibility(0);
        this.binding.readingChapterNumber.setVisibility(0);
    }

    public final void y0(long targetTime, @l Function0<Unit> onCountDownFinish) {
        this.binding.readingHideAdCountdown.m(targetTime);
        this.binding.readingHideAdCountdown.setOnCountDownFinishListener(new IntervalCountdownTextView.b() { // from class: hd.m
            public /* synthetic */ m() {
            }

            @Override // com.martian.mibook.ui.IntervalCountdownTextView.b
            public final void a(IntervalCountdownTextView intervalCountdownTextView) {
                ReadMenu.A0(Function0.this, intervalCountdownTextView);
            }
        });
    }

    public /* synthetic */ ReadMenu(Context context, AttributeSet attributeSet, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReadMenu(@k Context context, @l AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.secondLayoutContainerMap = new LinkedHashMap();
        this.mViewModel = LazyKt.lazy(new Function0<ReadingViewModel>() { // from class: com.martian.mibook.mvvm.read.widget.ReadMenu$mViewModel$2
            final /* synthetic */ Context $context;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReadMenu$mViewModel$2(Context context2) {
                super(0);
                context = context2;
            }

            @Override // kotlin.jvm.functions.Function0
            @l
            public final ReadingViewModel invoke() {
                Object obj = context;
                if (obj instanceof FragmentActivity) {
                    return (ReadingViewModel) new ViewModelProvider((ViewModelStoreOwner) obj).get(ReadingViewModel.class);
                }
                return null;
            }
        });
        ViewReadMenuBinding inflate = ViewReadMenuBinding.inflate(LayoutInflater.from(context2), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        this.menuTopIn = LazyKt.lazy(new Function0<Animation>() { // from class: com.martian.mibook.mvvm.read.widget.ReadMenu$menuTopIn$2
            final /* synthetic */ Context $context;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReadMenu$menuTopIn$2(Context context2) {
                super(0);
                context = context2;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Animation invoke() {
                return AnimationUtils.loadAnimation(context, R.anim.anim_readbook_top_in);
            }
        });
        this.menuTopOut = LazyKt.lazy(new Function0<Animation>() { // from class: com.martian.mibook.mvvm.read.widget.ReadMenu$menuTopOut$2
            final /* synthetic */ Context $context;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReadMenu$menuTopOut$2(Context context2) {
                super(0);
                context = context2;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Animation invoke() {
                return AnimationUtils.loadAnimation(context, R.anim.anim_readbook_top_out);
            }
        });
        this.menuBottomIn = LazyKt.lazy(new Function0<Animation>() { // from class: com.martian.mibook.mvvm.read.widget.ReadMenu$menuBottomIn$2
            final /* synthetic */ Context $context;
            final /* synthetic */ ReadMenu this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReadMenu$menuBottomIn$2(Context context2, ReadMenu this) {
                super(0);
                context = context2;
                this = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Animation invoke() {
                ReadMenu.b bVar;
                Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.anim_readbook_bottom_in);
                bVar = this.menuInListener;
                loadAnimation.setAnimationListener(bVar);
                return loadAnimation;
            }
        });
        this.menuBottomOut = LazyKt.lazy(new Function0<Animation>() { // from class: com.martian.mibook.mvvm.read.widget.ReadMenu$menuBottomOut$2
            final /* synthetic */ Context $context;
            final /* synthetic */ ReadMenu this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReadMenu$menuBottomOut$2(Context context2, ReadMenu this) {
                super(0);
                context = context2;
                this = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Animation invoke() {
                ReadMenu.c cVar;
                Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.anim_readbook_bottom_out);
                cVar = this.menuOutListener;
                loadAnimation.setAnimationListener(cVar);
                return loadAnimation;
            }
        });
        this.onlyMenuTopOut = LazyKt.lazy(new Function0<Animation>() { // from class: com.martian.mibook.mvvm.read.widget.ReadMenu$onlyMenuTopOut$2
            final /* synthetic */ Context $context;
            final /* synthetic */ ReadMenu this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReadMenu$onlyMenuTopOut$2(Context context2, ReadMenu this) {
                super(0);
                context = context2;
                this = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Animation invoke() {
                ReadMenu.e eVar;
                Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.anim_readbook_top_out);
                eVar = this.onlyMenuTopOutListener;
                loadAnimation.setAnimationListener(eVar);
                return loadAnimation;
            }
        });
        this.onlyMenuTopIn = LazyKt.lazy(new Function0<Animation>() { // from class: com.martian.mibook.mvvm.read.widget.ReadMenu$onlyMenuTopIn$2
            final /* synthetic */ Context $context;
            final /* synthetic */ ReadMenu this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReadMenu$onlyMenuTopIn$2(Context context2, ReadMenu this) {
                super(0);
                context = context2;
                this = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Animation invoke() {
                ReadMenu.d dVar;
                Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.anim_readbook_top_in);
                dVar = this.onlyMenuTopInListener;
                loadAnimation.setAnimationListener(dVar);
                return loadAnimation;
            }
        });
        this.addBookShelfAnimationIn = LazyKt.lazy(new Function0<Animation>() { // from class: com.martian.mibook.mvvm.read.widget.ReadMenu$addBookShelfAnimationIn$2
            final /* synthetic */ Context $context;
            final /* synthetic */ ReadMenu this$0;

            public static final class a implements Animation.AnimationListener {

                /* renamed from: a */
                public final /* synthetic */ ReadMenu f14855a;

                public a(ReadMenu readMenu) {
                    this.f14855a = readMenu;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(@l Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(@l Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(@l Animation animation) {
                    ReadingAddShelfViewBinding readingAddShelfViewBinding;
                    readingAddShelfViewBinding = this.f14855a.addShelfViewBinding;
                    RelativeLayout root = readingAddShelfViewBinding != null ? readingAddShelfViewBinding.getRoot() : null;
                    if (root == null) {
                        return;
                    }
                    root.setVisibility(0);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReadMenu$addBookShelfAnimationIn$2(Context context2, ReadMenu this) {
                super(0);
                context = context2;
                this = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Animation invoke() {
                Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.anim_readbook_right_in);
                loadAnimation.setAnimationListener(new a(this));
                return loadAnimation;
            }
        });
        this.addBookShelfAnimationOut = LazyKt.lazy(new Function0<Animation>() { // from class: com.martian.mibook.mvvm.read.widget.ReadMenu$addBookShelfAnimationOut$2
            final /* synthetic */ Context $context;
            final /* synthetic */ ReadMenu this$0;

            public static final class a implements Animation.AnimationListener {

                /* renamed from: a */
                public final /* synthetic */ ReadMenu f14856a;

                public a(ReadMenu readMenu) {
                    this.f14856a = readMenu;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(@l Animation animation) {
                    ReadingAddShelfViewBinding readingAddShelfViewBinding;
                    readingAddShelfViewBinding = this.f14856a.addShelfViewBinding;
                    RelativeLayout root = readingAddShelfViewBinding != null ? readingAddShelfViewBinding.getRoot() : null;
                    if (root == null) {
                        return;
                    }
                    root.setVisibility(8);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(@l Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(@l Animation animation) {
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReadMenu$addBookShelfAnimationOut$2(Context context2, ReadMenu this) {
                super(0);
                context = context2;
                this = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Animation invoke() {
                Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.anim_readbook_right_out);
                loadAnimation.setAnimationListener(new a(this));
                return loadAnimation;
            }
        });
        O();
        h0();
        this.menuInListener = new b();
        this.menuOutListener = new c();
        this.onlyMenuTopOutListener = new e();
        this.onlyMenuTopInListener = new d();
    }
}
