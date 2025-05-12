package hello.schedule.filter;

import hello.schedule.filter.dto.UserResponseDto;
import hello.schedule.filter.entity.Role;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;

@Slf4j
public class RoleFilter implements Filter {

    private static final String[] ROLE_CHECK_LIST = {"/admin"};

    @Override
    public void doFilter(
            ServletRequest servletRequest,
            ServletResponse servletResponse,
            FilterChain filterChain
    ) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        String requestURI = httpRequest.getRequestURI();

        log.info("권한 확인 필터 로직 실행");

        if (isRoleCheckList(requestURI)) {

            HttpSession session = httpRequest.getSession(false);

            UserResponseDto dto = (UserResponseDto) session.getAttribute("sessionKey");

            if (!dto.getRole().equals(Role.ADMIN)) {
                throw new RuntimeException("관리자 권한이 없습니다.");
            }

        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private boolean isRoleCheckList(String requestURI) {

        return PatternMatchUtils.simpleMatch(ROLE_CHECK_LIST, requestURI);
    }
}
