package com.example.workflow.services;

//@Service
//@RequiredArgsConstructor
//@Slf4j
public class EntraGroupService {

//    private final GraphServiceClient graphClient;
//
//    /**
//     * Add a user to a security group
//     *
//     * @param userId The user's ID or UPN (User Principal Name)
//     * @param groupId The security group's ID
//     * @return True if the operation was successful
//     */
//    public boolean addUserToGroup(String userId, String groupId) {
//        try {
//            User user = findUserByIdOrUpn(userId);
//            if (user == null) {
//                log.error("User with ID or UPN '{}' not found", userId);
//                return false;
//            }
//
//            DirectoryObject directoryObject = new DirectoryObject();
//            directoryObject.id = user.id;
//
//            graphClient.groups(groupId)
//                    .members()
//                    .references()
//                    .buildRequest()
//                    .post(directoryObject);
//
//            log.info("Successfully added user '{}' to group '{}'", userId, groupId);
//            return true;
//        } catch (Exception e) {
//            log.error("Error adding user '{}' to group '{}': {}", userId, groupId, e.getMessage());
//            return false;
//        }
//    }
//
//    /**
//     * Remove a user from a security group
//     *
//     * @param userId The user's ID or UPN (User Principal Name)
//     * @param groupId The security group's ID
//     * @return True if the operation was successful
//     */
//    public boolean removeUserFromGroup(String userId, String groupId) {
//        try {
//            User user = findUserByIdOrUpn(userId);
//            if (user == null) {
//                log.error("User with ID or UPN '{}' not found", userId);
//                return false;
//            }
//
//            graphClient.groups(groupId)
//                    .members(user.id)
//                    .reference()
//                    .buildRequest()
//                    .delete();
//
//            log.info("Successfully removed user '{}' from group '{}'", userId, groupId);
//            return true;
//        } catch (Exception e) {
//            log.error("Error removing user '{}' from group '{}': {}", userId, groupId, e.getMessage());
//            return false;
//        }
//    }
//
//    /**
//     * List all members of a security group
//     *
//     * @param groupId The security group's ID
//     * @return List of users in the group
//     */
//    public List<User> listGroupMembers(String groupId) {
//        try {
//            return graphClient.groups(groupId)
//                    .members()
//                    .buildRequest()
//                    .select("id,displayName,userPrincipalName")
//                    .get()
//                    .getCurrentPage()
//                    .stream()
//                    .filter(member -> member instanceof User)
//                    .map(member -> (User) member)
//                    .toList();
//        } catch (Exception e) {
//            log.error("Error listing members of group '{}': {}", groupId, e.getMessage());
//            throw new RuntimeException("Failed to list group members", e);
//        }
//    }
//
//    /**
//     * List all security groups in the tenant
//     *
//     * @return List of security groups
//     */
//    public List<Group> listSecurityGroups() {
//        try {
//            return graphClient.groups()
//                    .buildRequest()
//                    .filter("securityEnabled eq true")
//                    .select("id,displayName,description")
//                    .get()
//                    .getCurrentPage();
//        } catch (Exception e) {
//            log.error("Error listing security groups: {}", e.getMessage());
//            throw new RuntimeException("Failed to list security groups", e);
//        }
//    }
//
//    /**
//     * Find a user by ID or User Principal Name (email)
//     *
//     * @param idOrUpn The user's ID or UPN
//     * @return The user object if found, null otherwise
//     */
//    private User findUserByIdOrUpn(String idOrUpn) {
//        try {
//            // First try to find the user by ID
//            return graphClient.users(idOrUpn)
//                    .buildRequest()
//                    .select("id,displayName,userPrincipalName")
//                    .get();
//        } catch (Exception e) {
//            try {
//                // If that fails, try to find by UPN
//                return graphClient.users()
//                        .buildRequest()
//                        .filter("userPrincipalName eq '" + idOrUpn + "'")
//                        .select("id,displayName,userPrincipalName")
//                        .get()
//                        .getCurrentPage()
//                        .stream()
//                        .findFirst()
//                        .orElse(null);
//            } catch (Exception ex) {
//                log.error("Error finding user by ID or UPN '{}': {}", idOrUpn, ex.getMessage());
//                return null;
//            }
//        }
//    }
}
