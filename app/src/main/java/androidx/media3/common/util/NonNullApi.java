package androidx.media3.common.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.Nonnull;
import javax.annotation.meta.TypeQualifierDefault;
import kotlin.annotations.jvm.MigrationStatus;
import kotlin.annotations.jvm.UnderMigration;

@TypeQualifierDefault({ElementType.TYPE_USE})
@Nonnull
@UnderMigration(status = MigrationStatus.STRICT)
@Retention(RetentionPolicy.CLASS)
@UnstableApi
/* loaded from: classes.dex */
public @interface NonNullApi {
}
