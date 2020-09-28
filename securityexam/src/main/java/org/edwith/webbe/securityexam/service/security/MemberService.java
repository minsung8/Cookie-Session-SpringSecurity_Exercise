package org.edwith.webbe.securityexam.service.security;

import java.util.List;

public interface MemberService extends UserDbService {

	List<UserRoleEntity> getUserRoles(String loginUserId);

		
}
