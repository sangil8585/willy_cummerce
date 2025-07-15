package com.loopers.domain.user;

import com.loopers.support.error.CoreException;
import com.loopers.support.error.ErrorType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@Slf4j
public class UserTest {

    @Test
    @DisplayName("ID가 10자 초과일 경우 유저 생성에 실패해야 한다.")
    void idTooLongThrowException() {
        // Given
        String id = "sangil8585sangil8585";
        String email = "sangil8585@naver.com";
        String birthday = "1993-02-24";
        Gender gender = Gender.valueOf("MALE");

        // When
        CoreException ex = assertThrows(CoreException.class, () ->
            new User(id, email, birthday, gender)
        );
        // Then
        assertEquals(ErrorType.BAD_REQUEST, ex.getErrorType());
        assertEquals("ID는 10자를 초과할 수 없습니다.", ex.getCustomMessage());

    }

    @Test
    @DisplayName("이메일이 잘못된 형식으로 되어 있는 경우 예외를 발생한다.")
    void emailIsLongType() {
        // Given
        String id = "sangil8585";
        String email = "sangil8585@@naver.com";
        String birthday = "1993-02-24";
        Gender gender = Gender.valueOf("MALE");

        // When
        CoreException ex = assertThrows(CoreException.class, () ->
                new User(id, email, birthday, gender)
        );
        // Then
        assertEquals(ErrorType.BAD_REQUEST, ex.getErrorType());
        assertEquals("EMAIL 형식에 맞지 않습니다.", ex.getCustomMessage());
    }
}
