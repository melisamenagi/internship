package com.project.catalog1.web;

import com.project.catalog1.converter.TeacherBasicInfoConverter;
import com.project.catalog1.converter.TeacherConverter;
import com.project.catalog1.model.Teacher;
import com.project.catalog1.service.TeacherService;
import com.project.catalog1.web.dto.TeacherBasicInfoDto;
import com.project.catalog1.web.dto.TeacherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/teacher")
public class TeacherController {

//    @Value("${test.value}")
//    private String testValue;

    private final TeacherService teacherService;
    private final TeacherConverter teacherConverter;
    private final TeacherBasicInfoConverter teacherBasicInfoConverter;

    @Autowired  //injects (an instance) of TeacherService in the controller
    public TeacherController(TeacherService teacherService, TeacherConverter teacherConverter,
                             TeacherBasicInfoConverter teacherBasicInfoConverter) {
        this.teacherService = teacherService;
        this.teacherConverter = teacherConverter;
        this.teacherBasicInfoConverter = teacherBasicInfoConverter;
    }

    @GetMapping(value = "/{id}")//in url se pune valoarea deci PathVariable
    public TeacherDto getTeacher(@PathVariable(name = "id")Long id){
        Teacher teacher = teacherService.getTeacher(id);
        return teacherConverter.fromEntityToDto(teacher);
    }

    @GetMapping(value = "/{id}/basic")
    public TeacherBasicInfoDto getTeacherBasicInfo(@PathVariable(name = "id")Long id){
        Teacher teacher = teacherService.getTeacher(id);
        return teacherBasicInfoConverter.fromEntityToDto(teacher);
    }

    @GetMapping(value = "") //? in url si and intre ele, if many deci RequestParam
    public List<TeacherDto> getAll(@RequestParam(name = "cnp", required = false) String cnp,
                                   @RequestParam(name = "firstName",required = false) String firstName,
                                   @RequestParam(name = "lastName", required = false) String lastName) {
        List<Teacher> allTeachers;
        if(cnp!= null) {
            allTeachers = teacherService.getAllTeachersByCnp(cnp);
        }else if (firstName!=null && lastName!=null){
            allTeachers = teacherService.getAllTeachersByName(firstName,lastName);
        }else{
            allTeachers = teacherService.getAllTeachers();
        }
        return teacherConverter.fromEntitiesToDtos(allTeachers);
    }

    @GetMapping(value = "/basic")
    public List<TeacherBasicInfoDto> getAllBasicInfo() {
        List<Teacher> allTeachers = teacherService.getAllTeachers();

        return teacherBasicInfoConverter.fromEntitiesToDtos(allTeachers);
    }

    @PutMapping(value = "/{teacherId}/subject/{subjectId}")
    public TeacherDto assignSubjectToTeacher(@PathVariable(name = "teacherId") Long teacherId,
                                             @PathVariable(name = "subjectId") Long subjectId){
        Teacher teacher = teacherService.assignSubjectToTeacher(teacherId, subjectId);
        return teacherConverter.fromEntityToDto(teacher);
    }

    @PostMapping(value = "")
    public TeacherDto saveTeacher(@Valid @RequestBody TeacherDto teacherDto){
        Teacher teacher = teacherConverter.fromDtoToEntity(teacherDto);
        teacher = teacherService.saveTeacher(teacher);

        return teacherConverter.fromEntityToDto(teacher);
    }

    @PutMapping(value = "/{id}")
    public TeacherDto updateTeacher(@PathVariable(name = "id") Long id,
                                    @Valid @RequestBody TeacherDto teacherDto){
        Teacher teacher = teacherConverter.fromDtoToEntity(teacherDto);
        teacher = teacherService.updateTeacher(id, teacher);

        return teacherConverter.fromEntityToDto(teacher);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTeacher(@PathVariable(name = "id")Long id){
        teacherService.deleteTeacher(id);
    }










//    @GetMapping(value = "/hello")
//    public String hello(){
//        return testValue;
//    }
//
//    @GetMapping(value = "/")
//    public TeacherDto getTeacher(){
//        return teacherService.getTeacher();
//    }

}
