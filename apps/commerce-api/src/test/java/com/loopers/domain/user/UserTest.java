package com.loopers.domain.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;

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
        assertThrows(IllegalArgumentException.class, () -> {
            new User(id, email, birthday, gender);
        });
        // Then
    }

    @Test
    @DisplayName("이메일이 잘못된 형식으로 되어 있는 경우 예외를 발생한다.")
    void emailIsLongType() {
        // Given
        String id = "sangil8585";
        String email = "sangil8585@@naver.com";
        String birthday = "1993-02-24";
        Gender gender = Gender.valueOf("MALE");

        // When & Then
        assertThrows(IllegalArgumentException.class, () ->
                new User(id, email, birthday, gender));
    }
}
