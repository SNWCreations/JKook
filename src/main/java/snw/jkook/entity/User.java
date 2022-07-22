/*
 * Copyright 2022 JKook contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
     * Set the nickname of this user in the specified guild. <p>
     * If this object represents the Bot in this VM, then you won't need {@link Permission#CHANGE_OTHERS_NICKNAME}, but you will need {@link Permission#CHANGE_NICKNAME}.
     *
     * @param guild The guild that contains this user
     * @param name The new nickname of this user
     */
    @RequirePermission({Permission.CHANGE_NICKNAME, Permission.CHANGE_OTHERS_NICKNAME})
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
     * Get the roles that this user have. <p>
     * The result is a set of role ID.
     * The result is read-only.
     */
    Collection<Integer> getRoles();

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

    /**
     * Grant the specified role to this user. <p>
     * It is <b>DANGEROUS</b>!
     *
     * @param roleId The role to grant
     */
    @RequirePermission(Permission.ROLE_MANAGE)
    void grantRole(Guild guild, int roleId);

    /**
     * Revoke the specified role that this user have. <p>
     * It is <b>DANGEROUS</b>!
     *
     * @param roleId The role to revoke
     */
    @RequirePermission(Permission.ROLE_MANAGE)
    void revokeRole(Guild guild, int roleId);
}
