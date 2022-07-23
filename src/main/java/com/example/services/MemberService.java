package com.example.services;
import com.example.entity.BloodGroups;
import com.example.entity.ProfileEntity;
import com.example.entity.RegistrationEntity;
import com.example.repository.BloodGroupRepo;
import com.example.repository.ProfileRepo;
import com.example.repository.RegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.regex.*;

@Service
public class MemberService {

    @Autowired
    RegistrationRepo registrationRepo;

    @Autowired
    ProfileRepo profileRepo;

    @Autowired
    BloodGroupRepo bloodGroupRepo;

    public List<RegistrationEntity> getRecords(){
        return registrationRepo.findAll();
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }


    public void addMember(RegistrationEntity registrationEntity){
        if(validate(registrationEntity.getEmail())){
            ProfileEntity profile = new ProfileEntity();

            profile.setFirst_Name(registrationEntity.getFirst_Name());
            profile.setBlood_Group(registrationEntity.getBlood_Group());
            profile.setCity("ss");
            profile = profileRepo.save(profile);

            registrationEntity.setProfileEntity(profile);

            registrationRepo.save(registrationEntity);
        }


    }
 ///////////////////////////////////////////////////////////////////////////////////////////////////////////

    public List<ProfileEntity> getProfile(){
        return profileRepo.findAll();
    }

    public void updateProfile(ProfileEntity profile){
        profileRepo.save(profile);
    }

    public List<ProfileEntity> getByCity(String city){

        return profileRepo.findByCity(city);
    }

    public List<ProfileEntity> getByBlood_Group(String bloodgroup){

        return profileRepo.findByBlood_Group(bloodgroup);
    }


   public List<BloodGroups> AvailableBlood(){
        return bloodGroupRepo.findAll();
   }

   public BloodGroups updateBloodUnits(BloodGroups bg){
      BloodGroups b = new BloodGroups();
      b= bloodGroupRepo.findById(bg.getId()).get();
      bg.setUnits(bg.getUnits()+bg.getUnits());

      return bloodGroupRepo.save(bg);

   }

   public void addBloodGroup(BloodGroups bg){
        bloodGroupRepo.save(bg);
   }

//    public void ApproveBlood()

//    public void viewBloodRequest()

    public void deleteUser(Long id){
        registrationRepo.deleteById(id);
    }


}
