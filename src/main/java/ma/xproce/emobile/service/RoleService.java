package ma.xproce.emobile.service;

import ma.xproce.emobile.dao.entities.Role;
import ma.xproce.emobile.service.dto.RoleDTO;
import ma.xproce.emobile.service.dto.RoleDTOADD;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface RoleService {
    List<RoleDTO> getAllRole();

    RoleDTO addCompte(RoleDTOADD roleDTOADD);

    void saveRole(RoleDTO roleDTO);

    Role findRoleByNom(String user);
}
