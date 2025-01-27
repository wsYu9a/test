package com.martian.mibook.mvvm.read.widget;

import android.content.Context;
import android.view.View;
import com.martian.libmars.R;
import com.martian.mibook.data.TypefaceItem;
import com.martian.mibook.databinding.ItemReadingTypeFaceBinding;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.read.adapter.TypeFaceGridAdapter;
import com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel;
import com.martian.mibook.mvvm.read.widget.ReadingTypeFaceSettingLayout;
import com.martian.mibook.mvvm.read.widget.ReadingTypeFaceSettingLayout$initData$4;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import l9.i0;
import l9.t0;
import xi.l;

/* loaded from: classes3.dex */
public final class ReadingTypeFaceSettingLayout$initData$4 implements TypeFaceGridAdapter.a {

    /* renamed from: a */
    public final /* synthetic */ ReadingTypeFaceSettingLayout f14998a;

    public ReadingTypeFaceSettingLayout$initData$4(ReadingTypeFaceSettingLayout readingTypeFaceSettingLayout) {
        this.f14998a = readingTypeFaceSettingLayout;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0016, code lost:
    
        r2 = r2.getReadMenuCallBack();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void d(com.martian.mibook.mvvm.read.widget.ReadingTypeFaceSettingLayout r2, int r3) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            com.martian.mibook.mvvm.read.adapter.TypeFaceGridAdapter r0 = com.martian.mibook.mvvm.read.widget.ReadingTypeFaceSettingLayout.g(r2)
            if (r0 == 0) goto L1f
            android.content.Context r1 = r2.getContext()
            boolean r3 = r0.n(r1, r3)
            r0 = 1
            if (r3 != r0) goto L1f
            com.martian.mibook.mvvm.read.widget.a r2 = com.martian.mibook.mvvm.read.widget.ReadingTypeFaceSettingLayout.f(r2)
            if (r2 == 0) goto L1f
            r2.y0()
        L1f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.read.widget.ReadingTypeFaceSettingLayout$initData$4.d(com.martian.mibook.mvvm.read.widget.ReadingTypeFaceSettingLayout, int):void");
    }

    @Override // com.martian.mibook.mvvm.read.adapter.TypeFaceGridAdapter.a
    public boolean a(@l View view, @l TypefaceItem typefaceItem, int i10) {
        if (typefaceItem != null && typefaceItem.getType() == 2) {
            Context context = this.f14998a.getContext();
            Context context2 = this.f14998a.getContext();
            i0.z0(context, context2 != null ? context2.getString(R.string.prompt) : null, "删除选中的字体?", new i0.l() { // from class: hd.t3

                /* renamed from: b */
                public final /* synthetic */ int f26654b;

                public /* synthetic */ t3(int i102) {
                    i10 = i102;
                }

                @Override // l9.i0.l
                public final void a() {
                    ReadingTypeFaceSettingLayout$initData$4.d(ReadingTypeFaceSettingLayout.this, i10);
                }
            });
        }
        return true;
    }

    @Override // com.martian.mibook.mvvm.read.adapter.TypeFaceGridAdapter.a
    public void b(@l View view, @l TypefaceItem typefaceItem, int i10, @l ItemReadingTypeFaceBinding itemReadingTypeFaceBinding) {
        TypeFaceGridAdapter typeFaceGridAdapter;
        typeFaceGridAdapter = this.f14998a.typeFaceGridAdapter;
        if (typeFaceGridAdapter != null) {
            typeFaceGridAdapter.r(this.f14998a.getContext(), i10, itemReadingTypeFaceBinding, new Function0<Unit>() { // from class: com.martian.mibook.mvvm.read.widget.ReadingTypeFaceSettingLayout$initData$4$onItemClick$1
                public ReadingTypeFaceSettingLayout$initData$4$onItemClick$1() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke */
                public final void invoke2() {
                    a readMenuCallBack;
                    ReadingViewModel mViewModel;
                    AppViewModel appViewModel;
                    readMenuCallBack = ReadingTypeFaceSettingLayout.this.getReadMenuCallBack();
                    if (readMenuCallBack != null) {
                        readMenuCallBack.y0();
                    }
                    mViewModel = ReadingTypeFaceSettingLayout.this.getMViewModel();
                    if (mViewModel != null) {
                        mViewModel.g3(true);
                    }
                    appViewModel = ReadingTypeFaceSettingLayout.this.getAppViewModel();
                    if (appViewModel != null) {
                        appViewModel.y0();
                    }
                    t0.b(ReadingTypeFaceSettingLayout.this.getContext(), ExtKt.c("字体已设置成功"));
                }
            });
        }
    }
}
