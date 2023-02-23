package me.isayaksh.swagger.service;

import lombok.RequiredArgsConstructor;
import me.isayaksh.swagger.entity.Member;
import me.isayaksh.swagger.entity.MemberForm;
import me.isayaksh.swagger.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void create(MemberForm form) {
        memberRepository.save(form.toEntity());
    }

    public Member findOne(Long id) {
        return getMember(id);
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Transactional
    public void update(Long id, MemberForm form){
        Member member = getMember(id);
        member.update(form.getEmail(), form.getPassword(), form.getUsername());
    }

    @Transactional
    public void delete(Long id){
        memberRepository.deleteById(id);
    }

    private Member getMember(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException());
    }

}
