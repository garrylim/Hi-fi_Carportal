package com.example.demo.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.Entity.Role;
import com.example.demo.Entity.User;
import com.example.demo.Repository.RoleRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.*;;

@Controller

public class CommonController{

    @Autowired
    private UserRepository UserRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired UserService userService;

    //Index Page
    @GetMapping("/")
    public String getHomepage() {
        return "index";
    }

    @GetMapping("/dashboard")
		public String getDashboardPage(Model model, @AuthenticationPrincipal CustomUserDetails loggedinUser) {
			model.addAttribute("username", loggedinUser.getUsername());
			
			User user = userService.getUserByUsername(loggedinUser.getUsername());
			model.addAttribute("user_id", user.getId());
			
			List<User> users = userService.retrieveAllUserProfile();
			model.addAttribute("users", users);	
			
			long count = userService.countRegisteredUser();
			model.addAttribute("count", count);
			
			return "dashboard";
		}

        @PostMapping("/process_signup")
        public String registerUser(@ModelAttribute("user") User user, Model model, RedirectAttributes redirectAttributes,
            @RequestParam(value = "role", required = false) String roleName) {

        User existingUser = UserRepository.findUserByEmail(user.getEmail());
        if (existingUser != null) {
            redirectAttributes.addFlashAttribute("message", "User with this email already exists! Please Sign In");
            return "redirect:/messagePage";
        }

        Role role = roleRepository.findByName("USER");
        if (role == null) {
            role = new Role("USER");
            roleRepository.save(role);
        }
        user.addRole(role);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        UserRepository.save(user);

        return "index";
    }


    @GetMapping("/messagePage")
    public String showMessage(Model model, @ModelAttribute("message") String message) {
        model.addAttribute("message", message);
        return "messagePage";
    }
  
    // get profile page
@GetMapping("/profile")
public String getProfilePage(Model model, @RequestParam("user_id") Long userId) {
    User user = userService.getUserById(userId); //this should link to your service file
    model.addAttribute("user", user);
    return "profile";
}

@GetMapping("/update-profile")
public String getUpdateProfilePage(Model model, @RequestParam("user_id") Long userId) {
    // Get user from database by ID
    User user = userService.getUserById(userId);

    // Add user object to the model
    model.addAttribute("user", user);

    // Return the update profile view
    return "update-profile";
}

@PostMapping("/update-profile")  
public String updateUserProfile(Model model, @ModelAttribute("user") User tmp, @RequestParam("user_id") Long userId,
        @AuthenticationPrincipal CustomUserDetails loggedinUser) {
    System.out.println("user_id: " + userId);
    User user = userService.getUserById(userId);
    
    user.setUsername(tmp.getUsername());
    user.setEmail(tmp.getEmail()); // add this line to update the email
    loggedinUser.setUsername(tmp.getUsername());
    userService.updateUser(user);

    return "redirect:dashboard";  //back to the page you want
}

    @GetMapping("/storeList")
    public String getStoreList() {
    return "storeList";
    }

    @GetMapping("/users/{user_id}")
public String getUserById(@PathVariable("user_id") Long userId, Model model) {
    System.out.println("User ID passed: " + userId);
    User user = userService.getUserById(userId);
    if (user == null) {
        // Handle user not found error
        return "error-page";
    } else {
        model.addAttribute("user", user);
        return "user-details";
    }
}

}
