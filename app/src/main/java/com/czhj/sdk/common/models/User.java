package com.czhj.sdk.common.models;

import android.os.Parcelable;
import com.czhj.wire.AndroidMessage;
import com.czhj.wire.FieldEncoding;
import com.czhj.wire.Message;
import com.czhj.wire.ProtoAdapter;
import com.czhj.wire.ProtoReader;
import com.czhj.wire.ProtoWriter;
import com.czhj.wire.WireField;
import com.czhj.wire.internal.Internal;
import com.czhj.wire.okio.ByteString;
import java.io.IOException;
import java.util.List;

/* loaded from: classes2.dex */
public final class User extends AndroidMessage<User, Builder> {
    public static final ProtoAdapter<User> ADAPTER;
    public static final Parcelable.Creator<User> CREATOR;
    public static final Boolean DEFAULT_CHANGE_RECOMMENDATION_STATE;
    public static final Boolean DEFAULT_DISABLE_PERSONALIZED_RECOMMENDATION;
    public static final String DEFAULT_GENDER = "";
    public static final Boolean DEFAULT_IS_MINOR;
    public static final Integer DEFAULT_YOB;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 3)
    public final List<String> app_list;

    @WireField(adapter = "Version#ADAPTER", tag = 5)
    public final Version app_market_version;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 9)
    public final Boolean change_recommendation_state;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 8)
    public final Boolean disable_personalized_recommendation;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String gender;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 7)
    public final Boolean is_minor;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 4)
    public final List<String> user_strategy;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 1)
    public final Integer yob;

    public static final class Builder extends Message.Builder<User, Builder> {
        public Version app_market_version;
        public Integer yob = User.DEFAULT_YOB;
        public String gender = "";
        public Boolean is_minor = User.DEFAULT_IS_MINOR;
        public Boolean disable_personalized_recommendation = User.DEFAULT_DISABLE_PERSONALIZED_RECOMMENDATION;
        public Boolean change_recommendation_state = User.DEFAULT_CHANGE_RECOMMENDATION_STATE;
        public List<String> app_list = Internal.newMutableList();
        public List<String> user_strategy = Internal.newMutableList();

        public Builder app_list(List<String> list) {
            Internal.checkElementsNotNull(list);
            this.app_list = list;
            return this;
        }

        public Builder app_market_version(Version version) {
            this.app_market_version = version;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public User build() {
            return new User(this.yob, this.gender, this.app_list, this.user_strategy, this.app_market_version, this.is_minor, this.disable_personalized_recommendation, this.change_recommendation_state, super.buildUnknownFields());
        }

        public Builder change_recommendation_state(Boolean bool) {
            this.change_recommendation_state = bool;
            return this;
        }

        public Builder disable_personalized_recommendation(Boolean bool) {
            this.disable_personalized_recommendation = bool;
            return this;
        }

        public Builder gender(String str) {
            this.gender = str;
            return this;
        }

        public Builder is_minor(Boolean bool) {
            this.is_minor = bool;
            return this;
        }

        public Builder user_strategy(List<String> list) {
            Internal.checkElementsNotNull(list);
            this.user_strategy = list;
            return this;
        }

        public Builder yob(Integer num) {
            this.yob = num;
            return this;
        }
    }

    public static final class ProtoAdapter_User extends ProtoAdapter<User> {
        public ProtoAdapter_User() {
            super(FieldEncoding.LENGTH_DELIMITED, User.class);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public User decode(ProtoReader protoReader) throws IOException {
            List<String> list;
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                switch (nextTag) {
                    case 1:
                        builder.yob(ProtoAdapter.UINT32.decode(protoReader));
                        continue;
                    case 2:
                        builder.gender(ProtoAdapter.STRING.decode(protoReader));
                        continue;
                    case 3:
                        list = builder.app_list;
                        break;
                    case 4:
                        list = builder.user_strategy;
                        break;
                    case 5:
                        builder.app_market_version(Version.ADAPTER.decode(protoReader));
                        continue;
                    case 6:
                    default:
                        FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                        builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                        continue;
                    case 7:
                        builder.is_minor(ProtoAdapter.BOOL.decode(protoReader));
                        continue;
                    case 8:
                        builder.disable_personalized_recommendation(ProtoAdapter.BOOL.decode(protoReader));
                        continue;
                    case 9:
                        builder.change_recommendation_state(ProtoAdapter.BOOL.decode(protoReader));
                        continue;
                }
                list.add(ProtoAdapter.STRING.decode(protoReader));
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, User user) throws IOException {
            ProtoAdapter.UINT32.encodeWithTag(protoWriter, 1, user.yob);
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.encodeWithTag(protoWriter, 2, user.gender);
            protoAdapter.asRepeated().encodeWithTag(protoWriter, 3, user.app_list);
            protoAdapter.asRepeated().encodeWithTag(protoWriter, 4, user.user_strategy);
            Version.ADAPTER.encodeWithTag(protoWriter, 5, user.app_market_version);
            ProtoAdapter<Boolean> protoAdapter2 = ProtoAdapter.BOOL;
            protoAdapter2.encodeWithTag(protoWriter, 7, user.is_minor);
            protoAdapter2.encodeWithTag(protoWriter, 8, user.disable_personalized_recommendation);
            protoAdapter2.encodeWithTag(protoWriter, 9, user.change_recommendation_state);
            protoWriter.writeBytes(user.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(User user) {
            int encodedSizeWithTag = ProtoAdapter.UINT32.encodedSizeWithTag(1, user.yob);
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            int encodedSizeWithTag2 = encodedSizeWithTag + protoAdapter.encodedSizeWithTag(2, user.gender) + protoAdapter.asRepeated().encodedSizeWithTag(3, user.app_list) + protoAdapter.asRepeated().encodedSizeWithTag(4, user.user_strategy) + Version.ADAPTER.encodedSizeWithTag(5, user.app_market_version);
            ProtoAdapter<Boolean> protoAdapter2 = ProtoAdapter.BOOL;
            return encodedSizeWithTag2 + protoAdapter2.encodedSizeWithTag(7, user.is_minor) + protoAdapter2.encodedSizeWithTag(8, user.disable_personalized_recommendation) + protoAdapter2.encodedSizeWithTag(9, user.change_recommendation_state) + user.unknownFields().size();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public User redact(User user) {
            Builder newBuilder = user.newBuilder();
            Version version = newBuilder.app_market_version;
            if (version != null) {
                newBuilder.app_market_version = Version.ADAPTER.redact(version);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_User protoAdapter_User = new ProtoAdapter_User();
        ADAPTER = protoAdapter_User;
        CREATOR = AndroidMessage.newCreator(protoAdapter_User);
        DEFAULT_YOB = 0;
        Boolean bool = Boolean.FALSE;
        DEFAULT_IS_MINOR = bool;
        DEFAULT_DISABLE_PERSONALIZED_RECOMMENDATION = bool;
        DEFAULT_CHANGE_RECOMMENDATION_STATE = bool;
    }

    public User(Integer num, String str, List<String> list, List<String> list2, Version version, Boolean bool, Boolean bool2, Boolean bool3) {
        this(num, str, list, list2, version, bool, bool2, bool3, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User user = (User) obj;
        return unknownFields().equals(user.unknownFields()) && Internal.equals(this.yob, user.yob) && Internal.equals(this.gender, user.gender) && this.app_list.equals(user.app_list) && this.user_strategy.equals(user.user_strategy) && Internal.equals(this.app_market_version, user.app_market_version) && Internal.equals(this.is_minor, user.is_minor) && Internal.equals(this.disable_personalized_recommendation, user.disable_personalized_recommendation) && Internal.equals(this.change_recommendation_state, user.change_recommendation_state);
    }

    public int hashCode() {
        int i10 = this.hashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Integer num = this.yob;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.gender;
        int hashCode3 = (((((hashCode2 + (str != null ? str.hashCode() : 0)) * 37) + this.app_list.hashCode()) * 37) + this.user_strategy.hashCode()) * 37;
        Version version = this.app_market_version;
        int hashCode4 = (hashCode3 + (version != null ? version.hashCode() : 0)) * 37;
        Boolean bool = this.is_minor;
        int hashCode5 = (hashCode4 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.disable_personalized_recommendation;
        int hashCode6 = (hashCode5 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Boolean bool3 = this.change_recommendation_state;
        int hashCode7 = hashCode6 + (bool3 != null ? bool3.hashCode() : 0);
        this.hashCode = hashCode7;
        return hashCode7;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.yob = this.yob;
        builder.gender = this.gender;
        builder.app_list = Internal.copyOf("app_list", this.app_list);
        builder.user_strategy = Internal.copyOf("user_strategy", this.user_strategy);
        builder.app_market_version = this.app_market_version;
        builder.is_minor = this.is_minor;
        builder.disable_personalized_recommendation = this.disable_personalized_recommendation;
        builder.change_recommendation_state = this.change_recommendation_state;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.yob != null) {
            sb2.append(", yob=");
            sb2.append(this.yob);
        }
        if (this.gender != null) {
            sb2.append(", gender=");
            sb2.append(this.gender);
        }
        if (!this.app_list.isEmpty()) {
            sb2.append(", app_list=");
            sb2.append(this.app_list);
        }
        if (!this.user_strategy.isEmpty()) {
            sb2.append(", user_strategy=");
            sb2.append(this.user_strategy);
        }
        if (this.app_market_version != null) {
            sb2.append(", app_market_version=");
            sb2.append(this.app_market_version);
        }
        if (this.is_minor != null) {
            sb2.append(", is_minor=");
            sb2.append(this.is_minor);
        }
        if (this.disable_personalized_recommendation != null) {
            sb2.append(", disable_personalized_recommendation=");
            sb2.append(this.disable_personalized_recommendation);
        }
        if (this.change_recommendation_state != null) {
            sb2.append(", change_recommendation_state=");
            sb2.append(this.change_recommendation_state);
        }
        StringBuilder replace = sb2.replace(0, 2, "User{");
        replace.append('}');
        return replace.toString();
    }

    public User(Integer num, String str, List<String> list, List<String> list2, Version version, Boolean bool, Boolean bool2, Boolean bool3, ByteString byteString) {
        super(ADAPTER, byteString);
        this.yob = num;
        this.gender = str;
        this.app_list = Internal.immutableCopyOf("app_list", list);
        this.user_strategy = Internal.immutableCopyOf("user_strategy", list2);
        this.app_market_version = version;
        this.is_minor = bool;
        this.disable_personalized_recommendation = bool2;
        this.change_recommendation_state = bool3;
    }
}
