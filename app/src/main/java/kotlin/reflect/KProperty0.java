package kotlin.reflect;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import f.b.a.d;
import f.b.a.e;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\fJ\u000f\u0010\u0004\u001a\u00028\u0000H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0006H'¢\u0006\u0004\b\u0007\u0010\u0005R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lkotlin/reflect/KProperty0;", "R", "Lkotlin/reflect/KProperty;", "Lkotlin/Function0;", MonitorConstants.CONNECT_TYPE_GET, "()Ljava/lang/Object;", "", "getDelegate", "Lkotlin/reflect/KProperty0$Getter;", "getGetter", "()Lkotlin/reflect/KProperty0$Getter;", "getter", "Getter", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public interface KProperty0<R> extends KProperty<R>, Function0<R> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/reflect/KProperty0$Getter;", "R", "Lkotlin/reflect/KProperty$Getter;", "Lkotlin/Function0;", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
    public interface Getter<R> extends KProperty.Getter<R>, Function0<R> {
    }

    R get();

    @e
    @SinceKotlin(version = "1.1")
    Object getDelegate();

    @Override // kotlin.reflect.KProperty
    @d
    Getter<R> getGetter();
}
