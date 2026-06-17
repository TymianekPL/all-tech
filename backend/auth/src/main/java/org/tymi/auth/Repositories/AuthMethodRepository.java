package org.tymi.auth.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tymi.auth.Models.AuthMethodModel;

import java.util.List;

public interface AuthMethodRepository extends JpaRepository<AuthMethodModel, Integer> {
	List<AuthMethodModel> findAuthMethodModelByUser_Username(String userUsername);
}
