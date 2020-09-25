# Cookie-Session_Exercise

웹에서 상태유지기술
- HTTP 프로토콜은 상태유지불가 => 상태유지를 위해 Cookie, Session 기술 등장

Cookie
- 클라이언트 단에 저장되는 작은 정보의 단위
- 클라이언트 단에서 생성/저장, 서버에서 전송된 쿠기가 저장
- 사용자 컴퓨터에 저장
- 저장된 정보를 다른 사람/시스템이 볼 수 있음
- 유효기간이 지나면 사라짐

Session
- 클라이언트별로 서버에 저장되는 정보
- 서버에 저장
- 서버종료 or 유효기간 지나면 사라짐

Spring Security
- 스프링 시큐리티는 스프링 기반의 어플리케이션 보안을 담당하는 프레임워크
- 보안과 관련된 체계적으로 많은 옵션 지원
- 필터기반으로 동작하기 때문에 MVC와 분리되어 관리 및 동작
- 용어
  * 접근 주체(Principal) : 보호된 대상에 접근하는 유저
  * 인증(Authentication) : 인증은 '증명하다'라는 의미로 예를 들어, 유저 아이디와 비밀번호를 이용하여 로그인 하는
                                   과정 을 말합니다.
  * 인가(Authorization) : '권한부여'나 '허가'와 같은 의미로 사용됩니다. 즉, 어떤 대상이 특정 목적을 실현하도록 허
                                  용(Access) 하는 것을 의미합니다.
  * 권한 : 인증된 주체가 애플리케이션의 동작을 수행할 수 있도록 허락되었는지를 결정할 때 사용합니다.


Spring Security Filter
- 클라이언트(보통 브라우저)는 요청을 보내고 되고, 그 요청을 서블릿이나 JSP등이 처리하게 됩니다. 스프링 MVC에서는 요청을 가장 먼저 받는 것이 DispatcherServlet이라고 했었습니다.
 이 DispatcherServlet이 요청 받기 전에 다양한 필터들이 있을 수 있습니다.
 필터가 하는 역할은 클라이언트와 자원 사이에서 요청과 응답 정보를 이용해 다양한 처리를 하는데 목적이 있습니다. 어떤 필터는 요청을 받은 후, 클라이언트가 원래 요청한 자원이 아닌 다른 자원으로    리다이렉트 시킬 수도 있습니다. 어떤 필터는 다음 필터에게 요청과 응답을 전달하지 않고, 바로 클라이언트에게 응답하고 끝낼 수도 있습니다.
 스프링 시큐리티는 다양한 기능을 가진 필터들을 10개 이상 기본적으로 제공합니다. 이렇게 제공되는 필터들을 Security Filter Chain(시큐리티 필터 체인)이라고 말합니다.
- 필터 종류 
  * SecurityContextPersistenceFilter : SecurityContextRepository에서 SecurityContext를 가져오거나 저장하는 역할을
                                               한다.
  * LogoutFilter : 설정된 로그아웃 URL로 오는 요청을 감시하며, 해당 유저를 로그아웃 처리
  * (UsernamePassword)AuthenticationFilter : (아이디와 비밀번호를 사용하는 form 기반 인증) 설정된 로그인 URL로
                                                          오는 요청을 감시하며, 유저 인증 처리
                                                          1. AuthenticationManager를 통한 인증 실행
                                                          2. 인증 성공 시, 얻은 Authentication 객체를 SecurityContext에 저장 후
                                                             AuthenticationSuccessHandler 실행
                                                          3. 인증 실패 시, AuthenticationFailureHandler 실행
  * DefaultLoginPageGeneratingFilter : 인증을 위한 로그인폼 URL을 감시한다.
  * BasicAuthenticationFilter : HTTP 기본 인증 헤더를 감시하여 처리한다.
  * RequestCacheAwareFilter : 로그인 성공 후, 원래 요청 정보를 재구성하기 위해 사용된다.
  * SecurityContextHolderAwareRequestFilter : HttpServletRequestWrapper를 상속한 SecurityContextHolderAware
                                                            RequestWapper 클래스로 HttpServletRequest 정보를 감싼다. Security
                                                            ContextHolderAwareRequestWrapper 클래스는 필터 체인상의 다음                                                                필터들에게 부가정보를 제공한다.
  * AnonymousAuthenticationFilter : 이 필터가 호출되는 시점까지 사용자 정보가 인증되지 않았다면 인증토큰에
                                               사용자가 익명 사용자로 나타난다.
  * SessionManagementFilter : 이 필터는 인증된 사용자와 관련된 모든 세션을 추적한다.
  * ExceptionTranslationFilter : 이 필터는 보호된 요청을 처리하는 중에 발생할 수 있는 예외를 위임하거나 전달하는
                                       역할을 한다.
  * FilterSecurityInterceptor : 이 필터는 AccessDecisionManager 로 권한부여 처리를 위임함으로써 접근 제어 결정을
                                     쉽게해준다.
