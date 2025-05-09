package hello.schedule.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;

/*
* 이 클래스는 필터에 관한 공부용으로 구현한곳이므로 과제랑 상관없는 내용입니다 ! 참고해주세요 !
*
* */
@Slf4j
public class LoginFilter implements Filter {

     //(로그인 하지 않나도될 URL? ) 인증을 하지 않아도 될 URL 이라는데 어떤 URL을 넣어야 하는지
    private static final String[] WHITE_LIST = {"/schedules/signup", "/schedules/login"};

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain filterChain
    ) throws IOException, ServletException {

        //다운캐스팅을 해서 -->> 다양한 기능을 더 사용할수 있다.
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();

        //  만약 URL이 포함되어 있지 않으면? -->필터를 실행해라
        // 로그인을 체크 해야하는 URL인지 검사한다.

        if (!isWhiteList(requestURI)) {
            // 로그인 확인 -> 로그인하면 session에 값이 저장되어 있다는 가정.
            // 세션이 존재하면 가져온다. 세션이 없으면 session = null
            HttpSession session = httpRequest.getSession(false);

            if (session == null || session.getAttribute("sessionKey") == null) {
                throw new RuntimeException("로그인 해주세요");
            }
            log.info("로그인된 사용자요청 : {}", requestURI);
        }
        // 다음 필터로 -->>> 없으면 다음 필터 없으면 Servlet -> Controller 호출
        filterChain.doFilter(request, response);
    }
    private boolean isWhiteList(String requestURL) {

        return PatternMatchUtils.simpleMatch(WHITE_LIST, requestURL);
    }
}
