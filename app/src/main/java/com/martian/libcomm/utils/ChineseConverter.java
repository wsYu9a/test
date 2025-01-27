package com.martian.libcomm.utils;

import android.content.Context;
import com.kwad.sdk.m.e;
import com.umeng.analytics.pro.f;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\tJ;\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\"\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000bj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0005J\u0017\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u0005R2\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000bj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R2\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000bj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/martian/libcomm/utils/ChineseConverter;", "", "Landroid/content/Context;", f.X, "<init>", "(Landroid/content/Context;)V", "", "input", "f", "(Ljava/lang/String;)Ljava/lang/String;", "g", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "conversionMap", "c", "(Ljava/lang/String;Ljava/util/HashMap;)Ljava/lang/String;", "", "d", e.TAG, "a", "Ljava/util/HashMap;", "simplifiedToTraditional", "b", "traditionalToSimplified", "support_release"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nChineseConverter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChineseConverter.kt\ncom/martian/libcomm/utils/ChineseConverter\n+ 2 ReadWrite.kt\nkotlin/io/TextStreamsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,106:1\n52#2:107\n52#2:111\n1#3:108\n1#3:112\n1313#4,2:109\n1313#4,2:113\n*S KotlinDebug\n*F\n+ 1 ChineseConverter.kt\ncom/martian/libcomm/utils/ChineseConverter\n*L\n61#1:107\n87#1:111\n61#1:108\n87#1:112\n62#1:109,2\n88#1:113,2\n*E\n"})
/* loaded from: classes3.dex */
public final class ChineseConverter {

    /* renamed from: c, reason: from kotlin metadata */
    @k
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d */
    @l
    public static volatile ChineseConverter f12010d;

    /* renamed from: a, reason: from kotlin metadata */
    public HashMap<String, String> simplifiedToTraditional;

    /* renamed from: b, reason: from kotlin metadata */
    public HashMap<String, String> traditionalToSimplified;

    @SourceDebugExtension({"SMAP\nChineseConverter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChineseConverter.kt\ncom/martian/libcomm/utils/ChineseConverter$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,106:1\n1#2:107\n*E\n"})
    /* renamed from: com.martian.libcomm.utils.ChineseConverter$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @k
        public final ChineseConverter a(@k Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            ChineseConverter chineseConverter = ChineseConverter.f12010d;
            if (chineseConverter == null) {
                synchronized (this) {
                    chineseConverter = ChineseConverter.f12010d;
                    if (chineseConverter == null) {
                        chineseConverter = new ChineseConverter(context);
                        Companion companion = ChineseConverter.INSTANCE;
                        ChineseConverter.f12010d = chineseConverter;
                    }
                }
            }
            return chineseConverter;
        }

        public Companion() {
        }
    }

    public ChineseConverter(@k Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        d(context);
        e(context);
    }

    public final String c(String input, HashMap<String, String> conversionMap) {
        StringBuilder sb2 = new StringBuilder();
        int length = input.length();
        for (int i10 = 0; i10 < length; i10++) {
            String valueOf = String.valueOf(input.charAt(i10));
            String str = conversionMap.get(valueOf);
            if (str != null) {
                valueOf = str;
            }
            Intrinsics.checkNotNull(valueOf);
            sb2.append(valueOf);
        }
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "toString(...)");
        return sb3;
    }

    public final void d(Context r10) {
        try {
            this.simplifiedToTraditional = new HashMap<>();
            this.traditionalToSimplified = new HashMap<>();
            InputStream open = r10.getAssets().open("chinese.txt");
            Intrinsics.checkNotNullExpressionValue(open, "open(...)");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open, "UTF-8"));
            try {
                Iterator<String> it = TextStreamsKt.lineSequence(bufferedReader).iterator();
                while (true) {
                    HashMap<String, String> hashMap = null;
                    if (!it.hasNext()) {
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(bufferedReader, null);
                        bufferedReader.close();
                        return;
                    }
                    List split$default = StringsKt.split$default((CharSequence) it.next(), new String[]{","}, false, 0, 6, (Object) null);
                    if (split$default.size() == 2) {
                        String obj = StringsKt.trim((CharSequence) split$default.get(0)).toString();
                        String obj2 = StringsKt.trim((CharSequence) split$default.get(1)).toString();
                        HashMap<String, String> hashMap2 = this.simplifiedToTraditional;
                        if (hashMap2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("simplifiedToTraditional");
                            hashMap2 = null;
                        }
                        hashMap2.put(obj, obj2);
                        HashMap<String, String> hashMap3 = this.traditionalToSimplified;
                        if (hashMap3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("traditionalToSimplified");
                        } else {
                            hashMap = hashMap3;
                        }
                        hashMap.put(obj2, obj);
                    }
                }
            } finally {
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void e(Context context) {
        try {
            InputStream open = context.getAssets().open("traditionalToSimple.txt");
            Intrinsics.checkNotNullExpressionValue(open, "open(...)");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open, "UTF-8"));
            try {
                Iterator<String> it = TextStreamsKt.lineSequence(bufferedReader).iterator();
                while (true) {
                    HashMap<String, String> hashMap = null;
                    if (!it.hasNext()) {
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(bufferedReader, null);
                        bufferedReader.close();
                        return;
                    }
                    List split$default = StringsKt.split$default((CharSequence) it.next(), new String[]{","}, false, 0, 6, (Object) null);
                    if (split$default.size() == 2) {
                        String obj = StringsKt.trim((CharSequence) split$default.get(0)).toString();
                        String obj2 = StringsKt.trim((CharSequence) split$default.get(1)).toString();
                        HashMap<String, String> hashMap2 = this.traditionalToSimplified;
                        if (hashMap2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("traditionalToSimplified");
                        } else {
                            hashMap = hashMap2;
                        }
                        hashMap.put(obj2, obj);
                    }
                }
            } finally {
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @k
    public final String f(@k String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        HashMap<String, String> hashMap = this.simplifiedToTraditional;
        if (hashMap == null) {
            Intrinsics.throwUninitializedPropertyAccessException("simplifiedToTraditional");
            hashMap = null;
        }
        return c(input, hashMap);
    }

    @k
    public final String g(@k String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        HashMap<String, String> hashMap = this.traditionalToSimplified;
        if (hashMap == null) {
            Intrinsics.throwUninitializedPropertyAccessException("traditionalToSimplified");
            hashMap = null;
        }
        return c(input, hashMap);
    }
}
