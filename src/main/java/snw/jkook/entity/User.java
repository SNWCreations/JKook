package snw.jkook.entity;

import snw.jkook.command.CommandSender;
import snw.jkook.entity.abilities.AvatarHolder;
import snw.jkook.entity.abilities.Nameable;
import snw.jkook.message.component.BaseComponent;

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
     * Return true if this user has the specified role.
     *
     * @param role Role to check
     */
    default boolean hasRole(Role role) {
        return getRoles().contains(role);
    }

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
}
