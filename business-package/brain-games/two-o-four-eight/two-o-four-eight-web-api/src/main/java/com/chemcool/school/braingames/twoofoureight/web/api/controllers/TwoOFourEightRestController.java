package com.chemcool.school.braingames.twoofoureight.web.api.controllers;

import com.chemcool.school.braingames.twoofoureight.domain.UserScore;
import com.chemcool.school.braingames.twoofoureight.service.UserScoreService;
import com.chemcool.school.braingames.twoofoureight.web.api.jwt.JWTParser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class TwoOFourEightRestController {

    private final JWTParser jwtParser;
    private final UserScoreService userScoreService;
    private final String DBUserID = "100";
    private final String DBUserEmail = null;

    @GetMapping("/valid")
    @ResponseBody
    public String isValid(@RequestHeader(value = "AuthorizationToken") String token) {
        String userID = jwtParser.getIdUserOfToken(token);
        String userEmail = jwtParser.getEmailUserOfToken(token);
        if (userID.equals(DBUserID) && userEmail == DBUserEmail) {
            return Boolean.TRUE.toString();
        }
        return Boolean.FALSE.toString();
    }

    @PostMapping("/saveScore")
    public String getData(@RequestHeader(value = "AuthorizationToken") String token, @RequestBody(required = false) Map<String, String> payload) {
        String userID = jwtParser.getIdUserOfToken(token);
        UserScore userScore = new UserScore();
        userScore.setUserId(userID);
        userScore.setScore(payload.get("score"));
        userScoreService.saveUserScore(userScore);
        System.out.println("User: " + userID + ",  Score:" + userScore.getScore() + " saved to DB");
        return userScore.toString();
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserScore>> getAllUserScoreData(){
        return new ResponseEntity<>(userScoreService.getAllUser(), HttpStatus.OK);
    }
}
