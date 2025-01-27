package kotlin.reflect;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.tencent.open.SocialConstants;
import f.b.a.d;
import f.b.a.e;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\b\u0012\u0004\u0012\u00028\u00010\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004:\u0001\u000eJ\u0017\u0010\u0006\u001a\u00028\u00012\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00028\u0000H'¢\u0006\u0004\b\t\u0010\u0007R\"\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lkotlin/reflect/KProperty1;", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlin/reflect/KProperty;", "Lkotlin/Function1;", SocialConstants.PARAM_RECEIVER, MonitorConstants.CONNECT_TYPE_GET, "(Ljava/lang/Object;)Ljava/lang/Object;", "", "getDelegate", "Lkotlin/reflect/KProperty1$Getter;", "getGetter", "()Lkotlin/reflect/KProperty1$Getter;", "getter", "Getter", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public interface KProperty1<T, R> extends KProperty<R>, Function1<T, R> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0006\b\u0003\u0010\u0002 \u00012\b\u0012\u0004\u0012\u00028\u00030\u00032\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/reflect/KProperty1$Getter;", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlin/reflect/KProperty$Getter;", "Lkotlin/Function1;", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
    public interface Getter<T, R> extends KProperty.Getter<R>, Function1<T, R> {
    }

    R get(T t);

    @e
    @SinceKotlin(version = "1.1")
    Object getDelegate(T r1);

    @Override // kotlin.reflect.KProperty
    @d
    Getter<T, R> getGetter();
}
