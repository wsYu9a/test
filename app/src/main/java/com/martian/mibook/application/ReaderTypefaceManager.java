package com.martian.mibook.application;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.TextView;
import ba.g;
import ba.j;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.mibook.R;
import com.martian.mibook.data.TypefaceItem;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.f;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 '2\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\u00020\b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0019\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001c\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001b\u001a\u00020\b¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\b¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\u000f¢\u0006\u0004\b\"\u0010\u0013J\r\u0010$\u001a\u00020#¢\u0006\u0004\b$\u0010%J\u0019\u0010'\u001a\u0004\u0018\u00010#2\b\u0010&\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u000f2\b\u0010*\u001a\u0004\u0018\u00010)¢\u0006\u0004\b+\u0010,J\r\u0010-\u001a\u00020\u000f¢\u0006\u0004\b-\u0010\u0013J\u000f\u0010.\u001a\u00020\u000fH\u0002¢\u0006\u0004\b.\u0010\u0013J\u0015\u00100\u001a\b\u0012\u0004\u0012\u00020\u00060/H\u0002¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u000fH\u0002¢\u0006\u0004\b2\u0010\u0013J\u0015\u00103\u001a\b\u0012\u0004\u0012\u00020\u00060/H\u0002¢\u0006\u0004\b3\u00101J\u001d\u00105\u001a\b\u0012\u0004\u0012\u00020\u00060/2\u0006\u00104\u001a\u00020\u0006H\u0002¢\u0006\u0004\b5\u00106J\u0019\u00108\u001a\u00020\b2\b\u00107\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b8\u0010\nJ\u001f\u0010:\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010#09H\u0002¢\u0006\u0004\b:\u0010;R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\"\u0010<\u001a\u0004\b=\u0010>R\u001e\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010?R\u0016\u0010B\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010AR\u0018\u0010E\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010G\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010FR(\u0010I\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010HR\u001d\u0010M\u001a\u0004\u0018\u00010J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010K\u001a\u0004\bC\u0010L¨\u0006N"}, d2 = {"Lcom/martian/mibook/application/ReaderTypefaceManager;", "", "Landroid/content/Context;", f.X, "<init>", "(Landroid/content/Context;)V", "", "filepath", "", "n", "(Ljava/lang/String;)Z", "", "favorList", t.f11211k, "(Ljava/util/List;)Z", "", "b", "(Ljava/lang/String;)V", "s", "()V", "Ljava/util/LinkedList;", "Lcom/martian/mibook/data/TypefaceItem;", "f", "()Ljava/util/LinkedList;", "directoryPath", "u", "(Landroid/content/Context;Ljava/lang/String;)V", "systemDefault", "v", "(Landroid/content/Context;Z)V", t.f11204d, "()Z", "i", "()Ljava/lang/String;", "a", "Landroid/graphics/Typeface;", "g", "()Landroid/graphics/Typeface;", t8.a.f30751f, "h", "(Ljava/lang/String;)Landroid/graphics/Typeface;", "Landroid/widget/TextView;", "textView", bt.aO, "(Landroid/widget/TextView;)V", "q", "m", "", "j", "()Ljava/util/List;", "c", "p", "json", "k", "(Ljava/lang/String;)Ljava/util/List;", "typefaceDirectory", "o", "Ljava/util/Hashtable;", e.TAG, "()Ljava/util/Hashtable;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Ljava/util/List;", "mLocalTypefaceList", "Z", "typefaceChanged", "d", "Ljava/lang/Boolean;", "isSystemTypeface", "Ljava/lang/String;", "typefaceDirectoryRecord", "Ljava/util/Hashtable;", "fontCache", "Lcom/martian/mibook/mvvm/ui/viewmodel/AppViewModel;", "Lkotlin/Lazy;", "()Lcom/martian/mibook/mvvm/ui/viewmodel/AppViewModel;", "appViewModel", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nReaderTypefaceManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReaderTypefaceManager.kt\ncom/martian/mibook/application/ReaderTypefaceManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,442:1\n1855#2,2:443\n*S KotlinDebug\n*F\n+ 1 ReaderTypefaceManager.kt\ncom/martian/mibook/application/ReaderTypefaceManager\n*L\n77#1:443,2\n*E\n"})
/* loaded from: classes3.dex */
public final class ReaderTypefaceManager {

