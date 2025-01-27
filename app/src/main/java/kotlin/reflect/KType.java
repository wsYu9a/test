package kotlin.reflect;

import f.b.a.d;
import f.b.a.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.SinceKotlin;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0003\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058&@'X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\f8&@'X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lkotlin/reflect/KType;", "Lkotlin/reflect/KAnnotatedElement;", "", "isMarkedNullable", "()Z", "", "Lkotlin/reflect/KTypeProjection;", "getArguments", "()Ljava/util/List;", "arguments$annotations", "()V", "arguments", "Lkotlin/reflect/KClassifier;", "getClassifier", "()Lkotlin/reflect/KClassifier;", "classifier$annotations", "classifier", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public interface KType extends KAnnotatedElement {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void arguments$annotations() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void classifier$annotations() {
        }
    }

    @d
    List<KTypeProjection> getArguments();

    @e
    KClassifier getClassifier();

    /* renamed from: isMarkedNullable */
    boolean getIsMarkedNullable();
}
