package com.example.FreeSoulsApi;


import com.example.FreeSoulsApi.entities.Character;
import com.example.FreeSoulsApi.repositories.ArmorRepository;
import com.example.FreeSoulsApi.repositories.CharacterRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import static com.example.FreeSoulsApi.entities.CharacterType.VAGRANT;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ActiveProfiles("test")
public class ArmorControllerTest {

    @Autowired
    private ArmorRepository armorRepository;
    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    MockMvc mockMvc;

    @Test
    void givenAValidArmor_whenPostRequestIsMade_thenReturnSuccess() throws Exception {
        Character character = new Character("Valin", 50, VAGRANT, 100, 50, 55);
        characterRepository.save(character);

        String request = """
                {
                         "name": "Swordsman´s armor",
                         "defense": 100,
                         "weight": 20,
                         "characterId": 1
                       }
                """;

        String response = """
                {
                         "id": 1,
                         "name": "Swordsman´s armor",
                         "defense": 100,
                         "weight": 20,
                         "character": {
                             "id": 1,
                             "name": "Valin",
                             "level": 50,
                             "characterType": "VAGRANT",
                             "health": 100,
                             "stamina": 50,
                             "strength": 55
                         }
                     }
                """;

        mockMvc.perform(post("/armors")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andExpect(status().isCreated())
                .andExpect(content().json(response));
    }
}