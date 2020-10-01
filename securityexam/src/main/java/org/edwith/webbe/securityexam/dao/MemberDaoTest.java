package org.edwith.webbe.securityexam.dao;

import java.sql.Connection;

import javax.sql.DataSource;

import org.edwith.webbe.securityexam.config.ApplicationConfig;
import org.edwith.webbe.securityexam.dto.Member;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class MemberDaoTest {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	MemberDao memberDao;
	
	@Autowired
	MemberRoleDao memberRoleDao;
	
	@Test
	public void configTest() throws Exception{
		// 아무작업도 하지 않는다 실행이 잘 된다는 것은 spring 설정이 잘 되어 있다는 것이다.
	}
	
	@Test
	public void connectionTest() throws Exception{
		Connection conn = dataSource.getConnection();
		Assert.assertNotNull(conn);
	}
	 
	@Test
	public void getUser() throws Exception{
		Member member = memberDao.getMemberByEmail("carami@example.com");
        Assert.assertNotNull(member);
        Assert.assertEquals("강경미", member.getName());	
	}
	
	

}
