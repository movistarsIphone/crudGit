package salinas.prueba.crud.cliente;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ClienteControllerIntegrationTest {

    private static final String CLIENTE_PATH = "/cliente/";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenReadAll_thenStatusIsOk() throws Exception {
        this.mockMvc.perform(get(CLIENTE_PATH))
                .andExpect(status().isOk());
    }

    @Test
    public void whenReadOne_thenStatusIsOk() throws Exception {
        this.mockMvc.perform(get(CLIENTE_PATH + 1))
                .andExpect(status().isOk());
    }

    @Test
    public void whenCreate_thenStatusIsCreated() throws Exception {
        Cliente student = new Cliente(1, "Arturo Cruz", "jesus.cruzca@gmail.com");
        this.mockMvc.perform(post(CLIENTE_PATH).content(asJsonString(student))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isCreated());
    }

    @Test
    public void whenUpdate_thenStatusIsOk() throws Exception {
        Cliente student = new Cliente(1, "Jesus Arturo Cruz Cardenas", "jesus.cruzca@elektra.com.mx");
        this.mockMvc.perform(put(CLIENTE_PATH + 1)
                        .content(asJsonString(student))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    public void whenDelete_thenStatusIsNoContent() throws Exception {
        this.mockMvc.perform(delete(CLIENTE_PATH + 3))
                .andExpect(status().isNoContent());
    }

    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
