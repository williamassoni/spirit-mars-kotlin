package com.assoni.mars.spiritmarskotlin.integration

import com.assoni.mars.SpiritMarsKotlinApplication
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest(classes = [SpiritMarsKotlinApplication::class])
@AutoConfigureMockMvc
internal class NavigationIntegrationTests(@Autowired val mockMvc: MockMvc) {

    @Test
    fun `should be able to navigate to coordinates(2, 0, S) lat(2) long(0) camera pointer to(S)`() {
        mockMvc.perform(post("/rest/mars/{command}", "MMRMMRMM").contentType(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk)
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("(2, 0, S)"))
    }

    @Test
    fun `should be able to navigate to coordinates(0, 2, W) lat(0) long(2) camera pointer to(W)`() {
        mockMvc.perform(post("/rest/mars/{command}", "MML").contentType(MediaType.TEXT_PLAIN))
            .andExpect(status().isOk)
            .andExpect(content().contentType("text/plain;charset=UTF-8"))
            .andExpect(content().string("(0, 2, W)"))
    }

    @Test
    fun `should be able to navigate to coordinates(2, 4, W) lat(0) long(4) camera pointer to(W)`() {
        mockMvc.perform(post("/rest/mars/{command}", "MMMMRMMRMMlMlMMlMMM").contentType(MediaType.TEXT_PLAIN))
            .andExpect(status().isOk)
            .andExpect(content().contentType("text/plain;charset=UTF-8"))
            .andExpect(content().string("(0, 4, W)"))
    }

    @Test
    fun `should be able to navigate to coordinates(2, 2, W) lat(2) long(2) camera pointer to(W)`() {
        mockMvc.perform(post("/rest/mars/{command}", "MMMMRMMMMRMMMMRMMMRMMMRMMRMRM").contentType(MediaType.TEXT_PLAIN))
            .andExpect(status().isOk)
            .andExpect(content().contentType("text/plain;charset=UTF-8"))
            .andExpect(content().string("(2, 2, W)"))
    }

    @Test
    fun `should be able to navigate to coordinates(0, 0, S) lat(0) long(0) camera pointer to(S)`() {
        mockMvc.perform(post("/rest/mars/{command}", "RR").contentType(MediaType.TEXT_PLAIN))
            .andExpect(status().isOk)
            .andExpect(content().contentType("text/plain;charset=UTF-8"))
            .andExpect(content().string("(0, 0, S)"))
    }

    @Test
    fun `should be able to navigate to coordinates(0, 0, W) lat(0) long(0) camera pointer to(W)`() {
        mockMvc.perform(post("/rest/mars/{command}", "RRR").contentType(MediaType.TEXT_PLAIN))
            .andExpect(status().isOk)
            .andExpect(content().contentType("text/plain;charset=UTF-8"))
            .andExpect(content().string("(0, 0, W)"))
    }

    @Test
    fun `should return 404 when the command is not valid{R - L - M}`() {
        mockMvc.perform(post("/rest/mars/{command}", "AAA").contentType(MediaType.TEXT_PLAIN))
            .andExpect(status().is4xxClientError)
    }

    @Test
    fun `should return 404 when the command lead the robot out of the wold range`() {
        mockMvc.perform(post("/rest/mars/{command}", "MMMMMMMMMMMMMMMMMMMMMMMM").contentType(MediaType.TEXT_PLAIN))
            .andExpect(status().is4xxClientError)
    }
}
