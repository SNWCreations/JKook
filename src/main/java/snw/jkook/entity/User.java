package snw.jkook.entity;

import org.jetbrains.annotations.Nullable;
import snw.jkook.Permission;
import snw.jkook.command.CommandSender;
import snw.jkook.entity.abilities.AvatarHolder;
import snw.jkook.entity.abilities.Nameable;
import snw.jkook.entity.channel.VoiceChannel;
import snw.jkook.message.component.BaseComponent;
import snw.jkook.util.RequirePermission;

import java.util.Collection;

/**
 * Represents a user.
 */
public interface User extends Nameable, AvatarHolder, CommandSender {

    /**
     * Get the ID of this user.
     */
    String getId();

    /**
     * Get the nickname of this user. <p>
     *
     * @param guild The guild that contains this user
     */
    String getNickName(Guild guild);

    /**
     * Set the nickname of this user in the specified guild.
     *
     * @param guild The guild that contains this user
     * @param name The new nickname of this user
     */
    @RequirePermission(Permission.CHANGE_OTHERS_NICKNAME)
    void setNickName(Guild guild, String name);

    /**
     * Return identify number. It can be changed!
     */
    int getIdentifyNumber();

    /**
     * Return true if this user have "Kook BUFF".
     */
    boolean isVip();

    /**
     * Return true if this user is a Bot.
     */
    boolean isBot();

    /**
     * Return true if this user is online.
     */
    boolean isOnline();

    /**
     * Return true if this user is currently banned by Kook Official.
     */
    boolean isBanned();

    /**
     * Return true if this user's mobile number has verified.
     */
    boolean isMobileVerified();

    /**
     * Get the roles that this user have. <p>
     * The result is read-only.
     */
    Collection<Role> getRoles();

    /**
     * Send a component to this user.
     *
     * @param component The component to send
     */
    void sendPrivateMessage(BaseComponent component);

    /**
     * Get the voice channel that this user joined.
     */
    @Nullable
    VoiceChannel getJoinedVoiceChannel();

    /**
     * Kick the user from the target guild. This <b>CANNOT</b> be undone!
     *
     * @deprecated Use {@link Guild#kick(User)} instead. This method still works but not recommended.
     */
    @RequirePermission(Permission.KICK)
    @Deprecated
    void kick(Guild guild);

    /**
     * Get the intimacy score of this user.
     */
    int getIntimacy();

    /**
     * Set the intimacy score of this user.
     *
     * @param intimacy The intimacy value
     */
    void setIntimacy(int intimacy);

    /**
     * Return true if this user has the specified role.
     *
     * @param role Role to check
     */
    default boolean hasRole(Role role) {
        return getRoles().contains(role);
    }

    /**
     * Grant the specified role to this user. <p>
     * It is <b>DANGEROUS</b>!
     *
     * @param role The role to grant
     */
    @RequirePermission(Permission.ROLE_MANAGE)
    void grantRole(Role role);

    /**
     * Revoke the specified role that this user have. <p>
     * It is <b>DANGEROUS</b>!
     *
     * @param role The role to revoke
     */
    @RequirePermission(Permission.ROLE_MANAGE)
    void revokeRole(Role role);
}
