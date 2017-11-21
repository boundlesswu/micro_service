package com.coreos.jetcd;

import com.coreos.jetcd.auth.*;
import com.coreos.jetcd.data.ByteSequence;
import com.coreos.jetcd.internal.impl.CloseableClient;

import java.util.concurrent.CompletableFuture;

/**
 * Interface of auth talking to etcd.
 */
public interface Auth extends CloseableClient {

  /**
   * enables auth of an etcd cluster.
   */
  CompletableFuture<AuthEnableResponse> authEnable();

  /**
   * disables auth of an etcd cluster.
   */
  CompletableFuture<AuthDisableResponse> authDisable();

  /**
   * adds a new user to an etcd cluster.
   */
  CompletableFuture<AuthUserAddResponse> userAdd(ByteSequence user, ByteSequence password);

  /**
   * deletes a user from an etcd cluster.
   */
  CompletableFuture<AuthUserDeleteResponse> userDelete(ByteSequence user);

  /**
   * changes a password of a user.
   */
  CompletableFuture<AuthUserChangePasswordResponse> userChangePassword(ByteSequence user,
                                                                       ByteSequence password);

  /**
   * gets a detailed information of a user.
   */
  CompletableFuture<AuthUserGetResponse> userGet(ByteSequence user);

  /**
   * gets a list of all users.
   */
  CompletableFuture<AuthUserListResponse> userList();

  /**
   * grants a role to a user.
   */
  CompletableFuture<AuthUserGrantRoleResponse> userGrantRole(ByteSequence user, ByteSequence role);

  /**
   * revokes a role of a user.
   */
  CompletableFuture<AuthUserRevokeRoleResponse> userRevokeRole(ByteSequence user,
                                                               ByteSequence role);

  /**
   * adds a new role to an etcd cluster.
   */
  CompletableFuture<AuthRoleAddResponse> roleAdd(ByteSequence user);

  /**
   * grants a permission to a role.
   */
  CompletableFuture<AuthRoleGrantPermissionResponse> roleGrantPermission(ByteSequence role,
                                                                         ByteSequence key,
                                                                         ByteSequence rangeEnd, Permission.Type permType);

  /**
   * gets a detailed information of a role.
   */
  CompletableFuture<AuthRoleGetResponse> roleGet(ByteSequence role);

  /**
   * gets a list of all roles.
   */
  CompletableFuture<AuthRoleListResponse> roleList();

  /**
   * revokes a permission from a role.
   */
  CompletableFuture<AuthRoleRevokePermissionResponse> roleRevokePermission(ByteSequence role,
                                                                           ByteSequence key,
                                                                           ByteSequence rangeEnd);

  /**
   * RoleDelete deletes a role.
   */
  CompletableFuture<AuthRoleDeleteResponse> roleDelete(ByteSequence role);

}
