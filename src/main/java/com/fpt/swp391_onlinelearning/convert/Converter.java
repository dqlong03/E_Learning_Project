/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.convert;

import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.dto.BlogCategoryDTO;
import com.fpt.swp391_onlinelearning.dto.BlogDTO;
import com.fpt.swp391_onlinelearning.dto.CourseCategoryDTO;
import com.fpt.swp391_onlinelearning.dto.CourseDTO;
import com.fpt.swp391_onlinelearning.dto.CourseRegisterationDTO;
import com.fpt.swp391_onlinelearning.dto.DurationDTO;
import com.fpt.swp391_onlinelearning.dto.FeatureDTO;
import com.fpt.swp391_onlinelearning.dto.LanguageDTO;
import com.fpt.swp391_onlinelearning.dto.LevelDTO;
import com.fpt.swp391_onlinelearning.dto.RoleDTO;
import com.fpt.swp391_onlinelearning.dto.SliderDTO;
import com.fpt.swp391_onlinelearning.dto.UserDTO;
import com.fpt.swp391_onlinelearning.model.Account;
import com.fpt.swp391_onlinelearning.model.Blog;
import com.fpt.swp391_onlinelearning.model.BlogCategory;
import com.fpt.swp391_onlinelearning.model.Course;
import com.fpt.swp391_onlinelearning.model.CourseCategory;
import com.fpt.swp391_onlinelearning.model.CourseRegisteration;
import com.fpt.swp391_onlinelearning.model.Duration;
import com.fpt.swp391_onlinelearning.model.Feature;
import com.fpt.swp391_onlinelearning.model.Language;
import com.fpt.swp391_onlinelearning.model.Role;
import com.fpt.swp391_onlinelearning.model.Level;
import com.fpt.swp391_onlinelearning.model.Slider;
import com.fpt.swp391_onlinelearning.model.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tran Hoang Phuc
 */
public class Converter {

    public static AccountDTO toDTO(Account account) {
        AccountDTO accountDTO = new AccountDTO();
        if (account != null) {

            try {
                accountDTO.setAccId(account.getAccId());
            } catch (Exception e) {
            } finally {
                accountDTO.setEmail(account.getEmail());
                accountDTO.setCreatedTime(account.getCreatedTime());
                accountDTO.setIsActivated(account.getIsActivated());
                if (account.getRole() == null) {
                    accountDTO.setRole(null);
                } else {
                    RoleDTO roleDTO = new RoleDTO();
                    roleDTO.setRoleId(account.getRole().getRoleId());
                    accountDTO.setRole(roleDTO);
                }
                accountDTO.setOtp(account.getOtp());
                return accountDTO;
            }
        }
        return null;
    }

