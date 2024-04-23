package com.revature.daos;

import com.revature.models.GameCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameCompanyDAO extends JpaRepository<GameCompany, Integer> {
    public List<GameCompany> findAll();
    public GameCompany findByCompanyId(int companyId);
    public GameCompany findByName(String name);
    public GameCompany findByLocation(String location);
}
