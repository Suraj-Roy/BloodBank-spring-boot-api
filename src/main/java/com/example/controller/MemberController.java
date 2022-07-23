package com.example.controller;
import com.example.entity.BloodGroups;
import com.example.entity.ProfileEntity;
import com.example.entity.RegistrationEntity;
import com.example.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("blood/bank")
public class MemberController {

//    @GetMapping("/name")
//    public String getName(){
//        return "Hello";
//    }

    @Autowired
    MemberService memberService;

    @GetMapping("/getAllRegisters")
    public List<RegistrationEntity> record(){
            return memberService.getRecords();
    }

    @GetMapping("/getAllProfile")
    public List<ProfileEntity> records(){
        return memberService.getProfile();
    }



    @PostMapping("/register")
    public void registerMembers(@Valid @RequestBody RegistrationEntity registrationEntity){

        memberService.addMember(registrationEntity);

    }

    @PutMapping("/Update/{bg}")
    public BloodGroups UpdateBloodUnit(@RequestBody BloodGroups bg){
        return memberService.updateBloodUnits(bg);
    }

    @PostMapping("/createBgroup")
    public void createbloodgrou(@RequestBody BloodGroups bloogGroups){
        memberService.addBloodGroup(bloogGroups);
    }

    @GetMapping("/allBloodGrpoups")
    public List<BloodGroups> getAllBloodGroups(){
        return memberService.AvailableBlood();
    }

    @GetMapping("/searchbyBloodgroup/{bg}")
    public List<ProfileEntity> getfacts(String bg){
        return memberService.getByBlood_Group(bg);
    }

    @GetMapping("/searchbycity/{city}")
    public List<ProfileEntity> getcity(String city){
        return memberService.getByCity(city);
    }

    @DeleteMapping("/DeleteAccount/{id}")
    public void delete(Long id){
        memberService.deleteUser(id);
    }

    @PutMapping("updateProfile/{Profile}")
    public void updateProfile(@RequestBody ProfileEntity Profile){
        return;
    }

    @PostMapping("/login/{register}")
    public void register(@RequestBody RegistrationEntity register){
        return;
    }
}
