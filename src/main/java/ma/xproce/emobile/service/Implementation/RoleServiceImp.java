package ma.xproce.emobile.service.Implementation;

import ma.xproce.emobile.dao.entities.Role;
import ma.xproce.emobile.dao.repository.RoleRepository;
import ma.xproce.emobile.service.RoleService;
import ma.xproce.emobile.service.dto.RoleDTO;
import ma.xproce.emobile.service.dto.RoleDTOADD;
import ma.xproce.emobile.service.mapers.RoleMaper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component

public class RoleServiceImp implements RoleService {
    @Autowired
    RoleMaper roleMaper;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<RoleDTO> getAllRole() {
        List<Role> roles = roleRepository.findAll();
        List<RoleDTO> roleDTOList = new ArrayList<>();
        for(Role role: roles){
            if(!"adminMan".equals(role.getNom())){
            RoleDTO compteDto = roleMaper.fromRoleteToRoleDTO(role);
            roleDTOList.add(compteDto);}
        }
        return roleDTOList;    }

    @Override
    public RoleDTO addCompte(RoleDTOADD roleDTOADD) {
        Role role = roleMaper.fromRoleDTOADDToRole(roleDTOADD);
        role = roleRepository.save(role) ;
        RoleDTO roleDTO = roleMaper.fromRoleteToRoleDTO(role);
        return roleDTO;
    }

    @Override
    public void saveRole(RoleDTO roleDTO) {
        Role role = new Role();

        // Copier les propriétés de RoleDTO à l'entité Role
        // Assurez-vous que les noms des propriétés dans RoleDTO et Role sont les mêmes
        // pour que BeanUtils puisse les copier correctement
        BeanUtils.copyProperties(role, roleDTO);

        // Sauvegarder l'entité dans la base de données
        roleRepository.save(role);
    }

    @Override
    public Role findRoleByNom(String user) {
        return roleRepository.findRoleByNom(user);
    }


}
