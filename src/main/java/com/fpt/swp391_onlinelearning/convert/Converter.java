/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.convert;

import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.dto.BlogCategoryDTO;
import com.fpt.swp391_onlinelearning.dto.BlogDTO;
import com.fpt.swp391_onlinelearning.dto.BlogViewDTO;
import com.fpt.swp391_onlinelearning.dto.ChapterDTO;
import com.fpt.swp391_onlinelearning.dto.CourseCategoryDTO;
import com.fpt.swp391_onlinelearning.dto.CourseDTO;
import com.fpt.swp391_onlinelearning.dto.CourseRegistrationDTO;
import com.fpt.swp391_onlinelearning.dto.DurationDTO;
import com.fpt.swp391_onlinelearning.dto.FeatureDTO;
import com.fpt.swp391_onlinelearning.dto.LanguageDTO;
import com.fpt.swp391_onlinelearning.dto.LessonDTO;
import com.fpt.swp391_onlinelearning.dto.LessonTypeDTO;
import com.fpt.swp391_onlinelearning.dto.LevelDTO;
import com.fpt.swp391_onlinelearning.dto.PostCategoryDTO;
import com.fpt.swp391_onlinelearning.dto.PostDTO;
import com.fpt.swp391_onlinelearning.dto.RoleDTO;
import com.fpt.swp391_onlinelearning.dto.SettingDTO;
import com.fpt.swp391_onlinelearning.dto.SettingTypeDTO;
import com.fpt.swp391_onlinelearning.dto.SliderDTO;
import com.fpt.swp391_onlinelearning.dto.TransactionDTO;
import com.fpt.swp391_onlinelearning.dto.UserDTO;
import com.fpt.swp391_onlinelearning.dto.UserLessonDTO;
import com.fpt.swp391_onlinelearning.model.Account;
import com.fpt.swp391_onlinelearning.model.Blog;
import com.fpt.swp391_onlinelearning.model.BlogCategory;
import com.fpt.swp391_onlinelearning.model.BlogView;
import com.fpt.swp391_onlinelearning.model.Chapter;
import com.fpt.swp391_onlinelearning.model.Course;
import com.fpt.swp391_onlinelearning.model.CourseCategory;
import com.fpt.swp391_onlinelearning.model.CourseRegistration;
import com.fpt.swp391_onlinelearning.model.Duration;
import com.fpt.swp391_onlinelearning.model.Feature;
import com.fpt.swp391_onlinelearning.model.Language;
import com.fpt.swp391_onlinelearning.model.Lesson;
import com.fpt.swp391_onlinelearning.model.Level;
import com.fpt.swp391_onlinelearning.model.Post;
import com.fpt.swp391_onlinelearning.model.PostCategory;
import com.fpt.swp391_onlinelearning.model.Role;
import com.fpt.swp391_onlinelearning.model.Setting;
import com.fpt.swp391_onlinelearning.model.SettingType;
import com.fpt.swp391_onlinelearning.model.Slider;
import com.fpt.swp391_onlinelearning.model.Transaction;
import com.fpt.swp391_onlinelearning.model.User;
import com.fpt.swp391_onlinelearning.model.UserLesson;
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
                accountDTO.setRegisteredTime(account.getRegisteredTime());
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

    public static List<LevelDTO> toLevelDTO(List<Level> level) {
        List<LevelDTO> levelcoursedtos = new ArrayList<>();

        for (int i = 0; i < level.size(); i++) {
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

    public static List<DurationDTO> toDTO1(List<Duration> durations) {
        List<DurationDTO> durationdtos = new ArrayList<>();

        for (int i = 0; i < durations.size(); i++) {
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

        Account a = new Account();
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

    public static List<LanguageDTO> toDTO2(List<Language> language) {
        List<LanguageDTO> languagedtos = new ArrayList<>();

        for (int i = 0; i < language.size(); i++) {
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
        BlogDTO bdto = new BlogDTO();
        bdto.setBlogId(b.getBlogId());
        bdto.setTitle(b.getTitle());
        bdto.setContent(b.getContent());
        bdto.setCreatedTime(b.getCreatedTime());
        bdto.setImg(b.getImg());
        bdto.setQuickReview(b.getQuickReview());

        BlogCategoryDTO bcdto = new BlogCategoryDTO();
        bcdto.setBlogCategoryId(b.getCategory().getBlogCategoryId());
        bcdto.setName(b.getCategory().getName());
        bdto.setCategory(bcdto);

        UserDTO udto = new UserDTO();
        udto.setUserId(b.getAuthor().getUserId());
        udto.setName(b.getAuthor().getName());
        bdto.setAuthor(udto);

        return bdto;
    }

    public static SliderDTO toDTO(Slider s) {
        SliderDTO sdto = new SliderDTO();
        sdto.setSliderId(s.getSliderId());
        sdto.setImg(s.getImg());
        sdto.setTitle(s.getTitle());
        sdto.setDescription(s.getDescription());
        PostDTO p = new PostDTO();
        p.setPostId(s.getPost().getPostId());
        sdto.setPost(p);
        sdto.setStatus(s.getStatus());

        return sdto;
    }

    public static Slider toDomain(SliderDTO sdto) {
        Slider domain = new Slider();
        domain.setSliderId(sdto.getSliderId());
        domain.setImg(sdto.getImg());
        domain.setTitle(sdto.getTitle());
        domain.setDescription(sdto.getDescription());
        Post p = new Post();
        p.setPostId(sdto.getPost().getPostId());
        domain.setPost(p);
        domain.setStatus(sdto.getStatus());
        return domain;
    }

    public static List<SliderDTO> toSliderListDTO(List<Slider> sliderList) {
        List<SliderDTO> sliderDTOList = new ArrayList<SliderDTO>();
        for (Slider s : sliderList) {
            SliderDTO sdto = Converter.toDTO(s);
            sliderDTOList.add(sdto);
        }
        return sliderDTOList;
    }

    public static List<CourseCategoryDTO> toDto(List<CourseCategory> courseCategory) {
        List<CourseCategoryDTO> courseCategorydtos = new ArrayList<>();

        for (int i = 0; i < courseCategory.size(); i++) {
            CourseCategoryDTO ccdto = toDTO(courseCategory.get(i));
            courseCategorydtos.add(ccdto);
        }
        return courseCategorydtos;
    }

    public static List<CourseCategory> toDomain(List<CourseCategoryDTO> courseCategorydto) {
        List<CourseCategory> courseCategory = new ArrayList<>();

        for (int i = 0; i < courseCategorydto.size(); i++) {
            CourseCategory cc = toDomain(courseCategorydto.get(i));
            courseCategory.add(cc);
        }
        return courseCategory;
    }

    public static CourseDTO toDTO1(Course course) {
        CourseDTO coursedto = new CourseDTO();
        coursedto.setCourseId(course.getCourseId());
        if (course.getName() != null) {
            coursedto.setName(course.getName());
        }
        if (course.getCategory() != null) {
            coursedto.setCategory(toDTO(course.getCategory()));
        }
        coursedto.setPrice(course.getPrice());
        if (course.getLevel() != null) {
            coursedto.setLevel(toDTO(course.getLevel()));
        }
        if (course.getAuthor() != null) {
            coursedto.setAuthor(toDTO(course.getAuthor()));
        }
        if (course.getImg() != null) {
            coursedto.setImg(course.getImg());
        }
        if (course.getLanguage() != null) {
            coursedto.setLanguage(toDTO(course.getLanguage()));
        }
        if (course.getDescription() != null) {
            coursedto.setDescription(course.getDescription());
        }
        if (course.isIsActivated() == true) {
            coursedto.setIsActivated(course.isIsActivated());
        }
        if (course.getDuration() != null) {
            DurationDTO durationDTO = new DurationDTO();
            durationDTO.setName(course.getDuration().getName());
            coursedto.setDuration(durationDTO);
        }
        if (course.getLanguage() != null) {
            LanguageDTO languageDTO = new LanguageDTO();
            languageDTO.setName(course.getLanguage().getName());
            coursedto.setLanguage(languageDTO);
        }
        if (course.getAuthor() != null) {
            UserDTO author = new UserDTO();
            author.setName(course.getAuthor().getName());
            coursedto.setAuthor(author);
        }
        return coursedto;
    }

    public static CourseDTO toCourseDTO(Course course) {
        CourseDTO coursedto = new CourseDTO();
        coursedto.setCourseId(course.getCourseId());
        if (course.getName() != null) {
            coursedto.setName(course.getName());
        }
        if (course.getCategory() != null) {
            coursedto.setCategory(toDTO(course.getCategory()));
        }
        coursedto.setPrice(course.getPrice());
        if (course.getLevel() != null) {
            coursedto.setLevel(toDTO(course.getLevel()));
        }

        if (course.getImg() != null) {
            coursedto.setImg(course.getImg());
        }
        if (course.getLanguage() != null) {
            coursedto.setLanguage(toDTO(course.getLanguage()));
        }
        if (course.getDescription() != null) {
            coursedto.setDescription(course.getDescription());
        }
        if (course.isIsActivated() == true) {
            coursedto.setIsActivated(course.isIsActivated());
        }
        if (course.getDuration() != null) {
            DurationDTO durationDTO = new DurationDTO();
            durationDTO.setName(course.getDuration().getName());
            coursedto.setDuration(durationDTO);
        }
        if (course.getLanguage() != null) {
            LanguageDTO languageDTO = new LanguageDTO();
            languageDTO.setName(course.getLanguage().getName());
            coursedto.setLanguage(languageDTO);
        }
        if (course.getAuthor() != null) {
            UserDTO author = new UserDTO();
            author.setName(course.getAuthor().getName());
            coursedto.setAuthor(author);
        }
        return coursedto;
    }

    public static List<CourseDTO> toDTOList(List<Course> courses) {
        List<CourseDTO> coursedtos = new ArrayList<>();

        for (int i = 0; i < courses.size(); i++) {
            CourseDTO cdto = toCourseDTO(courses.get(i));
            coursedtos.add(cdto);
        }

        return coursedtos;
    }

    public static List<CourseDTO> toDTO(List<Course> courses) {
        List<CourseDTO> coursedtos = new ArrayList<>();

        for (int i = 0; i < courses.size(); i++) {
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
        if (user.getImg() != null) {
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
        if(blog.getImg()!=null){
        blogDTO.setImg(blog.getImg());
        }
        if(blog.isIsActivated()==true){
            blogDTO.setIsActivated(blog.isIsActivated());
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
    public static List<BlogCategoryDTO> toBlogCategoryDTO(List<BlogCategory> blogCategorys) {
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

    public static CourseRegistrationDTO toDto(CourseRegistration registeration) {
        CourseRegistrationDTO courseRegisterationDTO = new CourseRegistrationDTO();
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setCourseId(registeration.getCourse().getCourseId());
        courseRegisterationDTO.setCourse(courseDTO);
        UserDTO user = new UserDTO();
        user.setUserId(registeration.getUser().getUserId());
        courseRegisterationDTO.setUser(user);
        courseRegisterationDTO.setCourseRegisterationId(registeration.getCourseRegisterationId());
        return courseRegisterationDTO;
    }

    public static TransactionDTO toDto(Transaction transaction) {
        TransactionDTO dto = new TransactionDTO();
        dto.setTransactionId(transaction.getTransactionId());
        dto.setAmount(transaction.getAmount());
        dto.setCreatedTime(transaction.getCreatedTime());
        dto.setStatus(transaction.isStatus());
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccId(transaction.getAccount().getAccId());
        dto.setAcc(accountDTO);
        return dto;
    }
    
    public static CourseDTO toDto4(Course course) {
        CourseDTO dto = new CourseDTO();
        dto.setCourseId(course.getCourseId());
        dto.setName(course.getName());
        dto.setDescription(course.getDescription());
        dto.setImg(course.getImg());
        dto.setPrice(course.getPrice());
        
        CourseCategoryDTO categoryDTO = new CourseCategoryDTO();
        categoryDTO.setCourseCategoryId(course.getCategory().getCourseCategoryId());
        categoryDTO.setName(course.getCategory().getName());
        dto.setCategory(categoryDTO);
        
        UserDTO u = new UserDTO();
        u.setUserId(course.getAuthor().getUserId());
        u.setName(course.getAuthor().getName());
        dto.setAuthor(u);
        
        LevelDTO l = new LevelDTO();
        l.setLevelId(course.getLevel().getLevelId());
        l.setName(course.getLevel().getName());
        dto.setLevel(l);
        
        DurationDTO d = new DurationDTO();
        d.setDurationId(course.getDuration().getDurationId());
        d.setName(course.getDuration().getName());
        dto.setDuration(d);
        
        LanguageDTO la = new LanguageDTO();
        la.setLanguageId(course.getLevel().getLevelId());
        la.setName(course.getLevel().getName());
        dto.setLanguage(la);
        
        return dto;
    }
    
    public static UserDTO toDTO1(User user) {
        UserDTO userDTO = new UserDTO();
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setEmail(user.getAccount().getEmail());
        userDTO.setAccount(accountDTO);
        return userDTO;
    }

    public static CourseDTO toDTO2(Course course) {
        CourseDTO cdto = new CourseDTO();
        cdto.setName(course.getName());
        CourseCategoryDTO ccdto = new CourseCategoryDTO();
        ccdto.setName(course.getCategory().getName());
        cdto.setCategory(ccdto);
        DurationDTO ddto = new DurationDTO();
        ddto.setName(course.getDuration().getName());
        cdto.setDuration(ddto);
        cdto.setPrice(course.getPrice());
        return cdto;
    }

    public static CourseDTO toDTO4(Course course) {
        CourseDTO cdto = new CourseDTO();
        cdto.setCourseId(course.getCourseId());
        cdto.setName(course.getName());

        LevelDTO leveldto = new LevelDTO();
        leveldto.setName(course.getLevel().getName());
        cdto.setLevel(leveldto);

        LanguageDTO languageDTO = new LanguageDTO();
        languageDTO.setName(course.getLanguage().getName());
        cdto.setLanguage(languageDTO);

        cdto.setImg(course.getImg());
        cdto.setDescription(course.getDescription());
        UserDTO author = new UserDTO();
        author.setImg(course.getAuthor().getImg());
        author.setName(course.getAuthor().getName());
        cdto.setAuthor(author);

        CourseCategoryDTO ccdto = new CourseCategoryDTO();
        ccdto.setName(course.getCategory().getName());
        cdto.setCategory(ccdto);
        DurationDTO ddto = new DurationDTO();
        ddto.setName(course.getDuration().getName());
        cdto.setDuration(ddto);
        cdto.setPrice(course.getPrice());
        
        return cdto;
    }

    public static CourseRegistrationDTO toDTO1(CourseRegistration courseRegistration) {
        CourseRegistrationDTO courseRegistrationDTO = new CourseRegistrationDTO();
        courseRegistrationDTO.setCourseRegisterationId(courseRegistration.getCourseRegisterationId());

        UserDTO udto = Converter.toDTO1(courseRegistration.getUser());
        courseRegistrationDTO.setUser(udto);

        CourseDTO cdto = Converter.toDTO2(courseRegistration.getCourse());
        courseRegistrationDTO.setCourse(cdto);

        courseRegistrationDTO.setCreatedTime(courseRegistration.getCreatedTime());

        return courseRegistrationDTO;
    }
    
    public static CourseRegistrationDTO toDTO2(CourseRegistration courseRegisteration){
        CourseRegistrationDTO courseRegisterationDTO = new CourseRegistrationDTO();
        courseRegisteration.setCourseRegisterationId(courseRegisteration.getCourseRegisterationId());
        
        UserDTO udto = Converter.toDTO(courseRegisteration.getUser());
        courseRegisterationDTO.setUser(udto);
        
        CourseDTO cdto = Converter.toDTO4(courseRegisteration.getCourse());
        courseRegisterationDTO.setCourse(cdto);
        
        courseRegisterationDTO.setCreatedTime(courseRegisteration.getCreatedTime());
        
        return courseRegisterationDTO;
              
    }
    public static CourseRegistrationDTO toDto2(CourseRegistration registeration) {
        CourseRegistrationDTO courseRegisterationDTO = new CourseRegistrationDTO();
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setCourseId(registeration.getCourse().getCourseId());
        courseDTO.setName(registeration.getCourse().getName());
        courseDTO.setPrice(registeration.getCourse().getPrice());
        courseRegisterationDTO.setCourse(courseDTO);
        UserDTO user = new UserDTO();
        user.setUserId(registeration.getUser().getUserId());
        AccountDTO adto= new AccountDTO();
        adto.setEmail(registeration.getUser().getAccount().getEmail());
        user.setAccount(adto);
        courseRegisterationDTO.setUser(user);
        courseRegisterationDTO.setCourseRegisterationId(registeration.getCourseRegisterationId());
        courseRegisterationDTO.setCreatedTime(registeration.getCreatedTime());
        return courseRegisterationDTO;
    }
    public static UserDTO toDTO2(User u)
    {
        UserDTO udto= new UserDTO();
        
        AccountDTO adto= new AccountDTO();
        adto.setAccId(u.getAccount().getAccId());
        adto.setEmail(u.getAccount().getEmail());
        adto.setCreatedTime(u.getAccount().getCreatedTime());
        adto.setRegisteredTime(u.getAccount().getRegisteredTime());
        
        udto.setAccount(adto);
        udto.setName(u.getName());
        
        return udto;
    }
    public static CourseRegistrationDTO toTrendCourseDTO(CourseRegistration c)
    {
        CourseDTO cdto= new CourseDTO();
        cdto.setCourseId(c.getCourse().getCourseId());
        cdto.setName(c.getCourse().getName());
        CourseRegistrationDTO crdto= new CourseRegistrationDTO();
        crdto.setCourse(cdto);
        return crdto;
    }
    
    public static BlogViewDTO toDTO(BlogView bv)
    {
        BlogViewDTO bvdto= new BlogViewDTO();
        BlogDTO bdto= new BlogDTO();
        bdto.setTitle(bv.getBlog().getTitle());
        bdto.setBlogId(bv.getBlog().getBlogId());
        bvdto.setBlog(bdto);
        return bvdto;
    }
    public static BlogView toDomain(BlogViewDTO bvdto)
    {
        BlogView bv= new BlogView();
        Blog b= new Blog();
        b.setBlogId(bvdto.getBlog().getBlogId());
        if(bvdto.getUser()!=null)
        {
            User u = new User();
            u.setUserId(bvdto.getUser().getUserId());
            bv.setUser(u);
        }
        bv.setBlog(b);
        bv.setViewTime(bvdto.getViewTime());
        return bv;
                
    }
    public static PostDTO toDto4(Post post) {
        PostDTO dTO = new PostDTO();
        dTO.setPostId(post.getPostId());
        dTO.setTitle(post.getTitle());
        return dTO;
    }

    public static SliderDTO toDto4(Slider slider) {
        SliderDTO sliderDTO = new SliderDTO();
        if (slider.getImg() != null) {
            sliderDTO.setImg(slider.getImg());
        }
        if (slider.getPost() != null) {
            sliderDTO.setPost(toDto4(slider.getPost()));
        }
        sliderDTO.setSliderId(slider.getSliderId());
        sliderDTO.setStatus(slider.getStatus());
        if (slider.getCreatedTime() != null) {
            sliderDTO.setCreatedTime(slider.getCreatedTime());
        }
        sliderDTO.setDescription(slider.getDescription());
        sliderDTO.setTitle(slider.getTitle());
        return sliderDTO;
    }

    public static List<SliderDTO> toDto4(List<Slider> sliders) {
        List<SliderDTO> dTOs = new ArrayList<>();
        for (int i = 0; i < sliders.size(); i++) {
            dTOs.add(toDto4(sliders.get(i)));
        }
        return dTOs;
    }

    public static List<PostDTO> toPostDto3(List<Post> posts) {
        List<PostDTO> dTOs = new ArrayList<>();
        for (int i = 0; i < posts.size(); i++) {
            dTOs.add(toDto4(posts.get(i)));
        }
        return dTOs;
    }

    public static Slider toSliderInsertDomain(SliderDTO sliderDTO) {
        Slider slider = new Slider();
        slider.setImg(sliderDTO.getImg());
        slider.setTitle(sliderDTO.getTitle());
        slider.setStatus(sliderDTO.getStatus());
        slider.setDescription(sliderDTO.getDescription());
        slider.setCreatedTime(sliderDTO.getCreatedTime());
        Post post = new Post();
        post.setPostId(sliderDTO.getPost().getPostId());
        slider.setPost(post);
        return slider;
    }

    public static Slider toSliderUpdateDomain(SliderDTO sliderDTO) {
        Slider slider = new Slider();
        slider.setImg(sliderDTO.getImg());
        slider.setTitle(sliderDTO.getTitle());
        slider.setStatus(sliderDTO.getStatus());
        slider.setDescription(sliderDTO.getDescription());
        slider.setSliderId(sliderDTO.getSliderId());
        Post post = new Post();
        post.setPostId(sliderDTO.getPost().getPostId());
        slider.setPost(post);
        return slider;
    }

    public static PostDTO toDto5(Post post) {
        PostDTO dTO = new PostDTO();
        dTO.setPostId(post.getPostId());
        dTO.setTitle(post.getTitle());
        if (post.getCreatedTime() != null) {
            dTO.setCreatedTime(post.getCreatedTime());
        }
        if (post.getContent() != null) {
            dTO.setContent(post.getContent());
        }
        dTO.setStatus(post.getStatus());
        PostCategoryDTO categoryDTO = new PostCategoryDTO();
        categoryDTO.setPostCategoryId(post.getPostCategory().getPostCategoryId());
        categoryDTO.setName(post.getPostCategory().getName());
        dTO.setPostCategory(categoryDTO);
        return dTO;
    }

    public static List<PostDTO> toPostDto4(List<Post> posts) {
        List<PostDTO> dTOs = new ArrayList<>();
        for (int i = 0; i < posts.size(); i++) {
            dTOs.add(toDto5(posts.get(i)));
        }
        return dTOs;
    }

    public static PostCategoryDTO toDto3(PostCategory category) {
        PostCategoryDTO dTO = new PostCategoryDTO();
        dTO.setPostCategoryId(category.getPostCategoryId());
        dTO.setName(category.getName());
        return dTO;
    }

    public static List<PostCategoryDTO> toPostCategoryDto3(List<PostCategory> categorys) {
        List<PostCategoryDTO> dTOs = new ArrayList<>();
        for (int i = 0; i < categorys.size(); i++) {
            dTOs.add(toDto3(categorys.get(i)));
        }
        return dTOs;
    }

    public static Post toPostUpdateDomain(PostDTO postDTO) {
        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setStatus(postDTO.getStatus());
        post.setContent(postDTO.getContent());
        post.setPostId(postDTO.getPostId());
        PostCategory postCategory = new PostCategory();
        postCategory.setPostCategoryId(postDTO.getPostCategory().getPostCategoryId());
        post.setPostCategory(postCategory);
        return post;
    }
    public static Post toPostInserteDomain(PostDTO postDTO) {
        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setStatus(postDTO.getStatus());
        post.setContent(postDTO.getContent());
        post.setCreatedTime(postDTO.getCreatedTime());
        PostCategory postCategory = new PostCategory();
        postCategory.setPostCategoryId(postDTO.getPostCategory().getPostCategoryId());
        post.setPostCategory(postCategory);
        return post;
    }
    
    public static ChapterDTO toDto(Chapter chapter) {
        ChapterDTO dto = new ChapterDTO();
        dto.setChapterId(chapter.getChapterId());
        dto.setName(chapter.getName());
        return dto;
    }
    
    public static LessonDTO toDto(Lesson lesson) {
        LessonDTO dto = new LessonDTO();
        dto.setLessonId(lesson.getLessonId());
        dto.setName(lesson.getName());
        dto.setContent(lesson.getContent());
        
        LessonTypeDTO lt = new LessonTypeDTO();
        lt.setTypeId(lesson.getType().getTypeId());
        dto.setType(lt);
        
        dto.setDuration(lesson.getDuration());
        ChapterDTO c = new ChapterDTO();
        c.setName(lesson.getChapter().getName());
        c.setChapterId(lesson.getChapter().getChapterId());
        dto.setChapter(c);
        return dto;
    }
    
    public static UserLessonDTO toDto(UserLesson ul) {
        UserLessonDTO dto = new UserLessonDTO();
        LessonDTO l = toDto(ul.getLesson());
        dto.setLesson(l);
        
        UserDTO udto = new UserDTO();
        udto.setUserId(ul.getUser().getUserId());
        dto.setUser(udto);
        
        dto.setUserLessonId(ul.getUserLessonId());
        dto.setFinish(ul.isFinish());
        return dto;
    }
     //Tien viet
    public static Setting toDomain(SettingDTO dto) {
        Setting domain = new Setting();
        domain.setName(dto.getName());
        SettingType st = new SettingType();
        st.setTypeid(dto.getType().getTypeid());
        st.setName(dto.getType().getName());
        domain.setType(st);
        domain.setOrder(dto.getOrder());
        domain.setStatus(dto.isStatus());
        return domain;
    }
    //Tien viet
    public static SettingTypeDTO toDTO(SettingType set) {
        SettingTypeDTO roleDTO = new SettingTypeDTO();
        roleDTO.setName(set.getName());
        roleDTO.setTypeid(set.getTypeid());

        return roleDTO;
    }
    //MTien viet
    public static List<SettingTypeDTO> toSettingTypeDTO(List<SettingType> role) {
        List<SettingTypeDTO> roledtos = new ArrayList<>();

        for (int i = 0; i < role.size(); i++) {
            SettingTypeDTO cdto = toDTO(role.get(i));
            roledtos.add(cdto);
        }
        return roledtos;
    }
    //MTien viet
    public static SettingDTO toDTO(Setting set) {
        SettingDTO roleDTO = new SettingDTO();
        roleDTO.setName(set.getName());
        
        SettingTypeDTO st = new SettingTypeDTO();
        st.setTypeid(set.getType().getTypeid());
        st.setName(set.getType().getName());
        roleDTO.setType(st);
        roleDTO.setOrder(set.getOrder());
        roleDTO.setStatus(set.isStatus());
        return roleDTO;
    }
    //MTien viet
    public static List<SettingDTO> toSettingDTO(List<Setting> role) {
        List<SettingDTO> roledtos = new ArrayList<>();

        for (int i = 0; i < role.size(); i++) {
            SettingDTO cdto = toDTO(role.get(i));
            roledtos.add(cdto);
        }
        return roledtos;
    }
    //MTien viet
    public static List<RoleDTO> toRoleDTO(List<Role> role) {
        List<RoleDTO> roledtos = new ArrayList<>();

        for (int i = 0; i < role.size(); i++) {
            RoleDTO cdto = toDTO(role.get(i));
            roledtos.add(cdto);
        }
        return roledtos;
    }
    
    public static Account toDomain1(AccountDTO dto) {
        Account domain = new Account();
        domain.setAccId(dto.getAccId());
        domain.setIsActivated(dto.getIsActivated());
        domain.setOtp(dto.getOtp());
        Role role = new Role();
        role.setRoleId(dto.getRole().getRoleId());
        domain.setRole(role);
        return domain;
    }
    
    //MTien viet
    public static Account toDomain2(AccountDTO dto) {
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
    //MTien viet
    public static UserDTO toDTOTien(User user) {
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
        RoleDTO role = new RoleDTO();
        role.setRoleId(user.getAccount().getRole().getRoleId());
        role.setName(user.getAccount().getRole().getName());
        AccountDTO a = new AccountDTO();
        a.setAccId(user.getAccount().getAccId());
        a.setEmail(user.getAccount().getEmail());
        a.setIsActivated(user.getAccount().getIsActivated());
        a.setRole(role);
        a.setCreatedTime(user.getAccount().getCreatedTime());
        userDTO.setAccount(a);

        return userDTO;
    }
    //MTien viet
    public static UserDTO toDTOTien1(User user) {
        UserDTO userDTO = new UserDTO();

        
        userDTO.setPhone(user.getPhone());
        
        return userDTO;
    }
    //MTien viet
    public static List<UserDTO> usertoDTO(List<User> user) {
        List<UserDTO> userdtos = new ArrayList<>();

        for (int i = 0; i < user.size(); i++) {
            UserDTO cdto = toDTOTien(user.get(i));
            userdtos.add(cdto);
        }

        return userdtos;
    }
    //MTien viet
        public static User toDomain2(UserDTO udto) {
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
        Role role = new Role();
        role.setRoleId(udto.getAccount().getRole().getRoleId());
        role.setName(udto.getAccount().getRole().getName());
        Account a = new Account();
        a.setAccId(udto.getAccount().getAccId());
        a.setEmail(udto.getAccount().getEmail());
        a.setIsActivated(udto.getAccount().getIsActivated());
        a.setRole(role);
        u.setAccount(a);

        return u;
    }
    public static CourseRegistrationDTO toDTO3(CourseRegistration cr) {
        CourseRegistrationDTO crdto= new CourseRegistrationDTO();
        CourseDTO cdto= new CourseDTO();
        cdto.setCourseId(cr.getCourse().getCourseId());
        cdto.setName(cr.getCourse().getName());
        cdto.setImg(cr.getCourse().getImg());
        CourseCategoryDTO ccdto= new CourseCategoryDTO();
        ccdto.setCourseCategoryId(cr.getCourse().getCategory().getCourseCategoryId());
        ccdto.setName(cr.getCourse().getCategory().getName());
        cdto.setCategory(ccdto);
        UserDTO udto= new UserDTO();
        udto.setUserId(cr.getUser().getUserId());
        crdto.setCourse(cdto);
        crdto.setUser(udto);
                
        return crdto;
    }
    public static Blog toBlogDomain(BlogDTO blogDTO){
        Blog blog=new Blog();
        blog.setBlogId(blogDTO.getBlogId());
        BlogCategory bc = new BlogCategory();
        bc.setBlogCategoryId(blogDTO.getCategory().getBlogCategoryId());
        blog.setCategory(bc);
        blog.setContent(blogDTO.getContent());
        blog.setImg(blogDTO.getImg());
        blog.setQuickReview(blogDTO.getQuickReview());
        blog.setTitle(blogDTO.getTitle());
        return blog;
    }
    public static Blog toBlogDomain1(BlogDTO blogDTO){
        Blog blog=new Blog();
        BlogCategory bc = new BlogCategory();
        bc.setBlogCategoryId(blogDTO.getCategory().getBlogCategoryId());
        blog.setCategory(bc);
        blog.setContent(blogDTO.getContent());
        blog.setImg(blogDTO.getImg());
        blog.setQuickReview(blogDTO.getQuickReview());
        blog.setTitle(blogDTO.getTitle());
        blog.setCreatedTime(blogDTO.getCreatedTime());
        User user= new User();
        user.setUserId(blogDTO.getAuthor().getUserId());
        blog.setAuthor(user);
        blog.setIsActivated(false);
        return blog;
    }
    
}
