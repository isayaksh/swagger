package me.isayaksh.swagger.repository;

import me.isayaksh.swagger.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
