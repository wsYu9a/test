package kotlin.io.path;

import kotlin.Metadata;
import xi.k;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lkotlin/io/path/DefaultCopyActionContext;", "Lkotlin/io/path/CopyActionContext;", "()V", "copyToIgnoringExistingDirectory", "Lkotlin/io/path/CopyActionResult;", "Ljava/nio/file/Path;", "target", "followLinks", "", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 9, 0}, xi = 48)
@ExperimentalPathApi
/* loaded from: classes4.dex */
final class DefaultCopyActionContext implements CopyActionContext {

    @k
    public static final DefaultCopyActionContext INSTANCE = new DefaultCopyActionContext();

    private DefaultCopyActionContext() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0038, code lost:
    
        if (r0 == false) goto L24;
     */
    @Override // kotlin.io.path.CopyActionContext
    @xi.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public kotlin.io.path.CopyActionResult copyToIgnoringExistingDirectory(@xi.k java.nio.file.Path r5, @xi.k java.nio.file.Path r6, boolean r7) {
        /*
            r4 = this;
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "target"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            kotlin.io.path.LinkFollowing r0 = kotlin.io.path.LinkFollowing.INSTANCE
            java.nio.file.LinkOption[] r7 = r0.toLinkOptions(r7)
            int r0 = r7.length
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r7, r0)
            java.nio.file.LinkOption[] r0 = (java.nio.file.LinkOption[]) r0
            int r1 = r0.length
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r1)
            java.nio.file.LinkOption[] r0 = (java.nio.file.LinkOption[]) r0
            boolean r0 = zh.a.a(r5, r0)
            if (r0 == 0) goto L3a
            r0 = 1
            java.nio.file.LinkOption[] r1 = new java.nio.file.LinkOption[r0]
            r2 = 0
            java.nio.file.LinkOption r3 = zh.b.a()
            r1[r2] = r3
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r1, r0)
            java.nio.file.LinkOption[] r0 = (java.nio.file.LinkOption[]) r0
            boolean r0 = zh.a.a(r6, r0)
            if (r0 != 0) goto L51
        L3a:
            int r0 = r7.length
            java.lang.Object[] r7 = java.util.Arrays.copyOf(r7, r0)
            java.nio.file.CopyOption[] r7 = (java.nio.file.CopyOption[]) r7
            int r0 = r7.length
            java.lang.Object[] r7 = java.util.Arrays.copyOf(r7, r0)
            java.nio.file.CopyOption[] r7 = (java.nio.file.CopyOption[]) r7
            java.nio.file.Path r5 = zh.c.a(r5, r6, r7)
            java.lang.String r6 = "copy(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
        L51:
            kotlin.io.path.CopyActionResult r5 = kotlin.io.path.CopyActionResult.CONTINUE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.DefaultCopyActionContext.copyToIgnoringExistingDirectory(java.nio.file.Path, java.nio.file.Path, boolean):kotlin.io.path.CopyActionResult");
    }
}
