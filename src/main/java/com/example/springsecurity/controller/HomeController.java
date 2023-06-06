package com.example.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.springsecurity.model.Usuario;
import com.example.springsecurity.service.UserService;

@Controller
public class HomeController {

    private UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "login";
    }

    @GetMapping("/cadastro")
    public String cadastro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastrar(@ModelAttribute("usuario") Usuario usuario) {
        userService.save(usuario);
        return "redirect:/login?cadastrado";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login?logout";
    }
}


/* 
@RestController
@RequestMapping("/")
public class HomeController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("usuarios", usuarioRepository.findAll());
        modelAndView.addObject("usuario", new Usuario());
        System.out.println("Login realizado com sucesso");
        return modelAndView;
    }

    @GetMapping("/cadastro")
    public ModelAndView cadastro() {
        ModelAndView modelAndView = new ModelAndView("cadastro");
        modelAndView.addObject("usuarios", usuarioRepository.findAll());
        modelAndView.addObject("usuario", new Usuario());
        System.out.println("Cadastro realizado com sucesso");
        return modelAndView;
    }

    @PostMapping("/cadastro")
    public RedirectView cadastrarUsuario(@ModelAttribute("usuario") Usuario usuario) {
        // Salvar os dados do usuário no banco de dados
        usuarioRepository.save(usuario);

        // Redirecionar para a página de login
        return new RedirectView("/login", true);
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:login";
    }

}*/
