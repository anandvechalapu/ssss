·       After clicking on Log Out button, user should be logged out immediately and redirected to the login screen.
 

Controller:
@Controller
public class LogoutController {

    @GetMapping("/logout")
    public String logOut(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";
    }

}

Service:
@Service
public class LogoutService {

    @Autowired
    private LogoutController logoutController;

    public void logOut(HttpServletRequest request, HttpServletResponse response) {
        logoutController.logOut(request, response);
    }

}

Repository:
@Repository
public interface LogoutRepository {

    @Query("DELETE FROM User u WHERE u.username = ?1")
    void logOut(String username);

}