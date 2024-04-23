package com.revature.controllers;

import com.revature.daos.GameDAO;
import com.revature.daos.GameCompanyDAO;
import com.revature.models.Game;
import com.revature.models.GameCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/games")
public class GameController {
    private GameDAO gameDao;
    private GameCompanyDAO gameCompanyDao;
    @Autowired
    public GameController(GameCompanyDAO gameCompanyDao, GameDAO gameDao) {
        this.gameCompanyDao = gameCompanyDao;
        this.gameDao = gameDao;
    }

    //select all items from the game table
    @GetMapping
    public ResponseEntity<List<Game>> getAllGames() {
        List<Game> games = gameDao.findAll();
        return ResponseEntity.ok(games);
    }

    //select a game by its id
    @GetMapping("/{gameId}")
    public ResponseEntity<Game> getGameById(@PathVariable int gameId) {
        Game game = gameDao.findByGameId(gameId);
        if (game == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(game);
    }

    //select all games belong to a company
    @GetMapping("/gameCompanies/{companyId}")
    public ResponseEntity<List<Game>> getGamesByCompanyId(@PathVariable int companyId) {
        List<Game> games = gameDao.findByCompanyId(companyId);
        return ResponseEntity.ok(games);
    }

    //add a game into the game table with a company id
    @PostMapping("/{companyId}")
    public ResponseEntity<Game> addGame(@RequestBody Game game, @PathVariable int companyId) {
        GameCompany matchedCompany = gameCompanyDao.findByCompanyId(companyId);
        if (matchedCompany == null) {
            return ResponseEntity.notFound().build();
        }
        game.setCompany(matchedCompany);
        Game g = gameDao.save(game);
        return ResponseEntity.status(201).body(g);
    }

    //delete a game by its id
    @DeleteMapping("/{gameId}")
    public ResponseEntity<Game> deleteGame(@PathVariable int gameId) {
        Game foundGame = gameDao.findByGameId(gameId);
        if (foundGame == null) {
            return ResponseEntity.notFound().build();
        }
        gameDao.delete(foundGame);
        return ResponseEntity.accepted().body(foundGame);
    }

    @GetMapping("/genres/{genre}/gameCompanies/{companyId}")
    public ResponseEntity<List<Game>> getGamesByGenreAndCompanyId(@PathVariable String genre, @PathVariable int companyId) {
        List<Game> games = gameDao.findByCompanyIdAndGenre(companyId, genre);
        return ResponseEntity.ok(games);
    }
}