    public static RoleDTO toDTO(Role role) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setRoleId(role.getRoleId());
        roleDTO.setName(role.getName());
        return roleDTO;
    }

    public static Account toDomain(AccountDTO dto) {
        Account domain = new Account();
        domain.setAccId(dto.getAccId());
        domain.setEmail(dto.getEmail());
        domain.setIsActivated(dto.getIsActivated());
        domain.setOtp(dto.getOtp());
        Role role = new Role();
        role.setRoleId(dto.getRole().getRoleId());
        domain.setRole(role);
        return domain;
    }

    public static Account toDomainRegister(AccountDTO dto) {
        Account domain = new Account();
        domain.setEmail(dto.getEmail());
        domain.setOtp(dto.getOtp());
        return domain;
    }

    public static Role toDomain(RoleDTO dto) {
        Role domain = new Role();
        domain.setRoleId(dto.getRoleId());
        domain.setName(dto.getName());
        return domain;
    }

    public static FeatureDTO toDTO(Feature domain) {
        FeatureDTO dto = new FeatureDTO();
        dto.setFeatureId(domain.getFeatureId());
        dto.setName(domain.getName());
        return dto;
    }

    public static CourseCategoryDTO toDTO(CourseCategory coursecategory) {
        CourseCategoryDTO coursecategorydto = new CourseCategoryDTO();
        coursecategorydto.setCourseCategoryId(coursecategory.getCourseCategoryId());
        coursecategorydto.setName(coursecategory.getName());
        return coursecategorydto;
    }

    public static CourseCategory toDomain(CourseCategoryDTO coursecategorydto) {
        CourseCategory coursecategory = new CourseCategory();
        coursecategory.setCourseCategoryId(coursecategorydto.getCourseCategoryId());
        coursecategory.setName(coursecategorydto.getName());
        return coursecategory;
    }

    public static LevelDTO toDTO(Level level) {
        LevelDTO leveldto = new LevelDTO();
        leveldto.setLevelId(level.getLevelId());
        leveldto.setName(level.getName());
        return leveldto;
    }
    
        public static List<LevelDTO> toLevelDTO(List<Level> level){
        List<LevelDTO> levelcoursedtos = new ArrayList<>();

        for (int i=0;i<level.size();i++) {
            LevelDTO cdto = toDTO(level.get(i));
            levelcoursedtos.add(cdto);
        }
        return levelcoursedtos;
    }

    public static Level toDomain(LevelDTO leveldto) {
        Level level = new Level();
        level.setLevelId(leveldto.getLevelId());
        level.setName(leveldto.getName());
        return level;
    }

    public static DurationDTO toDTO(Duration duration) {
        DurationDTO durationdto = new DurationDTO();
        durationdto.setDurationId(duration.getDurationId());
        durationdto.setName(duration.getName());
        return durationdto;
    }
    
    public static List<DurationDTO> toDTO1(List<Duration> durations){
        List<DurationDTO> durationdtos = new ArrayList<>();

        for (int i=0;i<durations.size();i++) {
            DurationDTO cdto = toDTO(durations.get(i));
            durationdtos.add(cdto);
        }

        return durationdtos;
    }

    public static Duration toDomain(DurationDTO durationdto) {
        Duration duration = new Duration();
        duration.setDurationId(durationdto.getDurationId());
        duration.setName(durationdto.getName());
        return duration;
    }

    public static UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();

        userDTO.setUserId(user.getUserId());
        userDTO.setName(user.getName());
        userDTO.setGender(user.isGender());
        userDTO.setDob(user.getDob());
        userDTO.setPhone(user.getPhone());
        userDTO.setImg(user.getImg());
        userDTO.setAddress(user.getAddress());
        userDTO.setPostCode(user.getPostCode());
        userDTO.setBalance(user.getBalance());

        AccountDTO a = new AccountDTO();
        a.setAccId(user.getAccount().getAccId());
        a.setEmail(user.getAccount().getEmail());

        userDTO.setAccount(a);

        return userDTO;
    }

    public static User toDomain(UserDTO dto) {
        User domain = new User();
        domain.setName(dto.getName());
        domain.setDob(dto.getDob());
        domain.setPhone(dto.getPhone());
        domain.setGender(dto.isGender());
        Account a = new Account();
        a.setAccId(dto.getAccount().getAccId());
        domain.setAccount(a);
        return domain;
    }
    public static User toUserDomain(UserDTO udto) {
        User u = new User();
        
        u.setUserId(udto.getUserId());
        u.setName(udto.getName());
        u.setGender(udto.isGender());
        u.setDob(udto.getDob());
        u.setPhone(udto.getPhone());
        u.setImg(udto.getImg());
        u.setAddress(udto.getAddress());
        u.setPostCode(udto.getPostCode());
        u.setBalance(udto.getBalance());
        
        Account a= new Account();
        a.setAccId(udto.getAccount().getAccId());
        a.setEmail(udto.getAccount().getEmail());
        
        u.setAccount(a);
        
        return u;
    }
    public static LanguageDTO toDTO(Language language) {
        LanguageDTO languagedto = new LanguageDTO();
        languagedto.setLanguageId(language.getLanguageId());
        languagedto.setName(language.getName());
        return languagedto;
    }
    
        public static List<LanguageDTO> toDTO2(List<Language> language){
        List<LanguageDTO> languagedtos = new ArrayList<>();

        for (int i=0;i<language.size();i++) {
            LanguageDTO cdto = toDTO(language.get(i));
            languagedtos.add(cdto);
        }

        return languagedtos;
    }

    public static Language toDomain(LanguageDTO languagedto) {
        Language language = new Language();
        language.setLanguageId(languagedto.getLanguageId());
        language.setName(languagedto.getName());
        return language;
    }

    public static CourseDTO toDTO(Course course) {
        CourseDTO coursedto = new CourseDTO();
        coursedto.setCourseId(course.getCourseId());
        coursedto.setName(course.getName());
        
        CourseCategoryDTO categoryDTO = new CourseCategoryDTO();
        categoryDTO.setCourseCategoryId(course.getCategory().getCourseCategoryId());
        categoryDTO.setName(course.getCategory().getName());
        
        coursedto.setPrice(course.getPrice());
        
        LevelDTO level = new LevelDTO();
        level.setLevelId(course.getLevel().getLevelId());
        level.setName(course.getLevel().getName());
        
        DurationDTO durationDTO = new DurationDTO();
        durationDTO.setDurationId(course.getDuration().getDurationId());
        durationDTO.setName(course.getDuration().getName());
        
        UserDTO u = new UserDTO();
        u.setUserId(course.getAuthor().getUserId());
        u.setName(course.getAuthor().getName());
        
        LanguageDTO languageDTO = new LanguageDTO();
        languageDTO.setLanguageId(course.getLanguage().getLanguageId());
        languageDTO.setName(course.getLanguage().getName());
        
        coursedto.setCategory(categoryDTO);
        coursedto.setDuration(durationDTO);
        coursedto.setLevel(level);
        coursedto.setAuthor(u);
        coursedto.setLanguage(languageDTO);
        coursedto.setDescription(course.getDescription());
        coursedto.setImg(course.getImg());
        coursedto.setCreatedTime(course.getCreatedTime());
        return coursedto;
    }

    public static Course toDomain(CourseDTO coursedto) {
        Course course = new Course();
        course.setCourseId(coursedto.getCourseId());
        course.setName(coursedto.getName());
        course.setCategory(toDomain(coursedto.getCategory()));
        course.setPrice(coursedto.getPrice());
        course.setLevel(toDomain(coursedto.getLevel()));
        course.setAuthor(toDomain(coursedto.getAuthor()));
        course.setDescription(coursedto.getDescription());
        return course;
    }

    public static BlogDTO toDTO(Blog b) {
        BlogDTO bdto= new BlogDTO();
        bdto.setBlogId(b.getBlogId());
        bdto.setTitle(b.getTitle());
        bdto.setContent(b.getContent());
        bdto.setCreatedTime(b.getCreatedTime());
        bdto.setImg(b.getImg());
        bdto.setQuickReview(b.getQuickReview());
        
        BlogCategoryDTO bcdto= new BlogCategoryDTO();
        bcdto.setBlogCategoryId(b.getCategory().getBlogCategoryId());
        bcdto.setName(b.getCategory().getName());
        bdto.setCategory(bcdto);
        
        UserDTO udto= new UserDTO();
        udto.setUserId(b.getAuthor().getUserId());
        udto.setName(b.getAuthor().getName());
        bdto.setAuthor(udto);
        
        return bdto;
    }
    public static SliderDTO toDTO(Slider s)
    {
        SliderDTO sdto= new SliderDTO();
        sdto.setSliderID(s.getSliderID());
        sdto.setImg(s.getImg());
        sdto.setTitle(s.getTitle());
        sdto.setDescription(s.getDescription());
        sdto.setLinkDetail(s.getLinkDetail());
        sdto.setStatus(s.getStatus());
        
        return sdto;
    }
    public static Slider toDomain(Slider sdto)
    {
        Slider domain= new Slider();
        domain.setSliderID(sdto.getSliderID());
        domain.setImg(sdto.getImg());
        domain.setTitle(sdto.getTitle());
        domain.setDescription(sdto.getDescription());
        domain.setLinkDetail(sdto.getLinkDetail());
        domain.setStatus(sdto.getStatus());
        
        return domain;
    }
    public static List<SliderDTO> toSliderListDTO(List<Slider> sliderList)
    {
        List<SliderDTO> sliderDTOList= new ArrayList<SliderDTO>();
        for(Slider s: sliderList)
        {
            SliderDTO sdto= Converter.toDTO(s);
            sliderDTOList.add(sdto);
        }
        return sliderDTOList;
    }
        public static List<CourseCategoryDTO> toDTO(ArrayList<CourseCategory> courseCategory) {
        List<CourseCategoryDTO> courseCategorydtos = new ArrayList<>();

        for(int i=0;i<courseCategory.size();i++){
            CourseCategoryDTO ccdto = toDTO(courseCategory.get(i));
            courseCategorydtos.add(ccdto);
        }
        return courseCategorydtos;
    }
    
    public static List<CourseCategory> toDomain(ArrayList<CourseCategoryDTO> courseCategorydto) {
        List<CourseCategory> courseCategory = new ArrayList<>();

        for(int i=0;i<courseCategorydto.size();i++){
            CourseCategory cc = toDomain(courseCategorydto.get(i));
            courseCategory.add(cc);
        }
        return courseCategory;
    }
        
    public static CourseDTO toDTO1(Course course) {
        CourseDTO coursedto = new CourseDTO();
        coursedto.setCourseId(course.getCourseId());
        if(course.getName()!=null){
            coursedto.setName(course.getName());
        }
        if(course.getCategory()!=null){
            coursedto.setCategory(toDTO(course.getCategory()));
        }
        coursedto.setPrice(course.getPrice());
        if(course.getLevel()!=null){
            coursedto.setLevel(toDTO(course.getLevel()));
        }
        if(course.getAuthor()!=null){
            coursedto.setAuthor(toDTO(course.getAuthor()));
        }
        if(course.getImg()!=null){
            coursedto.setImg(course.getImg());
        }
        if(course.getLanguage()!=null){
            coursedto.setLanguage(toDTO(course.getLanguage()));
        }
        if(course.getDescription()!=null){
            coursedto.setDescription(course.getDescription());
        }
        return coursedto;
    }
        public static List<CourseDTO> toDTO(List<Course> courses) {
        List<CourseDTO> coursedtos = new ArrayList<>();

        for (int i=0;i<courses.size();i++) {
            CourseDTO cdto = toDTO1(courses.get(i));
            coursedtos.add(cdto);
        }

        return coursedtos;
    }
        
        //Blog to BlogDTO
    public static BlogCategoryDTO toDTO(BlogCategory blogCategory) {
        BlogCategoryDTO dto = new BlogCategoryDTO();
        dto.setBlogCategoryId(blogCategory.getBlogCategoryId());
        dto.setName(blogCategory.getName());
        return dto;
    }

    public static UserDTO toUserDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setUserId(user.getUserId());
        dto.setName(user.getName());
        if(user.getImg()!=null){
            dto.setImg(user.getImg());
        }
        return dto;
    }

    public static BlogDTO toBlogDTO(Blog blog) {
        BlogDTO blogDTO = new BlogDTO();
        blogDTO.setBlogId(blog.getBlogId());
        blogDTO.setTitle(blog.getTitle());
        if (blog.getContent() != null) {
            blogDTO.setContent(blog.getContent());
        }
        if (blog.getCategory() != null) {
            BlogCategoryDTO bc = toDTO(blog.getCategory());
            blogDTO.setCategory(bc);
        }
        blogDTO.setCreatedTime(blog.getCreatedTime());
        if (blog.getQuickReview() != null) {
            blogDTO.setQuickReview(blog.getQuickReview());
        }
        if (blog.getAuthor() != null) {
            UserDTO userDTO = toUserDTO(blog.getAuthor());
            blogDTO.setAuthor(userDTO);
        }
        blogDTO.setImg(blog.getImg());
        return blogDTO;
    }

    public static List<BlogDTO> toBlogDTO(List<Blog> blogs) {
        List<BlogDTO> blogDTOs = new ArrayList<>();
        for (int i = 0; i < blogs.size(); i++) {
            BlogDTO bdto = toBlogDTO(blogs.get(i));
            blogDTOs.add(bdto);
        }
        return blogDTOs;
    }
    //Blog category to Course Blog DTO
    public static List<BlogCategoryDTO> toBlogCategoryDTO(List<BlogCategory> blogCategorys){
        List<BlogCategoryDTO> blogCategoryDTOs = new ArrayList<>();
        for (int i = 0; i < blogCategorys.size(); i++) {
            BlogCategoryDTO blogCategoryDTO = toDTO(blogCategorys.get(i));
            blogCategoryDTOs.add(blogCategoryDTO);
        }
        return blogCategoryDTOs;
    }
    
    //Course to CourseDTO
    public static CourseCategoryDTO toDTO3(CourseCategory courseCategory) {
        CourseCategoryDTO dto = new CourseCategoryDTO();
        dto.setCourseCategoryId(courseCategory.getCourseCategoryId());
        dto.setName(courseCategory.getName());
        return dto;
    }

    public static LevelDTO toDTO3(Level levelCourse) {
        LevelDTO dto = new LevelDTO();
        dto.setLevelId(levelCourse.getLevelId());
        dto.setName(levelCourse.getName());
        return dto;
    }

    public static DurationDTO toDTO3(Duration duration) {
        DurationDTO dto = new DurationDTO();
        dto.setDurationId(duration.getDurationId());
        dto.setName(duration.getName());
        return dto;
    }

    public static LanguageDTO toDTO3(Language language) {
        LanguageDTO dto = new LanguageDTO();
        dto.setLanguageId(language.getLanguageId());
        dto.setName(language.getName());
        return dto;
    }

    public static CourseDTO toDTO3(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setCourseId(course.getCourseId());
        courseDTO.setDescription(course.getDescription());
        courseDTO.setImg(course.getImg());
        courseDTO.setName(course.getName());
        courseDTO.setPrice(course.getPrice());

        UserDTO userDTO = toUserDTO(course.getAuthor());
        courseDTO.setAuthor(userDTO);

        CourseCategoryDTO ccdto = toDTO3(course.getCategory());
        courseDTO.setCategory(ccdto);

        DurationDTO ddto = toDTO3(course.getDuration());
        courseDTO.setDuration(ddto);

        LevelDTO lcdto = toDTO3(course.getLevel());
        courseDTO.setLevel(lcdto);

        LanguageDTO ldto = toDTO3(course.getLanguage());
        courseDTO.setLanguage(ldto);
        return courseDTO;
    }
    
    public static CourseRegisterationDTO toDto(CourseRegisteration registeration) {
        CourseRegisterationDTO courseRegisterationDTO = new CourseRegisterationDTO();
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setCourseId(registeration.getCourse().getCourseId());
        courseRegisterationDTO.setCourse(courseDTO);
        UserDTO user = new UserDTO();
        user.setUserId(registeration.getUser().getUserId());
        courseRegisterationDTO.setUser(user);
        courseRegisterationDTO.setCourseRegisterationId(registeration.getCourseRegisterationId());
        return courseRegisterationDTO;
    }
}
