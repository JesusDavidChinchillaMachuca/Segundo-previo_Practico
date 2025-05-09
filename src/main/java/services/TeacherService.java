package services;

import entity.Teacher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.TeacherRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Optional<Teacher> getTeacherById(Long id) {
        return teacherRepository.findById(id);
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher updateTeacher(Long id, Teacher updatedTeacher) {
        return teacherRepository.findById(id)
                .map(existingTeacher -> {
                    existingTeacher.setName(updatedTeacher.getName());
                    existingTeacher.setEmail(updatedTeacher.getEmail());
                    existingTeacher.setPassword(updatedTeacher.getPassword());
                    return teacherRepository.save(existingTeacher);
                })
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }
}
