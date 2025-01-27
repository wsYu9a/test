package kotlin.io;

import f.b.a.d;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0007\u001a\u00020\u0006*\u00020\u0005H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a#\u0010\u000b\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u000b\u0010\f\"\u001a\u0010\u000f\u001a\u00020\u0005*\u00020\u00058@@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\"\u001a\u0010\u0012\u001a\u00020\u0000*\u00020\u00058@@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\"\u0017\u0010\u0014\u001a\u00020\u0013*\u00020\u00058F@\u0006¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"", "", "getRootLength$FilesKt__FilePathComponentsKt", "(Ljava/lang/String;)I", "getRootLength", "Ljava/io/File;", "Lkotlin/io/FilePathComponents;", "toComponents", "(Ljava/io/File;)Lkotlin/io/FilePathComponents;", "beginIndex", "endIndex", "subPath", "(Ljava/io/File;II)Ljava/io/File;", "getRoot", "(Ljava/io/File;)Ljava/io/File;", "root", "getRootName", "(Ljava/io/File;)Ljava/lang/String;", "rootName", "", "isRooted", "(Ljava/io/File;)Z", "kotlin-stdlib"}, k = 5, mv = {1, 4, 0}, xs = "kotlin/io/FilesKt")
/* loaded from: classes5.dex */
class FilesKt__FilePathComponentsKt {
    @d
    public static final File getRoot(@d File root) {
        Intrinsics.checkParameterIsNotNull(root, "$this$root");
        return new File(getRootName(root));
    }

    private static final int getRootLength$FilesKt__FilePathComponentsKt(@d String str) {
        boolean endsWith$default;
        int indexOf$default;
        int indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) str, File.separatorChar, 0, false, 4, (Object) null);
        if (indexOf$default2 == 0) {
            if (str.length() > 1) {
                char charAt = str.charAt(1);
                char c2 = File.separatorChar;
                if (charAt == c2 && (indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, c2, 2, false, 4, (Object) null)) >= 0) {
                    int indexOf$default3 = StringsKt__StringsKt.indexOf$default((CharSequence) str, File.separatorChar, indexOf$default + 1, false, 4, (Object) null);
                    return indexOf$default3 >= 0 ? indexOf$default3 + 1 : str.length();
                }
            }
            return 1;
        }
        if (indexOf$default2 > 0 && str.charAt(indexOf$default2 - 1) == ':') {
            return indexOf$default2 + 1;
        }
        if (indexOf$default2 == -1) {
            endsWith$default = StringsKt__StringsKt.endsWith$default((CharSequence) str, ':', false, 2, (Object) null);
            if (endsWith$default) {
                return str.length();
            }
        }
        return 0;
    }

    @d
    public static final String getRootName(@d File rootName) {
        Intrinsics.checkParameterIsNotNull(rootName, "$this$rootName");
        String path = rootName.getPath();
        Intrinsics.checkExpressionValueIsNotNull(path, "path");
        String path2 = rootName.getPath();
        Intrinsics.checkExpressionValueIsNotNull(path2, "path");
        int rootLength$FilesKt__FilePathComponentsKt = getRootLength$FilesKt__FilePathComponentsKt(path2);
        if (path == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String substring = path.substring(0, rootLength$FilesKt__FilePathComponentsKt);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final boolean isRooted(@d File isRooted) {
        Intrinsics.checkParameterIsNotNull(isRooted, "$this$isRooted");
        String path = isRooted.getPath();
        Intrinsics.checkExpressionValueIsNotNull(path, "path");
        return getRootLength$FilesKt__FilePathComponentsKt(path) > 0;
    }

    @d
    public static final File subPath(@d File subPath, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(subPath, "$this$subPath");
        return toComponents(subPath).subPath(i2, i3);
    }

    @d
    public static final FilePathComponents toComponents(@d File toComponents) {
        List split$default;
        List list;
        Intrinsics.checkParameterIsNotNull(toComponents, "$this$toComponents");
        String path = toComponents.getPath();
        Intrinsics.checkExpressionValueIsNotNull(path, "path");
        int rootLength$FilesKt__FilePathComponentsKt = getRootLength$FilesKt__FilePathComponentsKt(path);
        String substring = path.substring(0, rootLength$FilesKt__FilePathComponentsKt);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String substring2 = path.substring(rootLength$FilesKt__FilePathComponentsKt);
        Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.String).substring(startIndex)");
        if (substring2.length() == 0) {
            list = CollectionsKt__CollectionsKt.emptyList();
        } else {
            split$default = StringsKt__StringsKt.split$default((CharSequence) substring2, new char[]{File.separatorChar}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(split$default, 10));
            Iterator it = split$default.iterator();
            while (it.hasNext()) {
                arrayList.add(new File((String) it.next()));
            }
            list = arrayList;
        }
        return new FilePathComponents(new File(substring), list);
    }
}
