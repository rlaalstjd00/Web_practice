package com.springprac.ex01.sevice;

import com.springprac.ex01.domain.User;
import com.springprac.ex01.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    // 회원가입
    public Long join(User user){
        // 중복회원 검증
        validateDuplicateUser(user);
        userRepository.save(user);
        return user.getId();
    }

    // 중복 회원 검증
    private void validateDuplicateUser(User user){
        userRepository.findByName(user.getName())
                .ifPresent(m->{
                    throw new IllegalStateException("이미 존재하는 회원입니다");
                });
    }

    public List<User> findUsers(){
        return userRepository.findAll();
    }

    public Optional<User> findOne(Long userid){
        return userRepository.findById(userid);
    }
}
