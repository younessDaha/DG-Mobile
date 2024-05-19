package ma.xproce.emobile.web;

import ma.xproce.emobile.service.RoleService;
import ma.xproce.emobile.service.dto.RoleDTO;
import ma.xproce.emobile.service.dto.RoleDTOADD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RoleControlleur {
    @Autowired
    private RoleService roleService;

    @GetMapping("/rolelist")
    public String roleList(Model model, @RequestParam(required = false) String search) {
        List<RoleDTO> roleDTOList = roleService.getAllRole();

        model.addAttribute("roles", roleDTOList);
        return "rolelist";
    }

    @GetMapping("/role/new")
    public String newRoleForm(Model model) {
        model.addAttribute("role", new RoleDTO());
        return "roleform";
    }

//    @PostMapping("/role/save")
//    public String saveRole(@ModelAttribute RoleDTO roleDTO) {
//        roleService.saveRole(roleDTO);
//        return "redirect:/rolelist";
//    }

//    @GetMapping("/role/edit/{id}")
//    public String editRoleForm(@PathVariable Integer id, Model model) {
//        RoleDTO roleDTO = roleService.getRoleById(id);
//        model.addAttribute("role", roleDTO);
//        return "roleform";
//    }
//
//    @GetMapping("/role/delete/{id}")
//    public String deleteRole(@PathVariable Integer id) {
//        roleService.deleteRole(id);
//        return "redirect:/rolelist";
//    }
}

