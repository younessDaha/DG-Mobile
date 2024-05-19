package ma.xproce.emobile.service.mapers;

import ma.xproce.emobile.dao.entities.Role;
import ma.xproce.emobile.service.dto.RoleDTO;

import ma.xproce.emobile.service.dto.RoleDTOADD;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component

public class RoleMaper  {
    private ModelMapper modelMapper = new ModelMapper();
    public RoleDTO fromRoleteToRoleDTO(Role role){
        return modelMapper.map(role, RoleDTO.class);
    }

    public Role fromRoleDTOToRole(RoleDTO compteDto){
        return modelMapper.map(compteDto, Role.class);
    }

    public RoleDTOADD fromRoleToRoleDTOADD(Role compte){
        return modelMapper.map(compte, RoleDTOADD.class);
    }

    public Role fromRoleDTOADDToRole(RoleDTOADD compteDTOADD){
        return modelMapper.map(compteDTOADD, Role.class);
    }
}
