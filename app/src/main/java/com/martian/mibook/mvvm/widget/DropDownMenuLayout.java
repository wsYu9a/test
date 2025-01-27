package com.martian.mibook.mvvm.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import androidx.core.view.ViewGroupKt;
import com.martian.mibook.R;
import com.martian.mibook.mvvm.widget.DropDownMenuLayout;
import com.umeng.analytics.pro.f;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequencesKt;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0010\u001a\u00020\n2\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n\u0018\u00010\r¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\fJ\r\u0010\u0013\u001a\u00020\n¢\u0006\u0004\b\u0013\u0010\fJ\u000f\u0010\u0014\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\fR$\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/martian/mibook/mvvm/widget/DropDownMenuLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", f.X, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "onFinishInflate", "()V", "Lkotlin/Function1;", "", "onMenuOutEnd", "j", "(Lkotlin/jvm/functions/Function1;)V", "g", "f", "i", "b", "Lkotlin/jvm/functions/Function1;", "Landroid/view/ViewGroup;", "c", "Landroid/view/ViewGroup;", "contentLayout", "Landroid/view/View;", "d", "Landroid/view/View;", "transparentBackground", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nDropDownMenuLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DropDownMenuLayout.kt\ncom/martian/mibook/mvvm/widget/DropDownMenuLayout\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,124:1\n1313#2,2:125\n1855#3,2:127\n*S KotlinDebug\n*F\n+ 1 DropDownMenuLayout.kt\ncom/martian/mibook/mvvm/widget/DropDownMenuLayout\n*L\n38#1:125,2\n41#1:127,2\n*E\n"})
/* loaded from: classes3.dex */
public final class DropDownMenuLayout extends FrameLayout {

    /* renamed from: b, reason: from kotlin metadata */
    @l
    public Function1<? super Boolean, Unit> onMenuOutEnd;

    /* renamed from: c, reason: from kotlin metadata */
    @k
    public ViewGroup contentLayout;

    /* renamed from: d, reason: from kotlin metadata */
    @k
    public View transparentBackground;

    public static final class a extends Animation {

        /* renamed from: c */
        public final /* synthetic */ int f15313c;

        public a(int i10) {
            this.f15313c = i10;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f10, @l Transformation transformation) {
            if (f10 == 1.0f) {
                DropDownMenuLayout.this.contentLayout.setVisibility(8);
                return;
            }
            ViewGroup.LayoutParams layoutParams = DropDownMenuLayout.this.contentLayout.getLayoutParams();
            int i10 = this.f15313c;
            layoutParams.height = i10 - ((int) (i10 * f10));
            DropDownMenuLayout.this.contentLayout.requestLayout();
        }

        @Override // android.view.animation.Animation
        public boolean willChangeBounds() {
            return true;
        }
    }

    public static final class b extends Animation {

        /* renamed from: c */
        public final /* synthetic */ int f15315c;

        public b(int i10) {
            this.f15315c = i10;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f10, @l Transformation transformation) {
            DropDownMenuLayout.this.contentLayout.getLayoutParams().height = f10 == 1.0f ? -2 : (int) (this.f15315c * f10);
            DropDownMenuLayout.this.contentLayout.requestLayout();
        }

        @Override // android.view.animation.Animation
        public boolean willChangeBounds() {
            return true;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DropDownMenuLayout(@k Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static final void c(DropDownMenuLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.g();
    }

    public static final void h(DropDownMenuLayout this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.transparentBackground.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void k(DropDownMenuLayout dropDownMenuLayout, Function1 function1, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            function1 = null;
        }
        dropDownMenuLayout.j(function1);
    }

    public final void f() {
        this.transparentBackground.setVisibility(8);
        this.contentLayout.setVisibility(8);
        Function1<? super Boolean, Unit> function1 = this.onMenuOutEnd;
        if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
    }

    public final void g() {
        this.transparentBackground.animate().alpha(0.0f).setDuration(300L).withEndAction(new Runnable() { // from class: rd.b
            public /* synthetic */ b() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                DropDownMenuLayout.h(DropDownMenuLayout.this);
            }
        }).start();
        a aVar = new a(this.contentLayout.getMeasuredHeight());
        aVar.setDuration((long) ((r0 / 2) / getContext().getResources().getDisplayMetrics().density));
        this.contentLayout.startAnimation(aVar);
        Function1<? super Boolean, Unit> function1 = this.onMenuOutEnd;
        if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
    }

    public final void i() {
        this.transparentBackground.setVisibility(0);
        this.contentLayout.setVisibility(0);
        this.transparentBackground.animate().alpha(0.5f).setDuration(150L).start();
        this.contentLayout.measure(0, 0);
        int measuredHeight = this.contentLayout.getMeasuredHeight();
        this.contentLayout.getLayoutParams().height = 0;
        this.contentLayout.setVisibility(0);
        b bVar = new b(measuredHeight);
        bVar.setDuration((long) ((measuredHeight / 2) / getContext().getResources().getDisplayMetrics().density));
        this.contentLayout.startAnimation(bVar);
        Function1<? super Boolean, Unit> function1 = this.onMenuOutEnd;
        if (function1 != null) {
            function1.invoke(Boolean.TRUE);
        }
    }

    public final void j(@l Function1<? super Boolean, Unit> onMenuOutEnd) {
        this.onMenuOutEnd = onMenuOutEnd;
        if (this.contentLayout.getVisibility() == 0) {
            g();
        } else {
            i();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        ArrayList<View> arrayList = new ArrayList();
        Iterator it = SequencesKt.filter(ViewGroupKt.getChildren(this), new Function1<View, Boolean>() { // from class: com.martian.mibook.mvvm.widget.DropDownMenuLayout$onFinishInflate$1
            public DropDownMenuLayout$onFinishInflate$1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @k
            public final Boolean invoke(@k View it2) {
                boolean z10;
                View view;
                Intrinsics.checkNotNullParameter(it2, "it");
                if (!Intrinsics.areEqual(it2, DropDownMenuLayout.this.contentLayout)) {
                    view = DropDownMenuLayout.this.transparentBackground;
                    if (!Intrinsics.areEqual(it2, view)) {
                        z10 = true;
                        return Boolean.valueOf(z10);
                    }
                }
                z10 = false;
                return Boolean.valueOf(z10);
            }
        }).iterator();
        while (it.hasNext()) {
            arrayList.add((View) it.next());
        }
        for (View view : arrayList) {
            removeView(view);
            this.contentLayout.addView(view);
            view.setOnClickListener(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DropDownMenuLayout(@k Context context, @l AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ DropDownMenuLayout(Context context, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DropDownMenuLayout(@k Context context, @l AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.dropdown_menu_layout, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.contentLayout);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.contentLayout = (ViewGroup) findViewById;
        View findViewById2 = findViewById(R.id.transparentBackground);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.transparentBackground = findViewById2;
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: rd.a
            public /* synthetic */ a() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DropDownMenuLayout.c(DropDownMenuLayout.this, view);
            }
        });
    }
}
