package hello.schedule.filter.dto;

import hello.schedule.filter.entity.Role;
import lombok.Getter;

@Getter
public class UserResponseDto {

    private final Role role;

    public UserResponseDto(Role role) {
        this.role = role;
    }
}