    /* renamed from: i */
    @k
    public static final String f13362i = "mibook_typeface.json";

    /* renamed from: j */
    @k
    public static final String f13363j = "TYPEFACE_SYSTEM_DEFAULT";

    /* renamed from: k */
    @k
    public static final String f13364k = "TYPEFACE_DIRECTORY_RECORE";

    /* renamed from: a, reason: from kotlin metadata */
    @k
    public final Context com.umeng.analytics.pro.f.X java.lang.String;

    /* renamed from: b, reason: from kotlin metadata */
    @l
    public List<String> mLocalTypefaceList;

    /* renamed from: c, reason: from kotlin metadata */
    public boolean typefaceChanged;

    /* renamed from: d, reason: from kotlin metadata */
    @l
    public Boolean isSystemTypeface;

    /* renamed from: e */
    @l
    public String typefaceDirectoryRecord;

    /* renamed from: f, reason: from kotlin metadata */
    @l
    public Hashtable<String, Typeface> fontCache;

    /* renamed from: g, reason: from kotlin metadata */
    @k
    public final Lazy appViewModel;

    public static final class b extends TypeToken<List<String>> {
    }

    public ReaderTypefaceManager(@k Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.com.umeng.analytics.pro.f.X java.lang.String = context;
        this.appViewModel = LazyKt.lazy(new Function0<AppViewModel>() { // from class: com.martian.mibook.application.ReaderTypefaceManager$appViewModel$2
            public ReaderTypefaceManager$appViewModel$2() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @l
            public final AppViewModel invoke() {
                return lc.b.a(ReaderTypefaceManager.this.getCom.umeng.analytics.pro.f.X java.lang.String());
            }
        });
        m();
    }

    public final void a() {
        e().clear();
    }

