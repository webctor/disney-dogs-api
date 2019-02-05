package com.disney.studios;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PetRepositoryIntegrationTest {

    @Autowired
    private MockMvc mvc;


    @Test
    public void getPictures() throws Exception {
        this.mvc.perform(get("/dogs/pictures")).andExpect(status().isOk())
                .andExpect(content().json("{\"labrador\":[{\"id\":1,\"picture\":\"http://i.imgur.com/eE29vX4.png\",\"breed\":\"labrador\",\"votes\":0},{\"id\":2,\"picture\":\"http://i.imgur.com/xX2AeDR.png\",\"breed\":\"labrador\",\"votes\":0},{\"id\":3,\"picture\":\"http://i.imgur.com/hBFRUuW.png\",\"breed\":\"labrador\",\"votes\":0},{\"id\":4,\"picture\":\"http://i.imgur.com/WDWK4nF.png\",\"breed\":\"labrador\",\"votes\":0},{\"id\":5,\"picture\":\"http://i.imgur.com/zxtD5Zw.png\",\"breed\":\"labrador\",\"votes\":0},{\"id\":6,\"picture\":\"http://i.imgur.com/MrkAGKR.png\",\"breed\":\"labrador\",\"votes\":0},{\"id\":7,\"picture\":\"http://i.imgur.com/o3Nyw4R.png\",\"breed\":\"labrador\",\"votes\":0},{\"id\":8,\"picture\":\"http://i.imgur.com/SzP5370.png\",\"breed\":\"labrador\",\"votes\":0},{\"id\":9,\"picture\":\"http://i.imgur.com/oHaP6I3.png\",\"breed\":\"labrador\",\"votes\":0},{\"id\":10,\"picture\":\"http://i.imgur.com/kSU7Zca.png\",\"breed\":\"labrador\",\"votes\":0},{\"id\":11,\"picture\":\"http://i.imgur.com/SAJJ1oH.png\",\"breed\":\"labrador\",\"votes\":0},{\"id\":12,\"picture\":\"http://i.imgur.com/BYvRbs8.png\",\"breed\":\"labrador\",\"votes\":0},{\"id\":13,\"picture\":\"http://i.imgur.com/VzFTsGg.png\",\"breed\":\"labrador\",\"votes\":0},{\"id\":14,\"picture\":\"http://i.imgur.com/qigJZWa.png\",\"breed\":\"labrador\",\"votes\":0},{\"id\":15,\"picture\":\"http://i.imgur.com/gskym.png\",\"breed\":\"labrador\",\"votes\":0}],\"pug\":[{\"id\":16,\"picture\":\"http://i.imgur.com/ozJD7SC.png\",\"breed\":\"pug\",\"votes\":0},{\"id\":17,\"picture\":\"http://i.imgur.com/E5vBM5Z.png\",\"breed\":\"pug\",\"votes\":0},{\"id\":18,\"picture\":\"http://i.imgur.com/miiP4NI.png\",\"breed\":\"pug\",\"votes\":0},{\"id\":19,\"picture\":\"http://i.imgur.com/GCE8dj5.png\",\"breed\":\"pug\",\"votes\":0},{\"id\":20,\"picture\":\"http://i.imgur.com/NGG3Yir.png\",\"breed\":\"pug\",\"votes\":0},{\"id\":21,\"picture\":\"http://i.imgur.com/q53cfRy.png\",\"breed\":\"pug\",\"votes\":0},{\"id\":22,\"picture\":\"http://i.imgur.com/Flic3TB.png\",\"breed\":\"pug\",\"votes\":0},{\"id\":23,\"picture\":\"http://i.imgur.com/zjgtrf9.png\",\"breed\":\"pug\",\"votes\":0},{\"id\":24,\"picture\":\"http://i.imgur.com/Mda3xXr.png\",\"breed\":\"pug\",\"votes\":0},{\"id\":25,\"picture\":\"http://i.imgur.com/IOh5mgB.png\",\"breed\":\"pug\",\"votes\":0},{\"id\":26,\"picture\":\"http://i.imgur.com/Fl2ivvG.png\",\"breed\":\"pug\",\"votes\":0},{\"id\":27,\"picture\":\"http://i.imgur.com/iLzWvSY.png\",\"breed\":\"pug\",\"votes\":0},{\"id\":28,\"picture\":\"http://i.imgur.com/RQKBN3F.png\",\"breed\":\"pug\",\"votes\":0},{\"id\":29,\"picture\":\"http://i.imgur.com/8c3RpI0.png\",\"breed\":\"pug\",\"votes\":0},{\"id\":30,\"picture\":\"http://i.imgur.com/7ysJzS4.png\",\"breed\":\"pug\",\"votes\":0},{\"id\":31,\"picture\":\"http://i.imgur.com/uccGfLn.png\",\"breed\":\"pug\",\"votes\":0},{\"id\":32,\"picture\":\"http://i.imgur.com/HrscSnK.png\",\"breed\":\"pug\",\"votes\":0},{\"id\":33,\"picture\":\"http://i.imgur.com/tUZhJYN.png\",\"breed\":\"pug\",\"votes\":0},{\"id\":34,\"picture\":\"http://i.imgur.com/xAGJ0Ry.png\",\"breed\":\"pug\",\"votes\":0},{\"id\":35,\"picture\":\"http://i.imgur.com/YxSvzWm.png\",\"breed\":\"pug\",\"votes\":0},{\"id\":36,\"picture\":\"http://i.imgur.com/Y32LWO6.png\",\"breed\":\"pug\",\"votes\":0},{\"id\":37,\"picture\":\"http://i.imgur.com/umJXx6S.png\",\"breed\":\"pug\",\"votes\":0},{\"id\":38,\"picture\":\"http://i.imgur.com/R8Ju76x.png\",\"breed\":\"pug\",\"votes\":0},{\"id\":39,\"picture\":\"http://i.imgur.com/xTg9j70.png\",\"breed\":\"pug\",\"votes\":0},{\"id\":40,\"picture\":\"http://i.imgur.com/zUnR5lj.png\",\"breed\":\"pug\",\"votes\":0},{\"id\":41,\"picture\":\"http://i.imgur.com/RUjOi8t.png\",\"breed\":\"pug\",\"votes\":0},{\"id\":42,\"picture\":\"http://i.imgur.com/Dd1K1uR.png\",\"breed\":\"pug\",\"votes\":0},{\"id\":43,\"picture\":\"http://i.imgur.com/Q5uksG8.png\",\"breed\":\"pug\",\"votes\":0},{\"id\":44,\"picture\":\"http://i.imgur.com/7YxiavD.png\",\"breed\":\"pug\",\"votes\":0},{\"id\":45,\"picture\":\"http://i.imgur.com/8B3HOrS.png\",\"breed\":\"pug\",\"votes\":0},{\"id\":46,\"picture\":\"http://i.imgur.com/9YfjSxU.png\",\"breed\":\"pug\",\"votes\":0},{\"id\":47,\"picture\":\"http://i.imgur.com/NSCW1Rz.png\",\"breed\":\"pug\",\"votes\":0},{\"id\":48,\"picture\":\"http://i.imgur.com/ZwM4KY4.png\",\"breed\":\"pug\",\"votes\":0},{\"id\":49,\"picture\":\"http://i.imgur.com/uy9pY3Y.png\",\"breed\":\"pug\",\"votes\":0},{\"id\":50,\"picture\":\"http://i.imgur.com/ZFk0cgV.png\",\"breed\":\"pug\",\"votes\":0},{\"id\":51,\"picture\":\"http://i.imgur.com/6Fz5JOg.png\",\"breed\":\"pug\",\"votes\":0},{\"id\":52,\"picture\":\"http://i.imgur.com/mNQbxWo.png\",\"breed\":\"pug\",\"votes\":0},{\"id\":53,\"picture\":\"http://i.imgur.com/C1MFoB0.png\",\"breed\":\"pug\",\"votes\":0},{\"id\":54,\"picture\":\"http://i.imgur.com/Rdbawjx.png\",\"breed\":\"pug\",\"votes\":0}],\"retriever\":[{\"id\":55,\"picture\":\"http://i.imgur.com/wR38uBx.png\",\"breed\":\"retriever\",\"votes\":0},{\"id\":56,\"picture\":\"http://i.imgur.com/CHRlo0W.png\",\"breed\":\"retriever\",\"votes\":0},{\"id\":57,\"picture\":\"http://i.imgur.com/tXnch1O.png\",\"breed\":\"retriever\",\"votes\":0},{\"id\":58,\"picture\":\"http://i.imgur.com/VCgfaB2.png\",\"breed\":\"retriever\",\"votes\":0},{\"id\":59,\"picture\":\"http://i.imgur.com/Ror46i4.png\",\"breed\":\"retriever\",\"votes\":0},{\"id\":60,\"picture\":\"http://i.imgur.com/Ful5PwH.png\",\"breed\":\"retriever\",\"votes\":0},{\"id\":61,\"picture\":\"http://i.imgur.com/C4rrJdn.png\",\"breed\":\"retriever\",\"votes\":0},{\"id\":62,\"picture\":\"http://i.imgur.com/Ao9bR9A.png\",\"breed\":\"retriever\",\"votes\":0},{\"id\":63,\"picture\":\"http://i.imgur.com/R14AU0I.png\",\"breed\":\"retriever\",\"votes\":0},{\"id\":64,\"picture\":\"http://i.imgur.com/gpH8wIV.png\",\"breed\":\"retriever\",\"votes\":0},{\"id\":65,\"picture\":\"http://i.imgur.com/luPxoig.png\",\"breed\":\"retriever\",\"votes\":0},{\"id\":66,\"picture\":\"http://i.imgur.com/MiIDyfD.png\",\"breed\":\"retriever\",\"votes\":0},{\"id\":67,\"picture\":\"http://i.imgur.com/4qmmRFj.png\",\"breed\":\"retriever\",\"votes\":0},{\"id\":68,\"picture\":\"http://i.imgur.com/ZSzHQ2q.png\",\"breed\":\"retriever\",\"votes\":0},{\"id\":69,\"picture\":\"http://i.imgur.com/PoA6rLg.png\",\"breed\":\"retriever\",\"votes\":0},{\"id\":70,\"picture\":\"http://i.imgur.com/NYwynk3.png\",\"breed\":\"retriever\",\"votes\":0},{\"id\":71,\"picture\":\"http://i.imgur.com/ni8vK0U.png\",\"breed\":\"retriever\",\"votes\":0},{\"id\":72,\"picture\":\"http://i.imgur.com/NinMpda.png\",\"breed\":\"retriever\",\"votes\":0},{\"id\":73,\"picture\":\"http://i.imgur.com/4L8rMko.png\",\"breed\":\"retriever\",\"votes\":0},{\"id\":74,\"picture\":\"http://i.imgur.com/HoISzqN.png\",\"breed\":\"retriever\",\"votes\":0},{\"id\":75,\"picture\":\"http://i.imgur.com/FPISssi.png\",\"breed\":\"retriever\",\"votes\":0},{\"id\":76,\"picture\":\"http://i.imgur.com/SzP5370.png\",\"breed\":\"retriever\",\"votes\":0},{\"id\":77,\"picture\":\"http://i.imgur.com/oHaP6I3.png\",\"breed\":\"retriever\",\"votes\":0},{\"id\":78,\"picture\":\"http://i.imgur.com/wlVWJpY.png\",\"breed\":\"retriever\",\"votes\":0},{\"id\":79,\"picture\":\"http://i.imgur.com/rV4COi2.png\",\"breed\":\"retriever\",\"votes\":0},{\"id\":80,\"picture\":\"http://i.imgur.com/6WZFhJX.png\",\"breed\":\"retriever\",\"votes\":0},{\"id\":81,\"picture\":\"http://i.imgur.com/gFLzkPt.png\",\"breed\":\"retriever\",\"votes\":0},{\"id\":82,\"picture\":\"http://i.imgur.com/ULSe4AI.png\",\"breed\":\"retriever\",\"votes\":0},{\"id\":83,\"picture\":\"http://i.imgur.com/yDEa2a5.png\",\"breed\":\"retriever\",\"votes\":0},{\"id\":84,\"picture\":\"http://i.imgur.com/BYvRbs8.png\",\"breed\":\"retriever\",\"votes\":0},{\"id\":85,\"picture\":\"http://i.imgur.com/VzFTsGg.png\",\"breed\":\"retriever\",\"votes\":0},{\"id\":86,\"picture\":\"http://i.imgur.com/BnhbY54.png\",\"breed\":\"retriever\",\"votes\":0},{\"id\":87,\"picture\":\"http://i.imgur.com/ToYsMEC.png\",\"breed\":\"retriever\",\"votes\":0}],\"yorkie\":[{\"id\":88,\"picture\":\"http://i.imgur.com/oSieVUO.png\",\"breed\":\"yorkie\",\"votes\":0},{\"id\":89,\"picture\":\"http://i.imgur.com/qtXIL.png\",\"breed\":\"yorkie\",\"votes\":0},{\"id\":90,\"picture\":\"http://i.imgur.com/qWLKy8a.jpg\",\"breed\":\"yorkie\",\"votes\":0}]}"));
    }

    @Test
    public void getPictureById() throws Exception {
        this.mvc.perform(get("/dogs/87")).andExpect(status().isOk())
                .andExpect(content().json("{\"id\":87,\"picture\":\"http://i.imgur.com/ToYsMEC.png\",\"breed\":\"retriever\",\"votes\":0}"));
    }

    @Test
    public void getPictureByWrongId() throws Exception {
        this.mvc.perform(get("/dogs/11187")).andExpect(status().is4xxClientError());
    }

    @Test
    public void putVoteUp() throws Exception {
        this.mvc.perform(put("/dogs/87/up")).andExpect(status().isOk())
        .andExpect(content().json("{\"id\":87,\"picture\":\"http://i.imgur.com/ToYsMEC.png\",\"breed\":\"retriever\",\"votes\":1}"));
    }

    @Test
    public void putVoteDown() throws Exception {
        this.mvc.perform(put("/dogs/87/down")).andExpect(status().isOk())
        .andExpect(content().json("{\"id\":87,\"picture\":\"http://i.imgur.com/ToYsMEC.png\",\"breed\":\"retriever\",\"votes\":0}"));
    }


}