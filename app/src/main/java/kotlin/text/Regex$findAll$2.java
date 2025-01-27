package kotlin.text;

import com.cdo.oaps.ad.Launcher;
import f.b.a.d;
import f.b.a.e;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlin/text/MatchResult;", "p1", Launcher.Method.INVOKE_CALLBACK, "(Lkotlin/text/MatchResult;)Lkotlin/text/MatchResult;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes5.dex */
final /* synthetic */ class Regex$findAll$2 extends FunctionReference implements Function1<MatchResult, MatchResult> {
    public static final Regex$findAll$2 INSTANCE = new Regex$findAll$2();

    Regex$findAll$2() {
        super(1);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public final String getName() {
        return "next";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(MatchResult.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "next()Lkotlin/text/MatchResult;";
    }

    @Override // kotlin.jvm.functions.Function1
    @e
    public final MatchResult invoke(@d MatchResult p1) {
        Intrinsics.checkParameterIsNotNull(p1, "p1");
        return p1.next();
    }
}
