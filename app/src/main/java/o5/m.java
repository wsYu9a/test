package o5;

import com.google.common.reflect.TypeToken;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotMock;
import java.util.Map;
import javax.annotation.CheckForNull;

@DoNotMock("Use ImmutableTypeToInstanceMap or MutableTypeToInstanceMap")
@d
/* loaded from: classes2.dex */
public interface m<B> extends Map<TypeToken<? extends B>, B> {
    @CheckForNull
    <T extends B> T b(TypeToken<T> typeToken);

    @CanIgnoreReturnValue
    @CheckForNull
    <T extends B> T d(TypeToken<T> typeToken, T t10);

    @CheckForNull
    <T extends B> T getInstance(Class<T> cls);

    @CanIgnoreReturnValue
    @CheckForNull
    <T extends B> T putInstance(Class<T> cls, T t10);
}
