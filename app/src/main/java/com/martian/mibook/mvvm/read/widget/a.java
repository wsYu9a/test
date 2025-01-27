package com.martian.mibook.mvvm.read.widget;

import android.view.View;
import com.martian.mibook.application.ReadingInstance;
import com.martian.mibook.lib.model.data.MiBookMark;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import xi.k;
import xi.l;

/* loaded from: classes3.dex */
public interface a {

    /* renamed from: com.martian.mibook.mvvm.read.widget.a$a */
    public static final class C0540a {
        public static /* synthetic */ void a(a aVar, boolean z10, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyReadingTheme");
            }
            if ((i10 & 1) != 0) {
                z10 = true;
            }
            aVar.d0(z10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void b(a aVar, Function0 function0, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doCloseReadMenu");
            }
            if ((i10 & 1) != 0) {
                function0 = null;
            }
            aVar.O(function0);
        }

        public static /* synthetic */ boolean c(a aVar, boolean z10, MiBookMark miBookMark, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handlePageBookMark");
            }
            if ((i10 & 2) != 0) {
                miBookMark = null;
            }
            return aVar.Q(z10, miBookMark);
        }

        public static /* synthetic */ void d(a aVar, boolean z10, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: upSystemUiVisibility");
            }
            if ((i10 & 1) != 0) {
                z10 = false;
            }
            aVar.k(z10);
        }
    }

    void A();

    void B0(boolean z10);

    void C0(int i10, int i11);

    void F0(@k String str);

    void G();

    void G0();

    void K();

    void L0();

    void M();

    void M0();

    void O(@l Function0<Unit> function0);

    void P();

    void P0();

    boolean Q(boolean z10, @l MiBookMark miBookMark);

    void T();

    void U();

    void X();

    void Y();

    void a0(boolean z10);

    void b0();

    void d();

    void d0(boolean z10);

    void e();

    void f(boolean z10, boolean z11);

    void i();

    void i0();

    void j0(@k ReadingInstance.ScreenOffTime screenOffTime, boolean z10);

    void k(boolean z10);

    void l();

    void m();

    void n();

    void o(boolean z10);

    void o0();

    void onBackClick(@l View view);

    void onMoreItemClick(@k View view);

    void q0();

    void t(boolean z10);

    void t0(int i10, int i11, int i12);

    void u();

    void u0();

    void v();

    void v0();

    void w(@k String str);

    void y0();

    void z();
}
