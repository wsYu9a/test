package com.kwad.sdk.utils;

/* loaded from: classes3.dex */
public final class as {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public static int a(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, int i10) {
        ?? r02 = z10;
        if (z11) {
            r02 = (z10 ? 1 : 0) | 2;
        }
        if (z12) {
            r02 = (r02 == true ? 1 : 0) | 4;
        }
        if (z13) {
            r02 = (r02 == true ? 1 : 0) | '\b';
        }
        if (z14) {
            r02 = (r02 == true ? 1 : 0) | 16;
        }
        if (z15) {
            r02 = (r02 == true ? 1 : 0) | b5.a.O;
        }
        return i10 == 2 ? r02 | 64 : r02;
    }
}
