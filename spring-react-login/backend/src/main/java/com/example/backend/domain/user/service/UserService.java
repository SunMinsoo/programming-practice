package com.example.backend.domain.user.service;

import com.example.backend.domain.user.dto.UserRequestDTO;
import com.example.backend.domain.user.entity.UserEntity;
import com.example.backend.domain.user.entity.UserRoleType;
import com.example.backend.domain.user.repository.UserRepository;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    /**
     * 1. 자체 로그인 회원 가입 (존재 여부)
     * 회원 가입 시 username의 존재 여부 확인
     */
    @Transactional(readOnly = true)
    public Boolean existUser(UserRequestDTO dto) {
        return userRepository.existsByUsername(dto.getUsername());
    }

    /** 2. 자체 로그인 회원 가입
     * @return 추가한 회원의 등록번호
     */
    @Transactional
    public long addUser(UserRequestDTO dto) {
        // API 테스트 또는 악의적으로 Back단에 직접 API로 쓰는 경우를 위함
        if (existUser(dto)) {
            throw new IllegalArgumentException("이미 유저가 존재합니다");
        }

        UserEntity entity = UserEntity.builder()
                .username(dto.getUsername())
                .password(passwordEncoder.encode(dto.getPassword()))
                .isLock(false)
                .isSocial(false)
                .roleType(UserRoleType.USER)
                .nickname(dto.getUsername())
                .email(dto.getEmail())
                .build();

        return userRepository.save(entity).getId();
    }

    /** 3. 자체 로그인
     * 회원 로그인 시는 읽기만 수행, implements로 해당 메소드를 Override가 필수
     */
    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity entity = userRepository.findByUsernameAndIsLockAndIsSocial(username, false, false)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        return User.builder()
                .username(entity.getUsername())
                .password(entity.getPassword())
                .roles(entity.getRoleType().name())
                .accountExpired(entity.getIsLock())
                .build();
    }

    /** 4. 자체 로그인 회원 정보 수정
     * 회원 정보 수정 시 자체 로그인, 여브 및 잠김 여부 확인 필요
     * https://www.youtube.com/watch?v=0QSczASWcMA
     */
    @Transactional
    public Long updateUser(UserRequestDTO dto) {
        String sessionUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        // 현재 세션의 User와 같은지 검증
        if (!sessionUsername.equals(dto.getUsername())) {
            throw new AccessDeniedException("본인 계정만 수정 가능합니다.");
        }

        // 조회 기능
        UserEntity entity = userRepository.findByUsernameAndIsLockAndIsSocial(dto.getUsername(), false, false)
                .orElseThrow(() -> new UsernameNotFoundException(dto.getUsername()));

        // 입력된 회원 정보 수정
        entity.updateUser(dto);

        return userRepository.save(entity).getId();
    }

    /** 5. 자체/소셜 로그인 회원 탈퇴
     *
     */

    /** 6. 소설 로그인 (매 로그인시 : 신규 = 가입, 기존 = 업데이트)
     *
     */

    /** 7. 자체/소셜 유저 정보 조회
     *
     */
}
