package br.com.jokenpo.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.jokenpo.dto.Player;
import br.com.jokenpo.service.PlayerServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class PlayerServiceTest {
	
	@Autowired
	PlayerServiceImpl playerService;
	
    @Test
    public void savePlayerWithSucess() throws Exception {
        // Clear singleton data
        this.playerService.deleteAll();
        
        // Save one player
        String expectedPlayerName = "PLAYER NAME 1";
        Player player = this.playerService.save(new Player(expectedPlayerName));
        Assert.assertEquals(expectedPlayerName, player.getName());
        
        // Save one player
        expectedPlayerName = "PLAYER NAME 2";
        player = this.playerService.save(new Player(expectedPlayerName));
        Assert.assertEquals(expectedPlayerName, player.getName());
    }
}
