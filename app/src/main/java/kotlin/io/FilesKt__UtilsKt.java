package kotlin.io;

import com.kwad.sdk.api.model.AdnName;
import f.b.a.d;
import f.b.a.e;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\r\u001a/\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006\u001a/\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\u0006\u001a\u0019\u0010\t\u001a\u00020\u0000*\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\n\u001a\u0019\u0010\u000b\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\f\u001a\u0019\u0010\r\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\f\u001a\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u0003*\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\f\u001a\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u0000*\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000f\u0010\n\u001a-\u0010\u0016\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017\u001a?\u0010\u001c\u001a\u00020\u0012*\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00122\u001a\b\u0002\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u0018¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0011\u0010\u001e\u001a\u00020\u0012*\u00020\u0003¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0019\u0010!\u001a\u00020\u0012*\u00020\u00032\u0006\u0010 \u001a\u00020\u0003¢\u0006\u0004\b!\u0010\"\u001a\u0019\u0010!\u001a\u00020\u0012*\u00020\u00032\u0006\u0010 \u001a\u00020\u0000¢\u0006\u0004\b!\u0010#\u001a\u0019\u0010$\u001a\u00020\u0012*\u00020\u00032\u0006\u0010 \u001a\u00020\u0003¢\u0006\u0004\b$\u0010\"\u001a\u0019\u0010$\u001a\u00020\u0012*\u00020\u00032\u0006\u0010 \u001a\u00020\u0000¢\u0006\u0004\b$\u0010#\u001a\u0011\u0010%\u001a\u00020\u0003*\u00020\u0003¢\u0006\u0004\b%\u0010&\u001a\u0013\u0010%\u001a\u00020'*\u00020'H\u0002¢\u0006\u0004\b(\u0010)\u001a\u001f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030**\b\u0012\u0004\u0012\u00020\u00030*H\u0002¢\u0006\u0004\b(\u0010+\u001a\u0019\u0010-\u001a\u00020\u0003*\u00020\u00032\u0006\u0010,\u001a\u00020\u0003¢\u0006\u0004\b-\u0010\f\u001a\u0019\u0010-\u001a\u00020\u0003*\u00020\u00032\u0006\u0010,\u001a\u00020\u0000¢\u0006\u0004\b-\u0010.\u001a\u0019\u0010/\u001a\u00020\u0003*\u00020\u00032\u0006\u0010,\u001a\u00020\u0003¢\u0006\u0004\b/\u0010\f\u001a\u0019\u0010/\u001a\u00020\u0003*\u00020\u00032\u0006\u0010,\u001a\u00020\u0000¢\u0006\u0004\b/\u0010.\"\u0017\u00102\u001a\u00020\u0000*\u00020\u00038F@\u0006¢\u0006\u0006\u001a\u0004\b0\u00101\"\u0017\u00104\u001a\u00020\u0000*\u00020\u00038F@\u0006¢\u0006\u0006\u001a\u0004\b3\u00101\"\u0017\u00106\u001a\u00020\u0000*\u00020\u00038F@\u0006¢\u0006\u0006\u001a\u0004\b5\u00101¨\u00067"}, d2 = {"", "prefix", "suffix", "Ljava/io/File;", "directory", "createTempDir", "(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Ljava/io/File;", "createTempFile", "base", "toRelativeString", "(Ljava/io/File;Ljava/io/File;)Ljava/lang/String;", "relativeTo", "(Ljava/io/File;Ljava/io/File;)Ljava/io/File;", "relativeToOrSelf", "relativeToOrNull", "toRelativeStringOrNull$FilesKt__UtilsKt", "toRelativeStringOrNull", "target", "", "overwrite", "", "bufferSize", "copyTo", "(Ljava/io/File;Ljava/io/File;ZI)Ljava/io/File;", "Lkotlin/Function2;", "Ljava/io/IOException;", "Lkotlin/io/OnErrorAction;", "onError", "copyRecursively", "(Ljava/io/File;Ljava/io/File;ZLkotlin/jvm/functions/Function2;)Z", "deleteRecursively", "(Ljava/io/File;)Z", AdnName.OTHER, "startsWith", "(Ljava/io/File;Ljava/io/File;)Z", "(Ljava/io/File;Ljava/lang/String;)Z", "endsWith", "normalize", "(Ljava/io/File;)Ljava/io/File;", "Lkotlin/io/FilePathComponents;", "normalize$FilesKt__UtilsKt", "(Lkotlin/io/FilePathComponents;)Lkotlin/io/FilePathComponents;", "", "(Ljava/util/List;)Ljava/util/List;", "relative", "resolve", "(Ljava/io/File;Ljava/lang/String;)Ljava/io/File;", "resolveSibling", "getNameWithoutExtension", "(Ljava/io/File;)Ljava/lang/String;", "nameWithoutExtension", "getInvariantSeparatorsPath", "invariantSeparatorsPath", "getExtension", "extension", "kotlin-stdlib"}, k = 5, mv = {1, 4, 0}, xs = "kotlin/io/FilesKt")
/* loaded from: classes5.dex */
class FilesKt__UtilsKt extends FilesKt__FileTreeWalkKt {
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a0 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean copyRecursively(@f.b.a.d java.io.File r11, @f.b.a.d java.io.File r12, boolean r13, @f.b.a.d final kotlin.jvm.functions.Function2<? super java.io.File, ? super java.io.IOException, ? extends kotlin.io.OnErrorAction> r14) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FilesKt__UtilsKt.copyRecursively(java.io.File, java.io.File, boolean, kotlin.jvm.functions.Function2):boolean");
    }

    public static /* synthetic */ boolean copyRecursively$default(File file, File file2, boolean z, Function2 function2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            function2 = new Function2() { // from class: kotlin.io.FilesKt__UtilsKt$copyRecursively$1
                @Override // kotlin.jvm.functions.Function2
                @d
                public final Void invoke(@d File file3, @d IOException exception) {
                    Intrinsics.checkParameterIsNotNull(file3, "<anonymous parameter 0>");
                    Intrinsics.checkParameterIsNotNull(exception, "exception");
                    throw exception;
                }
            };
        }
        return copyRecursively(file, file2, z, function2);
    }

    @d
    public static final File copyTo(@d File copyTo, @d File target, boolean z, int i2) {
        Intrinsics.checkParameterIsNotNull(copyTo, "$this$copyTo");
        Intrinsics.checkParameterIsNotNull(target, "target");
        if (!copyTo.exists()) {
            throw new NoSuchFileException(copyTo, null, "The source file doesn't exist.", 2, null);
        }
        if (target.exists()) {
            if (!z) {
                throw new FileAlreadyExistsException(copyTo, target, "The destination file already exists.");
            }
            if (!target.delete()) {
                throw new FileAlreadyExistsException(copyTo, target, "Tried to overwrite the destination, but failed to delete it.");
            }
        }
        if (!copyTo.isDirectory()) {
            File parentFile = target.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            FileInputStream fileInputStream = new FileInputStream(copyTo);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(target);
                try {
                    ByteStreamsKt.copyTo(fileInputStream, fileOutputStream, i2);
                    CloseableKt.closeFinally(fileOutputStream, null);
                    CloseableKt.closeFinally(fileInputStream, null);
                } finally {
                }
            } finally {
            }
        } else if (!target.mkdirs()) {
            throw new FileSystemException(copyTo, target, "Failed to create target directory.");
        }
        return target;
    }

    public static /* synthetic */ File copyTo$default(File file, File file2, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 8192;
        }
        return copyTo(file, file2, z, i2);
    }

    @d
    public static final File createTempDir(@d String prefix, @e String str, @e File file) {
        Intrinsics.checkParameterIsNotNull(prefix, "prefix");
        File dir = File.createTempFile(prefix, str, file);
        dir.delete();
        if (dir.mkdir()) {
            Intrinsics.checkExpressionValueIsNotNull(dir, "dir");
            return dir;
        }
        throw new IOException("Unable to create temporary directory " + dir + '.');
    }

    public static /* synthetic */ File createTempDir$default(String str, String str2, File file, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "tmp";
        }
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        if ((i2 & 4) != 0) {
            file = null;
        }
        return createTempDir(str, str2, file);
    }

    @d
    public static final File createTempFile(@d String prefix, @e String str, @e File file) {
        Intrinsics.checkParameterIsNotNull(prefix, "prefix");
        File createTempFile = File.createTempFile(prefix, str, file);
        Intrinsics.checkExpressionValueIsNotNull(createTempFile, "File.createTempFile(prefix, suffix, directory)");
        return createTempFile;
    }

    public static /* synthetic */ File createTempFile$default(String str, String str2, File file, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "tmp";
        }
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        if ((i2 & 4) != 0) {
            file = null;
        }
        return createTempFile(str, str2, file);
    }

    public static final boolean deleteRecursively(@d File deleteRecursively) {
        Intrinsics.checkParameterIsNotNull(deleteRecursively, "$this$deleteRecursively");
        while (true) {
            boolean z = true;
            for (File file : FilesKt__FileTreeWalkKt.walkBottomUp(deleteRecursively)) {
                if (file.delete() || !file.exists()) {
                    if (z) {
                        break;
                    }
                }
                z = false;
            }
            return z;
        }
    }

    public static final boolean endsWith(@d File endsWith, @d File other) {
        Intrinsics.checkParameterIsNotNull(endsWith, "$this$endsWith");
        Intrinsics.checkParameterIsNotNull(other, "other");
        FilePathComponents components = FilesKt__FilePathComponentsKt.toComponents(endsWith);
        FilePathComponents components2 = FilesKt__FilePathComponentsKt.toComponents(other);
        if (components2.isRooted()) {
            return Intrinsics.areEqual(endsWith, other);
        }
        int size = components.getSize() - components2.getSize();
        if (size < 0) {
            return false;
        }
        return components.getSegments().subList(size, components.getSize()).equals(components2.getSegments());
    }

    @d
    public static final String getExtension(@d File extension) {
        Intrinsics.checkParameterIsNotNull(extension, "$this$extension");
        String name = extension.getName();
        Intrinsics.checkExpressionValueIsNotNull(name, "name");
        return StringsKt__StringsKt.substringAfterLast(name, '.', "");
    }

    @d
    public static final String getInvariantSeparatorsPath(@d File invariantSeparatorsPath) {
        String replace$default;
        Intrinsics.checkParameterIsNotNull(invariantSeparatorsPath, "$this$invariantSeparatorsPath");
        if (File.separatorChar == '/') {
            String path = invariantSeparatorsPath.getPath();
            Intrinsics.checkExpressionValueIsNotNull(path, "path");
            return path;
        }
        String path2 = invariantSeparatorsPath.getPath();
        Intrinsics.checkExpressionValueIsNotNull(path2, "path");
        replace$default = StringsKt__StringsJVMKt.replace$default(path2, File.separatorChar, '/', false, 4, (Object) null);
        return replace$default;
    }

    @d
    public static final String getNameWithoutExtension(@d File nameWithoutExtension) {
        String substringBeforeLast$default;
        Intrinsics.checkParameterIsNotNull(nameWithoutExtension, "$this$nameWithoutExtension");
        String name = nameWithoutExtension.getName();
        Intrinsics.checkExpressionValueIsNotNull(name, "name");
        substringBeforeLast$default = StringsKt__StringsKt.substringBeforeLast$default(name, ".", (String) null, 2, (Object) null);
        return substringBeforeLast$default;
    }

    @d
    public static final File normalize(@d File normalize) {
        Intrinsics.checkParameterIsNotNull(normalize, "$this$normalize");
        FilePathComponents components = FilesKt__FilePathComponentsKt.toComponents(normalize);
        File root = components.getRoot();
        List<File> normalize$FilesKt__UtilsKt = normalize$FilesKt__UtilsKt(components.getSegments());
        String str = File.separator;
        Intrinsics.checkExpressionValueIsNotNull(str, "File.separator");
        return resolve(root, CollectionsKt___CollectionsKt.joinToString$default(normalize$FilesKt__UtilsKt, str, null, null, 0, null, null, 62, null));
    }

    private static final FilePathComponents normalize$FilesKt__UtilsKt(@d FilePathComponents filePathComponents) {
        return new FilePathComponents(filePathComponents.getRoot(), normalize$FilesKt__UtilsKt(filePathComponents.getSegments()));
    }

    @d
    public static final File relativeTo(@d File relativeTo, @d File base) {
        Intrinsics.checkParameterIsNotNull(relativeTo, "$this$relativeTo");
        Intrinsics.checkParameterIsNotNull(base, "base");
        return new File(toRelativeString(relativeTo, base));
    }

    @e
    public static final File relativeToOrNull(@d File relativeToOrNull, @d File base) {
        Intrinsics.checkParameterIsNotNull(relativeToOrNull, "$this$relativeToOrNull");
        Intrinsics.checkParameterIsNotNull(base, "base");
        String relativeStringOrNull$FilesKt__UtilsKt = toRelativeStringOrNull$FilesKt__UtilsKt(relativeToOrNull, base);
        if (relativeStringOrNull$FilesKt__UtilsKt != null) {
            return new File(relativeStringOrNull$FilesKt__UtilsKt);
        }
        return null;
    }

    @d
    public static final File relativeToOrSelf(@d File relativeToOrSelf, @d File base) {
        Intrinsics.checkParameterIsNotNull(relativeToOrSelf, "$this$relativeToOrSelf");
        Intrinsics.checkParameterIsNotNull(base, "base");
        String relativeStringOrNull$FilesKt__UtilsKt = toRelativeStringOrNull$FilesKt__UtilsKt(relativeToOrSelf, base);
        return relativeStringOrNull$FilesKt__UtilsKt != null ? new File(relativeStringOrNull$FilesKt__UtilsKt) : relativeToOrSelf;
    }

    @d
    public static final File resolve(@d File resolve, @d File relative) {
        boolean endsWith$default;
        Intrinsics.checkParameterIsNotNull(resolve, "$this$resolve");
        Intrinsics.checkParameterIsNotNull(relative, "relative");
        if (FilesKt__FilePathComponentsKt.isRooted(relative)) {
            return relative;
        }
        String file = resolve.toString();
        Intrinsics.checkExpressionValueIsNotNull(file, "this.toString()");
        if (!(file.length() == 0)) {
            endsWith$default = StringsKt__StringsKt.endsWith$default((CharSequence) file, File.separatorChar, false, 2, (Object) null);
            if (!endsWith$default) {
                return new File(file + File.separatorChar + relative);
            }
        }
        return new File(file + relative);
    }

    @d
    public static final File resolveSibling(@d File resolveSibling, @d File relative) {
        Intrinsics.checkParameterIsNotNull(resolveSibling, "$this$resolveSibling");
        Intrinsics.checkParameterIsNotNull(relative, "relative");
        FilePathComponents components = FilesKt__FilePathComponentsKt.toComponents(resolveSibling);
        return resolve(resolve(components.getRoot(), components.getSize() == 0 ? new File("..") : components.subPath(0, components.getSize() - 1)), relative);
    }

    public static final boolean startsWith(@d File startsWith, @d File other) {
        Intrinsics.checkParameterIsNotNull(startsWith, "$this$startsWith");
        Intrinsics.checkParameterIsNotNull(other, "other");
        FilePathComponents components = FilesKt__FilePathComponentsKt.toComponents(startsWith);
        FilePathComponents components2 = FilesKt__FilePathComponentsKt.toComponents(other);
        if (!(!Intrinsics.areEqual(components.getRoot(), components2.getRoot())) && components.getSize() >= components2.getSize()) {
            return components.getSegments().subList(0, components2.getSize()).equals(components2.getSegments());
        }
        return false;
    }

    @d
    public static final String toRelativeString(@d File toRelativeString, @d File base) {
        Intrinsics.checkParameterIsNotNull(toRelativeString, "$this$toRelativeString");
        Intrinsics.checkParameterIsNotNull(base, "base");
        String relativeStringOrNull$FilesKt__UtilsKt = toRelativeStringOrNull$FilesKt__UtilsKt(toRelativeString, base);
        if (relativeStringOrNull$FilesKt__UtilsKt != null) {
            return relativeStringOrNull$FilesKt__UtilsKt;
        }
        throw new IllegalArgumentException("this and base files have different roots: " + toRelativeString + " and " + base + '.');
    }

    private static final String toRelativeStringOrNull$FilesKt__UtilsKt(@d File file, File file2) {
        List drop;
        FilePathComponents normalize$FilesKt__UtilsKt = normalize$FilesKt__UtilsKt(FilesKt__FilePathComponentsKt.toComponents(file));
        FilePathComponents normalize$FilesKt__UtilsKt2 = normalize$FilesKt__UtilsKt(FilesKt__FilePathComponentsKt.toComponents(file2));
        if (!Intrinsics.areEqual(normalize$FilesKt__UtilsKt.getRoot(), normalize$FilesKt__UtilsKt2.getRoot())) {
            return null;
        }
        int size = normalize$FilesKt__UtilsKt2.getSize();
        int size2 = normalize$FilesKt__UtilsKt.getSize();
        int i2 = 0;
        int min = Math.min(size2, size);
        while (i2 < min && Intrinsics.areEqual(normalize$FilesKt__UtilsKt.getSegments().get(i2), normalize$FilesKt__UtilsKt2.getSegments().get(i2))) {
            i2++;
        }
        StringBuilder sb = new StringBuilder();
        int i3 = size - 1;
        if (i3 >= i2) {
            while (!Intrinsics.areEqual(normalize$FilesKt__UtilsKt2.getSegments().get(i3).getName(), "..")) {
                sb.append("..");
                if (i3 != i2) {
                    sb.append(File.separatorChar);
                }
                if (i3 != i2) {
                    i3--;
                }
            }
            return null;
        }
        if (i2 < size2) {
            if (i2 < size) {
                sb.append(File.separatorChar);
            }
            drop = CollectionsKt___CollectionsKt.drop(normalize$FilesKt__UtilsKt.getSegments(), i2);
            String str = File.separator;
            Intrinsics.checkExpressionValueIsNotNull(str, "File.separator");
            CollectionsKt.joinTo$default(drop, sb, str, null, null, 0, null, null, 124, null);
        }
        return sb.toString();
    }

    private static final List<File> normalize$FilesKt__UtilsKt(@d List<? extends File> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (File file : list) {
            String name = file.getName();
            if (name != null) {
                int hashCode = name.hashCode();
                if (hashCode != 46) {
                    if (hashCode == 1472 && name.equals("..")) {
                        if (arrayList.isEmpty() || !(!Intrinsics.areEqual(((File) CollectionsKt.last((List) arrayList)).getName(), ".."))) {
                            arrayList.add(file);
                        } else {
                            arrayList.remove(arrayList.size() - 1);
                        }
                    }
                } else if (name.equals(".")) {
                }
            }
            arrayList.add(file);
        }
        return arrayList;
    }

    @d
    public static final File resolve(@d File resolve, @d String relative) {
        Intrinsics.checkParameterIsNotNull(resolve, "$this$resolve");
        Intrinsics.checkParameterIsNotNull(relative, "relative");
        return resolve(resolve, new File(relative));
    }

    @d
    public static final File resolveSibling(@d File resolveSibling, @d String relative) {
        Intrinsics.checkParameterIsNotNull(resolveSibling, "$this$resolveSibling");
        Intrinsics.checkParameterIsNotNull(relative, "relative");
        return resolveSibling(resolveSibling, new File(relative));
    }

    public static final boolean startsWith(@d File startsWith, @d String other) {
        Intrinsics.checkParameterIsNotNull(startsWith, "$this$startsWith");
        Intrinsics.checkParameterIsNotNull(other, "other");
        return startsWith(startsWith, new File(other));
    }

    public static final boolean endsWith(@d File endsWith, @d String other) {
        Intrinsics.checkParameterIsNotNull(endsWith, "$this$endsWith");
        Intrinsics.checkParameterIsNotNull(other, "other");
        return endsWith(endsWith, new File(other));
    }
}
