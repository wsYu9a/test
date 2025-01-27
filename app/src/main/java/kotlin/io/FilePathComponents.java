package kotlin.io;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.cdo.oaps.ad.OapsKey;
import com.kwad.sdk.api.model.AdnName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import f.b.a.d;
import f.b.a.e;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\n¢\u0006\u0004\b$\u0010%J\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ*\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00052\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\nHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0013\u0010\u001b\u001a\u00020\u00118F@\u0006¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0013R\u0013\u0010\u001d\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0015R\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b\u001f\u0010\fR\u0013\u0010 \u001a\u00020\u00178F@\u0006¢\u0006\u0006\u001a\u0004\b \u0010!R\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\"\u001a\u0004\b#\u0010\t¨\u0006&"}, d2 = {"Lkotlin/io/FilePathComponents;", "", "", "beginIndex", "endIndex", "Ljava/io/File;", "subPath", "(II)Ljava/io/File;", "component1", "()Ljava/io/File;", "", "component2", "()Ljava/util/List;", "root", DBDefinition.SEGMENT_TABLE_NAME, "copy", "(Ljava/io/File;Ljava/util/List;)Lkotlin/io/FilePathComponents;", "", "toString", "()Ljava/lang/String;", TTDownloadField.TT_HASHCODE, "()I", AdnName.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "getRootName", "rootName", "getSize", OapsKey.KEY_SIZE, "Ljava/util/List;", "getSegments", "isRooted", "()Z", "Ljava/io/File;", "getRoot", "<init>", "(Ljava/io/File;Ljava/util/List;)V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final /* data */ class FilePathComponents {

    @d
    private final File root;

    @d
    private final List<File> segments;

    /* JADX WARN: Multi-variable type inference failed */
    public FilePathComponents(@d File root, @d List<? extends File> segments) {
        Intrinsics.checkParameterIsNotNull(root, "root");
        Intrinsics.checkParameterIsNotNull(segments, "segments");
        this.root = root;
        this.segments = segments;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FilePathComponents copy$default(FilePathComponents filePathComponents, File file, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            file = filePathComponents.root;
        }
        if ((i2 & 2) != 0) {
            list = filePathComponents.segments;
        }
        return filePathComponents.copy(file, list);
    }

    @d
    /* renamed from: component1, reason: from getter */
    public final File getRoot() {
        return this.root;
    }

    @d
    public final List<File> component2() {
        return this.segments;
    }

    @d
    public final FilePathComponents copy(@d File root, @d List<? extends File> r3) {
        Intrinsics.checkParameterIsNotNull(root, "root");
        Intrinsics.checkParameterIsNotNull(r3, "segments");
        return new FilePathComponents(root, r3);
    }

    public boolean equals(@e Object r3) {
        if (this == r3) {
            return true;
        }
        if (!(r3 instanceof FilePathComponents)) {
            return false;
        }
        FilePathComponents filePathComponents = (FilePathComponents) r3;
        return Intrinsics.areEqual(this.root, filePathComponents.root) && Intrinsics.areEqual(this.segments, filePathComponents.segments);
    }

    @d
    public final File getRoot() {
        return this.root;
    }

    @d
    public final String getRootName() {
        String path = this.root.getPath();
        Intrinsics.checkExpressionValueIsNotNull(path, "root.path");
        return path;
    }

    @d
    public final List<File> getSegments() {
        return this.segments;
    }

    public final int getSize() {
        return this.segments.size();
    }

    public int hashCode() {
        File file = this.root;
        int hashCode = (file != null ? file.hashCode() : 0) * 31;
        List<File> list = this.segments;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    public final boolean isRooted() {
        String path = this.root.getPath();
        Intrinsics.checkExpressionValueIsNotNull(path, "root.path");
        return path.length() > 0;
    }

    @d
    public final File subPath(int beginIndex, int endIndex) {
        if (beginIndex < 0 || beginIndex > endIndex || endIndex > getSize()) {
            throw new IllegalArgumentException();
        }
        List<File> subList = this.segments.subList(beginIndex, endIndex);
        String str = File.separator;
        Intrinsics.checkExpressionValueIsNotNull(str, "File.separator");
        return new File(CollectionsKt___CollectionsKt.joinToString$default(subList, str, null, null, 0, null, null, 62, null));
    }

    @d
    public String toString() {
        return "FilePathComponents(root=" + this.root + ", segments=" + this.segments + ")";
    }
}
