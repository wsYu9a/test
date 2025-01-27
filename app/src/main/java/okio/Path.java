package okio;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.internal._PathKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import p1.b;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001.B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0000H\u0096\u0002J\u0016\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\rH\u0087\u0002¢\u0006\u0002\b\"J\u0016\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0003H\u0087\u0002¢\u0006\u0002\b\"J\u0016\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0002\b\"J\u0013\u0010#\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010$H\u0096\u0002J\b\u0010%\u001a\u00020\u001eH\u0016J\u0006\u0010&\u001a\u00020\u0000J\u000e\u0010'\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0000J\u0018\u0010\"\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\r2\b\b\u0002\u0010(\u001a\u00020\bJ\u0018\u0010\"\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\bJ\u0018\u0010\"\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u00002\b\b\u0002\u0010(\u001a\u00020\bJ\u0006\u0010)\u001a\u00020*J\b\u0010+\u001a\u00020,H\u0007J\b\u0010-\u001a\u00020\rH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0011\u0010\n\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\tR\u0011\u0010\u000b\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0006R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u00008G¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00008F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00158F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b8G¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001c¨\u0006/"}, d2 = {"Lokio/Path;", "", "bytes", "Lokio/ByteString;", "(Lokio/ByteString;)V", "getBytes$okio", "()Lokio/ByteString;", "isAbsolute", "", "()Z", "isRelative", "isRoot", "name", "", "()Ljava/lang/String;", "nameBytes", "parent", "()Lokio/Path;", "root", "getRoot", DBDefinition.SEGMENT_TABLE_NAME, "", "getSegments", "()Ljava/util/List;", "segmentsBytes", "getSegmentsBytes", "volumeLetter", "", "()Ljava/lang/Character;", "compareTo", "", AdnName.OTHER, "div", "child", "resolve", "equals", "", TTDownloadField.TT_HASHCODE, "normalized", "relativeTo", "normalize", "toFile", "Ljava/io/File;", "toNioPath", "Ljava/nio/file/Path;", "toString", "Companion", "okio"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Path implements Comparable<Path> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @k
    public static final Companion INSTANCE = new Companion(null);

    @k
    @JvmField
    public static final String DIRECTORY_SEPARATOR;

    @k
    private final ByteString bytes;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\nJ\u001b\u0010\u0005\u001a\u00020\u0006*\u00020\u000b2\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\nJ\u001b\u0010\f\u001a\u00020\u0006*\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\nR\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lokio/Path$Companion;", "", "()V", "DIRECTORY_SEPARATOR", "", "toOkioPath", "Lokio/Path;", "Ljava/io/File;", "normalize", "", MonitorConstants.CONNECT_TYPE_GET, "Ljava/nio/file/Path;", "toPath", "okio"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Path get$default(Companion companion, String str, boolean z10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z10 = false;
            }
            return companion.get(str, z10);
        }

        @JvmStatic
        @k
        @JvmName(name = MonitorConstants.CONNECT_TYPE_GET)
        @JvmOverloads
        public final Path get(@k File file) {
            Intrinsics.checkNotNullParameter(file, "<this>");
            return get$default(this, file, false, 1, (Object) null);
        }

        private Companion() {
        }

        public static /* synthetic */ Path get$default(Companion companion, File file, boolean z10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z10 = false;
            }
            return companion.get(file, z10);
        }

        @JvmStatic
        @k
        @JvmName(name = MonitorConstants.CONNECT_TYPE_GET)
        @JvmOverloads
        public final Path get(@k String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            return get$default(this, str, false, 1, (Object) null);
        }

        public static /* synthetic */ Path get$default(Companion companion, java.nio.file.Path path, boolean z10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z10 = false;
            }
            return companion.get(path, z10);
        }

        @JvmStatic
        @k
        @JvmName(name = MonitorConstants.CONNECT_TYPE_GET)
        @IgnoreJRERequirement
        @JvmOverloads
        public final Path get(@k java.nio.file.Path path) {
            Intrinsics.checkNotNullParameter(path, "<this>");
            return get$default(this, path, false, 1, (Object) null);
        }

        @JvmStatic
        @k
        @JvmName(name = MonitorConstants.CONNECT_TYPE_GET)
        @JvmOverloads
        public final Path get(@k String str, boolean z10) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            return _PathKt.commonToPath(str, z10);
        }

        @JvmStatic
        @k
        @JvmName(name = MonitorConstants.CONNECT_TYPE_GET)
        @JvmOverloads
        public final Path get(@k File file, boolean z10) {
            Intrinsics.checkNotNullParameter(file, "<this>");
            String file2 = file.toString();
            Intrinsics.checkNotNullExpressionValue(file2, "toString()");
            return get(file2, z10);
        }

        @JvmStatic
        @k
        @JvmName(name = MonitorConstants.CONNECT_TYPE_GET)
        @IgnoreJRERequirement
        @JvmOverloads
        public final Path get(@k java.nio.file.Path path, boolean z10) {
            Intrinsics.checkNotNullParameter(path, "<this>");
            return get(path.toString(), z10);
        }
    }

    static {
        String separator = File.separator;
        Intrinsics.checkNotNullExpressionValue(separator, "separator");
        DIRECTORY_SEPARATOR = separator;
    }

    public Path(@k ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        this.bytes = bytes;
    }

    @JvmStatic
    @k
    @JvmName(name = MonitorConstants.CONNECT_TYPE_GET)
    @JvmOverloads
    public static final Path get(@k File file) {
        return INSTANCE.get(file);
    }

    public static /* synthetic */ Path resolve$default(Path path, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return path.resolve(str, z10);
    }

    public boolean equals(@l Object r22) {
        return (r22 instanceof Path) && Intrinsics.areEqual(((Path) r22).getBytes(), getBytes());
    }

    @k
    /* renamed from: getBytes$okio, reason: from getter */
    public final ByteString getBytes() {
        return this.bytes;
    }

    @l
    public final Path getRoot() {
        int rootLength = _PathKt.rootLength(this);
        if (rootLength == -1) {
            return null;
        }
        return new Path(getBytes().substring(0, rootLength));
    }

    @k
    public final List<String> getSegments() {
        ArrayList arrayList = new ArrayList();
        int rootLength = _PathKt.rootLength(this);
        if (rootLength == -1) {
            rootLength = 0;
        } else if (rootLength < getBytes().size() && getBytes().getByte(rootLength) == ((byte) 92)) {
            rootLength++;
        }
        int size = getBytes().size();
        int i10 = rootLength;
        while (rootLength < size) {
            if (getBytes().getByte(rootLength) == ((byte) 47) || getBytes().getByte(rootLength) == ((byte) 92)) {
                arrayList.add(getBytes().substring(i10, rootLength));
                i10 = rootLength + 1;
            }
            rootLength++;
        }
        if (i10 < getBytes().size()) {
            arrayList.add(getBytes().substring(i10, getBytes().size()));
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((ByteString) it.next()).utf8());
        }
        return arrayList2;
    }

    @k
    public final List<ByteString> getSegmentsBytes() {
        ArrayList arrayList = new ArrayList();
        int rootLength = _PathKt.rootLength(this);
        if (rootLength == -1) {
            rootLength = 0;
        } else if (rootLength < getBytes().size() && getBytes().getByte(rootLength) == ((byte) 92)) {
            rootLength++;
        }
        int size = getBytes().size();
        int i10 = rootLength;
        while (rootLength < size) {
            if (getBytes().getByte(rootLength) == ((byte) 47) || getBytes().getByte(rootLength) == ((byte) 92)) {
                arrayList.add(getBytes().substring(i10, rootLength));
                i10 = rootLength + 1;
            }
            rootLength++;
        }
        if (i10 < getBytes().size()) {
            arrayList.add(getBytes().substring(i10, getBytes().size()));
        }
        return arrayList;
    }

    public int hashCode() {
        return getBytes().hashCode();
    }

    public final boolean isAbsolute() {
        return _PathKt.rootLength(this) != -1;
    }

    public final boolean isRelative() {
        return _PathKt.rootLength(this) == -1;
    }

    public final boolean isRoot() {
        return _PathKt.rootLength(this) == getBytes().size();
    }

    @k
    @JvmName(name = "name")
    public final String name() {
        return nameBytes().utf8();
    }

    @k
    @JvmName(name = "nameBytes")
    public final ByteString nameBytes() {
        int indexOfLastSlash = _PathKt.getIndexOfLastSlash(this);
        return indexOfLastSlash != -1 ? ByteString.substring$default(getBytes(), indexOfLastSlash + 1, 0, 2, null) : (volumeLetter() == null || getBytes().size() != 2) ? getBytes() : ByteString.EMPTY;
    }

    @k
    public final Path normalized() {
        return INSTANCE.get(toString(), true);
    }

    @l
    @JvmName(name = "parent")
    public final Path parent() {
        Path path;
        if (Intrinsics.areEqual(getBytes(), _PathKt.DOT) || Intrinsics.areEqual(getBytes(), _PathKt.SLASH) || Intrinsics.areEqual(getBytes(), _PathKt.BACKSLASH) || _PathKt.lastSegmentIsDotDot(this)) {
            return null;
        }
        int indexOfLastSlash = _PathKt.getIndexOfLastSlash(this);
        if (indexOfLastSlash != 2 || volumeLetter() == null) {
            if (indexOfLastSlash == 1 && getBytes().startsWith(_PathKt.BACKSLASH)) {
                return null;
            }
            if (indexOfLastSlash != -1 || volumeLetter() == null) {
                if (indexOfLastSlash == -1) {
                    return new Path(_PathKt.DOT);
                }
                if (indexOfLastSlash != 0) {
                    return new Path(ByteString.substring$default(getBytes(), 0, indexOfLastSlash, 1, null));
                }
                path = new Path(ByteString.substring$default(getBytes(), 0, 1, 1, null));
            } else {
                if (getBytes().size() == 2) {
                    return null;
                }
                path = new Path(ByteString.substring$default(getBytes(), 0, 2, 1, null));
            }
        } else {
            if (getBytes().size() == 3) {
                return null;
            }
            path = new Path(ByteString.substring$default(getBytes(), 0, 3, 1, null));
        }
        return path;
    }

    @k
    public final Path relativeTo(@k Path r92) {
        Intrinsics.checkNotNullParameter(r92, "other");
        if (!Intrinsics.areEqual(getRoot(), r92.getRoot())) {
            throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + this + " and " + r92).toString());
        }
        List<ByteString> segmentsBytes = getSegmentsBytes();
        List<ByteString> segmentsBytes2 = r92.getSegmentsBytes();
        int min = Math.min(segmentsBytes.size(), segmentsBytes2.size());
        int i10 = 0;
        while (i10 < min && Intrinsics.areEqual(segmentsBytes.get(i10), segmentsBytes2.get(i10))) {
            i10++;
        }
        if (i10 == min && getBytes().size() == r92.getBytes().size()) {
            return Companion.get$default(INSTANCE, b.f29697h, false, 1, (Object) null);
        }
        if (segmentsBytes2.subList(i10, segmentsBytes2.size()).indexOf(_PathKt.DOT_DOT) != -1) {
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + this + " and " + r92).toString());
        }
        Buffer buffer = new Buffer();
        ByteString slash = _PathKt.getSlash(r92);
        if (slash == null && (slash = _PathKt.getSlash(this)) == null) {
            slash = _PathKt.toSlash(DIRECTORY_SEPARATOR);
        }
        int size = segmentsBytes2.size();
        for (int i11 = i10; i11 < size; i11++) {
            buffer.write(_PathKt.DOT_DOT);
            buffer.write(slash);
        }
        int size2 = segmentsBytes.size();
        while (i10 < size2) {
            buffer.write(segmentsBytes.get(i10));
            buffer.write(slash);
            i10++;
        }
        return _PathKt.toPath(buffer, false);
    }

    @k
    @JvmName(name = "resolve")
    public final Path resolve(@k Path child) {
        Intrinsics.checkNotNullParameter(child, "child");
        return _PathKt.commonResolve(this, child, false);
    }

    @k
    public final File toFile() {
        return new File(toString());
    }

    @k
    @IgnoreJRERequirement
    public final java.nio.file.Path toNioPath() {
        java.nio.file.Path path;
        path = Paths.get(toString(), new String[0]);
        Intrinsics.checkNotNullExpressionValue(path, "get(toString())");
        return path;
    }

    @k
    public String toString() {
        return getBytes().utf8();
    }

    @l
    @JvmName(name = "volumeLetter")
    public final Character volumeLetter() {
        if (ByteString.indexOf$default(getBytes(), _PathKt.SLASH, 0, 2, (Object) null) != -1 || getBytes().size() < 2 || getBytes().getByte(1) != ((byte) 58)) {
            return null;
        }
        char c10 = (char) getBytes().getByte(0);
        if (('a' > c10 || c10 >= '{') && ('A' > c10 || c10 >= '[')) {
            return null;
        }
        return Character.valueOf(c10);
    }

    @JvmStatic
    @k
    @JvmName(name = MonitorConstants.CONNECT_TYPE_GET)
    @JvmOverloads
    public static final Path get(@k File file, boolean z10) {
        return INSTANCE.get(file, z10);
    }

    public static /* synthetic */ Path resolve$default(Path path, ByteString byteString, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return path.resolve(byteString, z10);
    }

    @Override // java.lang.Comparable
    public int compareTo(@k Path r22) {
        Intrinsics.checkNotNullParameter(r22, "other");
        return getBytes().compareTo(r22.getBytes());
    }

    @k
    public final Path resolve(@k Path child, boolean normalize) {
        Intrinsics.checkNotNullParameter(child, "child");
        return _PathKt.commonResolve(this, child, normalize);
    }

    @JvmStatic
    @k
    @JvmName(name = MonitorConstants.CONNECT_TYPE_GET)
    @JvmOverloads
    public static final Path get(@k String str) {
        return INSTANCE.get(str);
    }

    public static /* synthetic */ Path resolve$default(Path path, Path path2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return path.resolve(path2, z10);
    }

    @k
    @JvmName(name = "resolve")
    public final Path resolve(@k String child) {
        Intrinsics.checkNotNullParameter(child, "child");
        return _PathKt.commonResolve(this, _PathKt.toPath(new Buffer().writeUtf8(child), false), false);
    }

    @JvmStatic
    @k
    @JvmName(name = MonitorConstants.CONNECT_TYPE_GET)
    @JvmOverloads
    public static final Path get(@k String str, boolean z10) {
        return INSTANCE.get(str, z10);
    }

    @JvmStatic
    @k
    @JvmName(name = MonitorConstants.CONNECT_TYPE_GET)
    @IgnoreJRERequirement
    @JvmOverloads
    public static final Path get(@k java.nio.file.Path path) {
        return INSTANCE.get(path);
    }

    @k
    @JvmName(name = "resolve")
    public final Path resolve(@k ByteString child) {
        Intrinsics.checkNotNullParameter(child, "child");
        return _PathKt.commonResolve(this, _PathKt.toPath(new Buffer().write(child), false), false);
    }

    @JvmStatic
    @k
    @JvmName(name = MonitorConstants.CONNECT_TYPE_GET)
    @IgnoreJRERequirement
    @JvmOverloads
    public static final Path get(@k java.nio.file.Path path, boolean z10) {
        return INSTANCE.get(path, z10);
    }

    @k
    public final Path resolve(@k String child, boolean normalize) {
        Intrinsics.checkNotNullParameter(child, "child");
        return _PathKt.commonResolve(this, _PathKt.toPath(new Buffer().writeUtf8(child), false), normalize);
    }

    @k
    public final Path resolve(@k ByteString child, boolean normalize) {
        Intrinsics.checkNotNullParameter(child, "child");
        return _PathKt.commonResolve(this, _PathKt.toPath(new Buffer().write(child), false), normalize);
    }
}
