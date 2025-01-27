package kc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.alibaba.android.arouter.facade.Postcard;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.account.MiUserManager;
import com.martian.mibook.lib.model.data.MiReadingRecord;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.mvvm.book.viewmodel.BookInfo;
import com.martian.mibook.mvvm.tts.activity.AudiobookActivity;
import com.martian.mibook.mvvm.yuewen.fragment.YWTagBookListFragment;
import ea.c;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import m1.e;
import xi.k;
import xi.l;
import ya.e0;

@SourceDebugExtension({"SMAP\nMIRouter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MIRouter.kt\ncom/martian/mibook/mvvm/arouter/MIRouter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,343:1\n1#2:344\n*E\n"})
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a */
    @k
    public static final b f27763a = new b();

    @JvmStatic
    public static final void A(@k String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        n1.a.j().d(kc.a.f27762r).withString("intent_source", source).navigation();
    }

    @JvmStatic
    public static final void B(@k String tag, int i10, int i11) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        n1.a.j().d(kc.a.f27747c).withInt("intent_ctype", i10).withInt(YWTagBookListFragment.D, i11).withString(YWTagBookListFragment.E, tag).navigation();
    }

    @JvmStatic
    @k
    public static final Intent a(@k Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Postcard d10 = n1.a.j().d(kc.a.f27751g);
        e.c(d10);
        return new Intent(context, d10.getDestination());
    }

    @JvmStatic
    @k
    public static final Intent b(@k Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Postcard d10 = n1.a.j().d(kc.a.f27761q);
        e.c(d10);
        return new Intent(context, d10.getDestination());
    }

    @JvmStatic
    @k
    public static final Intent c(@l Context context, @l String str) {
        Postcard d10 = n1.a.j().d(kc.a.f27754j);
        e.c(d10);
        Intent intent = new Intent(context, d10.getDestination());
        intent.putExtra(e0.I0, str);
        intent.setFlags(268435456);
        return intent;
    }

    @JvmStatic
    public static final void d() {
        n1.a.j().d(kc.a.f27746b).withInt(MiUserManager.f13854j, 200).withBoolean(MiUserManager.f13855k, true).navigation();
    }

    @JvmStatic
    public static final void e(@l Book book, int i10, int i11, boolean z10, @l String str) {
        n1.a.j().d(kc.a.f27751g).withSerializable("intent_book", book).withSerializable(AudiobookActivity.E, str).withInt(AudiobookActivity.B, i10).withInt(AudiobookActivity.C, i11).withBoolean(AudiobookActivity.D, z10).withFlags(131072).navigation();
    }

    public static /* synthetic */ void f(Book book, int i10, int i11, boolean z10, String str, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            book = null;
        }
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = 0;
        }
        if ((i12 & 8) != 0) {
            z10 = false;
        }
        if ((i12 & 16) != 0) {
            str = null;
        }
        e(book, i10, i11, z10, str);
    }

    @JvmStatic
    public static final void g(int i10) {
        n1.a.j().d(kc.a.f27748d).withInt("intent_ctype", i10).navigation();
    }

    @JvmStatic
    public static final void h(@k BookInfo bookInfo) {
        Intrinsics.checkNotNullParameter(bookInfo, "bookInfo");
        n1.a.j().d(kc.a.f27755k).withSerializable("INTENT_BOOK_INFO", bookInfo).navigation();
    }

    @JvmStatic
    public static final void i(int i10, @l Integer num, @l String str, @l String str2) {
        Postcard d10 = n1.a.j().d(kc.a.f27749e);
        d10.withInt("intent_ctype", i10);
        if (num != null) {
            d10.withInt("intent_brtype", num.intValue());
        }
        d10.withString("intent_category", str);
        d10.withString("intent_source", str2);
        d10.navigation();
    }

    public static /* synthetic */ void j(int i10, Integer num, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            num = null;
        }
        if ((i11 & 4) != 0) {
            str = null;
        }
        if ((i11 & 8) != 0) {
            str2 = null;
        }
        i(i10, num, str, str2);
    }

    @JvmStatic
    public static final void k(@l String str, @l String str2, @l String str3, @l String str4) {
        n1.a.j().d(kc.a.f27760p).withString(e0.f33173r0, str).withString(e0.f33175s0, str2).withString(e0.O0, str3).withString(e0.P0, str4).navigation();
    }

    @JvmStatic
    public static final void l(@l Integer num, @l Integer num2, @l Integer num3) {
        Postcard d10 = n1.a.j().d(kc.a.f27761q);
        if (num != null) {
            d10.withInt(e0.f33181v0, num.intValue());
        }
        if (num2 != null) {
            d10.withInt(e0.f33183w0, num2.intValue());
        }
        if (num3 != null) {
            d10.withFlags(num3.intValue());
        }
        d10.navigation();
    }

    public static /* synthetic */ void m(Integer num, Integer num2, Integer num3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = null;
        }
        if ((i10 & 2) != 0) {
            num2 = null;
        }
        if ((i10 & 4) != 0) {
            num3 = null;
        }
        l(num, num2, num3);
    }

    @JvmStatic
    public static final void n(int i10, @l String str) {
        n1.a.j().d(kc.a.f27753i).withInt(e0.f33189z0, i10).withString(e0.A0, str).navigation();
    }

    public static /* synthetic */ void o(int i10, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        n(i10, str);
    }

    @JvmStatic
    public static final void p(@k Activity activity, @l Uri uri) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (uri == null) {
            return;
        }
        n1.a.j().d(kc.a.f27754j).withString(e0.L0, uri.toString()).navigation(activity, 200);
    }

    @JvmStatic
    public static final void q(@k Activity activity, @l MiReadingRecord miReadingRecord) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (miReadingRecord == null) {
            return;
        }
        Book I = MiConfigSingleton.b2().M1().I(vb.e.l(miReadingRecord.getSourceString()));
        if (I == null) {
            t(activity, vb.e.d(miReadingRecord.getSourceString()), vb.e.e(miReadingRecord.getSourceString()), miReadingRecord.getChapterIndex(), miReadingRecord.getContentPos(), miReadingRecord.getContentLength());
        } else {
            r(activity, I);
        }
    }

    @JvmStatic
    public static final void r(@k Activity activity, @l Book book) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        s(activity, book, null, 0, 0, true);
    }

    @JvmStatic
    public static final void s(@k Activity activity, @l Book book, @l Integer num, @l Integer num2, @l Integer num3, boolean z10) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (book != null && book.isLocal()) {
            c.i(activity, MiConfigSingleton.b2().I0(), new a(book, num, num2, num3, z10, activity));
            return;
        }
        Postcard d10 = n1.a.j().d(kc.a.f27754j);
        d10.withSerializable("intent_book", book);
        d10.withInt(e0.E0, num != null ? num.intValue() : (book == null || !book.isLocal()) ? -1 : 0);
        d10.withInt(e0.F0, num2 != null ? num2.intValue() : 0);
        if (num3 != null && num3.intValue() > 0) {
            d10.withInt(e0.G0, num3.intValue());
        }
        d10.withBoolean(e0.H0, z10);
        d10.navigation(activity, 200);
    }

    @JvmStatic
    public static final void t(@k Activity activity, @l String str, @l String str2, int i10, @l Integer num, @l Integer num2) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        p(activity, Uri.parse("ttbook://m.taoyuewenhua.com/reader?sourceId=" + str + "&sourceName=" + str2 + "&chapterIndex=" + i10 + "&contentPos=" + num + "&contentLength=" + num2));
    }

    @JvmStatic
    public static final void u() {
        n1.a.j().d(kc.a.f27757m).navigation();
    }

    @JvmStatic
    public static final void v(@l String str, @l String str2) {
        n1.a.j().d(kc.a.f27759o).withString(e0.f33173r0, str).withString(e0.f33175s0, str2).navigation();
    }

    @JvmStatic
    public static final void w(@l String str) {
        n1.a.j().d(kc.a.f27756l).withString(e0.N0, str).navigation();
    }

    public static /* synthetic */ void x(String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        w(str);
    }

    @JvmStatic
    public static final void y() {
        n1.a.j().d(kc.a.f27752h).navigation();
    }

    @JvmStatic
    public static final void z(@k Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        n1.a.j().d(kc.a.f27758n).navigation(activity, 0);
    }

    public static final class a implements ea.b {

        /* renamed from: a */
        public final /* synthetic */ Book f27764a;

        /* renamed from: b */
        public final /* synthetic */ Integer f27765b;

        /* renamed from: c */
        public final /* synthetic */ Integer f27766c;

        /* renamed from: d */
        public final /* synthetic */ Integer f27767d;

        /* renamed from: e */
        public final /* synthetic */ boolean f27768e;

        /* renamed from: f */
        public final /* synthetic */ Activity f27769f;

        public a(Book book, Integer num, Integer num2, Integer num3, boolean z10, Activity activity) {
            this.f27764a = book;
            this.f27765b = num;
            this.f27766c = num2;
            this.f27767d = num3;
            this.f27768e = z10;
            this.f27769f = activity;
        }

        @Override // ea.b
        public void permissionGranted() {
            Postcard d10 = n1.a.j().d(kc.a.f27754j);
            d10.withSerializable("intent_book", this.f27764a);
            Integer num = this.f27765b;
            d10.withInt(e0.E0, num != null ? num.intValue() : this.f27764a.isLocal() ? 0 : -1);
            Integer num2 = this.f27766c;
            d10.withInt(e0.F0, num2 != null ? num2.intValue() : 0);
            Integer num3 = this.f27767d;
            if (num3 != null && num3.intValue() > 0) {
                d10.withInt(e0.G0, this.f27767d.intValue());
            }
            d10.withBoolean(e0.H0, this.f27768e);
            d10.navigation(this.f27769f, 200);
        }

        @Override // ea.b
        public void permissionDenied() {
        }
    }
}
