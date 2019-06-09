/*
 * Created by m.krasilnikov
 */

package ru.bellintegrator.organizationapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.organizationapi.model.entity.Organization;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Repository("organizationRepository")
public interface OrganizationRepository extends JpaRepository<Organization, Integer> {

    public List<Organization> findByNameOrInnOrIsActive(String name,
                                             String inn,
                                             Boolean isActive);

}
