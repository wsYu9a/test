package com.martian.libmars.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p0.t;
import com.martian.libmars.R;
import com.umeng.analytics.pro.bt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 ;2\u00020\u0001:\u0005qCFILB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0015\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0017\u0010\u000eJ\u001f\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ#\u0010\u001d\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u001d\u0010\u0016J\u001f\u0010 \u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0014¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b#\u0010$J\u0015\u0010'\u001a\u00020\n2\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\u0015\u0010+\u001a\u00020\n2\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,J\r\u0010-\u001a\u00020\n¢\u0006\u0004\b-\u0010\u000eJ\u0015\u0010/\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\"¢\u0006\u0004\b/\u00100J\u0015\u00101\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\"¢\u0006\u0004\b1\u00100J\u0015\u00102\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\"¢\u0006\u0004\b2\u00100J\u0015\u00104\u001a\u00020\u00002\u0006\u00103\u001a\u00020\u0006¢\u0006\u0004\b4\u00105J\u0015\u00106\u001a\u00020\u00002\u0006\u00103\u001a\u00020\u0006¢\u0006\u0004\b6\u00105J\u0015\u00109\u001a\u00020\u00002\u0006\u00108\u001a\u000207¢\u0006\u0004\b9\u0010:J\u0015\u0010;\u001a\u00020\u00002\u0006\u00108\u001a\u000207¢\u0006\u0004\b;\u0010:J\u0015\u0010=\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\u0006¢\u0006\u0004\b=\u00105J\u0015\u0010>\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u001a¢\u0006\u0004\b>\u0010?J\u0015\u0010@\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u001a¢\u0006\u0004\b@\u0010?J\u0015\u0010B\u001a\u00020\u00002\u0006\u0010A\u001a\u00020\u0006¢\u0006\u0004\bB\u00105R\u0016\u0010E\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010H\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010K\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010M\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010GR\u0016\u0010O\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010DR\u0016\u0010R\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010T\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010JR\u0016\u0010V\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010GR\u0016\u0010X\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010DR\u0016\u0010Z\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010QR\u0016\u0010\\\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010JR\u0016\u0010^\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010DR\u0018\u0010a\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0018\u0010d\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010DR\u0018\u0010h\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010gR\u0018\u0010j\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010iR\u001a\u0010m\u001a\u00060kR\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010lR\u0016\u0010p\u001a\u00020n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010oR\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u0010J¨\u0006r"}, d2 = {"Lcom/martian/libmars/widget/FoldedTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", com.umeng.analytics.pro.f.X, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", bt.aO, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "s", "()V", "", "getTextByConfig", "()Ljava/lang/CharSequence;", "text", "Landroid/widget/TextView$BufferType;", "type", "F", "(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V", "G", "preText", "addedText", "", t.f11211k, "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "setText", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "", "performClick", "()Z", "Lcom/martian/libmars/widget/FoldedTextView$d;", "onExpandListener", "setOnExpandListener", "(Lcom/martian/libmars/widget/FoldedTextView$d;)V", "Lcom/martian/libmars/widget/FoldedTextView$c;", "onExpandBtnClickListener", "setOnExpandBtnClickListener", "(Lcom/martian/libmars/widget/FoldedTextView$c;)V", "q", "show", "C", "(Z)Lcom/martian/libmars/widget/FoldedTextView;", "D", "B", "color", "x", "(I)Lcom/martian/libmars/widget/FoldedTextView;", "u", "Landroid/graphics/Typeface;", "typeface", "y", "(Landroid/graphics/Typeface;)Lcom/martian/libmars/widget/FoldedTextView;", "v", "status", bt.aJ, IAdInterListener.AdReqParam.WIDTH, "(Ljava/lang/String;)Lcom/martian/libmars/widget/FoldedTextView;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "maxLinesOnCollapsed", ExifInterface.LONGITUDE_EAST, "b", "I", "mMaxLineOnCollapsed", "c", "Ljava/lang/String;", "mEllipsisHintText", "d", "Z", "isShowEllipsisHint", com.kwad.sdk.m.e.TAG, "mExpandHintText", "f", "mExpandHintTextColor", "g", "Landroid/graphics/Typeface;", "mExpandHintTextTypeface", "h", "isShowExpandHint", "i", "mCollapsedHintText", "j", "mCollapsedHintTextColor", "k", "mCollapsedHintTextTypeface", t.f11204d, "isShowCollapsedHint", "m", "mCurrentStatus", "n", "Ljava/lang/CharSequence;", "mOriginText", "o", "Landroid/widget/TextView$BufferType;", "mBufferType", "p", "mWidth", "Lcom/martian/libmars/widget/FoldedTextView$d;", "mOnExpandListener", "Lcom/martian/libmars/widget/FoldedTextView$c;", "mOnExpandBtnClickListener", "Lcom/martian/libmars/widget/FoldedTextView$e;", "Lcom/martian/libmars/widget/FoldedTextView$e;", "mTouchableSpan", "Landroid/text/TextPaint;", "Landroid/text/TextPaint;", "mPaint", "a", "libmars_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public class FoldedTextView extends AppCompatTextView {

    @k
    public static final String A = "展开";
    public static final int B = 4;
    public static final int C = -9599586;
    public static final int D = -9599586;
    public static final boolean E = true;
    public static final boolean F = true;
    public static final boolean G = true;

    /* renamed from: w */
    public static final int f12583w = 0;

    /* renamed from: x */
    public static final int f12584x = 1;

    /* renamed from: y */
    @k
    public static final String f12585y = "...";

    /* renamed from: z */
    @k
    public static final String f12586z = "收起";

    /* renamed from: b, reason: from kotlin metadata */
    public int mMaxLineOnCollapsed;

    /* renamed from: c, reason: from kotlin metadata */
    @k
    public String mEllipsisHintText;

    /* renamed from: d, reason: from kotlin metadata */
    public boolean isShowEllipsisHint;

    /* renamed from: e */
    @k
    public String mExpandHintText;

    /* renamed from: f, reason: from kotlin metadata */
    public int mExpandHintTextColor;

    /* renamed from: g, reason: from kotlin metadata */
    @k
    public Typeface mExpandHintTextTypeface;

    /* renamed from: h, reason: from kotlin metadata */
    public boolean isShowExpandHint;

    /* renamed from: i, reason: from kotlin metadata */
    @k
    public String mCollapsedHintText;

    /* renamed from: j, reason: from kotlin metadata */
    public int mCollapsedHintTextColor;

    /* renamed from: k, reason: from kotlin metadata */
    @k
    public Typeface mCollapsedHintTextTypeface;

    /* renamed from: l */
    public boolean isShowCollapsedHint;

    /* renamed from: m, reason: from kotlin metadata */
    public int mCurrentStatus;

    /* renamed from: n, reason: from kotlin metadata */
    @l
    public CharSequence mOriginText;

    /* renamed from: o, reason: from kotlin metadata */
    @l
    public TextView.BufferType mBufferType;

    /* renamed from: p, reason: from kotlin metadata */
    public int mWidth;

    /* renamed from: q, reason: from kotlin metadata */
    @l
    public d mOnExpandListener;

    /* renamed from: r */
    @l
    public c mOnExpandBtnClickListener;

    /* renamed from: s, reason: from kotlin metadata */
    @k
    public e mTouchableSpan;

    /* renamed from: t */
    @k
    public TextPaint mPaint;

    /* renamed from: u, reason: from kotlin metadata */
    public boolean performClick;

    public final class b extends LinkMovementMethod {
        public b() {
        }

        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(@k TextView widget, @k Spannable buffer, @k MotionEvent event) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.getAction() == 1) {
                int x10 = (((int) event.getX()) - widget.getTotalPaddingLeft()) + widget.getScrollX();
                int y10 = (((int) event.getY()) - widget.getTotalPaddingTop()) + widget.getScrollY();
                Layout layout = widget.getLayout();
                if (layout != null) {
                    int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(y10), x10);
                    e[] eVarArr = (e[]) buffer.getSpans(offsetForHorizontal, offsetForHorizontal, e.class);
                    Intrinsics.checkNotNull(eVarArr);
                    if (!(eVarArr.length == 0)) {
                        FoldedTextView.this.performClick = false;
                        eVarArr[0].onClick(widget);
                        return true;
                    }
                }
            }
            return super.onTouchEvent(widget, buffer, event);
        }
    }

    public interface c {
        void onClick();
    }

    public interface d {
        void a(@k FoldedTextView foldedTextView);

        void b(@k FoldedTextView foldedTextView);
    }

    public final class e extends ClickableSpan {
        public e() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@k View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            if (FoldedTextView.this.mOnExpandBtnClickListener == null) {
                FoldedTextView.this.G();
                return;
            }
            c cVar = FoldedTextView.this.mOnExpandBtnClickListener;
            if (cVar != null) {
                cVar.onClick();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@k TextPaint ds) {
            Intrinsics.checkNotNullParameter(ds, "ds");
            super.updateDrawState(ds);
            ds.setUnderlineText(false);
            int i10 = FoldedTextView.this.mCurrentStatus;
            if (i10 == 0) {
                ds.setColor(FoldedTextView.this.mExpandHintTextColor);
                ds.setTypeface(FoldedTextView.this.mExpandHintTextTypeface);
            } else {
                if (i10 != 1) {
                    return;
                }
                ds.setColor(FoldedTextView.this.mCollapsedHintTextColor);
                ds.setTypeface(FoldedTextView.this.mCollapsedHintTextTypeface);
            }
        }
    }

    public static final class f implements ViewTreeObserver.OnGlobalLayoutListener {
        public f() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            FoldedTextView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            FoldedTextView foldedTextView = FoldedTextView.this;
            foldedTextView.F(foldedTextView.getTextByConfig(), FoldedTextView.this.mBufferType);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FoldedTextView(@k Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void G() {
        int i10 = this.mCurrentStatus;
        if (i10 == 0) {
            this.mCurrentStatus = 1;
            d dVar = this.mOnExpandListener;
            if (dVar != null) {
                dVar.a(this);
            }
        } else if (i10 == 1) {
            this.mCurrentStatus = 0;
            d dVar2 = this.mOnExpandListener;
            if (dVar2 != null) {
                dVar2.b(this);
            }
        }
        F(getTextByConfig(), this.mBufferType);
    }

    public final CharSequence getTextByConfig() {
        if (TextUtils.isEmpty(this.mOriginText)) {
            return this.mOriginText;
        }
        if (this.mWidth == 0) {
            return this.mOriginText;
        }
        TextPaint paint = getPaint();
        Intrinsics.checkNotNullExpressionValue(paint, "getPaint(...)");
        this.mPaint = paint;
        CharSequence charSequence = this.mOriginText;
        Intrinsics.checkNotNull(charSequence);
        DynamicLayout dynamicLayout = new DynamicLayout(charSequence, this.mPaint, this.mWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        int lineCount = dynamicLayout.getLineCount();
        int i10 = this.mMaxLineOnCollapsed;
        if (lineCount <= i10) {
            return this.mOriginText;
        }
        int i11 = this.mCurrentStatus;
        if (i11 != 0) {
            if (i11 != 1) {
                return this.mOriginText;
            }
            if (!this.isShowCollapsedHint) {
                return this.mOriginText;
            }
            SpannableStringBuilder append = new SpannableStringBuilder(this.mOriginText).append((CharSequence) this.mCollapsedHintText);
            append.setSpan(this.mTouchableSpan, append.length() - this.mCollapsedHintText.length(), append.length(), 33);
            return append;
        }
        String str = this.isShowEllipsisHint ? this.mEllipsisHintText : "";
        String str2 = this.isShowExpandHint ? this.mExpandHintText : "";
        int lineStart = dynamicLayout.getLineStart(i10 - 1);
        int lineEnd = dynamicLayout.getLineEnd(this.mMaxLineOnCollapsed - 1);
        CharSequence charSequence2 = this.mOriginText;
        Intrinsics.checkNotNull(charSequence2);
        if (charSequence2.charAt(lineEnd - 1) == '\n' && lineEnd > lineStart) {
            lineEnd--;
        }
        TextPaint textPaint = this.mPaint;
        CharSequence charSequence3 = this.mOriginText;
        Intrinsics.checkNotNull(charSequence3);
        float measureText = textPaint.measureText(((Object) charSequence3.subSequence(lineStart, lineEnd)) + str + str2);
        while (measureText > this.mWidth) {
            lineEnd--;
            TextPaint textPaint2 = this.mPaint;
            CharSequence charSequence4 = this.mOriginText;
            Intrinsics.checkNotNull(charSequence4);
            measureText = textPaint2.measureText(((Object) charSequence4.subSequence(lineStart, lineEnd)) + str + str2);
        }
        CharSequence charSequence5 = this.mOriginText;
        Intrinsics.checkNotNull(charSequence5);
        CharSequence subSequence = charSequence5.subSequence(0, lineEnd);
        CharSequence charSequence6 = this.mOriginText;
        Intrinsics.checkNotNull(charSequence6);
        SpannableStringBuilder append2 = new SpannableStringBuilder(subSequence).append((CharSequence) str).append((CharSequence) r(charSequence6.subSequence(lineStart, lineEnd).toString(), str + str2));
        if (!this.isShowExpandHint) {
            return append2;
        }
        append2.append((CharSequence) this.mExpandHintText);
        append2.setSpan(this.mTouchableSpan, append2.length() - str2.length(), append2.length(), 33);
        return append2;
    }

    private final void s() {
        setMovementMethod(new b());
        getViewTreeObserver().addOnGlobalLayoutListener(new f());
    }

    @k
    public final FoldedTextView A(@k String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.mExpandHintText = text;
        return this;
    }

    @k
    public final FoldedTextView B(boolean show) {
        this.isShowCollapsedHint = show;
        return this;
    }

    @k
    public final FoldedTextView C(boolean show) {
        this.isShowEllipsisHint = show;
        return this;
    }

    @k
    public final FoldedTextView D(boolean show) {
        this.isShowExpandHint = show;
        return this;
    }

    @k
    public final FoldedTextView E(int i10) {
        this.mMaxLineOnCollapsed = i10;
        return this;
    }

    public final void F(CharSequence text, TextView.BufferType type) {
        super.setText(text, type);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.mWidth = (View.MeasureSpec.getSize(widthMeasureSpec) - getPaddingLeft()) - getPaddingRight();
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.performClick) {
            return super.performClick();
        }
        this.performClick = true;
        return false;
    }

    public final void q() {
        F(getTextByConfig(), this.mBufferType);
    }

    public final String r(CharSequence charSequence, CharSequence charSequence2) {
        StringBuilder sb2 = new StringBuilder("");
        TextPaint textPaint = this.mPaint;
        StringBuilder sb3 = new StringBuilder();
        sb3.append((Object) charSequence);
        sb3.append((Object) sb2);
        sb3.append((Object) charSequence2);
        float measureText = textPaint.measureText(sb3.toString());
        while (measureText + 0.5f <= this.mWidth - this.mPaint.measureText(" ")) {
            sb2.append(" ");
            TextPaint textPaint2 = this.mPaint;
            StringBuilder sb4 = new StringBuilder();
            sb4.append((Object) charSequence);
            sb4.append((Object) sb2);
            sb4.append((Object) charSequence2);
            measureText = textPaint2.measureText(sb4.toString());
        }
        String sb5 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb5, "toString(...)");
        return sb5;
    }

    public final void setOnExpandBtnClickListener(@k c onExpandBtnClickListener) {
        Intrinsics.checkNotNullParameter(onExpandBtnClickListener, "onExpandBtnClickListener");
        this.mOnExpandBtnClickListener = onExpandBtnClickListener;
    }

    public final void setOnExpandListener(@k d onExpandListener) {
        Intrinsics.checkNotNullParameter(onExpandListener, "onExpandListener");
        this.mOnExpandListener = onExpandListener;
    }

    @Override // android.widget.TextView
    public void setText(@l CharSequence text, @l TextView.BufferType type) {
        this.mOriginText = text;
        this.mBufferType = type;
        F(getTextByConfig(), type);
    }

    public final void t(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FoldedTextView);
        try {
            this.mMaxLineOnCollapsed = obtainStyledAttributes.getInt(R.styleable.FoldedTextView_ftv_MaxLinesOnCollapsed, 4);
            String string = obtainStyledAttributes.getString(R.styleable.FoldedTextView_ftv_EllipsisHintText);
            if (string == null) {
                string = f12585y;
            } else {
                Intrinsics.checkNotNull(string);
            }
            this.mEllipsisHintText = string;
            this.isShowEllipsisHint = obtainStyledAttributes.getBoolean(R.styleable.FoldedTextView_ftv_IsShowEllipsisHint, true);
            String string2 = obtainStyledAttributes.getString(R.styleable.FoldedTextView_ftv_ExpandHintText);
            if (string2 == null) {
                string2 = A;
            } else {
                Intrinsics.checkNotNull(string2);
            }
            this.mExpandHintText = string2;
            this.mExpandHintTextColor = obtainStyledAttributes.getInt(R.styleable.FoldedTextView_ftv_ExpandHintTextColor, -9599586);
            this.isShowExpandHint = obtainStyledAttributes.getBoolean(R.styleable.FoldedTextView_ftv_IsShowExpandHint, true);
            String string3 = obtainStyledAttributes.getString(R.styleable.FoldedTextView_ftv_CollapsedHintText);
            if (string3 == null) {
                string3 = f12586z;
            } else {
                Intrinsics.checkNotNull(string3);
            }
            this.mCollapsedHintText = string3;
            this.mCollapsedHintTextColor = obtainStyledAttributes.getInt(R.styleable.FoldedTextView_ftv_CollapsedHintTextColor, -9599586);
            this.isShowCollapsedHint = obtainStyledAttributes.getBoolean(R.styleable.FoldedTextView_ftv_IsShowCollapsedHint, true);
            this.mCurrentStatus = obtainStyledAttributes.getInt(R.styleable.FoldedTextView_ftv_InitState, 0);
            obtainStyledAttributes.recycle();
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }

    @k
    public final FoldedTextView u(int color) {
        this.mCollapsedHintTextColor = color;
        return this;
    }

    @k
    public final FoldedTextView v(@k Typeface typeface) {
        Intrinsics.checkNotNullParameter(typeface, "typeface");
        this.mCollapsedHintTextTypeface = typeface;
        return this;
    }

    @k
    public final FoldedTextView w(@k String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.mCollapsedHintText = text;
        return this;
    }

    @k
    public final FoldedTextView x(int color) {
        this.mExpandHintTextColor = color;
        return this;
    }

    @k
    public final FoldedTextView y(@k Typeface typeface) {
        Intrinsics.checkNotNullParameter(typeface, "typeface");
        this.mExpandHintTextTypeface = typeface;
        return this;
    }

    @k
    public final FoldedTextView z(int i10) {
        this.mCurrentStatus = i10 != 1 ? 0 : 1;
        return this;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FoldedTextView(@k Context context, @l AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ FoldedTextView(Context context, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FoldedTextView(@k Context context, @l AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mMaxLineOnCollapsed = 4;
        this.mEllipsisHintText = f12585y;
        this.isShowEllipsisHint = true;
        this.mExpandHintText = A;
        this.mExpandHintTextColor = -9599586;
        Typeface DEFAULT = Typeface.DEFAULT;
        Intrinsics.checkNotNullExpressionValue(DEFAULT, "DEFAULT");
        this.mExpandHintTextTypeface = DEFAULT;
        this.isShowExpandHint = true;
        this.mCollapsedHintText = f12586z;
        this.mCollapsedHintTextColor = -9599586;
        Intrinsics.checkNotNullExpressionValue(DEFAULT, "DEFAULT");
        this.mCollapsedHintTextTypeface = DEFAULT;
        this.isShowCollapsedHint = true;
        this.mBufferType = TextView.BufferType.NORMAL;
        this.mTouchableSpan = new e();
        this.mPaint = new TextPaint();
        this.performClick = true;
        t(context, attributeSet);
        s();
    }
}
