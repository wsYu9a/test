package com.martian.mibook.mvvm.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.martian.mibook.R;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.f;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010!\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0015H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001c\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u000eH\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\"\u0010!J\u0017\u0010$\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\fH\u0002¢\u0006\u0004\b$\u0010\u0010J\u0017\u0010%\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\fH\u0002¢\u0006\u0004\b%\u0010&J\u001f\u0010)\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010(\u001a\u00020'H\u0002¢\u0006\u0004\b)\u0010*J\u001f\u0010,\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010+\u001a\u00020'H\u0002¢\u0006\u0004\b,\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010.R\u0018\u00102\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u00101R\u0016\u00104\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u00103R\u0016\u00105\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u00103R\u0014\u00106\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u00103R\u0016\u00107\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u00103R\u0018\u0010\r\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010<\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u00103R\u0016\u0010>\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u00103R\u0016\u0010@\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u00103R\u0016\u0010B\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u00103R\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010H\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u00103R\u0016\u0010J\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u00103R\u0018\u0010M\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010O\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u00103R\u0016\u0010Q\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u00103R\u0016\u0010R\u001a\u00020C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010ER\u001a\u0010V\u001a\b\u0012\u0004\u0012\u00020\f0S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0011\u0010\u001a\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\bW\u0010\u000b¨\u0006X"}, d2 = {"Lcom/martian/mibook/mvvm/widget/VerticalTextView;", "Landroid/view/View;", "Landroid/content/Context;", f.X, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getCharHeight", "()I", "", "text", "", "setText", "(Ljava/lang/String;)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "Landroid/graphics/Typeface;", "typeface", "style", "f", "(Landroid/graphics/Typeface;I)V", "setTypeface", "(Landroid/graphics/Typeface;)V", "d", "()V", e.TAG, "s", "c", "b", "(Ljava/lang/String;)I", "", "spVal", "g", "(Landroid/content/Context;F)I", "dpVal", "a", "Landroid/text/TextPaint;", "Landroid/text/TextPaint;", "textPaint", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "leftLinePaint", "I", "width", "height", "columnWidth", "charHeight", "", "h", "Ljava/lang/CharSequence;", "i", "textColor", "j", "textSize", "k", "letterSpacing", t.f11204d, "columnSpacing", "", "m", "Z", "leftLine", "n", "leftLinePadding", "o", "leftLineColor", "p", "Ljava/lang/String;", "regex", "q", "textStyle", t.f11211k, "arrangeDirection", "isLeftToRight", "", bt.aO, "Ljava/util/List;", "formatTexts", "getTypeface", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nVerticalTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VerticalTextView.kt\ncom/martian/mibook/mvvm/widget/VerticalTextView\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,282:1\n731#2,9:283\n731#2,9:294\n37#3,2:292\n37#3,2:303\n1#4:305\n*S KotlinDebug\n*F\n+ 1 VerticalTextView.kt\ncom/martian/mibook/mvvm/widget/VerticalTextView\n*L\n129#1:283,9\n146#1:294,9\n130#1:292,2\n147#1:303,2\n*E\n"})
/* loaded from: classes3.dex */
public final class VerticalTextView extends View {

    /* renamed from: b, reason: from kotlin metadata */
    @l
    public TextPaint textPaint;

    /* renamed from: c, reason: from kotlin metadata */
    @l
    public Paint leftLinePaint;

    /* renamed from: d, reason: from kotlin metadata */
    public int width;

    /* renamed from: e */
    public int height;

    /* renamed from: f, reason: from kotlin metadata */
    public final int columnWidth;

    /* renamed from: g, reason: from kotlin metadata */
    public int charHeight;

    /* renamed from: h, reason: from kotlin metadata */
    @l
    public CharSequence text;

    /* renamed from: i, reason: from kotlin metadata */
    public int textColor;

    /* renamed from: j, reason: from kotlin metadata */
    public int textSize;

    /* renamed from: k, reason: from kotlin metadata */
    public int letterSpacing;

    /* renamed from: l */
    public int columnSpacing;

    /* renamed from: m, reason: from kotlin metadata */
    public boolean leftLine;

    /* renamed from: n, reason: from kotlin metadata */
    public int leftLinePadding;

    /* renamed from: o, reason: from kotlin metadata */
    public int leftLineColor;

    /* renamed from: p, reason: from kotlin metadata */
    @l
    public String regex;

    /* renamed from: q, reason: from kotlin metadata */
    public int textStyle;

    /* renamed from: r */
    public int arrangeDirection;

    /* renamed from: s, reason: from kotlin metadata */
    public boolean isLeftToRight;

    /* renamed from: t */
    @k
    public final List<String> formatTexts;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VerticalTextView(@k Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final int getCharHeight() {
        TextPaint textPaint = this.textPaint;
        Intrinsics.checkNotNull(textPaint);
        int abs = (int) (Math.abs(textPaint.ascent()) + this.letterSpacing);
        this.charHeight = abs;
        return abs;
    }

    public final int a(Context r22, float dpVal) {
        return (int) TypedValue.applyDimension(1, dpVal, r22.getResources().getDisplayMetrics());
    }

    public final int b(String s10) {
        return getCharHeight() * s10.length();
    }

    public final void c(String s10) {
        int paddingTop = (this.height - getPaddingTop()) - getPaddingBottom();
        if (b(s10) <= paddingTop) {
            this.formatTexts.add(s10);
            return;
        }
        int i10 = paddingTop / this.charHeight;
        int i11 = 0;
        while (i11 < b(s10) / paddingTop) {
            List<String> list = this.formatTexts;
            int i12 = i11 * i10;
            i11++;
            String substring = s10.substring(i12, i11 * i10);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            list.add(substring);
        }
        if (b(s10) % paddingTop != 0) {
            List<String> list2 = this.formatTexts;
            String substring2 = s10.substring(i11 * i10, s10.length());
            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
            list2.add(substring2);
        }
    }

    public final void d() {
        this.text = "";
        this.textColor = -14211289;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        this.textSize = g(context, 14.0f);
        this.columnSpacing = 0;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        this.letterSpacing = a(context2, 4.0f);
        this.leftLinePadding = 0;
        this.leftLineColor = -14211289;
        this.regex = "";
        this.textStyle = 0;
    }

    public final void e() {
        TextPaint textPaint = new TextPaint(1);
        this.textPaint = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        textPaint.setTextSize(this.textSize);
        textPaint.setColor(this.textColor);
        textPaint.setFakeBoldText((this.textStyle & 1) != 0);
        textPaint.setTextSkewX((this.textStyle & 2) != 0 ? -0.25f : 0.0f);
        Paint paint = new Paint(1);
        this.leftLinePaint = paint;
        paint.setColor(this.leftLineColor);
    }

    public final void f(@l Typeface typeface, int style) {
        if (style <= 0) {
            TextPaint textPaint = this.textPaint;
            if (textPaint != null) {
                textPaint.setFakeBoldText(false);
            }
            TextPaint textPaint2 = this.textPaint;
            if (textPaint2 != null) {
                textPaint2.setTextSkewX(0.0f);
            }
            setTypeface(typeface);
            return;
        }
        Typeface defaultFromStyle = typeface == null ? Typeface.defaultFromStyle(style) : Typeface.create(typeface, style);
        setTypeface(defaultFromStyle);
        int i10 = (~(defaultFromStyle != null ? defaultFromStyle.getStyle() : 0)) & style;
        TextPaint textPaint3 = this.textPaint;
        if (textPaint3 != null) {
            textPaint3.setFakeBoldText((i10 & 1) != 0);
        }
        TextPaint textPaint4 = this.textPaint;
        if (textPaint4 == null) {
            return;
        }
        textPaint4.setTextSkewX((i10 & 2) != 0 ? -0.25f : 0.0f);
    }

    public final int g(Context r22, float spVal) {
        return (int) TypedValue.applyDimension(2, spVal, r22.getResources().getDisplayMetrics());
    }

    public final int getTypeface() {
        TextPaint textPaint = this.textPaint;
        Intrinsics.checkNotNull(textPaint);
        Typeface typeface = textPaint.getTypeface();
        if (typeface != null) {
            return typeface.getStyle();
        }
        return 0;
    }

    @Override // android.view.View
    public void onDraw(@k Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        float paddingLeft = (this.width - getPaddingLeft()) - getPaddingRight();
        float paddingTop = getPaddingTop();
        if (this.isLeftToRight) {
            int size = this.formatTexts.size();
            int i10 = 0;
            while (i10 < size) {
                paddingLeft = i10 == 0 ? this.columnSpacing : paddingLeft + this.columnWidth;
                int length = this.formatTexts.get(i10).length();
                int i11 = 0;
                while (i11 < length) {
                    paddingTop = i11 == 0 ? (this.charHeight - this.letterSpacing) + getPaddingTop() : paddingTop + this.charHeight;
                    String str = this.formatTexts.get(i10);
                    int i12 = i11 + 1;
                    TextPaint textPaint = this.textPaint;
                    Intrinsics.checkNotNull(textPaint);
                    canvas.drawText(str, i11, i12, paddingLeft, paddingTop, (Paint) textPaint);
                    i11 = i12;
                }
                if (this.leftLine) {
                    Paint paint = this.leftLinePaint;
                    Intrinsics.checkNotNull(paint);
                    canvas.drawLine(paddingLeft - this.leftLinePadding, getPaddingTop(), paddingLeft - this.leftLinePadding, paddingTop + this.letterSpacing, paint);
                }
                i10++;
            }
            return;
        }
        int size2 = this.formatTexts.size();
        int i13 = 0;
        while (i13 < size2) {
            paddingLeft = i13 == 0 ? (this.width - this.columnWidth) + this.columnSpacing : paddingLeft - this.columnWidth;
            int length2 = this.formatTexts.get(i13).length();
            int i14 = 0;
            while (i14 < length2) {
                paddingTop = i14 == 0 ? (this.charHeight - this.letterSpacing) + getPaddingTop() : paddingTop + this.charHeight;
                String str2 = this.formatTexts.get(i13);
                int i15 = i14 + 1;
                TextPaint textPaint2 = this.textPaint;
                Intrinsics.checkNotNull(textPaint2);
                canvas.drawText(str2, i14, i15, paddingLeft, paddingTop, (Paint) textPaint2);
                i14 = i15;
            }
            if (this.leftLine) {
                Paint paint2 = this.leftLinePaint;
                Intrinsics.checkNotNull(paint2);
                canvas.drawLine(paddingLeft - this.leftLinePadding, getPaddingTop(), paddingLeft - this.leftLinePadding, paddingTop + this.letterSpacing, paint2);
            }
            i13++;
        }
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        List emptyList;
        int i10;
        List emptyList2;
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        if (mode2 == 1073741824) {
            this.height = size2;
        } else {
            if (TextUtils.isEmpty(this.regex)) {
                this.height = b(String.valueOf(this.text));
            } else {
                this.height = 0;
                String valueOf = String.valueOf(this.text);
                String str = this.regex;
                Intrinsics.checkNotNull(str);
                List<String> split = new Regex(str).split(valueOf, 0);
                if (!split.isEmpty()) {
                    ListIterator<String> listIterator = split.listIterator(split.size());
                    while (listIterator.hasPrevious()) {
                        if (listIterator.previous().length() != 0) {
                            emptyList = CollectionsKt.take(split, listIterator.nextIndex() + 1);
                            break;
                        }
                    }
                }
                emptyList = CollectionsKt.emptyList();
                for (String str2 : (String[]) emptyList.toArray(new String[0])) {
                    this.height = RangesKt.coerceAtLeast(this.height, b(str2));
                }
                this.height += this.letterSpacing;
            }
            if (this.height > size2) {
                this.height = size2;
            }
        }
        this.formatTexts.clear();
        if (TextUtils.isEmpty(this.regex)) {
            c(String.valueOf(this.text));
        } else {
            String valueOf2 = String.valueOf(this.text);
            String str3 = this.regex;
            Intrinsics.checkNotNull(str3);
            List<String> split2 = new Regex(str3).split(valueOf2, 0);
            if (!split2.isEmpty()) {
                ListIterator<String> listIterator2 = split2.listIterator(split2.size());
                while (listIterator2.hasPrevious()) {
                    if (listIterator2.previous().length() != 0) {
                        emptyList2 = CollectionsKt.take(split2, listIterator2.nextIndex() + 1);
                        break;
                    }
                }
            }
            emptyList2 = CollectionsKt.emptyList();
            for (String str4 : (String[]) emptyList2.toArray(new String[0])) {
                c(str4);
            }
        }
        if (mode == 1073741824) {
            this.width = size;
        } else {
            if (TextUtils.isEmpty(this.regex)) {
                int b10 = b(String.valueOf(this.text));
                int paddingTop = (this.height - getPaddingTop()) - getPaddingBottom();
                i10 = this.columnWidth * ((b10 / paddingTop) + (b10 % paddingTop > 0 ? 1 : 0));
            } else {
                i10 = this.columnWidth * this.formatTexts.size();
            }
            this.width = i10;
            if (1 <= size && size < i10) {
                this.width = size;
            }
        }
        setMeasuredDimension(this.width, this.height);
    }

    public final void setText(@k String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        requestLayout();
    }

    public final void setTypeface(@l Typeface typeface) {
        if (typeface == null) {
            typeface = Typeface.DEFAULT;
        }
        TextPaint textPaint = this.textPaint;
        if ((textPaint != null ? textPaint.getTypeface() : null) != typeface) {
            TextPaint textPaint2 = this.textPaint;
            if (textPaint2 != null) {
                textPaint2.setTypeface(typeface);
            }
            requestLayout();
            invalidate();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VerticalTextView(@k Context context, @l AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ VerticalTextView(Context context, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VerticalTextView(@k Context context, @l AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        this.isLeftToRight = true;
        this.formatTexts = new ArrayList();
        d();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.VerticalTextView, i10, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i11 = 0; i11 < indexCount; i11++) {
            int index = obtainStyledAttributes.getIndex(i11);
            if (index == R.styleable.VerticalTextView_text) {
                this.text = obtainStyledAttributes.getString(index);
            } else if (index == R.styleable.VerticalTextView_textColor) {
                this.textColor = obtainStyledAttributes.getColor(index, this.textColor);
            } else if (index == R.styleable.VerticalTextView_textSize) {
                this.textSize = obtainStyledAttributes.getDimensionPixelSize(index, this.textSize);
            } else if (index == R.styleable.VerticalTextView_columnSpacing) {
                this.columnSpacing = obtainStyledAttributes.getDimensionPixelSize(index, this.columnSpacing);
            } else if (index == R.styleable.VerticalTextView_letterSpacing) {
                this.letterSpacing = obtainStyledAttributes.getDimensionPixelSize(index, this.letterSpacing);
            } else if (index == R.styleable.VerticalTextView_regex) {
                this.regex = obtainStyledAttributes.getString(index);
            } else if (index == R.styleable.VerticalTextView_textStyle) {
                this.textStyle = obtainStyledAttributes.getInt(index, this.textStyle);
            } else if (index == R.styleable.VerticalTextView_arrangeDirection) {
                int i12 = obtainStyledAttributes.getInt(index, this.textStyle);
                this.arrangeDirection = i12;
                this.isLeftToRight = i12 == 0;
            } else if (index == R.styleable.VerticalTextView_leftLine) {
                this.leftLine = obtainStyledAttributes.getBoolean(index, false);
            } else if (index == R.styleable.VerticalTextView_leftLinePadding) {
                this.leftLinePadding = obtainStyledAttributes.getDimensionPixelSize(index, this.leftLinePadding);
            } else if (index == R.styleable.VerticalTextView_leftLineColor) {
                this.leftLineColor = obtainStyledAttributes.getColor(index, this.leftLineColor);
            }
        }
        obtainStyledAttributes.recycle();
        e();
        TextPaint textPaint = this.textPaint;
        Intrinsics.checkNotNull(textPaint);
        float abs = Math.abs(textPaint.ascent());
        TextPaint textPaint2 = this.textPaint;
        Intrinsics.checkNotNull(textPaint2);
        this.columnWidth = (int) (abs + Math.abs(textPaint2.descent()) + this.columnSpacing);
    }
}
