package kr.inhatc.spring.member.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.inhatc.spring.member.dto.MemberFormDto;
import kr.inhatc.spring.member.entity.Member;
import kr.inhatc.spring.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private MemberService memberService;
    
    @GetMapping("/login")
    public String login() {
        return "/member/memberLogin";
    }
    
    @GetMapping("/login/error")
    public String loginError(Model model) {
        model.addAttribute("loginErrorMsg","아이디 또는 패스워드를 다시 확인하세요.");
        return "/member/memberLogin";
    }
    
    @GetMapping("/new")
    public String memberForm(Model model) {
        model.addAttribute("memberFormDto", new MemberFormDto());
        return "member/memberForm";
    }
    
    @PostMapping("/new")
    public String memberForm(@Valid MemberFormDto memberFormDto,
            BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return "member/memberForm";
        }
        try {
            Member createMember = Member.createMember(memberFormDto, passwordEncoder);
            memberService.saveMember(createMember);
        }catch(IllegalStateException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "member/memberForm";
        }
        
        return "redirect:/";
    }
}
