package com.loopers.domain.user;

import com.loopers.support.error.CoreException;
import com.loopers.support.error.ErrorType;

public record User(
        String id,
        String email,
        String birthday,
        Gender gender
) {
    public User {
        if(id.length() > 10) {
            throw new CoreException(ErrorType.BAD_REQUEST, "ID는 10자를 초과할 수 없습니다.");
        }

        if(!email.matches("^[\\\\w.-]+@[\\\\w.-]+\\\\.[a-zA-Z]{2,}$")) {
            throw new CoreException(ErrorType.BAD_REQUEST, "EMAIL 형식에 맞지 않습니다.");
        }


    }
}