    public final void b(@l String filepath) {
        List<String> j10 = j();
        this.mLocalTypefaceList = j10;
        if (j10 != null) {
            TypeIntrinsics.asMutableCollection(j10).remove(filepath);
        }
        this.typefaceChanged = true;
        try {
            c();
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    public final void c() {
        if (this.typefaceChanged) {
            try {
                g.F(this.com.umeng.analytics.pro.f.X java.lang.String, f13362i, new Gson().toJson(this.mLocalTypefaceList));
            } catch (Exception unused) {
            }
        }
    }

    public final AppViewModel d() {
        return (AppViewModel) this.appViewModel.getValue();
    }

    public final Hashtable<String, Typeface> e() {
        Hashtable<String, Typeface> hashtable = this.fontCache;
        return hashtable == null ? new Hashtable<>() : hashtable;
    }

    @k
    public final LinkedList<TypefaceItem> f() {
        int size;
        LinkedList<TypefaceItem> linkedList = new LinkedList<>();
        TypefaceItem typefaceItem = new TypefaceItem();
        typefaceItem.setType(0);
        linkedList.add(typefaceItem);
        List<String> j10 = j();
        if ((!j10.isEmpty()) && j10.size() - 1 >= 0) {
            while (true) {
                int i10 = size - 1;
                String str = j10.get(size);
                if (!ba.l.q(str) && new File(str).exists()) {
                    TypefaceItem typefaceItem2 = new TypefaceItem();
                    typefaceItem2.setFilePath(str);
                    typefaceItem2.setType(2);
                    linkedList.add(typefaceItem2);
                }
                if (i10 < 0) {
                    break;
                }
                size = i10;
            }
        }
        TypefaceItem typefaceItem3 = new TypefaceItem();
        String str2 = ba.b.j() + "SourceHanSerifCN-Regular.ttf";
        String str3 = ba.b.h("fonts") + this.com.umeng.analytics.pro.f.X java.lang.String.getString(R.string.typeface_sysong) + p1.a.f29680b;
        typefaceItem3.setType(1);
        typefaceItem3.setDownloadUrl("http://scdn.taoyuewenhua.net/app/font/SourceHanSerifCN-Regular.zip");
        typefaceItem3.setDownloadPath(str3);
        typefaceItem3.setFilePath(str2);
        typefaceItem3.setRes(R.drawable.typeface_sysong);
        typefaceItem3.setFileSize("7.26M");
        linkedList.add(typefaceItem3);
        TypefaceItem typefaceItem4 = new TypefaceItem();
        String str4 = ba.b.j() + "GenJyuuGothic-Regular-2.ttf";
        String str5 = ba.b.h("fonts") + this.com.umeng.analytics.pro.f.X java.lang.String.getString(R.string.typeface_syrouhei) + p1.a.f29680b;
        typefaceItem4.setType(1);
        typefaceItem4.setDownloadUrl("http://scdn.taoyuewenhua.net/app/font/GenJyuuGothic-Regular-2.zip");
        typefaceItem4.setDownloadPath(str5);
        typefaceItem4.setFilePath(str4);
        typefaceItem4.setRes(R.drawable.typeface_syrou);
        typefaceItem4.setFileSize("4.87M");
        linkedList.add(typefaceItem4);
        TypefaceItem typefaceItem5 = new TypefaceItem();
        String str6 = ba.b.j() + "yrdz.ttf";
        String str7 = ba.b.h("fonts") + this.com.umeng.analytics.pro.f.X java.lang.String.getString(R.string.typeface_yrdz) + p1.a.f29680b;
        typefaceItem5.setType(1);
        typefaceItem5.setDownloadUrl("http://scdn.taoyuewenhua.net/app/font/yrdz.zip");
        typefaceItem5.setDownloadPath(str7);
        typefaceItem5.setFilePath(str6);
        typefaceItem5.setRes(R.drawable.typeface_yrdz);
        typefaceItem5.setFileSize("2.26M");
        linkedList.add(typefaceItem5);
        TypefaceItem typefaceItem6 = new TypefaceItem();
        String str8 = ba.b.j() + "SIMKAI(1).ttf";
        String str9 = ba.b.h("fonts") + this.com.umeng.analytics.pro.f.X java.lang.String.getString(R.string.typeface_kai) + p1.a.f29680b;
        typefaceItem6.setType(1);
        typefaceItem6.setDownloadUrl("http://scdn.taoyuewenhua.net/app/font/SIMKAI.zip");
        typefaceItem6.setDownloadPath(str9);
        typefaceItem6.setFilePath(str8);
        typefaceItem6.setRes(R.drawable.typeface_kai);
        typefaceItem6.setFileSize("6.42M");
        linkedList.add(typefaceItem6);
        TypefaceItem typefaceItem7 = new TypefaceItem();
        String str10 = ba.b.j() + "xiawu.ttf";
        String str11 = ba.b.h("fonts") + this.com.umeng.analytics.pro.f.X java.lang.String.getString(R.string.typeface_xiawu) + p1.a.f29680b;
        typefaceItem7.setType(4);
        typefaceItem7.setDownloadUrl("http://scdn.taoyuewenhua.net/app/font/xiawu.ttf.zip");
        typefaceItem7.setDownloadPath(str11);
        typefaceItem7.setFilePath(str10);
        typefaceItem7.setRes(R.drawable.typeface_xiawu);
        typefaceItem7.setFileSize("18.6M");
        typefaceItem7.setUnlockExpLevel(10);
        linkedList.add(typefaceItem7);
        TypefaceItem typefaceItem8 = new TypefaceItem();
        String str12 = ba.b.j() + "台黑.ttf";
        String str13 = ba.b.h("fonts") + this.com.umeng.analytics.pro.f.X java.lang.String.getString(R.string.typeface_tb_black) + p1.a.f29680b;
        typefaceItem8.setType(4);
        typefaceItem8.setDownloadUrl("http://scdn.taoyuewenhua.net/app/font/%E5%8F%B0%E9%BB%91.ttf.zip");
        typefaceItem8.setDownloadPath(str13);
        typefaceItem8.setFilePath(str12);
        typefaceItem8.setRes(R.drawable.typeface_tb_black);
        typefaceItem8.setFileSize("20.7M");
        typefaceItem8.setUnlockExpLevel(20);
        linkedList.add(typefaceItem8);
        TypefaceItem typefaceItem9 = new TypefaceItem();
        String str14 = ba.b.j() + "清松.ttf";
        String str15 = ba.b.h("fonts") + this.com.umeng.analytics.pro.f.X java.lang.String.getString(R.string.typeface_sonamu_handwrite) + p1.a.f29680b;
        typefaceItem9.setType(4);
        typefaceItem9.setDownloadUrl("http://scdn.taoyuewenhua.net/app/font/%E6%B8%85%E6%9D%BE.ttf.zip");
        typefaceItem9.setDownloadPath(str15);
        typefaceItem9.setFilePath(str14);
        typefaceItem9.setRes(R.drawable.typeface_sonamu_handwrite);
        typefaceItem9.setFileSize("6.3M");
        typefaceItem9.setUnlockExpLevel(30);
        linkedList.add(typefaceItem9);
        TypefaceItem typefaceItem10 = new TypefaceItem();
        String str16 = ba.b.j() + "851手写.ttf";
        String str17 = ba.b.h("fonts") + this.com.umeng.analytics.pro.f.X java.lang.String.getString(R.string.typeface_851_handwrite) + p1.a.f29680b;
        typefaceItem10.setType(4);
        typefaceItem10.setDownloadUrl("http://scdn.taoyuewenhua.net/app/font/851%E6%89%8B%E5%86%99.ttf.zip");
        typefaceItem10.setDownloadPath(str17);
        typefaceItem10.setFilePath(str16);
        typefaceItem10.setRes(R.drawable.typeface_851_handwrite);
        typefaceItem10.setFileSize("28.6M");
        linkedList.add(typefaceItem10);
        TypefaceItem typefaceItem11 = new TypefaceItem();
        String str18 = ba.b.j() + "极影.ttf";
        String str19 = ba.b.h("fonts") + this.com.umeng.analytics.pro.f.X java.lang.String.getString(R.string.typeface_polar_shadow_circle) + p1.a.f29680b;
        typefaceItem11.setType(4);
        typefaceItem11.setDownloadUrl("http://scdn.taoyuewenhua.net/app/font/%E6%9E%81%E5%BD%B1.ttf.zip");
        typefaceItem11.setDownloadPath(str19);
        typefaceItem11.setFilePath(str18);
        typefaceItem11.setRes(R.drawable.typeface_polar_shadow_circle);
        typefaceItem11.setFileSize("9.3M");
        typefaceItem11.setUnlockExpLevel(40);
        linkedList.add(typefaceItem11);
        String m10 = ba.b.m();
        if (ba.b.q(m10, "SourceHanSerifCN-Regular.ttf")) {
            typefaceItem3.setFilePath(m10 + "SourceHanSerifCN-Regular.ttf");
            typefaceItem3.setDownloadPath(m10 + this.com.umeng.analytics.pro.f.X java.lang.String.getString(R.string.typeface_sysong) + p1.a.f29680b);
        }
        if (ba.b.q(m10, "GenJyuuGothic-Regular-2.ttf")) {
            typefaceItem4.setFilePath(m10 + "GenJyuuGothic-Regular-2.ttf");
            typefaceItem4.setDownloadPath(m10 + this.com.umeng.analytics.pro.f.X java.lang.String.getString(R.string.typeface_syrouhei) + p1.a.f29680b);
        }
        if (ba.b.q(m10, "yrdz.ttf")) {
            typefaceItem5.setFilePath(m10 + "yrdz.ttf");
            typefaceItem5.setDownloadPath(m10 + this.com.umeng.analytics.pro.f.X java.lang.String.getString(R.string.typeface_yrdz) + p1.a.f29680b);
        }
        if (ba.b.q(m10, "SIMKAI(1).ttf")) {
            typefaceItem6.setFilePath(m10 + "SIMKAI(1).ttf");
            typefaceItem6.setDownloadPath(m10 + this.com.umeng.analytics.pro.f.X java.lang.String.getString(R.string.typeface_kai) + p1.a.f29680b);
        }
        return linkedList;
    }

    @k
    public final Typeface g() {
        if (l()) {
            Typeface DEFAULT = Typeface.DEFAULT;
            Intrinsics.checkNotNullExpressionValue(DEFAULT, "DEFAULT");
            return DEFAULT;
        }
        Typeface h10 = h(getTypefaceDirectoryRecord());
        if (h10 != null) {
            return h10;
        }
        Typeface DEFAULT2 = Typeface.DEFAULT;
        Intrinsics.checkNotNullExpressionValue(DEFAULT2, "DEFAULT");
        return DEFAULT2;
    }

    @k
    /* renamed from: getContext, reason: from getter */
    public final Context getCom.umeng.analytics.pro.f.X java.lang.String() {
        return this.com.umeng.analytics.pro.f.X java.lang.String;
    }

    @l
    public final Typeface h(@l String r32) {
        if (TextUtils.isEmpty(r32)) {
            return null;
        }
        Typeface typeface = e().get(r32);
        if (typeface == null) {
            try {
                typeface = Typeface.createFromFile(r32);
                e().put(r32, typeface);
            } catch (Exception unused) {
                return null;
            }
        }
        return typeface;
    }

    @l
    /* renamed from: i, reason: from getter */
    public final String getTypefaceDirectoryRecord() {
        return this.typefaceDirectoryRecord;
    }

    public final List<String> j() {
        if (this.mLocalTypefaceList == null) {
            try {
                this.mLocalTypefaceList = p();
            } catch (IOException unused) {
            }
        }
        if (this.mLocalTypefaceList == null) {
            this.mLocalTypefaceList = new ArrayList();
        } else {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            List<String> list = this.mLocalTypefaceList;
            ListIterator<String> listIterator = list != null ? list.listIterator() : null;
            boolean z10 = false;
            while (listIterator != null && listIterator.hasNext()) {
                try {
                } catch (IOException unused2) {
                    listIterator.remove();
                }
                if (!linkedHashSet.add(new File(listIterator.next()).getCanonicalPath())) {
                    listIterator.remove();
                    z10 = true;
                }
            }
            if (z10) {
                try {
                    c();
                } catch (IOException unused3) {
                }
            }
        }
        List<String> list2 = this.mLocalTypefaceList;
        return list2 == null ? new ArrayList() : list2;
    }

    public final List<String> k(String json) {
        List<String> list = (List) GsonUtils.a().fromJson(json, new b().getType());
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (TextUtils.isEmpty(listIterator.next())) {
                listIterator.remove();
            }
        }
        Intrinsics.checkNotNull(list);
        return list;
    }

    public final boolean l() {
        Boolean bool = this.isSystemTypeface;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public final void m() {
        AppViewModel d10;
        if (this.isSystemTypeface == null) {
            this.isSystemTypeface = Boolean.valueOf(j.d(this.com.umeng.analytics.pro.f.X java.lang.String, f13363j, true));
        }
        Boolean bool = this.isSystemTypeface;
        Intrinsics.checkNotNull(bool);
        if (bool.booleanValue()) {
            return;
        }
        if (this.typefaceDirectoryRecord == null) {
            this.typefaceDirectoryRecord = j.j(this.com.umeng.analytics.pro.f.X java.lang.String, f13364k);
        }
        if (TextUtils.isEmpty(this.typefaceDirectoryRecord)) {
            return;
        }
        String str = this.typefaceDirectoryRecord;
        Intrinsics.checkNotNull(str);
        if (!new File(str).exists()) {
            v(this.com.umeng.analytics.pro.f.X java.lang.String, true);
        } else {
            if (MiConfigSingleton.b2().K2() || !o(this.typefaceDirectoryRecord) || (d10 = d()) == null) {
                return;
            }
            d10.D0(Boolean.FALSE);
        }
    }

    public final boolean n(@k String filepath) {
        Intrinsics.checkNotNullParameter(filepath, "filepath");
        if (TextUtils.isEmpty(filepath)) {
            return false;
        }
        List<String> j10 = j();
        this.mLocalTypefaceList = j10;
        if (j10 == null) {
            return false;
        }
        Iterator<T> it = j10.iterator();
        while (it.hasNext()) {
            if (StringsKt.equals(filepath, (String) it.next(), true)) {
                return true;
            }
        }
        return false;
    }

    public final boolean o(String typefaceDirectory) {
        if (!Intrinsics.areEqual(typefaceDirectory, ba.b.j() + "台黑.ttf")) {
            if (!Intrinsics.areEqual(typefaceDirectory, ba.b.j() + "清松.ttf")) {
                if (!Intrinsics.areEqual(typefaceDirectory, ba.b.j() + "851手写.ttf")) {
                    if (!Intrinsics.areEqual(typefaceDirectory, ba.b.j() + "极影.ttf")) {
                        if (!Intrinsics.areEqual(typefaceDirectory, ba.b.j() + "xiawu.ttf")) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public final List<String> p() {
        try {
            String B = g.B(this.com.umeng.analytics.pro.f.X java.lang.String, f13362i);
            this.typefaceChanged = false;
            Intrinsics.checkNotNull(B);
            return k(B);
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public final void q() {
        if (MiConfigSingleton.b2().K2() || !o(this.typefaceDirectoryRecord)) {
            return;
        }
        v(this.com.umeng.analytics.pro.f.X java.lang.String, true);
    }

    public final boolean r(@l List<String> list) {
        List<String> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return false;
        }
        List<String> j10 = j();
        this.mLocalTypefaceList = j10;
        if (j10 != null) {
            j10.addAll(list2);
        }
        this.typefaceChanged = true;
        try {
            c();
        } catch (IOException e10) {
            e10.printStackTrace();
        }
        this.typefaceChanged = false;
        return true;
    }

    public final void s() {
        try {
            this.mLocalTypefaceList = p();
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    public final void t(@l TextView textView) {
        Typeface h10;
        TextPaint paint;
        TextPaint paint2;
        if (l()) {
            if (textView == null || (paint2 = textView.getPaint()) == null) {
                return;
            }
            paint2.setTypeface(Typeface.DEFAULT);
            return;
        }
        String typefaceDirectoryRecord = getTypefaceDirectoryRecord();
        if (TextUtils.isEmpty(typefaceDirectoryRecord) || (h10 = h(typefaceDirectoryRecord)) == null || textView == null || (paint = textView.getPaint()) == null) {
            return;
        }
        paint.setTypeface(h10);
    }

    public final void u(@l Context r22, @l String directoryPath) {
        this.typefaceDirectoryRecord = directoryPath;
        j.o(r22, f13364k, directoryPath);
    }

    public final void v(@l Context r22, boolean systemDefault) {
        this.isSystemTypeface = Boolean.valueOf(systemDefault);
        j.p(r22, f13363j, systemDefault);
    }
}
