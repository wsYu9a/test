package com.martian.mibook.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.google.android.flexbox.FlexboxLayout;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.theme.MiReadingTheme;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.ui.FlexboxTagLayout;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.f;
import id.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002:\u0001kB\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\tH\u0014¢\u0006\u0004\b\u0018\u0010\u000bJ\u000f\u0010\u0019\u001a\u00020\tH\u0014¢\u0006\u0004\b\u0019\u0010\u000bJ\u0015\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u000e¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u000e¢\u0006\u0004\b\u001d\u0010\u0017J\r\u0010\u001e\u001a\u00020\f¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\"\u001a\u00020\t2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\f0 ¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\tH\u0016¢\u0006\u0004\b$\u0010\u000bJ\u0015\u0010'\u001a\u00020\t2\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\u0015\u0010*\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u0010¢\u0006\u0004\b*\u0010+J\r\u0010,\u001a\u00020\t¢\u0006\u0004\b,\u0010\u000bJ\u000f\u0010-\u001a\u00020\tH\u0002¢\u0006\u0004\b-\u0010\u000bJ\u0011\u0010/\u001a\u0004\u0018\u00010.H\u0002¢\u0006\u0004\b/\u00100J%\u00102\u001a\u00020\t2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\f0 2\u0006\u00101\u001a\u00020\u000eH\u0002¢\u0006\u0004\b2\u00103J\u001f\u00104\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b4\u00105R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010<\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010;R\u0014\u0010@\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010;R\u0014\u0010D\u001a\u00020A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010F\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010;R\u0016\u0010H\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010;R\u0014\u0010J\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u00108R\u0014\u0010L\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010;R\u0014\u0010M\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u00108R\u0014\u0010N\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010;R\u0014\u0010P\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010;R\u0014\u0010Q\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010;R\u0014\u0010R\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010;R\u0014\u0010T\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010;R\u0014\u0010V\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010;R\u0014\u0010W\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010;R\u0014\u0010X\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u0010;R\u0016\u0010Y\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010;R\u0016\u0010Z\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010;R\u0016\u0010[\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010;R\u0016\u0010]\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u00108R$\u0010b\u001a\u0012\u0012\u0004\u0012\u00020\f0^j\b\u0012\u0004\u0012\u00020\f`_8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010f\u001a\u00020c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010h\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u00108R\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010j¨\u0006l"}, d2 = {"Lcom/martian/mibook/ui/FlexboxTagLayout;", "Lcom/google/android/flexbox/FlexboxLayout;", "Lk9/a;", "Landroid/content/Context;", f.X, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "M", "()V", "", "name", "", c.f26972i, "Landroid/widget/TextView;", "J", "(Ljava/lang/String;I)Landroid/widget/TextView;", "Landroid/widget/ImageView;", "getMoreIcon", "()Landroid/widget/ImageView;", "getIconWidth", "()I", "onAttachedToWindow", "onDetachedFromWindow", "selectPosition", "setSelectPosition", "(I)V", "getSelectPosition", "getSelectedItem", "()Ljava/lang/String;", "", DBDefinition.SEGMENT_INFO, "setData", "(Ljava/util/List;)V", "p", "Lcom/martian/mibook/ui/FlexboxTagLayout$a;", "onItemTitleClickListener", "setOnItemTitleClickListener", "(Lcom/martian/mibook/ui/FlexboxTagLayout$a;)V", "textView", "setTypeface", "(Landroid/widget/TextView;)V", "O", "P", "Landroid/widget/HorizontalScrollView;", "G", "()Landroid/widget/HorizontalScrollView;", "index", "N", "(Ljava/util/List;I)V", "Q", "(Landroid/widget/TextView;I)V", "", IAdInterListener.AdReqParam.WIDTH, "Z", "isInitialized", "x", "I", "moreIconSize", "y", "mSelectPosition", bt.aJ, "mParentWidth", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "F", "textSize", "B", "textColorType", "C", "textColor", "D", "allBackground", ExifInterface.LONGITUDE_EAST, "backgroundType", "selectableLayout", "textPaddingTop", "H", "textPaddingLeft", "textPaddingBottom", "textPaddingRight", "K", "textMarginTop", "L", "textMarginLeft", "textMarginBottom", "textMarginRight", "initLines", "flexShrink", "startIndex", "R", "selectable", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", ExifInterface.LATITUDE_SOUTH, "Ljava/util/ArrayList;", "datas", "Landroid/graphics/Typeface;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/graphics/Typeface;", "typeface", "U", "withTypeFace", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/martian/mibook/ui/FlexboxTagLayout$a;", "a", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class FlexboxTagLayout extends FlexboxLayout implements k9.a {

    /* renamed from: A */
    public final float textSize;

    /* renamed from: B, reason: from kotlin metadata */
    public final int textColorType;

    /* renamed from: C, reason: from kotlin metadata */
    public int textColor;

    /* renamed from: D, reason: from kotlin metadata */
    public final boolean allBackground;

    /* renamed from: E */
    public final int backgroundType;

    /* renamed from: F, reason: from kotlin metadata */
    public final boolean selectableLayout;

    /* renamed from: G, reason: from kotlin metadata */
    public final int textPaddingTop;

    /* renamed from: H, reason: from kotlin metadata */
    public final int textPaddingLeft;

    /* renamed from: I, reason: from kotlin metadata */
    public final int textPaddingBottom;

    /* renamed from: J, reason: from kotlin metadata */
    public final int textPaddingRight;

    /* renamed from: K, reason: from kotlin metadata */
    public final int textMarginTop;

    /* renamed from: L, reason: from kotlin metadata */
    public final int textMarginLeft;

    /* renamed from: M, reason: from kotlin metadata */
    public final int textMarginBottom;

    /* renamed from: N, reason: from kotlin metadata */
    public final int textMarginRight;

    /* renamed from: O, reason: from kotlin metadata */
    public int initLines;

    /* renamed from: P, reason: from kotlin metadata */
    public int flexShrink;

    /* renamed from: Q, reason: from kotlin metadata */
    public int startIndex;

    /* renamed from: R, reason: from kotlin metadata */
    public boolean selectable;

    /* renamed from: S */
    @k
    public final ArrayList<String> datas;

    /* renamed from: T */
    @k
    public Typeface typeface;

    /* renamed from: U, reason: from kotlin metadata */
    public boolean withTypeFace;

    /* renamed from: V */
    @l
    public a onItemTitleClickListener;

    /* renamed from: w */
    public boolean isInitialized;

    /* renamed from: x, reason: from kotlin metadata */
    public final int moreIconSize;

    /* renamed from: y, reason: from kotlin metadata */
    public int mSelectPosition;

    /* renamed from: z */
    public final int mParentWidth;

    public interface a {
        void a(@k String str, int i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlexboxTagLayout(@k Context context, @l AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.moreIconSize = ConfigSingleton.i(26.0f);
        this.textColor = ConfigSingleton.D().j0();
        this.flexShrink = 1;
        this.selectable = true;
        this.datas = new ArrayList<>();
        Typeface DEFAULT = Typeface.DEFAULT;
        Intrinsics.checkNotNullExpressionValue(DEFAULT, "DEFAULT");
        this.typeface = DEFAULT;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FlexboxTagLayout);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.textColorType = obtainStyledAttributes.getInteger(R.styleable.FlexboxTagLayout_Flexbox_textColorType, 0);
        this.textSize = obtainStyledAttributes.getDimension(R.styleable.FlexboxTagLayout_Flexbox_textSize, 0.0f);
        this.selectableLayout = obtainStyledAttributes.getBoolean(R.styleable.FlexboxTagLayout_Flexbox_selectableLayout, true);
        this.allBackground = obtainStyledAttributes.getBoolean(R.styleable.FlexboxTagLayout_Flexbox_allBackground, false);
        this.backgroundType = obtainStyledAttributes.getInteger(R.styleable.FlexboxTagLayout_Flexbox_backgroundType, 0);
        this.textPaddingTop = obtainStyledAttributes.getInteger(R.styleable.FlexboxTagLayout_Flexbox_textPaddingTop, 4);
        this.textPaddingLeft = obtainStyledAttributes.getInteger(R.styleable.FlexboxTagLayout_Flexbox_textPaddingLeft, 12);
        this.textPaddingBottom = obtainStyledAttributes.getInteger(R.styleable.FlexboxTagLayout_Flexbox_textPaddingBottom, 4);
        this.textPaddingRight = obtainStyledAttributes.getInteger(R.styleable.FlexboxTagLayout_Flexbox_textPaddingRight, 12);
        this.textMarginTop = obtainStyledAttributes.getInteger(R.styleable.FlexboxTagLayout_Flexbox_textMarginTop, 6);
        this.textMarginLeft = obtainStyledAttributes.getInteger(R.styleable.FlexboxTagLayout_Flexbox_textMarginLeft, 4);
        this.textMarginBottom = obtainStyledAttributes.getInteger(R.styleable.FlexboxTagLayout_Flexbox_textMarginBottom, 6);
        this.textMarginRight = obtainStyledAttributes.getInteger(R.styleable.FlexboxTagLayout_Flexbox_textMarginRight, 4);
        this.initLines = obtainStyledAttributes.getInteger(R.styleable.SearchLayout_Sear_initLines, 100);
        this.flexShrink = obtainStyledAttributes.getInteger(R.styleable.FlexboxTagLayout_Flexbox_flexShrink, 1);
        boolean z10 = obtainStyledAttributes.getBoolean(R.styleable.FlexboxTagLayout_Flexbox_selectable, true);
        this.selectable = z10;
        if (!z10) {
            this.mSelectPosition = -1;
        }
        this.mParentWidth = displayMetrics.widthPixels - ((int) obtainStyledAttributes.getDimension(R.styleable.FlexboxTagLayout_Flexbox_margin, 0.0f));
        P();
        obtainStyledAttributes.recycle();
    }

    public static final boolean H(ImageView moreIcon, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(moreIcon, "$moreIcon");
        int action = motionEvent.getAction();
        if (action == 0) {
            moreIcon.setAlpha(0.6f);
            return false;
        }
        if (action != 1 && action != 3) {
            return false;
        }
        moreIcon.setAlpha(1.0f);
        return false;
    }

    public static final void I(FlexboxTagLayout this$0, ImageView moreIcon, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(moreIcon, "$moreIcon");
        this$0.initLines = 100;
        moreIcon.setVisibility(8);
        this$0.N(this$0.datas, this$0.startIndex);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final TextView J(String name, int r72) {
        TextView textView = new TextView(getContext());
        textView.setIncludeFontPadding(Intrinsics.areEqual(this.typeface, Typeface.DEFAULT));
        textView.setTag(Integer.valueOf(r72));
        textView.setTextSize(0, this.textSize);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setPadding(ConfigSingleton.i(this.textPaddingLeft), ConfigSingleton.i(this.textPaddingTop), ConfigSingleton.i(this.textPaddingRight), ConfigSingleton.i(this.textPaddingBottom));
        Q(textView, r72);
        textView.setText(ExtKt.c(name));
        if (this.selectableLayout) {
            textView.setOnTouchListener(new View.OnTouchListener() { // from class: be.e

                /* renamed from: b */
                public final /* synthetic */ TextView f1575b;

                public /* synthetic */ e(TextView textView2) {
                    textView = textView2;
                }

                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean K;
                    K = FlexboxTagLayout.K(textView, view, motionEvent);
                    return K;
                }
            });
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: be.f

            /* renamed from: c */
            public final /* synthetic */ int f1577c;

            /* renamed from: d */
            public final /* synthetic */ String f1578d;

            public /* synthetic */ f(int r722, String name2) {
                position = r722;
                name = name2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FlexboxTagLayout.L(FlexboxTagLayout.this, position, name, view);
            }
        });
        FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(ConfigSingleton.i(this.textMarginLeft), ConfigSingleton.i(this.textMarginTop), ConfigSingleton.i(this.textMarginRight), ConfigSingleton.i(this.textMarginBottom));
        layoutParams.u(this.flexShrink);
        textView2.setLayoutParams(layoutParams);
        return textView2;
    }

    public static final boolean K(TextView textView, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(textView, "$textView");
        int action = motionEvent.getAction();
        if (action == 0) {
            textView.setAlpha(0.6f);
            return false;
        }
        if (action != 1 && action != 3) {
            return false;
        }
        textView.setAlpha(1.0f);
        return false;
    }

    public static final void L(FlexboxTagLayout this$0, int i10, String name, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(name, "$name");
        if (this$0.selectable) {
            this$0.setSelectPosition(i10);
        }
        a aVar = this$0.onItemTitleClickListener;
        if (aVar != null) {
            aVar.a(name, i10);
        }
    }

    private final void M() {
        if (this.datas.isEmpty()) {
            return;
        }
        int size = this.datas.size();
        for (int i10 = 0; i10 < size; i10++) {
            TextView textView = (TextView) findViewWithTag(Integer.valueOf(i10));
            if (textView != null) {
                Q(textView, i10);
            }
        }
    }

    private final int getIconWidth() {
        return this.moreIconSize + ConfigSingleton.i(this.textMarginLeft);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final ImageView getMoreIcon() {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(R.drawable.icon_more);
        if (this.allBackground) {
            imageView.setBackgroundResource(MiConfigSingleton.b2().A0() ? R.drawable.border_search_background_night : R.drawable.border_search_background_day);
        }
        imageView.setColorFilter(this.textColor);
        imageView.setOnTouchListener(new View.OnTouchListener() { // from class: be.c

            /* renamed from: b */
            public final /* synthetic */ ImageView f1572b;

            public /* synthetic */ c(ImageView imageView2) {
                imageView = imageView2;
            }

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean H;
                H = FlexboxTagLayout.H(imageView, view, motionEvent);
                return H;
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: be.d

            /* renamed from: c */
            public final /* synthetic */ ImageView f1574c;

            public /* synthetic */ d(ImageView imageView2) {
                imageView = imageView2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FlexboxTagLayout.I(FlexboxTagLayout.this, imageView, view);
            }
        });
        FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(-2, -2);
        int i10 = this.moreIconSize;
        ((ViewGroup.MarginLayoutParams) layoutParams).width = i10;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = i10;
        int i11 = ConfigSingleton.i(6.0f);
        imageView2.setPadding(i11, i11, i11, i11);
        layoutParams.setMargins(ConfigSingleton.i(this.textMarginLeft), (int) (((((((this.textSize + ConfigSingleton.i(4.0f)) + ConfigSingleton.i(this.textPaddingTop)) + ConfigSingleton.i(this.textPaddingBottom)) + ConfigSingleton.i(this.textMarginTop)) + ConfigSingleton.i(this.textMarginBottom)) - this.moreIconSize) / 2), 0, 0);
        layoutParams.u(this.flexShrink);
        imageView2.setLayoutParams(layoutParams);
        return imageView2;
    }

    public final HorizontalScrollView G() {
        ViewParent parent = getParent();
        if (parent instanceof HorizontalScrollView) {
            return (HorizontalScrollView) parent;
        }
        return null;
    }

    public final void N(List<String> r32, int index) {
        if (r32.isEmpty()) {
            return;
        }
        this.datas.clear();
        this.datas.addAll(r32);
        if (this.selectable) {
            this.mSelectPosition = 0;
        }
        int size = this.datas.size();
        while (index < size) {
            String str = this.datas.get(index);
            Intrinsics.checkNotNullExpressionValue(str, "get(...)");
            addView(J(str, index));
            index++;
        }
    }

    public final void O() {
        this.withTypeFace = true;
        this.typeface = MiConfigSingleton.b2().i2().g();
    }

    public final void P() {
        int i10;
        if (ConfigSingleton.D().A0()) {
            int i11 = this.textColorType;
            i10 = i11 != 1 ? i11 != 2 ? R.color.night_text_color_primary : R.color.night_text_color_thirdly : R.color.night_text_color_secondary;
        } else {
            int i12 = this.textColorType;
            i10 = i12 != 1 ? i12 != 2 ? R.color.day_text_color_primary : R.color.day_text_color_thirdly : R.color.day_text_color_secondary;
        }
        this.textColor = i10;
    }

    public final void Q(TextView textView, int r52) {
        int i10;
        setTypeface(textView);
        if (this.allBackground) {
            textView.setBackgroundResource(MiConfigSingleton.b2().A0() ? R.drawable.border_search_background_night : R.drawable.border_search_background_day);
            textView.setTextColor(ContextCompat.getColor(getContext(), this.textColor));
            return;
        }
        if (MiConfigSingleton.b2().A0()) {
            if (this.mSelectPosition == r52) {
                textView.setTextColor(ContextCompat.getColor(getContext(), R.color.theme_default));
                i10 = this.backgroundType == 1 ? R.drawable.border_search_background_night_card : R.drawable.border_search_light_theme_night;
            } else {
                if (this.backgroundType != 2) {
                    textView.setTextColor(ContextCompat.getColor(getContext(), this.textColor));
                }
                int i11 = this.backgroundType;
                if (i11 == 1) {
                    i10 = R.drawable.border_search_background_night_card;
                } else {
                    if (i11 == 2) {
                        MiReadingTheme k10 = MiConfigSingleton.b2().h2().k();
                        textView.setTextColor(k10.getTextColorThirdly());
                        textView.setBackground(k10.getBorderBackgroundLightButtonDrawable(getContext()));
                        return;
                    }
                    i10 = R.drawable.border_search_background_night;
                }
            }
        } else if (this.mSelectPosition == r52) {
            textView.setTextColor(ContextCompat.getColor(getContext(), R.color.theme_default));
            i10 = this.backgroundType == 1 ? R.drawable.border_search_light_theme_day : R.drawable.border_search_light_theme_day;
        } else {
            if (this.backgroundType != 2) {
                textView.setTextColor(ContextCompat.getColor(getContext(), this.textColor));
            }
            int i12 = this.backgroundType;
            if (i12 == 1) {
                i10 = R.drawable.border_search_background_day;
            } else {
                if (i12 == 2) {
                    MiReadingTheme k11 = MiConfigSingleton.b2().h2().k();
                    textView.setTextColor(k11.getTextColorThirdly());
                    textView.setBackground(k11.getBorderBackgroundLightButtonDrawable(getContext()));
                    return;
                }
                i10 = R.drawable.border_search_background_day;
            }
        }
        textView.setBackgroundResource(i10);
    }

    /* renamed from: getSelectPosition, reason: from getter */
    public final int getMSelectPosition() {
        return this.mSelectPosition;
    }

    @k
    public final String getSelectedItem() {
        if (this.mSelectPosition >= this.datas.size()) {
            return "";
        }
        String str = this.datas.get(this.mSelectPosition);
        Intrinsics.checkNotNull(str);
        return str;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.isInitialized) {
            return;
        }
        this.isInitialized = true;
        ConfigSingleton.D().h(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.isInitialized = false;
        ConfigSingleton.D().X0(this);
    }

    @Override // k9.a
    public void p() {
        P();
        M();
    }

    public final void setData(@k List<String> r22) {
        Intrinsics.checkNotNullParameter(r22, "info");
        N(r22, 0);
    }

    public final void setOnItemTitleClickListener(@k a onItemTitleClickListener) {
        Intrinsics.checkNotNullParameter(onItemTitleClickListener, "onItemTitleClickListener");
        this.onItemTitleClickListener = onItemTitleClickListener;
    }

    public final void setSelectPosition(int selectPosition) {
        this.mSelectPosition = selectPosition;
        M();
        TextView textView = (TextView) findViewWithTag(Integer.valueOf(selectPosition));
        HorizontalScrollView G = G();
        if (textView == null || G == null) {
            return;
        }
        G.smoothScrollTo(textView.getLeft() - (G.getWidth() / 2), 0);
    }

    public final void setTypeface(@k TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        if (this.withTypeFace) {
            textView.setTypeface(this.typeface);
            textView.setIncludeFontPadding(Intrinsics.areEqual(this.typeface, Typeface.DEFAULT));
        }
    }

    public /* synthetic */ FlexboxTagLayout(Context context, AttributeSet attributeSet, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }
}
