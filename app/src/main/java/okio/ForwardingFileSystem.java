package okio;

import c7.g;
import com.sigmob.sdk.base.k;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import t8.a;
import xi.l;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00172\u0006\u0010\u0012\u001a\u00020\bH\u0016J\u0018\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\bH\u0016J\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001a2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\nH\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0010\u001a\u00020\bH\u0016J \u0010\u001e\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0016J\u0018\u0010\"\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u0007\u001a\u00020\bH\u0016J \u0010%\u001a\u00020$2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010&\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020'2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010(\u001a\u00020 H\u0016R\u0013\u0010\u0002\u001a\u00020\u00018\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0004¨\u0006)"}, d2 = {"Lokio/ForwardingFileSystem;", "Lokio/FileSystem;", "delegate", "(Lokio/FileSystem;)V", "()Lokio/FileSystem;", "appendingSink", "Lokio/Sink;", k.f18193y, "Lokio/Path;", "mustExist", "", "atomicMove", "", "source", "target", "canonicalize", a.f30751f, "createDirectory", "dir", "mustCreate", "createSymlink", "delete", g.f1745c, "", "listOrNull", "listRecursively", "Lkotlin/sequences/Sequence;", "followSymlinks", "metadataOrNull", "Lokio/FileMetadata;", "onPathParameter", "functionName", "", "parameterName", "onPathResult", "openReadOnly", "Lokio/FileHandle;", "openReadWrite", "sink", "Lokio/Source;", "toString", "okio"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class ForwardingFileSystem extends FileSystem {

    @xi.k
    private final FileSystem delegate;

    public ForwardingFileSystem(@xi.k FileSystem delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // okio.FileSystem
    @xi.k
    public Sink appendingSink(@xi.k Path r32, boolean mustExist) throws IOException {
        Intrinsics.checkNotNullParameter(r32, "file");
        return this.delegate.appendingSink(onPathParameter(r32, "appendingSink", k.f18193y), mustExist);
    }

    @Override // okio.FileSystem
    public void atomicMove(@xi.k Path source, @xi.k Path target) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        this.delegate.atomicMove(onPathParameter(source, "atomicMove", "source"), onPathParameter(target, "atomicMove", "target"));
    }

    @Override // okio.FileSystem
    @xi.k
    public Path canonicalize(@xi.k Path r32) throws IOException {
        Intrinsics.checkNotNullParameter(r32, "path");
        return onPathResult(this.delegate.canonicalize(onPathParameter(r32, "canonicalize", a.f30751f)), "canonicalize");
    }

    @Override // okio.FileSystem
    public void createDirectory(@xi.k Path dir, boolean mustCreate) throws IOException {
        Intrinsics.checkNotNullParameter(dir, "dir");
        this.delegate.createDirectory(onPathParameter(dir, "createDirectory", "dir"), mustCreate);
    }

    @Override // okio.FileSystem
    public void createSymlink(@xi.k Path source, @xi.k Path target) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        this.delegate.createSymlink(onPathParameter(source, "createSymlink", "source"), onPathParameter(target, "createSymlink", "target"));
    }

    @xi.k
    @JvmName(name = "delegate")
    /* renamed from: delegate, reason: from getter */
    public final FileSystem getDelegate() {
        return this.delegate;
    }

    @Override // okio.FileSystem
    public void delete(@xi.k Path r32, boolean mustExist) throws IOException {
        Intrinsics.checkNotNullParameter(r32, "path");
        this.delegate.delete(onPathParameter(r32, "delete", a.f30751f), mustExist);
    }

    @Override // okio.FileSystem
    @xi.k
    public List<Path> list(@xi.k Path dir) throws IOException {
        Intrinsics.checkNotNullParameter(dir, "dir");
        List<Path> list = this.delegate.list(onPathParameter(dir, g.f1745c, "dir"));
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(onPathResult((Path) it.next(), g.f1745c));
        }
        CollectionsKt.sort(arrayList);
        return arrayList;
    }

    @Override // okio.FileSystem
    @l
    public List<Path> listOrNull(@xi.k Path dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        List<Path> listOrNull = this.delegate.listOrNull(onPathParameter(dir, "listOrNull", "dir"));
        if (listOrNull == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listOrNull.iterator();
        while (it.hasNext()) {
            arrayList.add(onPathResult((Path) it.next(), "listOrNull"));
        }
        CollectionsKt.sort(arrayList);
        return arrayList;
    }

    @Override // okio.FileSystem
    @xi.k
    public Sequence<Path> listRecursively(@xi.k Path dir, boolean followSymlinks) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        return SequencesKt.map(this.delegate.listRecursively(onPathParameter(dir, "listRecursively", "dir"), followSymlinks), new Function1<Path, Path>() { // from class: okio.ForwardingFileSystem$listRecursively$1
            public ForwardingFileSystem$listRecursively$1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @xi.k
            public final Path invoke(@xi.k Path it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return ForwardingFileSystem.this.onPathResult(it, "listRecursively");
            }
        });
    }

    @Override // okio.FileSystem
    @l
    public FileMetadata metadataOrNull(@xi.k Path r14) throws IOException {
        FileMetadata copy;
        Intrinsics.checkNotNullParameter(r14, "path");
        FileMetadata metadataOrNull = this.delegate.metadataOrNull(onPathParameter(r14, "metadataOrNull", a.f30751f));
        if (metadataOrNull == null) {
            return null;
        }
        if (metadataOrNull.getSymlinkTarget() == null) {
            return metadataOrNull;
        }
        copy = metadataOrNull.copy((r18 & 1) != 0 ? metadataOrNull.isRegularFile : false, (r18 & 2) != 0 ? metadataOrNull.isDirectory : false, (r18 & 4) != 0 ? metadataOrNull.symlinkTarget : onPathResult(metadataOrNull.getSymlinkTarget(), "metadataOrNull"), (r18 & 8) != 0 ? metadataOrNull.size : null, (r18 & 16) != 0 ? metadataOrNull.createdAtMillis : null, (r18 & 32) != 0 ? metadataOrNull.lastModifiedAtMillis : null, (r18 & 64) != 0 ? metadataOrNull.lastAccessedAtMillis : null, (r18 & 128) != 0 ? metadataOrNull.extras : null);
        return copy;
    }

    @xi.k
    public Path onPathParameter(@xi.k Path r22, @xi.k String functionName, @xi.k String parameterName) {
        Intrinsics.checkNotNullParameter(r22, "path");
        Intrinsics.checkNotNullParameter(functionName, "functionName");
        Intrinsics.checkNotNullParameter(parameterName, "parameterName");
        return r22;
    }

    @xi.k
    public Path onPathResult(@xi.k Path r22, @xi.k String functionName) {
        Intrinsics.checkNotNullParameter(r22, "path");
        Intrinsics.checkNotNullParameter(functionName, "functionName");
        return r22;
    }

    @Override // okio.FileSystem
    @xi.k
    public FileHandle openReadOnly(@xi.k Path r32) throws IOException {
        Intrinsics.checkNotNullParameter(r32, "file");
        return this.delegate.openReadOnly(onPathParameter(r32, "openReadOnly", k.f18193y));
    }

    @Override // okio.FileSystem
    @xi.k
    public FileHandle openReadWrite(@xi.k Path r32, boolean mustCreate, boolean mustExist) throws IOException {
        Intrinsics.checkNotNullParameter(r32, "file");
        return this.delegate.openReadWrite(onPathParameter(r32, "openReadWrite", k.f18193y), mustCreate, mustExist);
    }

    @Override // okio.FileSystem
    @xi.k
    public Sink sink(@xi.k Path r32, boolean mustCreate) throws IOException {
        Intrinsics.checkNotNullParameter(r32, "file");
        return this.delegate.sink(onPathParameter(r32, "sink", k.f18193y), mustCreate);
    }

    @Override // okio.FileSystem
    @xi.k
    public Source source(@xi.k Path r32) throws IOException {
        Intrinsics.checkNotNullParameter(r32, "file");
        return this.delegate.source(onPathParameter(r32, "source", k.f18193y));
    }

    @xi.k
    public String toString() {
        return Reflection.getOrCreateKotlinClass(getClass()).getSimpleName() + '(' + this.delegate + ')';
    }
}
