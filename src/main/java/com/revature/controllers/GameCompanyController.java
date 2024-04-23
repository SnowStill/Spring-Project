package com.revature.controllers;

import com.revature.daos.GameCompanyDAO;
import com.revature.daos.GameDAO;
import com.revature.models.Game;
import com.revature.models.GameCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/gameCompanies")
public class GameCompanyController {
    private GameCompanyDAO gameCompanyDao;
    private GameDAO gameDao;

    @Autowired
    public GameCompanyController(GameCompanyDAO gameCompanyDao, GameDAO gameDao) {
        this.gameCompanyDao = gameCompanyDao;
        this.gameDao = gameDao;
    }

    //add a game company into the game company table
    @PostMapping()
    public ResponseEntity<GameCompany> addGameCompany(@RequestBody GameCompany gameCompany) {
        //System.console().printf("Game Company: %s\n", gameCompany);
        GameCompany gameComp = gameCompanyDao.save(gameCompany);
        return ResponseEntity.status(201).body(gameComp);
    }

    //update a game company
    @PutMapping("/{companyId}")
    public ResponseEntity<GameCompany> updateGameCompany(@RequestBody GameCompany gameCompany, @PathVariable int companyId) {
        GameCompany matchedCompany = gameCompanyDao.findByCompanyId(companyId);
        if (matchedCompany == null) {
            return ResponseEntity.notFound().build();
        }
        GameCompany updatedCompany = gameCompanyDao.save(gameCompany);
        return ResponseEntity.status(201).body(updatedCompany);
    }
}
