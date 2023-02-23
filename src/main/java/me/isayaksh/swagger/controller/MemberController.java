package me.isayaksh.swagger.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import me.isayaksh.swagger.entity.Member;
import me.isayaksh.swagger.entity.MemberForm;
import me.isayaksh.swagger.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @Operation(summary = "test summary", description = "test for swagger")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK !!"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST !!"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND !!"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR !!")
    })
    @GetMapping("/test")
    public String test(@RequestParam("name") String name) {
        return "Welcome " + name + "!";
    }

    @Operation(summary = "create member", description = "api for create member")
    @PostMapping("/create")
    public String create(@RequestBody MemberForm form) {
        memberService.create(form);
        return "create success";
    }

    @Operation(summary = "find member", description = "api for find member")
    @GetMapping("/{id}")
    public Member findOne(@PathVariable Long id) {
        return memberService.findOne(id);
    }

    @Operation(summary = "find members", description = "api for find members")
    @GetMapping("/all")
    public List<Member> findAll() {
        return memberService.findAll();
    }

    @Operation(summary = "update member", description = "api for update member")
    @PatchMapping("/{id}/update")
    public String update(@PathVariable Long id,
                         @RequestBody MemberForm form) {
        memberService.update(id, form);
        return "update success";
    }

    @Operation(summary = "delete member", description = "api for delete member")
    @DeleteMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        memberService.delete(id);
        return "delete success";
    }
}
