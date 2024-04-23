package com.revature.daos;
import com.revature.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameDAO extends JpaRepository<Game, Integer>{

    //select all items from the game table

    public List<Game> findAll();
    public Game findByGameId(int gameId);
    public List<Game> findByCompanyId(int companyId);
    public Game findByName(String name);
    public List<Game> findByCompanyIdAndGenre(int companyId, String genre);
}
