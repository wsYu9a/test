package androidx.media3.session;

import android.os.Bundle;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.media3.common.Bundleable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.session.CommandButton;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* loaded from: classes.dex */
public final class CommandButton implements Bundleable {
    public final CharSequence displayName;

    @UnstableApi
    public final Bundle extras;

    @DrawableRes
    public final int iconResId;
    public final boolean isEnabled;
    public final int playerCommand;

    @Nullable
    public final SessionCommand sessionCommand;
    private static final String FIELD_SESSION_COMMAND = Util.intToStringMaxRadix(0);
    private static final String FIELD_PLAYER_COMMAND = Util.intToStringMaxRadix(1);
    private static final String FIELD_ICON_RES_ID = Util.intToStringMaxRadix(2);
    private static final String FIELD_DISPLAY_NAME = Util.intToStringMaxRadix(3);
    private static final String FIELD_EXTRAS = Util.intToStringMaxRadix(4);
    private static final String FIELD_ENABLED = Util.intToStringMaxRadix(5);

    @UnstableApi
    public static final Bundleable.Creator<CommandButton> CREATOR = new Bundleable.Creator() { // from class: p0.a
        @Override // androidx.media3.common.Bundleable.Creator
        public final Bundleable fromBundle(Bundle bundle) {
            CommandButton fromBundle;
            fromBundle = CommandButton.fromBundle(bundle);
            return fromBundle;
        }
    };

    public static final class Builder {
        private boolean enabled;

        @DrawableRes
        private int iconResId;

        @Nullable
        private SessionCommand sessionCommand;
        private CharSequence displayName = "";
        private Bundle extras = Bundle.EMPTY;
        private int playerCommand = -1;

        public CommandButton build() {
            return new CommandButton(this.sessionCommand, this.playerCommand, this.iconResId, this.displayName, this.extras, this.enabled);
        }

        @CanIgnoreReturnValue
        public Builder setDisplayName(CharSequence charSequence) {
            this.displayName = charSequence;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setEnabled(boolean z10) {
            this.enabled = z10;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setExtras(Bundle bundle) {
            this.extras = new Bundle(bundle);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setIconResId(@DrawableRes int i10) {
            this.iconResId = i10;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setPlayerCommand(int i10) {
            Assertions.checkArgument(this.sessionCommand == null, "sessionCommand is already set. Only one of sessionCommand and playerCommand should be set.");
            this.playerCommand = i10;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setSessionCommand(SessionCommand sessionCommand) {
            Assertions.checkNotNull(sessionCommand, "sessionCommand should not be null.");
            Assertions.checkArgument(this.playerCommand == -1, "playerCommands is already set. Only one of sessionCommand and playerCommand should be set.");
            this.sessionCommand = sessionCommand;
            return this;
        }
    }

    public /* synthetic */ CommandButton(SessionCommand sessionCommand, int i10, int i11, CharSequence charSequence, Bundle bundle, boolean z10, AnonymousClass1 anonymousClass1) {
        this(sessionCommand, i10, i11, charSequence, bundle, z10);
    }

    public static CommandButton fromBundle(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(FIELD_SESSION_COMMAND);
        SessionCommand fromBundle = bundle2 == null ? null : SessionCommand.CREATOR.fromBundle(bundle2);
        int i10 = bundle.getInt(FIELD_PLAYER_COMMAND, -1);
        int i11 = bundle.getInt(FIELD_ICON_RES_ID, 0);
        CharSequence charSequence = bundle.getCharSequence(FIELD_DISPLAY_NAME, "");
        Bundle bundle3 = bundle.getBundle(FIELD_EXTRAS);
        boolean z10 = bundle.getBoolean(FIELD_ENABLED, false);
        Builder builder = new Builder();
        if (fromBundle != null) {
            builder.setSessionCommand(fromBundle);
        }
        if (i10 != -1) {
            builder.setPlayerCommand(i10);
        }
        Builder displayName = builder.setIconResId(i11).setDisplayName(charSequence);
        if (bundle3 == null) {
            bundle3 = Bundle.EMPTY;
        }
        return displayName.setExtras(bundle3).setEnabled(z10).build();
    }

    @Override // androidx.media3.common.Bundleable
    @UnstableApi
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        SessionCommand sessionCommand = this.sessionCommand;
        if (sessionCommand != null) {
            bundle.putBundle(FIELD_SESSION_COMMAND, sessionCommand.toBundle());
        }
        bundle.putInt(FIELD_PLAYER_COMMAND, this.playerCommand);
        bundle.putInt(FIELD_ICON_RES_ID, this.iconResId);
        bundle.putCharSequence(FIELD_DISPLAY_NAME, this.displayName);
        bundle.putBundle(FIELD_EXTRAS, this.extras);
        bundle.putBoolean(FIELD_ENABLED, this.isEnabled);
        return bundle;
    }

    private CommandButton(@Nullable SessionCommand sessionCommand, int i10, @DrawableRes int i11, CharSequence charSequence, Bundle bundle, boolean z10) {
        this.sessionCommand = sessionCommand;
        this.playerCommand = i10;
        this.iconResId = i11;
        this.displayName = charSequence;
        this.extras = new Bundle(bundle);
        this.isEnabled = z10;
    }
}
