package com.loopers.domain.user;

public record User(
        String id,
        String email,
        String birthday,
        Gender gender
) {
    public User {
        if(id.length() > 10) {
            throw new IllegalArgumentException("ID는 10자를 초과할 수 없습니다.");
        }

        // 이메일 형식에 맞지 않으면 예외발생 (정상이멜이 예시 : sangil8585@naver.com)
        if(!email.matches("^[\\\\w.-]+@[\\\\w.-]+\\\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("이메일 형식이 맞지 않습니다.");
        }
    }
}
